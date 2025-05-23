package com.tenpay.sdk.util;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.api.QFuncProxy;
import com.tenpay.ndk.DesDecUtil;
import com.tenpay.ndk.DesEncUtil;
import com.tenpay.sdk.Cgi;
import com.tenpay.util.MD5;
import com.tenpay.util.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ConfigUtil {
    private static final String CONFIG_SURFIX = "tenpay_qrcode";
    private static final String KEY_IS_CHARGE_TIPS = "is_charge_tips";
    private static final String SP_QRCODE = "qrcode_config";
    private static final String TAG = "ConfigUtil";
    private static final String UNIFIED_CONFIG_FILE_NAME = "qb_tenpay_unified_config";
    private static final String UNIFIED_CONFIG_SP = "qb_tenpay_prefer";
    private static final String WITHDRAW_DEFAULT_BANK = "qb_tenpay_withdraw_bank";
    private static JSONObject mUnifiedConfig;

    public static int getQRTransQuota(int i3) {
        int i16;
        JSONObject optJSONObject;
        if (mUnifiedConfig == null) {
            loadUnifiedConfig();
        }
        JSONObject jSONObject = mUnifiedConfig;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("qpayment")) != null) {
            i16 = optJSONObject.optInt("generate_qr_code_max_fee");
        } else {
            i16 = 0;
        }
        if (i16 <= 0) {
            return i3;
        }
        return i16;
    }

    public static String getQrcodeUrl(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer("https://i.qianbao.qq.com/wallet/sqrcode.htm?m=tenpay&f=wallet");
        if (map == null) {
            QwLog.i("error in map, is null!");
            return stringBuffer.toString();
        }
        for (String str : map.keySet()) {
            stringBuffer.append(String.format("&%s=%s", str, map.get(str)));
        }
        return stringBuffer.toString();
    }

    public static int getTransQuota() {
        JSONObject optJSONObject;
        if (mUnifiedConfig == null) {
            loadUnifiedConfig();
        }
        JSONObject jSONObject = mUnifiedConfig;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("qpayment")) != null) {
            return optJSONObject.optInt("large_transfer_remind_fee");
        }
        return 0;
    }

    public static String getTransQuotaMsg() {
        JSONObject optJSONObject;
        if (mUnifiedConfig == null) {
            loadUnifiedConfig();
        }
        JSONObject jSONObject = mUnifiedConfig;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("qpayment")) != null) {
            return optJSONObject.optString("large_transfer_remind_msg");
        }
        return null;
    }

    public static int getUnifiedConfigVersion() {
        return com.tencent.mobileqq.qwallet.utils.g.e("qpay_unified_config_ver", -1);
    }

    public static boolean loadUnifiedConfig() {
        boolean z16 = false;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = BaseApplication.getContext().openFileInput(UNIFIED_CONFIG_FILE_NAME);
            byte[] bArr = new byte[1024];
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                sb5.append(new String(bArr, 0, read));
            }
            mUnifiedConfig = new JSONObject(sb5.toString());
            Utils.closeObject(fileInputStream);
            z16 = true;
        } catch (Throwable th5) {
            try {
                QLog.e("ConfigUtil", 1, "", th5);
            } finally {
                Utils.closeObject(fileInputStream);
            }
        }
        if (!z16) {
            com.tencent.mobileqq.qwallet.utils.g.s("qpay_unified_config_ver");
        }
        return z16;
    }

    public static String parseValueByKey(String str, String str2) {
        for (String str3 : str.split("\\|")) {
            if (str3.startsWith(str2)) {
                return str3.substring(str2.length() + 1);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public static byte[] readEncrptConfigFile(String str, int i3, byte[] bArr) {
        byte[] bArr2;
        File file = new File(str);
        ?? r16 = 0;
        r1 = null;
        byte[] bArr3 = null;
        FileInputStream fileInputStream = null;
        r16 = 0;
        if (file.exists()) {
            int length = (int) file.length();
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        try {
                            if (fileInputStream2.read(bArr, 0, i3) == i3) {
                                int i16 = length - i3;
                                bArr2 = new byte[i16];
                                try {
                                    if (fileInputStream2.read(bArr2) == i16) {
                                        bArr3 = bArr2;
                                    }
                                } catch (Exception e16) {
                                    e = e16;
                                    fileInputStream = fileInputStream2;
                                    QLog.e("ConfigUtil", 1, "", e);
                                    Utils.closeObject(fileInputStream);
                                    r16 = bArr2;
                                    return r16;
                                }
                            }
                            Utils.closeObject(fileInputStream2);
                            r16 = bArr3;
                        } catch (Throwable th5) {
                            th = th5;
                            r16 = fileInputStream2;
                            Utils.closeObject(r16);
                            throw th;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        bArr2 = null;
                    }
                } catch (Exception e18) {
                    e = e18;
                    bArr2 = null;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return r16;
    }

    public static boolean readIsChargeTips(String str) {
        BaseApplication context = BaseApplication.getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getSharedPreferences(WITHDRAW_DEFAULT_BANK, 0).getBoolean(KEY_IS_CHARGE_TIPS + str, false);
        } catch (Exception e16) {
            QLog.e("ConfigUtil", 1, "", e16);
            return false;
        }
    }

    public static String readQRCodeConfig(String str) {
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            return "";
        }
        try {
            String decDesWithStringKey = new DesDecUtil(context).decDesWithStringKey(MD5.hexdigest(str + com.tencent.mobileqq.base.b.d() + QFuncProxy.getDeviceId(context)).substring(0, 16), context.getSharedPreferences(SP_QRCODE, 0).getString("qrcode" + str, ""));
            if (!decDesWithStringKey.endsWith(CONFIG_SURFIX)) {
                return "";
            }
            return decDesWithStringKey.substring(0, decDesWithStringKey.length() - 13);
        } catch (Exception e16) {
            QLog.e("ConfigUtil", 1, "", e16);
            return "";
        }
    }

    public static String readWithDrawBank(String str) {
        BaseApplication context = BaseApplication.getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new DesDecUtil(context).decDesWithStringKey(MD5.hexdigest(str + com.tencent.mobileqq.base.b.d() + QFuncProxy.getDeviceId(context)).substring(0, 16), context.getSharedPreferences(WITHDRAW_DEFAULT_BANK, 0).getString("bank_info" + str, ""));
        } catch (Exception e16) {
            QLog.e("ConfigUtil", 1, "", e16);
            return "";
        }
    }

    public static void saveIsChargeTips(String str, boolean z16) {
        BaseApplication context = BaseApplication.getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(WITHDRAW_DEFAULT_BANK, 0).edit();
                edit.putBoolean(KEY_IS_CHARGE_TIPS + str, z16);
                edit.commit();
            } catch (Exception e16) {
                QLog.e("ConfigUtil", 1, "", e16);
            }
        }
    }

    public static void saveQRCodeConfig(JSONObject jSONObject, String str) {
        BaseApplication context = BaseApplication.getContext();
        if (context != null && jSONObject != null) {
            try {
                String substring = MD5.hexdigest(str + com.tencent.mobileqq.base.b.d() + QFuncProxy.getDeviceId(context)).substring(0, 16);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(jSONObject.toString());
                sb5.append(CONFIG_SURFIX);
                String encryptDesWithStringKey = new DesEncUtil(context).encryptDesWithStringKey(substring, sb5.toString());
                SharedPreferences.Editor edit = context.getSharedPreferences(SP_QRCODE, 0).edit();
                edit.putString("qrcode" + str, encryptDesWithStringKey);
                edit.commit();
            } catch (Exception e16) {
                QLog.e("ConfigUtil", 1, "", e16);
            }
        }
    }

    public static void saveUnifiedConfig(JSONObject jSONObject) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                jSONObject2.remove("retcode");
                jSONObject2.remove("retmsg");
                mUnifiedConfig = jSONObject2;
                fileOutputStream = BaseApplication.getContext().openFileOutput(UNIFIED_CONFIG_FILE_NAME, 0);
                fileOutputStream.write(jSONObject2.toString().getBytes());
                fileOutputStream.flush();
                String parseValueByKey = parseValueByKey(jSONObject2.getString("interf_cache_ver"), "QPAY");
                if (!TextUtils.isEmpty(parseValueByKey)) {
                    com.tencent.mobileqq.qwallet.utils.g.n("qpay_unified_config_ver", Integer.parseInt(parseValueByKey));
                }
            } catch (Exception e16) {
                QLog.e("ConfigUtil", 1, "", e16);
            }
        } finally {
            Utils.closeObject(fileOutputStream);
        }
    }

    public static void saveUserInfoExtend(String str, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info_extend");
            if (optJSONObject != null) {
                if (optJSONObject.optJSONArray("address_suggest") != null || optJSONObject.optJSONArray("job_suggest") != null) {
                    TenUtils.saveJsonToSP("user_info_extend" + str, str, "user_info_extend", optJSONObject.toString(), Cgi.userInfoExtendEnc);
                }
            }
        } catch (Exception e16) {
            QLog.e("ConfigUtil", 1, "", e16);
        }
    }

    public static void saveWithDrawBank(String str, String str2) {
        BaseApplication context = BaseApplication.getContext();
        if (context != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                String encryptDesWithStringKey = new DesEncUtil(context).encryptDesWithStringKey(MD5.hexdigest(str + com.tencent.mobileqq.base.b.d() + QFuncProxy.getDeviceId(context)).substring(0, 16), str2);
                SharedPreferences.Editor edit = context.getSharedPreferences(WITHDRAW_DEFAULT_BANK, 0).edit();
                edit.putString("bank_info" + str, encryptDesWithStringKey);
                edit.commit();
            } catch (Exception e16) {
                QLog.e("ConfigUtil", 1, "", e16);
            }
        }
    }
}
