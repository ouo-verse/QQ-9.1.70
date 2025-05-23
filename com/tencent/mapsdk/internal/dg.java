package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.cp;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface dg extends cp.a {
    @NetRequest(constQuery = "ctrlpf=vector&ctrlmb=and", method = NetMethod.GET, queryKeys = {"apikey", "ver", "ctrlver", "uk", "frontier", "scenetype", "mpt"})
    NetResponse checkAuth(String str, String str2, int i3, String str3, int i16, int i17, int i18);
}
