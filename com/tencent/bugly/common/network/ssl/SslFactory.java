package com.tencent.bugly.common.network.ssl;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00048B@BX\u0082\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f8F\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/bugly/common/network/ssl/SslFactory;", "", "()V", "DEFAULT_SSL_CONTEXT", "Lcom/tencent/bugly/common/network/ssl/ISslContextBuilder;", "value", "sslBuilder", "getSslBuilder", "()Lcom/tencent/bugly/common/network/ssl/ISslContextBuilder;", "setSslBuilder", "(Lcom/tencent/bugly/common/network/ssl/ISslContextBuilder;)V", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class SslFactory {

    @JvmField
    @NotNull
    public static final ISslContextBuilder DEFAULT_SSL_CONTEXT;
    public static final SslFactory INSTANCE = new SslFactory();
    private static ISslContextBuilder sslBuilder;

    @Nullable
    private static final SSLSocketFactory sslSocketFactory = null;

    static {
        DefaultSslContextBuilder defaultSslContextBuilder = new DefaultSslContextBuilder();
        DEFAULT_SSL_CONTEXT = defaultSslContextBuilder;
        sslBuilder = defaultSslContextBuilder;
    }

    SslFactory() {
    }

    private final ISslContextBuilder getSslBuilder() {
        ISslContextBuilder iSslContextBuilder = sslBuilder;
        if (iSslContextBuilder == null) {
            return DEFAULT_SSL_CONTEXT;
        }
        return iSslContextBuilder;
    }

    private final void setSslBuilder(ISslContextBuilder iSslContextBuilder) {
        synchronized (SslFactory.class) {
            sslBuilder = iSslContextBuilder;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Nullable
    public final SSLSocketFactory getSslSocketFactory() {
        SSLContext build;
        SSLSocketFactory sSLSocketFactory = sslSocketFactory;
        if (sSLSocketFactory == null) {
            ISslContextBuilder sslBuilder2 = getSslBuilder();
            if (sslBuilder2 != null && (build = sslBuilder2.build()) != null) {
                return build.getSocketFactory();
            }
            return null;
        }
        return sSLSocketFactory;
    }
}
