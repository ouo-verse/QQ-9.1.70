package com.tencent.thumbplayer.api.asset;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* loaded from: classes26.dex */
public interface ITPDrmMediaAsset extends ITPUrlMediaAsset {
    public static final String TP_ASSET_PARAM_KEY_BOOL_LICENSE_STANDARDIZATION = "tp_asset_param_key_bool_license_standardization";
    public static final String TP_ASSET_PARAM_KEY_STRING_EXT_X_KEY = "ext_x_key";

    /* loaded from: classes26.dex */
    public static class DrmResourceRequest {
        public byte[] data;
        public long timeoutMs;
    }

    /* loaded from: classes26.dex */
    public static class DrmResourceResponse {
        public byte[] data;
        public boolean isSuccess;
    }

    /* loaded from: classes26.dex */
    public interface ICertificateRequestListener {
        @Nullable
        DrmResourceResponse onCertificateRequest(@NonNull DrmResourceRequest drmResourceRequest);
    }

    /* loaded from: classes26.dex */
    public interface ILicenseRequestListener {
        @Nullable
        DrmResourceResponse onLicenseRequest(@NonNull DrmResourceRequest drmResourceRequest);
    }

    void setCertificateRequestListener(@Nullable ICertificateRequestListener iCertificateRequestListener);

    void setCertificateUrl(String str);

    void setCertificateUrl(String str, Map<String, String> map);

    void setDrmType(int i3);

    void setLicenseRequestListener(@Nullable ILicenseRequestListener iLicenseRequestListener);

    void setLicenseUrl(String str);

    void setLicenseUrl(String str, Map<String, String> map);
}
