package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ad;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\bA\u0010BJ0\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\fJ\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J \u0010!\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\u0018\u0010%\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\fH\u0016R\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00102\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R*\u0010<\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000f8\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010@\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010=8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/kuikly/core/views/FooterRefreshView;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/views/x;", "Lcom/tencent/kuikly/core/views/y;", "Lcom/tencent/kuikly/core/views/ad;", "", "contentWidth", "contentHeight", "contentOffsetX", "contentOffsetY", "", "isDragging", "", "u", "y", "Lcom/tencent/kuikly/core/views/FooterRefreshState;", "newState", "oldState", HippyTKDListViewAdapter.X, "state", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/kuikly/core/views/FooterRefreshEndState;", "endState", "t", "p", "didMoveToParentView", "willRemoveFromParentView", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "", "viewName", "Lcom/tencent/kuikly/core/views/bn;", "params", "onContentOffsetDidChanged", "onPagerParentScrollerDidScroll", "width", "height", "contentSizeDidChanged", "subViewsDidLayout", "a", "Z", "didDragList", "", "b", "I", "nextTickSetRefreshStateTaskFlag", "c", "firstContentSizeChangedFlag", "d", UserInfo.SEX_FEMALE, "listContentWidth", "e", "listContentHeight", "value", "f", "Lcom/tencent/kuikly/core/views/FooterRefreshState;", "v", "()Lcom/tencent/kuikly/core/views/FooterRefreshState;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lcom/tencent/kuikly/core/views/FooterRefreshState;)V", "refreshState", "Lcom/tencent/kuikly/core/views/ScrollerView;", "w", "()Lcom/tencent/kuikly/core/views/ScrollerView;", "scrollerView", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class FooterRefreshView extends ViewContainer<x, y> implements ad {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean didDragList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int nextTickSetRefreshStateTaskFlag;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int firstContentSizeChangedFlag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float listContentWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float listContentHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FooterRefreshState refreshState = FooterRefreshState.IDLE;

    /* JADX WARN: Multi-variable type inference failed */
    private final void s(FooterRefreshState state) {
        Function1<FooterRefreshState, Unit> h16 = ((y) getEvent()).h();
        if (h16 != null) {
            h16.invoke(state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void u(float contentWidth, float contentHeight, float contentOffsetX, float contentOffsetY, boolean isDragging) {
        FooterRefreshState footerRefreshState;
        float height;
        float y16;
        float l3;
        FooterRefreshState footerRefreshState2 = this.refreshState;
        if (footerRefreshState2 == FooterRefreshState.NONE_MORE_DATA || footerRefreshState2 == (footerRefreshState = FooterRefreshState.REFRESHING) || w() == null) {
            return;
        }
        ScrollerView<?, ?> w3 = w();
        Intrinsics.checkNotNull(w3);
        if (!w3.getFlexNode().getLayoutFrame().f() && contentHeight > ((x) getAttr()).getMinContentSize().getHeight() && contentWidth > ((x) getAttr()).getMinContentSize().getWidth()) {
            if (isDragging) {
                this.didDragList = true;
            }
            if (this.didDragList) {
                if (y()) {
                    if (contentOffsetX < 0.0f) {
                        return;
                    }
                } else if (contentOffsetY < 0.0f) {
                    return;
                }
                if (y()) {
                    ScrollerView<?, ?> w16 = w();
                    Intrinsics.checkNotNull(w16);
                    height = (contentWidth - contentOffsetX) - w16.getFlexNode().getLayoutFrame().getWidth();
                } else {
                    ScrollerView<?, ?> w17 = w();
                    Intrinsics.checkNotNull(w17);
                    height = (contentHeight - contentOffsetY) - w17.getFlexNode().getLayoutFrame().getHeight();
                }
                if (com.tencent.kuikly.core.pager.h.b()) {
                    if (y()) {
                        y16 = convertFrame(getFlexNode().getLayoutFrame(), null).getX();
                        l3 = getPager().getPageData().m();
                    } else {
                        y16 = convertFrame(getFlexNode().getLayoutFrame(), null).getY();
                        l3 = getPager().getPageData().l();
                    }
                    height = y16 - l3;
                }
                if (height < ((x) getAttr()).getPreloadDistance()) {
                    z(footerRefreshState);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScrollerView<?, ?> w() {
        ViewContainer<?, ?> parent = getParent();
        ViewContainer<?, ?> parent2 = parent != null ? parent.getParent() : null;
        while (parent2 != null && !(parent2 instanceof ScrollerView)) {
            parent2 = parent2.getParent();
        }
        if (parent2 != null && !(parent2 instanceof ScrollerView)) {
            PagerNotFoundExceptionKt.a("FooterRefresh\u7ec4\u4ef6\u9700\u8981\u5e03\u5c40\u5728Scroller\u5bb9\u5668\u7ec4\u4ef6\u4e0b");
        }
        if (parent2 instanceof ScrollerView) {
            return (ScrollerView) parent2;
        }
        return null;
    }

    private final void x(FooterRefreshState newState, FooterRefreshState oldState) {
        s(newState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean y() {
        FlexNode flexNode;
        FlexNode flexNode2;
        ScrollerView<?, ?> w3 = w();
        FlexDirection flexDirection = null;
        if (((w3 == null || (flexNode2 = w3.getFlexNode()) == null) ? null : flexNode2.j()) != FlexDirection.ROW) {
            ScrollerView<?, ?> w16 = w();
            if (w16 != null && (flexNode = w16.getFlexNode()) != null) {
                flexDirection = flexNode.j();
            }
            if (flexDirection != FlexDirection.ROW_REVERSE) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(FooterRefreshState footerRefreshState) {
        this.nextTickSetRefreshStateTaskFlag++;
        FooterRefreshState footerRefreshState2 = this.refreshState;
        if (footerRefreshState != footerRefreshState2) {
            this.refreshState = footerRefreshState;
            x(footerRefreshState, footerRefreshState2);
        }
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void contentSizeDidChanged(float width, float height) {
        int i3;
        ad.a.a(this, width, height);
        this.listContentWidth = width;
        this.listContentHeight = height;
        if (width <= 1.0f || height <= 1.0f || (i3 = this.firstContentSizeChangedFlag) != 0) {
            return;
        }
        this.firstContentSizeChangedFlag = i3 + 1;
        final int nativeRef = getNativeRef();
        TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.FooterRefreshView$contentSizeDidChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ScrollerView w3;
                boolean y16;
                ScrollerView w16;
                float f16;
                com.tencent.kuikly.core.layout.d layoutFrame;
                com.tencent.kuikly.core.pager.g pageData;
                float f17;
                float f18;
                ScrollerView w17;
                ScrollerView w18;
                ScrollerView w19;
                float f19;
                com.tencent.kuikly.core.layout.d layoutFrame2;
                com.tencent.kuikly.core.pager.g pageData2;
                w3 = FooterRefreshView.this.w();
                if (w3 == null) {
                    return;
                }
                y16 = FooterRefreshView.this.y();
                float f26 = 0.0f;
                if (y16) {
                    if (com.tencent.kuikly.core.pager.h.b()) {
                        com.tencent.kuikly.core.pager.b h16 = com.tencent.kuikly.core.manager.c.f117352a.h();
                        if (h16 != null && (pageData2 = h16.getPageData()) != null) {
                            f26 = pageData2.m();
                        }
                    } else {
                        w19 = FooterRefreshView.this.w();
                        Intrinsics.checkNotNull(w19);
                        f26 = w19.getFlexNode().getLayoutFrame().getWidth();
                    }
                    f19 = FooterRefreshView.this.listContentWidth;
                    layoutFrame2 = FooterRefreshView.this.getLayoutFrame();
                    if (f19 - layoutFrame2.getWidth() > f26) {
                        return;
                    }
                } else {
                    if (com.tencent.kuikly.core.pager.h.b()) {
                        com.tencent.kuikly.core.pager.b h17 = com.tencent.kuikly.core.manager.c.f117352a.h();
                        if (h17 != null && (pageData = h17.getPageData()) != null) {
                            f26 = pageData.l();
                        }
                    } else {
                        w16 = FooterRefreshView.this.w();
                        Intrinsics.checkNotNull(w16);
                        f26 = w16.getFlexNode().getLayoutFrame().getHeight();
                    }
                    f16 = FooterRefreshView.this.listContentHeight;
                    layoutFrame = FooterRefreshView.this.getLayoutFrame();
                    if (f16 - layoutFrame.getHeight() > f26) {
                        return;
                    }
                }
                if (com.tencent.kuikly.core.manager.c.f117352a.g().getViewWithNativeRef(nativeRef) != null) {
                    FooterRefreshView footerRefreshView = FooterRefreshView.this;
                    f17 = footerRefreshView.listContentWidth;
                    f18 = footerRefreshView.listContentHeight;
                    w17 = footerRefreshView.w();
                    Intrinsics.checkNotNull(w17);
                    float contentViewOffsetX = w17.getContentViewOffsetX();
                    w18 = footerRefreshView.w();
                    Intrinsics.checkNotNull(w18);
                    footerRefreshView.u(f17, f18, contentViewOffsetX, w18.getContentViewOffsetY(), true);
                }
            }
        });
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void contentViewDidSetFrameToRenderView() {
        ad.a.b(this);
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didMoveToParentView() {
        super.didMoveToParentView();
        ScrollerView<?, ?> w3 = w();
        if (w3 != null) {
            w3.addScrollerViewEventObserver(this);
        }
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void onContentOffsetDidChanged(float contentOffsetX, float contentOffsetY, ScrollParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        u(params.getContentWidth(), params.getContentHeight(), contentOffsetX, contentOffsetY, params.getIsDragging());
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void onPagerParentScrollerDidScroll() {
        ad.a.c(this);
        float f16 = this.listContentWidth;
        float f17 = this.listContentHeight;
        ScrollerView<?, ?> w3 = w();
        Intrinsics.checkNotNull(w3);
        float contentViewOffsetX = w3.getContentViewOffsetX();
        ScrollerView<?, ?> w16 = w();
        Intrinsics.checkNotNull(w16);
        u(f16, f17, contentViewOffsetX, w16.getContentViewOffsetY(), true);
    }

    public final void p() {
        z(FooterRefreshState.REFRESHING);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public x createAttr() {
        return new x();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public y createEvent() {
        return new y();
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void scrollFrameDidChanged(com.tencent.kuikly.core.layout.d dVar) {
        ad.a.d(this, dVar);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void scrollerDragBegin(ScrollParams scrollParams) {
        ad.a.e(this, scrollParams);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void scrollerScrollDidEnd(ScrollParams scrollParams) {
        ad.a.f(this, scrollParams);
    }

    public final void t(final FooterRefreshEndState endState) {
        Intrinsics.checkNotNullParameter(endState, "endState");
        final int i3 = this.nextTickSetRefreshStateTaskFlag + 1;
        this.nextTickSetRefreshStateTaskFlag = i3;
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.FooterRefreshView$endRefresh$task$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.kuikly.core.pager.b pager = FooterRefreshView.this.getPager();
                final int i16 = i3;
                final FooterRefreshView footerRefreshView = FooterRefreshView.this;
                final FooterRefreshEndState footerRefreshEndState = endState;
                pager.addNextTickTask(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.FooterRefreshView$endRefresh$task$1.1

                    /* compiled from: P */
                    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                    /* renamed from: com.tencent.kuikly.core.views.FooterRefreshView$endRefresh$task$1$1$a */
                    /* loaded from: classes33.dex */
                    public /* synthetic */ class a {

                        /* renamed from: a, reason: collision with root package name */
                        public static final /* synthetic */ int[] f118293a;

                        static {
                            int[] iArr = new int[FooterRefreshEndState.values().length];
                            try {
                                iArr[FooterRefreshEndState.SUCCESS.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[FooterRefreshEndState.FAILURE.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                iArr[FooterRefreshEndState.NONE_MORE_DATA.ordinal()] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            f118293a = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        int i17;
                        int i18 = i16;
                        i17 = footerRefreshView.nextTickSetRefreshStateTaskFlag;
                        if (i18 == i17) {
                            int i19 = a.f118293a[footerRefreshEndState.ordinal()];
                            if (i19 == 1) {
                                footerRefreshView.z(FooterRefreshState.IDLE);
                            } else if (i19 == 2) {
                                footerRefreshView.z(FooterRefreshState.FAILURE);
                            } else {
                                if (i19 != 3) {
                                    return;
                                }
                                footerRefreshView.z(FooterRefreshState.NONE_MORE_DATA);
                            }
                        }
                    }
                });
            }
        };
        if (this.refreshState == FooterRefreshState.REFRESHING && endState != FooterRefreshEndState.NONE_MORE_DATA) {
            TimerKt.d(150, new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.FooterRefreshView$endRefresh$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    function0.invoke();
                }
            });
        } else {
            function0.invoke();
        }
    }

    /* renamed from: v, reason: from getter */
    public final FooterRefreshState getRefreshState() {
        return this.refreshState;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRView";
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void willRemoveFromParentView() {
        super.willRemoveFromParentView();
        ScrollerView<?, ?> w3 = w();
        if (w3 != null) {
            w3.removeScrollerViewEventObserver(this);
        }
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void subViewsDidLayout() {
    }
}
