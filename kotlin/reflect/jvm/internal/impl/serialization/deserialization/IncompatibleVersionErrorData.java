package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class IncompatibleVersionErrorData<T> {
    private final T actualVersion;

    @NotNull
    private final ClassId classId;
    private final T expectedVersion;

    @NotNull
    private final String filePath;

    public IncompatibleVersionErrorData(T t16, T t17, @NotNull String filePath, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(classId, "classId");
        this.actualVersion = t16;
        this.expectedVersion = t17;
        this.filePath = filePath;
        this.classId = classId;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IncompatibleVersionErrorData)) {
            return false;
        }
        IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
        if (Intrinsics.areEqual(this.actualVersion, incompatibleVersionErrorData.actualVersion) && Intrinsics.areEqual(this.expectedVersion, incompatibleVersionErrorData.expectedVersion) && Intrinsics.areEqual(this.filePath, incompatibleVersionErrorData.filePath) && Intrinsics.areEqual(this.classId, incompatibleVersionErrorData.classId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        T t16 = this.actualVersion;
        int i3 = 0;
        if (t16 == null) {
            hashCode = 0;
        } else {
            hashCode = t16.hashCode();
        }
        int i16 = hashCode * 31;
        T t17 = this.expectedVersion;
        if (t17 != null) {
            i3 = t17.hashCode();
        }
        return ((((i16 + i3) * 31) + this.filePath.hashCode()) * 31) + this.classId.hashCode();
    }

    @NotNull
    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ", classId=" + this.classId + ')';
    }
}
