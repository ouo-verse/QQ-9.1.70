package com.tencent.sqshow.zootopia.data;

import com.tencent.sqshow.zootopia.data.ZootopiaTaskItemData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001\nB1\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/sqshow/zootopia/data/y;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/sqshow/zootopia/data/u;", "a", "Lcom/tencent/sqshow/zootopia/data/u;", "b", "()Lcom/tencent/sqshow/zootopia/data/u;", "setDailyRewardData", "(Lcom/tencent/sqshow/zootopia/data/u;)V", "dailyRewardData", "Lcom/tencent/sqshow/zootopia/data/s;", "Lcom/tencent/sqshow/zootopia/data/s;", "()Lcom/tencent/sqshow/zootopia/data/s;", "setBlindBoxData", "(Lcom/tencent/sqshow/zootopia/data/s;)V", "blindBoxData", "", "Lcom/tencent/sqshow/zootopia/data/v;", "c", "Ljava/util/List;", "()Ljava/util/List;", "setTaskList", "(Ljava/util/List;)V", "taskList", "<init>", "(Lcom/tencent/sqshow/zootopia/data/u;Lcom/tencent/sqshow/zootopia/data/s;Ljava/util/List;)V", "d", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.y, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaTaskSystemMainData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private ZootopiaTaskDailyRewardData dailyRewardData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private ZootopiaTaskBlindBoxData blindBoxData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private List<ZootopiaTaskItemData> taskList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/y$a;", "", "Lxv4/u;", "dailyTask", "Lcom/tencent/sqshow/zootopia/data/y;", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.data.y$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaTaskSystemMainData a(xv4.u dailyTask) {
            xv4.ac acVar;
            xv4.w[] wVarArr;
            ArrayList arrayList = null;
            ZootopiaTaskDailyRewardData a16 = ZootopiaTaskDailyRewardData.INSTANCE.a(dailyTask != null ? dailyTask.f448820b : null);
            ZootopiaTaskBlindBoxData a17 = ZootopiaTaskBlindBoxData.INSTANCE.a(dailyTask != null ? dailyTask.f448821c : null);
            if (dailyTask != null && (acVar = dailyTask.f448819a) != null && (wVarArr = acVar.f448776f) != null) {
                arrayList = new ArrayList(wVarArr.length);
                for (xv4.w questInfo : wVarArr) {
                    ZootopiaTaskItemData.Companion companion = ZootopiaTaskItemData.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(questInfo, "questInfo");
                    arrayList.add(companion.a(questInfo));
                }
            }
            return new ZootopiaTaskSystemMainData(a16, a17, arrayList);
        }

        Companion() {
        }
    }

    public ZootopiaTaskSystemMainData() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final ZootopiaTaskBlindBoxData getBlindBoxData() {
        return this.blindBoxData;
    }

    /* renamed from: b, reason: from getter */
    public final ZootopiaTaskDailyRewardData getDailyRewardData() {
        return this.dailyRewardData;
    }

    public final List<ZootopiaTaskItemData> c() {
        return this.taskList;
    }

    public int hashCode() {
        ZootopiaTaskDailyRewardData zootopiaTaskDailyRewardData = this.dailyRewardData;
        int hashCode = (zootopiaTaskDailyRewardData == null ? 0 : zootopiaTaskDailyRewardData.hashCode()) * 31;
        ZootopiaTaskBlindBoxData zootopiaTaskBlindBoxData = this.blindBoxData;
        int hashCode2 = (hashCode + (zootopiaTaskBlindBoxData == null ? 0 : zootopiaTaskBlindBoxData.hashCode())) * 31;
        List<ZootopiaTaskItemData> list = this.taskList;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ZootopiaTaskSystemMainData(dailyRewardData=" + this.dailyRewardData + ", blindBoxData=" + this.blindBoxData + ", taskList=" + this.taskList + ")";
    }

    public ZootopiaTaskSystemMainData(ZootopiaTaskDailyRewardData zootopiaTaskDailyRewardData, ZootopiaTaskBlindBoxData zootopiaTaskBlindBoxData, List<ZootopiaTaskItemData> list) {
        this.dailyRewardData = zootopiaTaskDailyRewardData;
        this.blindBoxData = zootopiaTaskBlindBoxData;
        this.taskList = list;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaTaskSystemMainData)) {
            return false;
        }
        ZootopiaTaskSystemMainData zootopiaTaskSystemMainData = (ZootopiaTaskSystemMainData) other;
        return Intrinsics.areEqual(this.dailyRewardData, zootopiaTaskSystemMainData.dailyRewardData) && Intrinsics.areEqual(this.blindBoxData, zootopiaTaskSystemMainData.blindBoxData) && Intrinsics.areEqual(this.taskList, zootopiaTaskSystemMainData.taskList);
    }

    public /* synthetic */ ZootopiaTaskSystemMainData(ZootopiaTaskDailyRewardData zootopiaTaskDailyRewardData, ZootopiaTaskBlindBoxData zootopiaTaskBlindBoxData, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : zootopiaTaskDailyRewardData, (i3 & 2) != 0 ? null : zootopiaTaskBlindBoxData, (i3 & 4) != 0 ? new ArrayList() : list);
    }
}
