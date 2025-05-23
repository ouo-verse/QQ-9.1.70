package com.tencent.mobileqq;

import android.os.SystemClock;
import android.os.Trace;
import android.util.Log;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringBuilderJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/DebugTrace;", "", "a", "Step", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class DebugTrace {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    private static final int f154063b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final HashMap<Integer, Long> f154064c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final StringBuilder f154065d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f154066e;

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f154067f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/DebugTrace$Step;", "", "(Ljava/lang/String;I)V", "click_2_open", "app_attachBasecontext", "app_onCreate", "activity_onCreate", "activity_onResume", "fragment_onCreate", "fragment_onActivityCreate", "fragment_onResume", "webview_loadUrl", "webview_loadDelay", "webview_pageload", "activity_onWindowFocusChanged", "kernel_initdata", "kernel_initx5", "step_initx5", "step_setTbsUserData", "kernel_initengine", "kernel_initwebview", "kernel_loadurl", "kernel_inituiframe", "kernel_inituicontent", "kernel_inittitlebar", "kernel_initbottom", "kernel_initfinal", "step_end", "webview_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Step {
        private static final /* synthetic */ Step[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Step activity_onCreate;
        public static final Step activity_onResume;
        public static final Step activity_onWindowFocusChanged;
        public static final Step app_attachBasecontext;
        public static final Step app_onCreate;
        public static final Step click_2_open;
        public static final Step fragment_onActivityCreate;
        public static final Step fragment_onCreate;
        public static final Step fragment_onResume;
        public static final Step kernel_initbottom;
        public static final Step kernel_initdata;
        public static final Step kernel_initengine;
        public static final Step kernel_initfinal;
        public static final Step kernel_inittitlebar;
        public static final Step kernel_inituicontent;
        public static final Step kernel_inituiframe;
        public static final Step kernel_initwebview;
        public static final Step kernel_initx5;
        public static final Step kernel_loadurl;
        public static final Step step_end;
        public static final Step step_initx5;
        public static final Step step_setTbsUserData;
        public static final Step webview_loadDelay;
        public static final Step webview_loadUrl;
        public static final Step webview_pageload;

        private static final /* synthetic */ Step[] $values() {
            return new Step[]{click_2_open, app_attachBasecontext, app_onCreate, activity_onCreate, activity_onResume, fragment_onCreate, fragment_onActivityCreate, fragment_onResume, webview_loadUrl, webview_loadDelay, webview_pageload, activity_onWindowFocusChanged, kernel_initdata, kernel_initx5, step_initx5, step_setTbsUserData, kernel_initengine, kernel_initwebview, kernel_loadurl, kernel_inituiframe, kernel_inituicontent, kernel_inittitlebar, kernel_initbottom, kernel_initfinal, step_end};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34819);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            click_2_open = new Step("click_2_open", 0);
            app_attachBasecontext = new Step("app_attachBasecontext", 1);
            app_onCreate = new Step("app_onCreate", 2);
            activity_onCreate = new Step("activity_onCreate", 3);
            activity_onResume = new Step("activity_onResume", 4);
            fragment_onCreate = new Step("fragment_onCreate", 5);
            fragment_onActivityCreate = new Step("fragment_onActivityCreate", 6);
            fragment_onResume = new Step("fragment_onResume", 7);
            webview_loadUrl = new Step("webview_loadUrl", 8);
            webview_loadDelay = new Step("webview_loadDelay", 9);
            webview_pageload = new Step("webview_pageload", 10);
            activity_onWindowFocusChanged = new Step("activity_onWindowFocusChanged", 11);
            kernel_initdata = new Step("kernel_initdata", 12);
            kernel_initx5 = new Step("kernel_initx5", 13);
            step_initx5 = new Step("step_initx5", 14);
            step_setTbsUserData = new Step("step_setTbsUserData", 15);
            kernel_initengine = new Step("kernel_initengine", 16);
            kernel_initwebview = new Step("kernel_initwebview", 17);
            kernel_loadurl = new Step("kernel_loadurl", 18);
            kernel_inituiframe = new Step("kernel_inituiframe", 19);
            kernel_inituicontent = new Step("kernel_inituicontent", 20);
            kernel_inittitlebar = new Step("kernel_inittitlebar", 21);
            kernel_initbottom = new Step("kernel_initbottom", 22);
            kernel_initfinal = new Step("kernel_initfinal", 23);
            step_end = new Step("step_end", 24);
            $VALUES = $values();
        }

        Step(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static Step valueOf(String str) {
            return (Step) Enum.valueOf(Step.class, str);
        }

        public static Step[] values() {
            return (Step[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0007R3\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u0013j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t`\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR(\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b!\u0010\"\u0012\u0004\b'\u0010(\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010)\u001a\u00020 8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b)\u0010\"\u0012\u0004\b+\u0010(\u001a\u0004\b*\u0010$R\u0014\u0010,\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/DebugTrace$a;", "", "", "l", "Lcom/tencent/mobileqq/DebugTrace$Step;", "step", "b", "a", "j", "", "ts", "k", "g", tl.h.F, "", "text", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "type", "i", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "tsMap", "Ljava/util/HashMap;", "f", "()Ljava/util/HashMap;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sbAll", "Ljava/lang/StringBuilder;", "c", "()Ljava/lang/StringBuilder;", "", "sysTraceOn", "Z", "d", "()Z", "setSysTraceOn", "(Z)V", "getSysTraceOn$annotations", "()V", "timeTraceOn", "e", "getTimeTraceOn$annotations", "TAG", "Ljava/lang/String;", "<init>", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.DebugTrace$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.DebugTrace$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C7076a<T> implements Comparator {
            static IPatchRedirector $redirector_;

            public C7076a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((Number) ((Pair) t16).component2()).longValue()), Long.valueOf(((Number) ((Pair) t17).component2()).longValue()));
                    return compareValues;
                }
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
                return;
            }
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) defaultConstructorMarker);
        }

        private final void l() {
            Method declaredMethod = Class.forName("android.os.Trace").getDeclaredMethod("setAppTracingAllowed", Boolean.TYPE);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "trace.getDeclaredMethod(\u2026imitiveType\n            )");
            declaredMethod.invoke(null, Boolean.TRUE);
            Log.i("WVPerf.DebugTrace", "setAllowTrace");
        }

        @NotNull
        public final StringBuilder c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return DebugTrace.f154065d;
            }
            return (StringBuilder) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return DebugTrace.f154066e;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return DebugTrace.f154067f;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }

        @NotNull
        public final HashMap<Integer, Long> f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return DebugTrace.f154064c;
            }
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @JvmStatic
        public final void g(@NotNull Step step) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) step);
            } else {
                Intrinsics.checkNotNullParameter(step, "step");
                h(step, SystemClock.uptimeMillis());
            }
        }

        @JvmStatic
        public final void h(@NotNull Step step, long ts5) {
            List list;
            List sortedWith;
            Map map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, step, Long.valueOf(ts5));
                return;
            }
            Intrinsics.checkNotNullParameter(step, "step");
            if (!e()) {
                return;
            }
            a(step);
            Long l3 = f().get(Integer.valueOf(step.ordinal()));
            if (l3 == null) {
                l3 = Long.valueOf(ts5);
            }
            long longValue = l3.longValue();
            String str = "[" + step.name() + "] cost = " + (ts5 - longValue) + " ms";
            StringBuilder c16 = c();
            c16.append('\n');
            c16.append(str);
            Log.i("WVPerf.DebugTrace", str);
            if (d()) {
                Trace.endSection();
            }
            if (step == Step.step_end) {
                StringBuilder sb5 = new StringBuilder();
                Long l16 = f().get(Integer.valueOf(Step.click_2_open.ordinal()));
                if (l16 == null) {
                    l16 = 0L;
                }
                long longValue2 = l16.longValue();
                list = MapsKt___MapsKt.toList(f());
                sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new C7076a());
                map = MapsKt__MapsKt.toMap(sortedWith);
                for (Map.Entry entry : map.entrySet()) {
                    long longValue3 = ((Number) entry.getValue()).longValue() - longValue2;
                    sb5.append("\n[" + Step.values()[((Number) entry.getKey()).intValue()] + "] begin = " + longValue3 + " ms");
                }
                f().clear();
                Log.i("WVPerf.DebugTrace", String.valueOf(sb5));
                StringBuilder c17 = c();
                c17.append('\n');
                c17.append((CharSequence) sb5);
                c17.append("\n\n");
                String sb6 = c().toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "sbAll.toString()");
                m(sb6);
                StringsKt__StringBuilderJVMKt.clear(c());
            }
        }

        @JvmStatic
        public final void i(@NotNull String type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) type);
                return;
            }
            Intrinsics.checkNotNullParameter(type, "type");
            Log.i("WVPerf.DebugTrace", "runType: " + type);
            StringBuilder c16 = c();
            c16.append("\n");
            c16.append("runType: ");
            c16.append(type);
            c16.append("\n");
        }

        @JvmStatic
        public final void j(@NotNull Step step) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) step);
                return;
            }
            Intrinsics.checkNotNullParameter(step, "step");
            if (!e()) {
                return;
            }
            k(step, SystemClock.uptimeMillis());
        }

        @JvmStatic
        public final void k(@NotNull Step step, long ts5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, step, Long.valueOf(ts5));
                return;
            }
            Intrinsics.checkNotNullParameter(step, "step");
            if (!e()) {
                return;
            }
            b(step);
            if (step == Step.app_attachBasecontext && d()) {
                l();
            }
            if (step == Step.activity_onCreate) {
                long uptimeMillis = SystemClock.uptimeMillis();
                f().put(Integer.valueOf(step.ordinal()), Long.valueOf(uptimeMillis));
                f().put(Integer.valueOf(Step.click_2_open.ordinal()), Long.valueOf(ts5));
                String str = "[click_2_open] cost = " + (uptimeMillis - ts5) + " ms";
                Log.i("WVPerf.DebugTrace", str);
                StringBuilder c16 = c();
                c16.append('\n');
                c16.append(str);
            } else {
                f().put(Integer.valueOf(step.ordinal()), Long.valueOf(ts5));
            }
            Log.i("WVPerf.DebugTrace", "[" + step.name() + "] start");
            if (d()) {
                String upperCase = step.name().toUpperCase();
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
                Trace.beginSection(upperCase);
            }
        }

        public final void m(@NotNull String text) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) text);
                return;
            }
            Intrinsics.checkNotNullParameter(text, "text");
            String str = MobileQQ.sMobileQQ.getExternalCacheDir() + "/debugtrace.txt";
            Log.i("WVPerf.DebugTrace", "writeDebugTrace to:" + str + "\n" + text);
            com.tencent.mobileqq.webview.util.s.m(str, text, false, true);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        private final void a(Step step) {
        }

        private final void b(Step step) {
        }
    }

    static {
        boolean z16;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34826);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new Companion(null);
        f154063b = 207257600;
        f154064c = new HashMap<>();
        f154065d = new StringBuilder();
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && ((Boolean) com.tencent.mobileqq.webview.util.t.INSTANCE.a().b("debug_time_trace_log", Boolean.FALSE)).booleanValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        f154067f = z16;
    }

    @JvmStatic
    public static final void e(@NotNull Step step) {
        INSTANCE.g(step);
    }

    @JvmStatic
    public static final void f(@NotNull Step step, long j3) {
        INSTANCE.h(step, j3);
    }

    @JvmStatic
    public static final void g(@NotNull Step step) {
        INSTANCE.j(step);
    }

    @JvmStatic
    public static final void h(@NotNull Step step, long j3) {
        INSTANCE.k(step, j3);
    }
}
