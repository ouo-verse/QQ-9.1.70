package com.qzone.publish.business.task.compress;

import android.content.Intent;
import android.text.TextUtils;
import bp.b;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.service.RemoteVideoServiceHandler;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VideoCompressEngine {

    /* renamed from: g, reason: collision with root package name */
    private static VideoCompressEngine f51195g;

    /* renamed from: c, reason: collision with root package name */
    VideoCompressTask f51198c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f51196a = true;

    /* renamed from: b, reason: collision with root package name */
    private LinkedHashMap<String, VideoCompressTask> f51197b = new LinkedHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    int f51199d = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TASK_RETRY_FOR_DISCONNECT, 3);

    /* renamed from: e, reason: collision with root package name */
    int f51200e = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TASK_RETRY_FOR_CONNECT_FAILED, 2);

    /* renamed from: f, reason: collision with root package name */
    int f51201f = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TASK_RETRY_FOR_BUILD_FAILED, 0);

    public VideoCompressEngine() {
        if (QZLog.isColorLevel()) {
            QZLog.d("[upload2_VideoCompressEngine]", 2, "retry4Dis=" + this.f51199d + ", retry4Conn=" + this.f51200e + ", retry4build=" + this.f51201f);
        }
    }

    public static VideoCompressEngine e() {
        if (f51195g == null) {
            synchronized (VideoCompressEngine.class) {
                if (f51195g == null) {
                    f51195g = new VideoCompressEngine();
                }
            }
        }
        return f51195g;
    }

    public synchronized boolean a(VideoCompressTask videoCompressTask) {
        if (videoCompressTask != null) {
            if (!TextUtils.isEmpty(videoCompressTask.getCommentUniKey())) {
                this.f51197b.put(videoCompressTask.getCommentUniKey(), videoCompressTask);
                return true;
            }
        }
        return false;
    }

    public synchronized void b(VideoCompressTask videoCompressTask) {
        this.f51197b.remove(videoCompressTask.getCommentUniKey());
        VideoCompressTask videoCompressTask2 = this.f51198c;
        if (videoCompressTask2 != null && videoCompressTask2.getCommentUniKey().equals(videoCompressTask.getCommentUniKey())) {
            this.f51198c = null;
        }
    }

    public synchronized void c(VideoCompressTask videoCompressTask) {
        if (videoCompressTask == null) {
            return;
        }
        if (!this.f51197b.containsKey(videoCompressTask.getCommentUniKey())) {
            a(videoCompressTask);
        }
        videoCompressTask.execute();
    }

    public synchronized VideoCompressTask d() {
        if (this.f51197b.size() == 0) {
            return null;
        }
        VideoCompressTask videoCompressTask = this.f51198c;
        if (videoCompressTask != null) {
            return videoCompressTask;
        }
        return this.f51197b.entrySet().iterator().next().getValue();
    }

    public VideoCompressTask f(String str) {
        VideoCompressTask videoCompressTask = this.f51197b.get(str);
        if (videoCompressTask == null) {
            return null;
        }
        return videoCompressTask;
    }

    public synchronized void g(String str) {
        VideoCompressTask f16 = f(str);
        if (f16 == null) {
            QZLog.i("[upload2_VideoCompressEngine]", 1, "handleCompressStart, getTaskByCacheKey null");
        } else {
            this.f51198c = f16;
            f16.onStartCompress();
        }
    }

    public synchronized void h(String str, Intent intent) {
        final VideoCompressTask f16 = f(str);
        if (f16 == null) {
            return;
        }
        if (intent == null) {
            return;
        }
        f16.mVideoHandling = false;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getHandler().removeCallbacks(f16.handleVideoTimeoutRunnable);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getHandler().removeCallbacks(f16.handleCompressProgressRunnable);
        boolean booleanExtra = intent.getBooleanExtra(VideoCompressTask.KEY_HANDLE_RESULT, false);
        QZLog.i("[upload2_VideoCompressEngine]", 1, "VideoCompressTask video receiver handle result:" + booleanExtra);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(VideoCompressTask.KEY_DEST_PATH);
            if (TextUtils.isEmpty(stringExtra)) {
                f16.f45835msg = "video path is empty!";
                f16.listener.onCompressFailed(f16, VideoCompressTask.VIDEO_COMPRESS_RESULT_FILE_NOT_EXIST);
                return;
            }
            File file = new File(stringExtra);
            if (file.exists() && file.length() != 0) {
                f16.videoInfo.mVideoPath = stringExtra;
                if (!f16.isVideoToGif) {
                    f16.addRecordVideoToMediaLibrary();
                    ShuoshuoVideoInfo shuoshuoVideoInfo = f16.videoInfo;
                    shuoshuoVideoInfo.mNeedProcess = false;
                    shuoshuoVideoInfo.needDeleteLocal = true;
                    shuoshuoVideoInfo.mSize = file.length();
                    ShuoshuoVideoInfo shuoshuoVideoInfo2 = f16.videoInfo;
                    shuoshuoVideoInfo2.mHasCompressed = shuoshuoVideoInfo2.mIsUploadOrigin ? false : true;
                    QZLog.i("[upload2_VideoCompressEngine]", 1, "VideoCompressTask video receiver handle destpath:" + f16.videoInfo.mVideoPath);
                }
                b(f16);
                RemoteVideoServiceHandler.j().i(f16.getCommentUniKey());
                f16.listener.onCompressSuccess(f16, intent);
                this.f51198c = null;
            }
            f16.f45835msg = "video file is not valid";
            f16.listener.onCompressFailed(f16, VideoCompressTask.VIDEO_COMPRESS_RESULT_FILE_NOT_VAILD);
            return;
        }
        final int intExtra = intent.getIntExtra("video_error_code", 0);
        final String stringExtra2 = intent.getStringExtra(VideoCompressTask.KEY_ERR_FILE_NAME);
        String stringExtra3 = intent.getStringExtra(VideoCompressTask.KEY_ERR_MSG);
        QZLog.w("[upload2_VideoCompressEngine]", "handleVideoComplete compress error errCode:" + intExtra + ", errMsg:" + stringExtra3 + ", failedFile:" + stringExtra2);
        f16.f45835msg = stringExtra3;
        f16.videoRetryNum = f16.videoRetryNum + 1;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.business.task.compress.VideoCompressEngine.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        File file2 = new File(stringExtra2);
                        if (file2.exists()) {
                            file2.delete();
                        }
                    }
                } catch (Exception e16) {
                    QZLog.w(e16);
                }
                if (QZLog.isColorLevel()) {
                    QZLog.d("[upload2_VideoCompressEngine]", 2, "VideoCompressTask error code=" + intExtra + ", retryNum=" + f16.videoRetryNum + ", retry4Dis=" + VideoCompressEngine.this.f51199d + ", retry4Conn=" + VideoCompressEngine.this.f51200e + ", retry4build=" + VideoCompressEngine.this.f51201f);
                }
                int i3 = intExtra;
                if (1 == i3 && f16.videoRetryNum <= VideoCompressEngine.this.f51199d) {
                    if (QZLog.isColorLevel()) {
                        QZLog.d("[upload2_VideoCompressEngine]", 2, "VideoCompressTask retry for VIDEO_SERVICE_DISCONNECT");
                    }
                    f16.asyncCompressVideo();
                    QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_RETRY_RES, "23", f16.videoRetryNum + "");
                    b.d(1016);
                    return;
                }
                if (2 == i3 && f16.videoRetryNum <= VideoCompressEngine.this.f51200e) {
                    if (QZLog.isColorLevel()) {
                        QZLog.d("[upload2_VideoCompressEngine]", 2, "VideoCompressTask retry for VIDEO_SERVICE_CONNECT_FAILED");
                    }
                    f16.asyncCompressVideo();
                    QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_RETRY_RES, "24", f16.videoRetryNum + "");
                    b.d(1017);
                    return;
                }
                if (f16.videoRetryNum <= VideoCompressEngine.this.f51201f) {
                    if (QZLog.isColorLevel()) {
                        QZLog.d("[upload2_VideoCompressEngine]", 2, "VideoCompressTask retry for VIDEO_SERVICE_ERROR_UNKNOWN");
                    }
                    f16.asyncCompressVideo();
                    return;
                }
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_RETRY_RES, "25", f16.videoRetryNum + "");
                VideoCompressEngine.this.b(f16);
                RemoteVideoServiceHandler.j().i(f16.getCommentUniKey());
                VideoCompressTask videoCompressTask = f16;
                videoCompressTask.listener.onCompressFailed(videoCompressTask, VideoCompressTask.VIDEO_COMPRESS_TIMEOUT);
                VideoCompressEngine.this.f51198c = null;
            }
        });
    }
}
