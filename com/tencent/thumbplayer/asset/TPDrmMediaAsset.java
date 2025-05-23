package com.tencent.thumbplayer.asset;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPDrmMediaAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPDrmMediaAsset extends TPUrlMediaAsset implements ITPDrmMediaAsset {
    private final Map<String, String> mCertificateHttpHeaderMap;

    @Nullable
    private ITPDrmMediaAsset.ICertificateRequestListener mCertificateRequestListener;
    private String mCertificateUrl;
    private int mDrmType;
    private final Map<String, String> mLicenseHttpHeaderMap;

    @Nullable
    private ITPDrmMediaAsset.ILicenseRequestListener mLicenseRequestListener;
    private String mLicenseUrl;

    public TPDrmMediaAsset(String str, int i3) {
        super(str);
        this.mDrmType = -1;
        this.mCertificateHttpHeaderMap = new HashMap();
        this.mLicenseHttpHeaderMap = new HashMap();
        this.mLicenseRequestListener = null;
        this.mCertificateRequestListener = null;
        this.mDrmType = i3;
    }

    @Override // com.tencent.thumbplayer.asset.TPUrlMediaAsset, com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public int getAssetType() {
        return 5;
    }

    @NonNull
    public Map<String, String> getCertificateHttpHeader() {
        return Collections.unmodifiableMap(this.mCertificateHttpHeaderMap);
    }

    @Nullable
    public ITPDrmMediaAsset.ICertificateRequestListener getCertificateRequestListener() {
        return this.mCertificateRequestListener;
    }

    public String getCertificateUrl() {
        return this.mCertificateUrl;
    }

    public int getDrmType() {
        return this.mDrmType;
    }

    @NonNull
    public Map<String, String> getLicenseHttpHeader() {
        return Collections.unmodifiableMap(this.mLicenseHttpHeaderMap);
    }

    @Nullable
    public ITPDrmMediaAsset.ILicenseRequestListener getLicenseRequestListener() {
        return this.mLicenseRequestListener;
    }

    public String getLicenseUrl() {
        return this.mLicenseUrl;
    }

    @Override // com.tencent.thumbplayer.asset.TPUrlMediaAsset, com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
    public boolean isValid() {
        if (!super.isValid() || this.mDrmType == -1) {
            return false;
        }
        if (this.mLicenseRequestListener == null && TextUtils.isEmpty(this.mLicenseUrl)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPDrmMediaAsset
    public void setCertificateRequestListener(@Nullable ITPDrmMediaAsset.ICertificateRequestListener iCertificateRequestListener) {
        this.mCertificateRequestListener = iCertificateRequestListener;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPDrmMediaAsset
    public void setCertificateUrl(String str) {
        setCertificateUrl(str, null);
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPDrmMediaAsset
    public void setDrmType(int i3) {
        this.mDrmType = i3;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPDrmMediaAsset
    public void setLicenseRequestListener(@Nullable ITPDrmMediaAsset.ILicenseRequestListener iLicenseRequestListener) {
        this.mLicenseRequestListener = iLicenseRequestListener;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPDrmMediaAsset
    public void setLicenseUrl(String str) {
        setLicenseUrl(str, null);
    }

    @Override // com.tencent.thumbplayer.asset.TPUrlMediaAsset, com.tencent.thumbplayer.asset.TPMediaAsset
    public String toString() {
        return "TPDrmMediaAsset(" + super.toString() + ")\ndrmType=" + this.mDrmType + "\ncertificateUrl=" + this.mCertificateUrl + "\ncertificateHeader=" + this.mCertificateHttpHeaderMap + "\nlicenseUrl=" + this.mLicenseUrl + "\nlicenseHeader=" + this.mLicenseHttpHeaderMap + "\nlicenseRequestListener=" + this.mLicenseRequestListener + "\ncertificateRequestListener=" + this.mCertificateRequestListener;
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPDrmMediaAsset
    public void setCertificateUrl(String str, Map<String, String> map) {
        this.mCertificateUrl = str;
        if (map == null || map.isEmpty()) {
            return;
        }
        this.mCertificateHttpHeaderMap.putAll(map);
    }

    @Override // com.tencent.thumbplayer.api.asset.ITPDrmMediaAsset
    public void setLicenseUrl(String str, Map<String, String> map) {
        this.mLicenseUrl = str;
        if (map == null || map.isEmpty()) {
            return;
        }
        this.mLicenseHttpHeaderMap.putAll(map);
    }
}
