package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.tencent.component.media.MediaFile;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VideoThumbnail {
    private static final String FILE_URL_PREFIX = "file://";
    private static final String[] PROJECTION_VIDEO = {"DISTINCT _id", "_data"};
    private static final String TAG = "VideoThumbnail";

    private static Bitmap createVideoThumbnail(String str) {
        return getFirstKeyFrame(str);
    }

    @TargetApi(10)
    private static Bitmap getFirstKeyFrame(String str) {
        int width;
        int height;
        int max;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        Bitmap bitmap = null;
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                bitmap = mediaMetadataRetriever.getFrameAtTime(500L, 2);
                if (bitmap != null && (max = Math.max((width = bitmap.getWidth()), (height = bitmap.getHeight()))) > 512) {
                    float f16 = 512.0f / max;
                    bitmap = Bitmap.createScaledBitmap(bitmap, Math.round(width * f16), Math.round(f16 * height), true);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException e16) {
                e16.printStackTrace();
            }
        } catch (Throwable th5) {
            try {
                th5.printStackTrace();
                mediaMetadataRetriever.release();
            } catch (Throwable th6) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e17) {
                    e17.printStackTrace();
                }
                throw th6;
            }
        }
        return bitmap;
    }

    public static BitmapReference getThumb(Context context, String str) {
        Bitmap bitmap;
        try {
            bitmap = createVideoThumbnail(str);
            if (bitmap == null) {
                try {
                    bitmap = queryVideoThumbnail(context, str);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            bitmap = null;
        }
        return BitmapReference.getBitmapReference(bitmap);
    }

    public static boolean isVideo(String str) {
        MediaFile.MediaFileType fileType = MediaFile.getFileType(str);
        if (fileType != null && MediaFile.isVideoFileType(fileType.fileType)) {
            return true;
        }
        return false;
    }

    private static String processPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(FILE_URL_PREFIX)) {
            str = str.substring(7);
        }
        String str2 = File.separator;
        if (!str.startsWith(str2)) {
            return str2 + str;
        }
        return str;
    }

    private static Bitmap queryVideoThumbnail(Context context, String str) {
        Cursor cursor = null;
        r0 = null;
        r0 = null;
        Bitmap thumbnail = null;
        if (context == null) {
            return null;
        }
        try {
            Cursor query = ContactsMonitor.query(context.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, PROJECTION_VIDEO, "_data='" + processPath(str) + "' COLLATE NOCASE", null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
                        if (query.moveToFirst()) {
                            thumbnail = MediaStore.Video.Thumbnails.getThumbnail(context.getContentResolver(), query.getLong(columnIndexOrThrow), 1, null);
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return thumbnail;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0070, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
    
        if (r9 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String queryVideoThumbnailFilePath(Context context, String str) {
        Cursor cursor;
        String str2 = null;
        if (context == null) {
            return null;
        }
        try {
            cursor = ContactsMonitor.query(context.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, PROJECTION_VIDEO, "_data='" + processPath(str) + "' COLLATE NOCASE", null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                        if (cursor.moveToFirst()) {
                            str2 = queryVideoThumbnailFilePath(context, cursor.getLong(columnIndexOrThrow));
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        ImageManagerLog.e(TAG, "queryVideoThumbnailFilePath fail: " + th);
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        if (r9 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0043, code lost:
    
        if (r9 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0045, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0067, code lost:
    
        return r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String queryVideoThumbnailFilePath(Context context, long j3) {
        Cursor cursor;
        ?? r16 = 0;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        String str = null;
        try {
            try {
                cursor = ContactsMonitor.query(context.getContentResolver(), MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"video_id", "_data"}, "video_id=" + j3, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                            if (cursor.moveToFirst()) {
                                str = cursor.getString(columnIndexOrThrow);
                            }
                        }
                    } catch (Exception e16) {
                        e = e16;
                        ImageManagerLog.e(TAG, "queryVideoThumbnailFilePath fail: " + e);
                    }
                }
            } catch (Exception e17) {
                e = e17;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (r16 != 0) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            r16 = context;
            if (r16 != 0) {
                r16.close();
            }
            throw th;
        }
    }
}
