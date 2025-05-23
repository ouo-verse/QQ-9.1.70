package com.tencent.kuikly.core.views;

import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.base.event.Event;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u000f\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/views/ab;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/views/aa;", "Lcom/tencent/kuikly/core/base/event/Event;", "Lcom/tencent/kuikly/core/layout/d;", "i", "", "didInit", "didMoveToParentView", tl.h.F, "createEvent", "", "viewName", "getFrame", "()Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ab extends ViewContainer<aa, Event> {
    /* JADX WARN: Multi-variable type inference failed */
    private final com.tencent.kuikly.core.layout.d i() {
        ViewContainer<?, ?> domParent = getDomParent();
        ScrollerContentView scrollerContentView = domParent instanceof ScrollerContentView ? (ScrollerContentView) domParent : null;
        if (Intrinsics.areEqual(scrollerContentView != null ? Boolean.valueOf(scrollerContentView.isRowFlexDirection()) : null, Boolean.TRUE)) {
            float offsetX = scrollerContentView.getOffsetX();
            com.tencent.kuikly.core.layout.h k3 = getFlexNode().getLayoutFrame().k();
            float hoverMarginTop = ((aa) getViewAttr()).getHoverMarginTop();
            if (offsetX > k3.getX() - hoverMarginTop) {
                k3.g(k3.getX() + (offsetX - (k3.getX() - hoverMarginTop)));
            }
            return k3.i();
        }
        float offsetY = scrollerContentView != null ? scrollerContentView.getOffsetY() : 0.0f;
        com.tencent.kuikly.core.layout.h k16 = getFlexNode().getLayoutFrame().k();
        float hoverMarginTop2 = ((aa) getViewAttr()).getHoverMarginTop();
        if (offsetY > k16.getY() - hoverMarginTop2) {
            k16.h(k16.getY() + (offsetY - (k16.getY() - hoverMarginTop2)));
        }
        return k16.i();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public Event createEvent() {
        return new Event();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
        ((aa) getAttr()).setKeepAlive(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didMoveToParentView() {
        List<DeclarativeBaseView<?, ?>> a16;
        super.didMoveToParentView();
        aa aaVar = (aa) getAttr();
        ViewContainer<?, ?> parent = getParent();
        aaVar.h((parent == null || (a16 = VirtualViewKt.a(parent)) == null) ? 0 : a16.indexOf(this));
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public com.tencent.kuikly.core.layout.d getFrame() {
        return i();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public aa createAttr() {
        return new aa();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRHoverView";
    }
}
