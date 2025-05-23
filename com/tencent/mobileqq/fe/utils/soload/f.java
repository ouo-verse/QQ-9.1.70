package com.tencent.mobileqq.fe.utils.soload;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f205869a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13363);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f205869a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        }
    }

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                byte b16 = bArr[i3];
                int i16 = i3 * 2;
                char[] cArr2 = f205869a;
                cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                cArr[i16 + 0] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        }
        return "";
    }

    private static boolean b(Context context, String str, String str2) {
        try {
            File file = new File(str2 + str);
            if (file.exists()) {
                File c16 = c(context, str, str2, str + "_tmp");
                if (!g(str2 + str + "_tmp").equals(com.tencent.mobileqq.fe.f.a().g("d_so_key"))) {
                    file.delete();
                    if (c16 != null) {
                        c16.renameTo(new File(str2 + str));
                    }
                } else if (c16 != null) {
                    c16.delete();
                }
            }
            if (!file.exists() || file.length() == 0) {
                file = c(context, str, str2, str);
            }
            if (file != null && file.exists() && file.length() > 10) {
                try {
                    System.load(str2 + str);
                    com.tencent.mobileqq.fe.f.a().f("d_so_key", g(str2 + str));
                    return true;
                } catch (UnsatisfiedLinkError unused) {
                    com.tencent.mobileqq.fe.c.a(SoLoadCore.TAG, 1, "@1Failed to load the new unzipped so !!");
                    return false;
                }
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private static File c(Context context, String str, String str2, String str3) {
        File l3 = l(d(context), str, str2, str3);
        if (l3.exists() && l3.length() > 0) {
            return l3;
        }
        return null;
    }

    public static String d(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192);
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (Exception unused) {
            com.tencent.mobileqq.fe.c.a(SoLoadCore.TAG, 1, "get apk path exception !!");
            return null;
        }
    }

    public static String e(Context context) {
        Object obj;
        try {
            try {
                return context.getFilesDir().getParent();
            } catch (Exception unused) {
                if (context instanceof ContextWrapper) {
                    obj = ((ContextWrapper) context).getBaseContext();
                } else {
                    Field declaredField = ContextWrapper.class.getDeclaredField("mBase");
                    declaredField.setAccessible(true);
                    obj = declaredField.get(context);
                }
                Method declaredMethod = obj.getClass().getDeclaredMethod("getDataDirFile", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((File) declaredMethod.invoke(obj, new Object[0])).getAbsolutePath();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    private static synchronized String f() {
        synchronized (f.class) {
            String str = Build.CPU_ABI;
            if (str != null && str.contains("armeabi-v7a")) {
                return "armeabi-v7a";
            }
            if (str != null && str.contains("arm64-v8a")) {
                return "arm64-v8a";
            }
            if (str != null) {
                if (str.contains("armeabi")) {
                    return "armeabi";
                }
            }
            return "";
        }
    }

    public static String g(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        String a16 = a(messageDigest.digest());
                        fileInputStream.close();
                        return a16;
                    }
                }
            } catch (Exception e16) {
                e = e16;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                }
                e.printStackTrace();
                return null;
            }
        } catch (Exception e18) {
            e = e18;
            fileInputStream = null;
        }
    }

    public static String h(String str) {
        return RFixConstants.SO_PATH + str + ".so";
    }

    private static synchronized String i() {
        String f16;
        synchronized (f.class) {
            f16 = f();
        }
        return f16;
    }

    private static boolean j(Context context, String str) {
        return b(context, h(str), e(context) + "/.fekitlib/");
    }

    public static boolean k(Context context, String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            if (context != null) {
                com.tencent.mobileqq.fe.c.a(SoLoadCore.TAG, 1, "loadSo Enter compatibility mode!! ");
                return j(context, str);
            }
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    public static File l(String str, String str2, String str3, String str4) {
        e eVar;
        File file = null;
        FileOutputStream fileOutputStream = null;
        ?? r36 = 0;
        file = null;
        file = null;
        if (str == null) {
            return null;
        }
        String str5 = File.separator;
        if (!str3.endsWith(str5)) {
            str3 = str3 + str5;
        }
        new File(str3).mkdirs();
        String str6 = "lib/" + i() + "/";
        try {
            eVar = new e(new File(str), "lib/" + i() + "/" + str2);
        } catch (IOException e16) {
            com.tencent.mobileqq.fe.c.a(SoLoadCore.TAG, 1, "releaseFromApk failed" + e16);
            eVar = null;
        }
        if (eVar == null) {
            return null;
        }
        d c16 = eVar.c();
        if (c16 != null && c16.a().contains(str6) && c16.a().endsWith(".so")) {
            String a16 = c16.a();
            int lastIndexOf = a16.lastIndexOf(47);
            if (lastIndexOf != -1) {
                a16.substring(lastIndexOf + 1);
            }
            File file2 = new File(str3 + str4);
            if (file2.exists()) {
                file2.delete();
            }
            byte[] bArr = new byte[4096];
            try {
            } catch (IOException unused) {
                com.tencent.mobileqq.fe.c.a(SoLoadCore.TAG, 1, "close fos fail!!");
            }
            try {
                try {
                    InputStream e17 = eVar.e(c16);
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    while (true) {
                        try {
                            int read = e17.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        } catch (Exception e18) {
                            e = e18;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            com.tencent.mobileqq.fe.c.a(SoLoadCore.TAG, 1, "releaseFromApk failed" + e);
                            fileOutputStream.close();
                            r36 = file2;
                            file = r36;
                            eVar.b();
                            return file;
                        } catch (Throwable th5) {
                            th = th5;
                            r36 = fileOutputStream2;
                            try {
                                r36.close();
                            } catch (IOException unused2) {
                                com.tencent.mobileqq.fe.c.a(SoLoadCore.TAG, 1, "close fos fail!!");
                            }
                            throw th;
                        }
                    }
                    fileOutputStream2.close();
                } catch (Exception e19) {
                    e = e19;
                }
                r36 = file2;
                file = r36;
            } catch (Throwable th6) {
                th = th6;
            }
        }
        try {
            eVar.b();
        } catch (IOException unused3) {
            com.tencent.mobileqq.fe.c.a(SoLoadCore.TAG, 1, "close zipFile fail!!");
        }
        return file;
    }
}
