package com.tencent.sqshow.zootopia.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "groupId", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "bgColor", "Lcom/tencent/sqshow/zootopia/data/e;", "Lcom/tencent/sqshow/zootopia/data/e;", "d", "()Lcom/tencent/sqshow/zootopia/data/e;", "titleData", "childModuleCount", "<init>", "(ILjava/lang/String;Lcom/tencent/sqshow/zootopia/data/e;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.d, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaCardGroupData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int groupId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String bgColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaCardTitleData titleData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int childModuleCount;

    public ZootopiaCardGroupData(int i3, String bgColor, ZootopiaCardTitleData titleData, int i16) {
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        Intrinsics.checkNotNullParameter(titleData, "titleData");
        this.groupId = i3;
        this.bgColor = bgColor;
        this.titleData = titleData;
        this.childModuleCount = i16;
    }

    /* renamed from: a, reason: from getter */
    public final String getBgColor() {
        return this.bgColor;
    }

    /* renamed from: b, reason: from getter */
    public final int getChildModuleCount() {
        return this.childModuleCount;
    }

    /* renamed from: c, reason: from getter */
    public final int getGroupId() {
        return this.groupId;
    }

    /* renamed from: d, reason: from getter */
    public final ZootopiaCardTitleData getTitleData() {
        return this.titleData;
    }

    public int hashCode() {
        return (((((this.groupId * 31) + this.bgColor.hashCode()) * 31) + this.titleData.hashCode()) * 31) + this.childModuleCount;
    }

    public String toString() {
        return "ZootopiaCardGroupData(groupId=" + this.groupId + ", bgColor=" + this.bgColor + ", titleData=" + this.titleData + ", childModuleCount=" + this.childModuleCount + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaCardGroupData)) {
            return false;
        }
        ZootopiaCardGroupData zootopiaCardGroupData = (ZootopiaCardGroupData) other;
        return this.groupId == zootopiaCardGroupData.groupId && Intrinsics.areEqual(this.bgColor, zootopiaCardGroupData.bgColor) && Intrinsics.areEqual(this.titleData, zootopiaCardGroupData.titleData) && this.childModuleCount == zootopiaCardGroupData.childModuleCount;
    }
}
