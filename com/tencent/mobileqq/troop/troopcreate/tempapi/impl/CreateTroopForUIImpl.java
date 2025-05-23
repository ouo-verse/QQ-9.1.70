package com.tencent.mobileqq.troop.troopcreate.tempapi.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.model.k;
import com.tencent.mobileqq.troop.troopcreate.tempapi.ICreateTroopForUI;
import mqq.app.AppRuntime;
import org.slf4j.Marker;
import wn2.ContactSearchModelNtBuddy;
import wn2.b;
import wn2.c;
import wn2.j;
import wn2.m;

/* compiled from: P */
/* loaded from: classes19.dex */
public class CreateTroopForUIImpl implements ICreateTroopForUI {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CreateTroopForUIImpl";

    public CreateTroopForUIImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.tempapi.ICreateTroopForUI
    public String getTroopUinFromModel(k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) kVar);
        }
        if (kVar instanceof b) {
            return ((b) kVar).d();
        }
        if (kVar instanceof j) {
            return ((j) kVar).X;
        }
        if (kVar instanceof ContactSearchModelNtBuddy) {
            return ((ContactSearchModelNtBuddy) kVar).getGroupCode();
        }
        return "-1";
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.tempapi.ICreateTroopForUI
    public int getUinTypeFromModel(k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) kVar)).intValue();
        }
        String uin = kVar.getUin();
        if (kVar instanceof b) {
            return 2;
        }
        if (kVar instanceof j) {
            return 1;
        }
        if (!(kVar instanceof c)) {
            if (kVar instanceof m) {
                if (uin.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                    return 4;
                }
            } else {
                if (kVar instanceof ContactSearchModelNtBuddy) {
                    return kVar.M();
                }
                return -1;
            }
        }
        return 0;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
