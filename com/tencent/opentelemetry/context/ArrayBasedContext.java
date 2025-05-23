package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class ArrayBasedContext implements Context {
    static IPatchRedirector $redirector_;
    private static final Context ROOT;
    private final Object[] entries;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16350);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            ROOT = new ArrayBasedContext(new Object[0]);
        }
    }

    ArrayBasedContext(Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) objArr);
        } else {
            this.entries = objArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context root() {
        return ROOT;
    }

    @Override // com.tencent.opentelemetry.context.Context
    @Nullable
    public <V> V get(ContextKey<V> contextKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (V) iPatchRedirector.redirect((short) 2, (Object) this, (Object) contextKey);
        }
        int i3 = 0;
        while (true) {
            Object[] objArr = this.entries;
            if (i3 < objArr.length) {
                if (objArr[i3] == contextKey) {
                    return (V) objArr[i3 + 1];
                }
                i3 += 2;
            } else {
                return null;
            }
        }
    }

    @Override // com.tencent.opentelemetry.context.Context
    public /* synthetic */ Scope makeCurrent() {
        return e.a(this);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("{");
        int i3 = 0;
        while (true) {
            Object[] objArr = this.entries;
            if (i3 >= objArr.length) {
                break;
            }
            sb5.append(objArr[i3]);
            sb5.append('=');
            sb5.append(this.entries[i3 + 1]);
            sb5.append(", ");
            i3 += 2;
        }
        if (sb5.length() > 1) {
            sb5.setLength(sb5.length() - 2);
        }
        sb5.append('}');
        return sb5.toString();
    }

    @Override // com.tencent.opentelemetry.context.Context
    public /* synthetic */ Context with(ImplicitContextKeyed implicitContextKeyed) {
        return e.b(this, implicitContextKeyed);
    }

    @Override // com.tencent.opentelemetry.context.Context
    public /* synthetic */ Runnable wrap(Runnable runnable) {
        return e.c(this, runnable);
    }

    @Override // com.tencent.opentelemetry.context.Context
    public <V> Context with(ContextKey<V> contextKey, V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Context) iPatchRedirector.redirect((short) 3, (Object) this, (Object) contextKey, (Object) v3);
        }
        int i3 = 0;
        while (true) {
            Object[] objArr = this.entries;
            if (i3 < objArr.length) {
                if (objArr[i3] == contextKey) {
                    int i16 = i3 + 1;
                    if (objArr[i16] == v3) {
                        return this;
                    }
                    Object[] objArr2 = (Object[]) objArr.clone();
                    objArr2[i16] = v3;
                    return new ArrayBasedContext(objArr2);
                }
                i3 += 2;
            } else {
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length + 2);
                copyOf[copyOf.length - 2] = contextKey;
                copyOf[copyOf.length - 1] = v3;
                return new ArrayBasedContext(copyOf);
            }
        }
    }

    @Override // com.tencent.opentelemetry.context.Context
    public /* synthetic */ Callable wrap(Callable callable) {
        return e.d(this, callable);
    }

    @Override // com.tencent.opentelemetry.context.Context
    public /* synthetic */ Executor wrap(Executor executor) {
        return e.e(this, executor);
    }

    @Override // com.tencent.opentelemetry.context.Context
    public /* synthetic */ ExecutorService wrap(ExecutorService executorService) {
        return e.f(this, executorService);
    }

    @Override // com.tencent.opentelemetry.context.Context
    public /* synthetic */ ScheduledExecutorService wrap(ScheduledExecutorService scheduledExecutorService) {
        return e.g(this, scheduledExecutorService);
    }
}
