package com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieScanningLightView extends DeclarativeBaseView<AdelieScanningLightViewAttr, AdelieScanningLightViewEvent> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new AdelieScanningLightViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new AdelieScanningLightViewEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "ScanningLightView";
    }
}
