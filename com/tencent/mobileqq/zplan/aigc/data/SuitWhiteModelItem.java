package com.tencent.mobileqq.zplan.aigc.data;

import com.tencent.mobileqq.zplan.aigc.render.AIGCWhiteModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uv4.bn;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\n\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/o;", "", "", "toString", "", "hashCode", "other", "", "equals", "Luv4/bn;", "a", "Luv4/bn;", "b", "()Luv4/bn;", "data", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "imageUrl", "d", "itemId", "Lcom/tencent/mobileqq/zplan/aigc/render/AIGCWhiteModel;", "Lcom/tencent/mobileqq/zplan/aigc/render/AIGCWhiteModel;", "()Lcom/tencent/mobileqq/zplan/aigc/render/AIGCWhiteModel;", "setAigcWhiteModel", "(Lcom/tencent/mobileqq/zplan/aigc/render/AIGCWhiteModel;)V", "aigcWhiteModel", "e", "Z", "getSelected", "()Z", "setSelected", "(Z)V", "selected", "<init>", "(Luv4/bn;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/zplan/aigc/render/AIGCWhiteModel;Z)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aigc.data.o, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class SuitWhiteModelItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final bn data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String imageUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String itemId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private AIGCWhiteModel aigcWhiteModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean selected;

    public SuitWhiteModelItem(bn bnVar, String str, String itemId, AIGCWhiteModel aigcWhiteModel, boolean z16) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(aigcWhiteModel, "aigcWhiteModel");
        this.data = bnVar;
        this.imageUrl = str;
        this.itemId = itemId;
        this.aigcWhiteModel = aigcWhiteModel;
        this.selected = z16;
    }

    /* renamed from: a, reason: from getter */
    public final AIGCWhiteModel getAigcWhiteModel() {
        return this.aigcWhiteModel;
    }

    /* renamed from: b, reason: from getter */
    public final bn getData() {
        return this.data;
    }

    /* renamed from: c, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: d, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        bn bnVar = this.data;
        int hashCode = (bnVar == null ? 0 : bnVar.hashCode()) * 31;
        String str = this.imageUrl;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.itemId.hashCode()) * 31) + this.aigcWhiteModel.hashCode()) * 31;
        boolean z16 = this.selected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode2 + i3;
    }

    public String toString() {
        return "SuitWhiteModelItem(data=" + this.data + ", imageUrl=" + this.imageUrl + ", itemId=" + this.itemId + ", aigcWhiteModel=" + this.aigcWhiteModel + ", selected=" + this.selected + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuitWhiteModelItem)) {
            return false;
        }
        SuitWhiteModelItem suitWhiteModelItem = (SuitWhiteModelItem) other;
        return Intrinsics.areEqual(this.data, suitWhiteModelItem.data) && Intrinsics.areEqual(this.imageUrl, suitWhiteModelItem.imageUrl) && Intrinsics.areEqual(this.itemId, suitWhiteModelItem.itemId) && Intrinsics.areEqual(this.aigcWhiteModel, suitWhiteModelItem.aigcWhiteModel) && this.selected == suitWhiteModelItem.selected;
    }

    public /* synthetic */ SuitWhiteModelItem(bn bnVar, String str, String str2, AIGCWhiteModel aIGCWhiteModel, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(bnVar, str, str2, aIGCWhiteModel, (i3 & 16) != 0 ? false : z16);
    }
}
