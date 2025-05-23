package com.tencent.midas.comm.log.util;

/* loaded from: classes9.dex */
public class APBytesUtil {
    public static byte[] int2bytes(int i3) {
        return new byte[]{(byte) (i3 >> 24), (byte) (i3 >> 16), (byte) (i3 >> 8), (byte) i3};
    }
}
