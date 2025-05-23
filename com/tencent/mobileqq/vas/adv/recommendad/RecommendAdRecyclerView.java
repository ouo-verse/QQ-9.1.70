package com.tencent.mobileqq.vas.adv.recommendad;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.recommendad.RecommendAdView;
import com.tencent.mobileqq.vas.adv.recommendad.a;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0002>?B\u0011\b\u0016\u0012\u0006\u00106\u001a\u000205\u00a2\u0006\u0004\b7\u00108B\u001b\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\b\u0010:\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\b7\u0010;B#\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\u0006\u0010<\u001a\u00020\u0014\u00a2\u0006\u0004\b7\u0010=J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010(\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u00104\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mobileqq/vas/adv/recommendad/a$b;", "D", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lcom/tencent/mobileqq/vas/adv/recommendad/a;", "adapter", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$b;", "touchInterceptor", "", "H", "K", "I", "L", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "", "f", UserInfo.SEX_FEMALE, "()I", "setMLastCompletelyVisibleItemPos", "(I)V", "mLastCompletelyVisibleItemPos", tl.h.F, "Lcom/tencent/mobileqq/vas/adv/recommendad/a$b;", "getMLastHolder", "()Lcom/tencent/mobileqq/vas/adv/recommendad/a$b;", "setMLastHolder", "(Lcom/tencent/mobileqq/vas/adv/recommendad/a$b;)V", "mLastHolder", "i", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$b;", "getMTouchInterceptListener", "()Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$b;", "setMTouchInterceptListener", "(Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$b;)V", "mTouchInterceptListener", "Ljava/lang/Runnable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "G", "()Ljava/lang/Runnable;", "mScrollEndRunnable", "Landroid/os/Handler;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Handler;", "E", "()Landroid/os/Handler;", "mHandler", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class RecommendAdRecyclerView extends RecyclerView {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Handler mHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mLastCompletelyVisibleItemPos;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a.b mLastHolder;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecommendAdView.b mTouchInterceptListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mScrollEndRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/adv/recommendad/RecommendAdRecyclerView$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            a.b D;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 1 && (D = RecommendAdRecyclerView.this.D()) != null) {
                RecommendAdRecyclerView recommendAdRecyclerView = RecommendAdRecyclerView.this;
                recommendAdRecyclerView.setMLastHolder(D);
                recommendAdRecyclerView.setMLastCompletelyVisibleItemPos(D.getPosition());
                D.onPause();
            }
            if (newState == 0) {
                RecommendAdRecyclerView.this.getMHandler().removeCallbacks(RecommendAdRecyclerView.this.getMScrollEndRunnable());
                RecommendAdRecyclerView.this.getMHandler().postDelayed(RecommendAdRecyclerView.this.getMScrollEndRunnable(), 200L);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0014\u0010\u000f\u001a\u00020\u000e2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdRecyclerView$c;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/OrientationHelper;", "c", "Landroid/view/View;", "targetView", "helper", "", "a", "b", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "attachToRecyclerView", "", "calculateDistanceToFinalSnap", "findSnapView", "Landroidx/recyclerview/widget/OrientationHelper;", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "", "Z", "mReverse", "<init>", "()V", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c extends LinearSnapHelper {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private OrientationHelper helper;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private RecyclerView mRecyclerView;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean mReverse;

        private final int a(View targetView, OrientationHelper helper) {
            return helper.getDecoratedStart(targetView) - helper.getStartAfterPadding();
        }

        private final View b(RecyclerView.LayoutManager layoutManager, OrientationHelper helper) {
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition == -1) {
                return null;
            }
            View findViewByPosition = layoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (helper.getDecoratedEnd(findViewByPosition) < Math.abs(helper.getDecoratedStart(layoutManager.findViewByPosition(findLastVisibleItemPosition)) - helper.getTotalSpace())) {
                return layoutManager.findViewByPosition(findFirstVisibleItemPosition + 1);
            }
            return findViewByPosition;
        }

        private final OrientationHelper c(RecyclerView.LayoutManager layoutManager) {
            OrientationHelper orientationHelper = this.helper;
            if (orientationHelper == null) {
                OrientationHelper createHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
                Intrinsics.checkNotNullExpressionValue(createHorizontalHelper, "createHorizontalHelper(layoutManager)");
                return createHorizontalHelper;
            }
            return orientationHelper;
        }

        @Override // androidx.recyclerview.widget.SnapHelper
        public void attachToRecyclerView(@androidx.annotation.Nullable @Nullable RecyclerView recyclerView) {
            RecyclerView.LayoutManager layoutManager;
            super.attachToRecyclerView(recyclerView);
            this.mRecyclerView = recyclerView;
            if (recyclerView != null) {
                layoutManager = recyclerView.getLayoutManager();
            } else {
                layoutManager = null;
            }
            if (layoutManager instanceof LinearLayoutManager) {
                this.mReverse = ((LinearLayoutManager) layoutManager).getReverseLayout();
            }
        }

        @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
        @NotNull
        public int[] calculateDistanceToFinalSnap(@NonNull @NotNull RecyclerView.LayoutManager layoutManager, @NonNull @NotNull View targetView) {
            Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            int[] iArr = new int[2];
            if (layoutManager.canScrollHorizontally()) {
                iArr[0] = a(targetView, c(layoutManager)) - ViewUtils.dpToPx(15.0f);
            } else {
                iArr[0] = 0;
            }
            return iArr;
        }

        @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public View findSnapView(@NotNull RecyclerView.LayoutManager layoutManager) {
            Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
            return b(layoutManager, c(layoutManager));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/vas/adv/recommendad/RecommendAdRecyclerView$d", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d extends RecyclerView.ItemDecoration {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            int i3;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager != null) {
                i3 = layoutManager.getItemCount();
            } else {
                i3 = 0;
            }
            outRect.left = ViewUtils.dpToPx(10.0f);
            if (parent.getChildAdapterPosition(view) == i3 - 1) {
                outRect.right = ViewUtils.dpToPx(10.0f);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/vas/adv/recommendad/RecommendAdRecyclerView$e", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            RecommendAdRecyclerView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            a.b D = RecommendAdRecyclerView.this.D();
            if (D != null) {
                D.onResume();
                return true;
            }
            return true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendAdRecyclerView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a.b D() {
        int i3;
        if (getLayoutManager() == null) {
            return null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
        if (linearLayoutManager != null) {
            i3 = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        } else {
            i3 = -1;
        }
        return (a.b) findViewHolderForPosition(i3);
    }

    @NotNull
    /* renamed from: E, reason: from getter */
    public final Handler getMHandler() {
        return this.mHandler;
    }

    /* renamed from: F, reason: from getter */
    public final int getMLastCompletelyVisibleItemPos() {
        return this.mLastCompletelyVisibleItemPos;
    }

    @NotNull
    /* renamed from: G, reason: from getter */
    public final Runnable getMScrollEndRunnable() {
        return this.mScrollEndRunnable;
    }

    public final void H(@NotNull LinearLayoutManager layoutManager, @NotNull com.tencent.mobileqq.vas.adv.recommendad.a adapter, @NotNull RecommendAdView.b touchInterceptor) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(touchInterceptor, "touchInterceptor");
        setLayoutManager(layoutManager);
        setAdapter(adapter);
        adapter.notifyDataSetChanged();
        this.mLastCompletelyVisibleItemPos = 0;
        this.mLastHolder = null;
        this.mTouchInterceptListener = touchInterceptor;
    }

    public final void I() {
        a.b D = D();
        if (D != null) {
            D.onPause();
        }
    }

    public final void K() {
        a.b D = D();
        if (D == null) {
            getViewTreeObserver().addOnPreDrawListener(new e());
        } else {
            D.onResume();
        }
    }

    public final void L() {
        a.b D = D();
        if (D != null) {
            D.onStop();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        RecommendAdView.b bVar;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (ev5.getAction() == 0) {
            RecommendAdView.b bVar2 = this.mTouchInterceptListener;
            if (bVar2 != null) {
                bVar2.a(false);
            }
        } else if ((ev5.getAction() == 3 || ev5.getAction() == 1) && (bVar = this.mTouchInterceptListener) != null) {
            bVar.a(true);
        }
        return super.dispatchTouchEvent(ev5);
    }

    public final void onDestroy() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            a.b bVar = (a.b) getChildViewHolder(getChildAt(i3));
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    public final void setMLastCompletelyVisibleItemPos(int i3) {
        this.mLastCompletelyVisibleItemPos = i3;
    }

    public final void setMLastHolder(@Nullable a.b bVar) {
        this.mLastHolder = bVar;
    }

    public final void setMTouchInterceptListener(@Nullable RecommendAdView.b bVar) {
        this.mTouchInterceptListener = bVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendAdRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendAdRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mScrollEndRunnable = new Runnable() { // from class: com.tencent.mobileqq.vas.adv.recommendad.RecommendAdRecyclerView$mScrollEndRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                int i16;
                if (RecommendAdRecyclerView.this.getLayoutManager() instanceof LinearLayoutManager) {
                    a.b D = RecommendAdRecyclerView.this.D();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("scroll mLasVisibleItemPos=");
                    sb5.append(RecommendAdRecyclerView.this.getMLastCompletelyVisibleItemPos());
                    sb5.append(",currentViewHolder:");
                    sb5.append(D);
                    sb5.append("\uff0ccurrentPos:");
                    if (D != null) {
                        i16 = D.getPosition();
                    } else {
                        i16 = -1;
                    }
                    sb5.append(i16);
                    QLog.d("RecommendAdRecyclerView", 2, sb5.toString());
                    if (D == null) {
                        return;
                    }
                    D.onResume();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper());
        new c().attachToRecyclerView(this);
        addOnScrollListener(new a());
        addItemDecoration(new d());
    }
}
