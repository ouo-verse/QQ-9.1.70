package com.tencent.mobileqq.search.searchdetail.eventbus;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u0006H\u0016R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/eventbus/ChangeTabEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "tabInfo", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "extensionMap", "", "", "(Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;Ljava/util/Map;)V", "getExtensionMap", "()Ljava/util/Map;", "getTabInfo", "()Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "toString", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class ChangeTabEvent extends SimpleBaseEvent {

    @Nullable
    private final Map<String, String> extensionMap;

    @NotNull
    private final SearchDetailTabListViewModel.TabInfo tabInfo;

    public ChangeTabEvent(@NotNull SearchDetailTabListViewModel.TabInfo tabInfo, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
        this.tabInfo = tabInfo;
        this.extensionMap = map;
    }

    @Nullable
    public final Map<String, String> getExtensionMap() {
        return this.extensionMap;
    }

    @NotNull
    public final SearchDetailTabListViewModel.TabInfo getTabInfo() {
        return this.tabInfo;
    }

    @NotNull
    public String toString() {
        return "ChangeTabEvent(tabInfo=" + this.tabInfo + " extensionMap=" + this.extensionMap + ")";
    }

    public /* synthetic */ ChangeTabEvent(SearchDetailTabListViewModel.TabInfo tabInfo, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(tabInfo, (i3 & 2) != 0 ? null : map);
    }
}
