package com.tencent.ams.fusion.widget.apng.frame.animation.loader;

import com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader;
import com.tencent.ams.fusion.widget.apng.frame.animation.io.StreamReader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class StreamLoader implements Loader {
    static IPatchRedirector $redirector_;

    public StreamLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected abstract InputStream getInputStream() throws IOException;

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.loader.Loader
    public final synchronized Reader obtain() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Reader) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new StreamReader(getInputStream());
    }
}
