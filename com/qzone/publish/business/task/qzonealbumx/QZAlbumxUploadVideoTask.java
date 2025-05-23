package com.qzone.publish.business.task.qzonealbumx;

import FileUpload.MultiPicInfo;
import FileUpload.PicExtendInfo;
import FileUpload.UploadPicInfoReq;
import FileUpload.UploadVideoInfoRsp;
import FileUpload.stPoi;
import FileUpload.stWaterTemplate;
import NS_MOBILE_PHOTO.upload_finish_rsp;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.publish.business.model.a;
import com.qzone.publish.business.protocol.QzoneMediaUploadRequest;
import com.qzone.publish.business.protocol.QzoneUploadPicFinishRequest;
import com.qzone.publish.business.publishqueue.common.CommonPublishVideoStatusInfo;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadVideoTaskParams;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxUploadAlbumEvent;
import com.qzone.reborn.editdraft.QZWinkEditDraftUtil;
import com.qzone.video.service.QzoneVideoPerfReport;
import com.qzone.video.service.QzoneVideoUploadActionReport;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedLogicManager;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.image.ImageProcessUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lc.n;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZAlbumxUploadVideoTask extends QZoneQueueTask implements QzoneMediaUploadRequest.b {
    private static final String REFER_VIDEO_SHUOSHUO = "video_shuoshuo";
    public static final int STEP_FINISH = 3;
    public static final int STEP_UPLOAD_VIDEO = 2;
    private static final String TAG = "QZPublishX_QZAlbumxUploadVideoTask";

    @NeedParcel
    private QZAlbumxUploadVideoTaskParams mParams;
    String uploadToAlbum = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadVideoToAlbum", "\u4e0a\u4f20\u89c6\u9891\u5230\u76f8\u518c");
    String uploadVideo = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadVideo", "\u4e0a\u4f20\u89c6\u9891");
    String publishing = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoPublishing", "\u53d1\u8868\u4e2d...");
    String notExist = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoVideoFileNotExist", "\u89c6\u9891\u6587\u4ef6\u4e0d\u5b58\u5728\uff01");

    public QZAlbumxUploadVideoTask() {
    }

    private void finalSuccessOperation(QZoneQueueTask qZoneQueueTask) {
        getPublishQueue().g(qZoneQueueTask, true);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.publish.business.task.qzonealbumx.e
            @Override // java.lang.Runnable
            public final void run() {
                QZAlbumxUploadVideoTask.this.lambda$finalSuccessOperation$2();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finalSuccessOperation$2() {
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String uinString = LoginData.getInstance().getUinString();
        QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams = this.mParams;
        simpleEventBus.dispatchEvent(new QZAlbumxUploadAlbumEvent(uinString, qZAlbumxUploadVideoTaskParams.albumId, this.batchId, qZAlbumxUploadVideoTaskParams.successCount, this.clientKey));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$triggerFetchRealFeed$1() {
        run();
    }

    private void triggerFetchRealFeed(final QZoneQueueTask qZoneQueueTask) {
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            le.b.f414397d.f(true, this.clientKey, new QzoneFakeFeedLogicManager.OnFetchFeedCompleteCallback() { // from class: com.qzone.publish.business.task.qzonealbumx.f
                @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedLogicManager.OnFetchFeedCompleteCallback
                public final void onComplete(boolean z16) {
                    QZAlbumxUploadVideoTask.this.lambda$triggerFetchRealFeed$0(qZoneQueueTask, z16);
                }
            });
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.qzonealbumx.g
                @Override // java.lang.Runnable
                public final void run() {
                    QZAlbumxUploadVideoTask.this.lambda$triggerFetchRealFeed$1();
                }
            }, 1000L);
        }
    }

    protected com.qzone.publish.ui.model.a buildQZoneMediaUploadParams(byte[] bArr) {
        com.qzone.publish.ui.model.a aVar = new com.qzone.publish.ui.model.a();
        aVar.C(0).A(this.mParams.refer).d(this.batchId).f(this.clientKey).F(this.mParams.uploadEntrance).b(this.mParams.albumId).H(this.mParams.uploadTime).q(111).L(0).O(bArr).N(this.mParams.stExternalMapExt).K(this.mParams.maxNum).M(this.mParams.curNum).l(true).y(k5.a.d(this.mParams.poiInfo)).B(this.mParams.shootParams).e("video_shuoshuo");
        return aVar;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean cancel() {
        QZLog.i(TAG, getTaskDesc() + ", cancel");
        this.mParams.taskIsRunning = false;
        QZoneRequest qZoneRequest = this.mRequest;
        if (!(qZoneRequest instanceof QzoneMediaUploadRequest)) {
            return true;
        }
        ((QzoneMediaUploadRequest) qZoneRequest).cancel();
        return true;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams = this.mParams;
        if (qZAlbumxUploadVideoTaskParams != null && !qZAlbumxUploadVideoTaskParams.isSingleVideo) {
            return this.clientKey + "_" + this.mParams.curNum;
        }
        return this.clientKey;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public String getCaseId() {
        return LoginData.getInstance().getUinString();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public List<String> getEditMissionId() {
        QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams = this.mParams;
        if (qZAlbumxUploadVideoTaskParams == null) {
            return null;
        }
        return QZWinkEditDraftUtil.g(qZAlbumxUploadVideoTaskParams.shuoshuoVideoInfo);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return this.mParams.isSingleVideo ? 15 : 16;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public long getFakeSize() {
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.mParams.shuoshuoVideoInfo;
        if (shuoshuoVideoInfo == null) {
            return 0L;
        }
        double d16 = shuoshuoVideoInfo.mEstimateSize;
        return d16 > 0.0d ? (long) d16 : shuoshuoVideoInfo.mSize;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public com.qzone.publish.business.task.c getInfo() {
        com.qzone.publish.business.task.c info = super.getInfo();
        if (info == null) {
            return null;
        }
        info.f51185a = this.uploadToAlbum + "\u300a" + this.mParams.albumName + "\u300b";
        if (getState() == 1) {
            long j3 = this.mRecvDataSize;
            if (j3 > 0) {
                long j16 = this.mTotalSize;
                if (j16 > 0) {
                    info.f51190f = Math.max((int) ((j3 * 100) / j16), 1);
                    info.f51186b = this.uploadVideo + this.mRecvDataSize + "/" + this.mTotalSize + "K";
                }
            }
            QZoneRequest qZoneRequest = this.mRequest;
            if (qZoneRequest instanceof QzoneMediaUploadRequest) {
                info = ((QzoneMediaUploadRequest) qZoneRequest).getInfo(info);
            } else {
                info.f51186b = this.publishing;
            }
        } else if (getState() != 3 && getState() != 2) {
            if (getState() == 7) {
                info.f51186b = com.qzone.reborn.configx.g.f53821a.j().t();
            }
        } else if (!isVideoExist()) {
            info.f51186b = this.notExist;
        } else if (this.mResultCode != 0 && !TextUtils.isEmpty(this.f45835msg)) {
            info.f51186b = this.f45835msg;
        }
        info.f51192h = getVideoCoverUrl();
        info.f51193i = true;
        return info;
    }

    public Map<String, String> getLocalUrlMap() {
        return this.mParams.localUrlMap;
    }

    public QZAlbumxUploadVideoTaskParams getParams() {
        return this.mParams;
    }

    protected String getTaskDesc() {
        return "id:" + getTaskId() + ", batchId:" + this.batchId + ", fakeKey:" + getCommentUniKey();
    }

    public String getVideoCoverUrl() {
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.mParams.shuoshuoVideoInfo;
        if (shuoshuoVideoInfo != null) {
            return shuoshuoVideoInfo.mCoverUrl;
        }
        return "";
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isNullTask() {
        QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams = this.mParams;
        return qZAlbumxUploadVideoTaskParams == null || (TextUtils.isEmpty(qZAlbumxUploadVideoTaskParams.albumId) && TextUtils.isEmpty(this.mParams.albumName) && this.mParams.videoInfo == null);
    }

    protected boolean isVideoExist() {
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.mParams.shuoshuoVideoInfo;
        if (shuoshuoVideoInfo == null || TextUtils.isEmpty(shuoshuoVideoInfo.mVideoPath)) {
            return false;
        }
        return new File(this.mParams.shuoshuoVideoInfo.mVideoPath).exists();
    }

    protected boolean isVideoNeedProcess() {
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.mParams.shuoshuoVideoInfo;
        if (shuoshuoVideoInfo == null || TextUtils.isEmpty(shuoshuoVideoInfo.mVideoPath)) {
            return false;
        }
        return this.mParams.shuoshuoVideoInfo.mNeedProcess;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isVideoTask() {
        return this.mParams.shuoshuoVideoInfo != null;
    }

    public void notifyTranscodeFeed() {
        QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams = this.mParams;
        ShuoshuoVideoInfo shuoshuoVideoInfo = qZAlbumxUploadVideoTaskParams.shuoshuoVideoInfo;
        if (shuoshuoVideoInfo == null) {
            return;
        }
        VideoInfo videoInfo = qZAlbumxUploadVideoTaskParams.videoInfo;
        videoInfo.isUploading = false;
        videoInfo.isTranscoding = true;
        videoInfo.isFakeFeed = true;
        long j3 = shuoshuoVideoInfo.mDuration;
        videoInfo.videoTime = j3;
        videoInfo.validVideoTime = j3;
        videoInfo.showVideoTime = VideoInfo.getShownTimeFromNumeric(j3);
        VideoInfo videoInfo2 = this.mParams.videoInfo;
        videoInfo2.playType = (byte) 1;
        videoInfo2.actionType = 3;
        i.H().O1(getCommentUniKey(), this.mParams.videoInfo);
        QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams2 = this.mParams;
        if (qZAlbumxUploadVideoTaskParams2.isSingleVideo) {
            lc.i.f414345a.z(this.clientKey, new CommonPublishVideoStatusInfo(true, 2, qZAlbumxUploadVideoTaskParams2.videoInfo));
        }
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressFailed(String str, int i3, int i16, String str2) {
        getPublishQueue().d(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressProgress(String str, int i3, double d16) {
        getPublishQueue().d(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressSuccess(String str, String str2, int i3) {
        getPublishQueue().d(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadFailed(int i3, int i16, String str) {
        QZLog.w(TAG, "onMediaUploadFailed mediaIndex:" + i3 + ", errCode:" + i16 + ", errMsg:" + str);
        getPublishQueue().d(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadReport(a.C0436a c0436a) {
        addReportInfo(c0436a);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadStart(int i3, String str, String str2) {
        getPublishQueue().d(this);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onRemove() {
        super.onRemove();
        QZLog.i(TAG, getTaskDesc() + ", onRemove");
        this.mParams.taskIsRunning = false;
        if (n.c(this.batchId)) {
            long j3 = this.batchId;
            HashMap hashMap = new HashMap();
            QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams = this.mParams;
            n.a b16 = n.b(j3, false, hashMap, qZAlbumxUploadVideoTaskParams.albumId, qZAlbumxUploadVideoTaskParams.clientKey);
            this.mParams.localUrlMap = b16.f414356e;
            QZLog.i(TAG, 1, getTaskDesc() + ", upload video onRemove, bacth " + b16.toString());
            n.d(this.batchId);
        }
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        if (this.mParams == null) {
            QZLog.e(TAG, getTaskDesc() + ", onRun -- mParams is null");
            return;
        }
        QZLog.e(TAG, getTaskDesc() + ", onRun -- mStep: " + this.mParams.step);
        com.qzone.publish.business.model.a aVar = this.mReportInfo;
        if (aVar != null && (aVar.f51012c == 0 || aVar.f51014e < this.retryNum)) {
            com.qzone.publish.business.model.a aVar2 = new com.qzone.publish.business.model.a();
            this.mReportInfo = aVar2;
            aVar2.f51010a = 2;
            aVar2.f51012c = System.currentTimeMillis();
            this.mReportInfo.f51014e = this.retryNum;
        }
        if (this.mState != 5) {
            QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams = this.mParams;
            if (!qZAlbumxUploadVideoTaskParams.taskIsRunning) {
                qZAlbumxUploadVideoTaskParams.taskIsRunning = true;
            }
        }
        QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams2 = this.mParams;
        int i3 = qZAlbumxUploadVideoTaskParams2.step;
        if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            int i16 = qZAlbumxUploadVideoTaskParams2.successCount;
            long j3 = this.batchId;
            QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams3 = this.mParams;
            String str = qZAlbumxUploadVideoTaskParams3.albumId;
            if (str == null) {
                str = "";
            }
            QzoneUploadPicFinishRequest qzoneUploadPicFinishRequest = new QzoneUploadPicFinishRequest(j3, str, i16, qZAlbumxUploadVideoTaskParams3.successCount, qZAlbumxUploadVideoTaskParams3.retryCount, this.clientKey, i16);
            this.mRequest = qzoneUploadPicFinishRequest;
            qzoneUploadPicFinishRequest.setRefer(this.mParams.refer);
            this.mParams.retryCount++;
            QZLog.i(TAG, 1, getTaskDesc() + ",  upload video finish, send upload_finish_req req, mRetryCount: " + this.mParams.retryCount);
            return;
        }
        if (!isVideoNeedProcess() && !isVideoExist()) {
            this.f45835msg = this.notExist;
            QZLog.e(TAG, getTaskDesc() + ", video file not found, completeTask false");
            getPublishQueue().g(this, false);
            return;
        }
        if (isVideoTask()) {
            UniAttribute uniAttribute = new UniAttribute();
            uniAttribute.setEncodeName("utf8");
            uniAttribute.put("hostuin", Long.valueOf(LoginData.getInstance().getUin()));
            if (!TextUtils.isEmpty(this.mParams.refer)) {
                uniAttribute.put("refer", this.mParams.refer);
            }
            com.qzone.publish.ui.model.a buildQZoneMediaUploadParams = buildQZoneMediaUploadParams(buildExtra());
            ArrayList arrayList = new ArrayList();
            QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams4 = this.mParams;
            ShuoshuoVideoInfo shuoshuoVideoInfo = qZAlbumxUploadVideoTaskParams4.shuoshuoVideoInfo;
            shuoshuoVideoInfo.mDesc = qZAlbumxUploadVideoTaskParams4.content;
            arrayList.add(new MediaWrapper(shuoshuoVideoInfo));
            this.mRequest = new QzoneMediaUploadRequest(arrayList, buildQZoneMediaUploadParams, this, this);
            com.qzone.publish.business.model.a aVar3 = this.mReportInfo;
            if (aVar3 != null) {
                aVar3.f51011b = 5;
            }
        }
    }

    public static String getEmptyString(String str) {
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$triggerFetchRealFeed$0(QZoneQueueTask qZoneQueueTask, boolean z16) {
        if (z16) {
            finalSuccessOperation(qZoneQueueTask);
        }
    }

    protected byte[] buildExtra() {
        UploadPicInfoReq uploadPicInfoReq = new UploadPicInfoReq();
        uploadPicInfoReq.sPicTitle = getEmptyString(this.mParams.picTitle);
        uploadPicInfoReq.sPicDesc = getEmptyString(this.mParams.shuoshuoVideoInfo.mDescription);
        uploadPicInfoReq.sAlbumID = getEmptyString(this.mParams.albumId);
        uploadPicInfoReq.sAlbumName = getEmptyString(this.mParams.albumName);
        QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams = this.mParams;
        uploadPicInfoReq.iAlbumTypeID = qZAlbumxUploadVideoTaskParams.albumTypeId;
        uploadPicInfoReq.iBitmap = qZAlbumxUploadVideoTaskParams.iBitmap;
        uploadPicInfoReq.iUploadType = qZAlbumxUploadVideoTaskParams.iUploadType;
        uploadPicInfoReq.iUpPicType = qZAlbumxUploadVideoTaskParams.iUpPicType;
        uploadPicInfoReq.iBatchID = qZAlbumxUploadVideoTaskParams.batchId;
        uploadPicInfoReq.mutliPicInfo = qZAlbumxUploadVideoTaskParams.multiPicInfo;
        uploadPicInfoReq.mapExt = qZAlbumxUploadVideoTaskParams.mapExt;
        PicExtendInfo picExtendInfo = qZAlbumxUploadVideoTaskParams.stExtendInfo;
        uploadPicInfoReq.stExtendInfo = picExtendInfo;
        uploadPicInfoReq.stExternalMapExt = qZAlbumxUploadVideoTaskParams.stExternalMapExt;
        uploadPicInfoReq.sPicPath = qZAlbumxUploadVideoTaskParams.picPath;
        if (picExtendInfo == null) {
            PicExtendInfo picExtendInfo2 = new PicExtendInfo();
            qZAlbumxUploadVideoTaskParams.stExtendInfo = picExtendInfo2;
            uploadPicInfoReq.stExtendInfo = picExtendInfo2;
            picExtendInfo2.mapParams = new HashMap();
        }
        PicExtendInfo picExtendInfo3 = uploadPicInfoReq.stExtendInfo;
        if (picExtendInfo3 != null && picExtendInfo3.mapParams != null && !TextUtils.isEmpty(this.clientKey)) {
            uploadPicInfoReq.stExtendInfo.mapParams.put(v4.b.CLIENTKEY, this.clientKey);
        }
        PicExtendInfo picExtendInfo4 = uploadPicInfoReq.stExtendInfo;
        Map<String, String> map = picExtendInfo4 == null ? null : picExtendInfo4.mapExif;
        String str = "";
        if (map != null) {
            String str2 = map.get(UploadConfiguration.getExifTagCode("Make"));
            if (str2 == null) {
                str2 = "";
            }
            uploadPicInfoReq.sExif_CameraMaker = str2;
            String str3 = map.get(UploadConfiguration.getExifTagCode("Model"));
            if (str3 == null) {
                str3 = "";
            }
            uploadPicInfoReq.sExif_CameraModel = str3;
            String str4 = map.get(UploadConfiguration.getExifTagCode("GPSLatitude"));
            if (str4 == null) {
                str4 = "";
            }
            uploadPicInfoReq.sExif_Latitude = str4;
            String str5 = map.get(UploadConfiguration.getExifTagCode("GPSLatitudeRef"));
            if (str5 == null) {
                str5 = "";
            }
            uploadPicInfoReq.sExif_LatitudeRef = str5;
            String str6 = map.get(UploadConfiguration.getExifTagCode("GPSLongitude"));
            if (str6 == null) {
                str6 = "";
            }
            uploadPicInfoReq.sExif_Longitude = str6;
            String str7 = map.get(UploadConfiguration.getExifTagCode("GPSLongitudeRef"));
            if (str7 == null) {
                str7 = "";
            }
            uploadPicInfoReq.sExif_LongitudeRef = str7;
            if (this.mParams.iUploadType == 3) {
                String str8 = map.get(UploadConfiguration.getExifTagCode("Orientation"));
                try {
                    int parseInt = Integer.parseInt(str8);
                    if (parseInt == 3) {
                        str8 = "180";
                    } else if (parseInt == 6) {
                        str8 = "90";
                    } else if (parseInt != 8) {
                        str8 = "0";
                    } else {
                        str8 = "270";
                    }
                } catch (NumberFormatException unused) {
                }
                PicExtendInfo picExtendInfo5 = uploadPicInfoReq.stExtendInfo;
                if (picExtendInfo5.mapParams == null) {
                    picExtendInfo5.mapParams = new HashMap();
                }
                Map<String, String> map2 = uploadPicInfoReq.stExtendInfo.mapParams;
                if (str8 == null) {
                    str8 = "";
                }
                map2.put(BasicAnimation.KeyPath.ROTATION, str8);
            }
        }
        QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams2 = this.mParams;
        uploadPicInfoReq.sExif_Time = qZAlbumxUploadVideoTaskParams2.exifTime;
        uploadPicInfoReq.iUploadTime = qZAlbumxUploadVideoTaskParams2.uploadTime;
        if (TextUtils.isEmpty(qZAlbumxUploadVideoTaskParams2.albumId)) {
            uploadPicInfoReq.iAlbumTypeID = 1;
        } else {
            uploadPicInfoReq.iAlbumTypeID = 0;
            uploadPicInfoReq.sAlbumID = this.mParams.albumId;
        }
        HashMap hashMap = (HashMap) uploadPicInfoReq.mapExt;
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        hashMap.put(FSUploadConst.KEY_FAKEFEED_CLIENTKEY, getEmptyString(this.clientKey));
        PicExtendInfo picExtendInfo6 = uploadPicInfoReq.stExtendInfo;
        if (picExtendInfo6 != null && picExtendInfo6.mapParams == null) {
            picExtendInfo6.mapParams = new HashMap();
        }
        if (uploadPicInfoReq.stExtendInfo != null && !TextUtils.isEmpty(this.mParams.picPath)) {
            try {
                String str9 = this.mParams.picPath;
                BitmapFactory.Options decodeBitmapOptions = ImageProcessUtil.decodeBitmapOptions(str9);
                uploadPicInfoReq.stExtendInfo.mapParams.put("raw_width", Integer.toString(decodeBitmapOptions.outWidth));
                uploadPicInfoReq.stExtendInfo.mapParams.put("raw_height", Integer.toString(decodeBitmapOptions.outHeight));
                uploadPicInfoReq.stExtendInfo.mapParams.put("raw_size", Long.toString(new File(str9).length()));
                String str10 = this.mParams.stExtendInfo.mapParams.get("geo_x");
                Map<String, String> map3 = uploadPicInfoReq.stExtendInfo.mapParams;
                if (str10 == null) {
                    str10 = "";
                }
                map3.put("geo_x", str10);
                String str11 = this.mParams.stExtendInfo.mapParams.get("geo_y");
                Map<String, String> map4 = uploadPicInfoReq.stExtendInfo.mapParams;
                if (str11 == null) {
                    str11 = "";
                }
                map4.put("geo_y", str11);
                String str12 = this.mParams.stExtendInfo.mapParams.get("geo_id");
                Map<String, String> map5 = uploadPicInfoReq.stExtendInfo.mapParams;
                if (str12 == null) {
                    str12 = "";
                }
                map5.put("geo_id", str12);
                String str13 = this.mParams.stExtendInfo.mapParams.get("geo_idname");
                Map<String, String> map6 = uploadPicInfoReq.stExtendInfo.mapParams;
                if (str13 == null) {
                    str13 = "";
                }
                map6.put("geo_idname", str13);
                String str14 = this.mParams.stExtendInfo.mapParams.get("geo_name");
                Map<String, String> map7 = uploadPicInfoReq.stExtendInfo.mapParams;
                if (str14 != null) {
                    str = str14;
                }
                map7.put("geo_name", str);
                String str15 = this.mParams.stExtendInfo.mapParams.get("show_geo");
                uploadPicInfoReq.stExtendInfo.mapParams.put("show_geo", str15 == null ? "0" : str15);
            } catch (Exception e16) {
                QZLog.e(TAG, e16.toString());
            }
        }
        if (!TextUtils.isEmpty(this.mParams.refer)) {
            hashMap.put("refer", this.mParams.refer);
        }
        uploadPicInfoReq.mapExt = hashMap;
        QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams3 = this.mParams;
        uploadPicInfoReq.iDistinctUse = qZAlbumxUploadVideoTaskParams3.iDistinctUse;
        uploadPicInfoReq.uploadPoi = convertPoiInfo(qZAlbumxUploadVideoTaskParams3.poiInfo);
        QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams4 = this.mParams;
        uploadPicInfoReq.waterTemplate = new stWaterTemplate(qZAlbumxUploadVideoTaskParams4.waterTemplateId, qZAlbumxUploadVideoTaskParams4.watermarkPoiName);
        QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams5 = this.mParams;
        int i3 = qZAlbumxUploadVideoTaskParams5.iBusiNessType;
        uploadPicInfoReq.iBusiNessType = i3;
        if (i3 == 1) {
            byte[] bArr = qZAlbumxUploadVideoTaskParams5.vBusiNessData;
            if (bArr == null) {
                bArr = new byte[0];
            }
            uploadPicInfoReq.vBusiNessData = bArr;
        } else {
            uploadPicInfoReq.vBusiNessData = new byte[0];
        }
        try {
            return pack("UploadPicInfoReq", uploadPicInfoReq);
        } catch (Exception e17) {
            QZLog.e(TAG, e17.toString());
            return null;
        }
    }

    protected stPoi convertPoiInfo(LbsDataV2.PoiInfo poiInfo) {
        if (poiInfo != null) {
            return k5.a.d(poiInfo);
        }
        return null;
    }

    protected void onMediaVideoUploadSuccess(UploadVideoInfoRsp uploadVideoInfoRsp, int i3) {
        if (uploadVideoInfoRsp == null) {
            return;
        }
        if (this.mUniAttr == null) {
            this.mUniAttr = new UniAttribute();
        }
        this.mUniAttr.put("response", uploadVideoInfoRsp);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3;
        QZLog.i(TAG, 2, getTaskDesc() + ", onTaskResponse mStep: " + this.mParams.step);
        int i16 = this.mParams.step;
        boolean z16 = false;
        if (i16 != 2) {
            if (i16 != 3) {
                return;
            }
            if (qZoneTask.succeeded()) {
                upload_finish_rsp upload_finish_rspVar = (upload_finish_rsp) qZoneTask.mRequest.rsp;
                if (upload_finish_rspVar != null && upload_finish_rspVar.retry_timeout > 0) {
                    QZLog.i(TAG, 1, getTaskDesc() + ", upload_finish_rsp rptFinish rsp.retry_timeout:" + upload_finish_rspVar.retry_timeout);
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.qzonealbumx.QZAlbumxUploadVideoTask.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QZAlbumxUploadVideoTask.this.run();
                        }
                    }, (long) (upload_finish_rspVar.retry_timeout * 1000));
                    z16 = true;
                }
                if (z16) {
                    return;
                }
                QZLog.i(TAG, getTaskDesc() + ", send upload_finish_rsp succeed, videoPath:" + this.mParams.shuoshuoVideoInfo.mVideoPath);
                lc.i.f414345a.n(this.clientKey, (HashMap) getLocalUrlMap(), this.mUniAttr);
                finalSuccessOperation((QZoneQueueTask) qZoneTask);
                return;
            }
            String[] split = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FAKE_FEED_RETRY_TIMEOUT, QzoneConfig.DefaultValue.DEFAULT_FAKE_FEED_RETRY_TIMEOUT).split("/");
            if (split == null || (i3 = this.mParams.retryCount) > split.length) {
                return;
            }
            int parseInt = Integer.parseInt(split[i3 - 1]);
            QZLog.i(TAG, 1, getTaskDesc() + ", retry send upload_finish_rsp, retryCount:" + this.mParams.retryCount + ", retryTimeout:" + parseInt);
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.qzonealbumx.QZAlbumxUploadVideoTask.2
                @Override // java.lang.Runnable
                public void run() {
                    QZAlbumxUploadVideoTask.this.run();
                }
            }, (long) (parseInt * 1000));
            return;
        }
        if (qZoneTask.succeeded()) {
            QZLog.i(TAG, getTaskDesc() + ", upload video succeed, videoPath:" + this.mParams.shuoshuoVideoInfo.mVideoPath);
            QzoneVideoUploadActionReport.b().d(this.mParams.shuoshuoVideoInfo.mVideoPath, "end_upload", 0);
            QzoneVideoPerfReport.a(this.mParams.shuoshuoVideoInfo.perfKey, 4);
            notifyTranscodeFeed();
            addReportInfo(this.mParams.mediaReportInfo);
            if (qZoneTask.mUniAttr != null && qZoneTask.mResultCode != 1000006) {
                if (n.c(this.batchId)) {
                    UploadVideoInfoRsp uploadVideoInfoRsp = (UploadVideoInfoRsp) qZoneTask.mUniAttr.get("response");
                    if (uploadVideoInfoRsp == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(uploadVideoInfoRsp.sVid, this.mParams.localUrlMap.get(this.clientKey));
                    long j3 = this.batchId;
                    boolean succeeded = qZoneTask.succeeded();
                    QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams = this.mParams;
                    n.a b16 = n.b(j3, succeeded, hashMap, qZAlbumxUploadVideoTaskParams.albumId, qZAlbumxUploadVideoTaskParams.clientKey);
                    this.mParams.localUrlMap = b16.f414356e;
                    QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
                    String str = uploadVideoInfoRsp.sVid;
                    ShuoshuoVideoInfo shuoshuoVideoInfo = this.mParams.shuoshuoVideoInfo;
                    v06.h2(str, shuoshuoVideoInfo.mStartTime, shuoshuoVideoInfo.mEndTime);
                    QZLog.i(TAG, 1, getTaskDesc() + ", upload video success, vid: " + uploadVideoInfoRsp.sVid + ", uploadInfo:" + b16);
                    ShuoshuoVideoInfo shuoshuoVideoInfo2 = this.mParams.shuoshuoVideoInfo;
                    if (shuoshuoVideoInfo2.needDeleteLocal && !TextUtils.isEmpty(shuoshuoVideoInfo2.mVideoPath)) {
                        new File(this.mParams.shuoshuoVideoInfo.mVideoPath).delete();
                    }
                    if (b16.f414353b == b16.f414355d && b16.f414354c == 0) {
                        QZLog.i(TAG, 1, getTaskDesc() + ", all batch media upload finish, " + b16);
                        QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams2 = this.mParams;
                        qZAlbumxUploadVideoTaskParams2.step = 3;
                        qZAlbumxUploadVideoTaskParams2.successCount = b16.f414353b;
                        if (com.qzone.reborn.configx.g.f53821a.j().n()) {
                            setState(7);
                            getPublishQueue().c(this);
                            QZLog.i(TAG, 1, getTaskDesc() + "onTaskResponse, set STATE_FINISH_REQUEST");
                        }
                        if (!this.mParams.isSingleVideo) {
                            lc.i.f414345a.z(this.clientKey, new CommonPublishVideoStatusInfo(false, 2, null));
                        }
                        triggerFetchRealFeed((QZoneQueueTask) qZoneTask);
                        return;
                    }
                    QZLog.i(TAG, 1, getTaskDesc() + ", batch in uploading, " + b16);
                    getPublishQueue().g((QZoneQueueTask) qZoneTask, true);
                    return;
                }
                getPublishQueue().g((QZoneQueueTask) qZoneTask, true);
                return;
            }
            getPublishQueue().g((QZoneQueueTask) qZoneTask, true);
            return;
        }
        if (this.mRequest instanceof QzoneMediaUploadRequest) {
            QZLog.e(TAG, getTaskDesc() + ", upload video failed, resultCode:" + this.mResultCode + ", resultMsg:" + this.f45835msg + ",completeTask false, videoPath:" + this.mParams.shuoshuoVideoInfo.mVideoPath);
            getPublishQueue().g(this, false);
            this.mParams.taskIsRunning = false;
        }
    }

    public QZAlbumxUploadVideoTask(QZAlbumxUploadVideoTaskParams qZAlbumxUploadVideoTaskParams) {
        this.mParams = qZAlbumxUploadVideoTaskParams;
        if (qZAlbumxUploadVideoTaskParams == null) {
            return;
        }
        this.clientKey = qZAlbumxUploadVideoTaskParams.clientKey;
        this.batchId = qZAlbumxUploadVideoTaskParams.batchId;
        if (qZAlbumxUploadVideoTaskParams.maxNum == 1) {
            qZAlbumxUploadVideoTaskParams.isSingleVideo = true;
        }
        ShuoshuoVideoInfo shuoshuoVideoInfo = qZAlbumxUploadVideoTaskParams.shuoshuoVideoInfo;
        if (shuoshuoVideoInfo != null) {
            qZAlbumxUploadVideoTaskParams.originalVideoPath = shuoshuoVideoInfo.mVideoPath;
            HashMap hashMap = new HashMap();
            qZAlbumxUploadVideoTaskParams.localUrlMap = hashMap;
            hashMap.put(this.clientKey, qZAlbumxUploadVideoTaskParams.shuoshuoVideoInfo.mVideoPath);
        }
        MultiPicInfo multiPicInfo = new MultiPicInfo();
        qZAlbumxUploadVideoTaskParams.multiPicInfo = multiPicInfo;
        multiPicInfo.iBatUploadNum = qZAlbumxUploadVideoTaskParams.maxNum;
        multiPicInfo.iCurUpload = qZAlbumxUploadVideoTaskParams.curNum;
        HashMap<String, String> hashMap2 = new HashMap<>();
        qZAlbumxUploadVideoTaskParams.stExternalMapExt = hashMap2;
        hashMap2.put(FSUploadConst.KEY_MIX_FEED, "1");
        ShuoshuoVideoInfo shuoshuoVideoInfo2 = qZAlbumxUploadVideoTaskParams.shuoshuoVideoInfo;
        a.C0436a c0436a = new a.C0436a(2, shuoshuoVideoInfo2 != null ? shuoshuoVideoInfo2.mVideoPath : null);
        qZAlbumxUploadVideoTaskParams.mediaReportInfo = c0436a;
        ShuoshuoVideoInfo shuoshuoVideoInfo3 = qZAlbumxUploadVideoTaskParams.shuoshuoVideoInfo;
        c0436a.f51028c = shuoshuoVideoInfo3 != null ? shuoshuoVideoInfo3.mSize / 1024 : 0L;
    }

    public static final byte[] pack(String str, Object obj) throws Exception {
        if (str == null || obj == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket();
        uniPacket.setEncodeName("UTF-8");
        uniPacket.setRequestId(0);
        uniPacket.setFuncName("FuncName");
        uniPacket.setServantName("ServantName");
        uniPacket.put(str, obj);
        byte[] encode = uniPacket.encode();
        uniPacket.clearCacheData();
        return encode;
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadSuccess(JceStruct jceStruct, AbstractUploadTask abstractUploadTask, int i3, String str, String str2, String str3) {
        if (jceStruct == null || i3 < 0) {
            return;
        }
        QZLog.i(TAG, "onMediaUploadSuccess mediaIndex:" + i3 + ", id:" + str + ", srcPath:" + str2 + ", uploadPath:" + str3);
        if (jceStruct instanceof UploadVideoInfoRsp) {
            onMediaVideoUploadSuccess((UploadVideoInfoRsp) jceStruct, i3);
        }
    }
}
