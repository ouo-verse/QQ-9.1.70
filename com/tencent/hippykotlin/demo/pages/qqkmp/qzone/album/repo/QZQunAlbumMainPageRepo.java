package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.IQZAegisListener;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.webapp_qun_media.GetMainPageRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QZQunAlbumMainPageService;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZQunAlbumMainPageRepo;", "", "apiReport", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;)V", "albumMainPageService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QZQunAlbumMainPageService;", "requestGetMainPage", "", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/webapp_qun_media/GetMainPageRsp;", "qunId", "", "cacheKey", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZQunAlbumMainPageRepo {
    public static final int $stable = 0;
    public static final String TAG = "QZQunAlbumMainPageRepo";
    private final QZQunAlbumMainPageService albumMainPageService;

    public QZQunAlbumMainPageRepo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void requestGetMainPage(final DataCallback<GetMainPageRsp> dataCallback, String qunId, String cacheKey) {
        this.albumMainPageService.fetchMainPage$qecommerce_biz_release(new DataCallback<GetMainPageRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo.QZQunAlbumMainPageRepo$requestGetMainPage$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog.INSTANCE.e(QZQunAlbumMainPageRepo.TAG, "onFailure, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetMainPageRsp t16, long retCode, String msg2, boolean isFinish) {
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
            }
        }, qunId, cacheKey);
    }

    public QZQunAlbumMainPageRepo(IQZAegisListener iQZAegisListener) {
        QZQunAlbumMainPageService qZQunAlbumMainPageService = new QZQunAlbumMainPageService();
        this.albumMainPageService = qZQunAlbumMainPageService;
        qZQunAlbumMainPageService.setAegisListener(iQZAegisListener);
    }

    public /* synthetic */ QZQunAlbumMainPageRepo(IQZAegisListener iQZAegisListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : iQZAegisListener);
    }

    public static /* synthetic */ void requestGetMainPage$default(QZQunAlbumMainPageRepo qZQunAlbumMainPageRepo, DataCallback dataCallback, String str, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        qZQunAlbumMainPageRepo.requestGetMainPage(dataCallback, str, str2);
    }
}
