package g32;

import g32.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0011\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lg32/j;", "Lg32/b;", "E", "", "event", "", "a", "(Lg32/b;)Z", "Z", "b", "()Z", "isOnce", "<init>", "(Z)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class j<E extends b> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isOnce;

    public j() {
        this(false, 1, null);
    }

    public abstract boolean a(@NotNull E event);

    /* renamed from: b, reason: from getter */
    public final boolean getIsOnce() {
        return this.isOnce;
    }

    public j(boolean z16) {
        this.isOnce = z16;
    }

    public /* synthetic */ j(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
