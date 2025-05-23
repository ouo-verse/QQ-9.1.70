package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface LocalClassifierTypeSettings {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Default implements LocalClassifierTypeSettings {

        @NotNull
        public static final Default INSTANCE = new Default();

        Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings
        @Nullable
        public SimpleType getReplacementTypeForLocalClassifiers() {
            return null;
        }
    }

    @Nullable
    SimpleType getReplacementTypeForLocalClassifiers();
}
