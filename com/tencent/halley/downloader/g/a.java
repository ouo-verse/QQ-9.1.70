package com.tencent.halley.downloader.g;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    public static com.tencent.halley.downloader.d.a a(InetAddress[] inetAddressArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (InetAddress inetAddress : inetAddressArr) {
            boolean z16 = inetAddress instanceof Inet6Address;
            String hostAddress = inetAddress.getHostAddress();
            if (z16) {
                arrayList2.add(hostAddress);
            } else {
                arrayList.add(hostAddress);
            }
        }
        return new com.tencent.halley.downloader.d.a(arrayList, arrayList2, Collections.emptyList());
    }
}
