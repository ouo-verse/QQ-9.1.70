package com.tencent.mobileqq.guild.util.performance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] a(int i3) {
        BufferedReader bufferedReader;
        IOException e16;
        String[] strArr = new String[5];
        File file = new File("/proc/" + i3 + "/stat");
        if (file.exists() && file.canRead()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file), 8192);
            } catch (IOException e17) {
                bufferedReader = null;
                e16 = e17;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] split = readLine.split(" ");
                    strArr[0] = split[1];
                    strArr[1] = split[13];
                    strArr[2] = split[14];
                    strArr[3] = split[15];
                    strArr[4] = split[16];
                }
            } catch (IOException e18) {
                e16 = e18;
                e16.printStackTrace();
                if (bufferedReader != null) {
                }
                return strArr;
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            }
        }
        return strArr;
    }
}
