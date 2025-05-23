package kotlin.reflect.jvm.internal.impl.types;

/* loaded from: classes28.dex */
public final class TypeParameterErasureOptions {
    private final boolean intersectUpperBounds;
    private final boolean leaveNonTypeParameterTypes;

    public TypeParameterErasureOptions(boolean z16, boolean z17) {
        this.leaveNonTypeParameterTypes = z16;
        this.intersectUpperBounds = z17;
    }

    public final boolean getIntersectUpperBounds() {
        return this.intersectUpperBounds;
    }

    public final boolean getLeaveNonTypeParameterTypes() {
        return this.leaveNonTypeParameterTypes;
    }
}
