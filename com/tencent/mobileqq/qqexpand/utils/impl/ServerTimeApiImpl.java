package com.tencent.mobileqq.qqexpand.utils.impl;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqexpand.utils.IServerTimeApi;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ServerTimeApiImpl implements IServerTimeApi {
    @Override // com.tencent.mobileqq.qqexpand.utils.IServerTimeApi
    public long getServerTime() {
        return NetConnInfoCenter.getServerTime();
    }
}
