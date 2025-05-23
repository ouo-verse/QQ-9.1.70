package com.tencent.qqlive.tvkplayer.vinfo.common;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class TVKCkeyParam {
    private final String mAppVer;
    private final String mAssetIdForCKey;
    private final JSONObject mExtraJson;
    private final Map<String, String> mExtraParamsMap;
    private final String mPlatform;
    private final int mRequestType;
    private final String mSdtfrom;

    /* loaded from: classes23.dex */
    public static class Builder {
        private String mAppVer;
        private final String mAssetIdForCKey;
        private JSONObject mExtraJson;
        private Map<String, String> mExtraParamsMap;
        private String mPlatform;
        private final int mRequestType;
        private String mSdtfrom;

        public Builder(int i3, String str) {
            this.mRequestType = i3;
            this.mAssetIdForCKey = str;
        }

        public Builder appVer(String str) {
            this.mAppVer = str;
            return this;
        }

        public TVKCkeyParam build() {
            return new TVKCkeyParam(this);
        }

        public Builder extraJson(JSONObject jSONObject) {
            this.mExtraJson = jSONObject;
            return this;
        }

        public Builder extraParamsMap(Map<String, String> map) {
            this.mExtraParamsMap = map;
            return this;
        }

        public Builder platform(String str) {
            this.mPlatform = str;
            return this;
        }

        public Builder sdtfrom(String str) {
            this.mSdtfrom = str;
            return this;
        }
    }

    public TVKCkeyParam(Builder builder) {
        this.mRequestType = builder.mRequestType;
        this.mAssetIdForCKey = builder.mAssetIdForCKey;
        this.mPlatform = builder.mPlatform;
        this.mSdtfrom = builder.mSdtfrom;
        this.mAppVer = builder.mAppVer;
        this.mExtraJson = builder.mExtraJson;
        this.mExtraParamsMap = builder.mExtraParamsMap;
    }

    public String getAppVer() {
        return this.mAppVer;
    }

    public String getAssetIdForCKey() {
        return this.mAssetIdForCKey;
    }

    public JSONObject getExtraJson() {
        return this.mExtraJson;
    }

    public Map<String, String> getExtraParamsMap() {
        return this.mExtraParamsMap;
    }

    public String getPlatform() {
        return this.mPlatform;
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public String getSdtfrom() {
        return this.mSdtfrom;
    }
}
