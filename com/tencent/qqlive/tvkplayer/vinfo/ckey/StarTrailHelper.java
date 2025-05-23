package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.LibLoadUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class StarTrailHelper {
    private static boolean bLoadSucc = false;

    public static boolean loadso(Context context) {
        if (!bLoadSucc) {
            bLoadSucc = LibLoadUtil.loadso(context, "poxy");
        }
        return bLoadSucc;
    }

    public static byte[] stGetSign(Context context, String str, String str2, byte[] bArr) {
        if (context != null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.tencent.secprotocol.ByteData");
                return (byte[]) loadClass.getMethod("getSign", String.class, String.class, byte[].class).invoke(loadClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), str, str2, bArr);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return null;
    }

    public static int stInitUp(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context != null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.tencent.secprotocol.ByteData");
                loadClass.getMethod("init", Context.class, String.class, String.class, String.class, String.class, String.class).invoke(loadClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), context, str, str2, str3, str4, str5);
                return 0;
            } catch (Throwable th5) {
                th5.printStackTrace();
                return -1;
            }
        }
        return -1;
    }
}
