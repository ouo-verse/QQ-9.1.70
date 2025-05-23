package com.tencent.state.square.bubblesetting;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J-\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/square/bubblesetting/SquareBubbleSkinGroup;", "", "groupId", "", "groupName", "", "skins", "", "Lcom/tencent/state/square/bubblesetting/SquareBubbleSkin;", "(ILjava/lang/String;Ljava/util/List;)V", "getGroupId", "()I", "setGroupId", "(I)V", "getGroupName", "()Ljava/lang/String;", "setGroupName", "(Ljava/lang/String;)V", "getSkins", "()Ljava/util/List;", "setSkins", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareBubbleSkinGroup {
    private int groupId;
    private String groupName;
    private List<SquareBubbleSkin> skins;

    public SquareBubbleSkinGroup() {
        this(0, null, null, 7, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getGroupId() {
        return this.groupId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    public final List<SquareBubbleSkin> component3() {
        return this.skins;
    }

    public final SquareBubbleSkinGroup copy(int groupId, String groupName, List<SquareBubbleSkin> skins) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(skins, "skins");
        return new SquareBubbleSkinGroup(groupId, groupName, skins);
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final List<SquareBubbleSkin> getSkins() {
        return this.skins;
    }

    public int hashCode() {
        int i3 = this.groupId * 31;
        String str = this.groupName;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        List<SquareBubbleSkin> list = this.skins;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setGroupId(int i3) {
        this.groupId = i3;
    }

    public final void setGroupName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupName = str;
    }

    public final void setSkins(List<SquareBubbleSkin> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.skins = list;
    }

    public String toString() {
        return "SquareBubbleSkinGroup(groupId=" + this.groupId + ", groupName=" + this.groupName + ", skins=" + this.skins + ")";
    }

    public SquareBubbleSkinGroup(int i3, String groupName, List<SquareBubbleSkin> skins) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(skins, "skins");
        this.groupId = i3;
        this.groupName = groupName;
        this.skins = skins;
    }

    public /* synthetic */ SquareBubbleSkinGroup(int i3, String str, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareBubbleSkinGroup)) {
            return false;
        }
        SquareBubbleSkinGroup squareBubbleSkinGroup = (SquareBubbleSkinGroup) other;
        return this.groupId == squareBubbleSkinGroup.groupId && Intrinsics.areEqual(this.groupName, squareBubbleSkinGroup.groupName) && Intrinsics.areEqual(this.skins, squareBubbleSkinGroup.skins);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SquareBubbleSkinGroup copy$default(SquareBubbleSkinGroup squareBubbleSkinGroup, int i3, String str, List list, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = squareBubbleSkinGroup.groupId;
        }
        if ((i16 & 2) != 0) {
            str = squareBubbleSkinGroup.groupName;
        }
        if ((i16 & 4) != 0) {
            list = squareBubbleSkinGroup.skins;
        }
        return squareBubbleSkinGroup.copy(i3, str, list);
    }
}
