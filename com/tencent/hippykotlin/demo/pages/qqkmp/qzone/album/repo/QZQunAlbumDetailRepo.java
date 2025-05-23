package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo;

import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumBatchBean;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumCommData;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album.AlbumInfoConverterKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.IQZAegisListener;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.BatchInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.QunRight;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.webapp_qun_media.GetMediaListRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QZQunAlbumDetailService;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J`\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0010\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u000ej\u0002`\u001a0\u0013H\u0002J>\u0010\u001b\u001a\u00020\n2\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\bJ\u001c\u0010$\u001a\u00020\n2\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001dH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZQunAlbumDetailRepo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZAlbumDetailRepo;", "apiReport", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;)V", "albumDetailService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QZQunAlbumDetailService;", "lastQunId", "", "handleAlbumDetailListResponse", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "result", "", "errMsg", "album", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumInfo;", "batchList", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/BatchInfo;", "mediaList", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "mediaInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/MediaListInfo;", "opmask", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/QunMediaRightEnum;", "requestGetAlbumBatchList", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumBatchBean;", "qunId", "albumID", FeedManager.LOAD_MORE, "cacheKey", "requestMore", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZQunAlbumDetailRepo extends QZAlbumDetailRepo {
    public static final String TAG = "QZQunAlbumDetailRepo";
    private final QZQunAlbumDetailService albumDetailService;
    private String lastQunId;
    public static final int $stable = 8;

    public QZQunAlbumDetailRepo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAlbumDetailListResponse(boolean isLoadMore, int result, String errMsg, AlbumInfo album, List<BatchInfo> batchList, List<StMedia> mediaList, MediaListInfo mediaInfo, List<Integer> opmask) {
        KLog.INSTANCE.e(TAG, "handleAlbumDetailListResponse result:=" + result);
        if (result != 0) {
            return;
        }
        if (!isLoadMore) {
            setCommData(new CommonAlbumCommData());
            CommonAlbumCommData commData = getCommData();
            if (commData != null) {
                commData.setNormalUpLoad(false);
                commData.getRightList().addAll(opmask);
            }
            setAlbumInfo(album != null ? AlbumInfoConverterKt.toCommonAlbumInfo(album) : null);
            CommonAlbumInfo albumInfo = getAlbumInfo();
            setSortType(albumInfo != null ? Integer.valueOf(albumInfo.getSortType()) : null);
            getAllBatch().clear();
        }
        polymerizeStMediaListToBatchList(!isLoadMore ? 1 : 2, mediaList, batchList);
    }

    public final void requestGetAlbumBatchList(final DataCallback<List<CommonAlbumBatchBean>> dataCallback, String qunId, String albumID, final boolean loadMore, String cacheKey) {
        this.lastQunId = qunId;
        setLastAlbumID(albumID);
        this.albumDetailService.fetchAlbumDetail$qecommerce_biz_release(new DataCallback<GetMediaListRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo.QZQunAlbumDetailRepo$requestGetAlbumBatchList$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog.INSTANCE.e(QZQunAlbumDetailRepo.TAG, "onFailure, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetMediaListRsp t16, long retCode, String msg2, boolean isFinish) {
                List arrayList;
                MediaListInfo mediaListInfo = new MediaListInfo();
                String str = t16.nextAttachInfo;
                if (str == null) {
                    str = "";
                }
                mediaListInfo.setNextAttachInfo(str);
                Boolean bool = t16.nextHasMore;
                mediaListInfo.setNextHasMore(bool != null ? bool.booleanValue() : false);
                Integer num = t16.mediaIndex;
                mediaListInfo.setMediasIndex(num != null ? num.intValue() : 0);
                QZQunAlbumDetailRepo qZQunAlbumDetailRepo = QZQunAlbumDetailRepo.this;
                boolean z16 = loadMore;
                int i3 = (int) retCode;
                AlbumInfo albumInfo = t16.album;
                List<BatchInfo> list = t16.batchList;
                List<StMedia> list2 = t16.mediaList;
                QunRight qunRight = t16.right;
                if (qunRight == null || (arrayList = qunRight.right) == null) {
                    arrayList = new ArrayList();
                }
                qZQunAlbumDetailRepo.handleAlbumDetailListResponse(z16, i3, msg2, albumInfo, list, list2, mediaListInfo, arrayList);
                QZQunAlbumDetailRepo.this.setLastIsFinish(isFinish);
                dataCallback.onSuccess(QZQunAlbumDetailRepo.this.getAllBatch(), retCode, msg2, isFinish);
            }
        }, qunId, albumID, loadMore, cacheKey);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo.QZAlbumDetailRepo
    public void requestMore(DataCallback<List<CommonAlbumBatchBean>> dataCallback) {
        requestGetAlbumBatchList$default(this, dataCallback, this.lastQunId, getLastAlbumID(), true, null, 16, null);
    }

    public QZQunAlbumDetailRepo(IQZAegisListener iQZAegisListener) {
        this.lastQunId = "";
        QZQunAlbumDetailService qZQunAlbumDetailService = new QZQunAlbumDetailService();
        this.albumDetailService = qZQunAlbumDetailService;
        qZQunAlbumDetailService.setAegisListener(iQZAegisListener);
    }

    public /* synthetic */ QZQunAlbumDetailRepo(IQZAegisListener iQZAegisListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : iQZAegisListener);
    }

    public static /* synthetic */ void requestGetAlbumBatchList$default(QZQunAlbumDetailRepo qZQunAlbumDetailRepo, DataCallback dataCallback, String str, String str2, boolean z16, String str3, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i3 & 16) != 0) {
            str3 = "";
        }
        qZQunAlbumDetailRepo.requestGetAlbumBatchList(dataCallback, str, str2, z17, str3);
    }
}
