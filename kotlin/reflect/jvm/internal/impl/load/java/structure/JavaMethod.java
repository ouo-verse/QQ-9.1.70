package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface JavaMethod extends JavaMember, JavaTypeParameterListOwner {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        public static boolean getHasAnnotationParameterDefaultValue(@NotNull JavaMethod javaMethod) {
            if (javaMethod.getAnnotationParameterDefaultValue() != null) {
                return true;
            }
            return false;
        }
    }

    @Nullable
    JavaAnnotationArgument getAnnotationParameterDefaultValue();

    boolean getHasAnnotationParameterDefaultValue();

    @NotNull
    JavaType getReturnType();

    @NotNull
    List<JavaValueParameter> getValueParameters();
}
