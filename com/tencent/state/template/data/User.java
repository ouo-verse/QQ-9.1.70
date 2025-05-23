package com.tencent.state.template.data;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.state.data.UserCommon;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.data.RelationType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0002\u0010\u0015J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\t\u00105\u001a\u00020\u0005H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\bH\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\u0085\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u00c6\u0001J\u0013\u0010>\u001a\u00020#2\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010@\u001a\u00020AH\u00d6\u0001J\u0006\u0010B\u001a\u00020#J\u0006\u0010C\u001a\u00020#J\t\u0010D\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010$R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0019\u00a8\u0006E"}, d2 = {"Lcom/tencent/state/template/data/User;", "", "uin", "", "info", "Lcom/tencent/state/data/UserCommon;", "dressKey", "status", "Lcom/tencent/state/template/data/UserStatus;", "sitDown", "Lcom/tencent/state/template/data/SitDownInfo;", "prizeInfo", "Lcom/tencent/state/template/data/PrizeInfo;", "interaction", "Lcom/tencent/state/template/data/InterResourceInfo;", "relationType", "Lcom/tencent/state/square/data/RelationType;", "focusAnimationSkin", "Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "focusBroadcastSkin", "bubbleSkin", "(Ljava/lang/String;Lcom/tencent/state/data/UserCommon;Ljava/lang/String;Lcom/tencent/state/template/data/UserStatus;Lcom/tencent/state/template/data/SitDownInfo;Lcom/tencent/state/template/data/PrizeInfo;Lcom/tencent/state/template/data/InterResourceInfo;Lcom/tencent/state/square/data/RelationType;Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;)V", "getBubbleSkin", "()Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "getDressKey", "()Ljava/lang/String;", "getFocusAnimationSkin", "getFocusBroadcastSkin", "getInfo", "()Lcom/tencent/state/data/UserCommon;", "getInteraction", "()Lcom/tencent/state/template/data/InterResourceInfo;", "setInteraction", "(Lcom/tencent/state/template/data/InterResourceInfo;)V", "isMe", "", "()Z", "getPrizeInfo", "()Lcom/tencent/state/template/data/PrizeInfo;", "setPrizeInfo", "(Lcom/tencent/state/template/data/PrizeInfo;)V", "getRelationType", "()Lcom/tencent/state/square/data/RelationType;", "getSitDown", "()Lcom/tencent/state/template/data/SitDownInfo;", "setSitDown", "(Lcom/tencent/state/template/data/SitDownInfo;)V", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Lcom/tencent/state/template/data/UserStatus;", "getUin", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "isReceiver", "isSend", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class User {
    private final SquareBubbleInfo bubbleSkin;
    private final String dressKey;
    private final SquareBubbleInfo focusAnimationSkin;
    private final SquareBubbleInfo focusBroadcastSkin;
    private final UserCommon info;
    private InterResourceInfo interaction;
    private PrizeInfo prizeInfo;
    private final RelationType relationType;
    private SitDownInfo sitDown;
    private final UserStatus status;
    private final String uin;

    public User(String uin, UserCommon info, String dressKey, UserStatus status, SitDownInfo sitDownInfo, PrizeInfo prizeInfo, InterResourceInfo interResourceInfo, RelationType relationType, SquareBubbleInfo squareBubbleInfo, SquareBubbleInfo squareBubbleInfo2, SquareBubbleInfo squareBubbleInfo3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(status, "status");
        this.uin = uin;
        this.info = info;
        this.dressKey = dressKey;
        this.status = status;
        this.sitDown = sitDownInfo;
        this.prizeInfo = prizeInfo;
        this.interaction = interResourceInfo;
        this.relationType = relationType;
        this.focusAnimationSkin = squareBubbleInfo;
        this.focusBroadcastSkin = squareBubbleInfo2;
        this.bubbleSkin = squareBubbleInfo3;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component10, reason: from getter */
    public final SquareBubbleInfo getFocusBroadcastSkin() {
        return this.focusBroadcastSkin;
    }

    /* renamed from: component11, reason: from getter */
    public final SquareBubbleInfo getBubbleSkin() {
        return this.bubbleSkin;
    }

    /* renamed from: component2, reason: from getter */
    public final UserCommon getInfo() {
        return this.info;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDressKey() {
        return this.dressKey;
    }

    /* renamed from: component4, reason: from getter */
    public final UserStatus getStatus() {
        return this.status;
    }

    /* renamed from: component5, reason: from getter */
    public final SitDownInfo getSitDown() {
        return this.sitDown;
    }

    /* renamed from: component6, reason: from getter */
    public final PrizeInfo getPrizeInfo() {
        return this.prizeInfo;
    }

    /* renamed from: component7, reason: from getter */
    public final InterResourceInfo getInteraction() {
        return this.interaction;
    }

    /* renamed from: component8, reason: from getter */
    public final RelationType getRelationType() {
        return this.relationType;
    }

    /* renamed from: component9, reason: from getter */
    public final SquareBubbleInfo getFocusAnimationSkin() {
        return this.focusAnimationSkin;
    }

    public final User copy(String uin, UserCommon info, String dressKey, UserStatus status, SitDownInfo sitDown, PrizeInfo prizeInfo, InterResourceInfo interaction, RelationType relationType, SquareBubbleInfo focusAnimationSkin, SquareBubbleInfo focusBroadcastSkin, SquareBubbleInfo bubbleSkin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(status, "status");
        return new User(uin, info, dressKey, status, sitDown, prizeInfo, interaction, relationType, focusAnimationSkin, focusBroadcastSkin, bubbleSkin);
    }

    public final SquareBubbleInfo getBubbleSkin() {
        return this.bubbleSkin;
    }

    public final String getDressKey() {
        return this.dressKey;
    }

    public final SquareBubbleInfo getFocusAnimationSkin() {
        return this.focusAnimationSkin;
    }

    public final SquareBubbleInfo getFocusBroadcastSkin() {
        return this.focusBroadcastSkin;
    }

    public final UserCommon getInfo() {
        return this.info;
    }

    public final InterResourceInfo getInteraction() {
        return this.interaction;
    }

    public final PrizeInfo getPrizeInfo() {
        return this.prizeInfo;
    }

    public final RelationType getRelationType() {
        return this.relationType;
    }

    public final SitDownInfo getSitDown() {
        return this.sitDown;
    }

    public final UserStatus getStatus() {
        return this.status;
    }

    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        String str = this.uin;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        UserCommon userCommon = this.info;
        int hashCode2 = (hashCode + (userCommon != null ? userCommon.hashCode() : 0)) * 31;
        String str2 = this.dressKey;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        UserStatus userStatus = this.status;
        int hashCode4 = (hashCode3 + (userStatus != null ? userStatus.hashCode() : 0)) * 31;
        SitDownInfo sitDownInfo = this.sitDown;
        int hashCode5 = (hashCode4 + (sitDownInfo != null ? sitDownInfo.hashCode() : 0)) * 31;
        PrizeInfo prizeInfo = this.prizeInfo;
        int hashCode6 = (hashCode5 + (prizeInfo != null ? prizeInfo.hashCode() : 0)) * 31;
        InterResourceInfo interResourceInfo = this.interaction;
        int hashCode7 = (hashCode6 + (interResourceInfo != null ? interResourceInfo.hashCode() : 0)) * 31;
        RelationType relationType = this.relationType;
        int hashCode8 = (hashCode7 + (relationType != null ? relationType.hashCode() : 0)) * 31;
        SquareBubbleInfo squareBubbleInfo = this.focusAnimationSkin;
        int hashCode9 = (hashCode8 + (squareBubbleInfo != null ? squareBubbleInfo.hashCode() : 0)) * 31;
        SquareBubbleInfo squareBubbleInfo2 = this.focusBroadcastSkin;
        int hashCode10 = (hashCode9 + (squareBubbleInfo2 != null ? squareBubbleInfo2.hashCode() : 0)) * 31;
        SquareBubbleInfo squareBubbleInfo3 = this.bubbleSkin;
        return hashCode10 + (squareBubbleInfo3 != null ? squareBubbleInfo3.hashCode() : 0);
    }

    public final boolean isMe() {
        return this.info.isMe();
    }

    public final boolean isReceiver() {
        InterReceiverInfo receiverInfo;
        InterResourceInfo interResourceInfo = this.interaction;
        return Intrinsics.areEqual(String.valueOf((interResourceInfo == null || (receiverInfo = interResourceInfo.getReceiverInfo()) == null) ? null : Long.valueOf(receiverInfo.getUin())), this.uin);
    }

    public final boolean isSend() {
        InterSenderInfo senderInfo;
        InterResourceInfo interResourceInfo = this.interaction;
        return Intrinsics.areEqual(String.valueOf((interResourceInfo == null || (senderInfo = interResourceInfo.getSenderInfo()) == null) ? null : Long.valueOf(senderInfo.getUin())), this.uin);
    }

    public final void setInteraction(InterResourceInfo interResourceInfo) {
        this.interaction = interResourceInfo;
    }

    public final void setPrizeInfo(PrizeInfo prizeInfo) {
        this.prizeInfo = prizeInfo;
    }

    public final void setSitDown(SitDownInfo sitDownInfo) {
        this.sitDown = sitDownInfo;
    }

    public String toString() {
        return "User(uin=" + this.uin + ", info=" + this.info + ", dressKey=" + this.dressKey + ", status=" + this.status + ", sitDown=" + this.sitDown + ", prizeInfo=" + this.prizeInfo + ", interaction=" + this.interaction + ", relationType=" + this.relationType + ", focusAnimationSkin=" + this.focusAnimationSkin + ", focusBroadcastSkin=" + this.focusBroadcastSkin + ", bubbleSkin=" + this.bubbleSkin + ")";
    }

    public /* synthetic */ User(String str, UserCommon userCommon, String str2, UserStatus userStatus, SitDownInfo sitDownInfo, PrizeInfo prizeInfo, InterResourceInfo interResourceInfo, RelationType relationType, SquareBubbleInfo squareBubbleInfo, SquareBubbleInfo squareBubbleInfo2, SquareBubbleInfo squareBubbleInfo3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, userCommon, str2, userStatus, sitDownInfo, (i3 & 32) != 0 ? null : prizeInfo, (i3 & 64) != 0 ? null : interResourceInfo, (i3 & 128) != 0 ? null : relationType, (i3 & 256) != 0 ? null : squareBubbleInfo, (i3 & 512) != 0 ? null : squareBubbleInfo2, (i3 & 1024) != 0 ? null : squareBubbleInfo3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User user = (User) other;
        return Intrinsics.areEqual(this.uin, user.uin) && Intrinsics.areEqual(this.info, user.info) && Intrinsics.areEqual(this.dressKey, user.dressKey) && Intrinsics.areEqual(this.status, user.status) && Intrinsics.areEqual(this.sitDown, user.sitDown) && Intrinsics.areEqual(this.prizeInfo, user.prizeInfo) && Intrinsics.areEqual(this.interaction, user.interaction) && Intrinsics.areEqual(this.relationType, user.relationType) && Intrinsics.areEqual(this.focusAnimationSkin, user.focusAnimationSkin) && Intrinsics.areEqual(this.focusBroadcastSkin, user.focusBroadcastSkin) && Intrinsics.areEqual(this.bubbleSkin, user.bubbleSkin);
    }
}
