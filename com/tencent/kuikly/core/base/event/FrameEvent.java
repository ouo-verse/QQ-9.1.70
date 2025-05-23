package com.tencent.kuikly.core.base.event;

import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001\u0016B\u0007\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016R0\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00148\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR0\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00148\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR0\u0010%\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00148\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bRG\u0010.\u001a'\u0012\u0015\u0012\u0013\u0018\u00010&\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014j\u0004\u0018\u0001`*8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0017\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bRG\u00102\u001a'\u0012\u0015\u0012\u0013\u0018\u00010&\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014j\u0004\u0018\u0001`*8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0017\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\"\u0010:\u001a\u0002038\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/kuikly/core/base/event/FrameEvent;", "Lcom/tencent/kuikly/core/base/event/b;", "Lcom/tencent/kuikly/core/pager/c;", "", "onRenderViewDidCreated", "onRenderViewDidRemoved", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "view", "onRelativeCoordinatesDidChanged", "onViewLayoutFrameDidChanged", "onViewDidRemove", "", "pagerEvent", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "eventData", "onPagerEvent", "", "width", "height", "onRootViewSizeChanged", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/layout/d;", "a", "Lkotlin/jvm/functions/Function1;", "i", "()Lkotlin/jvm/functions/Function1;", "l", "(Lkotlin/jvm/functions/Function1;)V", "layoutFrameChangedHandlerFn", "b", tl.h.F, "k", "globalLayoutFrameChangedHandlerFn", "Lcom/tencent/kuikly/core/base/w;", "c", "j", "o", "sizeChangedHandlerFn", "", "Lkotlin/ParameterName;", "name", "parma", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "d", "getRenderViewDidCreatedHandlerFn$core_release", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "renderViewDidCreatedHandlerFn", "e", "getRenderViewDidRemovedHandlerFn$core_release", DomainData.DOMAIN_NAME, "renderViewDidRemovedHandlerFn", "", "f", "Z", "getDidListenRootViewSizeChangedEvent$core_release", "()Z", "setDidListenRootViewSizeChangedEvent$core_release", "(Z)V", "didListenRootViewSizeChangedEvent", "<init>", "()V", "g", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class FrameEvent extends b implements com.tencent.kuikly.core.pager.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Function1<? super com.tencent.kuikly.core.layout.d, Unit> layoutFrameChangedHandlerFn;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super com.tencent.kuikly.core.layout.d, Unit> globalLayoutFrameChangedHandlerFn;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function1<? super w, Unit> sizeChangedHandlerFn;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> renderViewDidCreatedHandlerFn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> renderViewDidRemovedHandlerFn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean didListenRootViewSizeChangedEvent;

    public final Function1<com.tencent.kuikly.core.layout.d, Unit> h() {
        return this.globalLayoutFrameChangedHandlerFn;
    }

    public final Function1<com.tencent.kuikly.core.layout.d, Unit> i() {
        return this.layoutFrameChangedHandlerFn;
    }

    public final Function1<w, Unit> j() {
        return this.sizeChangedHandlerFn;
    }

    public final void k(Function1<? super com.tencent.kuikly.core.layout.d, Unit> function1) {
        this.globalLayoutFrameChangedHandlerFn = function1;
    }

    public final void l(Function1<? super com.tencent.kuikly.core.layout.d, Unit> function1) {
        this.layoutFrameChangedHandlerFn = function1;
    }

    public final void m(Function1<Object, Unit> function1) {
        this.renderViewDidCreatedHandlerFn = function1;
    }

    public final void n(Function1<Object, Unit> function1) {
        this.renderViewDidRemovedHandlerFn = function1;
    }

    public final void o(Function1<? super w, Unit> function1) {
        this.sizeChangedHandlerFn = function1;
    }

    @Override // com.tencent.kuikly.core.pager.c
    public void onPagerEvent(String pagerEvent, com.tencent.kuikly.core.nvi.serialization.json.e eventData) {
        Intrinsics.checkNotNullParameter(pagerEvent, "pagerEvent");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
    }

    @Override // com.tencent.kuikly.core.base.event.d
    public void onRelativeCoordinatesDidChanged(DeclarativeBaseView<?, ?> view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.tencent.kuikly.core.base.event.d
    public void onRenderViewDidCreated() {
        Function1<Object, Unit> function1 = this.renderViewDidCreatedHandlerFn;
        if (function1 != null) {
            function1.invoke(null);
        }
    }

    @Override // com.tencent.kuikly.core.base.event.d
    public void onRenderViewDidRemoved() {
        Function1<Object, Unit> function1 = this.renderViewDidRemovedHandlerFn;
        if (function1 != null) {
            function1.invoke(null);
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public void onRootViewSizeChanged(double width, double height) {
        if (this.globalLayoutFrameChangedHandlerFn != null) {
            getPager().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.kuikly.core.base.event.FrameEvent$onRootViewSizeChanged$1
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
                    com.tencent.kuikly.core.pager.b pager = FrameEvent.this.getPager();
                    final FrameEvent frameEvent = FrameEvent.this;
                    pager.addNextTickTask(new Function0<Unit>() { // from class: com.tencent.kuikly.core.base.event.FrameEvent$onRootViewSizeChanged$1.1
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
                            com.tencent.kuikly.core.layout.d a16;
                            FlexNode flexNode;
                            Function1<com.tencent.kuikly.core.layout.d, Unit> h16 = FrameEvent.this.h();
                            if (h16 != null) {
                                AbstractBaseView<?, ?> view = FrameEvent.this.getView();
                                if (view == null || (flexNode = view.getFlexNode()) == null || (a16 = flexNode.getLayoutFrame()) == null) {
                                    a16 = com.tencent.kuikly.core.layout.d.INSTANCE.a();
                                }
                                h16.invoke(a16);
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.tencent.kuikly.core.base.event.b, com.tencent.kuikly.core.base.event.d
    public void onViewDidRemove() {
        super.onViewDidRemove();
        this.layoutFrameChangedHandlerFn = null;
        this.renderViewDidCreatedHandlerFn = null;
        this.renderViewDidRemovedHandlerFn = null;
        this.globalLayoutFrameChangedHandlerFn = null;
        if (this.didListenRootViewSizeChangedEvent) {
            this.didListenRootViewSizeChangedEvent = false;
            getPager().removePagerEventObserver(this);
        }
    }

    @Override // com.tencent.kuikly.core.base.event.d
    public void onViewLayoutFrameDidChanged(final DeclarativeBaseView<?, ?> view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.layoutFrameChangedHandlerFn != null) {
            getPager().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.kuikly.core.base.event.FrameEvent$onViewLayoutFrameDidChanged$1
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
                    Function1<com.tencent.kuikly.core.layout.d, Unit> i3 = FrameEvent.this.i();
                    if (i3 != null) {
                        i3.invoke(view.getFlexNode().getLayoutFrame());
                    }
                }
            });
        }
        if (this.sizeChangedHandlerFn != null) {
            Object obj = getExtProps().get("lastViewSize");
            final w wVar = new w(view.getFlexNode().getLayoutFrame().getWidth(), view.getFlexNode().getLayoutFrame().getHeight());
            if (obj == null || !Intrinsics.areEqual((w) obj, wVar)) {
                getExtProps().put("lastViewSize", wVar);
                getPager().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.kuikly.core.base.event.FrameEvent$onViewLayoutFrameDidChanged$2
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
                        Function1<w, Unit> j3 = FrameEvent.this.j();
                        if (j3 != null) {
                            j3.invoke(wVar);
                        }
                    }
                });
            }
        }
        if (this.globalLayoutFrameChangedHandlerFn != null) {
            getPager().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.kuikly.core.base.event.FrameEvent$onViewLayoutFrameDidChanged$3
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
                    Function1<com.tencent.kuikly.core.layout.d, Unit> h16 = FrameEvent.this.h();
                    if (h16 != null) {
                        h16.invoke(view.getFlexNode().getLayoutFrame());
                    }
                }
            });
            if (this.didListenRootViewSizeChangedEvent) {
                return;
            }
            this.didListenRootViewSizeChangedEvent = true;
            getPager().addPagerEventObserver(this);
        }
    }
}
