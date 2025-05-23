package com.tencent.mobileqq.nearbypro.media.gallery;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/media/gallery/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "picUrl", "I", "c", "()I", "width", "height", "<init>", "(Ljava/lang/String;II)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.media.gallery.b, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class NBGalleryImageInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String picUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    public NBGalleryImageInfo(@NotNull String picUrl, int i3, int i16) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        this.picUrl = picUrl;
        this.width = i3;
        this.height = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    /* renamed from: c, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NBGalleryImageInfo)) {
            return false;
        }
        NBGalleryImageInfo nBGalleryImageInfo = (NBGalleryImageInfo) other;
        if (Intrinsics.areEqual(this.picUrl, nBGalleryImageInfo.picUrl) && this.width == nBGalleryImageInfo.width && this.height == nBGalleryImageInfo.height) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.picUrl.hashCode() * 31) + this.width) * 31) + this.height;
    }

    @NotNull
    public String toString() {
        return "NBGalleryImageInfo(picUrl=" + this.picUrl + ", width=" + this.width + ", height=" + this.height + ")";
    }
}
