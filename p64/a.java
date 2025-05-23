package p64;

import com.tencent.robot.profile.data.g;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u001b\b\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H&R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0001\u0001\u0014\u00a8\u0006\u0015"}, d2 = {"Lp64/a;", "", "other", "", "equals", "b", "a", "", "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "itemId", "Z", "c", "()Z", "d", "(Z)V", "exported", "<init>", "(Ljava/lang/String;Z)V", "Lp64/b;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String itemId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean exported;

    public /* synthetic */ a(String str, boolean z16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z16);
    }

    public abstract boolean a(@NotNull a other);

    public abstract boolean b(@NotNull a other);

    /* renamed from: c, reason: from getter */
    public final boolean getExported() {
        return this.exported;
    }

    public final void d(boolean z16) {
        this.exported = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        return Intrinsics.areEqual(this.itemId, ((g) other).getItemId());
    }

    a(String str, boolean z16) {
        this.itemId = str;
        this.exported = z16;
    }

    public /* synthetic */ a(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? false : z16, null);
    }
}
