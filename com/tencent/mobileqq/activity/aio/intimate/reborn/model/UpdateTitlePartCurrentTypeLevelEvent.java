package com.tencent.mobileqq.activity.aio.intimate.reborn.model;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/model/UpdateTitlePartCurrentTypeLevelEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "type", "", "level", "flag", "", "(IIJ)V", "getFlag", "()J", "getLevel", "()I", "getType", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class UpdateTitlePartCurrentTypeLevelEvent extends SimpleBaseEvent {
    private final long flag;
    private final int level;
    private final int type;

    public UpdateTitlePartCurrentTypeLevelEvent(int i3, int i16, long j3) {
        this.type = i3;
        this.level = i16;
        this.flag = j3;
    }

    public final long getFlag() {
        return this.flag;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getType() {
        return this.type;
    }
}
