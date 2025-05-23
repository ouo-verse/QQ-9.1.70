package com.tencent.mobileqq.app.parser;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes11.dex */
public class JumpParserBean {
    static IPatchRedirector $redirector_;
    private Class mParserClass;
    private String mParserKey;

    public JumpParserBean(String str, Class cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) cls);
        } else {
            this.mParserKey = str;
            this.mParserClass = cls;
        }
    }

    public Class getParserClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mParserClass;
    }

    public String getParserKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mParserKey;
    }

    public void setParserClass(Class cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cls);
        } else {
            this.mParserClass = cls;
        }
    }

    public void setParserKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mParserKey = str;
        }
    }
}
