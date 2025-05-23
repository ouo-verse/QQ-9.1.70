package com.tencent.qqlive.tvkplayer.vinfo.api;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;

/* loaded from: classes23.dex */
public class TVKCGIRequestParam {

    @NonNull
    private final ITVKAsset mAsset;
    private final String mDefinition;
    private final String mFlowId;
    private final boolean mIsUserSwitchDefinitionOrAudioTrack;
    private final int mRequestSource;
    private final int mStreamFormatId;

    @NonNull
    private final TVKUserInfo mUserInfo;

    @NonNull
    private final TVKPlayerVideoInfo mVideoInfo;

    /* loaded from: classes23.dex */
    public static class Builder {

        @NonNull
        private final ITVKAsset mAsset;

        @NonNull
        private final TVKUserInfo mUserInfo;

        @NonNull
        private final TVKPlayerVideoInfo mVideoInfo;
        private String mFlowId = "";
        private String mDefinition = "";
        private int mStreamFormatId = 0;
        private int mRequestSource = 0;
        private boolean mIsUserSwitchDefinitionOrAudioTrack = false;

        public Builder(@NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo, @NonNull ITVKAsset iTVKAsset, @NonNull TVKUserInfo tVKUserInfo) {
            this.mVideoInfo = tVKPlayerVideoInfo;
            this.mAsset = iTVKAsset;
            this.mUserInfo = tVKUserInfo;
        }

        public TVKCGIRequestParam build() {
            return new TVKCGIRequestParam(this);
        }

        public Builder definition(String str) {
            this.mDefinition = str;
            return this;
        }

        public Builder flowId(String str) {
            this.mFlowId = str;
            return this;
        }

        public Builder isUserSwitchDefinitionOrAudioTrack(boolean z16) {
            this.mIsUserSwitchDefinitionOrAudioTrack = z16;
            return this;
        }

        public Builder requestSource(int i3) {
            this.mRequestSource = i3;
            return this;
        }

        public Builder streamFormatId(int i3) {
            this.mStreamFormatId = i3;
            return this;
        }
    }

    @NonNull
    public ITVKAsset getAsset() {
        return this.mAsset;
    }

    public String getDefinition() {
        return this.mDefinition;
    }

    public String getFlowId() {
        return this.mFlowId;
    }

    public int getRequestSource() {
        return this.mRequestSource;
    }

    public int getStreamFormatId() {
        return this.mStreamFormatId;
    }

    @NonNull
    public TVKUserInfo getUserInfo() {
        return this.mUserInfo;
    }

    @NonNull
    public TVKPlayerVideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public boolean isUserSwitchDefinitionOrAudioTrack() {
        return this.mIsUserSwitchDefinitionOrAudioTrack;
    }

    TVKCGIRequestParam(Builder builder) {
        this.mFlowId = builder.mFlowId;
        this.mDefinition = builder.mDefinition;
        this.mStreamFormatId = builder.mStreamFormatId;
        this.mUserInfo = builder.mUserInfo;
        this.mVideoInfo = builder.mVideoInfo;
        this.mAsset = builder.mAsset;
        this.mRequestSource = builder.mRequestSource;
        this.mIsUserSwitchDefinitionOrAudioTrack = builder.mIsUserSwitchDefinitionOrAudioTrack;
    }
}
