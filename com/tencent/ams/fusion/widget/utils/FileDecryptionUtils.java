package com.tencent.ams.fusion.widget.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Base64InputStream;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FileDecryptionUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FileEncryptionUtils";
    private final String mAesKey;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface DecryptionListener {
        void onFail(String str);

        void onSuccess();
    }

    public FileDecryptionUtils(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.mAesKey = str;
        }
    }

    private static void safeCloseInputStream(InputStream inputStream) {
        Utils.safeCloseInputStream(inputStream);
    }

    private static void safeCloseOutputStream(OutputStream outputStream) {
        Utils.safeCloseOutputStream(outputStream);
    }

    public Bitmap decryptBitmapByAES(String str) {
        FileInputStream fileInputStream;
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        Logger.d(TAG, String.format("aes decrypt bitmap input:%s", str));
        if (TextUtils.isEmpty(str)) {
            Logger.w(TAG, "aes decrypt bitmap failed: empty input file path");
            return null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            file = new File(str);
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream.read(bArr);
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.mAesKey.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, secretKeySpec);
            byte[] doFinal = cipher.doFinal(bArr);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(doFinal, 0, doFinal.length);
            Logger.i(TAG, String.format(Locale.CHINA, "aes decrypt bitmap finish cost:%dms input:%s", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), str));
            return decodeByteArray;
        } catch (Throwable th6) {
            th = th6;
            try {
                Logger.w(TAG, "aes decrypt bitmap failed: " + th.getMessage());
                return null;
            } finally {
                safeCloseInputStream(fileInputStream);
            }
        }
    }

    public Bitmap decryptBitmapByBase64(String str) {
        FileInputStream fileInputStream;
        File file;
        byte[] decode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        Logger.d(TAG, String.format("base64 decrypt bitmap input:%s", str));
        if (TextUtils.isEmpty(str)) {
            Logger.w(TAG, "base64 decrypt bitmap failed: empty input file path");
            return null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            file = new File(str);
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream.read(bArr);
            decode = Base64.decode(bArr, 0);
        } catch (Throwable th6) {
            th = th6;
            try {
                Logger.w(TAG, "base64 decrypt bitmap failed: " + th.getMessage());
                return null;
            } finally {
                safeCloseInputStream(fileInputStream);
            }
        }
        if (decode != null && decode.length > 0) {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            Logger.i(TAG, String.format(Locale.CHINA, "aes decrypt bitmap finish cost:%dms input:%s", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), str));
            return decodeByteArray;
        }
        Logger.w(TAG, "base64 decrypt bitmap failed: decode failed");
        return null;
    }

    public boolean decryptFileByAES(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? decryptFileByAES(str, str2, null) : ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).booleanValue();
    }

    public boolean decryptFileByBase64(String str, String str2) {
        Base64InputStream base64InputStream;
        FileOutputStream fileOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        Logger.d(TAG, String.format("base64 decrypt input:%s, output:%s", str, str2));
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            FileInputStream fileInputStream = null;
            try {
                File file = new File(str);
                File file2 = new File(str2);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    base64InputStream = new Base64InputStream(fileInputStream2, 0);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    base64InputStream = null;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = base64InputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            Logger.i(TAG, String.format(Locale.CHINA, "base64 encrypt finish cost:%dms input:%s, output:%s", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), str, str2));
                            safeCloseInputStream(fileInputStream2);
                            safeCloseInputStream(base64InputStream);
                            safeCloseOutputStream(fileOutputStream);
                            return true;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream = fileInputStream2;
                    try {
                        Logger.w(TAG, "base64 decrypt failed: " + th.getMessage());
                        return false;
                    } finally {
                        safeCloseInputStream(fileInputStream);
                        safeCloseInputStream(base64InputStream);
                        safeCloseOutputStream(fileOutputStream);
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                base64InputStream = null;
                fileOutputStream = null;
            }
        } else {
            Logger.w(TAG, "base64 decrypt failed: empty input or output file path");
            return false;
        }
    }

    public String decryptUrlByAES(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.mAesKey.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, secretKeySpec);
            String str2 = new String(cipher.doFinal(decode));
            Logger.i(TAG, "aes decrypt url: " + str2);
            return str2;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public String decryptUrlByBase64(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        try {
            String str2 = new String(Base64.decode(str, 0));
            Logger.i(TAG, "base64 decrypt url: " + str2);
            return str2;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public boolean decryptFileByAES(String str, String str2, DecryptionListener decryptionListener) {
        FileOutputStream fileOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, str2, decryptionListener)).booleanValue();
        }
        Logger.d(TAG, String.format("aes decrypt input:%s, output:%s", str, str2));
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            FileInputStream fileInputStream = null;
            try {
                File file = new File(str);
                File file2 = new File(str2);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = null;
                }
                try {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(this.mAesKey.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
                    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    cipher.init(2, secretKeySpec);
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(cipher.update(bArr, 0, read));
                    }
                    fileOutputStream.write(cipher.doFinal());
                    Logger.i(TAG, String.format(Locale.CHINA, "aes decrypt finish cost:%dms input:%s, output:%s", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), str, str2));
                    if (decryptionListener != null) {
                        decryptionListener.onSuccess();
                    }
                    safeCloseInputStream(fileInputStream2);
                    safeCloseOutputStream(fileOutputStream);
                    return true;
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream = fileInputStream2;
                    try {
                        Logger.w(TAG, "aes decrypt failed: " + th.getMessage());
                        if (decryptionListener != null) {
                            decryptionListener.onFail("exception: " + th.getMessage() + ", inputFilePath:" + str + "outputFilePath: " + str2);
                        }
                        return false;
                    } finally {
                        safeCloseInputStream(fileInputStream);
                        safeCloseOutputStream(fileOutputStream);
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
        } else {
            Logger.w(TAG, "des decrypt failed: empty input or output file path");
            if (decryptionListener != null) {
                decryptionListener.onFail("empty input or output file path, inputFilePath:" + str + "outputFilePath: " + str2);
            }
            return false;
        }
    }
}
