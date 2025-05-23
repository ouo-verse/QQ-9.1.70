package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.mapsdk.core.components.protocol.jce.conf.CSFileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.SCFileUpdateRsp;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetFileResolver;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetJceResolver;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.cp;
import com.tencent.mapsdk.internal.ec;
import com.tencent.mapsdk.internal.ed;
import com.tencent.qqnt.ntstartup.nativeinterface.StartupSessionConstant;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface df extends cp.a {
    @NetJceResolver(inJce = CSFileUpdateReq.class, outJce = SCFileUpdateRsp.class, queryRange = {5, 10})
    @NetRequest(constQuery = "pf=androidsdk&fr=02001", method = NetMethod.POST, path = "fileupdate", queryKeys = {"sdkver", "suid", "appsuid", StartupSessionConstant.KNTMODULENAME, "api_key"})
    ed.a<SCFileUpdateRsp> checkUpdate(String str, String str2, String str3, String str4, String str5, ArrayList<FileUpdateReq> arrayList, String str6, String str7, String str8, String str9, String str10);

    @NetFileResolver(outFile = cc.f148006g, queryRange = {0})
    @NetRequest(authority = "mapapi.qq.com", method = NetMethod.GET, path = "sdk/config/offline_city_detail_v2.json")
    ec.a downloadOfflineMapCityList(String str);
}
