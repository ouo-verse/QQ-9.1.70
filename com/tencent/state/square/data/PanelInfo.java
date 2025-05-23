package com.tencent.state.square.data;

import com.tencent.state.square.pickfriend.service.FriendData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/data/PanelInfo;", "", "categoryList", "", "Lcom/tencent/state/square/data/PanelCategoryInfo;", "pickFriendList", "Lcom/tencent/state/square/pickfriend/service/FriendData;", "(Ljava/util/List;Ljava/util/List;)V", "getCategoryList", "()Ljava/util/List;", "getPickFriendList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class PanelInfo {
    private final List<PanelCategoryInfo> categoryList;
    private final List<FriendData> pickFriendList;

    public PanelInfo(List<PanelCategoryInfo> categoryList, List<FriendData> pickFriendList) {
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        Intrinsics.checkNotNullParameter(pickFriendList, "pickFriendList");
        this.categoryList = categoryList;
        this.pickFriendList = pickFriendList;
    }

    public final List<PanelCategoryInfo> component1() {
        return this.categoryList;
    }

    public final List<FriendData> component2() {
        return this.pickFriendList;
    }

    public final PanelInfo copy(List<PanelCategoryInfo> categoryList, List<FriendData> pickFriendList) {
        Intrinsics.checkNotNullParameter(categoryList, "categoryList");
        Intrinsics.checkNotNullParameter(pickFriendList, "pickFriendList");
        return new PanelInfo(categoryList, pickFriendList);
    }

    public final List<PanelCategoryInfo> getCategoryList() {
        return this.categoryList;
    }

    public final List<FriendData> getPickFriendList() {
        return this.pickFriendList;
    }

    public int hashCode() {
        List<PanelCategoryInfo> list = this.categoryList;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<FriendData> list2 = this.pickFriendList;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "PanelInfo(categoryList=" + this.categoryList + ", pickFriendList=" + this.pickFriendList + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PanelInfo)) {
            return false;
        }
        PanelInfo panelInfo = (PanelInfo) other;
        return Intrinsics.areEqual(this.categoryList, panelInfo.categoryList) && Intrinsics.areEqual(this.pickFriendList, panelInfo.pickFriendList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PanelInfo copy$default(PanelInfo panelInfo, List list, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = panelInfo.categoryList;
        }
        if ((i3 & 2) != 0) {
            list2 = panelInfo.pickFriendList;
        }
        return panelInfo.copy(list, list2);
    }
}
