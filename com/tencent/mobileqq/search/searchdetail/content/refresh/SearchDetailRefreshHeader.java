package com.tencent.mobileqq.search.searchdetail.content.refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mp2.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001BB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b:\u0010;B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u00a2\u0006\u0004\b:\u0010>B#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\u0006\u0010?\u001a\u00020\u0015\u00a2\u0006\u0004\b:\u0010@J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0017J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0017J\u0014\u0010\u0019\u001a\u00020\u00052\n\u0010\u0018\u001a\u00020\u0017\"\u00020\u0015H\u0017J \u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0017J0\u0010#\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0017J \u0010$\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0017J \u0010%\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0017J \u0010)\u001a\u00020\u00052\u0006\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u0015H\u0017J\b\u0010*\u001a\u00020\u0013H\u0016J \u0010.\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\u0013H\u0016R\u0016\u00100\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010/R\u0016\u00102\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/refresh/SearchDetailRefreshHeader;", "Landroid/widget/FrameLayout;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshHeader;", "Landroid/content/Context;", "context", "", "d", "b", "c", "Landroid/view/View;", "getView", "Lcom/tencent/richframework/widget/refresh/layout/constant/SpinnerStyle;", "getSpinnerStyle", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshLayout;", "refreshLayout", "Lcom/tencent/richframework/widget/refresh/layout/constant/RefreshState;", "oldState", "newState", "onStateChanged", "", "success", "", "onFinish", "", NodeProps.COLORS, "setPrimaryColors", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshKernel;", "kernel", "height", "maxDragHeight", "onInitialized", "isDragging", "", "percent", "offset", "onMoving", "onReleased", "onStartAnimator", "percentX", "offsetX", "offsetMax", "onHorizontalDrag", "isSupportHorizontalDrag", "duration", "dragRate", "animationOnly", "autoOpen", "Lcom/tencent/richframework/widget/refresh/layout/constant/RefreshState;", "oldRefreshState", "e", "curRefreshState", "Lmp2/a;", "f", "Lmp2/a;", "loadingViewWrapper", h.F, "Z", "isFromAutoRefresh", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"RestrictedApi"})
/* loaded from: classes18.dex */
public final class SearchDetailRefreshHeader extends FrameLayout implements IRefreshHeader {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RefreshState oldRefreshState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RefreshState curRefreshState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private a loadingViewWrapper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isFromAutoRefresh;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f284025a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            try {
                iArr[RefreshState.RefreshReleased.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RefreshState.None.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f284025a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchDetailRefreshHeader(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b() {
        if (this.curRefreshState == RefreshState.None) {
            a aVar = this.loadingViewWrapper;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingViewWrapper");
                aVar = null;
            }
            aVar.b();
            this.isFromAutoRefresh = false;
        }
    }

    private final void c() {
        int i3 = b.f284025a[this.curRefreshState.ordinal()];
        a aVar = null;
        if (i3 != 1) {
            if (i3 == 2) {
                this.isFromAutoRefresh = false;
                a aVar2 = this.loadingViewWrapper;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingViewWrapper");
                } else {
                    aVar = aVar2;
                }
                aVar.b();
                return;
            }
            return;
        }
        a aVar3 = this.loadingViewWrapper;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingViewWrapper");
        } else {
            aVar = aVar3;
        }
        aVar.a();
    }

    private final void d(Context context) {
        RefreshLoadingView refreshLoadingView = new RefreshLoadingView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bi.b(20), bi.b(20));
        layoutParams.gravity = 17;
        refreshLoadingView.setLayoutParams(layoutParams);
        addView(refreshLoadingView);
        this.loadingViewWrapper = new c(refreshLoadingView);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean autoOpen(int duration, float dragRate, boolean animationOnly) {
        this.isFromAutoRefresh = true;
        a aVar = this.loadingViewWrapper;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingViewWrapper");
            aVar = null;
        }
        aVar.a();
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NotNull
    /* renamed from: getSpinnerStyle */
    public SpinnerStyle getFooterSpinnerStyle() {
        SpinnerStyle Translate = SpinnerStyle.Translate;
        Intrinsics.checkNotNullExpressionValue(Translate, "Translate");
        return Translate;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public int onFinish(@NotNull IRefreshLayout refreshLayout, boolean success) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QQSearch.NetDetail.SearchDetailRefreshHeader", "onFinish " + success);
            return 400;
        }
        return 400;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QQSearch.NetDetail.SearchDetailRefreshHeader", "onHorizontalDrag " + percentX + ", " + offsetX + ", " + offsetMax);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onInitialized(@NotNull IRefreshKernel kernel, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QQSearch.NetDetail.SearchDetailRefreshHeader", "onInitialized " + height + ", " + maxDragHeight);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {
        float coerceAtMost;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QQSearch.NetDetail.SearchDetailRefreshHeader", "onMoving " + isDragging + ", " + percent + ", " + offset + ", " + height + ", " + maxDragHeight);
        }
        if (!this.isFromAutoRefresh) {
            if (isDragging || this.curRefreshState == RefreshState.PullDownCanceled) {
                a aVar = this.loadingViewWrapper;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingViewWrapper");
                    aVar = null;
                }
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(percent, 1.0f);
                aVar.c(coerceAtMost);
            }
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onReleased(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QQSearch.NetDetail.SearchDetailRefreshHeader", "onReleased " + height + ", " + maxDragHeight);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void onStartAnimator(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QQSearch.NetDetail.SearchDetailRefreshHeader", "onStartAnimator " + height + ", " + maxDragHeight);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
    @SuppressLint({"RestrictedApi"})
    public void onStateChanged(@NotNull IRefreshLayout refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailRefreshHeader", 1, "onStateChanged " + oldState + ", " + newState + " " + this.isFromAutoRefresh);
        this.oldRefreshState = oldState;
        this.curRefreshState = newState;
        if (this.isFromAutoRefresh) {
            b();
        } else {
            c();
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @SuppressLint({"RestrictedApi"})
    public void setPrimaryColors(@NotNull int... colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QQSearch.NetDetail.SearchDetailRefreshHeader", "setPrimaryColors " + colors);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchDetailRefreshHeader(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchDetailRefreshHeader(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        RefreshState refreshState = RefreshState.None;
        this.oldRefreshState = refreshState;
        this.curRefreshState = refreshState;
        d(context);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NotNull
    public View getView() {
        return this;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/refresh/SearchDetailRefreshHeader$c", "Lmp2/a;", "", "a", "b", "", "progress", "c", "", "Z", "getRotating", "()Z", "setRotating", "(Z)V", "rotating", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean rotating;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RefreshLoadingView f284027b;

        c(RefreshLoadingView refreshLoadingView) {
            this.f284027b = refreshLoadingView;
        }

        @Override // mp2.a
        public void a() {
            if (this.rotating) {
                return;
            }
            this.rotating = true;
            this.f284027b.b();
        }

        @Override // mp2.a
        public void b() {
            this.rotating = false;
            this.f284027b.e();
        }

        @Override // mp2.a
        public void c(float progress) {
        }
    }
}
