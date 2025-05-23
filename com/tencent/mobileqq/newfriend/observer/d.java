package com.tencent.mobileqq.newfriend.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.newfriend.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), obj);
        }
    }

    public void b(boolean z16, List<AddFriendBlockedInfo> list, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), list, str);
        }
    }

    public void c(boolean z16, boolean z17, boolean z18, String str, boolean z19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, Boolean.valueOf(z19));
        }
    }

    public void d(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NEW_FRD.NewFriendVerificationObserver", 2, " onUpdate() type =" + i3 + " isSuccess = " + z16);
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (QLog.isColorLevel()) {
                            QLog.d("NEW_FRD.NewFriendVerificationObserver", 2, " default type =" + i3);
                            return;
                        }
                        return;
                    }
                    Object[] objArr = (Object[]) obj;
                    List<AddFriendBlockedInfo> list = (List) objArr[0];
                    String str = (String) objArr[1];
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(" blockedInfos =");
                        if (list != null) {
                            obj2 = Integer.valueOf(list.size());
                        } else {
                            obj2 = " is null";
                        }
                        sb5.append(obj2);
                        QLog.d("NEW_FRD.NewFriendVerificationObserver", 2, sb5.toString());
                    }
                    b(z16, list, str);
                    return;
                }
                Object[] objArr2 = (Object[]) obj;
                boolean booleanValue = ((Boolean) objArr2[0]).booleanValue();
                boolean booleanValue2 = ((Boolean) objArr2[1]).booleanValue();
                String str2 = (String) objArr2[2];
                boolean booleanValue3 = ((Boolean) objArr2[3]).booleanValue();
                if (QLog.isColorLevel()) {
                    QLog.d("NEW_FRD.NewFriendVerificationObserver", 2, " isShowEntrance =" + booleanValue + " isShowRedPoint =" + booleanValue2 + " isShowRedPointAtNewFriendBanner = " + booleanValue3);
                }
                c(z16, booleanValue, booleanValue2, str2, booleanValue3);
                return;
            }
            d(z16, null);
            return;
        }
        a(z16, null);
    }
}
