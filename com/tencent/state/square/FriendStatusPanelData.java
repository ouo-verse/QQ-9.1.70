package com.tencent.state.square;

import com.tencent.mobileqq.vas.VasPerfReportUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/FriendStatusPanelData;", "", "title", "", "list", "", "(Ljava/lang/String;Ljava/util/List;)V", VasPerfReportUtils.WHILE_GET_LIST, "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class FriendStatusPanelData {
    private final List<String> list;
    private final String title;

    public FriendStatusPanelData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final List<String> component2() {
        return this.list;
    }

    public final FriendStatusPanelData copy(String title, List<String> list) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(list, "list");
        return new FriendStatusPanelData(title, list);
    }

    public final List<String> getList() {
        return this.list;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.list;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "FriendStatusPanelData(title=" + this.title + ", list=" + this.list + ")";
    }

    public FriendStatusPanelData(String title, List<String> list) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(list, "list");
        this.title = title;
        this.list = list;
    }

    public /* synthetic */ FriendStatusPanelData(String str, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendStatusPanelData)) {
            return false;
        }
        FriendStatusPanelData friendStatusPanelData = (FriendStatusPanelData) other;
        return Intrinsics.areEqual(this.title, friendStatusPanelData.title) && Intrinsics.areEqual(this.list, friendStatusPanelData.list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FriendStatusPanelData copy$default(FriendStatusPanelData friendStatusPanelData, String str, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = friendStatusPanelData.title;
        }
        if ((i3 & 2) != 0) {
            list = friendStatusPanelData.list;
        }
        return friendStatusPanelData.copy(str, list);
    }
}
