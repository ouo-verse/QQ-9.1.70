package com.tencent.qqlive.tvkplayer.api.asset;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKUrlAsset extends TVKAssetBase {
    private Map<String, String> mCdnHttpHeaderMap;
    private String mFileId;
    private final String mUrl;

    public TVKUrlAsset(@NonNull String str) {
        this.mUrl = TextUtils.isEmpty(str) ? "" : str;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public int getAssetType() {
        return 2;
    }

    public Map<String, String> getCdnHttpHeaderMap() {
        return this.mCdnHttpHeaderMap;
    }

    public String getFileId() {
        return this.mFileId;
    }

    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public boolean isAssetValid() {
        return !TextUtils.isEmpty(this.mUrl);
    }

    public void setCdnHttpHeaderMap(Map<String, String> map) {
        this.mCdnHttpHeaderMap = map;
    }

    public void setFileId(String str) {
        this.mFileId = str;
    }

    @NonNull
    public String toString() {
        return "TVKUrlAsset: url:" + this.mUrl + ", fileId:" + this.mFileId + ", assetType:" + getAssetType();
    }
}
