package com.tencent.gamecenter.wadl.sdk.downloader.b;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c implements b {
    @Override // com.tencent.gamecenter.wadl.sdk.downloader.b.b
    public Map<String, com.tencent.gamecenter.wadl.sdk.downloader.b.d.b> a(List<String> list) {
        HashMap hashMap = new HashMap(list.size());
        if (list.isEmpty()) {
            return hashMap;
        }
        try {
            for (String str : list) {
                hashMap.put(str, com.tencent.gamecenter.wadl.sdk.common.e.c.a(InetAddress.getAllByName(str)));
            }
        } catch (UnknownHostException e16) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl_LocalDnsParser", "getDomainIpListMap: " + e16.getLocalizedMessage());
        }
        return hashMap;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.b.b
    public void a(String str, String str2, Map<String, String> map) {
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.b.b
    public void b(String str, String str2, Map<String, String> map) {
    }
}
