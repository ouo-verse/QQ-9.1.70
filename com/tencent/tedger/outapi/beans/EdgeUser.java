package com.tencent.tedger.outapi.beans;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class EdgeUser extends TEdgeRSBase {
    static IPatchRedirector $redirector_;

    public EdgeUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract ArrayList<EdgeAction> getActions();

    public abstract String getUserID();

    protected String getUserIDInCpp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String userID = getUserID();
        if (userID == null) {
            return "";
        }
        return userID;
    }

    public abstract void setActions(ArrayList<EdgeAction> arrayList);

    public abstract String setUserID(String str);

    public abstract void updateProfile(EdgeUser edgeUser);
}
