package com.tencent.qimei.sdk.S;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DataFormatter implements Serializable {
    static IPatchRedirector $redirector_;
    private HashMap<String, SpreadValue> spreadData;

    public DataFormatter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.spreadData = new HashMap<>();
        }
    }

    public HashMap<String, SpreadValue> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.spreadData : (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    public void a(HashMap<String, SpreadValue> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.spreadData = hashMap;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) hashMap);
        }
    }
}
