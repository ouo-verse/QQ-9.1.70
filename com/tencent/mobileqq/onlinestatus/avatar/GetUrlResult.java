package com.tencent.mobileqq.onlinestatus.avatar;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0015\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/avatar/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "key", "b", "downloadUrl", "Z", "()Z", "checkMd5AndSha", "d", "md5", "e", "sha1", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.onlinestatus.avatar.a, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class GetUrlResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String key;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String downloadUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean checkMd5AndSha;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String md5;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sha1;

    public GetUrlResult(@NotNull String key, @NotNull String downloadUrl, boolean z16, @NotNull String md5, @NotNull String sha1) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        this.key = key;
        this.downloadUrl = downloadUrl;
        this.checkMd5AndSha = z16;
        this.md5 = md5;
        this.sha1 = sha1;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getCheckMd5AndSha() {
        return this.checkMd5AndSha;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getSha1() {
        return this.sha1;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetUrlResult)) {
            return false;
        }
        GetUrlResult getUrlResult = (GetUrlResult) other;
        if (Intrinsics.areEqual(this.key, getUrlResult.key) && Intrinsics.areEqual(this.downloadUrl, getUrlResult.downloadUrl) && this.checkMd5AndSha == getUrlResult.checkMd5AndSha && Intrinsics.areEqual(this.md5, getUrlResult.md5) && Intrinsics.areEqual(this.sha1, getUrlResult.sha1)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.key.hashCode() * 31) + this.downloadUrl.hashCode()) * 31;
        boolean z16 = this.checkMd5AndSha;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((hashCode + i3) * 31) + this.md5.hashCode()) * 31) + this.sha1.hashCode();
    }

    @NotNull
    public String toString() {
        return "GetUrlResult(key=" + this.key + ", downloadUrl=" + this.downloadUrl + ", checkMd5AndSha=" + this.checkMd5AndSha + ", md5=" + this.md5 + ", sha1=" + this.sha1 + ')';
    }
}
