package com.tencent.sqshow.zootopia.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 02\u00020\u0001:\u0001\nBY\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&\u00a2\u0006\u0004\b.\u0010/J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014\"\u0004\b\"\u0010\u0016R\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b$\u0010\u0016R*\u0010-\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/w;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "g", "()J", "setRewardItemId", "(J)V", "rewardItemId", "b", "I", "f", "()I", "setRewardItemCnt", "(I)V", "rewardItemCnt", "c", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setItemTitle", "(Ljava/lang/String;)V", "itemTitle", "d", "setItemIcon", "itemIcon", "setBagStatus", "bagStatus", "setBagType", "bagType", "", "Lxv4/ab;", "Ljava/util/List;", "getMaterialList", "()Ljava/util/List;", "setMaterialList", "(Ljava/util/List;)V", "materialList", "<init>", "(JILjava/lang/String;Ljava/lang/String;IILjava/util/List;)V", tl.h.F, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.w, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaTaskRewardInfo {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static final ZootopiaTaskRewardInfo f370454i = new ZootopiaTaskRewardInfo(0, 0, null, null, 0, 0, null, 127, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long rewardItemId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int rewardItemCnt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String itemTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String itemIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int bagStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int bagType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private List<xv4.ab> materialList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0006\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/w$a;", "", "Lxv4/z;", "info", "Lcom/tencent/sqshow/zootopia/data/w;", "a", "DEFAULT_DATA", "Lcom/tencent/sqshow/zootopia/data/w;", "b", "()Lcom/tencent/sqshow/zootopia/data/w;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.data.w$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaTaskRewardInfo b() {
            return ZootopiaTaskRewardInfo.f370454i;
        }

        Companion() {
        }

        public final ZootopiaTaskRewardInfo a(xv4.z info) {
            List asList;
            if (info == null) {
                return b();
            }
            long j3 = info.f448857a;
            int i3 = info.f448858b;
            String str = info.f448859c;
            String str2 = info.f448860d;
            int i16 = info.f448861e;
            int i17 = info.f448863g;
            xv4.ab[] abVarArr = info.f448862f;
            Intrinsics.checkNotNullExpressionValue(abVarArr, "info.spMaterial");
            asList = ArraysKt___ArraysJvmKt.asList(abVarArr);
            return new ZootopiaTaskRewardInfo(j3, i3, str, str2, i16, i17, asList);
        }
    }

    public ZootopiaTaskRewardInfo() {
        this(0L, 0, null, null, 0, 0, null, 127, null);
    }

    /* renamed from: b, reason: from getter */
    public final int getBagStatus() {
        return this.bagStatus;
    }

    /* renamed from: c, reason: from getter */
    public final int getBagType() {
        return this.bagType;
    }

    /* renamed from: d, reason: from getter */
    public final String getItemIcon() {
        return this.itemIcon;
    }

    /* renamed from: e, reason: from getter */
    public final String getItemTitle() {
        return this.itemTitle;
    }

    /* renamed from: f, reason: from getter */
    public final int getRewardItemCnt() {
        return this.rewardItemCnt;
    }

    /* renamed from: g, reason: from getter */
    public final long getRewardItemId() {
        return this.rewardItemId;
    }

    public int hashCode() {
        int a16 = ((com.tencent.mobileqq.vas.banner.c.a(this.rewardItemId) * 31) + this.rewardItemCnt) * 31;
        String str = this.itemTitle;
        int hashCode = (a16 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.itemIcon;
        int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.bagStatus) * 31) + this.bagType) * 31;
        List<xv4.ab> list = this.materialList;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ZootopiaTaskRewardInfo(rewardItemId=" + this.rewardItemId + ", rewardItemCnt=" + this.rewardItemCnt + ", itemTitle=" + this.itemTitle + ", itemIcon=" + this.itemIcon + ", bagStatus=" + this.bagStatus + ", bagType=" + this.bagType + ", materialList=" + this.materialList + ")";
    }

    public ZootopiaTaskRewardInfo(long j3, int i3, String str, String str2, int i16, int i17, List<xv4.ab> list) {
        this.rewardItemId = j3;
        this.rewardItemCnt = i3;
        this.itemTitle = str;
        this.itemIcon = str2;
        this.bagStatus = i16;
        this.bagType = i17;
        this.materialList = list;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaTaskRewardInfo)) {
            return false;
        }
        ZootopiaTaskRewardInfo zootopiaTaskRewardInfo = (ZootopiaTaskRewardInfo) other;
        return this.rewardItemId == zootopiaTaskRewardInfo.rewardItemId && this.rewardItemCnt == zootopiaTaskRewardInfo.rewardItemCnt && Intrinsics.areEqual(this.itemTitle, zootopiaTaskRewardInfo.itemTitle) && Intrinsics.areEqual(this.itemIcon, zootopiaTaskRewardInfo.itemIcon) && this.bagStatus == zootopiaTaskRewardInfo.bagStatus && this.bagType == zootopiaTaskRewardInfo.bagType && Intrinsics.areEqual(this.materialList, zootopiaTaskRewardInfo.materialList);
    }

    public /* synthetic */ ZootopiaTaskRewardInfo(long j3, int i3, String str, String str2, int i16, int i17, List list, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0L : j3, (i18 & 2) != 0 ? 0 : i3, (i18 & 4) != 0 ? null : str, (i18 & 8) != 0 ? null : str2, (i18 & 16) != 0 ? 0 : i16, (i18 & 32) == 0 ? i17 : 0, (i18 & 64) == 0 ? list : null);
    }
}
