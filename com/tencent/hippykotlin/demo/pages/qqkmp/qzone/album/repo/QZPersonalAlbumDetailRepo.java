package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo;

import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumBatchBean;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumCommData;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonMediaLbsAreaList;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonPageEndMsg;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album.AlbumInfoConverterKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album.QZAlbumxConverterKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.IQZAegisListener;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.GetPhotoListRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.RecommendMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.BatchInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.MediaLbsAreaList;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.PageEndMsg;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StTimeLine;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QZPersonalAlbumDetailService;
import com.tencent.kuikly.core.log.KLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0088\u0001\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001f2\u0006\u0010#\u001a\u00020$2\u0010\u0010%\u001a\f\u0012\b\u0012\u00060\u001aj\u0002`&0\u001f2\b\u0010\u000f\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J@\u0010.\u001a\u00020\u00162\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020201002\b\b\u0002\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u00182\b\b\u0002\u00106\u001a\u00020\u000eJ\u001c\u00107\u001a\u00020\u00162\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020100H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u00069"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZPersonalAlbumDetailRepo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZAlbumDetailRepo;", "apiReport", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;)V", "albumDetailService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QZPersonalAlbumDetailService;", "endMsg", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonPageEndMsg;", "getEndMsg", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonPageEndMsg;", "setEndMsg", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonPageEndMsg;)V", "lastUIN", "", "mediaLbsAreaList", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonMediaLbsAreaList;", "getMediaLbsAreaList", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonMediaLbsAreaList;", "setMediaLbsAreaList", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonMediaLbsAreaList;)V", "handleAlbumDetailListResponse", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "result", "", "errMsg", "album", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumInfo;", "batchList", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/BatchInfo;", "mediaList", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "mediaInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/MediaListInfo;", "opmask", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/PhotoListOpMask;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/MediaLbsAreaList;", "timeline", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StTimeLine;", "pageEndMsg", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/PageEndMsg;", "recommendMedia", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/RecommendMedia;", "requestGetAlbumBatchList", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumBatchBean;", "uin", "albumID", FeedManager.LOAD_MORE, "cacheKey", "requestMore", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZPersonalAlbumDetailRepo extends QZAlbumDetailRepo {
    public static final String TAG = "QZPersonalAlbumDetailRepo";
    private final QZPersonalAlbumDetailService albumDetailService;
    private CommonPageEndMsg endMsg;
    private String lastUIN;
    private CommonMediaLbsAreaList mediaLbsAreaList;
    public static final int $stable = 8;

    public QZPersonalAlbumDetailRepo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAlbumDetailListResponse(boolean isLoadMore, int result, String errMsg, AlbumInfo album, List<BatchInfo> batchList, List<StMedia> mediaList, MediaListInfo mediaInfo, List<Integer> opmask, MediaLbsAreaList mediaLbsAreaList, StTimeLine timeline, PageEndMsg pageEndMsg, RecommendMedia recommendMedia) {
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
            this.mediaLbsAreaList = mediaLbsAreaList != null ? QZAlbumxConverterKt.toCommonMediaLbsAreaList(mediaLbsAreaList) : null;
        }
        polymerizeStMediaListToBatchList(!isLoadMore ? 1 : 2, mediaList, batchList);
        this.endMsg = pageEndMsg != null ? QZAlbumxConverterKt.toCommonPageEndMsg(pageEndMsg) : null;
    }

    public final CommonPageEndMsg getEndMsg() {
        return this.endMsg;
    }

    public final CommonMediaLbsAreaList getMediaLbsAreaList() {
        return this.mediaLbsAreaList;
    }

    public final void requestGetAlbumBatchList(final DataCallback<List<CommonAlbumBatchBean>> dataCallback, String uin, String albumID, final boolean loadMore, String cacheKey) {
        this.lastUIN = uin;
        setLastAlbumID(albumID);
        this.albumDetailService.fetchAlbumDetail$qecommerce_biz_release(new DataCallback<GetPhotoListRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo.QZPersonalAlbumDetailRepo$requestGetAlbumBatchList$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog.INSTANCE.e(QZPersonalAlbumDetailRepo.TAG, "onFailure, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetPhotoListRsp t16, long retCode, String msg2, boolean isFinish) {
                MediaListInfo mediaListInfo = new MediaListInfo();
                String str = t16.attachInfo;
                if (str == null) {
                    str = "";
                }
                mediaListInfo.setNextAttachInfo(str);
                Boolean bool = t16.hasMore;
                mediaListInfo.setNextHasMore(bool != null ? bool.booleanValue() : false);
                Integer num = t16.curIndex;
                mediaListInfo.setMediasIndex(num != null ? num.intValue() : 0);
                QZPersonalAlbumDetailRepo.this.handleAlbumDetailListResponse(loadMore, (int) retCode, msg2, t16.albumInfo, t16.batchList, t16.medias, mediaListInfo, t16.opmask, t16.mediaLbsAreaList, t16.timeLine, t16.endMsg, t16.recommendMedia);
                QZPersonalAlbumDetailRepo.this.setLastIsFinish(isFinish);
                dataCallback.onSuccess(QZPersonalAlbumDetailRepo.this.getAllBatch(), retCode, msg2, isFinish);
            }
        }, uin, albumID, loadMore, cacheKey);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo.QZAlbumDetailRepo
    public void requestMore(DataCallback<List<CommonAlbumBatchBean>> dataCallback) {
        requestGetAlbumBatchList$default(this, dataCallback, this.lastUIN, getLastAlbumID(), true, null, 16, null);
    }

    public final void setEndMsg(CommonPageEndMsg commonPageEndMsg) {
        this.endMsg = commonPageEndMsg;
    }

    public final void setMediaLbsAreaList(CommonMediaLbsAreaList commonMediaLbsAreaList) {
        this.mediaLbsAreaList = commonMediaLbsAreaList;
    }

    public QZPersonalAlbumDetailRepo(IQZAegisListener iQZAegisListener) {
        this.lastUIN = "";
        QZPersonalAlbumDetailService qZPersonalAlbumDetailService = new QZPersonalAlbumDetailService();
        this.albumDetailService = qZPersonalAlbumDetailService;
        qZPersonalAlbumDetailService.setAegisListener(iQZAegisListener);
    }

    public static /* synthetic */ void requestGetAlbumBatchList$default(QZPersonalAlbumDetailRepo qZPersonalAlbumDetailRepo, DataCallback dataCallback, String str, String str2, boolean z16, String str3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = QQKuiklyPlatformApi.Companion.getUin();
        }
        String str4 = str;
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i3 & 16) != 0) {
            str3 = "";
        }
        qZPersonalAlbumDetailRepo.requestGetAlbumBatchList(dataCallback, str4, str2, z17, str3);
    }

    public /* synthetic */ QZPersonalAlbumDetailRepo(IQZAegisListener iQZAegisListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : iQZAegisListener);
    }
}
