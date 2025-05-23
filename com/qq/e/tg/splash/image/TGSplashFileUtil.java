package com.qq.e.tg.splash.image;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.util.Md5Util;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TGSplashFileUtil {
    public static final String ADNET = "adnet";
    public static final String PRELOAD_CACHE_DIR_COLD = "cold";
    public static final String PRELOAD_CACHE_DIR_HOT = "hot";
    public static final String PRELOAD_FILE = "preload";
    public static final String RESOURCE = "resource";

    public static File getImgFile(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder("resource");
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append("image");
            sb5.append(str2);
            sb5.append(Md5Util.encode(str));
            return new File(context.getDir(ADNET, 0), sb5.toString());
        }
        return null;
    }

    public static File getPreloadDataFile(Context context, String str, boolean z16) {
        String str2;
        if (context != null && !TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder(str);
            String str3 = File.separator;
            sb5.append(str3);
            if (z16) {
                str2 = "hot";
            } else {
                str2 = PRELOAD_CACHE_DIR_COLD;
            }
            sb5.append(str2);
            sb5.append(str3);
            sb5.append("preload");
            return new File(context.getDir(ADNET, 0), sb5.toString());
        }
        return null;
    }

    public static File getVideoFile(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder("resource");
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append("video");
            sb5.append(str2);
            sb5.append(Md5Util.encode(str));
            return new File(context.getDir(ADNET, 0), sb5.toString());
        }
        return null;
    }
}
