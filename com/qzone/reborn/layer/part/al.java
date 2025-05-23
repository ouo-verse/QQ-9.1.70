package com.qzone.reborn.layer.part;

import com.qzone.reborn.event.QZoneFeedxLayerPraiseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

/* compiled from: P */
/* loaded from: classes37.dex */
public class al extends ad {
    @Override // com.qzone.reborn.layer.part.ad
    protected void T9() {
        SimpleEventBus.getInstance().dispatchEvent(new QZoneFeedxLayerPraiseEvent(P9(), Q9(), this.f57984d.lloc), true);
    }
}
