package com.tencent.video.decode;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class AVVideoParam {
    static IPatchRedirector $redirector_;
    public int duration;
    public int errcode;
    public int fps_den;
    public int fps_num;
    public int frame_count;
    public int frame_index;
    public int height;
    public int rotation;
    public int stream_kind;
    public int width;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AVVideoParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
