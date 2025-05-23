package com.tencent.mobileqq.haoliyou;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.qroute.utils.b;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class JefsClassInjectUtil {
    static IPatchRedirector $redirector_;

    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQActivity/Inject_JefsClassConfig.yml", version = 1)
    public static ArrayList<IJefsClassInjectInterface> sInjectInterfaceList;
    private static ArrayList sInjectInterfaceList_AutoGenClazzList_QAutoInjectTransform;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43639);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sInjectInterfaceList_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(JefsClassInjectImpl.class);
        sInjectInterfaceList = new ArrayList<>();
        initInjectVariable();
    }

    public JefsClassInjectUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @QAutoInitMethod
    private static void initInjectVariable() {
        b.c(sInjectInterfaceList_AutoGenClazzList_QAutoInjectTransform, sInjectInterfaceList);
    }
}
