package com.tencent.component.network.utils.http;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SystemDefaultDnsResolver implements DnsResolver {
    @Override // com.tencent.component.network.utils.http.DnsResolver
    public InetAddress[] resolve(String str) throws UnknownHostException {
        return InetAddress.getAllByName(str);
    }
}
