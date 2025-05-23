package com.tencent.luggage.wxa.f4;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00dd, code lost:
    
        if (r11 == null) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, Uri uri) {
        Uri uri2;
        String str;
        String[] strArr;
        Cursor cursor;
        Cursor cursor2 = null;
        if (DocumentsContract.isDocumentUri(context.getApplicationContext(), uri)) {
            if (b(uri)) {
                return Environment.getExternalStorageDirectory() + "/" + DocumentsContract.getDocumentId(uri).split(":")[1];
            }
            if (a(uri)) {
                uri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue());
            } else if (c(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                String str2 = split[0];
                if ("image".equals(str2)) {
                    uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str2)) {
                    uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str2)) {
                    uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                uri2 = uri;
                str = "_id=?";
                strArr = new String[]{split[1]};
                if (!"content".equalsIgnoreCase(uri2.getScheme())) {
                    try {
                        cursor = ContactsMonitor.query(context.getContentResolver(), uri2, new String[]{"_data"}, str, strArr, null);
                    } catch (Exception unused) {
                        cursor = null;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                    if (cursor == null) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                    try {
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                        if (cursor.moveToFirst()) {
                            String string = cursor.getString(columnIndexOrThrow);
                            cursor.close();
                            return string;
                        }
                    } catch (Exception unused2) {
                    } catch (Throwable th6) {
                        th = th6;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                    cursor.close();
                } else if ("file".equalsIgnoreCase(uri2.getScheme())) {
                    return uri2.getPath();
                }
                return null;
            }
        }
        uri2 = uri;
        str = null;
        strArr = null;
        if (!"content".equalsIgnoreCase(uri2.getScheme())) {
        }
        return null;
    }

    public static boolean b(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean c(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean a(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }
}
