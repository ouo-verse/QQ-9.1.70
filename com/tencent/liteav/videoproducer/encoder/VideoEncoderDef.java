package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaFormat;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.videobase.e;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public interface VideoEncoderDef {

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum BitrateMode {
        UNKNOWN(-1),
        CBR(0),
        VBR(1),
        CQ(2);


        /* renamed from: e, reason: collision with root package name */
        private static final BitrateMode[] f119649e = values();
        public int mValue;

        BitrateMode(int i3) {
            this.mValue = i3;
        }

        public static BitrateMode a(int i3) {
            for (BitrateMode bitrateMode : f119649e) {
                if (i3 == bitrateMode.mValue) {
                    return bitrateMode;
                }
            }
            return VBR;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class EncodeAbility {

        /* renamed from: a, reason: collision with root package name */
        public boolean f119651a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f119652b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f119653c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f119654d;

        public boolean isSupportHwHEVC() {
            return this.f119654d;
        }

        public boolean isSupportRPS() {
            return this.f119651a;
        }

        public boolean isSupportSVC() {
            return this.f119652b;
        }

        public boolean isSupportSwHEVC() {
            return this.f119653c;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum EncodeScene {
        kCameraRealTime(0),
        kScreenRealTime(1);

        int mValue;

        EncodeScene(int i3) {
            this.mValue = i3;
        }

        public static EncodeScene a(int i3) {
            for (EncodeScene encodeScene : values()) {
                if (encodeScene.mValue == i3) {
                    return encodeScene;
                }
            }
            return kCameraRealTime;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum EncoderComplexity {
        UNKNOWN(65535),
        HYPER_FAST(0),
        ULTRA_FAST(1),
        SUPER_FAST(2),
        VERY_FAST(3),
        FAST(4);

        final int mValue;

        EncoderComplexity(int i3) {
            this.mValue = i3;
        }

        public static EncoderComplexity a(int i3) {
            for (EncoderComplexity encoderComplexity : values()) {
                if (encoderComplexity.mValue == i3) {
                    return encoderComplexity;
                }
            }
            return UNKNOWN;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum EncoderProfile {
        PROFILE_BASELINE(1),
        PROFILE_MAIN(2),
        PROFILE_HIGH(3),
        PROFILE_BASELINERPS(11),
        PROFILE_MAINRPS(12),
        PROFILE_HIGHRPS(13);


        /* renamed from: g, reason: collision with root package name */
        private static final EncoderProfile[] f119671g = values();
        int mValue;

        EncoderProfile(int i3) {
            this.mValue = i3;
        }

        public static EncoderProfile a(int i3) {
            for (EncoderProfile encoderProfile : f119671g) {
                if (i3 == encoderProfile.mValue) {
                    return encoderProfile;
                }
            }
            return PROFILE_BASELINE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class EncoderProperty {

        /* renamed from: a, reason: collision with root package name */
        public a f119673a;

        /* renamed from: b, reason: collision with root package name */
        public ReferenceStrategy f119674b;

        /* renamed from: c, reason: collision with root package name */
        public CodecType f119675c;

        public int getCodecType() {
            return this.f119675c.mValue;
        }

        public int getEncoderType() {
            return this.f119673a.value;
        }

        public int getReferenceStrategy() {
            return this.f119674b.mValue;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum ReferenceStrategy {
        FIX_GOP(0),
        RPS(1),
        SVC(2),
        UNLIMITED_GOP(3);


        /* renamed from: e, reason: collision with root package name */
        private static final ReferenceStrategy[] f119680e = values();
        int mValue;

        ReferenceStrategy(int i3) {
            this.mValue = i3;
        }

        public static ReferenceStrategy a(int i3) {
            for (ReferenceStrategy referenceStrategy : f119680e) {
                if (i3 == referenceStrategy.mValue) {
                    return referenceStrategy;
                }
            }
            return FIX_GOP;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum a {
        HARDWARE(1),
        SOFTWARE(2);

        int value;

        a(int i3) {
            this.value = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static abstract class b {
        public void onBitrateModeUpdated(BitrateMode bitrateMode) {
        }

        public void onEncodedFail(e.a aVar) {
        }

        public void onOutputFormatChanged(MediaFormat mediaFormat) {
        }

        public void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z16) {
        }
    }
}
