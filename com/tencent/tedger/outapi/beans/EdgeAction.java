package com.tencent.tedger.outapi.beans;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.proto.TEdgeEvent$Event;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class EdgeAction extends TEdgeRSBase {
    static IPatchRedirector $redirector_;

    public EdgeAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract ArrayList<TEdgeEvent$Event> getEvents();

    public abstract String getItemID();

    protected String getUserIDInCpp() {
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

    public abstract void setEvents(ArrayList<TEdgeEvent$Event> arrayList);
}
