package com.tencent.qqnt.http.api;

import java.net.InetAddress;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/http/api/a;", "", "", "useDefaultDns", "", "hostname", "", "Ljava/net/InetAddress;", "lookup", "http_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.http.api.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final class C9631a {
        @Nullable
        public static List<InetAddress> a(@NotNull a aVar, @NotNull String hostname) {
            Intrinsics.checkNotNullParameter(hostname, "hostname");
            return null;
        }
    }

    @Nullable
    List<InetAddress> lookup(@NotNull String hostname);

    boolean useDefaultDns();
}
