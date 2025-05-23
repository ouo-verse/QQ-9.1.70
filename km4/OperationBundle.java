package km4;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomRotateMessage;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0010\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lkm4/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "roomId", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomRotateMessage;", "b", "Ljava/util/List;", "c", "()Ljava/util/List;", "setRoomRotateMsgList", "(Ljava/util/List;)V", "roomRotateMsgList", "Lj05/a;", "roomOperation", "Lj05/a;", "()Lj05/a;", "setRoomOperation", "(Lj05/a;)V", "<init>", "(JLj05/a;Ljava/util/List;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: km4.a, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class OperationBundle {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<YoloRoomOuterClass$YoloRoomRotateMessage> roomRotateMsgList;

    public OperationBundle(long j3, @Nullable j05.a aVar, @NotNull List<YoloRoomOuterClass$YoloRoomRotateMessage> roomRotateMsgList) {
        Intrinsics.checkNotNullParameter(roomRotateMsgList, "roomRotateMsgList");
        this.roomId = j3;
        this.roomRotateMsgList = roomRotateMsgList;
    }

    /* renamed from: a, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    @Nullable
    public final j05.a b() {
        return null;
    }

    @NotNull
    public final List<YoloRoomOuterClass$YoloRoomRotateMessage> c() {
        return this.roomRotateMsgList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OperationBundle)) {
            return false;
        }
        OperationBundle operationBundle = (OperationBundle) other;
        if (this.roomId == operationBundle.roomId && Intrinsics.areEqual((Object) null, (Object) null) && Intrinsics.areEqual(this.roomRotateMsgList, operationBundle.roomRotateMsgList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((androidx.fragment.app.a.a(this.roomId) * 31) + 0) * 31) + this.roomRotateMsgList.hashCode();
    }

    @NotNull
    public String toString() {
        return "OperationBundle(roomId=" + this.roomId + ", roomOperation=" + ((Object) null) + ", roomRotateMsgList=" + this.roomRotateMsgList + ")";
    }
}
