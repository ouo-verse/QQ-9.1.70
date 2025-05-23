package org.java_websocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Collection;
import org.java_websocket.drafts.Draft;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.framing.Framedata;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface WebSocket {
    void close();

    void close(int i3);

    void close(int i3, String str);

    void closeConnection(int i3, String str);

    <T> T getAttachment();

    Draft getDraft();

    InetSocketAddress getLocalSocketAddress();

    ReadyState getReadyState();

    InetSocketAddress getRemoteSocketAddress();

    String getResourceDescriptor();

    boolean hasBufferedData();

    boolean isClosed();

    boolean isClosing();

    boolean isFlushAndClose();

    boolean isOpen();

    void send(String str);

    void send(ByteBuffer byteBuffer);

    void send(byte[] bArr);

    void sendFragmentedFrame(Opcode opcode, ByteBuffer byteBuffer, boolean z16);

    void sendFrame(Collection<Framedata> collection);

    void sendFrame(Framedata framedata);

    void sendPing();

    <T> void setAttachment(T t16);
}
