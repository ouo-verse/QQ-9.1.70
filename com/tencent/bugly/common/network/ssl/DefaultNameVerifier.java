package com.tencent.bugly.common.network.ssl;

import com.tencent.bugly.BuildConfigWrapper;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/bugly/common/network/ssl/DefaultNameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "verify", "", "hostname", "", SessionDbHelper.SESSION_ID, "Ljavax/net/ssl/SSLSession;", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class DefaultNameVerifier implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(@NotNull String hostname, @NotNull SSLSession session) {
        Intrinsics.checkParameterIsNotNull(hostname, "hostname");
        Intrinsics.checkParameterIsNotNull(session, "session");
        try {
            URL url = new URL(BuildConfigWrapper.getDomain());
            URL url2 = new URL(BuildConfigWrapper.getAttaUrl());
            if (!Intrinsics.areEqual(hostname, url.getHost())) {
                if (!Intrinsics.areEqual(hostname, url2.getHost())) {
                    return false;
                }
                return true;
            }
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }
}
