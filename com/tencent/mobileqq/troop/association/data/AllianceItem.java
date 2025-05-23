package com.tencent.mobileqq.troop.association.data;

import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AllianceItem implements Serializable {
    static IPatchRedirector $redirector_;
    public String adminName;
    public String adminUin;
    public int associatedTroopCount;
    public List<AssociatedTroopItem> associatedTroopList;
    public long createTime;
    public String nextTroopUin;

    @unique
    public String uin;

    public AllianceItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("AllianceItem{uin='" + this.uin + "', adminUin='" + this.adminUin + "', createTime='" + this.createTime + "', associatedTroopCount='" + this.associatedTroopCount + "', nextTroopUin='" + this.nextTroopUin + '\'');
        if (this.associatedTroopList != null) {
            sb5.append(", associatedTroopList='");
            int size = this.associatedTroopList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 == size - 1) {
                    sb5.append(this.associatedTroopList.get(i3).toString() + "'");
                } else {
                    sb5.append(this.associatedTroopList.get(i3).toString() + "\u3001");
                }
            }
        }
        sb5.append("}");
        return sb5.toString();
    }
}
