package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.InputStream;
import java.util.zip.ZipFile;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.finally, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cfinally {
    /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        String str2;
        ZipFile zipFile;
        InputStream inputStream;
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        InputStream inputStream2 = null;
        try {
            packageManager = context.getApplicationContext().getPackageManager();
        } catch (Throwable unused) {
        }
        if (packageManager != null && (packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0)) != null) {
            str2 = packageArchiveInfo.packageName;
            if (str2 == null) {
                return str2;
            }
            try {
                try {
                    zipFile = new ZipFile(str);
                    try {
                        inputStream = zipFile.getInputStream(zipFile.getEntry("AndroidManifest.xml"));
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    zipFile = null;
                }
            } catch (Throwable unused4) {
            }
            try {
                str2 = new Cwhile().a(inputStream).getChildNodes().item(0).getAttributes().getNamedItem("package").getNodeValue();
                Cvolatile.a(inputStream);
                if (Creturn.b() >= 19) {
                    Cvolatile.a(zipFile);
                } else {
                    zipFile.close();
                }
            } catch (Throwable unused5) {
                inputStream2 = inputStream;
                Cvolatile.a(inputStream2);
                if (Creturn.b() >= 19) {
                    Cvolatile.a(zipFile);
                } else {
                    zipFile.close();
                }
                return str2;
            }
            return str2;
        }
        str2 = null;
        if (str2 == null) {
        }
    }
}
