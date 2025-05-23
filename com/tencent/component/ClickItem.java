package com.tencent.component;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/component/ClickItem;", "", "lastClickTime", "", "(J)V", "canClick", "", "getCanClick", "()Z", "setCanClick", "(Z)V", "getLastClickTime", "()J", "setLastClickTime", "qq-live-od-adapter-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
final class ClickItem {
    private boolean canClick;
    private long lastClickTime;

    public ClickItem() {
        this(0L, 1, null);
    }

    public final boolean getCanClick() {
        return this.canClick;
    }

    public final long getLastClickTime() {
        return this.lastClickTime;
    }

    public final void setCanClick(boolean z16) {
        this.canClick = z16;
    }

    public final void setLastClickTime(long j3) {
        this.lastClickTime = j3;
    }

    public ClickItem(long j3) {
        this.lastClickTime = j3;
        this.canClick = true;
    }

    public /* synthetic */ ClickItem(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? System.currentTimeMillis() : j3);
    }
}
