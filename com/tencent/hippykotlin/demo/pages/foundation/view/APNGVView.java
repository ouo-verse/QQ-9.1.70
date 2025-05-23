package com.tencent.hippykotlin.demo.pages.foundation.view;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;

/* loaded from: classes31.dex */
public final class APNGVView extends DeclarativeBaseView<APNGAttr, APNGEvent> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new APNGAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new APNGEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "HRAPNGView";
    }
}
