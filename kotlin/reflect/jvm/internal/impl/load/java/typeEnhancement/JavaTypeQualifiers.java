package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaTypeQualifiers {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final JavaTypeQualifiers NONE = new JavaTypeQualifiers(null, null, false, false, 8, null);
    private final boolean definitelyNotNull;
    private final boolean isNullabilityQualifierForWarning;

    @Nullable
    private final MutabilityQualifier mutability;

    @Nullable
    private final NullabilityQualifier nullability;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final JavaTypeQualifiers getNONE() {
            return JavaTypeQualifiers.NONE;
        }

        Companion() {
        }
    }

    public JavaTypeQualifiers(@Nullable NullabilityQualifier nullabilityQualifier, @Nullable MutabilityQualifier mutabilityQualifier, boolean z16, boolean z17) {
        this.nullability = nullabilityQualifier;
        this.mutability = mutabilityQualifier;
        this.definitelyNotNull = z16;
        this.isNullabilityQualifierForWarning = z17;
    }

    public final boolean getDefinitelyNotNull() {
        return this.definitelyNotNull;
    }

    @Nullable
    public final MutabilityQualifier getMutability() {
        return this.mutability;
    }

    @Nullable
    public final NullabilityQualifier getNullability() {
        return this.nullability;
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.isNullabilityQualifierForWarning;
    }

    public /* synthetic */ JavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifier, mutabilityQualifier, z16, (i3 & 8) != 0 ? false : z17);
    }
}
