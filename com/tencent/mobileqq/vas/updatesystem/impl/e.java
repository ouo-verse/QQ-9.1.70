package com.tencent.mobileqq.vas.updatesystem.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.vas.updatesystem.handler.VasUpdateHandler;
import com.tencent.mobileqq.vas.updatesystem.service.IVasUpdateHandler;
import com.tencent.mobileqq.vas.utils.VasCommonUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.listener.ICmdListener;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e implements sw4.a {

    /* renamed from: a, reason: collision with root package name */
    private ICmdListener f311220a;

    private IVasUpdateHandler c() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (VasCommonUtils.INSTANCE.isMainProcess() && (peekAppRuntime instanceof BaseQQAppInterface)) {
            return (IVasUpdateHandler) ((BaseQQAppInterface) peekAppRuntime).getBusinessHandler(VasUpdateHandler.f311201h);
        }
        return null;
    }

    @Override // sw4.a
    public boolean a(String str, String str2, ICmdListener iCmdListener) {
        this.f311220a = iCmdListener;
        IVasUpdateHandler c16 = c();
        if (c16 != null) {
            return c16.requestQuickUpdate(str, str2);
        }
        QLog.e("VasUpdate_VasCmdManagerImpl", 1, "sendPbRequest mRequestHandler = null");
        return false;
    }

    public ICmdListener b() {
        return this.f311220a;
    }
}
