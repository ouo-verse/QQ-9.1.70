package com.tencent.mobileqq.vas;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.utils.bn;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class LzmaUtils {
    private static native int DecodeEx(String str, String str2);

    private static int decodeExWrapper(Context context, boolean z16, String str, String str2) {
        if (z16) {
            SoLoadUtilNew.loadSoByName(context, "lzmadecode");
        } else {
            SoLoadUtilNew.loadSoByName(context, "DecodeSo");
        }
        int i3 = 0;
        for (int i16 = 0; i16 <= 3; i16++) {
            if (z16) {
                i3 = bn.b(str, str2);
            } else {
                i3 = DecodeEx(str, str2);
            }
            if (i3 == 0) {
                break;
            }
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
    
        if (r4 == 0) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int lzmaDecode(Context context, String str, String str2) {
        boolean z16;
        int i3;
        if (str != null && str2 != null) {
            if (!new File(str).exists()) {
                if (QLog.isColorLevel()) {
                    QLog.d("lzmaDecode", 2, "lzma File not exists.");
                }
                return -1;
            }
            File file = new File(str2);
            if (!file.exists() && !file.mkdirs()) {
                if (QLog.isColorLevel()) {
                    QLog.d("lzmaDecode", 2, "cannot create dirs.");
                }
                return -1;
            }
            try {
                z16 = bn.c();
                if (z16) {
                    try {
                        i3 = decodeExWrapper(context, true, str, str2);
                    } catch (UnsatisfiedLinkError e16) {
                        e = e16;
                        i3 = 0;
                        if (QLog.isColorLevel()) {
                            QLog.d("lzmaDecode", 2, "Unsatisfied Link error: " + e.toString());
                        }
                        if (i3 == 0) {
                        }
                    }
                } else {
                    i3 = 0;
                }
            } catch (UnsatisfiedLinkError e17) {
                e = e17;
                z16 = false;
                i3 = 0;
            }
            try {
                i3 = decodeExWrapper(context, false, str, str2);
            } catch (UnsatisfiedLinkError e18) {
                e = e18;
                if (QLog.isColorLevel()) {
                }
                if (i3 == 0) {
                }
            }
            if (i3 == 0) {
                return 0;
            }
            if (QLog.isColorLevel()) {
                QLog.d("lzmaDecode", 2, "decode file, result:" + i3 + ", isUseNewLoad:" + z16);
            }
            return i3;
        }
        if (QLog.isColorLevel()) {
            QLog.d("lzmaDecode", 2, "path is null.");
        }
        return -1;
    }
}
