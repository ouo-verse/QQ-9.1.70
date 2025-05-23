package com.tenpay.sdk.net.core.log;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tenpay/sdk/net/core/log/DLogAgent;", "Lcom/tenpay/sdk/net/core/log/ILogAgent;", "()V", "d", "", "tag", "", "msg", "e", "", "i", "v", "w", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class DLogAgent implements ILogAgent {
    @Override // com.tenpay.sdk.net.core.log.ILogAgent
    public void d(@NotNull String tag, @NotNull String msg2, @Nullable Throwable e16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d(tag, 2, msg2, e16);
    }

    @Override // com.tenpay.sdk.net.core.log.ILogAgent
    public void e(@NotNull String tag, @NotNull String msg2, @Nullable Throwable e16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.e(tag, 1, msg2, e16);
    }

    @Override // com.tenpay.sdk.net.core.log.ILogAgent
    public void i(@NotNull String tag, @NotNull String msg2, @Nullable Throwable e16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.i(tag, 1, msg2, e16);
    }

    @Override // com.tenpay.sdk.net.core.log.ILogAgent
    public void v(@NotNull String tag, @NotNull String msg2, @Nullable Throwable e16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d(tag, 2, msg2, e16);
    }

    @Override // com.tenpay.sdk.net.core.log.ILogAgent
    public void w(@NotNull String tag, @NotNull String msg2, @Nullable Throwable e16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.w(tag, 1, msg2, e16);
    }
}
