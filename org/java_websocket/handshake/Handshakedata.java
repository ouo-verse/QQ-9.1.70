package org.java_websocket.handshake;

import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface Handshakedata {
    byte[] getContent();

    String getFieldValue(String str);

    boolean hasFieldValue(String str);

    Iterator<String> iterateHttpFields();
}
