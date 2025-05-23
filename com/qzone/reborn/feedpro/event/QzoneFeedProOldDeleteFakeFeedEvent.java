package com.qzone.reborn.feedpro.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/qzone/reborn/feedpro/event/QzoneFeedProOldDeleteFakeFeedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "clientKey", "", "(Ljava/lang/String;)V", "getClientKey", "()Ljava/lang/String;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedProOldDeleteFakeFeedEvent extends SimpleBaseEvent {
    private final String clientKey;

    public QzoneFeedProOldDeleteFakeFeedEvent(String str) {
        this.clientKey = str;
    }

    public final String getClientKey() {
        return this.clientKey;
    }
}
