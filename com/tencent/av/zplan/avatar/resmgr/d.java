package com.tencent.av.zplan.avatar.resmgr;

import com.tencent.av.business.servlet.BaseService;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.Servlet;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends BaseService {
    public d(AppInterface appInterface) {
        super(appInterface);
    }

    @Override // com.tencent.av.business.servlet.BaseService
    public Class<? extends Servlet> a() {
        return e.class;
    }

    @Override // com.tencent.av.business.servlet.BaseService
    protected void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ((RequestCDNServerUseStateHandler) this.f73467a.getBusinessHandler(RequestCDNServerUseStateHandler.class.getName())).onReceive(toServiceMsg, fromServiceMsg, obj);
    }
}
