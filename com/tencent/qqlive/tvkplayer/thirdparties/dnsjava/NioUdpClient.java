package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import androidx.annotation.RequiresApi;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.NioClient;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.NioUdpClient;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

/* compiled from: P */
@RequiresApi(api = 26)
/* loaded from: classes23.dex */
final class NioUdpClient extends NioClient {
    private static final int EPHEMERAL_RANGE;
    private static final int EPHEMERAL_START;
    private static final SecureRandom prng;
    private static final Queue<Transaction> registrationQueue = new ConcurrentLinkedQueue();
    private static final Queue<Transaction> pendingTransactions = new ConcurrentLinkedQueue();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Transaction implements NioClient.KeyProcessor {
        private final DatagramChannel channel;
        private final byte[] data;
        private final long endTime;

        /* renamed from: f, reason: collision with root package name */
        private final CompletableFuture<byte[]> f345849f;

        /* renamed from: id, reason: collision with root package name */
        private final int f345850id;
        private final int max;

        public Transaction(int i3, byte[] bArr, int i16, long j3, DatagramChannel datagramChannel, CompletableFuture<byte[]> completableFuture) {
            this.f345850id = i3;
            this.data = bArr;
            this.max = i16;
            this.endTime = j3;
            this.channel = datagramChannel;
            this.f345849f = completableFuture;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void access$100(Transaction transaction, Exception exc) {
            transaction.completeExceptionally(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void completeExceptionally(Exception exc) {
            silentCloseChannel();
            this.f345849f.completeExceptionally(exc);
        }

        private void silentCloseChannel() {
            try {
                this.channel.disconnect();
            } catch (IOException unused) {
            } catch (Throwable th5) {
                try {
                    this.channel.close();
                } catch (IOException unused2) {
                }
                throw th5;
            }
            try {
                this.channel.close();
            } catch (IOException unused3) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
        @Override // com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.NioClient.KeyProcessor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void processReadyKey(SelectionKey selectionKey) {
            boolean z16;
            if (selectionKey.isValid()) {
                z16 = selectionKey.isReadable();
                if (z16) {
                    completeExceptionally(new EOFException("Key for transaction " + this.f345850id + " is not readable"));
                    NioUdpClient.pendingTransactions.remove(this);
                    return;
                }
                DatagramChannel datagramChannel = (DatagramChannel) selectionKey.channel();
                ByteBuffer allocate = ByteBuffer.allocate(this.max);
                try {
                    int read = datagramChannel.read(allocate);
                    if (read > 0) {
                        allocate.flip();
                        byte[] bArr = new byte[read];
                        System.arraycopy(allocate.array(), 0, bArr, 0, read);
                        silentCloseChannel();
                        this.f345849f.complete(bArr);
                        NioUdpClient.pendingTransactions.remove(this);
                        return;
                    }
                    throw new EOFException();
                } catch (IOException e16) {
                    completeExceptionally(e16);
                    NioUdpClient.pendingTransactions.remove(this);
                    return;
                }
            }
            z16 = false;
            if (z16) {
            }
        }

        void send() throws IOException {
            ByteBuffer wrap = ByteBuffer.wrap(this.data);
            DatagramChannel datagramChannel = this.channel;
            int send = datagramChannel.send(wrap, datagramChannel.socket().getRemoteSocketAddress());
            if (send != 0) {
                if (send >= this.data.length) {
                    return;
                }
                throw new EOFException("Could not send all data for transaction " + this.f345850id);
            }
            throw new EOFException("Insufficient room for the datagram in the underlying output buffer for transaction " + this.f345850id);
        }
    }

    static {
        int i3;
        int i16;
        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            i3 = 32768;
            i16 = 60999;
        } else {
            i3 = 49152;
            i16 = 65535;
        }
        int intValue = Integer.getInteger("dnsjava.udp.ephemeral.start", i3).intValue();
        EPHEMERAL_START = intValue;
        EPHEMERAL_RANGE = Integer.getInteger("dnsjava.udp.ephemeral.end", i16).intValue() - intValue;
        if (Boolean.getBoolean("dnsjava.udp.ephemeral.use_ephemeral_port")) {
            prng = null;
        } else {
            prng = new SecureRandom();
        }
        NioClient.setRegistrationsTask(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.h
            @Override // java.lang.Runnable
            public final void run() {
                NioUdpClient.processPendingRegistrations();
            }
        });
        NioClient.setTimeoutTask(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.i
            @Override // java.lang.Runnable
            public final void run() {
                NioUdpClient.checkTransactionTimeouts();
            }
        });
        NioClient.setCloseTask(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.j
            @Override // java.lang.Runnable
            public final void run() {
                NioUdpClient.closeUdp();
            }
        });
    }

    NioUdpClient() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkTransactionTimeouts() {
        Iterator<Transaction> it = pendingTransactions.iterator();
        while (it.hasNext()) {
            Transaction next = it.next();
            if (next.endTime - System.nanoTime() < 0) {
                next.completeExceptionally(new SocketTimeoutException("Query timed out"));
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeUdp() {
        registrationQueue.clear();
        final EOFException eOFException = new EOFException("Client is closing");
        Queue<Transaction> queue = pendingTransactions;
        queue.forEach(new Consumer() { // from class: com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.g
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                NioUdpClient.Transaction.access$100((NioUdpClient.Transaction) obj, eOFException);
            }
        });
        queue.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processPendingRegistrations() {
        while (true) {
            Queue<Transaction> queue = registrationQueue;
            if (!queue.isEmpty()) {
                Transaction remove = queue.remove();
                try {
                    remove.channel.register(NioClient.selector(), 1, remove);
                    remove.send();
                } catch (IOException e16) {
                    remove.completeExceptionally(e16);
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CompletableFuture<byte[]> sendrecv(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, Message message, byte[] bArr, int i3, Duration duration) {
        long nanos;
        Selector selector;
        DatagramChannel open;
        boolean z16;
        InetSocketAddress inetSocketAddress3;
        SecureRandom secureRandom;
        long nanoTime = System.nanoTime();
        nanos = duration.toNanos();
        long j3 = nanoTime + nanos;
        CompletableFuture<byte[]> completableFuture = new CompletableFuture<>();
        DatagramChannel datagramChannel = null;
        try {
            selector = NioClient.selector();
            open = DatagramChannel.open();
            z16 = false;
        } catch (IOException e16) {
            e = e16;
        }
        try {
            open.configureBlocking(false);
            Transaction transaction = new Transaction(message.getHeader().getID(), bArr, i3, j3, open, completableFuture);
            if (inetSocketAddress == null || inetSocketAddress.getPort() == 0) {
                int i16 = 0;
                while (true) {
                    if (i16 >= 1024) {
                        break;
                    }
                    try {
                        if (inetSocketAddress == null) {
                            SecureRandom secureRandom2 = prng;
                            if (secureRandom2 != null) {
                                inetSocketAddress3 = new InetSocketAddress(secureRandom2.nextInt(EPHEMERAL_RANGE) + EPHEMERAL_START);
                            } else {
                                inetSocketAddress3 = null;
                            }
                        } else {
                            int port = inetSocketAddress.getPort();
                            if (port == 0 && (secureRandom = prng) != null) {
                                port = secureRandom.nextInt(EPHEMERAL_RANGE) + EPHEMERAL_START;
                            }
                            inetSocketAddress3 = new InetSocketAddress(inetSocketAddress.getAddress(), port);
                        }
                        open.bind((SocketAddress) inetSocketAddress3);
                        z16 = true;
                        break;
                    } catch (SocketException unused) {
                        i16++;
                    }
                }
                if (!z16) {
                    transaction.completeExceptionally(new IOException("No available source port found"));
                    return completableFuture;
                }
            }
            open.connect(inetSocketAddress2);
            pendingTransactions.add(transaction);
            registrationQueue.add(transaction);
            selector.wakeup();
        } catch (IOException e17) {
            e = e17;
            datagramChannel = open;
            if (datagramChannel != null) {
                try {
                    datagramChannel.close();
                } catch (IOException unused2) {
                }
            }
            completableFuture.completeExceptionally(e);
            return completableFuture;
        }
        return completableFuture;
    }
}
