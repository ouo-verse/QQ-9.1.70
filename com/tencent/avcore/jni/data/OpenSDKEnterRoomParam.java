package com.tencent.avcore.jni.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class OpenSDKEnterRoomParam {
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
    public String freeFlowSignature;
    public int scene;
    public int screenRecvMode;
    public int videoRecvMode;

    public OpenSDKEnterRoomParam(int i3, String str, String str2, byte[] bArr, String str3, long j3, int i16, long j16, int i17, int i18, boolean z16, boolean z17, boolean z18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, bArr, str3, Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i19));
            return;
        }
        this.appId = i3;
        this.appVersion = str;
        this.freeFlowSignature = str2;
        this.authbuffer = bArr;
        this.controlRole = str3;
        this.appRoomId = j3;
        this.audioCategory = i16;
        this.authBits = j16;
        this.videoRecvMode = i17;
        this.screenRecvMode = i18;
        this.enableMic = z16;
        this.enableSpeaker = z17;
        this.enableHdAudio = z18;
        this.scene = i19;
    }
}
