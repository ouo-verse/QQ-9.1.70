package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NetworkInterface {
    public int index;
    public boolean isLoopback;
    public boolean isPointToPoint;
    public boolean isUp;
    public boolean isVirtual;
    public int prefixLength;
    public boolean supportsMulticast;
    public String name = "";
    public String friendlyName = "";
    public ConnectionType connectionType = ConnectionType.values()[0];
    public String address = "";

    public String getAddress() {
        return this.address;
    }

    public ConnectionType getConnectionType() {
        return this.connectionType;
    }

    public String getFriendlyName() {
        return this.friendlyName;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean getIsLoopback() {
        return this.isLoopback;
    }

    public boolean getIsPointToPoint() {
        return this.isPointToPoint;
    }

    public boolean getIsUp() {
        return this.isUp;
    }

    public boolean getIsVirtual() {
        return this.isVirtual;
    }

    public String getName() {
        return this.name;
    }

    public int getPrefixLength() {
        return this.prefixLength;
    }

    public boolean getSupportsMulticast() {
        return this.supportsMulticast;
    }

    public String toString() {
        return "NetworkInterface{name=" + this.name + ",friendlyName=" + this.friendlyName + ",index=" + this.index + ",connectionType=" + this.connectionType + ",address=" + this.address + ",prefixLength=" + this.prefixLength + ",isLoopback=" + this.isLoopback + ",isPointToPoint=" + this.isPointToPoint + ",isUp=" + this.isUp + ",isVirtual=" + this.isVirtual + ",supportsMulticast=" + this.supportsMulticast + ",}";
    }
}
