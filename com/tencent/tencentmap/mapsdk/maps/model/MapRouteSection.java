package com.tencent.tencentmap.mapsdk.maps.model;

import org.apache.commons.lang.CharEncoding;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MapRouteSection {
    public static final int kMaxRoadNameLength = 32;
    public int color;
    public int endNum;
    public String roadName;
    public int startNum;

    public static int byteLength() {
        return 140;
    }

    private byte[] intToBytes(int i3) {
        return new byte[]{(byte) i3, (byte) (i3 >> 8), (byte) (i3 >> 16), (byte) (i3 >> 24)};
    }

    private byte[] stringToBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes(CharEncoding.UTF_16LE);
            } catch (Exception unused) {
            }
        }
        return new byte[0];
    }

    public byte[] toBytes() {
        byte[] bArr = new byte[byteLength()];
        System.arraycopy(intToBytes(this.startNum), 0, bArr, 0, 4);
        System.arraycopy(intToBytes(this.endNum), 0, bArr, 4, 4);
        System.arraycopy(intToBytes(this.color), 0, bArr, 8, 4);
        byte[] stringToBytes = stringToBytes(this.roadName);
        if (stringToBytes.length < 32) {
            System.arraycopy(stringToBytes, 0, bArr, 12, stringToBytes.length);
        } else {
            System.arraycopy(stringToBytes, 0, bArr, 12, 32);
        }
        return bArr;
    }
}
