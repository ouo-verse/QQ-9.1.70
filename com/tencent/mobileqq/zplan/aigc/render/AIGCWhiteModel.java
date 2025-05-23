package com.tencent.mobileqq.zplan.aigc.render;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u00c6\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/AIGCWhiteModel;", "", "itemID", "", "slotID", "extraInfo", "", "modelExtraInfo", "Lcom/tencent/mobileqq/zplan/aigc/render/ModelExtraInfo;", "(JJLjava/lang/String;Lcom/tencent/mobileqq/zplan/aigc/render/ModelExtraInfo;)V", "getExtraInfo", "()Ljava/lang/String;", "getItemID", "()J", "getModelExtraInfo", "()Lcom/tencent/mobileqq/zplan/aigc/render/ModelExtraInfo;", "setModelExtraInfo", "(Lcom/tencent/mobileqq/zplan/aigc/render/ModelExtraInfo;)V", "getSlotID", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class AIGCWhiteModel {
    private final String extraInfo;
    private final long itemID;
    private ModelExtraInfo modelExtraInfo;
    private final long slotID;

    public AIGCWhiteModel(long j3, long j16, String extraInfo, ModelExtraInfo modelExtraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.itemID = j3;
        this.slotID = j16;
        this.extraInfo = extraInfo;
        this.modelExtraInfo = modelExtraInfo;
    }

    /* renamed from: component1, reason: from getter */
    public final long getItemID() {
        return this.itemID;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSlotID() {
        return this.slotID;
    }

    /* renamed from: component3, reason: from getter */
    public final String getExtraInfo() {
        return this.extraInfo;
    }

    /* renamed from: component4, reason: from getter */
    public final ModelExtraInfo getModelExtraInfo() {
        return this.modelExtraInfo;
    }

    public final AIGCWhiteModel copy(long itemID, long slotID, String extraInfo, ModelExtraInfo modelExtraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        return new AIGCWhiteModel(itemID, slotID, extraInfo, modelExtraInfo);
    }

    public final String getExtraInfo() {
        return this.extraInfo;
    }

    public final long getItemID() {
        return this.itemID;
    }

    public final ModelExtraInfo getModelExtraInfo() {
        return this.modelExtraInfo;
    }

    public final long getSlotID() {
        return this.slotID;
    }

    public int hashCode() {
        int a16 = ((((com.tencent.mobileqq.vas.banner.c.a(this.itemID) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.slotID)) * 31) + this.extraInfo.hashCode()) * 31;
        ModelExtraInfo modelExtraInfo = this.modelExtraInfo;
        return a16 + (modelExtraInfo == null ? 0 : modelExtraInfo.hashCode());
    }

    public final void setModelExtraInfo(ModelExtraInfo modelExtraInfo) {
        this.modelExtraInfo = modelExtraInfo;
    }

    public String toString() {
        return "AIGCWhiteModel(itemID=" + this.itemID + ", slotID=" + this.slotID + ", extraInfo=" + this.extraInfo + ", modelExtraInfo=" + this.modelExtraInfo + ")";
    }

    public static /* synthetic */ AIGCWhiteModel copy$default(AIGCWhiteModel aIGCWhiteModel, long j3, long j16, String str, ModelExtraInfo modelExtraInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = aIGCWhiteModel.itemID;
        }
        long j17 = j3;
        if ((i3 & 2) != 0) {
            j16 = aIGCWhiteModel.slotID;
        }
        long j18 = j16;
        if ((i3 & 4) != 0) {
            str = aIGCWhiteModel.extraInfo;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            modelExtraInfo = aIGCWhiteModel.modelExtraInfo;
        }
        return aIGCWhiteModel.copy(j17, j18, str2, modelExtraInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIGCWhiteModel)) {
            return false;
        }
        AIGCWhiteModel aIGCWhiteModel = (AIGCWhiteModel) other;
        return this.itemID == aIGCWhiteModel.itemID && this.slotID == aIGCWhiteModel.slotID && Intrinsics.areEqual(this.extraInfo, aIGCWhiteModel.extraInfo) && Intrinsics.areEqual(this.modelExtraInfo, aIGCWhiteModel.modelExtraInfo);
    }
}
