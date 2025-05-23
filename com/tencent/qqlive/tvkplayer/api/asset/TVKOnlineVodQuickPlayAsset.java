package com.tencent.qqlive.tvkplayer.api.asset;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* loaded from: classes23.dex */
public class TVKOnlineVodQuickPlayAsset extends TVKAssetBase {
    private final String mCid;
    private final String mPrevid;

    public TVKOnlineVodQuickPlayAsset(String str, String str2) {
        this.mPrevid = TextUtils.isEmpty(str) ? "" : str;
        this.mCid = TextUtils.isEmpty(str2) ? "" : str2;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public int getAssetType() {
        return 524288;
    }

    public String getCid() {
        return this.mCid;
    }

    public String getPrevid() {
        return this.mPrevid;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public boolean isAssetValid() {
        return !TextUtils.isEmpty(this.mPrevid);
    }

    @NonNull
    public String toString() {
        return "TVKOnlineVodQuickPlayAsset: previd:" + this.mPrevid + ", cid:" + this.mCid + ", assetType:" + getAssetType();
    }
}
