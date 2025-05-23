package com.tencent.richmedia.videocompress;

/* compiled from: P */
/* loaded from: classes25.dex */
public class VideoConverterConfig {
    public boolean accurateSeek;
    public int destHeight;
    public int destWidth;
    public boolean isMute;
    public int level;
    public String output;
    public int profile;
    public String rotate;
    public float scaleRate;
    public boolean setProfileLevel;
    public SoftwareConfig softwareConfig;
    public long srcBitrate;
    public long srcFrameRate;
    public int srcHeight;
    public int srcWidth;
    public int videoBitRate;
    public int videoFrameRate;
    public boolean isNeedCompress = true;
    public int destQmax = 0;
    public long beginTime = -1;
    public long endTime = -1;
    public int iFrameInterval = 1;
    public int bitrateMode = -1;
    public boolean setRotation = shouldSetRotation();
    public int maxBFrameCount = 3;
    public boolean enableRenderWithoutEGL = false;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class SoftwareConfig {
        public static final int CRF_HIGH_QUALITY = 17;
        public static final int CRF_LOWER_QUALITY = 35;
        public static final int CRF_LOW_QUALITY = 28;
        public static final int CRF_MEDIUM = 23;
        public static final int CRF_RECOMMENDED = 25;
        public static final String ENCODER_X264 = "libx264";
        public static final String ENCODER_X265 = "libx265";
        public static final String PRESET_FAST = "fast";
        public static final String PRESET_FASTER = "faster";
        public static final String PRESET_MEDIUM = "medium";
        public static final String PRESET_RECOMMENDED = "veryfast";
        public static final String PRESET_SLOW = "slow";
        public static final String PRESET_SLOWER = "slower";
        public static final String PRESET_VERY_FAST = "veryfast";
        private int bFrame;
        private String encoder;
        private String preset;
        private int refs;
        public static final SoftwareConfig H264_DEFAULT = getH264Default();
        public static final SoftwareConfig H265_DEFAULT = getH265Default();
        public static final SoftwareConfig H264_HIGH_QUALITY = getH264HighQuality();
        private int crf = 0;
        private int minRateKbps = 0;
        private int maxRateKbps = 0;

        /* compiled from: P */
        /* loaded from: classes25.dex */
        public static class Builder {
            final SoftwareConfig config = new SoftwareConfig();

            public SoftwareConfig build() {
                return this.config;
            }

            public Builder setBFrame(int i3) {
                this.config.bFrame = i3;
                return this;
            }

            public Builder setCrf(int i3) {
                this.config.crf = i3;
                return this;
            }

            public Builder setEncoder(String str) {
                this.config.encoder = str;
                return this;
            }

            public Builder setMaxRateKbps(int i3) {
                this.config.maxRateKbps = i3;
                return this;
            }

            public Builder setMinRateKbps(int i3) {
                this.config.minRateKbps = i3;
                return this;
            }

            public Builder setPreset(String str) {
                this.config.preset = str;
                return this;
            }

            public Builder setRefs(int i3) {
                this.config.refs = i3;
                return this;
            }
        }

        static SoftwareConfig getH264Default() {
            Builder builder = new Builder();
            builder.setEncoder(ENCODER_X264);
            builder.setCrf(25);
            builder.setPreset("veryfast");
            return builder.build();
        }

        static SoftwareConfig getH264HighQuality() {
            Builder builder = new Builder();
            builder.setEncoder(ENCODER_X264);
            builder.setCrf(23);
            builder.setPreset("veryfast");
            return builder.build();
        }

        static SoftwareConfig getH265Default() {
            Builder builder = new Builder();
            builder.setEncoder(ENCODER_X265);
            builder.setCrf(25);
            builder.setPreset("veryfast");
            return builder.build();
        }

        public int getBFrame() {
            return this.bFrame;
        }

        public int getCrf() {
            return this.crf;
        }

        public String getEncoder() {
            return this.encoder;
        }

        public int getMaxRateKbps() {
            return this.maxRateKbps;
        }

        public int getMinRateKbps() {
            return this.minRateKbps;
        }

        public String getPreset() {
            return this.preset;
        }

        public int getRef() {
            return this.refs;
        }

        public String toString() {
            return "SoftwareConfig{crf=" + this.crf + ", preset='" + this.preset + "', encoder='" + this.encoder + "', refs=" + this.refs + ", bFrame=" + this.bFrame + ", minRateKbps=" + this.minRateKbps + ", maxRateKbps=" + this.maxRateKbps + '}';
        }
    }

    private static boolean shouldSetRotation() {
        return false;
    }

    public String toString() {
        return "VideoConverterConfig{srcWidth=" + this.srcWidth + ", srcHeight=" + this.srcHeight + ", srcHeight=" + this.srcHeight + ", srcFrameRate=" + this.srcFrameRate + ", srcBitrate=" + this.srcBitrate + ", videoBitRate=" + this.videoBitRate + ", videoFrameRate=" + this.videoFrameRate + ", destQmax=" + this.destQmax + ", softwareConfig=" + this.softwareConfig + ", destWidth=" + this.destWidth + ", destHeight=" + this.destHeight + ", rotate='" + this.rotate + "', scaleRate=" + this.scaleRate + ", bitrateMode=" + this.bitrateMode + ", setProfileLevel=" + this.setProfileLevel + ", profile=" + this.profile + ", level=" + this.level + ", isMute=" + this.isMute + ", setRotation=" + this.setRotation + ", maxBFrameCount=" + this.maxBFrameCount + ", enableRenderWithoutEGL=" + this.enableRenderWithoutEGL + '}';
    }
}
