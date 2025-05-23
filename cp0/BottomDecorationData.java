package cp0;

import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcp0/b;", "Lcp0/a;", "", "e", "", "getItemId", "", "toString", "hashCode", "", "other", "", "equals", "b", "I", "d", "()I", "itemHeight", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: cp0.b, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class BottomDecorationData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int itemHeight;

    public BottomDecorationData(int i3) {
        this.itemHeight = i3;
    }

    /* renamed from: d, reason: from getter */
    public final int getItemHeight() {
        return this.itemHeight;
    }

    public int e() {
        return 7;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof BottomDecorationData) && this.itemHeight == ((BottomDecorationData) other).itemHeight) {
            return true;
        }
        return false;
    }

    @Override // cp0.k
    public long getItemId() {
        return Objects.hash(Integer.valueOf(e()), Integer.valueOf(this.itemHeight));
    }

    public int hashCode() {
        return this.itemHeight;
    }

    @NotNull
    public String toString() {
        return "BottomDecorationData(itemHeight=" + this.itemHeight + ")";
    }
}
