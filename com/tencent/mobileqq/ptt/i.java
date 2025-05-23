package com.tencent.mobileqq.ptt;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class i {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface) {
        BaseApplicationImpl.sApplication.getSharedPreferences("LsRecord_" + qQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("UserGuide", true).commit();
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "markUserGuideFlag");
        }
    }

    public static void b(QQAppInterface qQAppInterface) {
        long currentTimeMillis = System.currentTimeMillis();
        BaseApplicationImpl.sApplication.getSharedPreferences("LsRecord_" + qQAppInterface.getCurrentAccountUin(), 0).edit().putLong("UserTips", currentTimeMillis);
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "markUserTipsFlag:" + currentTimeMillis);
        }
    }

    public static boolean c(QQAppInterface qQAppInterface) {
        BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
        return !baseApplicationImpl.getSharedPreferences("LsRecord_" + qQAppInterface.getCurrentAccountUin(), 0).getBoolean("UserGuide", false);
    }

    public static boolean d(QQAppInterface qQAppInterface) {
        if (Math.abs(System.currentTimeMillis() - BaseApplicationImpl.sApplication.getSharedPreferences("LsRecord_" + qQAppInterface.getCurrentAccountUin(), 0).getLong("UserTips", 0L)) < 3600000) {
            return false;
        }
        return true;
    }
}
