package com.tencent.mapsdk.internal;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.internal.cp;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ch extends dp<a> {

    /* renamed from: f, reason: collision with root package name */
    private a f148045f;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a extends cp.a {
        @NetRequest(constQuery = "channel=1&output=json&uuid=unknown", method = NetMethod.GET, path = "sdk_event/get_logo", queryKeys = {DownloaderConstant.KEY_RANGE, "map_level"})
        NetResponse fetchData(String str, String str2);
    }

    public ch() {
        ((dp) this).f148138d = "sdkgw.map.qq.com";
    }

    public static a b() {
        ch chVar = (ch) cr.a(ch.class);
        a aVar = chVar.f148045f;
        if (aVar != null && chVar.f148117a) {
            return aVar;
        }
        return (a) chVar.i();
    }

    @Override // com.tencent.mapsdk.internal.cp
    public final String a() {
        return TencentMapServiceProtocol.SERVICE_NAME_PROMOTE_IMAGE_DATA;
    }

    private static void a(a aVar) {
        ((ch) cr.a(ch.class)).f148045f = aVar;
    }
}
