package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.cp;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface dc extends cp.a {
    @NetRequest(method = NetMethod.URL, path = "indoor_map")
    String getIndoorMapUrl();
}
