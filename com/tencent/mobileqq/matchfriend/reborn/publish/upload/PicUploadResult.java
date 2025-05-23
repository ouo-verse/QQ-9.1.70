package com.tencent.mobileqq.matchfriend.reborn.publish.upload;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\t\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/upload/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "success", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "url", "I", "d", "()I", "width", "height", "<init>", "(ZLjava/lang/String;II)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.publish.upload.a, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class PicUploadResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean success;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String url;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    public PicUploadResult(boolean z16, String url, int i3, int i16) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.success = z16;
        this.url = url;
        this.width = i3;
        this.height = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: c, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: d, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.success;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((r06 * 31) + this.url.hashCode()) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        return "PicUploadResult(success=" + this.success + ", url=" + this.url + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public /* synthetic */ PicUploadResult(boolean z16, String str, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i17 & 2) != 0 ? "" : str, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PicUploadResult)) {
            return false;
        }
        PicUploadResult picUploadResult = (PicUploadResult) other;
        return this.success == picUploadResult.success && Intrinsics.areEqual(this.url, picUploadResult.url) && this.width == picUploadResult.width && this.height == picUploadResult.height;
    }
}
