package com.tencent.sqshow.zootopia.guide;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/guide/ZplanGuideVisibilityChangedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "groupId", "", "visibliity", "", "(IZ)V", "getGroupId", "()I", "getVisibliity", "()Z", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZplanGuideVisibilityChangedEvent extends SimpleBaseEvent {
    private final int groupId;
    private final boolean visibliity;

    public ZplanGuideVisibilityChangedEvent(int i3, boolean z16) {
        this.groupId = i3;
        this.visibliity = z16;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final boolean getVisibliity() {
        return this.visibliity;
    }
}
