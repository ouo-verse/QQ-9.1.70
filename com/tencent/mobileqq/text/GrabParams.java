package com.tencent.mobileqq.text;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes18.dex */
public class GrabParams {
    static IPatchRedirector $redirector_;
    public int emoSize;
    public int end;
    public int flag;
    public Object message;
    public int start;
    public String text;
    public int uinType;

    public GrabParams(String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.emoSize = 32;
        this.uinType = -1;
        this.text = str;
        this.flag = i3;
        this.start = i16;
        this.end = i17;
    }

    public void setEmoSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.emoSize = i3;
        }
    }

    public void setMessage(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, obj);
        } else {
            this.message = obj;
        }
    }

    public void setUinType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.uinType = i3;
        }
    }
}
