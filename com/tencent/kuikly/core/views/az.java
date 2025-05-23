package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/kuikly/core/views/az;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/views/ba;", "Lcom/tencent/kuikly/core/base/event/Event;", tl.h.F, "createEvent", "", "viewName", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class az extends ViewContainer<ba, Event> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public Event createEvent() {
        return new Event();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public ba createAttr() {
        return new ba();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRMaskView";
    }
}
