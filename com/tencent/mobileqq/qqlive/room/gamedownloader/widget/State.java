package com.tencent.mobileqq.qqlive.room.gamedownloader.widget;

import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.raft.codegenmeta.utils.RLog;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/State;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "IDLE", "DOWNLOADING", Tracker.PAUSE, com.tencent.tmdownloader.a.CONNTECTSTATE_FINISH, "INSTALLED", RLog.ERROR, "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class State {
    private static final /* synthetic */ State[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final State DOWNLOADING;
    public static final State ERROR;
    public static final State FINISH;
    public static final State IDLE;
    public static final State INSTALLED;
    public static final State PAUSE;
    private final int value;

    private static final /* synthetic */ State[] $values() {
        return new State[]{IDLE, DOWNLOADING, PAUSE, FINISH, INSTALLED, ERROR};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28945);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        IDLE = new State("IDLE", 0, 0);
        DOWNLOADING = new State("DOWNLOADING", 1, 1);
        PAUSE = new State(Tracker.PAUSE, 2, 2);
        FINISH = new State(com.tencent.tmdownloader.a.CONNTECTSTATE_FINISH, 3, 3);
        INSTALLED = new State("INSTALLED", 4, 4);
        ERROR = new State(RLog.ERROR, 5, 5);
        $VALUES = $values();
    }

    State(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    public static State valueOf(String str) {
        return (State) Enum.valueOf(State.class, str);
    }

    public static State[] values() {
        return (State[]) $VALUES.clone();
    }

    public final int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.value;
    }
}
