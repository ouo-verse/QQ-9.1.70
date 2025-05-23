package com.tencent.live2.jsplugin.player;

import android.os.Bundle;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.impl.V2TXLiveUtils;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes7.dex */
public class V2TXLivePlayerJSConfig {
    static IPatchRedirector $redirector_;
    public static int sAudioRoute;
    public int audioRoute;
    public boolean enableDebugView;
    public boolean enableRecvSEIMessage;
    public V2TXLiveDef.V2TXLiveFillMode fillMode;
    public boolean isAutoPlay;
    public boolean isCanAutoPlay;
    public boolean isMuteAudio;
    public boolean isMuteVideo;
    public float maxCache;
    public float minCache;
    public int mode;
    public V2TXLiveDef.V2TXLiveRotation renderRotation;
    public String url;
    public int volumeNotifyIntervals;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16626);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            sAudioRoute = TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone.ordinal();
        }
    }

    public V2TXLivePlayerJSConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.url = "";
        this.mode = 1;
        this.isCanAutoPlay = true;
        this.minCache = 1.0f;
        this.maxCache = 3.0f;
        this.audioRoute = TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone.ordinal();
        this.fillMode = V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill;
        this.renderRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0;
    }

    public String diffConfig(V2TXLivePlayerJSConfig v2TXLivePlayerJSConfig) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) v2TXLivePlayerJSConfig);
        }
        StringBuilder sb5 = new StringBuilder();
        String str2 = this.url;
        if (str2 != null && !str2.equals(v2TXLivePlayerJSConfig.url)) {
            sb5.append("[url:");
            sb5.append(V2TXLiveUtils.removeURLSensitiveInfo(this.url));
            sb5.append("]");
        }
        if (this.mode != v2TXLivePlayerJSConfig.mode) {
            sb5.append("[mode:");
            sb5.append(this.mode);
            sb5.append("]");
        }
        if (this.isCanAutoPlay != v2TXLivePlayerJSConfig.isCanAutoPlay) {
            sb5.append("[isCanAutoPlay:");
            sb5.append(this.isCanAutoPlay);
            sb5.append("]");
        }
        if (this.isAutoPlay != v2TXLivePlayerJSConfig.isAutoPlay) {
            sb5.append("[isAutoPlay:");
            sb5.append(this.isAutoPlay);
            sb5.append("]");
        }
        if (this.isMuteVideo != v2TXLivePlayerJSConfig.isMuteVideo) {
            sb5.append("[isMuteVideo:");
            sb5.append(this.isMuteVideo);
            sb5.append("]");
        }
        if (this.isMuteAudio != v2TXLivePlayerJSConfig.isMuteAudio) {
            sb5.append("[isMuteAudio:");
            sb5.append(this.isMuteAudio);
            sb5.append("]");
        }
        if (this.enableRecvSEIMessage != v2TXLivePlayerJSConfig.enableRecvSEIMessage) {
            sb5.append("[enableRecvSEIMessage:");
            sb5.append(this.enableRecvSEIMessage);
            sb5.append("]");
        }
        if (this.minCache != v2TXLivePlayerJSConfig.minCache) {
            sb5.append("[minCache:");
            sb5.append(this.minCache);
            sb5.append("]");
        }
        if (this.maxCache != v2TXLivePlayerJSConfig.maxCache) {
            sb5.append("[macCache:");
            sb5.append(this.maxCache);
            sb5.append("]");
        }
        if (this.audioRoute != v2TXLivePlayerJSConfig.audioRoute) {
            sb5.append("[audioRoute:");
            if (this.audioRoute == TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone.ordinal()) {
                str = "speaker";
            } else {
                str = "ear";
            }
            sb5.append(str);
            sb5.append("]");
        }
        if (this.volumeNotifyIntervals != v2TXLivePlayerJSConfig.volumeNotifyIntervals) {
            sb5.append("[volumeNotifyIntervals:");
            sb5.append(this.volumeNotifyIntervals);
            sb5.append("]");
        }
        if (this.fillMode != v2TXLivePlayerJSConfig.fillMode) {
            sb5.append("[fillMode:");
            sb5.append(this.fillMode);
            sb5.append("]");
        }
        if (this.renderRotation != v2TXLivePlayerJSConfig.renderRotation) {
            sb5.append("[renderRotation:");
            sb5.append(this.renderRotation);
            sb5.append("]");
        }
        return sb5.toString();
    }

    public String toString() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("[url:");
        sb5.append(V2TXLiveUtils.removeURLSensitiveInfo(this.url));
        sb5.append("][mode:");
        sb5.append(this.mode);
        sb5.append("][isAutoPlay:");
        sb5.append(this.isAutoPlay);
        sb5.append("][isCanAutoPlay:");
        sb5.append(this.isCanAutoPlay);
        sb5.append("][isMuteVideo:");
        sb5.append(this.isMuteVideo);
        sb5.append("][isMuteAudio:");
        sb5.append(this.isMuteAudio);
        sb5.append("][enableDebugView:");
        sb5.append(this.enableDebugView);
        sb5.append("][enableRecvSEIMessage:");
        sb5.append(this.enableRecvSEIMessage);
        sb5.append("][minCache:");
        sb5.append(this.minCache);
        sb5.append("][maxCache:");
        sb5.append(this.maxCache);
        sb5.append("][volumeNotifyIntervals:");
        sb5.append(this.volumeNotifyIntervals);
        sb5.append("][audioRoute:");
        if (this.audioRoute == TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone.ordinal()) {
            str = "speaker";
        } else {
            str = "ear";
        }
        sb5.append(str);
        sb5.append("][fillMode:");
        sb5.append(this.fillMode);
        sb5.append("][renderRotation:");
        sb5.append(this.renderRotation);
        sb5.append(']');
        return sb5.toString();
    }

    public void updateFromBundle(Bundle bundle) {
        int ordinal;
        int i3;
        V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode;
        V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        if (bundle.containsKey("playUrl")) {
            this.url = bundle.getString("playUrl", "");
        }
        if (bundle.containsKey("mode")) {
            this.mode = bundle.getInt("mode");
        }
        if (bundle.containsKey("autoplay")) {
            this.isAutoPlay = bundle.getBoolean("autoplay");
        }
        if (bundle.containsKey(V2TXJSAdapterConstants.PLAYER_KEY_CAN_AUTO_PLAY)) {
            this.isCanAutoPlay = bundle.getBoolean(V2TXJSAdapterConstants.PLAYER_KEY_CAN_AUTO_PLAY);
        }
        if (bundle.containsKey("muteVideo")) {
            this.isMuteVideo = bundle.getBoolean("muteVideo");
        }
        if (bundle.containsKey("muteAudio")) {
            this.isMuteAudio = bundle.getBoolean("muteAudio");
        }
        if (bundle.containsKey("muted")) {
            this.isMuteAudio = bundle.getBoolean("muted");
        }
        if (bundle.containsKey("orientation")) {
            if (bundle.getString("orientation", "").equalsIgnoreCase("horizontal")) {
                v2TXLiveRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation90;
            } else {
                v2TXLiveRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0;
            }
            this.renderRotation = v2TXLiveRotation;
        }
        if (bundle.containsKey("objectFit")) {
            if (bundle.getString("objectFit", "").equalsIgnoreCase("fillCrop")) {
                v2TXLiveFillMode = V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill;
            } else {
                v2TXLiveFillMode = V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFit;
            }
            this.fillMode = v2TXLiveFillMode;
        }
        if (bundle.containsKey("minCache")) {
            this.minCache = bundle.getFloat("minCache");
        }
        if (bundle.containsKey("maxCache")) {
            this.maxCache = bundle.getFloat("maxCache");
        }
        if (bundle.containsKey("enableRecvMessage")) {
            this.enableRecvSEIMessage = bundle.getBoolean("enableRecvMessage");
        }
        if (bundle.containsKey("needAudioVolume")) {
            if (bundle.getBoolean("needAudioVolume")) {
                i3 = 300;
            } else {
                i3 = 0;
            }
            this.volumeNotifyIntervals = i3;
        }
        if (bundle.containsKey("debug")) {
            this.enableDebugView = bundle.getBoolean("debug");
        }
        if (bundle.containsKey("soundMode")) {
            if (bundle.getString("soundMode", "").equalsIgnoreCase("speaker")) {
                ordinal = TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone.ordinal();
            } else {
                ordinal = TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece.ordinal();
            }
            this.audioRoute = ordinal;
            sAudioRoute = ordinal;
        }
    }

    public V2TXLivePlayerJSConfig(V2TXLivePlayerJSConfig v2TXLivePlayerJSConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) v2TXLivePlayerJSConfig);
            return;
        }
        this.url = "";
        this.mode = 1;
        this.isCanAutoPlay = true;
        this.minCache = 1.0f;
        this.maxCache = 3.0f;
        this.audioRoute = TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone.ordinal();
        this.fillMode = V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill;
        this.renderRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0;
        this.url = v2TXLivePlayerJSConfig.url;
        this.mode = v2TXLivePlayerJSConfig.mode;
        this.isAutoPlay = v2TXLivePlayerJSConfig.isAutoPlay;
        this.isCanAutoPlay = v2TXLivePlayerJSConfig.isCanAutoPlay;
        this.isMuteAudio = v2TXLivePlayerJSConfig.isMuteAudio;
        this.isMuteVideo = v2TXLivePlayerJSConfig.isMuteVideo;
        this.enableDebugView = v2TXLivePlayerJSConfig.enableDebugView;
        this.enableRecvSEIMessage = v2TXLivePlayerJSConfig.enableRecvSEIMessage;
        this.minCache = v2TXLivePlayerJSConfig.minCache;
        this.maxCache = v2TXLivePlayerJSConfig.maxCache;
        this.volumeNotifyIntervals = v2TXLivePlayerJSConfig.volumeNotifyIntervals;
        this.audioRoute = v2TXLivePlayerJSConfig.audioRoute;
        this.fillMode = v2TXLivePlayerJSConfig.fillMode;
        this.renderRotation = v2TXLivePlayerJSConfig.renderRotation;
    }
}
