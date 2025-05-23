package com.tencent.qqlive.tvkplayer.api.asset;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKOnlineVodVidAsset extends TVKAssetBase {
    private final String mCid;
    private final String mVid;

    public TVKOnlineVodVidAsset(String str, String str2) {
        this.mVid = TextUtils.isEmpty(str) ? "" : str;
        this.mCid = TextUtils.isEmpty(str2) ? "" : str2;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public int getAssetType() {
        return 131072;
    }

    public String getCid() {
        return this.mCid;
    }

    public String getVid() {
        return this.mVid;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public boolean isAssetValid() {
        if (TextUtils.isEmpty(this.mVid) && TextUtils.isEmpty(this.mCid)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String toString() {
        return "TVKOnlineVodVidAsset: vid:" + this.mVid + ", cid:" + this.mCid + ", assetType:" + getAssetType();
    }
}
