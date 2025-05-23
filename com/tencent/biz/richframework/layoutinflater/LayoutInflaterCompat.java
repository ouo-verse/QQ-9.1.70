package com.tencent.biz.richframework.layoutinflater;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/LayoutInflaterCompat;", "", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/LayoutInflater$Factory2;", "factory", "", "forceInvokeSetPrivateFactory", "forceSetFactory2", "targetLayoutInflater", "fallbackFactory2", "", "forceMainFactory2", "setForceMainAndFallbackFactory2", "Ljava/lang/reflect/Method;", "sLayoutInflaterPrivateFactoryMethod", "Ljava/lang/reflect/Method;", "sCheckedSetPrivateFactoryMethod", "Z", "Ljava/lang/reflect/Field;", "sLayoutInflaterFactory2Field", "Ljava/lang/reflect/Field;", "sCheckedSetFactory2Field", "<init>", "()V", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class LayoutInflaterCompat {

    @NotNull
    public static final LayoutInflaterCompat INSTANCE = new LayoutInflaterCompat();
    private static boolean sCheckedSetFactory2Field;
    private static boolean sCheckedSetPrivateFactoryMethod;
    private static Field sLayoutInflaterFactory2Field;
    private static Method sLayoutInflaterPrivateFactoryMethod;

    LayoutInflaterCompat() {
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    public final void forceInvokeSetPrivateFactory(@NotNull LayoutInflater inflater, @NotNull LayoutInflater.Factory2 factory) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(factory, "factory");
        if (!sCheckedSetPrivateFactoryMethod) {
            try {
                Method declaredMethod = LayoutInflater.class.getDeclaredMethod("setPrivateFactory", LayoutInflater.Factory2.class);
                sLayoutInflaterPrivateFactoryMethod = declaredMethod;
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                }
            } catch (NoSuchMethodException e16) {
                Log.e("LayoutInflaterCompat", "forceInvokeSetPrivateFactory Could not find method 'setPrivateFactory' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e16);
            }
            sCheckedSetPrivateFactoryMethod = true;
        }
        Method method = sLayoutInflaterPrivateFactoryMethod;
        if (method != null && method != null) {
            try {
                method.invoke(inflater, factory);
            } catch (IllegalAccessException e17) {
                Log.e("LayoutInflaterCompat", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + inflater + "; inflation may have unexpected results.", e17);
            }
        }
    }

    public final void forceSetFactory2(@NotNull LayoutInflater inflater, @NotNull LayoutInflater.Factory2 factory) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(factory, "factory");
        if (!sCheckedSetFactory2Field) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                sLayoutInflaterFactory2Field = declaredField;
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
            } catch (NoSuchFieldException e16) {
                Log.e("LayoutInflaterCompat", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e16);
            }
            sCheckedSetFactory2Field = true;
        }
        Field field = sLayoutInflaterFactory2Field;
        if (field != null) {
            try {
                Intrinsics.checkNotNull(field);
                field.set(inflater, factory);
            } catch (IllegalAccessException e17) {
                Log.e("LayoutInflaterCompat", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + inflater + "; inflation may have unexpected results.", e17);
            }
        }
    }

    public final void setForceMainAndFallbackFactory2(@NotNull LayoutInflater targetLayoutInflater, @NotNull LayoutInflater.Factory2 fallbackFactory2, boolean forceMainFactory2) {
        Intrinsics.checkNotNullParameter(targetLayoutInflater, "targetLayoutInflater");
        Intrinsics.checkNotNullParameter(fallbackFactory2, "fallbackFactory2");
        RFWLog.i("LayoutInflaterCompat", RFWLog.USR, "setForceMainAndFallbackFactory2 before: content:" + targetLayoutInflater.getContext() + " factory2:" + targetLayoutInflater.getFactory2());
        if (targetLayoutInflater.getFactory2() != null) {
            LayoutInflater.Factory2 factory2 = targetLayoutInflater.getFactory2();
            Intrinsics.checkNotNullExpressionValue(factory2, "targetLayoutInflater.factory2");
            fallbackFactory2 = new FallbackFactoryMerger(factory2, targetLayoutInflater.getFactory2(), fallbackFactory2, fallbackFactory2);
        }
        if (forceMainFactory2) {
            fallbackFactory2 = new ForceMainFactory2(fallbackFactory2, fallbackFactory2);
        }
        if (targetLayoutInflater.getFactory2() == null) {
            targetLayoutInflater.setFactory2(fallbackFactory2);
        } else if (!Intrinsics.areEqual(targetLayoutInflater.getFactory2().getClass(), fallbackFactory2.getClass())) {
            targetLayoutInflater.setFactory2(fallbackFactory2);
        }
        RFWLog.i("LayoutInflaterCompat", RFWLog.USR, "setForceMainAndFallbackFactory2:" + targetLayoutInflater.getFactory2());
    }
}
