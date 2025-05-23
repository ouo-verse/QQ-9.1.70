package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.cp;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface dl extends cp.a {
    @NetRequest(constQuery = "p_ver=1", method = NetMethod.GET, path = "map/traffic/event", queryKeys = {"param"})
    NetResponse mapTrafficEvent(String str);
}
