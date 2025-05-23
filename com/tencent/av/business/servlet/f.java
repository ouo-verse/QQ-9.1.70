package com.tencent.av.business.servlet;

import com.tencent.av.business.handler.SafetyHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Servlet;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f extends BaseService {
    public f(AppInterface appInterface) {
        super(appInterface);
    }

    @Override // com.tencent.av.business.servlet.BaseService
    public Class<? extends Servlet> a() {
        return g.class;
    }

    @Override // com.tencent.av.business.servlet.BaseService
    protected void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.i("SafetyService", 2, "notifyResult");
        }
        ((SafetyHandler) this.f73467a.getBusinessHandler(SafetyHandler.class.getName())).onReceive(toServiceMsg, fromServiceMsg, obj);
    }
}
