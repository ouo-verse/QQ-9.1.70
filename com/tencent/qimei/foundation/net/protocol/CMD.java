package com.tencent.qimei.foundation.net.protocol;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class CMD {
    static IPatchRedirector $redirector_;
    public static final CMD APM;
    public static final CMD AUDIT;
    public static final CMD AUDIT_SETTING;
    public static final CMD BEAT;
    public static final CMD GET_OID;
    public static final CMD H5_BIND;
    public static final CMD PWD_CHANGE;
    public static final CMD QM_SETTING;
    public static final CMD REGISTER;
    public static final CMD TASK_SETTING;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CMD[] f343274a;
    private final int cmd;
    private final int maxBodySize;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19894);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        CMD cmd = new CMD("REGISTER", 0, 1, 18);
        REGISTER = cmd;
        CMD cmd2 = new CMD("AUDIT", 1, 2, 0);
        AUDIT = cmd2;
        CMD cmd3 = new CMD("APM", 2, 3, 13);
        APM = cmd3;
        CMD cmd4 = new CMD("QM_SETTING", 3, 4, 1);
        QM_SETTING = cmd4;
        CMD cmd5 = new CMD("AUDIT_SETTING", 4, 5, 0);
        AUDIT_SETTING = cmd5;
        CMD cmd6 = new CMD("TASK_SETTING", 5, 6, 0);
        TASK_SETTING = cmd6;
        CMD cmd7 = new CMD("BEAT", 6, 7, 5);
        BEAT = cmd7;
        CMD cmd8 = new CMD("PWD_CHANGE", 7, 8, 0);
        PWD_CHANGE = cmd8;
        CMD cmd9 = new CMD("H5_BIND", 8, 11, 8);
        H5_BIND = cmd9;
        CMD cmd10 = new CMD("GET_OID", 9, 13, 3);
        GET_OID = cmd10;
        f343274a = new CMD[]{cmd, cmd2, cmd3, cmd4, cmd5, cmd6, cmd7, cmd8, cmd9, cmd10};
    }

    public CMD(String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.cmd = i16;
            this.maxBodySize = i17;
        }
    }

    public static CMD valueOf(String str) {
        return (CMD) Enum.valueOf(CMD.class, str);
    }

    public static CMD[] values() {
        return (CMD[]) f343274a.clone();
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.maxBodySize;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.cmd;
    }
}
