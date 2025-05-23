package com.tencent.mobileqq.qqlive.api.anchor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes17.dex */
public final class QQLiveAnchorRoomState {
    private static final /* synthetic */ QQLiveAnchorRoomState[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final QQLiveAnchorRoomState STATE_CREATE;
    public static final QQLiveAnchorRoomState STATE_DESTROY;
    public static final QQLiveAnchorRoomState STATE_ENTER_FAILED;
    public static final QQLiveAnchorRoomState STATE_ENTER_ING;
    public static final QQLiveAnchorRoomState STATE_ENTER_READY;
    public static final QQLiveAnchorRoomState STATE_FIRST_FRAME_SENT;
    public static final QQLiveAnchorRoomState STATE_INIT_FAILED;
    public static final QQLiveAnchorRoomState STATE_INIT_ING;
    public static final QQLiveAnchorRoomState STATE_INIT_READY;
    public static final QQLiveAnchorRoomState STATE_LIVE_EXIT;
    public static final QQLiveAnchorRoomState STATE_LIVE_ING;
    public static final QQLiveAnchorRoomState STATE_NONE;
    public static final QQLiveAnchorRoomState STATE_PUBLISH_FAILED;
    public static final QQLiveAnchorRoomState STATE_PUBLISH_ING;
    public static final QQLiveAnchorRoomState STATE_PUBLISH_READY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32285);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        QQLiveAnchorRoomState qQLiveAnchorRoomState = new QQLiveAnchorRoomState("STATE_NONE", 0);
        STATE_NONE = qQLiveAnchorRoomState;
        QQLiveAnchorRoomState qQLiveAnchorRoomState2 = new QQLiveAnchorRoomState("STATE_CREATE", 1);
        STATE_CREATE = qQLiveAnchorRoomState2;
        QQLiveAnchorRoomState qQLiveAnchorRoomState3 = new QQLiveAnchorRoomState("STATE_INIT_ING", 2);
        STATE_INIT_ING = qQLiveAnchorRoomState3;
        QQLiveAnchorRoomState qQLiveAnchorRoomState4 = new QQLiveAnchorRoomState("STATE_INIT_READY", 3);
        STATE_INIT_READY = qQLiveAnchorRoomState4;
        QQLiveAnchorRoomState qQLiveAnchorRoomState5 = new QQLiveAnchorRoomState("STATE_INIT_FAILED", 4);
        STATE_INIT_FAILED = qQLiveAnchorRoomState5;
        QQLiveAnchorRoomState qQLiveAnchorRoomState6 = new QQLiveAnchorRoomState("STATE_ENTER_ING", 5);
        STATE_ENTER_ING = qQLiveAnchorRoomState6;
        QQLiveAnchorRoomState qQLiveAnchorRoomState7 = new QQLiveAnchorRoomState("STATE_ENTER_FAILED", 6);
        STATE_ENTER_FAILED = qQLiveAnchorRoomState7;
        QQLiveAnchorRoomState qQLiveAnchorRoomState8 = new QQLiveAnchorRoomState("STATE_ENTER_READY", 7);
        STATE_ENTER_READY = qQLiveAnchorRoomState8;
        QQLiveAnchorRoomState qQLiveAnchorRoomState9 = new QQLiveAnchorRoomState("STATE_PUBLISH_ING", 8);
        STATE_PUBLISH_ING = qQLiveAnchorRoomState9;
        QQLiveAnchorRoomState qQLiveAnchorRoomState10 = new QQLiveAnchorRoomState("STATE_PUBLISH_FAILED", 9);
        STATE_PUBLISH_FAILED = qQLiveAnchorRoomState10;
        QQLiveAnchorRoomState qQLiveAnchorRoomState11 = new QQLiveAnchorRoomState("STATE_PUBLISH_READY", 10);
        STATE_PUBLISH_READY = qQLiveAnchorRoomState11;
        QQLiveAnchorRoomState qQLiveAnchorRoomState12 = new QQLiveAnchorRoomState("STATE_LIVE_ING", 11);
        STATE_LIVE_ING = qQLiveAnchorRoomState12;
        QQLiveAnchorRoomState qQLiveAnchorRoomState13 = new QQLiveAnchorRoomState("STATE_LIVE_EXIT", 12);
        STATE_LIVE_EXIT = qQLiveAnchorRoomState13;
        QQLiveAnchorRoomState qQLiveAnchorRoomState14 = new QQLiveAnchorRoomState("STATE_DESTROY", 13);
        STATE_DESTROY = qQLiveAnchorRoomState14;
        QQLiveAnchorRoomState qQLiveAnchorRoomState15 = new QQLiveAnchorRoomState("STATE_FIRST_FRAME_SENT", 14);
        STATE_FIRST_FRAME_SENT = qQLiveAnchorRoomState15;
        $VALUES = new QQLiveAnchorRoomState[]{qQLiveAnchorRoomState, qQLiveAnchorRoomState2, qQLiveAnchorRoomState3, qQLiveAnchorRoomState4, qQLiveAnchorRoomState5, qQLiveAnchorRoomState6, qQLiveAnchorRoomState7, qQLiveAnchorRoomState8, qQLiveAnchorRoomState9, qQLiveAnchorRoomState10, qQLiveAnchorRoomState11, qQLiveAnchorRoomState12, qQLiveAnchorRoomState13, qQLiveAnchorRoomState14, qQLiveAnchorRoomState15};
    }

    QQLiveAnchorRoomState(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static QQLiveAnchorRoomState valueOf(String str) {
        return (QQLiveAnchorRoomState) Enum.valueOf(QQLiveAnchorRoomState.class, str);
    }

    public static QQLiveAnchorRoomState[] values() {
        return (QQLiveAnchorRoomState[]) $VALUES.clone();
    }
}
