package com.tencent.ad.tangram.statistics;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.config.AdConfigManager;
import com.tencent.ad.tangram.config.data.AdConfigForMsgReport;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.util.AdCryptoUtil;
import com.tencent.ad.tangram.util.AdGZipUtil;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdReporterForSdkMsg {
    private static final String CIPHER_ALGORITHM = String.format("AES/%s/PKCS7Padding", KeyPropertiesCompact.BLOCK_MODE_ECB);
    private static final String KEY_ALGORITHM = "AES";
    public static final int MSG_CODE_RELATION_TARGET_MATCH = 1006;
    private static final String MSG_KEY_BUSINESS = "biz";
    private static final String MSG_KEY_PLACEMENTINFO = "plc";
    private static final String MSG_KEY_SDK = "sdk";
    private static final String SDK_SERVER_MSG_URL = "https://sdkreport.e.qq.com/xq_msg";
    private static final String TAG = "AdReporterForSdkMsg";

    @Nullable
    private static JSONObject buildBizData(@Nullable Ad ad5, int i3, @Nullable JSONObject jSONObject) throws JSONException {
        if (ad5 != null && ad5.isValid() && jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("code", Integer.valueOf(i3));
            jSONObject2.putOpt("threadid", "");
            jSONObject2.putOpt("data", jSONObject);
            return jSONObject2;
        }
        return null;
    }

    @Nullable
    private static JSONObject buildPlacementInfo(@Nullable Ad ad5) throws JSONException {
        if (ad5 != null && ad5.isValid()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("posid", ad5.getPosId());
            jSONObject.putOpt("adtype", 0);
            return jSONObject;
        }
        return null;
    }

    private static JSONObject buildSDKInfo() {
        JSONObject newJSONObject = AdJSONUtil.newJSONObject();
        AdJSONUtil.put(newJSONObject, "sdk_st", 9);
        return newJSONObject;
    }

    private static byte[] getCryptoKey(WeakReference<Context> weakReference) {
        AdConfigForMsgReport configForMsgReport = AdConfigManager.getInstance().getConfigForMsgReport();
        return getCryptoKey(configForMsgReport != null ? configForMsgReport.f61319k : null);
    }

    @NonNull
    private static AdHttp.Params getRequestParams(String str, byte[] bArr) {
        AdHttp.Params params = new AdHttp.Params();
        params.setUrl(str);
        params.method = "POST";
        params.contentType = "application/x-www-form-urlencoded";
        params.requestData = bArr;
        return params;
    }

    @Nullable
    public static byte[] pack(@Nullable byte[] bArr, byte[] bArr2) {
        DataOutputStream dataOutputStream;
        if (bArr != null && bArr.length > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            AdCryptoUtil.Params params = new AdCryptoUtil.Params();
            params.keyAlgorithm = "AES";
            params.cipherAlgorithm = CIPHER_ALGORITHM;
            params.key = bArr2;
            byte[] bArr3 = null;
            try {
                try {
                    dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                } catch (Throwable th5) {
                    th = th5;
                    dataOutputStream = null;
                }
            } catch (Throwable th6) {
                AdLog.e(TAG, "pack exception", th6);
            }
            try {
                dataOutputStream.write(AdCryptoUtil.encrypt(params, AdGZipUtil.compress(bArr)));
                bArr3 = byteArrayOutputStream.toByteArray();
                dataOutputStream.close();
                byteArrayOutputStream.close();
            } catch (Throwable th7) {
                th = th7;
                try {
                    AdLog.e(TAG, "pack failed", th);
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    byteArrayOutputStream.close();
                    return bArr3;
                } catch (Throwable th8) {
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Throwable th9) {
                            AdLog.e(TAG, "pack exception", th9);
                            throw th8;
                        }
                    }
                    byteArrayOutputStream.close();
                    throw th8;
                }
            }
            return bArr3;
        }
        return bArr;
    }

    private static void reportForAnalysis(Context context, Ad ad5, boolean z16) {
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, gdt_analysis_event.CONFIG_REPORT_FOR_MSG, ad5);
        if (createEventForAd == null) {
            AdLog.e(TAG, "[reportForAnalysis] error, event is null");
        } else {
            createEventForAd.internalErrorCode = !z16 ? 1 : 0;
            AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForAd, 103));
        }
    }

    public static void reportMsg(@Nullable WeakReference<Context> weakReference, Ad ad5, int i3, JSONObject jSONObject) {
        Context context;
        boolean z16;
        Context context2;
        AdLog.i(TAG, String.format("reportMsg code: %d", Integer.valueOf(i3)));
        byte[] cryptoKey = getCryptoKey(weakReference);
        Context context3 = null;
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        if (cryptoKey != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        reportForAnalysis(context, ad5, z16);
        if (cryptoKey == null) {
            AdLog.e(TAG, "reportMsg crypto key empty");
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AdLog.e(TAG, "reportMsg could not run on main thread");
            return;
        }
        if (weakReference != null) {
            context2 = weakReference.get();
        } else {
            context2 = null;
        }
        AdAnalysisHelperForStatistics.reportForSdkMsgStatisticsStart(context2, ad5, SDK_SERVER_MSG_URL);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MSG_KEY_SDK, buildSDKInfo());
            jSONObject2.putOpt("plc", buildPlacementInfo(ad5));
            jSONObject2.putOpt("biz", buildBizData(ad5, i3, jSONObject));
            AdHttp.Params requestParams = getRequestParams(SDK_SERVER_MSG_URL, pack(jSONObject2.toString().getBytes("UTF-8"), cryptoKey));
            AdHttp.send(requestParams);
            if (weakReference != null) {
                context3 = weakReference.get();
            }
            AdAnalysisHelperForStatistics.reportForSdkMsgStatisticsEnd(context3, ad5, requestParams);
            AdLog.i(TAG, String.format("reportMsg %s", jSONObject2.toString()));
        } catch (Throwable th5) {
            AdLog.e(TAG, "reportMsg error, req params construct error.", th5);
        }
    }

    @TargetApi(9)
    @Nullable
    public static byte[] unpack(@Nullable byte[] bArr, byte[] bArr2) {
        ByteArrayInputStream byteArrayInputStream;
        DataInputStream dataInputStream;
        if (bArr != null && bArr.length >= 4) {
            AdCryptoUtil.Params params = new AdCryptoUtil.Params();
            params.keyAlgorithm = "AES";
            params.cipherAlgorithm = CIPHER_ALGORITHM;
            params.key = bArr2;
            byte[] bArr3 = null;
            try {
                try {
                    byteArrayInputStream = new ByteArrayInputStream(bArr);
                    try {
                        dataInputStream = new DataInputStream(byteArrayInputStream);
                    } catch (Throwable th5) {
                        th = th5;
                        dataInputStream = null;
                    }
                    try {
                        bArr3 = AdGZipUtil.decompress(AdCryptoUtil.decrypt(params, bArr));
                        byteArrayInputStream.close();
                        dataInputStream.close();
                    } catch (Throwable th6) {
                        th = th6;
                        try {
                            AdLog.e(TAG, "unpack failed while packaging byte array", th);
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                            if (dataInputStream != null) {
                                dataInputStream.close();
                            }
                            return bArr3;
                        } catch (Throwable th7) {
                            if (byteArrayInputStream != null) {
                                try {
                                    byteArrayInputStream.close();
                                } catch (Throwable th8) {
                                    AdLog.e(TAG, "unpack", th8);
                                    throw th7;
                                }
                            }
                            if (dataInputStream != null) {
                                dataInputStream.close();
                            }
                            throw th7;
                        }
                    }
                } catch (Throwable th9) {
                    th = th9;
                    byteArrayInputStream = null;
                    dataInputStream = null;
                }
            } catch (Throwable th10) {
                AdLog.e(TAG, "unpack", th10);
            }
            return bArr3;
        }
        AdLog.e(TAG, "unpack failed formatError");
        return bArr;
    }

    public static byte[] getCryptoKey(String str) {
        if (str != null && str.length() > 8) {
            try {
                return Base64.decode(str.substring(8), 0);
            } catch (Throwable th5) {
                AdLog.e(TAG, "getCryptoKey", th5);
            }
        }
        return null;
    }
}
