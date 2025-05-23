package com.tencent.mobileqq.qwallet.pet.data;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0006\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\t\u0010\u0005\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\"\u0010\u001a\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0013\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u000b\u0010\u0019R\"\u0010 \u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b\u0010\u0010\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/data/h;", "", "", "", "d", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getPetType", "()Ljava/lang/String;", "petType", "b", "getActionType", "actionType", "c", "getModelId", "modelId", "I", "getReadResourceTime", "()I", "(I)V", "readResourceTime", "e", "getAddResourceTime", "addResourceTime", "f", "getLoadModelTime", "loadModelTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qwallet.pet.data.h, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class PetReportBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String petType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String actionType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String modelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int readResourceTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int addResourceTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int loadModelTime;

    public PetReportBean(@NotNull String petType, @NotNull String actionType, @NotNull String modelId, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        this.petType = petType;
        this.actionType = actionType;
        this.modelId = modelId;
        this.readResourceTime = i3;
        this.addResourceTime = i16;
        this.loadModelTime = i17;
    }

    public final void a(int i3) {
        this.addResourceTime = i3;
    }

    public final void b(int i3) {
        this.loadModelTime = i3;
    }

    public final void c(int i3) {
        this.readResourceTime = i3;
    }

    @NotNull
    public final Map<String, String> d() {
        Map<String, String> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("kpet_pet_type", this.petType), TuplesKt.to("kpet_action_type", this.actionType), TuplesKt.to("kpet_model_id", this.modelId), TuplesKt.to("kpet_read_res_time", String.valueOf(this.readResourceTime)), TuplesKt.to("kpet_add_res_time", String.valueOf(this.addResourceTime)), TuplesKt.to("kpet_load_model_time", String.valueOf(this.loadModelTime)));
        return mutableMapOf;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PetReportBean)) {
            return false;
        }
        PetReportBean petReportBean = (PetReportBean) other;
        if (Intrinsics.areEqual(this.petType, petReportBean.petType) && Intrinsics.areEqual(this.actionType, petReportBean.actionType) && Intrinsics.areEqual(this.modelId, petReportBean.modelId) && this.readResourceTime == petReportBean.readResourceTime && this.addResourceTime == petReportBean.addResourceTime && this.loadModelTime == petReportBean.loadModelTime) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.petType.hashCode() * 31) + this.actionType.hashCode()) * 31) + this.modelId.hashCode()) * 31) + this.readResourceTime) * 31) + this.addResourceTime) * 31) + this.loadModelTime;
    }

    @NotNull
    public String toString() {
        return "PetReportBean(petType=" + this.petType + ", actionType=" + this.actionType + ", modelId=" + this.modelId + ", readResourceTime=" + this.readResourceTime + ", addResourceTime=" + this.addResourceTime + ", loadModelTime=" + this.loadModelTime + ")";
    }

    public /* synthetic */ PetReportBean(String str, String str2, String str3, int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i18 & 8) != 0 ? -1 : i3, (i18 & 16) != 0 ? -1 : i16, (i18 & 32) != 0 ? -1 : i17);
    }
}
