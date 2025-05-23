package org.tencwebrtc;

import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DataChannel {
    private long nativeDataChannel;
    private long nativeObserver;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Buffer {
        public final boolean binary;
        public final ByteBuffer data;

        @CalledByNative("Buffer")
        public Buffer(ByteBuffer byteBuffer, boolean z16) {
            this.data = byteBuffer;
            this.binary = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Init {
        public boolean negotiated;
        public boolean ordered = true;
        public int maxRetransmitTimeMs = -1;
        public int maxRetransmits = -1;

        /* renamed from: protocol, reason: collision with root package name */
        public String f423842protocol = "";

        /* renamed from: id, reason: collision with root package name */
        public int f423841id = -1;

        @CalledByNative(QZoneCoverStoreJsPlugin.INIT_PLUGIN)
        int getId() {
            return this.f423841id;
        }

        @CalledByNative(QZoneCoverStoreJsPlugin.INIT_PLUGIN)
        int getMaxRetransmitTimeMs() {
            return this.maxRetransmitTimeMs;
        }

        @CalledByNative(QZoneCoverStoreJsPlugin.INIT_PLUGIN)
        int getMaxRetransmits() {
            return this.maxRetransmits;
        }

        @CalledByNative(QZoneCoverStoreJsPlugin.INIT_PLUGIN)
        boolean getNegotiated() {
            return this.negotiated;
        }

        @CalledByNative(QZoneCoverStoreJsPlugin.INIT_PLUGIN)
        boolean getOrdered() {
            return this.ordered;
        }

        @CalledByNative(QZoneCoverStoreJsPlugin.INIT_PLUGIN)
        String getProtocol() {
            return this.f423842protocol;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface Observer {
        @CalledByNative("Observer")
        void onBufferedAmountChange(long j3);

        @CalledByNative("Observer")
        void onMessage(Buffer buffer);

        @CalledByNative("Observer")
        void onStateChange();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum State {
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED;

        @CalledByNative("State")
        static State fromNativeIndex(int i3) {
            return values()[i3];
        }
    }

    @CalledByNative
    public DataChannel(long j3) {
        this.nativeDataChannel = j3;
    }

    private void checkDataChannelExists() {
        if (this.nativeDataChannel != 0) {
        } else {
            throw new IllegalStateException("DataChannel has been disposed.");
        }
    }

    private native long nativeBufferedAmount();

    private native void nativeClose();

    private native int nativeId();

    private native String nativeLabel();

    private native long nativeRegisterObserver(Observer observer);

    private native boolean nativeSend(byte[] bArr, boolean z16);

    private native State nativeState();

    private native void nativeUnregisterObserver(long j3);

    public long bufferedAmount() {
        checkDataChannelExists();
        return nativeBufferedAmount();
    }

    public void close() {
        checkDataChannelExists();
        nativeClose();
    }

    public void dispose() {
        checkDataChannelExists();
        JniCommon.nativeReleaseRef(this.nativeDataChannel);
        this.nativeDataChannel = 0L;
    }

    @CalledByNative
    long getNativeDataChannel() {
        return this.nativeDataChannel;
    }

    public int id() {
        checkDataChannelExists();
        return nativeId();
    }

    public String label() {
        checkDataChannelExists();
        return nativeLabel();
    }

    public void registerObserver(Observer observer) {
        checkDataChannelExists();
        long j3 = this.nativeObserver;
        if (j3 != 0) {
            nativeUnregisterObserver(j3);
        }
        this.nativeObserver = nativeRegisterObserver(observer);
    }

    public boolean send(Buffer buffer) {
        checkDataChannelExists();
        byte[] bArr = new byte[buffer.data.remaining()];
        buffer.data.get(bArr);
        return nativeSend(bArr, buffer.binary);
    }

    public State state() {
        checkDataChannelExists();
        return nativeState();
    }

    public void unregisterObserver() {
        checkDataChannelExists();
        nativeUnregisterObserver(this.nativeObserver);
    }
}
