package com.tenpay.idverify.model;

import com.google.gson.annotations.SerializedName;
import com.tenpay.idverify.EnumIdVerifyState;
import com.tenpay.idverify.EnumIdVerifyStateRole;
import cooperation.qqcircle.report.QCircleQualityReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u00a8\u0006\u001f"}, d2 = {"Lcom/tenpay/idverify/model/IdVerifyStateBean;", "", "state", "", "stateTitle", "", "stateTip", "role", "(ILjava/lang/String;Ljava/lang/String;I)V", "getRole", "()I", "setRole", "(I)V", "getState", "getStateTip", "()Ljava/lang/String;", "getStateTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getRoleEnum", "Lcom/tenpay/idverify/EnumIdVerifyStateRole;", "getStateEnum", "Lcom/tenpay/idverify/EnumIdVerifyState;", "hashCode", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class IdVerifyStateBean {

    @SerializedName(QCircleQualityReporter.KEY_ID)
    private int role;

    @SerializedName("state")
    private final int state;

    @SerializedName("state_tip")
    @Nullable
    private final String stateTip;

    @SerializedName("state_title")
    @Nullable
    private final String stateTitle;

    public IdVerifyStateBean(int i3, @Nullable String str, @Nullable String str2, int i16) {
        this.state = i3;
        this.stateTitle = str;
        this.stateTip = str2;
        this.role = i16;
    }

    public static /* synthetic */ IdVerifyStateBean copy$default(IdVerifyStateBean idVerifyStateBean, int i3, String str, String str2, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = idVerifyStateBean.state;
        }
        if ((i17 & 2) != 0) {
            str = idVerifyStateBean.stateTitle;
        }
        if ((i17 & 4) != 0) {
            str2 = idVerifyStateBean.stateTip;
        }
        if ((i17 & 8) != 0) {
            i16 = idVerifyStateBean.role;
        }
        return idVerifyStateBean.copy(i3, str, str2, i16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getState() {
        return this.state;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getStateTitle() {
        return this.stateTitle;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getStateTip() {
        return this.stateTip;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRole() {
        return this.role;
    }

    @NotNull
    public final IdVerifyStateBean copy(int state, @Nullable String stateTitle, @Nullable String stateTip, int role) {
        return new IdVerifyStateBean(state, stateTitle, stateTip, role);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdVerifyStateBean)) {
            return false;
        }
        IdVerifyStateBean idVerifyStateBean = (IdVerifyStateBean) other;
        if (this.state == idVerifyStateBean.state && Intrinsics.areEqual(this.stateTitle, idVerifyStateBean.stateTitle) && Intrinsics.areEqual(this.stateTip, idVerifyStateBean.stateTip) && this.role == idVerifyStateBean.role) {
            return true;
        }
        return false;
    }

    public final int getRole() {
        return this.role;
    }

    @NotNull
    public final EnumIdVerifyStateRole getRoleEnum() {
        return EnumIdVerifyStateRole.INSTANCE.findByValue(this.role);
    }

    public final int getState() {
        return this.state;
    }

    @NotNull
    public final EnumIdVerifyState getStateEnum() {
        return EnumIdVerifyState.INSTANCE.findByValue(this.state);
    }

    @Nullable
    public final String getStateTip() {
        return this.stateTip;
    }

    @Nullable
    public final String getStateTitle() {
        return this.stateTitle;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.state * 31;
        String str = this.stateTitle;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        String str2 = this.stateTip;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return ((i17 + i16) * 31) + this.role;
    }

    public final void setRole(int i3) {
        this.role = i3;
    }

    @NotNull
    public String toString() {
        return "IdVerifyStateBean(state=" + this.state + ", stateTitle=" + this.stateTitle + ", stateTip=" + this.stateTip + ", role=" + this.role + ")";
    }

    public /* synthetic */ IdVerifyStateBean(int i3, String str, String str2, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? EnumIdVerifyState.NONE.ordinal() : i3, str, str2, (i17 & 8) != 0 ? EnumIdVerifyStateRole.INVITER.ordinal() : i16);
    }
}
