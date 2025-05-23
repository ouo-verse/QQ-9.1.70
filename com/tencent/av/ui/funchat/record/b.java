package com.tencent.av.ui.funchat.record;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import com.tencent.av.utils.ak;
import com.tencent.biz.richframework.util.ByteArrayPool;
import com.tencent.biz.richframework.util.RFWIOUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f75864a = ".mp4";

    public static long a(File file) throws Exception {
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            long available = fileInputStream.available();
            fileInputStream.close();
            return available;
        }
        QLog.e("FileSwapHelper", 1, "\u83b7\u53d6\u6587\u4ef6\u5927\u5c0f", "\u6587\u4ef6\u4e0d\u5b58\u5728!");
        return 0L;
    }

    public static String b() {
        String str = ((BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + "/QQVideo/") + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis()))) + f75864a;
        File parentFile = new File(str).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        return str;
    }

    public static long c() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        try {
            StatFs statFs = new StatFs(externalStorageDirectory.getPath());
            long blockSize = statFs.getBlockSize();
            long availableBlocks = statFs.getAvailableBlocks();
            if (QLog.isColorLevel()) {
                QLog.d("FileSwapHelper", 2, "getStorageLeft left=" + (blockSize * availableBlocks));
            }
            return blockSize * availableBlocks;
        } catch (Throwable th5) {
            QLog.e("FileSwapHelper", 1, "getSpaceLeft exception:" + th5 + ", path=" + externalStorageDirectory, th5);
            return TTL.MAX_VALUE;
        }
    }

    private static void d(String str, File file) {
        if (str != null && !file.exists()) {
            File file2 = new File(str);
            if (file2.exists()) {
                FileUtils.copyFile(file2, file);
                file2.delete();
            }
        }
    }

    public static void e(String str, Context context) {
        if (QLog.isColorLevel()) {
            QLog.d("FileSwapHelper", 2, "notifyMp4Saved=" + str);
        }
        if (str == null) {
            return;
        }
        String replace = str.replace(BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath(), Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
        boolean c16 = ak.c("qav_rtc_record_save_file", "save_file_old_version", false);
        if (c16) {
            File file = new File(replace);
            d(str, file);
            com.tencent.biz.qqstory.utils.d.b(context, file);
        } else {
            g(str, replace, context);
        }
        QLog.d("FileSwapHelper", 1, "notifyMp4Saved useOldVersion=" + c16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r11v23, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10, types: [android.os.ParcelFileDescriptor] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v7 */
    private static boolean f(Context context, Uri uri, File file) {
        FileInputStream fileInputStream;
        Closeable closeable;
        Closeable closeable2;
        if (uri == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                context = context.getContentResolver().openFileDescriptor(uri, "rw");
                if (context == 0) {
                    RFWIOUtil.flushAll(null);
                    RFWIOUtil.closeAll(new Closeable[]{0, 0, context});
                    return false;
                }
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(context.getFileDescriptor());
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (IOException e16) {
                        e = e16;
                        fileInputStream = null;
                    } catch (SecurityException e17) {
                        e = e17;
                        fileInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = null;
                    }
                    try {
                        byte[] buf = ByteArrayPool.getGenericInstance().getBuf(4096);
                        int i3 = 0;
                        while (i3 != -1) {
                            i3 = fileInputStream.read(buf);
                            if (i3 != -1) {
                                fileOutputStream2.write(buf, 0, i3);
                            }
                        }
                        ByteArrayPool.getGenericInstance().returnBuf(buf);
                        RFWIOUtil.flushAll(fileOutputStream2);
                        RFWIOUtil.closeAll(new Closeable[]{fileInputStream, fileOutputStream2, context});
                        return true;
                    } catch (IOException e18) {
                        e = e18;
                        fileOutputStream = fileOutputStream2;
                        closeable2 = context;
                        QLog.e("FileSwapHelper", 1, "saveFileToMediaUri: " + e);
                        RFWIOUtil.flushAll(fileOutputStream);
                        RFWIOUtil.closeAll(fileInputStream, fileOutputStream, closeable2);
                        context = closeable2;
                        return false;
                    } catch (SecurityException e19) {
                        e = e19;
                        fileOutputStream = fileOutputStream2;
                        closeable = context;
                        QLog.e("FileSwapHelper", 1, "saveFileToMediaUri: " + e);
                        RFWIOUtil.flushAll(fileOutputStream);
                        RFWIOUtil.closeAll(fileInputStream, fileOutputStream, closeable);
                        context = closeable;
                        return false;
                    } catch (Throwable th6) {
                        th = th6;
                        fileOutputStream = fileOutputStream2;
                        RFWIOUtil.flushAll(fileOutputStream);
                        RFWIOUtil.closeAll(new Closeable[]{fileInputStream, fileOutputStream, context});
                        throw th;
                    }
                } catch (IOException e26) {
                    e = e26;
                    fileInputStream = null;
                    closeable2 = context;
                } catch (SecurityException e27) {
                    e = e27;
                    fileInputStream = null;
                    closeable = context;
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream = null;
                }
            } catch (IOException e28) {
                e = e28;
                closeable2 = null;
                fileInputStream = null;
            } catch (SecurityException e29) {
                e = e29;
                closeable = null;
                fileInputStream = null;
            } catch (Throwable th8) {
                th = th8;
                context = 0;
                fileInputStream = null;
            }
        } catch (Throwable th9) {
            th = th9;
        }
    }

    private static void g(String str, String str2, Context context) {
        ContentValues contentValues = new ContentValues();
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(str);
        String name = file.getName();
        contentValues.put("title", name);
        contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, name);
        contentValues.put("_size", Long.valueOf(file.length()));
        contentValues.put(JobDbManager.COL_UP_MIME_TYPE, "video");
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        contentValues.put("description", name);
        if (Build.VERSION.SDK_INT < 29) {
            contentValues.put("_data", str2);
        } else {
            contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
            StringBuilder sb5 = new StringBuilder();
            sb5.append(Environment.DIRECTORY_DCIM);
            String str3 = File.separator;
            sb5.append(str3);
            sb5.append("QQVideo");
            sb5.append(str3);
            contentValues.put("relative_path", sb5.toString());
        }
        f(context, context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues), file);
        QLog.d("FileSwapHelper", 1, "saveMediaFile.....");
    }
}
