package com.tencent.mobileqq.activity.aio.intimate.reborn.model;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/model/MutualMarkCardUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "changedCardIndex", "", "isWear", "", "(JZ)V", "getChangedCardIndex", "()J", "()Z", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class MutualMarkCardUpdateEvent extends SimpleBaseEvent {
    private final long changedCardIndex;
    private final boolean isWear;

    public MutualMarkCardUpdateEvent(long j3, boolean z16) {
        this.changedCardIndex = j3;
        this.isWear = z16;
    }

    public final long getChangedCardIndex() {
        return this.changedCardIndex;
    }

    /* renamed from: isWear, reason: from getter */
    public final boolean getIsWear() {
        return this.isWear;
    }
}
