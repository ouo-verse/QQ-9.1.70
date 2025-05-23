package com.tencent.mobileqq.search.searchdetail.eventbus;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/eventbus/StartScrollingView;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "state", "", "(I)V", "getState", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final /* data */ class StartScrollingView extends SimpleBaseEvent {
    private final int state;

    public StartScrollingView(int i3) {
        this.state = i3;
    }

    public static /* synthetic */ StartScrollingView copy$default(StartScrollingView startScrollingView, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = startScrollingView.state;
        }
        return startScrollingView.copy(i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getState() {
        return this.state;
    }

    @NotNull
    public final StartScrollingView copy(int state) {
        return new StartScrollingView(state);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof StartScrollingView) && this.state == ((StartScrollingView) other).state) {
            return true;
        }
        return false;
    }

    public final int getState() {
        return this.state;
    }

    public int hashCode() {
        return this.state;
    }

    @NotNull
    public String toString() {
        return "StartScrollingView(state=" + this.state + ")";
    }
}
