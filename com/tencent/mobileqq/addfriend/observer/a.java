package com.tencent.mobileqq.addfriend.observer;

import android.os.Bundle;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class a implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
        }
    }

    public void b(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, obj);
        }
    }

    public void c(boolean z16, ArrayList<AddBatchPhoneFriendResult> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), arrayList);
        }
    }

    protected void d(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void e(boolean z16, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3));
        }
    }

    protected void f(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str, str2);
        }
    }

    protected void g(boolean z16, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
        }
    }

    protected void h(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
        }
    }

    protected void i(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void j(boolean z16, HashMap<String, Integer> hashMap, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), hashMap, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        switch (i3) {
            case 1:
                a(obj);
                return;
            case 2:
                b(obj);
                return;
            case 3:
                Bundle bundle = (Bundle) obj;
                String string = bundle.getString("uin");
                int i17 = bundle.getInt(QzoneIPCModule.RESULT_CODE, 1);
                boolean z18 = bundle.getBoolean(com.tencent.mobileqq.friend.observer.a.ADD_DIRECT, false);
                if (i17 == 0) {
                    z17 = true;
                }
                h(z16, z17, z18, string, bundle);
                return;
            case 4:
                Bundle bundle2 = (Bundle) obj;
                f(z16, bundle2.getString("uin"), bundle2.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME));
                return;
            case 5:
                Bundle bundle3 = (Bundle) obj;
                String string2 = bundle3.getString("uin");
                if (z16) {
                    e(true, string2, bundle3.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME), bundle3.getInt("group_id", 0));
                    return;
                } else {
                    e(false, string2, "", 0);
                    return;
                }
            case 6:
                i(z16, (Bundle) obj);
                return;
            case 7:
                Bundle bundle4 = (Bundle) obj;
                g(z16, bundle4.getLong("uin"), bundle4.getInt(FriendListHandler.KEY_SAFETY_FLAG));
                return;
            case 8:
                d(z16, (Bundle) obj);
                return;
            case 9:
                HashMap<String, Integer> hashMap = new HashMap<>();
                if (z16 && (obj instanceof Bundle)) {
                    Bundle bundle5 = (Bundle) obj;
                    ArrayList<String> stringArrayList = bundle5.getStringArrayList("qzone_permission_uins");
                    ArrayList<Integer> integerArrayList = bundle5.getIntegerArrayList("qzone_permission_res");
                    for (int i18 = 0; i18 < stringArrayList.size(); i18++) {
                        hashMap.put(stringArrayList.get(i18), integerArrayList.get(i18));
                    }
                    i16 = bundle5.getInt("qzone_permission_status");
                } else {
                    i16 = -1;
                }
                j(z16, hashMap, i16);
                return;
            case 10:
                c(z16, (ArrayList) obj);
                return;
            default:
                return;
        }
    }
}
