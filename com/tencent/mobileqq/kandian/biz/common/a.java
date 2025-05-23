package com.tencent.mobileqq.kandian.biz.common;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/common/a;", "", "Ljava/net/URL;", "url", "", "a", "", "b", "", "Ljava/util/Map;", "urlStrToObjMap", "<init>", "()V", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f239282a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, URL> urlStrToObjMap = new LinkedHashMap();

    a() {
    }

    public final void a(@NotNull URL url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Map<String, URL> map = urlStrToObjMap;
        String url2 = url.toString();
        Intrinsics.checkNotNullExpressionValue(url2, "url.toString()");
        map.put(url2, url);
    }

    @Nullable
    public final URL b(@Nullable String url) {
        if (url == null) {
            return null;
        }
        return urlStrToObjMap.get(url);
    }
}
