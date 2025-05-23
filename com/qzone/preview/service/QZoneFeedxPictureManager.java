package com.qzone.preview.service;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.remote.Callback;
import java.util.HashMap;
import o8.a;
import o8.b;

/* loaded from: classes39.dex */
public class QZoneFeedxPictureManager {
    private static final String TAG = "QZoneFeedxPictureManager";
    protected static final Object lock = new Object();
    private static volatile QZoneFeedxPictureManager sInstance;
    private a mRemoteCall;
    private QZoneFeedxLayerRequestSender mRequestSender;

    public QZoneFeedxPictureManager() {
        initRemoteCall();
    }

    public static QZoneFeedxPictureManager getInstance() {
        if (sInstance == null) {
            synchronized (lock) {
                if (sInstance == null) {
                    sInstance = new QZoneFeedxPictureManager();
                }
            }
        }
        return sInstance;
    }

    private QZoneFeedxLayerRequestSender getRequestSender() {
        if (this.mRequestSender == null) {
            this.mRequestSender = new QZoneFeedxLayerRequestSender();
        }
        return this.mRequestSender;
    }

    private void initRemoteCall() {
        this.mRemoteCall = new b();
    }

    private boolean isFeedxLayerUseMainProcess() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTOVIEW, QzoneConfig.SECONDARY_KEY_FEEDX_LAYER_REQUEST_USE_MAIN_PROCESS, 1) == 1;
    }

    private PhotoParam makeUpPhotoParam(PhotoParam photoParam) {
        if (photoParam == null) {
            RFWLog.e(TAG, RFWLog.USR, "photoParam is null");
            return null;
        }
        if (photoParam.albumid == null) {
            photoParam.albumid = "";
        }
        if (photoParam.albumanswer == null) {
            photoParam.albumanswer = "";
        }
        if (photoParam.ownerUin == 0) {
            photoParam.ownerUin = photoParam.realOwnerUin;
        }
        if (photoParam.appid == 0) {
            photoParam.appid = 4;
        }
        return photoParam;
    }

    public void getQZonePhotoComment(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, Handler handler) {
        PhotoParam photoParam;
        if (qZoneAlbumRequestBuilder == null || (photoParam = qZoneAlbumRequestBuilder.photoParam) == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().getQzonePhotoComment(qZoneAlbumRequestBuilder.photoId, qZoneAlbumRequestBuilder.albumId, qZoneAlbumRequestBuilder.cellId, photoParam, handler);
            return;
        }
        qZoneAlbumRequestBuilder.uin = photoParam.feedUin;
        int i3 = photoParam.appid;
        if (i3 == 4) {
            qZoneAlbumRequestBuilder = makeUpPhotoBuilder(qZoneAlbumRequestBuilder);
        } else if (i3 == 311) {
            qZoneAlbumRequestBuilder = makeUpMoodBuilder(qZoneAlbumRequestBuilder, photoParam);
        }
        getRequestSender().handleGetQZonePhotoComment(qZoneAlbumRequestBuilder, handler);
    }

    public void commentGroupPhoto(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        getRequestSender().handleCommentGroupPhoto(qZoneInteractPhotoRequestBuilder, handler);
    }

    public void deleteFavor(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().getSender().delFavor(handler, qZoneInteractPhotoRequestBuilder.ownerUin, qZoneInteractPhotoRequestBuilder.ugcKey, qZoneInteractPhotoRequestBuilder.appId, qZoneInteractPhotoRequestBuilder.subId);
        } else {
            getRequestSender().handleDeleteFavor(qZoneInteractPhotoRequestBuilder, handler);
        }
    }

    public void deletePhoto(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().getSender().deletePhoto(handler, qZoneInteractPhotoRequestBuilder.albumId, qZoneInteractPhotoRequestBuilder.photoIdList, qZoneInteractPhotoRequestBuilder.videoIdList);
        } else {
            getRequestSender().handleDeletePhoto(qZoneInteractPhotoRequestBuilder, handler);
        }
    }

    public void downloadVideo(QZoneAlbumMediaRequestBuilder qZoneAlbumMediaRequestBuilder, Handler handler) {
        if (qZoneAlbumMediaRequestBuilder == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().downloadVideo(qZoneAlbumMediaRequestBuilder.videoDownloadUrl, handler);
        } else {
            getRequestSender().handleDownloadVideo(qZoneAlbumMediaRequestBuilder, handler);
        }
    }

    public void editPhotoInfo(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().getSender().editPhotoDesc(handler, qZoneInteractPhotoRequestBuilder.albumId, qZoneInteractPhotoRequestBuilder.photoIdList, qZoneInteractPhotoRequestBuilder.photoInfo, qZoneInteractPhotoRequestBuilder.operateType, qZoneInteractPhotoRequestBuilder.extraInfoMap, qZoneInteractPhotoRequestBuilder.cacheKey);
        } else {
            getRequestSender().handleEditPhotoInfo(qZoneInteractPhotoRequestBuilder, handler);
        }
    }

    public void forwardPhoto(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().getSender().forwardPhoto(handler, qZoneInteractPhotoRequestBuilder.forwardText, qZoneInteractPhotoRequestBuilder.contentCacheUniKey, 4, 0, qZoneInteractPhotoRequestBuilder.ownerUin, qZoneInteractPhotoRequestBuilder.albumId, qZoneInteractPhotoRequestBuilder.srcSubId);
        } else {
            getRequestSender().handleForwardPhoto(qZoneInteractPhotoRequestBuilder, handler);
        }
    }

    public void getBigPhotoAdList(QZoneAlbumMediaRequestBuilder qZoneAlbumMediaRequestBuilder, Handler handler) {
        if (qZoneAlbumMediaRequestBuilder == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().getSender().getBigPhotoAdList(1, 2541, handler);
        } else {
            getRequestSender().handleRequestAdData(qZoneAlbumMediaRequestBuilder, handler);
        }
    }

    public void getCacheRecentAlbumPhoto(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, Callback callback) {
        if (qZoneAlbumRequestBuilder == null || isFeedxLayerUseMainProcess()) {
            return;
        }
        PictureManager.getInstance().getCacheRecentPhotoList(qZoneAlbumRequestBuilder.uin, qZoneAlbumRequestBuilder.startIndex, qZoneAlbumRequestBuilder.endIndex, qZoneAlbumRequestBuilder.reqType, callback);
    }

    public void getGroupPhotoList(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, Callback callback) {
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        getRequestSender().getGroupPhotoList(qZoneAlbumRequestBuilder, callback);
    }

    public void getMoreRecentAlbumPhoto(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, Callback callback) {
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().getMoreRecentPhotoList(qZoneAlbumRequestBuilder.uin, qZoneAlbumRequestBuilder.reqType, callback);
        } else {
            getRequestSender().getMoreRecentAlbumPhoto(qZoneAlbumRequestBuilder, callback);
        }
    }

    public void getMoreRecentVideoList(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, Callback callback) {
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        getRequestSender().getMoreRecentVideoList(qZoneAlbumRequestBuilder, callback);
    }

    public void getVideoId(QZoneAlbumMediaRequestBuilder qZoneAlbumMediaRequestBuilder, Handler handler) {
        if (qZoneAlbumMediaRequestBuilder == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().getVideoId(handler, qZoneAlbumMediaRequestBuilder.videoShareUrl);
        } else {
            getRequestSender().handleGetVideoId(qZoneAlbumMediaRequestBuilder, handler);
        }
    }

    public void loadMoreRecentAlbumTimeline(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, Callback callback) {
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().getPullDownRecentPhotoList(qZoneAlbumRequestBuilder.uin, callback);
        } else {
            getRequestSender().loadMoreRecentAlbumTimeline(qZoneAlbumRequestBuilder, callback);
        }
    }

    public void loadMoreUpRecentAlbumTimeline(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, Callback callback) {
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().getPullUpRecentPhotoList(qZoneAlbumRequestBuilder.uin, callback);
        } else {
            getRequestSender().loadMoreUpRecentAlbumTimeline(qZoneAlbumRequestBuilder, callback);
        }
    }

    public void praisePhoto(Handler handler, QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().getSender().praisePhoto(handler, qZoneInteractPhotoRequestBuilder.ugcKey, qZoneInteractPhotoRequestBuilder.feedKey, qZoneInteractPhotoRequestBuilder.curKey, qZoneInteractPhotoRequestBuilder.uniKey, qZoneInteractPhotoRequestBuilder.isLike, qZoneInteractPhotoRequestBuilder.appId, qZoneInteractPhotoRequestBuilder.extraInfoMap, qZoneInteractPhotoRequestBuilder.syn, qZoneInteractPhotoRequestBuilder.index);
        } else {
            getRequestSender().handlePraisePhoto(qZoneInteractPhotoRequestBuilder, handler);
        }
    }

    public void sendReportExposeOrClick(QZoneAlbumMediaRequestBuilder qZoneAlbumMediaRequestBuilder, Handler handler) {
        if (qZoneAlbumMediaRequestBuilder == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().getSender().sendReportExposeOrClick(qZoneAlbumMediaRequestBuilder.traceInfo, qZoneAlbumMediaRequestBuilder.uin, qZoneAlbumMediaRequestBuilder.isExpose, handler);
        } else {
            getRequestSender().handleSendReportExposeOrClick(qZoneAlbumMediaRequestBuilder, handler);
        }
    }

    private int checkFetchPhotoListDirection(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder) {
        if (qZoneAlbumRequestBuilder == null) {
            return 0;
        }
        int i3 = qZoneAlbumRequestBuilder.fetchLeft;
        if (i3 == 1 && qZoneAlbumRequestBuilder.fetchRight == 1) {
            return 0;
        }
        if (i3 == 1) {
            return 1;
        }
        return qZoneAlbumRequestBuilder.fetchRight == 1 ? 2 : 0;
    }

    private QZoneAlbumRequestBuilder makeUpPhotoBuilder(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder) {
        if (qZoneAlbumRequestBuilder == null) {
            return null;
        }
        if (TextUtils.isEmpty(qZoneAlbumRequestBuilder.cellId)) {
            qZoneAlbumRequestBuilder.cellId = "";
            qZoneAlbumRequestBuilder.reqType = 0;
        } else {
            qZoneAlbumRequestBuilder.reqType = 4;
        }
        return qZoneAlbumRequestBuilder;
    }

    private QZoneAlbumRequestBuilder makeUpMoodBuilder(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, PhotoParam photoParam) {
        if (qZoneAlbumRequestBuilder == null || photoParam == null) {
            return null;
        }
        qZoneAlbumRequestBuilder.cellId = photoParam.cell_id;
        qZoneAlbumRequestBuilder.photoId = "";
        qZoneAlbumRequestBuilder.albumId = "";
        qZoneAlbumRequestBuilder.reqType = 5;
        return qZoneAlbumRequestBuilder;
    }

    public void addFavor(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().getSender().addFavor(handler, qZoneInteractPhotoRequestBuilder.ownerUin, qZoneInteractPhotoRequestBuilder.appId, qZoneInteractPhotoRequestBuilder.subId, qZoneInteractPhotoRequestBuilder.cellId, qZoneInteractPhotoRequestBuilder.cellSubId, qZoneInteractPhotoRequestBuilder.ugcKey, qZoneInteractPhotoRequestBuilder.extendMap, qZoneInteractPhotoRequestBuilder.photoUrlList);
        } else {
            getRequestSender().handleAddFavor(qZoneInteractPhotoRequestBuilder, handler);
        }
    }

    public void commentPhoto(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().getSender().commentPhoto(handler, qZoneInteractPhotoRequestBuilder.ugcKey, qZoneInteractPhotoRequestBuilder.feedKey, qZoneInteractPhotoRequestBuilder.lloc, qZoneInteractPhotoRequestBuilder.appId, qZoneInteractPhotoRequestBuilder.ownerUin, qZoneInteractPhotoRequestBuilder.srcId, qZoneInteractPhotoRequestBuilder.content, qZoneInteractPhotoRequestBuilder.isVerified, qZoneInteractPhotoRequestBuilder.contentCacheUniKey, qZoneInteractPhotoRequestBuilder.extraInfoMap, qZoneInteractPhotoRequestBuilder.syn, qZoneInteractPhotoRequestBuilder.photo, qZoneInteractPhotoRequestBuilder.isPrivate, qZoneInteractPhotoRequestBuilder.commentPics, qZoneInteractPhotoRequestBuilder.index, qZoneInteractPhotoRequestBuilder.fontInfo, qZoneInteractPhotoRequestBuilder.superFontInfo, qZoneInteractPhotoRequestBuilder.barrageEffectInfo);
        } else {
            getRequestSender().handleCommentPhoto(qZoneInteractPhotoRequestBuilder, handler);
        }
    }

    public void getOutShareUrl(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        if (!isFeedxLayerUseMainProcess()) {
            PictureManager.getInstance().getOutShareUrl(handler, qZoneInteractPhotoRequestBuilder.appId, qZoneInteractPhotoRequestBuilder.ugcType, qZoneInteractPhotoRequestBuilder.cellId, qZoneInteractPhotoRequestBuilder.albumId, qZoneInteractPhotoRequestBuilder.lloc, qZoneInteractPhotoRequestBuilder.batchId, qZoneInteractPhotoRequestBuilder.iIsShareTo, qZoneInteractPhotoRequestBuilder.ownerUin, qZoneInteractPhotoRequestBuilder.shareScene, qZoneInteractPhotoRequestBuilder.extraInfoMap);
        } else {
            getRequestSender().handleGetOutShareUrl(qZoneInteractPhotoRequestBuilder, handler);
        }
    }

    public void getQZonePhotoListEx(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, Callback callback) {
        int i3;
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        if (TextUtils.isEmpty(qZoneAlbumRequestBuilder.photoId)) {
            qZoneAlbumRequestBuilder.photoId = "";
            i3 = 1;
        } else {
            i3 = 0;
        }
        PhotoParam makeUpPhotoParam = makeUpPhotoParam(qZoneAlbumRequestBuilder.photoParam);
        if (makeUpPhotoParam == null) {
            RFWLog.e(TAG, RFWLog.USR, "photoParam is null");
        } else {
            this.mRemoteCall.b(Long.valueOf(makeUpPhotoParam.ownerUin), makeUpPhotoParam.albumid, qZoneAlbumRequestBuilder.photoId, makeUpPhotoParam.albumanswer, Integer.valueOf(makeUpPhotoParam.sortType), 0, 0, 0, Integer.valueOf(i3), qZoneAlbumRequestBuilder.url, (HashMap) makeUpPhotoParam.busi_param, Integer.valueOf(makeUpPhotoParam.appid), makeUpPhotoParam.cell_id, Integer.valueOf(checkFetchPhotoListDirection(qZoneAlbumRequestBuilder)), Long.valueOf(qZoneAlbumRequestBuilder.albumType), Integer.valueOf(qZoneAlbumRequestBuilder.getPhotoExType), Long.valueOf(qZoneAlbumRequestBuilder.sharer), callback);
        }
    }
}
