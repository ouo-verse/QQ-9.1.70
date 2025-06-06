package com.tencent.mobileqq.qqexpand.flutter.channel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/flutter/channel/IExpandChannelCallback;", "", "error", "", "errorCode", "", "errorMsg", "errorDetails", "notImplemented", "success", "ret", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public interface IExpandChannelCallback {
    void error(@NotNull String errorCode, @Nullable String errorMsg, @Nullable Object errorDetails);

    void notImplemented();

    void success(@Nullable Object ret);
}
