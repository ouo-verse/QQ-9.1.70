package com.tencent.av.zplan.avatar.resmgr;

import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e extends com.tencent.av.business.servlet.a {
    @Override // com.tencent.av.business.servlet.a
    protected void a(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        ((RequestCDNServerUseStateHandler) ((AppInterface) getAppRuntime()).getBusinessHandler(RequestCDNServerUseStateHandler.class.getName())).D2().b(toServiceMsg, fromServiceMsg);
    }
}
