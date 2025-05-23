package org.jbox2d.serialization;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface SerializationResult {
    Object getValue();

    void writeTo(OutputStream outputStream) throws IOException;
}
