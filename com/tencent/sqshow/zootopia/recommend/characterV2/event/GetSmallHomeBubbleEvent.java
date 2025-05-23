package com.tencent.sqshow.zootopia.recommend.characterV2.event;

import android.graphics.Rect;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/event/GetSmallHomeBubbleEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "viewPos", "Landroid/graphics/Rect;", "bubbleIndex", "", "(Landroid/graphics/Rect;I)V", "getBubbleIndex", "()I", "getViewPos", "()Landroid/graphics/Rect;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final /* data */ class GetSmallHomeBubbleEvent extends SimpleBaseEvent {
    private final int bubbleIndex;
    private final Rect viewPos;

    public GetSmallHomeBubbleEvent(Rect viewPos, int i3) {
        Intrinsics.checkNotNullParameter(viewPos, "viewPos");
        this.viewPos = viewPos;
        this.bubbleIndex = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final Rect getViewPos() {
        return this.viewPos;
    }

    /* renamed from: component2, reason: from getter */
    public final int getBubbleIndex() {
        return this.bubbleIndex;
    }

    public final GetSmallHomeBubbleEvent copy(Rect viewPos, int bubbleIndex) {
        Intrinsics.checkNotNullParameter(viewPos, "viewPos");
        return new GetSmallHomeBubbleEvent(viewPos, bubbleIndex);
    }

    public final int getBubbleIndex() {
        return this.bubbleIndex;
    }

    public final Rect getViewPos() {
        return this.viewPos;
    }

    public int hashCode() {
        return (this.viewPos.hashCode() * 31) + this.bubbleIndex;
    }

    public String toString() {
        return "GetSmallHomeBubbleEvent(viewPos=" + this.viewPos + ", bubbleIndex=" + this.bubbleIndex + ")";
    }

    public static /* synthetic */ GetSmallHomeBubbleEvent copy$default(GetSmallHomeBubbleEvent getSmallHomeBubbleEvent, Rect rect, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            rect = getSmallHomeBubbleEvent.viewPos;
        }
        if ((i16 & 2) != 0) {
            i3 = getSmallHomeBubbleEvent.bubbleIndex;
        }
        return getSmallHomeBubbleEvent.copy(rect, i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetSmallHomeBubbleEvent)) {
            return false;
        }
        GetSmallHomeBubbleEvent getSmallHomeBubbleEvent = (GetSmallHomeBubbleEvent) other;
        return Intrinsics.areEqual(this.viewPos, getSmallHomeBubbleEvent.viewPos) && this.bubbleIndex == getSmallHomeBubbleEvent.bubbleIndex;
    }
}
