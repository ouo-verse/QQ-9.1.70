package com.tencent.now.linkpkanchorplay.event;

import com.tencent.now.linkpkanchorplay.mainpage.model.LinkPKTabData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/event/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData$TabId;", "a", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData$TabId;", "getSelectTabID", "()Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData$TabId;", "selectTabID", "<init>", "(Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData$TabId;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.now.linkpkanchorplay.event.e, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class MainPageTabChangeEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final LinkPKTabData.TabId selectTabID;

    public MainPageTabChangeEvent(@NotNull LinkPKTabData.TabId selectTabID) {
        Intrinsics.checkNotNullParameter(selectTabID, "selectTabID");
        this.selectTabID = selectTabID;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof MainPageTabChangeEvent) && this.selectTabID == ((MainPageTabChangeEvent) other).selectTabID) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.selectTabID.hashCode();
    }

    @NotNull
    public String toString() {
        return "MainPageTabChangeEvent(selectTabID=" + this.selectTabID + ')';
    }
}
