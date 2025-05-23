package com.tencent.ams.fusion.widget.apng.frame.animation.loader;

import com.tencent.ams.fusion.widget.apng.frame.animation.io.ByteBufferReader;
import com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class ByteBufferLoader implements Loader {
    static IPatchRedirector $redirector_;

    public ByteBufferLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract ByteBuffer getByteBuffer();

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.loader.Loader
    public Reader obtain() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Reader) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new ByteBufferReader(getByteBuffer());
    }
}
