package com.tencent.bugly.common.network.ssl;

import javax.net.ssl.SSLContext;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/bugly/common/network/ssl/DefaultSslContextBuilder;", "Lcom/tencent/bugly/common/network/ssl/ISslContextBuilder;", "()V", "sslContext", "Ljavax/net/ssl/SSLContext;", "getSslContext", "()Ljavax/net/ssl/SSLContext;", "sslContext$delegate", "Lkotlin/Lazy;", "build", "initSslContext", "", "ssl", "Companion", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class DefaultSslContextBuilder implements ISslContextBuilder {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultSslContextBuilder.class), "sslContext", "getSslContext()Ljavax/net/ssl/SSLContext;"))};

    @NotNull
    public static final String TAG = "Bugly_common_DefaultSslContextBuilder";

    /* renamed from: sslContext$delegate, reason: from kotlin metadata */
    @Nullable
    private final Lazy sslContext;

    public DefaultSslContextBuilder() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SSLContext>() { // from class: com.tencent.bugly.common.network.ssl.DefaultSslContextBuilder$sslContext$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final SSLContext invoke() {
                try {
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    Intrinsics.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\")");
                    DefaultSslContextBuilder.this.initSslContext(sSLContext);
                    return sSLContext;
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    return null;
                }
            }
        });
        this.sslContext = lazy;
    }

    @Override // com.tencent.bugly.common.network.ssl.ISslContextBuilder
    @Nullable
    public SSLContext build() {
        return getSslContext();
    }

    @Override // com.tencent.bugly.common.network.ssl.ISslContextBuilder
    @Nullable
    public SSLContext getSslContext() {
        Lazy lazy = this.sslContext;
        KProperty kProperty = $$delegatedProperties[0];
        return (SSLContext) lazy.getValue();
    }

    @Override // com.tencent.bugly.common.network.ssl.ISslContextBuilder
    public void initSslContext(@NotNull SSLContext ssl) {
        Intrinsics.checkParameterIsNotNull(ssl, "ssl");
        ssl.init(null, null, null);
    }
}
