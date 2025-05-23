package com.qq.e.comm.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class StringUtil {
    public static boolean isEmpty(String str) {
        if (str != null && str.trim().length() != 0) {
            return false;
        }
        return true;
    }

    public static String join(String str, String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (str != null && i3 != 0) {
                    stringBuffer.append(str);
                }
                stringBuffer.append(strArr[i3]);
            }
        }
        return stringBuffer.toString();
    }

    public static int parseInteger(String str, int i3) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readAll(File file) throws IOException {
        Throwable th5;
        BufferedReader bufferedReader;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                try {
                    StringBuilder sb5 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb5.append(readLine);
                    }
                    String sb6 = sb5.toString();
                    try {
                        bufferedReader.close();
                    } catch (Exception e16) {
                        GDTLogger.e("Exception while close bufferreader", e16);
                    }
                    return sb6;
                } catch (Throwable th6) {
                    th5 = th6;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e17) {
                            GDTLogger.e("Exception while close bufferreader", e17);
                        }
                    }
                    throw th5;
                }
            } catch (IOException e18) {
                throw e18;
            }
        } catch (IOException e19) {
            bufferedReader = null;
            throw e19;
        } catch (Throwable th7) {
            th5 = th7;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            throw th5;
        }
    }

    public static String safeString(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static void writeTo(String str, File file) throws IOException {
        if (file != null) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str);
            fileWriter.close();
            return;
        }
        throw new IOException("Target File Can not be null in StringUtil.writeTo");
    }
}
