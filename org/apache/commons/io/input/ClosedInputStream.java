package org.apache.commons.io.input;

import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ClosedInputStream extends InputStream {
    public static final ClosedInputStream CLOSED_INPUT_STREAM = new ClosedInputStream();

    @Override // java.io.InputStream
    public int read() {
        return -1;
    }
}
