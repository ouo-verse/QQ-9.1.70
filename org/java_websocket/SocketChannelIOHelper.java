package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import org.java_websocket.enums.Role;

/* compiled from: P */
/* loaded from: classes38.dex */
public class SocketChannelIOHelper {
    SocketChannelIOHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean read(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, ByteChannel byteChannel) throws IOException {
        byteBuffer.clear();
        int read = byteChannel.read(byteBuffer);
        byteBuffer.flip();
        if (read != -1) {
            return read != 0;
        }
        webSocketImpl.eot();
        return false;
    }

    public static boolean readMore(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, WrappedByteChannel wrappedByteChannel) throws IOException {
        byteBuffer.clear();
        int readMore = wrappedByteChannel.readMore(byteBuffer);
        byteBuffer.flip();
        if (readMore == -1) {
            webSocketImpl.eot();
            return false;
        }
        return wrappedByteChannel.isNeedRead();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean batch(WebSocketImpl webSocketImpl, ByteChannel byteChannel) throws IOException {
        WrappedByteChannel wrappedByteChannel;
        if (webSocketImpl == null) {
            return false;
        }
        ByteBuffer peek = webSocketImpl.outQueue.peek();
        if (peek == null) {
            if (byteChannel instanceof WrappedByteChannel) {
                wrappedByteChannel = (WrappedByteChannel) byteChannel;
                if (wrappedByteChannel.isNeedWrite()) {
                    wrappedByteChannel.writeMore();
                }
                if (webSocketImpl.outQueue.isEmpty() && webSocketImpl.isFlushAndClose() && webSocketImpl.getDraft() != null && webSocketImpl.getDraft().getRole() != null && webSocketImpl.getDraft().getRole() == Role.SERVER) {
                    webSocketImpl.closeConnection();
                }
                return (wrappedByteChannel == null && ((WrappedByteChannel) byteChannel).isNeedWrite()) ? false : true;
            }
            wrappedByteChannel = null;
            if (webSocketImpl.outQueue.isEmpty()) {
                webSocketImpl.closeConnection();
            }
            if (wrappedByteChannel == null) {
            }
        }
        do {
            byteChannel.write(peek);
            if (peek.remaining() > 0) {
                return false;
            }
            webSocketImpl.outQueue.poll();
            peek = webSocketImpl.outQueue.peek();
        } while (peek != null);
        wrappedByteChannel = null;
        if (webSocketImpl.outQueue.isEmpty()) {
        }
        if (wrappedByteChannel == null) {
        }
    }
}
