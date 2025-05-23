package com.tencent.kuikly.core.render.android.expand.component.list;

import android.view.View;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/list/a;", "", "", "offsetX", "offsetY", "", "l", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "j", "Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerContentView;", "contentView", "Landroid/view/View;", "contentViewChild", "o", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface a {
    void j(float offsetX, float offsetY);

    void l(float offsetX, float offsetY);

    void o(@NotNull KRRecyclerContentView contentView, @NotNull View contentViewChild);

    void onScroll(float offsetX, float offsetY);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.list.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C5873a {
        public static void b(@NotNull a aVar, @NotNull KRRecyclerContentView contentView, @NotNull View contentViewChild) {
            Intrinsics.checkNotNullParameter(contentView, "contentView");
            Intrinsics.checkNotNullParameter(contentViewChild, "contentViewChild");
        }

        public static void a(@NotNull a aVar, float f16, float f17) {
        }

        public static void c(@NotNull a aVar, float f16, float f17) {
        }
    }
}
