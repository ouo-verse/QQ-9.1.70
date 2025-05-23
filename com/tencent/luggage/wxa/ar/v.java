package com.tencent.luggage.wxa.ar;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class v {
    public static boolean a(int i3, String str) {
        try {
            return a(i3, new File(str));
        } catch (Throwable th5) {
            x0.a("FileListMD5Checker", "checkFileListMd5 error", th5);
            return false;
        }
    }

    public static boolean b(int i3, File file) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        String[] split;
        String str;
        String str2;
        File file2;
        String a16;
        x0.d("FileListMD5Checker", "checkResFileListMd5, version:" + i3 + ", configFile:" + file);
        if (file != null && file.exists()) {
            String j3 = u0.j(i3);
            BufferedReader bufferedReader = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine != null) {
                                    if (!readLine.isEmpty()) {
                                        x0.d("FileListMD5Checker", "checkResFileListMd5, line:" + readLine);
                                        split = readLine.split(":");
                                        if (split != null && split.length == 2 && (str = split[0]) != null && !str.isEmpty() && (str2 = split[1]) != null && !str2.isEmpty() && ((a16 = y.a((file2 = new File(j3, split[0])))) == null || !a16.equalsIgnoreCase(split[1]))) {
                                            break;
                                        }
                                    }
                                } else {
                                    w.a(fileInputStream);
                                    w.a(inputStreamReader);
                                    w.a(bufferedReader2);
                                    return true;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedReader = bufferedReader2;
                                try {
                                    x0.a("FileListMD5Checker", "checkResFileListMd5 error", th);
                                    return false;
                                } finally {
                                    w.a(fileInputStream);
                                    w.a(inputStreamReader);
                                    w.a(bufferedReader);
                                }
                            }
                        }
                        com.tencent.luggage.wxa.wq.a.b(split[0]);
                        x0.f("FileListMD5Checker", "checkResFileListMd5 failed, resFile:" + split[0] + ", fileMd5:" + a16 + ", expectedMd5:" + split[1]);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("checkResFileListMd5, fileSize:");
                        sb5.append(w.a(file2, false));
                        x0.f("FileListMD5Checker", sb5.toString());
                        w.a(fileInputStream);
                        w.a(inputStreamReader);
                        w.a(bufferedReader2);
                        return false;
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    inputStreamReader = null;
                }
            } catch (Throwable th8) {
                th = th8;
                inputStreamReader = null;
                fileInputStream = null;
            }
        } else {
            x0.f("FileListMD5Checker", "checkResFileListMd5, config file not exist");
            return false;
        }
    }

    public static boolean a(int i3, File file) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        String[] split;
        String str;
        String str2;
        String a16;
        File file2;
        String a17;
        x0.d("FileListMD5Checker", "checkFileListMd5, version:" + i3 + ", configFile:" + file);
        if (file != null && file.exists()) {
            BufferedReader bufferedReader = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine != null) {
                                    if (!readLine.isEmpty()) {
                                        x0.d("FileListMD5Checker", "checkFileListMd5, line:" + readLine);
                                        split = readLine.split(":");
                                        if (split != null && split.length == 2 && (str = split[0]) != null && !str.isEmpty() && (str2 = split[1]) != null && !str2.isEmpty()) {
                                            if ("base.apk".equals(split[0])) {
                                                a16 = u0.e(i3);
                                            } else {
                                                a16 = u0.a(i3, split[0]);
                                            }
                                            file2 = new File(a16);
                                            a17 = y.a(file2);
                                            if (a17 == null || !a17.equalsIgnoreCase(split[1])) {
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    w.a(fileInputStream);
                                    w.a(inputStreamReader);
                                    w.a(bufferedReader2);
                                    return true;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedReader = bufferedReader2;
                                try {
                                    x0.a("FileListMD5Checker", "checkFileListMd5 error", th);
                                    return false;
                                } finally {
                                    w.a(fileInputStream);
                                    w.a(inputStreamReader);
                                    w.a(bufferedReader);
                                }
                            }
                        }
                        com.tencent.luggage.wxa.wq.a.a(split[0]);
                        x0.f("FileListMD5Checker", "checkFileListMd5 failed, filePath:" + a16 + ", fileMd5:" + a17 + ", expectedMd5:" + split[1]);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("checkResFileListMd5, fileSize:");
                        sb5.append(w.a(file2, false));
                        x0.f("FileListMD5Checker", sb5.toString());
                        w.a(fileInputStream);
                        w.a(inputStreamReader);
                        w.a(bufferedReader2);
                        return false;
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    inputStreamReader = null;
                }
            } catch (Throwable th8) {
                th = th8;
                inputStreamReader = null;
                fileInputStream = null;
            }
        } else {
            x0.f("FileListMD5Checker", "checkFileListMd5, config file not exist");
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable, java.io.BufferedReader] */
    public static String[] a(int i3) {
        Throwable th5;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        ?? r26;
        String[] split;
        String str;
        x0.d("FileListMD5Checker", "getResFileList, version:" + i3);
        String g16 = u0.g(i3);
        File file = new File(g16);
        if (!file.exists()) {
            x0.f("FileListMD5Checker", "getResFileList, resConfigPath not exist, path:" + g16);
            n0.a(79L, 1);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th6) {
            th5 = th6;
            fileInputStream = null;
            inputStreamReader = null;
        }
        try {
            inputStreamReader = new InputStreamReader(fileInputStream);
            try {
                r26 = new BufferedReader(inputStreamReader);
            } catch (Throwable th7) {
                th5 = th7;
                r26 = 0;
            }
        } catch (Throwable th8) {
            th5 = th8;
            inputStreamReader = null;
            r26 = inputStreamReader;
            try {
                x0.a("FileListMD5Checker", "getResFileList error", th5);
                n0.a(79L, 1);
                return null;
            } finally {
                w.a(fileInputStream);
                w.a(inputStreamReader);
                w.a((Closeable) r26);
            }
        }
        try {
            ArrayList arrayList = new ArrayList();
            while (true) {
                String readLine = r26.readLine();
                if (readLine == null) {
                    break;
                }
                if (!readLine.isEmpty() && (split = readLine.split(":")) != null && split.length == 2 && (str = split[0]) != null && !str.isEmpty()) {
                    arrayList.add(split[0]);
                }
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            if (strArr != null) {
                return strArr;
            }
            n0.a(79L, 1);
            return null;
        } catch (Throwable th9) {
            th5 = th9;
            x0.a("FileListMD5Checker", "getResFileList error", th5);
            n0.a(79L, 1);
            return null;
        }
    }
}
