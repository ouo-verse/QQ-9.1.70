package com.tencent.mobileqq.search.searchdetail.eventbus;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/eventbus/ContentScrollStateChangeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "state", "", "tab", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "(ILcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;)V", "getState", "()I", "getTab", "()Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final /* data */ class ContentScrollStateChangeEvent extends SimpleBaseEvent {
    private final int state;

    @Nullable
    private final SearchDetailTabListViewModel.TabInfo tab;

    public ContentScrollStateChangeEvent(int i3, @Nullable SearchDetailTabListViewModel.TabInfo tabInfo) {
        this.state = i3;
        this.tab = tabInfo;
    }

    public static /* synthetic */ ContentScrollStateChangeEvent copy$default(ContentScrollStateChangeEvent contentScrollStateChangeEvent, int i3, SearchDetailTabListViewModel.TabInfo tabInfo, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = contentScrollStateChangeEvent.state;
        }
        if ((i16 & 2) != 0) {
            tabInfo = contentScrollStateChangeEvent.tab;
        }
        return contentScrollStateChangeEvent.copy(i3, tabInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final int getState() {
        return this.state;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final SearchDetailTabListViewModel.TabInfo getTab() {
        return this.tab;
    }

    @NotNull
    public final ContentScrollStateChangeEvent copy(int state, @Nullable SearchDetailTabListViewModel.TabInfo tab) {
        return new ContentScrollStateChangeEvent(state, tab);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentScrollStateChangeEvent)) {
            return false;
        }
        ContentScrollStateChangeEvent contentScrollStateChangeEvent = (ContentScrollStateChangeEvent) other;
        if (this.state == contentScrollStateChangeEvent.state && Intrinsics.areEqual(this.tab, contentScrollStateChangeEvent.tab)) {
            return true;
        }
        return false;
    }

    public final int getState() {
        return this.state;
    }

    @Nullable
    public final SearchDetailTabListViewModel.TabInfo getTab() {
        return this.tab;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.state * 31;
        SearchDetailTabListViewModel.TabInfo tabInfo = this.tab;
        if (tabInfo == null) {
            hashCode = 0;
        } else {
            hashCode = tabInfo.hashCode();
        }
        return i3 + hashCode;
    }

    @NotNull
    public String toString() {
        return "ContentScrollStateChangeEvent(state=" + this.state + ", tab=" + this.tab + ")";
    }
}
