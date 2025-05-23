package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NullOutputStream extends OutputStream {
    public static final NullOutputStream NULL_OUTPUT_STREAM = new NullOutputStream();

    @Override // java.io.OutputStream
    public void write(int i3) {
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) {
    }
}
