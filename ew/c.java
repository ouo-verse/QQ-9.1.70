package ew;

import com.tencent.qphone.base.util.QLog;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f397253a = {40, 100, 140, 640, 0};

    public static String a(String str, int i3, byte b16) {
        int[] iArr;
        if (i3 == 1080) {
            i3 = f397253a[4];
        }
        int i16 = 0;
        while (true) {
            iArr = f397253a;
            if (i16 < iArr.length) {
                if (iArr[i16] == i3) {
                    break;
                }
                i16++;
            } else {
                i16 = -1;
                break;
            }
        }
        if (i16 < 0 || i16 >= iArr.length) {
            i16 = 2;
        }
        boolean[] zArr = new boolean[iArr.length];
        c(b16, zArr);
        int i17 = iArr[2];
        int i18 = i16;
        while (true) {
            if (i18 < 0) {
                break;
            }
            if (zArr[i18]) {
                i17 = f397253a[i16];
                break;
            }
            i18--;
        }
        String str2 = str + i17;
        if (QLog.isDevelopLevel()) {
            QLog.i("QavAvatarUtil", 4, "getAvatarDownloadUrl, bFaceFlags = " + ((int) b16) + ", imgSize = " + i17 + ", url = " + str2);
        }
        return str2;
    }

    public static int b(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(61)) <= 0 || lastIndexOf >= str.length() - 1) {
            return -1;
        }
        try {
            return Integer.parseInt(str.substring(lastIndexOf + 1));
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void c(byte b16, boolean[] zArr) {
        if ((b16 & 32) != 0) {
            zArr[4] = true;
        } else {
            zArr[4] = false;
        }
        if ((b16 & RegisterType.UNINIT_REF) != 0) {
            zArr[3] = true;
        } else {
            zArr[3] = false;
        }
        if ((b16 & 8) != 0) {
            zArr[2] = true;
        } else {
            zArr[2] = false;
        }
        if ((b16 & 4) != 0) {
            zArr[1] = true;
        } else {
            zArr[1] = false;
        }
        zArr[0] = true;
    }

    public static boolean d(int i3) {
        if (i3 != 0 && i3 != 1000 && i3 != 1004 && i3 != 1024 && i3 != 1020 && i3 != 1021) {
            return false;
        }
        return true;
    }
}
