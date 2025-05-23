package com.tencent.luggage.wxa.z8;

import android.content.Context;
import com.tencent.luggage.wxa.z8.c;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'd' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes9.dex */
public final class d {
    public static final d C;
    public static final d D;
    public static final d E;
    public static final d F;
    public static final d G;
    public static final d H;
    public static final d I;
    public static final d J;
    public static final d K;
    public static final d L;
    public static final d M;
    public static final d N;
    public static final d O;
    public static final d P;
    public static final d Q;
    public static final d R;
    public static final d S;
    public static final d T;
    public static final d U;
    public static final d V;
    public static final d W;
    public static final d X;
    public static final d Y;
    public static final d Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final d f146413a0;

    /* renamed from: b0, reason: collision with root package name */
    public static final d f146414b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final /* synthetic */ d[] f146415c0;

    /* renamed from: d, reason: collision with root package name */
    public static final d f146416d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f146417e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f146418f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f146419g;

    /* renamed from: h, reason: collision with root package name */
    public static final d f146420h;

    /* renamed from: i, reason: collision with root package name */
    public static final d f146421i;

    /* renamed from: j, reason: collision with root package name */
    public static final d f146422j;

    /* renamed from: k, reason: collision with root package name */
    public static final d f146423k;

    /* renamed from: l, reason: collision with root package name */
    public static final d f146424l;

    /* renamed from: m, reason: collision with root package name */
    public static final d f146425m;

    /* renamed from: a, reason: collision with root package name */
    public final b f146426a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f146427b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f146428c = {-1};

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f146429a = new a("EXACT", 0);

        /* renamed from: b, reason: collision with root package name */
        public static final b f146430b = new C6977b("PREFIX_STARTS_WITH", 1);

        /* renamed from: c, reason: collision with root package name */
        public static final b f146431c = new c("NOT_PLAIN", 2);

        /* renamed from: d, reason: collision with root package name */
        public static final b f146432d = new C6978d("NOT_PLAIN_NOT_ISOLATED", 3);

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ b[] f146433e = a();

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public enum a extends b {
            public a(String str, int i3) {
                super(str, i3);
            }

            @Override // com.tencent.luggage.wxa.z8.d.b
            public boolean a(com.tencent.luggage.wxa.z8.c cVar, Object obj) {
                if (cVar == obj) {
                    return true;
                }
                return false;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.z8.d$b$b, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public enum C6977b extends b {
            public C6977b(String str, int i3) {
                super(str, i3);
            }

            @Override // com.tencent.luggage.wxa.z8.d.b
            public boolean a(com.tencent.luggage.wxa.z8.c cVar, Object obj) {
                return cVar.b().startsWith((String) obj);
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public enum c extends b {
            public c(String str, int i3) {
                super(str, i3);
            }

            @Override // com.tencent.luggage.wxa.z8.d.b
            public boolean a(com.tencent.luggage.wxa.z8.c cVar, Object obj) {
                if (cVar.c() == c.a.DEFAULT) {
                    return true;
                }
                return false;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.z8.d$b$d, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public enum C6978d extends b {
            public C6978d(String str, int i3) {
                super(str, i3);
            }

            @Override // com.tencent.luggage.wxa.z8.d.b
            public boolean a(com.tencent.luggage.wxa.z8.c cVar, Object obj) {
                if (b.f146431c.a(cVar, obj) && cVar.c() != c.a.ISOLATED) {
                    return true;
                }
                return false;
            }
        }

        public b(String str, int i3) {
        }

        public static /* synthetic */ b[] a() {
            return new b[]{f146429a, f146430b, f146431c, f146432d};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f146433e.clone();
        }

        public abstract boolean a(com.tencent.luggage.wxa.z8.c cVar, Object obj);
    }

    static {
        b bVar = b.f146429a;
        f146416d = new d("MATCH_MM", 0, bVar, c.f146390e);
        f146417e = new d("MATCH_PUSH", 1, bVar, c.f146392f);
        f146418f = new d("MATCH_TOOLS", 2, bVar, c.f146394g);
        b bVar2 = b.f146430b;
        f146419g = new d("MATCH_APPBRAND", 3, bVar2, ":appbrand");
        f146420h = new d("MATCH_APPBRAND1", 4, bVar, c.f146398i);
        f146421i = new d("MATCH_SANDBOX", 5, bVar, c.f146404m);
        f146422j = new d("MATCH_EXDEVICE", 6, bVar, c.C);
        f146423k = new d("MATCH_SUPPORT", 7, bVar, c.D);
        f146424l = new d("MATCH_CUPLOADER", 8, bVar, c.E);
        f146425m = new d("MATCH_PATCH", 9, bVar, c.F);
        C = new d("MATCH_HOTPOT_DOTDOT", 10, bVar, c.G);
        D = new d("MATCH_FALLBACK", 11, bVar, c.H);
        E = new d("MATCH_DEXOPT", 12, bVar, c.I);
        F = new d("MATCH_RECOVERY", 13, bVar, c.J);
        G = new d("MATCH_NOSPACE", 14, bVar, c.K);
        H = new d("MATCH_JECTL", 15, bVar, c.L);
        I = new d("MATCH_OPENGL_DETECTOR", 16, bVar, c.M);
        J = new d("MATCH_RUBBISHBIN", 17, bVar, c.N);
        K = new d("MATCH_ISOLATED_PROCESS", 18, bVar2, ":isolated_process");
        L = new d("MATCH_XWEB_SANDBOXED_PROCESS", 19, bVar2, ":xweb_sandboxed_process_");
        M = new d("MATCH_XWEB_SANDBOXED_PROCESS_EX", 20, bVar2, ":xweb_sandboxed_process_ex_");
        N = new d("MATCH_XWEB_SANDBOXED_PROCESS_EX_APPBRAND", 21, bVar2, ":xweb_sandboxed_process_ex_appbrand_");
        O = new d("MATCH_XWEB_PRIVILEGED_PROCESS", 22, bVar2, ":xweb_privileged_process_");
        P = new d("MATCH_XWEB_PRIVILEGED_PROCESS_APPBRAND", 23, bVar2, ":xweb_privileged_process_appbrand_");
        Q = new d("MATCH_RES_CAN_WORKER", 24, bVar, c.X);
        R = new d("MATCH_EXTMIG", 25, bVar, c.Y);
        S = new d("MATCH_BACKTRACE__", 26, bVar, c.Z);
        T = new d("MATCH_TM_ASSISTANT_DOWNLOAD_SDK_SERVICE", 27, bVar, c.f146386a0);
        U = new d("MATCH_SWITCH", 28, bVar, c.f146387b0);
        V = new d("MATCH_LITE", 29, bVar, c.f146389d0);
        W = new d("MATCH_HLD", 30, bVar, c.f146388c0);
        X = new d("MATCH_PLAYCORE_MISSING_SPLITS_ACTIVITY", 31, bVar, c.f146391e0);
        Y = new d("MATCH_HLDFL", 32, bVar, c.f146393f0);
        Z = new d("MATCH_MAGIC_EMOJI", 33, bVar, c.f146395g0);
        f146413a0 = new d("MATCH_NOT_PLAIN_PROCESSES", 34, b.f146431c, null);
        f146414b0 = new d("MATCH_NOT_PLAIN_NOT_ISOLATED_PROCESSES", 35, b.f146432d, null);
        f146415c0 = a();
    }

    public d(String str, int i3, b bVar, Object obj) {
        this.f146426a = bVar;
        this.f146427b = obj;
    }

    public static /* synthetic */ d[] a() {
        return new d[]{f146416d, f146417e, f146418f, f146419g, f146420h, f146421i, f146422j, f146423k, f146424l, f146425m, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, f146413a0, f146414b0};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f146415c0.clone();
    }

    public final boolean a(Context context) {
        int[] iArr = this.f146428c;
        if (iArr[0] == -1) {
            synchronized (iArr) {
                if (this.f146428c[0] == -1) {
                    c a16 = c.a(context);
                    if (a16 == null) {
                        return false;
                    }
                    this.f146428c[0] = this.f146426a.a(a16, this.f146427b) ? 1 : 0;
                }
            }
        }
        return this.f146428c[0] == 1;
    }
}
