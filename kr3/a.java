package kr3;

import android.view.View;
import android.view.Window;
import com.tencent.qmethod.pandoraex.core.o;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR\u001c\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lkr3/a;", "", "Landroid/view/View;", "view", "", "b", "c", "", "d", "a", "Ljava/lang/Class;", "Ljava/lang/Class;", "decorViewClass", "popDecorViewClass", "Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Method;", "getListenerInfoMethod", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static Class<?> decorViewClass;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Class<?> popDecorViewClass;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Method getListenerInfoMethod;

    /* renamed from: d, reason: collision with root package name */
    public static final a f412907d = new a();

    static {
        try {
            decorViewClass = Class.forName("com.android.internal.policy.DecorView");
            popDecorViewClass = Class.forName("android.widget.PopupWindow$PopupDecorView");
            Method declaredMethod = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
            getListenerInfoMethod = declaredMethod;
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
            }
        } catch (ClassNotFoundException e16) {
            o.b("CallbackInject", "find inject point error.", e16);
        }
    }

    a() {
    }

    private final void b(View view) {
        Field declaredField;
        Class<?> cls = decorViewClass;
        if (cls != null && (declaredField = cls.getDeclaredField("mWindow")) != null) {
            declaredField.setAccessible(true);
            Object obj = declaredField.get(view);
            if (obj != null && (obj instanceof Window)) {
                Window window = (Window) obj;
                Window.Callback callback = window.getCallback();
                Object newProxyInstance = Proxy.newProxyInstance(Window.Callback.class.getClassLoader(), new Class[]{Window.Callback.class}, new b(callback));
                if (newProxyInstance != null) {
                    window.setCallback((Window.Callback) newProxyInstance);
                    o.a("CallbackInject", "injectDecorView: " + callback.getClass().getCanonicalName() + " , hash=" + callback);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.view.Window.Callback");
            }
        }
    }

    private final void c(View view) {
        Object obj;
        Object obj2;
        Method method = getListenerInfoMethod;
        View.OnTouchListener onTouchListener = null;
        if (method != null) {
            obj = method.invoke(view, new Object[0]);
        } else {
            obj = null;
        }
        if (obj != null) {
            Field field = obj.getClass().getDeclaredField("mOnTouchListener");
            Intrinsics.checkExpressionValueIsNotNull(field, "field");
            field.setAccessible(true);
            obj2 = field.get(obj);
        } else {
            obj2 = null;
        }
        if (obj2 instanceof View.OnTouchListener) {
            onTouchListener = (View.OnTouchListener) obj2;
        }
        view.setOnTouchListener(new c(onTouchListener));
        o.a("CallbackInject", "injectPopNew: " + view.getClass().getCanonicalName() + " , hash=" + view + ", listener=" + obj2);
    }

    public final void a(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        try {
            o.a("CallbackInject", "inject: " + view.getClass().getCanonicalName() + " , hash=" + view);
            Class<?> cls = decorViewClass;
            if (cls != null && cls.isInstance(view)) {
                b(view);
            } else {
                Class<?> cls2 = popDecorViewClass;
                if (cls2 != null && cls2.isInstance(view)) {
                    c(view);
                }
            }
        } catch (Exception e16) {
            o.b("CallbackInject", "inject view error. view=" + view.getClass().getName(), e16);
        }
    }

    public final boolean d() {
        if (decorViewClass != null && popDecorViewClass != null && getListenerInfoMethod != null) {
            return true;
        }
        return false;
    }
}
