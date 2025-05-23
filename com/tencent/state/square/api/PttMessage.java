package com.tencent.state.square.api;

import androidx.fragment.app.a;
import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/api/PttMessage;", "", "uin", "", AppConstants.Key.COLUMN_MSG_UID, "", "msgTimeStamp", "(Ljava/lang/String;JJ)V", "getMsgTimeStamp", "()J", "getMsgUid", "getUin", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class PttMessage {
    private final long msgTimeStamp;
    private final long msgUid;

    @NotNull
    private final String uin;

    public PttMessage(@NotNull String uin, long j3, long j16) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.msgUid = j3;
        this.msgTimeStamp = j16;
    }

    public static /* synthetic */ PttMessage copy$default(PttMessage pttMessage, String str, long j3, long j16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = pttMessage.uin;
        }
        if ((i3 & 2) != 0) {
            j3 = pttMessage.msgUid;
        }
        long j17 = j3;
        if ((i3 & 4) != 0) {
            j16 = pttMessage.msgTimeStamp;
        }
        return pttMessage.copy(str, j17, j16);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMsgUid() {
        return this.msgUid;
    }

    /* renamed from: component3, reason: from getter */
    public final long getMsgTimeStamp() {
        return this.msgTimeStamp;
    }

    @NotNull
    public final PttMessage copy(@NotNull String uin, long msgUid, long msgTimeStamp) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return new PttMessage(uin, msgUid, msgTimeStamp);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PttMessage) {
                PttMessage pttMessage = (PttMessage) other;
                if (!Intrinsics.areEqual(this.uin, pttMessage.uin) || this.msgUid != pttMessage.msgUid || this.msgTimeStamp != pttMessage.msgTimeStamp) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getMsgTimeStamp() {
        return this.msgTimeStamp;
    }

    public final long getMsgUid() {
        return this.msgUid;
    }

    @NotNull
    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        int i3;
        String str = this.uin;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return (((i3 * 31) + a.a(this.msgUid)) * 31) + a.a(this.msgTimeStamp);
    }

    @NotNull
    public String toString() {
        return "PttMessage(uin=" + this.uin + ", msgUid=" + this.msgUid + ", msgTimeStamp=" + this.msgTimeStamp + ")";
    }
}
