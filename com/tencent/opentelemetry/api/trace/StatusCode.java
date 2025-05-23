package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.raft.codegenmeta.utils.RLog;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class StatusCode {
    private static final /* synthetic */ StatusCode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final StatusCode ERROR;
    public static final StatusCode OK;
    public static final StatusCode UNSET;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16726);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        StatusCode statusCode = new StatusCode("UNSET", 0);
        UNSET = statusCode;
        StatusCode statusCode2 = new StatusCode("OK", 1);
        OK = statusCode2;
        StatusCode statusCode3 = new StatusCode(RLog.ERROR, 2);
        ERROR = statusCode3;
        $VALUES = new StatusCode[]{statusCode, statusCode2, statusCode3};
    }

    StatusCode(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static StatusCode valueOf(String str) {
        return (StatusCode) Enum.valueOf(StatusCode.class, str);
    }

    public static StatusCode[] values() {
        return (StatusCode[]) $VALUES.clone();
    }
}
