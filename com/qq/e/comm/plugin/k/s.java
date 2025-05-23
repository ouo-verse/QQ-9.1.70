package com.qq.e.comm.plugin.k;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes3.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    static Class f39660a;

    /* renamed from: b, reason: collision with root package name */
    static Class f39661b;

    static {
        try {
            int i3 = FileProvider.f26474d;
            f39660a = FileProvider.class;
        } catch (ClassNotFoundException unused) {
            f39660a = null;
        }
        try {
            int i16 = android.support.v4.content.FileProvider.f26397d;
            f39661b = android.support.v4.content.FileProvider.class;
        } catch (ClassNotFoundException unused2) {
            f39661b = null;
        }
    }

    public static Uri a(Context context, String str, File file) {
        Method method;
        try {
            Class cls = f39660a;
            if (cls != null) {
                method = cls.getMethod("getUriForFile", Context.class, String.class, File.class);
                GDTLogger.d("FileProvider androidx support->androidx");
            } else {
                Class cls2 = f39661b;
                if (cls2 != null) {
                    method = cls2.getMethod("getUriForFile", Context.class, String.class, File.class);
                    GDTLogger.d("FileProvider support support->androidx");
                } else {
                    method = null;
                }
            }
            if (method != null) {
                GDTLogger.d("getUriForFileMethod is not null");
                Uri uri = (Uri) method.invoke(null, context, str, file);
                GDTLogger.d("getUriForFileMethod uri =" + uri.toString());
                return uri;
            }
            GDTLogger.d("getUriForFileMethod method is null");
            return null;
        } catch (Throwable th5) {
            th5.printStackTrace();
            GDTLogger.e("getUriForFileMethod exception ", th5);
            return null;
        }
    }

    public static Uri a(Context context, File file, Intent intent, String str) {
        Uri uri;
        if (context != null && file != null && file.exists() && !TextUtils.isEmpty(str)) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 29 && (i3 < 24 || context.getApplicationInfo().targetSdkVersion < 24)) {
                Uri fromFile = Uri.fromFile(file);
                GDTLogger.d("GdtApkInstaller buildInstallIntent beloew 7.0");
                return fromFile;
            }
            GDTLogger.d("getUriForFile higher targetSDKVersion");
            Uri a16 = a(context, file);
            if (a16 != null) {
                if (intent != null) {
                    intent.addFlags(1);
                } else {
                    context.grantUriPermission(str, a16, 1);
                }
                GDTLogger.i("getUriForFile success use customfileprovider. Uri: " + a16);
                return a16;
            }
            try {
                uri = a(context, context.getPackageName() + ".tg_fileprovider", file);
            } catch (Exception unused) {
                GDTLogger.d("getUriForFile fileprovider use tangram failed");
                GDTLogger.i("getUriForFile fileprovider use tangram failed");
                uri = null;
            }
            if (uri == null) {
                try {
                    uri = a(context, context.getPackageName() + ".fileprovider", file);
                } catch (Exception e16) {
                    GDTLogger.i("getUriForFile fileprovider use origin failed");
                    GDTLogger.e("getUriForFile: " + e16.getMessage());
                    uri = null;
                }
            }
            if (uri != null) {
                if (intent != null) {
                    intent.addFlags(1);
                } else {
                    context.grantUriPermission(str, uri, 1);
                }
                GDTLogger.i("getUriForFile normal fileprovider success. Uri: " + uri);
                return uri;
            }
            GDTLogger.i("getUriForFile fail ");
        }
        return null;
    }

    private static Uri a(Context context, File file) {
        String b16 = com.qq.e.comm.plugin.base.a.a.a().b();
        if (TextUtils.isEmpty(b16) || context == null) {
            return null;
        }
        try {
            Method method = Class.forName(b16).getMethod("getUriForFile", Context.class, String.class, File.class);
            GDTLogger.i("FileProvider custom support->androidx");
            return (Uri) method.invoke(null, context, context.getPackageName() + ".fileprovider", file);
        } catch (Throwable th5) {
            GDTLogger.e("getUriForCustomFileProvider failed", th5);
            return null;
        }
    }
}
