package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/kuikly/core/views/n;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/kuikly/core/views/m;", "Lcom/tencent/kuikly/core/base/event/Event;", tl.h.F, "createEvent", "", "viewName", "", "willInit", "didInit", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class n extends DeclarativeBaseView<m, Event> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public Event createEvent() {
        return new Event();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public m createAttr() {
        return new m();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRBlurView";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void willInit() {
        super.willInit();
        if (getPager().getPageData().getIsIOS()) {
            ((m) getViewAttr()).mo113backgroundColor(new com.tencent.kuikly.core.base.h(0, 0, 0, 0.1f));
        } else {
            ((m) getViewAttr()).mo113backgroundColor(new com.tencent.kuikly.core.base.h(255, 255, 255, 0.1f));
        }
    }
}
