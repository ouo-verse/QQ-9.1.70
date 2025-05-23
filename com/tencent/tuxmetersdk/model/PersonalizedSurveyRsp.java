package com.tencent.tuxmetersdk.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class PersonalizedSurveyRsp {
    static IPatchRedirector $redirector_;
    private Integer code;
    private Survey legacy;

    /* renamed from: msg, reason: collision with root package name */
    private String f383483msg;

    public PersonalizedSurveyRsp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public Integer getCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Integer) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.code;
    }

    public Survey getLegacy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Survey) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.legacy;
    }

    public String getMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f383483msg;
    }

    public void setCode(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) num);
        } else {
            this.code = num;
        }
    }

    public void setLegacy(Survey survey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) survey);
        } else {
            this.legacy = survey;
        }
    }

    public void setMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f383483msg = str;
        }
    }
}
