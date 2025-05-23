package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "shareIds", "Ljava/util/List;", "getShareIds", "()Ljava/util/List;", "pkActionIds", "getPkActionIds", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.h, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class PortalPreRecordAction {

    @SerializedName("pkActionIds")
    private final List<Integer> pkActionIds;

    @SerializedName("shareIds")
    private final List<Integer> shareIds;

    public PortalPreRecordAction() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public int hashCode() {
        return (this.shareIds.hashCode() * 31) + this.pkActionIds.hashCode();
    }

    public String toString() {
        return "PortalPreRecordAction(shareIds=" + this.shareIds + ", pkActionIds=" + this.pkActionIds + ')';
    }

    public PortalPreRecordAction(List<Integer> shareIds, List<Integer> pkActionIds) {
        Intrinsics.checkNotNullParameter(shareIds, "shareIds");
        Intrinsics.checkNotNullParameter(pkActionIds, "pkActionIds");
        this.shareIds = shareIds;
        this.pkActionIds = pkActionIds;
    }

    public /* synthetic */ PortalPreRecordAction(List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsJVMKt.listOf(6093) : list, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{6093, 6094, 6099, 6100, 6101}) : list2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PortalPreRecordAction)) {
            return false;
        }
        PortalPreRecordAction portalPreRecordAction = (PortalPreRecordAction) other;
        return Intrinsics.areEqual(this.shareIds, portalPreRecordAction.shareIds) && Intrinsics.areEqual(this.pkActionIds, portalPreRecordAction.pkActionIds);
    }
}
