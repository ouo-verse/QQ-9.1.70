package com.tencent.mobileqq.search.searchdetail.eventbus;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u00d6\u0003J\t\u0010\u000b\u001a\u00020\fH\u00d6\u0001J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/eventbus/ThemeChangedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "isNightThem", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final /* data */ class ThemeChangedEvent extends SimpleBaseEvent {
    private final boolean isNightThem;

    public ThemeChangedEvent(boolean z16) {
        this.isNightThem = z16;
    }

    public static /* synthetic */ ThemeChangedEvent copy$default(ThemeChangedEvent themeChangedEvent, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = themeChangedEvent.isNightThem;
        }
        return themeChangedEvent.copy(z16);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsNightThem() {
        return this.isNightThem;
    }

    @NotNull
    public final ThemeChangedEvent copy(boolean isNightThem) {
        return new ThemeChangedEvent(isNightThem);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ThemeChangedEvent) && this.isNightThem == ((ThemeChangedEvent) other).isNightThem) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        boolean z16 = this.isNightThem;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    public final boolean isNightThem() {
        return this.isNightThem;
    }

    @NotNull
    public String toString() {
        return "ThemeChangedEvent(isNightThem=" + this.isNightThem + ")";
    }
}
