package com.tencent.smtt.sdk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f369284a = 600;

    /* renamed from: b, reason: collision with root package name */
    private static int f369285b;

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        r3 = r3.substring(r4 + 9).trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (r3 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if (r3.length() == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        if (r3.contains("k") == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        r2 = java.lang.Integer.parseInt(r3.substring(0, r3.indexOf("k")).trim()) / 1024;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0059 -> B:25:0x0076). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a() {
        String readLine;
        int i3 = f369285b;
        if (i3 > 0) {
            return i3;
        }
        int i16 = 0;
        BufferedReader bufferedReader = null;
        bufferedReader = null;
        bufferedReader = null;
        bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                    while (true) {
                        try {
                            readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            int indexOf = readLine.indexOf("MemTotal:");
                            if (-1 != indexOf) {
                                break;
                            }
                        } catch (IOException e16) {
                            e = e16;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                                bufferedReader = bufferedReader;
                            }
                            f369285b = i16;
                            return i16;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader = bufferedReader2;
                            th.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                                bufferedReader = bufferedReader;
                            }
                            f369285b = i16;
                            return i16;
                        }
                    }
                    bufferedReader2.close();
                    bufferedReader = readLine;
                } catch (IOException e17) {
                    e = e17;
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e18) {
                e18.printStackTrace();
                bufferedReader = bufferedReader;
            }
            f369285b = i16;
            return i16;
        } catch (Throwable th7) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            }
            throw th7;
        }
    }
}
