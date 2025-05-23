package com.tencent.state.square.data;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0007H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/data/NewInfo;", "", "type", "", "hasNewFlag", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "", "(IZLjava/lang/String;)V", "getHasNewFlag", "()Z", "setHasNewFlag", "(Z)V", "getType", "()I", "getUniqueId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class NewInfo {
    public static final int TYPE_NEW_DRESS = 2;
    public static final int TYPE_NEW_INTERACT = 3;
    public static final int TYPE_NEW_STATUS = 1;
    private boolean hasNewFlag;
    private final int type;
    private final String uniqueId;

    public NewInfo(int i3, boolean z16, String uniqueId) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        this.type = i3;
        this.hasNewFlag = z16;
        this.uniqueId = uniqueId;
    }

    /* renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHasNewFlag() {
        return this.hasNewFlag;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final NewInfo copy(int type, boolean hasNewFlag, String uniqueId) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        return new NewInfo(type, hasNewFlag, uniqueId);
    }

    public final boolean getHasNewFlag() {
        return this.hasNewFlag;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.type * 31;
        boolean z16 = this.hasNewFlag;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (i3 + i16) * 31;
        String str = this.uniqueId;
        return i17 + (str != null ? str.hashCode() : 0);
    }

    public final void setHasNewFlag(boolean z16) {
        this.hasNewFlag = z16;
    }

    public String toString() {
        return "NewInfo(type=" + this.type + ", hasNewFlag=" + this.hasNewFlag + ", uniqueId=" + this.uniqueId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewInfo)) {
            return false;
        }
        NewInfo newInfo = (NewInfo) other;
        return this.type == newInfo.type && this.hasNewFlag == newInfo.hasNewFlag && Intrinsics.areEqual(this.uniqueId, newInfo.uniqueId);
    }

    public static /* synthetic */ NewInfo copy$default(NewInfo newInfo, int i3, boolean z16, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = newInfo.type;
        }
        if ((i16 & 2) != 0) {
            z16 = newInfo.hasNewFlag;
        }
        if ((i16 & 4) != 0) {
            str = newInfo.uniqueId;
        }
        return newInfo.copy(i3, z16, str);
    }
}
