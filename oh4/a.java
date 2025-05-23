package oh4;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mm4.b;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ph4.e;
import pl4.a;
import pl4.c;
import pl4.d;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomApplySpeakingListReq;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomApplySpeakingListRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\b"}, d2 = {"Loh4/a;", "Lpl4/a;", "", "b", "<init>", "()V", "d", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a extends pl4.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u00a8\u0006\u000e"}, d2 = {"Loh4/a$a;", "", "", "roomId", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomApplySpeakingListRsp;", "lastRsp", "Lmqq/app/NewIntent;", "a", "Lpl4/d;", "requestListener", "", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: oh4.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final NewIntent a(long roomId, YoloRoomOuterClass$YoloRoomApplySpeakingListRsp lastRsp) {
            YoloRoomOuterClass$YoloRoomApplySpeakingListReq yoloRoomOuterClass$YoloRoomApplySpeakingListReq = new YoloRoomOuterClass$YoloRoomApplySpeakingListReq();
            yoloRoomOuterClass$YoloRoomApplySpeakingListReq.room_id.set(roomId);
            yoloRoomOuterClass$YoloRoomApplySpeakingListReq.list_start_score.set(e.f426246a.I());
            if (lastRsp != null) {
                yoloRoomOuterClass$YoloRoomApplySpeakingListReq.last_score.set(lastRsp.next_score.get());
            }
            NewIntent a16 = a.C11028a.a(yoloRoomOuterClass$YoloRoomApplySpeakingListReq, a.class);
            Intrinsics.checkNotNullExpressionValue(a16, "createRequestIntent(\n   \u2026:class.java\n            )");
            return a16;
        }

        public final void b(long roomId, @Nullable YoloRoomOuterClass$YoloRoomApplySpeakingListRsp lastRsp, @NotNull d<YoloRoomOuterClass$YoloRoomApplySpeakingListRsp> requestListener) {
            Intrinsics.checkNotNullParameter(requestListener, "requestListener");
            ((c) b.b(c.class)).F1(a(roomId, lastRsp), YoloRoomOuterClass$YoloRoomApplySpeakingListRsp.class, requestListener);
        }

        Companion() {
        }
    }

    @Override // pl4.a
    protected int b() {
        return 926;
    }
}
