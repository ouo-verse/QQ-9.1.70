package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes13.dex */
public class v extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    public EIPCResult a(AbsIpcMethod.a aVar, String str, Object... objArr) {
        boolean a16 = ca.a();
        Bundle bundle = new Bundle();
        bundle.putBoolean("ret", a16);
        if (QLog.isColorLevel()) {
            QLog.d("IsShowGuildTabMethod", 2, "invoke result: isTabShow: ", Boolean.valueOf(a16));
        }
        return EIPCResult.createSuccessResult(bundle);
    }
}
