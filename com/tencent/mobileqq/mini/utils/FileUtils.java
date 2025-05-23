package com.tencent.mobileqq.mini.utils;

import android.system.Os;
import android.system.StructStat;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class FileUtils {
    private static final String TAG = "[mini] FileUtils";

    public static String getFileExtension(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) <= 0) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String getFileExtensionWithDot(String str) {
        String fileExtension = getFileExtension(str);
        if (TextUtils.isEmpty(fileExtension)) {
            return "";
        }
        return "." + fileExtension;
    }

    public static JSONObject getStats(String str) {
        try {
            StructStat stat = Os.stat(str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mode", stat.st_mode);
            jSONObject.put("size", stat.st_size);
            jSONObject.put("lastAccessedTime", stat.st_atime);
            jSONObject.put("lastModifiedTime", stat.st_mtime);
            return jSONObject;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getStats error. " + e16);
            return null;
        }
    }

    public static JSONObject getStatsByDir(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("/", getStats(str));
            ArrayList<String> childFiles = com.tencent.mobileqq.utils.FileUtils.getChildFiles(str, true);
            String str2 = new File(str).getCanonicalPath() + "/";
            Iterator<String> it = childFiles.iterator();
            while (it.hasNext()) {
                String next = it.next();
                jSONObject.put(next.replace(str2, ""), getStats(next));
            }
            return jSONObject;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getStatsByDir error. " + e16);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readFileFromAssets(String str) {
        Throwable th5;
        InputStream inputStream;
        try {
            inputStream = BaseApplication.getContext().getAssets().open(str);
        } catch (Exception e16) {
            e = e16;
            inputStream = null;
        } catch (Throwable th6) {
            th5 = th6;
            inputStream = null;
            if (inputStream != null) {
            }
            throw th5;
        }
        try {
            try {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                String str2 = new String(bArr, "utf8");
                try {
                    inputStream.close();
                } catch (IOException e17) {
                    QLog.e("FileUtils", 1, "readFileFromAssets close error. " + e17);
                }
                return str2;
            } catch (Throwable th7) {
                th5 = th7;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e18) {
                        QLog.e("FileUtils", 1, "readFileFromAssets close error. " + e18);
                    }
                }
                throw th5;
            }
        } catch (Exception e19) {
            e = e19;
            QLog.e("FileUtils", 1, "readFileFromAssets error. " + e);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e26) {
                    QLog.e("FileUtils", 1, "readFileFromAssets close error. " + e26);
                }
            }
            return null;
        }
    }

    public static boolean renameFile(File file, File file2) {
        boolean delete = file2.exists() ? file2.delete() : true;
        return delete ? file.renameTo(file2) : delete;
    }

    public static boolean writeFile(String str, String str2) {
        boolean z16;
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException unused) {
                z16 = false;
            }
        }
        z16 = true;
        try {
            fileOutputStream = new FileOutputStream(file, false);
        } catch (FileNotFoundException unused2) {
            fileOutputStream = null;
            z16 = false;
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.write(str2.getBytes());
            } catch (IOException unused3) {
                z16 = false;
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException unused4) {
                z16 = false;
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException unused5) {
                return false;
            }
        }
        return z16;
    }

    public static void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public static String readFileToStr(File file) {
        if (file == null) {
            return null;
        }
        try {
            if (file.exists()) {
                return readFileToString(file);
            }
            return null;
        } catch (Throwable th5) {
            QLog.e(TAG, 2, "readFileToStr", th5);
            return "";
        }
    }

    public static void delete(String str, boolean z16) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                delete(file2.getAbsolutePath(), z16);
            }
            if (z16) {
                return;
            }
            file.delete();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0079, code lost:
    
        if (r2 == null) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readFileToString(File file) throws IOException {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        r0 = null;
        String str = null;
        if (file == null) {
            return null;
        }
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                        } catch (Exception unused) {
                            inputStreamReader = null;
                        } catch (Throwable th5) {
                            th = th5;
                            inputStreamReader = null;
                        }
                        try {
                            int length = (int) file.length();
                            if (length > 12288) {
                                char[] cArr = new char[4096];
                                StringBuilder sb5 = new StringBuilder(12288);
                                while (true) {
                                    int read = inputStreamReader.read(cArr);
                                    if (-1 == read) {
                                        break;
                                    }
                                    sb5.append(cArr, 0, read);
                                }
                                str = sb5.toString();
                            } else {
                                char[] cArr2 = new char[length];
                                str = new String(cArr2, 0, inputStreamReader.read(cArr2));
                            }
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                            }
                        } catch (Exception unused3) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception unused4) {
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception unused5) {
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                    throw th;
                                } catch (Exception unused6) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Exception unused7) {
                        fileInputStream = null;
                        inputStreamReader = null;
                    } catch (Throwable th7) {
                        th = th7;
                        inputStreamReader = null;
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Exception unused8) {
                        return str;
                    }
                } else {
                    throw new IOException("File '" + file + "' cannot be read");
                }
            } else {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
        } else {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
    }
}
