package com.tencent.mobileqq.guild.base.reflect;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.s;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/base/reflect/FragmentReflect;", "", "", "b", "Landroidx/fragment/app/Fragment;", "fragment", "", "multiWindowModeChanged", "a", "Ljava/lang/reflect/Method;", "Lkotlin/Lazy;", "c", "()Ljava/lang/reflect/Method;", "methodPerformMultiWindowModeChanged", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FragmentReflect {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FragmentReflect f214787a = new FragmentReflect();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy methodPerformMultiWindowModeChanged;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Method>() { // from class: com.tencent.mobileqq.guild.base.reflect.FragmentReflect$methodPerformMultiWindowModeChanged$2
            @Override // kotlin.jvm.functions.Function0
            public final Method invoke() {
                Method declaredMethod = Fragment.class.getDeclaredMethod("performMultiWindowModeChanged", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            }
        });
        methodPerformMultiWindowModeChanged = lazy;
    }

    FragmentReflect() {
    }

    private final Method c() {
        Object value = methodPerformMultiWindowModeChanged.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-methodPerformMultiWindowModeChanged>(...)");
        return (Method) value;
    }

    public final void a(@NotNull Fragment fragment, boolean multiWindowModeChanged) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        try {
            c().invoke(fragment, Boolean.valueOf(multiWindowModeChanged));
        } catch (Exception e16) {
            if (e16 instanceof InvocationTargetException) {
                Logger logger = Logger.f235387a;
                Throwable targetException = ((InvocationTargetException) e16).getTargetException();
                Logger.b bVar = new Logger.b();
                bVar.a().add("dispatchMultiWindowModeChanged Invoke error!");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("FragmentReflect", 1, (String) it.next(), targetException);
                }
            } else {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                bVar2.a().add("dispatchMultiWindowModeChanged error!");
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("FragmentReflect", 1, (String) it5.next(), e16);
                }
            }
            if (e16 instanceof NoSuchMethodException) {
                s.f("FragmentReflect", "dispatchMultiWindowModeChanged", e16);
            }
        }
    }

    public final void b() {
        String joinToString$default;
        try {
            c();
        } catch (NoSuchMethodException e16) {
            Method[] declaredMethods = Fragment.class.getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "Fragment::class.java.declaredMethods");
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(declaredMethods, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Method, CharSequence>() { // from class: com.tencent.mobileqq.guild.base.reflect.FragmentReflect$ensureMethodIsPresent$availableMethods$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(Method method) {
                    String name = method.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "it.name");
                    return name;
                }
            }, 30, (Object) null);
            s.f("FragmentReflect", "ensureMethodIsPresent containsMethods: " + joinToString$default, e16);
        }
    }
}
