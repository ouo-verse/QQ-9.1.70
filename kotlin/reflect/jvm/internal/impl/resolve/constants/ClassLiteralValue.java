package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ClassLiteralValue {
    private final int arrayNestedness;

    @NotNull
    private final ClassId classId;

    public ClassLiteralValue(@NotNull ClassId classId, int i3) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        this.classId = classId;
        this.arrayNestedness = i3;
    }

    @NotNull
    public final ClassId component1() {
        return this.classId;
    }

    public final int component2() {
        return this.arrayNestedness;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassLiteralValue)) {
            return false;
        }
        ClassLiteralValue classLiteralValue = (ClassLiteralValue) obj;
        if (Intrinsics.areEqual(this.classId, classLiteralValue.classId) && this.arrayNestedness == classLiteralValue.arrayNestedness) {
            return true;
        }
        return false;
    }

    public final int getArrayNestedness() {
        return this.arrayNestedness;
    }

    @NotNull
    public final ClassId getClassId() {
        return this.classId;
    }

    public int hashCode() {
        return (this.classId.hashCode() * 31) + this.arrayNestedness;
    }

    @NotNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        int i3 = this.arrayNestedness;
        for (int i16 = 0; i16 < i3; i16++) {
            sb5.append("kotlin/Array<");
        }
        sb5.append(this.classId);
        int i17 = this.arrayNestedness;
        for (int i18 = 0; i18 < i17; i18++) {
            sb5.append(">");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }
}
