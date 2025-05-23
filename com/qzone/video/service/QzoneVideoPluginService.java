package com.qzone.video.service;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.qzone.publish.business.task.compress.VideoCompressTask;
import com.qzone.video.mediadevice.TrimVideoThread;
import com.qzone.video.mediadevice.VideoTrimmer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.maxvideo.MaxVideoConst;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.a;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.editor.composite.step.HwVideoMerge;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.mediadevice.GifProcessor;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.cache.QZoneFilePath;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppService;

/* loaded from: classes37.dex */
public class QzoneVideoPluginService extends AppService {
    private static volatile boolean C = false;
    private static String E = null;
    private static boolean F = false;

    /* renamed from: d, reason: collision with root package name */
    private static long f60101d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static long f60102e = 0;

    /* renamed from: f, reason: collision with root package name */
    private static volatile int f60103f = 0;

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f60104h = false;

    /* renamed from: i, reason: collision with root package name */
    private static Messenger f60105i = null;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f60106m = false;
    private static List<Message> D = new ArrayList();
    private static String G = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoGifComposeFail", "gif\u5408\u6210\u5931\u8d25");
    private static String H = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoComposeSuccess", "\u5408\u6210\u89c6\u9891\u6210\u529f");
    private static String I = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoComposeFail", "\u5408\u6210\u89c6\u9891\u5931\u8d25!");
    private static String J = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoTrimFailMessage", "\u88c1\u526a\u9519\u8bef:");
    private static String K = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "VideoTrimSuccessMessage", "\u88c1\u526a\u89c6\u9891\u6210\u529f");
    private static final VideoCompositeHelper L = new VideoCompositeHelper();
    private static Handler M = new a();
    private static CPUMonitorRunnable N = new CPUMonitorRunnable();
    private static Handler P = new d();
    private static Messenger Q = new Messenger(M);

    /* loaded from: classes37.dex */
    public static class CPUMonitorRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            int i3;
            int T = QzoneVideoPluginService.T();
            int threadId = QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.VideoThread).getHandlerThread().getThreadId();
            int threadPriority = Process.getThreadPriority(threadId);
            if (T > 80) {
                if (threadPriority < 10) {
                    Process.setThreadPriority(threadId, 10);
                }
            } else if (!QzoneVideoPluginService.f60104h && threadPriority > (i3 = TrimVideoThread.U)) {
                Process.setThreadPriority(threadId, i3);
            }
            int threadPriority2 = Process.getThreadPriority(threadId);
            if (QZLog.isColorLevel()) {
                QZLog.d("QzoneVideoPluginService", 2, "cpu usage=" + T + ", priority=" + threadPriority2);
            }
            if (QzoneVideoPluginService.U()) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(this, 5000L);
            }
            QzoneVideoPluginService.f60103f = T;
        }
    }

    /* loaded from: classes37.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            QZLog.i("[upload2][compress]", 1, "handleMessage, what=" + message.what);
            int i3 = message.what;
            if (i3 != 1006) {
                switch (i3) {
                    case 1000:
                        Messenger messenger = message.replyTo;
                        if (messenger != null) {
                            QzoneVideoPluginService.f60105i = messenger;
                            return;
                        } else {
                            QZLog.e("QzoneVideoPluginService", "no client is wrong");
                            return;
                        }
                    case 1001:
                        Object obj = message.obj;
                        if (obj != null && (obj instanceof Intent)) {
                            if (!QzoneVideoPluginService.C) {
                                QzoneVideoPluginService.C = true;
                                QzoneVideoPluginService.O(message);
                                return;
                            } else {
                                QZLog.i("[upload2][compress]", 1, "other video is processing, add to queue.");
                                Message message2 = new Message();
                                message2.obj = message.obj;
                                QzoneVideoPluginService.D.add(message2);
                                return;
                            }
                        }
                        QZLog.e("[upload2][compress]", "msg.obj is wrong");
                        return;
                    case 1002:
                        QzoneVideoPluginService.f60104h = false;
                        int threadId = QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.VideoThread).getHandlerThread().getThreadId();
                        int threadPriority = Process.getThreadPriority(threadId);
                        if (threadPriority > TrimVideoThread.U) {
                            if (QzoneVideoPluginService.f60103f <= 80) {
                                Process.setThreadPriority(threadId, TrimVideoThread.U);
                            } else if (threadPriority > 10) {
                                Process.setThreadPriority(threadId, 10);
                            }
                        }
                        int threadPriority2 = Process.getThreadPriority(threadId);
                        if (QZLog.isColorLevel()) {
                            QZLog.d("QzoneVideoPluginService", 2, "SPEED UP, tid=" + threadId + ", priority=" + threadPriority2 + ", TRIM_THREAD_PRORITY=" + TrimVideoThread.U);
                            return;
                        }
                        return;
                    case 1003:
                        QzoneVideoPluginService.f60104h = true;
                        int threadId2 = QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.VideoThread).getHandlerThread().getThreadId();
                        if (Process.getThreadPriority(threadId2) != 19) {
                            Process.setThreadPriority(threadId2, 19);
                        }
                        int threadPriority3 = Process.getThreadPriority(threadId2);
                        if (QZLog.isColorLevel()) {
                            QZLog.d("QzoneVideoPluginService", 2, "SPEED DOWN, tid=" + threadId2 + ", priority=" + threadPriority3 + ", TRIM_THREAD_PRORITY=" + TrimVideoThread.U);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            String stringExtra = ((Intent) message.obj).getStringExtra("client_key");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            Iterator it = QzoneVideoPluginService.D.iterator();
            while (it.hasNext()) {
                if (stringExtra.equals(((Intent) ((Message) it.next()).obj).getStringExtra("client_key"))) {
                    it.remove();
                }
            }
            if (stringExtra.equals(QzoneVideoPluginService.E)) {
                VideoTrimmer.k(stringExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements com.tencent.mobileqq.shortvideo.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f60109a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f60110b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ PublishVideoEntry f60111c;

        b(String str, boolean z16, PublishVideoEntry publishVideoEntry) {
            this.f60109a = str;
            this.f60110b = z16;
            this.f60111c = publishVideoEntry;
        }

        @Override // com.tencent.mobileqq.shortvideo.g
        public void a(String str, byte[] bArr, String str2, int i3, int i16, byte[] bArr2, int i17) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.arg1 = 0;
            obtain.getData().putString(MaxVideoConst.TAG_FILE_MP4, str);
            obtain.getData().putString("source_path", this.f60109a);
            obtain.getData().putString("client_key", QzoneVideoPluginService.E);
            obtain.getData().putBoolean(VideoCompressTask.KEY_NO_DELETE_FILE, this.f60110b);
            obtain.getData().putString(EncodeThread.KEY_BACKGROUND_MUSIC_PATH, this.f60111c.backgroundMusicPath);
            obtain.getData().putInt(EncodeThread.KEY_BACKGROUND_MUSIC_OFFSET, this.f60111c.backgroundMusicOffset);
            obtain.getData().putString(EncodeThread.KEY_DOODLE_PATH, this.f60111c.doodlePath);
            obtain.getData().putString(EncodeThread.KEY_LOCAL_RAW_VIDEO_DIR, this.f60111c.mLocalRawVideoDir);
            obtain.getData().putInt("key_video_width", this.f60111c.videoWidth);
            obtain.getData().putInt("key_video_height", this.f60111c.videoHeight);
            obtain.getData().putBoolean("is_new_encode", true);
            QzoneVideoPluginService.P.sendMessage(obtain);
            QZLog.i("[upload2][compress]", 1, "build video type 0 success", "source_path ", this.f60109a, "videoPath", str);
            com.qzone.video.service.a.a(0, "build video type 0 success");
        }

        @Override // com.tencent.mobileqq.shortvideo.g
        public void onError(int i3) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.arg1 = i3;
            obtain.getData().putString(MaxVideoConst.TAG_FILE_MP4, null);
            obtain.getData().putString("source_path", this.f60109a);
            obtain.getData().putString("client_key", QzoneVideoPluginService.E);
            obtain.getData().putBoolean(VideoCompressTask.KEY_NO_DELETE_FILE, this.f60110b);
            QzoneVideoPluginService.P.sendMessage(obtain);
            QZLog.i("[upload2][compress]", 1, "build video type 0 fail", "source_path ", this.f60109a);
            com.qzone.video.service.a.a(-1, "build video type 0 fail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class c implements VideoCompositeHelper.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f60112a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f60113b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ PublishVideoEntry f60114c;

        c(String str, boolean z16, PublishVideoEntry publishVideoEntry) {
            this.f60112a = str;
            this.f60113b = z16;
            this.f60114c = publishVideoEntry;
        }

        @Override // com.tencent.mobileqq.editor.composite.VideoCompositeHelper.f
        public void a(int i3, String str, String str2) {
            if (i3 == 0) {
                Message obtain = Message.obtain();
                obtain.what = 3;
                obtain.arg1 = 0;
                obtain.getData().putString(MaxVideoConst.TAG_FILE_MP4, str2);
                obtain.getData().putString("source_path", this.f60112a);
                obtain.getData().putString("client_key", QzoneVideoPluginService.E);
                obtain.getData().putBoolean(VideoCompressTask.KEY_NO_DELETE_FILE, this.f60113b);
                obtain.getData().putString(EncodeThread.KEY_BACKGROUND_MUSIC_PATH, this.f60114c.backgroundMusicPath);
                obtain.getData().putInt(EncodeThread.KEY_BACKGROUND_MUSIC_OFFSET, this.f60114c.backgroundMusicOffset);
                obtain.getData().putString(EncodeThread.KEY_DOODLE_PATH, this.f60114c.doodlePath);
                obtain.getData().putString(EncodeThread.KEY_LOCAL_RAW_VIDEO_DIR, this.f60114c.mLocalRawVideoDir);
                obtain.getData().putInt("key_video_width", this.f60114c.videoWidth);
                obtain.getData().putInt("key_video_height", this.f60114c.videoHeight);
                obtain.getData().putBoolean("is_new_encode", true);
                QzoneVideoPluginService.P.sendMessage(obtain);
                QZLog.i("[upload2][compress]", 1, "build video type 0 success", "source_path ", this.f60112a, "videoPath", str2);
                com.qzone.video.service.a.a(0, "build video type 0 success");
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 3;
            obtain2.arg1 = i3;
            obtain2.getData().putString(MaxVideoConst.TAG_FILE_MP4, null);
            obtain2.getData().putString("source_path", this.f60112a);
            obtain2.getData().putString("client_key", QzoneVideoPluginService.E);
            obtain2.getData().putBoolean(VideoCompressTask.KEY_NO_DELETE_FILE, this.f60113b);
            QzoneVideoPluginService.P.sendMessage(obtain2);
            QZLog.i("[upload2][compress]", 1, "build video type 0 fail", "source_path ", this.f60112a);
            com.qzone.video.service.a.a(-1, "build video type 0 fail");
        }
    }

    /* loaded from: classes37.dex */
    class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            String string = message.getData().getString("source_path");
            String string2 = message.getData().getString("client_key");
            int i3 = message.what;
            if (i3 == 1) {
                QZLog.i("[upload2][compress]", 1, "BuildVideo Begin. client_key=" + string2 + " source_path=" + string);
                QzoneVideoPluginService.Q(message, string2);
                return;
            }
            if (i3 == 2) {
                QZLog.i("[upload2][compress]", 1, "BuildVideo Progress\uff1a" + message.arg1 + "client_key=" + string2 + " source_path=" + string);
                return;
            }
            if (i3 == 3) {
                QzoneVideoPluginService.P(message, string, string2);
                return;
            }
            if (i3 == 1000) {
                QZLog.i("[upload2][compress]", 1, "TrimVideo Success. client_key=" + string2 + " source_path=" + string);
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(QzoneVideoPluginService.N);
                QzoneVideoPluginService.V(true, string, message.getData().getString("target_file"), QzoneVideoPluginService.K, string2);
                return;
            }
            if (i3 == 1001) {
                QZLog.i("[upload2][compress]", 1, "TrimVideo Fail. client_key=" + string2 + " source_path=" + string);
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(QzoneVideoPluginService.N);
                QzoneVideoPluginService.V(false, string, "", QzoneVideoPluginService.J + message.getData().getString("report_msg"), string2);
                return;
            }
            if (i3 != 1004) {
                if (i3 == 1005 && (obj = message.obj) != null && (obj instanceof String)) {
                    Intent intent = new Intent();
                    intent.putExtra("video_dest_file", (String) message.obj);
                    Message obtain = Message.obtain();
                    obtain.what = 1002;
                    obtain.obj = intent;
                    try {
                        QzoneVideoPluginService.f60105i.send(obtain);
                        return;
                    } catch (Exception e16) {
                        QZLog.e("[upload2][compress]", "DEST_FILE_PATH sendMessageToClient", e16);
                        return;
                    }
                }
                return;
            }
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(QzoneVideoPluginService.N, 5000L);
        }
    }

    /* loaded from: classes37.dex */
    public static class f extends ExecuteBinResponseCallback {

        /* renamed from: a, reason: collision with root package name */
        String f60116a;

        /* renamed from: b, reason: collision with root package name */
        String f60117b;

        /* renamed from: c, reason: collision with root package name */
        String f60118c;

        /* renamed from: d, reason: collision with root package name */
        String f60119d;

        /* renamed from: e, reason: collision with root package name */
        String f60120e;

        /* renamed from: f, reason: collision with root package name */
        String f60121f;

        /* renamed from: g, reason: collision with root package name */
        boolean f60122g;

        /* renamed from: h, reason: collision with root package name */
        int f60123h;

        /* renamed from: i, reason: collision with root package name */
        int f60124i;

        /* renamed from: j, reason: collision with root package name */
        long f60125j = System.currentTimeMillis();

        public f(String str, String str2, String str3, String str4, int i3, int i16, String str5, String str6, boolean z16) {
            this.f60116a = str;
            this.f60117b = str2;
            this.f60118c = str3;
            this.f60119d = str6;
            this.f60120e = str5;
            this.f60121f = str4;
            this.f60123h = i3;
            this.f60124i = i16;
            this.f60122g = z16;
            QZLog.i("QzoneVideoPluginService", 1, "mixBackgroundMusic originalPath: " + str + ", inputPath: " + str2 + ", outputPath: " + str3 + ", localRawVideoDir: " + str4 + ", videoWidth: " + i3 + ", videoHeight: " + i16 + ", doodlePath: " + str5 + ", clientKey: " + str6);
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFailure(String str) {
            QZLog.i("QzoneVideoPluginService", 1, "ResponseCallBack onFailure: " + str);
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFinish(boolean z16) {
            QZLog.i("QzoneVideoPluginService", 1, "ResponseCallBack onFinish step cost:" + ((System.currentTimeMillis() - this.f60125j) / 1000.0d) + ", isSuccess: " + z16);
            if (!z16) {
                QzoneVideoPluginService.V(false, this.f60116a, this.f60118c, QzoneVideoPluginService.I, this.f60119d);
                return;
            }
            if (!TextUtils.isEmpty(this.f60120e) && FileUtils.fileExistsAndNotEmpty(this.f60120e)) {
                QZLog.i("QzoneVideoPluginService", 1, "ResponseCallBack onFinish ---> watermarkVideoToAlum: originalPath: " + this.f60116a + ", videoPath: " + this.f60118c + ", localRawVideoDir:" + this.f60121f + ", videoWidth" + this.f60123h + ", videoHeight: " + this.f60124i + ", doodlePath: " + this.f60120e + ", clientKey: " + this.f60119d);
                e.d(this.f60116a, this.f60118c, this.f60121f, this.f60123h, this.f60124i, this.f60120e, this.f60119d, this.f60122g);
                return;
            }
            QZLog.i("QzoneVideoPluginService", 1, "ResponseCallBack onFinish ---> sendMessageToClient: originalPath: " + this.f60116a + ", videoPath: " + this.f60118c + ", clientKey:" + this.f60119d);
            QzoneVideoPluginService.V(true, this.f60116a, this.f60118c, QzoneVideoPluginService.H, this.f60119d);
            if (this.f60122g) {
                return;
            }
            FileUtils.deleteDirectory(this.f60116a);
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onSuccess(String str) {
            FileUtils.deleteFile(this.f60117b);
            QZLog.i("QzoneVideoPluginService", 1, "ResponseCallBack onSuccess: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(Message message, String str) {
        Intent intent = new Intent();
        intent.putExtra("client_key", str);
        Message obtain = Message.obtain();
        obtain.what = 1003;
        obtain.obj = intent;
        try {
            f60105i.send(obtain);
        } catch (Exception e16) {
            QZLog.e("QzoneVideoPluginService", "MSG_WHAT_TRIM_START sendMessageToClient", e16);
        }
    }

    private static void R(String str, int i3, int i16, boolean z16, String str2, PublishVideoEntry publishVideoEntry, boolean z17) {
        EncodeVideoTask.d dVar = new EncodeVideoTask.d();
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.getData().putString("client_key", E);
        P.sendMessage(obtain);
        EncodeVideoTask encodeVideoTask = new EncodeVideoTask(BaseApplication.getContext(), str2, true, dVar, true);
        encodeVideoTask.J(z17);
        encodeVideoTask.H(true);
        encodeVideoTask.I(new b(str, z16, publishVideoEntry));
        encodeVideoTask.execute(new Void[0]);
        QZLog.i("[upload2][compress]", 1, "START BUILD_VIDEO USE NEW ENCODE, sourcePath=" + str + ", type=" + i3 + ", cacheKey=" + E + ", retryNum=" + i16 + ", isGenerateGif=" + F);
    }

    private static void S(String str, int i3, int i16, boolean z16, PublishVideoEntry publishVideoEntry) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.getData().putString("client_key", E);
        P.sendMessage(obtain);
        String videoOutputPath = ShortVideoUtils.getVideoOutputPath(publishVideoEntry.mLocalRawVideoDir);
        if (TextUtils.isEmpty(videoOutputPath)) {
            QZLog.i("[upload2][compress]", 1, "get target path fail");
            return;
        }
        com.tencent.sveffects.a.b();
        L.b(publishVideoEntry, videoOutputPath, false, true, new c(str, z16, publishVideoEntry));
        QZLog.i("[upload2][compress]", 1, "START BUILD_VIDEO USE NEW ENCODE, sourcePath=" + str + ", type=" + i3 + ", cacheKey=" + E + ", retryNum=" + i16 + ", isGenerateGif=" + F);
    }

    public static boolean U() {
        return f60106m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void W(String str, String str2, int i3, String str3) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.arg1 = i3;
        obtain.getData().putString(MaxVideoConst.TAG_FILE_MP4, str);
        obtain.getData().putString("source_path", str2);
        obtain.getData().putString("client_key", E);
        P.sendMessage(obtain);
        QZLog.d("[upload2][compress]", 1, str3 + i3);
    }

    @Override // mqq.app.AppService, android.app.Service
    public IBinder onBind(Intent intent) {
        QZLog.i("QzoneVideoPluginService", 1, "onBind, uin=" + intent.getStringExtra("qzone_uin"));
        f60106m = true;
        return Q.getBinder();
    }

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        QZLog.i("QzoneVideoPluginService", 1, "onCreate, thread=" + Thread.currentThread().getName());
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes37.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private static FFmpeg f60115a;

        /* JADX INFO: Access modifiers changed from: private */
        public static void c(String str, String str2, String str3, int i3, long j3, f fVar) {
            QZLog.i("QzoneVideoPluginService", 1, "mixBackgroundMusic inputPath: " + str + ", outputPath: " + str2 + ", backgroundMusicPath: " + str3 + ", backgroundMusicOffset: " + i3 + ", mVideoDuration: " + j3);
            try {
                FFmpegUtils.combinBackgroundMusic(BaseApplicationImpl.getApplication(), str, str3, i3, (int) j3, str2, fVar);
            } catch (FFmpegCommandAlreadyRunningException e16) {
                QZLog.e("QzoneVideoPluginService", "mixBackgroundMusic error!", e16);
            } catch (IOException e17) {
                QZLog.e("QzoneVideoPluginService", "mixBackgroundMusic error!", e17);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void d(String str, String str2, String str3, int i3, int i16, String str4, String str5, boolean z16) {
            QZLog.i("QzoneVideoPluginService", 1, "watermarkVideoToAlum originalPath: " + str + ", inputPath: " + str2 + ", localRawVideoDir: " + str3 + ", videoWidth: " + i3 + ", videoHeight: " + i16 + ", doodlePath: " + str4 + ", clientKey: " + str5);
            String vidFromSourceDirFile = VidUtil.getVidFromSourceDirFile(new File(str3));
            StringBuilder sb5 = new StringBuilder(AppConstants.SDCARD_IMG_CAMERA);
            sb5.append(vidFromSourceDirFile);
            sb5.append("_qz");
            sb5.append(".mp4");
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append("watermarkVideoToAlum: outputPath = ");
            sb7.append(sb6);
            QZLog.i("QzoneVideoPluginService", 1, sb7.toString());
            if (f60115a == null) {
                f60115a = FFmpeg.getInstance(BaseApplicationImpl.getApplication());
            }
            if (f60115a.isFFmpegCommandRunning()) {
                QZLog.i("QzoneVideoPluginService", 1, "watermarkVideoToAlum: generate files mFFmpeg is running!");
                return;
            }
            try {
                g gVar = new g(str, str2, sb6, str5, z16);
                f60115a.setCurrentTaskUni(sb6);
                QZLog.i("QzoneVideoPluginService", 1, "watermarkVideoToAlum: start watermark!");
                f60115a.watermark(str4, str2, sb6, i3, i16, gVar);
            } catch (Exception e16) {
                QZLog.e("QzoneVideoPluginService", "watermarkVideoToAlum: generate files save alum", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(boolean z16, String str, String str2, String str3, String str4) {
        QZLog.i("[upload2][compress]", 1, "sendMessageToClient, source path=" + str + ", clientKey=" + str4, " dstPath=", str2, " errMsg=", str3, " target=", str4);
        if (f60105i == null) {
            QZLog.e("[upload2][compress]", 1, "no connection is active");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("video_source_path", str);
        intent.putExtra(VideoCompressTask.KEY_HANDLE_RESULT, z16);
        intent.putExtra(VideoCompressTask.KEY_DEST_PATH, str2);
        intent.putExtra(VideoCompressTask.KEY_ERR_MSG, str3);
        intent.putExtra("client_key", str4);
        QZLog.i("QzoneVideoPluginService", 1, "video file size srcLen=" + q.m(str) + ",dstLen=" + q.m(str2));
        Message obtain = Message.obtain();
        obtain.what = 1000;
        obtain.obj = intent;
        try {
            f60105i.send(obtain);
            QZLog.e("[upload2][compress]", 1, "send to client success");
        } catch (Exception e16) {
            QZLog.e("[upload2][compress]", "sendMessageToClient error", e16);
        }
        if (D.size() > 0) {
            O(D.remove(0));
        } else {
            C = false;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        QZLog.i("QzoneVideoPluginService", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        QZLog.i("QzoneVideoPluginService", 1, "onUnbind");
        f60105i = null;
        f60106m = false;
        return super.onUnbind(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O(Message message) {
        PublishVideoEntry publishVideoEntry;
        Intent intent = (Intent) message.obj;
        final String stringExtra = intent.getStringExtra("video_source_path");
        int intExtra = intent.getIntExtra("video_type", -1);
        E = intent.getStringExtra("client_key");
        int intExtra2 = intent.getIntExtra(VideoCompressTask.KEY_RETRY_NUM, 0);
        boolean booleanExtra = intent.getBooleanExtra(VideoCompressTask.KEY_NO_DELETE_FILE, false);
        F = intent.getBooleanExtra(ShortVideoConstants.VIDEO_IS_GENERATE_GIF, false);
        boolean booleanExtra2 = intent.getBooleanExtra(RemoteHandleConst.VIDEO_PARAM_ISUPLOADORIGIN, false);
        QZLog.i("[upload2][compress]", 1, "START BUILD_VIDEO, sourcePath=" + stringExtra + ", type=" + intExtra + ", cacheKey=" + E + ", retryNum=" + intExtra2 + ", isGenerateGif=" + F);
        if (intExtra != 0) {
            if (intExtra == 1) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.getData().putString("client_key", E);
                P.sendMessage(obtain);
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.VideoThread).post(new TrimVideoThread(BaseApplication.getContext(), P, stringExtra, intent.getLongExtra("start_time", -1L), intent.getLongExtra("end_time", -1L), intent.getLongExtra(VideoCompressTask.KEY_TOTAL_DURATION, -1L), E, intent.getBooleanExtra(VideoCompressTask.KEY_NEED_ORIGIN, false), intExtra2, booleanExtra, intent.getBooleanExtra(ShortVideoConstants.VIDEO_IS_SYNC_TO_WEISHI, false), intent.getBooleanExtra(ShortVideoConstants.VIDEO_IS_USE_QCIRCLE_RATE, false)));
                QZLog.i("[upload2][compress]", 1, "START BUILD_VIDEO FOR TRIM, sourcePath=" + stringExtra + ", type=" + intExtra + ", cacheKey=" + E + ", retryNum=" + intExtra2 + ", isGenerateGif=" + F);
                return;
            }
            return;
        }
        String stringExtra2 = intent.getStringExtra(ShortVideoConstants.VIDEO_NEW_FAKE_VID);
        QZLog.i("QzoneVideoPluginService", 1, "VIDEO_EDIT_NEW_FAKE_VID, fakeVid = " + stringExtra2);
        if (VideoEnvironment.getAVCodecVersion() >= 21) {
            try {
                VideoSourceHelper.nativeSetMaxPhotoFrameCount(3);
            } catch (UnsatisfiedLinkError e16) {
                QZLog.e("QzoneVideoPluginService", 1, "nativeSetMaxPhotoFrameCount:exp=" + e16);
            }
        }
        boolean z16 = !booleanExtra;
        if (TextUtils.isEmpty(stringExtra2)) {
            publishVideoEntry = null;
        } else {
            PublishVideoEntry k3 = VideoCompositeHelper.k(stringExtra2);
            if (k3 != null) {
                int i3 = k3.saveMode;
                if (i3 != 0) {
                    CodecParam.mSaveMode = i3;
                }
                if (TextUtils.isEmpty(k3.backgroundMusicPath)) {
                    TextUtils.isEmpty(k3.doodlePath);
                }
                CodecParam.mAdjustSpecialSpeed = k3.businessId == 2 ? 0 : 1;
            } else {
                QZLog.e("QzoneVideoPluginService", "publishVideoEntry is null !!!!");
            }
            publishVideoEntry = k3;
        }
        final a.C7209a b16 = com.tencent.mobileqq.activity.shortvideo.a.b(stringExtra);
        boolean booleanExtra3 = intent.getBooleanExtra(RemoteHandleConst.PARAM_FROM_AIO, false);
        if (publishVideoEntry != null && publishVideoEntry.hwEncodeRecordVideo && booleanExtra3) {
            R(stringExtra, intExtra, intExtra2, booleanExtra, stringExtra2, publishVideoEntry, z16);
            return;
        }
        if (publishVideoEntry != null && publishVideoEntry.hwEncodeRecordVideo) {
            L.s(true ^ booleanExtra2);
            S(stringExtra, intExtra, intExtra2, booleanExtra, publishVideoEntry);
        } else {
            if (b16 != null) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.VideoThread).post(new Runnable() { // from class: com.qzone.video.service.QzoneVideoPluginService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String shortVideoPath = ShortVideoUtils.getShortVideoPath(new File(stringExtra));
                            int merge = HwVideoMerge.merge(b16.f186311a, null, shortVideoPath, 0);
                            if (merge == 0) {
                                QzoneVideoPluginService.W(shortVideoPath, stringExtra, 0, null);
                            } else {
                                QzoneVideoPluginService.W(shortVideoPath, stringExtra, merge, "HwVideoMerge.merge error");
                            }
                        } catch (Exception e17) {
                            QZLog.e("[upload2][compress]", "HwVideoMerge.merge error ", e17);
                            QzoneVideoPluginService.W(null, stringExtra, -1, "HwVideoMerge.merge error");
                        }
                    }
                });
                QZLog.i("[upload2][compress]", 1, "START BUILD_VIDEO FOR COVER, sourcePath=" + stringExtra + ", cacheKey=" + E);
                return;
            }
            W(null, stringExtra, -1, "build video type 0 fail,file not found");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int T() {
        BufferedReader bufferedReader;
        Throwable th5;
        IOException e16;
        String readLine;
        float f16 = -1.0f;
        try {
        } catch (Exception e17) {
            QZLog.w(e17);
        }
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
            } catch (IOException e18) {
                bufferedReader = null;
                e16 = e18;
            } catch (Throwable th6) {
                bufferedReader = null;
                th5 = th6;
                if (bufferedReader != null) {
                }
                throw th5;
            }
            try {
                readLine = bufferedReader.readLine();
            } catch (IOException e19) {
                e16 = e19;
                QZLog.w(e16);
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return Math.round(f16);
            }
            if (readLine == null) {
                try {
                    bufferedReader.close();
                    return 0;
                } catch (Exception e26) {
                    QZLog.w(e26);
                    return 0;
                }
            }
            String[] split = readLine.split(" ");
            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]);
            long parseLong2 = Long.parseLong(split[5]);
            long j3 = f60101d;
            f16 = (((float) (parseLong - j3)) * 100.0f) / ((float) (((parseLong - j3) + parseLong2) - f60102e));
            f60101d = parseLong;
            f60102e = parseLong2;
            bufferedReader.close();
            return Math.round(f16);
        } catch (Throwable th7) {
            th5 = th7;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e27) {
                    QZLog.w(e27);
                }
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void P(Message message, String str, String str2) {
        String str3;
        File file;
        String str4;
        String str5;
        String str6;
        String sb5;
        if (message.arg1 == 0) {
            QZLog.i("[upload2][compress]", 1, "BuildVideo success. client_key=" + str2 + " source_path=" + str);
            boolean z16 = message.getData().getBoolean("is_new_encode", false);
            String string = message.getData().getString(MaxVideoConst.TAG_FILE_MP4);
            String string2 = message.getData().getString(EncodeThread.KEY_BACKGROUND_MUSIC_PATH);
            int i3 = message.getData().getInt(EncodeThread.KEY_BACKGROUND_MUSIC_OFFSET, -1);
            String string3 = message.getData().getString(EncodeThread.KEY_LOCAL_RAW_VIDEO_DIR);
            int i16 = message.getData().getInt("key_video_width");
            int i17 = message.getData().getInt("key_video_height");
            String string4 = message.getData().getString(EncodeThread.KEY_DOODLE_PATH);
            boolean z17 = (TextUtils.isEmpty(string2) || F) ? false : true;
            boolean z18 = !TextUtils.isEmpty(string4) && FileUtils.fileExistsAndNotEmpty(string4);
            boolean z19 = message.getData().getBoolean(VideoCompressTask.KEY_NO_DELETE_FILE, false);
            QZLog.i("QzoneVideoPluginService", 1, "existAudioFile : " + z17 + " , existDoodleFile : " + z18);
            if (z17 && !TextUtils.isEmpty(string3) && !z16) {
                try {
                    String vidFromSourceDirFile = VidUtil.getVidFromSourceDirFile(new File(string3));
                    StringBuilder sb6 = new StringBuilder(AppConstants.SDCARD_IMG_CAMERA);
                    sb6.append(vidFromSourceDirFile);
                    if (z18) {
                        str6 = "_qz_temp";
                    } else {
                        str6 = "_qz";
                    }
                    sb6.append(str6);
                    sb6.append(".mp4");
                    sb5 = sb6.toString();
                    str5 = string;
                } catch (Exception e16) {
                    e = e16;
                    str5 = string;
                }
                try {
                    e.c(string, sb5, string2, i3, ShortVideoUtils.getDurationOfVideo(string), new f(str, string, sb5, string3, i16, i17, string4, str2, z19));
                } catch (Exception e17) {
                    e = e17;
                    QZLog.e("QzoneVideoPluginService", "dealVideoEnd error:", e);
                    str4 = str5;
                    str3 = str4;
                    QZLog.i("QzoneVideoPluginService", 1, "BuildVideo End, errorCode=" + message.arg1 + ", mp4 file=" + str3);
                }
                str4 = str5;
            } else if (z18 && !z16) {
                str4 = string;
                e.d(str, string, string3, i16, i17, string4, str2, z19);
            } else {
                if (F && !TextUtils.isEmpty(string3)) {
                    str3 = QZoneFilePath.DCIM_CAMERA_PATH + File.separator + VidUtil.getVidFromSourceDirFile(new File(string3)) + QzoneEmotionUtils.SIGN_ICON_URL_END;
                    QZLog.i("QzoneVideoPluginService", 1, "mResultHandler ---> convertGif mp4File:" + string + " gifPath:" + str3);
                    if (GifProcessor.convertVideoToGifForRecord(string, str3) == 0 && !TextUtils.isEmpty(string)) {
                        new File(string).delete();
                        V(true, str, str3, H, str2);
                        if (!z19 && !TextUtils.isEmpty(str)) {
                            file = new File(str);
                            if (!file.exists() && file.isDirectory()) {
                                FileUtils.deleteDirectory(str);
                            } else if (file.isFile()) {
                                FileUtils.deleteFile(str);
                            }
                        }
                    } else {
                        QZLog.i("QzoneVideoPluginService", 1, "mResultHandler ---> convertGif fail mp4File:" + string + " gifPath:" + str3);
                        V(false, string3, string, G, str2);
                    }
                }
                str3 = string;
                V(true, str, str3, H, str2);
                if (!z19) {
                    file = new File(str);
                    if (!file.exists()) {
                    }
                    if (file.isFile()) {
                    }
                }
            }
            str3 = str4;
        } else {
            QZLog.i("[upload2][compress]", 1, "BuildVideo fail. client_key=" + str2 + " source_path=" + str);
            str3 = "";
            V(false, str, "", I, str2);
        }
        QZLog.i("QzoneVideoPluginService", 1, "BuildVideo End, errorCode=" + message.arg1 + ", mp4 file=" + str3);
    }

    /* loaded from: classes37.dex */
    public static class g implements FFmpegExecuteResponseCallback {

        /* renamed from: a, reason: collision with root package name */
        String f60126a;

        /* renamed from: b, reason: collision with root package name */
        String f60127b;

        /* renamed from: c, reason: collision with root package name */
        String f60128c;

        /* renamed from: d, reason: collision with root package name */
        String f60129d;

        /* renamed from: e, reason: collision with root package name */
        long f60130e = System.currentTimeMillis();

        /* renamed from: f, reason: collision with root package name */
        boolean f60131f;

        public g(String str, String str2, String str3, String str4, boolean z16) {
            this.f60126a = str;
            this.f60127b = str2;
            this.f60128c = str3;
            this.f60129d = str4;
            this.f60131f = z16;
            QZLog.i("QzoneVideoPluginService", 1, "VideoSaveAlumCallBack originalPath: " + str + ", inputPath: " + str2 + ", videoPath: " + str3 + ", clientKey: " + str4 + ", mStartTime: " + this.f60130e);
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFailure(String str) {
            QZLog.i("QzoneVideoPluginService", 1, "VideoSaveAlumCallBack onFailure step fail:" + str);
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFinish(boolean z16) {
            QZLog.i("QzoneVideoPluginService", 1, "VideoSaveAlumCallBack onFinish step cost:" + ((System.currentTimeMillis() - this.f60130e) / 1000.0d) + ", isSuccess: " + z16);
            if (z16) {
                if (QzoneVideoPluginService.F) {
                    String str = QZoneFilePath.DCIM_CAMERA_PATH + File.separator + VidUtil.getVidFromSourceDirFile(new File(this.f60126a)) + QzoneEmotionUtils.SIGN_ICON_URL_END;
                    QZLog.i("QzoneVideoPluginService", 1, "VideoSaveAlumCallBack onFinish ---> convertGif videoFinalPath:" + this.f60128c + " gifPath:" + str);
                    if (GifProcessor.convertVideoToGifForRecord(this.f60128c, str) != 0) {
                        QzoneVideoPluginService.V(false, this.f60126a, this.f60128c, QzoneVideoPluginService.G, this.f60129d);
                    } else {
                        new File(this.f60128c).delete();
                        this.f60128c = str;
                    }
                }
                QZLog.i("QzoneVideoPluginService", 1, "VideoSaveAlumCallBack onFinish ---> sendMessageToClient: originalPath: " + this.f60126a + ", videoFinalPath: " + this.f60128c + ", clientKey:" + this.f60129d);
                QzoneVideoPluginService.V(true, this.f60126a, this.f60128c, QzoneVideoPluginService.H, this.f60129d);
                if (this.f60131f) {
                    return;
                }
                FileUtils.deleteDirectory(this.f60126a);
                return;
            }
            QzoneVideoPluginService.V(true, this.f60126a, this.f60128c, QzoneVideoPluginService.I, this.f60129d);
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onSuccess(String str) {
            QZLog.i("QzoneVideoPluginService", 1, "VideoSaveAlumCallBack onSuccess --->  message: " + str);
            FileUtils.deleteFile(this.f60127b);
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onStart() {
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onProgress(String str) {
        }
    }
}
