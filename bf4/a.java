package bf4;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import pl4.a;
import pl4.d;
import trpc.yes.common.LiveActivityServerOuterClass$GetRoomPendantReq;
import trpc.yes.common.LiveActivityServerOuterClass$GetRoomPendantRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bJ\b\u0010\r\u001a\u00020\u0002H\u0014\u00a8\u0006\u0010"}, d2 = {"Lbf4/a;", "Lpl4/a;", "", "viewType", "", "roomId", "Lmqq/app/NewIntent;", "d", "Lpl4/d;", "Ltrpc/yes/common/LiveActivityServerOuterClass$GetRoomPendantRsp;", "callback", "", "e", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a extends pl4.a {
    private final NewIntent d(int viewType, long roomId) {
        LiveActivityServerOuterClass$GetRoomPendantReq liveActivityServerOuterClass$GetRoomPendantReq = new LiveActivityServerOuterClass$GetRoomPendantReq();
        liveActivityServerOuterClass$GetRoomPendantReq.room_id.set(roomId);
        liveActivityServerOuterClass$GetRoomPendantReq.view_type.set(viewType);
        return a.C11028a.a(liveActivityServerOuterClass$GetRoomPendantReq, a.class);
    }

    @Override // pl4.a
    protected int b() {
        return 719;
    }

    public final void e(int viewType, long roomId, @NotNull d<LiveActivityServerOuterClass$GetRoomPendantRsp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(d(viewType, roomId), LiveActivityServerOuterClass$GetRoomPendantRsp.class, callback);
    }
}
