package jc4;

import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0019\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Ljc4/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "itemType", "Lhu4/f;", "b", "Lhu4/f;", "()Lhu4/f;", "personalInfo", "Ljc4/g;", "c", "Ljc4/g;", "()Ljc4/g;", "titleData", "Ljc4/h;", "d", "Ljc4/h;", "()Ljc4/h;", "workItemData", "Lcom/tencent/sqshow/zootopia/data/c;", "e", "Lcom/tencent/sqshow/zootopia/data/c;", "getCardData", "()Lcom/tencent/sqshow/zootopia/data/c;", "cardData", "<init>", "(ILhu4/f;Ljc4/g;Ljc4/h;Lcom/tencent/sqshow/zootopia/data/c;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jc4.a, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class UserCenterCardData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int itemType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final hu4.f personalInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final UserCenterTitleCardData titleData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final UserWorkItemData workItemData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaCardData cardData;

    public UserCenterCardData(int i3, hu4.f fVar, UserCenterTitleCardData userCenterTitleCardData, UserWorkItemData userWorkItemData, ZootopiaCardData zootopiaCardData) {
        this.itemType = i3;
        this.personalInfo = fVar;
        this.titleData = userCenterTitleCardData;
        this.workItemData = userWorkItemData;
        this.cardData = zootopiaCardData;
    }

    /* renamed from: a, reason: from getter */
    public final int getItemType() {
        return this.itemType;
    }

    /* renamed from: b, reason: from getter */
    public final hu4.f getPersonalInfo() {
        return this.personalInfo;
    }

    /* renamed from: c, reason: from getter */
    public final UserCenterTitleCardData getTitleData() {
        return this.titleData;
    }

    /* renamed from: d, reason: from getter */
    public final UserWorkItemData getWorkItemData() {
        return this.workItemData;
    }

    public int hashCode() {
        int i3 = this.itemType * 31;
        hu4.f fVar = this.personalInfo;
        int hashCode = (i3 + (fVar == null ? 0 : fVar.hashCode())) * 31;
        UserCenterTitleCardData userCenterTitleCardData = this.titleData;
        int hashCode2 = (hashCode + (userCenterTitleCardData == null ? 0 : userCenterTitleCardData.hashCode())) * 31;
        UserWorkItemData userWorkItemData = this.workItemData;
        int hashCode3 = (hashCode2 + (userWorkItemData == null ? 0 : userWorkItemData.hashCode())) * 31;
        ZootopiaCardData zootopiaCardData = this.cardData;
        return hashCode3 + (zootopiaCardData != null ? zootopiaCardData.hashCode() : 0);
    }

    public String toString() {
        return "UserCenterCardData(itemType=" + this.itemType + ", personalInfo=" + this.personalInfo + ", titleData=" + this.titleData + ", workItemData=" + this.workItemData + ", cardData=" + this.cardData + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserCenterCardData)) {
            return false;
        }
        UserCenterCardData userCenterCardData = (UserCenterCardData) other;
        return this.itemType == userCenterCardData.itemType && Intrinsics.areEqual(this.personalInfo, userCenterCardData.personalInfo) && Intrinsics.areEqual(this.titleData, userCenterCardData.titleData) && Intrinsics.areEqual(this.workItemData, userCenterCardData.workItemData) && Intrinsics.areEqual(this.cardData, userCenterCardData.cardData);
    }

    public /* synthetic */ UserCenterCardData(int i3, hu4.f fVar, UserCenterTitleCardData userCenterTitleCardData, UserWorkItemData userWorkItemData, ZootopiaCardData zootopiaCardData, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : fVar, (i16 & 4) != 0 ? null : userCenterTitleCardData, (i16 & 8) != 0 ? null : userWorkItemData, (i16 & 16) != 0 ? null : zootopiaCardData);
    }
}
