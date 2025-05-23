package com.tencent.mobileqq.troop.troopgame.data;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopGameActivityInfo implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TroopGameActivityInfo";
    public long activityValue;
    public String iconUrl;
    public String rankEntrance;
    public long rankNum;
    public String rankText;

    public TroopGameActivityInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.activityValue = 0L;
            this.rankNum = 0L;
        }
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "activityValue = " + this.activityValue + ", rankNum = " + this.rankNum + ", rankText = " + this.rankText + ", rankEntrance = " + this.rankEntrance + ", iconUrl = " + this.iconUrl;
    }
}
