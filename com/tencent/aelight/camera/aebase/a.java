package com.tencent.aelight.camera.aebase;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {
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
            QLog.e("AECaptureContext", 1, "getAppRuntime fail, ", e16);
            return null;
        }
    }
}
