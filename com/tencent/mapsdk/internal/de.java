package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.cp;
import com.tencent.qqnt.ntstartup.nativeinterface.StartupSessionConstant;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface de extends cp.a {
    @NetRequest(constQuery = "pf=androidsdk&fr=02001", method = NetMethod.POST, path = "fileupdate", queryKeys = {"sdkver", "suid", "appsuid", StartupSessionConstant.KNTMODULENAME, "api_key"})
    NetResponse configFileUpdate(String str, String str2, String str3, String str4, String str5, byte[] bArr);
}
