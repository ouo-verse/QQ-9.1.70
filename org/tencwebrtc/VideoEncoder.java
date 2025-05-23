package org.tencwebrtc;

import android.support.annotation.Nullable;
import org.tencwebrtc.EncodedImage;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface VideoEncoder {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BitrateAllocation {
        public final int[][] bitratesBbs;

        @CalledByNative("BitrateAllocation")
        public BitrateAllocation(int[][] iArr) {
            this.bitratesBbs = iArr;
        }

        public int getSum() {
            int i3 = 0;
            for (int[] iArr : this.bitratesBbs) {
                for (int i16 : iArr) {
                    i3 += i16;
                }
            }
            return i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface Callback {
        void onEncodedFrame(EncodedImage encodedImage, CodecSpecificInfo codecSpecificInfo);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class CodecSpecificInfo {
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class CodecSpecificInfoH264 extends CodecSpecificInfo {
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class CodecSpecificInfoVP8 extends CodecSpecificInfo {
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class CodecSpecificInfoVP9 extends CodecSpecificInfo {
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class EncodeInfo {
        public final EncodedImage.FrameType[] frameTypes;

        @CalledByNative("EncodeInfo")
        public EncodeInfo(EncodedImage.FrameType[] frameTypeArr) {
            this.frameTypes = frameTypeArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Settings {
        public final boolean automaticResizeOn;
        public final int height;
        public final int maxFramerate;
        public final int numberOfCores;
        public final int numberOfSimulcastStreams;
        public final int startBitrate;
        public final int width;

        @CalledByNative("Settings")
        public Settings(int i3, int i16, int i17, int i18, int i19, int i26, boolean z16) {
            this.numberOfCores = i3;
            this.width = i16;
            this.height = i17;
            this.startBitrate = i18;
            this.maxFramerate = i19;
            this.numberOfSimulcastStreams = i26;
            this.automaticResizeOn = z16;
        }
    }

    @CalledByNative
    long createNativeVideoEncoder();

    @CalledByNative
    VideoCodecStatus encode(VideoFrame videoFrame, EncodeInfo encodeInfo);

    @CalledByNative
    String getImplementationName();

    @CalledByNative
    ScalingSettings getScalingSettings();

    @CalledByNative
    VideoCodecStatus initEncode(Settings settings, Callback callback);

    @CalledByNative
    boolean isHardwareEncoder();

    @CalledByNative
    VideoCodecStatus release();

    @CalledByNative
    VideoCodecStatus setRateAllocation(BitrateAllocation bitrateAllocation, int i3);

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class ScalingSettings {
        public static final ScalingSettings OFF = new ScalingSettings();

        @Nullable
        public final Integer high;

        @Nullable
        public final Integer low;

        /* renamed from: on, reason: collision with root package name */
        public final boolean f423851on;

        public ScalingSettings(int i3, int i16) {
            this.f423851on = true;
            this.low = Integer.valueOf(i3);
            this.high = Integer.valueOf(i16);
        }

        public String toString() {
            if (this.f423851on) {
                return "[ " + this.low + ", " + this.high + " ]";
            }
            return "OFF";
        }

        ScalingSettings() {
            this.f423851on = false;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean z16) {
            this.f423851on = z16;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean z16, int i3, int i16) {
            this.f423851on = z16;
            this.low = Integer.valueOf(i3);
            this.high = Integer.valueOf(i16);
        }
    }
}
