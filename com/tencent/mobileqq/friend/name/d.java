package com.tencent.mobileqq.friend.name;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d implements c {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.friend.name.c
    public String a(String str, com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) dVar);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (dVar != null && !TextUtils.isEmpty(dVar.p())) {
            return dVar.p();
        }
        return null;
    }
}
