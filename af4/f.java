package af4;

import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.LiveActivityServerOuterClass$GetRoomPendantRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Laf4/f;", "", "", "viewType", "", "roomId", "Lbf4/b;", "listener", "", "b", "Ltrpc/yes/common/LiveActivityServerOuterClass$GetRoomPendantRsp;", "Ltrpc/yes/common/LiveActivityServerOuterClass$GetRoomPendantRsp;", "mCurrentTimiOperationData", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f26028a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static LiveActivityServerOuterClass$GetRoomPendantRsp mCurrentTimiOperationData = new LiveActivityServerOuterClass$GetRoomPendantRsp();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"af4/f$a", "Lbf4/b;", "Ltrpc/yes/common/LiveActivityServerOuterClass$GetRoomPendantRsp;", "rsp", "", "a", "", "errCode", "", "msg", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements bf4.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ bf4.b f26030d;

        a(bf4.b bVar) {
            this.f26030d = bVar;
        }

        @Override // bf4.b
        public void a(@NotNull LiveActivityServerOuterClass$GetRoomPendantRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            f.mCurrentTimiOperationData = rsp;
            this.f26030d.a(rsp);
        }

        @Override // bf4.b
        public void b(int errCode, @Nullable String msg2) {
            this.f26030d.b(errCode, msg2);
        }
    }

    f() {
    }

    public final void b(int viewType, long roomId, @NotNull bf4.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (o.d("TimiOperationDataManager" + roomId, 500)) {
            l.c("TimiOperationDataManager_", 1, "request too fre roomId:" + roomId + " filtered!");
            return;
        }
        l.h("TimiOperationDataManager_", 1, "request roomId:" + roomId + " starting.");
        bf4.c.f28360a.a(viewType, roomId, new a(listener));
    }
}
