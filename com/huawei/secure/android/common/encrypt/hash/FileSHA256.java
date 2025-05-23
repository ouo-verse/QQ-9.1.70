package com.huawei.secure.android.common.encrypt.hash;

import android.app.backup.BackupDataInputStream;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.a;
import com.huawei.secure.android.common.encrypt.utils.b;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class FileSHA256 {

    /* renamed from: a, reason: collision with root package name */
    private static final int f37778a = 8192;

    /* renamed from: b, reason: collision with root package name */
    private static final String f37779b = "SHA-256";

    /* renamed from: c, reason: collision with root package name */
    private static final String f37780c = "FileSHA256";

    /* renamed from: d, reason: collision with root package name */
    private static final String f37781d = "";

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f37782e = {"SHA-256", KeyPropertiesCompact.DIGEST_SHA384, KeyPropertiesCompact.DIGEST_SHA512};

    private static boolean a(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static String fileSHA256Encrypt(File file) {
        return fileSHAEncrypt(file, "SHA-256");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String fileSHAEncrypt(File file, String str) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        if (!TextUtils.isEmpty(str) && a(str)) {
            if (!a(file)) {
                b.b(f37780c, "file is not valid");
                return "";
            }
            BackupDataInputStream backupDataInputStream = 0;
            r0 = null;
            String str2 = null;
            try {
                try {
                    messageDigest = MessageDigest.getInstance(str);
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e16) {
                    e = e16;
                    fileInputStream = null;
                } catch (NoSuchAlgorithmException e17) {
                    e = e17;
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    a.a((InputStream) backupDataInputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[8192];
                    boolean z16 = false;
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                        z16 = true;
                    }
                    if (z16) {
                        str2 = HexUtil.byteArray2HexStr(messageDigest.digest());
                    }
                    a.a((InputStream) fileInputStream);
                } catch (IOException e18) {
                    e = e18;
                    b.b(f37780c, "IOException" + e.getMessage());
                    a.a((InputStream) fileInputStream);
                    return str2;
                } catch (NoSuchAlgorithmException e19) {
                    e = e19;
                    b.b(f37780c, "NoSuchAlgorithmException" + e.getMessage());
                    a.a((InputStream) fileInputStream);
                    return str2;
                }
                return str2;
            } catch (Throwable th6) {
                th = th6;
                backupDataInputStream = "";
                a.a((InputStream) backupDataInputStream);
                throw th;
            }
        }
        b.b(f37780c, "algorithm is empty or not safe");
        return "";
    }

    public static String inputStreamSHA256Encrypt(InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        return inputStreamSHAEncrypt(inputStream, "SHA-256");
    }

    public static String inputStreamSHAEncrypt(InputStream inputStream, String str) {
        if (inputStream == null) {
            return "";
        }
        byte[] bArr = new byte[8192];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            while (true) {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                    }
                } else {
                    return HexUtil.byteArray2HexStr(messageDigest.digest());
                }
            }
        } catch (IOException | NoSuchAlgorithmException unused) {
            b.b(f37780c, "inputstraem exception");
            return "";
        } finally {
            a.a(inputStream);
        }
    }

    public static boolean validateFileSHA(File file, String str, String str2) {
        if (!TextUtils.isEmpty(str) && a(str2)) {
            return str.equals(fileSHAEncrypt(file, str2));
        }
        b.b(f37780c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateFileSHA256(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(fileSHA256Encrypt(file));
    }

    public static boolean validateInputStreamSHA(InputStream inputStream, String str, String str2) {
        if (!TextUtils.isEmpty(str) && a(str2)) {
            return str.equals(inputStreamSHAEncrypt(inputStream, str2));
        }
        b.b(f37780c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateInputStreamSHA256(InputStream inputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(inputStreamSHA256Encrypt(inputStream));
    }

    private static boolean a(String str) {
        for (String str2 : f37782e) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
