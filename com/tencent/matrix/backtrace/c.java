package com.tencent.matrix.backtrace;

import android.content.Context;
import android.os.CancellationSignal;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.tencent.matrix.backtrace.WeChatBacktrace;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes9.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static Map<String, Integer> f151451a;

        public static boolean a(Context context, String str, int i3) {
            if (d(context, c.o(str, i3)) >= 3) {
                return false;
            }
            return true;
        }

        public static boolean b(Context context, String str, int i3) {
            String o16 = c.o(str, i3);
            int d16 = d(context, o16);
            if (d16 >= 3) {
                return false;
            }
            f151451a.put(o16, Integer.valueOf(d16 + 1));
            c.d(context, f151451a);
            return true;
        }

        public static void c(Context context, String str, int i3, boolean z16) {
            String o16 = c.o(str, i3);
            int d16 = d(context, o16);
            if (z16) {
                f151451a.remove(o16);
            } else {
                f151451a.put(o16, Integer.valueOf(d16 + 1));
            }
            c.d(context, f151451a);
        }

        private static int d(Context context, String str) {
            if (f151451a == null) {
                f151451a = c.l(context);
            }
            Integer num = f151451a.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
    }

    static File a(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + "/wechat-backtrace/clean-up.timestamp");
        file.getParentFile().mkdirs();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(WeChatBacktrace.b bVar) {
        return bVar.f151433a.getFilesDir().getAbsolutePath() + "/wechat-backtrace/saving-cache/";
    }

    static File c(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + "/wechat-backtrace/disk-usage.timestamp");
        file.getParentFile().mkdirs();
        return file;
    }

    static void d(Context context, Map<String, Integer> map) {
        File n3 = n(context);
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey() + "|" + entry.getValue() + "\n");
        }
        r(n3, stringBuffer.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(Context context) {
        return q(context).exists();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(File file, CancellationSignal cancellationSignal, FileFilter fileFilter) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    f(file2, cancellationSignal, fileFilter);
                    cancellationSignal.throwIfCanceled();
                }
                return;
            }
            return;
        }
        fileFilter.accept(file);
        cancellationSignal.throwIfCanceled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(Context context) {
        File a16 = a(context);
        try {
            a16.createNewFile();
            a16.setLastModified(System.currentTimeMillis());
        } catch (IOException e16) {
            g51.b.d("Matrix.Backtrace.WarmUp", e16, "", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(Context context) {
        File c16 = c(context);
        try {
            c16.createNewFile();
            c16.setLastModified(System.currentTimeMillis());
        } catch (IOException e16) {
            g51.b.d("Matrix.Backtrace.WarmUp", e16, "", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(Context context) {
        File a16 = a(context);
        if (!a16.exists()) {
            try {
                a16.createNewFile();
            } catch (IOException e16) {
                g51.b.d("Matrix.Backtrace.WarmUp", e16, "", new Object[0]);
            }
            return false;
        }
        if (System.currentTimeMillis() - a16.lastModified() < 172800000) {
            return false;
        }
        return true;
    }

    static boolean j(WeChatBacktrace.b bVar) {
        if (bVar.f151434b == null) {
            return false;
        }
        try {
        } catch (IOException e16) {
            g51.b.d("Matrix.Backtrace.WarmUp", e16, "", new Object[0]);
        }
        if (new File(bVar.f151434b).getCanonicalPath().startsWith(bVar.f151433a.getFilesDir().getParentFile().getCanonicalFile().getAbsolutePath())) {
            return true;
        }
        g51.b.b("Matrix.Backtrace.WarmUp", "Saving path should under private storage path %s", bVar.f151433a.getFilesDir().getParentFile().getAbsolutePath());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        g51.b.d("Matrix.Backtrace.WarmUp", r8, "", new java.lang.Object[0]);
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String k(File file, int i3) {
        FileReader fileReader;
        StringBuilder sb5;
        FileReader fileReader2 = null;
        if (file.isFile()) {
            try {
                sb5 = new StringBuilder(4096);
                fileReader = new FileReader(file);
            } catch (Exception e16) {
                e = e16;
                fileReader = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileReader2 != null) {
                }
                throw th;
            }
            try {
                try {
                    char[] cArr = new char[1024];
                    int i16 = 0;
                    do {
                        int read = fileReader.read(cArr);
                        if (read > 0) {
                            sb5.append(cArr, 0, read);
                            i16 += read;
                        } else {
                            String sb6 = sb5.toString();
                            try {
                                fileReader.close();
                            } catch (IOException e17) {
                                g51.b.d("Matrix.Backtrace.WarmUp", e17, "", new Object[0]);
                            }
                            return sb6;
                        }
                    } while (i16 <= i3);
                    fileReader.close();
                    return null;
                } catch (Throwable th6) {
                    th = th6;
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (IOException e18) {
                            g51.b.d("Matrix.Backtrace.WarmUp", e18, "", new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                g51.b.d("Matrix.Backtrace.WarmUp", e, "", new Object[0]);
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e26) {
                        g51.b.d("Matrix.Backtrace.WarmUp", e26, "", new Object[0]);
                    }
                }
                return null;
            }
        }
        return null;
    }

    static Map<String, Integer> l(Context context) {
        HashMap hashMap = new HashMap();
        File n3 = n(context);
        String k3 = k(n3, IoUtils.DEFAULT_IMAGE_TOTAL_SIZE);
        if (k3 == null) {
            g51.b.e("Matrix.Backtrace.WarmUp", "Read unfinished maps file failed, file size %s", Long.valueOf(n3.length()));
            if (n3.length() > 512000) {
                n3.delete();
            }
        } else {
            for (String str : k3.split("\n")) {
                int lastIndexOf = str.lastIndexOf("|");
                if (lastIndexOf >= 0) {
                    try {
                        hashMap.put(str.substring(0, lastIndexOf), Integer.valueOf(Integer.parseInt(str.substring(lastIndexOf + 1))));
                    } catch (Throwable th5) {
                        g51.b.d("Matrix.Backtrace.WarmUp", th5, "", new Object[0]);
                    }
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean m(Context context) {
        File c16 = c(context);
        if (!c16.exists()) {
            try {
                c16.createNewFile();
            } catch (IOException e16) {
                g51.b.d("Matrix.Backtrace.WarmUp", e16, "", new Object[0]);
            }
            return false;
        }
        if (System.currentTimeMillis() - c16.lastModified() < 259200000) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File n(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + "/wechat-backtrace/unfinished");
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e16) {
                g51.b.d("Matrix.Backtrace.WarmUp", e16, "", new Object[0]);
            }
        }
        return file;
    }

    static String o(String str, int i3) {
        return str + ":" + i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String p(WeChatBacktrace.b bVar) {
        if (j(bVar)) {
            return bVar.f151434b;
        }
        return b(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File q(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + "/wechat-backtrace/warmed-up");
        file.getParentFile().mkdirs();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r(File file, String str) {
        if (file.isFile()) {
            FileWriter fileWriter = null;
            try {
                try {
                    FileWriter fileWriter2 = new FileWriter(file);
                    try {
                        fileWriter2.write(str);
                        try {
                            fileWriter2.close();
                            return true;
                        } catch (IOException e16) {
                            g51.b.d("Matrix.Backtrace.WarmUp", e16, "", new Object[0]);
                            return true;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        fileWriter = fileWriter2;
                        g51.b.d("Matrix.Backtrace.WarmUp", e, "", new Object[0]);
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e18) {
                                g51.b.d("Matrix.Backtrace.WarmUp", e18, "", new Object[0]);
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        fileWriter = fileWriter2;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e19) {
                                g51.b.d("Matrix.Backtrace.WarmUp", e19, "", new Object[0]);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e26) {
                e = e26;
            }
        }
        return false;
    }
}
