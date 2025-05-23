package com.tencent.mobileqq.register.bean;

import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f280370a;

    /* renamed from: b, reason: collision with root package name */
    private String f280371b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, Object> f280372c;

    public b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f280370a = str;
        this.f280371b = str2;
        HashMap<String, Object> hashMap = new HashMap<>();
        this.f280372c = hashMap;
        hashMap.put(MsfConstants.ATTRIBUTE_MAP_FACE_REG_SIG, str.getBytes());
        this.f280372c.put(MsfConstants.ATTRIBUTE_MAP_FACE_RESULT, str2.getBytes());
    }

    public HashMap<String, Object> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f280372c;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f280371b;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f280370a;
    }
}
