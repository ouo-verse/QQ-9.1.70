package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HostNameResolver {
    InetAddress resolve(String str) throws IOException;
}
