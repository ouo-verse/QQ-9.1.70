package m32;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lm32/a;", "Lg32/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "getComponentKey", "()Ljava/lang/String;", "componentKey", "<init>", "(Ljava/lang/String;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: m32.a, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class ComponentInitEvent extends g32.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String componentKey;

    public ComponentInitEvent(@NotNull String componentKey) {
        Intrinsics.checkNotNullParameter(componentKey, "componentKey");
        this.componentKey = componentKey;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ComponentInitEvent) && Intrinsics.areEqual(this.componentKey, ((ComponentInitEvent) other).componentKey)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.componentKey.hashCode();
    }

    @NotNull
    public String toString() {
        return "ComponentInitEvent(componentKey=" + this.componentKey + ")";
    }
}
