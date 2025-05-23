package com.tencent.mobileqq.perf.memory.leak;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.vivo.push.PushClientConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J&\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J&\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J9\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0012\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\rJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001R\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u001c*\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/perf/memory/leak/h;", "", "", PushClientConstants.TAG_CLASS_NAME, "methodName", "", "throwException", "Ljava/lang/reflect/Method;", "f", "Ljava/lang/Class;", "targetClass", "e", "fieldName", "Ljava/lang/reflect/Field;", "c", "target", "b", "method", "", "args", tl.h.F, "(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "field", "d", "value", "", "i", "Landroid/content/Context;", "Landroid/app/Activity;", "a", "(Landroid/content/Context;)Landroid/app/Activity;", "activityOrNull", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f257780a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30413);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f257780a = new h();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ Method g(h hVar, Class cls, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        return hVar.e(cls, str, z16);
    }

    @Nullable
    public final Activity a(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Activity) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "<this>");
        Context baseContext = context;
        while (!(baseContext instanceof Application)) {
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper) || (baseContext = ((ContextWrapper) baseContext).getBaseContext()) == context) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
        }
        return null;
    }

    @Nullable
    public final Field b(@NotNull Class<?> target, @NotNull String fieldName, boolean throwException) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Field) iPatchRedirector.redirect((short) 5, this, target, fieldName, Boolean.valueOf(throwException));
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        try {
            Field declaredField = target.getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Exception e16) {
            if (!throwException) {
                return null;
            }
            throw e16;
        }
    }

    @Nullable
    public final Field c(@NotNull String className, @NotNull String fieldName, boolean throwException) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Field) iPatchRedirector.redirect((short) 4, this, className, fieldName, Boolean.valueOf(throwException));
        }
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        try {
            Field declaredField = Class.forName(className).getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Exception e16) {
            if (!throwException) {
                return null;
            }
            throw e16;
        }
    }

    @Nullable
    public final Object d(@Nullable Object target, @NotNull Field field) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, (Object) this, target, (Object) field);
        }
        Intrinsics.checkNotNullParameter(field, "field");
        if (target != null) {
            return field.get(target);
        }
        return null;
    }

    @Nullable
    public final Method e(@NotNull Class<?> targetClass, @NotNull String methodName, boolean throwException) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Method) iPatchRedirector.redirect((short) 3, this, targetClass, methodName, Boolean.valueOf(throwException));
        }
        Intrinsics.checkNotNullParameter(targetClass, "targetClass");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        try {
            return targetClass.getMethod(methodName, new Class[0]);
        } catch (Exception e16) {
            if (!throwException) {
                return null;
            }
            throw e16;
        }
    }

    @Nullable
    public final Method f(@NotNull String className, @NotNull String methodName, boolean throwException) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Method) iPatchRedirector.redirect((short) 2, this, className, methodName, Boolean.valueOf(throwException));
        }
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        try {
            return Class.forName(className).getMethod(methodName, new Class[0]);
        } catch (Exception e16) {
            if (!throwException) {
                return null;
            }
            throw e16;
        }
    }

    @Nullable
    public final Object h(@NotNull Method method, @Nullable Object target, @NotNull Object... args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, this, method, target, args);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        return method.invoke(target, Arrays.copyOf(args, args.length));
    }

    public final void i(@NotNull Object target, @NotNull Field field, @Nullable Object value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, target, field, value);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(field, "field");
        field.set(target, value);
    }
}
