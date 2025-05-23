package com.tencent.qqnt.http.api;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\b\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/http/api/f;", "", "", "contentLength", "()Ljava/lang/Long;", "", "", "headers", "", "a", "http_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface f {
    int a();

    @Nullable
    Long contentLength();

    @Nullable
    Map<String, String> headers();
}
