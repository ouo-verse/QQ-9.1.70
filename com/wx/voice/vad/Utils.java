package com.wx.voice.vad;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Utils {
    public static int finPosinArraylist(ArrayList<Byte> arrayList, ArrayList<Byte> arrayList2) {
        int i3 = -1;
        for (int i16 = 0; i16 <= arrayList.size() - arrayList2.size(); i16++) {
            if (arrayList.get(i16) == arrayList2.get(0)) {
                for (int i17 = 0; i17 < arrayList2.size() && arrayList.get(i16 + i17) == arrayList2.get(i17); i17++) {
                    if (i17 == arrayList2.size() - 1) {
                        i3 = i16;
                    }
                }
            }
            if (i3 != -1) {
                break;
            }
        }
        return i3;
    }

    public static byte[] toByteArray(short[] sArr) {
        int length = sArr.length;
        byte[] bArr = new byte[length << 1];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            short s16 = sArr[i3];
            bArr[i16 + 1] = (byte) (s16 >> 8);
            bArr[i16] = (byte) (s16 & 255);
        }
        return bArr;
    }

    public static short[] toShortArray(byte[] bArr) {
        int length = bArr.length >> 1;
        short[] sArr = new short[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            sArr[i3] = (short) ((bArr[i16] & 255) | (bArr[i16 + 1] << 8));
        }
        return sArr;
    }
}
