package com.tencent.mobileqq.phonecontact.processor;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "Business/qq-phonecontact-impl/src/main/resources/Inject_PhoneContactProcessor.yml", version = 1)
    private static ArrayList<Class<? extends a>> f258495a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24700);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends a>> arrayList = new ArrayList<>();
        f258495a = arrayList;
        arrayList.add(c.class);
    }

    public static a a(AppInterface appInterface) {
        a aVar = null;
        try {
            a newInstance = f258495a.get(0).newInstance();
            try {
                newInstance.d(appInterface);
                return newInstance;
            } catch (Exception e16) {
                e = e16;
                aVar = newInstance;
                QLog.d("IMCore.PhoneContact.PhoneContactInjectFactory", 1, "getProcessor", e);
                return aVar;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }
}
