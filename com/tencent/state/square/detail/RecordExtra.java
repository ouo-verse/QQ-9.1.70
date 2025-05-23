package com.tencent.state.square.detail;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.state.square.data.OnlineStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/detail/RecordExtra;", "", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "uin", "", "(Lcom/tencent/state/square/data/OnlineStatus;Ljava/lang/String;)V", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Lcom/tencent/state/square/data/OnlineStatus;", "getUin", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class RecordExtra {
    private final OnlineStatus status;
    private final String uin;

    public RecordExtra(OnlineStatus onlineStatus, String str) {
        this.status = onlineStatus;
        this.uin = str;
    }

    /* renamed from: component1, reason: from getter */
    public final OnlineStatus getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public final RecordExtra copy(OnlineStatus status, String uin) {
        return new RecordExtra(status, uin);
    }

    public final OnlineStatus getStatus() {
        return this.status;
    }

    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        OnlineStatus onlineStatus = this.status;
        int hashCode = (onlineStatus != null ? onlineStatus.hashCode() : 0) * 31;
        String str = this.uin;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "RecordExtra(status=" + this.status + ", uin=" + this.uin + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecordExtra)) {
            return false;
        }
        RecordExtra recordExtra = (RecordExtra) other;
        return Intrinsics.areEqual(this.status, recordExtra.status) && Intrinsics.areEqual(this.uin, recordExtra.uin);
    }

    public static /* synthetic */ RecordExtra copy$default(RecordExtra recordExtra, OnlineStatus onlineStatus, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            onlineStatus = recordExtra.status;
        }
        if ((i3 & 2) != 0) {
            str = recordExtra.uin;
        }
        return recordExtra.copy(onlineStatus, str);
    }
}
