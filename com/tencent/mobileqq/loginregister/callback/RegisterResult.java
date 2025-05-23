package com.tencent.mobileqq.loginregister.callback;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/loginregister/callback/RegisterResult;", "", "result", "", "(Ljava/lang/String;II)V", "getResult", "()I", "RegisterCancel", "RegisterFailed", "RegisterGatewayFailed", "RegisterAndLoginFailed", "RegisterAndLoginSuccess", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class RegisterResult {
    private static final /* synthetic */ RegisterResult[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final RegisterResult RegisterAndLoginFailed;
    public static final RegisterResult RegisterAndLoginSuccess;
    public static final RegisterResult RegisterCancel;
    public static final RegisterResult RegisterFailed;
    public static final RegisterResult RegisterGatewayFailed;
    private final int result;

    private static final /* synthetic */ RegisterResult[] $values() {
        return new RegisterResult[]{RegisterCancel, RegisterFailed, RegisterGatewayFailed, RegisterAndLoginFailed, RegisterAndLoginSuccess};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32292);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        RegisterCancel = new RegisterResult("RegisterCancel", 0, 0);
        RegisterFailed = new RegisterResult("RegisterFailed", 1, 1);
        RegisterGatewayFailed = new RegisterResult("RegisterGatewayFailed", 2, 2);
        RegisterAndLoginFailed = new RegisterResult("RegisterAndLoginFailed", 3, 3);
        RegisterAndLoginSuccess = new RegisterResult("RegisterAndLoginSuccess", 4, 4);
        $VALUES = $values();
    }

    RegisterResult(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.result = i16;
        }
    }

    public static RegisterResult valueOf(String str) {
        return (RegisterResult) Enum.valueOf(RegisterResult.class, str);
    }

    public static RegisterResult[] values() {
        return (RegisterResult[]) $VALUES.clone();
    }

    public final int getResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.result;
    }
}
