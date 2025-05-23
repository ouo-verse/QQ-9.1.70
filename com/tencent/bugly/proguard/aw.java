package com.tencent.bugly.proguard;

import com.tencent.bugly.common.utils.AndroidVersion;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class aw {
    public static boolean a(File file, String str, long j3, boolean z16) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, z16));
            boolean a16 = a(bufferedWriter, str.toCharArray(), str.length(), file.length(), j3);
            bufferedWriter.close();
            return a16;
        } catch (Throwable th5) {
            av.a(th5);
            return false;
        }
    }

    private static List<File> b(String str, final String str2, final String str3, long j3) {
        ArrayList arrayList = new ArrayList();
        if (str2 != null && str3 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                try {
                    File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.tencent.bugly.proguard.aw.1
                        @Override // java.io.FilenameFilter
                        public final boolean accept(File file2, String str4) {
                            if (str4 == null || !str4.startsWith(str2) || !str4.endsWith(str3)) {
                                return false;
                            }
                            return true;
                        }
                    });
                    if (listFiles != null && listFiles.length != 0) {
                        return a(listFiles, str2, str3, currentTimeMillis - j3);
                    }
                    return arrayList;
                } catch (Throwable th5) {
                    av.a(th5);
                    return arrayList;
                }
            }
            return arrayList;
        }
        av.d("prefix %s and/or postfix %s is null.", str2, str3);
        return arrayList;
    }

    private static boolean a(Writer writer, char[] cArr, int i3, long j3, long j16) {
        if (j3 >= j16) {
            return false;
        }
        try {
            if ((i3 * 2) + j3 <= j16) {
                writer.write(cArr, 0, i3);
            } else {
                writer.write(cArr, 0, (int) ((j16 - j3) / 2));
            }
            writer.flush();
            return true;
        } catch (IOException e16) {
            av.a(e16);
            return false;
        }
    }

    public static void a(String str, String str2, String str3, long j3) {
        try {
            int i3 = 0;
            for (File file : b(str, str2, str3, j3)) {
                av.c("File %s is to be deleted.", file.getName());
                if (file.delete()) {
                    i3++;
                }
            }
            av.c("Number of overdue trace files that has deleted: ".concat(String.valueOf(i3)), new Object[0]);
        } catch (Throwable th5) {
            av.a(th5);
        }
    }

    private static List<File> a(File[] fileArr, String str, String str2, long j3) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            long a16 = a(file.getName(), str, str2);
            if (a16 >= 0 && 0 <= a16 && a16 <= j3) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    public static long a(String str, String str2, String str3) {
        if (str == null) {
            av.d("File name is null.", new Object[0]);
            return -1L;
        }
        try {
            if (str.startsWith(str2) && str.endsWith(str3)) {
                return Long.parseLong(str.substring(str2.length(), str.indexOf(str3)));
            }
        } catch (Throwable th5) {
            av.a(th5);
        }
        return -1L;
    }

    public static boolean a(String str, String str2, int i3) {
        boolean z16 = true;
        av.c("rqdp{  sv sd start} %s", str);
        if (str2 != null && str2.trim().length() > 0) {
            File file = new File(str);
            try {
                if (!file.exists()) {
                    if (file.getParentFile() != null) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                long j3 = i3;
                if (file.length() >= j3) {
                    z16 = false;
                }
                return a(file, str2, j3, z16);
            } catch (Throwable th5) {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
            }
        }
        return false;
    }

    public static void a(File[] fileArr) {
        try {
            Arrays.sort(fileArr, new Comparator() { // from class: com.tencent.bugly.proguard.aw.2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    if (AndroidVersion.isOverKitKat()) {
                        return Long.compare(((File) obj).lastModified(), ((File) obj2).lastModified());
                    }
                    File file = (File) obj;
                    File file2 = (File) obj2;
                    if (file.lastModified() > file2.lastModified()) {
                        return 1;
                    }
                    if (file.lastModified() < file2.lastModified()) {
                        return -1;
                    }
                    return 0;
                }
            });
        } catch (Throwable th5) {
            av.a(th5);
        }
    }
}
