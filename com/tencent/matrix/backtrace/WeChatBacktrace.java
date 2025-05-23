package com.tencent.matrix.backtrace;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.xlog.XLogNative;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.util.AbiUtil;
import java.io.File;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WeChatBacktrace {

    /* renamed from: g, reason: collision with root package name */
    private static boolean f151425g = false;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f151426a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f151427b;

    /* renamed from: c, reason: collision with root package name */
    private volatile b f151428c;

    /* renamed from: d, reason: collision with root package name */
    private final WarmUpDelegate f151429d = new WarmUpDelegate();

    /* renamed from: e, reason: collision with root package name */
    private final Handler f151430e = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name */
    private boolean f151431f = false;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum Mode {
        Fp(0),
        Quicken(1),
        Dwarf(2),
        FpUntilQuickenWarmedUp(3),
        DwarfUntilQuickenWarmedUp(4);

        int value;

        Mode(int i3) {
            this.value = i3;
        }

        @Override // java.lang.Enum
        public String toString() {
            int i3 = a.f151432a[ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return "Unreachable.";
                            }
                            return "Use dwarf-based backtrace before quicken has warmed up.";
                        }
                        return "Use fp-based backtrace before quicken has warmed up.";
                    }
                    return "Dwarf-based.";
                }
                return "WeChat QuickenUnwindTable-based.";
            }
            return "FramePointer-based.";
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum WarmUpTiming {
        WhileScreenOff,
        WhileCharging,
        PostStartup
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f151432a;

        static {
            int[] iArr = new int[Mode.values().length];
            f151432a = iArr;
            try {
                iArr[Mode.Fp.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f151432a[Mode.Quicken.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f151432a[Mode.Dwarf.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f151432a[Mode.FpUntilQuickenWarmedUp.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f151432a[Mode.DwarfUntilQuickenWarmedUp.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        Context f151433a;

        /* renamed from: b, reason: collision with root package name */
        String f151434b;

        /* renamed from: c, reason: collision with root package name */
        HashSet<String> f151435c;

        /* renamed from: d, reason: collision with root package name */
        Mode f151436d;

        /* renamed from: e, reason: collision with root package name */
        boolean f151437e;

        /* renamed from: f, reason: collision with root package name */
        boolean f151438f;

        /* renamed from: g, reason: collision with root package name */
        boolean f151439g;

        /* renamed from: h, reason: collision with root package name */
        boolean f151440h;

        /* renamed from: i, reason: collision with root package name */
        boolean f151441i;

        /* renamed from: j, reason: collision with root package name */
        WarmUpTiming f151442j;

        /* renamed from: k, reason: collision with root package name */
        long f151443k;

        /* renamed from: l, reason: collision with root package name */
        boolean f151444l;

        /* renamed from: m, reason: collision with root package name */
        boolean f151445m;

        /* renamed from: n, reason: collision with root package name */
        String f151446n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f151447o;

        /* renamed from: p, reason: collision with root package name */
        private final WeChatBacktrace f151448p;

        b(Context context, WeChatBacktrace weChatBacktrace) {
            HashSet<String> hashSet = new HashSet<>();
            this.f151435c = hashSet;
            this.f151436d = Mode.Quicken;
            this.f151437e = false;
            this.f151438f = false;
            this.f151439g = true;
            this.f151440h = false;
            this.f151441i = true;
            this.f151442j = WarmUpTiming.WhileScreenOff;
            this.f151443k = 3000L;
            this.f151444l = false;
            this.f151445m = false;
            this.f151446n = null;
            this.f151447o = false;
            this.f151433a = context;
            this.f151448p = weChatBacktrace;
            hashSet.add(context.getApplicationInfo().nativeLibraryDir);
            this.f151435c.add(WeChatBacktrace.j());
            this.f151435c.add(WeChatBacktrace.i(context));
            this.f151440h = com.tencent.matrix.backtrace.a.c(this.f151433a);
        }

        public void a() {
            if (this.f151447o) {
                return;
            }
            this.f151447o = true;
            this.f151448p.f(this);
        }

        public b b(Mode mode) {
            if (this.f151447o) {
                return this;
            }
            if (mode != null) {
                this.f151436d = mode;
            }
            return this;
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\nWeChat backtrace configurations: \n>>> Backtrace Mode: ");
            sb5.append(this.f151436d);
            sb5.append("\n>>> Quicken always on: ");
            sb5.append(this.f151438f);
            sb5.append("\n>>> Saving Path: ");
            String str = this.f151434b;
            if (str == null) {
                str = com.tencent.matrix.backtrace.c.b(this);
            }
            sb5.append(str);
            sb5.append("\n>>> Custom Library Loader: ");
            sb5.append(false);
            sb5.append("\n>>> Directories to Warm-up: ");
            sb5.append(this.f151435c.toString());
            sb5.append("\n>>> Is Warm-up Process: ");
            sb5.append(this.f151440h);
            sb5.append("\n>>> Warm-up Timing: ");
            sb5.append(this.f151442j);
            sb5.append("\n>>> Warm-up Delay: ");
            sb5.append(this.f151443k);
            sb5.append("ms\n>>> Warm-up in isolate process: ");
            sb5.append(this.f151441i);
            sb5.append("\n>>> Enable logger: ");
            sb5.append(this.f151444l);
            sb5.append("\n>>> Enable Isolate Process logger: ");
            sb5.append(this.f151445m);
            sb5.append("\n>>> Path of XLog: ");
            sb5.append(this.f151446n);
            sb5.append("\n>>> Cool-down: ");
            sb5.append(this.f151437e);
            sb5.append("\n>>> Cool-down if Apk Updated: ");
            sb5.append(this.f151439g);
            sb5.append("\n");
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void load(String str);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final WeChatBacktrace f151449a = new WeChatBacktrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(b bVar) {
        if (p(bVar)) {
            g51.b.c("Matrix.Backtrace", "Isolate process does not need any configuration.", new Object[0]);
            return;
        }
        boolean z16 = bVar.f151441i;
        n(null);
        XLogNative.a(bVar.f151446n);
        h(bVar.f151444l);
        g51.b.c("Matrix.Backtrace", bVar.toString(), new Object[0]);
        Mode mode = bVar.f151436d;
        Mode mode2 = Mode.Fp;
        if (mode == mode2 || mode == Mode.Dwarf) {
            WeChatBacktraceNative.setBacktraceMode(mode.value);
        }
        Mode mode3 = bVar.f151436d;
        Mode mode4 = Mode.Quicken;
        if (mode3 == mode4 || mode3 == Mode.FpUntilQuickenWarmedUp || mode3 == Mode.DwarfUntilQuickenWarmedUp || bVar.f151438f) {
            String p16 = com.tencent.matrix.backtrace.c.p(bVar);
            g51.b.c("Matrix.Backtrace", "Set saving path: %s", p16);
            new File(p16).mkdirs();
            String str = File.separator;
            if (!p16.endsWith(str)) {
                p16 = p16 + str;
            }
            this.f151429d.s(p16);
            g(bVar);
            this.f151429d.o(bVar);
            boolean e16 = com.tencent.matrix.backtrace.c.e(bVar.f151433a);
            Mode mode5 = bVar.f151436d;
            if (mode5 == mode4 || !bVar.f151438f) {
                if (!e16) {
                    if (mode5 != Mode.FpUntilQuickenWarmedUp) {
                        if (mode5 == Mode.DwarfUntilQuickenWarmedUp) {
                            mode2 = Mode.Dwarf;
                        }
                    }
                    WeChatBacktraceNative.setBacktraceMode(mode2.value);
                }
                mode2 = mode4;
                WeChatBacktraceNative.setBacktraceMode(mode2.value);
            }
            g51.b.c("Matrix.Backtrace", "Has warmed up: %s", Boolean.valueOf(e16));
            WeChatBacktraceNative.setWarmedUp(e16);
            q();
            if (!bVar.f151440h) {
                this.f151429d.p(bVar, bVar.f151436d);
            }
        }
        this.f151427b = true;
    }

    private void g(b bVar) {
        if (bVar.f151440h) {
            File q16 = com.tencent.matrix.backtrace.c.q(bVar.f151433a);
            if (bVar.f151439g && q16.exists()) {
                String k3 = com.tencent.matrix.backtrace.c.k(q16, 4096);
                if (k3 == null) {
                    bVar.f151437e = true;
                } else if (!k3.split("\n")[0].equalsIgnoreCase(bVar.f151433a.getApplicationInfo().nativeLibraryDir)) {
                    g51.b.c("Matrix.Backtrace", "Apk updated, remove warmed-up file.", new Object[0]);
                    bVar.f151437e = true;
                }
            }
            if (bVar.f151437e) {
                q16.delete();
                com.tencent.matrix.backtrace.c.n(bVar.f151433a).delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(boolean z16) {
        WeChatBacktraceNative.enableLogger(z16);
    }

    public static String i(Context context) {
        String str;
        if (!l()) {
            str = AbiUtil.ARM;
        } else {
            str = ResourceAttributes.HostArchValues.ARM64;
        }
        return new File(new File(context.getApplicationInfo().nativeLibraryDir).getParentFile().getParentFile(), "/oat/" + str + "/base.odex").getAbsolutePath();
    }

    public static String j() {
        if (Build.VERSION.SDK_INT >= 29) {
            if (!l()) {
                return "/apex/com.android.runtime/lib/";
            }
            return "/apex/com.android.runtime/lib64/";
        }
        if (!l()) {
            return "/system/lib/";
        }
        return "/system/lib64/";
    }

    public static WeChatBacktrace k() {
        return d.f151449a;
    }

    public static boolean l() {
        String str = Build.CPU_ABI;
        if (!"arm64-v8a".equalsIgnoreCase(str) && !"x86_64".equalsIgnoreCase(str) && !"mips64".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m() {
        System.loadLibrary("wechatbacktrace");
    }

    public static void n(c cVar) {
        if (f151425g) {
            return;
        }
        if (cVar == null) {
            m();
        } else {
            g51.b.c("Matrix.Backtrace", "Using custom library loader: %s.", cVar);
            cVar.load("wechatbacktrace");
        }
        f151425g = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.f151426a && this.f151427b) {
            this.f151429d.r();
        }
    }

    private boolean p(b bVar) {
        String a16 = com.tencent.matrix.backtrace.a.a(bVar.f151433a);
        if (a16 != null && a16.endsWith(com.tencent.bugly.matrix.backtrace.WeChatBacktrace.ISOLATE_PROCESS_SUFFIX)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f151431f) {
            return;
        }
        this.f151431f = false;
        this.f151430e.postDelayed(new Runnable() { // from class: com.tencent.matrix.backtrace.WeChatBacktrace.1
            @Override // java.lang.Runnable
            public void run() {
                WeChatBacktrace.this.o();
                WeChatBacktrace.this.f151431f = false;
                WeChatBacktrace.this.q();
            }
        }, 21600000L);
    }

    public synchronized b e(Context context) {
        if (this.f151428c != null) {
            return this.f151428c;
        }
        this.f151428c = new b(context, this);
        this.f151426a = true;
        return this.f151428c;
    }
}
