package com.tencent.mobileqq.kandian.base.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b {
    public static String a() {
        String account;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        AppRuntime runtime = application != null ? application.getRuntime() : null;
        return (runtime == null || (account = runtime.getAccount()) == null) ? "0" : account;
    }

    public static QQAppInterface b() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    public static AppRuntime c() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            return application.getRuntime();
        }
        return null;
    }

    public static long d() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        AppRuntime runtime = application != null ? application.getRuntime() : null;
        if (runtime == null) {
            return 0L;
        }
        return runtime.getLongAccountUin();
    }

    public static QQAppInterface e() {
        AppRuntime c16 = c();
        if (c16 instanceof QQAppInterface) {
            return (QQAppInterface) c16;
        }
        return null;
    }
}
