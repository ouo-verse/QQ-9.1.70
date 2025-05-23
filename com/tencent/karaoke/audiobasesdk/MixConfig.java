package com.tencent.karaoke.audiobasesdk;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MixConfig {
    public static final float DEFAULT_ABS_ACCOMPANY_VOLUME = 0.7f;
    public static final float DEFAULT_ABS_VOLUME = 1.0f;
    public static final int LEFT_VOLUM_MAX = 200;
    public static final int LEFT_VOLUM_MIN = 0;
    public static final int LEFT_VOLUM_NORMAL = 100;
    public static final int RIGHT_DELAY_MAX = 5000;
    public static final int RIGHT_DELAY_MIN = -5000;
    public static final int RIGHT_DELAY_NORMAL = 0;
    public static final int RIGHT_VOLUM_MAX = 200;
    public static final int RIGHT_VOLUM_MIN = 0;
    public static final int RIGHT_VOLUM_NORMAL = 100;
    public int sampleRate = 44100;
    public float leftVolum = 0.7f;
    public float rightVolum = 1.0f;
    public int rightDelay = 0;
    public int channel = 2;
    public boolean mIsAcapella = false;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MixConfig)) {
            return false;
        }
        MixConfig mixConfig = (MixConfig) obj;
        if (mixConfig.leftVolum == this.leftVolum && mixConfig.rightDelay == this.rightDelay && mixConfig.rightVolum == this.rightVolum && mixConfig.channel == this.channel && mixConfig.mIsAcapella == this.mIsAcapella) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((int) this.rightVolum) * 100) + 37) * 37) + (((int) this.leftVolum) * 100)) * 37) + this.rightDelay) * 37) + this.channel) * 37) + (this.mIsAcapella ? 1 : 0);
    }

    public String toString() {
        return "MixConfig[leftVolum:" + this.leftVolum + ", rightVolum: " + this.rightVolum + ", rightDelay: " + this.rightDelay + ", channel: " + this.channel + ", mIsAcapella: " + this.mIsAcapella + "]";
    }
}
