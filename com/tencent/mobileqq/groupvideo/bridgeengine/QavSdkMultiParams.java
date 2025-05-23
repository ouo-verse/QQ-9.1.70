package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;

@Keep
/* loaded from: classes12.dex */
public class QavSdkMultiParams {
    static IPatchRedirector $redirector_;
    public int appId;
    public long appRoomId;
    public String appVersion;
    public int audioCategory;
    public long authBits;
    public byte[] authbuffer;
    public String controlRole;
    public boolean enableHdAudio;
    public boolean enableMic;
    public boolean enableSpeaker;
    public int scene;
    public int screenRecvMode;
    public int videoRecvMode;

    public QavSdkMultiParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.appId = 0;
        this.appVersion = "";
        this.controlRole = "";
        this.appRoomId = 0L;
        this.audioCategory = 0;
        this.authBits = 0L;
        this.videoRecvMode = 0;
        this.screenRecvMode = 0;
        this.enableMic = false;
        this.enableSpeaker = false;
        this.enableHdAudio = false;
        this.scene = 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QavSdkMultiParams{appId=" + this.appId + ", appVersion=" + this.appVersion + ", authbuffer=" + Arrays.toString(this.authbuffer) + ", controlRole=" + this.controlRole + ", appRoomId=" + this.appRoomId + ", audioCategory='" + this.audioCategory + "', authBits=" + this.authBits + ", videoRecvMode=" + this.videoRecvMode + ", screenRecvMode=" + this.screenRecvMode + ", enableMic=" + this.enableMic + ", enableSpeaker=" + this.enableSpeaker + ", enableHdAudio=" + this.enableHdAudio + ", scene=" + this.scene + '}';
    }
}
