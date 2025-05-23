package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class ReflectJavaType implements JavaType {

    @NotNull
    public static final Factory Factory = new Factory(null);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ReflectJavaType create(@NotNull Type type) {
            ReflectJavaType reflectJavaArrayType;
            Intrinsics.checkNotNullParameter(type, "type");
            boolean z16 = type instanceof Class;
            if (z16) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new ReflectJavaPrimitiveType(cls);
                }
            }
            if (!(type instanceof GenericArrayType) && (!z16 || !((Class) type).isArray())) {
                if (type instanceof WildcardType) {
                    reflectJavaArrayType = new ReflectJavaWildcardType((WildcardType) type);
                } else {
                    reflectJavaArrayType = new ReflectJavaClassifierType(type);
                }
            } else {
                reflectJavaArrayType = new ReflectJavaArrayType(type);
            }
            return reflectJavaArrayType;
        }

        Factory() {
        }
    }

    public boolean equals(@Nullable Object obj) {
        if ((obj instanceof ReflectJavaType) && Intrinsics.areEqual(getReflectType(), ((ReflectJavaType) obj).getReflectType())) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    public JavaAnnotation findAnnotation(@NotNull FqName fqName) {
        return JavaType.DefaultImpls.findAnnotation(this, fqName);
    }

    @NotNull
    protected abstract Type getReflectType();

    public int hashCode() {
        return getReflectType().hashCode();
    }

    @NotNull
    public String toString() {
        return getClass().getName() + MsgSummary.STR_COLON + getReflectType();
    }
}
