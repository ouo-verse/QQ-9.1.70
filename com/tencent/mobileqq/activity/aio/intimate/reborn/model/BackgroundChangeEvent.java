package com.tencent.mobileqq.activity.aio.intimate.reborn.model;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/model/BackgroundChangeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "type", "", "level", "(II)V", "getLevel", "()I", "getType", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class BackgroundChangeEvent extends SimpleBaseEvent {
    private final int level;
    private final int type;

    public BackgroundChangeEvent(int i3, int i16) {
        this.type = i3;
        this.level = i16;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getType() {
        return this.type;
    }
}
