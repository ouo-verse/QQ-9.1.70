package com.tencent.kuikly.core.base;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\t\u001a\u00020\b2\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016R\u001b\u0010\u000f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00058F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/base/ab;", "Lcom/tencent/kuikly/core/base/m;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/kuikly/core/base/event/Event;", "E", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "view", "", "i", "", "viewName", "isRenderView", tl.h.F, "()Lcom/tencent/kuikly/core/base/ViewContainer;", "realParent", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class ab<A extends m, E extends Event> extends ViewContainer<A, E> {
    public final ViewContainer<?, ?> h() {
        ViewContainer<?, ?> parent = getParent();
        while (i(parent)) {
            parent = parent != null ? parent.getParent() : null;
        }
        if (parent instanceof ViewContainer) {
            return parent;
        }
        return null;
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public boolean isRenderView() {
        return false;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRView";
    }

    private final boolean i(DeclarativeBaseView<?, ?> view) {
        return view != null && VirtualViewKt.b(view);
    }
}
