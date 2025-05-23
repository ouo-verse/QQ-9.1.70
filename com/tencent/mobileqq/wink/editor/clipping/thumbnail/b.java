package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static int f319224a;

    private static int a(byte[] bArr) {
        int i3;
        int i16 = 0;
        while (true) {
            i3 = f319224a;
            if (i3 >= bArr.length * 8 || (bArr[i3 / 8] & (128 >> (i3 % 8))) != 0) {
                break;
            }
            i16++;
            f319224a = i3 + 1;
        }
        f319224a = i3 + 1;
        int i17 = 0;
        for (int i18 = 0; i18 < i16; i18++) {
            i17 <<= 1;
            int i19 = f319224a;
            if ((bArr[i19 / 8] & (128 >> (i19 % 8))) != 0) {
                i17++;
            }
            f319224a = i19 + 1;
        }
        return ((1 << i16) + i17) - 1;
    }

    private static int b(int i3, byte[] bArr) {
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            i16 <<= 1;
            int i18 = f319224a;
            if ((bArr[i18 / 8] & (128 >> (i18 % 8))) != 0) {
                i16++;
            }
            f319224a = i18 + 1;
        }
        return i16;
    }

    public static Map<String, Integer> c(byte[] bArr) {
        HashMap hashMap = new HashMap();
        f319224a = 32;
        hashMap.put("forbiddenZeroBit", Integer.valueOf(b(1, bArr)));
        hashMap.put("nalRefIdc", Integer.valueOf(b(2, bArr)));
        int b16 = b(5, bArr);
        hashMap.put("nalUnitType", Integer.valueOf(b16));
        if (b16 == 7) {
            int b17 = b(8, bArr);
            hashMap.put("profileIdc", Integer.valueOf(b17));
            b(1, bArr);
            b(1, bArr);
            b(1, bArr);
            b(1, bArr);
            b(4, bArr);
            hashMap.put("levelIdc", Integer.valueOf(b(8, bArr)));
            hashMap.put("seqParameterSetId", Integer.valueOf(a(bArr)));
            if (b17 == 100 || b17 == 110 || b17 == 122 || b17 == 144) {
                hashMap.put("chromaFormatIdc", Integer.valueOf(a(bArr)));
                hashMap.put("bitDepthLumaMinus8", Integer.valueOf(a(bArr)));
                hashMap.put("bitDepthChromaMinus8", Integer.valueOf(a(bArr)));
                hashMap.put("qpprimeYZeroTransformBypassFlag", Integer.valueOf(b(1, bArr)));
                hashMap.put("seqScalingMatrixPresentFlag", Integer.valueOf(b(1, bArr)));
            }
            hashMap.put("log2MaxFrameNumMinus4", Integer.valueOf(a(bArr)));
            hashMap.put("picOrderCntType", Integer.valueOf(a(bArr)));
            hashMap.put("log2MaxPicOrderCntLsbMinus4", Integer.valueOf(a(bArr)));
            hashMap.put("numRefFrames", Integer.valueOf(a(bArr)));
            hashMap.put("gapsInFrameNumValueAllowedFlag", Integer.valueOf(b(1, bArr)));
            int a16 = a(bArr);
            int a17 = (a(bArr) + 1) * 16;
            hashMap.put("width", Integer.valueOf((a16 + 1) * 16));
            hashMap.put("height", Integer.valueOf(a17));
        }
        return hashMap;
    }
}
