package com.tencent.live2.jsplugin.pusher;

import android.os.Bundle;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.impl.V2TXLiveUtils;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;

/* loaded from: classes7.dex */
public class V2TXLivePusherJSConfig {
    static IPatchRedirector $redirector_;
    private static final TXAudioEffectManager.TXVoiceReverbType[] REVERB_TYPES;
    private static final TXAudioEffectManager.TXVoiceChangerType[] VOICE_CHANGER_TYPES;
    public int aspect;
    public V2TXLiveDef.V2TXLiveAudioQuality audioQuality;
    public String backgroundImagePath;
    public int beautyLevel;
    public int beautyStyle;
    public boolean enableAGC;
    public boolean enableANS;
    public boolean enableAutoFocus;
    public boolean enableBGMEventCallback;
    public boolean enableCamera;
    public boolean enableDebugView;
    public boolean enableEarMonitor;
    public boolean enableMicrophone;
    public boolean enableRemoteMirror;
    public boolean enableZoom;
    public String filterImagePath;
    public int fps;
    public int height;
    public boolean isAutoPush;
    public boolean isFrontCamera;
    public boolean isMuteAudio;
    public boolean isVOIP;
    public boolean isVerticalOrientation;
    public int maxBitrate;
    public int minBitrate;
    public V2TXLiveDef.V2TXLiveMirrorType mirrorType;
    public int mode;
    public TXAudioEffectManager.TXVoiceReverbType reverbType;
    public String url;
    public TXAudioEffectManager.TXVoiceChangerType voiceChangerType;
    public int volumeNotifyIntervals;
    public TXDeviceManager.TXSystemVolumeType volumeType;
    public String watermarkImagePath;
    public float watermarkLeft;
    public float watermarkTop;
    public float watermarkWidth;
    public int whitenessLevel;
    public int width;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17300);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            REVERB_TYPES = new TXAudioEffectManager.TXVoiceReverbType[]{TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7};
            VOICE_CHANGER_TYPES = new TXAudioEffectManager.TXVoiceChangerType[]{TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11};
        }
    }

    public V2TXLivePusherJSConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.url = "";
        this.mode = 1;
        this.isAutoPush = false;
        this.enableBGMEventCallback = false;
        this.enableDebugView = false;
        this.isVOIP = false;
        this.enableCamera = true;
        this.isFrontCamera = true;
        this.isVerticalOrientation = true;
        this.enableAutoFocus = true;
        this.enableZoom = false;
        this.enableRemoteMirror = false;
        this.aspect = 2;
        this.width = 368;
        this.height = 640;
        this.minBitrate = 0;
        this.maxBitrate = 0;
        this.fps = 15;
        this.mirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeAuto;
        this.enableMicrophone = true;
        this.isMuteAudio = false;
        this.enableAGC = false;
        this.enableANS = false;
        this.enableEarMonitor = false;
        this.volumeNotifyIntervals = 0;
        this.volumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
        this.reverbType = TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0;
        this.voiceChangerType = TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0;
        this.audioQuality = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualityDefault;
        this.beautyStyle = 0;
        this.beautyLevel = 5;
        this.whitenessLevel = 3;
        this.watermarkImagePath = "";
        this.watermarkTop = 0.0f;
        this.watermarkLeft = 0.0f;
        this.watermarkWidth = 0.1f;
        this.backgroundImagePath = "";
    }

    public String diffConfig(V2TXLivePusherJSConfig v2TXLivePusherJSConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) v2TXLivePusherJSConfig);
        }
        StringBuilder sb5 = new StringBuilder();
        if (this.url != v2TXLivePusherJSConfig.url) {
            sb5.append("[url:" + V2TXLiveUtils.removeURLSensitiveInfo(this.url) + "]");
        }
        if (this.mode != v2TXLivePusherJSConfig.mode) {
            sb5.append("[mode:" + this.mode + "]");
        }
        if (this.isVOIP != v2TXLivePusherJSConfig.isVOIP) {
            sb5.append("[isVOIP:" + this.isVOIP + "]");
        }
        if (this.enableCamera != v2TXLivePusherJSConfig.enableCamera) {
            sb5.append("[enableCamera:" + this.enableCamera + "]");
        }
        if (this.isFrontCamera != v2TXLivePusherJSConfig.isFrontCamera) {
            sb5.append("[isFrontCamera:" + this.isFrontCamera + "]");
        }
        if (this.isVerticalOrientation != v2TXLivePusherJSConfig.isVerticalOrientation) {
            sb5.append("[isVerticalOrientation:" + this.isVerticalOrientation + "]");
        }
        if (this.aspect != v2TXLivePusherJSConfig.aspect) {
            sb5.append("[aspect:" + this.aspect + "]");
        }
        if (this.width != v2TXLivePusherJSConfig.width) {
            sb5.append("[width:" + this.width + "]");
        }
        if (this.height != v2TXLivePusherJSConfig.height) {
            sb5.append("[height:" + this.height + "]");
        }
        if (this.minBitrate != v2TXLivePusherJSConfig.minBitrate) {
            sb5.append("[minBitrate:" + this.minBitrate + "]");
        }
        if (this.maxBitrate != v2TXLivePusherJSConfig.maxBitrate) {
            sb5.append("[maxBitrate:" + this.maxBitrate + "]");
        }
        if (this.fps != v2TXLivePusherJSConfig.fps) {
            sb5.append("[fps:" + this.fps + "]");
        }
        if (this.enableMicrophone != v2TXLivePusherJSConfig.enableMicrophone) {
            sb5.append("[enableMicrophone:" + this.enableMicrophone + "]");
        }
        if (this.isMuteAudio != v2TXLivePusherJSConfig.isMuteAudio) {
            sb5.append("[isMuteAudio:" + this.isMuteAudio + "]");
        }
        if (this.enableAGC != v2TXLivePusherJSConfig.enableAGC) {
            sb5.append("[enableAGC:" + this.enableAGC + "]");
        }
        if (this.enableANS != v2TXLivePusherJSConfig.enableANS) {
            sb5.append("[enableANS:" + this.enableANS + "]");
        }
        if (this.enableEarMonitor != v2TXLivePusherJSConfig.enableEarMonitor) {
            sb5.append("[enableEarMonitor:" + this.enableEarMonitor + "]");
        }
        if (this.volumeType != v2TXLivePusherJSConfig.volumeType) {
            sb5.append("[volumeType:" + this.volumeType + "]");
        }
        if (this.reverbType != v2TXLivePusherJSConfig.reverbType) {
            sb5.append("[reverbType:" + this.reverbType + "]");
        }
        if (this.voiceChangerType != v2TXLivePusherJSConfig.voiceChangerType) {
            sb5.append("[voiceChangerType:" + this.voiceChangerType + "]");
        }
        if (this.audioQuality != v2TXLivePusherJSConfig.audioQuality) {
            sb5.append("[audioQuality:" + this.audioQuality + "]");
        }
        return sb5.toString();
    }

    public void parseAudioParam(Bundle bundle) {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
            return;
        }
        if (bundle.containsKey("muted")) {
            this.isMuteAudio = bundle.getBoolean("muted");
        }
        if (bundle.containsKey("enableMic")) {
            this.enableMicrophone = bundle.getBoolean("enableMic");
        }
        if (bundle.containsKey("audioQuality")) {
            String string = bundle.getString("audioQuality", "");
            string.hashCode();
            if (!string.equals(HippyImageInfo.QUALITY_LOW)) {
                this.audioQuality = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualityDefault;
            } else {
                this.audioQuality = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualitySpeech;
            }
        }
        if (bundle.containsKey("enableAGC")) {
            this.enableAGC = bundle.getBoolean("enableAGC");
        }
        if (bundle.containsKey("enableANS")) {
            this.enableANS = bundle.getBoolean("enableANS");
        }
        if (bundle.containsKey("enableEarMonitor")) {
            this.enableEarMonitor = bundle.getBoolean("enableEarMonitor");
        }
        if (bundle.containsKey("audioVolumeType")) {
            String string2 = bundle.getString("audioVolumeType", "");
            string2.hashCode();
            if (!string2.equals("voicecall")) {
                if (!string2.equals(QAdVrReportParams.ParamKey.MEDIA)) {
                    this.volumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
                } else {
                    this.volumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeMedia;
                }
            } else {
                this.volumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeVOIP;
            }
        }
        if (bundle.containsKey("audioReverbType") && (i17 = bundle.getInt("audioReverbType")) >= 0) {
            TXAudioEffectManager.TXVoiceReverbType[] tXVoiceReverbTypeArr = REVERB_TYPES;
            if (i17 < tXVoiceReverbTypeArr.length) {
                this.reverbType = tXVoiceReverbTypeArr[i17];
            }
        }
        if (bundle.containsKey(V2TXJSAdapterConstants.PUSHER_KEY_VOICE_CHANGER_TYPE) && (i16 = bundle.getInt(V2TXJSAdapterConstants.PUSHER_KEY_VOICE_CHANGER_TYPE)) >= 0) {
            TXAudioEffectManager.TXVoiceChangerType[] tXVoiceChangerTypeArr = VOICE_CHANGER_TYPES;
            if (i16 < tXVoiceChangerTypeArr.length) {
                this.voiceChangerType = tXVoiceChangerTypeArr[i16];
            }
        }
        if (bundle.containsKey("needAudioVolume")) {
            if (bundle.getBoolean("needAudioVolume")) {
                i3 = 300;
            } else {
                i3 = 0;
            }
            this.volumeNotifyIntervals = i3;
        }
    }

    public void parseBasicParam(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        if (bundle.containsKey("pushUrl")) {
            this.url = bundle.getString("pushUrl", "");
        }
        if (bundle.containsKey("mode")) {
            this.mode = bundle.getInt("mode");
        }
        if (bundle.containsKey("autopush")) {
            this.isAutoPush = bundle.getBoolean("autopush");
        }
        if (bundle.containsKey("needBGMEvent")) {
            this.enableBGMEventCallback = bundle.getBoolean("needBGMEvent");
        }
        if (bundle.containsKey("debug")) {
            this.enableDebugView = bundle.getBoolean("debug");
        }
        if (bundle.containsKey(V2TXJSAdapterConstants.IS_VOIP)) {
            this.isVOIP = bundle.getBoolean(V2TXJSAdapterConstants.IS_VOIP);
        }
    }

    public void parseBeautyParam(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
            return;
        }
        if (bundle.containsKey(V2TXJSAdapterConstants.PUSHER_KEY_BEAUTY_STYLE)) {
            String string = bundle.getString(V2TXJSAdapterConstants.PUSHER_KEY_BEAUTY_STYLE, "");
            string.hashCode();
            if (!string.equals("nature")) {
                this.beautyStyle = 0;
            } else {
                this.beautyStyle = 1;
            }
        }
        if (bundle.containsKey("beauty")) {
            this.beautyLevel = bundle.getInt("beauty");
        }
        if (bundle.containsKey("whiteness")) {
            this.whitenessLevel = bundle.getInt("whiteness");
        }
        if (bundle.containsKey(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE)) {
            this.filterImagePath = bundle.getString(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE, "");
        }
    }

    public void parseGasketParam(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle);
        } else if (bundle.containsKey("backgroundImage")) {
            this.backgroundImagePath = bundle.getString("backgroundImage", "");
        }
    }

    public void parseVideoParam(Bundle bundle) {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        if (bundle.containsKey("enableCamera")) {
            this.enableCamera = bundle.getBoolean("enableCamera");
        }
        if (bundle.containsKey("devicePosition")) {
            this.isFrontCamera = !"back".equals(bundle.getString("devicePosition", ""));
        }
        if (bundle.containsKey("focusMode")) {
            if (bundle.getInt("focusMode") == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.enableAutoFocus = z16;
        }
        if (bundle.containsKey("orientation")) {
            this.isVerticalOrientation = !"horizontal".equals(bundle.getString("orientation", ""));
        }
        if (bundle.containsKey("zoom")) {
            this.enableZoom = bundle.getBoolean("zoom");
        }
        if (bundle.containsKey("mirror")) {
            this.enableRemoteMirror = bundle.getBoolean("mirror");
        }
        if (bundle.containsKey("remoteMirror")) {
            this.enableRemoteMirror = bundle.getBoolean("remoteMirror");
        }
        if (bundle.containsKey("aspect")) {
            this.aspect = bundle.getInt("aspect");
        }
        if (bundle.containsKey("videoWidth")) {
            this.width = bundle.getInt("videoWidth");
        }
        if (bundle.containsKey("videoHeight")) {
            this.height = bundle.getInt("videoHeight");
        }
        if (bundle.containsKey("minBitrate")) {
            this.minBitrate = bundle.getInt("minBitrate");
        }
        if (bundle.containsKey("maxBitrate")) {
            this.maxBitrate = bundle.getInt("maxBitrate");
        }
        if (bundle.containsKey("fps")) {
            if (bundle.getInt("fps") > 0) {
                i3 = bundle.getInt("fps");
            } else {
                i3 = 15;
            }
            this.fps = Math.min(30, i3);
        }
        if (bundle.containsKey("localMirror")) {
            String string = bundle.getString("localMirror", "");
            string.hashCode();
            if (!string.equals("enable")) {
                if (!string.equals("disable")) {
                    this.mirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeAuto;
                    return;
                } else {
                    this.mirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeDisable;
                    return;
                }
            }
            this.mirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeEnable;
        }
    }

    public void parseWatermarkParam(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle);
            return;
        }
        if (bundle.containsKey("watermarkImage")) {
            this.watermarkImagePath = bundle.getString("watermarkImage", "");
        }
        if (bundle.containsKey("watermarkLeft")) {
            this.watermarkLeft = bundle.getFloat("watermarkLeft");
        }
        if (bundle.containsKey("watermarkTop")) {
            this.watermarkTop = bundle.getFloat("watermarkTop");
        }
        if (bundle.containsKey("watermarkWidth")) {
            this.watermarkWidth = bundle.getFloat("watermarkWidth");
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "[url:" + V2TXLiveUtils.removeURLSensitiveInfo(this.url) + "][mode:" + this.mode + "][isVOIP:" + this.isVOIP + "][isAutoPush:" + this.isAutoPush + "][enableCamera:" + this.enableCamera + "][isVerticalOrientation:" + this.isVerticalOrientation + "][aspect:" + this.aspect + "][width:" + this.width + "][height:" + this.height + "][minBitrate:" + this.minBitrate + "][maxBitrate:" + this.maxBitrate + "][fps:" + this.fps + "][enableMicrophone:" + this.enableMicrophone + "][isMuteAudio:" + this.isMuteAudio + "][enableAGC:" + this.enableAGC + "][enableANS:" + this.enableANS + "][enableEarMonitor:" + this.enableEarMonitor + "][volumeType:" + this.volumeType + "][audioQuality:" + this.audioQuality + ']';
    }

    public void updateFromBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        parseBasicParam(bundle);
        parseVideoParam(bundle);
        parseAudioParam(bundle);
        parseBeautyParam(bundle);
        parseWatermarkParam(bundle);
        parseGasketParam(bundle);
    }

    public V2TXLivePusherJSConfig(V2TXLivePusherJSConfig v2TXLivePusherJSConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) v2TXLivePusherJSConfig);
            return;
        }
        this.url = "";
        this.mode = 1;
        this.isAutoPush = false;
        this.enableBGMEventCallback = false;
        this.enableDebugView = false;
        this.isVOIP = false;
        this.enableCamera = true;
        this.isFrontCamera = true;
        this.isVerticalOrientation = true;
        this.enableAutoFocus = true;
        this.enableZoom = false;
        this.enableRemoteMirror = false;
        this.aspect = 2;
        this.width = 368;
        this.height = 640;
        this.minBitrate = 0;
        this.maxBitrate = 0;
        this.fps = 15;
        this.mirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeAuto;
        this.enableMicrophone = true;
        this.isMuteAudio = false;
        this.enableAGC = false;
        this.enableANS = false;
        this.enableEarMonitor = false;
        this.volumeNotifyIntervals = 0;
        this.volumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
        this.reverbType = TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0;
        this.voiceChangerType = TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0;
        this.audioQuality = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualityDefault;
        this.beautyStyle = 0;
        this.beautyLevel = 5;
        this.whitenessLevel = 3;
        this.watermarkImagePath = "";
        this.watermarkTop = 0.0f;
        this.watermarkLeft = 0.0f;
        this.watermarkWidth = 0.1f;
        this.backgroundImagePath = "";
        this.url = v2TXLivePusherJSConfig.url;
        this.mode = v2TXLivePusherJSConfig.mode;
        this.isAutoPush = v2TXLivePusherJSConfig.isAutoPush;
        this.enableBGMEventCallback = v2TXLivePusherJSConfig.enableBGMEventCallback;
        this.enableDebugView = v2TXLivePusherJSConfig.enableDebugView;
        this.isVOIP = v2TXLivePusherJSConfig.isVOIP;
        this.enableCamera = v2TXLivePusherJSConfig.enableCamera;
        this.isFrontCamera = v2TXLivePusherJSConfig.isFrontCamera;
        this.enableAutoFocus = v2TXLivePusherJSConfig.enableAutoFocus;
        this.isVerticalOrientation = v2TXLivePusherJSConfig.isVerticalOrientation;
        this.enableZoom = v2TXLivePusherJSConfig.enableZoom;
        this.enableRemoteMirror = v2TXLivePusherJSConfig.enableRemoteMirror;
        this.aspect = v2TXLivePusherJSConfig.aspect;
        this.width = v2TXLivePusherJSConfig.width;
        this.height = v2TXLivePusherJSConfig.height;
        this.minBitrate = v2TXLivePusherJSConfig.minBitrate;
        this.maxBitrate = v2TXLivePusherJSConfig.maxBitrate;
        this.fps = v2TXLivePusherJSConfig.fps;
        this.mirrorType = v2TXLivePusherJSConfig.mirrorType;
        this.enableMicrophone = v2TXLivePusherJSConfig.enableMicrophone;
        this.isMuteAudio = v2TXLivePusherJSConfig.isMuteAudio;
        this.enableAGC = v2TXLivePusherJSConfig.enableAGC;
        this.enableANS = v2TXLivePusherJSConfig.enableANS;
        this.enableEarMonitor = v2TXLivePusherJSConfig.enableEarMonitor;
        this.volumeNotifyIntervals = v2TXLivePusherJSConfig.volumeNotifyIntervals;
        this.volumeType = v2TXLivePusherJSConfig.volumeType;
        this.reverbType = v2TXLivePusherJSConfig.reverbType;
        this.voiceChangerType = v2TXLivePusherJSConfig.voiceChangerType;
        this.audioQuality = v2TXLivePusherJSConfig.audioQuality;
        this.beautyStyle = v2TXLivePusherJSConfig.beautyStyle;
        this.beautyLevel = v2TXLivePusherJSConfig.beautyLevel;
        this.whitenessLevel = v2TXLivePusherJSConfig.whitenessLevel;
        this.filterImagePath = v2TXLivePusherJSConfig.filterImagePath;
        this.watermarkImagePath = v2TXLivePusherJSConfig.watermarkImagePath;
        this.watermarkTop = v2TXLivePusherJSConfig.watermarkTop;
        this.watermarkLeft = v2TXLivePusherJSConfig.watermarkLeft;
        this.watermarkWidth = v2TXLivePusherJSConfig.watermarkWidth;
        this.backgroundImagePath = v2TXLivePusherJSConfig.backgroundImagePath;
    }
}
