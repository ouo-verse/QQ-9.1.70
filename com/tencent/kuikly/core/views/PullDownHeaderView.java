package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ad;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b/\u00100J,\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J \u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016R\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\"R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010%R\u001e\u0010.\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010+8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/kuikly/core/views/PullDownHeaderView;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/views/bh;", "Lcom/tencent/kuikly/core/views/bi;", "Lcom/tencent/kuikly/core/views/ad;", "", "beforeOffset", "afterOffset", "", "animated", "velocityY", "", "o", "p", "k", "l", "didInit", "didMoveToParentView", "willRemoveFromParentView", "contentOffsetX", "contentOffsetY", "Lcom/tencent/kuikly/core/views/bn;", "params", "onContentOffsetDidChanged", "Lcom/tencent/kuikly/core/views/co;", "e", DomainData.DOMAIN_NAME, "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "layoutFrameDidChanged", "contentViewDidSetFrameToRenderView", "", "viewName", "a", UserInfo.SEX_FEMALE, "listViewContentInsetTop", "b", "Z", "contentViewDidSetFrame", "c", "syncOffsetToList", "d", "didAppear", "Lcom/tencent/kuikly/core/views/aq;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/kuikly/core/views/aq;", "listView", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PullDownHeaderView extends ViewContainer<bh, bi> implements ad {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float listViewContentInsetTop;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean contentViewDidSetFrame;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float syncOffsetToList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean didAppear;

    /* JADX INFO: Access modifiers changed from: private */
    public final aq<?, ?> m() {
        ViewContainer<?, ?> parent = getParent();
        ViewContainer<?, ?> parent2 = parent != null ? parent.getParent() : null;
        while (parent2 != null && !(parent2 instanceof aq)) {
            parent2 = parent2.getParent();
        }
        if (parent2 != null && !(parent2 instanceof aq)) {
            PagerNotFoundExceptionKt.a("PullDownView\u7ec4\u4ef6\u9700\u8981\u5e03\u5c40\u5728List\u5bb9\u5668\u7ec4\u4ef6\u4e0b");
        }
        if (parent2 instanceof aq) {
            return (aq) parent2;
        }
        return null;
    }

    private final void o(float beforeOffset, final float afterOffset, boolean animated, float velocityY) {
        if (getPager().getPageData().getIsIOS()) {
            aq<?, ?> m3 = m();
            if (m3 != null) {
                m3.setContentOffset(0.0f, afterOffset, true, new bs(400, 1.0f, velocityY));
                return;
            }
            return;
        }
        aq<?, ?> m16 = m();
        if (m16 != null) {
            ScrollerView.setContentOffset$default(m16, 0.0f, beforeOffset, animated, null, 8, null);
        }
        TimerKt.d(16, new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.PullDownHeaderView$setContentOffsetWhenEndDrag$1
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
                aq m17;
                m17 = PullDownHeaderView.this.m();
                if (m17 != null) {
                    ScrollerView.setContentOffset$default(m17, 0.0f, afterOffset, true, null, 8, null);
                }
            }
        });
    }

    private final void p() {
        if (getFlexNode().getLayoutFrame().f()) {
            return;
        }
        float height = getFlexNode().getLayoutFrame().getHeight() - this.syncOffsetToList;
        if (this.contentViewDidSetFrame) {
            if (height == 0.0f) {
                return;
            }
            aq<?, ?> m3 = m();
            if (m3 != null) {
                aq<?, ?> m16 = m();
                ScrollerView.setContentOffset$default(m3, 0.0f, (m16 != null ? m16.getContentViewOffsetY() : 0.0f) + height, false, null, 12, null);
            }
            this.syncOffsetToList = getFlexNode().getLayoutFrame().getHeight();
        }
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void contentSizeDidChanged(float f16, float f17) {
        ad.a.a(this, f16, f17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.jvm.functions.Function1] */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
        ((bh) getViewAttr()).keepAlive(true);
        getFlexNode().u0(new Function1<Boolean, Unit>() { // from class: com.tencent.kuikly.core.views.PullDownHeaderView$didInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(boolean z16) {
                aq m3;
                ao aoVar;
                m3 = PullDownHeaderView.this.m();
                if (m3 == null || (aoVar = (ao) m3.getViewAttr()) == null) {
                    return;
                }
                PullDownHeaderView pullDownHeaderView = PullDownHeaderView.this;
                aoVar.bouncesEnable(aoVar.getBouncesEnable(), true);
                aoVar.setContentInsetTop$core_release(pullDownHeaderView.getFlexNode().getLayoutFrame().getHeight());
            }
        });
        final bi biVar = (bi) getEvent();
        event(new Function1<bi, Unit>() { // from class: com.tencent.kuikly.core.views.PullDownHeaderView$didInit$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(bi biVar2) {
                invoke2(biVar2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(bi event) {
                Intrinsics.checkNotNullParameter(event, "$this$event");
                if (bi.this.i() == null && bi.this.j() == null) {
                    return;
                }
                final bi biVar2 = bi.this;
                final PullDownHeaderView pullDownHeaderView = this;
                VisibilityEventKt.a(event, new Function1<Float, Unit>() { // from class: com.tencent.kuikly.core.views.PullDownHeaderView$didInit$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                        invoke(f16.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f16) {
                        boolean z16;
                        Function1<Float, Unit> j3 = bi.this.j();
                        if (j3 != null) {
                            j3.invoke(Float.valueOf(f16));
                        }
                        if (f16 <= 0.95f) {
                            if (f16 < 0.05f) {
                                pullDownHeaderView.didAppear = false;
                                return;
                            }
                            return;
                        }
                        z16 = pullDownHeaderView.didAppear;
                        if (z16) {
                            return;
                        }
                        pullDownHeaderView.didAppear = true;
                        Function1<Object, Unit> i3 = bi.this.i();
                        if (i3 != null) {
                            i3.invoke(Float.valueOf(f16));
                        }
                    }
                });
            }
        });
        aq<?, ?> m3 = m();
        if (m3 != null) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = ((ap) m3.getViewEvent()).handlerWithEventName("willDragEnd");
            m3.event(new Function1<ap, Unit>() { // from class: com.tencent.kuikly.core.views.PullDownHeaderView$didInit$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ap apVar) {
                    invoke2(apVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ap event) {
                    Intrinsics.checkNotNullParameter(event, "$this$event");
                    final Ref.ObjectRef<Function1<Object, Unit>> objectRef2 = objectRef;
                    final PullDownHeaderView pullDownHeaderView = this;
                    event.willDragEndBySync(new Function1<co, Unit>() { // from class: com.tencent.kuikly.core.views.PullDownHeaderView$didInit$3$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(co coVar) {
                            invoke2(coVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(co it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            Function1<Object, Unit> function1 = objectRef2.element;
                            if (function1 != null) {
                                function1.invoke(it);
                            }
                            pullDownHeaderView.n(it);
                        }
                    });
                }
            });
        }
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didMoveToParentView() {
        super.didMoveToParentView();
        aq<?, ?> m3 = m();
        if (m3 != null) {
            m3.setShouldListenWillEndDrag$core_release(true);
            aq<?, ?> m16 = m();
            if (m16 != null) {
                m16.addScrollerViewEventObserver(this);
            }
        }
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public bh createAttr() {
        return new bh();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public bi createEvent() {
        return new bi();
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.AbstractBaseView
    public void layoutFrameDidChanged(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        super.layoutFrameDidChanged(frame);
        p();
    }

    public final void n(co e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        float height = getFlexNode().getLayoutFrame().getHeight();
        if (this.listViewContentInsetTop == 0.0f) {
            return;
        }
        if (e16.getOffsetY() >= height - 20.0f) {
            o(e16.getOffsetY(), height, false, e16.getVelocityY());
        } else if (e16.getVelocityY() >= -0.2d && (Math.abs(e16.getVelocityY()) >= 0.05d || e16.getOffsetY() >= height / 2)) {
            o(e16.getOffsetY(), height, false, e16.getVelocityY());
        } else {
            o(e16.getOffsetY(), 0.0f, true, e16.getVelocityY());
        }
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void onContentOffsetDidChanged(float contentOffsetX, float contentOffsetY, ScrollParams params) {
        aq<?, ?> m3;
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.getOffsetY() < 0.0f) {
            this.listViewContentInsetTop = 0.0f;
            aq<?, ?> m16 = m();
            if (m16 != null) {
                ScrollerView.setContentOffset$default(m16, 0.0f, 0.0f, false, null, 12, null);
                return;
            }
            return;
        }
        float height = getFlexNode().getLayoutFrame().getHeight();
        if (params.getIsDragging() && params.getOffsetY() < height - 0.01d) {
            this.listViewContentInsetTop = height;
        }
        if (!params.getIsDragging() && Math.abs(params.getOffsetY() - height) < 1.0f) {
            this.listViewContentInsetTop = 0.0f;
        }
        if (params.getIsDragging() || params.getOffsetY() >= height) {
            return;
        }
        if (!(this.listViewContentInsetTop == 0.0f) || (m3 = m()) == null) {
            return;
        }
        ScrollerView.setContentOffset$default(m3, 0.0f, height, getPager().getPageData().getIsAndroid(), null, 8, null);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void onPagerParentScrollerDidScroll() {
        ad.a.c(this);
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
        ad.a.g(this);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRView";
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void willRemoveFromParentView() {
        super.willRemoveFromParentView();
        aq<?, ?> m3 = m();
        if (m3 != null) {
            m3.removeScrollerViewEventObserver(this);
        }
        getFlexNode().u0(null);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public void contentViewDidSetFrameToRenderView() {
        this.contentViewDidSetFrame = true;
        p();
    }
}
