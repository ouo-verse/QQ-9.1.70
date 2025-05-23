package com.tencent.rapier;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.TypeVariable;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001c\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J!\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t0\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/rapier/k;", "", "T", "Ljava/lang/Class;", "service", "", "f", "Ljava/lang/reflect/Method;", "method", "Lcom/tencent/rapier/n;", "d", "b", "(Ljava/lang/Class;)Ljava/lang/Object;", "", "timeout", "e", "a", "J", "c", "()J", "setTimeout", "(J)V", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "serviceMethodCache", "<init>", "()V", "rapier_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long timeout;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ConcurrentHashMap<Method, n<Object>> serviceMethodCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0096\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"com/tencent/rapier/k$a", "Ljava/lang/reflect/InvocationHandler;", "", "proxy", "Ljava/lang/reflect/Method;", "method", "", "args", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "a", "[Ljava/lang/Object;", "emptyArgs", "rapier_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class a implements InvocationHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Object[] emptyArgs;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) k.this);
            } else {
                this.emptyArgs = new Object[]{0};
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(@NotNull Object proxy, @NotNull Method method, @Nullable Object[] args) throws Throwable {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return iPatchRedirector.redirect((short) 1, this, proxy, method, args);
            }
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Intrinsics.checkNotNullParameter(method, "method");
            if (Intrinsics.areEqual(method.getDeclaringClass(), Object.class)) {
                return method.invoke(this, args);
            }
            if (args == null) {
                args = this.emptyArgs;
            }
            n d16 = k.this.d(method);
            if (d16 != null) {
                return d16.a(args);
            }
            return null;
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.serviceMethodCache = new ConcurrentHashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n<Object> d(Method method) {
        n<Object> nVar;
        n<Object> nVar2 = this.serviceMethodCache.get(method);
        if (nVar2 != null) {
            return nVar2;
        }
        synchronized (this.serviceMethodCache) {
            nVar = this.serviceMethodCache.get(method);
            if (nVar == null) {
                nVar = n.INSTANCE.a(this, method);
                this.serviceMethodCache.put(method, nVar);
                Unit unit = Unit.INSTANCE;
            }
            Unit unit2 = Unit.INSTANCE;
        }
        return nVar;
    }

    private final <T> void f(Class<T> service) {
        boolean z16;
        if (service.isInterface()) {
            ArrayDeque arrayDeque = new ArrayDeque(1);
            arrayDeque.add(service);
            while (!arrayDeque.isEmpty()) {
                Class candidate = (Class) arrayDeque.removeFirst();
                Intrinsics.checkNotNullExpressionValue(candidate, "candidate");
                TypeVariable<Class<T>>[] typeParameters = candidate.getTypeParameters();
                Intrinsics.checkNotNullExpressionValue(typeParameters, "candidate.typeParameters");
                if (typeParameters.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    StringBuilder sb5 = new StringBuilder("Type parameters are unsupported on ");
                    sb5.append(candidate.getName());
                    if (true ^ Intrinsics.areEqual(candidate, service)) {
                        sb5.append(" which is an interface of ");
                        sb5.append(service.getName());
                    }
                    throw new IllegalArgumentException(sb5.toString());
                }
                Class<?>[] interfaces = candidate.getInterfaces();
                Collections.addAll(arrayDeque, (Class[]) Arrays.copyOf(interfaces, interfaces.length));
            }
            return;
        }
        throw new IllegalArgumentException("API declarations must be interfaces.".toString());
    }

    public final <T> T b(@NotNull Class<T> service) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) service);
        }
        Intrinsics.checkNotNullParameter(service, "service");
        f(service);
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, new a());
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Long) iPatchRedirector.redirect((short) 1, (Object) this)).longValue();
        }
        return this.timeout;
    }

    public final void e(long timeout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, timeout);
        } else {
            this.timeout = timeout;
        }
    }
}
