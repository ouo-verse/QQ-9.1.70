package com.tencent.kuikly.core.views;

import com.tencent.aekit.plugin.core.AIInput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/kuikly/core/views/ad;", "", "", "contentOffsetX", "contentOffsetY", "Lcom/tencent/kuikly/core/views/bn;", "params", "", "onContentOffsetDidChanged", "subViewsDidLayout", "contentViewDidSetFrameToRenderView", "width", "height", "contentSizeDidChanged", "onPagerParentScrollerDidScroll", "scrollerDragBegin", "scrollerScrollDidEnd", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "scrollFrameDidChanged", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public interface ad {
    void contentSizeDidChanged(float width, float height);

    void contentViewDidSetFrameToRenderView();

    void onContentOffsetDidChanged(float contentOffsetX, float contentOffsetY, ScrollParams params);

    void onPagerParentScrollerDidScroll();

    void scrollFrameDidChanged(com.tencent.kuikly.core.layout.d frame);

    void scrollerDragBegin(ScrollParams params);

    void scrollerScrollDidEnd(ScrollParams params);

    void subViewsDidLayout();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class a {
        public static void d(ad adVar, com.tencent.kuikly.core.layout.d frame) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }

        public static void e(ad adVar, ScrollParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
        }

        public static void f(ad adVar, ScrollParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
        }

        public static void b(ad adVar) {
        }

        public static void c(ad adVar) {
        }

        public static void g(ad adVar) {
        }

        public static void a(ad adVar, float f16, float f17) {
        }
    }
}
