package com.tencent.biz.qqstory.utils;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {
    public static void a(Context context, File file) {
        FileProvider7Helper.savePhotoToSysAlbum(context, file);
    }

    public static void b(Context context, File file) {
        try {
            context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, s(context, file));
        } catch (Exception e16) {
            hd0.c.u("Q.qqstory:Utils", "exception", e16);
        }
        a(context, file);
    }

    public static boolean c(String str) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return true;
        }
        hd0.c.v("Q.qqstory:Utils", "mkdirs failed, path:%s", str);
        return false;
    }

    public static boolean d(String str) {
        return FileUtils.fileExists(str);
    }

    public static boolean e(File file, File file2) {
        FileInputStream fileInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (IOException unused) {
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (IOException unused2) {
            fileInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (-1 == read) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
            }
            bufferedOutputStream.flush();
            try {
                bufferedOutputStream.close();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            return true;
        } catch (IOException unused3) {
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
            if (fileInputStream == null) {
                return false;
            }
            try {
                fileInputStream.close();
                return false;
            } catch (Exception e19) {
                e19.printStackTrace();
                return false;
            }
        } catch (Throwable th7) {
            th = th7;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e26) {
                    e26.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    throw th;
                } catch (Exception e27) {
                    e27.printStackTrace();
                    throw th;
                }
            }
            throw th;
        }
    }

    public static boolean f(String str, String str2) {
        return FileUtils.copyFile(str, str2);
    }

    public static File g(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public static void h(File file) {
        hd0.c.t("Q.qqstory:Utils", "delete " + file);
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    h(file2);
                }
                file.delete();
                return;
            }
            file.delete();
        }
    }

    public static boolean i(String str) {
        if (StringUtil.isEmpty(str)) {
            hd0.c.t("Q.qqstory:Utils", "save from: delete path null");
            return false;
        }
        FileUtils.deleteFile(str);
        hd0.c.v("Q.qqstory:Utils", "deleteFile %s", str);
        return true;
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.indexOf("assets") < 0 && !new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static boolean k(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    public static String l(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        int lastIndexOf2 = str.lastIndexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (lastIndexOf == -1 || lastIndexOf == str.length() - 1) {
            return null;
        }
        if (lastIndexOf2 > lastIndexOf) {
            return str.substring(lastIndexOf + 1, lastIndexOf2);
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String m(String str) {
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf("/");
        int lastIndexOf2 = str.lastIndexOf(".");
        if (lastIndexOf <= 0 || lastIndexOf2 <= lastIndexOf) {
            return "";
        }
        return str.substring(lastIndexOf + 1, lastIndexOf2);
    }

    public static String n(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("/");
        int lastIndexOf2 = str.lastIndexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (lastIndexOf == -1 || lastIndexOf == str.length() - 1) {
            return null;
        }
        if (lastIndexOf2 > lastIndexOf) {
            return str.substring(lastIndexOf + 1, lastIndexOf2);
        }
        return str.substring(lastIndexOf + 1);
    }

    public static long o(String str) {
        try {
            return new File(str).length();
        } catch (Exception e16) {
            hd0.c.w("Q.qqstory:Utils", e16, "", new Object[0]);
            return -1L;
        }
    }

    @TargetApi(10)
    public static int[] p(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
                int[] iArr = new int[3];
                if (extractMetadata == null) {
                    extractMetadata = "0";
                }
                iArr[0] = Integer.valueOf(extractMetadata).intValue();
                iArr[1] = Integer.valueOf(extractMetadata2).intValue();
                iArr[2] = Integer.valueOf(extractMetadata3).intValue();
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e16) {
                    hd0.c.t("Q.qqstory:Utils", "retriever.release error" + e16);
                }
                return iArr;
            } catch (Exception e17) {
                hd0.c.u("Q.qqstory:Utils", "exception", e17);
                try {
                    mediaMetadataRetriever.release();
                    return null;
                } catch (RuntimeException e18) {
                    hd0.c.t("Q.qqstory:Utils", "retriever.release error" + e18);
                    return null;
                }
            }
        } catch (Throwable th5) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException e19) {
                hd0.c.t("Q.qqstory:Utils", "retriever.release error" + e19);
            }
            throw th5;
        }
    }

    public static String q() {
        String path;
        if (cu.e()) {
            path = BaseApplication.getContext().getExternalCacheDir().getPath();
        } else {
            path = BaseApplication.getContext().getCacheDir().getPath();
        }
        return path + File.separator + "tencent/qq/music/";
    }

    public static long r() {
        return FileUtils.getAvailableExternalMemorySize();
    }

    public static ContentValues s(Context context, File file) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", file.getName());
        contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, file.getName());
        contentValues.put(JobDbManager.COL_UP_MIME_TYPE, "video/mp4");
        contentValues.put("datetaken", Long.valueOf(file.lastModified()));
        contentValues.put("date_modified", Long.valueOf(file.lastModified()));
        contentValues.put("date_added", Long.valueOf(file.lastModified()));
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        return contentValues;
    }

    public static void t(String str) {
        String str2 = str + "/dont_delete.txt";
        if (!k(str2)) {
            c(str);
            hd0.c.v("Q.qqstory:Utils", "make flag file %b", Boolean.valueOf(FileUtils.writeFile(str2, String.valueOf(System.currentTimeMillis()))));
        } else {
            hd0.c.t("Q.qqstory:Utils", "flag file exist");
        }
    }

    public static boolean u(String str, String str2) {
        return FileUtils.moveFile(str, str2);
    }

    public static boolean v(String str) {
        FileUtils.deleteDirectory(str);
        hd0.c.t("Q.qqstory:Utils", "removeAllFiles " + str);
        return true;
    }

    public static boolean w(String str, String str2) {
        return FileUtils.rename(str, str2);
    }

    public static boolean x(Context context, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(str2);
        String parent = file2.getParent();
        if (parent != null) {
            c(parent);
        }
        hd0.c.k("Q.qqstory:Utils", "saveVideoToAlbum: " + e(file, file2));
        a(context, file2);
        return true;
    }

    public static boolean y(String str) {
        if (StringUtil.isEmpty(str)) {
            hd0.c.t("Q.qqstory:Utils", "save from: delete path null");
            return false;
        }
        FileUtils.deleteFile(str);
        hd0.c.v("Q.qqstory:Utils", "tryDeleteFile %s", str);
        return true;
    }

    public static long z(String str) {
        byte[] readFile = FileUtils.readFile(str + "/dont_delete.txt");
        if (readFile == null) {
            return 0L;
        }
        try {
            return Long.valueOf(new String(readFile).trim().replaceAll("[\n\r]", "")).longValue();
        } catch (Exception e16) {
            hd0.c.u("Q.qqstory:Utils", "exception", e16);
            return 0L;
        }
    }
}
