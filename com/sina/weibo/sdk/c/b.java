package com.sina.weibo.sdk.c;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.libra.util.ImageContentType;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class b {
    public static boolean a(Context context, Uri uri) {
        String c16 = c(context, uri);
        if (!TextUtils.isEmpty(c16)) {
            File file = new File(c16);
            if (b(file)) {
                return false;
            }
            String a16 = a(file);
            return !TextUtils.isEmpty(a16) && a16.startsWith(ImageContentType.IMAGE_PREFIX);
        }
        throw new IllegalArgumentException("get image path is null");
    }

    public static boolean b(Context context, Uri uri) {
        String str;
        String c16 = c(context, uri);
        if (!TextUtils.isEmpty(c16)) {
            File file = new File(c16);
            if (b(file)) {
                return false;
            }
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(".");
            if (lastIndexOf >= 0) {
                String substring = name.substring(lastIndexOf);
                if (!TextUtils.isEmpty(substring) || substring.length() >= 2) {
                    str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring.substring(1).toLowerCase());
                    return TextUtils.isEmpty(str) && str.startsWith("video/");
                }
            }
            str = "*/*";
            if (TextUtils.isEmpty(str)) {
            }
        }
        throw new IllegalArgumentException("get video path is null");
    }

    @TargetApi(19)
    private static String c(Context context, Uri uri) {
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else {
                if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                    return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
                if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = split2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return a(context, uri2, "_id=?", new String[]{split2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
                    return uri.getLastPathSegment();
                }
                return a(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    private static String a(File file) {
        try {
            String absolutePath = file.getAbsolutePath();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(absolutePath, options);
            String str = options.outMimeType;
            if (!str.contains("jpg") && !str.contains("gif") && !str.contains("png")) {
                if (!str.contains(MimeHelper.IMAGE_SUBTYPE_JPEG)) {
                    return null;
                }
            }
            return "image/*";
        } catch (Exception unused) {
            return "*/*";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if (r8 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002a, code lost:
    
        if (r8 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0039, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
    
        r8.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            cursor = ContactsMonitor.query(context.getContentResolver(), uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                            cursor.close();
                            return string;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                }
            }
        } catch (Exception e17) {
            e = e17;
            cursor = null;
        } catch (Throwable th6) {
            th = th6;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    private static boolean b(File file) {
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }
}
