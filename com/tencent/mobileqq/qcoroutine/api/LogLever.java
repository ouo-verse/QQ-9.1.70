package com.tencent.mobileqq.qcoroutine.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.raft.codegenmeta.utils.RLog;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/LogLever;", "", "(Ljava/lang/String;I)V", "INFO", RLog.ERROR, "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class LogLever {
    private static final /* synthetic */ LogLever[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final LogLever ERROR;
    public static final LogLever INFO;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7627);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        LogLever logLever = new LogLever("INFO", 0);
        INFO = logLever;
        LogLever logLever2 = new LogLever(RLog.ERROR, 1);
        ERROR = logLever2;
        $VALUES = new LogLever[]{logLever, logLever2};
    }

    LogLever(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
    }

    public static LogLever valueOf(String str) {
        return (LogLever) Enum.valueOf(LogLever.class, str);
    }

    public static LogLever[] values() {
        return (LogLever[]) $VALUES.clone();
    }
}
