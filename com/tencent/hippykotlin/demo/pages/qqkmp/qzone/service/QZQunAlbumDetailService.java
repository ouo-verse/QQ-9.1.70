package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service;

import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.webapp_qun_media.GetMediaListRsp;
import com.tencent.hippykotlin.demo.pages.qzone.album.group_album_detail.request.QZQunAlbumGetAlbumDetailRequest;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J?\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b\u0018J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QZQunAlbumDetailService;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneBaseService;", "()V", "attachInfo", "", "getAttachInfo", "()Ljava/lang/String;", "setAttachInfo", "(Ljava/lang/String;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "fetchAlbumDetail", "", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/webapp_qun_media/GetMediaListRsp;", "qunId", "albumID", FeedManager.LOAD_MORE, "cacheKey", "fetchAlbumDetail$qecommerce_biz_release", "getLogTag", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZQunAlbumDetailService extends QzoneBaseService {
    public static final String TAG = "QZQunAlbumDetailService";
    private String attachInfo = "";
    private boolean hasMore;
    public static final int $stable = 8;

    public final String getAttachInfo() {
        return this.attachInfo;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService
    public String getLogTag() {
        return TAG;
    }

    public final void setAttachInfo(String str) {
        this.attachInfo = str;
    }

    public final void setHasMore(boolean z16) {
        this.hasMore = z16;
    }

    public final void fetchAlbumDetail$qecommerce_biz_release(final DataCallback<GetMediaListRsp> dataCallback, String qunId, String albumID, boolean loadMore, final String cacheKey) {
        byte[] loadRspCache;
        if (!loadMore) {
            this.attachInfo = "";
        } else if (!this.hasMore) {
            KLog.INSTANCE.e(TAG, "hasMore is false");
            dataCallback.onFailure(-1L, "hasMore is false");
            return;
        }
        final QZQunAlbumGetAlbumDetailRequest qZQunAlbumGetAlbumDetailRequest = new QZQunAlbumGetAlbumDetailRequest(qunId, albumID, this.attachInfo);
        if ((cacheKey.length() > 0) && (loadRspCache = loadRspCache(cacheKey)) != null) {
            if (!(loadRspCache.length == 0)) {
                final GetMediaListRsp decodeBusiRsp = qZQunAlbumGetAlbumDetailRequest.decodeBusiRsp(loadRspCache);
                runOnUIThread(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QZQunAlbumDetailService$fetchAlbumDetail$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(QzoneBaseService.LOG_PREFIX);
                        m3.append(QZQunAlbumDetailService.this.getLogTag());
                        String sb5 = m3.toString();
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("doRequest get cache success, cmd: ");
                        qZQunAlbumGetAlbumDetailRequest.getClass();
                        m16.append("QunAlbum.trpc.qzone.webapp_qun_media.QunMedia.GetMediaList");
                        m16.append(", traceId: ");
                        m16.append(qZQunAlbumGetAlbumDetailRequest.traceId);
                        m16.append(", cacheKey:");
                        m16.append(cacheKey);
                        m16.append(", busiRsp: ");
                        QZQunAlbumGetAlbumDetailRequest qZQunAlbumGetAlbumDetailRequest2 = qZQunAlbumGetAlbumDetailRequest;
                        GetMediaListRsp getMediaListRsp = decodeBusiRsp;
                        qZQunAlbumGetAlbumDetailRequest2.getClass();
                        m16.append(getMediaListRsp.toString());
                        kLog.d(sb5, m16.toString());
                        DataCallback<GetMediaListRsp> dataCallback2 = dataCallback;
                        GetMediaListRsp getMediaListRsp2 = decodeBusiRsp;
                        dataCallback2.onSuccess(getMediaListRsp2, 0L, "", qZQunAlbumGetAlbumDetailRequest.checkFinish(getMediaListRsp2));
                    }
                });
            }
        }
        sendQzoneRequest$qecommerce_biz_release(qZQunAlbumGetAlbumDetailRequest, new DataCallback<GetMediaListRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QZQunAlbumDetailService$fetchAlbumDetail$2
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetMediaListRsp t16, long retCode, String msg2, boolean isFinish) {
                QZQunAlbumDetailService qZQunAlbumDetailService = QZQunAlbumDetailService.this;
                String str = t16.nextAttachInfo;
                if (str == null) {
                    str = "";
                }
                qZQunAlbumDetailService.setAttachInfo(str);
                QZQunAlbumDetailService.this.setHasMore(!isFinish);
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
            }
        }, cacheKey);
    }

    public static /* synthetic */ void fetchAlbumDetail$qecommerce_biz_release$default(QZQunAlbumDetailService qZQunAlbumDetailService, DataCallback dataCallback, String str, String str2, boolean z16, String str3, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i3 & 16) != 0) {
            str3 = "";
        }
        qZQunAlbumDetailService.fetchAlbumDetail$qecommerce_biz_release(dataCallback, str, str2, z17, str3);
    }
}
