package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.cp;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface dh extends cp.a {
    @NetRequest(method = NetMethod.POST, path = "rttserverex/", userAgent = "sosomap navsns")
    NetResponse rttData(byte[] bArr);
}
