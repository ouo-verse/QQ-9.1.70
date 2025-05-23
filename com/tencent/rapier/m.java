package com.tencent.rapier;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rapier.annotation.Route;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R<\u0010\n\u001a(\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00040\u0004 \b*\u0014\u0012\u000e\b\u0001\u0012\n \b*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00070\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\tR<\u0010\u000e\u001a(\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000b0\u000b \b*\u0014\u0012\u000e\b\u0001\u0012\n \b*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\u00070\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rRx\u0010\u0011\u001ad\u0012*\u0012(\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00040\u0004 \b*\u0014\u0012\u000e\b\u0001\u0012\n \b*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00070\u0007 \b*2\u0012,\b\u0001\u0012(\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00040\u0004 \b*\u0014\u0012\u000e\b\u0001\u0012\n \b*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00070\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\f\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/rapier/m;", "", "", "a", "", "annotation", "d", "", "kotlin.jvm.PlatformType", "[Ljava/lang/annotation/Annotation;", "methodAnnotations", "Ljava/lang/reflect/Type;", "b", "[Ljava/lang/reflect/Type;", "parameterTypes", "c", "[[Ljava/lang/annotation/Annotation;", "parameterAnnotationsArray", "", "Ljava/lang/String;", "()Ljava/lang/String;", "setRequestService", "(Ljava/lang/String;)V", "requestService", "e", "setRequestMethod", "requestMethod", "Lcom/tencent/rapier/k;", "f", "Lcom/tencent/rapier/k;", "rapier", "Ljava/lang/reflect/Method;", "g", "Ljava/lang/reflect/Method;", "method", "<init>", "(Lcom/tencent/rapier/k;Ljava/lang/reflect/Method;)V", "rapier_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Annotation[] methodAnnotations;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Type[] parameterTypes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Annotation[][] parameterAnnotationsArray;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String requestService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String requestMethod;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final k rapier;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Method method;

    public m(@NotNull k rapier, @NotNull Method method) {
        Intrinsics.checkNotNullParameter(rapier, "rapier");
        Intrinsics.checkNotNullParameter(method, "method");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rapier, (Object) method);
            return;
        }
        this.rapier = rapier;
        this.method = method;
        this.methodAnnotations = method.getAnnotations();
        this.parameterTypes = method.getGenericParameterTypes();
        this.parameterAnnotationsArray = method.getParameterAnnotations();
        this.requestService = "";
        this.requestMethod = "";
        a();
    }

    private final void a() {
        for (Annotation annotation : this.methodAnnotations) {
            Intrinsics.checkNotNullExpressionValue(annotation, "annotation");
            d(annotation);
        }
    }

    private final void d(Annotation annotation) {
        boolean z16;
        if (annotation instanceof Route) {
            Route route = (Route) annotation;
            boolean z17 = true;
            if (route.service().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                this.requestService = route.service();
                if (route.method().length() != 0) {
                    z17 = false;
                }
                if (!z17) {
                    this.requestMethod = route.method();
                    return;
                }
                throw InvalidMethodException.INSTANCE.b();
            }
            throw InvalidMethodException.INSTANCE.c();
        }
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.requestMethod;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.requestService;
    }
}
