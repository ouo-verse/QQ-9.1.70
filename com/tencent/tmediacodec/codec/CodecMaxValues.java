package com.tencent.tmediacodec.codec;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class CodecMaxValues {
    static IPatchRedirector $redirector_;
    public int height;
    public int inputSize;
    public int width;

    public CodecMaxValues(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.width = i3;
        this.height = i16;
        this.inputSize = i17;
    }
}
