package org.apache.httpcore.impl.bootstrap;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface SSLServerSetupHandler {
    void initialize(SSLServerSocket sSLServerSocket) throws SSLException;
}
