package com.tencent.mobileqq.utils;

import android.app.Notification;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqmini.minigame.plugins.AudioRecorderJsPlugin;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AudioUtil {

    /* renamed from: c, reason: collision with root package name */
    public static MediaPlayer f306881c;

    /* renamed from: a, reason: collision with root package name */
    static final int[] f306879a = {35, 36};

    /* renamed from: b, reason: collision with root package name */
    static final int[] f306880b = {26, 27};

    /* renamed from: d, reason: collision with root package name */
    private static int f306882d = 0;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements MediaPlayer.OnCompletionListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.release();
            AudioUtil.f306881c = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements MediaPlayer.OnCompletionListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.release();
            AudioUtil.f306881c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.release();
            AudioUtil.f306881c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements MediaPlayer.OnPreparedListener {
        d() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                mediaPlayer.start();
            } catch (Exception e16) {
                QLog.e("AudioUtil", 1, "mediaplayer error: " + Arrays.toString(e16.getStackTrace()));
            }
        }
    }

    private static void d(final MediaPlayer.OnCompletionListener onCompletionListener, Handler handler) {
        if (onCompletionListener == null) {
            return;
        }
        if (handler != null && handler.getLooper() != Looper.myLooper()) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioUtil", 1, "callbackWithHandler post callback");
            }
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.utils.AudioUtil.10
                @Override // java.lang.Runnable
                public void run() {
                    onCompletionListener.onCompletion(AudioUtil.f306881c);
                }
            });
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("AudioUtil", 1, "callbackWithHandler immediately callback ");
            }
            onCompletionListener.onCompletion(f306881c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.media.MediaPlayer] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r9v3, types: [android.media.MediaPlayer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static MediaPlayer e(Context context, int i3) {
        AssetFileDescriptor assetFileDescriptor;
        ?? r16;
        ReportMediaPlayer reportMediaPlayer;
        AssetFileDescriptor assetFileDescriptor2 = null;
        try {
            try {
                AssetFileDescriptor openRawResourceFd = context.getResources().openRawResourceFd(i3);
                if (openRawResourceFd != null) {
                    try {
                        try {
                            reportMediaPlayer = new ReportMediaPlayer();
                            try {
                                u(reportMediaPlayer);
                                reportMediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                                openRawResourceFd.close();
                                try {
                                    reportMediaPlayer.prepare();
                                } catch (Exception e16) {
                                    e = e16;
                                    r16 = reportMediaPlayer;
                                    assetFileDescriptor = null;
                                    try {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("createAndSetAudioStreamType", 2, "create failed:", e);
                                        }
                                        if (r16 != 0) {
                                            try {
                                                r16.release();
                                            } catch (Exception unused) {
                                            }
                                        } else {
                                            assetFileDescriptor2 = r16;
                                        }
                                        if (assetFileDescriptor != null) {
                                            try {
                                                assetFileDescriptor.close();
                                            } catch (Exception unused2) {
                                            }
                                        }
                                        return assetFileDescriptor2;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        assetFileDescriptor2 = assetFileDescriptor;
                                        if (assetFileDescriptor2 != null) {
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Exception e17) {
                                assetFileDescriptor = openRawResourceFd;
                                e = e17;
                                r16 = reportMediaPlayer;
                            }
                        } catch (Exception e18) {
                            r16 = 0;
                            assetFileDescriptor = openRawResourceFd;
                            e = e18;
                        }
                    } catch (Throwable th6) {
                        assetFileDescriptor2 = openRawResourceFd;
                        th = th6;
                        if (assetFileDescriptor2 != null) {
                            try {
                                assetFileDescriptor2.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                } else {
                    reportMediaPlayer = null;
                    assetFileDescriptor2 = openRawResourceFd;
                }
                if (assetFileDescriptor2 != null) {
                    try {
                        assetFileDescriptor2.close();
                        return reportMediaPlayer;
                    } catch (Exception unused4) {
                        return reportMediaPlayer;
                    }
                }
                return reportMediaPlayer;
            } catch (Exception e19) {
                e = e19;
                assetFileDescriptor = null;
                r16 = 0;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private static MediaPlayer f(Context context, Uri uri) {
        ReportMediaPlayer reportMediaPlayer;
        try {
            reportMediaPlayer = new ReportMediaPlayer();
            try {
                u(reportMediaPlayer);
                reportMediaPlayer.setDataSource(context, uri);
                reportMediaPlayer.prepare();
            } catch (IOException e16) {
                e = e16;
                if (QLog.isColorLevel()) {
                    QLog.d("createAndSetAudioStreamType", 2, "create failed:", e);
                }
                if (reportMediaPlayer != null) {
                    try {
                        reportMediaPlayer.release();
                        return null;
                    } catch (Exception unused) {
                        return null;
                    }
                }
                return reportMediaPlayer;
            }
        } catch (IOException e17) {
            e = e17;
            reportMediaPlayer = null;
        }
        return reportMediaPlayer;
    }

    public static int g() {
        return ((AudioManager) BaseApplication.getContext().getSystemService("audio")).getRingerMode();
    }

    public static boolean h(int i3) {
        return i(i3, BaseApplication.getContext());
    }

    public static boolean i(int i3, Context context) {
        Object systemService;
        if (j() && (systemService = context.getSystemService("appops")) != null && systemService.getClass().getSimpleName().equals(AudioRecorderJsPlugin.AudioManager.CLASS_NAME_APP_OPS_MANAGER)) {
            try {
                Class<?> cls = systemService.getClass();
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod(AudioRecorderJsPlugin.AudioManager.FUNCTION_NAME_CHECK_OP_NOT_THROW, cls2, cls2, String.class);
                int i16 = f306880b[i3];
                ApplicationInfo applicationInfo = BaseApplication.getContext().getApplicationInfo();
                int intValue = ((Integer) method.invoke(systemService, Integer.valueOf(i16), Integer.valueOf(applicationInfo.uid), applicationInfo.packageName)).intValue();
                if (QLog.isColorLevel()) {
                    QLog.d("AudioUtil", 2, "isForbidByRubbishMeizu(), result = " + intValue);
                }
                if (intValue == 0) {
                    return false;
                }
                return true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AudioUtil", 2, e16.toString());
                }
            }
        }
        return false;
    }

    private static boolean j() {
        return CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static void k(int i3) {
        n(i3, false);
    }

    public static synchronized void l(int i3, int i16, MediaPlayer.OnCompletionListener onCompletionListener) {
        synchronized (AudioUtil.class) {
            m(i3, i16, onCompletionListener, null);
        }
    }

    public static synchronized void m(int i3, int i16, final MediaPlayer.OnCompletionListener onCompletionListener, final Handler handler) {
        MediaPlayer mediaPlayer;
        synchronized (AudioUtil.class) {
            boolean z16 = false;
            try {
                MediaPlayer mediaPlayer2 = f306881c;
                if (mediaPlayer2 != null) {
                    if (mediaPlayer2.isPlaying()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AudioUtil", 2, "[SilkPlayer] MediaPlayerStart return, mediaPalyer.isPlaying()");
                        }
                        return;
                    }
                    s();
                }
                if (i3 != com.tencent.mobileqq.inject.a.f238063a.b()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AudioUtil", 2, "[SilkPlayer] MediaPlayerStart, resId != AppSetting.TypeSystemSoundId");
                    }
                    f306881c = MediaPlayer.create(BaseApplication.getContext(), i3);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("AudioUtil", 2, "[SilkPlayer] MediaPlayerStart, resId == AppSetting.TypeSystemSoundId");
                    }
                    f306881c = MediaPlayer.create(BaseApplication.getContext(), Settings.System.DEFAULT_NOTIFICATION_URI);
                }
                mediaPlayer = f306881c;
            } catch (Exception e16) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[SilkPlayer]mediaPlayerStart, exception, mediaPalyer == null ?  ");
                if (f306881c == null) {
                    z16 = true;
                }
                sb5.append(z16);
                QLog.e("AudioUtil", 1, sb5.toString(), e16);
                if (onCompletionListener != null) {
                    if (handler != null && handler.getLooper() != Looper.myLooper()) {
                        QLog.e("AudioUtil", 1, "MediaPlayerStart, exception, branch 2");
                        handler.post(new Runnable() { // from class: com.tencent.mobileqq.utils.AudioUtil.5
                            @Override // java.lang.Runnable
                            public void run() {
                                onCompletionListener.onCompletion(AudioUtil.f306881c);
                            }
                        });
                    }
                    QLog.e("AudioUtil", 1, "MediaPlayerStart, exception, branch 1");
                    onCompletionListener.onCompletion(f306881c);
                }
            }
            if (mediaPlayer == null) {
                return;
            }
            f306882d = i16;
            if (i16 != 0) {
                f306882d = i16 - 1;
            }
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.mobileqq.utils.AudioUtil.4
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer3) {
                    if (AudioUtil.f306882d != 0) {
                        AudioUtil.f306882d--;
                        AudioUtil.t(AudioUtil.f306881c);
                        return;
                    }
                    if (onCompletionListener != null) {
                        Handler handler2 = handler;
                        if (handler2 != null && handler2.getLooper() != Looper.myLooper()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("AudioUtil", 2, "MediaPlayerStart, onCompletion, onCompletion branch 2");
                            }
                            AudioUtil.s();
                            handler.post(new Runnable() { // from class: com.tencent.mobileqq.utils.AudioUtil.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    onCompletionListener.onCompletion(AudioUtil.f306881c);
                                }
                            });
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("AudioUtil", 2, "MediaPlayerStart, onCompletion, onCompletion branch 1");
                        }
                        onCompletionListener.onCompletion(AudioUtil.f306881c);
                        return;
                    }
                    AudioUtil.s();
                }
            });
            f306881c.start();
            if (QLog.isColorLevel()) {
                QLog.d("AudioUtil", 2, "[SilkPlayer]mediaPlayerStart, \u64ad\u653e\u63d0\u793a\u97f3\uff0cmediaPalyer.start().");
            }
            f306881c.setLooping(false);
        }
    }

    public static void n(int i3, boolean z16) {
        o(i3, z16, false);
    }

    public static synchronized void o(int i3, boolean z16, boolean z17) {
        MediaPlayer mediaPlayer;
        synchronized (AudioUtil.class) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("MediaPlayerStart", 2, "resourceId=" + i3 + ",looping=" + z16);
                }
                MediaPlayer mediaPlayer2 = f306881c;
                if (mediaPlayer2 != null) {
                    if (mediaPlayer2.isPlaying()) {
                        if (QLog.isColorLevel()) {
                            QLog.w("MediaPlayerStart", 2, "media palyer is playing");
                        }
                        return;
                    }
                    try {
                        try {
                            f306881c.release();
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e("MediaPlayerStart", 2, "media palyer release exception", e16);
                            }
                        }
                    } finally {
                        f306881c = null;
                    }
                }
                if (i3 != com.tencent.mobileqq.inject.a.f238063a.b()) {
                    if (z17) {
                        f306881c = MediaPlayer.create(BaseApplication.getContext(), i3, Notification.AUDIO_ATTRIBUTES_DEFAULT, 0);
                    } else {
                        f306881c = MediaPlayer.create(BaseApplication.getContext(), i3);
                    }
                } else {
                    if (z17) {
                        f306881c = MediaPlayer.create(BaseApplication.getContext(), Settings.System.DEFAULT_NOTIFICATION_URI, null, Notification.AUDIO_ATTRIBUTES_DEFAULT, 0);
                    } else {
                        f306881c = MediaPlayer.create(BaseApplication.getContext(), Settings.System.DEFAULT_NOTIFICATION_URI);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MediaPlayerStart", 2, "media palyer uri=" + Settings.System.DEFAULT_NOTIFICATION_URI);
                    }
                }
                mediaPlayer = f306881c;
            } finally {
            }
            if (mediaPlayer == null) {
                if (QLog.isColorLevel()) {
                    QLog.w("MediaPlayerStart", 2, "media palyer is null");
                }
            } else {
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.mobileqq.utils.AudioUtil.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(final MediaPlayer mediaPlayer3) {
                        AudioUtil.f306881c = null;
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.utils.AudioUtil.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                mediaPlayer3.release();
                            }
                        }, 16, null, false);
                    }
                });
                f306881c.start();
                f306881c.setLooping(z16);
            }
        }
    }

    public static synchronized void p(Uri uri, boolean z16, boolean z17) {
        synchronized (AudioUtil.class) {
            FileInputStream fileInputStream = null;
            try {
                MediaPlayer mediaPlayer = f306881c;
                if (mediaPlayer != null) {
                    try {
                        mediaPlayer.release();
                    } catch (Exception unused) {
                    } catch (Throwable th5) {
                        f306881c = null;
                        throw th5;
                    }
                    f306881c = null;
                }
                if (uri.getScheme().equals("file")) {
                    f306881c = new ReportMediaPlayer();
                    if (z17) {
                        if (QLog.isColorLevel()) {
                            QLog.d("mediaPlayerStart", 2, "===isNotification=");
                        }
                        u(f306881c);
                    }
                    FileInputStream fileInputStream2 = new FileInputStream(new File(uri.getPath()));
                    try {
                        f306881c.setDataSource(fileInputStream2.getFD());
                        f306881c.prepare();
                        fileInputStream = fileInputStream2;
                    } catch (Exception unused2) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e16) {
                                e = e16;
                                e.printStackTrace();
                            }
                        }
                    } catch (Throwable th6) {
                        fileInputStream = fileInputStream2;
                        th = th6;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } else {
                    MediaPlayer create = MediaPlayer.create(BaseApplication.getContext(), uri);
                    f306881c = create;
                    if (create == null) {
                        return;
                    }
                    if (z17) {
                        if (QLog.isColorLevel()) {
                            QLog.d("mediaPlayerStart", 2, "===isNotification=");
                        }
                        u(f306881c);
                    }
                }
                f306881c.setOnCompletionListener(new c());
                f306881c.start();
                f306881c.setLooping(z16);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e18) {
                        e = e18;
                        e.printStackTrace();
                    }
                }
            } catch (Exception unused3) {
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    public static synchronized void q(int i3, int i16, MediaPlayer.OnCompletionListener onCompletionListener, Handler handler) {
        boolean z16;
        MediaPlayer mediaPlayer;
        synchronized (AudioUtil.class) {
            try {
                mediaPlayer = f306881c;
            } catch (Exception e16) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[SilkPlayer]mediaPlayerStartForAudio, exception, mediaPalyer == null ?  ");
                if (f306881c == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.e("AudioUtil", 1, sb5.toString(), e16);
                d(onCompletionListener, handler);
            }
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                if (QLog.isColorLevel()) {
                    QLog.d("AudioUtil", 2, "[SilkPlayer] mediaPlayerStartForAudio return, mediaPalyer.isPlaying()");
                }
                d(onCompletionListener, handler);
                return;
            }
            m(i3, i16, onCompletionListener, handler);
        }
    }

    public static synchronized void r(int i3, boolean z16) {
        MediaPlayer mediaPlayer;
        synchronized (AudioUtil.class) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("mediaPlayerStartForMsg", 2, "resourceId=" + i3 + ",looping=" + z16);
                }
                MediaPlayer mediaPlayer2 = f306881c;
                if (mediaPlayer2 != null) {
                    if (mediaPlayer2.isPlaying()) {
                        if (QLog.isColorLevel()) {
                            QLog.w("mediaPlayerStartForMsg", 2, "media palyer is playing");
                        }
                        return;
                    }
                    try {
                        try {
                            f306881c.release();
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e("mediaPlayerStartForMsg", 2, "media palyer release exception", e16);
                            }
                        }
                    } finally {
                        f306881c = null;
                    }
                }
                if (i3 != com.tencent.mobileqq.inject.a.f238063a.b()) {
                    f306881c = e(BaseApplication.getContext(), i3);
                } else {
                    f306881c = f(BaseApplication.getContext(), Settings.System.DEFAULT_NOTIFICATION_URI);
                    if (QLog.isColorLevel()) {
                        QLog.d("mediaPlayerStartForMsg", 2, "media palyer uri=" + Settings.System.DEFAULT_NOTIFICATION_URI);
                    }
                }
                mediaPlayer = f306881c;
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("mediaPlayerStartForMsg", 2, "media palyer exception", e17);
                }
            }
            if (mediaPlayer == null) {
                if (QLog.isColorLevel()) {
                    QLog.w("mediaPlayerStartForMsg", 2, "media palyer is null");
                }
            } else {
                mediaPlayer.setOnCompletionListener(new b());
                f306881c.start();
                f306881c.setLooping(z16);
            }
        }
    }

    public static void s() {
        if (QLog.isColorLevel()) {
            QLog.d("AudioUtil", 2, "[silkPlayer]mediaPlayerStop");
        }
        try {
            MediaPlayer mediaPlayer = f306881c;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                if (QLog.isColorLevel()) {
                    QLog.d("AudioUtil", 2, "[silkPlayer]mediaPlayerStop,mediaPalyer.release()");
                }
            }
        } catch (Exception unused) {
        }
        f306881c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(MediaPlayer mediaPlayer) {
        if (mediaPlayer == null) {
            return;
        }
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.reset();
            mediaPlayer.setOnPreparedListener(new d());
            mediaPlayer.prepareAsync();
        } catch (Exception e16) {
            QLog.e("AudioUtil", 1, "mediaplayer error: " + Arrays.toString(e16.getStackTrace()));
        }
    }

    private static void u(MediaPlayer mediaPlayer) {
        v(mediaPlayer, false);
    }

    private static void v(MediaPlayer mediaPlayer, boolean z16) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof BaseQQAppInterface) {
            if (z16) {
                mediaPlayer.setAudioAttributes(Notification.AUDIO_ATTRIBUTES_DEFAULT);
                return;
            } else {
                mediaPlayer.setAudioStreamType(3);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("MediaPlayerStart", 2, "get QQAppInterface error");
        }
    }

    public static synchronized void w(String str, boolean z16, boolean z17) {
        synchronized (AudioUtil.class) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    MediaPlayer mediaPlayer = f306881c;
                    if (mediaPlayer != null) {
                        if (mediaPlayer.isPlaying()) {
                            return;
                        }
                        try {
                            f306881c.release();
                        } catch (Exception unused) {
                        } catch (Throwable th5) {
                            f306881c = null;
                            throw th5;
                        }
                        f306881c = null;
                    }
                    if (f306881c == null) {
                        f306881c = new ReportMediaPlayer();
                    }
                    f306881c.reset();
                    FileInputStream fileInputStream2 = new FileInputStream(str);
                    try {
                        f306881c.setDataSource(fileInputStream2.getFD());
                        v(f306881c, z17);
                        f306881c.prepare();
                        f306881c.setOnCompletionListener(new a());
                        f306881c.start();
                        f306881c.setLooping(z16);
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.e("AudioUtil", 2, "specialSoundStart: failed. ", e);
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e17) {
                                e = e17;
                                e.printStackTrace();
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    try {
                        fileInputStream2.close();
                    } catch (IOException e19) {
                        e = e19;
                        e.printStackTrace();
                    }
                } catch (Exception e26) {
                    e = e26;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        if (r4 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0044, code lost:
    
        if (r4 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String x(byte[] bArr, int i3, int i16) {
        ByteArrayInputStream byteArrayInputStream;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        try {
            byte[] bArr2 = new byte[i16 + 2];
            bArr2[0] = (byte) (i16 >> 8);
            bArr2[1] = (byte) i16;
            System.arraycopy(bArr, i3, bArr2, 2, i16);
            byteArrayInputStream = new ByteArrayInputStream(bArr2);
            try {
                dataInputStream = new DataInputStream(byteArrayInputStream);
            } catch (IOException unused) {
            } catch (Exception unused2) {
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (IOException unused3) {
            byteArrayInputStream = null;
        } catch (Exception unused4) {
            byteArrayInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            byteArrayInputStream = null;
        }
        try {
            String readUTF = dataInputStream.readUTF();
            try {
                dataInputStream.close();
            } catch (IOException unused5) {
            }
            try {
                byteArrayInputStream.close();
            } catch (IOException unused6) {
                return readUTF;
            }
        } catch (IOException unused7) {
            dataInputStream2 = dataInputStream;
            if (dataInputStream2 != null) {
                try {
                    dataInputStream2.close();
                } catch (IOException unused8) {
                }
            }
        } catch (Exception unused9) {
            dataInputStream2 = dataInputStream;
            if (dataInputStream2 != null) {
                try {
                    dataInputStream2.close();
                } catch (IOException unused10) {
                }
            }
        } catch (Throwable th7) {
            th = th7;
            dataInputStream2 = dataInputStream;
            if (dataInputStream2 != null) {
                try {
                    dataInputStream2.close();
                } catch (IOException unused11) {
                }
            }
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                    throw th;
                } catch (IOException unused12) {
                    throw th;
                }
            }
            throw th;
        }
    }
}
