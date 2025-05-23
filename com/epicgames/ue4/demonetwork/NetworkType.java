package com.epicgames.ue4.demonetwork;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum NetworkType {
    NETWORK_WIFI("WiFi"),
    NETWORK_4G("4G"),
    NETWORK_3G("3G"),
    NETWORK_2G("2G"),
    NETWORK_UNKNOWN("Unknown"),
    NETWORK_NO("No network");

    private String desc;

    NetworkType(String str) {
        this.desc = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.desc;
    }
}
