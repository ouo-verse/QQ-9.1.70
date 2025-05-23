package com.tencent.mobileqq.util;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.image.NativeGifIndex8;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ak {
    public static void a(String str) {
        if (str != null) {
            if (str.contains("NativeGifFactory") || str.contains(NativeGifIndex8.TAG) || str.contains("libkIndexGif") || str.contains("libskia")) {
                MobileQQ.sMobileQQ.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
                if (QLog.isColorLevel()) {
                    QLog.d("GifSoLoader", 2, String.format("Crash in libkIndexGif support library at %s process!", MobileQQ.sMobileQQ.getQQProcessName()));
                }
            }
        }
    }

    public static String b(Context context) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return null;
        }
        return filesDir.getParent() + SoLoadCore.PATH_LIB;
    }
}
