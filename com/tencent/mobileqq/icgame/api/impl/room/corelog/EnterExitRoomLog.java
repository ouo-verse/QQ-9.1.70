package com.tencent.mobileqq.icgame.api.impl.room.corelog;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tt0.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\r\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/impl/room/corelog/EnterExitRoomLog;", "", "()V", "STEP_CHECK_LOGIN_STATE", "", "STEP_ENTER_ROOM", "STEP_EXIT_ROOM", "TAG", "beginEnteringRoom", "", "msg", "beginExitingRoom", "endEnteringRoom", "endExitingRoom", "errorEnterRoom", "errorExitRoom", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class EnterExitRoomLog {

    @NotNull
    public static final EnterExitRoomLog INSTANCE = new EnterExitRoomLog();

    @NotNull
    private static final String STEP_CHECK_LOGIN_STATE = "checking login state";

    @NotNull
    private static final String STEP_ENTER_ROOM = "entering room";

    @NotNull
    private static final String STEP_EXIT_ROOM = "exiting room";

    @NotNull
    private static final String TAG = "ICGameCoreEnterRoom.EnterExitRoom.MiniSdk";

    EnterExitRoomLog() {
    }

    public final void beginEnteringRoom(@Nullable String msg2) {
        c.a().i(TAG, 1, "begin " + STEP_ENTER_ROOM + " -> " + msg2);
    }

    public final void beginExitingRoom(@Nullable String msg2) {
        c.a().i(TAG, 1, "begin " + STEP_EXIT_ROOM + " -> " + msg2);
    }

    public final void endEnteringRoom(@Nullable String msg2) {
        c.a().i(TAG, 1, "end " + STEP_ENTER_ROOM + " -> " + msg2);
    }

    public final void endExitingRoom(@Nullable String msg2) {
        c.a().i(TAG, 1, "end " + STEP_EXIT_ROOM + " -> " + msg2);
    }

    public final void errorEnterRoom(@Nullable String msg2) {
        c.a().e(TAG, 1, "error " + STEP_ENTER_ROOM + " -> " + msg2);
    }

    public final void errorExitRoom(@Nullable String msg2) {
        c.a().e(TAG, 1, "error " + STEP_EXIT_ROOM + " -> " + msg2);
    }
}
