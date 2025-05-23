package com.tencent.mobileqq.z1.download;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0003R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadReq;", "Ljava/io/Serializable;", "path", "", "url", "md5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMd5", "()Ljava/lang/String;", "getPath", "getUrl", "getProxyDownloadType", "getUniqueKey", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class ZPlanResDownloadReq implements Serializable {

    @NotNull
    private final String md5;

    @NotNull
    private final String path;

    @NotNull
    private final String url;

    public ZPlanResDownloadReq(@NotNull String path, @NotNull String url, @NotNull String md5) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(md5, "md5");
        this.path = path;
        this.url = url;
        this.md5 = md5;
    }

    @NotNull
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final String getProxyDownloadType() {
        return "ZPlanResDownloadReq";
    }

    @NotNull
    public final String getUniqueKey() {
        return this.path;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public /* synthetic */ ZPlanResDownloadReq(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3);
    }
}
