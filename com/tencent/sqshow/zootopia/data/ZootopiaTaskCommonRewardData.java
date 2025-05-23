package com.tencent.sqshow.zootopia.data;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\nB9\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u0012\b\u0002\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0011\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR,\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0014\u001a\u0004\b\n\u0010\u0015\"\u0004\b\u001a\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/t;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/sqshow/zootopia/data/x;", "a", "Lcom/tencent/sqshow/zootopia/data/x;", "c", "()Lcom/tencent/sqshow/zootopia/data/x;", "setRewardStatus", "(Lcom/tencent/sqshow/zootopia/data/x;)V", "rewardStatus", "", "Lcom/tencent/sqshow/zootopia/data/w;", "b", "Ljava/util/List;", "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "rewardList", "Lxv4/ab;", "setMaterialList", "materialList", "<init>", "(Lcom/tencent/sqshow/zootopia/data/x;Ljava/util/List;Ljava/util/List;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.t, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaTaskCommonRewardData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final ZootopiaTaskCommonRewardData f370416e = new ZootopiaTaskCommonRewardData(null, null, null, 7, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private ZootopiaTaskRewardStatus rewardStatus;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private List<ZootopiaTaskRewardInfo> rewardList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private List<xv4.ab> materialList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/t$a;", "", "Lxv4/h;", "info", "Lcom/tencent/sqshow/zootopia/data/t;", "a", "Lxv4/j;", "b", "Lxv4/l;", "c", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.data.t$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaTaskCommonRewardData a(xv4.h info) {
            ArrayList arrayList;
            xv4.ab[] abVarArr;
            xv4.z[] zVarArr;
            List list = null;
            ZootopiaTaskRewardStatus a16 = ZootopiaTaskRewardStatus.INSTANCE.a(info != null ? info.f448798a : null);
            if (info == null || (zVarArr = info.f448799b) == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(zVarArr.length);
                for (xv4.z zVar : zVarArr) {
                    arrayList.add(ZootopiaTaskRewardInfo.INSTANCE.a(zVar));
                }
            }
            if (info != null && (abVarArr = info.f448800c) != null) {
                list = ArraysKt___ArraysJvmKt.asList(abVarArr);
            }
            return new ZootopiaTaskCommonRewardData(a16, arrayList, list);
        }

        public final ZootopiaTaskCommonRewardData b(xv4.j info) {
            xv4.ab[] abVarArr;
            return new ZootopiaTaskCommonRewardData(ZootopiaTaskRewardStatus.INSTANCE.a(info != null ? info.f448803a : null), null, (info == null || (abVarArr = info.f448804b) == null) ? null : ArraysKt___ArraysJvmKt.asList(abVarArr));
        }

        public final ZootopiaTaskCommonRewardData c(xv4.l info) {
            xv4.ab[] abVarArr;
            return new ZootopiaTaskCommonRewardData(ZootopiaTaskRewardStatus.INSTANCE.a(info != null ? info.f448808a : null), null, (info == null || (abVarArr = info.f448809b) == null) ? null : ArraysKt___ArraysJvmKt.asList(abVarArr));
        }

        Companion() {
        }
    }

    public ZootopiaTaskCommonRewardData() {
        this(null, null, null, 7, null);
    }

    public final List<xv4.ab> a() {
        return this.materialList;
    }

    public final List<ZootopiaTaskRewardInfo> b() {
        return this.rewardList;
    }

    /* renamed from: c, reason: from getter */
    public final ZootopiaTaskRewardStatus getRewardStatus() {
        return this.rewardStatus;
    }

    public final void d(List<ZootopiaTaskRewardInfo> list) {
        this.rewardList = list;
    }

    public int hashCode() {
        ZootopiaTaskRewardStatus zootopiaTaskRewardStatus = this.rewardStatus;
        int hashCode = (zootopiaTaskRewardStatus == null ? 0 : zootopiaTaskRewardStatus.hashCode()) * 31;
        List<ZootopiaTaskRewardInfo> list = this.rewardList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<xv4.ab> list2 = this.materialList;
        return hashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "ZootopiaTaskCommonRewardData(rewardStatus=" + this.rewardStatus + ", rewardList=" + this.rewardList + ", materialList=" + this.materialList + ")";
    }

    public ZootopiaTaskCommonRewardData(ZootopiaTaskRewardStatus zootopiaTaskRewardStatus, List<ZootopiaTaskRewardInfo> list, List<xv4.ab> list2) {
        this.rewardStatus = zootopiaTaskRewardStatus;
        this.rewardList = list;
        this.materialList = list2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaTaskCommonRewardData)) {
            return false;
        }
        ZootopiaTaskCommonRewardData zootopiaTaskCommonRewardData = (ZootopiaTaskCommonRewardData) other;
        return Intrinsics.areEqual(this.rewardStatus, zootopiaTaskCommonRewardData.rewardStatus) && Intrinsics.areEqual(this.rewardList, zootopiaTaskCommonRewardData.rewardList) && Intrinsics.areEqual(this.materialList, zootopiaTaskCommonRewardData.materialList);
    }

    public /* synthetic */ ZootopiaTaskCommonRewardData(ZootopiaTaskRewardStatus zootopiaTaskRewardStatus, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : zootopiaTaskRewardStatus, (i3 & 2) != 0 ? null : list, (i3 & 4) != 0 ? null : list2);
    }
}
