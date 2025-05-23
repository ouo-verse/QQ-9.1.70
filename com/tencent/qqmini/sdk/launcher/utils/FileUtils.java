package com.tencent.qqmini.sdk.launcher.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FileUtils {
    private static final String TAG = "FileUtils";

    public static boolean copyFile(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            try {
                return copyFile(file, createFile(str2));
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public static File createFile(String str) throws IOException {
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

    public static void delete(String str, boolean z16) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
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
        if (!z16) {
            file.delete();
        }
    }

    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                deleteFile(file2);
            }
        }
        return file.delete();
    }

    public static String readFileToStr(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return readFileToString(file);
                }
                return null;
            } catch (Throwable th5) {
                th5.printStackTrace();
                return "";
            }
        }
        return null;
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

    public static boolean rename(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        return file.renameTo(new File(str2));
    }

    public static boolean writeFile(String str, byte[] bArr) {
        return writeFile(str, bArr, false);
    }

    public static boolean writeFile(String str, byte[] bArr, boolean z16) {
        return writeFile(str, bArr, z16, bArr.length);
    }

    public static boolean writeFile(String str, byte[] bArr, boolean z16, int i3) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        boolean z17 = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file, z16);
            } catch (IOException unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                fileOutputStream.write(bArr, 0, i3);
                fileOutputStream.flush();
                fileOutputStream.close();
                z17 = true;
            } catch (IOException unused2) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return z17;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException unused4) {
        }
        return z17;
    }

    public static boolean copyFile(File file, File file2) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream = null;
        try {
            if (file2.exists()) {
                file2.delete();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                            fileOutputStream2.flush();
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    }
                    fileOutputStream2.close();
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused2) {
                    }
                    return true;
                } catch (IOException unused3) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (bufferedInputStream == null) {
                        return false;
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused5) {
                        return false;
                    }
                } catch (OutOfMemoryError unused6) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (bufferedInputStream == null) {
                        return false;
                    }
                    bufferedInputStream.close();
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused8) {
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            throw th;
                        } catch (IOException unused9) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (IOException unused10) {
                bufferedInputStream = null;
            } catch (OutOfMemoryError unused11) {
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = null;
            }
        } catch (IOException unused12) {
            bufferedInputStream = null;
        } catch (OutOfMemoryError unused13) {
            bufferedInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            bufferedInputStream = null;
        }
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
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

    public static boolean writeFile(byte[] bArr, String str) {
        return writeFile(bArr, str, false);
    }

    public static boolean writeFile(byte[] bArr, String str, boolean z16) {
        return writeFile(bArr, str, z16, bArr.length);
    }

    public static boolean writeFile(byte[] bArr, String str, boolean z16, int i3) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        boolean z17 = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file, z16);
            } catch (IOException unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                fileOutputStream.write(bArr, 0, i3);
                fileOutputStream.flush();
                fileOutputStream.close();
                z17 = true;
            } catch (IOException unused2) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return z17;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException unused4) {
        }
        return z17;
    }
}
