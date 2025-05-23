package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer;
import kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public final class RawProjectionComputer extends ErasureProjectionComputer {

    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JavaTypeFlexibility.values().length];
            try {
                iArr[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer
    @NotNull
    public TypeProjection computeProjection(@NotNull TypeParameterDescriptor parameter, @NotNull ErasureTypeAttributes typeAttr, @NotNull TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, @NotNull KotlinType erasedUpperBound) {
        TypeProjection makeStarProjection;
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
        Intrinsics.checkNotNullParameter(typeParameterUpperBoundEraser, "typeParameterUpperBoundEraser");
        Intrinsics.checkNotNullParameter(erasedUpperBound, "erasedUpperBound");
        if (!(typeAttr instanceof JavaTypeAttributes)) {
            return super.computeProjection(parameter, typeAttr, typeParameterUpperBoundEraser, erasedUpperBound);
        }
        JavaTypeAttributes javaTypeAttributes = (JavaTypeAttributes) typeAttr;
        if (!javaTypeAttributes.isRaw()) {
            javaTypeAttributes = javaTypeAttributes.withFlexibility(JavaTypeFlexibility.INFLEXIBLE);
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[javaTypeAttributes.getFlexibility().ordinal()];
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            if (!parameter.getVariance().getAllowsOutPosition()) {
                makeStarProjection = new TypeProjectionImpl(Variance.INVARIANT, DescriptorUtilsKt.getBuiltIns(parameter).getNothingType());
            } else {
                Intrinsics.checkNotNullExpressionValue(erasedUpperBound.getConstructor().getParameters(), "erasedUpperBound.constructor.parameters");
                if (!r5.isEmpty()) {
                    makeStarProjection = new TypeProjectionImpl(Variance.OUT_VARIANCE, erasedUpperBound);
                } else {
                    makeStarProjection = TypeUtils.makeStarProjection(parameter, javaTypeAttributes);
                }
            }
            Intrinsics.checkNotNullExpressionValue(makeStarProjection, "{\n                if (!p\u2026          }\n            }");
            return makeStarProjection;
        }
        return new TypeProjectionImpl(Variance.INVARIANT, erasedUpperBound);
    }
}
