package org.jf.dexlib2.writer.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface DexDataStore {
    void close() throws IOException;

    @Nonnull
    OutputStream outputAt(int i3);

    @Nonnull
    InputStream readAt(int i3);
}
