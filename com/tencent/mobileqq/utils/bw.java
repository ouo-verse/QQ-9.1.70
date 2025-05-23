package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.remote.SimpleAccount;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bw {
    public static final String a() {
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            return firstSimpleAccount.getUin();
        }
        return "";
    }
}
