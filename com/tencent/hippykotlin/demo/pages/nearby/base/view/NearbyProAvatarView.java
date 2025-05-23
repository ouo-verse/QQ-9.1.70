package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;

/* loaded from: classes31.dex */
public final class NearbyProAvatarView extends DeclarativeBaseView<NearbyProAvatarAttr, NearbyProAvatarEvent> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NearbyProAvatarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyProAvatarEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
    }

    public final void onPlay() {
        AbstractBaseView.callRenderViewMethod$default(this, "onPlay", null, null, 6, null);
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void removeRenderView() {
        AbstractBaseView.callRenderViewMethod$default(this, MosaicConstants$JsFunction.FUNC_ON_DESTROY, null, null, 6, null);
        super.removeRenderView();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "NearbyProAvatarView";
    }
}
