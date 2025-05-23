package com.tencent.mobileqq.troop.redpoint;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* loaded from: classes19.dex */
public class RedPointItem implements Serializable {
    static IPatchRedirector $redirector_;
    public int redId;
    public int unReadNum;

    public RedPointItem(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.redId = i3;
            this.unReadNum = i16;
        }
    }
}
