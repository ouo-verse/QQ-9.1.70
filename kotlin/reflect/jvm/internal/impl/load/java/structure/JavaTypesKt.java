package kotlin.reflect.jvm.internal.impl.load.java.structure;

import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaTypesKt {
    public static final boolean isSuperWildcard(@Nullable JavaType javaType) {
        JavaWildcardType javaWildcardType;
        if (javaType instanceof JavaWildcardType) {
            javaWildcardType = (JavaWildcardType) javaType;
        } else {
            javaWildcardType = null;
        }
        if (javaWildcardType == null || javaWildcardType.getBound() == null || javaWildcardType.isExtends()) {
            return false;
        }
        return true;
    }
}
