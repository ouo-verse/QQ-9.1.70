package com.tencent.mapsdk.internal;

import com.tencent.ads.data.AdParam;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetHead;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.cp;
import com.tencent.qqnt.ntstartup.nativeinterface.StartupSessionConstant;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface dk extends cp.a {
    @NetRequest(constQuery = "appid=sdk&logid=launch_stat&channel=1&output=json&uuid=unknown", method = NetMethod.GET, path = "pingd", queryKeys = {"sessionid", "hm", "suid", "duid", "os", "psv", "ver", AdParam.PF, StartupSessionConstant.KNTMODULENAME}, userAgent = NetUtil.MAP_USER_AGENT)
    NetResponse launchStat(String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8);

    @NetRequest(method = NetMethod.GET, path = "pingd", queryKeys = {"local"}, userAgent = NetUtil.MAP_USER_AGENT)
    NetResponse local(int i3);

    @NetRequest(constQuery = "channel=1&output=json&uuid=unknown", head = @NetHead(keys = {"Content-Type"}, values = {"application/json"}), method = NetMethod.POST, path = "ditusdk/monitor", queryKeys = {"key", "key2", "pid", "pid2", "hm", "suid", "os", "psv", "ver", AdParam.PF, StartupSessionConstant.KNTMODULENAME}, userAgent = NetUtil.MAP_USER_AGENT)
    NetResponse report(String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8, String str9, String str10, byte[] bArr);
}
