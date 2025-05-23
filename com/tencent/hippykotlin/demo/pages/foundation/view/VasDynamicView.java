package com.tencent.hippykotlin.demo.pages.foundation.view;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.manager.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class VasDynamicView extends DeclarativeBaseView<DynamicAttr, DynamicEvent> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        DynamicAttr dynamicAttr = new DynamicAttr();
        dynamicAttr.with("sceneTag", c.f117352a.g().getPageName());
        return dynamicAttr;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new DynamicEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "VasDynamicView";
    }
}
