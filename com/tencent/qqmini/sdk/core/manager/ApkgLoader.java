package com.tencent.qqmini.sdk.core.manager;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ApkgLoader {
    private static volatile ApkgLoader instance;
    private static volatile byte[] lock = new byte[0];

    ApkgLoader() {
    }

    public static ApkgLoader g() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ApkgLoader();
                }
            }
        }
        return instance;
    }

    public ApkgInfo loadApkg(Context context, String str) {
        File wxapkgFileInAssets = WxapkgUnpacker.getWxapkgFileInAssets(context, str);
        String str2 = context.getFilesDir().getPath() + "/mini/" + str;
        if (wxapkgFileInAssets != null && !WxapkgUnpacker.unpackSync(wxapkgFileInAssets.getPath(), str2)) {
            return null;
        }
        try {
            return ApkgInfo.loadApkgInfoFromFolderPath(str2, null, null);
        } catch (Throwable th5) {
            QMLog.e("ApkgLoader", "", th5);
            return null;
        }
    }
}
