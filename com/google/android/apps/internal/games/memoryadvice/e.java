package com.google.android.apps.internal.games.memoryadvice;

import android.util.Log;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f32933a = "e";

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f32934b = Pattern.compile("([^:]+)[^\\d]*(\\d+).*\n");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f32935c = Pattern.compile("([a-zA-Z]+)[^\\d]*(\\d+) kB.*\n");

    public static long a(Object obj) {
        long j3;
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        if (obj instanceof String) {
            String upperCase = ((String) obj).toUpperCase();
            int indexOf = upperCase.indexOf(75);
            if (indexOf == -1) {
                indexOf = upperCase.indexOf(77);
                if (indexOf == -1) {
                    indexOf = upperCase.indexOf(71);
                    if (indexOf == -1) {
                        j3 = 1;
                    } else {
                        j3 = 1073741824;
                    }
                } else {
                    j3 = 1048576;
                }
            } else {
                j3 = 1024;
            }
            return Float.parseFloat(upperCase.substring(0, indexOf)) * ((float) j3);
        }
        throw new IllegalArgumentException("Input to getMemoryQuantity neither string or number.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i3) {
        try {
            return Integer.parseInt(e("/proc/" + i3 + "/oom_score"));
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Long> c() {
        HashMap hashMap = new HashMap();
        try {
            Matcher matcher = f32934b.matcher(e("/proc/meminfo"));
            while (matcher.find()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                Objects.requireNonNull(group2);
                hashMap.put(group, Long.valueOf(Long.parseLong(group2) * 1024));
            }
        } catch (IOException unused) {
            Log.w(f32933a, "Failed to read /proc/meminfo");
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Long> d(int i3) {
        HashMap hashMap = new HashMap();
        String str = "/proc/" + i3 + "/status";
        try {
            Matcher matcher = f32935c.matcher(e(str));
            while (matcher.find()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                Objects.requireNonNull(group2);
                hashMap.put(group, Long.valueOf(Long.parseLong(group2) * 1024));
            }
        } catch (IOException unused) {
            Log.w(f32933a, "Failed to read " + str);
        }
        return hashMap;
    }

    public static String e(String str) throws IOException {
        return f(new FileInputStream(str));
    }

    public static String f(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        try {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            try {
                String lineSeparator = System.lineSeparator();
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (sb5.length() > 0) {
                            sb5.append(lineSeparator);
                        }
                        sb5.append(readLine);
                    } else {
                        String sb6 = sb5.toString();
                        bufferedReader.close();
                        inputStreamReader.close();
                        return sb6;
                    }
                }
            } finally {
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }
}
