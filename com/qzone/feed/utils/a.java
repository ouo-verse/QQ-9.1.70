package com.qzone.feed.utils;

import android.content.Context;
import android.util.Base64;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f47463a = "com.qzone.feed.utils.a";

    /* renamed from: b, reason: collision with root package name */
    private static String f47464b;

    public static String b(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        d(context);
        if (f47464b == null) {
            return null;
        }
        return new String(com.tencent.securitysdk.utils.c.b(str4 + "_" + a(str5) + "_" + a(str6) + "_" + a(str7) + "_" + a(str8) + "_" + a(str9) + "_" + a(str10) + "_" + a(str11) + "_" + new String(com.tencent.securitysdk.utils.c.b(a(str) + "_" + a(str2) + "_" + a(str3) + "_" + f47464b))));
    }

    private static String c(Context context) {
        String str = null;
        if (context != null) {
            String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_COMMENT_REPLY_REPORT_KEY, "https://jubao.qq.com/uniform_impeach/impeach_cryptokey");
            if (!NetworkState.isNetSupport()) {
                QZLog.e(f47463a, "network not connected: url: " + config);
            } else {
                try {
                    HttpResponse d16 = to.e.d(context, config);
                    if (d16 != null) {
                        if (d16.getStatusLine().getStatusCode() != 200) {
                            QZLog.e(f47463a, "getEnrptedKey http\u8bf7\u6c42\u5931\u8d25\uff01");
                            return null;
                        }
                        HttpEntity entity = d16.getEntity();
                        if (entity != null) {
                            str = new JSONObject(new String(EntityUtils.toByteArray(entity))).getString("key");
                        }
                    }
                } catch (ClientProtocolException e16) {
                    QZLog.e(f47463a, "getEnrptedKey " + e16);
                } catch (IOException e17) {
                    QZLog.e(f47463a, "getEnrptedKey " + e17);
                } catch (JSONException e18) {
                    QZLog.e(f47463a, "getEnrptedKey " + e18);
                }
            }
        }
        return str == null ? "abcdabcdabcdabcd" : str;
    }

    private static void d(Context context) {
        String c16 = c(context);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec("d41d8cd98f00b204e9800998ecf8427e".getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            f47464b = new String(cipher.doFinal(Base64.decode(c16, 0)), "utf-8");
        } catch (UnsupportedEncodingException e16) {
            QZLog.e(f47463a, "initDecryptedKey " + e16);
        } catch (InvalidKeyException e17) {
            QZLog.e(f47463a, "initDecryptedKey " + e17);
        } catch (NoSuchAlgorithmException e18) {
            QZLog.e(f47463a, "initDecryptedKey " + e18);
        } catch (BadPaddingException e19) {
            QZLog.e(f47463a, "initDecryptedKey " + e19);
        } catch (IllegalBlockSizeException e26) {
            QZLog.e(f47463a, "initDecryptedKey " + e26);
        } catch (NoSuchPaddingException e27) {
            QZLog.e(f47463a, "initDecryptedKey " + e27);
        }
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }
}
