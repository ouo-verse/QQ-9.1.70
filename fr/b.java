package fr;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {
    public static AppInterface a() {
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                return (QQAppInterface) runtime;
            }
            AppRuntime appRuntime = BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
            if (appRuntime instanceof PeakAppInterface) {
                return (PeakAppInterface) appRuntime;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("CaptureContext", 1, "getAppRuntime fail, ", e16);
            return null;
        }
    }
}
