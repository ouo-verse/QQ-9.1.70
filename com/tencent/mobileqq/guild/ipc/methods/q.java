package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class q extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        QLog.i("QGL.GuildLiveCloseLiveAgreementIPCMethod", 1, "doInvoke.");
        ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).onCloseLiveAgreement();
        return EIPCResult.createSuccessResult(new Bundle());
    }
}
