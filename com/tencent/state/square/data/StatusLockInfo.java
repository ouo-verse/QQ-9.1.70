package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/data/StatusLockInfo;", "", "lockStatus", "", "tip", "", "buttonText", "linkUrl", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonText", "()Ljava/lang/String;", "getLinkUrl", "getLockStatus", "()I", "getTip", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class StatusLockInfo {
    private final String buttonText;
    private final String linkUrl;
    private final int lockStatus;
    private final String tip;

    public StatusLockInfo(int i3, String tip, String buttonText, String linkUrl) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(linkUrl, "linkUrl");
        this.lockStatus = i3;
        this.tip = tip;
        this.buttonText = buttonText;
        this.linkUrl = linkUrl;
    }

    /* renamed from: component1, reason: from getter */
    public final int getLockStatus() {
        return this.lockStatus;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTip() {
        return this.tip;
    }

    /* renamed from: component3, reason: from getter */
    public final String getButtonText() {
        return this.buttonText;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final StatusLockInfo copy(int lockStatus, String tip, String buttonText, String linkUrl) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(linkUrl, "linkUrl");
        return new StatusLockInfo(lockStatus, tip, buttonText, linkUrl);
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final int getLockStatus() {
        return this.lockStatus;
    }

    public final String getTip() {
        return this.tip;
    }

    public int hashCode() {
        int i3 = this.lockStatus * 31;
        String str = this.tip;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.buttonText;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.linkUrl;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "StatusLockInfo(lockStatus=" + this.lockStatus + ", tip=" + this.tip + ", buttonText=" + this.buttonText + ", linkUrl=" + this.linkUrl + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatusLockInfo)) {
            return false;
        }
        StatusLockInfo statusLockInfo = (StatusLockInfo) other;
        return this.lockStatus == statusLockInfo.lockStatus && Intrinsics.areEqual(this.tip, statusLockInfo.tip) && Intrinsics.areEqual(this.buttonText, statusLockInfo.buttonText) && Intrinsics.areEqual(this.linkUrl, statusLockInfo.linkUrl);
    }

    public static /* synthetic */ StatusLockInfo copy$default(StatusLockInfo statusLockInfo, int i3, String str, String str2, String str3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = statusLockInfo.lockStatus;
        }
        if ((i16 & 2) != 0) {
            str = statusLockInfo.tip;
        }
        if ((i16 & 4) != 0) {
            str2 = statusLockInfo.buttonText;
        }
        if ((i16 & 8) != 0) {
            str3 = statusLockInfo.linkUrl;
        }
        return statusLockInfo.copy(i3, str, str2, str3);
    }
}
