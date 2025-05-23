package com.tencent.opentelemetry.sdk.logs.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.raft.codegenmeta.utils.RLog;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class Severity {
    private static final /* synthetic */ Severity[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final Severity DEBUG;
    public static final Severity DEBUG2;
    public static final Severity DEBUG3;
    public static final Severity DEBUG4;
    public static final Severity ERROR;
    public static final Severity ERROR2;
    public static final Severity ERROR3;
    public static final Severity ERROR4;
    public static final Severity FATAL;
    public static final Severity FATAL2;
    public static final Severity FATAL3;
    public static final Severity FATAL4;
    public static final Severity INFO;
    public static final Severity INFO2;
    public static final Severity INFO3;
    public static final Severity INFO4;
    public static final Severity TRACE;
    public static final Severity TRACE2;
    public static final Severity TRACE3;
    public static final Severity TRACE4;
    public static final Severity UNDEFINED_SEVERITY_NUMBER;
    public static final Severity WARN;
    public static final Severity WARN2;
    public static final Severity WARN3;
    public static final Severity WARN4;
    private final int severityNumber;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10587);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        Severity severity = new Severity("UNDEFINED_SEVERITY_NUMBER", 0, 0);
        UNDEFINED_SEVERITY_NUMBER = severity;
        Severity severity2 = new Severity("TRACE", 1, 1);
        TRACE = severity2;
        Severity severity3 = new Severity("TRACE2", 2, 2);
        TRACE2 = severity3;
        Severity severity4 = new Severity("TRACE3", 3, 3);
        TRACE3 = severity4;
        Severity severity5 = new Severity("TRACE4", 4, 4);
        TRACE4 = severity5;
        Severity severity6 = new Severity("DEBUG", 5, 5);
        DEBUG = severity6;
        Severity severity7 = new Severity("DEBUG2", 6, 6);
        DEBUG2 = severity7;
        Severity severity8 = new Severity("DEBUG3", 7, 7);
        DEBUG3 = severity8;
        Severity severity9 = new Severity("DEBUG4", 8, 8);
        DEBUG4 = severity9;
        Severity severity10 = new Severity("INFO", 9, 9);
        INFO = severity10;
        Severity severity11 = new Severity("INFO2", 10, 10);
        INFO2 = severity11;
        Severity severity12 = new Severity("INFO3", 11, 11);
        INFO3 = severity12;
        Severity severity13 = new Severity("INFO4", 12, 12);
        INFO4 = severity13;
        Severity severity14 = new Severity("WARN", 13, 13);
        WARN = severity14;
        Severity severity15 = new Severity("WARN2", 14, 14);
        WARN2 = severity15;
        Severity severity16 = new Severity("WARN3", 15, 15);
        WARN3 = severity16;
        Severity severity17 = new Severity("WARN4", 16, 16);
        WARN4 = severity17;
        Severity severity18 = new Severity(RLog.ERROR, 17, 17);
        ERROR = severity18;
        Severity severity19 = new Severity("ERROR2", 18, 18);
        ERROR2 = severity19;
        Severity severity20 = new Severity("ERROR3", 19, 19);
        ERROR3 = severity20;
        Severity severity21 = new Severity("ERROR4", 20, 20);
        ERROR4 = severity21;
        Severity severity22 = new Severity("FATAL", 21, 21);
        FATAL = severity22;
        Severity severity23 = new Severity("FATAL2", 22, 22);
        FATAL2 = severity23;
        Severity severity24 = new Severity("FATAL3", 23, 23);
        FATAL3 = severity24;
        Severity severity25 = new Severity("FATAL4", 24, 24);
        FATAL4 = severity25;
        $VALUES = new Severity[]{severity, severity2, severity3, severity4, severity5, severity6, severity7, severity8, severity9, severity10, severity11, severity12, severity13, severity14, severity15, severity16, severity17, severity18, severity19, severity20, severity21, severity22, severity23, severity24, severity25};
    }

    Severity(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.severityNumber = i16;
        }
    }

    public static Severity valueOf(String str) {
        return (Severity) Enum.valueOf(Severity.class, str);
    }

    public static Severity[] values() {
        return (Severity[]) $VALUES.clone();
    }

    public int getSeverityNumber() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.severityNumber;
    }
}
