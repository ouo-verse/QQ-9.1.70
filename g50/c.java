package g50;

import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.search.event.UpdateSearchShadingWordEvent;
import com.tencent.biz.qqcircle.immersive.request.QFSGetFeedDetailSecondaryLoadRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StShadingWords;
import feedcloud.FeedCloudRead$StFeedDeatilSecondaryLoadRsp;
import feedcloud.FeedCloudRead$StShadingWords;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lg50/c;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "j1", "Lfeedcloud/FeedCloudRead$StFeedDeatilSecondaryLoadRsp;", "rsp", "i1", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedSelected", "", "w0", "<init>", "()V", "I", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private final void i1(FeedCloudRead$StFeedDeatilSecondaryLoadRsp rsp) {
        List<e30.b> list;
        this.E.o("SHADING_WORDS_REQUESTED", Boolean.TRUE);
        List<FeedCloudRead$StShadingWords> shadingWordList = rsp.shadingWords.get();
        if (shadingWordList.size() == 0) {
            QLog.i("QFSFeedPublicAccountShadingWordsPresenter", 1, "handleSuccess shadingWordList is empty!!");
            return;
        }
        t40.a s06 = s0();
        if (s06 != null) {
            list = s06.getFeedList();
        } else {
            list = null;
        }
        if (list != null && list.size() != 0) {
            HashMap hashMap = new HashMap(shadingWordList.size());
            for (FeedCloudRead$StShadingWords feedCloudRead$StShadingWords : shadingWordList) {
                String str = feedCloudRead$StShadingWords.feedID.get();
                Intrinsics.checkNotNullExpressionValue(str, "shadingWord.feedID.get()");
                FeedCloudMeta$StShadingWords feedCloudMeta$StShadingWords = feedCloudRead$StShadingWords.shadingWord.get();
                Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StShadingWords, "shadingWord.shadingWord.get()");
                hashMap.put(str, feedCloudMeta$StShadingWords);
            }
            for (e30.b bVar : list) {
                if (bVar.g() == null) {
                    QLog.i("QFSFeedPublicAccountShadingWordsPresenter", 1, "handleSuccess feedBlockData sourceData is empty!!");
                } else {
                    FeedCloudMeta$StShadingWords feedCloudMeta$StShadingWords2 = (FeedCloudMeta$StShadingWords) hashMap.get(bVar.g().f398449id.get());
                    if (feedCloudMeta$StShadingWords2 != null) {
                        bVar.g().shading_words = feedCloudMeta$StShadingWords2;
                    }
                }
            }
            Intrinsics.checkNotNullExpressionValue(shadingWordList, "shadingWordList");
            if (!shadingWordList.isEmpty()) {
                SimpleEventBus.getInstance().dispatchEvent(new UpdateSearchShadingWordEvent(hashMap));
            }
            QLog.d("QFSFeedPublicAccountShadingWordsPresenter", 1, "handleSuccess #shadingWordListCount = ", Integer.valueOf(shadingWordList.size()));
            return;
        }
        QLog.i("QFSFeedPublicAccountShadingWordsPresenter", 1, "handleSuccess feedList is empty!!");
    }

    private final void j1(FeedCloudMeta$StFeed feed) {
        VSNetworkHelper.getInstance().sendRequest(new QFSGetFeedDetailSecondaryLoadRequest(feed), new VSDispatchObserver.OnVSRspCallBack() { // from class: g50.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                c.k1(c.this, baseRequest, z16, j3, str, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(final c this$0, BaseRequest baseRequest, boolean z16, long j3, String str, final Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QFSFeedPublicAccountShadingWordsPresenter", 1, "requestFeedSearchShadingWords onReceive: dispatch #Success=", Boolean.valueOf(z16), "#TraceId=", baseRequest.getTraceId(), "#SeqId=", Integer.valueOf(baseRequest.getCurrentSeq()), "#retCode=", Long.valueOf(j3), "#errMsg=", str, "#isCache=", Boolean.valueOf(VSNetworkHelper.isProtocolCache(str)));
        if (z16 && j3 == 0 && obj != null) {
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: g50.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.l1(c.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(c this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type feedcloud.FeedCloudRead.StFeedDeatilSecondaryLoadRsp");
        this$0.i1((FeedCloudRead$StFeedDeatilSecondaryLoadRsp) obj);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedSelected(selectInfo);
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null && !(this.E.b("SHADING_WORDS_REQUESTED") instanceof Boolean)) {
            FeedCloudMeta$StFeed g16 = this.E.g();
            Intrinsics.checkNotNullExpressionValue(g16, "mFeedBlockData.sourceData");
            if (g16.secondaryLoadMask.get().contains(3)) {
                j1(g16);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedPublicAccountShadingWordsPresenter";
    }
}
