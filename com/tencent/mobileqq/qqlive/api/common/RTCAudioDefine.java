package com.tencent.mobileqq.qqlive.api.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RTCAudioDefine {
    static IPatchRedirector $redirector_ = null;
    public static final int RTC_AUDIO_ACCOMPANY_DUB_TYPE = 2;
    public static final int RTC_AUDIO_ACCOMPANY_ORIGINAL_TYPE = 1;
    public static final int RTC_AUDIO_CH_LAYOUT_MONO = 1;
    public static final int RTC_AUDIO_CH_LAYOUT_STEREO = 2;
    public static final int RTC_AUDIO_DATA_SOURCE_LOCAL_PROCESSED = 2;
    public static final int RTC_AUDIO_DATA_SOURCE_MIXED_ALL = 4;
    public static final int RTC_AUDIO_DATA_SOURCE_MIXED_PLAY = 3;
    public static final int RTC_AUDIO_DATA_SOURCE_RAW_DATA = 1;
    public static final int RTC_AUDIO_DATA_SOURCE_REMOTE = 5;
    public static final int RTC_AUDIO_EFFECT_REVERB_AUDITORIUM = 3;
    public static final int RTC_AUDIO_EFFECT_REVERB_DEEP = 4;
    public static final int RTC_AUDIO_EFFECT_REVERB_KTV = 1;
    public static final int RTC_AUDIO_EFFECT_REVERB_MAGNETISM = 7;
    public static final int RTC_AUDIO_EFFECT_REVERB_METAL = 6;
    public static final int RTC_AUDIO_EFFECT_REVERB_NONE = 0;
    public static final int RTC_AUDIO_EFFECT_REVERB_SMALL_ROOM = 2;
    public static final int RTC_AUDIO_EFFECT_REVERB_SONOROUS = 5;
    public static final int RTC_AUDIO_EFFECT_VOICE_CHANGER_BEAST = 7;
    public static final int RTC_AUDIO_EFFECT_VOICE_CHANGER_COLD = 5;
    public static final int RTC_AUDIO_EFFECT_VOICE_CHANGER_FAT = 8;
    public static final int RTC_AUDIO_EFFECT_VOICE_CHANGER_FOREIGNER = 6;
    public static final int RTC_AUDIO_EFFECT_VOICE_CHANGER_HEAVY_METAL = 4;
    public static final int RTC_AUDIO_EFFECT_VOICE_CHANGER_LOLITA = 2;
    public static final int RTC_AUDIO_EFFECT_VOICE_CHANGER_MACHINERY = 10;
    public static final int RTC_AUDIO_EFFECT_VOICE_CHANGER_NAUGHTY_KID = 1;
    public static final int RTC_AUDIO_EFFECT_VOICE_CHANGER_NONE = 0;
    public static final int RTC_AUDIO_EFFECT_VOICE_CHANGER_PEACE = 11;
    public static final int RTC_AUDIO_EFFECT_VOICE_CHANGER_STRONG_CURRENT = 9;
    public static final int RTC_AUDIO_EFFECT_VOICE_CHANGER_UNCLE = 3;
    public static final int RTC_AUDIO_QUALITY_DEFAULT = 2;
    public static final int RTC_AUDIO_QUALITY_MUSIC = 3;
    public static final int RTC_AUDIO_QUALITY_SPEECH = 1;
    public static final int RTC_AUDIO_ROUTE_EARPIECE = 1;
    public static final int RTC_AUDIO_ROUTE_SPEAKER = 0;
    public static final int RTC_AUDIO_SAMPLE_FMT_DOUBLE = 5;
    public static final int RTC_AUDIO_SAMPLE_FMT_DOUBLE_PLANAR = 7;
    public static final int RTC_AUDIO_SAMPLE_FMT_FLOAT = 4;
    public static final int RTC_AUDIO_SAMPLE_FMT_FLOAT_PLANAR = 6;
    public static final int RTC_AUDIO_SAMPLE_FMT_NONE = 0;
    public static final int RTC_AUDIO_SAMPLE_FMT_S16 = 2;
    public static final int RTC_AUDIO_SAMPLE_FMT_S16_PLANAR = 9;
    public static final int RTC_AUDIO_SAMPLE_FMT_S32 = 3;
    public static final int RTC_AUDIO_SAMPLE_FMT_S32_PLANAR = 10;
    public static final int RTC_AUDIO_SAMPLE_FMT_U8 = 1;
    public static final int RTC_AUDIO_SAMPLE_FMT_U8_PLANAR = 8;
    public static final int RTC_AUDIO_SAMPLE_RATE_16000 = 16000;
    public static final int RTC_AUDIO_SAMPLE_RATE_24000 = 24000;
    public static final int RTC_AUDIO_SAMPLE_RATE_32000 = 32000;
    public static final int RTC_AUDIO_SAMPLE_RATE_44100 = 44100;
    public static final int RTC_AUDIO_SAMPLE_RATE_48000 = 48000;
    public static final int RTC_AUDIO_SYSTEMVOLUME_AUTO = 0;
    public static final int RTC_AUDIO_SYSTEMVOLUME_MEDIA = 1;
    public static final int RTC_AUDIO_SYSTEMVOLUME_VOIP = 2;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCAudioChannelLayout {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCAudioProcessType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCAudioQualityType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCAudioRouteMode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCAudioSampleRateType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCAudioSystemVolumeType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCMusicAccompanyType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCTAudioSampleFormat {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCVoiceChangerType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface RTCVoiceReverbType {
    }

    public RTCAudioDefine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
