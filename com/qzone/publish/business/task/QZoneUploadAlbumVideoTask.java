package com.qzone.publish.business.task;

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
import com.qzone.publish.business.publishqueue.h;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.editdraft.QZWinkEditDraftUtil;
import com.qzone.util.image.ImageInfo;
import com.qzone.video.service.QzoneVideoPerfReport;
import com.qzone.video.service.QzoneVideoUploadActionReport;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedLogicManager;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.image.ImageProcessUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneUploadAlbumVideoTask extends QZoneQueueTask implements QzoneMediaUploadRequest.b {
    public static final String REFER_VIDEO_SHUOSHUO = "video_shuoshuo";
    protected static final int STEP_FINISH = 3;
    protected static final int STEP_UPLOAD_VIDEO = 2;
    protected static final String TAG = "[upload2_QZoneUploadAlbumVideoTask]";

    @NeedParcel
    public BusinessAlbumInfo albumInfo;
    String composing;

    @NeedParcel
    protected int curNum;

    @NeedParcel
    public String exifTime;

    @NeedParcel
    public Map<String, byte[]> extras;

    @NeedParcel
    public int iAlbumTypeID;

    @NeedParcel
    public int iBitmap;
    public int iBusiNessType;
    public int iDistinctUse;

    @NeedParcel
    public int iUpPicType;

    @NeedParcel
    public int iUploadType;

    @NeedParcel
    public List<ImageInfo> imageInfos;
    protected boolean isQunUplaod;

    @NeedParcel
    protected boolean isSingleVideo;

    @NeedParcel
    public String lbsAddress;

    @NeedParcel
    protected Map<String, String> localUrlMap;

    @NeedParcel
    public String mContent;

    @NeedParcel
    public String mOriginalVideoPath;

    @NeedParcel
    protected LbsDataV2.PoiInfo mPoiInfo;

    @NeedParcel
    protected String mRefer;
    protected int mRetryCount;

    @NeedParcel
    protected Map<String, String> mShootParams;

    @NeedParcel
    protected int mStep;
    protected int mSuccessCount;
    public boolean mTaskIsRunning;

    @NeedParcel
    protected ShuoshuoVideoInfo mVideoInfo;
    public HashMap<String, String> mapExt;

    @NeedParcel
    protected int maxNum;
    a.C0436a mediaReportInfo;
    b mixUploadTask;

    @NeedParcel
    public MultiPicInfo mutliPicInfo;
    String notExist;

    @NeedParcel
    public String picPath;
    String publishing;

    @NeedParcel
    public String sAlbumID;

    @NeedParcel
    public String sAlbumName;

    @NeedParcel
    public String sPicTitle;

    @NeedParcel
    public PicExtendInfo stExtendInfo;
    public HashMap<String, String> stExternalMapExt;

    @NeedParcel
    public long svrTime;
    String timeOut;

    @NeedParcel
    public int uploadEntrance;

    @NeedParcel
    protected long uploadTime;
    String uploadToAlbum;
    String uploadVideo;
    public byte[] vBusiNessData;

    @NeedParcel
    public VideoInfo videoInfo;

    @NeedParcel
    public String waterTemplateId;

    @NeedParcel
    public String watermarkPoiName;

    public QZoneUploadAlbumVideoTask() {
        this.mStep = 2;
        this.mSuccessCount = 0;
        this.mRetryCount = 0;
        this.sPicTitle = "";
        this.sAlbumName = "";
        this.sAlbumID = "";
        this.iAlbumTypeID = 0;
        this.iBitmap = 0;
        this.iUploadType = 0;
        this.iUpPicType = 0;
        this.mutliPicInfo = null;
        this.stExtendInfo = null;
        this.iDistinctUse = 0;
        this.iBusiNessType = 0;
        this.vBusiNessData = null;
        this.stExternalMapExt = null;
        this.mapExt = null;
        this.exifTime = "";
        this.picPath = "";
        this.isQunUplaod = false;
        this.mTaskIsRunning = false;
        this.uploadToAlbum = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadVideoToAlbum", "\u4e0a\u4f20\u89c6\u9891\u5230\u76f8\u518c");
        this.uploadVideo = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadVideo", "\u4e0a\u4f20\u89c6\u9891");
        this.composing = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoVideoComposing ", "\u89c6\u9891\u5408\u6210\u4e2d ");
        this.publishing = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoPublishing", "\u53d1\u8868\u4e2d...");
        this.notExist = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoVideoFileNotExist", "\u89c6\u9891\u6587\u4ef6\u4e0d\u5b58\u5728\uff01");
        this.timeOut = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoProcessVideoTimeOut", "\u89c6\u9891\u5904\u7406\u8d85\u65f6");
    }

    private void finalSuccessOperation() {
        String str = LoginData.getInstance().getUin() + "";
        QzoneVideoUploadActionReport.b().d(this.mVideoInfo.mVideoPath, "end_request_2fakefeed", 0);
        QzoneVideoPerfReport.a(this.mVideoInfo.perfKey, 5).d(this.mVideoInfo.perfKey, str);
    }

    private void triggerFetchRealFeed() {
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            le.b.f414397d.f(true, this.clientKey, new QzoneFakeFeedLogicManager.OnFetchFeedCompleteCallback() { // from class: com.qzone.publish.business.task.d
                @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedLogicManager.OnFetchFeedCompleteCallback
                public final void onComplete(boolean z16) {
                    QZoneUploadAlbumVideoTask.this.lambda$triggerFetchRealFeed$0(z16);
                }
            });
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.QZoneUploadAlbumVideoTask.3
                @Override // java.lang.Runnable
                public void run() {
                    QZoneUploadAlbumVideoTask.this.run();
                }
            }, 1000L);
        }
    }

    protected com.qzone.publish.ui.model.a buildQZoneMediaUploadParams(byte[] bArr) {
        com.qzone.publish.ui.model.a aVar = new com.qzone.publish.ui.model.a();
        aVar.C(0).A(this.mRefer).d(this.batchId).f(this.clientKey).F(this.uploadEntrance).b(this.sAlbumID).H(this.uploadTime).q(111).L(0).O(bArr).N(this.stExternalMapExt).K(this.maxNum).M(this.curNum).l(true).y(k5.a.d(this.mPoiInfo)).B(this.mShootParams).e("video_shuoshuo");
        return aVar;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean cancel() {
        QZLog.i(TAG, getTaskDesc() + ", cancel");
        this.mTaskIsRunning = false;
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
        if (this.isSingleVideo) {
            return this.clientKey;
        }
        return this.clientKey + "_" + this.curNum;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public List<String> getEditMissionId() {
        return QZWinkEditDraftUtil.g(this.mVideoInfo);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return this.isSingleVideo ? 15 : 16;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public long getFakeSize() {
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.mVideoInfo;
        if (shuoshuoVideoInfo == null) {
            return 0L;
        }
        double d16 = shuoshuoVideoInfo.mEstimateSize;
        return d16 > 0.0d ? (long) d16 : shuoshuoVideoInfo.mSize;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public c getInfo() {
        c info = super.getInfo();
        if (info == null) {
            return null;
        }
        info.f51185a = this.uploadToAlbum + "\u300a" + this.sAlbumName + "\u300b";
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
        } else if (getState() == 3 || getState() == 2) {
            if (!isVideoExist()) {
                info.f51186b = this.notExist;
            } else if (this.mResultCode != 0 && !TextUtils.isEmpty(this.f45835msg)) {
                info.f51186b = this.f45835msg;
            }
        }
        info.f51192h = getVideoCoverUrl();
        info.f51193i = true;
        return info;
    }

    public Map<String, String> getLocalUrlMap() {
        return this.localUrlMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getTaskDesc() {
        return "id:" + getTaskId() + ", batchId:" + this.batchId + ", fakeKey:" + getCommentUniKey();
    }

    public String getVideoCoverUrl() {
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.mVideoInfo;
        if (shuoshuoVideoInfo != null) {
            return shuoshuoVideoInfo.mCoverUrl;
        }
        return "";
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isNullTask() {
        return TextUtils.isEmpty(this.sAlbumID) && TextUtils.isEmpty(this.sAlbumName) && this.videoInfo == null && this.albumInfo == null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isVideoExist() {
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.mVideoInfo;
        return (shuoshuoVideoInfo == null || TextUtils.isEmpty(shuoshuoVideoInfo.mVideoPath) || !new File(this.mVideoInfo.mVideoPath).exists()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isVideoNeedProcess() {
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.mVideoInfo;
        if (shuoshuoVideoInfo == null || TextUtils.isEmpty(shuoshuoVideoInfo.mVideoPath)) {
            return false;
        }
        return this.mVideoInfo.mNeedProcess;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isVideoTask() {
        return this.mVideoInfo != null;
    }

    public void notifyTranscodeFeed() {
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.mVideoInfo;
        if (shuoshuoVideoInfo == null) {
            return;
        }
        VideoInfo videoInfo = this.videoInfo;
        videoInfo.isUploading = false;
        videoInfo.isTranscoding = true;
        videoInfo.isFakeFeed = true;
        long j3 = shuoshuoVideoInfo.mDuration;
        videoInfo.videoTime = j3;
        videoInfo.validVideoTime = j3;
        videoInfo.showVideoTime = VideoInfo.getShownTimeFromNumeric(j3);
        VideoInfo videoInfo2 = this.videoInfo;
        videoInfo2.playType = (byte) 1;
        videoInfo2.actionType = 3;
        i.H().O1(getCommentUniKey(), this.videoInfo);
        if (!this.isSingleVideo || this.isQunUplaod) {
            return;
        }
        QZoneWriteOperationService.v0().notify(44, this.clientKey, this.imageInfos, this.videoInfo, this.lbsAddress, Long.valueOf(this.svrTime), this.albumInfo, this.extras);
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
        this.mTaskIsRunning = false;
        if (h.c(this.batchId)) {
            h.a b16 = h.b(this.batchId, false, new HashMap());
            this.localUrlMap = b16.f51146e;
            QZLog.i(TAG, 1, getTaskDesc() + ", upload video onRemove, bacth " + b16.toString());
            if ((b16.f51142a == 0 && b16.f51143b > 0) || b16.f51143b == b16.f51145d) {
                QZLog.i(TAG, 1, getTaskDesc() + ", send upload_finish_rsp rptFinish on task remove");
                this.mStep = 3;
                this.mState = 7;
                this.mSuccessCount = b16.f51143b;
                if (this.isSingleVideo) {
                    this.mType = 27;
                }
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.QZoneUploadAlbumVideoTask.4
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneUploadAlbumVideoTask.this.run();
                    }
                }, 1000L);
            }
            h.g(this.batchId);
        }
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        QZLog.e(TAG, getTaskDesc() + ", onRun -- mStep: " + this.mStep);
        com.qzone.publish.business.model.a aVar = this.mReportInfo;
        if (aVar != null && (aVar.f51012c == 0 || aVar.f51014e < this.retryNum)) {
            com.qzone.publish.business.model.a aVar2 = new com.qzone.publish.business.model.a();
            this.mReportInfo = aVar2;
            aVar2.f51010a = 2;
            aVar2.f51012c = System.currentTimeMillis();
            this.mReportInfo.f51014e = this.retryNum;
        }
        if (this.mState != 5 && !this.mTaskIsRunning) {
            this.mTaskIsRunning = true;
        }
        int i3 = this.mStep;
        if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            int i16 = this.mSuccessCount;
            long j3 = this.batchId;
            String str = this.sAlbumID;
            if (str == null) {
                str = "";
            }
            QzoneUploadPicFinishRequest qzoneUploadPicFinishRequest = new QzoneUploadPicFinishRequest(j3, str, i16, this.mSuccessCount, this.mRetryCount, this.clientKey, i16);
            this.mRequest = qzoneUploadPicFinishRequest;
            qzoneUploadPicFinishRequest.setRefer(this.mRefer);
            this.mRetryCount++;
            QZLog.i(TAG, 1, getTaskDesc() + ",  upload video finish, send upload_finish_req req, mRetryCount: " + this.mRetryCount);
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
            if (!TextUtils.isEmpty(this.mRefer)) {
                uniAttribute.put("refer", this.mRefer);
            }
            com.qzone.publish.ui.model.a buildQZoneMediaUploadParams = buildQZoneMediaUploadParams(buildExtra());
            ArrayList arrayList = new ArrayList();
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.mVideoInfo;
            shuoshuoVideoInfo.mDesc = this.mContent;
            arrayList.add(new MediaWrapper(shuoshuoVideoInfo));
            this.mRequest = new QzoneMediaUploadRequest(arrayList, buildQZoneMediaUploadParams, this, this);
            com.qzone.publish.business.model.a aVar3 = this.mReportInfo;
            if (aVar3 != null) {
                aVar3.f51011b = 5;
            }
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        UploadVideoInfoRsp uploadVideoInfoRsp;
        List<MediaWrapper> arrayList;
        int i3;
        QZLog.i(TAG, 2, getTaskDesc() + ", onTaskResponse mStep: " + this.mStep);
        int i16 = this.mStep;
        boolean z16 = false;
        if (i16 != 2) {
            if (i16 != 3) {
                return;
            }
            if (qZoneTask.succeeded()) {
                upload_finish_rsp upload_finish_rspVar = (upload_finish_rsp) qZoneTask.mRequest.rsp;
                if (upload_finish_rspVar != null && upload_finish_rspVar.retry_timeout > 0) {
                    QZLog.i(TAG, 1, getTaskDesc() + ", upload_finish_rsp rptFinish rsp.retry_timeout:" + upload_finish_rspVar.retry_timeout);
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.QZoneUploadAlbumVideoTask.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QZoneUploadAlbumVideoTask.this.run();
                        }
                    }, (long) (upload_finish_rspVar.retry_timeout * 1000));
                    QzoneVideoUploadActionReport.b().d(this.mVideoInfo.mVideoPath, "start_request_2fakefeed", upload_finish_rspVar.retry_timeout);
                    z16 = true;
                }
                if (z16) {
                    return;
                }
                QZLog.i(TAG, getTaskDesc() + ", send upload_finish_rsp succeed, videoPath:" + this.mVideoInfo.mVideoPath);
                QZoneWriteOperationService.v0().onTaskResponse(qZoneTask);
                finalSuccessOperation();
                return;
            }
            String[] split = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FAKE_FEED_RETRY_TIMEOUT, QzoneConfig.DefaultValue.DEFAULT_FAKE_FEED_RETRY_TIMEOUT).split("/");
            if (split == null || (i3 = this.mRetryCount) > split.length) {
                return;
            }
            int parseInt = Integer.parseInt(split[i3 - 1]);
            QZLog.i(TAG, 1, getTaskDesc() + ", retry send upload_finish_rsp, retryCount:" + this.mRetryCount + ", retryTimeout:" + parseInt);
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.QZoneUploadAlbumVideoTask.2
                @Override // java.lang.Runnable
                public void run() {
                    QZoneUploadAlbumVideoTask.this.run();
                }
            }, (long) (parseInt * 1000));
            return;
        }
        if (qZoneTask.succeeded()) {
            QZLog.i(TAG, getTaskDesc() + ", upload video succeed, videoPath:" + this.mVideoInfo.mVideoPath);
            QzoneVideoUploadActionReport.b().d(this.mVideoInfo.mVideoPath, "end_upload", 0);
            QzoneVideoPerfReport.a(this.mVideoInfo.perfKey, 4);
            getPublishQueue().g((QZoneQueueTask) qZoneTask, qZoneTask.succeeded());
            notifyTranscodeFeed();
            addReportInfo(this.mediaReportInfo);
            if (qZoneTask.mUniAttr == null || qZoneTask.mResultCode == 1000006 || !h.c(this.batchId) || (uploadVideoInfoRsp = (UploadVideoInfoRsp) qZoneTask.mUniAttr.get("response")) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(uploadVideoInfoRsp.sVid, this.localUrlMap.get(this.clientKey));
            h.a b16 = h.b(this.batchId, qZoneTask.succeeded(), hashMap);
            this.localUrlMap = b16.f51146e;
            QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
            String str = uploadVideoInfoRsp.sVid;
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.mVideoInfo;
            v06.h2(str, shuoshuoVideoInfo.mStartTime, shuoshuoVideoInfo.mEndTime);
            QZLog.i(TAG, 1, getTaskDesc() + ", upload video success, vid: " + uploadVideoInfoRsp.sVid + ", uploadInfo:" + b16.toString());
            ShuoshuoVideoInfo shuoshuoVideoInfo2 = this.mVideoInfo;
            if (shuoshuoVideoInfo2.needDeleteLocal && !TextUtils.isEmpty(shuoshuoVideoInfo2.mVideoPath)) {
                new File(this.mVideoInfo.mVideoPath).delete();
            }
            if ((b16.f51142a == 0 && b16.f51143b > 0) || b16.f51143b == b16.f51145d) {
                QZLog.i(TAG, 1, getTaskDesc() + ", all batch media upload finish, " + b16.toString());
                this.mStep = 3;
                this.mSuccessCount = b16.f51143b;
                if (this.isSingleVideo) {
                    this.mType = 27;
                } else if (!this.isQunUplaod) {
                    QZoneWriteOperationService v07 = QZoneWriteOperationService.v0();
                    Object[] objArr = new Object[7];
                    objArr[0] = this.clientKey;
                    b bVar = this.mixUploadTask;
                    if (bVar != null) {
                        arrayList = bVar.a();
                    } else {
                        arrayList = new ArrayList<>();
                    }
                    objArr[1] = arrayList;
                    objArr[2] = this.lbsAddress;
                    objArr[3] = Long.valueOf(this.svrTime);
                    objArr[4] = this.albumInfo;
                    objArr[5] = this.extras;
                    objArr[6] = 2;
                    v07.notify(49, objArr);
                }
                triggerFetchRealFeed();
                return;
            }
            QZLog.i(TAG, 1, getTaskDesc() + ", batch in uploading, " + b16.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(LoginData.getInstance().getUin());
            sb5.append("");
            QzoneVideoPerfReport.a(this.mVideoInfo.perfKey, 4).d(this.mVideoInfo.perfKey, sb5.toString());
            return;
        }
        if (this.mRequest instanceof QzoneMediaUploadRequest) {
            QZLog.e(TAG, getTaskDesc() + ", upload video failed, resultCode:" + this.mResultCode + ", resultMsg:" + this.f45835msg + ",completeTask false, videoPath:" + this.mVideoInfo.mVideoPath);
            QzoneVideoUploadActionReport.b().d(this.mVideoInfo.mVideoPath, "end_upload", this.mResultCode);
            getPublishQueue().g(this, false);
            this.mTaskIsRunning = false;
        }
    }

    public void setMixUploadTaskInfo(b bVar) {
        this.mixUploadTask = bVar;
    }

    public static String getEmptyString(String str) {
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$triggerFetchRealFeed$0(boolean z16) {
        if (z16) {
            finalSuccessOperation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] buildExtra() {
        UploadPicInfoReq uploadPicInfoReq = new UploadPicInfoReq();
        uploadPicInfoReq.sPicTitle = getEmptyString(this.sPicTitle);
        uploadPicInfoReq.sPicDesc = getEmptyString(this.mVideoInfo.mDescription);
        uploadPicInfoReq.sAlbumID = getEmptyString(this.sAlbumID);
        uploadPicInfoReq.sAlbumName = getEmptyString(this.sAlbumName);
        uploadPicInfoReq.iAlbumTypeID = this.iAlbumTypeID;
        uploadPicInfoReq.iBitmap = this.iBitmap;
        uploadPicInfoReq.iUploadType = this.iUploadType;
        uploadPicInfoReq.iUpPicType = this.iUpPicType;
        uploadPicInfoReq.iBatchID = this.batchId;
        uploadPicInfoReq.mutliPicInfo = this.mutliPicInfo;
        uploadPicInfoReq.mapExt = this.mapExt;
        PicExtendInfo picExtendInfo = this.stExtendInfo;
        uploadPicInfoReq.stExtendInfo = picExtendInfo;
        uploadPicInfoReq.stExternalMapExt = this.stExternalMapExt;
        uploadPicInfoReq.sPicPath = this.picPath;
        if (picExtendInfo == null) {
            PicExtendInfo picExtendInfo2 = new PicExtendInfo();
            this.stExtendInfo = picExtendInfo2;
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
            if (this.iUploadType == 3) {
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
        uploadPicInfoReq.sExif_Time = this.exifTime;
        uploadPicInfoReq.iUploadTime = this.uploadTime;
        if (TextUtils.isEmpty(this.sAlbumID)) {
            uploadPicInfoReq.iAlbumTypeID = 1;
        } else {
            uploadPicInfoReq.iAlbumTypeID = 0;
            uploadPicInfoReq.sAlbumID = this.sAlbumID;
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
        if (uploadPicInfoReq.stExtendInfo != null && !TextUtils.isEmpty(this.picPath)) {
            try {
                String str9 = this.picPath;
                BitmapFactory.Options decodeBitmapOptions = ImageProcessUtil.decodeBitmapOptions(str9);
                uploadPicInfoReq.stExtendInfo.mapParams.put("raw_width", Integer.toString(decodeBitmapOptions.outWidth));
                uploadPicInfoReq.stExtendInfo.mapParams.put("raw_height", Integer.toString(decodeBitmapOptions.outHeight));
                uploadPicInfoReq.stExtendInfo.mapParams.put("raw_size", Long.toString(new File(str9).length()));
                String str10 = this.stExtendInfo.mapParams.get("geo_x");
                Map<String, String> map3 = uploadPicInfoReq.stExtendInfo.mapParams;
                if (str10 == null) {
                    str10 = "";
                }
                map3.put("geo_x", str10);
                String str11 = this.stExtendInfo.mapParams.get("geo_y");
                Map<String, String> map4 = uploadPicInfoReq.stExtendInfo.mapParams;
                if (str11 == null) {
                    str11 = "";
                }
                map4.put("geo_y", str11);
                String str12 = this.stExtendInfo.mapParams.get("geo_id");
                Map<String, String> map5 = uploadPicInfoReq.stExtendInfo.mapParams;
                if (str12 == null) {
                    str12 = "";
                }
                map5.put("geo_id", str12);
                String str13 = this.stExtendInfo.mapParams.get("geo_idname");
                Map<String, String> map6 = uploadPicInfoReq.stExtendInfo.mapParams;
                if (str13 == null) {
                    str13 = "";
                }
                map6.put("geo_idname", str13);
                String str14 = this.stExtendInfo.mapParams.get("geo_name");
                Map<String, String> map7 = uploadPicInfoReq.stExtendInfo.mapParams;
                if (str14 != null) {
                    str = str14;
                }
                map7.put("geo_name", str);
                String str15 = this.stExtendInfo.mapParams.get("show_geo");
                uploadPicInfoReq.stExtendInfo.mapParams.put("show_geo", str15 == null ? "0" : str15);
            } catch (Exception e16) {
                QZLog.e(TAG, e16.toString());
            }
        }
        if (!TextUtils.isEmpty(this.mRefer)) {
            hashMap.put("refer", this.mRefer);
        }
        uploadPicInfoReq.mapExt = hashMap;
        uploadPicInfoReq.iDistinctUse = this.iDistinctUse;
        uploadPicInfoReq.uploadPoi = convertPoiInfo(this.mPoiInfo);
        uploadPicInfoReq.waterTemplate = new stWaterTemplate(this.waterTemplateId, this.watermarkPoiName);
        int i3 = this.iBusiNessType;
        uploadPicInfoReq.iBusiNessType = i3;
        if (i3 == 1) {
            byte[] bArr = this.vBusiNessData;
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

    public QZoneUploadAlbumVideoTask(int i3, ShuoshuoVideoInfo shuoshuoVideoInfo, String str, long j3, String str2, LbsDataV2.PoiInfo poiInfo, int i16, int i17, Map<String, String> map) {
        super(i3);
        this.mStep = 2;
        this.mSuccessCount = 0;
        this.mRetryCount = 0;
        this.sPicTitle = "";
        this.sAlbumName = "";
        this.sAlbumID = "";
        this.iAlbumTypeID = 0;
        this.iBitmap = 0;
        this.iUploadType = 0;
        this.iUpPicType = 0;
        this.mutliPicInfo = null;
        this.stExtendInfo = null;
        this.iDistinctUse = 0;
        this.iBusiNessType = 0;
        this.vBusiNessData = null;
        this.stExternalMapExt = null;
        this.mapExt = null;
        this.exifTime = "";
        this.picPath = "";
        this.isQunUplaod = false;
        this.mTaskIsRunning = false;
        this.uploadToAlbum = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadVideoToAlbum", "\u4e0a\u4f20\u89c6\u9891\u5230\u76f8\u518c");
        this.uploadVideo = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadVideo", "\u4e0a\u4f20\u89c6\u9891");
        this.composing = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoVideoComposing ", "\u89c6\u9891\u5408\u6210\u4e2d ");
        this.publishing = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoPublishing", "\u53d1\u8868\u4e2d...");
        this.notExist = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoVideoFileNotExist", "\u89c6\u9891\u6587\u4ef6\u4e0d\u5b58\u5728\uff01");
        this.timeOut = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoProcessVideoTimeOut", "\u89c6\u9891\u5904\u7406\u8d85\u65f6");
        this.mVideoInfo = shuoshuoVideoInfo;
        this.mRefer = str;
        this.clientKey = str2;
        this.mPoiInfo = poiInfo;
        this.uploadTime = j3;
        this.mShootParams = map;
        if (i16 == 1) {
            this.isSingleVideo = true;
        }
        if (shuoshuoVideoInfo != null) {
            this.mOriginalVideoPath = shuoshuoVideoInfo.mVideoPath;
        }
        HashMap hashMap = new HashMap();
        this.localUrlMap = hashMap;
        if (shuoshuoVideoInfo != null) {
            hashMap.put(this.clientKey, shuoshuoVideoInfo.mVideoPath);
        }
        MultiPicInfo multiPicInfo = new MultiPicInfo();
        this.mutliPicInfo = multiPicInfo;
        this.maxNum = i16;
        multiPicInfo.iBatUploadNum = i16;
        this.curNum = i17;
        multiPicInfo.iCurUpload = i17;
        HashMap<String, String> hashMap2 = new HashMap<>();
        this.stExternalMapExt = hashMap2;
        hashMap2.put(FSUploadConst.KEY_MIX_FEED, "1");
        ShuoshuoVideoInfo shuoshuoVideoInfo2 = this.mVideoInfo;
        a.C0436a c0436a = new a.C0436a(2, shuoshuoVideoInfo2 != null ? shuoshuoVideoInfo2.mVideoPath : null);
        this.mediaReportInfo = c0436a;
        ShuoshuoVideoInfo shuoshuoVideoInfo3 = this.mVideoInfo;
        c0436a.f51028c = shuoshuoVideoInfo3 != null ? shuoshuoVideoInfo3.mSize / 1024 : 0L;
    }
}
