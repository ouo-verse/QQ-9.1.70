package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class NullabilityQualifierWithMigrationStatus {
    private final boolean isForWarningOnly;

    @NotNull
    private final NullabilityQualifier qualifier;

    public NullabilityQualifierWithMigrationStatus(@NotNull NullabilityQualifier qualifier, boolean z16) {
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        this.qualifier = qualifier;
        this.isForWarningOnly = z16;
    }

    public static /* synthetic */ NullabilityQualifierWithMigrationStatus copy$default(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, NullabilityQualifier nullabilityQualifier, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            nullabilityQualifier = nullabilityQualifierWithMigrationStatus.qualifier;
        }
        if ((i3 & 2) != 0) {
            z16 = nullabilityQualifierWithMigrationStatus.isForWarningOnly;
        }
        return nullabilityQualifierWithMigrationStatus.copy(nullabilityQualifier, z16);
    }

    @NotNull
    public final NullabilityQualifierWithMigrationStatus copy(@NotNull NullabilityQualifier qualifier, boolean z16) {
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        return new NullabilityQualifierWithMigrationStatus(qualifier, z16);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NullabilityQualifierWithMigrationStatus)) {
            return false;
        }
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = (NullabilityQualifierWithMigrationStatus) obj;
        if (this.qualifier == nullabilityQualifierWithMigrationStatus.qualifier && this.isForWarningOnly == nullabilityQualifierWithMigrationStatus.isForWarningOnly) {
            return true;
        }
        return false;
    }

    @NotNull
    public final NullabilityQualifier getQualifier() {
        return this.qualifier;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.qualifier.hashCode() * 31;
        boolean z16 = this.isForWarningOnly;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final boolean isForWarningOnly() {
        return this.isForWarningOnly;
    }

    @NotNull
    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.qualifier + ", isForWarningOnly=" + this.isForWarningOnly + ')';
    }

    public /* synthetic */ NullabilityQualifierWithMigrationStatus(NullabilityQualifier nullabilityQualifier, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifier, (i3 & 2) != 0 ? false : z16);
    }
}
