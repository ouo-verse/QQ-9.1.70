package com.tencent.state.template.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J5\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/template/data/CommonHippyInfo;", "", "bundleName", "", "domainName", "isHalfScreen", "", "speedUp", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getBundleName", "()Ljava/lang/String;", "getDomainName", "()Z", "getSpeedUp", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class CommonHippyInfo {
    private final String bundleName;
    private final String domainName;
    private final boolean isHalfScreen;
    private final boolean speedUp;

    public CommonHippyInfo(String str, String str2, boolean z16, boolean z17) {
        this.bundleName = str;
        this.domainName = str2;
        this.isHalfScreen = z16;
        this.speedUp = z17;
    }

    /* renamed from: component1, reason: from getter */
    public final String getBundleName() {
        return this.bundleName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDomainName() {
        return this.domainName;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsHalfScreen() {
        return this.isHalfScreen;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getSpeedUp() {
        return this.speedUp;
    }

    public final CommonHippyInfo copy(String bundleName, String domainName, boolean isHalfScreen, boolean speedUp) {
        return new CommonHippyInfo(bundleName, domainName, isHalfScreen, speedUp);
    }

    public final String getBundleName() {
        return this.bundleName;
    }

    public final String getDomainName() {
        return this.domainName;
    }

    public final boolean getSpeedUp() {
        return this.speedUp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.bundleName;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.domainName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z16 = this.isHalfScreen;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        boolean z17 = this.speedUp;
        return i16 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final boolean isHalfScreen() {
        return this.isHalfScreen;
    }

    public String toString() {
        return "CommonHippyInfo(bundleName=" + this.bundleName + ", domainName=" + this.domainName + ", isHalfScreen=" + this.isHalfScreen + ", speedUp=" + this.speedUp + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonHippyInfo)) {
            return false;
        }
        CommonHippyInfo commonHippyInfo = (CommonHippyInfo) other;
        return Intrinsics.areEqual(this.bundleName, commonHippyInfo.bundleName) && Intrinsics.areEqual(this.domainName, commonHippyInfo.domainName) && this.isHalfScreen == commonHippyInfo.isHalfScreen && this.speedUp == commonHippyInfo.speedUp;
    }

    public static /* synthetic */ CommonHippyInfo copy$default(CommonHippyInfo commonHippyInfo, String str, String str2, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = commonHippyInfo.bundleName;
        }
        if ((i3 & 2) != 0) {
            str2 = commonHippyInfo.domainName;
        }
        if ((i3 & 4) != 0) {
            z16 = commonHippyInfo.isHalfScreen;
        }
        if ((i3 & 8) != 0) {
            z17 = commonHippyInfo.speedUp;
        }
        return commonHippyInfo.copy(str, str2, z16, z17);
    }
}
