package com.tencent.mobileqq.z1.download;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadUrlRsp;", "Ljava/io/Serializable;", "fullUrl", "", "md5", "path", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFullUrl", "()Ljava/lang/String;", "getMd5", "getPath", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class ZPlanResDownloadUrlRsp implements Serializable {

    @NotNull
    private final String fullUrl;

    @NotNull
    private final String md5;

    @NotNull
    private final String path;

    public ZPlanResDownloadUrlRsp(@NotNull String fullUrl, @NotNull String md5, @NotNull String path) {
        Intrinsics.checkNotNullParameter(fullUrl, "fullUrl");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(path, "path");
        this.fullUrl = fullUrl;
        this.md5 = md5;
        this.path = path;
    }

    public static /* synthetic */ ZPlanResDownloadUrlRsp copy$default(ZPlanResDownloadUrlRsp zPlanResDownloadUrlRsp, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = zPlanResDownloadUrlRsp.fullUrl;
        }
        if ((i3 & 2) != 0) {
            str2 = zPlanResDownloadUrlRsp.md5;
        }
        if ((i3 & 4) != 0) {
            str3 = zPlanResDownloadUrlRsp.path;
        }
        return zPlanResDownloadUrlRsp.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getFullUrl() {
        return this.fullUrl;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final ZPlanResDownloadUrlRsp copy(@NotNull String fullUrl, @NotNull String md5, @NotNull String path) {
        Intrinsics.checkNotNullParameter(fullUrl, "fullUrl");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(path, "path");
        return new ZPlanResDownloadUrlRsp(fullUrl, md5, path);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanResDownloadUrlRsp)) {
            return false;
        }
        ZPlanResDownloadUrlRsp zPlanResDownloadUrlRsp = (ZPlanResDownloadUrlRsp) other;
        if (Intrinsics.areEqual(this.fullUrl, zPlanResDownloadUrlRsp.fullUrl) && Intrinsics.areEqual(this.md5, zPlanResDownloadUrlRsp.md5) && Intrinsics.areEqual(this.path, zPlanResDownloadUrlRsp.path)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getFullUrl() {
        return this.fullUrl;
    }

    @NotNull
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public int hashCode() {
        return (((this.fullUrl.hashCode() * 31) + this.md5.hashCode()) * 31) + this.path.hashCode();
    }

    @NotNull
    public String toString() {
        return "ZPlanResDownloadUrlRsp(fullUrl=" + this.fullUrl + ", md5=" + this.md5 + ", path=" + this.path + ')';
    }
}
