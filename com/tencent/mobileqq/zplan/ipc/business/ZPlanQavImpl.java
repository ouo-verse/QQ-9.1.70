package com.tencent.mobileqq.zplan.ipc.business;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.zplan.ipc.business.d;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes34.dex */
public class ZPlanQavImpl implements d {
    public static final String TAG = "ZPlanQavImpl";

    @Override // com.tencent.mobileqq.zplan.ipc.business.d
    public void isAvChatting(d.a aVar) {
        if (aVar == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean U = peekAppRuntime instanceof QQAppInterface ? ((QQAppInterface) peekAppRuntime).getAVNotifyCenter().U() : false;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "isAvChatting: " + U);
        }
        aVar.a(U);
    }
}
