package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JvmMetadataVersion extends BinaryVersion {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final JvmMetadataVersion INSTANCE = new JvmMetadataVersion(1, 7, 1);

    @JvmField
    @NotNull
    public static final JvmMetadataVersion INVALID_VERSION = new JvmMetadataVersion(new int[0]);
    private final boolean isStrictSemantics;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmMetadataVersion(@NotNull int[] versionArray, boolean z16) {
        super(Arrays.copyOf(versionArray, versionArray.length));
        Intrinsics.checkNotNullParameter(versionArray, "versionArray");
        this.isStrictSemantics = z16;
    }

    public boolean isCompatible() {
        boolean z16;
        if (getMajor() == 1 && getMinor() == 0) {
            return false;
        }
        if (this.isStrictSemantics) {
            z16 = isCompatibleTo(INSTANCE);
        } else {
            int major = getMajor();
            JvmMetadataVersion jvmMetadataVersion = INSTANCE;
            if (major == jvmMetadataVersion.getMajor() && getMinor() <= jvmMetadataVersion.getMinor() + 1) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JvmMetadataVersion(@NotNull int... numbers) {
        this(numbers, false);
        Intrinsics.checkNotNullParameter(numbers, "numbers");
    }
}
