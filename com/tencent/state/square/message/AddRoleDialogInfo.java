package com.tencent.state.square.message;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001J\u0006\u0010\u0019\u001a\u00020\u0016J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\t\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/square/message/AddRoleDialogInfo;", "", "uin", "", "type", "", "name", "(Ljava/lang/String;ILjava/lang/String;)V", "getName", "()Ljava/lang/String;", "reportEvent", "getReportEvent", "setReportEvent", "(Ljava/lang/String;)V", "getType", "()I", "getUin", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "isTroop", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class AddRoleDialogInfo {
    private final String name;
    private String reportEvent;
    private final int type;
    private final String uin;

    public AddRoleDialogInfo(String uin, int i3, String name) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(name, "name");
        this.uin = uin;
        this.type = i3;
        this.name = name;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final AddRoleDialogInfo copy(String uin, int type, String name) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(name, "name");
        return new AddRoleDialogInfo(uin, type, name);
    }

    public final String getName() {
        return this.name;
    }

    public final String getReportEvent() {
        return this.reportEvent;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        String str = this.uin;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.type) * 31;
        String str2 = this.name;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final boolean isTroop() {
        return this.type == 4;
    }

    public final void setReportEvent(String str) {
        this.reportEvent = str;
    }

    public String toString() {
        return "AddRoleDialogInfo(uin=" + this.uin + ", type=" + this.type + ", name=" + this.name + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddRoleDialogInfo)) {
            return false;
        }
        AddRoleDialogInfo addRoleDialogInfo = (AddRoleDialogInfo) other;
        return Intrinsics.areEqual(this.uin, addRoleDialogInfo.uin) && this.type == addRoleDialogInfo.type && Intrinsics.areEqual(this.name, addRoleDialogInfo.name);
    }

    public static /* synthetic */ AddRoleDialogInfo copy$default(AddRoleDialogInfo addRoleDialogInfo, String str, int i3, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = addRoleDialogInfo.uin;
        }
        if ((i16 & 2) != 0) {
            i3 = addRoleDialogInfo.type;
        }
        if ((i16 & 4) != 0) {
            str2 = addRoleDialogInfo.name;
        }
        return addRoleDialogInfo.copy(str, i3, str2);
    }
}
