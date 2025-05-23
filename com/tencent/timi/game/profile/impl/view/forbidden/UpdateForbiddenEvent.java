package com.tencent.timi.game.profile.impl.view.forbidden;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes26.dex */
public class UpdateForbiddenEvent extends SimpleBaseEvent {
    public int second;

    public UpdateForbiddenEvent(int i3) {
        this.second = i3;
    }
}
