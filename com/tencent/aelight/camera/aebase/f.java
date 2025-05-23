package com.tencent.aelight.camera.aebase;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.provider.MediaStore;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f {
    private static Bitmap a(Bitmap bitmap) {
        int width;
        int height;
        int min;
        if (bitmap == null || bitmap.isRecycled() || (min = Math.min((width = bitmap.getWidth()), (height = bitmap.getHeight()))) <= 50) {
            return bitmap;
        }
        float f16 = 50.0f / min;
        Matrix matrix = new Matrix();
        matrix.preScale(f16, f16);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (createBitmap.equals(bitmap)) {
            return createBitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00dc, code lost:
    
        if (r15.moveToLast() != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00de, code lost:
    
        r0 = r15.getInt(r15.getColumnIndex("_id"));
        r2 = java.lang.Math.max(r15.getLong(r15.getColumnIndex("date_added")), r15.getLong(r15.getColumnIndex("date_modified")));
        r14 = r15.getString(r15.getColumnIndex("_data"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0106, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0108, code lost:
    
        com.tencent.qphone.base.util.QLog.d(r13, 2, "queryFirstMediaThumbnail(image part) : id = " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x011e, code lost:
    
        r0 = com.tencent.ttpic.baseutils.bitmap.BitmapUtils.decodeBitmap(r14, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0123, code lost:
    
        if (r0 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x012f, code lost:
    
        if (r15.moveToPrevious() != false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0127, code lost:
    
        if (r2 <= r16) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0129, code lost:
    
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0148, code lost:
    
        if (android.text.TextUtils.isEmpty(r14) != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x014a, code lost:
    
        if (r1 == null) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x014c, code lost:
    
        r1 = a(r1);
        r0 = com.tencent.mobileqq.utils.BaseImageUtil.getExifOrientation(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0154, code lost:
    
        if (r0 == 0) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0158, code lost:
    
        if ((r0 % 90) != 0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x015e, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0160, code lost:
    
        com.tencent.qphone.base.util.QLog.d(r13, 2, "has exif rotate" + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0176, code lost:
    
        r5 = r1.getWidth();
        r6 = r1.getHeight();
        r7 = new android.graphics.Matrix();
        r7.postRotate(r0, r5 / 2.0f, r6 / 2.0f);
        r0 = android.graphics.Bitmap.createBitmap(r1, 0, 0, r5, r6, r7, true);
        r1.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0199, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0141, code lost:
    
        if (r15 == null) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00d8 A[Catch: all -> 0x0137, Exception -> 0x0139, TryCatch #5 {Exception -> 0x0139, blocks: (B:9:0x00cb, B:11:0x00d8, B:13:0x00de, B:15:0x0108, B:16:0x011e, B:18:0x012b), top: B:8:0x00cb, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap b(Context context, boolean z16) {
        String str;
        Bitmap bitmap;
        String str2;
        String str3;
        long j3;
        Cursor cursor;
        Cursor cursor2 = null;
        r1 = null;
        Bitmap bitmap2 = null;
        cursor2 = null;
        if (context == null) {
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        String str4 = "QIMCameraUtil";
        long j16 = 0;
        if (!z16) {
            str = "QIMCameraUtil";
            str3 = null;
            j3 = 0;
            cursor = null;
        } else {
            try {
                try {
                    Cursor query = ContactsMonitor.query(contentResolver, MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
                    if (query != null) {
                        try {
                            try {
                                if (query.moveToLast()) {
                                    bitmap = null;
                                    str2 = null;
                                    while (true) {
                                        try {
                                            int i3 = query.getInt(query.getColumnIndex("_id"));
                                            String str5 = str4;
                                            try {
                                                j16 = Math.max(query.getLong(query.getColumnIndex("date_added")), query.getLong(query.getColumnIndex("date_modified")));
                                                str2 = query.getString(query.getColumnIndex("_data"));
                                                if (QLog.isColorLevel()) {
                                                    str = str5;
                                                    try {
                                                        QLog.d(str, 2, "queryFirstMediaThumbnail(video part) : id = " + i3);
                                                    } catch (Exception e16) {
                                                        e = e16;
                                                        cursor2 = query;
                                                        QLog.e(str, 2, "queryFirstMediaThumbnail(video part) : error", e);
                                                        if (cursor2 != null) {
                                                            cursor2.close();
                                                        }
                                                        str3 = str2;
                                                        j3 = j16;
                                                        cursor = cursor2;
                                                        bitmap2 = bitmap;
                                                        try {
                                                            cursor = ContactsMonitor.query(contentResolver, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
                                                            if (cursor != null) {
                                                            }
                                                        } catch (Exception e17) {
                                                            QLog.e(str, 2, "queryFirstMediaThumbnail(image part) : error", e17);
                                                        }
                                                    }
                                                } else {
                                                    str = str5;
                                                }
                                                bitmap = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, i3, 3, null);
                                                if (bitmap != null || !query.moveToPrevious()) {
                                                    break;
                                                }
                                                str4 = str;
                                            } catch (Exception e18) {
                                                e = e18;
                                                str = str5;
                                            }
                                        } catch (Exception e19) {
                                            e = e19;
                                            str = str4;
                                        }
                                    }
                                    bitmap2 = bitmap;
                                    if (query != null) {
                                        query.close();
                                    }
                                    str3 = str2;
                                    j3 = j16;
                                    cursor = query;
                                }
                            } catch (Exception e26) {
                                e = e26;
                                str = "QIMCameraUtil";
                                bitmap = null;
                                str2 = null;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            cursor2 = query;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    }
                    str = "QIMCameraUtil";
                    str2 = null;
                    if (query != null) {
                    }
                    str3 = str2;
                    j3 = j16;
                    cursor = query;
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e27) {
                e = e27;
                str = "QIMCameraUtil";
                bitmap = null;
                str2 = null;
            }
        }
        try {
            cursor = ContactsMonitor.query(contentResolver, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
            if (cursor != null) {
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
