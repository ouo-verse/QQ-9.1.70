package com.tencent.richframework.gallery.delegate.inner;

import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import com.tencent.richframework.widget.drag.RFWDragLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/richframework/gallery/delegate/inner/IGalleryPageProvider;", "", "dragLayout", "Lcom/tencent/richframework/widget/drag/RFWDragLayout;", "getDragLayout", "()Lcom/tencent/richframework/widget/drag/RFWDragLayout;", "galleryViewPager", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "getGalleryViewPager", "()Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public interface IGalleryPageProvider {
    @NotNull
    RFWDragLayout getDragLayout();

    @NotNull
    RFWGalleryViewPager getGalleryViewPager();
}
