package com.qzone.preview.event;

import com.qzone.preview.photodanmaku.entity.PhotoDanmakuModel;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneFeedxLayerAddDanmakuEvent extends SimpleBaseEvent {
    private final PhotoDanmakuModel mAddDamaku;

    public QZoneFeedxLayerAddDanmakuEvent(PhotoDanmakuModel photoDanmakuModel) {
        this.mAddDamaku = photoDanmakuModel;
    }

    public PhotoDanmakuModel getDamakuModel() {
        return this.mAddDamaku;
    }
}
