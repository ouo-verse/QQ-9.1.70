package com.tencent.state.square.interaction.record;

import com.tencent.mobileqq.vas.banner.c;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.state.square.interaction.InteractionRecordInfo;
import com.tencent.state.utils.TimeFormatUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b2\b\u0086\b\u0018\u00002\u00020\u0001B5\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rB\u0083\u0001\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\u001aJ\t\u0010-\u001a\u00020\u000fH\u00c6\u0003J\t\u0010.\u001a\u00020\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\fH\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0007H\u00c6\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\t\u00103\u001a\u00020\fH\u00c6\u0003J\t\u00104\u001a\u00020\u0007H\u00c6\u0003J\t\u00105\u001a\u00020\u0007H\u00c6\u0003J\t\u00106\u001a\u00020\u0005H\u00c6\u0003J\t\u00107\u001a\u00020\u0005H\u00c6\u0003J\t\u00108\u001a\u00020\u0005H\u00c6\u0003J\t\u00109\u001a\u00020\u0005H\u00c6\u0003J\t\u0010:\u001a\u00020\u0005H\u00c6\u0003J\t\u0010;\u001a\u00020\u0005H\u00c6\u0003J\u00a5\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010=\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010?\u001a\u00020\u0007H\u00d6\u0001J\t\u0010@\u001a\u00020\u0005H\u00d6\u0001R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0017\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u0018\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\u0019\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010$R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010$R\u0011\u0010\u0015\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0011\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0011\u0010\u0013\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0011\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,\u00a8\u0006A"}, d2 = {"Lcom/tencent/state/square/interaction/record/InteractionRecordData;", "", "info", "Lcom/tencent/state/square/interaction/InteractionRecordInfo;", "actionString", "", "actionIcon", "", "action", "Lkotlin/Function0;", "", "isInSquare", "", "(Lcom/tencent/state/square/interaction/InteractionRecordInfo;Ljava/lang/String;ILkotlin/jvm/functions/Function0;Z)V", "uin", "", "status", "richStatus", "statusIcon", "statusTitle", "header", "name", "time", "content", "contentIcon", "isCritical", "(JIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ILkotlin/jvm/functions/Function0;Z)V", "getAction", "()Lkotlin/jvm/functions/Function0;", "getActionIcon", "()I", "getActionString", "()Ljava/lang/String;", "getContent", "getContentIcon", "getHeader", "()Z", "getName", "getRichStatus", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "getStatusIcon", "getStatusTitle", "getTime", "getUin", "()J", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionRecordData {
    private final Function0<Unit> action;
    private final int actionIcon;
    private final String actionString;
    private final String content;
    private final String contentIcon;
    private final String header;
    private final boolean isCritical;
    private final boolean isInSquare;
    private final String name;
    private final int richStatus;
    private final int status;
    private final String statusIcon;
    private final String statusTitle;
    private final String time;
    private final long uin;

    public InteractionRecordData(long j3, int i3, int i16, String statusIcon, String statusTitle, String header, String name, String time, String content, String contentIcon, boolean z16, String actionString, int i17, Function0<Unit> action, boolean z17) {
        Intrinsics.checkNotNullParameter(statusIcon, "statusIcon");
        Intrinsics.checkNotNullParameter(statusTitle, "statusTitle");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(contentIcon, "contentIcon");
        Intrinsics.checkNotNullParameter(actionString, "actionString");
        Intrinsics.checkNotNullParameter(action, "action");
        this.uin = j3;
        this.status = i3;
        this.richStatus = i16;
        this.statusIcon = statusIcon;
        this.statusTitle = statusTitle;
        this.header = header;
        this.name = name;
        this.time = time;
        this.content = content;
        this.contentIcon = contentIcon;
        this.isCritical = z16;
        this.actionString = actionString;
        this.actionIcon = i17;
        this.action = action;
        this.isInSquare = z17;
    }

    /* renamed from: component1, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    /* renamed from: component10, reason: from getter */
    public final String getContentIcon() {
        return this.contentIcon;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsCritical() {
        return this.isCritical;
    }

    /* renamed from: component12, reason: from getter */
    public final String getActionString() {
        return this.actionString;
    }

    /* renamed from: component13, reason: from getter */
    public final int getActionIcon() {
        return this.actionIcon;
    }

    public final Function0<Unit> component14() {
        return this.action;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getIsInSquare() {
        return this.isInSquare;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRichStatus() {
        return this.richStatus;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStatusIcon() {
        return this.statusIcon;
    }

    /* renamed from: component5, reason: from getter */
    public final String getStatusTitle() {
        return this.statusTitle;
    }

    /* renamed from: component6, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    /* renamed from: component7, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    /* renamed from: component9, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final InteractionRecordData copy(long uin, int status, int richStatus, String statusIcon, String statusTitle, String header, String name, String time, String content, String contentIcon, boolean isCritical, String actionString, int actionIcon, Function0<Unit> action, boolean isInSquare) {
        Intrinsics.checkNotNullParameter(statusIcon, "statusIcon");
        Intrinsics.checkNotNullParameter(statusTitle, "statusTitle");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(contentIcon, "contentIcon");
        Intrinsics.checkNotNullParameter(actionString, "actionString");
        Intrinsics.checkNotNullParameter(action, "action");
        return new InteractionRecordData(uin, status, richStatus, statusIcon, statusTitle, header, name, time, content, contentIcon, isCritical, actionString, actionIcon, action, isInSquare);
    }

    public final Function0<Unit> getAction() {
        return this.action;
    }

    public final int getActionIcon() {
        return this.actionIcon;
    }

    public final String getActionString() {
        return this.actionString;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getContentIcon() {
        return this.contentIcon;
    }

    public final String getHeader() {
        return this.header;
    }

    public final String getName() {
        return this.name;
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

    public final String getTime() {
        return this.time;
    }

    public final long getUin() {
        return this.uin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((((c.a(this.uin) * 31) + this.status) * 31) + this.richStatus) * 31;
        String str = this.statusIcon;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.statusTitle;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.header;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.name;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.time;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.content;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.contentIcon;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        boolean z16 = this.isCritical;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode7 + i3) * 31;
        String str8 = this.actionString;
        int hashCode8 = (((i16 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.actionIcon) * 31;
        Function0<Unit> function0 = this.action;
        int hashCode9 = (hashCode8 + (function0 != null ? function0.hashCode() : 0)) * 31;
        boolean z17 = this.isInSquare;
        return hashCode9 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final boolean isCritical() {
        return this.isCritical;
    }

    public final boolean isInSquare() {
        return this.isInSquare;
    }

    public String toString() {
        return "InteractionRecordData(uin=" + this.uin + ", status=" + this.status + ", richStatus=" + this.richStatus + ", statusIcon=" + this.statusIcon + ", statusTitle=" + this.statusTitle + ", header=" + this.header + ", name=" + this.name + ", time=" + this.time + ", content=" + this.content + ", contentIcon=" + this.contentIcon + ", isCritical=" + this.isCritical + ", actionString=" + this.actionString + ", actionIcon=" + this.actionIcon + ", action=" + this.action + ", isInSquare=" + this.isInSquare + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InteractionRecordData(InteractionRecordInfo info, String actionString, int i3, Function0<Unit> action, boolean z16) {
        this(info.getUin(), info.getStatus(), info.getRichStatus(), info.getStatusIcon(), info.getStatusTitle(), info.getHead(), info.getNick(), TimeFormatUtils.INSTANCE.formatInteractionTime(info.getTime()), info.getContentText(), info.getContentIcon(), info.isCritical(), actionString, i3, action, z16);
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(actionString, "actionString");
        Intrinsics.checkNotNullParameter(action, "action");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionRecordData)) {
            return false;
        }
        InteractionRecordData interactionRecordData = (InteractionRecordData) other;
        return this.uin == interactionRecordData.uin && this.status == interactionRecordData.status && this.richStatus == interactionRecordData.richStatus && Intrinsics.areEqual(this.statusIcon, interactionRecordData.statusIcon) && Intrinsics.areEqual(this.statusTitle, interactionRecordData.statusTitle) && Intrinsics.areEqual(this.header, interactionRecordData.header) && Intrinsics.areEqual(this.name, interactionRecordData.name) && Intrinsics.areEqual(this.time, interactionRecordData.time) && Intrinsics.areEqual(this.content, interactionRecordData.content) && Intrinsics.areEqual(this.contentIcon, interactionRecordData.contentIcon) && this.isCritical == interactionRecordData.isCritical && Intrinsics.areEqual(this.actionString, interactionRecordData.actionString) && this.actionIcon == interactionRecordData.actionIcon && Intrinsics.areEqual(this.action, interactionRecordData.action) && this.isInSquare == interactionRecordData.isInSquare;
    }
}
