package com.tencent.trtc;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLContext;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TRTCCloudDef {
    static IPatchRedirector $redirector_ = null;
    public static final int TRTCAVStatusChangeReasonBufferingBegin = 1;
    public static final int TRTCAVStatusChangeReasonBufferingEnd = 2;
    public static final int TRTCAVStatusChangeReasonInternal = 0;
    public static final int TRTCAVStatusChangeReasonLocalStarted = 3;
    public static final int TRTCAVStatusChangeReasonLocalStopped = 4;
    public static final int TRTCAVStatusChangeReasonRemoteStarted = 5;
    public static final int TRTCAVStatusChangeReasonRemoteStopped = 6;
    public static final int TRTCAVStatusLoading = 2;
    public static final int TRTCAVStatusPlaying = 1;
    public static final int TRTCAVStatusStopped = 0;
    public static final int TRTCAudioCapabilityLowLatencyChorus = 1;
    public static final int TRTCAudioCapabilityLowLatencyEarMonitor = 2;
    public static final int TRTCAudioSampleRate16000 = 16000;
    public static final int TRTCAudioSampleRate32000 = 32000;
    public static final int TRTCAudioSampleRate44100 = 44100;
    public static final int TRTCAudioSampleRate48000 = 48000;
    public static final int TRTCRoleAnchor = 20;
    public static final int TRTCRoleAudience = 21;
    public static final int TRTCSystemVolumeTypeAuto = 0;
    public static final int TRTCSystemVolumeTypeMedia = 1;
    public static final int TRTCSystemVolumeTypeVOIP = 2;
    public static final int TRTC_APP_SCENE_AUDIOCALL = 2;
    public static final int TRTC_APP_SCENE_LIVE = 1;
    public static final int TRTC_APP_SCENE_VIDEOCALL = 0;
    public static final int TRTC_APP_SCENE_VOICE_CHATROOM = 3;
    public static final int TRTC_AUDIO_FRAME_FORMAT_PCM = 1;
    public static final int TRTC_AUDIO_FRAME_OPERATION_MODE_READONLY = 1;
    public static final int TRTC_AUDIO_FRAME_OPERATION_MODE_READWRITE = 0;
    public static final int TRTC_AUDIO_QUALITY_DEFAULT = 2;
    public static final int TRTC_AUDIO_QUALITY_MUSIC = 3;
    public static final int TRTC_AUDIO_QUALITY_SPEECH = 1;
    public static final int TRTC_AUDIO_ROUTE_BLUETOOTH_HEADSET = 3;
    public static final int TRTC_AUDIO_ROUTE_EARPIECE = 1;
    public static final int TRTC_AUDIO_ROUTE_SOUND_CARD = 4;
    public static final int TRTC_AUDIO_ROUTE_SPEAKER = 0;
    public static final int TRTC_AUDIO_ROUTE_UNKNOWN = -1;
    public static final int TRTC_AUDIO_ROUTE_WIRED_HEADSET = 2;
    public static final int TRTC_AudioRecordingContent_All = 0;
    public static final int TRTC_AudioRecordingContent_Local = 1;
    public static final int TRTC_AudioRecordingContent_Remote = 2;
    public static final int TRTC_BEAUTY_STYLE_NATURE = 1;
    public static final int TRTC_BEAUTY_STYLE_PITU = 2;
    public static final int TRTC_BEAUTY_STYLE_SMOOTH = 0;
    public static final int TRTC_DEBUG_VIEW_LEVEL_ALL = 2;
    public static final int TRTC_DEBUG_VIEW_LEVEL_GONE = 0;
    public static final int TRTC_DEBUG_VIEW_LEVEL_STATUS = 1;
    public static final int TRTC_EncryptionAlgorithm_Aes_128_Gcm = 0;
    public static final int TRTC_EncryptionAlgorithm_Aes_256_Gcm = 1;
    public static final int TRTC_GRAVITY_SENSOR_ADAPTIVE_MODE_DISABLE = 0;
    public static final int TRTC_GRAVITY_SENSOR_ADAPTIVE_MODE_FILL_BY_CENTER_CROP = 1;
    public static final int TRTC_GRAVITY_SENSOR_ADAPTIVE_MODE_FIT_WITH_BLACK_BORDER = 2;
    public static final int TRTC_GSENSOR_MODE_DISABLE = 0;
    public static final int TRTC_GSENSOR_MODE_UIAUTOLAYOUT = 1;
    public static final int TRTC_GSENSOR_MODE_UIFIXLAYOUT = 2;
    public static final int TRTC_LOG_LEVEL_DEBUG = 1;
    public static final int TRTC_LOG_LEVEL_ERROR = 4;
    public static final int TRTC_LOG_LEVEL_FATAL = 5;
    public static final int TRTC_LOG_LEVEL_INFO = 2;
    public static final int TRTC_LOG_LEVEL_NULL = 6;
    public static final int TRTC_LOG_LEVEL_VERBOSE = 0;
    public static final int TRTC_LOG_LEVEL_WARN = 3;
    public static final int TRTC_MixInputType_AudioVideo = 1;
    public static final int TRTC_MixInputType_PureAudio = 3;
    public static final int TRTC_MixInputType_PureVideo = 2;
    public static final int TRTC_MixInputType_Undefined = 0;
    public static final int TRTC_MixInputType_Watermark = 4;
    public static final int TRTC_PublishBigStream_ToCdn = 1;
    public static final int TRTC_PublishMixStream_ToCdn = 3;
    public static final int TRTC_PublishMixStream_ToRoom = 4;
    public static final int TRTC_PublishMode_Unknown = 0;
    public static final int TRTC_PublishSubStream_ToCdn = 2;
    public static final int TRTC_QUALITY_Bad = 4;
    public static final int TRTC_QUALITY_Down = 6;
    public static final int TRTC_QUALITY_Excellent = 1;
    public static final int TRTC_QUALITY_Good = 2;
    public static final int TRTC_QUALITY_Poor = 3;
    public static final int TRTC_QUALITY_UNKNOWN = 0;
    public static final int TRTC_QUALITY_Vbad = 5;
    public static final int TRTC_RECORD_TYPE_AUDIO = 0;
    public static final int TRTC_RECORD_TYPE_BOTH = 2;
    public static final int TRTC_RECORD_TYPE_VIDEO = 1;
    public static final int TRTC_REVERB_TYPE_0 = 0;
    public static final int TRTC_REVERB_TYPE_1 = 1;
    public static final int TRTC_REVERB_TYPE_2 = 2;
    public static final int TRTC_REVERB_TYPE_3 = 3;
    public static final int TRTC_REVERB_TYPE_4 = 4;
    public static final int TRTC_REVERB_TYPE_5 = 5;
    public static final int TRTC_REVERB_TYPE_6 = 6;
    public static final int TRTC_REVERB_TYPE_7 = 7;
    public static final String TRTC_SDK_VERSION = "12.3.0.41603";
    public static final int TRTC_SNAPSHOT_SOURCE_TYPE_CAPTURE = 2;
    public static final int TRTC_SNAPSHOT_SOURCE_TYPE_STREAM = 0;
    public static final int TRTC_SNAPSHOT_SOURCE_TYPE_VIEW = 1;
    public static final int TRTC_SpeedTestScene_Delay_Bandwidth_Testing = 2;
    public static final int TRTC_SpeedTestScene_Delay_Testing = 1;
    public static final int TRTC_SpeedTestScene_Online_Chorus_Testing = 3;
    public static final int TRTC_TranscodingConfigMode_Manual = 1;
    public static final int TRTC_TranscodingConfigMode_Template_PresetLayout = 3;
    public static final int TRTC_TranscodingConfigMode_Template_PureAudio = 2;
    public static final int TRTC_TranscodingConfigMode_Template_ScreenSharing = 4;
    public static final int TRTC_TranscodingConfigMode_Unknown = 0;
    public static final int TRTC_VIDEO_BUFFER_TYPE_BYTE_ARRAY = 2;
    public static final int TRTC_VIDEO_BUFFER_TYPE_BYTE_BUFFER = 1;
    public static final int TRTC_VIDEO_BUFFER_TYPE_TEXTURE = 3;
    public static final int TRTC_VIDEO_BUFFER_TYPE_UNKNOWN = 0;
    public static final int TRTC_VIDEO_MIRROR_TYPE_AUTO = 0;
    public static final int TRTC_VIDEO_MIRROR_TYPE_DISABLE = 2;
    public static final int TRTC_VIDEO_MIRROR_TYPE_ENABLE = 1;
    public static final int TRTC_VIDEO_PIXEL_FORMAT_I420 = 1;
    public static final int TRTC_VIDEO_PIXEL_FORMAT_NV21 = 4;
    public static final int TRTC_VIDEO_PIXEL_FORMAT_RGBA = 5;
    public static final int TRTC_VIDEO_PIXEL_FORMAT_TEXTURE_EXTERNAL_OES = 3;
    public static final int TRTC_VIDEO_PIXEL_FORMAT_Texture_2D = 2;
    public static final int TRTC_VIDEO_PIXEL_FORMAT_UNKNOWN = 0;
    public static final int TRTC_VIDEO_QOS_PREFERENCE_CLEAR = 2;
    public static final int TRTC_VIDEO_QOS_PREFERENCE_SMOOTH = 1;
    public static final int TRTC_VIDEO_RENDER_MODE_FILL = 0;
    public static final int TRTC_VIDEO_RENDER_MODE_FIT = 1;
    public static final int TRTC_VIDEO_RENDER_MODE_SCALE_FILL = 2;
    public static final int TRTC_VIDEO_RESOLUTION_120_120 = 1;
    public static final int TRTC_VIDEO_RESOLUTION_1280_720 = 112;
    public static final int TRTC_VIDEO_RESOLUTION_160_120 = 50;
    public static final int TRTC_VIDEO_RESOLUTION_160_160 = 3;
    public static final int TRTC_VIDEO_RESOLUTION_160_90 = 100;
    public static final int TRTC_VIDEO_RESOLUTION_1920_1080 = 114;
    public static final int TRTC_VIDEO_RESOLUTION_240_180 = 52;
    public static final int TRTC_VIDEO_RESOLUTION_256_144 = 102;
    public static final int TRTC_VIDEO_RESOLUTION_270_270 = 5;
    public static final int TRTC_VIDEO_RESOLUTION_280_210 = 54;
    public static final int TRTC_VIDEO_RESOLUTION_320_180 = 104;
    public static final int TRTC_VIDEO_RESOLUTION_320_240 = 56;
    public static final int TRTC_VIDEO_RESOLUTION_400_300 = 58;
    public static final int TRTC_VIDEO_RESOLUTION_480_270 = 106;
    public static final int TRTC_VIDEO_RESOLUTION_480_360 = 60;
    public static final int TRTC_VIDEO_RESOLUTION_480_480 = 7;
    public static final int TRTC_VIDEO_RESOLUTION_640_360 = 108;
    public static final int TRTC_VIDEO_RESOLUTION_640_480 = 62;
    public static final int TRTC_VIDEO_RESOLUTION_960_540 = 110;
    public static final int TRTC_VIDEO_RESOLUTION_960_720 = 64;
    public static final int TRTC_VIDEO_RESOLUTION_MODE_LANDSCAPE = 0;
    public static final int TRTC_VIDEO_RESOLUTION_MODE_PORTRAIT = 1;
    public static final int TRTC_VIDEO_ROTATION_0 = 0;
    public static final int TRTC_VIDEO_ROTATION_180 = 2;
    public static final int TRTC_VIDEO_ROTATION_270 = 3;
    public static final int TRTC_VIDEO_ROTATION_90 = 1;
    public static final int TRTC_VIDEO_STREAM_TYPE_BIG = 0;
    public static final int TRTC_VIDEO_STREAM_TYPE_SMALL = 1;
    public static final int TRTC_VIDEO_STREAM_TYPE_SUB = 2;
    public static final int TRTC_VOICE_CHANGER_TYPE_0 = 0;
    public static final int TRTC_VOICE_CHANGER_TYPE_1 = 1;
    public static final int TRTC_VOICE_CHANGER_TYPE_10 = 10;
    public static final int TRTC_VOICE_CHANGER_TYPE_11 = 11;
    public static final int TRTC_VOICE_CHANGER_TYPE_2 = 2;
    public static final int TRTC_VOICE_CHANGER_TYPE_3 = 3;
    public static final int TRTC_VOICE_CHANGER_TYPE_4 = 4;
    public static final int TRTC_VOICE_CHANGER_TYPE_5 = 5;
    public static final int TRTC_VOICE_CHANGER_TYPE_6 = 6;
    public static final int TRTC_VOICE_CHANGER_TYPE_7 = 7;
    public static final int TRTC_VOICE_CHANGER_TYPE_8 = 8;
    public static final int TRTC_VOICE_CHANGER_TYPE_9 = 9;
    public static final int VIDEO_QOS_CONTROL_CLIENT = 0;
    public static final int VIDEO_QOS_CONTROL_SERVER = 1;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCAudioEffectParam {
        static IPatchRedirector $redirector_;
        public int effectId;
        public int loopCount;
        public String path;
        public boolean publish;
        public int volume;

        public TRTCAudioEffectParam(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
                return;
            }
            this.path = str;
            this.effectId = i3;
            this.loopCount = 0;
            this.publish = false;
            this.volume = 100;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCAudioFrame {
        static IPatchRedirector $redirector_;
        public int channel;
        public byte[] data;
        public byte[] extraData;
        public int sampleRate;
        public long timestamp;

        public TRTCAudioFrame() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCAudioFrameCallbackFormat {
        static IPatchRedirector $redirector_;
        public int channel;
        public int mode;
        public int sampleRate;
        public int samplesPerCall;

        public TRTCAudioFrameCallbackFormat() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.sampleRate = 0;
            this.channel = 0;
            this.samplesPerCall = 0;
            this.mode = 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCAudioParallelParams {
        static IPatchRedirector $redirector_;
        public ArrayList<String> includeUsers;
        public int maxCount;

        public TRTCAudioParallelParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.maxCount = 0;
                this.includeUsers = new ArrayList<>();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCAudioRecordingParams {
        static IPatchRedirector $redirector_;
        public String filePath;
        public int maxDurationPerFile;
        public int recordingContent;

        public TRTCAudioRecordingParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.filePath = "";
            this.recordingContent = 0;
            this.maxDurationPerFile = 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCAudioVolumeEvaluateParams {
        static IPatchRedirector $redirector_;
        public boolean enablePitchCalculation;
        public boolean enableSpectrumCalculation;
        public boolean enableVadDetection;
        public int interval;

        public TRTCAudioVolumeEvaluateParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.interval = 300;
            this.enableVadDetection = false;
            this.enablePitchCalculation = false;
            this.enableSpectrumCalculation = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCLocalRecordingParams {
        static IPatchRedirector $redirector_;
        public String filePath;
        public int interval;
        public int maxDurationPerFile;
        public int recordType;

        public TRTCLocalRecordingParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.filePath = "";
            this.recordType = 2;
            this.interval = -1;
            this.maxDurationPerFile = 0;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "filePath=" + this.filePath + ", recordType=" + this.recordType + ", interval=" + this.interval + ", maxDurationPerFile=" + this.maxDurationPerFile;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCNetworkQosParam {
        static IPatchRedirector $redirector_;
        public int controlMode;
        public int preference;

        public TRTCNetworkQosParam() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCPayloadPrivateEncryptionConfig {
        static IPatchRedirector $redirector_;
        public int encryptionAlgorithm;
        public String encryptionKey;
        public final byte[] encryptionSalt;

        public TRTCPayloadPrivateEncryptionConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            byte[] bArr = new byte[32];
            this.encryptionSalt = bArr;
            this.encryptionAlgorithm = 0;
            this.encryptionKey = null;
            Arrays.fill(bArr, (byte) 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCPublishCDNParam {
        static IPatchRedirector $redirector_;
        public int appId;
        public int bizId;
        public String streamId;
        public String url;

        public TRTCPublishCDNParam() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCPublishTarget {
        static IPatchRedirector $redirector_;
        public ArrayList<TRTCPublishCdnUrl> cdnUrlList;
        public TRTCUser mixStreamIdentity;
        public int mode;

        public TRTCPublishTarget() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.mode = 0;
            this.cdnUrlList = new ArrayList<>();
            this.mixStreamIdentity = new TRTCUser();
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCQuality {
        static IPatchRedirector $redirector_;
        public int quality;
        public String userId;

        public TRTCQuality() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCRenderParams {
        static IPatchRedirector $redirector_;
        public int fillMode;
        public int mirrorType;
        public int rotation;

        public TRTCRenderParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCScreenShareParams {
        static IPatchRedirector $redirector_;

        @Deprecated
        public boolean enableForegroundService;
        public View floatingView;
        public Object mediaProjection;

        public TRTCScreenShareParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.enableForegroundService = true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCSpeedTestParams {
        static IPatchRedirector $redirector_;
        public int expectedDownBandwidth;
        public int expectedUpBandwidth;
        public int scene;
        public int sdkAppId;
        public String userId;
        public String userSig;

        public TRTCSpeedTestParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "sdkAppId:" + this.sdkAppId + " userId:" + this.userId + " expectedUpBandwidth:" + this.expectedDownBandwidth + " expectedDownBandwidth:" + this.expectedDownBandwidth + " scene:" + this.scene;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCSpeedTestResult {
        static IPatchRedirector $redirector_;
        public int availableDownBandwidth;
        public int availableUpBandwidth;
        public int downJitter;
        public float downLostRate;
        public String errMsg;

        /* renamed from: ip, reason: collision with root package name */
        public String f381676ip;
        public int quality;
        public int rtt;
        public boolean success;
        public int upJitter;
        public float upLostRate;

        public TRTCSpeedTestResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "success:" + this.success + " errMsg:" + this.errMsg + " ip:" + this.f381676ip + " quality:" + this.quality + " upLostRate:" + this.upLostRate + " downLostRate:" + this.downLostRate + " rtt:" + this.rtt + " availableUpBandwidth:" + this.availableUpBandwidth + " availableDownBandwidth:" + this.availableDownBandwidth + " upJitter:" + this.upJitter + " downJitter:" + this.downJitter;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCStreamEncoderParam {
        static IPatchRedirector $redirector_;
        public int audioEncodedChannelNum;
        public int audioEncodedCodecType;
        public int audioEncodedKbps;
        public int audioEncodedSampleRate;
        public int videoEncodedCodecType;
        public int videoEncodedFPS;
        public int videoEncodedGOP;
        public int videoEncodedHeight;
        public int videoEncodedKbps;
        public int videoEncodedWidth;
        public String videoSeiParams;

        public TRTCStreamEncoderParam() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.videoEncodedWidth = 0;
            this.videoEncodedHeight = 0;
            this.videoEncodedFPS = 0;
            this.videoEncodedGOP = 0;
            this.videoEncodedKbps = 0;
            this.audioEncodedSampleRate = 0;
            this.audioEncodedChannelNum = 0;
            this.audioEncodedKbps = 0;
            this.audioEncodedCodecType = 0;
            this.videoEncodedCodecType = 0;
            this.videoSeiParams = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCStreamMixingConfig {
        static IPatchRedirector $redirector_;
        public ArrayList<TRTCUser> audioMixUserList;
        public int backgroundColor;
        public String backgroundImage;
        public ArrayList<TRTCVideoLayout> videoLayoutList;
        public ArrayList<TRTCWatermark> watermarkList;

        public TRTCStreamMixingConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.backgroundColor = 0;
            this.backgroundImage = "";
            this.videoLayoutList = new ArrayList<>();
            this.audioMixUserList = new ArrayList<>();
            this.watermarkList = new ArrayList<>();
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCSwitchRoomConfig {
        static IPatchRedirector $redirector_;
        public String privateMapKey;
        public int roomId;
        public String strRoomId;
        public String userSig;

        public TRTCSwitchRoomConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.roomId = 0;
            this.strRoomId = null;
            this.userSig = null;
            this.privateMapKey = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCTexture {
        static IPatchRedirector $redirector_;
        public EGLContext eglContext10;
        public android.opengl.EGLContext eglContext14;
        public int textureId;

        public TRTCTexture() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCUser {
        static IPatchRedirector $redirector_;
        public int intRoomId;
        public String strRoomId;
        public String userId;

        public TRTCUser() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.userId = "";
            this.intRoomId = 0;
            this.strRoomId = "";
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCVideoEncParam {
        static IPatchRedirector $redirector_;
        public boolean enableAdjustRes;
        public int minVideoBitrate;
        public int videoBitrate;
        public int videoFps;
        public int videoResolution;
        public int videoResolutionMode;

        public TRTCVideoEncParam() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCVideoFrame {
        static IPatchRedirector $redirector_;
        public ByteBuffer buffer;
        public int bufferType;
        public byte[] data;
        public int height;
        public int pixelFormat;
        public int rotation;
        public TRTCTexture texture;
        public long timestamp;
        public int width;

        public TRTCVideoFrame() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCVideoLayout {
        static IPatchRedirector $redirector_;
        public int backgroundColor;
        public int fillMode;
        public int fixedVideoStreamType;
        public TRTCUser fixedVideoUser;
        public int height;
        public String placeHolderImage;
        public int width;

        /* renamed from: x, reason: collision with root package name */
        public int f381677x;

        /* renamed from: y, reason: collision with root package name */
        public int f381678y;
        public int zOrder;

        public TRTCVideoLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f381677x = 0;
            this.f381678y = 0;
            this.width = 0;
            this.height = 0;
            this.zOrder = 0;
            this.fillMode = 0;
            this.backgroundColor = 0;
            this.placeHolderImage = "";
            this.fixedVideoUser = new TRTCUser();
            this.fixedVideoStreamType = 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCVolumeInfo {
        static IPatchRedirector $redirector_;
        public float pitch;
        public float[] spectrumData;
        public String userId;
        public int vad;
        public int volume;

        public TRTCVolumeInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCWatermark {
        static IPatchRedirector $redirector_;
        public int height;
        public String watermarkUrl;
        public int width;

        /* renamed from: x, reason: collision with root package name */
        public int f381679x;

        /* renamed from: y, reason: collision with root package name */
        public int f381680y;
        public int zOrder;

        public TRTCWatermark() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.watermarkUrl = "";
            this.f381679x = 0;
            this.f381680y = 0;
            this.height = 0;
            this.width = 0;
            this.zOrder = 0;
        }
    }

    public TRTCCloudDef() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCPublishCdnUrl {
        static IPatchRedirector $redirector_;
        public boolean isInternalLine;
        public String rtmpUrl;

        public TRTCPublishCdnUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.rtmpUrl = "";
                this.isInternalLine = true;
            }
        }

        public TRTCPublishCdnUrl(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
            } else {
                this.rtmpUrl = str;
                this.isInternalLine = z16;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCParams {
        static IPatchRedirector $redirector_;
        public String businessInfo;
        public String privateMapKey;
        public int role;
        public int roomId;
        public int sdkAppId;
        public String strRoomId;
        public String streamId;
        public String userDefineRecordId;
        public String userId;
        public String userSig;

        public TRTCParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.sdkAppId = 0;
            this.userId = "";
            this.userSig = "";
            this.roomId = 0;
            this.strRoomId = "";
            this.role = 20;
            this.streamId = "";
            this.userDefineRecordId = "";
            this.privateMapKey = "";
            this.businessInfo = "";
        }

        public TRTCParams(int i3, String str, String str2, int i16, String str3, String str4) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), str3, str4);
                return;
            }
            this.role = 20;
            this.streamId = "";
            this.userDefineRecordId = "";
            this.sdkAppId = i3;
            this.userId = str;
            this.userSig = str2;
            this.roomId = i16;
            this.strRoomId = "";
            this.privateMapKey = str3;
            this.businessInfo = str4;
        }

        public TRTCParams(int i3, String str, String str2, String str3, String str4, String str5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2, str3, str4, str5);
                return;
            }
            this.roomId = 0;
            this.role = 20;
            this.streamId = "";
            this.userDefineRecordId = "";
            this.sdkAppId = i3;
            this.userId = str;
            this.userSig = str2;
            this.strRoomId = str3;
            this.privateMapKey = str4;
            this.businessInfo = str5;
        }

        public TRTCParams(TRTCParams tRTCParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) tRTCParams);
                return;
            }
            this.sdkAppId = 0;
            this.userId = "";
            this.userSig = "";
            this.roomId = 0;
            this.strRoomId = "";
            this.role = 20;
            this.streamId = "";
            this.userDefineRecordId = "";
            this.privateMapKey = "";
            this.businessInfo = "";
            this.sdkAppId = tRTCParams.sdkAppId;
            this.userId = tRTCParams.userId;
            this.userSig = tRTCParams.userSig;
            this.roomId = tRTCParams.roomId;
            this.strRoomId = tRTCParams.strRoomId;
            this.role = tRTCParams.role;
            this.streamId = tRTCParams.streamId;
            this.userDefineRecordId = tRTCParams.userDefineRecordId;
            this.privateMapKey = tRTCParams.privateMapKey;
            this.businessInfo = tRTCParams.businessInfo;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCMixUser {
        static IPatchRedirector $redirector_;
        public int height;
        public String image;
        public int inputType;
        public boolean pureAudio;
        public int renderMode;
        public String roomId;
        public int soundLevel;
        public int streamType;
        public String userId;
        public int width;

        /* renamed from: x, reason: collision with root package name */
        public int f381674x;

        /* renamed from: y, reason: collision with root package name */
        public int f381675y;
        public int zOrder;

        public TRTCMixUser() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.userId = "";
            this.f381674x = 0;
            this.f381675y = 0;
            this.width = 0;
            this.height = 0;
            this.zOrder = 0;
            this.streamType = 0;
            this.inputType = 0;
            this.renderMode = 0;
            this.soundLevel = 100;
            this.image = null;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "userId=" + this.userId + ", roomId=" + this.roomId + ", x=" + this.f381674x + ", y=" + this.f381675y + ", width=" + this.width + ", height=" + this.height + ", zOrder=" + this.zOrder + ", streamType=" + this.streamType + ", pureAudio=" + this.pureAudio + ", inputType=" + this.inputType + ", renderMode=" + this.renderMode + ", soundLevel=" + this.soundLevel + ", image=" + this.image;
        }

        public TRTCMixUser(String str, int i3, int i16, int i17, int i18, int i19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
                return;
            }
            this.userId = str;
            this.f381674x = i3;
            this.f381675y = i16;
            this.width = i17;
            this.height = i18;
            this.zOrder = i19;
            this.streamType = 0;
            this.inputType = 0;
            this.renderMode = 0;
            this.soundLevel = 100;
            this.image = null;
        }

        public TRTCMixUser(TRTCMixUser tRTCMixUser) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) tRTCMixUser);
                return;
            }
            this.userId = tRTCMixUser.userId;
            this.roomId = tRTCMixUser.roomId;
            this.f381674x = tRTCMixUser.f381674x;
            this.f381675y = tRTCMixUser.f381675y;
            this.width = tRTCMixUser.width;
            this.height = tRTCMixUser.height;
            this.zOrder = tRTCMixUser.zOrder;
            this.streamType = tRTCMixUser.streamType;
            this.pureAudio = tRTCMixUser.pureAudio;
            this.inputType = tRTCMixUser.inputType;
            this.renderMode = tRTCMixUser.renderMode;
            this.soundLevel = tRTCMixUser.soundLevel;
            this.image = tRTCMixUser.image;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TRTCTranscodingConfig {
        static IPatchRedirector $redirector_;
        public int appId;
        public int audioBitrate;
        public int audioChannels;
        public int audioCodec;
        public int audioSampleRate;
        public int backgroundColor;
        public String backgroundImage;
        public int bizId;
        public ArrayList<TRTCMixUser> mixUsers;
        public int mode;
        public String streamId;
        public int videoBitrate;
        public int videoFramerate;
        public int videoGOP;
        public int videoHeight;
        public String videoSeiParams;
        public int videoWidth;

        public TRTCTranscodingConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.mode = 0;
            this.videoWidth = 0;
            this.videoHeight = 0;
            this.videoBitrate = 0;
            this.videoFramerate = 15;
            this.videoGOP = 2;
            this.backgroundColor = 0;
            this.backgroundImage = null;
            this.audioSampleRate = 48000;
            this.audioBitrate = 64;
            this.audioChannels = 1;
            this.audioCodec = 0;
            this.streamId = null;
            this.videoSeiParams = null;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "appId=" + this.appId + ", bizId=" + this.bizId + ", mode=" + this.mode + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoBitrate=" + this.videoBitrate + ", videoFramerate=" + this.videoFramerate + ", videoGOP=" + this.videoGOP + ", backgroundColor=" + this.backgroundColor + ", backgroundImage=" + this.backgroundImage + ", audioSampleRate=" + this.audioSampleRate + ", audioBitrate=" + this.audioBitrate + ", audioChannels=" + this.audioChannels + ", audioCodec=" + this.audioCodec + ", streamId=" + this.streamId + ", videoSeiParams=" + this.videoSeiParams + ", mixUsers=" + this.mixUsers;
        }

        public TRTCTranscodingConfig(TRTCTranscodingConfig tRTCTranscodingConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) tRTCTranscodingConfig);
                return;
            }
            this.appId = tRTCTranscodingConfig.appId;
            this.bizId = tRTCTranscodingConfig.bizId;
            this.mode = tRTCTranscodingConfig.mode;
            this.videoWidth = tRTCTranscodingConfig.videoWidth;
            this.videoHeight = tRTCTranscodingConfig.videoHeight;
            this.videoBitrate = tRTCTranscodingConfig.videoBitrate;
            this.videoFramerate = tRTCTranscodingConfig.videoFramerate;
            this.videoGOP = tRTCTranscodingConfig.videoGOP;
            this.backgroundColor = tRTCTranscodingConfig.backgroundColor;
            this.backgroundImage = tRTCTranscodingConfig.backgroundImage;
            this.audioSampleRate = tRTCTranscodingConfig.audioSampleRate;
            this.audioBitrate = tRTCTranscodingConfig.audioBitrate;
            this.audioChannels = tRTCTranscodingConfig.audioChannels;
            this.audioCodec = tRTCTranscodingConfig.audioCodec;
            this.streamId = tRTCTranscodingConfig.streamId;
            this.videoSeiParams = tRTCTranscodingConfig.videoSeiParams;
            this.mixUsers = new ArrayList<>(tRTCTranscodingConfig.mixUsers);
        }
    }
}
