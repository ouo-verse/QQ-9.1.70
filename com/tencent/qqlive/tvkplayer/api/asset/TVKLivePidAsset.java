package com.tencent.qqlive.tvkplayer.api.asset;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* loaded from: classes23.dex */
public class TVKLivePidAsset extends TVKAssetBase {
    private String mAnchorid;
    private final String mChid;
    private String mLiveAppid;
    private final String mPid;
    private String mRoomid;

    public TVKLivePidAsset(String str, String str2) {
        this.mPid = TextUtils.isEmpty(str) ? "" : str;
        this.mChid = TextUtils.isEmpty(str2) ? "" : str2;
        this.mRoomid = "";
        this.mAnchorid = "";
        this.mLiveAppid = "";
    }

    public String getAnchorid() {
        if (TextUtils.isEmpty(this.mAnchorid)) {
            return "";
        }
        return this.mAnchorid;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public int getAssetType() {
        return 256;
    }

    public String getChid() {
        return this.mChid;
    }

    public String getLiveAppid() {
        if (TextUtils.isEmpty(this.mLiveAppid)) {
            return "";
        }
        return this.mLiveAppid;
    }

    public String getPid() {
        return this.mPid;
    }

    public String getRoomid() {
        if (TextUtils.isEmpty(this.mRoomid)) {
            return "";
        }
        return this.mRoomid;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public boolean isAssetValid() {
        return !TextUtils.isEmpty(this.mPid);
    }

    public void setAnchorid(String str) {
        this.mAnchorid = str;
    }

    public void setLiveAppid(String str) {
        this.mLiveAppid = str;
    }

    public void setRoomid(String str) {
        this.mRoomid = str;
    }

    @NonNull
    public String toString() {
        return "TVKLivePidAsset: pid:" + this.mPid + ", chid:" + this.mChid + ", roomId:" + this.mRoomid + ", anchorId:" + this.mAnchorid + ", liveAppid:" + this.mLiveAppid + ", assetType:" + getAssetType();
    }
}
