package com.tencent.could.huiyansdk.enums;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes5.dex */
public final class AuthState {
    private static final /* synthetic */ AuthState[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AuthState ALL_ACTION_DONE;
    public static final AuthState AUTH_ACTION;
    public static final AuthState AUTH_END;
    public static final AuthState AUTH_ERROR_DIALOG;
    public static final AuthState AUTH_FAIL;
    public static final AuthState ON_ENTRY_BOT;
    public static final AuthState ON_ENTRY_OTHER_ACTION;
    public static final AuthState ON_EXIT_BOT;
    public static final AuthState ON_FIRST_FOUND_FACE;
    public static final AuthState PREPARE;
    public static final AuthState START_CAMERA_PREVIEW;
    public static final AuthState START_GET_LIVE_TYPE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18226);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        AuthState authState = new AuthState("PREPARE", 0);
        PREPARE = authState;
        AuthState authState2 = new AuthState("START_GET_LIVE_TYPE", 1);
        START_GET_LIVE_TYPE = authState2;
        AuthState authState3 = new AuthState("START_CAMERA_PREVIEW", 2);
        START_CAMERA_PREVIEW = authState3;
        AuthState authState4 = new AuthState("AUTH_ACTION", 3);
        AUTH_ACTION = authState4;
        AuthState authState5 = new AuthState("ALL_ACTION_DONE", 4);
        ALL_ACTION_DONE = authState5;
        AuthState authState6 = new AuthState("AUTH_END", 5);
        AUTH_END = authState6;
        AuthState authState7 = new AuthState("AUTH_FAIL", 6);
        AUTH_FAIL = authState7;
        AuthState authState8 = new AuthState("AUTH_ERROR_DIALOG", 7);
        AUTH_ERROR_DIALOG = authState8;
        AuthState authState9 = new AuthState("ON_FIRST_FOUND_FACE", 8);
        ON_FIRST_FOUND_FACE = authState9;
        AuthState authState10 = new AuthState("ON_ENTRY_OTHER_ACTION", 9);
        ON_ENTRY_OTHER_ACTION = authState10;
        AuthState authState11 = new AuthState("ON_ENTRY_BOT", 10);
        ON_ENTRY_BOT = authState11;
        AuthState authState12 = new AuthState("ON_EXIT_BOT", 11);
        ON_EXIT_BOT = authState12;
        $VALUES = new AuthState[]{authState, authState2, authState3, authState4, authState5, authState6, authState7, authState8, authState9, authState10, authState11, authState12};
    }

    AuthState(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static AuthState valueOf(String str) {
        return (AuthState) Enum.valueOf(AuthState.class, str);
    }

    public static AuthState[] values() {
        return (AuthState[]) $VALUES.clone();
    }
}
