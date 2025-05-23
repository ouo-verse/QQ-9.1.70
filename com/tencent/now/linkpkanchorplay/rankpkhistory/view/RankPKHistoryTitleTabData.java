package com.tencent.now.linkpkanchorplay.rankpkhistory.view;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cB'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\n\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTitleTabData;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTitleTabData$TabId;", "a", "Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTitleTabData$TabId;", "c", "()Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTitleTabData$TabId;", "tabID", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "tabTitle", "Z", "()Z", "selected", "I", "()I", "pkType", "<init>", "(Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTitleTabData$TabId;Ljava/lang/String;ZI)V", "TabId", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final /* data */ class RankPKHistoryTitleTabData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TabId tabID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tabTitle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean selected;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int pkType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTitleTabData$TabId;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "LINK_SCREEN_MATCH", "COMMON_MATCH", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public enum TabId {
        LINK_SCREEN_MATCH(0),
        COMMON_MATCH(1);

        private final int id;

        TabId(int i3) {
            this.id = i3;
        }

        public final int getId() {
            return this.id;
        }
    }

    public RankPKHistoryTitleTabData(@NotNull TabId tabID, @NotNull String tabTitle, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(tabID, "tabID");
        Intrinsics.checkNotNullParameter(tabTitle, "tabTitle");
        this.tabID = tabID;
        this.tabTitle = tabTitle;
        this.selected = z16;
        this.pkType = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getPkType() {
        return this.pkType;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final TabId getTabID() {
        return this.tabID;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTabTitle() {
        return this.tabTitle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RankPKHistoryTitleTabData)) {
            return false;
        }
        RankPKHistoryTitleTabData rankPKHistoryTitleTabData = (RankPKHistoryTitleTabData) other;
        if (this.tabID == rankPKHistoryTitleTabData.tabID && Intrinsics.areEqual(this.tabTitle, rankPKHistoryTitleTabData.tabTitle) && this.selected == rankPKHistoryTitleTabData.selected && this.pkType == rankPKHistoryTitleTabData.pkType) {
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
        return ((hashCode + i3) * 31) + this.pkType;
    }

    @NotNull
    public String toString() {
        return "RankPKHistoryTitleTabData(tabID=" + this.tabID + ", tabTitle=" + this.tabTitle + ", selected=" + this.selected + ", pkType=" + this.pkType + ')';
    }
}
