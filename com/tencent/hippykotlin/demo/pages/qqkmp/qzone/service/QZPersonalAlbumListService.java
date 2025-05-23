package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service;

import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.GetAlbumListRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qzone.album.personal_album.request.QZPersonalAlbumGetAlbumListRequest;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J9\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b\u0017J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QZPersonalAlbumListService;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneBaseService;", "()V", "attachInfo", "", "getAttachInfo", "()Ljava/lang/String;", "setAttachInfo", "(Ljava/lang/String;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "fetchAlbumList", "", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/GetAlbumListRsp;", "uin", FeedManager.LOAD_MORE, "cacheKey", "fetchAlbumList$qecommerce_biz_release", "getLogTag", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZPersonalAlbumListService extends QzoneBaseService {
    public static final String TAG = "QZPersonalAlbumListService";
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

    public static /* synthetic */ void fetchAlbumList$qecommerce_biz_release$default(QZPersonalAlbumListService qZPersonalAlbumListService, DataCallback dataCallback, String str, boolean z16, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = QQKuiklyPlatformApi.Companion.getUin();
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if ((i3 & 8) != 0) {
            str2 = "";
        }
        qZPersonalAlbumListService.fetchAlbumList$qecommerce_biz_release(dataCallback, str, z16, str2);
    }

    public final void fetchAlbumList$qecommerce_biz_release(final DataCallback<GetAlbumListRsp> dataCallback, String uin, boolean loadMore, final String cacheKey) {
        byte[] loadRspCache;
        StUser stUser = new StUser(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
        stUser.uin = uin;
        stUser.uid = QQKuiklyPlatformApi.Companion.getUid(uin);
        if (!loadMore) {
            this.attachInfo = "";
        } else if (!this.hasMore) {
            KLog.INSTANCE.e(TAG, "hasMore is false");
            dataCallback.onFailure(-1L, "hasMore is false");
            return;
        }
        final QZPersonalAlbumGetAlbumListRequest qZPersonalAlbumGetAlbumListRequest = new QZPersonalAlbumGetAlbumListRequest(stUser, this.attachInfo, null);
        if ((cacheKey.length() > 0) && (loadRspCache = loadRspCache(cacheKey)) != null) {
            if (!(loadRspCache.length == 0)) {
                final GetAlbumListRsp decodeBusiRsp = qZPersonalAlbumGetAlbumListRequest.decodeBusiRsp(loadRspCache);
                runOnUIThread(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QZPersonalAlbumListService$fetchAlbumList$1
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
                        m3.append(QZPersonalAlbumListService.this.getLogTag());
                        String sb5 = m3.toString();
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("doRequest get cache success, cmd: ");
                        qZPersonalAlbumGetAlbumListRequest.getClass();
                        m16.append("QzoneV4Service.trpc.qzone.media_commreader.MediaCommReader.GetAlbumList");
                        m16.append(", traceId: ");
                        m16.append(qZPersonalAlbumGetAlbumListRequest.traceId);
                        m16.append(", cacheKey:");
                        m16.append(cacheKey);
                        m16.append(", busiRsp: ");
                        QZPersonalAlbumGetAlbumListRequest qZPersonalAlbumGetAlbumListRequest2 = qZPersonalAlbumGetAlbumListRequest;
                        GetAlbumListRsp getAlbumListRsp = decodeBusiRsp;
                        qZPersonalAlbumGetAlbumListRequest2.getClass();
                        m16.append(getAlbumListRsp.toString());
                        kLog.d(sb5, m16.toString());
                        DataCallback<GetAlbumListRsp> dataCallback2 = dataCallback;
                        GetAlbumListRsp getAlbumListRsp2 = decodeBusiRsp;
                        dataCallback2.onSuccess(getAlbumListRsp2, 0L, "", qZPersonalAlbumGetAlbumListRequest.checkFinish(getAlbumListRsp2));
                    }
                });
            }
        }
        sendQzoneRequest$qecommerce_biz_release(qZPersonalAlbumGetAlbumListRequest, new DataCallback<GetAlbumListRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QZPersonalAlbumListService$fetchAlbumList$2
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetAlbumListRsp t16, long retCode, String msg2, boolean isFinish) {
                QZPersonalAlbumListService qZPersonalAlbumListService = QZPersonalAlbumListService.this;
                String str = t16.attachInfo;
                if (str == null) {
                    str = "";
                }
                qZPersonalAlbumListService.setAttachInfo(str);
                QZPersonalAlbumListService.this.setHasMore(!isFinish);
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
            }
        }, cacheKey);
    }
}
