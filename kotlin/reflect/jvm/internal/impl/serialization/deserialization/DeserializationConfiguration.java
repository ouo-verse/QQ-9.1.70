package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface DeserializationConfiguration {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Default implements DeserializationConfiguration {

        @NotNull
        public static final Default INSTANCE = new Default();

        Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getAllowUnstableDependencies() {
            return DefaultImpls.getAllowUnstableDependencies(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getPreserveDeclarationsOrdering() {
            return DefaultImpls.getPreserveDeclarationsOrdering(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getReportErrorsOnPreReleaseDependencies() {
            return DefaultImpls.getReportErrorsOnPreReleaseDependencies(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getSkipMetadataVersionCheck() {
            return DefaultImpls.getSkipMetadataVersionCheck(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getSkipPrereleaseCheck() {
            return DefaultImpls.getSkipPrereleaseCheck(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getTypeAliasesAllowed() {
            return DefaultImpls.getTypeAliasesAllowed(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        public static boolean getAllowUnstableDependencies(@NotNull DeserializationConfiguration deserializationConfiguration) {
            return false;
        }

        public static boolean getPreserveDeclarationsOrdering(@NotNull DeserializationConfiguration deserializationConfiguration) {
            return false;
        }

        public static boolean getReportErrorsOnPreReleaseDependencies(@NotNull DeserializationConfiguration deserializationConfiguration) {
            return false;
        }

        public static boolean getSkipMetadataVersionCheck(@NotNull DeserializationConfiguration deserializationConfiguration) {
            return false;
        }

        public static boolean getSkipPrereleaseCheck(@NotNull DeserializationConfiguration deserializationConfiguration) {
            return false;
        }

        public static boolean getTypeAliasesAllowed(@NotNull DeserializationConfiguration deserializationConfiguration) {
            return true;
        }
    }

    boolean getAllowUnstableDependencies();

    boolean getPreserveDeclarationsOrdering();

    boolean getReportErrorsOnPreReleaseDependencies();

    boolean getSkipMetadataVersionCheck();

    boolean getSkipPrereleaseCheck();

    boolean getTypeAliasesAllowed();
}
