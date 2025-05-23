package com.tencent.gamematrix.gmcg.sdk.service;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGModelAbility {
    public DeviceLib device_lib;
    public SuperResolution super_resolution;
    public VideoCodec video_codec;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class DeviceLib {
        public String model;
        public String name;
        public String score;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class SuperResolution {
        public int support;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class VideoCodec {
        public int codec;
        public int decode;
    }

    public boolean isH264() {
        VideoCodec videoCodec = this.video_codec;
        if (videoCodec != null && videoCodec.codec == 1) {
            return true;
        }
        return false;
    }

    public boolean isH265() {
        VideoCodec videoCodec = this.video_codec;
        if (videoCodec != null && videoCodec.codec == 2) {
            return true;
        }
        return false;
    }

    public boolean isHardDecode() {
        VideoCodec videoCodec = this.video_codec;
        if (videoCodec != null && videoCodec.decode == 1) {
            return true;
        }
        return false;
    }

    public boolean isSoftDecode() {
        VideoCodec videoCodec = this.video_codec;
        if (videoCodec != null && videoCodec.decode == 2) {
            return true;
        }
        return false;
    }
}
