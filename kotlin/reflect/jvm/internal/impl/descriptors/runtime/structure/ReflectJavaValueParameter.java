package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public final class ReflectJavaValueParameter extends ReflectJavaElement implements JavaValueParameter {
    private final boolean isVararg;

    @NotNull
    private final Annotation[] reflectAnnotations;

    @Nullable
    private final String reflectName;

    @NotNull
    private final ReflectJavaType type;

    public ReflectJavaValueParameter(@NotNull ReflectJavaType type, @NotNull Annotation[] reflectAnnotations, @Nullable String str, boolean z16) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(reflectAnnotations, "reflectAnnotations");
        this.type = type;
        this.reflectAnnotations = reflectAnnotations;
        this.reflectName = str;
        this.isVararg = z16;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    @Nullable
    public Name getName() {
        String str = this.reflectName;
        if (str != null) {
            return Name.guessByFirstCharacter(str);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    public boolean isVararg() {
        return this.isVararg;
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(ReflectJavaValueParameter.class.getName());
        sb5.append(MsgSummary.STR_COLON);
        if (isVararg()) {
            str = "vararg ";
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append(getName());
        sb5.append(MsgSummary.STR_COLON);
        sb5.append(getType());
        return sb5.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    public ReflectJavaAnnotation findAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return ReflectJavaAnnotationOwnerKt.findAnnotation(this.reflectAnnotations, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwnerKt.getAnnotations(this.reflectAnnotations);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    @NotNull
    public ReflectJavaType getType() {
        return this.type;
    }
}
