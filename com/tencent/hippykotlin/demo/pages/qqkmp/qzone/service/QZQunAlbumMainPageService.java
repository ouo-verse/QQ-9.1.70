package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.webapp_qun_media.GetMainPageRsp;
import com.tencent.hippykotlin.demo.pages.qzone.album.group_album.request.QZQunAlbumGetMainPageRequest;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0000\u00a2\u0006\u0002\b\u000bJ\b\u0010\f\u001a\u00020\tH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QZQunAlbumMainPageService;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneBaseService;", "()V", "fetchMainPage", "", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/webapp_qun_media/GetMainPageRsp;", "qunId", "", "cacheKey", "fetchMainPage$qecommerce_biz_release", "getLogTag", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZQunAlbumMainPageService extends QzoneBaseService {
    public static final int $stable = 0;
    public static final String TAG = "QZQunAlbumMainPageService";

    public final void fetchMainPage$qecommerce_biz_release(final DataCallback<GetMainPageRsp> dataCallback, String qunId, String cacheKey) {
        sendQzoneRequest$qecommerce_biz_release(new QZQunAlbumGetMainPageRequest(qunId), new DataCallback<GetMainPageRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QZQunAlbumMainPageService$fetchMainPage$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetMainPageRsp t16, long retCode, String msg2, boolean isFinish) {
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
            }
        }, cacheKey);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService
    public String getLogTag() {
        return TAG;
    }

    public static /* synthetic */ void fetchMainPage$qecommerce_biz_release$default(QZQunAlbumMainPageService qZQunAlbumMainPageService, DataCallback dataCallback, String str, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        qZQunAlbumMainPageService.fetchMainPage$qecommerce_biz_release(dataCallback, str, str2);
    }
}
