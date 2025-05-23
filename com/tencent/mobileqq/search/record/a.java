package com.tencent.mobileqq.search.record;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J*\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0002H&J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH&J \u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000eH&J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/search/record/a;", "", "", "onRecorderStart", "", "maxAmplitude", "", "sliceData", "size", "", "time", "d", "onRecorderEnd", "errCode", "", "errMsg", "a", "sessionId", "text", "c", "errorCode", "textContent", "e", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface a {
    void a(int errCode, @NotNull String errMsg);

    void b(@NotNull String sessionId);

    void c(@NotNull String sessionId, @NotNull String text);

    void d(int maxAmplitude, @Nullable byte[] sliceData, int size, double time);

    void e(@NotNull String sessionId, int errorCode, @NotNull String textContent);

    void onRecorderEnd();

    void onRecorderStart();
}
