package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.pager.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J \u0010\u0016\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\u0012\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\u0006\u0010 \u001a\u00020\u001fR*\u0010\u0011\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00108\u0006@DX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R*\u0010\u0012\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00108\u0006@DX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\"\u00101\u001a\u00020\u001f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020\u001f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100\u00a8\u00068"}, d2 = {"Lcom/tencent/kuikly/core/views/ScrollerContentView;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/m;", "Lcom/tencent/kuikly/core/base/event/Event;", "Lcom/tencent/kuikly/core/pager/e;", "", "viewName", "j", "createEvent", "", "createFlexNode", "didMoveToParentView", "didRemoveFromParentView", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "layoutFrameDidChanged", "", "offsetX", "offsetY", "i", "Lcom/tencent/kuikly/core/views/bn;", "params", tl.h.F, "onPagerWillCalculateLayoutFinish", "onPagerCalculateLayoutFinish", "onPagerDidLayout", "", "scrollObject", "onPagerDidScroll", DomainData.DOMAIN_NAME, "didSetFrameToRenderView", "", "isRowFlexDirection", "<set-?>", "a", UserInfo.SEX_FEMALE, "l", "()F", "p", "(F)V", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "c", "Z", "k", "()Z", "o", "(Z)V", "needLayout", "d", "getWrapContentSize$core_release", "setWrapContentSize$core_release", "wrapContentSize", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class ScrollerContentView extends ViewContainer<com.tencent.kuikly.core.base.m, Event> implements com.tencent.kuikly.core.pager.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float offsetX;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float offsetY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean needLayout = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean wrapContentSize;

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public Event createEvent() {
        return new Event();
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.AbstractBaseView
    public void createFlexNode() {
        super.createFlexNode();
        getFlexNode().K0(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.ScrollerContentView$createFlexNode$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                ScrollerContentView.this.o(true);
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didMoveToParentView() {
        super.didMoveToParentView();
        getPager().addPagerLayoutEventObserver(this);
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        getPager().removePagerLayoutEventObserver(this);
        getFlexNode().K0(null);
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didSetFrameToRenderView() {
        super.didSetFrameToRenderView();
        ViewContainer<?, ?> parent = getParent();
        ScrollerView scrollerView = parent instanceof ScrollerView ? (ScrollerView) parent : null;
        if (scrollerView != null) {
            scrollerView.contentViewDidSetFrameToRenderView$core_release();
        }
    }

    public void h(float offsetX, float offsetY, ScrollParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public void i(float offsetX, float offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public final boolean isRowFlexDirection() {
        return getFlexNode().j() == FlexDirection.ROW || getFlexNode().j() == FlexDirection.ROW_REVERSE;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.tencent.kuikly.core.base.m createAttr() {
        return new com.tencent.kuikly.core.base.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k, reason: from getter */
    public final boolean getNeedLayout() {
        return this.needLayout;
    }

    /* renamed from: l, reason: from getter */
    public final float getOffsetX() {
        return this.offsetX;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.AbstractBaseView
    public void layoutFrameDidChanged(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        super.layoutFrameDidChanged(frame);
        ViewContainer<?, ?> parent = getParent();
        ScrollerView scrollerView = parent instanceof ScrollerView ? (ScrollerView) parent : null;
        if (scrollerView != null) {
            scrollerView.contentSizeDidChanged$core_release(frame.getWidth(), frame.getHeight());
            Function2<Float, Float, Unit> contentSizeChangedHandlerFn$core_release = ((ScrollerEvent) scrollerView.getViewEvent()).getContentSizeChangedHandlerFn$core_release();
            if (contentSizeChangedHandlerFn$core_release != null) {
                contentSizeChangedHandlerFn$core_release.invoke(Float.valueOf(frame.getWidth()), Float.valueOf(frame.getHeight()));
            }
        }
        if (this.wrapContentSize) {
            getPager().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.ScrollerContentView$layoutFrameDidChanged$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (ScrollerContentView.this.isRowFlexDirection()) {
                        ((com.tencent.kuikly.core.base.m) ScrollerContentView.this.getViewAttr()).mo153width(ScrollerContentView.this.getFlexNode().getLayoutFrame().getWidth());
                    } else {
                        ((com.tencent.kuikly.core.base.m) ScrollerContentView.this.getViewAttr()).mo141height(ScrollerContentView.this.getFlexNode().getLayoutFrame().getHeight());
                    }
                }
            });
        }
    }

    /* renamed from: m, reason: from getter */
    public final float getOffsetY() {
        return this.offsetY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o(boolean z16) {
        this.needLayout = z16;
    }

    public void onPagerDidLayout() {
        if (this.needLayout) {
            if (getParent() != null && (getParent() instanceof ScrollerView)) {
                ViewContainer<?, ?> parent = getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.tencent.kuikly.core.views.ScrollerView<*, *>");
                ((ScrollerView) parent).subViewsDidLayout$core_release();
            }
            this.needLayout = false;
        }
    }

    @Override // com.tencent.kuikly.core.pager.e
    public void onPagerDidScroll(Object scrollObject) {
        e.a.a(this, scrollObject);
        if (Intrinsics.areEqual(scrollObject, this) || scrollObject == null || Intrinsics.areEqual(scrollObject, getParent())) {
            return;
        }
        ViewContainer<?, ?> parent = getParent();
        com.tencent.kuikly.core.pager.b h16 = com.tencent.kuikly.core.manager.c.f117352a.h();
        while (parent != null && !Intrinsics.areEqual(parent, scrollObject) && !Intrinsics.areEqual(parent, h16)) {
            parent = parent.getParent();
        }
        if (Intrinsics.areEqual(parent, scrollObject)) {
            n();
            ViewContainer<?, ?> parent2 = getParent();
            ScrollerView scrollerView = parent2 instanceof ScrollerView ? (ScrollerView) parent2 : null;
            if (scrollerView != null) {
                scrollerView.firePagerParentScrollerDidScroll$core_release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p(float f16) {
        this.offsetX = f16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(float f16) {
        this.offsetY = f16;
    }

    public final void setWrapContentSize$core_release(boolean z16) {
        this.wrapContentSize = z16;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRScrollContentView";
    }

    public void n() {
    }

    public void onPagerCalculateLayoutFinish() {
    }

    public void onPagerWillCalculateLayoutFinish() {
    }
}
