package com.tencent.video.decode;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AVDecodeOption {
    static IPatchRedirector $redirector_ = null;
    public static final int DISABLE_DROP_VIDEO_FPS = -1;
    public static final int ENCODING_PCM_16BIT = 65281;
    public static final int ENCODING_PCM_8BIT = 65280;
    public static final int ENCODING_PCM_FLOAT = 65282;
    public int audioFormat;
    public boolean cycle;
    public String filename;
    public boolean fixDuration;
    public boolean ignore_audio;
    public String mAfPath;
    public int mDecodeType;
    public int mTotalTime;
    public String mVfPath;
    public int mVideoFrames;
    public boolean only_keyframe;
    public float wantedFps;

    public AVDecodeOption() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.audioFormat = ENCODING_PCM_16BIT;
        this.wantedFps = 0.0f;
        this.fixDuration = true;
        this.mDecodeType = 0;
    }
}
