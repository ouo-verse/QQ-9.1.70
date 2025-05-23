package com.tencent.mobileqq.zplan.friend.changerole.view.itemview;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J(\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0012\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/changerole/view/itemview/ZplanFriendStepItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "startX", "startY", "", "a", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "getItemOffsets", "c", "onDraw", "Landroid/graphics/Paint;", "d", "Lkotlin/Lazy;", "b", "()Landroid/graphics/Paint;", "paint", "Landroid/graphics/Path;", "e", "()Landroid/graphics/Path;", "path", "", "f", "I", "dp40", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanFriendStepItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy path;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int dp40;

    public ZplanFriendStepItemDecoration() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Paint>() { // from class: com.tencent.mobileqq.zplan.friend.changerole.view.itemview.ZplanFriendStepItemDecoration$paint$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Paint invoke() {
                Paint paint = new Paint(1);
                paint.setColor(-1);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(3.0f);
                paint.setPathEffect(new DashPathEffect(new float[]{12.0f, 4.0f}, 0.0f));
                return paint;
            }
        });
        this.paint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Path>() { // from class: com.tencent.mobileqq.zplan.friend.changerole.view.itemview.ZplanFriendStepItemDecoration$path$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Path invoke() {
                return new Path();
            }
        });
        this.path = lazy2;
        this.dp40 = UIUtils.b(BaseApplication.getContext(), 40.0f);
    }

    private final void a(Canvas canvas, float startX, float startY) {
        c().reset();
        c().moveTo(startX, startY);
        c().lineTo(startX + this.dp40, startY);
        canvas.drawPath(c(), b());
    }

    private final Paint b() {
        return (Paint) this.paint.getValue();
    }

    private final Path c() {
        return (Path) this.path.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) != 0) {
            outRect.left = this.dp40;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c16, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(c16, parent, state);
        RecyclerView.Adapter adapter = parent.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        int bottom = (parent.getBottom() - parent.getTop()) / 3;
        int i3 = itemCount - 1;
        for (int i16 = 0; i16 < i3; i16++) {
            if (parent.getChildAt(i16) != null) {
                a(c16, r2.getRight(), bottom);
            }
        }
    }
}
