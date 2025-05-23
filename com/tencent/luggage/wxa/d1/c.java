package com.tencent.luggage.wxa.d1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static File a(com.tencent.luggage.wxa.x0.f fVar) {
        File file;
        String a16 = fVar.a();
        if (fVar.b()) {
            file = new File(a16);
        } else {
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), a16);
        }
        if (!file.exists() && !file.mkdirs()) {
            d.a().a("Oops! Failed create " + a16);
            return null;
        }
        String str = "IMG_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        try {
            return File.createTempFile(str, ".jpg", file);
        } catch (IOException unused) {
            d.a().a("Oops! Failed create " + str + " file");
            return null;
        }
    }

    public static boolean b(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean b(com.tencent.luggage.wxa.f1.b bVar) {
        try {
            String guessContentTypeFromName = URLConnection.guessContentTypeFromName(bVar.b());
            if (guessContentTypeFromName != null) {
                if (guessContentTypeFromName.startsWith("video")) {
                    return true;
                }
            }
            return false;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.yp.b.b("ImagePickerUtils", "isVideoFormat fail. path:%s exception:%s", bVar.b(), e16);
            return false;
        }
    }

    public static String a(String str) {
        String str2 = File.separator;
        return str.contains(str2) ? str.substring(str.lastIndexOf(str2) + 1) : str;
    }

    public static void a(Context context, Intent intent, Uri uri) {
        Iterator it = ((List) com.tencent.luggage.wxa.ia.a.a(context.getPackageManager(), com.tencent.luggage.wxa.ja.b.a(65536, new com.tencent.luggage.wxa.ja.a()).a(intent).a(), "com/tencent/image_picker/imagepicker/helper/ImagePickerUtils", "grantAppPermission", "(Landroid/content/Context;Landroid/content/Intent;Landroid/net/Uri;)V", "android/content/pm/PackageManager", "queryIntentActivities", "(Landroid/content/Intent;I)Ljava/util/List;")).iterator();
        while (it.hasNext()) {
            context.grantUriPermission(((ResolveInfo) it.next()).activityInfo.packageName, uri, 3);
        }
    }

    public static void a(Context context, Uri uri) {
        context.revokeUriPermission(uri, 3);
    }

    public static boolean a(com.tencent.luggage.wxa.f1.b bVar) {
        return bVar.b().substring(bVar.b().lastIndexOf(".") + 1, bVar.b().length()).equalsIgnoreCase("gif");
    }
}
