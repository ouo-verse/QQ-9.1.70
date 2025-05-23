package kt2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016R\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lkt2/b;", "Lkt2/a;", "newItem", "", "a", "Z", "c", "()Z", "optGuildListIsEmpty", "<init>", "(Z)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean optGuildListIsEmpty;

    public b(boolean z16) {
        this.optGuildListIsEmpty = z16;
    }

    @Override // kt2.a
    public boolean a(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof b) || ((b) newItem).optGuildListIsEmpty != this.optGuildListIsEmpty) {
            return false;
        }
        return true;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getOptGuildListIsEmpty() {
        return this.optGuildListIsEmpty;
    }
}
