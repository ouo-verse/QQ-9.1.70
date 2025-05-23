package com.tencent.ams.xsad.rewarded.loader;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.ams.xsad.rewarded.utils.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static b f71828b;

    /* renamed from: a, reason: collision with root package name */
    private String f71829a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements Comparator<Object> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, obj, obj2)).intValue();
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
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14460);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f71828b = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f71829a = null;
        }
    }

    private String c() {
        return this.f71829a;
    }

    private String d(String str) {
        return g.g(str);
    }

    private File[] e() {
        String c16 = c();
        File[] fileArr = null;
        if (c16 == null) {
            return null;
        }
        File file = new File(c16);
        if (file.exists() && (fileArr = file.listFiles()) != null) {
            Arrays.sort(fileArr, new a());
        }
        return fileArr;
    }

    private long f() {
        File[] listFiles;
        String c16 = c();
        long j3 = 0;
        if (c16 == null) {
            return 0L;
        }
        File file = new File(c16);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                j3 += file2.length();
            }
        }
        return j3;
    }

    public static b g() {
        return f71828b;
    }

    private boolean j(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        return file.setLastModified(System.currentTimeMillis());
    }

    public String a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        String c16 = c();
        if (c16 == null) {
            return null;
        }
        String str2 = c16 + d(str);
        j(str2);
        return str2;
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public void h(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        if (context != null) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(externalFilesDir.getAbsoluteFile());
                String str = File.separator;
                sb5.append(str);
                sb5.append("ad");
                sb5.append(str);
                sb5.append("rewarded");
                sb5.append(str);
                this.f71829a = sb5.toString();
                return;
            }
            File filesDir = context.getFilesDir();
            if (filesDir == null) {
                return;
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append(filesDir.getAbsolutePath());
            String str2 = File.separator;
            sb6.append(str2);
            sb6.append("ad_cache");
            sb6.append(str2);
            sb6.append("rewarded");
            sb6.append(str2);
            this.f71829a = sb6.toString();
        }
    }

    public boolean i(String str, InputStream inputStream) {
        String c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) inputStream)).booleanValue();
        }
        if (TextUtils.isEmpty(str) || inputStream == null || (c16 = c()) == null) {
            return false;
        }
        File file = new File(c16);
        if (!file.exists()) {
            file.mkdirs();
        }
        String d16 = d(str);
        if (d16 == null) {
            return false;
        }
        File file2 = new File(c16 + d16 + "." + System.currentTimeMillis());
        if (file2.exists()) {
            file2.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                    fileOutputStream2.flush();
                    com.tencent.ams.xsad.rewarded.utils.c.a("RewardedAdResCache", "put url:" + str + " success");
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(c16);
                    sb5.append(d16);
                    File file3 = new File(sb5.toString());
                    if (file3.exists()) {
                        file3.delete();
                    }
                    boolean renameTo = file2.renameTo(file3);
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    try {
                        inputStream.close();
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                    try {
                        k();
                    } catch (Exception unused) {
                    }
                    return renameTo;
                } catch (Exception e18) {
                    e = e18;
                    fileOutputStream = fileOutputStream2;
                    com.tencent.ams.xsad.rewarded.utils.c.b("RewardedAdResCache", "put url:" + str + " failed", e);
                    file2.delete();
                    try {
                        fileOutputStream.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                    try {
                        inputStream.close();
                    } catch (Exception e26) {
                        e26.printStackTrace();
                    }
                    try {
                        k();
                    } catch (Exception unused2) {
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    try {
                        fileOutputStream.close();
                    } catch (Exception e27) {
                        e27.printStackTrace();
                    }
                    try {
                        inputStream.close();
                    } catch (Exception e28) {
                        e28.printStackTrace();
                    }
                    try {
                        k();
                        throw th;
                    } catch (Exception unused3) {
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e29) {
            e = e29;
        }
    }

    public void k() {
        File[] e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        String c16 = c();
        if (c16 == null) {
            return;
        }
        File file = new File(c16);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            long currentTimeMillis = System.currentTimeMillis();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2 != null && currentTimeMillis - file2.lastModified() > 604800000) {
                        file2.delete();
                        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdResCache", "trim out of date -> file deleted: " + file2.getName());
                    }
                }
            }
            long b16 = b();
            long f16 = f();
            com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdResCache", "availableSize: " + b16 + " cacheSize: " + f16);
            if ((f16 > 2097152 || b16 < 2097152) && (e16 = e()) != null) {
                for (File file3 : e16) {
                    if (file3 != null) {
                        com.tencent.ams.xsad.rewarded.utils.c.a("RewardedAdResCache", "trim out of size -> file deleted: " + file3.getName());
                        long length = file3.length();
                        f16 -= length;
                        b16 += length;
                        file3.delete();
                    }
                    if (f16 <= 2097152 && b16 >= 2097152) {
                        return;
                    }
                }
            }
        }
    }
}
