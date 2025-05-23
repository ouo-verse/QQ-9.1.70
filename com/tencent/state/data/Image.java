package com.tencent.state.data;

import android.util.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0000J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/data/Image;", "", "url", "", "size", "Landroid/util/Size;", "(Ljava/lang/String;Landroid/util/Size;)V", "getSize", "()Landroid/util/Size;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isSame", "newImage", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes4.dex */
public final /* data */ class Image {

    @NotNull
    private final Size size;

    @NotNull
    private final String url;

    public Image(@NotNull String url, @NotNull Size size) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(size, "size");
        this.url = url;
        this.size = size;
    }

    public static /* synthetic */ Image copy$default(Image image, String str, Size size, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = image.url;
        }
        if ((i3 & 2) != 0) {
            size = image.size;
        }
        return image.copy(str, size);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    @NotNull
    public final Image copy(@NotNull String url, @NotNull Size size) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(size, "size");
        return new Image(url, size);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Image) {
                Image image = (Image) other;
                if (!Intrinsics.areEqual(this.url, image.url) || !Intrinsics.areEqual(this.size, image.size)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final Size getSize() {
        return this.size;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i3;
        String str = this.url;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        Size size = this.size;
        if (size != null) {
            i16 = size.hashCode();
        }
        return i17 + i16;
    }

    public final boolean isSame(@NotNull Image newImage) {
        Intrinsics.checkNotNullParameter(newImage, "newImage");
        if (Intrinsics.areEqual(this.url, newImage.url) && this.size.getWidth() == newImage.size.getWidth() && this.size.getHeight() == newImage.size.getHeight()) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "Image(url=" + this.url + ", size=" + this.size + ")";
    }
}
