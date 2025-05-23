package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface NullabilityAnnotationStates<T> {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final NullabilityAnnotationStates EMPTY;

        static {
            Map emptyMap;
            emptyMap = MapsKt__MapsKt.emptyMap();
            EMPTY = new NullabilityAnnotationStatesImpl(emptyMap);
        }

        Companion() {
        }

        @NotNull
        public final NullabilityAnnotationStates getEMPTY() {
            return EMPTY;
        }
    }

    @Nullable
    T get(@NotNull FqName fqName);
}
