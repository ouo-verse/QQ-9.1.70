package org.apache.httpcore.config;

import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class SocketConfig implements Cloneable {
    public static final SocketConfig DEFAULT = new Builder().build();
    private final int backlogSize;
    private final int rcvBufSize;
    private final int sndBufSize;
    private final boolean soKeepAlive;
    private final int soLinger;
    private final boolean soReuseAddress;
    private final int soTimeout;
    private final boolean tcpNoDelay;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Builder {
        private int backlogSize;
        private int rcvBufSize;
        private int sndBufSize;
        private boolean soKeepAlive;
        private boolean soReuseAddress;
        private int soTimeout;
        private int soLinger = -1;
        private boolean tcpNoDelay = true;

        Builder() {
        }

        public SocketConfig build() {
            return new SocketConfig(this.soTimeout, this.soReuseAddress, this.soLinger, this.soKeepAlive, this.tcpNoDelay, this.sndBufSize, this.rcvBufSize, this.backlogSize);
        }

        public Builder setBacklogSize(int i3) {
            this.backlogSize = i3;
            return this;
        }

        public Builder setRcvBufSize(int i3) {
            this.rcvBufSize = i3;
            return this;
        }

        public Builder setSndBufSize(int i3) {
            this.sndBufSize = i3;
            return this;
        }

        public Builder setSoKeepAlive(boolean z16) {
            this.soKeepAlive = z16;
            return this;
        }

        public Builder setSoLinger(int i3) {
            this.soLinger = i3;
            return this;
        }

        public Builder setSoReuseAddress(boolean z16) {
            this.soReuseAddress = z16;
            return this;
        }

        public Builder setSoTimeout(int i3) {
            this.soTimeout = i3;
            return this;
        }

        public Builder setTcpNoDelay(boolean z16) {
            this.tcpNoDelay = z16;
            return this;
        }
    }

    SocketConfig(int i3, boolean z16, int i16, boolean z17, boolean z18, int i17, int i18, int i19) {
        this.soTimeout = i3;
        this.soReuseAddress = z16;
        this.soLinger = i16;
        this.soKeepAlive = z17;
        this.tcpNoDelay = z18;
        this.sndBufSize = i17;
        this.rcvBufSize = i18;
        this.backlogSize = i19;
    }

    public static Builder copy(SocketConfig socketConfig) {
        Args.notNull(socketConfig, "Socket config");
        return new Builder().setSoTimeout(socketConfig.getSoTimeout()).setSoReuseAddress(socketConfig.isSoReuseAddress()).setSoLinger(socketConfig.getSoLinger()).setSoKeepAlive(socketConfig.isSoKeepAlive()).setTcpNoDelay(socketConfig.isTcpNoDelay()).setSndBufSize(socketConfig.getSndBufSize()).setRcvBufSize(socketConfig.getRcvBufSize()).setBacklogSize(socketConfig.getBacklogSize());
    }

    public static Builder custom() {
        return new Builder();
    }

    public int getBacklogSize() {
        return this.backlogSize;
    }

    public int getRcvBufSize() {
        return this.rcvBufSize;
    }

    public int getSndBufSize() {
        return this.sndBufSize;
    }

    public int getSoLinger() {
        return this.soLinger;
    }

    public int getSoTimeout() {
        return this.soTimeout;
    }

    public boolean isSoKeepAlive() {
        return this.soKeepAlive;
    }

    public boolean isSoReuseAddress() {
        return this.soReuseAddress;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    public String toString() {
        return "[soTimeout=" + this.soTimeout + ", soReuseAddress=" + this.soReuseAddress + ", soLinger=" + this.soLinger + ", soKeepAlive=" + this.soKeepAlive + ", tcpNoDelay=" + this.tcpNoDelay + ", sndBufSize=" + this.sndBufSize + ", rcvBufSize=" + this.rcvBufSize + ", backlogSize=" + this.backlogSize + "]";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SocketConfig clone() throws CloneNotSupportedException {
        return (SocketConfig) super.clone();
    }
}
