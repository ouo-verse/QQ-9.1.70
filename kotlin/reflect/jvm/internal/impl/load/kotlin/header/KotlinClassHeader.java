package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KotlinClassHeader {

    @Nullable
    private final String[] data;
    private final int extraInt;

    @Nullable
    private final String extraString;

    @Nullable
    private final String[] incompatibleData;

    @NotNull
    private final Kind kind;

    @NotNull
    private final JvmMetadataVersion metadataVersion;

    @Nullable
    private final String packageName;

    @Nullable
    private final byte[] serializedIr;

    @Nullable
    private final String[] strings;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum Kind {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);


        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private static final Map<Integer, Kind> entryById;

        /* renamed from: id, reason: collision with root package name */
        private final int f412756id;

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @NotNull
            public final Kind getById(int i3) {
                Kind kind = (Kind) Kind.entryById.get(Integer.valueOf(i3));
                if (kind == null) {
                    return Kind.UNKNOWN;
                }
                return kind;
            }

            Companion() {
            }
        }

        static {
            int mapCapacity;
            int coerceAtLeast;
            Kind[] values = values();
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(values.length);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Kind kind : values) {
                linkedHashMap.put(Integer.valueOf(kind.f412756id), kind);
            }
            entryById = linkedHashMap;
        }

        Kind(int i3) {
            this.f412756id = i3;
        }

        @JvmStatic
        @NotNull
        public static final Kind getById(int i3) {
            return Companion.getById(i3);
        }
    }

    public KotlinClassHeader(@NotNull Kind kind, @NotNull JvmMetadataVersion metadataVersion, @Nullable String[] strArr, @Nullable String[] strArr2, @Nullable String[] strArr3, @Nullable String str, int i3, @Nullable String str2, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        this.kind = kind;
        this.metadataVersion = metadataVersion;
        this.data = strArr;
        this.incompatibleData = strArr2;
        this.strings = strArr3;
        this.extraString = str;
        this.extraInt = i3;
        this.packageName = str2;
        this.serializedIr = bArr;
    }

    private final boolean has(int i3, int i16) {
        if ((i3 & i16) != 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String[] getData() {
        return this.data;
    }

    @Nullable
    public final String[] getIncompatibleData() {
        return this.incompatibleData;
    }

    @NotNull
    public final Kind getKind() {
        return this.kind;
    }

    @NotNull
    public final JvmMetadataVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    @Nullable
    public final String getMultifileClassName() {
        boolean z16;
        String str = this.extraString;
        if (this.kind == Kind.MULTIFILE_CLASS_PART) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return null;
        }
        return str;
    }

    @NotNull
    public final List<String> getMultifilePartNames() {
        boolean z16;
        List<String> emptyList;
        String[] strArr = this.data;
        if (this.kind == Kind.MULTIFILE_CLASS) {
            z16 = true;
        } else {
            z16 = false;
        }
        List<String> list = null;
        if (!z16) {
            strArr = null;
        }
        if (strArr != null) {
            list = ArraysKt___ArraysJvmKt.asList(strArr);
        }
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    @Nullable
    public final String[] getStrings() {
        return this.strings;
    }

    public final boolean isPreRelease() {
        return has(this.extraInt, 2);
    }

    public final boolean isUnstableFirBinary() {
        if (has(this.extraInt, 64) && !has(this.extraInt, 32)) {
            return true;
        }
        return false;
    }

    public final boolean isUnstableJvmIrBinary() {
        if (has(this.extraInt, 16) && !has(this.extraInt, 32)) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return this.kind + " version=" + this.metadataVersion;
    }
}
