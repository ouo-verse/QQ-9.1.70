package com.tencent.hippykotlin.demo.pages.vas_base.views;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class VasLottieView extends DeclarativeBaseView<LottieAttr, l> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new LottieAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "VasLottieView";
    }
}
