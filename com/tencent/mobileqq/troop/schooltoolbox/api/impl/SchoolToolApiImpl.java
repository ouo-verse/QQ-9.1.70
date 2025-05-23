package com.tencent.mobileqq.troop.schooltoolbox.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.schooltoolbox.api.ISchoolToolApi;
import com.tencent.mobileqq.troop.troopcard.utils.b;

/* compiled from: P */
/* loaded from: classes19.dex */
public class SchoolToolApiImpl implements ISchoolToolApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TroopInfoActivityApiImpl";

    public SchoolToolApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.schooltoolbox.api.ISchoolToolApi
    public Class<?> getParserClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.class;
    }
}
