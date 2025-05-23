package com.tencent.ttpic.util;

import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Coffee {
    private static final String TAG = "Coffee";

    public static byte[] drink(byte[] bArr, String str) {
        LogUtils.v(TAG, "drink(), sign = %s", str);
        byte[] nDrink = nDrink(bArr, bArr.length, str);
        if (nDrink == null) {
            return bArr;
        }
        if (nDrink[0] == 120 && nDrink[1] == -100) {
            Inflater inflater = new Inflater();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    inflater.setInput(nDrink, 0, nDrink.length);
                    byte[] bArr2 = new byte[1024];
                    while (!inflater.finished()) {
                        byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                    }
                } catch (DataFormatException e16) {
                    e16.printStackTrace();
                }
                inflater.end();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th5) {
                inflater.end();
                throw th5;
            }
        }
        return nDrink;
    }

    public static InputStream drinkACupOfCoffee(InputStream inputStream, boolean z16) throws IOException, UnsatisfiedLinkError {
        return drinkACupOfCoffee(inputStream, z16, getDefaultSign());
    }

    public static byte[] drink_ios(byte[] bArr, String str) {
        LogUtils.v(TAG, "drink(), sign = %s", str);
        byte[] nDrinkios = nDrinkios(bArr, bArr.length, str);
        if (nDrinkios[0] == 120 && nDrinkios[1] == -100) {
            Inflater inflater = new Inflater();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    inflater.setInput(nDrinkios, 0, nDrinkios.length);
                    byte[] bArr2 = new byte[1024];
                    while (!inflater.finished()) {
                        byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                    }
                } catch (DataFormatException e16) {
                    e16.printStackTrace();
                }
                inflater.end();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th5) {
                inflater.end();
                throw th5;
            }
        }
        return nDrinkios;
    }

    @SoInfo(libName = "pitu_tools")
    public static native String getDefaultSign();

    @SoInfo(libName = "pitu_tools")
    public static native boolean isSign(String str);

    @SoInfo(libName = "pitu_tools")
    public static native byte[] nDecrypt(byte[] bArr, byte[] bArr2);

    @SoInfo(libName = "pitu_tools")
    private static native byte[] nDrink(byte[] bArr, int i3, String str);

    @SoInfo(libName = "pitu_tools")
    private static native byte[] nDrinkios(byte[] bArr, int i3, String str);

    @SoInfo(libName = "pitu_tools")
    public static native byte[] nEncrypt(byte[] bArr, byte[] bArr2);

    public static InputStream drinkACupOfCoffee(InputStream inputStream, boolean z16, String str) throws IOException {
        byte[] drink;
        byte[] byteArray = IOUtils.toByteArray(inputStream);
        if (z16) {
            drink = drink_ios(byteArray, str);
        } else {
            drink = drink(byteArray, str);
        }
        return IOUtils.toInputStream(drink);
    }
}
