package com.tencent.qqlive.tvkplayer.qqliveasset.player.source;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.http.TVKHttpProcessorFactory;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUrlBuilder;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.vinfo.checktime.TVKServerTimeGetter;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyDecryptedResult;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyEncryptedResult;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyGenerator;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCkeyParam;
import com.tencent.thumbplayer.api.asset.ITPDrmMediaAsset;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKWidevineLicenseRequester implements ITPDrmMediaAsset.ILicenseRequestListener {
    private static final String HTTP_REQUEST_TAG = "TVKWidevineLicenseRequestListener";
    private static final String TAG = "TVKWidevineLicenseRequestListener";
    private static final String WIDEVINE_LICENSE_REQUEST_QUERY_KEY_APP_VER = "app_ver";
    private static final String WIDEVINE_LICENSE_REQUEST_QUERY_KEY_CKEY = "ckey";
    private static final String WIDEVINE_LICENSE_REQUEST_QUERY_KEY_CKEY_ENCRYPT_VER = "encrypt_ver";
    private static final String WIDEVINE_LICENSE_RESPONSE_JSON_KEY_ANC = "anc";
    private static final String WIDEVINE_LICENSE_RESPONSE_JSON_KEY_CKC = "ckc";
    private final String mLicenseUrl;

    public TVKWidevineLicenseRequester(@NonNull String str) {
        this.mLicenseUrl = str;
    }

    @NonNull
    private Map<String, String> buildWidevineLicenseRequestQueryParams(@NonNull String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("ckey", str);
        hashMap.put(WIDEVINE_LICENSE_REQUEST_QUERY_KEY_APP_VER, TVKVcSystemInfo.getAppVersionName(TVKCommParams.getApplicationContext()));
        hashMap.put("encrypt_ver", TVKCKeyGenerator.getEncryptVer());
        return hashMap;
    }

    @Nullable
    private byte[] decryptLicenseResponse(@NonNull byte[] bArr) {
        String str;
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr, StandardCharsets.UTF_8));
            try {
                str = jSONObject.getString(WIDEVINE_LICENSE_RESPONSE_JSON_KEY_ANC);
            } catch (JSONException unused) {
                TVKLogUtil.i("TVKWidevineLicenseRequestListener", "no anc exists");
                str = null;
            }
            try {
                str2 = jSONObject.getString(WIDEVINE_LICENSE_RESPONSE_JSON_KEY_CKC);
            } catch (JSONException unused2) {
                TVKLogUtil.i("TVKWidevineLicenseRequestListener", "no ckc exists");
                str2 = null;
            }
            if (!TextUtils.isEmpty(str)) {
                TVKCKeyDecryptedResult decryptCKeyServerResponse = TVKCKeyGenerator.decryptCKeyServerResponse(str);
                if (decryptCKeyServerResponse == null) {
                    TVKLogUtil.e("TVKWidevineLicenseRequestListener", "fail to decryptCKeyServerResponse, return null.");
                    return null;
                }
                if (decryptCKeyServerResponse.getRetCode() != 0) {
                    TVKLogUtil.e("TVKWidevineLicenseRequestListener", "fail to decryptCKeyServerResponse, code:" + decryptCKeyServerResponse.getRetCode());
                }
                return decryptCKeyServerResponse.getData();
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    return Base64.decode(str2, 0);
                } catch (IllegalArgumentException unused3) {
                    TVKLogUtil.e("TVKWidevineLicenseRequestListener", "fail to Base64 decode");
                }
            }
            return null;
        } catch (JSONException e16) {
            TVKLogUtil.e("TVKWidevineLicenseRequestListener", e16);
            return null;
        }
    }

    @NonNull
    private TVKCKeyEncryptedResult encryptLicenseRequest(byte[] bArr) {
        return TVKCKeyGenerator.getCKeyWithData(new TVKCkeyParam.Builder(0, null).sdtfrom(TVKVersion.getSdtfrom()).platform(TVKVersion.getPlatform()).appVer(TVKVcSystemInfo.getAppVersionName(TVKCommParams.getApplicationContext())).build(), TVKServerTimeGetter.getInstance().calculateCurrentServerTimeSec(), bArr);
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPDrmMediaAsset.ILicenseRequestListener
    @Nullable
    public ITPDrmMediaAsset.DrmResourceResponse onLicenseRequest(@NonNull ITPDrmMediaAsset.DrmResourceRequest drmResourceRequest) {
        byte[] bArr = drmResourceRequest.data;
        if (bArr != null && drmResourceRequest.timeoutMs >= 0) {
            TVKCKeyEncryptedResult encryptLicenseRequest = encryptLicenseRequest(bArr);
            if (encryptLicenseRequest.getCKey() != null && encryptLicenseRequest.getCipher() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/octet-stream");
                try {
                    byte[] decryptLicenseResponse = decryptLicenseResponse(TVKHttpProcessorFactory.getHttpRequester().execute(new ITVKHttpProcessor.TVKHttpRequest.Builder(ITVKHttpProcessor.TVKHttpRequest.HttpMethod.POST, new TVKUrlBuilder().setUrl(this.mLicenseUrl).addParam(buildWidevineLicenseRequestQueryParams(new String(encryptLicenseRequest.getCKey(), StandardCharsets.UTF_8))).buildUrl()).reqTag("TVKWidevineLicenseRequestListener").headers(hashMap).body(encryptLicenseRequest.getCipher()).callTimeoutMs(drmResourceRequest.timeoutMs).build()).getData());
                    if (decryptLicenseResponse == null) {
                        TVKLogUtil.e("TVKWidevineLicenseRequestListener", "onLicenseRequest, fail to decryptLicenseResponse");
                        return null;
                    }
                    ITPDrmMediaAsset.DrmResourceResponse drmResourceResponse = new ITPDrmMediaAsset.DrmResourceResponse();
                    drmResourceResponse.isSuccess = true;
                    drmResourceResponse.data = decryptLicenseResponse;
                    return drmResourceResponse;
                } catch (IOException e16) {
                    TVKLogUtil.e("TVKWidevineLicenseRequestListener", "onLicenseRequest, fail to request license, exception:" + e16);
                    return null;
                }
            }
            TVKLogUtil.e("TVKWidevineLicenseRequestListener", "onLicenseRequest, fail to encryptRequestData.");
            return null;
        }
        TVKLogUtil.e("TVKWidevineLicenseRequestListener", "onLicenseRequest, illegal argument.");
        return null;
    }
}
