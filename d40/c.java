package d40;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.requests.QFSGetRelatedAlbumsReq;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedAlbum$GetRelatedAlbumsRsp;
import qqcircle.QQCircleFeedAlbum$StFeedDetail;
import qqcircle.QQCircleFeedAlbum$StVideoAlbumFeedInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 62\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R)\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0#0\"8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R$\u00100\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Ld40/c;", "Lcom/tencent/biz/qqcircle/viewmodels/a;", "", "isSuccess", "", "retCode", "", "errMsg", "Lqqcircle/QQCircleFeedAlbum$GetRelatedAlbumsRsp;", "rsp", "", "Q1", "getLogTag", "albumId", "isRefresh", "T1", "feedId", "S1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "N1", "()J", "setCurrentAlbumId", "(J)V", "currentAlbumId", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "", "Lqqcircle/QQCircleFeedAlbum$StVideoAlbumFeedInfo;", "D", "Ljava/util/List;", "relatedAlbums", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "E", "Landroidx/lifecycle/MutableLiveData;", "P1", "()Landroidx/lifecycle/MutableLiveData;", "relatedAlbumsData", "Lqqcircle/QQCircleFeedAlbum$StFeedDetail;", UserInfo.SEX_FEMALE, "Lqqcircle/QQCircleFeedAlbum$StFeedDetail;", "O1", "()Lqqcircle/QQCircleFeedAlbum$StFeedDetail;", "setLastFeed", "(Lqqcircle/QQCircleFeedAlbum$StFeedDetail;)V", "lastFeed", "G", "Z", "isRequesting", "<init>", "()V", "H", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c extends com.tencent.biz.qqcircle.viewmodels.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private LoadInfo loadInfo = new LoadInfo();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<QQCircleFeedAlbum$StVideoAlbumFeedInfo> relatedAlbums = new ArrayList();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<QQCircleFeedAlbum$StVideoAlbumFeedInfo>>> relatedAlbumsData = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QQCircleFeedAlbum$StFeedDetail lastFeed;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isRequesting;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long currentAlbumId;

    private final void Q1(final boolean isSuccess, final long retCode, final String errMsg, final QQCircleFeedAlbum$GetRelatedAlbumsRsp rsp) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: d40.b
            @Override // java.lang.Runnable
            public final void run() {
                c.R1(c.this, isSuccess, rsp, errMsg, retCode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(c this$0, boolean z16, QQCircleFeedAlbum$GetRelatedAlbumsRsp qQCircleFeedAlbum$GetRelatedAlbumsRsp, String str, long j3) {
        boolean z17;
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        String a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isRequesting = false;
        if (z16 && qQCircleFeedAlbum$GetRelatedAlbumsRsp != null) {
            boolean z18 = true;
            boolean z19 = !TextUtils.isEmpty(this$0.loadInfo.getStringAttachInfo());
            QLog.d("QFSRelatedAlbumsViewModel", 1, "[handleRelatedAlbumsList] attachInfo: " + qQCircleFeedAlbum$GetRelatedAlbumsRsp.attach_info.get() + " isLoadMore: " + z19);
            this$0.loadInfo.setStringAttachInfo(qQCircleFeedAlbum$GetRelatedAlbumsRsp.attach_info.get());
            LoadInfo loadInfo = this$0.loadInfo;
            if (qQCircleFeedAlbum$GetRelatedAlbumsRsp.is_finish.get() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            loadInfo.setFinish(z17);
            if (j3 != 0) {
                MutableLiveData<UIStateData<List<QQCircleFeedAlbum$StVideoAlbumFeedInfo>>> mutableLiveData = this$0.relatedAlbumsData;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                mutableLiveData.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(false));
            } else {
                if (!z19) {
                    this$0.relatedAlbums.clear();
                    QQCircleFeedAlbum$StVideoAlbumFeedInfo qQCircleFeedAlbum$StVideoAlbumFeedInfo = new QQCircleFeedAlbum$StVideoAlbumFeedInfo();
                    if (qQCircleFeedAlbum$GetRelatedAlbumsRsp.feed_info.get().isEmpty()) {
                        a16 = h.a(R.string.f194764cs);
                    } else {
                        a16 = h.a(R.string.f194774ct);
                    }
                    qQCircleFeedAlbum$StVideoAlbumFeedInfo.album_desc.set(a16);
                    this$0.relatedAlbums.add(qQCircleFeedAlbum$StVideoAlbumFeedInfo);
                }
                if (z19) {
                    obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(this$0.relatedAlbums.size(), qQCircleFeedAlbum$GetRelatedAlbumsRsp.feed_info.get().size());
                } else {
                    obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
                }
                List<QQCircleFeedAlbum$StVideoAlbumFeedInfo> list = this$0.relatedAlbums;
                List<QQCircleFeedAlbum$StVideoAlbumFeedInfo> list2 = qQCircleFeedAlbum$GetRelatedAlbumsRsp.feed_info.get();
                Intrinsics.checkNotNullExpressionValue(list2, "rsp.feed_info.get()");
                list.addAll(list2);
                UIStateData latestModifyRecord = UIStateData.obtainSuccess(false).setData(z19, this$0.relatedAlbums).setLatestModifyRecord(obtainNotifyDataSetChanged);
                if (qQCircleFeedAlbum$GetRelatedAlbumsRsp.is_finish.get() != 1) {
                    z18 = false;
                }
                UIStateData<List<QQCircleFeedAlbum$StVideoAlbumFeedInfo>> pos = latestModifyRecord.setFinish(z18).setPos(0);
                Intrinsics.checkNotNullExpressionValue(pos, "obtainSuccess<MutableLis\u2026               .setPos(0)");
                this$0.relatedAlbumsData.postValue(pos);
                this$0.lastFeed = qQCircleFeedAlbum$GetRelatedAlbumsRsp.last_feed.get();
            }
            this$0.loadInfo.setCurrentState(4);
            return;
        }
        MutableLiveData<UIStateData<List<QQCircleFeedAlbum$StVideoAlbumFeedInfo>>> mutableLiveData2 = this$0.relatedAlbumsData;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        mutableLiveData2.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(c this$0, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleFeedAlbum$GetRelatedAlbumsRsp qQCircleFeedAlbum$GetRelatedAlbumsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q1(z16, j3, str, qQCircleFeedAlbum$GetRelatedAlbumsRsp);
    }

    /* renamed from: N1, reason: from getter */
    public final long getCurrentAlbumId() {
        return this.currentAlbumId;
    }

    @Nullable
    /* renamed from: O1, reason: from getter */
    public final QQCircleFeedAlbum$StFeedDetail getLastFeed() {
        return this.lastFeed;
    }

    @NotNull
    public final MutableLiveData<UIStateData<List<QQCircleFeedAlbum$StVideoAlbumFeedInfo>>> P1() {
        return this.relatedAlbumsData;
    }

    public final boolean S1(@NotNull String feedId) {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        QQCircleFeedAlbum$StFeedDetail qQCircleFeedAlbum$StFeedDetail = this.lastFeed;
        if (qQCircleFeedAlbum$StFeedDetail != null && (feedCloudMeta$StFeed = qQCircleFeedAlbum$StFeedDetail.feed) != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        return Intrinsics.areEqual(feedId, str);
    }

    public final void T1(long albumId, boolean isRefresh) {
        if (this.isRequesting) {
            QLog.d("QFSRelatedAlbumsViewModel", 1, "[requestRelatedAlbumsList] is requesting, return.");
            return;
        }
        this.isRequesting = true;
        this.currentAlbumId = albumId;
        if (isRefresh) {
            this.loadInfo.setStringAttachInfo("");
        }
        String stringAttachInfo = this.loadInfo.getStringAttachInfo();
        Intrinsics.checkNotNullExpressionValue(stringAttachInfo, "loadInfo.stringAttachInfo");
        sendRequest(new QFSGetRelatedAlbumsReq(albumId, stringAttachInfo), new VSDispatchObserver.OnVSRspCallBack() { // from class: d40.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                c.U1(c.this, baseRequest, z16, j3, str, (QQCircleFeedAlbum$GetRelatedAlbumsRsp) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSRelatedAlbumsViewModel";
    }
}
