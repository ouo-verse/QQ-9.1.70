package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQUIChatTextSize {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQUIChatTextSize";

    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQUI/Inject_ChatTextSize.yml", version = 1)
    private static com.tencent.mobileqq.inject.d sChatTextSize;
    private static ArrayList sChatTextSize_AutoGenClazzList_QAutoInjectTransform;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53778);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sChatTextSize_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.i.class);
    }

    public QQUIChatTextSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void ensureInject() {
        if (sChatTextSize == null) {
            initQAutoInject();
        }
    }

    public static int getChatTextSizeWithDP() {
        ensureInject();
        com.tencent.mobileqq.inject.d dVar = sChatTextSize;
        if (dVar == null) {
            QLog.w(TAG, 1, "inject failed, call is getChatTextSizeWithDP");
            return 0;
        }
        return dVar.getChatTextSizeWithDP();
    }

    @QAutoInitMethod
    static void initQAutoInject() {
        sChatTextSize = (com.tencent.mobileqq.inject.d) com.tencent.mobileqq.qroute.utils.b.a(sChatTextSize_AutoGenClazzList_QAutoInjectTransform);
    }
}
