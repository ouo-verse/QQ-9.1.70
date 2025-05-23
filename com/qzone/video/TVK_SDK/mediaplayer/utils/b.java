package com.qzone.video.TVK_SDK.mediaplayer.utils;

import android.text.TextUtils;
import android.util.Log;
import java.util.MissingFormatArgumentException;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b {
    public static int a(String str, Throwable th5) {
        return b(str, th5, "");
    }

    public static int b(String str, Throwable th5, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str2)) {
            str3 = str2 + "\n";
        } else {
            str3 = "";
        }
        if (th5 != null) {
            str3 = str3 + Log.getStackTraceString(th5);
        }
        c(null, 0, 20, str, str3, new Object[0]);
        return 0;
    }

    private static int d(int i3) {
        if (i3 != 10) {
            if (i3 != 20) {
                if (i3 == 30 || i3 == 40) {
                    return 4;
                }
                if (i3 != 50) {
                    if (i3 != 60) {
                        return 0;
                    }
                    return 2;
                }
                return 3;
            }
            return 5;
        }
        return 6;
    }

    public static void c(String str, int i3, int i16, String str2, String str3, Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    str3 = String.format(str3, objArr);
                }
            } catch (MissingFormatArgumentException e16) {
                e16.printStackTrace();
                return;
            } catch (Exception e17) {
                e17.printStackTrace();
                return;
            }
        }
        String str4 = "[" + str + "]" + str3;
        if (zo.c.c()) {
            Log.println(d(i16), str2, str4);
        }
    }
}
