package com.tenpay.sdk.net.core.log;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tenpay/sdk/net/core/log/DLog;", "Lcom/tenpay/sdk/net/core/log/ILogAgent;", "()V", "TAG", "", "logAgent", "Lcom/tenpay/sdk/net/core/log/DLogAgent;", "d", "", "tag", "msg", "e", "", "getTag", "bizTag", "i", "v", "w", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class DLog implements ILogAgent {

    @NotNull
    public static final String TAG = "QWalletHttp";

    @NotNull
    public static final DLog INSTANCE = new DLog();

    @NotNull
    private static final DLogAgent logAgent = new DLogAgent();

    DLog() {
    }

    @Override // com.tenpay.sdk.net.core.log.ILogAgent
    public void d(@NotNull String tag, @NotNull String msg2, @Nullable Throwable e16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        logAgent.d(getTag(tag), msg2, e16);
    }

    @Override // com.tenpay.sdk.net.core.log.ILogAgent
    public void e(@NotNull String tag, @NotNull String msg2, @Nullable Throwable e16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        logAgent.e(getTag(tag), msg2, e16);
    }

    @NotNull
    public final String getTag(@NotNull String bizTag) {
        Intrinsics.checkNotNullParameter(bizTag, "bizTag");
        return "QWalletHttp-" + bizTag;
    }

    @Override // com.tenpay.sdk.net.core.log.ILogAgent
    public void i(@NotNull String tag, @NotNull String msg2, @Nullable Throwable e16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        logAgent.i(getTag(tag), msg2, e16);
    }

    @Override // com.tenpay.sdk.net.core.log.ILogAgent
    public void v(@NotNull String tag, @NotNull String msg2, @Nullable Throwable e16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        logAgent.v(getTag(tag), msg2, e16);
    }

    @Override // com.tenpay.sdk.net.core.log.ILogAgent
    public void w(@NotNull String tag, @NotNull String msg2, @Nullable Throwable e16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        logAgent.w(getTag(tag), msg2, e16);
    }
}
