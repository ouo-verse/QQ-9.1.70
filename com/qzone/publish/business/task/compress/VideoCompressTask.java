package com.qzone.publish.business.task.compress;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.qzone.publish.service.RemoteVideoServiceHandler;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VideoCompressTask extends QZoneQueueTask {
    public static final String KEY_CLIENT_KEY = "client_key";
    public static final String KEY_DEST_PATH = "video_dest_path";
    public static final String KEY_END_TIME = "end_time";
    public static final String KEY_ERR_CODE = "video_error_code";
    public static final String KEY_ERR_FILE_NAME = "video_error_file_name";
    public static final String KEY_ERR_MSG = "video_error_msg";
    public static final String KEY_HANDLE_RESULT = "video_handle_result";
    public static final String KEY_NEED_ORIGIN = "need_origin";
    public static final String KEY_NO_DELETE_FILE = "noDeleteFile";
    public static final String KEY_RETRY_NUM = "retry_num";
    public static final String KEY_SOURCE_PATH = "video_source_path";
    public static final String KEY_START_TIME = "start_time";
    public static final String KEY_TOTAL_DURATION = "video_total_duration";
    public static final String KEY_VIDEO_TYPE = "video_type";
    private static final String TAG = "[upload2_VideoCompressTask]";
    public static final int VIDEO_COMPRESS_RESULT_FILE_NOT_EXIST = 100082;
    public static final int VIDEO_COMPRESS_RESULT_FILE_NOT_VAILD = 100083;
    public static final int VIDEO_COMPRESS_TIMEOUT = 100081;
    private String clientKey;
    Runnable handleCompressProgressRunnable;
    HandleVideoTimeoutRunnable handleVideoTimeoutRunnable;
    private boolean isCanceled;
    private boolean isFromAIO;
    private boolean isOriginalVideo;
    boolean isVideoToGif;
    public boolean keepSourceFile;
    a listener;
    private int mVideoCompressProgress;
    private long mVideoCompressTimeout;
    private long mVideoCompressUpdateInterval;
    volatile boolean mVideoHandling;
    public String mVideoSourcePath;
    String timeOut;
    public ShuoshuoVideoInfo videoInfo;
    int videoRetryNum;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class HandleVideoTimeoutRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public String f51205d;

        HandleVideoTimeoutRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoCompressTask.this.mVideoHandling) {
                if (TextUtils.isEmpty(this.f51205d) || this.f51205d.equals(VideoCompressTask.this.getCommentUniKey())) {
                    VideoCompressTask.this.mVideoHandling = false;
                    VideoCompressTask.this.videoRetryNum++;
                    RemoteVideoServiceHandler.j().i(VideoCompressTask.this.getCommentUniKey());
                    QZLog.w(QZLog.PUBLISH_QUEUE_TAG, "VideoCompressTask video handle timeout");
                    int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TASK_RETRY_FOR_TIMEOUT, 1);
                    VideoCompressTask videoCompressTask = VideoCompressTask.this;
                    if (videoCompressTask.videoRetryNum <= config) {
                        if (QZLog.isColorLevel()) {
                            QZLog.d(QZLog.PUBLISH_QUEUE_TAG, 2, "VideoCompressTask retry for TIME_OUT, maxRetryNum:" + VideoCompressEngine.e().f51201f + ", currentTryNum:" + VideoCompressTask.this.videoRetryNum);
                        }
                        VideoCompressEngine.e().c(VideoCompressTask.this);
                        return;
                    }
                    videoCompressTask.f45835msg = videoCompressTask.timeOut;
                    videoCompressTask.listener.onCompressFailed(videoCompressTask, VideoCompressTask.VIDEO_COMPRESS_TIMEOUT);
                    VideoCompressEngine.e().f51198c = null;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        void onCompressFailed(VideoCompressTask videoCompressTask, int i3);

        void onCompressProgressUpdate(VideoCompressTask videoCompressTask, double d16);

        void onCompressStart(VideoCompressTask videoCompressTask);

        void onCompressSuccess(VideoCompressTask videoCompressTask, Intent intent);
    }

    public VideoCompressTask(ShuoshuoVideoInfo shuoshuoVideoInfo, String str, a aVar) {
        this(shuoshuoVideoInfo, str, aVar, false);
    }

    public void abort() {
        QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "VideoCompressTask.abort mVideoHandling:" + this.mVideoHandling);
        if (this.mVideoHandling) {
            this.mVideoHandling = false;
            Message obtain = Message.obtain();
            obtain.what = 1006;
            Intent intent = new Intent();
            intent.putExtra("client_key", getCommentUniKey());
            obtain.obj = intent;
            RemoteVideoServiceHandler.j().n(obtain);
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getHandler().removeCallbacks(this.handleVideoTimeoutRunnable);
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getHandler().removeCallbacks(this.handleCompressProgressRunnable);
            this.mListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addRecordVideoToMediaLibrary() {
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.videoInfo;
        if (shuoshuoVideoInfo.mVideoType != 0 || TextUtils.isEmpty(shuoshuoVideoInfo.mVideoPath)) {
            return;
        }
        File file = new File(this.videoInfo.mVideoPath);
        if (file.exists()) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, "add to media library, savedFilePath=" + this.videoInfo.mVideoPath);
            BaseApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asyncCompressVideo() {
        QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "VideoCompressTask.asyncCompressVideo, video path:" + this.videoInfo.mVideoPath);
        this.mVideoHandling = true;
        Message obtain = Message.obtain();
        obtain.what = 1001;
        Intent intent = new Intent();
        intent.putExtra("client_key", this.clientKey);
        intent.putExtra("video_source_path", this.videoInfo.mVideoPath);
        intent.putExtra("video_type", this.videoInfo.mVideoType);
        intent.putExtra("start_time", this.videoInfo.mStartTime);
        intent.putExtra("end_time", this.videoInfo.mEndTime);
        intent.putExtra(KEY_NEED_ORIGIN, this.videoInfo.mIsUploadOrigin);
        intent.putExtra(KEY_RETRY_NUM, this.videoRetryNum);
        intent.putExtra(KEY_TOTAL_DURATION, this.videoInfo.mTotalDuration);
        if (this.keepSourceFile) {
            intent.putExtra(KEY_NO_DELETE_FILE, true);
        }
        intent.putExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS, this.videoInfo.mExtras);
        intent.putExtra(ShortVideoConstants.VIDEO_NEW_FAKE_VID, this.videoInfo.fakeVid);
        intent.putExtra(ShortVideoConstants.VIDEO_IS_GENERATE_GIF, this.isVideoToGif);
        Bundle bundle = this.videoInfo.mExtras;
        intent.putExtra(ShortVideoConstants.VIDEO_IS_SYNC_TO_WEISHI, bundle == null ? false : bundle.getBoolean(ShortVideoConstants.VIDEO_IS_SYNC_TO_WEISHI, false));
        Bundle bundle2 = this.videoInfo.mExtras;
        intent.putExtra(ShortVideoConstants.VIDEO_IS_USE_QCIRCLE_RATE, bundle2 == null ? false : bundle2.getBoolean(ShortVideoConstants.VIDEO_IS_USE_QCIRCLE_RATE, false));
        intent.putExtra(RemoteHandleConst.PARAM_FROM_AIO, this.isFromAIO);
        intent.putExtra(RemoteHandleConst.VIDEO_PARAM_ISUPLOADORIGIN, this.isOriginalVideo);
        obtain.obj = intent;
        RemoteVideoServiceHandler.j().n(obtain);
        RemoteVideoServiceHandler.j().g(getCommentUniKey());
        getVideoTimeOutTime();
        this.handleVideoTimeoutRunnable.f51205d = getCommentUniKey();
        this.mVideoCompressProgress = 0;
        this.mVideoSourcePath = this.videoInfo.mVideoPath;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean cancel() {
        abort();
        this.isCanceled = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void execute() {
        asyncCompressVideo();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        return this.clientKey;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return 20;
    }

    public double getProgress() {
        long j3 = this.mVideoCompressTimeout;
        if (j3 == 0) {
            return 0.0d;
        }
        return (this.mVideoCompressProgress * 20000.0d) / j3;
    }

    public ShuoshuoVideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    public boolean isCanceled() {
        return this.isCanceled;
    }

    public boolean isVideoHandling() {
        return this.mVideoHandling;
    }

    public void onStartCompress() {
        QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "VideoCompressTask::compress video start, path=" + this.videoInfo.mVideoPath + ", start timeout & progress runnable, timeout:" + this.mVideoCompressTimeout);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getHandler().postDelayed(this.handleVideoTimeoutRunnable, this.mVideoCompressTimeout);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getHandler().postDelayed(this.handleCompressProgressRunnable, this.mVideoCompressUpdateInterval);
        a aVar = this.listener;
        if (aVar != null) {
            aVar.onCompressStart(this);
        }
    }

    public void setFromAIO(boolean z16) {
        this.isFromAIO = z16;
    }

    public void setIsVideoToGif(boolean z16) {
        this.isVideoToGif = z16;
    }

    public void setOriginalVideo(boolean z16) {
        this.isOriginalVideo = z16;
    }

    public VideoCompressTask(ShuoshuoVideoInfo shuoshuoVideoInfo, String str, a aVar, boolean z16) {
        this.mVideoHandling = false;
        this.isVideoToGif = false;
        this.handleCompressProgressRunnable = new Runnable() { // from class: com.qzone.publish.business.task.compress.VideoCompressTask.1
            @Override // java.lang.Runnable
            public void run() {
                if (VideoCompressTask.this.mVideoHandling) {
                    VideoCompressTask.this.mVideoCompressProgress++;
                    Handler handler = QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getHandler();
                    VideoCompressTask videoCompressTask = VideoCompressTask.this;
                    handler.postDelayed(videoCompressTask.handleCompressProgressRunnable, videoCompressTask.mVideoCompressUpdateInterval);
                    VideoCompressTask videoCompressTask2 = VideoCompressTask.this;
                    videoCompressTask2.listener.onCompressProgressUpdate(videoCompressTask2, videoCompressTask2.getProgress());
                }
            }
        };
        this.handleVideoTimeoutRunnable = new HandleVideoTimeoutRunnable();
        this.timeOut = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoProcessVideoTimeOut", "\u89c6\u9891\u5904\u7406\u8d85\u65f6");
        this.videoInfo = shuoshuoVideoInfo;
        this.clientKey = str + System.currentTimeMillis();
        this.listener = aVar;
        this.keepSourceFile = z16;
    }

    private void getVideoTimeOutTime() {
        long j3;
        long config;
        int config2;
        if (this.videoInfo.mVideoType == 0) {
            config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_COMPRESS_TIMEOUT_RECORD, 300000);
        } else if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TRIM_ENABLE_HW, 1) == 1) {
            config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_COMPRESS_TIMEOUT_TRIM, 300000);
        } else {
            long length = new File(this.videoInfo.mVideoPath).length();
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.videoInfo;
            long j16 = shuoshuoVideoInfo.mTotalDuration;
            if (j16 == 0) {
                j3 = 0;
            } else {
                long j17 = ((shuoshuoVideoInfo.mEndTime - shuoshuoVideoInfo.mStartTime) * length) / j16;
                long j18 = LocalMultiProcConfig.getLong(LocalMultiProcConfig.Constants.KEY_VIDEO_COMPRESS_SPEED, -1L);
                if (j18 <= 0) {
                    j18 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_COMPRESS_SW_TRIM_AVERAGE_SPEED, 75);
                }
                j3 = (j17 / j18) * 3;
                QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "compress video, path=" + this.videoInfo.mVideoPath + ",inputFileSize=" + length + ", trimmedFileSize=" + j17 + ", estimate timeout=" + j3);
            }
            config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_COMPRESS_TIMEOUT_TRIM, 300000);
            if (j3 >= config) {
                config = j3;
            }
            this.mVideoCompressUpdateInterval = 1000L;
            this.mVideoCompressTimeout = config;
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "compress video, path=" + this.videoInfo.mVideoPath + " estimate timeout=" + config);
        }
        config = config2;
        this.mVideoCompressUpdateInterval = 1000L;
        this.mVideoCompressTimeout = config;
        QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "compress video, path=" + this.videoInfo.mVideoPath + " estimate timeout=" + config);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
    }
}
