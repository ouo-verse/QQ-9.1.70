package com.tencent.qqnt.trace;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\u0011B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002J\u001f\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\u00028\u0000\"\b\b\u0000\u0010\u0002*\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0004\b\r\u0010\u000eR8\u0010\u0013\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\u000fj\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u0001`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012RH\u0010\u0019\u001a6\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0015*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003 \u0015*\u001a\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0015*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003\u0018\u00010\u00160\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/trace/g;", "", "T", "Ljava/lang/Class;", "clazz", "d", "(Ljava/lang/Class;)Ljava/lang/Object;", "", "c", PushClientConstants.TAG_CLASS_NAME, "f", "(Ljava/lang/String;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "e", "(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "apiInstances", "", "kotlin.jvm.PlatformType", "", "b", "Ljava/util/Set;", "missApiClasses", "<init>", "()V", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final g f362340d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Class<?>, Object> apiInstances;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Set<Class<?>> missApiClasses;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u000eJ'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/trace/g$a;", "", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "T", "Ljava/lang/Class;", "clazz", "a", "(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/trace/g;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/qqnt/trace/g;", "b", "()Lcom/tencent/qqnt/trace/g;", "getInstance$annotations", "()V", "", "FALLBACK_CLASS_SUFFIX", "Ljava/lang/String;", "TAG", "<init>", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.trace.g$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @NotNull
        public final <T extends QRouteApi> T a(@NotNull Class<T> clazz) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) clazz);
            }
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return (T) b().e(clazz);
        }

        @NotNull
        public final g b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return g.f362340d;
            }
            return (g) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42842);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            f362340d = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.apiInstances = new HashMap<>();
            this.missApiClasses = Collections.newSetFromMap(new ConcurrentHashMap());
        }
    }

    @JvmStatic
    @NotNull
    public static final <T extends QRouteApi> T b(@NotNull Class<T> cls) {
        return (T) INSTANCE.a(cls);
    }

    private final String c(Class<?> clazz) {
        int lastIndexOf$default;
        boolean startsWith$default;
        String name = clazz.getName();
        Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) name, '.', 0, false, 6, (Object) null);
        String name2 = clazz.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "clazz.name");
        String substring = name2.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        String name3 = clazz.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "clazz.name");
        String substring2 = name3.substring(lastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(substring2, "I", false, 2, null);
        if (startsWith$default) {
            substring2 = substring2.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        }
        return substring + ".impl." + substring2 + "NtImpl";
    }

    private final <T> T d(Class<T> clazz) {
        synchronized (this.apiInstances) {
            T t16 = (T) this.apiInstances.get(clazz);
            if (t16 == null) {
                t16 = null;
            }
            if (t16 != null) {
                return t16;
            }
            T t17 = (T) f(c(clazz));
            if (t17 == null) {
                t17 = null;
            }
            if (t17 == null) {
                return null;
            }
            this.apiInstances.put(clazz, t17);
            return t17;
        }
    }

    private final <T> T f(String className) {
        try {
            return (T) Class.forName(className).newInstance();
        } catch (ClassNotFoundException e16) {
            QLog.i("HodorPrefAdapterRoute", 1, "instantiateFallback, exc=" + e16);
            return null;
        }
    }

    @NotNull
    public final <T extends QRouteApi> T e(@NotNull Class<T> clazz) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) clazz);
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (!this.missApiClasses.contains(clazz)) {
            try {
                T t16 = (T) QRoute.api(clazz);
                Intrinsics.checkNotNullExpressionValue(t16, "api(clazz)");
                return t16;
            } catch (Exception e16) {
                QLog.i("HodorPrefAdapterRoute", 1, String.valueOf(e16));
                this.missApiClasses.add(clazz);
            }
        }
        T t17 = (T) d(clazz);
        if (t17 != null) {
            return t17;
        }
        throw new RuntimeException("HodorPrefAdapterRoute implementation of '" + clazz + "' not found");
    }
}
