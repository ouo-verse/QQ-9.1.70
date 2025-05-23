package com.tencent.mobileqq.vas.qqmc;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/a;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "hashCode", "", "other", "", "equals", "enableDressKeyTrigger", "Z", "a", "()Z", "enableGuestUpload", "getEnableGuestUpload", "<init>", "(ZZ)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.qqmc.a, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class SquareFilamentCoverRecordConfigData implements IConfigData {

    @SerializedName("enableDressKeyTrigger")
    private final boolean enableDressKeyTrigger;

    @SerializedName("enableGuestUpload")
    private final boolean enableGuestUpload;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SquareFilamentCoverRecordConfigData() {
        this(r2, r2, 3, null);
        boolean z16 = false;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnableDressKeyTrigger() {
        return this.enableDressKeyTrigger;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.enableDressKeyTrigger;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        boolean z17 = this.enableGuestUpload;
        return i3 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public String toString() {
        return "SquareFilamentCoverRecordConfigData(enableDressKeyTrigger=" + this.enableDressKeyTrigger + ", enableGuestUpload=" + this.enableGuestUpload + ")";
    }

    public SquareFilamentCoverRecordConfigData(boolean z16, boolean z17) {
        this.enableDressKeyTrigger = z16;
        this.enableGuestUpload = z17;
    }

    public /* synthetic */ SquareFilamentCoverRecordConfigData(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareFilamentCoverRecordConfigData)) {
            return false;
        }
        SquareFilamentCoverRecordConfigData squareFilamentCoverRecordConfigData = (SquareFilamentCoverRecordConfigData) other;
        return this.enableDressKeyTrigger == squareFilamentCoverRecordConfigData.enableDressKeyTrigger && this.enableGuestUpload == squareFilamentCoverRecordConfigData.enableGuestUpload;
    }
}
