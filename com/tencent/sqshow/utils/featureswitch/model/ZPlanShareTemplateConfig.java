package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\t\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R,\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/ak;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "", "sceneItemIndices", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "Lcom/tencent/sqshow/utils/featureswitch/model/aj;", "items", "Ljava/util/List;", "a", "()Ljava/util/List;", "<init>", "(Ljava/util/Map;Ljava/util/List;)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.ak, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanShareTemplateConfig {

    @SerializedName("items")
    private final List<ZPlanShareItem> items;

    @SerializedName("sceneItemIndices")
    private final Map<Integer, List<Integer>> sceneItemIndices;

    public ZPlanShareTemplateConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final List<ZPlanShareItem> a() {
        return this.items;
    }

    public final Map<Integer, List<Integer>> b() {
        return this.sceneItemIndices;
    }

    public int hashCode() {
        return (this.sceneItemIndices.hashCode() * 31) + this.items.hashCode();
    }

    public String toString() {
        return "ZPlanShareTemplateConfig(sceneItemIndices=" + this.sceneItemIndices + ", items=" + this.items + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ZPlanShareTemplateConfig(Map<Integer, ? extends List<Integer>> sceneItemIndices, List<ZPlanShareItem> items) {
        Intrinsics.checkNotNullParameter(sceneItemIndices, "sceneItemIndices");
        Intrinsics.checkNotNullParameter(items, "items");
        this.sceneItemIndices = sceneItemIndices;
        this.items = items;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ZPlanShareTemplateConfig(Map map, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i3 & 2) != 0 ? CollectionsKt__CollectionsJVMKt.listOf(new ZPlanShareItem(0, null, null, null, null, null, null, 127, null)) : list);
        List listOf;
        if ((i3 & 1) != 0) {
            Integer valueOf = Integer.valueOf(ShareScene.CHANGE_DRESS.getValue());
            listOf = CollectionsKt__CollectionsJVMKt.listOf(0);
            map = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(valueOf, listOf));
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanShareTemplateConfig)) {
            return false;
        }
        ZPlanShareTemplateConfig zPlanShareTemplateConfig = (ZPlanShareTemplateConfig) other;
        return Intrinsics.areEqual(this.sceneItemIndices, zPlanShareTemplateConfig.sceneItemIndices) && Intrinsics.areEqual(this.items, zPlanShareTemplateConfig.items);
    }
}
