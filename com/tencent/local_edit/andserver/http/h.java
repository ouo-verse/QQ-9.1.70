package com.tencent.local_edit.andserver.http;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.util.MediaType;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface h {
    long contentLength();

    @Nullable
    MediaType contentType();

    boolean isChunked();

    boolean isRepeatable();

    void writeTo(@NonNull OutputStream outputStream) throws IOException;
}
