package com.tencent.qne.delegate;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.raft.codegenmeta.utils.RLog;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qne/delegate/Level;", "", "(Ljava/lang/String;I)V", "VERBOSE", "DEBUG", "INFO", "WARN", RLog.ERROR, "qne_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class Level {
    private static final /* synthetic */ Level[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final Level DEBUG;
    public static final Level ERROR;
    public static final Level INFO;
    public static final Level VERBOSE;
    public static final Level WARN;

    private static final /* synthetic */ Level[] $values() {
        return new Level[]{VERBOSE, DEBUG, INFO, WARN, ERROR};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14642);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        VERBOSE = new Level("VERBOSE", 0);
        DEBUG = new Level("DEBUG", 1);
        INFO = new Level("INFO", 2);
        WARN = new Level("WARN", 3);
        ERROR = new Level(RLog.ERROR, 4);
        $VALUES = $values();
    }

    Level(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static Level valueOf(String str) {
        return (Level) Enum.valueOf(Level.class, str);
    }

    public static Level[] values() {
        return (Level[]) $VALUES.clone();
    }
}
