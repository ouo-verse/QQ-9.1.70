package com.tencent.mobileqq.qrscan.minicode;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minicode.DecodeProxy;
import com.tencent.mobileqq.minicode.YuvProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.qrscan.earlydown.g;
import com.tencent.mobileqq.qrscan.i;
import com.tencent.mobileqq.qrscan.j;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class MiniCodeController implements i, com.tencent.mobileqq.qrscan.e {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    private static final String f276681l;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f276682m;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f276683n;

    /* renamed from: o, reason: collision with root package name */
    private static boolean f276684o;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f276685p;

    /* renamed from: q, reason: collision with root package name */
    private static long f276686q;

    /* renamed from: r, reason: collision with root package name */
    private static String f276687r;

    /* renamed from: s, reason: collision with root package name */
    public static volatile MiniCodeController f276688s;

    /* renamed from: a, reason: collision with root package name */
    private c f276689a;

    /* renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<i>> f276690b;

    /* renamed from: c, reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<j>> f276691c;

    /* renamed from: d, reason: collision with root package name */
    private Set<Long> f276692d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f276693e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f276694f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f276695g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f276696h;

    /* renamed from: i, reason: collision with root package name */
    private int f276697i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f276698j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f276699k;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements i {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f276702a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f276703b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f276704c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f276705d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean[] f276706e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bitmap f276707f;

        a(long j3, ArrayList arrayList, Object obj, c cVar, boolean[] zArr, Bitmap bitmap) {
            this.f276702a = j3;
            this.f276703b = arrayList;
            this.f276704c = obj;
            this.f276705d = cVar;
            this.f276706e = zArr;
            this.f276707f = bitmap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MiniCodeController.this, Long.valueOf(j3), arrayList, obj, cVar, zArr, bitmap);
            }
        }

        @Override // com.tencent.mobileqq.qrscan.i
        public void a(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.qrscan.i
        public void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            if (this.f276705d != null && MiniCodeController.this.f276689a != null) {
                this.f276706e[0] = this.f276705d.f(this.f276707f, this.f276702a);
            } else {
                this.f276706e[0] = false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MiniRecog.MiniCodeController", 2, "detectSync onDetectReady exec=" + this.f276706e[0]);
            }
            if (!this.f276706e[0]) {
                synchronized (this.f276704c) {
                    this.f276704c.notifyAll();
                }
            }
        }

        @Override // com.tencent.mobileqq.qrscan.i
        public void c(List<com.tencent.mobileqq.qrscan.a> list, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, list, Long.valueOf(j3));
                return;
            }
            if (j3 == this.f276702a) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    com.tencent.mobileqq.qrscan.a aVar = list.get(i3);
                    if (aVar != null && !aVar.f276532b.isEmpty()) {
                        this.f276703b.add(aVar);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("MiniRecog.MiniCodeController", 2, String.format("detectSync onDetectResult=%s", this.f276703b));
                }
                synchronized (this.f276704c) {
                    this.f276704c.notifyAll();
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28924);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        String str = File.separator;
        sb5.append(str);
        sb5.append("qq.android.minidetect.model_v8.9.85");
        sb5.append(str);
        f276681l = sb5.toString();
        f276686q = 0L;
        f276687r = "vivo;vivo X6Plus A";
        f276688s = null;
    }

    MiniCodeController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f276696h = false;
        this.f276697i = -1;
        this.f276698j = false;
        this.f276699k = false;
        this.f276697i = e.i();
        this.f276690b = new CopyOnWriteArrayList<>();
        this.f276691c = new CopyOnWriteArrayList<>();
        this.f276692d = Collections.synchronizedSet(new HashSet());
        this.f276698j = ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).isMiniCodeDecodeSwitchOn();
        this.f276699k = ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).isMiniCodeDetectSwitchOn();
        boolean k3 = e.k();
        if (k3) {
            this.f276699k = false;
            this.f276698j = false;
            QLog.i("MiniRecog.MiniCodeController", 1, String.format("init return [%b %b]", Boolean.FALSE, Boolean.valueOf(k3)));
        }
        if (!f276685p || e.f(false) > 0) {
            f276685p = true;
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qrscan.minicode.MiniCodeController.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MiniCodeController.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    long q16 = MiniScanReport.q("report_tag_detect_supporttype", 0L);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - q16 > 86400000) {
                        MiniScanReport.o(MiniCodeController.this.f276697i, -1);
                        MiniScanReport.r("report_tag_detect_supporttype", currentTimeMillis);
                    }
                }
            }, 5, null, true);
        }
    }

    private synchronized void A() {
        StringBuilder sb5 = new StringBuilder("requestDownloadResourceIfNeed");
        boolean z16 = false;
        if (!f276682m && !this.f276693e) {
            if (com.tencent.mobileqq.qrscan.earlydown.c.t()) {
                this.f276693e = true;
                sb5.append(" decode 0");
            } else {
                com.tencent.mobileqq.qrscan.ipc.c.f().c(0);
                sb5.append(" decode 1");
            }
        }
        if (this.f276697i >= 0) {
            z16 = true;
        }
        if (this.f276699k && z16 && !f276683n && !this.f276694f) {
            if (g.t()) {
                this.f276694f = true;
                sb5.append(" detect 0");
            } else {
                com.tencent.mobileqq.qrscan.ipc.c.f().c(1);
                sb5.append(" detect 1");
            }
        }
        if (this.f276699k && z16 && this.f276689a == null && !this.f276695g) {
            if (com.tencent.mobileqq.qrscan.earlydown.d.t()) {
                this.f276695g = true;
                sb5.append(" model 0");
            } else {
                com.tencent.mobileqq.qrscan.ipc.c.f().c(2);
                sb5.append(" model 1");
            }
        }
        QLog.i("MiniRecog.MiniCodeController", 1, sb5.toString());
    }

    public static int h(int[] iArr, byte[] bArr, int i3, int i16) {
        if (!f276683n) {
            return -1;
        }
        try {
            YuvProxy.Yuv2Rgba(iArr, bArr, i3, i16);
            return 0;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.i("MiniRecog.MiniCodeController", 2, "Yuv2Rgba exception", th5);
            }
            return -1;
        }
    }

    public static boolean k(String str) {
        if (str != null && str.length() > 0 && !str.equals("____JAVA_EXCEPTION____") && !str.equals("____NATIVE_ERROR____") && !str.equals("____NATIVE_EXCEPTION____") && !str.startsWith("____NATIVE_ERROR____") && !str.startsWith("____NATIVE_EXCEPTION____")) {
            return true;
        }
        return false;
    }

    public static synchronized MiniCodeController p() {
        MiniCodeController miniCodeController;
        synchronized (MiniCodeController.class) {
            if (f276688s == null) {
                f276688s = new MiniCodeController();
            }
            miniCodeController = f276688s;
        }
        return miniCodeController;
    }

    private boolean s() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 != 24 && i3 != 25) {
            f276687r.split("\\|");
            return false;
        }
        return true;
    }

    public static boolean t() {
        return f276682m;
    }

    public static boolean u() {
        return f276683n;
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x017b, code lost:
    
        if (r14.f276689a != null) goto L90;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void v() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f276698j && !f276682m && com.tencent.mobileqq.qrscan.earlydown.c.t()) {
            try {
                if (com.tencent.mobileqq.qrscan.earlydown.c.u("minicode") == 0) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                f276682m = z27;
            } catch (Throwable th5) {
                QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel decode error", th5);
            }
        }
        if (this.f276697i >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f276699k && z16 && (!f276683n || this.f276689a == null)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            String s16 = g.s("QMCF_qr");
            String s17 = com.tencent.mobileqq.qrscan.earlydown.d.s();
            if (!TextUtils.isEmpty(s17) && s17.equalsIgnoreCase(s16)) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[3];
                if (s16 == null) {
                    s16 = "null";
                }
                objArr[0] = s16;
                if (s17 == null) {
                    s17 = "null";
                }
                objArr[1] = s17;
                objArr[2] = Boolean.valueOf(z18);
                QLog.i("MiniRecog.MiniCodeController", 2, String.format("loadSoAndModel checkMatch detectSoMd5=%s modelNeedMd5=%s bMatch=%b", objArr));
            }
        } else {
            z18 = false;
        }
        if (this.f276699k && z16 && !f276683n && z18 && g.t() && !s()) {
            try {
                byte u16 = g.u("QMCF_qr");
                byte u17 = g.u("yuvutil");
                if (u16 == 0 && u17 == 0) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                f276683n = z26;
            } catch (Throwable th6) {
                QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel detect error", th6);
            }
        }
        if (this.f276699k && z16 && f276683n && z18 && this.f276689a == null && com.tencent.mobileqq.qrscan.earlydown.d.t()) {
            try {
                if (f276686q == 0) {
                    f276686q = SystemClock.uptimeMillis();
                } else {
                    f276686q = 0L;
                }
                c cVar = new c(null, this.f276697i, 0, 0);
                this.f276689a = cVar;
                cVar.a(this);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(com.tencent.mobileqq.qrscan.earlydown.d.o());
                String str = f276681l;
                sb5.append(str);
                sb5.append(com.tencent.mobileqq.qrscan.earlydown.d.p("qr_detection_model.bin"));
                String sb6 = sb5.toString();
                String str2 = com.tencent.mobileqq.qrscan.earlydown.d.o() + str + com.tencent.mobileqq.qrscan.earlydown.d.p("qr_detection_model.txt");
                String str3 = com.tencent.mobileqq.qrscan.earlydown.d.o() + str + com.tencent.mobileqq.qrscan.earlydown.d.p("qr_anchor.bin");
                String d16 = e.d();
                File file = new File(d16);
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.f276689a.g(sb6, str2, str3, d16);
            } catch (Throwable th7) {
                QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel detect model error", th7);
                z19 = false;
                QLog.i("MiniRecog.MiniCodeController", 1, String.format("loadSoAndModel...... bDecodeInited=%b bDetectInited=%b bSupportDetect=%b mDecodeDpcSwitch=%b mDetectDpcSwitch=%b bModelInited=%b iDetectRuntype=%d bNeedCheckMatch=%b cost=%d(ms)", Boolean.valueOf(f276682m), Boolean.valueOf(f276683n), Boolean.valueOf(z16), Boolean.valueOf(this.f276698j), Boolean.valueOf(this.f276699k), Boolean.valueOf(z19), Integer.valueOf(this.f276697i), Boolean.valueOf(z17), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis)));
                w();
            }
        }
        z19 = true;
        QLog.i("MiniRecog.MiniCodeController", 1, String.format("loadSoAndModel...... bDecodeInited=%b bDetectInited=%b bSupportDetect=%b mDecodeDpcSwitch=%b mDetectDpcSwitch=%b bModelInited=%b iDetectRuntype=%d bNeedCheckMatch=%b cost=%d(ms)", Boolean.valueOf(f276682m), Boolean.valueOf(f276683n), Boolean.valueOf(z16), Boolean.valueOf(this.f276698j), Boolean.valueOf(this.f276699k), Boolean.valueOf(z19), Integer.valueOf(this.f276697i), Boolean.valueOf(z17), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis)));
        w();
    }

    private void w() {
        if (f276682m) {
            Iterator<WeakReference<j>> it = this.f276691c.iterator();
            while (it.hasNext()) {
                j jVar = it.next().get();
                if (jVar != null) {
                    jVar.d();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qrscan.i
    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
            return;
        }
        Iterator<WeakReference<i>> it = this.f276690b.iterator();
        while (it.hasNext()) {
            i iVar = it.next().get();
            if (iVar != null) {
                iVar.a(j3);
            }
        }
    }

    @Override // com.tencent.mobileqq.qrscan.i
    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        this.f276696h = true;
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.MiniCodeController", 2, "onDetectReady");
        }
        Iterator<WeakReference<i>> it = this.f276690b.iterator();
        while (it.hasNext()) {
            i iVar = it.next().get();
            if (iVar != null) {
                iVar.b(i3);
            }
        }
        long j3 = 0;
        if (f276686q > 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - f276686q;
            f276686q = 0L;
            j3 = uptimeMillis;
        }
        ThreadManagerV2.post(new Runnable(i3, j3) { // from class: com.tencent.mobileqq.qrscan.minicode.MiniCodeController.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f276700d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f276701e;

            {
                this.f276700d = i3;
                this.f276701e = j3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MiniCodeController.this, Integer.valueOf(i3), Long.valueOf(j3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                long q16 = MiniScanReport.q("report_tag_detect_supporttype", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - q16 > 86400000) {
                    MiniScanReport.o(MiniCodeController.this.f276697i, this.f276700d);
                    MiniScanReport.r("report_tag_detect_supporttype", currentTimeMillis);
                }
                long j16 = this.f276701e;
                if (j16 > 0 && j16 < 15000 && currentTimeMillis - MiniScanReport.q("report_tag_detect_init_internal_cost", 0L) > 86400000) {
                    MiniScanReport.m(MiniCodeController.this.f276697i, (int) this.f276701e);
                    MiniScanReport.r("report_tag_detect_init_internal_cost", currentTimeMillis);
                }
            }
        }, 5, null, true);
    }

    @Override // com.tencent.mobileqq.qrscan.i
    public void c(List<com.tencent.mobileqq.qrscan.a> list, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, Long.valueOf(j3));
            return;
        }
        Iterator<WeakReference<i>> it = this.f276690b.iterator();
        while (it.hasNext()) {
            i iVar = it.next().get();
            if (iVar != null) {
                iVar.c(list, j3);
            }
        }
    }

    @Override // com.tencent.mobileqq.qrscan.e
    public void d(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        QLog.i("MiniRecog.MiniCodeController", 1, String.format("onMiniResDownloadResult...... resType=%d suc=%b", Integer.valueOf(i3), Boolean.valueOf(z16)));
        if (z16) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        this.f276695g = true;
                    }
                } else {
                    this.f276694f = true;
                }
            } else {
                this.f276693e = true;
            }
            v();
        }
    }

    @Override // com.tencent.mobileqq.qrscan.e
    public void e(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void i(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) jVar);
            return;
        }
        Iterator<WeakReference<j>> it = this.f276691c.iterator();
        while (it.hasNext()) {
            j jVar2 = it.next().get();
            if (jVar2 != null && jVar2 == jVar) {
                return;
            }
        }
        this.f276691c.add(new WeakReference<>(jVar));
    }

    public void j(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) iVar);
            return;
        }
        Iterator<WeakReference<i>> it = this.f276690b.iterator();
        while (it.hasNext()) {
            i iVar2 = it.next().get();
            if (iVar2 != null && iVar2 == iVar) {
                return;
            }
        }
        this.f276690b.add(new WeakReference<>(iVar));
    }

    public String l(byte[] bArr, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
        return m(bArr, i3, i16, 0, 0, 0, 0, i17, i18);
    }

    public String m(byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
        }
        if (!f276682m) {
            return "";
        }
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.MiniCodeController", 2, String.format("decode [w,h,barX,barY,barW,barH]=[%d,%d,%d,%d,%d,%d] mode=%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i28)));
        }
        try {
            if (!f276684o) {
                QLog.i("MiniRecog.MiniCodeController", 1, "call nativeDecode version = " + DecodeProxy.getVersion());
                if (QLog.isColorLevel()) {
                    DecodeProxy.setLogSwitch(true);
                }
                f276684o = true;
            }
            if (i27 == 2) {
                return DecodeProxy.nativeDecode(bArr, i3, i16, i17, i18, i19, i26, i28);
            }
            if (i27 == 3) {
                return DecodeProxy.nativeWxDecode(bArr, i3, i16, i17, i18, i19, i26, i28);
            }
            String nativeDecode = DecodeProxy.nativeDecode(bArr, i3, i16, i17, i18, i19, i26, i28);
            if (!TextUtils.isEmpty(nativeDecode)) {
                return "WITHOUTAIQQ&" + nativeDecode;
            }
            String nativeWxDecode = DecodeProxy.nativeWxDecode(bArr, i3, i16, i17, i18, i19, i26, i28);
            if (!TextUtils.isEmpty(nativeWxDecode)) {
                return "WITHOUTAIWX&" + nativeWxDecode;
            }
            return nativeWxDecode;
        } catch (Throwable th5) {
            QLog.i("MiniRecog.MiniCodeController", 2, "call nativeDecode error", th5);
            return "____JAVA_EXCEPTION____";
        }
    }

    public boolean n(Bitmap bitmap, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, bitmap, Long.valueOf(j3))).booleanValue();
        }
        c cVar = this.f276689a;
        if (!f276683n || !this.f276696h || cVar == null) {
            return false;
        }
        boolean f16 = cVar.f(bitmap, j3);
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.MiniCodeController", 2, String.format("detect async exec=%b ts=%d", Boolean.valueOf(f16), Long.valueOf(j3)));
        }
        return f16;
    }

    public boolean o(Bitmap bitmap, ArrayList<com.tencent.mobileqq.qrscan.a> arrayList) {
        int i3;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) bitmap, (Object) arrayList)).booleanValue();
        }
        c cVar = this.f276689a;
        if (!f276683n || cVar == null || arrayList == null) {
            return false;
        }
        Object obj = new Object();
        boolean z18 = this.f276696h;
        if (z18) {
            i3 = 3000;
        } else {
            i3 = 5000;
        }
        int i16 = i3;
        boolean[] zArr = {false};
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a(currentTimeMillis, arrayList, obj, cVar, zArr, bitmap);
        if (z18 && cVar.f(bitmap, currentTimeMillis)) {
            z16 = true;
        } else {
            z16 = false;
        }
        zArr[0] = z16;
        if (z18 && (!z18 || !z16)) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.MiniCodeController", 2, String.format("detectSync needWait=%b bReady=%b exec=%b ts=%d", Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(zArr[0]), Long.valueOf(currentTimeMillis)));
        }
        if (z17) {
            cVar.a(aVar);
            synchronized (obj) {
                try {
                    obj.wait(i16);
                } catch (InterruptedException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("MiniRecog.MiniCodeController", 2, "detectSync wait InterruptedException", e16);
                    }
                }
            }
            cVar.j(aVar);
        }
        if (z17 && QLog.isColorLevel()) {
            QLog.i("MiniRecog.MiniCodeController", 2, "detectSync wait cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return zArr[0];
    }

    public synchronized void q(Context context, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, context, Long.valueOf(j3), str);
            return;
        }
        if (context == null) {
            return;
        }
        if (!this.f276698j && !this.f276699k) {
            return;
        }
        boolean add = this.f276692d.add(Long.valueOf(j3));
        if (add) {
            QLog.i("MiniRecog.MiniCodeController", 1, String.format("init busiHash=%d desc=%s", Long.valueOf(j3), str));
        }
        if (!add) {
            return;
        }
        com.tencent.mobileqq.qrscan.ipc.c.f().g(this);
        com.tencent.mobileqq.qrscan.ipc.c.f().a(this);
        v();
        A();
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f276696h;
    }

    public void x(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(j3), str);
            return;
        }
        if (this.f276692d.contains(Long.valueOf(j3))) {
            this.f276692d.remove(Long.valueOf(j3));
        }
        boolean isEmpty = this.f276692d.isEmpty();
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.MiniCodeController", 2, String.format("onDestroy busiHash=%d desc=%s bDoDestroy=%b", Long.valueOf(j3), str, Boolean.valueOf(isEmpty)));
        }
        if (isEmpty) {
            synchronized (this) {
                c cVar = this.f276689a;
                if (cVar != null) {
                    cVar.c();
                    this.f276689a = null;
                }
                com.tencent.mobileqq.qrscan.ipc.c.f().h(this);
                com.tencent.mobileqq.qrscan.ipc.c.f().i(this);
                f276688s = null;
            }
        }
    }

    public void y(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) jVar);
            return;
        }
        Iterator<WeakReference<j>> it = this.f276691c.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar2 = next.get();
            if (jVar2 != null && jVar2 == jVar) {
                this.f276691c.remove(next);
                return;
            }
        }
    }

    public void z(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) iVar);
            return;
        }
        Iterator<WeakReference<i>> it = this.f276690b.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            i iVar2 = next.get();
            if (iVar2 != null && iVar2 == iVar) {
                this.f276690b.remove(next);
                return;
            }
        }
    }
}
