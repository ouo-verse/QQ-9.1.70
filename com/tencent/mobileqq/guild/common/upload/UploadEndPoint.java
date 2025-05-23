package com.tencent.mobileqq.guild.common.upload;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/common/upload/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "host", "b", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.common.upload.a, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class UploadEndPoint {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String host;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    public UploadEndPoint(@NotNull String host, @NotNull String url) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(url, "url");
        this.host = host;
        this.url = url;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getHost() {
        return this.host;
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
        if (!(other instanceof UploadEndPoint)) {
            return false;
        }
        UploadEndPoint uploadEndPoint = (UploadEndPoint) other;
        if (Intrinsics.areEqual(this.host, uploadEndPoint.host) && Intrinsics.areEqual(this.url, uploadEndPoint.url)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.host.hashCode() * 31) + this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "UploadEndPoint(host=" + this.host + ", url=" + this.url + ")";
    }
}
