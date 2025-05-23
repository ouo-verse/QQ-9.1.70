package com.tencent.zplan.common.utils;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.util.ReflectionUtil;
import com.vivo.push.PushClientConstants;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002JK\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\"\u0010\n\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00060\t\"\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/zplan/common/utils/g;", "", "", PushClientConstants.TAG_CLASS_NAME, "fieldName", "b", "Ljava/lang/Class;", "interfaceClass", "methodName", "", "paramsTypes", "Ljava/lang/reflect/Method;", "a", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "T", "c", "(Ljava/lang/Class;)Ljava/lang/Object;", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f385293a = new g();

    g() {
    }

    @Nullable
    public final Method a(@NotNull Class<? extends Object> interfaceClass, @NotNull String methodName, @NotNull Class<? extends Object>... paramsTypes) {
        Intrinsics.checkNotNullParameter(interfaceClass, "interfaceClass");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(paramsTypes, "paramsTypes");
        try {
            return interfaceClass.getDeclaredMethod(methodName, (Class[]) Arrays.copyOf(paramsTypes, paramsTypes.length));
        } catch (NoSuchMethodException e16) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 == null) {
                return null;
            }
            a16.e(ReflectionUtil.TAG, 1, "getRemoteCallbackMethod :" + methodName + ", paramsTypes:" + paramsTypes + " NoSuchMethodException", e16);
            return null;
        } catch (SecurityException e17) {
            lx4.d a17 = LogUtil.f385285b.a();
            if (a17 == null) {
                return null;
            }
            a17.e(ReflectionUtil.TAG, 1, "getRemoteCallbackMethod :" + methodName + ", paramsTypes:" + paramsTypes + " SecurityException", e17);
            return null;
        }
    }

    @Nullable
    public final Object b(@NotNull String className, @NotNull String fieldName) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        if (TextUtils.isEmpty(className) || TextUtils.isEmpty(fieldName)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(className);
            return cls.getField(fieldName).get(cls);
        } catch (ClassNotFoundException e16) {
            Log.w(ReflectionUtil.TAG, "ClassNotFoundException", e16);
            return null;
        } catch (IllegalAccessException e17) {
            Log.w(ReflectionUtil.TAG, "IllegalAccessException", e17);
            return null;
        } catch (NoSuchFieldException e18) {
            Log.w(ReflectionUtil.TAG, "NoSuchFieldException", e18);
            return null;
        } catch (SecurityException e19) {
            Log.w(ReflectionUtil.TAG, "SecurityException", e19);
            return null;
        }
    }

    @Nullable
    public final <T> T c(@NotNull Class<T> newInstanceOrNull) {
        Intrinsics.checkNotNullParameter(newInstanceOrNull, "$this$newInstanceOrNull");
        try {
            return newInstanceOrNull.newInstance();
        } catch (Throwable th5) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                a16.e(ReflectionUtil.TAG, 1, "newInstance for class: " + newInstanceOrNull + ", exception:", th5);
            }
            return null;
        }
    }
}
