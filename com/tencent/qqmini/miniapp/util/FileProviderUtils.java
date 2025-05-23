package com.tencent.qqmini.miniapp.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;

/* loaded from: classes23.dex */
public class FileProviderUtils {
    public static String sAuthority;
    public static Boolean sIsTargetThanN;

    private static Uri getUriForFile24(Context context, File file) {
        if (sAuthority == null) {
            sAuthority = context.getApplicationContext().getPackageName() + ".fileprovider";
        }
        return FileProvider.getUriForFile(context, sAuthority, file);
    }

    public static boolean isTargetBeyondN(Context context) {
        boolean z16;
        if (sIsTargetThanN == null) {
            if (Build.VERSION.SDK_INT >= 24 && context.getApplicationContext().getApplicationInfo().targetSdkVersion >= 24) {
                z16 = true;
            } else {
                z16 = false;
            }
            sIsTargetThanN = Boolean.valueOf(z16);
        }
        return sIsTargetThanN.booleanValue();
    }

    public static Uri setSystemCapture(Context context, File file, Intent intent) {
        Uri fromFile;
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        if (isTargetBeyondN(context)) {
            fromFile = getUriForFile24(context, file);
            intent.addFlags(3);
        } else {
            fromFile = Uri.fromFile(file);
        }
        intent.putExtra("output", fromFile);
        intent.putExtra("android.intent.extra.videoQuality", 100);
        return fromFile;
    }
}
