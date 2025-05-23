package com.tencent.local_edit.andserver.http;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.util.MediaType;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface e {
    @NonNull
    String a() throws IOException;

    String b();

    @Nullable
    MediaType contentType();

    long length();

    @NonNull
    InputStream stream() throws IOException;
}
