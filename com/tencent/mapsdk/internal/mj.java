package com.tencent.mapsdk.internal;

import android.net.Uri;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.processor.RequestProcessor;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.tencentmap.mapsdk.maps.model.LocationRegion;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class mj implements RequestProcessor {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, Map<String, String>> f149309a;

    public mj(HashMap<String, Map<String, String>> hashMap) {
        this.f149309a = hashMap;
    }

    @Override // com.tencent.map.tools.net.processor.RequestProcessor
    public final void onRequest(NetRequest netRequest) throws Exception {
        Map<String, String> map;
        LocationRegion.RegionName regionName = netRequest.mRegionName;
        LogUtil.c(ky.A, "RegionHostProcessor Region:" + regionName + " HostList:" + this.f149309a);
        HashMap<String, Map<String, String>> hashMap = this.f149309a;
        if (hashMap != null && !hashMap.isEmpty() && regionName != LocationRegion.RegionName.EARTH && (map = this.f149309a.get(regionName.name())) != null) {
            Uri parse = Uri.parse(netRequest.url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().equals(parse.getHost())) {
                    String uri = parse.buildUpon().encodedAuthority(entry.getValue()).build().toString();
                    LogUtil.c(ky.A, "RegionHostProcessor change host from Url " + netRequest.url + " to " + uri);
                    netRequest.setUrl(uri);
                }
            }
        }
    }
}
