package com.tencent.state.square.guide;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\b\u0010!\u001a\u00020\u0007H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/square/guide/PublishStatusGuideConfig;", "", "alreadySetStatus", "", "pagDisplayNum", "", "statusPagUrl", "", "needEnlargeMap", "(ZJLjava/lang/String;Z)V", "getAlreadySetStatus", "()Z", "setAlreadySetStatus", "(Z)V", "getNeedEnlargeMap", "setNeedEnlargeMap", "getPagDisplayNum", "()J", "setPagDisplayNum", "(J)V", "getStatusPagUrl", "()Ljava/lang/String;", "setStatusPagUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class PublishStatusGuideConfig {
    private boolean alreadySetStatus;
    private boolean needEnlargeMap;
    private long pagDisplayNum;
    private String statusPagUrl;

    public PublishStatusGuideConfig() {
        this(false, 0L, null, false, 15, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getAlreadySetStatus() {
        return this.alreadySetStatus;
    }

    /* renamed from: component2, reason: from getter */
    public final long getPagDisplayNum() {
        return this.pagDisplayNum;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStatusPagUrl() {
        return this.statusPagUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getNeedEnlargeMap() {
        return this.needEnlargeMap;
    }

    public final PublishStatusGuideConfig copy(boolean alreadySetStatus, long pagDisplayNum, String statusPagUrl, boolean needEnlargeMap) {
        Intrinsics.checkNotNullParameter(statusPagUrl, "statusPagUrl");
        return new PublishStatusGuideConfig(alreadySetStatus, pagDisplayNum, statusPagUrl, needEnlargeMap);
    }

    public final boolean getAlreadySetStatus() {
        return this.alreadySetStatus;
    }

    public final boolean getNeedEnlargeMap() {
        return this.needEnlargeMap;
    }

    public final long getPagDisplayNum() {
        return this.pagDisplayNum;
    }

    public final String getStatusPagUrl() {
        return this.statusPagUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.alreadySetStatus;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int a16 = ((r06 * 31) + c.a(this.pagDisplayNum)) * 31;
        String str = this.statusPagUrl;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z17 = this.needEnlargeMap;
        return hashCode + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final void setAlreadySetStatus(boolean z16) {
        this.alreadySetStatus = z16;
    }

    public final void setNeedEnlargeMap(boolean z16) {
        this.needEnlargeMap = z16;
    }

    public final void setPagDisplayNum(long j3) {
        this.pagDisplayNum = j3;
    }

    public final void setStatusPagUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.statusPagUrl = str;
    }

    public String toString() {
        return '{' + this.alreadySetStatus + ", " + this.pagDisplayNum + ", " + this.statusPagUrl + ", " + this.needEnlargeMap + '}';
    }

    public PublishStatusGuideConfig(boolean z16, long j3, String statusPagUrl, boolean z17) {
        Intrinsics.checkNotNullParameter(statusPagUrl, "statusPagUrl");
        this.alreadySetStatus = z16;
        this.pagDisplayNum = j3;
        this.statusPagUrl = statusPagUrl;
        this.needEnlargeMap = z17;
    }

    public /* synthetic */ PublishStatusGuideConfig(boolean z16, long j3, String str, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? 1L : j3, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? false : z17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublishStatusGuideConfig)) {
            return false;
        }
        PublishStatusGuideConfig publishStatusGuideConfig = (PublishStatusGuideConfig) other;
        return this.alreadySetStatus == publishStatusGuideConfig.alreadySetStatus && this.pagDisplayNum == publishStatusGuideConfig.pagDisplayNum && Intrinsics.areEqual(this.statusPagUrl, publishStatusGuideConfig.statusPagUrl) && this.needEnlargeMap == publishStatusGuideConfig.needEnlargeMap;
    }

    public static /* synthetic */ PublishStatusGuideConfig copy$default(PublishStatusGuideConfig publishStatusGuideConfig, boolean z16, long j3, String str, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = publishStatusGuideConfig.alreadySetStatus;
        }
        if ((i3 & 2) != 0) {
            j3 = publishStatusGuideConfig.pagDisplayNum;
        }
        long j16 = j3;
        if ((i3 & 4) != 0) {
            str = publishStatusGuideConfig.statusPagUrl;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            z17 = publishStatusGuideConfig.needEnlargeMap;
        }
        return publishStatusGuideConfig.copy(z16, j16, str2, z17);
    }
}
