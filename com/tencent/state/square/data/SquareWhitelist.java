package com.tencent.state.square.data;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/data/SquareWhitelist;", "", "status", "", "showDialog", "dialogInfo", "Lcom/tencent/state/square/data/SquareWhiteListDialogInfo;", "(ZZLcom/tencent/state/square/data/SquareWhiteListDialogInfo;)V", "getDialogInfo", "()Lcom/tencent/state/square/data/SquareWhiteListDialogInfo;", "getShowDialog", "()Z", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareWhitelist {
    private final SquareWhiteListDialogInfo dialogInfo;
    private final boolean showDialog;
    private final boolean status;

    public SquareWhitelist() {
        this(false, false, null, 7, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getShowDialog() {
        return this.showDialog;
    }

    /* renamed from: component3, reason: from getter */
    public final SquareWhiteListDialogInfo getDialogInfo() {
        return this.dialogInfo;
    }

    public final SquareWhitelist copy(boolean status, boolean showDialog, SquareWhiteListDialogInfo dialogInfo) {
        Intrinsics.checkNotNullParameter(dialogInfo, "dialogInfo");
        return new SquareWhitelist(status, showDialog, dialogInfo);
    }

    public final SquareWhiteListDialogInfo getDialogInfo() {
        return this.dialogInfo;
    }

    public final boolean getShowDialog() {
        return this.showDialog;
    }

    public final boolean getStatus() {
        return this.status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.status;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        boolean z17 = this.showDialog;
        int i16 = (i3 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
        SquareWhiteListDialogInfo squareWhiteListDialogInfo = this.dialogInfo;
        return i16 + (squareWhiteListDialogInfo != null ? squareWhiteListDialogInfo.hashCode() : 0);
    }

    public String toString() {
        return "SquareWhitelist(status=" + this.status + ", showDialog=" + this.showDialog + ", dialogInfo=" + this.dialogInfo + ")";
    }

    public SquareWhitelist(boolean z16, boolean z17, SquareWhiteListDialogInfo dialogInfo) {
        Intrinsics.checkNotNullParameter(dialogInfo, "dialogInfo");
        this.status = z16;
        this.showDialog = z17;
        this.dialogInfo = dialogInfo;
    }

    public /* synthetic */ SquareWhitelist(boolean z16, boolean z17, SquareWhiteListDialogInfo squareWhiteListDialogInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? new SquareWhiteListDialogInfo(null, null, null, 7, null) : squareWhiteListDialogInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareWhitelist)) {
            return false;
        }
        SquareWhitelist squareWhitelist = (SquareWhitelist) other;
        return this.status == squareWhitelist.status && this.showDialog == squareWhitelist.showDialog && Intrinsics.areEqual(this.dialogInfo, squareWhitelist.dialogInfo);
    }

    public static /* synthetic */ SquareWhitelist copy$default(SquareWhitelist squareWhitelist, boolean z16, boolean z17, SquareWhiteListDialogInfo squareWhiteListDialogInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = squareWhitelist.status;
        }
        if ((i3 & 2) != 0) {
            z17 = squareWhitelist.showDialog;
        }
        if ((i3 & 4) != 0) {
            squareWhiteListDialogInfo = squareWhitelist.dialogInfo;
        }
        return squareWhitelist.copy(z16, z17, squareWhiteListDialogInfo);
    }
}
