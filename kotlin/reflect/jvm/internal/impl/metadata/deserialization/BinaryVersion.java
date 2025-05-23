package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class BinaryVersion {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int major;
    private final int minor;

    @NotNull
    private final int[] numbers;
    private final int patch;

    @NotNull
    private final List<Integer> rest;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    public BinaryVersion(@NotNull int... numbers) {
        Integer orNull;
        int i3;
        Integer orNull2;
        int i16;
        Integer orNull3;
        List<Integer> emptyList;
        List asList;
        Intrinsics.checkNotNullParameter(numbers, "numbers");
        this.numbers = numbers;
        orNull = ArraysKt___ArraysKt.getOrNull(numbers, 0);
        if (orNull != null) {
            i3 = orNull.intValue();
        } else {
            i3 = -1;
        }
        this.major = i3;
        orNull2 = ArraysKt___ArraysKt.getOrNull(numbers, 1);
        if (orNull2 != null) {
            i16 = orNull2.intValue();
        } else {
            i16 = -1;
        }
        this.minor = i16;
        orNull3 = ArraysKt___ArraysKt.getOrNull(numbers, 2);
        this.patch = orNull3 != null ? orNull3.intValue() : -1;
        if (numbers.length <= 3) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else if (numbers.length <= 1024) {
            asList = ArraysKt___ArraysJvmKt.asList(numbers);
            emptyList = CollectionsKt___CollectionsKt.toList(asList.subList(3, numbers.length));
        } else {
            throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + numbers.length + '.');
        }
        this.rest = emptyList;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != null && Intrinsics.areEqual(getClass(), obj.getClass())) {
            BinaryVersion binaryVersion = (BinaryVersion) obj;
            if (this.major == binaryVersion.major && this.minor == binaryVersion.minor && this.patch == binaryVersion.patch && Intrinsics.areEqual(this.rest, binaryVersion.rest)) {
                return true;
            }
        }
        return false;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public int hashCode() {
        int i3 = this.major;
        int i16 = i3 + (i3 * 31) + this.minor;
        int i17 = i16 + (i16 * 31) + this.patch;
        return i17 + (i17 * 31) + this.rest.hashCode();
    }

    public final boolean isAtLeast(@NotNull BinaryVersion version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return isAtLeast(version.major, version.minor, version.patch);
    }

    public final boolean isAtMost(int i3, int i16, int i17) {
        int i18 = this.major;
        if (i18 < i3) {
            return true;
        }
        if (i18 > i3) {
            return false;
        }
        int i19 = this.minor;
        if (i19 < i16) {
            return true;
        }
        if (i19 <= i16 && this.patch <= i17) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isCompatibleTo(@NotNull BinaryVersion ourVersion) {
        Intrinsics.checkNotNullParameter(ourVersion, "ourVersion");
        int i3 = this.major;
        if (i3 == 0) {
            if (ourVersion.major == 0 && this.minor == ourVersion.minor) {
                return true;
            }
        } else if (i3 == ourVersion.major && this.minor <= ourVersion.minor) {
            return true;
        }
        return false;
    }

    @NotNull
    public final int[] toArray() {
        return this.numbers;
    }

    @NotNull
    public String toString() {
        String joinToString$default;
        boolean z16;
        int[] array = toArray();
        ArrayList arrayList = new ArrayList();
        for (int i3 : array) {
            if (i3 != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                break;
            }
            arrayList.add(Integer.valueOf(i3));
        }
        if (!arrayList.isEmpty()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ".", null, null, 0, null, null, 62, null);
            return joinToString$default;
        }
        return "unknown";
    }

    public final boolean isAtLeast(int i3, int i16, int i17) {
        int i18 = this.major;
        if (i18 > i3) {
            return true;
        }
        if (i18 < i3) {
            return false;
        }
        int i19 = this.minor;
        if (i19 > i16) {
            return true;
        }
        return i19 >= i16 && this.patch >= i17;
    }
}
