package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface WrappedByteChannel extends ByteChannel {
    boolean isBlocking();

    boolean isNeedRead();

    boolean isNeedWrite();

    int readMore(ByteBuffer byteBuffer) throws IOException;

    void writeMore() throws IOException;
}
