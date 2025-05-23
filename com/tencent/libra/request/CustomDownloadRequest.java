package com.tencent.libra.request;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/libra/request/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "headers", "<init>", "(Ljava/util/Map;)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.libra.request.a, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class CustomDownloadRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Map<String, String> headers;

    public CustomDownloadRequest() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public final Map<String, String> a() {
        return this.headers;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof CustomDownloadRequest) || !Intrinsics.areEqual(this.headers, ((CustomDownloadRequest) other).headers)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public int hashCode() {
        Map<String, String> map = this.headers;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "CustomDownloadRequest(headers=" + this.headers + ")";
    }

    public CustomDownloadRequest(@NotNull Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.headers = headers;
    }

    public /* synthetic */ CustomDownloadRequest(Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new LinkedHashMap() : map);
    }
}
