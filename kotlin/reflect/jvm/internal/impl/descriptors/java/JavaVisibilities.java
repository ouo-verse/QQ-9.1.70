package kotlin.reflect.jvm.internal.impl.descriptors.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaVisibilities {

    @NotNull
    public static final JavaVisibilities INSTANCE = new JavaVisibilities();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class PackageVisibility extends Visibility {

        @NotNull
        public static final PackageVisibility INSTANCE = new PackageVisibility();

        PackageVisibility() {
            super("package", false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        @Nullable
        public Integer compareTo(@NotNull Visibility visibility) {
            Intrinsics.checkNotNullParameter(visibility, "visibility");
            if (this == visibility) {
                return 0;
            }
            if (Visibilities.INSTANCE.isPrivate(visibility)) {
                return 1;
            }
            return -1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        @NotNull
        public String getInternalDisplayName() {
            return "public/*package*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        @NotNull
        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ProtectedAndPackage extends Visibility {

        @NotNull
        public static final ProtectedAndPackage INSTANCE = new ProtectedAndPackage();

        ProtectedAndPackage() {
            super("protected_and_package", true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        @Nullable
        public Integer compareTo(@NotNull Visibility visibility) {
            int i3;
            Intrinsics.checkNotNullParameter(visibility, "visibility");
            if (Intrinsics.areEqual(this, visibility)) {
                return 0;
            }
            if (visibility == Visibilities.Internal.INSTANCE) {
                return null;
            }
            if (Visibilities.INSTANCE.isPrivate(visibility)) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            return Integer.valueOf(i3);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        @NotNull
        public String getInternalDisplayName() {
            return "protected/*protected and package*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        @NotNull
        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ProtectedStaticVisibility extends Visibility {

        @NotNull
        public static final ProtectedStaticVisibility INSTANCE = new ProtectedStaticVisibility();

        ProtectedStaticVisibility() {
            super("protected_static", true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        @NotNull
        public String getInternalDisplayName() {
            return "protected/*protected static*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        @NotNull
        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    JavaVisibilities() {
    }
}
