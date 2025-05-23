package com.tencent.rapier;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\b&\u0018\u0000 \u0005*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0005\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u00a6\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/rapier/n;", "T", "", "", "args", "a", "([Ljava/lang/Object;)Ljava/lang/Object;", "<init>", "()V", "rapier_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public abstract class n<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/rapier/n$a;", "", "T", "Lcom/tencent/rapier/k;", "rapier", "Ljava/lang/reflect/Method;", "method", "Lcom/tencent/rapier/n;", "a", "<init>", "()V", "rapier_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.rapier.n$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @NotNull
        public final <T> n<T> a(@NotNull k rapier, @NotNull Method method) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (n) iPatchRedirector.redirect((short) 1, (Object) this, (Object) rapier, (Object) method);
            }
            Intrinsics.checkNotNullParameter(rapier, "rapier");
            Intrinsics.checkNotNullParameter(method, "method");
            m mVar = new m(rapier, method);
            Type genericReturnType = method.getGenericReturnType();
            if (!p.f364089a.b(genericReturnType)) {
                if (genericReturnType != Void.TYPE) {
                    method.getGenericReturnType();
                    return new c(rapier, method, mVar);
                }
                throw InvalidMethodException.INSTANCE.d();
            }
            throw InvalidMethodException.INSTANCE.e();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9549);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract T a(@NotNull Object[] args);
}
