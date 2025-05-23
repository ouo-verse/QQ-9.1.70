package com.tencent.image.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ReportEventBean {
    static IPatchRedirector $redirector_;
    private final String actionName;
    private final int fromType;
    private final String mainAction;

    /* renamed from: r2, reason: collision with root package name */
    private final String f116249r2;

    /* renamed from: r3, reason: collision with root package name */
    private final String f116250r3;

    /* renamed from: r4, reason: collision with root package name */
    private final String f116251r4;

    /* renamed from: r5, reason: collision with root package name */
    private final String f116252r5;
    private final int result;
    private final String subAction;
    private final String tag;
    private final String toUin;

    public ReportEventBean(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), str6, str7, str8, str9);
            return;
        }
        this.tag = str;
        this.mainAction = str2;
        this.toUin = str3;
        this.subAction = str4;
        this.actionName = str5;
        this.fromType = i3;
        this.result = i16;
        this.f116249r2 = str6;
        this.f116250r3 = str7;
        this.f116251r4 = str8;
        this.f116252r5 = str9;
    }

    public String getActionName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.actionName;
    }

    public int getFromType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.fromType;
    }

    public String getMainAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mainAction;
    }

    public String getR2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f116249r2;
    }

    public String getR3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f116250r3;
    }

    public String getR4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f116251r4;
    }

    public String getR5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f116252r5;
    }

    public int getResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.result;
    }

    public String getSubAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.subAction;
    }

    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.tag;
    }

    public String getToUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.toUin;
    }
}
