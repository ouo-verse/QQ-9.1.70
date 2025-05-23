package com.tencent.sqshow.zootopia.recommend.main.dress.ui;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/ZplanDressDetailRefreshItemEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "id", "", "type", "", "(Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getType", "()I", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZplanDressDetailRefreshItemEvent extends SimpleBaseEvent {
    private final String id;
    private final int type;

    public ZplanDressDetailRefreshItemEvent(String id5, int i3) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
        this.type = i3;
    }

    public final String getId() {
        return this.id;
    }

    public final int getType() {
        return this.type;
    }

    public /* synthetic */ ZplanDressDetailRefreshItemEvent(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? 0 : i3);
    }
}
