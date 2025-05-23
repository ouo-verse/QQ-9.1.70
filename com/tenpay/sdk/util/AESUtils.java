package com.tenpay.sdk.util;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tenpay.QwLog;
import com.tenpay.ndk.PassWdEncUtil;
import com.tenpay.proxy.DataProxy;
import com.tenpay.sdk.ToolPool;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AESUtils {
    public static final int AES_KEY_LENGTH = 16;
    private static final String TAG = "AESUtils";

    public static byte[] encrypt(String str, byte[] bArr, byte[] bArr2) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            if (blockSize == 0) {
                return null;
            }
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr3 = new byte[length];
            System.arraycopy(bytes, 0, bArr3, 0, bytes.length);
            cipher.init(1, new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES), new IvParameterSpec(bArr2));
            return cipher.doFinal(bArr3);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            return null;
        }
    }

    public static String encryptInfo(Context context, Map<String, String> map) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : map.keySet()) {
            if (stringBuffer.length() == 0) {
                str = "%s=%s";
            } else {
                str = "&%s=%s";
            }
            stringBuffer.append(String.format(str, str2, map.get(str2)));
        }
        if (stringBuffer.length() == 0) {
            return "";
        }
        QwLog.i("enc info = " + stringBuffer.toString());
        PassWdEncUtil passWdEncUtil = new PassWdEncUtil(context);
        passWdEncUtil.encryptInfo(stringBuffer.toString(), Long.toString(DataProxy.getServerTimeMillis() / 1000), 1);
        return passWdEncUtil.getRSA2048Res();
    }

    public static void encryptInfoIfRsa2048(Context context, Map<String, String> map, Map<String, String> map2) {
        if (ToolPool.instance().isInfo2048()) {
            map.put("params_encrypt_type", ToolPool.RSA_2048);
            map.put("encrypt_data", encryptInfo(context, map2));
        } else {
            map.putAll(map2);
        }
    }
}
