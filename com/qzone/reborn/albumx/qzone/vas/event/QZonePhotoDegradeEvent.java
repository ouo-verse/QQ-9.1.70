package com.qzone.reborn.albumx.qzone.vas.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/vas/event/QZonePhotoDegradeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "isForceClose", "", "()Z", "setForceClose", "(Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZonePhotoDegradeEvent extends SimpleBaseEvent {
    private boolean isForceClose;

    /* renamed from: isForceClose, reason: from getter */
    public final boolean getIsForceClose() {
        return this.isForceClose;
    }

    public final void setForceClose(boolean z16) {
        this.isForceClose = z16;
    }
}
