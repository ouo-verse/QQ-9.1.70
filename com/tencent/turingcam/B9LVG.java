package com.tencent.turingcam;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes27.dex */
public class B9LVG {
    public static long a(byte[] bArr) {
        int i3;
        long j3;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        int length = bArr.length;
        long j16 = (length * (-4132994306676758123L)) ^ 0;
        int i16 = 0;
        int i17 = 0;
        while (i17 < (length >> 3)) {
            int i18 = i16 + (i17 << 3);
            long j17 = ((wrap.get(i18 + 0) & 255) + ((wrap.get(i18 + 1) & 255) << 8) + ((wrap.get(i18 + 2) & 255) << 16) + ((wrap.get(i18 + 3) & 255) << 24) + ((wrap.get(i18 + 4) & 255) << 32) + ((wrap.get(i18 + 5) & 255) << 40) + ((wrap.get(i18 + 6) & 255) << 48) + ((wrap.get(i18 + 7) & 255) << 56)) * (-4132994306676758123L);
            j16 = (j16 ^ ((j17 ^ (j17 >>> 47)) * (-4132994306676758123L))) * (-4132994306676758123L);
            i17++;
            i16 = 0;
        }
        switch (length & 7) {
            case 1:
                i3 = 0;
                long j18 = wrap.get((i3 + length) - r4) ^ j16;
                j3 = -4132994306676758123L;
                j16 = j18 * (-4132994306676758123L);
                break;
            case 2:
                i3 = 0;
                j16 ^= wrap.get(((i3 + length) - r4) + 1) << 8;
                long j182 = wrap.get((i3 + length) - r4) ^ j16;
                j3 = -4132994306676758123L;
                j16 = j182 * (-4132994306676758123L);
                break;
            case 3:
                i3 = 0;
                j16 ^= wrap.get(((i3 + length) - r4) + 2) << 16;
                j16 ^= wrap.get(((i3 + length) - r4) + 1) << 8;
                long j1822 = wrap.get((i3 + length) - r4) ^ j16;
                j3 = -4132994306676758123L;
                j16 = j1822 * (-4132994306676758123L);
                break;
            case 4:
                i3 = 0;
                j16 ^= wrap.get(((i3 + length) - r4) + 3) << 24;
                j16 ^= wrap.get(((i3 + length) - r4) + 2) << 16;
                j16 ^= wrap.get(((i3 + length) - r4) + 1) << 8;
                long j18222 = wrap.get((i3 + length) - r4) ^ j16;
                j3 = -4132994306676758123L;
                j16 = j18222 * (-4132994306676758123L);
                break;
            case 5:
                i3 = 0;
                j16 ^= wrap.get(((i3 + length) - r4) + 4) << 32;
                j16 ^= wrap.get(((i3 + length) - r4) + 3) << 24;
                j16 ^= wrap.get(((i3 + length) - r4) + 2) << 16;
                j16 ^= wrap.get(((i3 + length) - r4) + 1) << 8;
                long j182222 = wrap.get((i3 + length) - r4) ^ j16;
                j3 = -4132994306676758123L;
                j16 = j182222 * (-4132994306676758123L);
                break;
            case 7:
                j16 ^= wrap.get(((length + 0) - r4) + 6) << 48;
            case 6:
                i3 = 0;
                j16 ^= wrap.get(((0 + length) - r4) + 5) << 40;
                j16 ^= wrap.get(((i3 + length) - r4) + 4) << 32;
                j16 ^= wrap.get(((i3 + length) - r4) + 3) << 24;
                j16 ^= wrap.get(((i3 + length) - r4) + 2) << 16;
                j16 ^= wrap.get(((i3 + length) - r4) + 1) << 8;
                long j1822222 = wrap.get((i3 + length) - r4) ^ j16;
                j3 = -4132994306676758123L;
                j16 = j1822222 * (-4132994306676758123L);
                break;
            default:
                j3 = -4132994306676758123L;
                break;
        }
        long j19 = ((j16 >>> 47) ^ j16) * j3;
        return j19 ^ (j19 >>> 47);
    }
}
