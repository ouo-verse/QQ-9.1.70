package com.tencent.mobileqq.vas.api.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.api.IVasSchemeManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ap implements IVasSchemeManager {
    private BaseQQAppInterface a() {
        AppRuntime peekAppRuntime;
        if (MobileQQ.sProcessId == 1 && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && (peekAppRuntime instanceof BaseQQAppInterface)) {
            return (BaseQQAppInterface) peekAppRuntime;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NonNull
    public String getManagerName() {
        return "QQvipSchemeManagerImpl";
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSchemeManager
    public void launchScheme(Context context, String str) {
        BaseQQAppInterface a16 = a();
        if (a16 == null) {
            QLog.e("VasSchemeManagerImpl", 1, "launchScheme: application is null");
            return;
        }
        ax c16 = bi.c(a16, a16.getApplicationContext(), str);
        if (c16 != null) {
            QLog.e("VasSchemeManagerImpl", 1, "launchScheme: jumpAction is null");
            c16.b();
        }
    }
}
