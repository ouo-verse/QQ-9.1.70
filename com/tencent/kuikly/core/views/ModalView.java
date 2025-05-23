package com.tencent.kuikly.core.views;

import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001H\u0002J\u0012\u0010\u0006\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001H\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J!\u0010\u0016\u001a\u00020\r2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0013\u00a2\u0006\u0002\b\u0014H\u0016J!\u0010\u0017\u001a\u00020\r2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u0013\u00a2\u0006\u0002\b\u0014H\u0016JJ\u0010\u001c\u001a\u00020\r\"\u0010\b\u0000\u0010\u0018*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\u0006\u0010\u0019\u001a\u00028\u00002\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u0013\u00a2\u0006\u0002\b\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016R*\u0010)\u001a\u00020!2\u0006\u0010\"\u001a\u00020!8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010,\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/kuikly/core/views/ModalView;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/m;", "Lcom/tencent/kuikly/core/base/event/Event;", "i", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "k", tl.h.F, "createEvent", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "Lcom/tencent/kuikly/core/layout/h;", "frameInParentRenderComponentCoordinate", "", "willInit", "realContainerView", "didInit", "j", "getViewEvent", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "init", "attr", "event", "T", "child", "", "index", "addChild", "(Lcom/tencent/kuikly/core/base/DeclarativeBaseView;Lkotlin/jvm/functions/Function1;I)V", "didRemoveFromParentView", "", "viewName", "", "value", "a", "Z", "getInWindow", "()Z", "l", "(Z)V", "inWindow", "b", "Lcom/tencent/kuikly/core/base/ViewContainer;", "contentView", "<init>", "()V", "c", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ModalView extends ViewContainer<com.tencent.kuikly.core.base.m, Event> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean inWindow;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ViewContainer<?, ?> contentView;

    private final ViewContainer<?, ?> i() {
        DeclarativeBaseView<?, ?> k3 = k();
        if (k3 != null) {
            return (ViewContainer) k3;
        }
        Object pager = getPager();
        Intrinsics.checkNotNull(pager, "null cannot be cast to non-null type com.tencent.kuikly.core.base.ViewContainer<*, *>");
        return (ViewContainer) pager;
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer
    public <T extends DeclarativeBaseView<?, ?>> void addChild(T child, Function1<? super T, Unit> init, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(init, "init");
        if (this.inWindow) {
            super.addChild(child, init, index);
            return;
        }
        ViewContainer<?, ?> viewContainer = this.contentView;
        if (viewContainer != null) {
            viewContainer.addChild(child, init, index);
        }
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.q
    public void attr(Function1<? super com.tencent.kuikly.core.base.m, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        if (this.inWindow) {
            super.attr(init);
            return;
        }
        ViewContainer<?, ?> viewContainer = this.contentView;
        if (viewContainer != null) {
            viewContainer.attr(init);
        }
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public Event createEvent() {
        return new Event();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        ViewContainer<?, ?> viewContainer;
        super.didInit();
        if (this.inWindow || (viewContainer = this.contentView) == null) {
            return;
        }
        i().insertDomSubView(viewContainer, VirtualViewKt.a(i()).indexOf(viewContainer));
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didRemoveFromParentView() {
        ViewContainer<?, ?> viewContainer;
        super.didRemoveFromParentView();
        if (this.inWindow || getPager().getWillDestroy() || (viewContainer = this.contentView) == null) {
            return;
        }
        i().removeDomSubView(viewContainer);
        i().removeChild(viewContainer);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void event(Function1<? super Event, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        if (this.inWindow) {
            super.event(init);
            return;
        }
        ViewContainer<?, ?> viewContainer = this.contentView;
        if (viewContainer != null) {
            viewContainer.event(init);
        }
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public com.tencent.kuikly.core.layout.h frameInParentRenderComponentCoordinate(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        if (this.inWindow) {
            return frame.k();
        }
        return super.frameInParentRenderComponentCoordinate(frame);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.kuikly.core.base.event.Event] */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public Event getViewEvent() {
        ViewContainer<?, ?> viewContainer;
        if (!this.inWindow && (viewContainer = this.contentView) != null) {
            Intrinsics.checkNotNull(viewContainer);
            return viewContainer.getViewEvent();
        }
        return super.getViewEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public com.tencent.kuikly.core.base.m createAttr() {
        return new com.tencent.kuikly.core.base.m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.tencent.kuikly.core.base.m getViewAttr() {
        ViewContainer<?, ?> viewContainer;
        if (!this.inWindow && (viewContainer = this.contentView) != null) {
            Intrinsics.checkNotNull(viewContainer);
            return (com.tencent.kuikly.core.base.m) viewContainer.getViewAttr();
        }
        return (com.tencent.kuikly.core.base.m) super.getViewAttr();
    }

    public final void l(boolean z16) {
        if (com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().getNativeBuild() >= 2) {
            this.inWindow = z16;
        }
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer
    public ViewContainer<?, ?> realContainerView() {
        if (!this.inWindow) {
            ViewContainer<?, ?> viewContainer = this.contentView;
            return viewContainer == null ? super.realContainerView() : viewContainer;
        }
        return super.realContainerView();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        if (this.inWindow) {
            return "KRModalView";
        }
        return "KRView";
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void willInit() {
        super.willInit();
        if (this.inWindow) {
            attr(new Function1<com.tencent.kuikly.core.base.m, Unit>() { // from class: com.tencent.kuikly.core.views.ModalView$willInit$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.m mVar) {
                    invoke2(mVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.kuikly.core.base.m attr) {
                    Intrinsics.checkNotNullParameter(attr, "$this$attr");
                    Attr.absolutePosition$default(attr, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                    attr.mo153width(attr.getPagerData().c() > 0.0f ? attr.getPagerData().c() : attr.getPagerData().h());
                    attr.mo141height(attr.getPagerData().b() > 0.0f ? attr.getPagerData().b() : attr.getPagerData().g());
                }
            });
            event(new Function1<Event, Unit>() { // from class: com.tencent.kuikly.core.views.ModalView$willInit$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Event event) {
                    invoke2(event);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Event event) {
                    Intrinsics.checkNotNullParameter(event, "$this$event");
                    event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.kuikly.core.views.ModalView$willInit$2.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ClickParams it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                            invoke2(clickParams);
                            return Unit.INSTANCE;
                        }
                    });
                }
            });
        } else {
            v vVar = new v();
            this.contentView = vVar;
            i().addChild(vVar, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.ModalView$willInit$3$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    invoke2(viewContainer);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ViewContainer<?, ?> addChild) {
                    Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                    addChild.attr(new Function1<com.tencent.kuikly.core.base.m, Unit>() { // from class: com.tencent.kuikly.core.views.ModalView$willInit$3$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.m mVar) {
                            invoke2(mVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(com.tencent.kuikly.core.base.m attr) {
                            Intrinsics.checkNotNullParameter(attr, "$this$attr");
                            attr.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                        }
                    });
                }
            });
        }
    }

    private final DeclarativeBaseView<?, ?> k() {
        ViewContainer<?, ?> viewContainer = this;
        while (viewContainer != null && !viewContainer.isPager()) {
            viewContainer = viewContainer.getParent();
            boolean z16 = false;
            if (viewContainer != null && viewContainer.isPager()) {
                z16 = true;
            }
            if (z16) {
                break;
            }
        }
        return viewContainer;
    }
}
