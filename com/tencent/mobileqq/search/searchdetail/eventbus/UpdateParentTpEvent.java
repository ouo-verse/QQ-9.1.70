package com.tencent.mobileqq.search.searchdetail.eventbus;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/eventbus/OnTabChangedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "tabInfo", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "wxPreSearchId", "", "(Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;Ljava/lang/String;)V", "getTabInfo", "()Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "getWxPreSearchId", "()Ljava/lang/String;", "toString", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.tencent.mobileqq.search.searchdetail.eventbus.OnTabChangedEvent, reason: from toString */
/* loaded from: classes18.dex */
public final class UpdateParentTpEvent extends SimpleBaseEvent {

    @NotNull
    private final SearchDetailTabListViewModel.TabInfo tabInfo;

    @NotNull
    private final String wxPreSearchId;

    public UpdateParentTpEvent(@NotNull SearchDetailTabListViewModel.TabInfo tabInfo, @NotNull String wxPreSearchId) {
        Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
        Intrinsics.checkNotNullParameter(wxPreSearchId, "wxPreSearchId");
        this.tabInfo = tabInfo;
        this.wxPreSearchId = wxPreSearchId;
    }

    @NotNull
    public final SearchDetailTabListViewModel.TabInfo getTabInfo() {
        return this.tabInfo;
    }

    @NotNull
    public final String getWxPreSearchId() {
        return this.wxPreSearchId;
    }

    @NotNull
    public String toString() {
        return "UpdateParentTpEvent(tabInfo=" + this.tabInfo + " wxPreSearchId=" + this.wxPreSearchId + ")";
    }

    public /* synthetic */ UpdateParentTpEvent(SearchDetailTabListViewModel.TabInfo tabInfo, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(tabInfo, (i3 & 2) != 0 ? "" : str);
    }
}
