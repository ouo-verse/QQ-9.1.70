package com.tencent.mobileqq.guild.feed.squarehead.ownertask.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/squarehead/ownertask/event/OnOwnerTaskCardShowEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "contextHashCode", "", ViewStickEventHelper.IS_SHOW, "", "(IZ)V", "getContextHashCode", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class OnOwnerTaskCardShowEvent extends SimpleBaseEvent {
    private final int contextHashCode;
    private final boolean isShow;

    public OnOwnerTaskCardShowEvent(int i3, boolean z16) {
        this.contextHashCode = i3;
        this.isShow = z16;
    }

    public static /* synthetic */ OnOwnerTaskCardShowEvent copy$default(OnOwnerTaskCardShowEvent onOwnerTaskCardShowEvent, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = onOwnerTaskCardShowEvent.contextHashCode;
        }
        if ((i16 & 2) != 0) {
            z16 = onOwnerTaskCardShowEvent.isShow;
        }
        return onOwnerTaskCardShowEvent.copy(i3, z16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getContextHashCode() {
        return this.contextHashCode;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    @NotNull
    public final OnOwnerTaskCardShowEvent copy(int contextHashCode, boolean isShow) {
        return new OnOwnerTaskCardShowEvent(contextHashCode, isShow);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnOwnerTaskCardShowEvent)) {
            return false;
        }
        OnOwnerTaskCardShowEvent onOwnerTaskCardShowEvent = (OnOwnerTaskCardShowEvent) other;
        if (this.contextHashCode == onOwnerTaskCardShowEvent.contextHashCode && this.isShow == onOwnerTaskCardShowEvent.isShow) {
            return true;
        }
        return false;
    }

    public final int getContextHashCode() {
        return this.contextHashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.contextHashCode * 31;
        boolean z16 = this.isShow;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    @NotNull
    public String toString() {
        return "OnOwnerTaskCardShowEvent(contextHashCode=" + this.contextHashCode + ", isShow=" + this.isShow + ")";
    }
}
