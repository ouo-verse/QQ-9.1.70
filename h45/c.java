package h45;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static FileOutputStream f404311a;

    /* renamed from: b, reason: collision with root package name */
    private static FileInputStream f404312b;

    /* renamed from: c, reason: collision with root package name */
    private static Properties f404313c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile String f404314d;

    /* renamed from: e, reason: collision with root package name */
    private static AtomicBoolean f404315e = new AtomicBoolean(false);

    public static String a(Context context) {
        if (f404315e.compareAndSet(false, true)) {
            f404314d = g(context, "encryptversion");
        }
        return f404314d;
    }

    private static void b(Context context, String str, String str2) {
        String str3;
        File filesDir = context.getFilesDir();
        if (filesDir != null && filesDir.getPath() != null) {
            if (new File(filesDir.getPath() + "/settings.properties").exists()) {
                FileInputStream openFileInput = context.openFileInput("settings.properties");
                f404312b = openFileInput;
                if (openFileInput != null) {
                    f404313c.load(openFileInput);
                } else {
                    q.q.q.e.w.e.c("FileUtil", "inStream is null", true);
                }
            }
            f404311a = context.openFileOutput("settings.properties", 0);
            String[] a16 = a2.a.a();
            int length = a16.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    if (str.equals(a16[i3])) {
                        str3 = i2.b.b(context, str2);
                        break;
                    }
                    i3++;
                } else {
                    str3 = str2;
                    break;
                }
            }
            int i16 = 0;
            while (str3.length() > 8388588 && i16 < 3) {
                i16++;
                q.q.q.e.w.e.c("FileUtil", i16 + " mValue.length() is " + str3.length(), true);
                int length2 = a16.length;
                int i17 = 0;
                while (true) {
                    if (i17 >= length2) {
                        break;
                    }
                    if (str.equals(a16[i17])) {
                        str3 = i2.b.b(context, str2);
                        break;
                    }
                    i17++;
                }
            }
            if (str3.length() > 8388588) {
                q.q.q.e.w.e.b("FileUtil", "final mValue.length() is " + str3.length(), true);
                return;
            }
            f404313c.setProperty(str, str3);
            FileOutputStream fileOutputStream = f404311a;
            if (fileOutputStream != null) {
                f404313c.store(fileOutputStream, "accountagent");
            } else {
                q.q.q.e.w.e.c("FileUtil", "outStream is null", true);
            }
        }
    }

    public static void c(XmlSerializer xmlSerializer, String str, String str2) {
        try {
            xmlSerializer.startTag("", str);
            xmlSerializer.text(str2);
            xmlSerializer.endTag("", str);
        } catch (IOException unused) {
            q.q.q.e.w.e.b("FileUtil", "IOException ", true);
        } catch (IllegalArgumentException unused2) {
            q.q.q.e.w.e.b("FileUtil", "IllegalArgumentException  ", true);
        } catch (IllegalStateException unused3) {
            q.q.q.e.w.e.b("FileUtil", "IllegalStateException ", true);
        } catch (Exception unused4) {
            q.q.q.e.w.e.b("FileUtil", "Exception ", true);
        }
    }

    public static boolean d(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            return e(new File(context.getFilesDir(), str));
        }
        return false;
    }

    public static boolean e(File file) {
        File[] listFiles;
        q.q.q.e.w.e.c("FileUtil", "deleteFile : file.getName", true);
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                e(file2);
            }
        }
        return file.delete();
    }

    public static boolean f(String str, String str2, byte[] bArr) {
        File file;
        if (str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2) || bArr == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    file = new File(str);
                } catch (FileNotFoundException unused) {
                } catch (IOException unused2) {
                } catch (RuntimeException unused3) {
                } catch (Exception unused4) {
                }
            } catch (IOException unused5) {
                q.q.q.e.w.e.b("FileUtil", "IOException ", true);
            }
            if (!file.exists() && !file.mkdirs()) {
                return false;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str + str2));
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.close();
            } catch (FileNotFoundException unused6) {
                fileOutputStream = fileOutputStream2;
                q.q.q.e.w.e.b("FileUtil", "writeAgreement FileNotFoundException", true);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused7) {
                        q.q.q.e.w.e.b("FileUtil", "IOException ", true);
                    }
                }
                return false;
            } catch (IOException unused8) {
                fileOutputStream = fileOutputStream2;
                q.q.q.e.w.e.b("FileUtil", "writeAgreement IOException", true);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused9) {
                        q.q.q.e.w.e.b("FileUtil", "IOException ", true);
                    }
                }
                return false;
            } catch (RuntimeException unused10) {
                fileOutputStream = fileOutputStream2;
                q.q.q.e.w.e.b("FileUtil", "RuntimeException ", true);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return true;
            } catch (Exception unused11) {
                fileOutputStream = fileOutputStream2;
                q.q.q.e.w.e.b("FileUtil", "Exception ", true);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return true;
            } catch (Throwable th5) {
                fileOutputStream = fileOutputStream2;
                th = th5;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused12) {
                        q.q.q.e.w.e.b("FileUtil", "IOException ", true);
                    }
                }
                throw th;
            }
            return true;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x008e, code lost:
    
        r3 = i2.b.a(r9, r3);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String g(Context context, String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Properties properties;
        int i3;
        FileOutputStream fileOutputStream;
        synchronized (c.class) {
            FileOutputStream fileOutputStream2 = null;
            r2 = null;
            FileInputStream fileInputStream3 = null;
            FileOutputStream fileOutputStream3 = null;
            FileOutputStream fileOutputStream4 = null;
            fileOutputStream2 = null;
            try {
                try {
                    try {
                        properties = new Properties();
                        i3 = 0;
                        if (!new File(context.getFilesDir().getPath() + "/settings.properties").exists()) {
                            fileOutputStream = context.openFileOutput("settings.properties", 0);
                        } else {
                            fileOutputStream = null;
                        }
                    } catch (FileNotFoundException unused) {
                        fileInputStream2 = null;
                    } catch (Throwable unused2) {
                        fileInputStream = null;
                    }
                    try {
                        fileInputStream3 = context.openFileInput("settings.properties");
                        if (fileInputStream3 != null) {
                            properties.load(fileInputStream3);
                        } else {
                            q.q.q.e.w.e.c("FileUtil", "getProperties inStream is null", true);
                        }
                        String property = properties.getProperty(str);
                        if (TextUtils.isEmpty(property)) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused3) {
                                    q.q.q.e.w.e.b("FileUtil", "getProperties IOException / ", true);
                                }
                            }
                            if (fileInputStream3 != null) {
                                try {
                                    fileInputStream3.close();
                                } catch (IOException unused4) {
                                    q.q.q.e.w.e.b("FileUtil", "getProperties IOException / ", true);
                                }
                            }
                            return property;
                        }
                        String[] a16 = a2.a.a();
                        int length = a16.length;
                        while (true) {
                            if (i3 >= length) {
                                break;
                            }
                            if (str.equals(a16[i3])) {
                                break;
                            }
                            i3++;
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused5) {
                                q.q.q.e.w.e.b("FileUtil", "getProperties IOException / ", true);
                            }
                        }
                        if (fileInputStream3 != null) {
                            try {
                                fileInputStream3.close();
                            } catch (IOException unused6) {
                                q.q.q.e.w.e.b("FileUtil", "getProperties IOException / ", true);
                            }
                        }
                        return property;
                    } catch (FileNotFoundException unused7) {
                        fileInputStream2 = fileInputStream3;
                        fileOutputStream3 = fileOutputStream;
                        q.q.q.e.w.e.b("FileUtil", "Can not find the file settings.properties", true);
                        fileOutputStream2 = fileOutputStream3;
                        if (fileOutputStream3 != null) {
                            try {
                                fileOutputStream3.close();
                                fileOutputStream2 = fileOutputStream3;
                            } catch (IOException unused8) {
                                q.q.q.e.w.e.b("FileUtil", "getProperties IOException / ", true);
                                fileOutputStream2 = "getProperties IOException / ";
                            }
                        }
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                            fileOutputStream2 = fileOutputStream2;
                        }
                        context = "";
                        return "";
                    } catch (Throwable unused9) {
                        fileInputStream = fileInputStream3;
                        fileOutputStream4 = fileOutputStream;
                        q.q.q.e.w.e.b("FileUtil", "Throwable / ", true);
                        fileOutputStream2 = fileOutputStream4;
                        if (fileOutputStream4 != null) {
                            try {
                                fileOutputStream4.close();
                                fileOutputStream2 = fileOutputStream4;
                            } catch (IOException unused10) {
                                q.q.q.e.w.e.b("FileUtil", "getProperties IOException / ", true);
                                fileOutputStream2 = "getProperties IOException / ";
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            fileOutputStream2 = fileOutputStream2;
                        }
                        context = "";
                        return "";
                    }
                } catch (IOException unused11) {
                    q.q.q.e.w.e.b("FileUtil", "getProperties IOException / ", true);
                    context = "";
                    return "";
                }
            } finally {
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:24:0x00b0
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    public static synchronized void h(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h45.c.h(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void i(Context context, String str) {
        f404314d = str;
        h(context, "encryptversion", str);
    }
}
