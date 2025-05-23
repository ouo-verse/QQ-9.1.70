package com.tencent.mobileqq.auto.engine.loader.parse;

import android.text.TextUtils;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.zip.ZipEntry;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final File f199877a;

    /* renamed from: b, reason: collision with root package name */
    private final String f199878b;

    public c(ASPluginBean aSPluginBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aSPluginBean);
            return;
        }
        File file = new File(new File(MobileQQ.sMobileQQ.getFilesDir(), "ShadowPluginManager"), "UnpackedPlugin");
        this.f199877a = file;
        file.mkdirs();
        this.f199878b = aSPluginBean.getBusinessKey() + "-manager";
    }

    private void a(File file) throws IOException {
        IOException e16 = null;
        for (File file2 : l(file)) {
            try {
                c(file2);
            } catch (IOException e17) {
                e16 = e17;
            }
        }
        if (e16 != null) {
            throw e16;
        }
    }

    private void b(File file) throws IOException {
        if (!file.exists()) {
            return;
        }
        a(file);
        if (file.delete()) {
            return;
        }
        throw new IOException("Unable to delete directory " + file + ".");
    }

    private void c(File file) throws IOException {
        if (file.isDirectory()) {
            b(file);
            return;
        }
        boolean exists = file.exists();
        if (!file.delete()) {
            if (!exists) {
                throw new FileNotFoundException("File does not exist: " + file);
            }
            throw new IOException("Unable to delete file: " + file);
        }
    }

    private File d(File file, String str) {
        return new File(file, str);
    }

    private File f(File file) {
        return new File(file.getParentFile(), "unpacked." + file.getName());
    }

    private File g(File file, String str, String str2) {
        return new File(d(file, str), str2);
    }

    public static String j(File file) {
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                if (file == null || !file.exists()) {
                    return "";
                }
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = randomAccessFile2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    StringBuilder sb5 = new StringBuilder(new BigInteger(1, messageDigest.digest()).toString(16));
                    while (sb5.length() < 32) {
                        sb5.insert(0, "0");
                    }
                    String sb6 = sb5.toString();
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    return sb6;
                } catch (Exception e17) {
                    e = e17;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    return "";
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static File[] l(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    return listFiles;
                }
                throw new IOException("Failed to list contents of " + file);
            }
            throw new IllegalArgumentException(file + " is not a directory");
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File e(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            str = j(file);
        }
        return new File(h(str), file.getName());
    }

    File h(String str) {
        return g(this.f199877a, this.f199878b, str);
    }

    boolean i(File file) {
        return f(file).exists();
    }

    public boolean k(String str, File file) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) file)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            str = j(file);
        }
        File e16 = e(str, file);
        e16.mkdirs();
        File f16 = f(e16);
        if (i(e16)) {
            return true;
        }
        a(e16);
        e eVar = new e(new FileInputStream(file));
        while (true) {
            try {
                ZipEntry nextEntry = eVar.getNextEntry();
                if (nextEntry != null) {
                    if (!nextEntry.isDirectory()) {
                        BufferedOutputStream bufferedOutputStream2 = null;
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(e16, nextEntry.getName())));
                        } catch (Throwable th5) {
                            th = th5;
                        }
                        try {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(eVar);
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, 8192);
                                if (read < 0) {
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, read);
                            }
                            bufferedOutputStream.close();
                            eVar.closeEntry();
                        } catch (Throwable th6) {
                            th = th6;
                            bufferedOutputStream2 = bufferedOutputStream;
                            if (bufferedOutputStream2 != null) {
                                bufferedOutputStream2.close();
                            }
                            eVar.closeEntry();
                            throw th;
                        }
                    }
                } else {
                    f16.createNewFile();
                    return true;
                }
            } finally {
                eVar.close();
            }
        }
    }
}
