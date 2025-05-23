package com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;

/* loaded from: classes31.dex */
public final class AdeliePolarLightView extends DeclarativeBaseView<AdeliePolarLightViewAttr, AdeliePolarLightViewEvent> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new AdeliePolarLightViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new AdeliePolarLightViewEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "AdeliePolarLightView";
    }
}
