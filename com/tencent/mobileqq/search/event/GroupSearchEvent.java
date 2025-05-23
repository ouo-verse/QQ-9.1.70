package com.tencent.mobileqq.search.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/search/event/GroupSearchEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "searchWord", "", "isSelectionEnd", "", "(Ljava/lang/String;Z)V", "()Z", "getSearchWord", "()Ljava/lang/String;", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class GroupSearchEvent extends SimpleBaseEvent {
    private final boolean isSelectionEnd;

    @NotNull
    private final String searchWord;

    public GroupSearchEvent(@NotNull String searchWord, boolean z16) {
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        this.searchWord = searchWord;
        this.isSelectionEnd = z16;
    }

    @NotNull
    public final String getSearchWord() {
        return this.searchWord;
    }

    /* renamed from: isSelectionEnd, reason: from getter */
    public final boolean getIsSelectionEnd() {
        return this.isSelectionEnd;
    }

    public /* synthetic */ GroupSearchEvent(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? true : z16);
    }
}
