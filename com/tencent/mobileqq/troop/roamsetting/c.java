package com.tencent.mobileqq.troop.roamsetting;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends com.tencent.mobileqq.troop.api.config.a {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.a
    public void a(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
        } else {
            if (arrayList == null) {
                return;
            }
            arrayList.add(AppConstants.RoamingMapPath.TROOP_RING);
            arrayList.add(AppConstants.RoamingMapPath.TROOP_VIBRATE);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.a
    public int b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).intValue();
        }
        if (str.contains(AppConstants.RoamingMapPath.TROOP_RING)) {
            return 2;
        }
        if (str.contains(AppConstants.RoamingMapPath.TROOP_VIBRATE)) {
            return 3;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.troop.api.config.a
    public String c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        if (i3 == 2) {
            return String.valueOf(0);
        }
        if (i3 == 3) {
            return String.valueOf(0);
        }
        return null;
    }
}
