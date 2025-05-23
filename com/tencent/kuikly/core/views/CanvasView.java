package com.tencent.kuikly.core.views;

import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0006\u0010\u000f\u001a\u00020\u0004Ro\u0010\u001f\u001aO\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010j\u0004\u0018\u0001`\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/kuikly/core/views/CanvasView;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/kuikly/core/base/Attr;", "Lcom/tencent/kuikly/core/base/event/Event;", "", tl.h.F, "createAttr", "createEvent", "", "viewName", "createRenderView", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "setFrameToRenderView", "didRemoveFromParentView", "j", "Lkotlin/Function3;", "Lcom/tencent/kuikly/core/views/p;", "Lkotlin/ParameterName;", "name", "context", "", "width", "height", "Lcom/tencent/kuikly/core/views/CanvasDrawCallback;", "a", "Lkotlin/jvm/functions/Function3;", "i", "()Lkotlin/jvm/functions/Function3;", "k", "(Lkotlin/jvm/functions/Function3;)V", "drawCallback", "Lcom/tencent/kuikly/core/base/BaseObject;", "b", "Lcom/tencent/kuikly/core/base/BaseObject;", "reactiveObserverOwner", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class CanvasView extends DeclarativeBaseView<Attr, Event> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Function3<? super p, ? super Float, ? super Float, Unit> drawCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private BaseObject reactiveObserverOwner = new BaseObject();

    private final void h() {
        if (getRenderView() == null || getFlexNode().getLayoutFrame().f()) {
            return;
        }
        ReactiveObserver.Companion companion = ReactiveObserver.INSTANCE;
        companion.f(this.reactiveObserverOwner);
        companion.b(this.reactiveObserverOwner, new Function1<Boolean, Unit>() { // from class: com.tencent.kuikly.core.views.CanvasView$draw$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (CanvasView.this.getRenderView() == null || CanvasView.this.getFlexNode().getLayoutFrame().f() || CanvasView.this.i() == null) {
                    return;
                }
                RenderView renderView = CanvasView.this.getRenderView();
                Intrinsics.checkNotNull(renderView);
                p pVar = new p(renderView);
                pVar.l();
                Function3<p, Float, Float, Unit> i3 = CanvasView.this.i();
                Intrinsics.checkNotNull(i3);
                i3.invoke(pVar, Float.valueOf(CanvasView.this.getFlexNode().getLayoutFrame().getWidth()), Float.valueOf(CanvasView.this.getFlexNode().getLayoutFrame().getHeight()));
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public Attr createAttr() {
        return new Attr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public Event createEvent() {
        return new Event();
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void createRenderView() {
        boolean z16 = getRenderView() == null;
        super.createRenderView();
        if (z16) {
            h();
        }
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        ReactiveObserver.INSTANCE.f(this.reactiveObserverOwner);
    }

    public final Function3<p, Float, Float, Unit> i() {
        return this.drawCallback;
    }

    public final void j() {
        if (getRenderView() == null || getFlexNode().getLayoutFrame().f() || this.drawCallback == null) {
            return;
        }
        RenderView renderView = getRenderView();
        Intrinsics.checkNotNull(renderView);
        p pVar = new p(renderView);
        pVar.l();
        Function3<? super p, ? super Float, ? super Float, Unit> function3 = this.drawCallback;
        Intrinsics.checkNotNull(function3);
        function3.invoke(pVar, Float.valueOf(getFlexNode().getLayoutFrame().getWidth()), Float.valueOf(getFlexNode().getLayoutFrame().getHeight()));
    }

    public final void k(Function3<? super p, ? super Float, ? super Float, Unit> function3) {
        this.drawCallback = function3;
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void setFrameToRenderView(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        super.setFrameToRenderView(frame);
        h();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRCanvasView";
    }
}
