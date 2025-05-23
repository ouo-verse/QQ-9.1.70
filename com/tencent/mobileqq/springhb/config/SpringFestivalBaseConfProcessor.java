package com.tencent.mobileqq.springhb.config;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.config.QConfigureException;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.api.ISpringHbUtilApi;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;

/* loaded from: classes18.dex */
public abstract class SpringFestivalBaseConfProcessor<T> extends l<T> {
    static IPatchRedirector $redirector_;

    public SpringFestivalBaseConfProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected abstract T a(ai[] aiVarArr) throws Exception;

    @Override // com.tencent.mobileqq.config.l
    public Class<T> clazz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    public T onParsed(ai[] aiVarArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aiVarArr);
        }
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_SpringFestivalBaseConfProcessor", 2, "[onParsed]" + type());
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        ISpringHbReportApi iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all");
        ISpringHbUtilApi iSpringHbUtilApi = (ISpringHbUtilApi) QRoute.api(ISpringHbUtilApi.class);
        if (aiVarArr != null && aiVarArr.length != 0) {
            try {
                iSpringHbUtilApi.saveConfTaskId(type(), aiVarArr[0].f202267a);
                iSpringHbUtilApi.saveConfContentMd5(type(), MD5.toMD5(aiVarArr[0].f202268b));
                return a(aiVarArr);
            } catch (Exception e16) {
                int confTaskId = iSpringHbUtilApi.getConfTaskId(type());
                if (e16 instanceof JSONException) {
                    iSpringHbReportApi.gameHBConfigReport(2, 5, type(), confTaskId, am.s().g(type(), peekAppRuntime.getCurrentAccountUin()), true, QLog.getStackTraceString(e16.getCause()));
                } else {
                    iSpringHbReportApi.gameHBConfigReport(2, 4, type(), confTaskId, am.s().g(type(), peekAppRuntime.getCurrentAccountUin()), true, QLog.getStackTraceString(e16.getCause()));
                }
                iSpringHbReportApi.reportGameHBConfigCoverage(1, 1, type(), confTaskId, am.s().g(type(), peekAppRuntime.getCurrentAccountUin()), false, iSpringHbUtilApi.getConfContentMd5(type()));
                throw new QConfigureException(e16.getMessage());
            }
        }
        iSpringHbReportApi.gameHBConfigReport(2, 3, type(), iSpringHbUtilApi.getConfTaskId(type()), am.s().g(type(), peekAppRuntime.getCurrentAccountUin()), true, "parse config fail!");
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        boolean z16;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_SpringFestivalBaseConfProcessor", 2, "[onReqNoReceive] failCode=" + i3 + " type: " + type());
        }
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ISpringHbReportApi iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all");
                ISpringHbUtilApi iSpringHbUtilApi = (ISpringHbUtilApi) QRoute.api(ISpringHbUtilApi.class);
                if (i3 == -1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    i16 = 1;
                } else {
                    i16 = 2;
                }
                iSpringHbReportApi.gameHBConfigReport(2, i16, type(), iSpringHbUtilApi.getConfTaskId(type()), am.s().g(type(), peekAppRuntime.getCurrentAccountUin()), true, new String[0]);
                if (i3 != -1) {
                    iSpringHbReportApi.reportGameHBConfigCoverage(1, 1, type(), iSpringHbUtilApi.getConfTaskId(type()), am.s().g(type(), peekAppRuntime.getCurrentAccountUin()), false, iSpringHbUtilApi.getConfContentMd5(type()));
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqNoReceive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.i("SpringHb_SpringFestivalBaseConfProcessor", 2, "[onUpdate] onReqNoReceive = " + type());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public void onUpdate(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) t16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_SpringFestivalBaseConfProcessor", 2, "[onUpdate] " + type());
        }
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            ISpringHbReportApi iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all");
            ISpringHbUtilApi iSpringHbUtilApi = (ISpringHbUtilApi) QRoute.api(ISpringHbUtilApi.class);
            iSpringHbReportApi.reportGameHBConfigCoverage(1, 0, type(), iSpringHbUtilApi.getConfTaskId(type()), am.s().g(type(), peekAppRuntime.getCurrentAccountUin()), false, iSpringHbUtilApi.getConfContentMd5(type()));
        } catch (Throwable th5) {
            QLog.e("SpringHb_SpringFestivalBaseConfProcessor", 1, QLog.getStackTraceString(th5));
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }
}
