package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.base.event.Event;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyMineAvatarView extends DeclarativeBaseView<NearbyMineAvatarAttr, NearbyMineAvatarEvent> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NearbyMineAvatarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyMineAvatarEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "NearbyMineAvatarView";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final void willInit() {
        super.willInit();
        NearbyMineAvatarAttr nearbyMineAvatarAttr = (NearbyMineAvatarAttr) getAttr();
        nearbyMineAvatarAttr.getClass();
        nearbyMineAvatarAttr.with("autoPlay", Integer.valueOf(d.b(true)));
    }
}
