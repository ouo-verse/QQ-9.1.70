package com.qzone.publish.business.task;

import FileUpload.UploadVideoInfoRsp;
import FileUpload.stPoi;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.jce.wup.UniPacket;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.publish.business.model.UploadVideoObject;
import com.qzone.publish.business.protocol.QZoneUploadH5VideoRequest;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.publishqueue.h;
import com.qzone.publish.business.task.compress.VideoCompressTask;
import com.qzone.publish.service.RemoteVideoServiceHandler;
import com.qzone.util.image.ImageInfo;
import com.qzone.video.service.QzoneVideoPerfReport;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneUploadH5VideoTask extends QZoneQueueTask {
    public static final int MAX_VIDEO_TASK_RETRY_COUNT_FOR_BUILD_FAILED = 0;
    public static final int MAX_VIDEO_TASK_RETRY_COUNT_FOR_CONNECT_FAILED = 2;
    public static final int MAX_VIDEO_TASK_RETRY_COUNT_FOR_DISCONNECT = 3;
    public static final String REFER_VIDEO_SHUOSHUO = "video_shuoshuo";
    private static final int STEP_FINISH = 3;
    private static final int STEP_UPLOAD_VIDEO = 2;
    private static final String TAG = "QZoneUploadH5VideoTask";
    String composing;

    @NeedParcel
    public Map<String, byte[]> extras;
    private Runnable handleVideoTimeoutRunnable;

    @NeedParcel
    public List<ImageInfo> imageInfos;

    @NeedParcel
    private Map<String, String> localUrlMap;

    @NeedParcel
    private String mRefer;
    private int mRetryCount;

    @NeedParcel
    private int mStep;
    private int mSuccessCount;
    private volatile boolean mVideoHandling;

    @NeedParcel
    private ShuoshuoVideoInfo mVideoInfo;
    public HashMap<String, String> mapExt;
    String notExist;

    @NeedParcel
    public String picPath;

    @NeedParcel
    public String protocalString;
    String publishing;

    @NeedParcel
    public long svrTime;
    String timeOut;

    @NeedParcel
    public int uploadEntrance;

    @NeedParcel
    private long uploadTime;
    String uploadVideo;
    public byte[] vBusiNessData;

    @NeedParcel
    public VideoInfo videoInfo;
    private int videoRetryNum;

    public QZoneUploadH5VideoTask() {
        this.mStep = 2;
        this.picPath = "";
        this.mVideoHandling = false;
        this.handleVideoTimeoutRunnable = new Runnable() { // from class: com.qzone.publish.business.task.QZoneUploadH5VideoTask.2
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneUploadH5VideoTask.this.mVideoHandling) {
                    QZoneUploadH5VideoTask.this.mVideoHandling = false;
                    QZoneUploadH5VideoTask qZoneUploadH5VideoTask = QZoneUploadH5VideoTask.this;
                    qZoneUploadH5VideoTask.f45835msg = qZoneUploadH5VideoTask.timeOut;
                    QZLog.w(QZLog.PUBLISH_QUEUE_TAG, "QZoneUploadH5VideoTask video handle timeout");
                    QZonePublishQueue.w().g(QZoneUploadH5VideoTask.this, false);
                    RemoteVideoServiceHandler.j().i(QZoneUploadH5VideoTask.this.getCommentUniKey());
                }
            }
        };
        this.uploadVideo = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadVideo", "\u4e0a\u4f20\u89c6\u9891");
        this.composing = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoVideoComposing ", "\u89c6\u9891\u5408\u6210\u4e2d ");
        this.publishing = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoPublishing", "\u53d1\u8868\u4e2d...");
        this.notExist = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoVideoFileNotExist", "\u89c6\u9891\u6587\u4ef6\u4e0d\u5b58\u5728\uff01");
        this.timeOut = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoProcessVideoTimeOut", "\u89c6\u9891\u5904\u7406\u8d85\u65f6");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoInfo() {
        if (isVideoTask()) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "QZoneUploadH5VideoTask.handleVideoInfo");
            this.mVideoHandling = true;
            Message obtain = Message.obtain();
            obtain.what = 1001;
            Intent intent = new Intent();
            intent.putExtra("client_key", getCommentUniKey());
            intent.putExtra("video_source_path", this.mVideoInfo.mVideoPath);
            intent.putExtra("video_type", this.mVideoInfo.mVideoType);
            intent.putExtra("start_time", this.mVideoInfo.mStartTime);
            intent.putExtra("end_time", this.mVideoInfo.mEndTime);
            intent.putExtra(VideoCompressTask.KEY_NEED_ORIGIN, this.mVideoInfo.mIsUploadOrigin);
            intent.putExtra(VideoCompressTask.KEY_RETRY_NUM, this.videoRetryNum);
            intent.putExtra(VideoCompressTask.KEY_TOTAL_DURATION, this.mVideoInfo.mTotalDuration);
            intent.putExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS, this.mVideoInfo.mExtras);
            intent.putExtra(ShortVideoConstants.VIDEO_NEW_FAKE_VID, this.mVideoInfo.fakeVid);
            obtain.obj = intent;
            RemoteVideoServiceHandler.j().n(obtain);
            RemoteVideoServiceHandler.j().g(getCommentUniKey());
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getHandler().postDelayed(this.handleVideoTimeoutRunnable, MiniBoxNoticeInfo.MIN_5);
        }
    }

    private boolean isVideoExist() {
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.mVideoInfo;
        if (shuoshuoVideoInfo == null || TextUtils.isEmpty(shuoshuoVideoInfo.mVideoPath)) {
            return false;
        }
        return new File(this.mVideoInfo.mVideoPath).exists();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean cancel() {
        QZoneRequest qZoneRequest = this.mRequest;
        if (qZoneRequest == null || !(qZoneRequest instanceof QZoneUploadH5VideoRequest)) {
            return true;
        }
        return ((QZoneUploadH5VideoRequest) qZoneRequest).cancel();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        return this.clientKey;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return 18;
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
        info.f51185a = this.uploadVideo;
        if (getState() == 1) {
            long j3 = this.mRecvDataSize;
            if (j3 > 0) {
                long j16 = this.mTotalSize;
                if (j16 > 0) {
                    info.f51190f = (int) ((j3 * 100) / j16);
                    info.f51186b = this.uploadVideo + this.mRecvDataSize + "/" + this.mTotalSize + "K";
                }
            }
            if (this.mVideoHandling) {
                info.f51186b = this.composing;
                info.f51191g = true;
            } else {
                info.f51186b = this.publishing;
            }
        } else if (getState() == 3 && !isVideoExist()) {
            info.f51186b = this.notExist;
        }
        info.f51192h = getVideoCoverUrl();
        info.f51193i = true;
        return info;
    }

    public Map<String, String> getLocalUrlMap() {
        return this.localUrlMap;
    }

    public String getVideoCoverUrl() {
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.mVideoInfo;
        if (shuoshuoVideoInfo != null) {
            return shuoshuoVideoInfo.mCoverUrl;
        }
        return "";
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isVideoTask() {
        return this.mVideoInfo != null;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onRemove() {
        super.onRemove();
        if (isVideoTask() && this.mVideoHandling) {
            this.mVideoHandling = false;
            Message obtain = Message.obtain();
            obtain.what = 1006;
            Intent intent = new Intent();
            intent.putExtra("client_key", getCommentUniKey());
            obtain.obj = intent;
            RemoteVideoServiceHandler.j().n(obtain);
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        UploadVideoInfoRsp uploadVideoInfoRsp;
        QZLog.d(TAG, 2, "onTaskResponse mStep: " + this.mStep);
        if (this.mStep == 2 && qZoneTask.succeeded()) {
            QzoneVideoPerfReport.a(this.mVideoInfo.perfKey, 4);
            QZonePublishQueue.w().g((QZoneQueueTask) qZoneTask, qZoneTask.succeeded());
            if (qZoneTask.mUniAttr == null || qZoneTask.mResultCode == 1000006 || !h.c(this.batchId) || (uploadVideoInfoRsp = (UploadVideoInfoRsp) qZoneTask.mUniAttr.get("response")) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(uploadVideoInfoRsp.sVid, this.localUrlMap.get(this.clientKey));
            h.a b16 = h.b(this.batchId, qZoneTask.succeeded(), hashMap);
            this.localUrlMap = b16.f51146e;
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "upload album video uploadInfo:" + b16.toString());
            QZLog.i(TAG, 1, "upload video success, vid: " + uploadVideoInfoRsp.sVid);
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.mVideoInfo;
            if (shuoshuoVideoInfo.needDeleteLocal && !TextUtils.isEmpty(shuoshuoVideoInfo.mVideoPath)) {
                new File(this.mVideoInfo.mVideoPath).delete();
            }
            if ((b16.f51142a == 0 && b16.f51143b > 0) || b16.f51143b == b16.f51145d) {
                QZLog.i(TAG, 1, "send rptFinish");
                this.mStep = 3;
                this.mSuccessCount = b16.f51143b;
                this.mType = 29;
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.QZoneUploadH5VideoTask.3
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneUploadH5VideoTask.this.run();
                    }
                }, 1000L);
                return;
            }
            QzoneVideoPerfReport.a(this.mVideoInfo.perfKey, 4).d(this.mVideoInfo.perfKey, LoginData.getInstance().getUin() + "");
        }
    }

    private stPoi convertPoiInfo(LbsDataV2.PoiInfo poiInfo) {
        if (poiInfo != null) {
            return k5.a.d(poiInfo);
        }
        return null;
    }

    public static String getEmptyString(String str) {
        return str == null ? "" : str;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        int i3 = this.mStep;
        if (i3 != 2) {
            if (i3 == 3) {
                QZLog.i(TAG, 1, "upload_finish_req send --- mRetryCount: " + this.mRetryCount);
            }
        } else {
            if (!isVideoExist()) {
                this.f45835msg = this.notExist;
                QZonePublishQueue.w().g(this, false);
                return;
            }
            if (isVideoTask()) {
                QzoneVideoPerfReport.a(this.mVideoInfo.perfKey, 2);
                this.videoRetryNum = 0;
                if (this.mVideoHandling) {
                    this.mRequest = null;
                } else {
                    ShuoshuoVideoInfo shuoshuoVideoInfo = this.mVideoInfo;
                    if (shuoshuoVideoInfo.mNeedProcess) {
                        this.mRequest = null;
                        handleVideoInfo();
                    } else {
                        shuoshuoVideoInfo.mIsNew = 2000;
                        UploadVideoObject createFromShuoshuoVideoInfo = UploadVideoObject.createFromShuoshuoVideoInfo(shuoshuoVideoInfo, null);
                        UniAttribute uniAttribute = new UniAttribute();
                        uniAttribute.setEncodeName("utf8");
                        uniAttribute.put("hostuin", Long.valueOf(LoginData.getInstance().getUin()));
                        if (!TextUtils.isEmpty(this.mRefer)) {
                            uniAttribute.put("refer", this.mRefer);
                        }
                        QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "video has been compressed by client : " + this.mVideoInfo.mHasCompressed);
                        QZoneUploadH5VideoRequest qZoneUploadH5VideoRequest = new QZoneUploadH5VideoRequest(createFromShuoshuoVideoInfo, this.uploadTime, this.batchId, 1, this.protocalString.getBytes(), "video_shuoshuo", String.valueOf(getState()), this.uploadEntrance);
                        this.mRequest = qZoneUploadH5VideoRequest;
                        qZoneUploadH5VideoRequest.setUploadQueueListener(this);
                        this.mRequest.setRefer(this.mRefer);
                    }
                }
            }
        }
        QZLog.e(TAG, "onRun -- mStep: " + this.mStep);
    }

    public void handleVideoComplete(Intent intent) {
        if (intent == null) {
            return;
        }
        this.mVideoHandling = false;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getHandler().removeCallbacks(this.handleVideoTimeoutRunnable);
        boolean booleanExtra = intent.getBooleanExtra(VideoCompressTask.KEY_HANDLE_RESULT, false);
        QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "QZoneUploadH5VideoTask video receiver handle result:" + booleanExtra);
        if (booleanExtra) {
            this.mVideoInfo.mVideoPath = intent.getStringExtra(VideoCompressTask.KEY_DEST_PATH);
            if (TextUtils.isEmpty(this.mVideoInfo.mVideoPath)) {
                this.f45835msg = "video path is empty!";
                QZonePublishQueue.w().g(this, false);
                return;
            }
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.mVideoInfo;
            shuoshuoVideoInfo.mNeedProcess = false;
            shuoshuoVideoInfo.needDeleteLocal = true;
            this.mVideoInfo.mSize = new File(this.mVideoInfo.mVideoPath).length();
            this.mVideoInfo.mHasCompressed = !r6.mIsUploadOrigin;
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "QZoneUploadH5VideoTask video receiver handle destpath:" + this.mVideoInfo.mVideoPath);
            QZonePublishQueue.w().c(this);
            QZonePublishQueue.w().J();
            if (this.mState != 2) {
                super.run();
            } else {
                QZLog.i(QZLog.PUBLISH_QUEUE_TAG, "pause the task by network switch to mobile traffic!");
            }
            QzoneVideoPerfReport.a(this.mVideoInfo.perfKey, 3);
            return;
        }
        final int intExtra = intent.getIntExtra("video_error_code", 0);
        final String stringExtra = intent.getStringExtra(VideoCompressTask.KEY_ERR_FILE_NAME);
        this.f45835msg = intent.getStringExtra(VideoCompressTask.KEY_ERR_MSG);
        this.videoRetryNum++;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.business.task.QZoneUploadH5VideoTask.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!TextUtils.isEmpty(stringExtra)) {
                        File file = new File(stringExtra);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                } catch (Exception e16) {
                    QZLog.w(e16);
                }
                int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TASK_RETRY_FOR_DISCONNECT, 3);
                int config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TASK_RETRY_FOR_CONNECT_FAILED, 2);
                int config3 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TASK_RETRY_FOR_CONNECT_FAILED, 0);
                if (QZLog.isColorLevel()) {
                    QZLog.d(QZLog.PUBLISH_QUEUE_TAG, 2, "QZoneUploadH5VideoTask error code=" + intExtra + ", retryNum=" + QZoneUploadH5VideoTask.this.videoRetryNum + ", retry4Dis=" + config + ", retry4Conn=" + config2 + ", retry4build=" + config3);
                }
                if (1 == intExtra && QZoneUploadH5VideoTask.this.videoRetryNum <= config) {
                    if (QZLog.isColorLevel()) {
                        QZLog.d(QZLog.PUBLISH_QUEUE_TAG, 2, "QZoneUploadH5VideoTask retry for VIDEO_SERVICE_DISCONNECT");
                    }
                    QZoneUploadH5VideoTask.this.handleVideoInfo();
                    QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_RETRY_RES, "23", QZoneUploadH5VideoTask.this.videoRetryNum + "");
                    bp.b.d(1016);
                    return;
                }
                if (2 != intExtra || QZoneUploadH5VideoTask.this.videoRetryNum > config2) {
                    if (QZoneUploadH5VideoTask.this.videoRetryNum <= config3) {
                        if (QZLog.isColorLevel()) {
                            QZLog.d(QZLog.PUBLISH_QUEUE_TAG, 2, "QZoneUploadH5VideoTask retry for VIDEO_SERVICE_ERROR_UNKNOWN");
                        }
                        QZoneUploadH5VideoTask.this.handleVideoInfo();
                        return;
                    }
                    int config4 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TIME_NO_TRIM_THRESHOLD, 1000);
                    int config5 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_PUBLISH_ON_ERROR_SIZE, 20971520);
                    if (QZLog.isColorLevel()) {
                        QZLog.d(QZLog.PUBLISH_QUEUE_TAG, 2, "QZoneUploadH5VideoTask, error no retry, duration=" + QZoneUploadH5VideoTask.this.mVideoInfo.mDuration + ", totalDuration=" + QZoneUploadH5VideoTask.this.mVideoInfo.mTotalDuration + "timeThreshold=" + config4 + ", sizeThreshold=" + config5);
                    }
                    if (Math.abs(QZoneUploadH5VideoTask.this.mVideoInfo.mDuration - QZoneUploadH5VideoTask.this.mVideoInfo.mTotalDuration) < config4 && (NetworkState.isWifiConn() || QZoneUploadH5VideoTask.this.mVideoInfo.mSize < config5)) {
                        QZoneUploadH5VideoTask.this.mVideoInfo.mNeedProcess = false;
                        QZoneUploadH5VideoTask.super.run();
                        QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_RETRY_RES, "25", QZoneUploadH5VideoTask.this.videoRetryNum + "");
                        bp.b.d(1);
                        return;
                    }
                    QZonePublishQueue.w().g(QZoneUploadH5VideoTask.this, false);
                    return;
                }
                if (QZLog.isColorLevel()) {
                    QZLog.d(QZLog.PUBLISH_QUEUE_TAG, 2, "QZoneUploadH5VideoTask retry for VIDEO_SERVICE_CONNECT_FAILED");
                }
                QZoneUploadH5VideoTask.this.handleVideoInfo();
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_RETRY_RES, "24", QZoneUploadH5VideoTask.this.videoRetryNum + "");
                bp.b.d(1017);
            }
        });
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

    public QZoneUploadH5VideoTask(int i3, ShuoshuoVideoInfo shuoshuoVideoInfo, String str, long j3, String str2, String str3) {
        super(i3);
        this.mStep = 2;
        this.picPath = "";
        this.mVideoHandling = false;
        this.handleVideoTimeoutRunnable = new Runnable() { // from class: com.qzone.publish.business.task.QZoneUploadH5VideoTask.2
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneUploadH5VideoTask.this.mVideoHandling) {
                    QZoneUploadH5VideoTask.this.mVideoHandling = false;
                    QZoneUploadH5VideoTask qZoneUploadH5VideoTask = QZoneUploadH5VideoTask.this;
                    qZoneUploadH5VideoTask.f45835msg = qZoneUploadH5VideoTask.timeOut;
                    QZLog.w(QZLog.PUBLISH_QUEUE_TAG, "QZoneUploadH5VideoTask video handle timeout");
                    QZonePublishQueue.w().g(QZoneUploadH5VideoTask.this, false);
                    RemoteVideoServiceHandler.j().i(QZoneUploadH5VideoTask.this.getCommentUniKey());
                }
            }
        };
        this.uploadVideo = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadVideo", "\u4e0a\u4f20\u89c6\u9891");
        this.composing = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoVideoComposing ", "\u89c6\u9891\u5408\u6210\u4e2d ");
        this.publishing = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoPublishing", "\u53d1\u8868\u4e2d...");
        this.notExist = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoVideoFileNotExist", "\u89c6\u9891\u6587\u4ef6\u4e0d\u5b58\u5728\uff01");
        this.timeOut = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoProcessVideoTimeOut", "\u89c6\u9891\u5904\u7406\u8d85\u65f6");
        this.mVideoInfo = shuoshuoVideoInfo;
        this.mRefer = str;
        this.clientKey = str2;
        this.uploadTime = j3;
        this.protocalString = str3;
        HashMap hashMap = new HashMap();
        this.localUrlMap = hashMap;
        hashMap.put(this.clientKey, shuoshuoVideoInfo.mVideoPath);
    }
}
