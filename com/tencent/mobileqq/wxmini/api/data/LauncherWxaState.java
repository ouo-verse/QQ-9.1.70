package com.tencent.mobileqq.wxmini.api.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wxmini/api/data/LauncherWxaState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "STATE_AUTHORIZING", "STATE_AUTHORIZED", "STATE_LAUNCHING", "STATE_LAUNCH_SUCCEED", "STATE_LAUNCH_FAILED", "STATE_DOWNLOAD_SO_SUCCESS", "STATE_DOWNLOAD_SO_FAIL", "STATE_DOWNLOAD_SO_PROGRESS", "STATE_LAUNCHING_CLOSE", "wxmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class LauncherWxaState {
    private static final /* synthetic */ LauncherWxaState[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final LauncherWxaState STATE_AUTHORIZED;
    public static final LauncherWxaState STATE_AUTHORIZING;
    public static final LauncherWxaState STATE_DOWNLOAD_SO_FAIL;
    public static final LauncherWxaState STATE_DOWNLOAD_SO_PROGRESS;
    public static final LauncherWxaState STATE_DOWNLOAD_SO_SUCCESS;
    public static final LauncherWxaState STATE_LAUNCHING;
    public static final LauncherWxaState STATE_LAUNCHING_CLOSE;
    public static final LauncherWxaState STATE_LAUNCH_FAILED;
    public static final LauncherWxaState STATE_LAUNCH_SUCCEED;
    private final int state;

    private static final /* synthetic */ LauncherWxaState[] $values() {
        return new LauncherWxaState[]{STATE_AUTHORIZING, STATE_AUTHORIZED, STATE_LAUNCHING, STATE_LAUNCH_SUCCEED, STATE_LAUNCH_FAILED, STATE_DOWNLOAD_SO_SUCCESS, STATE_DOWNLOAD_SO_FAIL, STATE_DOWNLOAD_SO_PROGRESS, STATE_LAUNCHING_CLOSE};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36332);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        STATE_AUTHORIZING = new LauncherWxaState("STATE_AUTHORIZING", 0, 1);
        STATE_AUTHORIZED = new LauncherWxaState("STATE_AUTHORIZED", 1, 2);
        STATE_LAUNCHING = new LauncherWxaState("STATE_LAUNCHING", 2, 3);
        STATE_LAUNCH_SUCCEED = new LauncherWxaState("STATE_LAUNCH_SUCCEED", 3, 4);
        STATE_LAUNCH_FAILED = new LauncherWxaState("STATE_LAUNCH_FAILED", 4, 5);
        STATE_DOWNLOAD_SO_SUCCESS = new LauncherWxaState("STATE_DOWNLOAD_SO_SUCCESS", 5, 6);
        STATE_DOWNLOAD_SO_FAIL = new LauncherWxaState("STATE_DOWNLOAD_SO_FAIL", 6, 7);
        STATE_DOWNLOAD_SO_PROGRESS = new LauncherWxaState("STATE_DOWNLOAD_SO_PROGRESS", 7, 8);
        STATE_LAUNCHING_CLOSE = new LauncherWxaState("STATE_LAUNCHING_CLOSE", 8, 9);
        $VALUES = $values();
    }

    LauncherWxaState(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.state = i16;
        }
    }

    public static LauncherWxaState valueOf(String str) {
        return (LauncherWxaState) Enum.valueOf(LauncherWxaState.class, str);
    }

    public static LauncherWxaState[] values() {
        return (LauncherWxaState[]) $VALUES.clone();
    }

    public final int getState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.state;
    }
}
