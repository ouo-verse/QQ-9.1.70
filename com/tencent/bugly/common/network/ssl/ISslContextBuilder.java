package com.tencent.bugly.common.network.ssl;

import javax.net.ssl.SSLContext;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/bugly/common/network/ssl/ISslContextBuilder;", "", "sslContext", "Ljavax/net/ssl/SSLContext;", "getSslContext", "()Ljavax/net/ssl/SSLContext;", "build", "initSslContext", "", "ssl", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public interface ISslContextBuilder {
    @Nullable
    SSLContext build();

    @Nullable
    SSLContext getSslContext();

    void initSslContext(@NotNull SSLContext ssl);
}
