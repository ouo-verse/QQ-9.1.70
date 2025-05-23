package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum Modality {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;


    @NotNull
    public static final Companion Companion = new Companion(null);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Modality convertFromFlags(boolean z16, boolean z17, boolean z18) {
            if (z16) {
                return Modality.SEALED;
            }
            if (z17) {
                return Modality.ABSTRACT;
            }
            if (z18) {
                return Modality.OPEN;
            }
            return Modality.FINAL;
        }

        Companion() {
        }
    }
}
