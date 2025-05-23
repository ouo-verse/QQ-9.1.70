package com.tencent.lightquic.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\bH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/lightquic/api/IRequestCallback;", "", "onBodyReceived", "", "body", "", "onHeaderReceived", "header", "", "onRequestFinished", "errCode", "", "errMsg", "onRequestStats", "statsInfo", "LightQUIC_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IRequestCallback {
    void onBodyReceived(@NotNull byte[] body);

    void onHeaderReceived(@NotNull String header);

    void onRequestFinished(int errCode, @Nullable String errMsg);

    void onRequestStats(@NotNull String statsInfo);
}
