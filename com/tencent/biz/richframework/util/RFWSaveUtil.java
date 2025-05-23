package com.tencent.biz.richframework.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.media.MediaType;
import com.tencent.biz.richframework.media.uri.FileUriHandler;
import com.tencent.biz.richframework.media.uri.RFWMediaUriHelper;
import com.tencent.biz.richframework.media.uri.UriWrapper;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWSaveUtil {
    public static boolean checkSavePermission(Context context) {
        if (ContextCompat.checkSelfPermission(context, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean copyMediaFileToDownload(Context context, File file, String str) {
        if (file != null && !TextUtils.isEmpty(str)) {
            boolean copyFile = RFWFileUtils.copyFile(file, new File(str));
            if (copyFile) {
                scannerImage(context, str, null);
            }
            RFWLog.d("RFWSaveUtil", RFWLog.USR, "[copyMediaFileToDownload], result: " + copyFile + ", destPath: " + str);
            return copyFile;
        }
        RFWLog.e("RFWSaveUtil", RFWLog.USR, "[copyMediaFileToDownload], file is null.");
        return false;
    }

    public static Pair<String, String> generateSaveFileName(File file, boolean z16, String str, long j3, String str2, String str3, String str4) {
        String str5;
        if (z16 && file != null && !TextUtils.isEmpty(file.getName())) {
            str5 = file.getName();
        } else {
            str5 = str + j3;
        }
        int lastIndexOf = str5.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str5 = str5.substring(0, lastIndexOf);
        }
        if (TextUtils.isEmpty(str5)) {
            str5 = str + j3;
        }
        String str6 = str2 + str3;
        File file2 = new File(str6);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String generateUniqueFileName = RFWFileUtils.generateUniqueFileName(str6, str5, str4);
        return new Pair<>(generateUniqueFileName, str6 + File.separator + generateUniqueFileName + "." + str4);
    }

    public static void insertMedia(Context context, String str, boolean z16, Consumer<RFWSaveMediaResultBean> consumer) {
        insertMedia(context, str, RFWAppUtil.INSTANCE.getAppName(), z16, consumer);
    }

    private static void insertMediaInner(final Context context, final File file, final String str, final boolean z16, final Consumer<RFWSaveMediaResultBean> consumer) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.richframework.util.RFWSaveUtil.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                Uri uri;
                RFWMediaUriHelper rFWMediaUriHelper = new RFWMediaUriHelper();
                MediaType mediaType = MediaType.UNKNOWN;
                UriWrapper mediaUri = rFWMediaUriHelper.getMediaUri(context, file, str, z16);
                String str2 = "";
                if (mediaUri != null && (uri = mediaUri.uri) != null) {
                    z17 = RFWSaveUtil.saveFileToMediaUri(context, uri, file);
                    if (z17) {
                        str2 = mediaUri.newMediaPath;
                        mediaType = mediaUri.mediaType;
                        RFWSaveUtil.scannerImage(context, str2, mediaUri.mimeType);
                    }
                } else {
                    z17 = false;
                }
                if (!z17) {
                    String downloadDestPath = FileUriHandler.getDownloadDestPath(str, file.getPath());
                    z17 = RFWSaveUtil.copyMediaFileToDownload(context, file, downloadDestPath);
                    if (z17) {
                        str2 = downloadDestPath;
                    }
                }
                if (consumer != null) {
                    RFWSaveMediaResultBean rFWSaveMediaResultBean = new RFWSaveMediaResultBean(z17, str2);
                    rFWSaveMediaResultBean.mediaType = mediaType;
                    consumer.accept(rFWSaveMediaResultBean);
                }
                RFWLog.d("RFWSaveUtil", RFWLog.USR, "[insertMediaInner] result: " + z17);
            }
        });
    }

    public static void saveBitmapAndInsertImage(Context context, Bitmap bitmap, String str, boolean z16, Consumer<RFWSaveMediaResultBean> consumer) {
        saveBitmapAndInsertImage(context, bitmap, str, "", z16, consumer);
    }

    public static boolean saveBitmapAsJpg(Bitmap bitmap, String str) {
        File createNewFile = RFWFileUtils.createNewFile(str);
        if (createNewFile == null) {
            RFWLog.w("RFWSaveUtil", RFWLog.USR, "[saveBitmapAsJpg] error, file=null, path=" + str);
            return false;
        }
        return saveBitmapWithCompressFormat(bitmap, createNewFile, Bitmap.CompressFormat.JPEG);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static boolean saveBitmapWithCompressFormat(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat) {
        ?? r06 = 0;
        r06 = 0;
        r06 = 0;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    bitmap.compress(compressFormat, 100, fileOutputStream2);
                    RFWIOUtil.flushAll(fileOutputStream2);
                    RFWIOUtil.closeAll(fileOutputStream2);
                    r06 = 1;
                } catch (IOException e16) {
                    e = e16;
                    fileOutputStream = fileOutputStream2;
                    RFWLog.e("RFWSaveUtil", RFWLog.USR, e.getMessage(), e);
                    RFWIOUtil.flushAll(fileOutputStream);
                    RFWIOUtil.closeAll(fileOutputStream);
                    return r06;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    Flushable[] flushableArr = new Flushable[1];
                    flushableArr[r06] = fileOutputStream;
                    RFWIOUtil.flushAll(flushableArr);
                    Closeable[] closeableArr = new Closeable[1];
                    closeableArr[r06] = fileOutputStream;
                    RFWIOUtil.closeAll(closeableArr);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
            return r06;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean saveFileToMediaUri(Context context, Uri uri, File file) {
        ParcelFileDescriptor parcelFileDescriptor;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        if (uri == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
            if (parcelFileDescriptor == null) {
                RFWIOUtil.flushAll(null);
                RFWIOUtil.closeAll(null, null, parcelFileDescriptor);
                return false;
            }
            try {
                fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e16) {
                    e = e16;
                    fileInputStream = null;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        RFWLog.fatal("RFWSaveUtil", RFWLog.USR, e);
                        RFWIOUtil.flushAll(fileOutputStream2);
                        RFWIOUtil.closeAll(fileInputStream, fileOutputStream2, parcelFileDescriptor);
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        RFWIOUtil.flushAll(fileOutputStream2);
                        RFWIOUtil.closeAll(fileInputStream, fileOutputStream2, parcelFileDescriptor);
                        throw th;
                    }
                } catch (SecurityException e17) {
                    e = e17;
                    fileInputStream = null;
                    fileOutputStream2 = fileOutputStream;
                    RFWLog.fatal("RFWSaveUtil", RFWLog.USR, e);
                    RFWIOUtil.flushAll(fileOutputStream2);
                    RFWIOUtil.closeAll(fileInputStream, fileOutputStream2, parcelFileDescriptor);
                    return false;
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream = null;
                }
            } catch (IOException e18) {
                e = e18;
                fileInputStream = null;
                RFWLog.fatal("RFWSaveUtil", RFWLog.USR, e);
                RFWIOUtil.flushAll(fileOutputStream2);
                RFWIOUtil.closeAll(fileInputStream, fileOutputStream2, parcelFileDescriptor);
                return false;
            } catch (SecurityException e19) {
                e = e19;
                fileInputStream = null;
                RFWLog.fatal("RFWSaveUtil", RFWLog.USR, e);
                RFWIOUtil.flushAll(fileOutputStream2);
                RFWIOUtil.closeAll(fileInputStream, fileOutputStream2, parcelFileDescriptor);
                return false;
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = null;
            }
            try {
                byte[] buf = ByteArrayPool.getGenericInstance().getBuf(4096);
                while (true) {
                    int read = fileInputStream.read(buf);
                    if (read != -1) {
                        fileOutputStream.write(buf, 0, read);
                    } else {
                        ByteArrayPool.getGenericInstance().returnBuf(buf);
                        RFWIOUtil.flushAll(fileOutputStream);
                        RFWIOUtil.closeAll(fileInputStream, fileOutputStream, parcelFileDescriptor);
                        return true;
                    }
                }
            } catch (IOException e26) {
                e = e26;
                fileOutputStream2 = fileOutputStream;
                RFWLog.fatal("RFWSaveUtil", RFWLog.USR, e);
                RFWIOUtil.flushAll(fileOutputStream2);
                RFWIOUtil.closeAll(fileInputStream, fileOutputStream2, parcelFileDescriptor);
                return false;
            } catch (SecurityException e27) {
                e = e27;
                fileOutputStream2 = fileOutputStream;
                RFWLog.fatal("RFWSaveUtil", RFWLog.USR, e);
                RFWIOUtil.flushAll(fileOutputStream2);
                RFWIOUtil.closeAll(fileInputStream, fileOutputStream2, parcelFileDescriptor);
                return false;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream2 = fileOutputStream;
                RFWIOUtil.flushAll(fileOutputStream2);
                RFWIOUtil.closeAll(fileInputStream, fileOutputStream2, parcelFileDescriptor);
                throw th;
            }
        } catch (IOException e28) {
            e = e28;
            parcelFileDescriptor = null;
            fileInputStream = null;
            RFWLog.fatal("RFWSaveUtil", RFWLog.USR, e);
            RFWIOUtil.flushAll(fileOutputStream2);
            RFWIOUtil.closeAll(fileInputStream, fileOutputStream2, parcelFileDescriptor);
            return false;
        } catch (SecurityException e29) {
            e = e29;
            parcelFileDescriptor = null;
            fileInputStream = null;
            RFWLog.fatal("RFWSaveUtil", RFWLog.USR, e);
            RFWIOUtil.flushAll(fileOutputStream2);
            RFWIOUtil.closeAll(fileInputStream, fileOutputStream2, parcelFileDescriptor);
            return false;
        } catch (Throwable th9) {
            th = th9;
            parcelFileDescriptor = null;
            fileInputStream = null;
        }
    }

    public static void scannerImage(Context context, String str, String str2) {
        String[] strArr;
        if (TextUtils.isEmpty(str)) {
            RFWLog.e("RFWSaveUtil", RFWLog.USR, "[scannerImage] filePath is empty.");
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            strArr = new String[]{str2};
        } else {
            strArr = null;
        }
        MediaScannerConnection.scanFile(context.getApplicationContext(), new String[]{str}, strArr, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.tencent.biz.richframework.util.RFWSaveUtil.2
            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str3, Uri uri) {
                RFWLog.i("RFWSaveUtil", RFWLog.USR, "ExternalStorage Scanned " + str3 + ": uri=" + uri);
            }
        });
    }

    public static void insertMedia(Context context, String str, Consumer<RFWSaveMediaResultBean> consumer) {
        insertMedia(context, str, RFWAppUtil.INSTANCE.getAppName(), false, consumer);
    }

    public static void saveBitmapAndInsertImage(Context context, Bitmap bitmap, String str, String str2, boolean z16, Consumer<RFWSaveMediaResultBean> consumer) {
        if (!checkSavePermission(context)) {
            if (consumer != null) {
                consumer.accept(new RFWSaveMediaResultBean(false, ""));
            }
            RFWLog.e("RFWSaveUtil", RFWLog.USR, "[saveBitmapAndInsertImage] error, no WRITE_EXTERNAL_STORAGE permission.");
            return;
        }
        File createNewFile = RFWFileUtils.createNewFile(str);
        if (createNewFile == null) {
            if (consumer != null) {
                consumer.accept(new RFWSaveMediaResultBean(false, ""));
            }
            RFWLog.e("RFWSaveUtil", RFWLog.USR, "[saveBitmapAndInsertImage] error, file path not exist.");
            return;
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(createNewFile));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            insertMediaInner(context, createNewFile, str2, z16, consumer);
        } catch (IOException e16) {
            if (consumer != null) {
                consumer.accept(new RFWSaveMediaResultBean(false, ""));
            }
            RFWLog.e("RFWSaveUtil", RFWLog.USR, e16.getMessage(), e16);
        }
    }

    public static void insertMedia(Context context, String str, String str2, boolean z16, Consumer<RFWSaveMediaResultBean> consumer) {
        if (TextUtils.isEmpty(str)) {
            if (consumer != null) {
                consumer.accept(new RFWSaveMediaResultBean(false, ""));
            }
            RFWLog.e("RFWSaveUtil", RFWLog.USR, "[insertMedia] error, mediaPath is null.");
        } else {
            if (!checkSavePermission(context)) {
                if (consumer != null) {
                    consumer.accept(new RFWSaveMediaResultBean(false, ""));
                }
                RFWLog.e("RFWSaveUtil", RFWLog.USR, "[insertMedia] error, no WRITE_EXTERNAL_STORAGE permission.");
                return;
            }
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e16) {
                    if (consumer != null) {
                        consumer.accept(new RFWSaveMediaResultBean(false, ""));
                    }
                    RFWLog.e("RFWSaveUtil", RFWLog.USR, e16.getMessage(), e16);
                }
            }
            insertMediaInner(context, file, str2, z16, consumer);
        }
    }
}
