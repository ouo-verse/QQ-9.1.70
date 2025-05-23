package com.qzone.video.mediadevice;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bp.b;
import com.qzone.common.account.LoginData;
import com.qzone.publish.business.task.compress.VideoCompressTask;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.video.decode.ShortVideoSoLoad;
import common.config.service.QzoneConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;

/* compiled from: P */
/* loaded from: classes37.dex */
public class TrimVideoThread implements Runnable {
    public static int U;
    private boolean C;
    private String D;
    private String E;
    private int F;
    private int G;
    private boolean J;
    private boolean K;
    private boolean L;

    /* renamed from: d, reason: collision with root package name */
    private Handler f60047d;

    /* renamed from: e, reason: collision with root package name */
    private String f60048e;

    /* renamed from: f, reason: collision with root package name */
    private long f60049f;

    /* renamed from: h, reason: collision with root package name */
    private long f60050h;

    /* renamed from: i, reason: collision with root package name */
    private long f60051i;

    /* renamed from: m, reason: collision with root package name */
    private String f60052m;
    private Handler H = new Handler();
    private String I = "";
    private String M = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoFilePathNull", "\u89c6\u9891\u6587\u4ef6\u8def\u5f84\u4e3a\u7a7a");
    private String N = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoFileNotExist", "\u89c6\u9891\u6587\u4ef6\u4e0d\u5b58\u5728");
    private String P = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoTrimTimeError", "\u88c1\u526a\u65f6\u95f4\u9519\u8bef");
    private String Q = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoReadCacheFail", "\u8bfb\u53d6\u7f13\u5b58\u4f4d\u7f6e\u5931\u8d25");
    private String R = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoTrimSuccess", "\u88c1\u526a\u6210\u529f");
    private String S = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoTrimFail", "\u88c1\u526a\u5931\u8d25, code=");
    private Runnable T = new Runnable() { // from class: com.qzone.video.mediadevice.TrimVideoThread.1
        @Override // java.lang.Runnable
        public void run() {
            if (TrimVideoThread.this.G >= 80) {
                if (TrimVideoThread.this.G >= 90) {
                    if (TrimVideoThread.this.G >= 98) {
                        return;
                    }
                    TrimVideoThread.this.G += 2;
                } else {
                    TrimVideoThread.this.G += 5;
                }
            } else {
                TrimVideoThread.this.G += 10;
            }
            TrimVideoThread trimVideoThread = TrimVideoThread.this;
            trimVideoThread.i(1002, trimVideoThread.G);
            TrimVideoThread.this.H.postDelayed(this, 5000L);
        }
    };

    public TrimVideoThread(Context context, Handler handler, String str, long j3, long j16, long j17, String str2, boolean z16, int i3, boolean z17, boolean z18, boolean z19) {
        this.D = context.getFilesDir().getAbsolutePath();
        this.E = ShortVideoSoLoad.getShortVideoSoPath(context) + VideoEnvironment.getShortVideoSoLibName();
        this.f60047d = handler;
        this.f60048e = str;
        this.f60049f = j3;
        this.f60050h = j16;
        this.f60051i = j17;
        this.F = i3;
        this.f60052m = str2;
        this.C = z16;
        this.J = z17;
        this.K = z18;
        this.L = z19;
        QZLog.d("[upload2][compress]", 1, "videoPath=" + str + ", startTime=" + j3 + ", endTime=" + j16 + ", mFilesDir=" + this.D + ", mSoFullPath=" + this.E + ", retryNum=" + this.F + " isQcircle:", Boolean.valueOf(z19));
    }

    private void e(Message message) {
        Handler handler = this.f60047d;
        if (handler != null) {
            try {
                handler.sendMessage(message);
                return;
            } catch (Exception e16) {
                QZLog.w("TrimVideoThread", "TrimVideo Callback Error", e16);
                return;
            }
        }
        QZLog.e("TrimVideoThread", "TrimVideo Callback is NULL");
    }

    private static String f() {
        return CacheManager.getVideoFileCacheDir();
    }

    public static final boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    private void h(int i3, String str, String str2) {
        Message obtain = Message.obtain();
        obtain.what = i3;
        obtain.getData().putString("target_file", str);
        obtain.getData().putString("report_msg", str2);
        obtain.getData().putString("source_path", this.f60048e);
        obtain.getData().putString("client_key", this.f60052m);
        obtain.getData().putBoolean(VideoCompressTask.KEY_NO_DELETE_FILE, this.J);
        e(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3, int i16) {
        Message obtain = Message.obtain();
        obtain.what = i3;
        obtain.arg1 = i16;
        e(obtain);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f60048e)) {
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "12", null);
            h(1001, "", this.M);
            QZLog.e("[upload2][compress]", this.M);
            return;
        }
        if (!g(this.f60048e)) {
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "13", null);
            h(1001, "", this.N);
            QZLog.e("[upload2][compress]", this.N);
            return;
        }
        if (this.f60049f >= 0 && this.f60050h >= 0 && this.f60051i >= 0) {
            String f16 = f();
            if (TextUtils.isEmpty(f16)) {
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "15", null);
                h(1001, "", this.Q);
                b.d(1000);
                QZLog.e("[upload2][compress]", this.Q);
                return;
            }
            this.G = 0;
            i(1002, 0);
            this.H.postDelayed(this.T, 5000L);
            String str = f16 + "/" + System.currentTimeMillis() + ".mp4";
            this.I = f16 + "/" + System.currentTimeMillis() + "TmpRawVideo.mp4";
            Message obtain = Message.obtain();
            obtain.what = 1005;
            obtain.obj = str;
            this.f60047d.sendMessage(obtain);
            QZLog.d("[upload2][compress]", 1, "Start trim video", " mvideoPath= ", this.f60048e, "  videoPath= ", str, " mTmpVideoPath= mTmpVideoPath");
            int r16 = VideoTrimmer.r(this.D, this.E, this.f60048e, str, this.f60049f, this.f60050h, this.f60051i, this.C, this.F, this.f60047d, this.I, this.f60052m, this.K, this.L);
            this.H.removeCallbacks(this.T);
            if (r16 == 0) {
                h(1000, str, this.R);
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_SUCCESS, "16", String.valueOf(this.C));
                b.d(0);
                QZLog.d("[upload2][compress]", 1, "trim video success", " mvideoPath= ", this.f60048e, "  videoPath= ", str, " mTmpVideoPath= mTmpVideoPath");
                com.qzone.video.service.a.a(0, "trim video success");
                return;
            }
            h(1001, "", this.S + r16);
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_SUCCESS, "17", String.valueOf(this.C));
            b.d(1001);
            QZLog.d("[upload2][compress]", 1, "trim video fail", " mvideoPath= ", this.f60048e, "  videoPath= ", str, " mTmpVideoPath= mTmpVideoPath", " status=", String.valueOf(r16));
            com.qzone.video.service.a.a(r16, "trim video fail" + r16);
            return;
        }
        QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "14", null);
        h(1001, "", this.P);
        QZLog.e("[upload2][compress]", this.P);
    }
}
