package com.tencent.qqnt.http.api;

import java.io.InputStream;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0004H'J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/http/api/g;", "", "Ljava/io/InputStream;", "a", "", "Lkotlin/Pair;", "", "headers", "", "getHeaders", "http_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface g {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        @Nullable
        public static Map<String, String> a(@NotNull g gVar) {
            Map<String, String> map;
            Iterable<Pair<String, String>> headers = gVar.headers();
            if (headers != null) {
                map = MapsKt__MapsKt.toMap(headers);
                return map;
            }
            return null;
        }
    }

    @Nullable
    InputStream a();

    @Nullable
    Map<String, String> getHeaders();

    @Deprecated(message = "use getHeaders()")
    @Nullable
    Iterable<Pair<String, String>> headers();
}
