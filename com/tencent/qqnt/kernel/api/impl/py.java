package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.impl.KernelServiceImpl;
import com.tencent.qqnt.kernel.internel.CallMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\b\u001a\u00020\u0007R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/py;", "", "com/tencent/qqnt/kernel/api/impl/py$a", "f", "()Lcom/tencent/qqnt/kernel/api/impl/py$a;", "Lmqq/app/AppRuntime;", "c", "", "g", "Lmqq/util/WeakReference;", "a", "Lmqq/util/WeakReference;", "mAppRef", "", "b", "Ljava/lang/String;", "appUin", "Lcom/tencent/qqnt/kernel/internel/CallMonitor;", "Lcom/tencent/qqnt/kernel/internel/CallMonitor;", "e", "()Lcom/tencent/qqnt/kernel/internel/CallMonitor;", "setMCallMonitor", "(Lcom/tencent/qqnt/kernel/internel/CallMonitor;)V", "mCallMonitor", "d", "()Ljava/lang/String;", tl.h.F, "(Ljava/lang/String;)V", "curSessionId", "app", "<init>", "(Lmqq/app/AppRuntime;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class py {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<AppRuntime> mAppRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String appUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CallMonitor mCallMonitor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String curSessionId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/kernel/api/impl/py$a", "Lcom/tencent/qqnt/kernel/internel/CallMonitor;", "", "h1", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a extends CallMonitor {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) py.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qqnt.kernel.internel.CallMonitor
        public boolean h1() {
            AppRuntime appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                WeakReference weakReference = py.this.mAppRef;
                if (weakReference != null) {
                    appRuntime = (AppRuntime) weakReference.get();
                } else {
                    appRuntime = null;
                }
                if (appRuntime == null) {
                    l1("mApp is null, error!");
                    return false;
                }
                if (py.this.d() != null) {
                    String str = py.this.appUin;
                    KernelServiceImpl.Companion companion = KernelServiceImpl.INSTANCE;
                    if (!Intrinsics.areEqual(str, companion.d())) {
                        l1("Service(" + py.this.appUin + ") and Wrapper(" + companion.d() + ") is not match\uff0cerror!");
                        return false;
                    }
                    return true;
                }
                l1("curSessionId is null, error!");
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
    }

    public py(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        if (appRuntime != null) {
            this.mAppRef = new WeakReference<>(appRuntime);
            this.appUin = appRuntime.getCurrentUin();
        }
        this.mCallMonitor = f();
    }

    private final a f() {
        return new a();
    }

    @Nullable
    public final AppRuntime c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        WeakReference<AppRuntime> weakReference = this.mAppRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.curSessionId;
    }

    @NotNull
    public final CallMonitor e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CallMonitor) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mCallMonitor;
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            QLog.i("ServiceContent", 1, "release ServiceContent handlerThread");
        }
    }

    public final void h(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.curSessionId = str;
        }
    }
}
