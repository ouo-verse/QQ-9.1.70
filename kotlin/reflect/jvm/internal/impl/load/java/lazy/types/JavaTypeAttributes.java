package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaTypeAttributes extends ErasureTypeAttributes {

    @Nullable
    private final SimpleType defaultType;

    @NotNull
    private final JavaTypeFlexibility flexibility;

    @NotNull
    private final TypeUsage howThisTypeIsUsed;
    private final boolean isForAnnotationParameter;
    private final boolean isRaw;

    @Nullable
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    public /* synthetic */ JavaTypeAttributes(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z16, boolean z17, Set set, SimpleType simpleType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeUsage, (i3 & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? false : z17, (i3 & 16) != 0 ? null : set, (i3 & 32) != 0 ? null : simpleType);
    }

    public static /* synthetic */ JavaTypeAttributes copy$default(JavaTypeAttributes javaTypeAttributes, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z16, boolean z17, Set set, SimpleType simpleType, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            typeUsage = javaTypeAttributes.getHowThisTypeIsUsed();
        }
        if ((i3 & 2) != 0) {
            javaTypeFlexibility = javaTypeAttributes.flexibility;
        }
        JavaTypeFlexibility javaTypeFlexibility2 = javaTypeFlexibility;
        if ((i3 & 4) != 0) {
            z16 = javaTypeAttributes.isRaw;
        }
        boolean z18 = z16;
        if ((i3 & 8) != 0) {
            z17 = javaTypeAttributes.isForAnnotationParameter;
        }
        boolean z19 = z17;
        if ((i3 & 16) != 0) {
            set = javaTypeAttributes.getVisitedTypeParameters();
        }
        Set set2 = set;
        if ((i3 & 32) != 0) {
            simpleType = javaTypeAttributes.getDefaultType();
        }
        return javaTypeAttributes.copy(typeUsage, javaTypeFlexibility2, z18, z19, set2, simpleType);
    }

    @NotNull
    public final JavaTypeAttributes copy(@NotNull TypeUsage howThisTypeIsUsed, @NotNull JavaTypeFlexibility flexibility, boolean z16, boolean z17, @Nullable Set<? extends TypeParameterDescriptor> set, @Nullable SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(howThisTypeIsUsed, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(flexibility, "flexibility");
        return new JavaTypeAttributes(howThisTypeIsUsed, flexibility, z16, z17, set, simpleType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof JavaTypeAttributes)) {
            return false;
        }
        JavaTypeAttributes javaTypeAttributes = (JavaTypeAttributes) obj;
        if (!Intrinsics.areEqual(javaTypeAttributes.getDefaultType(), getDefaultType()) || javaTypeAttributes.getHowThisTypeIsUsed() != getHowThisTypeIsUsed() || javaTypeAttributes.flexibility != this.flexibility || javaTypeAttributes.isRaw != this.isRaw || javaTypeAttributes.isForAnnotationParameter != this.isForAnnotationParameter) {
            return false;
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    @Nullable
    public SimpleType getDefaultType() {
        return this.defaultType;
    }

    @NotNull
    public final JavaTypeFlexibility getFlexibility() {
        return this.flexibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    @NotNull
    public TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    @Nullable
    public Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public int hashCode() {
        int i3;
        SimpleType defaultType = getDefaultType();
        if (defaultType != null) {
            i3 = defaultType.hashCode();
        } else {
            i3 = 0;
        }
        int hashCode = i3 + (i3 * 31) + getHowThisTypeIsUsed().hashCode();
        int hashCode2 = hashCode + (hashCode * 31) + this.flexibility.hashCode();
        int i16 = hashCode2 + (hashCode2 * 31) + (this.isRaw ? 1 : 0);
        return i16 + (i16 * 31) + (this.isForAnnotationParameter ? 1 : 0);
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public final boolean isRaw() {
        return this.isRaw;
    }

    @NotNull
    public final JavaTypeAttributes markIsRaw(boolean z16) {
        return copy$default(this, null, null, z16, false, null, null, 59, null);
    }

    @NotNull
    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + getHowThisTypeIsUsed() + ", flexibility=" + this.flexibility + ", isRaw=" + this.isRaw + ", isForAnnotationParameter=" + this.isForAnnotationParameter + ", visitedTypeParameters=" + getVisitedTypeParameters() + ", defaultType=" + getDefaultType() + ')';
    }

    @NotNull
    public JavaTypeAttributes withDefaultType(@Nullable SimpleType simpleType) {
        return copy$default(this, null, null, false, false, null, simpleType, 31, null);
    }

    @NotNull
    public final JavaTypeAttributes withFlexibility(@NotNull JavaTypeFlexibility flexibility) {
        Intrinsics.checkNotNullParameter(flexibility, "flexibility");
        return copy$default(this, null, flexibility, false, false, null, null, 61, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    @NotNull
    public JavaTypeAttributes withNewVisitedTypeParameter(@NotNull TypeParameterDescriptor typeParameter) {
        Set of5;
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        if (getVisitedTypeParameters() == null) {
            of5 = SetsKt__SetsJVMKt.setOf(typeParameter);
        } else {
            of5 = SetsKt___SetsKt.plus((Set<? extends TypeParameterDescriptor>) ((Set<? extends Object>) getVisitedTypeParameters()), typeParameter);
        }
        return copy$default(this, null, null, false, false, of5, null, 47, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeAttributes(@NotNull TypeUsage howThisTypeIsUsed, @NotNull JavaTypeFlexibility flexibility, boolean z16, boolean z17, @Nullable Set<? extends TypeParameterDescriptor> set, @Nullable SimpleType simpleType) {
        super(howThisTypeIsUsed, set, simpleType);
        Intrinsics.checkNotNullParameter(howThisTypeIsUsed, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(flexibility, "flexibility");
        this.howThisTypeIsUsed = howThisTypeIsUsed;
        this.flexibility = flexibility;
        this.isRaw = z16;
        this.isForAnnotationParameter = z17;
        this.visitedTypeParameters = set;
        this.defaultType = simpleType;
    }
}
