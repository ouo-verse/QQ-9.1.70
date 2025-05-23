package com.tencent.weiyun.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class CBundleReader {
    static IPatchRedirector $redirector_;

    public CBundleReader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native void deleteBundle(long j3);

    public static native boolean getBoolean(long j3, String str, boolean z16);

    private static native byte getByte(long j3, String str, byte b16);

    private static native byte[] getByteArray(long j3, String str);

    private static native String getCharArray(long j3, String str);

    public static native double getDouble(long j3, String str, double d16);

    public static String getHexString(long j3, String str) {
        byte[] copyOf;
        byte[] byteArray = getByteArray(j3, str);
        if (byteArray == null) {
            copyOf = new byte[0];
        } else {
            copyOf = Arrays.copyOf(byteArray, byteArray.length);
        }
        return Utils.bytes2HexStr(copyOf);
    }

    public static native int getInt(long j3, String str, int i3);

    public static native long getLong(long j3, String str, long j16);

    public static native long[] getLongArray(long j3, String str);

    public static String getString(long j3, String str) {
        byte[] copyOf;
        byte[] byteArray = getByteArray(j3, str);
        if (byteArray == null) {
            copyOf = new byte[0];
        } else {
            copyOf = Arrays.copyOf(byteArray, byteArray.length);
        }
        return new String(copyOf);
    }

    private static native Object[] getStringArray(long j3, String str);

    private static List<String> getStringList(long j3, String str) {
        ArrayList arrayList = new ArrayList();
        Object[] stringArray = getStringArray(j3, str);
        if (stringArray != null) {
            for (Object obj : stringArray) {
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    arrayList.add(new String(Arrays.copyOf(bArr, bArr.length)));
                }
            }
        }
        return arrayList;
    }
}
