package kotlin.reflect.jvm.internal.impl.types;

import java.util.Set;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ErasureTypeAttributes {

    @Nullable
    private final SimpleType defaultType;

    @NotNull
    private final TypeUsage howThisTypeIsUsed;

    @Nullable
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    /* JADX WARN: Multi-variable type inference failed */
    public ErasureTypeAttributes(@NotNull TypeUsage howThisTypeIsUsed, @Nullable Set<? extends TypeParameterDescriptor> set, @Nullable SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(howThisTypeIsUsed, "howThisTypeIsUsed");
        this.howThisTypeIsUsed = howThisTypeIsUsed;
        this.visitedTypeParameters = set;
        this.defaultType = simpleType;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ErasureTypeAttributes)) {
            return false;
        }
        ErasureTypeAttributes erasureTypeAttributes = (ErasureTypeAttributes) obj;
        if (!Intrinsics.areEqual(erasureTypeAttributes.getDefaultType(), getDefaultType()) || erasureTypeAttributes.getHowThisTypeIsUsed() != getHowThisTypeIsUsed()) {
            return false;
        }
        return true;
    }

    @Nullable
    public SimpleType getDefaultType() {
        return this.defaultType;
    }

    @NotNull
    public TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    @Nullable
    public Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    public int hashCode() {
        int i3;
        SimpleType defaultType = getDefaultType();
        if (defaultType != null) {
            i3 = defaultType.hashCode();
        } else {
            i3 = 0;
        }
        return i3 + (i3 * 31) + getHowThisTypeIsUsed().hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0010, code lost:
    
        r1 = kotlin.collections.SetsKt___SetsKt.plus((java.util.Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor>) ((java.util.Set<? extends java.lang.Object>) r1), r4);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ErasureTypeAttributes withNewVisitedTypeParameter(@NotNull TypeParameterDescriptor typeParameter) {
        Set of5;
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        TypeUsage howThisTypeIsUsed = getHowThisTypeIsUsed();
        Set<TypeParameterDescriptor> visitedTypeParameters = getVisitedTypeParameters();
        if (visitedTypeParameters == null || of5 == null) {
            of5 = SetsKt__SetsJVMKt.setOf(typeParameter);
        }
        return new ErasureTypeAttributes(howThisTypeIsUsed, of5, getDefaultType());
    }
}
