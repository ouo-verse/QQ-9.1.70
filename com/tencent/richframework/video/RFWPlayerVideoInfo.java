package com.tencent.richframework.video;

import java.util.List;
import java.util.Map;

/* loaded from: classes25.dex */
public class RFWPlayerVideoInfo {
    public int height;
    public List<String> mCookies;
    public int mDurationInMs;
    public Map<String, String> mHttpHeader;
    public long mMinBufferingPacketDurationMs;
    public boolean mRequestAudio;
    public long mStartOffset;
    public String mStorePath;
    public String mUrl;
    public List<String> mVecUrls;
    public String mVid;
    public int width;

    /* loaded from: classes25.dex */
    public static final class RFWVideoInfoBuilder {
        public int height;
        private List<String> mCookies;
        public int mDurationInMs;
        public Map<String, String> mHttpHeader;
        private long mMinBufferingPacketDurationMs;
        public boolean mRequestAudio;
        private long mStartOffset;
        private String mStorePath;
        private String mUrl;
        private List<String> mVecUrls;
        private String mVid;
        public int width;

        RFWVideoInfoBuilder() {
        }

        public static RFWVideoInfoBuilder builder() {
            return new RFWVideoInfoBuilder();
        }

        public RFWPlayerVideoInfo build() {
            RFWPlayerVideoInfo rFWPlayerVideoInfo = new RFWPlayerVideoInfo();
            rFWPlayerVideoInfo.mStorePath = this.mStorePath;
            rFWPlayerVideoInfo.mCookies = this.mCookies;
            rFWPlayerVideoInfo.mUrl = this.mUrl;
            rFWPlayerVideoInfo.mVid = this.mVid;
            rFWPlayerVideoInfo.mStartOffset = this.mStartOffset;
            rFWPlayerVideoInfo.mVecUrls = this.mVecUrls;
            rFWPlayerVideoInfo.mMinBufferingPacketDurationMs = this.mMinBufferingPacketDurationMs;
            rFWPlayerVideoInfo.mRequestAudio = this.mRequestAudio;
            rFWPlayerVideoInfo.mDurationInMs = this.mDurationInMs;
            rFWPlayerVideoInfo.width = this.width;
            rFWPlayerVideoInfo.height = this.height;
            rFWPlayerVideoInfo.mHttpHeader = this.mHttpHeader;
            return rFWPlayerVideoInfo;
        }

        public RFWVideoInfoBuilder setCookies(List<String> list) {
            this.mCookies = list;
            return this;
        }

        public RFWVideoInfoBuilder setDurationInMs(int i3) {
            this.mDurationInMs = i3;
            return this;
        }

        public RFWVideoInfoBuilder setHttpHeader(Map<String, String> map) {
            this.mHttpHeader = map;
            return this;
        }

        public RFWVideoInfoBuilder setMinBufferingPacketDurationMs(long j3) {
            this.mMinBufferingPacketDurationMs = j3;
            return this;
        }

        public RFWVideoInfoBuilder setRequestAudio(boolean z16) {
            this.mRequestAudio = z16;
            return this;
        }

        public RFWVideoInfoBuilder setStartOffset(long j3) {
            this.mStartOffset = j3;
            return this;
        }

        public RFWVideoInfoBuilder setStorePath(String str) {
            this.mStorePath = str;
            return this;
        }

        public RFWVideoInfoBuilder setUrl(String str) {
            this.mUrl = str;
            return this;
        }

        public RFWVideoInfoBuilder setVecUrls(List<String> list) {
            this.mVecUrls = list;
            return this;
        }

        public RFWVideoInfoBuilder setVid(String str) {
            this.mVid = str;
            return this;
        }

        public RFWVideoInfoBuilder setWidthAndHeight(int i3, int i16) {
            this.width = i3;
            this.height = i16;
            return this;
        }
    }
}
