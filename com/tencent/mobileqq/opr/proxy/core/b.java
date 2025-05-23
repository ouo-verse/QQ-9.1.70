package com.tencent.mobileqq.opr.proxy.core;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.opr.utils.log.OprLogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\u0006B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007R*\u0010\b\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R&\u0010\n\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/opr/proxy/core/b;", "", "Ljava/lang/Class;", "proxy", "b", "", "a", "Ljava/util/Map;", "proxyServicesMap", "", "activatedServices", "<init>", "()V", "c", "opr_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final b f257060d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Map<Class<?>, Class<?>> proxyServicesMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Class<?>, Object> activatedServices;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/opr/proxy/core/b$a;", "", "Lcom/tencent/mobileqq/opr/proxy/core/b;", "a", "", "TAG", "Ljava/lang/String;", "sInstance", "Lcom/tencent/mobileqq/opr/proxy/core/b;", "<init>", "()V", "opr_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.mobileqq.opr.proxy.core.b$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return b.f257060d;
            }
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10690);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
            f257060d = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.proxyServicesMap = c.f257063a.a();
            this.activatedServices = new HashMap();
        }
    }

    @SuppressLint({"LongLogTag"})
    @Nullable
    public final Object b(@NotNull Class<?> proxy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) proxy);
        }
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Map<Class<?>, Class<?>> map = this.proxyServicesMap;
        Intrinsics.checkNotNull(map);
        Class<?> cls = map.get(proxy);
        if (cls == null) {
            OprLogger.w("[opr][ProxyServiceEngine]", Intrinsics.stringPlus("Can NOT find service class by proxy name: ", proxy));
            return null;
        }
        Object obj = this.activatedServices.get(cls);
        if (obj != null) {
            return obj;
        }
        synchronized (this) {
            try {
                obj = cls.newInstance();
                OprLogger.i("[opr][ProxyServiceEngine]", Intrinsics.stringPlus("Create a new proxy instance of ", cls));
                this.activatedServices.put(cls, obj);
            } catch (Exception unused) {
                OprLogger.e("[opr][ProxyServiceEngine]", Intrinsics.stringPlus("Failed to create instance of ", cls));
            }
            Unit unit = Unit.INSTANCE;
        }
        return obj;
    }
}
