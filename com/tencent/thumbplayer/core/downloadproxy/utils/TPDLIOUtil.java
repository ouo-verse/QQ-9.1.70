package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.content.Context;
import android.os.Environment;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes26.dex */
public class TPDLIOUtil {
    private static final String FILE_NAME = "TPDLIOUtil";
    private static final String PROTOCOL_ASSET = "asset";
    private static final String PROTOCOL_FILE = "file";
    private static final String PROTOCOL_HTTP = "http";
    private static final String PROTOCOL_HTTPS = "https";
    private static final Pattern PROTOCOL_PATTERN = Pattern.compile("^(\\w+):/{2,3}");
    private static final Pattern PATH_PATTERN = Pattern.compile("^(\\w+):/{2,3}(.*)");

    public static File compare(File file, File file2) {
        if (file == null) {
            return file2;
        }
        if (file2 != null && file2.exists()) {
            if (!file.exists()) {
                return file2;
            }
            if (file.lastModified() <= file2.lastModified()) {
                return file2;
            }
            return file;
        }
        return file;
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null || outputStream == null) {
            return 0;
        }
        byte[] bArr = new byte[1024];
        int i3 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                i3 += read;
            } catch (IOException unused) {
            }
        }
        return i3;
    }

    public static boolean createFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        if (!createParentDirectories(file)) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean createParentDirectories(File file) {
        if (file == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists()) {
            return true;
        }
        return parentFile.mkdirs();
    }

    public static String getPath(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = PATH_PATTERN.matcher(str);
        if (matcher.find() && matcher.group(1).equals(PROTOCOL_ASSET)) {
            return matcher.group(2);
        }
        return str;
    }

    public static String getProtocol(String str) {
        if (str != null && str.length() > 0) {
            Matcher matcher = PROTOCOL_PATTERN.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return "file";
    }

    public static boolean isExternalStorageMounted() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean isRemoteFile(String str) {
        String protocol2 = getProtocol(str);
        if (!protocol2.equals("https") && !protocol2.equals("http")) {
            return false;
        }
        return true;
    }

    public static InputStream open(Context context, String str) {
        String protocol2 = getProtocol(str);
        if (protocol2.equals(PROTOCOL_ASSET)) {
            try {
                return context.getAssets().open(getPath(str));
            } catch (IOException unused) {
                return null;
            }
        }
        if (protocol2.equals("file")) {
            try {
                return new FileInputStream(getPath(str));
            } catch (Exception unused2) {
                return null;
            }
        }
        if (!protocol2.equals("http") && !protocol2.equals("https")) {
            return null;
        }
        try {
            return new URL(str).openStream();
        } catch (Exception unused3) {
            return null;
        }
    }

    public static InputStream openInputStream(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return openInputStream(new File(str));
    }

    public static OutputStream openOutputStream(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return openOutputStream(new File(str));
    }

    public static void recursiveDelete(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null) {
                            return;
                        }
                        for (File file2 : listFiles) {
                            recursiveDelete(file2);
                        }
                    }
                    TPDLProxyLog.d(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "recursiveDelete: delete=" + file.delete());
                }
            } catch (Exception e16) {
                TPDLProxyLog.d(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "recursiveDelete failed, error:" + e16);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        if (r6.createNewFile() == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean write(File file, byte[] bArr, int i3, int i16) {
        if (file != null && bArr != null && bArr.length > 0) {
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.mkdirs()) {
                    return false;
                }
            }
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr, i3, i16);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e16) {
                        TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "write error:" + e16);
                        return true;
                    }
                } catch (Exception unused) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e17) {
                            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "write error:" + e17);
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e18) {
                            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "write error:" + e18);
                        }
                    }
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return false;
        return false;
    }

    public static int copy(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        if (file == null || file2 == null || !file.exists()) {
            return 0;
        }
        if (!file2.exists()) {
            File parentFile = file2.getParentFile();
            if (parentFile == null) {
                return 0;
            }
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                return 0;
            }
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (FileNotFoundException unused) {
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
        } catch (FileNotFoundException unused2) {
            fileOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
        }
        try {
            int copy = copy(fileInputStream, fileOutputStream);
            try {
                fileInputStream.close();
            } catch (IOException unused3) {
            }
            try {
                fileOutputStream.close();
            } catch (IOException unused4) {
            }
            return copy;
        } catch (FileNotFoundException unused5) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused6) {
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused7) {
                }
            }
            return 0;
        } catch (Throwable th7) {
            th = th7;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused8) {
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                    throw th;
                } catch (IOException unused9) {
                    throw th;
                }
            }
            throw th;
        }
    }

    public static InputStream openInputStream(File file) {
        if (file == null) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public static OutputStream openOutputStream(File file) {
        if (file != null && createFile(file)) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    public static boolean createFile(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return createFile(new File(str));
    }

    public static boolean createParentDirectories(String str) {
        return createParentDirectories(new File(str));
    }
}
