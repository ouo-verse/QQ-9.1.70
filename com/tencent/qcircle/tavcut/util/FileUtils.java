package com.tencent.qcircle.tavcut.util;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FileUtils {
    public static String readFile(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb5.append(readLine);
                } else {
                    return sb5.toString();
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x001a -> B:10:0x0029). Please report as a decompilation issue!!! */
    public static String readStringFromAsset(Context context, String str) {
        String str2 = "";
        if (context == null) {
            return "";
        }
        InputStream inputStream = null;
        try {
            try {
                try {
                    inputStream = context.getAssets().open(str);
                    str2 = readFile(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th5) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                    throw th5;
                }
            } catch (IOException e17) {
                e17.printStackTrace();
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (Exception e18) {
            e18.printStackTrace();
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readStringFromFile(String str) {
        Throwable th5;
        FileInputStream fileInputStream;
        IOException e16;
        try {
            fileInputStream = new FileInputStream(new File(str));
        } catch (IOException e17) {
            e16 = e17;
            fileInputStream = null;
        } catch (Throwable th6) {
            th5 = th6;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th5;
        }
        try {
            try {
                String readFile = readFile(fileInputStream);
                try {
                    fileInputStream.close();
                    return readFile;
                } catch (Exception e18) {
                    e18.printStackTrace();
                    return readFile;
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                }
                throw th5;
            }
        } catch (IOException e26) {
            e16 = e26;
            e16.printStackTrace();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e27) {
                    e27.printStackTrace();
                }
            }
            return "";
        }
    }
}
