package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.GregorianCalendar;
import javax.security.auth.x500.X500Principal;

/* compiled from: P */
/* loaded from: classes15.dex */
public class SignUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String KEYSTORE_PROVIDER_ANDROID_KEYSTORE = "AndroidKeyStore";
    public static final String SIGNATURE_SHA256withRSA = "SHA256withRSA";
    public static final String TAG = "SignUtils";
    public static final String TYPE_RSA = "RSA";

    public SignUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void createKeys(Context context, String str) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.add(1, 3);
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", KEYSTORE_PROVIDER_ANDROID_KEYSTORE);
        KeyGenParameterSpec build = new KeyGenParameterSpec.Builder(str, 4).setCertificateSubject(new X500Principal("CN=" + str)).setDigests(KeyPropertiesCompact.DIGEST_SHA256).setSignaturePaddings(KeyPropertiesCompact.SIGNATURE_PADDING_RSA_PKCS1).setCertificateSerialNumber(BigInteger.valueOf(1337L)).setCertificateNotBefore(gregorianCalendar.getTime()).setCertificateNotAfter(gregorianCalendar2.getTime()).build();
        if (build != null) {
            keyPairGenerator.initialize(build);
            keyPairGenerator.generateKeyPair();
        }
    }

    public static boolean isSupportKeyStore() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER_ANDROID_KEYSTORE);
            keyStore.load(null);
            KeyPairGenerator.getInstance("RSA", KEYSTORE_PROVIDER_ANDROID_KEYSTORE);
            Signature.getInstance(SIGNATURE_SHA256withRSA);
            KeyStore.Entry entry = keyStore.getEntry("test", null);
            if (entry == null) {
                createKeys(BaseApplication.getContext(), "test");
                entry = keyStore.getEntry("test", null);
            }
            if (entry == null) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileInputStream, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readFile(File file) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        String str = null;
        str = null;
        str = null;
        InputStream inputStream = null;
        if (file != null && file.exists()) {
            ?? isFile = file.isFile();
            try {
                try {
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception unused) {
            }
            if (isFile != 0) {
                try {
                    isFile = new FileInputStream(file);
                    try {
                        inputStreamReader2 = new InputStreamReader((InputStream) isFile, "UTF-8");
                    } catch (Exception e16) {
                        e = e16;
                        inputStreamReader2 = null;
                    } catch (Throwable th6) {
                        th = th6;
                        inputStreamReader = null;
                        inputStream = isFile;
                        if (inputStream != null) {
                        }
                        if (inputStreamReader == null) {
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                    isFile = 0;
                    inputStreamReader2 = null;
                } catch (Throwable th7) {
                    th = th7;
                    inputStreamReader = null;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (inputStreamReader == null) {
                        try {
                            inputStreamReader.close();
                            throw th;
                        } catch (Exception unused3) {
                            throw th;
                        }
                    }
                    throw th;
                }
                try {
                    int length = (int) file.length();
                    if (length > 12288) {
                        char[] cArr = new char[4096];
                        StringBuilder sb5 = new StringBuilder(12288);
                        while (true) {
                            int read = inputStreamReader2.read(cArr);
                            if (-1 == read) {
                                break;
                            }
                            sb5.append(cArr, 0, read);
                        }
                        str = sb5.toString();
                    } else {
                        char[] cArr2 = new char[length];
                        str = new String(cArr2, 0, inputStreamReader2.read(cArr2));
                    }
                    try {
                        isFile.close();
                    } catch (Exception unused4) {
                    }
                    inputStreamReader2.close();
                } catch (Exception e18) {
                    e = e18;
                    QLog.e(TAG, 1, "readFile error:", e);
                    if (isFile != 0) {
                        try {
                            isFile.close();
                        } catch (Exception unused5) {
                        }
                    }
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                    return str;
                }
                return str;
            }
        }
        return null;
    }

    public static String signData(Context context, String str, String str2) throws KeyStoreException, UnrecoverableEntryException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, IOException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        byte[] bytes = str.getBytes();
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER_ANDROID_KEYSTORE);
        keyStore.load(null);
        KeyStore.Entry entry = keyStore.getEntry(str2, null);
        if (entry == null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "create new key for:" + str2);
            }
            createKeys(context, str2);
            entry = keyStore.getEntry(str2, null);
        }
        if (entry == null) {
            QLog.e(TAG, 1, "null entry:" + str2);
            return null;
        }
        if (!(entry instanceof KeyStore.PrivateKeyEntry)) {
            QLog.e(TAG, 1, "Not an instance of a PrivateKeyEntry:" + str2);
            return null;
        }
        Signature signature = Signature.getInstance(SIGNATURE_SHA256withRSA);
        signature.initSign(((KeyStore.PrivateKeyEntry) entry).getPrivateKey());
        signature.update(bytes);
        return Base64.encodeToString(signature.sign(), 0);
    }

    public static boolean verifyData(String str, String str2, String str3) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, UnrecoverableEntryException, InvalidKeyException, SignatureException {
        byte[] bytes = str.getBytes();
        if (str2 == null) {
            QLog.e(TAG, 1, "Invalid signature:" + str3);
            return false;
        }
        try {
            byte[] decode = Base64.decode(str2, 0);
            KeyStore keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER_ANDROID_KEYSTORE);
            keyStore.load(null);
            KeyStore.Entry entry = keyStore.getEntry(str3, null);
            if (entry == null) {
                QLog.e(TAG, 1, "No key found under alias:" + str3);
                return false;
            }
            if (!(entry instanceof KeyStore.PrivateKeyEntry)) {
                QLog.e(TAG, 1, "Not an instance of a PrivateKeyEntry:" + str3);
                return false;
            }
            Signature signature = Signature.getInstance(SIGNATURE_SHA256withRSA);
            signature.initVerify(((KeyStore.PrivateKeyEntry) entry).getCertificate());
            signature.update(bytes);
            return signature.verify(decode);
        } catch (IllegalArgumentException e16) {
            QLog.e(TAG, 1, "decode signature error:", e16);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void writeFile(String str, String str2) {
        Throwable th5;
        FileOutputStream fileOutputStream;
        File file = new File(str);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file, false);
            } catch (Exception e16) {
                e = e16;
            } catch (Throwable th6) {
                th = th6;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
            try {
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e17) {
                e = e17;
                fileOutputStream2 = fileOutputStream;
                try {
                    QLog.e(TAG, 1, "writeFile error:", e);
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                } catch (Throwable th7) {
                    fileOutputStream = fileOutputStream2;
                    th5 = th7;
                    th = th5;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th8) {
                th5 = th8;
                th = th5;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        } catch (Exception unused2) {
        }
    }
}
