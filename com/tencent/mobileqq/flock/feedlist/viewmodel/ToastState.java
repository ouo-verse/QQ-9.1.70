package com.tencent.mobileqq.flock.feedlist.viewmodel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/viewmodel/ToastState;", "", "msg", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "REFRESH_FAILED", "LOAD_MORE_FAILED", "NETWORK_ERROR", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class ToastState {
    private static final /* synthetic */ ToastState[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ToastState LOAD_MORE_FAILED;
    public static final ToastState NETWORK_ERROR;
    public static final ToastState REFRESH_FAILED;

    @NotNull
    private final String msg;

    private static final /* synthetic */ ToastState[] $values() {
        return new ToastState[]{REFRESH_FAILED, LOAD_MORE_FAILED, NETWORK_ERROR};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45180);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        REFRESH_FAILED = new ToastState("REFRESH_FAILED", 0, "\u5237\u65b0\u5931\u8d25");
        LOAD_MORE_FAILED = new ToastState("LOAD_MORE_FAILED", 1, "\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5");
        NETWORK_ERROR = new ToastState("NETWORK_ERROR", 2, "\u7f51\u7edc\u4e0d\u7ed9\u529b\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e");
        $VALUES = $values();
    }

    ToastState(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
        } else {
            this.msg = str2;
        }
    }

    public static ToastState valueOf(String str) {
        return (ToastState) Enum.valueOf(ToastState.class, str);
    }

    public static ToastState[] values() {
        return (ToastState[]) $VALUES.clone();
    }

    @NotNull
    public final String getMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.msg;
    }
}
