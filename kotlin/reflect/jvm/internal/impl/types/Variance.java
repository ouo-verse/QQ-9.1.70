package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum Variance {
    INVARIANT("", true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE("out", false, true, 1);

    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;

    @NotNull
    private final String label;
    private final int superpositionFactor;

    Variance(String str, boolean z16, boolean z17, int i3) {
        this.label = str;
        this.allowsInPosition = z16;
        this.allowsOutPosition = z17;
        this.superpositionFactor = i3;
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.label;
    }
}
