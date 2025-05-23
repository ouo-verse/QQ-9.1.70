package com.tencent.mobileqq.zplan.aigc.render;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020\u0006H\u00d6\u0001J\t\u0010!\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/MaterialInst;", "", "ParaValue", "", "MatSlotName", "FuncName", "", "MatSlotId", "Type", "OriginValue", "ParaName", "(Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;)V", "getFuncName", "()I", "getMatSlotId", "getMatSlotName", "()Ljava/lang/String;", "getOriginValue", "getParaName", "getParaValue", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class MaterialInst {
    private final int FuncName;
    private final int MatSlotId;
    private final String MatSlotName;
    private final String OriginValue;
    private final String ParaName;
    private final String ParaValue;
    private final int Type;

    public MaterialInst(String ParaValue, String MatSlotName, int i3, int i16, int i17, String OriginValue, String ParaName) {
        Intrinsics.checkNotNullParameter(ParaValue, "ParaValue");
        Intrinsics.checkNotNullParameter(MatSlotName, "MatSlotName");
        Intrinsics.checkNotNullParameter(OriginValue, "OriginValue");
        Intrinsics.checkNotNullParameter(ParaName, "ParaName");
        this.ParaValue = ParaValue;
        this.MatSlotName = MatSlotName;
        this.FuncName = i3;
        this.MatSlotId = i16;
        this.Type = i17;
        this.OriginValue = OriginValue;
        this.ParaName = ParaName;
    }

    /* renamed from: component1, reason: from getter */
    public final String getParaValue() {
        return this.ParaValue;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMatSlotName() {
        return this.MatSlotName;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFuncName() {
        return this.FuncName;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMatSlotId() {
        return this.MatSlotId;
    }

    /* renamed from: component5, reason: from getter */
    public final int getType() {
        return this.Type;
    }

    /* renamed from: component6, reason: from getter */
    public final String getOriginValue() {
        return this.OriginValue;
    }

    /* renamed from: component7, reason: from getter */
    public final String getParaName() {
        return this.ParaName;
    }

    public final MaterialInst copy(String ParaValue, String MatSlotName, int FuncName, int MatSlotId, int Type, String OriginValue, String ParaName) {
        Intrinsics.checkNotNullParameter(ParaValue, "ParaValue");
        Intrinsics.checkNotNullParameter(MatSlotName, "MatSlotName");
        Intrinsics.checkNotNullParameter(OriginValue, "OriginValue");
        Intrinsics.checkNotNullParameter(ParaName, "ParaName");
        return new MaterialInst(ParaValue, MatSlotName, FuncName, MatSlotId, Type, OriginValue, ParaName);
    }

    public final int getFuncName() {
        return this.FuncName;
    }

    public final int getMatSlotId() {
        return this.MatSlotId;
    }

    public final String getMatSlotName() {
        return this.MatSlotName;
    }

    public final String getOriginValue() {
        return this.OriginValue;
    }

    public final String getParaName() {
        return this.ParaName;
    }

    public final String getParaValue() {
        return this.ParaValue;
    }

    public final int getType() {
        return this.Type;
    }

    public int hashCode() {
        return (((((((((((this.ParaValue.hashCode() * 31) + this.MatSlotName.hashCode()) * 31) + this.FuncName) * 31) + this.MatSlotId) * 31) + this.Type) * 31) + this.OriginValue.hashCode()) * 31) + this.ParaName.hashCode();
    }

    public String toString() {
        return "MaterialInst(ParaValue=" + this.ParaValue + ", MatSlotName=" + this.MatSlotName + ", FuncName=" + this.FuncName + ", MatSlotId=" + this.MatSlotId + ", Type=" + this.Type + ", OriginValue=" + this.OriginValue + ", ParaName=" + this.ParaName + ")";
    }

    public static /* synthetic */ MaterialInst copy$default(MaterialInst materialInst, String str, String str2, int i3, int i16, int i17, String str3, String str4, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            str = materialInst.ParaValue;
        }
        if ((i18 & 2) != 0) {
            str2 = materialInst.MatSlotName;
        }
        String str5 = str2;
        if ((i18 & 4) != 0) {
            i3 = materialInst.FuncName;
        }
        int i19 = i3;
        if ((i18 & 8) != 0) {
            i16 = materialInst.MatSlotId;
        }
        int i26 = i16;
        if ((i18 & 16) != 0) {
            i17 = materialInst.Type;
        }
        int i27 = i17;
        if ((i18 & 32) != 0) {
            str3 = materialInst.OriginValue;
        }
        String str6 = str3;
        if ((i18 & 64) != 0) {
            str4 = materialInst.ParaName;
        }
        return materialInst.copy(str, str5, i19, i26, i27, str6, str4);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MaterialInst)) {
            return false;
        }
        MaterialInst materialInst = (MaterialInst) other;
        return Intrinsics.areEqual(this.ParaValue, materialInst.ParaValue) && Intrinsics.areEqual(this.MatSlotName, materialInst.MatSlotName) && this.FuncName == materialInst.FuncName && this.MatSlotId == materialInst.MatSlotId && this.Type == materialInst.Type && Intrinsics.areEqual(this.OriginValue, materialInst.OriginValue) && Intrinsics.areEqual(this.ParaName, materialInst.ParaName);
    }

    public /* synthetic */ MaterialInst(String str, String str2, int i3, int i16, int i17, String str3, String str4, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i18 & 4) != 0 ? 2 : i3, i16, (i18 & 16) != 0 ? 0 : i17, (i18 & 32) != 0 ? "" : str3, (i18 & 64) != 0 ? "BaseColor" : str4);
    }
}
