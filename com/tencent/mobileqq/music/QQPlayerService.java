package com.tencent.mobileqq.music;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mediafocus.b;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.music.e;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.bu;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.util.VersionUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppService;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@SuppressLint({"NewApi"})
/* loaded from: classes15.dex */
public class QQPlayerService extends AppService implements MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {
    static IPatchRedirector $redirector_;
    private static int N;
    private static int P;
    private static int Q;
    private static SongInfo[] R;
    private static SongInfo S;
    private static int T;
    private static WeakReference<com.tencent.mobileqq.music.g> U;
    private static WeakReference<com.tencent.mobileqq.music.g> V;
    private static String W;
    private static Map<String, WeakReference<com.tencent.mobileqq.music.g>> X;
    private static Intent Y;
    private static Bundle Z;

    /* renamed from: a0, reason: collision with root package name */
    public static long f251835a0;

    /* renamed from: b0, reason: collision with root package name */
    public static long f251836b0;

    /* renamed from: c0, reason: collision with root package name */
    private static MediaPlayer f251837c0;

    /* renamed from: d0, reason: collision with root package name */
    private static int f251838d0;

    /* renamed from: e0, reason: collision with root package name */
    private static boolean f251839e0;

    /* renamed from: f0, reason: collision with root package name */
    static SparseArray<Boolean> f251840f0;

    /* renamed from: g0, reason: collision with root package name */
    private static boolean f251841g0;

    /* renamed from: h0, reason: collision with root package name */
    private static i f251842h0;

    /* renamed from: i0, reason: collision with root package name */
    private static b.c f251843i0;
    public boolean C;
    private Handler D;
    private volatile Looper E;
    private volatile g F;
    private volatile boolean G;
    private volatile boolean H;
    private HandlerThread I;
    private RemoteCallbackList<com.tencent.mobileqq.music.c> J;
    private d K;
    private boolean L;
    private e.a M;

    /* renamed from: d, reason: collision with root package name */
    private Object f251844d;

    /* renamed from: e, reason: collision with root package name */
    public long f251845e;

    /* renamed from: f, reason: collision with root package name */
    public DownloadThread f251846f;

    /* renamed from: h, reason: collision with root package name */
    public float f251847h;

    /* renamed from: i, reason: collision with root package name */
    private int f251848i;

    /* renamed from: m, reason: collision with root package name */
    private e f251849m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class DownloadThread extends BaseThread {
        static IPatchRedirector $redirector_;
        public String C;
        public String D;
        public volatile boolean E;
        public volatile boolean F;
        private int G;
        public int H;
        public int I;
        public volatile boolean J;
        public volatile boolean K;
        private ConcurrentHashMap<String, String> L;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes15.dex */
        public class a implements sd2.a {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadThread.this);
                }
            }

            @Override // sd2.a
            public void onFail(@NonNull String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                } else {
                    QLog.d("QQPlayerService", 1, "get pskey fail");
                }
            }

            @Override // sd2.a
            public void onSuccess(@NonNull Map<String, String> map) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) map);
                    return;
                }
                QLog.d("QQPlayerService", 1, "get pskey success size:" + map.size());
                DownloadThread.this.L.putAll(map);
            }
        }

        public DownloadThread(String str, String str2, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQPlayerService.this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.E = false;
            this.F = false;
            this.J = false;
            this.K = true;
            this.L = new ConcurrentHashMap<>(10);
            setName("QQPlayerService-DownloadThread");
            this.C = str;
            this.D = str2;
            this.G = i16;
            this.I = i16;
            this.H = i3;
        }

        private File d(String str) {
            String str2 = AppConstants.SDCARD_MUSIC;
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str2 + str);
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQPlayerService", 2, "createNewFile:" + e16.getMessage(), e16);
                    }
                }
            }
            return file2;
        }

        private void o() {
            ((IPskeyManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{"y.qq.com"}, new a());
        }

        /* JADX WARN: Code restructure failed: missing block: B:249:0x04ed, code lost:
        
            if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L229;
         */
        /* JADX WARN: Code restructure failed: missing block: B:250:0x04ef, code lost:
        
            com.tencent.qphone.base.util.QLog.d("QQPlayerService", 2, "<======== DownloadThread download over,downloadPosition:" + r24.H + ",readWaitTimes:" + r6 + ",fileSize:" + r24.I + ",preileSize:" + r24.G);
         */
        /* JADX WARN: Code restructure failed: missing block: B:251:0x0520, code lost:
        
            if (r2 == null) goto L231;
         */
        /* JADX WARN: Code restructure failed: missing block: B:252:0x0522, code lost:
        
            r2.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:253:0x0525, code lost:
        
            r2 = r24.H;
            r3 = r24.I;
         */
        /* JADX WARN: Code restructure failed: missing block: B:254:0x0529, code lost:
        
            if (r2 != r3) goto L235;
         */
        /* JADX WARN: Code restructure failed: missing block: B:255:0x052b, code lost:
        
            if (r3 <= 0) goto L235;
         */
        /* JADX WARN: Code restructure failed: missing block: B:256:0x052d, code lost:
        
            com.tencent.mobileqq.utils.bu.c(r24.D);
         */
        /* JADX WARN: Code restructure failed: missing block: B:257:0x0532, code lost:
        
            r24.J = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:259:0x0535, code lost:
        
            r10.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:262:0x053e, code lost:
        
            if (r3 > 0) goto L344;
         */
        /* JADX WARN: Code restructure failed: missing block: B:263:0x0703, code lost:
        
            com.tencent.mobileqq.utils.bu.f(r24.D, r2, r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:322:0x0686, code lost:
        
            if (r3 > 0) goto L344;
         */
        /* JADX WARN: Code restructure failed: missing block: B:368:0x0701, code lost:
        
            if (r3 > 0) goto L344;
         */
        /* JADX WARN: Code restructure failed: missing block: B:382:0x05e6, code lost:
        
            if (r3 > 0) goto L344;
         */
        /* JADX WARN: Code restructure failed: missing block: B:396:0x06c4, code lost:
        
            if (r3 > 0) goto L344;
         */
        /* JADX WARN: Code restructure failed: missing block: B:411:0x05a8, code lost:
        
            if (r3 > 0) goto L344;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:157:0x0730  */
        /* JADX WARN: Removed duplicated region for block: B:161:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:162:0x0727 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:266:0x070c  */
        /* JADX WARN: Removed duplicated region for block: B:269:0x0718  */
        /* JADX WARN: Removed duplicated region for block: B:271:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:295:0x05f5 A[Catch: all -> 0x0720, TryCatch #0 {all -> 0x0720, blocks: (B:293:0x05ef, B:295:0x05f5, B:296:0x060f, B:298:0x0615, B:300:0x061d, B:302:0x0625, B:303:0x0635, B:305:0x063b, B:308:0x0647, B:310:0x0654, B:312:0x065a, B:314:0x0662, B:316:0x0668, B:317:0x066f, B:403:0x0571, B:405:0x0577, B:406:0x0591, B:375:0x05af, B:377:0x05be, B:389:0x068d, B:391:0x069c, B:360:0x06ca, B:362:0x06d0, B:363:0x06ea), top: B:18:0x0048 }] */
        /* JADX WARN: Removed duplicated region for block: B:298:0x0615 A[Catch: all -> 0x0720, TryCatch #0 {all -> 0x0720, blocks: (B:293:0x05ef, B:295:0x05f5, B:296:0x060f, B:298:0x0615, B:300:0x061d, B:302:0x0625, B:303:0x0635, B:305:0x063b, B:308:0x0647, B:310:0x0654, B:312:0x065a, B:314:0x0662, B:316:0x0668, B:317:0x066f, B:403:0x0571, B:405:0x0577, B:406:0x0591, B:375:0x05af, B:377:0x05be, B:389:0x068d, B:391:0x069c, B:360:0x06ca, B:362:0x06d0, B:363:0x06ea), top: B:18:0x0048 }] */
        /* JADX WARN: Removed duplicated region for block: B:316:0x0668 A[Catch: all -> 0x0720, TryCatch #0 {all -> 0x0720, blocks: (B:293:0x05ef, B:295:0x05f5, B:296:0x060f, B:298:0x0615, B:300:0x061d, B:302:0x0625, B:303:0x0635, B:305:0x063b, B:308:0x0647, B:310:0x0654, B:312:0x065a, B:314:0x0662, B:316:0x0668, B:317:0x066f, B:403:0x0571, B:405:0x0577, B:406:0x0591, B:375:0x05af, B:377:0x05be, B:389:0x068d, B:391:0x069c, B:360:0x06ca, B:362:0x06d0, B:363:0x06ea), top: B:18:0x0048 }] */
        /* JADX WARN: Removed duplicated region for block: B:322:0x0686  */
        /* JADX WARN: Removed duplicated region for block: B:323:0x067d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x022d A[Catch: all -> 0x0542, IOException -> 0x0547, Exception -> 0x054f, IllegalStateException -> 0x0553, MalformedURLException -> 0x055e, FileNotFoundException -> 0x0563, TryCatch #11 {IOException -> 0x0547, blocks: (B:288:0x0139, B:290:0x013d, B:63:0x0167, B:66:0x0174, B:68:0x017a, B:70:0x0188, B:72:0x018e, B:74:0x01c8, B:75:0x01e7, B:76:0x0222, B:78:0x022d, B:80:0x0241, B:84:0x0264, B:101:0x02cb, B:103:0x02d1, B:104:0x02d8, B:117:0x02f1, B:119:0x02f5, B:120:0x02f6, B:123:0x02fe, B:125:0x0304, B:128:0x0326, B:130:0x0329, B:132:0x0341, B:134:0x0347, B:135:0x034e, B:148:0x0367, B:166:0x036e, B:169:0x037e, B:170:0x03a6, B:172:0x03b8, B:173:0x03c1, B:175:0x03c7, B:178:0x03e8, B:180:0x03ec, B:184:0x03f6, B:232:0x03fc, B:234:0x0402, B:186:0x041a, B:188:0x041e, B:191:0x042a, B:193:0x0439, B:195:0x0458, B:196:0x047f, B:198:0x0487, B:201:0x0495, B:205:0x049d, B:207:0x04a3, B:209:0x04a9, B:211:0x04b0, B:217:0x04b6, B:219:0x04bc, B:214:0x04d6, B:223:0x04da, B:226:0x04e0, B:248:0x04e9, B:250:0x04ef, B:252:0x0522, B:253:0x0525, B:256:0x052d, B:88:0x0288, B:94:0x028e, B:96:0x0294, B:276:0x01ee, B:279:0x01fa, B:283:0x0200, B:285:0x0206), top: B:287:0x0139 }] */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0264 A[Catch: all -> 0x0542, IOException -> 0x0547, Exception -> 0x054f, IllegalStateException -> 0x0553, MalformedURLException -> 0x055e, FileNotFoundException -> 0x0563, TRY_LEAVE, TryCatch #11 {IOException -> 0x0547, blocks: (B:288:0x0139, B:290:0x013d, B:63:0x0167, B:66:0x0174, B:68:0x017a, B:70:0x0188, B:72:0x018e, B:74:0x01c8, B:75:0x01e7, B:76:0x0222, B:78:0x022d, B:80:0x0241, B:84:0x0264, B:101:0x02cb, B:103:0x02d1, B:104:0x02d8, B:117:0x02f1, B:119:0x02f5, B:120:0x02f6, B:123:0x02fe, B:125:0x0304, B:128:0x0326, B:130:0x0329, B:132:0x0341, B:134:0x0347, B:135:0x034e, B:148:0x0367, B:166:0x036e, B:169:0x037e, B:170:0x03a6, B:172:0x03b8, B:173:0x03c1, B:175:0x03c7, B:178:0x03e8, B:180:0x03ec, B:184:0x03f6, B:232:0x03fc, B:234:0x0402, B:186:0x041a, B:188:0x041e, B:191:0x042a, B:193:0x0439, B:195:0x0458, B:196:0x047f, B:198:0x0487, B:201:0x0495, B:205:0x049d, B:207:0x04a3, B:209:0x04a9, B:211:0x04b0, B:217:0x04b6, B:219:0x04bc, B:214:0x04d6, B:223:0x04da, B:226:0x04e0, B:248:0x04e9, B:250:0x04ef, B:252:0x0522, B:253:0x0525, B:256:0x052d, B:88:0x0288, B:94:0x028e, B:96:0x0294, B:276:0x01ee, B:279:0x01fa, B:283:0x0200, B:285:0x0206), top: B:287:0x0139 }] */
        /* JADX WARN: Type inference failed for: r8v11 */
        /* JADX WARN: Type inference failed for: r8v78 */
        /* JADX WARN: Type inference failed for: r8v85 */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Throwable th5;
            boolean z16;
            RandomAccessFile randomAccessFile;
            Exception exc;
            RandomAccessFile randomAccessFile2;
            MalformedURLException malformedURLException;
            RandomAccessFile randomAccessFile3;
            IllegalStateException illegalStateException;
            RandomAccessFile randomAccessFile4;
            String str;
            IOException iOException;
            RandomAccessFile randomAccessFile5;
            FileNotFoundException fileNotFoundException;
            RandomAccessFile randomAccessFile6;
            int i3;
            int i16;
            ?? r85;
            SongInfo songInfo;
            int i17;
            int i18;
            RandomAccessFile randomAccessFile7;
            String insertMtype;
            URL url;
            SongInfo songInfo2;
            File file;
            boolean z17;
            HttpURLConnection httpURLConnection;
            int i19;
            int i26;
            String host;
            String str2;
            long j3;
            String str3 = "qzonevipmusic://";
            String str4 = "y.qq.com";
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long[] U = ah.U();
            if (U != null) {
                j3 = U[1];
                if (j3 <= 2) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQPlayerService", 2, "DownloadThread.run():available space on SD card is less than 2M. ====> Stop play.");
                    }
                    QQPlayerService.m1(QQPlayerService.this.getApplicationContext());
                    return;
                }
            }
            File d16 = d(this.D);
            this.J = true;
            try {
                try {
                    randomAccessFile7 = new RandomAccessFile(d16.getPath(), "rw");
                    try {
                        try {
                            try {
                                insertMtype = MsfSdkUtils.insertMtype("music", this.C);
                                url = new URL(insertMtype);
                                songInfo2 = QQPlayerService.S;
                            } catch (FileNotFoundException e16) {
                                fileNotFoundException = e16;
                                randomAccessFile6 = randomAccessFile7;
                                if (QLog.isColorLevel()) {
                                    QLog.d("QQPlayerService", 2, "DownloadThread,FileNotFoundException:" + fileNotFoundException.getMessage(), fileNotFoundException);
                                }
                                QQPlayerService.m1(QQPlayerService.this.getApplicationContext());
                                this.J = false;
                                if (randomAccessFile6 != null) {
                                    try {
                                        randomAccessFile6.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                i3 = this.H;
                                i16 = this.I;
                                if (i3 < i16) {
                                }
                                if (this.F) {
                                }
                                this.F = false;
                                if (QLog.isColorLevel()) {
                                }
                            } catch (IllegalStateException e17) {
                                illegalStateException = e17;
                                randomAccessFile4 = randomAccessFile7;
                                QQPlayerService.m1(QQPlayerService.this.getApplicationContext());
                                if (QLog.isColorLevel()) {
                                    QLog.d("QQPlayerService", 2, "DownloadThread,IllegalStateException:" + illegalStateException.getMessage(), illegalStateException);
                                }
                                this.J = false;
                                if (randomAccessFile4 != null) {
                                    try {
                                        randomAccessFile4.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                i3 = this.H;
                                i16 = this.I;
                                if (i3 < i16) {
                                }
                                if (this.F) {
                                }
                                this.F = false;
                                if (QLog.isColorLevel()) {
                                }
                            } catch (MalformedURLException e18) {
                                malformedURLException = e18;
                                randomAccessFile3 = randomAccessFile7;
                                QQPlayerService.m1(QQPlayerService.this.getApplicationContext());
                                if (QLog.isColorLevel()) {
                                    QLog.d("QQPlayerService", 2, "DownloadThread,MalformedURLException:" + malformedURLException.getMessage(), malformedURLException);
                                }
                                this.J = false;
                                if (randomAccessFile3 != null) {
                                    try {
                                        randomAccessFile3.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                i3 = this.H;
                                i16 = this.I;
                                if (i3 < i16) {
                                }
                                if (this.F) {
                                }
                                this.F = false;
                                if (QLog.isColorLevel()) {
                                }
                            } catch (Exception e19) {
                                exc = e19;
                                randomAccessFile2 = randomAccessFile7;
                                if (QLog.isColorLevel()) {
                                    QLog.d("QQPlayerService", 2, "DownloadThread,Exception:" + exc.getMessage(), exc);
                                }
                                QQPlayerService.m1(QQPlayerService.this.getApplicationContext());
                                this.J = false;
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (IOException unused4) {
                                    }
                                }
                                i3 = this.H;
                                i16 = this.I;
                                if (i3 < i16) {
                                }
                                if (this.F) {
                                }
                                this.F = false;
                                if (QLog.isColorLevel()) {
                                }
                            }
                        } catch (Throwable th6) {
                            th5 = th6;
                            z16 = false;
                        }
                    } catch (IOException e26) {
                        e = e26;
                        str = str3;
                    }
                } catch (FileNotFoundException e27) {
                    fileNotFoundException = e27;
                    randomAccessFile6 = null;
                } catch (IOException e28) {
                    str = "qzonevipmusic://";
                    iOException = e28;
                    randomAccessFile5 = null;
                } catch (IllegalStateException e29) {
                    illegalStateException = e29;
                    randomAccessFile4 = null;
                } catch (MalformedURLException e36) {
                    malformedURLException = e36;
                    randomAccessFile3 = null;
                } catch (Exception e37) {
                    exc = e37;
                    randomAccessFile2 = null;
                } catch (Throwable th7) {
                    th5 = th7;
                    z16 = false;
                    randomAccessFile = null;
                }
                try {
                    if (songInfo2 == null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("QQPlayerService", 2, "current song is null");
                        }
                        this.J = false;
                        try {
                            randomAccessFile7.close();
                        } catch (IOException unused5) {
                        }
                        int i27 = this.H;
                        int i28 = this.I;
                        if (i27 >= i28 || i28 <= 0) {
                            return;
                        }
                        bu.f(this.D, i27, i28);
                        return;
                    }
                    String str5 = songInfo2.f251870h;
                    boolean equals = (TextUtils.isEmpty(str5) || !str5.startsWith("qzonevipmusic://")) ? false : this.C.equals(QQPlayerService.this.W(str5));
                    if ((songInfo2.f251870h.equals(this.C) || equals) && this.K) {
                        if (this.H > this.I * QQPlayerService.this.f251847h) {
                            if (QLog.isColorLevel()) {
                                QLog.d("QQPlayerService", 2, "DownloadThread.run(): downloadPosition > beginPlayPosition,start to play");
                            }
                            QQPlayerService.f251837c0.reset();
                            QQPlayerService.f251837c0.setDataSource(d16.getAbsolutePath());
                            QQPlayerService.f251837c0.prepare();
                            QQPlayerService.f251837c0.start();
                            QQPlayerService.this.T(2);
                            this.K = false;
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("QQPlayerService", 2, "DownloadThread.run(): downloadPosition < beginPlayPosition, enter buffering\uff01\uff01\uff01");
                            }
                            QQPlayerService.this.T(1);
                        }
                    }
                    o();
                    int i29 = 0;
                    int i36 = 0;
                    HttpURLConnection httpURLConnection2 = null;
                    while (true) {
                        if (i29 > 0) {
                            file = d16;
                            z17 = equals;
                            httpURLConnection = httpURLConnection2;
                            break;
                        }
                        httpURLConnection = httpURLConnection2;
                        if (i36 > 5) {
                            file = d16;
                            z17 = equals;
                            break;
                        }
                        try {
                            httpURLConnection2 = (HttpURLConnection) url.openConnection();
                            i26 = i29;
                        } catch (Throwable th8) {
                            th5 = th8;
                            r85 = randomAccessFile7;
                            z16 = false;
                            randomAccessFile = r85;
                            this.J = z16;
                            if (randomAccessFile != null) {
                            }
                            i17 = this.H;
                            i18 = this.I;
                            if (i17 >= i18) {
                            }
                        }
                        try {
                            httpURLConnection2.setInstanceFollowRedirects(false);
                            httpURLConnection2.setRequestProperty("Accept-Encoding", "identity");
                            int i37 = this.G;
                            str = str3;
                            if (i37 != 0) {
                                try {
                                    if (i37 > this.H) {
                                        StringBuilder sb5 = new StringBuilder();
                                        file = d16;
                                        sb5.append("bytes=");
                                        sb5.append(this.H);
                                        sb5.append("-");
                                        sb5.append(this.G);
                                        httpURLConnection2.setRequestProperty("Range", sb5.toString());
                                        host = url.getHost();
                                        if (TextUtils.isEmpty(host) && host.contains(str4)) {
                                            String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
                                            ConcurrentHashMap<String, String> concurrentHashMap = this.L;
                                            if (concurrentHashMap != null && concurrentHashMap.get(str4) != null) {
                                                z17 = equals;
                                                QLog.i("QQPlayerService", 1, "getPsKey immediately returned.");
                                                String str6 = this.L.get(str4);
                                                StringBuilder sb6 = new StringBuilder();
                                                str2 = str4;
                                                sb6.append("p_skey=");
                                                sb6.append(str6);
                                                sb6.append("; p_uin=");
                                                sb6.append(account);
                                                sb6.append(";");
                                                String sb7 = sb6.toString();
                                                if (QLog.isColorLevel()) {
                                                    QLog.e("QQPlayerService", 1, "url:" + insertMtype + " cookie:" + sb7);
                                                }
                                                httpURLConnection2.setRequestProperty("Cookie", sb7);
                                            } else {
                                                str2 = str4;
                                                z17 = equals;
                                                QZLog.w("QQPlayerService", "getPsKey didn't immediately return.");
                                                i36++;
                                                try {
                                                    LockMethodProxy.sleep(500L);
                                                } catch (InterruptedException e38) {
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("QQPlayerService", 2, "DownloadThread: open HttpURLConnection:" + e38.getMessage(), e38);
                                                    }
                                                }
                                                i29 = i26;
                                                str3 = str;
                                                d16 = file;
                                                equals = z17;
                                                str4 = str2;
                                            }
                                        } else {
                                            str2 = str4;
                                            z17 = equals;
                                        }
                                        httpURLConnection2.connect();
                                        if (httpURLConnection2.getResponseCode() != 302) {
                                            i36++;
                                            url = new URL(httpURLConnection2.getHeaderField("Location"));
                                            if (QLog.isColorLevel()) {
                                                QLog.e("QQPlayerService", 1, "tempUrl:" + url);
                                            }
                                            i29 = i26;
                                            str3 = str;
                                            d16 = file;
                                            equals = z17;
                                            str4 = str2;
                                        } else {
                                            QLog.i("QQPlayerService", 1, "conn.getResponseCode():" + httpURLConnection2.getResponseCode());
                                            int contentLength = httpURLConnection2.getContentLength();
                                            if (contentLength > 0) {
                                                i19 = contentLength;
                                                break;
                                            }
                                            i36++;
                                            try {
                                                LockMethodProxy.sleep(500L);
                                            } catch (InterruptedException e39) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("QQPlayerService", 2, "DownloadThread: open HttpURLConnection:" + e39.getMessage(), e39);
                                                }
                                            }
                                            i29 = contentLength;
                                            str3 = str;
                                            d16 = file;
                                            equals = z17;
                                            str4 = str2;
                                        }
                                    }
                                } catch (IOException e46) {
                                    e = e46;
                                    iOException = e;
                                    randomAccessFile5 = randomAccessFile7;
                                    if (QLog.isColorLevel()) {
                                        QLog.d("QQPlayerService", 2, "DownloadThread, IOException:" + iOException.getMessage(), iOException);
                                    }
                                    songInfo = QQPlayerService.S;
                                    if (songInfo != null) {
                                        String str7 = songInfo.f251870h;
                                        boolean equals2 = (TextUtils.isEmpty(str7) || !str7.startsWith(str)) ? false : this.C.equals(QQPlayerService.this.W(songInfo.f251870h));
                                        if (QQPlayerService.f251837c0 != null && (this.C.equals(songInfo.f251870h) || equals2)) {
                                            QQPlayerService.f251837c0.reset();
                                            QQPlayerService.this.T(6);
                                        }
                                    }
                                    if (QQPlayerService.R != null && QQPlayerService.R.length == 1) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("QQPlayerService", 2, "DownloadThread, IOException happens, songlist num=1, stop music");
                                        }
                                        QQPlayerService.m1(QQPlayerService.this.getApplicationContext());
                                    }
                                    this.J = false;
                                    if (randomAccessFile5 != null) {
                                        try {
                                            randomAccessFile5.close();
                                        } catch (IOException unused6) {
                                        }
                                    }
                                    i3 = this.H;
                                    i16 = this.I;
                                    if (i3 < i16) {
                                    }
                                    if (this.F) {
                                        bu.a();
                                    }
                                    this.F = false;
                                    if (QLog.isColorLevel()) {
                                        QLog.d("QQPlayerService", 2, "===> DownloadThread run over <===");
                                        return;
                                    }
                                    return;
                                }
                            }
                            file = d16;
                            host = url.getHost();
                            if (TextUtils.isEmpty(host)) {
                            }
                            str2 = str4;
                            z17 = equals;
                            httpURLConnection2.connect();
                            if (httpURLConnection2.getResponseCode() != 302) {
                            }
                        } catch (Throwable th9) {
                            th5 = th9;
                            randomAccessFile = randomAccessFile7;
                            z16 = false;
                            this.J = z16;
                            if (randomAccessFile != null) {
                            }
                            i17 = this.H;
                            i18 = this.I;
                            if (i17 >= i18) {
                            }
                        }
                    }
                    httpURLConnection2 = httpURLConnection;
                    i19 = i29;
                    if (i19 <= 0) {
                        if (QLog.isColorLevel()) {
                            QLog.e("QQPlayerService", 2, "afrer 5 times retry, DownloadThread open HttpURLConnection still failure. contentLen < 0");
                        }
                        QQPlayerService.this.T(7);
                        this.J = false;
                        try {
                            randomAccessFile7.close();
                        } catch (IOException unused7) {
                        }
                        int i38 = this.H;
                        int i39 = this.I;
                        if (i38 >= i39 || i39 <= 0) {
                            return;
                        }
                        bu.f(this.D, i38, i39);
                        return;
                    }
                    int i46 = this.H;
                    if (i46 > 0) {
                        i19 += i46;
                    }
                    this.I = i19;
                    int i47 = this.G;
                    if (i47 != 0 && i47 != i19) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQPlayerService", 2, "mediaFile filesize if change,preileSize:" + this.G + ",newfileSize:" + i19);
                        }
                        z16 = false;
                        try {
                            this.H = 0;
                            this.K = true;
                            httpURLConnection2 = (HttpURLConnection) url.openConnection();
                            httpURLConnection2.setInstanceFollowRedirects(true);
                            httpURLConnection2.setRequestProperty("Accept-Encoding", "identity");
                            httpURLConnection2.connect();
                            i19 = httpURLConnection2.getContentLength();
                            if (i19 < 0) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("QQPlayerService", 2, "DownloadThread run,contentLen < 0, 2");
                                }
                                QQPlayerService.this.T(7);
                                this.J = false;
                                try {
                                    randomAccessFile7.close();
                                } catch (IOException unused8) {
                                }
                                int i48 = this.H;
                                int i49 = this.I;
                                if (i48 >= i49 || i49 <= 0) {
                                    return;
                                }
                                bu.f(this.D, i48, i49);
                                return;
                            }
                            this.I = i19;
                        } catch (Throwable th10) {
                            th5 = th10;
                            randomAccessFile = randomAccessFile7;
                            this.J = z16;
                            if (randomAccessFile != null) {
                            }
                            i17 = this.H;
                            i18 = this.I;
                            if (i17 >= i18) {
                            }
                        }
                    }
                    randomAccessFile7.setLength(i19);
                    if (QLog.isColorLevel()) {
                        QLog.d("QQPlayerService", 2, "DownloadThread run,downloadPosition:" + this.H + ",preileSize:" + this.G + ",fileSize:" + this.I);
                    }
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    byte[] bArr = new byte[8192];
                    randomAccessFile7.seek(this.H);
                    if (this.G == 0) {
                        bu.f(this.D, this.H, this.I);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QQPlayerService", 2, "========> DownloadThread download begin, downloadPosition:" + this.H + ",fileSize:" + this.I);
                    }
                    loop1: while (true) {
                        int i56 = 0;
                        while (!this.E && this.H < this.I && i56 < 10) {
                            SongInfo songInfo3 = QQPlayerService.S;
                            if (songInfo3 == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("QQPlayerService", 2, "current song is null");
                                }
                                this.J = false;
                                try {
                                    randomAccessFile7.close();
                                } catch (IOException unused9) {
                                }
                                int i57 = this.H;
                                int i58 = this.I;
                                if (i57 >= i58 || i58 <= 0) {
                                    return;
                                }
                                bu.f(this.D, i57, i58);
                                return;
                            }
                            if (this.K && ((songInfo3.f251870h.equals(this.C) || z17) && this.H > this.I * QQPlayerService.this.f251847h)) {
                                QQPlayerService.f251837c0.reset();
                                QQPlayerService.f251837c0.setDataSource(file.getAbsolutePath());
                                QQPlayerService.f251837c0.prepare();
                                if (QLog.isColorLevel()) {
                                    QLog.d("QQPlayerService", 2, "DownloadThread run,downloadPosition=" + this.H + ">200k,mUserPause=" + QQPlayerService.this.H);
                                }
                                if (!QQPlayerService.this.H) {
                                    QQPlayerService.f251837c0.start();
                                    QQPlayerService.this.T(2);
                                }
                                try {
                                    this.K = false;
                                } catch (Throwable th11) {
                                    th5 = th11;
                                    z16 = false;
                                    randomAccessFile = randomAccessFile7;
                                    this.J = z16;
                                    if (randomAccessFile != null) {
                                    }
                                    i17 = this.H;
                                    i18 = this.I;
                                    if (i17 >= i18) {
                                    }
                                }
                            }
                            int read = inputStream.read(bArr);
                            if (read <= 0) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("QQPlayerService", 2, "DownloadThread run,readLen <= 0, sleep 500ms for retry");
                                }
                                try {
                                    LockMethodProxy.sleep(500L);
                                } catch (InterruptedException e47) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("QQPlayerService", 2, "DownloadThread:" + e47.getMessage(), e47);
                                    }
                                }
                                i56++;
                            } else {
                                this.H += read;
                                try {
                                    randomAccessFile7.write(bArr, 0, read);
                                } catch (Throwable th12) {
                                    th5 = th12;
                                    z16 = false;
                                    randomAccessFile = randomAccessFile7;
                                    this.J = z16;
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException unused10) {
                                        }
                                    }
                                    i17 = this.H;
                                    i18 = this.I;
                                    if (i17 >= i18) {
                                        throw th5;
                                    }
                                    if (i18 > 0) {
                                        bu.f(this.D, i17, i18);
                                        throw th5;
                                    }
                                    throw th5;
                                }
                            }
                        }
                    }
                } catch (IOException e48) {
                    str = "qzonevipmusic://";
                    randomAccessFile5 = randomAccessFile7;
                    iOException = e48;
                    if (QLog.isColorLevel()) {
                    }
                    songInfo = QQPlayerService.S;
                    if (songInfo != null) {
                    }
                    if (QQPlayerService.R != null) {
                        if (QLog.isColorLevel()) {
                        }
                        QQPlayerService.m1(QQPlayerService.this.getApplicationContext());
                    }
                    this.J = false;
                    if (randomAccessFile5 != null) {
                    }
                    i3 = this.H;
                    i16 = this.I;
                    if (i3 < i16) {
                    }
                    if (this.F) {
                    }
                    this.F = false;
                    if (QLog.isColorLevel()) {
                    }
                }
            } catch (Throwable th13) {
                th5 = th13;
                r85 = j3;
            }
            i3 = this.H;
            i16 = this.I;
            if (i3 < i16) {
            }
            if (this.F) {
            }
            this.F = false;
            if (QLog.isColorLevel()) {
            }
        }
    }

    /* loaded from: classes15.dex */
    class a extends e.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQPlayerService.this);
            }
        }

        @Override // com.tencent.mobileqq.music.e
        public SongInfo[] B2() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (SongInfo[]) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : getPlayList");
            }
            return QQPlayerService.j0();
        }

        @Override // com.tencent.mobileqq.music.e
        public void C4(com.tencent.mobileqq.music.c cVar) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, (Object) this, (Object) cVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : registerCallback");
            }
            if (cVar == null) {
                return;
            }
            if (QQPlayerService.this.J == null) {
                synchronized (this) {
                    if (QQPlayerService.this.J == null) {
                        QQPlayerService.this.J = new RemoteCallbackList();
                    }
                }
            }
            QQPlayerService.this.J.register(cVar);
        }

        @Override // com.tencent.mobileqq.music.e
        public Intent N0() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (Intent) iPatchRedirector.redirect((short) 20, (Object) this);
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : getPlayBarIntent ");
            }
            return QQPlayerService.i0();
        }

        @Override // com.tencent.mobileqq.music.e
        public int O() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return QQPlayerService.k0();
        }

        @Override // com.tencent.mobileqq.music.e
        public String T4(int i3, String str) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (String) iPatchRedirector.redirect((short) 24, (Object) this, i3, (Object) str);
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : generateToken : callerType=" + i3 + ",id=" + str);
            }
            return QQPlayerService.Y(i3, str);
        }

        @Override // com.tencent.mobileqq.music.e
        public int X2() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return QQPlayerService.l0();
        }

        @Override // com.tencent.mobileqq.music.e
        public void X3(com.tencent.mobileqq.music.c cVar) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                iPatchRedirector.redirect((short) 22, (Object) this, (Object) cVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : unRegisterCallback");
            }
            if (cVar != null && QQPlayerService.this.J != null) {
                QQPlayerService.this.J.unregister(cVar);
            }
        }

        @Override // com.tencent.mobileqq.music.e
        public void b2(String str, SongInfo[] songInfoArr, int i3) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, songInfoArr, Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : startPlay sCallback = " + QQPlayerService.V + ",startIndex" + i3);
            }
            if (QQPlayerService.V != null) {
                QQPlayerService.U = QQPlayerService.V;
                QQPlayerService.V = null;
            }
            QQPlayerService.j1(QQPlayerService.this, str, songInfoArr, i3);
        }

        @Override // com.tencent.mobileqq.music.e
        public boolean b3(String str) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : isPlayingMySong : token=" + str);
            }
            return QQPlayerService.u0(str);
        }

        @Override // com.tencent.mobileqq.music.e
        public SongInfo getCurrentSong() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (SongInfo) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : getCurrentSong");
            }
            return QQPlayerService.b0();
        }

        @Override // com.tencent.mobileqq.music.e
        public int getCurrentSongPosition() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            return QQPlayerService.d0();
        }

        @Override // com.tencent.mobileqq.music.e
        public int getDuration() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            return QQPlayerService.e0();
        }

        @Override // com.tencent.mobileqq.music.e
        public Bundle getExtras() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return (Bundle) iPatchRedirector.redirect((short) 27, (Object) this);
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : getExtras ");
            }
            return QQPlayerService.f0();
        }

        @Override // com.tencent.mobileqq.music.e
        public int getPlayState() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return QQPlayerService.m0();
        }

        @Override // com.tencent.mobileqq.music.e
        public String getToken() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (String) iPatchRedirector.redirect((short) 25, (Object) this);
            }
            return QQPlayerService.o0();
        }

        @Override // com.tencent.mobileqq.music.e
        public boolean isPlaying() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            return QQPlayerService.s0();
        }

        @Override // com.tencent.mobileqq.music.e
        public void m2(Intent intent) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, (Object) intent);
                return;
            }
            if (intent == null) {
                QLog.d("QQPlayerService", 1, "AIDL : setPlayBarIntent params is null, return");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : setPlayBarIntent: " + intent.toString());
            }
            QQPlayerService.b1(intent);
        }

        @Override // com.tencent.mobileqq.music.e
        public void p0() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : playPrev");
            }
            QQPlayerService.O0(QQPlayerService.this);
        }

        @Override // com.tencent.mobileqq.music.e
        public void pause() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : pause");
            }
            QQPlayerService.K0(QQPlayerService.this);
        }

        @Override // com.tencent.mobileqq.music.e
        public int q4() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
            }
            return QQPlayerService.c0();
        }

        @Override // com.tencent.mobileqq.music.e
        public void r() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : playNext");
            }
            QQPlayerService.N0(QQPlayerService.this);
        }

        @Override // com.tencent.mobileqq.music.e
        public void resume() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : resume");
            }
            QQPlayerService.U0(QQPlayerService.this);
        }

        @Override // com.tencent.mobileqq.music.e
        public void seekTo(int i3) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                iPatchRedirector.redirect((short) 29, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : seekTo " + i3);
            }
            QQPlayerService.Y0(i3);
        }

        @Override // com.tencent.mobileqq.music.e
        public void setExtras(Bundle bundle) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                iPatchRedirector.redirect((short) 26, (Object) this, (Object) bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : setExtras ");
            }
            QQPlayerService.a1(bundle);
        }

        @Override // com.tencent.mobileqq.music.e
        public void setPlayMode(int i3) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                QQPlayerService.c1(i3);
            }
        }

        @Override // com.tencent.mobileqq.music.e
        public void stop() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : stop");
            }
            QQPlayerService.m1(QQPlayerService.this);
        }

        @Override // com.tencent.mobileqq.music.e
        public int w3() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "AIDL : getCurrentPlayPosition");
            }
            return QQPlayerService.a0();
        }

        @Override // com.tencent.mobileqq.music.e
        public SongInfo y0() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (SongInfo) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return QQPlayerService.g0();
        }
    }

    /* loaded from: classes15.dex */
    class b implements b.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.mediafocus.b.c
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 != -2 && i3 != -1) {
                if (i3 == 1) {
                    QQPlayerService.W0(BaseApplication.getContext(), QQPlayerService.f251841g0, true);
                    return;
                }
                return;
            }
            QQPlayerService.m1(BaseApplication.getContext());
        }
    }

    /* loaded from: classes15.dex */
    class c implements AudioManager.OnAudioFocusChangeListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQPlayerService.this);
            }
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQPlayerService.this.H0(i3);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
        }
    }

    /* loaded from: classes15.dex */
    private static class d implements INetInfoHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        long f251861d;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f251861d = 0L;
            }
        }

        private void a(int i3) {
            if (System.currentTimeMillis() - this.f251861d < 500) {
                return;
            }
            this.f251861d = System.currentTimeMillis();
            QQPlayerService.J0(BaseApplication.getContext());
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                a(4);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                a(3);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                a(1);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                a(2);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                a(6);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                a(5);
            }
        }
    }

    /* loaded from: classes15.dex */
    class e extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQPlayerService.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DownloadThread downloadThread;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (QQPlayerService.this.L) {
                if (QLog.isColorLevel()) {
                    QLog.i("QQPlayerService", 2, "received broadcast after service destroy");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "QQPlayerBroadcastReceiverReceiver onReceive,action:" + intent.getAction());
            }
            if (QQAppInterface.QQ_ACTION_LOGOUT.equals(intent.getAction()) || "qqplayer_exit_action".equals(intent.getAction())) {
                if (intent.getBooleanExtra("musicplayer.isDelFileOnDonwloadThreadOver", false) && (downloadThread = QQPlayerService.this.f251846f) != null) {
                    downloadThread.F = true;
                }
                QQPlayerService.m1(QQPlayerService.this.getApplicationContext());
            }
        }
    }

    /* loaded from: classes15.dex */
    private static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        MediaPlayer f251863a;

        /* renamed from: b, reason: collision with root package name */
        Looper f251864b;

        /* renamed from: c, reason: collision with root package name */
        SongInfo f251865c;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public final class g extends Handler {
        static IPatchRedirector $redirector_;

        public g(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQPlayerService.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message.what != 1) {
                QQPlayerService.this.I0((Intent) message.obj);
                return;
            }
            try {
                BaseApplication.getContext().unregisterReceiver(QQPlayerService.this.f251849m);
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQPlayerService", 2, "onDestroy unregisterReceiver exception ");
                }
            }
            f fVar = (f) message.obj;
            if (fVar == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("QQPlayerService", 2, "release player");
            }
            MediaPlayer mediaPlayer = fVar.f251863a;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                if (QQPlayerService.f251837c0 == fVar.f251863a) {
                    QQPlayerService.f251837c0 = null;
                }
            }
            Looper looper = fVar.f251864b;
            if (looper != null) {
                looper.quit();
            }
            if (QQPlayerService.S == fVar.f251865c) {
                QQPlayerService.S = null;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32691);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        N = 0;
        P = 103;
        Q = 0;
        T = -1;
        X = new HashMap();
        f251835a0 = 0L;
        f251836b0 = 0L;
        f251838d0 = 0;
        f251839e0 = false;
        f251840f0 = new SparseArray<>();
        f251841g0 = true;
        f251842h0 = new i();
        f251840f0.put(10, Boolean.TRUE);
        f251839e0 = j.a();
        try {
            Iterator<Class<? extends com.tencent.mobileqq.music.d>> it = h.f251882a.iterator();
            while (it.hasNext()) {
                f251842h0.d(it.next().newInstance());
            }
        } catch (Exception e16) {
            QLog.e("QQPlayerService", 1, "[static] ", e16);
        }
        f251843i0 = new b();
    }

    public QQPlayerService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f251845e = 500L;
        this.f251846f = null;
        this.f251847h = 0.3f;
        this.f251848i = 0;
        this.C = true;
        this.G = false;
        this.H = false;
        this.M = new a();
    }

    private void A0(int i3) {
        com.tencent.mobileqq.music.g gVar;
        WeakReference<com.tencent.mobileqq.music.g> weakReference = V;
        if (weakReference != null && weakReference.get() != null) {
            com.tencent.mobileqq.music.g gVar2 = V.get();
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:playState=" + n0(i3) + ",local callback=" + gVar2);
            }
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                if (this.D == null) {
                    this.D = new Handler(Looper.getMainLooper());
                }
                this.D.post(new Runnable(gVar2, i3) { // from class: com.tencent.mobileqq.music.QQPlayerService.7
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ com.tencent.mobileqq.music.g f251854d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f251855e;

                    {
                        this.f251854d = gVar2;
                        this.f251855e = i3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, QQPlayerService.this, gVar2, Integer.valueOf(i3));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            this.f251854d.onPlayStateChanged(this.f251855e);
                        }
                    }
                });
            } else {
                gVar2.onPlayStateChanged(N);
            }
        } else if (V == null && QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "changePlayStateAndNotify: sCallback = null! ");
        }
        Iterator<String> it = X.keySet().iterator();
        while (it.hasNext()) {
            WeakReference<com.tencent.mobileqq.music.g> weakReference2 = X.get(it.next());
            if (weakReference2 == null) {
                gVar = null;
            } else {
                gVar = weakReference2.get();
            }
            if (gVar != null) {
                if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                    if (this.D == null) {
                        this.D = new Handler(Looper.getMainLooper());
                    }
                    this.D.post(new Runnable(gVar, i3) { // from class: com.tencent.mobileqq.music.QQPlayerService.8
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ com.tencent.mobileqq.music.g f251856d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ int f251857e;

                        {
                            this.f251856d = gVar;
                            this.f251857e = i3;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, QQPlayerService.this, gVar, Integer.valueOf(i3));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                this.f251856d.onPlayStateChanged(this.f251857e);
                            }
                        }
                    });
                } else {
                    gVar.onPlayStateChanged(N);
                }
            }
        }
    }

    private synchronized void B0(SongInfo songInfo) {
        com.tencent.mobileqq.music.g gVar;
        WeakReference<com.tencent.mobileqq.music.g> weakReference = V;
        if (weakReference != null && weakReference.get() != null) {
            com.tencent.mobileqq.music.g gVar2 = V.get();
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:newSong=" + songInfo.f251871i + ",local callback=" + gVar2);
            }
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                if (this.D == null) {
                    this.D = new Handler(Looper.getMainLooper());
                }
                this.D.post(new Runnable(gVar2, songInfo) { // from class: com.tencent.mobileqq.music.QQPlayerService.4
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ com.tencent.mobileqq.music.g f251850d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ SongInfo f251851e;

                    {
                        this.f251850d = gVar2;
                        this.f251851e = songInfo;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, QQPlayerService.this, gVar2, songInfo);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            this.f251850d.onPlaySongChanged(this.f251851e);
                        }
                    }
                });
            } else {
                gVar2.onPlaySongChanged(songInfo);
            }
        }
        Iterator<String> it = X.keySet().iterator();
        while (it.hasNext()) {
            WeakReference<com.tencent.mobileqq.music.g> weakReference2 = X.get(it.next());
            if (weakReference2 == null) {
                gVar = null;
            } else {
                gVar = weakReference2.get();
            }
            if (gVar != null) {
                if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                    if (this.D == null) {
                        this.D = new Handler(Looper.getMainLooper());
                    }
                    this.D.post(new Runnable(gVar, songInfo) { // from class: com.tencent.mobileqq.music.QQPlayerService.5
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ com.tencent.mobileqq.music.g f251852d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ SongInfo f251853e;

                        {
                            this.f251852d = gVar;
                            this.f251853e = songInfo;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, QQPlayerService.this, gVar, songInfo);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                this.f251852d.onPlaySongChanged(this.f251853e);
                            }
                        }
                    });
                } else {
                    gVar.onPlaySongChanged(songInfo);
                }
            }
        }
        RemoteCallbackList<com.tencent.mobileqq.music.c> remoteCallbackList = this.J;
        if (remoteCallbackList != null) {
            int beginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                try {
                    this.J.getBroadcastItem(i3).onPlaySongChanged(songInfo);
                } catch (RemoteException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QQPlayerService", 2, "changePlaySongAndNotify", e16);
                    }
                }
            }
            this.J.finishBroadcast();
        }
    }

    private boolean C0() {
        synchronized (this) {
            DownloadThread downloadThread = this.f251846f;
            if (downloadThread != null && f251837c0 != null && downloadThread.isAlive() && downloadThread.J && !downloadThread.E && downloadThread.C.equals(S.f251870h) && this.C && f251838d0 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, current playing song isDownloading...");
                }
                if (f251837c0.isPlaying() && !this.G) {
                    int d06 = d0();
                    float f16 = d06;
                    int i3 = f251838d0;
                    int i16 = downloadThread.I;
                    float f17 = this.f251847h;
                    if (((f16 / i3) * i16) + (i16 * f17) >= i3) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, data is ok, just return;");
                        }
                        return true;
                    }
                    if (((f16 / i3) * i16) + (i16 * f17) > downloadThread.H) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS,no more data to play, need pause!");
                        }
                        this.f251848i = d06;
                        this.G = true;
                        f251837c0.pause();
                        T(1);
                        QLog.i("QQPlayerService", 2, InnerAudioPlugin.AUDIO_PROPERTY_BUFFERED);
                    }
                } else {
                    if (!this.G || N != 1 || f251837c0.isPlaying()) {
                        return true;
                    }
                    float f18 = this.f251848i / f251838d0;
                    int i17 = downloadThread.I;
                    if ((f18 * i17) + (i17 * this.f251847h) <= downloadThread.H) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, data buffering is enough");
                        }
                        this.f251848i = 0;
                        this.G = false;
                        if (!this.H) {
                            if (QLog.isColorLevel()) {
                                QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, user no Pause,so play!");
                            }
                            f251837c0.start();
                            T(2);
                        }
                    }
                }
                w0();
            }
            return false;
        }
    }

    private void D0() {
        int i3 = N;
        if (i3 == 2 || (i3 == 1 && f251837c0 != null)) {
            if (VersionUtils.isrFroyo()) {
                ((AudioManager) getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) this.f251844d);
            }
            MediaPlayer mediaPlayer = f251837c0;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                f251837c0.pause();
            }
            this.H = true;
            T(3);
        }
    }

    private void E0(Intent intent) {
        String str;
        SongInfo songInfo;
        SongInfo songInfo2;
        boolean z16 = false;
        boolean booleanExtra = intent.getBooleanExtra("key_is_from_change", false);
        if (this.H && booleanExtra) {
            return;
        }
        int i3 = N;
        if (i3 == 3 && f251837c0 != null) {
            this.H = false;
            int requestAudioFocus = ((AudioManager) getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) this.f251844d, 3, 1);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("requestAudioFocus,result:");
                if (requestAudioFocus == 1) {
                    z16 = true;
                }
                sb5.append(z16);
                QLog.d("QQPlayerService", 2, sb5.toString());
            }
            f251837c0.start();
            T(2);
            return;
        }
        if (i3 != 6 && (i3 != 7 || (songInfo2 = S) == null || TextUtils.isEmpty(songInfo2.f251870h))) {
            if (N == 5 && (songInfo = S) != null && !TextUtils.isEmpty(songInfo.f251870h)) {
                this.H = false;
                x0(S.f251870h);
                return;
            }
            return;
        }
        if (NetworkUtil.isNetworkAvailable(getApplicationContext())) {
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("resume from network interrupt, start play ");
                SongInfo songInfo3 = S;
                if (songInfo3 != null) {
                    str = songInfo3.f251871i;
                } else {
                    str = "";
                }
                sb6.append(str);
                QLog.d("QQPlayerService", 2, sb6.toString());
            }
            this.H = false;
            SongInfo songInfo4 = S;
            if (songInfo4 != null) {
                x0(songInfo4.f251870h);
            }
        }
    }

    private boolean F0(Intent intent) {
        SongInfo songInfo = (SongInfo) intent.getParcelableExtra("musicplayer.song");
        if (songInfo != null && !TextUtils.isEmpty(songInfo.f251870h)) {
            if (f251837c0.isPlaying()) {
                f251837c0.stop();
            }
            this.H = false;
            S = songInfo;
            S(songInfo);
            x0(S.f251870h);
            int i3 = songInfo.H;
            if (i3 > 0) {
                Y0(i3);
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.e("QQPlayerService", 2, "mediaPlayStart, url is null");
            return true;
        }
        return true;
    }

    private void G0() {
        MediaPlayer mediaPlayer = f251837c0;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            f251837c0.stop();
        }
        this.H = false;
        DownloadThread downloadThread = this.f251846f;
        if (downloadThread != null && downloadThread.isAlive() && !this.f251846f.E) {
            this.f251846f.E = true;
        }
        T(4);
        String str = W;
        if (str != null && str.startsWith("qzone_") && f251837c0 != null) {
            this.H = true;
            T = 0;
            S = null;
        }
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(int i3) {
        MediaPlayer mediaPlayer;
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "onAudioFocusChange,focusChange:" + i3);
        }
        try {
            synchronized (this) {
                if (i3 != -3) {
                    if (i3 != -2 && i3 != -1) {
                        if (i3 == 1) {
                            if (N == 3 && (mediaPlayer = f251837c0) != null && !mediaPlayer.isPlaying()) {
                                f251837c0.setVolume(1.0f, 1.0f);
                                if (this.G) {
                                    w0();
                                } else if (!this.H) {
                                    f251837c0.start();
                                    T(2);
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("QQPlayerService", 2, "onAudioFocusChange,gain focus");
                            }
                            this.C = true;
                        }
                    } else {
                        MediaPlayer mediaPlayer2 = f251837c0;
                        if (mediaPlayer2 != null && mediaPlayer2.isPlaying()) {
                            f251837c0.pause();
                            T(3);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("QQPlayerService", 2, "onAudioFocusChange,loss focus");
                        }
                        this.C = false;
                    }
                } else {
                    MediaPlayer mediaPlayer3 = f251837c0;
                    if (mediaPlayer3 != null && mediaPlayer3.isPlaying()) {
                        f251837c0.setVolume(0.5f, 0.5f);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QQPlayerService", 2, "onAudioFocusChange,temporarily lost audio focus");
                    }
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "onAudioFocusChange:" + e16.getMessage(), e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(Intent intent) {
        f251835a0 = SystemClock.uptimeMillis();
        if (intent == null) {
            return;
        }
        try {
            int intExtra = intent.getIntExtra("musicplayer.action", 0);
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "action->" + Z(intExtra));
            }
            if (intExtra == 0) {
                return;
            }
            if (f251837c0 == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQPlayerService", 2, "onHandleIntent, sPlayer is null");
                    return;
                }
                return;
            }
            if (intExtra != 2) {
                if (intExtra != 3) {
                    if (intExtra != 4) {
                        if (intExtra != 5) {
                            if (intExtra == 6) {
                                D0();
                                return;
                            }
                            return;
                        }
                        E0(intent);
                        return;
                    }
                    C0();
                    return;
                }
                G0();
                return;
            }
            F0(intent);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("QQPlayerService", 2, "onHandleIntent error" + th5.getMessage(), th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J0(Context context) {
        SongInfo songInfo;
        BroadcastMusicInfo broadcastMusicInfo;
        if (NetworkUtil.isNetworkAvailable(context) && N == 2 && (songInfo = S) != null && songInfo.I == 9 && songInfo.K != null) {
            m1(context);
            SongInfo songInfo2 = S;
            songInfo2.f251870h = songInfo2.K.e(NetworkUtil.isWifiConnected(context));
            for (SongInfo songInfo3 : R) {
                if (songInfo3 != null && songInfo3.I == 9 && (broadcastMusicInfo = songInfo3.K) != null) {
                    songInfo3.f251870h = broadcastMusicInfo.e(NetworkUtil.isWifiConnected(context));
                }
            }
            j1(context, W, R, T);
        }
    }

    public static void K0(Context context) {
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "pausePlayMusic");
        }
        Intent intent = new Intent(context, (Class<?>) QQPlayerService.class);
        intent.putExtra("musicplayer.action", 6);
        try {
            context.startService(intent);
        } catch (Throwable th5) {
            QLog.e("QQPlayerService", 1, "pausePlayMusic", th5);
        }
    }

    public static synchronized SongInfo L0() {
        int i3;
        synchronized (QQPlayerService.class) {
            SongInfo[] songInfoArr = R;
            if (songInfoArr != null && songInfoArr.length != 0) {
                int length = songInfoArr.length;
                if (QLog.isColorLevel()) {
                    QLog.d("QQPlayerService", 2, "pickNextSong : songNum=" + length + ",sPlayMode=" + P + ",currentSongIndex=" + T);
                }
                switch (P) {
                    case 100:
                        return null;
                    case 101:
                        SongInfo songInfo = S;
                        if (songInfo != null) {
                            return songInfo;
                        }
                        return R[0];
                    case 102:
                        int i16 = T;
                        if (i16 < 0 || i16 > length - 2) {
                            return null;
                        }
                        int i17 = i16 + 1;
                        T = i17;
                        return R[i17];
                    case 103:
                        int i18 = T;
                        if (i18 < 0 || i18 > length - 1) {
                            return null;
                        }
                        int i19 = i18 + 1;
                        T = i19;
                        if (i19 > i3) {
                            T = 0;
                        }
                        return R[T];
                    case 104:
                    default:
                        return null;
                    case 105:
                        int nextInt = new Random().nextInt(length);
                        T = nextInt;
                        if (nextInt >= 0 && nextInt <= length - 1) {
                            return R[nextInt];
                        }
                        if (length <= 0) {
                            return null;
                        }
                        return R[0];
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("QQPlayerService", 2, "pickNextSong : sSongList shouldn't be null or empty!");
            }
            return null;
        }
    }

    private static synchronized SongInfo M0() {
        int i3;
        synchronized (QQPlayerService.class) {
            SongInfo[] songInfoArr = R;
            if (songInfoArr != null && songInfoArr.length != 0) {
                int length = songInfoArr.length;
                if (QLog.isColorLevel()) {
                    QLog.d("QQPlayerService", 2, "pickPreviousSong : songNum=" + length + ",sPlayMode=" + P + ",currentSongIndex=" + T);
                }
                switch (P) {
                    case 100:
                        return null;
                    case 101:
                        SongInfo songInfo = S;
                        if (songInfo != null) {
                            return songInfo;
                        }
                        return R[0];
                    case 102:
                        int i16 = T;
                        if (i16 < 1 || i16 > length - 1) {
                            return null;
                        }
                        int i17 = i16 - 1;
                        T = i17;
                        return R[i17];
                    case 103:
                        int i18 = T;
                        if (i18 < 0 || i18 > (i3 = length - 1)) {
                            return null;
                        }
                        int i19 = i18 - 1;
                        T = i19;
                        if (i19 < 0) {
                            T = i3;
                        }
                        return R[T];
                    case 104:
                    default:
                        return null;
                    case 105:
                        int i26 = T;
                        int nextInt = new Random().nextInt(length);
                        T = nextInt;
                        if (nextInt == i26 && length >= 1) {
                            int i27 = nextInt + 1;
                            T = i27;
                            T = i27 % length;
                        }
                        int i28 = T;
                        if (i28 >= 0 && i28 <= length - 1) {
                            return R[i28];
                        }
                        if (length <= 0) {
                            return null;
                        }
                        return R[0];
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("QQPlayerService", 2, "pickPreviousSong : sSongList shouldn't be null or empty!");
            }
            return null;
        }
    }

    public static boolean N0(Context context) {
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "playNext");
        }
        SongInfo L0 = L0();
        if (L0 != null) {
            g1(context, L0);
            return true;
        }
        m1(context);
        return false;
    }

    public static boolean O0(Context context) {
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "playPrev");
        }
        SongInfo M0 = M0();
        if (M0 != null) {
            g1(context, M0);
            return true;
        }
        m1(context);
        return false;
    }

    private void P0(File file) {
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "mediaPlayStart:cache is complete");
        }
        f251837c0.reset();
        try {
            bu.g(file);
            f251837c0.setDataSource(file.getAbsolutePath());
            f251837c0.prepare();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "mediaPlayStart:" + e16.getMessage(), e16);
            }
            try {
                file.delete();
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQPlayerService", 2, "mediaPlayStart,delete file on error:" + e17.getMessage(), e17);
                }
            }
        }
        f251837c0.start();
        T(2);
        if (y0()) {
            R0();
        } else {
            f1();
        }
    }

    private void Q0(String str, boolean z16, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file");
        }
        if (!z16) {
            f251837c0.reset();
            T(6);
            return;
        }
        DownloadThread downloadThread = this.f251846f;
        if (downloadThread != null && downloadThread.isAlive() && !this.f251846f.E) {
            if (str != null && str.equals(this.f251846f.C)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file,the download url is equals current url,need play!");
                }
                this.f251846f.K = true;
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file,the download url not equals current url,need stop!");
                }
                this.f251846f.K = false;
                this.f251846f.E = true;
                this.f251846f = null;
            }
        }
        DownloadThread downloadThread2 = new DownloadThread(str, str2, 0, 0);
        this.f251846f = downloadThread2;
        downloadThread2.start();
    }

    public static void R(com.tencent.mobileqq.music.g gVar) {
        if (gVar != null) {
            X.put(gVar.getToken(), new WeakReference<>(gVar));
        }
    }

    private void R0() {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download ============");
        }
        if (g0() != null) {
            str = g0().f251870h;
        } else {
            str = "";
        }
        String o16 = o1(str);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(o16)) {
            File file = new File(AppConstants.SDCARD_MUSIC + o16);
            if (!TextUtils.isEmpty(str) && str.startsWith("qzonevipmusic://")) {
                str = W(str);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
            }
            String str2 = str;
            DownloadThread downloadThread = this.f251846f;
            if (downloadThread != null && downloadThread.isAlive() && !this.f251846f.E) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQPlayerService", 2, "mediaPlayStart: downloadThread is  running.... ");
                }
                if (str2.equals(this.f251846f.C)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQPlayerService", 2, "mediaPlayStart: download url equals nextUrl,so no need play and return.");
                    }
                    this.f251846f.K = false;
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQPlayerService", 2, "mediaPlayStart: download url not equals nextUrl,so no need stop.");
                    }
                    this.f251846f.K = false;
                    this.f251846f.E = true;
                    this.f251846f = null;
                }
            }
            if (file.exists() && file.length() > 0) {
                int[] iArr = new int[2];
                boolean e16 = bu.e(o16, iArr);
                if (QLog.isColorLevel()) {
                    QLog.d("QQPlayerService", 2, "mediaPlayStart:" + file.getAbsolutePath() + ",isNextCacheComplete:" + e16 + ",nextResult[0]:" + iArr[0] + ",nextResult[1]:" + iArr[1]);
                }
                if (e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache is complete.return");
                        return;
                    }
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache not complete");
                    }
                    DownloadThread downloadThread2 = new DownloadThread(str2, o16, iArr[0], iArr[1]);
                    this.f251846f = downloadThread2;
                    downloadThread2.K = false;
                    this.f251846f.start();
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache no exists");
            }
            DownloadThread downloadThread3 = new DownloadThread(str2, o16, 0, 0);
            this.f251846f = downloadThread3;
            downloadThread3.K = false;
            this.f251846f.start();
        }
    }

    private synchronized void S(SongInfo songInfo) {
        if (songInfo != null) {
            f251838d0 = 0;
            S = songInfo;
            B0(songInfo);
        } else {
            throw new IllegalArgumentException("newSong shouldn't be null!");
        }
    }

    public static void S0(com.tencent.mobileqq.music.g gVar) {
        if (gVar != null) {
            X.remove(gVar.getToken());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void T(int i3) {
        V(i3);
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:" + n0(N) + " =====> " + n0(i3));
        }
        N = i3;
        A0(i3);
        z0(i3);
    }

    private static void T0() {
        MediaPlayer mediaPlayer = f251837c0;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.reset();
            } catch (Exception unused) {
            }
        }
    }

    private void U() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.music.QQPlayerService.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQPlayerService.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Calendar calendar = Calendar.getInstance();
                calendar.set(11, 0);
                calendar.set(12, 0);
                calendar.set(13, 0);
                calendar.set(14, 0);
                SharedPreferences sharedPreferences = QQPlayerService.this.getSharedPreferences("QQPlayerService.sp", 0);
                long j3 = sharedPreferences.getLong("del_timestamp", 0L);
                long timeInMillis = calendar.getTimeInMillis();
                if (j3 < timeInMillis) {
                    sharedPreferences.edit().putLong("del_timestamp", timeInMillis).commit();
                    if (QLog.isColorLevel()) {
                        QLog.d("MusicCacheManager", 2, "lastDel<today =====>> delCacheByTimeAndSpace");
                    }
                    bu.b();
                }
            }
        });
    }

    public static void U0(Context context) {
        V0(context, v0(S));
    }

    private void V(int i3) {
        if (i3 != 0 && i3 != 2 && i3 != 3 && i3 != 1 && i3 != 4 && i3 != 7 && i3 != 5 && i3 != 6 && i3 != 8 && i3 != 10) {
            throw new IllegalArgumentException("playState value " + i3 + " is illegal.");
        }
    }

    public static void V0(Context context, boolean z16) {
        W0(context, v0(S), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String W(String str) {
        String str2 = "";
        try {
            Bundle f06 = f0();
            if (f06 != null && f06.containsKey("cacheForRealUrl")) {
                HashMap hashMap = (HashMap) f06.getSerializable("cacheForRealUrl");
                if (hashMap != null && hashMap.containsKey(str)) {
                    str2 = (String) hashMap.get(str);
                } else {
                    QLog.e("QQPlayerService", 1, "fakeUrl:" + str);
                }
            } else {
                QLog.e("QQPlayerService", 1, "playDataExtras dont contains cacheForRealUrl !");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return str2;
    }

    public static void W0(Context context, boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "resumePlayMusic");
        }
        Intent intent = new Intent(context, (Class<?>) QQPlayerService.class);
        intent.putExtra("musicplayer.action", 5);
        intent.putExtra("key_add_to_color_note", z16);
        intent.putExtra("key_is_from_change", z17);
        try {
            context.startService(intent);
        } catch (Throwable th5) {
            QLog.e("QQPlayerService", 1, "resumePlayMusic", th5);
        }
    }

    private void X(String str, boolean z16, String str2, int[] iArr) {
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete");
        }
        if (!z16) {
            f251837c0.reset();
            T(6);
            return;
        }
        DownloadThread downloadThread = this.f251846f;
        if (downloadThread != null && downloadThread.isAlive() && !this.f251846f.E) {
            if (str != null && str.equals(this.f251846f.C)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete,the download url is equals current url,need play!");
                }
                this.f251846f.K = true;
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete,the download url not equals current url,need stop!");
                }
                this.f251846f.K = false;
                this.f251846f.E = true;
                this.f251846f = null;
            }
        }
        DownloadThread downloadThread2 = new DownloadThread(str, str2, iArr[0], iArr[1]);
        this.f251846f = downloadThread2;
        downloadThread2.start();
    }

    private void X0() {
        BroadcastMusicInfo broadcastMusicInfo;
        SongInfo songInfo = S;
        if (songInfo != null && songInfo.I == 9 && (broadcastMusicInfo = songInfo.K) != null) {
            long c16 = broadcastMusicInfo.c();
            if (c16 > 0) {
                long currentTimeMillis = (c16 * 1000) - System.currentTimeMillis();
                if (this.F != null) {
                    this.F.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.music.QQPlayerService.3
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQPlayerService.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else if (QQPlayerService.N == 2) {
                                QQPlayerService.this.n1();
                            }
                        }
                    }, currentTimeMillis);
                }
            }
        }
    }

    public static String Y(int i3, String str) {
        switch (i3) {
            case 1:
                return "aio_" + str;
            case 2:
                return "fav_" + str;
            case 3:
                return "music_gene_" + str;
            case 4:
                return "qzone_" + str;
            case 5:
                return "troopbar_" + str;
            case 6:
                return "music_pendant_" + str;
            case 7:
                return "search_" + str;
            case 8:
                return "miniapp_" + str;
            case 9:
                return "zplan_square_" + str;
            default:
                if (QLog.isColorLevel()) {
                    QLog.d("QQPlayerService", 2, "generateToken unknown callerType");
                    return null;
                }
                return null;
        }
    }

    public static void Y0(int i3) {
        MediaPlayer mediaPlayer = f251837c0;
        if (mediaPlayer != null) {
            int i16 = N;
            if (i16 == 2 || i16 == 3) {
                try {
                    mediaPlayer.seekTo(i3);
                } catch (IllegalStateException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QQPlayerService", 2, "seekTo", e16);
                    }
                }
            }
        }
    }

    public static String Z(int i3) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            return "unknow action";
                        }
                        return "pause";
                    }
                    return "resume";
                }
                return "loopProgress";
            }
            return "stop";
        }
        return "start";
    }

    public static void Z0(com.tencent.mobileqq.music.g gVar) {
        if (gVar != null) {
            W = gVar.getToken();
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "setCallback: sToken=" + W);
            }
            U = V;
            V = new WeakReference<>(gVar);
            return;
        }
        W = null;
        U = V;
        V = null;
    }

    public static synchronized int a0() {
        int i3;
        synchronized (QQPlayerService.class) {
            MediaPlayer mediaPlayer = f251837c0;
            if (mediaPlayer != null) {
                i3 = mediaPlayer.getCurrentPosition();
            } else {
                i3 = -1;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "getCurrentPlayPosition(): sPlayState = " + n0(N) + " position = " + i3);
            }
        }
        return i3;
    }

    public static void a1(Bundle bundle) {
        Z = bundle;
    }

    public static SongInfo b0() {
        return S;
    }

    public static void b1(Intent intent) {
        Y = intent;
    }

    public static int c0() {
        return T;
    }

    public static void c1(int i3) {
        P = i3;
    }

    public static synchronized int d0() {
        int i3;
        synchronized (QQPlayerService.class) {
            MediaPlayer mediaPlayer = f251837c0;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                i3 = f251837c0.getCurrentPosition();
            } else {
                i3 = -1;
            }
        }
        return i3;
    }

    public static void d1(SongInfo[] songInfoArr) {
        e1(songInfoArr, P, 0);
    }

    public static synchronized int e0() {
        int i3;
        synchronized (QQPlayerService.class) {
            i3 = f251838d0;
        }
        return i3;
    }

    public static void e1(SongInfo[] songInfoArr, int i3, int i16) {
        R = songInfoArr;
        P = i3;
        T = i16;
    }

    public static Bundle f0() {
        return Z;
    }

    private void f1() {
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "mediaPlayStart: no need pre download =================");
        }
        DownloadThread downloadThread = this.f251846f;
        if (downloadThread != null && downloadThread.isAlive() && !this.f251846f.E) {
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "mediaPlayStart: download thread running,so no need play");
            }
            this.f251846f.K = false;
        }
    }

    public static SongInfo g0() {
        int i3;
        SongInfo[] songInfoArr = R;
        if (songInfoArr == null || songInfoArr.length == 0) {
            return null;
        }
        int length = songInfoArr.length;
        int i16 = 0;
        switch (P) {
            case 101:
                SongInfo songInfo = S;
                if (songInfo != null) {
                    return songInfo;
                }
                return songInfoArr[0];
            case 102:
                int i17 = T;
                if (i17 < 0 || i17 > length - 2) {
                    return null;
                }
                return songInfoArr[i17];
            case 103:
                int i18 = T;
                if (i18 < 0 || i18 > length - 1) {
                    return null;
                }
                int i19 = i18 + 1;
                if (i19 <= i3) {
                    i16 = i19;
                }
                return songInfoArr[i16];
            default:
                return null;
        }
    }

    private static void g1(Context context, SongInfo songInfo) {
        h1(context, songInfo, v0(songInfo));
    }

    public static SongInfo h0() {
        return g0();
    }

    private static void h1(Context context, SongInfo songInfo, boolean z16) {
        Intent intent = new Intent(context, (Class<?>) QQPlayerService.class);
        intent.putExtra("musicplayer.action", 2);
        intent.putExtra("musicplayer.song", songInfo);
        intent.putExtra("key_add_to_color_note", z16);
        com.tencent.mobileqq.mediafocus.b.i().l(1, f251843i0);
        try {
            context.startService(intent);
        } catch (Throwable th5) {
            QLog.e("QQPlayerService", 1, "startPlayMusic", th5);
        }
    }

    public static Intent i0() {
        return Y;
    }

    public static void i1(Context context, String str, SongInfo[] songInfoArr) {
        j1(context, str, songInfoArr, 0);
    }

    public static SongInfo[] j0() {
        return R;
    }

    public static synchronized void j1(Context context, String str, SongInfo[] songInfoArr, int i3) {
        synchronized (QQPlayerService.class) {
            k1(context, str, songInfoArr, i3, v0(songInfoArr[0]));
        }
    }

    public static int k0() {
        SongInfo[] songInfoArr = R;
        if (songInfoArr != null) {
            return songInfoArr.length;
        }
        return 0;
    }

    public static synchronized void k1(Context context, String str, SongInfo[] songInfoArr, int i3, boolean z16) {
        synchronized (QQPlayerService.class) {
            if (songInfoArr != null) {
                if (songInfoArr.length != 0) {
                    if (str != null && !str.equals("")) {
                        if (i3 >= 0 && i3 <= songInfoArr.length - 1) {
                            if (QLog.isColorLevel()) {
                                QLog.d("QQPlayerService", 2, "startPlayMusic,songLists num=" + songInfoArr.length + ", startIndex=" + i3 + " ,playMode=" + P);
                            }
                            W = str;
                            R = songInfoArr;
                            WeakReference<com.tencent.mobileqq.music.g> weakReference = U;
                            if (weakReference != null) {
                                N = 0;
                                com.tencent.mobileqq.music.g gVar = weakReference.get();
                                if (gVar != null) {
                                    gVar.onPlayStateChanged(0);
                                } else if (QLog.isColorLevel()) {
                                    QLog.e("QQPlayerService", 2, "startPlayMusic\uff1alastCallback = null");
                                }
                            }
                            T = i3;
                            h1(context, R[i3], z16);
                        } else {
                            throw new IllegalArgumentException("startIndex is out of range of SongList! Please check!");
                        }
                    } else {
                        throw new IllegalArgumentException("callerToken shouldn't be null or empty!");
                    }
                }
            }
            throw new IllegalArgumentException("SongList shouldn't be null or empty!");
        }
    }

    public static int l0() {
        return P;
    }

    public static synchronized void l1(Context context, String str, SongInfo songInfo) {
        synchronized (QQPlayerService.class) {
            c1(100);
            i1(context, str, new SongInfo[]{songInfo});
        }
    }

    public static int m0() {
        return N;
    }

    public static void m1(Context context) {
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "stopPlayMusic");
        }
        com.tencent.mobileqq.mediafocus.b.i().d(f251843i0);
        Intent intent = new Intent(context, (Class<?>) QQPlayerService.class);
        intent.putExtra("musicplayer.action", 3);
        try {
            context.startService(intent);
        } catch (Throwable th5) {
            QLog.e("QQPlayerService", 1, "stopPlayMusic", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String n0(int i3) {
        switch (i3) {
            case 0:
                return " IDLE ";
            case 1:
                return " BUFFERING ";
            case 2:
                return " PLAYING ";
            case 3:
                return " PAUSE ";
            case 4:
                return " STOP ";
            case 5:
                return " ERROR_INTERNAL ";
            case 6:
                return " NETWORK_INTERRUPT ";
            case 7:
                return " ERROR_SERVER ";
            case 8:
                return " COMPLETION ";
            default:
                return " Unknow playState ";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n1() {
        BroadcastMusicInfo broadcastMusicInfo;
        SongInfo songInfo = S;
        if (songInfo != null && songInfo.I == 9 && (broadcastMusicInfo = songInfo.K) != null) {
            songInfo.f251871i = broadcastMusicInfo.getTitle();
            B0(S);
            X0();
        }
    }

    public static String o0() {
        return W;
    }

    private static String o1(String str) {
        if (str != null) {
            return MD5.toMD5(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        f251837c0 = reportMediaPlayer;
        reportMediaPlayer.setOnErrorListener(this);
        f251837c0.setOnPreparedListener(this);
        f251837c0.setOnCompletionListener(this);
        f251837c0.setOnBufferingUpdateListener(this);
        f251837c0.setAudioStreamType(3);
    }

    private void q0() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("QQPlayerService");
        this.I = baseHandlerThread;
        try {
            baseHandlerThread.start();
            this.E = this.I.getLooper();
            this.F = new g(this.E);
        } catch (OutOfMemoryError unused) {
            QLog.e("QQPlayerService", 1, "start thread oom, stop self");
            stopSelf();
        }
    }

    public static boolean r0(String str) {
        File file = new File(AppConstants.SDCARD_MUSIC + o1(str));
        if (file.exists() && file.length() > FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE) {
            return true;
        }
        return false;
    }

    public static boolean s0() {
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "isPlaying : sPlayState " + n0(N));
        }
        int i3 = N;
        if (i3 == 2 || i3 == 1) {
            return true;
        }
        return false;
    }

    public static boolean t0(com.tencent.mobileqq.music.g gVar) {
        com.tencent.mobileqq.music.g gVar2;
        int i3 = N;
        if ((i3 != 2 && i3 != 1) || gVar == null) {
            return false;
        }
        WeakReference<com.tencent.mobileqq.music.g> weakReference = V;
        if (weakReference != null && (gVar2 = weakReference.get()) != null && gVar2 == gVar) {
            return true;
        }
        String token = gVar.getToken();
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "isPlayingMySong:callback.getToken()=" + token + ",sToken=" + W);
        }
        String str = W;
        if (str == null) {
            return false;
        }
        return str.equals(token);
    }

    public static boolean u0(String str) {
        String str2;
        int i3 = N;
        if ((i3 != 2 && i3 != 1) || (str2 = W) == null) {
            return false;
        }
        return str2.equals(str);
    }

    public static boolean v0(SongInfo songInfo) {
        if (songInfo == null || f251840f0.get(songInfo.I) == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(String str) {
        SongInfo songInfo;
        boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable(getApplicationContext());
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "mediaPlayStart,isNetworkAvailable = " + isNetworkAvailable + ",url : " + str);
        }
        if (!f251839e0 && ((songInfo = S) == null || songInfo.I != 9)) {
            String o16 = o1(str);
            File file = new File(AppConstants.SDCARD_MUSIC + o16);
            if (!TextUtils.isEmpty(str) && str.startsWith("qzonevipmusic://")) {
                str = W(str);
                if (TextUtils.isEmpty(str)) {
                    f251837c0.reset();
                    T(10);
                    if (S != null) {
                        QLog.e("QQPlayerService", 1, "mediaPlayStart:url coverted is null , title :" + S.f251871i + "and mid :" + S.E);
                        return;
                    }
                    return;
                }
            }
            if (file.exists() && file.length() > 0) {
                int[] iArr = new int[2];
                boolean e16 = bu.e(o16, iArr);
                if (QLog.isColorLevel()) {
                    QLog.d("QQPlayerService", 2, "mediaPlayStart:" + file.getAbsolutePath() + ",isCacheComplete:" + e16 + ",result[0]:" + iArr[0] + ",result[1]:" + iArr[1]);
                }
                if (e16) {
                    P0(file);
                    return;
                } else {
                    X(str, isNetworkAvailable, o16, iArr);
                    return;
                }
            }
            Q0(str, isNetworkAvailable, o16);
            return;
        }
        n1();
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "mediaPlayStart, || play song in compatible mode ||");
        }
        if (!isNetworkAvailable) {
            f251837c0.reset();
            T(6);
            return;
        }
        try {
            f251837c0.reset();
            if (!TextUtils.isEmpty(str) && str.startsWith("qzonevipmusic://")) {
                str = W(str);
                if (TextUtils.isEmpty(str)) {
                    T(10);
                    if (S != null) {
                        QLog.e("QQPlayerService", 1, "mediaPlayStart:url coverted is null , title :" + S.f251871i + "and mid :" + S.E);
                        return;
                    }
                    return;
                }
            }
            f251837c0.setDataSource(str);
            T(1);
            f251837c0.prepare();
            T(2);
        } catch (IOException e17) {
            e17.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IOException => ", e17);
            }
            f251837c0.reset();
            T(6);
        } catch (IllegalArgumentException e18) {
            e18.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IllegalArgumentException => ", e18);
            }
        } catch (IllegalStateException e19) {
            e19.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IllegalStateException => ", e19);
            }
        } catch (SecurityException e26) {
            e26.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode SecurityException => ", e26);
            }
        }
        f251837c0.start();
    }

    private boolean y0() {
        if (NetworkUtil.isWifiConnected(getApplicationContext()) && g0() != null) {
            return true;
        }
        return false;
    }

    private void z0(int i3) {
        RemoteCallbackList<com.tencent.mobileqq.music.c> remoteCallbackList = this.J;
        if (remoteCallbackList != null) {
            int beginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i16 = 0; i16 < beginBroadcast; i16++) {
                try {
                    this.J.getBroadcastItem(i16).onPlayStateChanged(i3);
                } catch (RemoteException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QQPlayerService", 2, "changePlaySongAndNotify", e16);
                    }
                }
            }
            RemoteCallbackList<com.tencent.mobileqq.music.c> remoteCallbackList2 = this.J;
            if (remoteCallbackList2 != null) {
                remoteCallbackList2.finishBroadcast();
            }
        }
        int i17 = N;
        if (i17 == 2) {
            Q = 0;
        }
        if (i17 == 5) {
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "PLAY_STATE_ERROR_INTERNAL ======> post runnable to retry play media");
            }
            if (this.F != null) {
                this.F.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.music.QQPlayerService.6
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQPlayerService.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QQPlayerService.N == 5) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.e("QQPlayerService", 2, "===========> timeout retry to check playState:" + QQPlayerService.n0(QQPlayerService.N) + ",needRetryPlay:" + z16);
                        }
                        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QMUSIC_HLS_MAX_RETRY_TIMES, 3);
                        if (z16 && QQPlayerService.S != null && !TextUtils.isEmpty(QQPlayerService.S.f251870h) && QQPlayerService.Q < config) {
                            QQPlayerService.Q++;
                            QQPlayerService.this.x0(QQPlayerService.S.f251870h);
                        }
                    }
                }, 4000L);
            }
        }
    }

    @Override // mqq.app.AppService
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onAccountChanged();
        QLog.d("QQPlayerService", 1, "[onAccountChanged]");
        stopSelf();
    }

    @Override // mqq.app.AppService, android.app.Service
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IBinder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "onBind");
        }
        return this.M;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) mediaPlayer, i3);
            return;
        }
        if (QLog.isColorLevel() && f251839e0 && i3 < 100) {
            QLog.d("QQPlayerService", 2, "onBufferingUpdate : " + i3 + "% buffered");
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    @TargetApi(8)
    public void onCompletion(MediaPlayer mediaPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) mediaPlayer);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "onCompletion");
        }
        T(8);
        if (!N0(getApplicationContext()) && VersionUtils.isrFroyo()) {
            ((AudioManager) getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) this.f251844d);
        }
    }

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onCreate();
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "onCreate");
        }
        if (VersionUtils.isrFroyo()) {
            this.f251844d = new c();
        }
        q0();
        if (this.F == null) {
            return;
        }
        this.f251849m = new e();
        this.F.post(new Runnable() { // from class: com.tencent.mobileqq.music.QQPlayerService.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQPlayerService.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(QQAppInterface.QQ_ACTION_LOGOUT);
                intentFilter.addAction("qqplayer_exit_action");
                try {
                    BaseApplication.getContext().registerReceiver(QQPlayerService.this.f251849m, intentFilter);
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQPlayerService", 2, "onCreate registerReceiver exception ");
                    }
                }
                try {
                    QQPlayerService.this.p0();
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QQPlayerService", 2, "initMediaPlayer", th5);
                    }
                }
            }
        });
        this.K = new d();
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.K);
        f251842h0.b(this);
    }

    @Override // android.app.Service
    @TargetApi(18)
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQPlayerService", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        if (this.F != null) {
            f fVar = new f();
            fVar.f251863a = f251837c0;
            fVar.f251864b = this.E;
            fVar.f251865c = S;
            this.F.sendMessage(this.F.obtainMessage(1, fVar));
        }
        f251842h0.c(this);
        W = null;
        f251838d0 = 0;
        T = 0;
        Y = null;
        Z = null;
        if (this.D != null) {
            this.D = null;
        }
        RemoteCallbackList<com.tencent.mobileqq.music.c> remoteCallbackList = this.J;
        if (remoteCallbackList != null) {
            remoteCallbackList.kill();
            this.J = null;
        }
        if (VersionUtils.isrFroyo()) {
            ((AudioManager) getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) this.f251844d);
        } else if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "Android 2.1 and below can not stop music");
        }
        d dVar = this.K;
        if (dVar != null) {
            AppNetConnInfo.unregisterNetInfoHandler(dVar);
        }
        U();
        this.L = true;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    @SuppressLint({"NewApi"})
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.e("QQPlayerService", 2, "onError,what:" + i3 + ",extra:" + i16);
        }
        if (i3 == 100) {
            MediaPlayer mediaPlayer2 = f251837c0;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
            }
            p0();
        }
        if (VersionUtils.isrFroyo()) {
            ((AudioManager) getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) this.f251844d);
        }
        T0();
        try {
            T(5);
        } catch (NullPointerException unused) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppService
    public void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) logoutReason);
            return;
        }
        super.onLogout(logoutReason);
        QLog.d("QQPlayerService", 1, "[onLogout]");
        stopSelf();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    @TargetApi(8)
    public void onPrepared(MediaPlayer mediaPlayer) {
        String str;
        SongInfo songInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) mediaPlayer);
            return;
        }
        MediaPlayer mediaPlayer2 = f251837c0;
        if (mediaPlayer2 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("QQPlayerService", 2, "player is null while invoking method onPrepared");
            }
            stopSelf();
            return;
        }
        f251838d0 = mediaPlayer2.getDuration();
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "onPrepared:sDuration" + f251838d0);
        }
        DownloadThread downloadThread = this.f251846f;
        if (downloadThread != null && downloadThread.J && (str = this.f251846f.C) != null && (songInfo = S) != null && str.equals(songInfo.f251870h)) {
            int i3 = f251838d0;
            if (i3 != 0) {
                this.f251845e = (long) (i3 * 0.01d);
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "onPrepared:loopProgressDelayTime:" + this.f251845e);
            }
            w0();
        }
        if (!VersionUtils.isrFroyo()) {
            if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "onPrepared Android 2.1 and below can not stop music");
                return;
            }
            return;
        }
        boolean z16 = true;
        int requestAudioFocus = ((AudioManager) getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) this.f251844d, 3, 1);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("requestAudioFocus,result:");
            if (requestAudioFocus != 1) {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("QQPlayerService", 2, sb5.toString());
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, i3);
        } else if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "onStart");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, intent, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "onStartCommand");
        }
        Message obtainMessage = this.F.obtainMessage();
        if (intent == null || intent.getBooleanExtra("key_add_to_color_note", true)) {
            z16 = true;
        }
        f251841g0 = z16;
        obtainMessage.obj = intent;
        HandlerThread handlerThread = this.I;
        if (handlerThread != null && !handlerThread.isAlive()) {
            if (this.E != null) {
                try {
                    this.E.quit();
                } catch (Throwable unused) {
                }
            }
            q0();
        }
        this.F.sendMessage(obtainMessage);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "onUnbind");
        }
        return super.onUnbind(intent);
    }

    public void w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "loopProgress : loopProgressDelayTime=" + this.f251845e);
        }
        Message obtainMessage = this.F.obtainMessage();
        Intent intent = new Intent();
        intent.putExtra("musicplayer.action", 4);
        obtainMessage.obj = intent;
        this.F.sendMessageDelayed(obtainMessage, this.f251845e);
    }
}
