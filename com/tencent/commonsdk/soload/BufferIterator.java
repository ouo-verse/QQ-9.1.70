package com.tencent.commonsdk.soload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class BufferIterator {
    static IPatchRedirector $redirector_;

    public BufferIterator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract int readInt();

    public abstract short readShort();

    public abstract void seek(int i3);

    public abstract void skip(int i3);
}
