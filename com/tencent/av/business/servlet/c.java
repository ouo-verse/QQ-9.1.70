package com.tencent.av.business.servlet;

import com.tencent.av.business.handler.EffectMaterialHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends a {
    @Override // com.tencent.av.business.servlet.a
    protected void a(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.i("EffectMaterialServlet", 2, "handleResponse");
        }
        ((EffectMaterialHandler) ((AppInterface) getAppRuntime()).getBusinessHandler(EffectMaterialHandler.class.getName())).D2().b(toServiceMsg, fromServiceMsg);
    }
}
