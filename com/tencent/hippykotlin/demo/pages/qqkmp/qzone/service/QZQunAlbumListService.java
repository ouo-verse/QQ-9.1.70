package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service;

import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.webapp_qun_media.GetAlbumListRsp;
import com.tencent.hippykotlin.demo.pages.qzone.album.group_album.request.QZQunAlbumGetAlbumListRequest;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J7\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b\u0017J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QZQunAlbumListService;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneBaseService;", "()V", "attachInfo", "", "getAttachInfo", "()Ljava/lang/String;", "setAttachInfo", "(Ljava/lang/String;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "fetchAlbumList", "", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/webapp_qun_media/GetAlbumListRsp;", "qunId", FeedManager.LOAD_MORE, "cacheKey", "fetchAlbumList$qecommerce_biz_release", "getLogTag", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZQunAlbumListService extends QzoneBaseService {
    public static final String TAG = "QZQunAlbumListService";
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

    public final void fetchAlbumList$qecommerce_biz_release(final DataCallback<GetAlbumListRsp> dataCallback, String qunId, boolean loadMore, final String cacheKey) {
        byte[] loadRspCache;
        if (!loadMore) {
            this.attachInfo = "";
        } else if (!this.hasMore) {
            KLog.INSTANCE.e(TAG, "hasMore is false");
            dataCallback.onFailure(-1L, "hasMore is false");
            return;
        }
        final QZQunAlbumGetAlbumListRequest qZQunAlbumGetAlbumListRequest = new QZQunAlbumGetAlbumListRequest(qunId, this.attachInfo);
        if ((cacheKey.length() > 0) && (loadRspCache = loadRspCache(cacheKey)) != null) {
            if (!(loadRspCache.length == 0)) {
                final GetAlbumListRsp decodeBusiRsp = qZQunAlbumGetAlbumListRequest.decodeBusiRsp(loadRspCache);
                runOnUIThread(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QZQunAlbumListService$fetchAlbumList$1
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
                        m3.append(QZQunAlbumListService.this.getLogTag());
                        String sb5 = m3.toString();
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("doRequest get cache success, cmd: ");
                        qZQunAlbumGetAlbumListRequest.getClass();
                        m16.append("QunAlbum.trpc.qzone.webapp_qun_media.QunMedia.GetAlbumList");
                        m16.append(", traceId: ");
                        m16.append(qZQunAlbumGetAlbumListRequest.traceId);
                        m16.append(", cacheKey:");
                        m16.append(cacheKey);
                        m16.append(", busiRsp: ");
                        QZQunAlbumGetAlbumListRequest qZQunAlbumGetAlbumListRequest2 = qZQunAlbumGetAlbumListRequest;
                        GetAlbumListRsp getAlbumListRsp = decodeBusiRsp;
                        qZQunAlbumGetAlbumListRequest2.getClass();
                        m16.append(getAlbumListRsp.toString());
                        kLog.d(sb5, m16.toString());
                        DataCallback<GetAlbumListRsp> dataCallback2 = dataCallback;
                        GetAlbumListRsp getAlbumListRsp2 = decodeBusiRsp;
                        dataCallback2.onSuccess(getAlbumListRsp2, 0L, "", qZQunAlbumGetAlbumListRequest.checkFinish(getAlbumListRsp2));
                    }
                });
            }
        }
        sendQzoneRequest$qecommerce_biz_release(qZQunAlbumGetAlbumListRequest, new DataCallback<GetAlbumListRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QZQunAlbumListService$fetchAlbumList$2
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetAlbumListRsp t16, long retCode, String msg2, boolean isFinish) {
                QZQunAlbumListService qZQunAlbumListService = QZQunAlbumListService.this;
                String str = t16.attachInfo;
                if (str == null) {
                    str = "";
                }
                qZQunAlbumListService.setAttachInfo(str);
                QZQunAlbumListService.this.setHasMore(!isFinish);
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
            }
        }, cacheKey);
    }

    public static /* synthetic */ void fetchAlbumList$qecommerce_biz_release$default(QZQunAlbumListService qZQunAlbumListService, DataCallback dataCallback, String str, boolean z16, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if ((i3 & 8) != 0) {
            str2 = "";
        }
        qZQunAlbumListService.fetchAlbumList$qecommerce_biz_release(dataCallback, str, z16, str2);
    }
}
