package com.tencent.mobileqq.troop.navigatebar.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAioNavMsgCollection implements Serializable {
    static IPatchRedirector $redirector_;
    public List<TroopAioNavMsg> msgList;
    public String troopId;

    public TroopAioNavMsgCollection() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.troopId = "";
            this.msgList = new ArrayList();
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopAioNavMsgCollection{troopId='" + this.troopId + "', msgList=" + this.msgList + '}';
    }
}
