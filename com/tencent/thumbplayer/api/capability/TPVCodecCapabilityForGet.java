package com.tencent.thumbplayer.api.capability;

/* loaded from: classes26.dex */
public class TPVCodecCapabilityForGet {
    private static final int MAX_FRAME_RATE_FOR_LUMA_SAMPLES_DEFAULT = -1;
    private static final int MAX_LEVEL_DEFAULT = -1;
    private static final int MAX_LUMA_SAMPLES_DEFAULT = -1;
    private static final int MAX_PROFILE_DEFAULT = -1;
    public static final TPVCodecCapabilityForGet mDefaultVCodecCapability = new TPVCodecCapabilityForGet(-1, -1, -1, -1);
    private int maxFramerateFormaxLumaSamples;
    private int maxLevel;
    private int maxLumaSamples;
    private int maxProfile;

    public TPVCodecCapabilityForGet(int i3, int i16, int i17, int i18) {
        this.maxLumaSamples = i3;
        this.maxProfile = i16;
        this.maxLevel = i17;
        this.maxFramerateFormaxLumaSamples = i18;
    }

    public int getMaxFramerateFormaxLumaSamples() {
        return this.maxFramerateFormaxLumaSamples;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public int getMaxLumaSamples() {
        return this.maxLumaSamples;
    }

    public int getMaxProfile() {
        return this.maxProfile;
    }
}
