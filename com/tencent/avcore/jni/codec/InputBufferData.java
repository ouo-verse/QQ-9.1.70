package com.tencent.avcore.jni.codec;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class InputBufferData {
    static IPatchRedirector $redirector_;
    public ByteBuffer buffer;
    public int index;
    public boolean processing;

    public InputBufferData(ByteBuffer byteBuffer, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) byteBuffer, i3);
            return;
        }
        this.processing = false;
        this.buffer = byteBuffer;
        this.index = i3;
    }
}
