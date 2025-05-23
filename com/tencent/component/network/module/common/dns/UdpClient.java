package com.tencent.component.network.module.common.dns;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.security.SecureRandom;

/* compiled from: P */
/* loaded from: classes5.dex */
final class UdpClient {
    private static final int EPHEMERAL_RANGE = 64511;
    private static final int EPHEMERAL_START = 1024;
    private static final int EPHEMERAL_STOP = 65535;
    private static final int MAX_SIZE = 512;
    private static SecureRandom prng = new SecureRandom();
    private long timeout_value = 5000;

    private static void blockUntil(SelectionKey selectionKey, long j3) throws IOException, SocketTimeoutException {
        int i3;
        long currentTimeMillis = j3 - System.currentTimeMillis();
        if (currentTimeMillis > 0) {
            i3 = selectionKey.selector().select(currentTimeMillis);
        } else if (currentTimeMillis == 0) {
            i3 = selectionKey.selector().selectNow();
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
        } else {
            throw new SocketTimeoutException();
        }
    }

    public byte[] sendrecv(String str, byte[] bArr) throws IOException, SocketTimeoutException {
        SelectionKey register;
        SelectionKey selectionKey = null;
        try {
            DatagramChannel open = DatagramChannel.open();
            open.configureBlocking(false);
            register = open.register(Selector.open(), 1);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            DatagramChannel datagramChannel = (DatagramChannel) register.channel();
            datagramChannel.socket().bind(new InetSocketAddress(prng.nextInt(EPHEMERAL_RANGE) + 1024));
            datagramChannel.connect(new InetSocketAddress(InetAddress.getByName(str), 53));
            datagramChannel.write(ByteBuffer.wrap(bArr));
            byte[] bArr2 = new byte[512];
            long currentTimeMillis = System.currentTimeMillis() + this.timeout_value;
            while (!register.isReadable()) {
                try {
                    blockUntil(register, currentTimeMillis);
                } finally {
                    if (register.isValid()) {
                        register.interestOps(0);
                    }
                }
            }
            long read = datagramChannel.read(ByteBuffer.wrap(bArr2));
            if (read > 0) {
                int i3 = (int) read;
                byte[] bArr3 = new byte[i3];
                System.arraycopy(bArr2, 0, bArr3, 0, i3);
                register.selector().close();
                register.channel().close();
                return bArr3;
            }
            register.selector().close();
            register.channel().close();
            return null;
        } catch (Throwable th6) {
            th = th6;
            selectionKey = register;
            if (selectionKey != null) {
                selectionKey.selector().close();
                selectionKey.channel().close();
            }
            throw th;
        }
    }

    public void setTimeout(long j3) {
        if (j3 > 0) {
            this.timeout_value = j3;
        }
    }
}
