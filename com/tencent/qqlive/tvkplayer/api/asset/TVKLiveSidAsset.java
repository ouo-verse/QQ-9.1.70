package com.tencent.qqlive.tvkplayer.api.asset;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLiveSidAsset extends TVKAssetBase {
    private final String mPid;
    private final String mSid;

    public TVKLiveSidAsset(@NonNull String str, @Nullable String str2) {
        this.mSid = TextUtils.isEmpty(str) ? "" : str;
        this.mPid = TextUtils.isEmpty(str2) ? "" : str2;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public int getAssetType() {
        return 512;
    }

    public String getPid() {
        return this.mPid;
    }

    public String getSid() {
        return this.mSid;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public boolean isAssetValid() {
        return !TextUtils.isEmpty(this.mSid);
    }

    @NonNull
    public String toString() {
        return "TVKLiveSidAsset: sid:" + this.mSid + ", pid:" + this.mPid + ", assetType:" + getAssetType();
    }
}
