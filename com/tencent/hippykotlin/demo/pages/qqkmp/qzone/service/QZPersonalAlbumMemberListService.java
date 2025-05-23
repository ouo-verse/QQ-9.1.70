package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.GetAlbumMemberListRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qzone.album.personal_album_member_list.request.QZPersonalAlbumGetAlbumMemberListRequest;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0000\u00a2\u0006\u0002\b\fJ\b\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QZPersonalAlbumMemberListService;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneBaseService;", "()V", "fetchAlbumMemberList", "", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/GetAlbumMemberListRsp;", "albumID", "", "uin", "cacheKey", "fetchAlbumMemberList$qecommerce_biz_release", "getLogTag", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZPersonalAlbumMemberListService extends QzoneBaseService {
    public static final int $stable = 0;
    public static final String TAG = "QZPersonalAlbumMemberListService";

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService
    public String getLogTag() {
        return TAG;
    }

    public static /* synthetic */ void fetchAlbumMemberList$qecommerce_biz_release$default(QZPersonalAlbumMemberListService qZPersonalAlbumMemberListService, DataCallback dataCallback, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = QQKuiklyPlatformApi.Companion.getUin();
        }
        if ((i3 & 8) != 0) {
            str3 = "";
        }
        qZPersonalAlbumMemberListService.fetchAlbumMemberList$qecommerce_biz_release(dataCallback, str, str2, str3);
    }

    public final void fetchAlbumMemberList$qecommerce_biz_release(final DataCallback<GetAlbumMemberListRsp> dataCallback, String albumID, String uin, final String cacheKey) {
        byte[] loadRspCache;
        StUser stUser = new StUser(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
        stUser.uin = uin;
        stUser.uid = QQKuiklyPlatformApi.Companion.getUid(uin);
        final QZPersonalAlbumGetAlbumMemberListRequest qZPersonalAlbumGetAlbumMemberListRequest = new QZPersonalAlbumGetAlbumMemberListRequest(albumID, stUser);
        if ((cacheKey.length() > 0) && (loadRspCache = loadRspCache(cacheKey)) != null) {
            if (!(loadRspCache.length == 0)) {
                final GetAlbumMemberListRsp getAlbumMemberListRsp = (GetAlbumMemberListRsp) i.b(new GetAlbumMemberListRsp(null, null, 3, null), loadRspCache);
                runOnUIThread(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QZPersonalAlbumMemberListService$fetchAlbumMemberList$1
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
                        m3.append(QZPersonalAlbumMemberListService.this.getLogTag());
                        String sb5 = m3.toString();
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("doRequest get cache success, cmd: ");
                        qZPersonalAlbumGetAlbumMemberListRequest.getClass();
                        m16.append("QzoneV4Service.trpc.qzone.media_commreader.MediaCommReader.GetAlbumMemberList");
                        m16.append(", traceId: ");
                        m16.append(qZPersonalAlbumGetAlbumMemberListRequest.traceId);
                        m16.append(", cacheKey:");
                        m16.append(cacheKey);
                        m16.append(", busiRsp: ");
                        QZPersonalAlbumGetAlbumMemberListRequest qZPersonalAlbumGetAlbumMemberListRequest2 = qZPersonalAlbumGetAlbumMemberListRequest;
                        GetAlbumMemberListRsp getAlbumMemberListRsp2 = getAlbumMemberListRsp;
                        qZPersonalAlbumGetAlbumMemberListRequest2.getClass();
                        m16.append(getAlbumMemberListRsp2.toString());
                        kLog.d(sb5, m16.toString());
                        DataCallback<GetAlbumMemberListRsp> dataCallback2 = dataCallback;
                        GetAlbumMemberListRsp getAlbumMemberListRsp3 = getAlbumMemberListRsp;
                        qZPersonalAlbumGetAlbumMemberListRequest.getClass();
                        dataCallback2.onSuccess(getAlbumMemberListRsp3, 0L, "", true);
                    }
                });
            }
        }
        sendQzoneRequest$qecommerce_biz_release(qZPersonalAlbumGetAlbumMemberListRequest, new DataCallback<GetAlbumMemberListRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QZPersonalAlbumMemberListService$fetchAlbumMemberList$2
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetAlbumMemberListRsp t16, long retCode, String msg2, boolean isFinish) {
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
            }
        }, cacheKey);
    }
}
