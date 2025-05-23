package com.tencent.mobileqq.zplan.smallhome.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/event/ZPlanUEScaleEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "mapId", "", ZPlanPublishSource.FROM_SCHEME, "", "nativeId", "type", "source", "(ILjava/lang/String;Ljava/lang/String;II)V", "getMapId", "()I", "getNativeId", "()Ljava/lang/String;", "getScheme", "getSource", "getType", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanUEScaleEvent extends SimpleBaseEvent {
    private final int mapId;
    private final String nativeId;
    private final String scheme;
    private final int source;
    private final int type;

    public /* synthetic */ ZPlanUEScaleEvent(int i3, String str, String str2, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i18 & 2) != 0 ? "" : str, (i18 & 4) != 0 ? "" : str2, (i18 & 8) != 0 ? 0 : i16, (i18 & 16) != 0 ? -1 : i17);
    }

    public final int getMapId() {
        return this.mapId;
    }

    public final String getNativeId() {
        return this.nativeId;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final int getSource() {
        return this.source;
    }

    public final int getType() {
        return this.type;
    }

    public ZPlanUEScaleEvent(int i3, String str, String str2, int i16, int i17) {
        this.mapId = i3;
        this.scheme = str;
        this.nativeId = str2;
        this.type = i16;
        this.source = i17;
    }
}
