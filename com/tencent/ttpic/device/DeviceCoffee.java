package com.tencent.ttpic.device;

import com.tencent.ttpic.baseutils.log.LogUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DeviceCoffee {
    public static byte[] drink(byte[] bArr, String str, String str2) {
        LogUtils.v("Coffee", "drink() deviceName = " + str + ", sign = " + str2);
        return nDrink(bArr, bArr.length, str, str2);
    }

    public static byte[] drinkRawData(byte[] bArr, String str) {
        return nDrinkRawData(bArr, bArr.length, str);
    }

    private static native byte[] nDrink(byte[] bArr, int i3, String str, String str2);

    private static native byte[] nDrinkRawData(byte[] bArr, int i3, String str);
}
