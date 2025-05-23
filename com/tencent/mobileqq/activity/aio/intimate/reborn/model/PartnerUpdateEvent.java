package com.tencent.mobileqq.activity.aio.intimate.reborn.model;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/model/PartnerUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "isPartner", "", "(Z)V", "()Z", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class PartnerUpdateEvent extends SimpleBaseEvent {
    private final boolean isPartner;

    public PartnerUpdateEvent(boolean z16) {
        this.isPartner = z16;
    }

    /* renamed from: isPartner, reason: from getter */
    public final boolean getIsPartner() {
        return this.isPartner;
    }
}
