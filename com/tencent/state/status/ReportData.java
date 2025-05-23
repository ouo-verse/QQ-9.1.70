package com.tencent.state.status;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00c6\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0012R\u0011\u0010\n\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/status/ReportData;", "", "isMultiAction", "", "hasRecorded", "cornerName", "", "actionId", "", "dynamicSrc", "staticSrc", "(ZZLjava/lang/String;III)V", "getActionId", "()I", "getCornerName", "()Ljava/lang/String;", "getDynamicSrc", "getHasRecorded", "()Z", "getStaticSrc", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class ReportData {
    private final int actionId;
    private final String cornerName;
    private final int dynamicSrc;
    private final boolean hasRecorded;
    private final boolean isMultiAction;
    private final int staticSrc;

    public ReportData() {
        this(false, false, null, 0, 0, 0, 63, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsMultiAction() {
        return this.isMultiAction;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHasRecorded() {
        return this.hasRecorded;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCornerName() {
        return this.cornerName;
    }

    /* renamed from: component4, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    /* renamed from: component5, reason: from getter */
    public final int getDynamicSrc() {
        return this.dynamicSrc;
    }

    /* renamed from: component6, reason: from getter */
    public final int getStaticSrc() {
        return this.staticSrc;
    }

    public final ReportData copy(boolean isMultiAction, boolean hasRecorded, String cornerName, int actionId, int dynamicSrc, int staticSrc) {
        Intrinsics.checkNotNullParameter(cornerName, "cornerName");
        return new ReportData(isMultiAction, hasRecorded, cornerName, actionId, dynamicSrc, staticSrc);
    }

    public final int getActionId() {
        return this.actionId;
    }

    public final String getCornerName() {
        return this.cornerName;
    }

    public final int getDynamicSrc() {
        return this.dynamicSrc;
    }

    public final boolean getHasRecorded() {
        return this.hasRecorded;
    }

    public final int getStaticSrc() {
        return this.staticSrc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z16 = this.isMultiAction;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        boolean z17 = this.hasRecorded;
        int i16 = (i3 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
        String str = this.cornerName;
        return ((((((i16 + (str != null ? str.hashCode() : 0)) * 31) + this.actionId) * 31) + this.dynamicSrc) * 31) + this.staticSrc;
    }

    public final boolean isMultiAction() {
        return this.isMultiAction;
    }

    public String toString() {
        return "ReportData(isMultiAction=" + this.isMultiAction + ", hasRecorded=" + this.hasRecorded + ", cornerName=" + this.cornerName + ", actionId=" + this.actionId + ", dynamicSrc=" + this.dynamicSrc + ", staticSrc=" + this.staticSrc + ")";
    }

    public ReportData(boolean z16, boolean z17, String cornerName, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(cornerName, "cornerName");
        this.isMultiAction = z16;
        this.hasRecorded = z17;
        this.cornerName = cornerName;
        this.actionId = i3;
        this.dynamicSrc = i16;
        this.staticSrc = i17;
    }

    public /* synthetic */ ReportData(boolean z16, boolean z17, String str, int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? false : z16, (i18 & 2) != 0 ? false : z17, (i18 & 4) != 0 ? "" : str, (i18 & 8) != 0 ? 0 : i3, (i18 & 16) != 0 ? 0 : i16, (i18 & 32) != 0 ? 0 : i17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportData)) {
            return false;
        }
        ReportData reportData = (ReportData) other;
        return this.isMultiAction == reportData.isMultiAction && this.hasRecorded == reportData.hasRecorded && Intrinsics.areEqual(this.cornerName, reportData.cornerName) && this.actionId == reportData.actionId && this.dynamicSrc == reportData.dynamicSrc && this.staticSrc == reportData.staticSrc;
    }

    public static /* synthetic */ ReportData copy$default(ReportData reportData, boolean z16, boolean z17, String str, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            z16 = reportData.isMultiAction;
        }
        if ((i18 & 2) != 0) {
            z17 = reportData.hasRecorded;
        }
        boolean z18 = z17;
        if ((i18 & 4) != 0) {
            str = reportData.cornerName;
        }
        String str2 = str;
        if ((i18 & 8) != 0) {
            i3 = reportData.actionId;
        }
        int i19 = i3;
        if ((i18 & 16) != 0) {
            i16 = reportData.dynamicSrc;
        }
        int i26 = i16;
        if ((i18 & 32) != 0) {
            i17 = reportData.staticSrc;
        }
        return reportData.copy(z16, z18, str2, i19, i26, i17);
    }
}
