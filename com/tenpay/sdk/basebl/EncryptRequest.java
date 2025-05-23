package com.tenpay.sdk.basebl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.api.QFuncApi;
import com.tenpay.api.TenUtilsApi;
import com.tenpay.api.TenpayCache;
import com.tenpay.ndk.CertUtil;
import com.tenpay.ndk.DesDecUtil;
import com.tenpay.ndk.DesEncUtil;
import com.tenpay.ndk.QWssl;
import com.tenpay.sdk.ToolPool;
import com.tenpay.sdk.net.NetUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class EncryptRequest {
    private static final String ECDH_CALC_SECRET = "ECDH_CALC_SECRET";
    private static final String ECDH_PUBLIC_KEY = "ECDH_PUBLIC_KEY";
    private static final String SHARE_KEY_SUCCESS = "SHARE_KEY_SUCCESS";
    private static final String TAG = "EncryptRequest";
    private static DesEncUtil des;
    private static QWssl qWssl;
    private Context ctx;

    public EncryptRequest(Context context) {
        this.ctx = null;
        synchronized (EncryptRequest.class) {
            this.ctx = context;
            qWssl = new QWssl(context);
            des = new DesEncUtil(this.ctx);
        }
    }

    private DecytBean bldataDecrypt(byte[] bArr, String str, String str2) {
        QWssl.DecInfo qwDecryptBL = qWssl.qwDecryptBL(bArr, bArr.length, str);
        QwLog.i("decinfo = " + qwDecryptBL);
        if (qwDecryptBL == null) {
            QwLog.i("error, decrypt...");
            ToolPool.instance().setUseOldEnc(true);
            return new DecytBean(1, 3, null);
        }
        int i3 = qwDecryptBL.tlsCode;
        if (2 == i3) {
            QwLog.i("warning, secret expired...");
            TenpayCache.removeUinKey(this.ctx, str2, ECDH_CALC_SECRET);
            TenpayCache.removeUinKey(this.ctx, str2, ECDH_PUBLIC_KEY);
            return new DecytBean(1, 2, qwDecryptBL.decText);
        }
        if (1 == i3) {
            QwLog.i("share key success...");
            TenpayCache.resetUinCacheTime(this.ctx, str2, ECDH_CALC_SECRET, qwDecryptBL.expireTime);
            TenpayCache.setUinValue(this.ctx, str2, SHARE_KEY_SUCCESS, Boolean.TRUE, qwDecryptBL.expireTime);
            return new DecytBean(1, 1, qwDecryptBL.decText);
        }
        if (3 == i3) {
            QwLog.i("switch to old encrypt...");
            ToolPool.instance().setUseOldEnc(true);
            return new DecytBean(1, 3, qwDecryptBL.decText);
        }
        QwLog.i("normal communication...");
        return new DecytBean(1, 0, qwDecryptBL.decText);
    }

    private String signEncdata(String str, String str2, Map<String, String> map) {
        String str3;
        try {
            if (str.contains("qpay_cert_activate.cgi")) {
                str3 = "cn";
            } else {
                if (!str.contains("qpay_ydt.cgi") && !str.contains("qpay_balance.cgi") && !str.contains("qpay_fpay_regbind.cgi") && !str.contains("qpay_itg_verify.cgi")) {
                    str3 = null;
                }
                str3 = "qpay_cert_cn";
            }
            if (!TextUtils.isEmpty(str3)) {
                return Uri.encode(CertUtil.getInstance(this.ctx).genUserSigNoEncode(map.get(str3), str2));
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-api module: ", e16);
        }
        return null;
    }

    public synchronized DecytBean decypt(String str, String str2, int i3, String str3) {
        if (ToolPool.instance().isEcdhEncrypt(str2)) {
            QwLog.i("decrypt new way...");
            byte[] base64Decode = qWssl.base64Decode(str3);
            if (base64Decode == null) {
                QwLog.i("base64 decode error...");
                return null;
            }
            String str4 = (String) TenpayCache.getUinValue(this.ctx, str, ECDH_CALC_SECRET, "");
            QwLog.i("calc_secret = " + str4);
            return bldataDecrypt(base64Decode, str4, str);
        }
        DesDecUtil desDecUtil = new DesDecUtil(this.ctx);
        desDecUtil.decryptDes(i3, str3);
        String decRes = desDecUtil.getDecRes();
        if (decRes != null && decRes.startsWith("{")) {
            return new DecytBean(0, -1, decRes);
        }
        desDecUtil.decryptDes(0, str3);
        return new DecytBean(0, -1, desDecUtil.getDecRes());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0187 A[Catch: all -> 0x01ae, TryCatch #0 {, blocks: (B:8:0x000c, B:10:0x001a, B:11:0x002d, B:13:0x007d, B:15:0x00b0, B:19:0x00ed, B:21:0x0187, B:22:0x018d, B:25:0x00b9, B:26:0x0196), top: B:7:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Encrypt encypt(String str, String str2, int i3, String str3, String str4, String str5) {
        if (str3 == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = false;
        if (!TextUtils.isEmpty(str4)) {
            sb5.append(String.format("%s=%s&", "pskey", str4));
        }
        sb5.append(str3);
        sb5.append("&h_net_type=");
        sb5.append(TenUtilsApi.getNetworkType(this.ctx.getApplicationContext()));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append(NetUtil.getDeviceInfo(this.ctx, str5));
        QwLog.i(String.format("final req params %s => %s", str2, sb5));
        String msgNo = QFuncApi.getMsgNo(str);
        HashMap hashMap = new HashMap();
        hashMap.put("msgno", msgNo);
        if (ToolPool.instance().isEcdhEncrypt(str2)) {
            String str6 = (String) TenpayCache.getUinValue(this.ctx, str, ECDH_CALC_SECRET, "");
            String str7 = (String) TenpayCache.getUinValue(this.ctx, str, ECDH_PUBLIC_KEY, "");
            boolean booleanValue = ((Boolean) TenpayCache.getUinValue(this.ctx, str, SHARE_KEY_SUCCESS, Boolean.FALSE)).booleanValue();
            if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7)) {
                z16 = booleanValue;
                QwLog.i("enc_info pub_key = " + str7);
                QwLog.i("enc_info calc_secret = " + str6);
                String substring = msgNo.substring(msgNo.length() + (-16));
                QwLog.i("enc_info iv = " + substring);
                QWssl.EncInfo aes256EcmEncrypt = qWssl.aes256EcmEncrypt(substring, str6, sb5.toString());
                QwLog.i("enc_info cipher = " + aes256EcmEncrypt.encText);
                QwLog.i("enc_info tag = " + aes256EcmEncrypt.tagText);
                hashMap.put("tag", aes256EcmEncrypt.tagText);
                hashMap.put("e_type", "1");
                hashMap.put("uin", str);
                if (!z16) {
                    hashMap.put("public_key", str7);
                }
                return new Encrypt(aes256EcmEncrypt.encText, hashMap);
            }
            QwLog.i("re generate public key...");
            TenpayCache.removeUinKey(this.ctx, str, SHARE_KEY_SUCCESS);
            QWssl.KeyInfo ecdh = qWssl.ecdh();
            Context context = this.ctx;
            String str8 = ecdh.calcSecret;
            TenpayCache.setUinValue(context, str, ECDH_CALC_SECRET, str8, 31536000L);
            Context context2 = this.ctx;
            String str9 = ecdh.pubKey;
            TenpayCache.setUinValue(context2, str, ECDH_PUBLIC_KEY, str9, 31536000L);
            str7 = str9;
            str6 = str8;
            QwLog.i("enc_info pub_key = " + str7);
            QwLog.i("enc_info calc_secret = " + str6);
            String substring2 = msgNo.substring(msgNo.length() + (-16));
            QwLog.i("enc_info iv = " + substring2);
            QWssl.EncInfo aes256EcmEncrypt2 = qWssl.aes256EcmEncrypt(substring2, str6, sb5.toString());
            QwLog.i("enc_info cipher = " + aes256EcmEncrypt2.encText);
            QwLog.i("enc_info tag = " + aes256EcmEncrypt2.tagText);
            hashMap.put("tag", aes256EcmEncrypt2.tagText);
            hashMap.put("e_type", "1");
            hashMap.put("uin", str);
            if (!z16) {
            }
            return new Encrypt(aes256EcmEncrypt2.encText, hashMap);
        }
        des.encryptDes(i3, sb5.toString());
        return new Encrypt(des.getDesEncResult(), hashMap);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Encrypt {
        public final String encText;
        public final Map<String, String> postParams;

        public Encrypt(String str) {
            this.postParams = new HashMap();
            this.encText = str;
        }

        public Encrypt(String str, Map<String, String> map) {
            this(str);
            if (map == null || map.size() <= 0) {
                return;
            }
            this.postParams.putAll(map);
        }
    }
}
