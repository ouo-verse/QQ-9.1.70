package com.tencent.midas.comm.log.processor;

import com.tencent.midas.comm.log.util.APBytesUtil;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes9.dex */
public class APLogEncryptor {
    private static String ENCRYPT_KEY = "}VjZtoJF;dE+7iJs";
    private static final byte MAGIC_END = 0;
    private static final byte MAGIC_START = 2;
    private static byte PROTOCOL_VERSION = 1;
    private static byte[] header = new byte[7];
    private Cipher encryptCipher = null;

    private static byte[] assembleHeader(int i3) {
        System.arraycopy(APBytesUtil.int2bytes(i3), 0, header, 3, 4);
        return header;
    }

    public static APLogEncryptor create() {
        APLogEncryptor aPLogEncryptor = new APLogEncryptor();
        aPLogEncryptor.init();
        return aPLogEncryptor;
    }

    private void init() {
        try {
            byte[] bArr = header;
            bArr[0] = 2;
            bArr[1] = PROTOCOL_VERSION;
            SecretKeySpec secretKeySpec = new SecretKeySpec(ENCRYPT_KEY.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            this.encryptCipher = cipher;
            cipher.init(1, secretKeySpec);
        } catch (InvalidKeyException e16) {
            e16.printStackTrace();
        } catch (NoSuchAlgorithmException e17) {
            e17.printStackTrace();
        } catch (NoSuchPaddingException e18) {
            e18.printStackTrace();
        }
    }

    public static void setEncryptKey(String str) {
        ENCRYPT_KEY = str;
    }

    public static void setProtocolVersion(byte b16) {
        PROTOCOL_VERSION = b16;
    }

    public void close() {
        this.encryptCipher = null;
    }

    public byte[] encrypt(byte[] bArr) {
        int length = bArr.length;
        int i3 = length % 16;
        if (i3 != 0) {
            try {
                byte[] bArr2 = new byte[(16 - i3) + length];
                System.arraycopy(bArr, 0, bArr2, 0, length);
                bArr = bArr2;
            } catch (BadPaddingException e16) {
                e16.printStackTrace();
            } catch (IllegalBlockSizeException e17) {
                e17.printStackTrace();
            }
        }
        bArr = this.encryptCipher.doFinal(bArr);
        byte[] assembleHeader = assembleHeader(length);
        int length2 = assembleHeader.length + bArr.length + 1;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(assembleHeader, 0, bArr3, 0, assembleHeader.length);
        System.arraycopy(bArr, 0, bArr3, assembleHeader.length, bArr.length);
        bArr3[length2 - 1] = 0;
        return bArr3;
    }
}
