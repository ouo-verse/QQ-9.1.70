package com.tencent.luggage.wxa.z8;

import android.content.Context;
import com.tencent.bugly.matrix.backtrace.WeChatBacktrace;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
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
public final class c {
    public static final c C;
    public static final c D;
    public static final c E;
    public static final c F;
    public static final c G;
    public static final c H;
    public static final c I;
    public static final c J;
    public static final c K;
    public static final c L;
    public static final c M;
    public static final c N;
    public static final c O;
    public static final c P;
    public static final c Q;
    public static final c R;
    public static final c S;
    public static final c T;
    public static final c U;
    public static final c V;
    public static final c W;
    public static final c X;
    public static final c Y;
    public static final c Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final c f146386a0;

    /* renamed from: b0, reason: collision with root package name */
    public static final c f146387b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final c f146388c0;

    /* renamed from: d0, reason: collision with root package name */
    public static final c f146389d0;

    /* renamed from: e, reason: collision with root package name */
    public static final c f146390e;

    /* renamed from: e0, reason: collision with root package name */
    public static final c f146391e0;

    /* renamed from: f, reason: collision with root package name */
    public static final c f146392f;

    /* renamed from: f0, reason: collision with root package name */
    public static final c f146393f0;

    /* renamed from: g, reason: collision with root package name */
    public static final c f146394g;

    /* renamed from: g0, reason: collision with root package name */
    public static final c f146395g0;

    /* renamed from: h, reason: collision with root package name */
    public static final c f146396h;

    /* renamed from: h0, reason: collision with root package name */
    public static final c f146397h0;

    /* renamed from: i, reason: collision with root package name */
    public static final c f146398i;

    /* renamed from: i0, reason: collision with root package name */
    public static final c[] f146399i0;

    /* renamed from: j, reason: collision with root package name */
    public static final c f146400j;

    /* renamed from: j0, reason: collision with root package name */
    public static final /* synthetic */ c[] f146401j0;

    /* renamed from: k, reason: collision with root package name */
    public static final c f146402k;

    /* renamed from: l, reason: collision with root package name */
    public static final c f146403l;

    /* renamed from: m, reason: collision with root package name */
    public static final c f146404m;

    /* renamed from: a, reason: collision with root package name */
    public final String f146405a;

    /* renamed from: b, reason: collision with root package name */
    public final String f146406b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f146407c;

    /* renamed from: d, reason: collision with root package name */
    public final a f146408d;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum a {
        DEFAULT,
        CLEAN,
        ISOLATED
    }

    static {
        a aVar = a.DEFAULT;
        f146390e = new c("MM", 0, "", "MM", true, aVar);
        f146392f = new c("PUSH", 1, ":push", "PUSH", false, aVar);
        f146394g = new c("TOOLS", 2, ":tools", "TOOL", true, aVar);
        f146396h = new c("APPBRAND0", 3, ":appbrand0", "APPBRAND0", true, aVar);
        f146398i = new c("APPBRAND1", 4, ":appbrand1", "APPBRAND1", true, aVar);
        f146400j = new c("APPBRAND2", 5, ":appbrand2", "APPBRAND2", true, aVar);
        f146402k = new c("APPBRAND3", 6, ":appbrand3", "APPBRAND3", true, aVar);
        f146403l = new c("APPBRAND4", 7, ":appbrand4", "APPBRAND4", true, aVar);
        f146404m = new c("SANDBOX", 8, ":sandbox", "SANDBOX", true, aVar);
        C = new c("EXDEVICE", 9, ":exdevice", "EXDEVICE", false, aVar);
        D = new c("SUPPORT", 10, ":support", "SUPPORT", true, aVar);
        a aVar2 = a.CLEAN;
        E = new c("CUPLOADER", 11, ":cuploader", null, false, aVar2);
        F = new c("PATCH", 12, ":patch", "PATCH", false, aVar);
        G = new c("HOTPOT_DOTDOT", 13, ":hotpot..", "HOTPOT..", false, aVar2);
        H = new c("FALLBACK", 14, ":fallback", null, false, aVar2);
        I = new c("DEXOPT", 15, ":dexopt", null, false, aVar2);
        J = new c("RECOVERY", 16, ":recovery", "RECOVERY", true, aVar2);
        K = new c("NOSPACE", 17, ":nospace", null, true, aVar);
        L = new c("JECTL", 18, ":jectl", "JECTL", false, aVar2);
        M = new c("OPENGL_DETECTOR", 19, ":opengl_detector", "OPENGL_DETECTOR", false, aVar2);
        N = new c("RUBBISHBIN", 20, ":rubbishbin", "RUBBISHBIN", false, aVar2);
        a aVar3 = a.ISOLATED;
        O = new c("ISOLATED_PROCESS0", 21, ":isolated_process0", null, true, aVar3);
        P = new c("ISOLATED_PROCESS1", 22, ":isolated_process1", null, true, aVar3);
        Q = new c("XWEB_SANDBOXED_PROCESS_0", 23, ":xweb_sandboxed_process_0", null, true, aVar3);
        R = new c("XWEB_SANDBOXED_PROCESS_1", 24, ":xweb_sandboxed_process_1", null, true, aVar3);
        S = new c("XWEB_SANDBOXED_PROCESS_EX_0", 25, ":xweb_sandboxed_process_ex_0", null, true, aVar3);
        T = new c("XWEB_SANDBOXED_PROCESS_EX_1", 26, ":xweb_sandboxed_process_ex_1", null, true, aVar3);
        U = new c("XWEB_SANDBOXED_PROCESS_EX_APPBRAND_0", 27, ":xweb_sandboxed_process_ex_appbrand_0", null, true, aVar3);
        V = new c("XWEB_PRIVILEGED_PROCESS_0", 28, ":xweb_privileged_process_0", null, true, aVar3);
        W = new c("XWEB_PRIVILEGED_PROCESS_APPBRAND_0", 29, ":xweb_privileged_process_appbrand_0", null, true, aVar3);
        X = new c("RES_CAN_WORKER", 30, ":res_can_worker", null, false, aVar2);
        Y = new c("EXTMIG", 31, ":extmig", "EXTMIG", true, aVar2);
        Z = new c("BACKTRACE__", 32, WeChatBacktrace.ISOLATE_PROCESS_SUFFIX, "BACKTRACE__", false, aVar2);
        f146386a0 = new c("TM_ASSISTANT_DOWNLOAD_SDK_SERVICE", 33, ":TMAssistantDownloadSDKService", null, false, aVar);
        f146387b0 = new c("SWITCH", 34, ":switch", "SWITCH", true, aVar);
        f146388c0 = new c("HLD", 35, ":hld", "HLD", true, aVar);
        f146389d0 = new c("LITE", 36, ":lite", "LITE", true, aVar);
        f146391e0 = new c("PLAYCORE_MISSING_SPLITS_ACTIVITY", 37, ":playcore_missing_splits_activity", null, true, aVar);
        f146393f0 = new c("HLDFL", 38, ":hldfl", "HLDFL", true, aVar);
        f146395g0 = new c("MAGIC_EMOJI", 39, ":magic_emoji", "ME", false, aVar2);
        f146397h0 = new c("KILL_PROCESSS_HELPER", 40, ":killprocesshelper", null, true, aVar2);
        f146401j0 = a();
        f146399i0 = new c[]{null};
    }

    public c(String str, int i3, String str2, String str3, boolean z16, a aVar) {
        this.f146405a = str2;
        this.f146406b = str3;
        this.f146407c = z16;
        this.f146408d = aVar;
    }

    public static /* synthetic */ c[] a() {
        return new c[]{f146390e, f146392f, f146394g, f146396h, f146398i, f146400j, f146402k, f146403l, f146404m, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, f146386a0, f146387b0, f146388c0, f146389d0, f146391e0, f146393f0, f146395g0, f146397h0};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f146401j0.clone();
    }

    public String b() {
        return this.f146405a;
    }

    public a c() {
        return this.f146408d;
    }

    public static c a(Context context) {
        c[] cVarArr = f146399i0;
        if (cVarArr[0] == null) {
            synchronized (cVarArr) {
                if (cVarArr[0] == null) {
                    String b16 = com.tencent.luggage.wxa.so.d.b(context);
                    for (c cVar : values()) {
                        String b17 = cVar.b();
                        if (!b17.equals(b16)) {
                            if (cVar != f146390e) {
                                if (b16.startsWith(b17 + ":")) {
                                }
                            }
                        }
                        f146399i0[0] = cVar;
                        break;
                    }
                    if (f146399i0[0] == null) {
                        com.tencent.luggage.wxa.yp.b.b("MicroMsg.ProcessDescriptor", "Fail to get current process descriptor, curr_process_suffix: %s", b16);
                    }
                }
            }
        }
        return f146399i0[0];
    }

    public static boolean b(Context context) {
        return a(context).c() == a.ISOLATED;
    }
}
