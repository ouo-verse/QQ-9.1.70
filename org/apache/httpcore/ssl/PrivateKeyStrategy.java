package org.apache.httpcore.ssl;

import java.net.Socket;
import java.util.Map;

/* loaded from: classes29.dex */
public interface PrivateKeyStrategy {
    String chooseAlias(Map<String, PrivateKeyDetails> map, Socket socket);
}
