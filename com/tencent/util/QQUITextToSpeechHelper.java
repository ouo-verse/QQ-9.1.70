package com.tencent.util;

import com.tencent.mobileqq.inject.r;
import com.tencent.mobileqq.injector.ac;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQUITextToSpeechHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQUITextToSpeechHelper";

    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQUI/Inject_QQTextToSpeechHelper.yml", version = 1)
    private static r sQQTextToSpeechHelper;
    private static ArrayList sQQTextToSpeechHelper_AutoGenClazzList_QAutoInjectTransform;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53798);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sQQTextToSpeechHelper_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(ac.class);
    }

    public QQUITextToSpeechHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void ensureInject() {
        if (sQQTextToSpeechHelper == null) {
            initQAutoInject();
        }
    }

    @QAutoInitMethod
    static void initQAutoInject() {
        sQQTextToSpeechHelper = (r) com.tencent.mobileqq.qroute.utils.b.a(sQQTextToSpeechHelper_AutoGenClazzList_QAutoInjectTransform);
    }

    public static void speak(String str) {
        ensureInject();
        r rVar = sQQTextToSpeechHelper;
        if (rVar == null) {
            QLog.w(TAG, 1, "inject failed, call is speak");
        } else {
            rVar.speak(str);
        }
    }
}
