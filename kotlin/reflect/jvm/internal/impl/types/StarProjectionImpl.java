package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public final class StarProjectionImpl extends TypeProjectionBase {

    @NotNull
    private final Lazy _type$delegate;

    @NotNull
    private final TypeParameterDescriptor typeParameter;

    public StarProjectionImpl(@NotNull TypeParameterDescriptor typeParameter) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        this.typeParameter = typeParameter;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl$_type$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final KotlinType invoke() {
                TypeParameterDescriptor typeParameterDescriptor;
                typeParameterDescriptor = StarProjectionImpl.this.typeParameter;
                return StarProjectionImplKt.starProjectionType(typeParameterDescriptor);
            }
        });
        this._type$delegate = lazy;
    }

    private final KotlinType get_type() {
        return (KotlinType) this._type$delegate.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public KotlinType getType() {
        return get_type();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public TypeProjection refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
