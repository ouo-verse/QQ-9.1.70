package com.tencent.mobileqq.qqlive.data.audio;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes17.dex */
public class TRTCAudioDefine {
    static IPatchRedirector $redirector_ = null;
    public static final int RTC_AUDIO_CH_LAYOUT_MONO = 1;
    public static final int RTC_AUDIO_CH_LAYOUT_STEREO = 2;
    public static final int RTC_AUDIO_DATA_SOURCE_LOCAL_PROCESSED = 2;
    public static final int RTC_AUDIO_DATA_SOURCE_MIXED_PLAY = 3;
    public static final int RTC_AUDIO_DATA_SOURCE_RAW_DATA = 1;
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
    public @interface RTCTAudioSampleFormat {
    }

    public TRTCAudioDefine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
