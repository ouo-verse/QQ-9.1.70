package com.tencent.state.square.interaction;

import com.tencent.mobileqq.vas.banner.c;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import pt4.o;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u00a2\u0006\u0004\b9\u0010:B\u0011\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u00a2\u0006\u0004\b9\u0010=J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\nH\u00c6\u0003J\t\u0010\f\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u000fH\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u000fH\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\u008b\u0001\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u0005H\u00c6\u0001J\t\u0010!\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\"\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010$\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b(\u0010'R\u0017\u0010\u0015\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b,\u0010'R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b-\u0010'R\u0017\u0010\u0018\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b.\u0010+R\u0017\u0010\u0019\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b\u0019\u00100R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b1\u0010'R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010%\u001a\u0004\b2\u0010'R\u0017\u0010\u001c\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\b3\u0010+R\u0017\u0010\u001d\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u00104\u001a\u0004\b5\u00106R\u0017\u0010\u001e\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b7\u00106R\u0017\u0010\u001f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010)\u001a\u0004\b8\u0010+\u00a8\u0006>"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionRecordInfo;", "", "", "component1", "component2", "", "component3", "component4", "component5", "component6", "", "component7", "component8", "component9", "component10", "", "component11", "component12", "component13", "statusIcon", "statusTitle", "uin", "nick", "head", "optionId", "isCritical", "contentIcon", "contentText", "time", "status", "richStatus", "itemId", "copy", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "getStatusIcon", "()Ljava/lang/String;", "getStatusTitle", "J", "getUin", "()J", "getNick", "getHead", "getOptionId", "Z", "()Z", "getContentIcon", "getContentText", "getTime", "I", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()I", "getRichStatus", "getItemId", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;JIIJ)V", "Lpt4/o;", "pb", "(Lpt4/o;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionRecordInfo {
    private final String contentIcon;
    private final String contentText;
    private final String head;
    private final boolean isCritical;
    private final long itemId;
    private final String nick;
    private final long optionId;
    private final int richStatus;
    private final int status;
    private final String statusIcon;
    private final String statusTitle;
    private final long time;
    private final long uin;

    public InteractionRecordInfo(String statusIcon, String statusTitle, long j3, String nick, String head, long j16, boolean z16, String contentIcon, String contentText, long j17, int i3, int i16, long j18) {
        Intrinsics.checkNotNullParameter(statusIcon, "statusIcon");
        Intrinsics.checkNotNullParameter(statusTitle, "statusTitle");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(contentIcon, "contentIcon");
        Intrinsics.checkNotNullParameter(contentText, "contentText");
        this.statusIcon = statusIcon;
        this.statusTitle = statusTitle;
        this.uin = j3;
        this.nick = nick;
        this.head = head;
        this.optionId = j16;
        this.isCritical = z16;
        this.contentIcon = contentIcon;
        this.contentText = contentText;
        this.time = j17;
        this.status = i3;
        this.richStatus = i16;
        this.itemId = j18;
    }

    /* renamed from: component1, reason: from getter */
    public final String getStatusIcon() {
        return this.statusIcon;
    }

    /* renamed from: component10, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    /* renamed from: component11, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component12, reason: from getter */
    public final int getRichStatus() {
        return this.richStatus;
    }

    /* renamed from: component13, reason: from getter */
    public final long getItemId() {
        return this.itemId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStatusTitle() {
        return this.statusTitle;
    }

    /* renamed from: component3, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component5, reason: from getter */
    public final String getHead() {
        return this.head;
    }

    /* renamed from: component6, reason: from getter */
    public final long getOptionId() {
        return this.optionId;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsCritical() {
        return this.isCritical;
    }

    /* renamed from: component8, reason: from getter */
    public final String getContentIcon() {
        return this.contentIcon;
    }

    /* renamed from: component9, reason: from getter */
    public final String getContentText() {
        return this.contentText;
    }

    public final String getContentIcon() {
        return this.contentIcon;
    }

    public final String getContentText() {
        return this.contentText;
    }

    public final String getHead() {
        return this.head;
    }

    public final long getItemId() {
        return this.itemId;
    }

    public final String getNick() {
        return this.nick;
    }

    public final long getOptionId() {
        return this.optionId;
    }

    public final int getRichStatus() {
        return this.richStatus;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getStatusIcon() {
        return this.statusIcon;
    }

    public final String getStatusTitle() {
        return this.statusTitle;
    }

    public final long getTime() {
        return this.time;
    }

    public final long getUin() {
        return this.uin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.statusIcon;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.statusTitle;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + c.a(this.uin)) * 31;
        String str3 = this.nick;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.head;
        int hashCode4 = (((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + c.a(this.optionId)) * 31;
        boolean z16 = this.isCritical;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode4 + i3) * 31;
        String str5 = this.contentIcon;
        int hashCode5 = (i16 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.contentText;
        return ((((((((hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31) + c.a(this.time)) * 31) + this.status) * 31) + this.richStatus) * 31) + c.a(this.itemId);
    }

    public final boolean isCritical() {
        return this.isCritical;
    }

    public String toString() {
        return "InteractionRecordInfo(statusIcon=" + this.statusIcon + ", statusTitle=" + this.statusTitle + ", uin=" + this.uin + ", nick=" + this.nick + ", head=" + this.head + ", optionId=" + this.optionId + ", isCritical=" + this.isCritical + ", contentIcon=" + this.contentIcon + ", contentText=" + this.contentText + ", time=" + this.time + ", status=" + this.status + ", richStatus=" + this.richStatus + ", itemId=" + this.itemId + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InteractionRecordInfo(o pb5) {
        this(r3, r4, r4, r8, r8, r8, r10, r12, r13, pb5.f427204l, pb5.f427193a, pb5.f427194b, pb5.f427205m);
        Intrinsics.checkNotNullParameter(pb5, "pb");
        String str = pb5.f427195c;
        Intrinsics.checkNotNullExpressionValue(str, "pb.statusIcon");
        String str2 = pb5.f427196d;
        Intrinsics.checkNotNullExpressionValue(str2, "pb.statusTitle");
        long j3 = pb5.f427197e;
        byte[] bArr = pb5.f427198f;
        Intrinsics.checkNotNullExpressionValue(bArr, "pb.nick");
        String str3 = new String(bArr, Charsets.UTF_8);
        String str4 = pb5.f427199g;
        Intrinsics.checkNotNullExpressionValue(str4, "pb.head");
        long j16 = pb5.f427200h;
        boolean z16 = pb5.f427201i;
        String str5 = pb5.f427202j;
        Intrinsics.checkNotNullExpressionValue(str5, "pb.icon");
        String str6 = pb5.f427203k;
        Intrinsics.checkNotNullExpressionValue(str6, "pb.text");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionRecordInfo)) {
            return false;
        }
        InteractionRecordInfo interactionRecordInfo = (InteractionRecordInfo) other;
        return Intrinsics.areEqual(this.statusIcon, interactionRecordInfo.statusIcon) && Intrinsics.areEqual(this.statusTitle, interactionRecordInfo.statusTitle) && this.uin == interactionRecordInfo.uin && Intrinsics.areEqual(this.nick, interactionRecordInfo.nick) && Intrinsics.areEqual(this.head, interactionRecordInfo.head) && this.optionId == interactionRecordInfo.optionId && this.isCritical == interactionRecordInfo.isCritical && Intrinsics.areEqual(this.contentIcon, interactionRecordInfo.contentIcon) && Intrinsics.areEqual(this.contentText, interactionRecordInfo.contentText) && this.time == interactionRecordInfo.time && this.status == interactionRecordInfo.status && this.richStatus == interactionRecordInfo.richStatus && this.itemId == interactionRecordInfo.itemId;
    }

    public final InteractionRecordInfo copy(String statusIcon, String statusTitle, long uin, String nick, String head, long optionId, boolean isCritical, String contentIcon, String contentText, long time, int status, int richStatus, long itemId) {
        Intrinsics.checkNotNullParameter(statusIcon, "statusIcon");
        Intrinsics.checkNotNullParameter(statusTitle, "statusTitle");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(contentIcon, "contentIcon");
        Intrinsics.checkNotNullParameter(contentText, "contentText");
        return new InteractionRecordInfo(statusIcon, statusTitle, uin, nick, head, optionId, isCritical, contentIcon, contentText, time, status, richStatus, itemId);
    }
}
