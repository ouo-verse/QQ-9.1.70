package com.tencent.richframework.gallery.item.section;

import android.widget.ImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/richframework/gallery/item/section/ClickPicEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "data", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "imageView", "Landroid/widget/ImageView;", "(Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;Landroid/widget/ImageView;)V", "getData", "()Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "getImageView", "()Landroid/widget/ImageView;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final /* data */ class ClickPicEvent extends SimpleBaseEvent {

    @NotNull
    private final RFWLayerItemMediaInfo data;

    @NotNull
    private final ImageView imageView;

    public ClickPicEvent(@NotNull RFWLayerItemMediaInfo data, @NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        this.data = data;
        this.imageView = imageView;
    }

    public static /* synthetic */ ClickPicEvent copy$default(ClickPicEvent clickPicEvent, RFWLayerItemMediaInfo rFWLayerItemMediaInfo, ImageView imageView, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            rFWLayerItemMediaInfo = clickPicEvent.data;
        }
        if ((i3 & 2) != 0) {
            imageView = clickPicEvent.imageView;
        }
        return clickPicEvent.copy(rFWLayerItemMediaInfo, imageView);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final RFWLayerItemMediaInfo getData() {
        return this.data;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final ImageView getImageView() {
        return this.imageView;
    }

    @NotNull
    public final ClickPicEvent copy(@NotNull RFWLayerItemMediaInfo data, @NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        return new ClickPicEvent(data, imageView);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ClickPicEvent) {
                ClickPicEvent clickPicEvent = (ClickPicEvent) other;
                if (!Intrinsics.areEqual(this.data, clickPicEvent.data) || !Intrinsics.areEqual(this.imageView, clickPicEvent.imageView)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final RFWLayerItemMediaInfo getData() {
        return this.data;
    }

    @NotNull
    public final ImageView getImageView() {
        return this.imageView;
    }

    public int hashCode() {
        int i3;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.data;
        int i16 = 0;
        if (rFWLayerItemMediaInfo != null) {
            i3 = rFWLayerItemMediaInfo.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        ImageView imageView = this.imageView;
        if (imageView != null) {
            i16 = imageView.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "ClickPicEvent(data=" + this.data + ", imageView=" + this.imageView + ")";
    }
}
