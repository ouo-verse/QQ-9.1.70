package com.tencent.upload.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class PDUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PDUtil";

    public PDUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int byte2int(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }

    public static boolean check(byte[] bArr) {
        byte[] bArr2 = new byte[1];
        System.arraycopy(bArr, 0, bArr2, 0, 1);
        if (vtolh(bArr2) != 4) {
            UploadLog.e(TAG, "0x04 decode error !");
            return false;
        }
        System.arraycopy(bArr, bArr.length - 1, bArr2, 0, 1);
        if (vtolh(bArr2) == 5) {
            return true;
        }
        UploadLog.e(TAG, "0x05 decode error !");
        return false;
    }

    public static PduHeader decodeHeader(byte[] bArr) {
        if (!check(bArr)) {
            return null;
        }
        try {
            int i3 = PduHeader.length;
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 1, bArr2, 0, i3);
            return PduHeader.decode(bArr2);
        } catch (OutOfMemoryError unused) {
            UploadLog.e(TAG, "OutOfMemoryError !!!");
            return null;
        }
    }

    public static byte[] decodeJce(byte[] bArr) {
        byte[] bArr2 = null;
        if (!check(bArr)) {
            return null;
        }
        try {
            int i3 = PduHeader.length;
            byte[] bArr3 = new byte[i3];
            System.arraycopy(bArr, 1, bArr3, 0, i3);
            int i16 = PduHeader.decode(bArr3).len - 25;
            bArr2 = new byte[i16];
            System.arraycopy(bArr, PduHeader.length + 1, bArr2, 0, i16);
            return bArr2;
        } catch (OutOfMemoryError unused) {
            UploadLog.e(TAG, "OutOfMemoryError !!!");
            return bArr2;
        }
    }

    public static int decodePDU(byte[] bArr) {
        byte[] bArr2 = new byte[1];
        System.arraycopy(bArr, 0, bArr2, 0, 1);
        if (vtolh(bArr2) != 4) {
            UploadLog.e(TAG, "0x04 error !!!");
            printHexString("---------- decodePDU:", bArr);
            return -1;
        }
        try {
            int i3 = PduHeader.length;
            byte[] bArr3 = new byte[i3];
            System.arraycopy(bArr, 1, bArr3, 0, i3);
            return PduHeader.decode(bArr3).len;
        } catch (OutOfMemoryError unused) {
            UploadLog.e(TAG, "OutOfMemoryError !!!");
            return -1;
        }
    }

    public static int decodeSeq(byte[] bArr) {
        if (!check(bArr)) {
            return -1;
        }
        try {
            int i3 = PduHeader.length;
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 1, bArr2, 0, i3);
            return PduHeader.decode(bArr2).seq;
        } catch (OutOfMemoryError unused) {
            UploadLog.e(TAG, "OutOfMemoryError !!!");
            return -1;
        }
    }

    public static int decodeSize(byte[] bArr) {
        if (!check(bArr)) {
            return -1;
        }
        try {
            int i3 = PduHeader.length;
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 1, bArr2, 0, i3);
            return PduHeader.decode(bArr2).len;
        } catch (OutOfMemoryError unused) {
            UploadLog.e(TAG, "OutOfMemoryError !!!");
            return -1;
        }
    }

    public static byte[] encode(int i3, byte[] bArr) {
        return encode(i3, 0, bArr);
    }

    public static byte[] int2byte(int i3) {
        return new byte[]{(byte) (i3 >> 24), (byte) (i3 >> 16), (byte) (i3 >> 8), (byte) i3};
    }

    public static byte[] long2byte(long j3) {
        return new byte[]{(byte) (j3 >> 56), (byte) (j3 >> 48), (byte) (j3 >> 40), (byte) (j3 >> 32), (byte) (j3 >> 24), (byte) (j3 >> 16), (byte) (j3 >> 8), (byte) j3};
    }

    public static void printHexString(String str, byte[] bArr) {
        UploadLog.e(TAG, str);
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            sb5.append(hexString.toUpperCase());
        }
        UploadLog.e(TAG, "printHexString:" + sb5.toString());
    }

    public static byte[] short2byte(int i3) {
        return new byte[]{(byte) (i3 >> 8), (byte) i3};
    }

    public static byte[] toLH(int i3) {
        return new byte[]{(byte) (i3 & 255), (byte) ((i3 >> 8) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 24) & 255)};
    }

    public static int vtolh(byte[] bArr) {
        int i3 = 0;
        for (int i16 = 0; i16 < bArr.length && i16 < 4; i16++) {
            i3 += bArr[i16] << (i16 * 8);
        }
        return i3;
    }

    public static byte[] encode(int i3, int i16, byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 25];
        try {
            byte[] bArr3 = {4};
            System.arraycopy(bArr3, 0, bArr2, 0, 1);
            PduHeader pduHeader = new PduHeader(i3, i16, bArr.length + 25);
            System.arraycopy(pduHeader.getBuf(), 0, bArr2, 1, pduHeader.getBuf().length);
            int length = pduHeader.getBuf().length + 1;
            System.arraycopy(bArr, 0, bArr2, length, bArr.length);
            int length2 = length + bArr.length;
            bArr3[0] = 5;
            System.arraycopy(bArr3, 0, bArr2, length2, 1);
        } catch (OutOfMemoryError unused) {
            UploadLog.e(TAG, "OutOfMemoryError !!!");
        }
        return bArr2;
    }

    public static void int2byte(int i3, byte[] bArr, int i16) {
        bArr[i16] = (byte) (i3 >> 24);
        bArr[i16 + 1] = (byte) (i3 >> 16);
        bArr[i16 + 2] = (byte) (i3 >> 8);
        bArr[i16 + 3] = (byte) i3;
    }
}
