package com.tencent.timi.game.app.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AudienceActivityOnResultEvent extends SimpleBaseEvent {
    public int requestCode;
    public int resultCode;

    public AudienceActivityOnResultEvent(int i3, int i16) {
        this.requestCode = i3;
        this.resultCode = i16;
    }
}
