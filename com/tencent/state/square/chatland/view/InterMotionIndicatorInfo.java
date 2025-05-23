package com.tencent.state.square.chatland.view;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.state.template.data.InteractionMotionState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/square/chatland/view/InterMotionIndicatorInfo;", "", "status", "Lcom/tencent/state/template/data/InteractionMotionState;", "billNo", "", "tips", "countdown", "", "(Lcom/tencent/state/template/data/InteractionMotionState;Ljava/lang/String;Ljava/lang/String;I)V", "getBillNo", "()Ljava/lang/String;", "getCountdown", "()I", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Lcom/tencent/state/template/data/InteractionMotionState;", "getTips", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InterMotionIndicatorInfo {
    private final String billNo;
    private final int countdown;
    private final InteractionMotionState status;
    private final String tips;

    public InterMotionIndicatorInfo(InteractionMotionState status, String billNo, String tips, int i3) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(tips, "tips");
        this.status = status;
        this.billNo = billNo;
        this.tips = tips;
        this.countdown = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final InteractionMotionState getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBillNo() {
        return this.billNo;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTips() {
        return this.tips;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCountdown() {
        return this.countdown;
    }

    public final InterMotionIndicatorInfo copy(InteractionMotionState status, String billNo, String tips, int countdown) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(tips, "tips");
        return new InterMotionIndicatorInfo(status, billNo, tips, countdown);
    }

    public final String getBillNo() {
        return this.billNo;
    }

    public final int getCountdown() {
        return this.countdown;
    }

    public final InteractionMotionState getStatus() {
        return this.status;
    }

    public final String getTips() {
        return this.tips;
    }

    public int hashCode() {
        InteractionMotionState interactionMotionState = this.status;
        int hashCode = (interactionMotionState != null ? interactionMotionState.hashCode() : 0) * 31;
        String str = this.billNo;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.tips;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.countdown;
    }

    public String toString() {
        return "InterMotionIndicatorInfo(status=" + this.status + ", billNo=" + this.billNo + ", tips=" + this.tips + ", countdown=" + this.countdown + ")";
    }

    public /* synthetic */ InterMotionIndicatorInfo(InteractionMotionState interactionMotionState, String str, String str2, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionMotionState, str, str2, (i16 & 8) != 0 ? 0 : i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InterMotionIndicatorInfo)) {
            return false;
        }
        InterMotionIndicatorInfo interMotionIndicatorInfo = (InterMotionIndicatorInfo) other;
        return Intrinsics.areEqual(this.status, interMotionIndicatorInfo.status) && Intrinsics.areEqual(this.billNo, interMotionIndicatorInfo.billNo) && Intrinsics.areEqual(this.tips, interMotionIndicatorInfo.tips) && this.countdown == interMotionIndicatorInfo.countdown;
    }

    public static /* synthetic */ InterMotionIndicatorInfo copy$default(InterMotionIndicatorInfo interMotionIndicatorInfo, InteractionMotionState interactionMotionState, String str, String str2, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            interactionMotionState = interMotionIndicatorInfo.status;
        }
        if ((i16 & 2) != 0) {
            str = interMotionIndicatorInfo.billNo;
        }
        if ((i16 & 4) != 0) {
            str2 = interMotionIndicatorInfo.tips;
        }
        if ((i16 & 8) != 0) {
            i3 = interMotionIndicatorInfo.countdown;
        }
        return interMotionIndicatorInfo.copy(interactionMotionState, str, str2, i3);
    }
}
