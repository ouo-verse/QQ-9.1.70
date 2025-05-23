package com.tencent.aelight.camera.ae.flashshow.ui;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0018B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0019\u001a\u00020\n\u00a2\u0006\u0004\b\u0014\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowGridView;", "Landroid/support/v7/widget/RecyclerView;", "Landroid/content/Context;", "context", "", "init", "c", "d", "Landroid/content/Context;", "mContext", "", "e", "I", "itemNum", "f", "itemHeight", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", tl.h.F, "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "itemDecoration", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "b", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEFlashShowGridView extends RecyclerView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int itemNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int itemHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView.ItemDecoration itemDecoration;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowGridView$b;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroid/support/v7/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/support/v7/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "spanCount", "e", "hSpacing", "f", "vSpacing", "", tl.h.F, "Z", "includeEdge", "<init>", "(Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowGridView;IIIZ)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int spanCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int hSpacing;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int vSpacing;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final boolean includeEdge;

        public b(int i3, int i16, int i17, boolean z16) {
            this.spanCount = i3;
            this.hSpacing = i16;
            this.vSpacing = i17;
            this.includeEdge = z16;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            int i3 = this.spanCount;
            int i16 = childAdapterPosition % i3;
            if (this.includeEdge) {
                int i17 = this.hSpacing;
                outRect.left = i17 - ((i16 * i17) / i3);
                outRect.right = ((i16 + 1) * i17) / i3;
                if (childAdapterPosition < i3) {
                    outRect.top = this.vSpacing;
                }
                outRect.bottom = this.vSpacing;
                return;
            }
            int i18 = this.hSpacing;
            outRect.left = (i16 * i18) / i3;
            outRect.right = i18 - (((i16 + 1) * i18) / i3);
            if (childAdapterPosition >= i3) {
                outRect.top = this.vSpacing;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowGridView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        init(context2);
    }

    private final void init(Context context) {
        this.mContext = context;
        c();
    }

    public final void c() {
        Context context = this.mContext;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        int f16 = BaseAIOUtils.f(64.0f, context.getResources());
        Context context3 = this.mContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context3 = null;
        }
        int f17 = BaseAIOUtils.f(8.0f, context3.getResources());
        Context context4 = this.mContext;
        if (context4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context4 = null;
        }
        int f18 = BaseAIOUtils.f(20.0f, context4.getResources());
        Context context5 = this.mContext;
        if (context5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context5 = null;
        }
        int f19 = BaseAIOUtils.f(20.0f, context5.getResources());
        Context context6 = this.mContext;
        if (context6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context2 = context6;
        }
        int i3 = context2.getResources().getDisplayMetrics().widthPixels - (f19 * 2);
        this.itemNum = ((i3 - f16) / (f17 + f16)) + 1;
        setPadding(f19, 0, f19, f18 * 2);
        int i16 = this.itemNum;
        int i17 = (i3 - (i16 * f16)) / (i16 - 1);
        setClipToPadding(false);
        setLayoutManager(new GridLayoutManager(getContext(), this.itemNum));
        RecyclerView.ItemDecoration itemDecoration = this.itemDecoration;
        if (itemDecoration != null) {
            removeItemDecoration(itemDecoration);
        }
        b bVar = new b(this.itemNum, i17, f18, false);
        this.itemDecoration = bVar;
        addItemDecoration(bVar);
        this.itemHeight = f16;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        init(context2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        init(context2);
    }
}
