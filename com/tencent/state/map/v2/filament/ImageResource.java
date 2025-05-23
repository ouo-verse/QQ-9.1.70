package com.tencent.state.map.v2.filament;

import com.google.gson.Gson;
import com.tencent.state.map.v2.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\u0006\u0010\u0013\u001a\u00020\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/map/v2/filament/ImageResource;", "", "url", "", "size", "Lcom/tencent/state/map/v2/Size;", "(Ljava/lang/String;Lcom/tencent/state/map/v2/Size;)V", "getSize", "()Lcom/tencent/state/map/v2/Size;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final /* data */ class ImageResource {
    private final Size size;
    private final String url;

    public ImageResource(String url, Size size) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(size, "size");
        this.url = url;
        this.size = size;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    public final ImageResource copy(String url, Size size) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(size, "size");
        return new ImageResource(url, size);
    }

    public final Size getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Size size = this.size;
        return hashCode + (size != null ? size.hashCode() : 0);
    }

    public final String toJson() {
        String json = new Gson().toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
        return json;
    }

    public String toString() {
        return "ImageResource(url=" + this.url + ", size=" + this.size + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageResource)) {
            return false;
        }
        ImageResource imageResource = (ImageResource) other;
        return Intrinsics.areEqual(this.url, imageResource.url) && Intrinsics.areEqual(this.size, imageResource.size);
    }

    public static /* synthetic */ ImageResource copy$default(ImageResource imageResource, String str, Size size, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = imageResource.url;
        }
        if ((i3 & 2) != 0) {
            size = imageResource.size;
        }
        return imageResource.copy(str, size);
    }
}
