package kt2;

import com.tencent.qqnt.kernel.nativeinterface.AIOBindGuildInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016R\u0017\u0010\t\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\u000f\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lkt2/d;", "Lkt2/a;", "newItem", "", "b", "a", "Z", "e", "()Z", "isSelected", "Lcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;", "aioBindGuildInfo", "d", "isLastItem", "<init>", "(ZLcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;Z)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isSelected;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AIOBindGuildInfo aioBindGuildInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isLastItem;

    public d() {
        this(false, null, false, 7, null);
    }

    @Override // kt2.a
    public boolean a(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return false;
    }

    @Override // kt2.a
    public boolean b(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (newItem instanceof d) {
            d dVar = (d) newItem;
            if (dVar.isSelected == this.isSelected && Intrinsics.areEqual(dVar.aioBindGuildInfo, this.aioBindGuildInfo) && dVar.isLastItem == this.isLastItem) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final AIOBindGuildInfo getAioBindGuildInfo() {
        return this.aioBindGuildInfo;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsLastItem() {
        return this.isLastItem;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public /* synthetic */ d(boolean z16, AIOBindGuildInfo aIOBindGuildInfo, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? null : aIOBindGuildInfo, (i3 & 4) != 0 ? false : z17);
    }

    public d(boolean z16, @Nullable AIOBindGuildInfo aIOBindGuildInfo, boolean z17) {
        this.isSelected = z16;
        this.aioBindGuildInfo = aIOBindGuildInfo;
        this.isLastItem = z17;
    }
}
