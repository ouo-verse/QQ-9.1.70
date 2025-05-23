package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopNameHelperService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopNameHelperServiceImpl implements ITroopNameHelperService {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TroopNameHelperApiImpl";

    public TroopNameHelperServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopNameHelperService
    public String getNewName(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            stringBuffer.append(arrayList.get(i3));
            stringBuffer.append("\u3001");
            try {
            } catch (Exception e16) {
                QLog.e(TAG, 1, "get length failed!", e16);
            }
            if (stringBuffer.toString().getBytes("utf-8").length > 48) {
                break;
            }
        }
        if (stringBuffer.toString().endsWith("\u3001")) {
            stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        }
        return stringBuffer.toString();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
