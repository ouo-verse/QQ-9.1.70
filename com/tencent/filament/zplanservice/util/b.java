package com.tencent.filament.zplanservice.util;

import com.tencent.filament.zplanservice.util.log.FLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f106443a = "FileUtil";

    /* JADX WARN: Removed duplicated region for block: B:56:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(File file, File file2) {
        OutputStream outputStream;
        BufferedOutputStream bufferedOutputStream;
        IOException e16;
        FileInputStream fileInputStream;
        StringBuilder sb5;
        boolean z16;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                } catch (IOException e17) {
                    bufferedOutputStream = null;
                    e16 = e17;
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = null;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                    }
                    if (outputStream == null) {
                    }
                }
            } catch (IOException e18) {
                bufferedOutputStream = null;
                e16 = e18;
                fileInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e19) {
                        FLog.INSTANCE.e(f106443a, "copyFile fail. srcFilePath:" + file.getAbsolutePath() + ", dstFilePath:" + file2.getAbsolutePath() + ". ", e19);
                    }
                }
                if (outputStream == null) {
                    try {
                        outputStream.close();
                        throw th;
                    } catch (Exception e26) {
                        FLog.INSTANCE.e(f106443a, "copyFile fail. srcFilePath:" + file.getAbsolutePath() + ", dstFilePath:" + file2.getAbsolutePath() + ". ", e26);
                        throw th;
                    }
                }
                throw th;
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
                    fileInputStream.close();
                    z16 = true;
                } catch (Exception e27) {
                    FLog.INSTANCE.e(f106443a, "copyFile fail. srcFilePath:" + file.getAbsolutePath() + ", dstFilePath:" + file2.getAbsolutePath() + ". ", e27);
                    z16 = false;
                }
                try {
                    bufferedOutputStream.close();
                    return z16;
                } catch (Exception e28) {
                    e = e28;
                    sb5 = new StringBuilder();
                    sb5.append("copyFile fail. srcFilePath:");
                    sb5.append(file.getAbsolutePath());
                    sb5.append(", dstFilePath:");
                    sb5.append(file2.getAbsolutePath());
                    sb5.append(". ");
                    FLog.INSTANCE.e(f106443a, sb5.toString(), e);
                    return false;
                }
            } catch (IOException e29) {
                e16 = e29;
                FLog.INSTANCE.e(f106443a, "copyFile fail. srcFilePath:" + file.getAbsolutePath() + ", dstFilePath:" + file2.getAbsolutePath() + ". ", e16);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e36) {
                        FLog.INSTANCE.e(f106443a, "copyFile fail. srcFilePath:" + file.getAbsolutePath() + ", dstFilePath:" + file2.getAbsolutePath() + ". ", e36);
                    }
                }
                if (bufferedOutputStream == null) {
                    return false;
                }
                try {
                    bufferedOutputStream.close();
                    return false;
                } catch (Exception e37) {
                    e = e37;
                    sb5 = new StringBuilder();
                    sb5.append("copyFile fail. srcFilePath:");
                    sb5.append(file.getAbsolutePath());
                    sb5.append(", dstFilePath:");
                    sb5.append(file2.getAbsolutePath());
                    sb5.append(". ");
                    FLog.INSTANCE.e(f106443a, sb5.toString(), e);
                    return false;
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static String b(File file) throws IOException {
        InputStreamReader inputStreamReader;
        StringBuilder sb5;
        String str = null;
        if (file == null) {
            return null;
        }
        ?? r46 = "File '";
        if (file.exists()) {
            if (!file.isDirectory()) {
                ?? canRead = file.canRead();
                try {
                    if (canRead != 0) {
                        try {
                            canRead = new FileInputStream(file);
                        } catch (Exception e16) {
                            e = e16;
                            canRead = 0;
                            inputStreamReader = null;
                        } catch (Throwable th5) {
                            r46 = 0;
                            th = th5;
                            canRead = 0;
                        }
                        try {
                            inputStreamReader = new InputStreamReader((InputStream) canRead, "UTF-8");
                        } catch (Exception e17) {
                            e = e17;
                            inputStreamReader = null;
                        } catch (Throwable th6) {
                            r46 = 0;
                            th = th6;
                            if (canRead != 0) {
                                try {
                                    canRead.close();
                                } catch (Exception e18) {
                                    FLog.INSTANCE.e(f106443a, "readFileToString fail. filePath:" + file.getAbsolutePath() + ". ", e18);
                                }
                            }
                            if (r46 != 0) {
                                try {
                                    r46.close();
                                    throw th;
                                } catch (Exception e19) {
                                    FLog.INSTANCE.e(f106443a, "readFileToString fail. filePath:" + file.getAbsolutePath() + ". ", e19);
                                    throw th;
                                }
                            }
                            throw th;
                        }
                        try {
                            int length = (int) file.length();
                            if (length > 12288) {
                                char[] cArr = new char[4096];
                                StringBuilder sb6 = new StringBuilder(length);
                                while (true) {
                                    int read = inputStreamReader.read(cArr);
                                    if (-1 == read) {
                                        break;
                                    }
                                    sb6.append(cArr, 0, read);
                                }
                                str = sb6.toString();
                            } else {
                                char[] cArr2 = new char[length];
                                str = new String(cArr2, 0, inputStreamReader.read(cArr2));
                            }
                            try {
                                canRead.close();
                            } catch (Exception e26) {
                                FLog.INSTANCE.e(f106443a, "readFileToString fail. filePath:" + file.getAbsolutePath() + ". ", e26);
                            }
                        } catch (Exception e27) {
                            e = e27;
                            FLog.INSTANCE.e(f106443a, "readFileToString fail. filePath:" + file.getAbsolutePath() + ". ", e);
                            if (canRead != 0) {
                                try {
                                    canRead.close();
                                } catch (Exception e28) {
                                    FLog.INSTANCE.e(f106443a, "readFileToString fail. filePath:" + file.getAbsolutePath() + ". ", e28);
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Exception e29) {
                                    e = e29;
                                    sb5 = new StringBuilder();
                                    sb5.append("readFileToString fail. filePath:");
                                    sb5.append(file.getAbsolutePath());
                                    sb5.append(". ");
                                    FLog.INSTANCE.e(f106443a, sb5.toString(), e);
                                    return str;
                                }
                            }
                            return str;
                        }
                        try {
                            inputStreamReader.close();
                        } catch (Exception e36) {
                            e = e36;
                            sb5 = new StringBuilder();
                            sb5.append("readFileToString fail. filePath:");
                            sb5.append(file.getAbsolutePath());
                            sb5.append(". ");
                            FLog.INSTANCE.e(f106443a, sb5.toString(), e);
                            return str;
                        }
                        return str;
                    }
                    throw new IOException("File '" + file + "' cannot be read");
                } catch (Throwable th7) {
                    th = th7;
                }
            } else {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
        } else {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(String str, String str2, String str3) {
        String str4;
        String str5;
        boolean z16;
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (str2 != null) {
            str4 = str2.replaceAll("[\\\\/*?<>:\"|]", "");
        } else {
            str4 = str2;
        }
        String str6 = File.separator;
        if (str.endsWith(str6)) {
            str5 = str + str4;
        } else {
            str5 = str + str6 + str4;
        }
        File file2 = new File(str5);
        if (!file.exists()) {
            z16 = file.mkdirs();
        } else {
            z16 = true;
        }
        if (file.exists()) {
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException e16) {
                    FLog.INSTANCE.e(f106443a, "writeFile fail. filePath:" + str + ", fileName:" + str2 + ". ", e16);
                    z16 = false;
                }
            }
            try {
                fileOutputStream = new FileOutputStream(file2, false);
            } catch (FileNotFoundException e17) {
                FLog.INSTANCE.e(f106443a, "writeFile fail. filePath:" + str + ", fileName:" + str2 + ". ", e17);
                fileOutputStream = null;
                z16 = false;
            }
            try {
                String str7 = str3 + "\r\n";
                if (fileOutputStream != null) {
                    fileOutputStream.write(str7.getBytes());
                }
            } catch (IOException e18) {
                FLog.INSTANCE.e(f106443a, "writeFile fail. filePath:" + str + ", fileName:" + str2 + ". ", e18);
                z16 = false;
                if (fileOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
            } catch (OutOfMemoryError e19) {
                FLog.INSTANCE.e(f106443a, "writeFile fail. filePath:" + str + ", fileName:" + str2 + ". ", e19);
                z16 = false;
                if (fileOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                } catch (IOException e26) {
                    FLog.INSTANCE.e(f106443a, "writeFile fail. filePath:" + str + ", fileName:" + str2 + ". ", e26);
                    z16 = false;
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                    return z16;
                } catch (IOException e27) {
                    FLog.INSTANCE.e(f106443a, "writeFile fail. filePath:" + str + ", fileName:" + str2 + ". ", e27);
                    return false;
                }
            }
            return z16;
        }
        return z16;
    }
}
