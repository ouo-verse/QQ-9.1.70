package com.tencent.state.template.data;

import com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl;
import hs4.s;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+B9\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003JG\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001J\t\u0010\u0014\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\u000f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/state/template/data/InteractionMotionInfo;", "", "", "component1", "component2", "", "component3", "Lcom/tencent/state/template/data/MotionDpi;", "component4", "Lcom/tencent/state/template/data/StyleType;", "component5", "Lhs4/s;", "component6", "icon", "name", "motionId", "dpi", "styleType", ZPlanApiImpl.FILAMENT_TAG, "copy", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getIcon", "()Ljava/lang/String;", "getName", "I", "getMotionId", "()I", "Lcom/tencent/state/template/data/MotionDpi;", "getDpi", "()Lcom/tencent/state/template/data/MotionDpi;", "Lcom/tencent/state/template/data/StyleType;", "getStyleType", "()Lcom/tencent/state/template/data/StyleType;", "Lhs4/s;", "getFilament", "()Lhs4/s;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/state/template/data/MotionDpi;Lcom/tencent/state/template/data/StyleType;Lhs4/s;)V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionMotionInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MotionDpi dpi;
    private final s filament;
    private final String icon;
    private final int motionId;
    private final String name;
    private final StyleType styleType;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/state/template/data/InteractionMotionInfo$Companion;", "", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public InteractionMotionInfo(String icon, String name, int i3, MotionDpi dpi, StyleType styleType, s sVar) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(dpi, "dpi");
        Intrinsics.checkNotNullParameter(styleType, "styleType");
        this.icon = icon;
        this.name = name;
        this.motionId = i3;
        this.dpi = dpi;
        this.styleType = styleType;
        this.filament = sVar;
    }

    /* renamed from: component1, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMotionId() {
        return this.motionId;
    }

    /* renamed from: component4, reason: from getter */
    public final MotionDpi getDpi() {
        return this.dpi;
    }

    /* renamed from: component5, reason: from getter */
    public final StyleType getStyleType() {
        return this.styleType;
    }

    /* renamed from: component6, reason: from getter */
    public final s getFilament() {
        return this.filament;
    }

    public final InteractionMotionInfo copy(String icon, String name, int motionId, MotionDpi dpi, StyleType styleType, s filament) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(dpi, "dpi");
        Intrinsics.checkNotNullParameter(styleType, "styleType");
        return new InteractionMotionInfo(icon, name, motionId, dpi, styleType, filament);
    }

    public final MotionDpi getDpi() {
        return this.dpi;
    }

    public final s getFilament() {
        return this.filament;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getMotionId() {
        return this.motionId;
    }

    public final String getName() {
        return this.name;
    }

    public final StyleType getStyleType() {
        return this.styleType;
    }

    public int hashCode() {
        String str = this.icon;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.motionId) * 31;
        MotionDpi motionDpi = this.dpi;
        int hashCode3 = (hashCode2 + (motionDpi != null ? motionDpi.hashCode() : 0)) * 31;
        StyleType styleType = this.styleType;
        int hashCode4 = (hashCode3 + (styleType != null ? styleType.hashCode() : 0)) * 31;
        s sVar = this.filament;
        return hashCode4 + (sVar != null ? sVar.hashCode() : 0);
    }

    public String toString() {
        return "InteractionMotionInfo(icon=" + this.icon + ", name=" + this.name + ", motionId=" + this.motionId + ", dpi=" + this.dpi + ", styleType=" + this.styleType + ", filament=" + this.filament + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionMotionInfo)) {
            return false;
        }
        InteractionMotionInfo interactionMotionInfo = (InteractionMotionInfo) other;
        return Intrinsics.areEqual(this.icon, interactionMotionInfo.icon) && Intrinsics.areEqual(this.name, interactionMotionInfo.name) && this.motionId == interactionMotionInfo.motionId && Intrinsics.areEqual(this.dpi, interactionMotionInfo.dpi) && Intrinsics.areEqual(this.styleType, interactionMotionInfo.styleType) && Intrinsics.areEqual(this.filament, interactionMotionInfo.filament);
    }

    public static /* synthetic */ InteractionMotionInfo copy$default(InteractionMotionInfo interactionMotionInfo, String str, String str2, int i3, MotionDpi motionDpi, StyleType styleType, s sVar, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = interactionMotionInfo.icon;
        }
        if ((i16 & 2) != 0) {
            str2 = interactionMotionInfo.name;
        }
        String str3 = str2;
        if ((i16 & 4) != 0) {
            i3 = interactionMotionInfo.motionId;
        }
        int i17 = i3;
        if ((i16 & 8) != 0) {
            motionDpi = interactionMotionInfo.dpi;
        }
        MotionDpi motionDpi2 = motionDpi;
        if ((i16 & 16) != 0) {
            styleType = interactionMotionInfo.styleType;
        }
        StyleType styleType2 = styleType;
        if ((i16 & 32) != 0) {
            sVar = interactionMotionInfo.filament;
        }
        return interactionMotionInfo.copy(str, str3, i17, motionDpi2, styleType2, sVar);
    }
}
