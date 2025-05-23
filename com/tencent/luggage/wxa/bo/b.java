package com.tencent.luggage.wxa.bo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.m;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static void a(String str, Context context) {
        if (w0.c(str)) {
            return;
        }
        String b16 = x.b(str, false);
        if (b16 != null) {
            if (new v(b16).p()) {
                w.b("Luggage.AndroidMediaUtil", "refreshMediaScanner error for path isDirectory.%s", b16);
                return;
            }
            try {
                a(context, b16);
            } catch (Throwable th5) {
                w.a("Luggage.AndroidMediaUtil", th5, "Cannot update media database", new Object[0]);
            }
            try {
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", m.a(context, new v(b16))));
            } catch (Exception e16) {
                w.a("Luggage.AndroidMediaUtil", e16, "", new Object[0]);
            }
        }
        w.d("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", str);
        if (Build.VERSION.SDK_INT > 28) {
            try {
                MediaScannerConnection.scanFile(context.getApplicationContext(), new String[]{b16}, new String[]{e.d(str)}, null);
                return;
            } catch (Throwable th6) {
                w.b("Luggage.AndroidMediaUtil", "refresh by MediaScannerConnection, path = %s, thr = %s", str, th6);
                return;
            }
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", m.a(context, new v(str))).addFlags(1));
        w.d("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", str);
    }

    public static String b(String str) {
        return a() + String.format(Locale.US, "%s%d.%s", "mmexport", Long.valueOf(System.currentTimeMillis()), str);
    }

    public static String c(String str) {
        if (Build.VERSION.SDK_INT > 29) {
            return b(str);
        }
        return com.tencent.luggage.wxa.db.a.d() + String.format(Locale.US, "%s%d.%s", "mmexport", Long.valueOf(System.currentTimeMillis()), str);
    }

    public static String d(String str) {
        String str2;
        int i3;
        StringBuilder sb5;
        String str3;
        if (w0.c(str)) {
            return "";
        }
        try {
            str2 = new File(str).getCanonicalPath();
        } catch (Throwable unused) {
            str2 = str;
        }
        if (str2.startsWith(com.tencent.luggage.wxa.db.a.k())) {
            i3 = com.tencent.luggage.wxa.db.a.k().length();
        } else if (str2.startsWith(com.tencent.luggage.wxa.db.a.j())) {
            i3 = com.tencent.luggage.wxa.db.a.j().length();
        } else {
            i3 = -1;
        }
        if (i3 < 0) {
            return str;
        }
        String substring = str.substring(i3);
        if (substring.startsWith("/")) {
            sb5 = new StringBuilder();
            str3 = PreDownloadConstants.SDCRAD_DEFAULT;
        } else {
            sb5 = new StringBuilder();
            str3 = "/sdcard/";
        }
        sb5.append(str3);
        sb5.append(substring);
        return sb5.toString();
    }

    public static BitmapFactory.Options e(String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = x.n(str);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                MMBitmapFactory.a(inputStream, null, options);
                w0.a((Closeable) inputStream);
                return options;
            } catch (FileNotFoundException unused) {
                w0.a((Closeable) inputStream);
                return null;
            } catch (Throwable th5) {
                inputStream2 = inputStream;
                th = th5;
                w0.a((Closeable) inputStream2);
                throw th;
            }
        } catch (FileNotFoundException unused2) {
            inputStream = null;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static String b() {
        String j3;
        String l3 = com.tencent.luggage.wxa.db.a.l();
        if (l3.startsWith(com.tencent.luggage.wxa.db.a.k())) {
            j3 = new File(l3).getParentFile().getParentFile().getParentFile().getAbsolutePath();
        } else {
            j3 = com.tencent.luggage.wxa.db.a.j();
        }
        try {
            j3 = new File(j3).getCanonicalPath();
        } catch (Throwable unused) {
        }
        String b16 = x.b(a(), true);
        int indexOf = b16.indexOf(j3);
        if (indexOf < 0) {
            return b16;
        }
        String substring = b16.substring(indexOf + j3.length());
        if (substring.startsWith("/")) {
            return PreDownloadConstants.SDCRAD_DEFAULT + substring;
        }
        return "/sdcard/" + substring;
    }

    public static String a() {
        String c16 = com.tencent.luggage.wxa.db.a.c();
        w.d("Luggage.AndroidMediaUtil", "getSysCameraDirPath: " + c16);
        return c16;
    }

    public static void a(Context context, String str) {
        Uri contentUri;
        String str2;
        int indexOf;
        int lastIndexOf;
        try {
            String d16 = e.d(str);
            if (d16 == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            if (d16.contains("image")) {
                contentUri = MediaStore.Images.Media.getContentUri("external");
                BitmapFactory.Options e16 = e(str);
                if (e16 == null) {
                    return;
                }
                contentValues.put("width", Integer.valueOf(e16.outWidth));
                contentValues.put("height", Integer.valueOf(e16.outHeight));
                if (d16.contains(MimeHelper.IMAGE_SUBTYPE_JPEG) || d16.contains("jpg")) {
                    contentValues.put("orientation", Integer.valueOf(a(str)));
                }
            } else if (d16.contains("video")) {
                contentUri = MediaStore.Video.Media.getContentUri("external");
                com.tencent.luggage.wxa.ba.b bVar = new com.tencent.luggage.wxa.ba.b();
                bVar.setDataSource(str);
                contentValues.put("width", bVar.extractMetadata(18));
                contentValues.put("height", bVar.extractMetadata(19));
                contentValues.put("duration", bVar.extractMetadata(9));
                contentValues.put("orientation", bVar.extractMetadata(24));
            } else {
                contentUri = MediaStore.Files.getContentUri("external");
            }
            String b16 = x.b(str, false);
            String str3 = b16 == null ? str : b16;
            if (Build.VERSION.SDK_INT > 29) {
                if (d16.contains("image")) {
                    str2 = Environment.DIRECTORY_PICTURES;
                } else if (d16.contains("video")) {
                    str2 = Environment.DIRECTORY_PICTURES;
                } else {
                    str2 = Environment.DIRECTORY_DOWNLOADS;
                }
                if (!w0.c(str2)) {
                    String str4 = "";
                    if (str3.contains(str2) && (indexOf = str3.indexOf(str2) + str2.length()) < (lastIndexOf = str3.lastIndexOf(File.separator))) {
                        str4 = str3 + str3.substring(indexOf, lastIndexOf);
                    }
                    contentValues.put("relative_path", str4);
                }
            }
            if (b16 == null) {
                b16 = str;
            }
            contentValues.put("_data", b16);
            contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, new v(str).i());
            contentValues.put("title", x.j(str));
            contentValues.put("_size", Long.valueOf(x.e(str)));
            contentValues.put(JobDbManager.COL_UP_MIME_TYPE, d16);
            context.getContentResolver().insert(contentUri, contentValues);
        } catch (Throwable th5) {
            w.a("Luggage.AndroidMediaUtil", th5, "[-] Failed when updateMediaDatabase", new Object[0]);
        }
    }

    public static int a(String str) {
        if (w0.c(str)) {
            w.a("Luggage.AndroidMediaUtil", "filepath is null or nil");
            return 0;
        }
        if (!x.d(str)) {
            w.a("Luggage.AndroidMediaUtil", "file not exist:[%s]", str);
            return 0;
        }
        return com.tencent.luggage.wxa.aa.d.a(str).a();
    }
}
