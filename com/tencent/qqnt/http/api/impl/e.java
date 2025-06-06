package com.tencent.qqnt.http.api.impl;

import com.tencent.qqnt.http.api.m;
import kotlin.Metadata;
import okhttp3.Call;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/http/api/impl/e;", "", "Lokhttp3/Call;", "call", "Lcom/tencent/qqnt/http/api/b;", "task", "", "onCallFinish", "generateCall", "", "hasSameTask", "Lcom/tencent/qqnt/http/api/m;", "taskResult", "notifySameTask", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface e {
    @NotNull
    Call generateCall(@NotNull com.tencent.qqnt.http.api.b task);

    boolean hasSameTask(@NotNull com.tencent.qqnt.http.api.b task);

    void notifySameTask(@NotNull com.tencent.qqnt.http.api.b task, @NotNull m taskResult);

    void onCallFinish(@NotNull Call call, @NotNull com.tencent.qqnt.http.api.b task);
}
