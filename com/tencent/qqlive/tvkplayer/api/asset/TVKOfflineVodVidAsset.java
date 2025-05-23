package com.tencent.qqlive.tvkplayer.api.asset;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKOfflineVodVidAsset extends TVKAssetBase {
    public static final int COMPLETE_OFFLINE = 0;
    public static final int INCOMPLETE_OFFLINE = 1;
    private final String mCid;
    private final int mOfflineType;
    private final String mVid;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface OfflineType {
    }

    public TVKOfflineVodVidAsset(String str, String str2, int i3) {
        this.mVid = TextUtils.isEmpty(str) ? "" : str;
        this.mCid = TextUtils.isEmpty(str2) ? "" : str2;
        this.mOfflineType = i3;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public int getAssetType() {
        return 262144;
    }

    public String getCid() {
        return this.mCid;
    }

    public int getOfflineType() {
        return this.mOfflineType;
    }

    public String getVid() {
        return this.mVid;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public boolean isAssetValid() {
        return !TextUtils.isEmpty(this.mVid);
    }

    @NonNull
    public String toString() {
        return "TVKOfflineVodVidAsset: vid:" + this.mVid + ", cid:" + this.mCid + ", offlineType:" + this.mOfflineType + ", assetType:" + getAssetType();
    }
}
