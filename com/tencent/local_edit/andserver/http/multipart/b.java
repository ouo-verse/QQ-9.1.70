package com.tencent.local_edit.andserver.http.multipart;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface b {
    byte[] getBytes() throws IOException;

    long getSize();

    @NonNull
    InputStream getStream() throws IOException;
}
