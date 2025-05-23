package com.tencent.mobileqq.friend.name;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.friend.inject.c f211692a;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f211692a = com.tencent.mobileqq.friend.inject.a.b();
        }
    }

    @Override // com.tencent.mobileqq.friend.name.c
    public String a(String str, com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) dVar);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        com.tencent.mobileqq.friend.inject.c cVar = this.f211692a;
        if (cVar != null) {
            str2 = cVar.getPhoneContactName(str);
        } else {
            QLog.e("IMCore.friend..PhoneContactName", 1, "mPhoneContactService == null");
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }
}
