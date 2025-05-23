package com.tencent.sqshow.zootopia.recommend.main.dress.ui;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/ZplanDressDetailSettingsEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZplanDressDetailSettingsEvent extends SimpleBaseEvent {
    private final String id;

    public ZplanDressDetailSettingsEvent(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
    }

    public final String getId() {
        return this.id;
    }
}
