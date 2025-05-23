package com.tencent.mobileqq.guild.top.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildGlobalTopMsgHandler extends BusinessHandler implements a {
    protected GuildGlobalTopMsgHandler(AppInterface appInterface) {
        super(appInterface);
    }

    @Override // com.tencent.mobileqq.guild.top.handler.a
    public void A(boolean z16, Bundle bundle, int i3) {
        notifyUI(i3, z16, bundle);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return u02.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }
}
