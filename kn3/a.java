package kn3;

import kn3.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lkn3/a;", "", "a", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ln3.a f412722b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final ln3.a f412723c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final ln3.a f412724d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lkn3/a$a;", "", "Lln3/a;", "getSeqInfoApi", "Lln3/a;", "b", "()Lln3/a;", "getGameInfoApi", "a", "", "CMD_SEQ_INFO_PUSH", "I", "CMD_SWITCH_GAME_PUSH", "", "SERVICE_GAME_MANAGER", "Ljava/lang/String;", "<init>", "()V", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kn3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ln3.a a() {
            return a.f412723c;
        }

        @NotNull
        public final ln3.a b() {
            return a.f412722b;
        }

        Companion() {
        }
    }

    static {
        b.Companion companion = b.INSTANCE;
        f412722b = companion.a("trpc.qlive.room_dating_game_manager.RoomDatingGameManager", "GetSeqInfo");
        f412723c = companion.a("trpc.qlive.room_dating_game_manager.RoomDatingGameManager", "GetGameInfo");
        f412724d = companion.a("trpc.qlive.room_dating_game_manager.RoomDatingGameManager", "SwitchGame");
    }
}
