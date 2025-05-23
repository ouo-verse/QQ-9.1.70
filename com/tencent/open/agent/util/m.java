package com.tencent.open.agent.util;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes22.dex */
public class m {
    public static String a(String str, String str2, byte[] bArr) {
        try {
            byte[] decode = Base64.decode(str, 0);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(decode));
        } catch (Exception e16) {
            t.d("OpenSdkDESUtils", "decryptAES", e16);
            return null;
        }
    }

    public static String b(String[] strArr, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2)) {
                sb5.append(str2);
            }
        }
        return e(str, sb5.toString());
    }

    public static String c(String str, String str2, byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
        } catch (Exception e16) {
            t.d("OpenSdkDESUtils", "encryptAES", e16);
            return null;
        }
    }

    public static byte[] d(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (Exception e16) {
            t.d("OpenSdkDESUtils", "encryptSha", e16);
            return null;
        }
    }

    public static String e(String str, String str2) {
        if (str == null) {
            t.e("OpenSdkDESUtils", "getDecryptPkgName decryptStr==null !!!!!!");
            return "";
        }
        try {
            byte[] d16 = d(str2);
            if (d16 == null) {
                t.e("OpenSdkDESUtils", "getDecryptPkgName shaBytes==null !!!!!!");
                return "";
            }
            byte[] bArr = new byte[8];
            System.arraycopy(d16, 5, bArr, 0, 8);
            byte[] bArr2 = new byte[16];
            System.arraycopy(d16, 8, bArr2, 0, 16);
            String bytes2HexStr = HexUtil.bytes2HexStr(bArr2);
            if (bytes2HexStr == null) {
                bytes2HexStr = "";
            }
            return a(str, bytes2HexStr, bArr);
        } catch (Exception e16) {
            t.d("OpenSdkDESUtils", "getDecryptPkgName", e16);
            return "";
        }
    }

    public static String f(Activity activity, String str) {
        if (activity == null) {
            t.e("OpenSdkDESUtils", "getEncryptPkgName activity==null !!!!!!");
            return "";
        }
        try {
            byte[] d16 = d(str);
            if (d16 == null) {
                t.e("OpenSdkDESUtils", "getEncryptPkgName shaBytes==null !!!!!!");
                return "";
            }
            byte[] bArr = new byte[8];
            System.arraycopy(d16, 5, bArr, 0, 8);
            byte[] bArr2 = new byte[16];
            System.arraycopy(d16, 8, bArr2, 0, 16);
            return c(activity.getPackageName(), HexUtil.bytes2HexStr(bArr2), bArr);
        } catch (Exception e16) {
            t.d("OpenSdkDESUtils", "getEncryptPkgName", e16);
            return "";
        }
    }

    public static String g(Bundle bundle) {
        String string = bundle.getString("status_os");
        String string2 = bundle.getString("status_machine");
        String string3 = bundle.getString("status_version");
        String string4 = bundle.getString("sdkv");
        String string5 = bundle.getString(CommonConstant.ReqAccessTokenParam.CLIENT_ID);
        String string6 = bundle.getString("need_pay");
        String string7 = bundle.getString(AdParam.PF);
        t.b("OpenSdkDESUtils", "os=", string, ", machine=", string2, ", version=", string3, ", sdkv=", string4, ", appId=", string5, ", needPay=", string6, ", pf=", string7);
        StringBuilder sb5 = new StringBuilder();
        if (string == null) {
            string = "";
        }
        sb5.append(string);
        if (string2 == null) {
            string2 = "";
        }
        sb5.append(string2);
        if (string3 == null) {
            string3 = "";
        }
        sb5.append(string3);
        if (string4 == null) {
            string4 = "";
        }
        sb5.append(string4);
        if (string5 == null) {
            string5 = "";
        }
        sb5.append(string5);
        if (string6 == null) {
            string6 = "";
        }
        sb5.append(string6);
        if (string7 == null) {
            string7 = "";
        }
        sb5.append(string7);
        return sb5.toString();
    }
}
