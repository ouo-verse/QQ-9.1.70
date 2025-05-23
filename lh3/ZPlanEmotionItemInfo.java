package lh3;

import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Llh3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zplan/model/e;", "a", "Lcom/tencent/mobileqq/zplan/model/e;", "b", "()Lcom/tencent/mobileqq/zplan/model/e;", "zPlanActionInfo", "I", "()I", "type", "<init>", "(Lcom/tencent/mobileqq/zplan/model/e;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: lh3.a, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class ZPlanEmotionItemInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZPlanActionInfo zPlanActionInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    public ZPlanEmotionItemInfo() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: b, reason: from getter */
    public final ZPlanActionInfo getZPlanActionInfo() {
        return this.zPlanActionInfo;
    }

    public int hashCode() {
        ZPlanActionInfo zPlanActionInfo = this.zPlanActionInfo;
        return ((zPlanActionInfo == null ? 0 : zPlanActionInfo.hashCode()) * 31) + this.type;
    }

    public String toString() {
        return "ZPlanEmotionItemInfo(zPlanActionInfo=" + this.zPlanActionInfo + ", type=" + this.type + ")";
    }

    public ZPlanEmotionItemInfo(ZPlanActionInfo zPlanActionInfo, int i3) {
        this.zPlanActionInfo = zPlanActionInfo;
        this.type = i3;
    }

    public /* synthetic */ ZPlanEmotionItemInfo(ZPlanActionInfo zPlanActionInfo, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : zPlanActionInfo, (i16 & 2) != 0 ? -1 : i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanEmotionItemInfo)) {
            return false;
        }
        ZPlanEmotionItemInfo zPlanEmotionItemInfo = (ZPlanEmotionItemInfo) other;
        return Intrinsics.areEqual(this.zPlanActionInfo, zPlanEmotionItemInfo.zPlanActionInfo) && this.type == zPlanEmotionItemInfo.type;
    }
}
