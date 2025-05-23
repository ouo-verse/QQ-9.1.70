package com.tencent.tedger.outapi.beans;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class EdgeItem extends TEdgeRSBase {
    static IPatchRedirector $redirector_;

    public EdgeItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract String getItemID();

    protected String getItemIDInCpp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String itemID = getItemID();
        if (itemID == null) {
            return "";
        }
        return itemID;
    }
}
