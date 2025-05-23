package com.tencent.mobileqq.util;

import com.tencent.common.app.BaseApplicationImpl;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g {
    public static String a() {
        return BaseApplicationImpl.getApplication().getQQProcessName();
    }

    public static boolean b() {
        if ("com.tencent.mobileqq".equals(a())) {
            return true;
        }
        return false;
    }
}
