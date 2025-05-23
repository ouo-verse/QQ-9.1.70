package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes12.dex */
public class am {
    public static String a(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str3 = File.separator;
        if (str.endsWith(str3)) {
            str3 = "";
        }
        sb5.append(str3);
        sb5.append(str2);
        return sb5.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0050, code lost:
    
        if (r3 == null) goto L38;
     */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(File file, File file2) {
        FileInputStream fileInputStream;
        if (file.isFile()) {
            FileOutputStream fileOutputStream = null;
            try {
                if (file2.exists()) {
                    file2.delete();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        }
                        fileOutputStream2.flush();
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused) {
                        }
                    } catch (IOException unused2) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                throw th;
                            } catch (IOException unused5) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused6) {
                    fileInputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream = null;
                }
            } catch (IOException unused7) {
                fileInputStream = null;
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = null;
            }
            try {
                fileInputStream.close();
            } catch (IOException unused8) {
            }
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            file2.mkdir();
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                b(listFiles[i3].getAbsoluteFile(), new File(file2.getAbsoluteFile() + File.separator + listFiles[i3].getName()));
            }
            return true;
        }
        return true;
    }

    public static boolean c(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                c(file2);
            }
        }
        return file.delete();
    }

    public static boolean d(String str) {
        boolean z16 = false;
        if (str != null && str.length() > 0) {
            try {
                z16 = c(new File(str));
                if (z16) {
                    t(str);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Tools.delete", 2, "" + e16.getMessage());
                }
            }
        }
        return z16;
    }

    public static void e(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                c(file2);
            }
        }
    }

    public static boolean f(String str) {
        return FileUtils.fileExistsAndNotEmpty(str);
    }

    public static String g(long j3) {
        return com.tencent.mobileqq.utils.ao.a(j3);
    }

    public static String h(long j3, int i3) {
        return com.tencent.mobileqq.utils.ao.b(j3, i3);
    }

    public static Bitmap i(String str) {
        Bitmap bitmap = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeFile(str, options);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return bitmap;
        }
    }

    public static String j(String str) {
        if (str == null) {
            return "";
        }
        if (str.endsWith(".rename")) {
            String replace = str.replace(".rename", "");
            int lastIndexOf = replace.lastIndexOf(".");
            if (lastIndexOf == -1) {
                return "";
            }
            if (replace.substring(lastIndexOf).replaceAll("[0-9]*", "").replace("(", "").replace(")", "").equalsIgnoreCase(".apk")) {
                return ".apk.rename";
            }
        }
        int lastIndexOf2 = str.lastIndexOf(".");
        if (lastIndexOf2 < 0) {
            return "";
        }
        return str.substring(lastIndexOf2);
    }

    public static String k(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf("/")) < 0) {
            return null;
        }
        return str.substring(0, lastIndexOf + 1);
    }

    public static FileInfo l(File file) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.y(file.getName());
        fileInfo.t(file.isDirectory());
        return fileInfo;
    }

    public static String m(String str) {
        int lastIndexOf;
        if (str != null && str.length() > 0 && (lastIndexOf = str.lastIndexOf(46)) > -1 && lastIndexOf < str.length()) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static long n(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            File file = new File(str);
            if (!file.exists() || file.length() <= 0) {
                return 0L;
            }
            return file.length();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("FileUtils", 2, s());
            }
            return 0L;
        }
    }

    public static ArrayList<FileInfo> o(String str, boolean z16, int i3) {
        File[] listFiles;
        ArrayList<FileInfo> arrayList = null;
        try {
            listFiles = new File(str).listFiles();
        } catch (Exception unused) {
        }
        if (listFiles == null) {
            return null;
        }
        arrayList = new ArrayList<>();
        for (File file : listFiles) {
            if ((z16 || !file.getName().startsWith(".")) && (file.isDirectory() || file.length() != 0)) {
                FileInfo fileInfo = new FileInfo();
                fileInfo.y(file.getName());
                fileInfo.t(file.isDirectory());
                fileInfo.z(file.getPath());
                fileInfo.A(file.length());
                fileInfo.r(file.lastModified());
                arrayList.add(fileInfo);
            }
        }
        if (i3 == 0) {
            Collections.sort(arrayList, new q.a());
        } else {
            Collections.sort(arrayList, new g());
        }
        return arrayList;
    }

    public static String p(Context context) {
        File file = new File(Utils.w(context) + "thumbnails/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static boolean q(String str) {
        return FileUtils.fileExists(str);
    }

    public static boolean r(File file, File file2) throws Exception {
        if (b(file, file2)) {
            c(file);
            return true;
        }
        return false;
    }

    public static synchronized String s() {
        String str;
        synchronized (am.class) {
            str = "";
            try {
                for (StackTraceElement stackTraceElement : Thread.getAllStackTraces().get(Thread.currentThread())) {
                    if (QLog.isColorLevel()) {
                        QLog.eAsync("FMERROR", 1, stackTraceElement.toString());
                    }
                    str = str + stackTraceElement.toString() + "\n";
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static void t(String str) {
        try {
            py3.b.e(BaseApplication.getContext().getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[]{str});
        } catch (Exception unused) {
        }
    }

    public static boolean u(Bitmap bitmap, String str) throws IOException, FileNotFoundException {
        return v(bitmap, str, Bitmap.CompressFormat.JPEG);
    }

    public static boolean v(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) throws IOException, FileNotFoundException {
        if (bitmap != null && str != null) {
            BufferedOutputStream bufferedOutputStream = null;
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str), 1048576);
                try {
                    boolean compress = bitmap.compress(compressFormat, 70, bufferedOutputStream2);
                    try {
                        bufferedOutputStream2.flush();
                    } catch (IOException unused) {
                    }
                    bufferedOutputStream2.close();
                    return compress;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.flush();
                        } catch (IOException unused2) {
                        }
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            return false;
        }
    }
}
