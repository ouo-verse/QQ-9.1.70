package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public final class SignatureSerializer {

    @NotNull
    public static final SignatureSerializer INSTANCE = new SignatureSerializer();

    SignatureSerializer() {
    }

    @NotNull
    public final String constructorDesc(@NotNull Constructor<?> constructor) {
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(");
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "constructor.parameterTypes");
        for (Class<?> parameterType : parameterTypes) {
            Intrinsics.checkNotNullExpressionValue(parameterType, "parameterType");
            sb5.append(ReflectClassUtilKt.getDesc(parameterType));
        }
        sb5.append(")V");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    @NotNull
    public final String fieldDesc(@NotNull Field field) {
        Intrinsics.checkNotNullParameter(field, "field");
        Class<?> type = field.getType();
        Intrinsics.checkNotNullExpressionValue(type, "field.type");
        return ReflectClassUtilKt.getDesc(type);
    }

    @NotNull
    public final String methodDesc(@NotNull Method method) {
        Intrinsics.checkNotNullParameter(method, "method");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
        for (Class<?> parameterType : parameterTypes) {
            Intrinsics.checkNotNullExpressionValue(parameterType, "parameterType");
            sb5.append(ReflectClassUtilKt.getDesc(parameterType));
        }
        sb5.append(")");
        Class<?> returnType = method.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "method.returnType");
        sb5.append(ReflectClassUtilKt.getDesc(returnType));
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }
}
