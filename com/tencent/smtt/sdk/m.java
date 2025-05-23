package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static m f369417a;

    /* renamed from: b, reason: collision with root package name */
    private static Context f369418b;

    m() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(Context context) {
        if (f369417a == null) {
            synchronized (m.class) {
                if (f369417a == null) {
                    f369417a = new m();
                }
            }
        }
        f369418b = context.getApplicationContext();
        return f369417a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.FileInputStream, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Properties e() {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        Properties properties;
        ?? r36;
        Exception e16;
        BufferedInputStream bufferedInputStream2;
        FileInputStream fileInputStream2;
        BufferedInputStream bufferedInputStream3 = null;
        try {
            try {
                try {
                    File a16 = a();
                    properties = new Properties();
                    if (a16 != null) {
                        try {
                            r36 = new FileInputStream(a16);
                            try {
                                bufferedInputStream2 = new BufferedInputStream(r36);
                            } catch (Exception e17) {
                                bufferedInputStream2 = null;
                                e16 = e17;
                            } catch (Throwable th5) {
                                bufferedInputStream = null;
                                th = th5;
                                fileInputStream = r36;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                        throw th;
                                    } catch (IOException e19) {
                                        e19.printStackTrace();
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e26) {
                            e = e26;
                            r36 = 0;
                            e16 = e;
                            bufferedInputStream2 = r36;
                            e16.printStackTrace();
                            if (bufferedInputStream2 != null) {
                            }
                            if (r36 != 0) {
                            }
                            return properties;
                        }
                        try {
                            properties.load(bufferedInputStream2);
                            bufferedInputStream3 = bufferedInputStream2;
                            fileInputStream2 = r36;
                        } catch (Exception e27) {
                            e16 = e27;
                            e16.printStackTrace();
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e28) {
                                    e28.printStackTrace();
                                }
                            }
                            if (r36 != 0) {
                                try {
                                    r36.close();
                                } catch (IOException e29) {
                                    e29.printStackTrace();
                                }
                            }
                            return properties;
                        }
                    } else {
                        fileInputStream2 = null;
                    }
                    if (bufferedInputStream3 != null) {
                        try {
                            bufferedInputStream3.close();
                        } catch (IOException e36) {
                            e36.printStackTrace();
                        }
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e37) {
                            e37.printStackTrace();
                        }
                    }
                    return properties;
                } catch (Exception e38) {
                    e = e38;
                    properties = null;
                    r36 = 0;
                }
            } catch (Throwable th6) {
                fileInputStream = null;
                th = th6;
                bufferedInputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i3, int i16) {
        a("tpatch_ver", i3);
        a("tpatch_status", i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return b("install_status");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return b("incrupdate_status");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i3, int i16) {
        a("install_core_ver", i3);
        a("install_status", i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i3) {
        a("unlzma_status", i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return c("install_core_ver");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d(String str) {
        Properties e16 = e();
        if (e16 == null || e16.getProperty(str) == null) {
            return null;
        }
        return e16.getProperty(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i3) {
        a("unzip_retry_num", i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i3) {
        a("incrupdate_status", i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(String str) {
        Properties e16 = e();
        if (e16 != null && e16.getProperty(str) != null) {
            try {
                return Integer.parseInt(e16.getProperty(str));
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(String str) {
        Properties e16 = e();
        if (e16 != null && e16.getProperty(str) != null) {
            try {
                return Integer.parseInt(e16.getProperty(str));
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i3, int i16) {
        a("copy_core_ver", i3);
        a("copy_status", i16);
    }

    File a() {
        File file = new File(n.o(f369418b), "tbscoreinstall.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i3) {
        a("dexopt_retry_num", i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        a("install_apk_path", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    Properties e16 = e();
                    if (e16 != null) {
                        e16.setProperty(str, str2);
                        File a16 = a();
                        if (a16 != null) {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(a16);
                            try {
                                e16.store(fileOutputStream2, "update " + str + " and status!");
                                fileOutputStream = fileOutputStream2;
                            } catch (Exception e17) {
                                e = e17;
                                fileOutputStream = fileOutputStream2;
                                e.printStackTrace();
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                return;
                            } catch (Throwable th5) {
                                th = th5;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Exception e19) {
                    e = e19;
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e26) {
            e26.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i3) {
        a(str, String.valueOf(i3));
    }
}
