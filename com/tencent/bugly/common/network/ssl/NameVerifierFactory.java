package com.tencent.bugly.common.network.ssl;

import javax.net.ssl.HostnameVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/bugly/common/network/ssl/NameVerifierFactory;", "", "()V", "DEFAULT_NAME_VERIFIER", "Ljavax/net/ssl/HostnameVerifier;", "value", "nameVerifier", "getNameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "setNameVerifier", "(Ljavax/net/ssl/HostnameVerifier;)V", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class NameVerifierFactory {

    @JvmField
    @NotNull
    public static final HostnameVerifier DEFAULT_NAME_VERIFIER;
    public static final NameVerifierFactory INSTANCE = new NameVerifierFactory();

    @Nullable
    private static HostnameVerifier nameVerifier;

    static {
        DefaultNameVerifier defaultNameVerifier = new DefaultNameVerifier();
        DEFAULT_NAME_VERIFIER = defaultNameVerifier;
        nameVerifier = defaultNameVerifier;
    }

    NameVerifierFactory() {
    }

    @Nullable
    public final HostnameVerifier getNameVerifier() {
        HostnameVerifier hostnameVerifier = nameVerifier;
        if (hostnameVerifier == null) {
            return DEFAULT_NAME_VERIFIER;
        }
        return hostnameVerifier;
    }

    public final void setNameVerifier(@Nullable HostnameVerifier hostnameVerifier) {
        synchronized (SslFactory.class) {
            nameVerifier = hostnameVerifier;
            Unit unit = Unit.INSTANCE;
        }
    }
}
