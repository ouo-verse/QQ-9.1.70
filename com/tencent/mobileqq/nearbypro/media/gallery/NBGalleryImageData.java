package com.tencent.mobileqq.nearbypro.media.gallery;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/media/gallery/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "id", "Lcom/tencent/mobileqq/nearbypro/media/gallery/b;", "b", "Lcom/tencent/mobileqq/nearbypro/media/gallery/b;", "c", "()Lcom/tencent/mobileqq/nearbypro/media/gallery/b;", "smallImage", "largeImage", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/nearbypro/media/gallery/b;Lcom/tencent/mobileqq/nearbypro/media/gallery/b;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.media.gallery.a, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class NBGalleryImageData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final NBGalleryImageInfo smallImage;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final NBGalleryImageInfo largeImage;

    public NBGalleryImageData(@NotNull String id5, @NotNull NBGalleryImageInfo smallImage, @NotNull NBGalleryImageInfo largeImage) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(smallImage, "smallImage");
        Intrinsics.checkNotNullParameter(largeImage, "largeImage");
        this.id = id5;
        this.smallImage = smallImage;
        this.largeImage = largeImage;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final NBGalleryImageInfo getLargeImage() {
        return this.largeImage;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final NBGalleryImageInfo getSmallImage() {
        return this.smallImage;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NBGalleryImageData)) {
            return false;
        }
        NBGalleryImageData nBGalleryImageData = (NBGalleryImageData) other;
        if (Intrinsics.areEqual(this.id, nBGalleryImageData.id) && Intrinsics.areEqual(this.smallImage, nBGalleryImageData.smallImage) && Intrinsics.areEqual(this.largeImage, nBGalleryImageData.largeImage)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.smallImage.hashCode()) * 31) + this.largeImage.hashCode();
    }

    @NotNull
    public String toString() {
        return "NBGalleryImageData(id=" + this.id + ", smallImage=" + this.smallImage + ", largeImage=" + this.largeImage + ")";
    }
}
