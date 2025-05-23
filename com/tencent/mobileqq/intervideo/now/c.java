package com.tencent.mobileqq.intervideo.now;

import android.os.Environment;
import com.tencent.mobileqq.intervideo.now.api.INowUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {
    public static boolean a(String str, String str2) {
        return INowUtil.Now_PKG_NAME.equals(str2) && h(f());
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(String str, String str2, String str3) {
        FileInputStream fileInputStream;
        boolean equals = INowUtil.Now_PKG_NAME.equals(str3);
        boolean z16 = false;
        if (!equals || !h(str)) {
            return false;
        }
        if (h(f())) {
            return true;
        }
        String g16 = g();
        if (h(g16)) {
            d(g16);
        }
        File file = new File(str);
        File file2 = new File(g16);
        try {
            file2.createNewFile();
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read != -1) {
                                    fileOutputStream2.write(bArr, 0, read);
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e16) {
                                        e16.printStackTrace();
                                    }
                                }
                            }
                            fileOutputStream2.close();
                            fileInputStream.close();
                            z16 = true;
                        } catch (FileNotFoundException unused) {
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (!z16) {
                            }
                            return z16;
                        } catch (IOException unused2) {
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (!z16) {
                            }
                            return z16;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                    throw th;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException unused3) {
                    } catch (IOException unused4) {
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (FileNotFoundException unused5) {
                    fileInputStream = null;
                } catch (IOException unused6) {
                    fileInputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream = null;
                }
            } catch (IOException e18) {
                e18.printStackTrace();
            }
            if (!z16) {
                d(g16);
            } else {
                j(g16, f());
            }
        } catch (IOException unused7) {
        }
        return z16;
    }

    private static void c(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        if (!file.getParentFile().exists()) {
            c(file.getParent());
        }
        file.mkdir();
    }

    private static String e() {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/now/";
        c(str);
        return str;
    }

    public static String f() {
        return e() + "now_download_common.apk";
    }

    public static String g() {
        return e() + "now_download_temp_QQ.apk";
    }

    public static boolean i() {
        return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/now/h5testEnv").exists();
    }

    public static boolean j(String str, String str2) {
        if (h(str)) {
            return new File(str).renameTo(new File(str2));
        }
        return false;
    }

    public static boolean d(String str) {
        if (str == null || "".equalsIgnoreCase(str)) {
            return false;
        }
        return new File(str).delete();
    }

    public static boolean h(String str) {
        if (str == null || "".equalsIgnoreCase(str)) {
            return false;
        }
        return new File(str).exists();
    }
}
