package com.tencent.mobileqq.qqlive.api.impl.room.corelog;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import et3.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\r\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0010\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0011\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/room/corelog/EnterExitRoomLog;", "", "()V", "STEP_CHECK_LOGIN_STATE", "", "STEP_ENTER_ROOM", "STEP_EXIT_ROOM", "TAG", "beginCheckingLoginState", "", "msg", "beginEnteringRoom", "beginExitingRoom", "endCheckingLoginState", "endEnteringRoom", "endExitingRoom", "errorEnterRoom", "errorExitRoom", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class EnterExitRoomLog {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final EnterExitRoomLog INSTANCE;

    @NotNull
    private static final String STEP_CHECK_LOGIN_STATE = "checking login state";

    @NotNull
    private static final String STEP_ENTER_ROOM = "entering room";

    @NotNull
    private static final String STEP_EXIT_ROOM = "exiting room";

    @NotNull
    private static final String TAG = "CoreEnterRoom.EnterExitRoom.MiniSdk";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32647);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new EnterExitRoomLog();
        }
    }

    EnterExitRoomLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void beginCheckingLoginState(@Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msg2);
            return;
        }
        c.a().i(TAG, 1, "begin " + STEP_CHECK_LOGIN_STATE + " -> " + msg2);
    }

    public final void beginEnteringRoom(@Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
            return;
        }
        c.a().i(TAG, 1, "begin " + STEP_ENTER_ROOM + " -> " + msg2);
    }

    public final void beginExitingRoom(@Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msg2);
            return;
        }
        c.a().i(TAG, 1, "begin " + STEP_EXIT_ROOM + " -> " + msg2);
    }

    public final void endCheckingLoginState(@Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) msg2);
            return;
        }
        c.a().i(TAG, 1, "end " + STEP_CHECK_LOGIN_STATE + " -> " + msg2);
    }

    public final void endEnteringRoom(@Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2);
            return;
        }
        c.a().i(TAG, 1, "end " + STEP_ENTER_ROOM + " -> " + msg2);
    }

    public final void endExitingRoom(@Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) msg2);
            return;
        }
        c.a().i(TAG, 1, "end " + STEP_EXIT_ROOM + " -> " + msg2);
    }

    public final void errorEnterRoom(@Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) msg2);
            return;
        }
        c.a().e(TAG, 1, "error " + STEP_ENTER_ROOM + " -> " + msg2);
    }

    public final void errorExitRoom(@Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) msg2);
            return;
        }
        c.a().e(TAG, 1, "error " + STEP_EXIT_ROOM + " -> " + msg2);
    }
}
