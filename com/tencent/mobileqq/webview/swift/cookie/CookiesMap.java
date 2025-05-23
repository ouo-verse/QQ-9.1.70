package com.tencent.mobileqq.webview.swift.cookie;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Hashtable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CookiesMap extends Hashtable<String, ArrayList<String>> {
    static IPatchRedirector $redirector_;

    public CookiesMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public synchronized void addCookie(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        } else {
            getCookies(str).add(str2);
        }
    }

    public synchronized ArrayList<String> getCookies(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        ArrayList<String> arrayList = get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            put(str, arrayList);
        }
        return arrayList;
    }
}
