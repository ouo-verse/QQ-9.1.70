package com.tencent.local_edit.andserver.http;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.http.cookie.Cookie;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface c {
    void a(@NonNull String str, long j3);

    void b(h hVar);

    void c(@NonNull Cookie cookie);

    @Nullable
    String getHeader(@NonNull String str);

    void setHeader(@NonNull String str, @NonNull String str2);

    void setStatus(int i3);
}
