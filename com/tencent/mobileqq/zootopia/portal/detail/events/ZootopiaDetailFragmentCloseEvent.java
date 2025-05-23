package com.tencent.mobileqq.zootopia.portal.detail.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/events/ZootopiaDetailFragmentCloseEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", IZootopiaShareArkService.ARK_MAP_ID, "", "source", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "fromBack", "", "(ILcom/tencent/mobileqq/zootopia/ZootopiaSource;Z)V", "getFromBack", "()Z", "getMapID", "()I", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZootopiaDetailFragmentCloseEvent extends SimpleBaseEvent {
    private final boolean fromBack;
    private final int mapID;
    private final ZootopiaSource source;

    public /* synthetic */ ZootopiaDetailFragmentCloseEvent(int i3, ZootopiaSource zootopiaSource, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, zootopiaSource, (i16 & 4) != 0 ? false : z16);
    }

    public final boolean getFromBack() {
        return this.fromBack;
    }

    public final int getMapID() {
        return this.mapID;
    }

    public final ZootopiaSource getSource() {
        return this.source;
    }

    public ZootopiaDetailFragmentCloseEvent(int i3, ZootopiaSource source, boolean z16) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.mapID = i3;
        this.source = source;
        this.fromBack = z16;
    }
}
