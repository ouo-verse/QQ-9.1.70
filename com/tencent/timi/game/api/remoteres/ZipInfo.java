package com.tencent.timi.game.api.remoteres;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/timi/game/api/remoteres/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "url", "md5", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.api.remoteres.b, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class ZipInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String md5;

    public ZipInfo(@NotNull String url, @NotNull String md5) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(md5, "md5");
        this.url = url;
        this.md5 = md5;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZipInfo)) {
            return false;
        }
        ZipInfo zipInfo = (ZipInfo) other;
        if (Intrinsics.areEqual(this.url, zipInfo.url) && Intrinsics.areEqual(this.md5, zipInfo.md5)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.md5.hashCode();
    }

    @NotNull
    public String toString() {
        return "ZipInfo(url=" + this.url + ", md5=" + this.md5 + ')';
    }
}
