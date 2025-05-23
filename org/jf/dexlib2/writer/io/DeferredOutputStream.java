package org.jf.dexlib2.writer.io;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class DeferredOutputStream extends OutputStream {
    public abstract void writeTo(OutputStream outputStream) throws IOException;
}
