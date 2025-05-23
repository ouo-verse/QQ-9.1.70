package com.tencent.kuikly.core.base.event;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.ad;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tribe.async.log.SLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u00012B\u0007\u00a2\u0006\u0004\b;\u0010<J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u000e\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u000e\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0016J\"\u0010\u0016\u001a\u00020\b2\u0010\u0010\u0013\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J,\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0018H\u0002J,\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0018H\u0002J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0003H\u0002J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003H\u0002J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003H\u0002J \u0010&\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002J \u0010'\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002J\b\u0010(\u001a\u00020\bH\u0002J\b\u0010)\u001a\u00020\bH\u0002J\u0012\u0010*\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0002J\u001a\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0002J\u001e\u00100\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0.H\u0002R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/kuikly/core/base/event/VisibilityEvent;", "Lcom/tencent/kuikly/core/base/event/b;", "Lcom/tencent/kuikly/core/views/ad;", "", "contentOffsetX", "contentOffsetY", "Lcom/tencent/kuikly/core/views/bn;", "params", "", "onContentOffsetDidChanged", "onPagerParentScrollerDidScroll", "subViewsDidLayout", "onRenderViewDidRemoved", "onViewDidRemove", "onRenderViewDidCreated", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "view", "onRelativeCoordinatesDidChanged", "onViewLayoutFrameDidChanged", "targetVisibleWindow", "Lcom/tencent/kuikly/core/layout/h;", "frameInWindow", "i", "Lcom/tencent/kuikly/core/layout/d;", "Lcom/tencent/kuikly/core/views/ScrollerView;", "targetScrollerWindow", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "", SLog.LOG_TAG, "percentage", tl.h.F, "left", "right", "lessThanEqual", "moreThanEqual", "windowWidth", "windowHeight", "isContaining", DomainData.DOMAIN_NAME, "l", "k", "handleLeaving", "Lcom/tencent/kuikly/core/base/event/VisibilityState;", "newState", "o", "Lkotlin/Function0;", "task", "performTask", "", "a", "I", "listViewNativeRef", "b", "Lcom/tencent/kuikly/core/base/event/VisibilityState;", "visibilityState", "c", UserInfo.SEX_FEMALE, "appearPercentage", "<init>", "()V", "d", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class VisibilityEvent extends b implements ad {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int listViewNativeRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private VisibilityState visibilityState = VisibilityState.DID_DISAPPEAR;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float appearPercentage;

    private final void h(boolean async, final float percentage) {
        if (getEventMap().containsKey("appearPercentage")) {
            performTask(async, new Function0<Unit>() { // from class: com.tencent.kuikly.core.base.event.VisibilityEvent$dispatchAppearPercentageEvent$1
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
                    VisibilityEvent.this.onFireEvent("appearPercentage", Float.valueOf(percentage));
                }
            });
        }
    }

    private final void handleLeaving(boolean async) {
        VisibilityState visibilityState = this.visibilityState;
        if (visibilityState != VisibilityState.WILL_APPEAR && visibilityState != VisibilityState.DID_APPEAR) {
            o(VisibilityState.DID_DISAPPEAR, async);
        } else {
            o(VisibilityState.WILL_DISAPPEAR, async);
            o(VisibilityState.DID_DISAPPEAR, async);
        }
    }

    private final boolean isContaining(com.tencent.kuikly.core.layout.h frameInWindow, float windowWidth, float windowHeight) {
        return frameInWindow.getX() >= 0.0f && lessThanEqual(frameInWindow.getX() + frameInWindow.getWidth(), windowWidth) && frameInWindow.getY() >= 0.0f && lessThanEqual(frameInWindow.getY() + frameInWindow.getHeight(), windowHeight);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j(com.tencent.kuikly.core.layout.d targetVisibleWindow, com.tencent.kuikly.core.layout.h frameInWindow, ScrollerView<?, ?> targetScrollerWindow) {
        float f16;
        FlexNode flexNode;
        FlexNode flexNode2;
        float max;
        float width = targetVisibleWindow.getWidth();
        float height = targetVisibleWindow.getHeight();
        if (!n(frameInWindow, width, height)) {
            if (isContaining(frameInWindow, width, height)) {
                f16 = 1.0f;
            } else {
                float y16 = frameInWindow.getY();
                float y17 = frameInWindow.getY() + frameInWindow.getHeight();
                float height2 = frameInWindow.getHeight();
                FlexDirection flexDirection = null;
                if (((targetScrollerWindow == null || (flexNode2 = targetScrollerWindow.getFlexNode()) == null) ? null : flexNode2.j()) != FlexDirection.ROW) {
                    if (targetScrollerWindow != null && (flexNode = targetScrollerWindow.getFlexNode()) != null) {
                        flexDirection = flexNode.j();
                    }
                    if (flexDirection != FlexDirection.ROW_REVERSE) {
                        width = height;
                        if (y16 <= 0.0f || y17 < 0.0f) {
                            if (!(y16 > width && width <= y17)) {
                                f16 = ((width - Math.max(0.0f, y16)) / height2) * 1.0f;
                            } else if (y16 >= 0.0f && y17 <= width) {
                                f16 = ((y17 - y16) / height2) * 1.0f;
                            }
                        } else {
                            f16 = (Math.min(y17, width) * 1.0f) / height2;
                        }
                    }
                }
                y16 = frameInWindow.getX();
                y17 = frameInWindow.getX() + frameInWindow.getWidth();
                height2 = frameInWindow.getWidth();
                if (y16 <= 0.0f) {
                }
                if (!(y16 > width && width <= y17)) {
                }
            }
            max = Math.max(Math.min(f16, 1.0f), 0.0f);
            if (this.appearPercentage == max) {
                this.appearPercentage = max;
                h(true, max);
                return;
            }
            return;
        }
        f16 = 0.0f;
        max = Math.max(Math.min(f16, 1.0f), 0.0f);
        if (this.appearPercentage == max) {
        }
    }

    private final void k() {
        VisibilityState visibilityState = this.visibilityState;
        if (visibilityState != VisibilityState.WILL_DISAPPEAR && visibilityState != VisibilityState.DID_DISAPPEAR) {
            p(this, VisibilityState.DID_APPEAR, false, 2, null);
        } else {
            p(this, VisibilityState.WILL_APPEAR, false, 2, null);
            p(this, VisibilityState.DID_APPEAR, false, 2, null);
        }
    }

    private final void l() {
        VisibilityState visibilityState = this.visibilityState;
        if (visibilityState == VisibilityState.DID_DISAPPEAR) {
            p(this, VisibilityState.WILL_APPEAR, false, 2, null);
        } else if (visibilityState == VisibilityState.DID_APPEAR) {
            p(this, VisibilityState.WILL_DISAPPEAR, false, 2, null);
        }
    }

    private final void m(com.tencent.kuikly.core.layout.d targetVisibleWindow, com.tencent.kuikly.core.layout.h frameInWindow, ScrollerView<?, ?> targetScrollerWindow) {
        float width = targetVisibleWindow.getWidth();
        float height = targetVisibleWindow.getHeight();
        if (getEventMap().containsKey("appearPercentage")) {
            j(targetVisibleWindow, frameInWindow, targetScrollerWindow);
        }
        if (n(frameInWindow, width, height)) {
            handleLeaving(true);
        } else if (isContaining(frameInWindow, width, height)) {
            k();
        } else {
            l();
        }
    }

    private final boolean n(com.tencent.kuikly.core.layout.h frameInWindow, float windowWidth, float windowHeight) {
        return frameInWindow.getX() + frameInWindow.getWidth() <= 0.0f || moreThanEqual(frameInWindow.getX(), windowWidth) || frameInWindow.getY() + frameInWindow.getHeight() <= 0.0f || moreThanEqual(frameInWindow.getY(), windowHeight);
    }

    private final void o(final VisibilityState newState, boolean async) {
        if (this.visibilityState != newState) {
            this.visibilityState = newState;
            performTask(async, new Function0<Unit>() { // from class: com.tencent.kuikly.core.base.event.VisibilityEvent$updateViewVisibility$1
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
                    VisibilityEvent.this.onFireEvent(newState.getValue(), new com.tencent.kuikly.core.nvi.serialization.json.e());
                }
            });
        }
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void contentSizeDidChanged(float f16, float f17) {
        ad.a.a(this, f16, f17);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void contentViewDidSetFrameToRenderView() {
        ad.a.b(this);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void onContentOffsetDidChanged(float contentOffsetX, float contentOffsetY, ScrollParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        AbstractBaseView<?, ?> view = getView();
        if (view == null || !(view instanceof DeclarativeBaseView)) {
            return;
        }
        onRelativeCoordinatesDidChanged((DeclarativeBaseView) view);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void onPagerParentScrollerDidScroll() {
        ad.a.c(this);
        AbstractBaseView<?, ?> view = getView();
        if (view == null || !(view instanceof DeclarativeBaseView)) {
            return;
        }
        onRelativeCoordinatesDidChanged((DeclarativeBaseView) view);
    }

    @Override // com.tencent.kuikly.core.base.event.d
    public void onRelativeCoordinatesDidChanged(DeclarativeBaseView<?, ?> view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (isEmpty() || view.getNativeRef() != getViewId() || view.getParent() == null) {
            return;
        }
        ViewContainer<?, ?> parent = view.getParent();
        com.tencent.kuikly.core.layout.d layoutFrame = view.getFlexNode().getLayoutFrame();
        com.tencent.kuikly.core.layout.h hVar = new com.tencent.kuikly.core.layout.h(layoutFrame.getX(), layoutFrame.getY(), layoutFrame.getWidth(), layoutFrame.getHeight());
        while (parent != null && !(parent instanceof ScrollerView) && !(parent instanceof com.tencent.kuikly.core.pager.b)) {
            hVar.g(hVar.getX() + parent.getFlexNode().getLayoutFrame().getX());
            hVar.h(hVar.getY() + parent.getFlexNode().getLayoutFrame().getY());
            parent = parent.getParent();
        }
        if (com.tencent.kuikly.core.pager.h.b()) {
            if ((parent instanceof ScrollerView) && this.listViewNativeRef != parent.getNativeRef()) {
                this.listViewNativeRef = parent.getNativeRef();
                ((ScrollerView) parent).addScrollerViewEventObserver(this);
            }
            com.tencent.kuikly.core.layout.h k3 = view.convertFrame(layoutFrame, null).k();
            Pager a16 = com.tencent.kuikly.core.pager.h.a();
            i(a16 instanceof Pager ? a16 : null, k3);
            return;
        }
        i(parent, hVar);
    }

    @Override // com.tencent.kuikly.core.base.event.d
    public void onRenderViewDidRemoved() {
        if (this.listViewNativeRef > 0) {
            AbstractBaseView<?, ?> viewWithNativeRef = getPager().getViewWithNativeRef(this.listViewNativeRef);
            if (viewWithNativeRef != null && (viewWithNativeRef instanceof ScrollerView)) {
                ((ScrollerView) viewWithNativeRef).removeScrollerViewEventObserver(this);
            }
            this.listViewNativeRef = 0;
        }
    }

    @Override // com.tencent.kuikly.core.base.event.b, com.tencent.kuikly.core.base.event.d
    public void onViewDidRemove() {
        super.onViewDidRemove();
        if (isEmpty()) {
            return;
        }
        handleLeaving(!getPager().getWillDestroy());
        h(!getPager().getWillDestroy(), 0.0f);
    }

    @Override // com.tencent.kuikly.core.base.event.d
    public void onViewLayoutFrameDidChanged(DeclarativeBaseView<?, ?> view) {
        Intrinsics.checkNotNullParameter(view, "view");
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

    @Override // com.tencent.kuikly.core.views.ad
    public void subViewsDidLayout() {
        AbstractBaseView<?, ?> view = getView();
        if (view == null || !(view instanceof DeclarativeBaseView)) {
            return;
        }
        onRelativeCoordinatesDidChanged((DeclarativeBaseView) view);
    }

    private final void performTask(boolean async, Function0<Unit> task) {
        if (async) {
            getPager().addNextTickTask(task);
        } else {
            task.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void i(DeclarativeBaseView<?, ?> targetVisibleWindow, com.tencent.kuikly.core.layout.h frameInWindow) {
        if (targetVisibleWindow == null) {
            p(this, VisibilityState.DID_DISAPPEAR, false, 2, null);
            return;
        }
        com.tencent.kuikly.core.layout.d layoutFrame = targetVisibleWindow.getFlexNode().getLayoutFrame();
        boolean z16 = targetVisibleWindow instanceof ScrollerView;
        if (z16) {
            ScrollerView scrollerView = (ScrollerView) targetVisibleWindow;
            float visibleAreaIgnoreTopMargin = ((ScrollerAttr) scrollerView.getViewAttr()).getVisibleAreaIgnoreTopMargin();
            float visibleAreaIgnoreBottomMargin = ((ScrollerAttr) scrollerView.getViewAttr()).getVisibleAreaIgnoreBottomMargin();
            frameInWindow.g(frameInWindow.getX() - scrollerView.getContentViewOffsetX());
            frameInWindow.h(frameInWindow.getY() - (scrollerView.getContentViewOffsetY() + visibleAreaIgnoreTopMargin));
            if (this.listViewNativeRef != targetVisibleWindow.getNativeRef()) {
                this.listViewNativeRef = targetVisibleWindow.getNativeRef();
                scrollerView.addScrollerViewEventObserver(this);
            }
            if (visibleAreaIgnoreTopMargin > 0.0f || visibleAreaIgnoreBottomMargin > 0.0f) {
                com.tencent.kuikly.core.layout.h k3 = layoutFrame.k();
                k3.e(k3.getHeight() - (visibleAreaIgnoreTopMargin + visibleAreaIgnoreBottomMargin));
                layoutFrame = k3.i();
            }
        }
        m(layoutFrame, frameInWindow, z16 ? (ScrollerView) targetVisibleWindow : null);
    }

    private final boolean lessThanEqual(float left, float right) {
        return left <= right || ((double) Math.abs(left - right)) <= 0.001d;
    }

    private final boolean moreThanEqual(float left, float right) {
        return left >= right || ((double) Math.abs(left - right)) <= 0.001d;
    }

    static /* synthetic */ void p(VisibilityEvent visibilityEvent, VisibilityState visibilityState, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        visibilityEvent.o(visibilityState, z16);
    }

    @Override // com.tencent.kuikly.core.base.event.d
    public void onRenderViewDidCreated() {
    }
}
