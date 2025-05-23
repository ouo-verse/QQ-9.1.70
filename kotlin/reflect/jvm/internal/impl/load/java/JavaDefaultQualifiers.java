package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaDefaultQualifiers {
    private final boolean definitelyNotNull;

    @NotNull
    private final NullabilityQualifierWithMigrationStatus nullabilityQualifier;

    @NotNull
    private final Collection<AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public JavaDefaultQualifiers(@NotNull NullabilityQualifierWithMigrationStatus nullabilityQualifier, @NotNull Collection<? extends AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes, boolean z16) {
        Intrinsics.checkNotNullParameter(nullabilityQualifier, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        this.nullabilityQualifier = nullabilityQualifier;
        this.qualifierApplicabilityTypes = qualifierApplicabilityTypes;
        this.definitelyNotNull = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JavaDefaultQualifiers copy$default(JavaDefaultQualifiers javaDefaultQualifiers, NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection collection, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            nullabilityQualifierWithMigrationStatus = javaDefaultQualifiers.nullabilityQualifier;
        }
        if ((i3 & 2) != 0) {
            collection = javaDefaultQualifiers.qualifierApplicabilityTypes;
        }
        if ((i3 & 4) != 0) {
            z16 = javaDefaultQualifiers.definitelyNotNull;
        }
        return javaDefaultQualifiers.copy(nullabilityQualifierWithMigrationStatus, collection, z16);
    }

    @NotNull
    public final JavaDefaultQualifiers copy(@NotNull NullabilityQualifierWithMigrationStatus nullabilityQualifier, @NotNull Collection<? extends AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes, boolean z16) {
        Intrinsics.checkNotNullParameter(nullabilityQualifier, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        return new JavaDefaultQualifiers(nullabilityQualifier, qualifierApplicabilityTypes, z16);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaDefaultQualifiers)) {
            return false;
        }
        JavaDefaultQualifiers javaDefaultQualifiers = (JavaDefaultQualifiers) obj;
        if (Intrinsics.areEqual(this.nullabilityQualifier, javaDefaultQualifiers.nullabilityQualifier) && Intrinsics.areEqual(this.qualifierApplicabilityTypes, javaDefaultQualifiers.qualifierApplicabilityTypes) && this.definitelyNotNull == javaDefaultQualifiers.definitelyNotNull) {
            return true;
        }
        return false;
    }

    public final boolean getDefinitelyNotNull() {
        return this.definitelyNotNull;
    }

    @NotNull
    public final NullabilityQualifierWithMigrationStatus getNullabilityQualifier() {
        return this.nullabilityQualifier;
    }

    @NotNull
    public final Collection<AnnotationQualifierApplicabilityType> getQualifierApplicabilityTypes() {
        return this.qualifierApplicabilityTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.nullabilityQualifier.hashCode() * 31) + this.qualifierApplicabilityTypes.hashCode()) * 31;
        boolean z16 = this.definitelyNotNull;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.nullabilityQualifier + ", qualifierApplicabilityTypes=" + this.qualifierApplicabilityTypes + ", definitelyNotNull=" + this.definitelyNotNull + ')';
    }

    public /* synthetic */ JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection collection, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifierWithMigrationStatus, collection, (i3 & 4) != 0 ? nullabilityQualifierWithMigrationStatus.getQualifier() == NullabilityQualifier.NOT_NULL : z16);
    }
}
