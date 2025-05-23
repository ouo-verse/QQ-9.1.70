package com.tencent.biz;

import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J%\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J'\u0010\t\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\u001a\u0010\f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\r\u001a\u00020\u0000H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/j;", "", "T", "", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "b", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "value", "d", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/biz/j;", "c", "e", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public interface j {
    @NotNull
    j a();

    <T> T b(@NotNull String key, T defaultValue);

    @Nullable
    String c(@NotNull String key, @Nullable String defaultValue);

    @NotNull
    <T> j d(@NotNull String key, @Nullable T value);

    @NotNull
    j e(@NotNull String key, @Nullable String value);
}
