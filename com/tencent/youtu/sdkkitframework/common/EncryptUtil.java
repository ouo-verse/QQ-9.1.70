package com.tencent.youtu.sdkkitframework.common;

import android.os.Environment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tenpay.utils.SMUtils;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes27.dex */
public class EncryptUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String head = "enhance_encrypt_method=1";
    public static final String publicKey = "04831b62b0b4f66cbd374b03d025dad9f1e4d3e19d2ed6180af3f169bf9de51b600ba6be92d06613a197db786bcfc8da5fbbe154af9566d3bed2ad372395b24843";

    public EncryptUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String byte2String(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b16 : bArr) {
            int i3 = b16 & RegisterType.DOUBLE_HI;
            int i16 = (b16 & 240) >> 4;
            if (i16 >= 10) {
                stringBuffer.append((char) ((i16 - 10) + 97));
            } else {
                stringBuffer.append((char) (i16 + 48));
            }
            if (i3 >= 10) {
                stringBuffer.append((char) ((i3 - 10) + 97));
            } else {
                stringBuffer.append((char) (i3 + 48));
            }
        }
        return stringBuffer.toString();
    }

    private byte char2bytewithasc2(char c16) {
        int i3;
        if (c16 >= '0' && c16 <= '9') {
            i3 = c16 - '0';
        } else {
            char c17 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET;
            if (c16 < 'A' || c16 > 'F') {
                c17 = 'a';
                if (c16 < 'a' || c16 > 'f') {
                    return (byte) 0;
                }
            }
            i3 = (c16 - c17) + 10;
        }
        return (byte) i3;
    }

    public static File createRequestFile(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Environment.getExternalStorageDirectory());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("RequestLog");
        sb5.append(str2);
        File file = new File(sb5.toString());
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        File file2 = new File(file.getPath() + str2 + (str + ".txt"));
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return file2;
    }

    private static byte[] intToBytes(int i3) {
        return new byte[]{(byte) (i3 & 255), (byte) ((i3 >> 8) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 24) & 255)};
    }

    private byte[] string2bytes(String str) {
        int length = (str.length() + 1) / 2;
        byte[] bArr = new byte[length];
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            bArr[i16] = 0;
            if (i3 >= str.length()) {
                break;
            }
            bArr[i16] = (byte) (char2bytewithasc2(str.charAt(i3)) << 4);
            int i17 = i3 + 1;
            if (i17 >= str.length()) {
                break;
            }
            bArr[i16] = (byte) (char2bytewithasc2(str.charAt(i17)) | bArr[i16]);
            i3 = i17 + 1;
        }
        return bArr;
    }

    public static void writeBytesToFile(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = byteArrayInputStream.read(bArr2);
            if (read != -1) {
                fileOutputStream.write(bArr2, 0, read);
            } else {
                byteArrayInputStream.close();
                fileOutputStream.close();
                return;
            }
        }
    }

    public static void writeFile(File file, String str) {
        PrintWriter printWriter = null;
        try {
            try {
                PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                try {
                    printWriter2.println(str);
                    printWriter2.flush();
                    printWriter2.close();
                } catch (Exception e16) {
                    e = e16;
                    printWriter = printWriter2;
                    e.printStackTrace();
                    if (printWriter != null) {
                        printWriter.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    printWriter = printWriter2;
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public String generateEncReq(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, str, str2, str3, str4);
        }
        FaceLiveReq faceLiveReq = new FaceLiveReq();
        faceLiveReq.app_id = str2;
        if (str3 == "") {
            str3 = "not_set";
        }
        faceLiveReq.session_id = str3;
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[16];
        secureRandom.nextBytes(bArr);
        byte[] bArr2 = new byte[16];
        secureRandom.nextBytes(bArr2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, KeyPropertiesCompact.KEY_ALGORITHM_AES);
        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        byte[] bArr3 = new byte[secretKeySpec.getEncoded().length + 16];
        System.arraycopy(secretKeySpec.getEncoded(), 0, bArr3, 0, secretKeySpec.getEncoded().length);
        System.arraycopy(bArr, 0, bArr3, secretKeySpec.getEncoded().length, 16);
        messageDigest.update(bArr3);
        byte[] digest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < digest.length; i3++) {
            if (Integer.toHexString(digest[i3] & 255).length() == 1) {
                stringBuffer.append("0");
                stringBuffer.append(Integer.toHexString(digest[i3] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(digest[i3] & 255));
            }
        }
        faceLiveReq.sign = stringBuffer.toString();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr));
        byte[] doFinal = cipher.doFinal(str.getBytes());
        ByteBuffer wrap = ByteBuffer.wrap(new byte[secretKeySpec.getEncoded().length + 16 + doFinal.length]);
        wrap.put(secretKeySpec.getEncoded());
        wrap.put(bArr);
        wrap.put(doFinal);
        faceLiveReq.data = new String(android.util.Base64.encodeToString(wrap.array(), 2));
        return new WeJson().toJson(faceLiveReq);
    }

    public String generateSMReq(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, str, str2, str3);
        }
        FaceLiveReq faceLiveReq = new FaceLiveReq();
        faceLiveReq.app_id = str2;
        if (str3 == "") {
            str3 = "not_set";
        }
        faceLiveReq.session_id = str3;
        byte[] SM4GenKey = SMUtils.getInstance().SM4GenKey();
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        byte[] sm4GCMEncryptNoPadding = SMUtils.getInstance().sm4GCMEncryptNoPadding(bytes, 16, SM4GenKey, bArr, new byte[0]);
        long SM2InitCtxWithPubKey = SMUtils.getInstance().SM2InitCtxWithPubKey(publicKey);
        byte[] SM2Encrypt = SMUtils.getInstance().SM2Encrypt(SM2InitCtxWithPubKey, SM4GenKey, publicKey);
        SMUtils.getInstance().SM2FreeCtx(SM2InitCtxWithPubKey);
        byte[] bytes2 = ("" + SM2Encrypt.length).getBytes();
        byte[] bArr2 = new byte[16];
        int i3 = 0;
        for (int length = sm4GCMEncryptNoPadding.length - 16; length < sm4GCMEncryptNoPadding.length; length++) {
            bArr2[i3] = sm4GCMEncryptNoPadding[length];
            i3++;
        }
        byte[] bArr3 = new byte[sm4GCMEncryptNoPadding.length - 16];
        for (int i16 = 0; i16 < sm4GCMEncryptNoPadding.length - 16; i16++) {
            bArr3[i16] = sm4GCMEncryptNoPadding[i16];
        }
        String encodeToString = android.util.Base64.encodeToString(bArr3, 2);
        ByteBuffer wrap = ByteBuffer.wrap(new byte[bytes2.length + 32 + head.getBytes().length + SM2Encrypt.length + encodeToString.getBytes().length]);
        wrap.put(head.getBytes());
        wrap.put(bArr);
        wrap.put(bytes2);
        wrap.put(SM2Encrypt);
        wrap.put(bArr2);
        wrap.put(encodeToString.getBytes());
        faceLiveReq.data = new String(android.util.Base64.encodeToString(wrap.array(), 2));
        return new WeJson().toJson(faceLiveReq);
    }
}
