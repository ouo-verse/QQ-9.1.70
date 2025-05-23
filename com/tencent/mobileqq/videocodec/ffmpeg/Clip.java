package com.tencent.mobileqq.videocodec.ffmpeg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
class Clip implements Cloneable {
    static IPatchRedirector $redirector_;
    public String aspect;
    public int audioBitrate;
    public String audioCodec;
    public double duration;
    public String format;
    public int height;
    public String mimeType;
    public String path;
    public String rotate;
    public String startTime;
    public int videoBitrate;
    public String videoCodec;
    public String videoFps;
    public int width;

    public Clip(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.width = -1;
        this.height = -1;
        this.videoBitrate = -1;
        this.audioBitrate = -1;
        this.duration = -1.0d;
        this.rotate = "0";
        this.path = str;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Clip m228clone() throws CloneNotSupportedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? (Clip) super.clone() : (Clip) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
