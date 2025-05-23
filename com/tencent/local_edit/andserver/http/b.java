package com.tencent.local_edit.andserver.http;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.util.MediaType;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface b extends a {
    long a(@NonNull String str);

    @Nullable
    f b(@NonNull String str);

    @NonNull
    List<MediaType> d();

    @Nullable
    e getBody();

    @Nullable
    MediaType getContentType();

    @Nullable
    String getHeader(@NonNull String str);

    @NonNull
    List<String> getHeaders(@NonNull String str);

    @NonNull
    HttpMethod getMethod();

    @Nullable
    String getParameter(@NonNull String str);

    @NonNull
    String getPath();

    @NonNull
    String getURI();
}
