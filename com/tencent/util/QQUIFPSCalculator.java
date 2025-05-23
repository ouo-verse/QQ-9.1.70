package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes27.dex */
public class QQUIFPSCalculator {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQUIFPSCalculator";

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/QQUI/Inject_FPSCalculator.yml", version = 1)
    private static ArrayList<Class<? extends com.tencent.mobileqq.inject.g>> sFPSCalculatorList;
    private com.tencent.mobileqq.inject.g fpsCalculator;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53784);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        ArrayList<Class<? extends com.tencent.mobileqq.inject.g>> arrayList = new ArrayList<>();
        sFPSCalculatorList = arrayList;
        arrayList.add(ry3.a.class);
    }

    public QQUIFPSCalculator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<Class<? extends com.tencent.mobileqq.inject.g>> arrayList = sFPSCalculatorList;
        if (arrayList != null) {
            QLog.d(TAG, 1, "sFPSCalculatorList size : ", Integer.valueOf(arrayList.size()));
            try {
                if (sFPSCalculatorList.size() > 0) {
                    this.fpsCalculator = sFPSCalculatorList.get(0).newInstance();
                    return;
                }
                return;
            } catch (IllegalAccessException | InstantiationException e16) {
                QLog.w(TAG, 1, "FPSCalculator Inject Fail,", e16);
                return;
            }
        }
        QLog.d(TAG, 1, "sFPSCalculatorList size : ", "");
    }

    public void calculateFPS(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.inject.g gVar = this.fpsCalculator;
        if (gVar != null) {
            gVar.b(i3);
        }
    }

    public void framAdd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.inject.g gVar = this.fpsCalculator;
        if (gVar != null) {
            gVar.d();
        }
    }

    public void printLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.inject.g gVar = this.fpsCalculator;
        if (gVar != null) {
            gVar.c();
        }
    }

    public void setActTAG(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        com.tencent.mobileqq.inject.g gVar = this.fpsCalculator;
        if (gVar != null) {
            gVar.a(str);
        }
    }
}
