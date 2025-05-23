package com.tencent.mobileqq.richstatus;

import PersonalState.HotRishState;
import PersonalState.RespGetSameStateList;
import PersonalState.UserProfile;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.StatusServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes18.dex */
public class m implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void a(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void b(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void c(boolean z16, List<byte[]> list, List<Integer> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), list, list2);
        }
    }

    protected void d(boolean z16, int i3, int i16, boolean z17, ArrayList<RichStatus> arrayList, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z17), arrayList, Boolean.valueOf(z18));
        }
    }

    protected void e(boolean z16, ArrayList<HotRishState> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), arrayList);
        }
    }

    protected void f(boolean z16, boolean z17, int i3, byte[] bArr, ArrayList<UserProfile> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), bArr, arrayList);
        }
    }

    protected void g(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void h(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        switch (i3) {
            case 1:
                if (z16) {
                    z17 = bundle.getBoolean("k_sync_ss", false);
                }
                g(z16, z17);
                return;
            case 2:
                if (z16) {
                    z17 = bundle.getBoolean("k_sync_ss", false);
                }
                h(z16, z17);
                return;
            case 3:
                boolean z18 = bundle.getBoolean("k_is_first");
                int i16 = bundle.getInt("k_fetch_sex");
                if (z16) {
                    RespGetSameStateList respGetSameStateList = (RespGetSameStateList) bundle.getSerializable("k_resp_mate");
                    f(z16, z18, i16, respGetSameStateList.vCookie, respGetSameStateList.vUserInfos);
                    return;
                } else {
                    f(false, z18, i16, null, null);
                    return;
                }
            case 4:
                StatusServlet.RspGetHistory rspGetHistory = (StatusServlet.RspGetHistory) bundle.getSerializable("k_data");
                d(z16, rspGetHistory.startTime, rspGetHistory.endTime, rspGetHistory.over, rspGetHistory.richStatus, rspGetHistory.isAddFromCard);
                return;
            case 5:
                ArrayList<String> stringArrayList = bundle.getStringArrayList("k_status_key");
                ArrayList arrayList = new ArrayList();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getBytes());
                    }
                }
                c(z16, arrayList, bundle.getIntegerArrayList("k_status_err_code_list"));
                return;
            case 6:
                e(z16, (ArrayList) bundle.get("k_resp_hot_status"));
                return;
            case 7:
            case 9:
                a(z16, bundle);
                return;
            case 8:
                b(z16, bundle);
                if (QLog.isColorLevel()) {
                    QLog.d("StatusObserver", 2, "clear self sign ret:" + z16);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
