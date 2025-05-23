package com.tenpay.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tenpay.QwLog;
import com.tenpay.api.QFuncApi;
import com.tenpay.ndk.QWssl;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CacheEnc implements ICacheEnc {
    private static final String SPLITER = "\\|";
    private String cache_imei;
    private Context context;

    /* renamed from: iv, reason: collision with root package name */
    private String f386485iv;
    private String key;
    private QWssl mQWssl;

    public CacheEnc(Context context) {
        this.cache_imei = "y1HIgmN8Xpa5FC7y1HIgmN8Xpa5FC7y1HIgmN8Xpa5FC7";
        this.context = context;
        this.mQWssl = new QWssl(context);
        String deviceId = QFuncApi.getDeviceId(context);
        if (!TextUtils.isEmpty(deviceId)) {
            this.cache_imei = String.format("%s%s%s", deviceId, deviceId, deviceId);
        }
        this.f386485iv = this.cache_imei.substring(r4.length() - 16);
        byte[] bytes = this.cache_imei.substring(0, 32).getBytes();
        this.key = this.mQWssl.base64Encode(bytes, bytes.length);
    }

    @Override // com.tenpay.cache.ICacheEnc
    public String cacheDec(String str) {
        String[] split = str.split(SPLITER);
        if (split.length < 2) {
            Log.i("delan", "error, ciper is not right...");
            return null;
        }
        String aes256EcmDecrypt = this.mQWssl.aes256EcmDecrypt(this.f386485iv, this.key, split[0], split[1]);
        QwLog.i("decTxt = " + aes256EcmDecrypt);
        return aes256EcmDecrypt;
    }

    @Override // com.tenpay.cache.ICacheEnc
    public String cacheEnc(String str) {
        QWssl.EncInfo aes256EcmEncrypt = this.mQWssl.aes256EcmEncrypt(this.f386485iv, this.key, str);
        if (!TextUtils.isEmpty(aes256EcmEncrypt.encText) && !TextUtils.isEmpty(aes256EcmEncrypt.tagText)) {
            String format = String.format("%s|%s", aes256EcmEncrypt.encText, aes256EcmEncrypt.tagText);
            QwLog.i("encTxt = " + format);
            return format;
        }
        return null;
    }

    @Override // com.tenpay.cache.ICacheEnc
    public String hashKey(String str) {
        String md5 = QFuncApi.md5(str.getBytes());
        QwLog.i("hashKey " + str + " => " + md5);
        return md5;
    }
}
