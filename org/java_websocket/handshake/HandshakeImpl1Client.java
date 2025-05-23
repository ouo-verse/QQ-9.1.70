package org.java_websocket.handshake;

/* compiled from: P */
/* loaded from: classes38.dex */
public class HandshakeImpl1Client extends HandshakedataImpl1 implements ClientHandshakeBuilder {
    private String resourceDescriptor = "*";

    @Override // org.java_websocket.handshake.ClientHandshake
    public String getResourceDescriptor() {
        return this.resourceDescriptor;
    }

    @Override // org.java_websocket.handshake.ClientHandshakeBuilder
    public void setResourceDescriptor(String str) {
        if (str != null) {
            this.resourceDescriptor = str;
            return;
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }
}
