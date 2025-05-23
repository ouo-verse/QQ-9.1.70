package com.tencent.mobileqq.ptt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioDeviceHelperKt;
import com.tencent.mobileqq.qqaudio.audioprocessor.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mobileqq.utils.WechatNsWrapper;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQRecorder implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: p, reason: collision with root package name */
    public static int f261208p;

    /* renamed from: a, reason: collision with root package name */
    protected AudioRecord f261209a;

    /* renamed from: b, reason: collision with root package name */
    protected AudioManager f261210b;

    /* renamed from: c, reason: collision with root package name */
    protected int f261211c;

    /* renamed from: d, reason: collision with root package name */
    protected int f261212d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.mobileqq.qqaudio.audioprocessor.b f261213e;

    /* renamed from: f, reason: collision with root package name */
    protected int f261214f;

    /* renamed from: g, reason: collision with root package name */
    private Context f261215g;

    /* renamed from: h, reason: collision with root package name */
    protected int f261216h;

    /* renamed from: i, reason: collision with root package name */
    protected int f261217i;

    /* renamed from: j, reason: collision with root package name */
    public RecordParams.RecorderParam f261218j;

    /* renamed from: k, reason: collision with root package name */
    protected String f261219k;

    /* renamed from: l, reason: collision with root package name */
    public RecordThread f261220l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f261221m;

    /* renamed from: n, reason: collision with root package name */
    protected d.a f261222n;

    /* renamed from: o, reason: collision with root package name */
    protected boolean f261223o;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class RecordInitException extends RuntimeException {
        static IPatchRedirector $redirector_;

        public RecordInitException(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class RecordNoPermissonException extends RuntimeException {
        static IPatchRedirector $redirector_;

        public RecordNoPermissonException(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class RecordThread extends BaseThread implements com.tencent.mobileqq.qqaudio.audioprocessor.d {
        static IPatchRedirector $redirector_;
        public volatile boolean C;
        private boolean D;
        public String E;
        public volatile boolean F;
        int G;
        long H;
        File I;
        FileOutputStream J;

        protected RecordThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQRecorder.this);
                return;
            }
            this.C = true;
            this.D = false;
            this.E = null;
            this.F = true;
            this.G = 0;
            this.H = 0L;
        }

        private void s(String str) {
            int i3;
            long j3;
            long j16;
            long j17;
            long j18;
            double d16;
            int i16;
            long j19;
            boolean z16;
            long j26;
            long j27;
            RecordThread recordThread;
            byte[] bArr;
            int t16;
            int i17;
            int b16;
            int i18;
            int i19;
            byte[] bArr2;
            long j28;
            int i26;
            c.a aVar;
            int i27;
            RecordThread recordThread2 = this;
            if (QLog.isColorLevel()) {
                QLog.d("QQRecorder", 2, "RecordThread doRecord: " + recordThread2);
            }
            long currentTimeMillis = System.currentTimeMillis();
            Process.setThreadPriority(-19);
            QQAudioUtils.i(QQRecorder.this.f261215g, true);
            QQRecorder qQRecorder = QQRecorder.this;
            RecordParams.RecorderParam recorderParam = qQRecorder.f261218j;
            if (recorderParam != null) {
                recorderParam.C = 0;
            }
            long j29 = 0;
            try {
                bArr = new byte[qQRecorder.f261212d];
                t16 = recordThread2.t(str, -1, 250, bArr);
                j3 = currentTimeMillis;
            } catch (Throwable th5) {
                th = th5;
                i3 = 0;
                j3 = currentTimeMillis;
            }
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                j18 = 0;
                long j36 = 0;
                long j37 = 0;
                double d17 = 0.0d;
                int i28 = 0;
                int i29 = 0;
                int i36 = 0;
                int i37 = 0;
                boolean z17 = false;
                int i38 = 0;
                j19 = 0;
                while (recordThread2.C) {
                    try {
                        try {
                            if (recordThread2.D) {
                                break;
                            }
                            z17 = QQRecorder.this.j(j19, i38, currentTimeMillis2, z17);
                            int p16 = recordThread2.p(currentTimeMillis2, i29);
                            long j38 = j29 + 1;
                            try {
                                QQRecorder qQRecorder2 = QQRecorder.this;
                                int read = qQRecorder2.f261209a.read(bArr, 0, qQRecorder2.f261212d);
                                if (read <= 0) {
                                    try {
                                        LockMethodProxy.sleep(10L);
                                        i36 = read;
                                        i29 = p16;
                                        j29 = j38;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        i16 = read;
                                        j29 = j38;
                                        d16 = d17;
                                        j16 = j36;
                                        i3 = i38;
                                        j17 = j37;
                                        try {
                                            recordThread = this;
                                            j27 = j18;
                                            j26 = j3;
                                            z16 = QQRecorder.this.n(str, th);
                                            recordThread.r(j29, j19, i16, d16, j27, j26, j16, z16, i3, j17);
                                        } catch (Throwable th7) {
                                            r(j29, j19, i16, d16, j18, j3, j16, false, i3, j17);
                                            throw th7;
                                        }
                                    }
                                } else {
                                    FileOutputStream fileOutputStream = recordThread2.J;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.write(bArr, 0, read);
                                        } catch (Throwable th8) {
                                            th = th8;
                                            i16 = i36;
                                            j29 = j38;
                                            d16 = d17;
                                            j16 = j36;
                                            i3 = i38;
                                            j17 = j37;
                                            recordThread = this;
                                            j27 = j18;
                                            j26 = j3;
                                            z16 = QQRecorder.this.n(str, th);
                                            recordThread.r(j29, j19, i16, d16, j27, j26, j16, z16, i3, j17);
                                        }
                                    }
                                    j18++;
                                    long j39 = read;
                                    long j46 = j19 + j39;
                                    try {
                                        b16 = (int) AudioHelper.b(QQRecorder.this.f261215g, bArr, read, 1.0f);
                                        i17 = i38;
                                    } catch (Throwable th9) {
                                        th = th9;
                                        d16 = d17;
                                        i17 = i38;
                                    }
                                    try {
                                        i38 = Math.max(i17, b16);
                                        j37 += b16;
                                        try {
                                            c.a a16 = QQRecorder.this.f261213e.a(bArr, 0, read);
                                            double millisecond = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).getMillisecond(QQRecorder.this.f261218j.f307255d, 2, 2, j39);
                                            d17 += millisecond;
                                            int i39 = (int) (i28 + millisecond);
                                            try {
                                                int max = Math.max(QQRecorder.this.f261214f, i37);
                                                if (i39 >= 100) {
                                                    RecordParams.RecorderParam recorderParam2 = QQRecorder.this.f261218j;
                                                    int[] iArr = recorderParam2.D;
                                                    if (iArr != null) {
                                                        int i46 = recorderParam2.C;
                                                        iArr[i46] = max;
                                                        if (i46 < iArr.length - 1) {
                                                            recorderParam2.C = i46 + 1;
                                                        }
                                                    }
                                                    i39 = 0;
                                                    i37 = 0;
                                                } else {
                                                    i37 = max;
                                                }
                                                QQRecorder qQRecorder3 = QQRecorder.this;
                                                d.a aVar2 = qQRecorder3.f261222n;
                                                if (aVar2 != null && a16 != null) {
                                                    i18 = i39;
                                                    i19 = t16;
                                                    bArr2 = bArr;
                                                    j28 = currentTimeMillis2;
                                                    aVar = a16;
                                                    i26 = p16;
                                                    aVar2.onRecorderSilceEnd(str, a16.f262210c, a16.f262208a, qQRecorder3.f261214f, d17, qQRecorder3.f261218j);
                                                } else {
                                                    i18 = i39;
                                                    i19 = t16;
                                                    bArr2 = bArr;
                                                    j28 = currentTimeMillis2;
                                                    i26 = p16;
                                                    aVar = a16;
                                                }
                                                if (aVar != null) {
                                                    j36 += aVar.f262208a;
                                                }
                                                if (i26 == 1 && recordThread2.G > 500) {
                                                    d.a aVar3 = QQRecorder.this.f261222n;
                                                    if (aVar3 != null) {
                                                        aVar3.onRecorderVolumeStateChanged(2);
                                                    }
                                                    if (QLog.isColorLevel()) {
                                                        i27 = 2;
                                                        QLog.d("QQRecorder", 2, "volume state changed, normal volume: " + recordThread2.G);
                                                    } else {
                                                        i27 = 2;
                                                    }
                                                    i29 = i27;
                                                } else {
                                                    i29 = i26;
                                                }
                                                if (i19 != -1 && d17 >= i19) {
                                                    recordThread2.D = true;
                                                }
                                                t16 = i19;
                                                i28 = i18;
                                                j29 = j38;
                                                j19 = j46;
                                                bArr = bArr2;
                                                currentTimeMillis2 = j28;
                                            } catch (Throwable th10) {
                                                th = th10;
                                                i16 = i36;
                                                j29 = j38;
                                                j19 = j46;
                                                d16 = d17;
                                                j16 = j36;
                                                i3 = i38;
                                                j17 = j37;
                                                recordThread = this;
                                                j27 = j18;
                                                j26 = j3;
                                                z16 = QQRecorder.this.n(str, th);
                                                recordThread.r(j29, j19, i16, d16, j27, j26, j16, z16, i3, j17);
                                            }
                                        } catch (Throwable th11) {
                                            th = th11;
                                            d16 = d17;
                                            i16 = i36;
                                            j29 = j38;
                                            j19 = j46;
                                            j16 = j36;
                                            i3 = i38;
                                            j17 = j37;
                                            recordThread = this;
                                            j27 = j18;
                                            j26 = j3;
                                            z16 = QQRecorder.this.n(str, th);
                                            recordThread.r(j29, j19, i16, d16, j27, j26, j16, z16, i3, j17);
                                        }
                                    } catch (Throwable th12) {
                                        th = th12;
                                        d16 = d17;
                                        i3 = i17;
                                        i16 = i36;
                                        j29 = j38;
                                        j19 = j46;
                                        j16 = j36;
                                        j17 = j37;
                                        recordThread = this;
                                        j27 = j18;
                                        j26 = j3;
                                        z16 = QQRecorder.this.n(str, th);
                                        recordThread.r(j29, j19, i16, d16, j27, j26, j16, z16, i3, j17);
                                    }
                                }
                            } catch (Throwable th13) {
                                th = th13;
                                d16 = d17;
                                i16 = i36;
                                j29 = j38;
                            }
                        } catch (Throwable th14) {
                            th = th14;
                            d16 = d17;
                            i16 = i36;
                            j16 = j36;
                            i3 = i38;
                            j17 = j37;
                            recordThread = this;
                            j27 = j18;
                            j26 = j3;
                            z16 = QQRecorder.this.n(str, th);
                            recordThread.r(j29, j19, i16, d16, j27, j26, j16, z16, i3, j17);
                        }
                    } catch (Throwable th15) {
                        th = th15;
                        d16 = d17;
                    }
                }
                d16 = d17;
                try {
                    recordThread2.v(str, d16);
                    recordThread = this;
                    i16 = i36;
                    j27 = j18;
                    j26 = j3;
                    j16 = j36;
                    z16 = false;
                    i3 = i38;
                    j17 = j37;
                } catch (Throwable th16) {
                    th = th16;
                    recordThread2 = this;
                    i16 = i36;
                    j16 = j36;
                    i3 = i38;
                    j17 = j37;
                    recordThread = this;
                    j27 = j18;
                    j26 = j3;
                    z16 = QQRecorder.this.n(str, th);
                    recordThread.r(j29, j19, i16, d16, j27, j26, j16, z16, i3, j17);
                }
            } catch (Throwable th17) {
                th = th17;
                i3 = 0;
                recordThread2 = this;
                j16 = 0;
                j17 = 0;
                j18 = 0;
                d16 = 0.0d;
                i16 = i3;
                j19 = 0;
                recordThread = this;
                j27 = j18;
                j26 = j3;
                z16 = QQRecorder.this.n(str, th);
                recordThread.r(j29, j19, i16, d16, j27, j26, j16, z16, i3, j17);
            }
            recordThread.r(j29, j19, i16, d16, j27, j26, j16, z16, i3, j17);
        }

        @Override // com.tencent.mobileqq.qqaudio.audioprocessor.d
        public void a(com.tencent.mobileqq.qqaudio.audioprocessor.c cVar, c.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) cVar, (Object) aVar);
                return;
            }
            if (cVar instanceof WechatNsWrapper) {
                QQRecorder qQRecorder = QQRecorder.this;
                qQRecorder.f261214f = (int) AudioHelper.b(qQRecorder.f261215g, aVar.f262210c, aVar.f262208a, 1.0f);
                this.G = Math.max(this.G, QQRecorder.this.f261214f);
                long j3 = this.H;
                QQRecorder qQRecorder2 = QQRecorder.this;
                this.H = j3 + qQRecorder2.f261214f;
                qQRecorder2.getClass();
            }
        }

        @Override // com.tencent.mobileqq.qqaudio.audioprocessor.d
        public void b(com.tencent.mobileqq.qqaudio.audioprocessor.c cVar, c.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) cVar, (Object) aVar);
            } else if (cVar instanceof WechatNsWrapper) {
                QQRecorder.this.getClass();
            }
        }

        public boolean o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
            }
            if (!this.F && QQRecorder.this.f261209a == null) {
                return false;
            }
            return true;
        }

        protected int p(long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Integer.valueOf(i3))).intValue();
            }
            if (System.currentTimeMillis() - j3 > 1000 && i3 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQRecorder", 2, "check 1000ms max volume, volume: " + this.G);
                }
                int i16 = this.G;
                if (i16 > 0 && i16 < 500) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                d.a aVar = QQRecorder.this.f261222n;
                if (aVar != null) {
                    aVar.onRecorderVolumeStateChanged(i3);
                }
            }
            return i3;
        }

        protected boolean q(double d16, long j3, long j16, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, this, Double.valueOf(d16), Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16))).booleanValue();
            }
            if ((j16 < 512 || d16 < 1000.0d) && !z16 && System.currentTimeMillis() - j3 > 1000) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x02a5  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x02ac  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x02e2 A[Catch: Exception -> 0x0347, TryCatch #2 {Exception -> 0x0347, blocks: (B:25:0x0200, B:28:0x02a9, B:31:0x02b1, B:33:0x02e2, B:34:0x033f, B:37:0x02ad, B:38:0x02a7), top: B:24:0x0200 }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x02ad A[Catch: Exception -> 0x0347, TryCatch #2 {Exception -> 0x0347, blocks: (B:25:0x0200, B:28:0x02a9, B:31:0x02b1, B:33:0x02e2, B:34:0x033f, B:37:0x02ad, B:38:0x02a7), top: B:24:0x0200 }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x02a7 A[Catch: Exception -> 0x0347, TryCatch #2 {Exception -> 0x0347, blocks: (B:25:0x0200, B:28:0x02a9, B:31:0x02b1, B:33:0x02e2, B:34:0x033f, B:37:0x02ad, B:38:0x02a7), top: B:24:0x0200 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void r(long j3, long j16, int i3, double d16, long j17, long j18, long j19, boolean z16, int i16, long j26) {
            String str;
            int i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Double.valueOf(d16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Boolean.valueOf(z16), Integer.valueOf(i16), Long.valueOf(j26));
                return;
            }
            AudioRecord audioRecord = QQRecorder.this.f261209a;
            if (audioRecord != null && audioRecord.getState() == 1) {
                QQRecorder.this.f261209a.stop();
            }
            try {
                FileOutputStream fileOutputStream = this.J;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    this.J = null;
                }
                QQRecorder.this.m();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQRecorder", 2, "MyThread end: " + this);
                QLog.d("QQRecorder", 2, "read times = " + j3 + " orginal data size = " + j16 + "arm data size = " + j19 + "  error code = " + i3);
            }
            QQAudioUtils.i(QQRecorder.this.f261215g, false);
            try {
                if (q(d16, j18, j19, z16)) {
                    try {
                        HashMap<String, String> w3 = w();
                        w3.put("exceptionType", "1");
                        w3.put("osVersion", Build.VERSION.SDK_INT + "");
                        w3.put("deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(j16);
                        sb5.append("");
                        w3.put("dataSize", sb5.toString());
                        w3.put("maxVolume", i16 + "");
                        w3.put("readTime", d16 + "");
                        w3.put("touchTime", (System.currentTimeMillis() - j18) + "");
                        u("actPttRecordException", false, w3);
                    } catch (Exception e16) {
                        e = e16;
                        str = "QQRecorder";
                        i17 = 2;
                    }
                    if (QLog.isColorLevel()) {
                        str = "QQRecorder";
                        i17 = 2;
                        try {
                            QLog.d(str, 2, "report exception(short record) | exception type = 1 | dataSize = " + j16 + " | amrSize = " + j19 + " | readTime = " + d16 + " | toucTime = " + (System.currentTimeMillis() - j18));
                        } catch (Exception e17) {
                            e = e17;
                            if (QLog.isColorLevel()) {
                                QLog.d(str, i17, "Report exception error.", e);
                            }
                            HashMap<String, String> w16 = w();
                            w16.put("osVersion", Build.VERSION.SDK_INT + "");
                            w16.put("deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(j16);
                            sb6.append("");
                            w16.put("dataSize", sb6.toString());
                            w16.put("pttDuration", d16 + "");
                            w16.put("touchTime", (System.currentTimeMillis() - j18) + "");
                            w16.put("maxVolume", i16 + "");
                            w16.put("amrMaxVolume", this.G + "");
                            long j27 = -1;
                            int i18 = (int) (j17 == 0 ? -1L : j26 / j17);
                            if (j17 != 0) {
                            }
                            int i19 = (int) j27;
                            w16.put("averageVolume", i18 + "");
                            w16.put("amrAverageVolume", i19 + "");
                            if (QLog.isColorLevel()) {
                            }
                            u("actPttRecordVolume", true, w16);
                            return;
                        }
                        HashMap<String, String> w162 = w();
                        w162.put("osVersion", Build.VERSION.SDK_INT + "");
                        w162.put("deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
                        StringBuilder sb62 = new StringBuilder();
                        sb62.append(j16);
                        sb62.append("");
                        w162.put("dataSize", sb62.toString());
                        w162.put("pttDuration", d16 + "");
                        w162.put("touchTime", (System.currentTimeMillis() - j18) + "");
                        w162.put("maxVolume", i16 + "");
                        w162.put("amrMaxVolume", this.G + "");
                        long j272 = -1;
                        int i182 = (int) (j17 == 0 ? -1L : j26 / j17);
                        if (j17 != 0) {
                            j272 = this.H / j17;
                        }
                        int i192 = (int) j272;
                        w162.put("averageVolume", i182 + "");
                        w162.put("amrAverageVolume", i192 + "");
                        if (QLog.isColorLevel()) {
                            QLog.d(str, 2, "report record detail | maxVolume = " + i16 + " | averageVolume = " + i182 + " | amrMaxVolume = " + i192 + " | amrAverage = " + i192 + " | dataSize = " + j16 + " |\u3000amrSize = " + j19 + " | pttDuration = " + d16 + " | touchTime = " + (System.currentTimeMillis() - j18));
                        }
                        u("actPttRecordVolume", true, w162);
                        return;
                    }
                }
                HashMap<String, String> w1622 = w();
                w1622.put("osVersion", Build.VERSION.SDK_INT + "");
                w1622.put("deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
                StringBuilder sb622 = new StringBuilder();
                sb622.append(j16);
                sb622.append("");
                w1622.put("dataSize", sb622.toString());
                w1622.put("pttDuration", d16 + "");
                w1622.put("touchTime", (System.currentTimeMillis() - j18) + "");
                w1622.put("maxVolume", i16 + "");
                w1622.put("amrMaxVolume", this.G + "");
                long j2722 = -1;
                int i1822 = (int) (j17 == 0 ? -1L : j26 / j17);
                if (j17 != 0) {
                }
                int i1922 = (int) j2722;
                w1622.put("averageVolume", i1822 + "");
                w1622.put("amrAverageVolume", i1922 + "");
                if (QLog.isColorLevel()) {
                }
                u("actPttRecordVolume", true, w1622);
                return;
            } catch (Exception e18) {
                if (QLog.isColorLevel()) {
                    QLog.d(str, 2, "Report record error.", e18);
                    return;
                }
                return;
            }
            str = "QQRecorder";
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            while (this.F) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQRecorder", 2, "RecordThread : begin run");
                }
                this.C = true;
                this.D = false;
                s(this.E);
                if (this.F) {
                    try {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        synchronized (QQRecorder.this) {
                            QQRecorder.this.wait(QQRecorder.f261208p);
                        }
                        if (SystemClock.uptimeMillis() - uptimeMillis < QQRecorder.f261208p) {
                            continue;
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("QQRecorder", 2, "RecordThread more than maxtime release");
                            }
                            synchronized (this) {
                                this.F = false;
                            }
                            y();
                        }
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            y();
        }

        protected int t(String str, int i3, int i16, byte[] bArr) throws IOException, InterruptedException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Integer.valueOf(i16), bArr)).intValue();
            }
            QQRecorder qQRecorder = QQRecorder.this;
            d.a aVar = qQRecorder.f261222n;
            if (aVar != null) {
                aVar.onRecorderPrepare(str, qQRecorder.f261218j);
            }
            QQRecorder.this.t();
            d.a aVar2 = QQRecorder.this.f261222n;
            if (aVar2 != null) {
                int onRecorderStart = aVar2.onRecorderStart();
                if (onRecorderStart <= 0) {
                    onRecorderStart = 250;
                }
                i16 = QQRecorder.k(onRecorderStart);
            }
            QQRecorder.this.l();
            QQRecorder.this.f261213e.d(this);
            LockMethodProxy.sleep(200L);
            int bytesInSecond = (((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).bytesInSecond(QQRecorder.this.f261218j.f307255d) / 1000) * i16;
            int i17 = 0;
            while (i17 < bytesInSecond) {
                QQRecorder qQRecorder2 = QQRecorder.this;
                int i18 = qQRecorder2.f261212d;
                int i19 = bytesInSecond - i17;
                if (i18 > i19) {
                    i18 = i19;
                }
                qQRecorder2.f261209a.read(bArr, 0, i18);
                i17 += i18;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQRecorder", 2, "MyThread abandonBuf,  abandonSize:" + i17 + " abandonBufLen:" + bytesInSecond);
            }
            QQRecorder qQRecorder3 = QQRecorder.this;
            d.a aVar3 = qQRecorder3.f261222n;
            if (aVar3 != null) {
                i3 = aVar3.onBeginReceiveData(this.E, qQRecorder3.f261218j);
                int i26 = (i3 / 1000) * 10;
                if (i26 > 255) {
                    i26 = 255;
                }
                QQRecorder.this.f261218j.D = new int[i26];
            }
            return i3;
        }

        protected void u(String str, boolean z16, HashMap<String, String> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16), hashMap);
            } else {
                QQRecorder.o(str, z16, hashMap);
            }
        }

        protected void v(String str, double d16) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, Double.valueOf(d16));
                return;
            }
            FileOutputStream fileOutputStream = this.J;
            if (fileOutputStream != null) {
                fileOutputStream.flush();
            }
            QQRecorder qQRecorder = QQRecorder.this;
            d.a aVar = qQRecorder.f261222n;
            if (aVar != null) {
                aVar.onRecorderEnd(str, qQRecorder.f261218j, d16);
                QQRecorder qQRecorder2 = QQRecorder.this;
                AudioManager audioManager = qQRecorder2.f261210b;
                if (audioManager != null && qQRecorder2.f261216h != -1) {
                    audioManager.setMode(0);
                }
            }
        }

        @NotNull
        protected HashMap<String, String> w() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (HashMap) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return new HashMap<>();
        }

        public void x() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QQRecorder.this.f261219k != null) {
                File file = new File(QQRecorder.this.f261219k);
                this.I = file;
                if (file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.I.delete();
                    QLog.i("QQRecorder", 1, "9015 \u5361\u987f\u76d1\u6d4b, delete cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                try {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    this.J = new FileOutputStream(this.I.getAbsoluteFile());
                    QLog.i("QQRecorder", 1, "9015 \u5361\u987f\u76d1\u6d4b, create file os cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                } catch (FileNotFoundException e16) {
                    e16.printStackTrace();
                }
            }
        }

        public void y() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this);
                return;
            }
            AudioDeviceHelperKt.f262108a.m(QQRecorder.this.f261215g);
            if (QQRecorder.this.f261209a != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQRecorder", 2, "releaseRecorder");
                }
                QQRecorder.this.f261209a.release();
                QQRecorder.this.f261209a = null;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36732);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            f261208p = 60000;
        }
    }

    public QQRecorder(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.f261209a = null;
        this.f261211c = 20480;
        this.f261212d = 800;
        this.f261214f = 0;
        this.f261216h = -1;
        this.f261217i = -1;
        this.f261221m = false;
        this.f261223o = true;
        this.f261215g = context;
        this.f261210b = (AudioManager) context.getSystemService("audio");
        this.f261218j = new RecordParams.RecorderParam(RecordParams.f307250a, 0, 0);
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qq_audio_record.name());
        if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "Init | dpc config = " + featureValue);
        }
        if (!TextUtils.isEmpty(featureValue)) {
            try {
                String[] split = featureValue.split("\\|");
                this.f261216h = Integer.parseInt(split[0]);
                this.f261217i = Integer.parseInt(split[1]);
                if (split.length > 4) {
                    q(Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]));
                }
                if (!VersionUtils.isHoneycomb() && (this.f261216h == 3 || this.f261217i == 7)) {
                    throw new RuntimeException("Illegal dpc config");
                }
            } catch (Exception e16) {
                this.f261216h = -1;
                this.f261217i = -1;
                if (QLog.isColorLevel()) {
                    QLog.d("QQRecorder", 2, "QQRecord init error.", e16);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "mMode = " + this.f261216h + " | mAudioSource = " + this.f261217i + " | recorderBufSize = " + this.f261211c + " | readLength = " + this.f261212d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(long j3, int i3, long j16, boolean z16) {
        if (System.currentTimeMillis() - j16 > 1000 && !z16) {
            if (j3 != 0 && i3 != 0) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQRecorder", 2, "record abnormal: data size = " + j3 + ", max volume = " + i3);
            }
            throw new RecordNoPermissonException("no permission");
        }
        return z16;
    }

    public static int k(int i3) {
        StringBuilder sb5 = new StringBuilder();
        String str = Build.MANUFACTURER;
        sb5.append(str);
        sb5.append("-");
        sb5.append(DeviceInfoMonitor.getModel());
        if (!sb5.toString().equalsIgnoreCase("Xiaomi-MI NOTE Pro") && !str.equalsIgnoreCase("OPPO")) {
            if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
                return i3 + 130;
            }
            return i3;
        }
        return i3 + 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(String str, Throwable th5) {
        QLog.d("QQRecorder", 1, "record Exception: ", th5);
        if (this.f261222n != null) {
            AudioManager audioManager = this.f261210b;
            if (audioManager != null && this.f261216h != -1) {
                audioManager.setMode(0);
            }
            if (!(th5 instanceof RecordInitException) && !(th5 instanceof IllegalArgumentException)) {
                if (th5 instanceof RecordNoPermissonException) {
                    this.f261222n.onRecorderAbnormal(str, this.f261218j);
                } else {
                    this.f261222n.onRecorderError(str, this.f261218j, th5.getMessage());
                }
            } else {
                this.f261222n.onInitFailed(str, this.f261218j);
            }
        }
        s(th5);
        return true;
    }

    protected static void o(String str, boolean z16, HashMap<String, String> hashMap) {
        if (new Random().nextInt(1000) == 521) {
            if (QLog.isColorLevel()) {
                QLog.d("QQRecorder", 2, "real do report");
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", str, z16, 0L, 0L, hashMap, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit r() {
        stop();
        return null;
    }

    @Override // com.tencent.mobileqq.ptt.d
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.f261220l == null) {
            return true;
        }
        return !r0.C;
    }

    @Override // com.tencent.mobileqq.ptt.d
    public void b(d.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) aVar);
        } else {
            this.f261222n = aVar;
        }
    }

    @Override // com.tencent.mobileqq.ptt.d
    public void c(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatActivity", 2, "thread is:" + this.f261220l + ", time is:" + System.currentTimeMillis());
        }
        AudioManager audioManager = this.f261210b;
        if (audioManager != null) {
            try {
                if (audioManager.isMicrophoneMute()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQRecorder", 2, "mic is mute, set mute false.");
                    }
                    this.f261210b.setMicrophoneMute(false);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQRecorder", 2, "setMicrophoneMute error.", e16);
                }
            }
        }
        this.f261223o = z16;
        ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).setLastRecorderPath(str);
        RecordThread recordThread = this.f261220l;
        if (recordThread != null && recordThread.o()) {
            if (QLog.isColorLevel()) {
                QLog.d("QQRecorder", 2, "start, RecordThread exist , notify ");
            }
            synchronized (this.f261220l) {
                this.f261220l.F = true;
                RecordThread recordThread2 = this.f261220l;
                recordThread2.E = str;
                recordThread2.x();
            }
            synchronized (this) {
                notifyAll();
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "QQRecorder.start, new RecordThread ");
        }
        AudioDeviceHelperKt.f262108a.k(this.f261215g, new Function0() { // from class: com.tencent.mobileqq.ptt.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit r16;
                r16 = QQRecorder.this.r();
                return r16;
            }
        });
        RecordThread recordThread3 = new RecordThread();
        this.f261220l = recordThread3;
        recordThread3.E = str;
        recordThread3.x();
        this.f261220l.start();
    }

    @Override // com.tencent.mobileqq.ptt.d
    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f261219k = str;
        }
    }

    @Override // com.tencent.mobileqq.ptt.d
    public void e(RecordParams.RecorderParam recorderParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) recorderParam);
            return;
        }
        if (this.f261218j.f307255d != recorderParam.f307255d) {
            this.f261221m = true;
        }
        this.f261218j = recorderParam;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ptt.QQRecorder.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQRecorder.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                int p16 = QQRecorder.this.p();
                QQRecorder qQRecorder = QQRecorder.this;
                if (qQRecorder.f261211c < p16) {
                    qQRecorder.f261211c = p16;
                }
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.ptt.d
    public boolean isRecording() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        RecordThread recordThread = this.f261220l;
        if (recordThread != null && recordThread.C) {
            return true;
        }
        return false;
    }

    protected void l() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.f261213e = new com.tencent.mobileqq.qqaudio.audioprocessor.b();
        WechatNsWrapper wechatNsWrapper = new WechatNsWrapper(this.f261215g);
        if (WechatNsWrapper.J) {
            this.f261213e.c(wechatNsWrapper);
        }
        if (this.f261223o) {
            if (this.f261218j.f307257f == 0) {
                this.f261213e.c(new AmrInputStreamWrapper(this.f261215g));
            } else {
                this.f261213e.c(new SilkCodecWrapper(this.f261215g));
            }
        }
        com.tencent.mobileqq.qqaudio.audioprocessor.b bVar = this.f261213e;
        RecordParams.RecorderParam recorderParam = this.f261218j;
        bVar.b(recorderParam.f307255d, recorderParam.f307256e, recorderParam.f307257f);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("mAudioType=" + this.f261218j.f307257f + ", mSampleRate=" + this.f261218j.f307255d + " ,mBitRate=" + this.f261218j.f307256e + " ,Codec=" + this.f261213e);
            sb5.append(" ,processor = ");
            sb5.append(" ,time is :");
            sb5.append(System.currentTimeMillis());
            QLog.d("QQRecorder", 2, sb5.toString());
        }
    }

    protected void m() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqaudio.audioprocessor.b bVar = this.f261213e;
        if (bVar != null) {
            bVar.release();
            this.f261213e = null;
        }
    }

    protected int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return AudioRecord.getMinBufferSize(this.f261218j.f307255d, 2, 2);
    }

    public void q(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (i3 != -1) {
            int p16 = p();
            if (p16 != -2 && p16 != -1) {
                this.f261211c = p16 * i3;
            }
        } else if (i16 != -1) {
            this.f261211c = i16;
        }
        if (i17 != -1) {
            this.f261212d = i17;
        }
    }

    @Override // com.tencent.mobileqq.ptt.d
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        RecordThread recordThread = this.f261220l;
        if (recordThread != null && recordThread.o()) {
            synchronized (this.f261220l) {
                this.f261220l.F = false;
            }
            synchronized (this) {
                notifyAll();
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQRecorder", 2, "RecordThread.release");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x009c A[Catch: Exception -> 0x00bb, TRY_LEAVE, TryCatch #0 {Exception -> 0x00bb, blocks: (B:3:0x0007, B:5:0x000f, B:8:0x0037, B:10:0x009c, B:16:0x001a, B:18:0x001e, B:21:0x0029), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void s(Throwable th5) {
        int i3;
        try {
            String th6 = th5.toString();
            if (th5 instanceof RuntimeException) {
                if (th6.contains("STATE_INITIALIZED")) {
                    i3 = 2;
                    HashMap hashMap = new HashMap();
                    hashMap.put("exceptionType", i3 + "");
                    hashMap.put("osVersion", Build.VERSION.SDK_INT + "");
                    hashMap.put("deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
                    hashMap.put("exceptionMsg", th6);
                    o("actPttRecordException", false, hashMap);
                    if (!QLog.isColorLevel()) {
                        QLog.d("QQRecorder", 2, "report exception(catch exception) | exceptionType = " + i3 + " | exceptionMessage = " + th6);
                        return;
                    }
                    return;
                }
                i3 = 7;
                HashMap hashMap2 = new HashMap();
                hashMap2.put("exceptionType", i3 + "");
                hashMap2.put("osVersion", Build.VERSION.SDK_INT + "");
                hashMap2.put("deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
                hashMap2.put("exceptionMsg", th6);
                o("actPttRecordException", false, hashMap2);
                if (!QLog.isColorLevel()) {
                }
            } else {
                if (th5 instanceof UnsatisfiedLinkError) {
                    if (th6.contains("Native method not found")) {
                        i3 = 4;
                    } else if (th6.contains("Library not found")) {
                        i3 = 5;
                    } else {
                        i3 = 6;
                    }
                    HashMap hashMap22 = new HashMap();
                    hashMap22.put("exceptionType", i3 + "");
                    hashMap22.put("osVersion", Build.VERSION.SDK_INT + "");
                    hashMap22.put("deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
                    hashMap22.put("exceptionMsg", th6);
                    o("actPttRecordException", false, hashMap22);
                    if (!QLog.isColorLevel()) {
                    }
                }
                i3 = 7;
                HashMap hashMap222 = new HashMap();
                hashMap222.put("exceptionType", i3 + "");
                hashMap222.put("osVersion", Build.VERSION.SDK_INT + "");
                hashMap222.put("deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
                hashMap222.put("exceptionMsg", th6);
                o("actPttRecordException", false, hashMap222);
                if (!QLog.isColorLevel()) {
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QQRecorder", 2, "Report exception error.", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.ptt.d
    public void start(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            c(str, true);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d
    public boolean stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatActivity", 2, "thread is:" + this.f261220l + ",time is:" + System.currentTimeMillis());
        }
        RecordThread recordThread = this.f261220l;
        if (recordThread == null) {
            return false;
        }
        boolean z16 = recordThread.C;
        this.f261220l.C = false;
        return z16;
    }

    @SuppressLint({"WrongConstant"})
    protected void t() {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        AudioManager audioManager = this.f261210b;
        if (audioManager != null) {
            i3 = audioManager.getMode();
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "startRecording | audio mode = " + i3);
        }
        AudioManager audioManager2 = this.f261210b;
        if (audioManager2 != null && (i17 = this.f261216h) != -1) {
            audioManager2.setMode(i17);
        }
        AudioRecord audioRecord = this.f261209a;
        if (audioRecord == null || audioRecord.getState() == 0 || this.f261221m) {
            int i18 = this.f261217i;
            if (i18 == -1) {
                i16 = 0;
            } else {
                i16 = i18;
            }
            this.f261209a = new AudioRecord(i16, this.f261218j.f307255d, 2, 2, this.f261211c);
            this.f261221m = false;
        }
        if (this.f261209a.getState() != 1) {
            int state = this.f261209a.getState();
            AudioRecord audioRecord2 = this.f261209a;
            if (audioRecord2 != null) {
                audioRecord2.release();
            }
            this.f261209a = null;
            throw new RecordInitException("mRecorder.getState is not STATE_INITIALIZED, state = " + state);
        }
        AudioMonitor.startRecording(this.f261209a);
        d.a aVar = this.f261222n;
        if (aVar != null) {
            aVar.onInitSuccess();
        }
    }
}
