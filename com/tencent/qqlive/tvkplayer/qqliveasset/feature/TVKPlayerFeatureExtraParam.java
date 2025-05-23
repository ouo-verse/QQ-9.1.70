package com.tencent.qqlive.tvkplayer.qqliveasset.feature;

import java.util.Map;

/* loaded from: classes23.dex */
public class TVKPlayerFeatureExtraParam {
    private final Map<String, String> mAssetExpireRequestMap;
    private final boolean mIsFirstRequestForThisPlay;

    /* loaded from: classes23.dex */
    public static class Builder {
        private boolean mIsFirstRequestForThisPlay = false;
        private Map<String, String> mAssetExpireRequestMap = null;

        public Builder assetExpireRequestMap(Map<String, String> map) {
            this.mAssetExpireRequestMap = map;
            return this;
        }

        public TVKPlayerFeatureExtraParam build() {
            return new TVKPlayerFeatureExtraParam(this);
        }

        public Builder isFirstRequestForThisPlay(boolean z16) {
            this.mIsFirstRequestForThisPlay = z16;
            return this;
        }
    }

    public Map<String, String> getAssetExpireRequestMap() {
        return this.mAssetExpireRequestMap;
    }

    public boolean isFirstRequestForThisPlay() {
        return this.mIsFirstRequestForThisPlay;
    }

    TVKPlayerFeatureExtraParam(Builder builder) {
        this.mIsFirstRequestForThisPlay = builder.mIsFirstRequestForThisPlay;
        this.mAssetExpireRequestMap = builder.mAssetExpireRequestMap;
    }
}
