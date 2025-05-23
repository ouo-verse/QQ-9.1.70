package com.tencent.state.common.record;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JM\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/common/record/RecordData;", "", "uin", "", "nick", PhotoCategorySummaryInfo.AVATAR_URL, PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "recordType", "", "text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getNick", "getRecordType", "()I", "getText", "getTimeStamp", "getUin", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class RecordData {
    private final String avatarUrl;
    private final String nick;
    private final int recordType;
    private final String text;
    private final String timeStamp;
    private final String uin;

    public RecordData(String uin, String str, String str2, String str3, int i3, String str4) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.nick = str;
        this.avatarUrl = str2;
        this.timeStamp = str3;
        this.recordType = i3;
        this.text = str4;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTimeStamp() {
        return this.timeStamp;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRecordType() {
        return this.recordType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final RecordData copy(String uin, String nick, String avatarUrl, String timeStamp, int recordType, String text) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return new RecordData(uin, nick, avatarUrl, timeStamp, recordType, text);
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getNick() {
        return this.nick;
    }

    public final int getRecordType() {
        return this.recordType;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTimeStamp() {
        return this.timeStamp;
    }

    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        String str = this.uin;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nick;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.avatarUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.timeStamp;
        int hashCode4 = (((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.recordType) * 31;
        String str5 = this.text;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "RecordData(uin=" + this.uin + ", nick=" + this.nick + ", avatarUrl=" + this.avatarUrl + ", timeStamp=" + this.timeStamp + ", recordType=" + this.recordType + ", text=" + this.text + ")";
    }

    public /* synthetic */ RecordData(String str, String str2, String str3, String str4, int i3, String str5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? "" : str3, (i16 & 8) != 0 ? "" : str4, (i16 & 16) != 0 ? 0 : i3, (i16 & 32) == 0 ? str5 : "");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecordData)) {
            return false;
        }
        RecordData recordData = (RecordData) other;
        return Intrinsics.areEqual(this.uin, recordData.uin) && Intrinsics.areEqual(this.nick, recordData.nick) && Intrinsics.areEqual(this.avatarUrl, recordData.avatarUrl) && Intrinsics.areEqual(this.timeStamp, recordData.timeStamp) && this.recordType == recordData.recordType && Intrinsics.areEqual(this.text, recordData.text);
    }

    public static /* synthetic */ RecordData copy$default(RecordData recordData, String str, String str2, String str3, String str4, int i3, String str5, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = recordData.uin;
        }
        if ((i16 & 2) != 0) {
            str2 = recordData.nick;
        }
        String str6 = str2;
        if ((i16 & 4) != 0) {
            str3 = recordData.avatarUrl;
        }
        String str7 = str3;
        if ((i16 & 8) != 0) {
            str4 = recordData.timeStamp;
        }
        String str8 = str4;
        if ((i16 & 16) != 0) {
            i3 = recordData.recordType;
        }
        int i17 = i3;
        if ((i16 & 32) != 0) {
            str5 = recordData.text;
        }
        return recordData.copy(str, str6, str7, str8, i17, str5);
    }
}
