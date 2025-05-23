package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieSuperResolutionImageView extends DeclarativeBaseView<AdelieSuperResolutionImageViewAttr, AdelieSuperResolutionImageViewEvent> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new AdelieSuperResolutionImageViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new AdelieSuperResolutionImageViewEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "SuperResolutionImageView";
    }
}
