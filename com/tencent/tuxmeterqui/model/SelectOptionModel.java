package com.tencent.tuxmeterqui.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.model.Option;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SelectOptionModel implements Serializable {
    static IPatchRedirector $redirector_;
    private boolean isSelect;
    private Option option;

    public SelectOptionModel(Option option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) option);
        } else {
            this.option = option;
        }
    }

    public Option getOption() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Option) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.option;
    }

    public boolean isSelect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isSelect;
    }

    public void setOption(Option option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) option);
        } else {
            this.option = option;
        }
    }

    public void setSelect(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.isSelect = z16;
        }
    }
}
