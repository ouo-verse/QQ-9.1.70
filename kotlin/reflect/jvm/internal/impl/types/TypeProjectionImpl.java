package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public class TypeProjectionImpl extends TypeProjectionBase {
    private final Variance projection;
    private final KotlinType type;

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 4 && i3 != 5) {
            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i3 != 4 && i3 != 5) {
            i16 = 3;
        } else {
            i16 = 2;
        }
        Object[] objArr = new Object[i16];
        switch (i3) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i3 != 4) {
            if (i3 != 5) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
            } else {
                objArr[1] = "getType";
            }
        } else {
            objArr[1] = "getProjectionKind";
        }
        if (i3 != 3) {
            if (i3 != 4 && i3 != 5) {
                if (i3 != 6) {
                    objArr[2] = "<init>";
                } else {
                    objArr[2] = "refine";
                }
            }
        } else {
            objArr[2] = "replaceType";
        }
        String format = String.format(str, objArr);
        if (i3 == 4 || i3 == 5) {
            throw new IllegalStateException(format);
        }
    }

    public TypeProjectionImpl(@NotNull Variance variance, @NotNull KotlinType kotlinType) {
        if (variance == null) {
            $$$reportNull$$$0(0);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(1);
        }
        this.projection = variance;
        this.type = kotlinType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public Variance getProjectionKind() {
        Variance variance = this.projection;
        if (variance == null) {
            $$$reportNull$$$0(4);
        }
        return variance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public KotlinType getType() {
        KotlinType kotlinType = this.type;
        if (kotlinType == null) {
            $$$reportNull$$$0(5);
        }
        return kotlinType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public TypeProjection refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(6);
        }
        return new TypeProjectionImpl(this.projection, kotlinTypeRefiner.refineType((KotlinTypeMarker) this.type));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypeProjectionImpl(@NotNull KotlinType kotlinType) {
        this(Variance.INVARIANT, kotlinType);
        if (kotlinType == null) {
            $$$reportNull$$$0(2);
        }
    }
}
