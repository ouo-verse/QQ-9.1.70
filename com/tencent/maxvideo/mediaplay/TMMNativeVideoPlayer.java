package com.tencent.maxvideo.mediaplay;

import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
public class TMMNativeVideoPlayer {
    static IPatchRedirector $redirector_;
    public long nativeAddr;

    public TMMNativeVideoPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public native void init(Object obj);

    public native void nativeChangeSize(int i3, int i16);

    public native boolean nativeIsLooping();

    public native boolean nativeIsPlaying();

    public native void nativePause();

    public native void nativePlayAudio();

    public native void nativeProcessMsg(MessageStruct messageStruct);

    public native void nativeRelease();

    public native void nativeRenderScene();

    public native void nativeReset();

    public native void nativeSeekTo(int i3);

    public native void nativeSetAudioPath(String str);

    public native void nativeSetFilter(int i3);

    public native void nativeSetLooping(boolean z16);

    public native void nativeSetPlayOrder(int i3);

    public native void nativeSetPlaySpeed(int i3);

    public native void nativeSetPlayingAudio(boolean z16);

    public native void nativeSetVideoPath(String str);

    public native void nativeSetVideoURI(String str);

    public native void nativeSetupScene();

    public native void nativeShutdownScene();

    public native void nativeStart();

    public native void nativeStartRealFps(int i3, int i16);

    public native void nativeStop();

    public native void nativeStopAudio();
}
