package com.tencent.component.network.utils.http;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface DnsResolver {
    InetAddress[] resolve(String str) throws UnknownHostException;
}
