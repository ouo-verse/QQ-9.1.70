package com.tencent.now.linkpkanchorplay.mainpage.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\n\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData$TabId;", "a", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData$TabId;", "b", "()Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData$TabId;", "tabID", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "tabTitle", "Z", "()Z", "selected", "<init>", "(Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData$TabId;Ljava/lang/String;Z)V", "TabId", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final /* data */ class LinkPKTabData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TabId tabID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tabTitle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean selected;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData$TabId;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "PK_TAB", "LINK_TAB", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public enum TabId {
        PK_TAB(0),
        LINK_TAB(1);

        private final int id;

        TabId(int i3) {
            this.id = i3;
        }

        public final int getId() {
            return this.id;
        }
    }

    public LinkPKTabData(@NotNull TabId tabID, @NotNull String tabTitle, boolean z16) {
        Intrinsics.checkNotNullParameter(tabID, "tabID");
        Intrinsics.checkNotNullParameter(tabTitle, "tabTitle");
        this.tabID = tabID;
        this.tabTitle = tabTitle;
        this.selected = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final TabId getTabID() {
        return this.tabID;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTabTitle() {
        return this.tabTitle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinkPKTabData)) {
            return false;
        }
        LinkPKTabData linkPKTabData = (LinkPKTabData) other;
        if (this.tabID == linkPKTabData.tabID && Intrinsics.areEqual(this.tabTitle, linkPKTabData.tabTitle) && this.selected == linkPKTabData.selected) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.tabID.hashCode() * 31) + this.tabTitle.hashCode()) * 31;
        boolean z16 = this.selected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "LinkPKTabData(tabID=" + this.tabID + ", tabTitle=" + this.tabTitle + ", selected=" + this.selected + ')';
    }
}
