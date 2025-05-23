package com.tencent.mobileqq.zplan.push;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;

/* compiled from: P */
@ServletImpl(impl = ZPlanOIDBPushIPCImpl.class, process = "com.tencent.mobileqq:zplan")
/* loaded from: classes34.dex */
public interface c {
    void onReceive(int i3, byte[] bArr);
}
