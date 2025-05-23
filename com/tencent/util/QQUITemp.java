package com.tencent.util;

import android.app.Activity;
import com.tencent.mobileqq.inject.s;
import com.tencent.mobileqq.injector.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQUITemp {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQUITemp";

    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQUI/Inject_QQUITemp.yml", version = 1)
    private static s sQQUITemp;
    private static ArrayList sQQUITemp_AutoGenClazzList_QAutoInjectTransform;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53796);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sQQUITemp_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(ad.class);
    }

    public QQUITemp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void ensureInject() {
        if (sQQUITemp == null) {
            initQAutoInject();
        }
    }

    @QAutoInitMethod
    static void initQAutoInject() {
        sQQUITemp = (s) com.tencent.mobileqq.qroute.utils.b.a(sQQUITemp_AutoGenClazzList_QAutoInjectTransform);
    }

    public static void initUrlDrawable() {
        ensureInject();
        s sVar = sQQUITemp;
        if (sVar == null) {
            QLog.w(TAG, 1, "inject failed, call is initUrlDrawable");
        } else {
            sVar.initUrlDrawable();
        }
    }

    public static void requestRecordAudioPermission(Activity activity, String str, String str2) {
        ensureInject();
        s sVar = sQQUITemp;
        if (sVar == null) {
            QLog.w(TAG, 1, "inject failed, call is requestRecordAudioPermission");
        } else {
            sVar.requestRecordAudioPermission(activity, str, str2);
        }
    }
}
