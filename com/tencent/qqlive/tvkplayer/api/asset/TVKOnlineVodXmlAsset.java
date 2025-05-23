package com.tencent.qqlive.tvkplayer.api.asset;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKOnlineVodXmlAsset extends TVKAssetBase {
    private final String mCid;
    private String mFlowId;
    private final String mVid;
    private final String mXml;

    public TVKOnlineVodXmlAsset(@NonNull String str) {
        this(str, "", "");
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public int getAssetType() {
        return 65536;
    }

    public String getCid() {
        return this.mCid;
    }

    public String getFlowId() {
        return this.mFlowId;
    }

    public String getVid() {
        return this.mVid;
    }

    public String getXml() {
        if (TextUtils.isEmpty(this.mXml)) {
            return "";
        }
        return this.mXml;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public boolean isAssetValid() {
        return !TextUtils.isEmpty(this.mXml);
    }

    public void setFlowId(String str) {
        this.mFlowId = str;
    }

    @NonNull
    public String toString() {
        return "TVKOnlineVodXmlAsset: xml:" + this.mXml + ", vid:" + this.mVid + ", cid:" + this.mCid + ", flowId:" + this.mFlowId + ", assetType:" + getAssetType();
    }

    public TVKOnlineVodXmlAsset(@NonNull String str, String str2, String str3) {
        this.mXml = TextUtils.isEmpty(str) ? "" : str;
        this.mVid = TextUtils.isEmpty(str2) ? "" : str2;
        this.mCid = TextUtils.isEmpty(str3) ? "" : str3;
        this.mFlowId = "";
    }
}
