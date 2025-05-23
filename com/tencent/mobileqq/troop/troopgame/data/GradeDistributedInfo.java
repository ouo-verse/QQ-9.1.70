package com.tencent.mobileqq.troop.troopgame.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes19.dex */
public class GradeDistributedInfo implements Serializable {
    static IPatchRedirector $redirector_;
    public int grade;
    public long userCount;

    public GradeDistributedInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
