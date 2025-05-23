package com.tencent.ugc;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TXRecordCommon {
    static IPatchRedirector $redirector_ = null;
    public static final int AUDIO_SAMPLERATE_16000 = 16000;
    public static final int AUDIO_SAMPLERATE_32000 = 32000;
    public static final int AUDIO_SAMPLERATE_44100 = 44100;
    public static final int AUDIO_SAMPLERATE_48000 = 48000;
    public static final int AUDIO_SAMPLERATE_8000 = 8000;
    public static final int EVT_CAMERA_CANNOT_USE = 3;
    public static final String EVT_DESCRIPTION = "EVT_DESCRIPTION";
    public static final int EVT_ID_PAUSE = 1;
    public static final int EVT_ID_RESUME = 2;
    public static final int EVT_ID_STARTED = 6;
    public static final int EVT_ID_VIDEO_GENERATED = 5;
    public static final int EVT_MIC_CANNOT_USE = 4;
    public static final String EVT_PARAM1 = "EVT_PARAM1";
    public static final String EVT_PARAM2 = "EVT_PARAM2";
    public static final String EVT_TIME = "EVT_TIME";
    public static final int RECORD_PROFILE_BASELINE = 1;
    public static final int RECORD_PROFILE_DEFAULT = 0;
    public static final int RECORD_PROFILE_HIGH = 3;
    public static final int RECORD_PROFILE_MAIN = 2;
    public static final int RECORD_RESULT_COMPOSE_CANCEL = -7;
    public static final int RECORD_RESULT_COMPOSE_INTERNAL_ERR = -9;
    public static final int RECORD_RESULT_COMPOSE_SET_DST_PATH_ERR = -5;
    public static final int RECORD_RESULT_COMPOSE_SET_SRC_PATH_ERR = -4;
    public static final int RECORD_RESULT_COMPOSE_START_ERR = -6;
    public static final int RECORD_RESULT_COMPOSE_VERIFY_FAIL = -8;
    public static final int RECORD_RESULT_FAILED = -1;
    public static final int RECORD_RESULT_FILE_ERR = -3;
    public static final int RECORD_RESULT_OK = 0;
    public static final int RECORD_RESULT_OK_LESS_THAN_MINDURATION = 1;
    public static final int RECORD_RESULT_OK_REACHED_MAXDURATION = 2;
    public static final int RECORD_RESULT_SUSPEND_FOR_NO_TASK = -2;
    public static final int RECORD_SPEED_FAST = 3;
    public static final int RECORD_SPEED_FASTEST = 4;
    public static final int RECORD_SPEED_NORMAL = 2;
    public static final int RECORD_SPEED_SLOW = 1;
    public static final int RECORD_SPEED_SLOWEST = 0;
    public static final int RECORD_TYPE_STREAM_SOURCE = 1;
    public static final int START_RECORD_ERR_API_IS_LOWER_THAN_18 = -3;
    public static final int START_RECORD_ERR_IS_IN_RECORDING = -1;
    public static final int START_RECORD_ERR_LICENCE_VERIFICATION_FAILED = -5;
    public static final int START_RECORD_ERR_NOT_INIT = -4;
    public static final int START_RECORD_ERR_VIDEO_PATH_IS_EMPTY = -2;
    public static final int START_RECORD_OK = 0;
    public static final int VIDEO_ASPECT_RATIO_16_9 = 3;
    public static final int VIDEO_ASPECT_RATIO_1_1 = 2;
    public static final int VIDEO_ASPECT_RATIO_3_4 = 1;
    public static final int VIDEO_ASPECT_RATIO_4_3 = 4;
    public static final int VIDEO_ASPECT_RATIO_9_16 = 0;
    public static final int VIDEO_QUALITY_HIGH = 3;
    public static final int VIDEO_QUALITY_LMEDIUM = 1;
    public static final int VIDEO_QUALITY_LOW = 0;
    public static final int VIDEO_QUALITY_MEDIUM = 2;
    public static final int VIDEO_RENDER_MIRROR_TYPE_AUTO = 0;
    public static final int VIDEO_RENDER_MIRROR_TYPE_DISABLE = 2;
    public static final int VIDEO_RENDER_MIRROR_TYPE_ENABLE = 1;
    public static final int VIDEO_RENDER_MODE_ADJUST_RESOLUTION = 1;
    public static final int VIDEO_RENDER_MODE_FULL_FILL_SCREEN = 0;
    public static final int VIDEO_RESOLUTION_1080_1920 = 4;
    public static final int VIDEO_RESOLUTION_360_640 = 0;
    public static final int VIDEO_RESOLUTION_480_640 = 1;
    public static final int VIDEO_RESOLUTION_540_960 = 2;
    public static final int VIDEO_RESOLUTION_720_1280 = 3;
    public static final int VIDOE_REVERB_TYPE_0 = 0;
    public static final int VIDOE_REVERB_TYPE_1 = 1;
    public static final int VIDOE_REVERB_TYPE_2 = 2;
    public static final int VIDOE_REVERB_TYPE_3 = 3;
    public static final int VIDOE_REVERB_TYPE_4 = 4;
    public static final int VIDOE_REVERB_TYPE_5 = 5;
    public static final int VIDOE_REVERB_TYPE_6 = 6;
    public static final int VIDOE_REVERB_TYPE_7 = 7;
    public static final int VIDOE_VOICECHANGER_TYPE_0 = 0;
    public static final int VIDOE_VOICECHANGER_TYPE_1 = 1;
    public static final int VIDOE_VOICECHANGER_TYPE_10 = 10;
    public static final int VIDOE_VOICECHANGER_TYPE_11 = 11;
    public static final int VIDOE_VOICECHANGER_TYPE_2 = 2;
    public static final int VIDOE_VOICECHANGER_TYPE_3 = 3;
    public static final int VIDOE_VOICECHANGER_TYPE_4 = 4;
    public static final int VIDOE_VOICECHANGER_TYPE_6 = 6;
    public static final int VIDOE_VOICECHANGER_TYPE_7 = 7;
    public static final int VIDOE_VOICECHANGER_TYPE_8 = 8;
    public static final int VIDOE_VOICECHANGER_TYPE_9 = 9;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ITXBGMNotify {
        void onBGMComplete(int i3);

        void onBGMProgress(long j3, long j16);

        void onBGMStart();
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ITXVideoRecordListener {
        void onRecordComplete(TXRecordResult tXRecordResult);

        void onRecordEvent(int i3, Bundle bundle);

        void onRecordProgress(long j3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class TXRecordResult {
        static IPatchRedirector $redirector_;
        public String coverPath;
        public String descMsg;
        public int retCode;
        public String videoPath;

        public TXRecordResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class TXUGCCustomConfig {
        static IPatchRedirector $redirector_;
        public int audioSampleRate;
        public boolean enableAEC;
        public boolean enableAGC;
        public boolean enableANS;
        boolean enableHighResolutionCapture;
        public boolean isFront;
        public int maxDuration;
        public int minDuration;
        public boolean needEdit;
        public int profile;
        public boolean touchFocus;
        public int videoBitrate;
        public int videoFps;
        public int videoGop;
        public int videoResolution;
        public Bitmap watermark;
        public int watermarkX;
        public int watermarkY;

        public TXUGCCustomConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.videoResolution = 2;
            this.videoFps = 20;
            this.videoBitrate = TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC;
            this.videoGop = 3;
            this.watermark = null;
            this.watermarkX = 0;
            this.watermarkY = 0;
            this.isFront = true;
            this.touchFocus = false;
            this.enableHighResolutionCapture = false;
            this.minDuration = 5000;
            this.maxDuration = 60000;
            this.audioSampleRate = 48000;
            this.needEdit = true;
            this.profile = 0;
            this.enableAEC = true;
            this.enableANS = true;
            this.enableAGC = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class TXUGCSimpleConfig {
        static IPatchRedirector $redirector_;
        public boolean isFront;
        public int maxDuration;
        public int minDuration;
        public boolean needEdit;
        public int profile;
        public boolean touchFocus;
        public int videoQuality;
        public Bitmap watermark;
        public int watermarkX;
        public int watermarkY;

        public TXUGCSimpleConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.videoQuality = 2;
            this.watermark = null;
            this.watermarkX = 0;
            this.watermarkY = 0;
            this.isFront = true;
            this.touchFocus = false;
            this.minDuration = 5000;
            this.maxDuration = 60000;
            this.needEdit = true;
        }
    }

    public TXRecordCommon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
