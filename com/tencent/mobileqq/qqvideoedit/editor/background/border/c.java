package com.tencent.mobileqq.qqvideoedit.editor.background.border;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.model.EditViewTransform;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\u0002H&J\n\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0017\u001a\u00020\u0014H&J\b\u0010\u0018\u001a\u00020\u0005H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0005H&J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/c;", "", "", HippyTKDListViewAdapter.X, "y", "Landroid/graphics/PointF;", "g", "degree", "c", "(F)Ljava/lang/Float;", "e", "getMaxScale", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/e;", "b", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/model/a;", "transform", "", "a", "Landroid/graphics/RectF;", "d", "", "active", "setActive", "isActive", "getCenter", "f", h.F, "()Ljava/lang/Float;", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface c {
    void a(@NotNull EditViewTransform transform);

    @Nullable
    e b();

    @Nullable
    Float c(float degree);

    @Nullable
    RectF d();

    float e();

    @Nullable
    PointF f();

    @Nullable
    PointF g(float x16, float y16);

    @NotNull
    PointF getCenter();

    float getMaxScale();

    @Nullable
    Float h();

    boolean isActive();

    void setActive(boolean active);
}
