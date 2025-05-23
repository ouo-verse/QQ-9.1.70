package com.tencent.state.square.data;

import com.tencent.state.service.UserFormatKt;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import com.tencent.state.square.record.RecordIdentifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import oicq.wlogin_sdk.tools.util;
import vs4.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u00a2\u0006\u0004\bP\u0010>J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u0004J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0016J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\t\u0010\u001d\u001a\u00020\u0004H\u00c6\u0003J\u0013\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u0004H\u00c6\u0001J\t\u0010 \u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010#\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\"\u0010,\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010F\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010:\u001a\u0004\bG\u0010<\"\u0004\bH\u0010>R\"\u0010I\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010:\u001a\u0004\bJ\u0010<\"\u0004\bK\u0010>R\"\u0010L\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010-\u001a\u0004\bM\u0010/\"\u0004\bN\u00101R\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010:\u001a\u0004\bO\u0010<\u00a8\u0006Q"}, d2 = {"Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "", "", "isInviteSuccess", "", "getReceiverNick", "getSenderNick", "uin", "isSender", "isReceiver", "isMeSender", "isMeReceiver", "", "getOtherUin", "", "getOtherGender", "getOtherNick", "getSuccessOtherUin", "()Ljava/lang/Long;", "getSuccessOtherGender", "()Ljava/lang/Integer;", DetailMeFragmentConfig.CURRENT_STATUS_ID, "(I)Ljava/lang/Long;", "(I)Ljava/lang/Integer;", "Lvs4/o;", "getOtherUser", "getUser", "isInInvite", "toString", "component1", "billNum", "copy", "hashCode", "other", "equals", "sender", "Lvs4/o;", "getSender", "()Lvs4/o;", "setSender", "(Lvs4/o;)V", "receiver", "getReceiver", "setReceiver", "inviteStatus", "I", "getInviteStatus", "()I", "setInviteStatus", "(I)V", "Lcom/tencent/state/square/data/Resource;", "statusResource", "Lcom/tencent/state/square/data/Resource;", "getStatusResource", "()Lcom/tencent/state/square/data/Resource;", "setStatusResource", "(Lcom/tencent/state/square/data/Resource;)V", "countDown", "Ljava/lang/String;", "getCountDown", "()Ljava/lang/String;", "setCountDown", "(Ljava/lang/String;)V", "Lcom/tencent/state/square/data/OnlineStatus;", "statusInfo", "Lcom/tencent/state/square/data/OnlineStatus;", "getStatusInfo", "()Lcom/tencent/state/square/data/OnlineStatus;", "setStatusInfo", "(Lcom/tencent/state/square/data/OnlineStatus;)V", "backgroundUrl", "getBackgroundUrl", "setBackgroundUrl", "previewUrl", "getPreviewUrl", "setPreviewUrl", "singleMotionId", "getSingleMotionId", "setSingleMotionId", "getBillNum", "<init>", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareMultiMotionDetailData {
    private String backgroundUrl;
    private final String billNum;

    /* renamed from: countDown, reason: from kotlin metadata and from toString */
    private String countdown;
    private int inviteStatus;
    private String previewUrl;
    private o receiver;
    private o sender;
    private int singleMotionId;
    private OnlineStatus statusInfo;

    /* renamed from: statusResource, reason: from kotlin metadata and from toString */
    private Resource resource;

    public SquareMultiMotionDetailData(String billNum) {
        Intrinsics.checkNotNullParameter(billNum, "billNum");
        this.billNum = billNum;
        this.sender = new o();
        this.receiver = new o();
        this.resource = new Resource(0, null, null, null, null, false, null, 0, 0, null, 1023, null);
        this.countdown = "";
        this.statusInfo = new OnlineStatus(0, 0, 0, null, null, null, null, null, null, null, 1023, null);
        this.backgroundUrl = "";
        this.previewUrl = "";
    }

    /* renamed from: component1, reason: from getter */
    public final String getBillNum() {
        return this.billNum;
    }

    public final SquareMultiMotionDetailData copy(String billNum) {
        Intrinsics.checkNotNullParameter(billNum, "billNum");
        return new SquareMultiMotionDetailData(billNum);
    }

    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public final String getBillNum() {
        return this.billNum;
    }

    /* renamed from: getCountDown, reason: from getter */
    public final String getCountdown() {
        return this.countdown;
    }

    public final int getInviteStatus() {
        return this.inviteStatus;
    }

    public final int getOtherGender() {
        o oVar;
        if (isMeSender()) {
            oVar = this.receiver;
        } else {
            oVar = this.sender;
        }
        return oVar.f443332e;
    }

    public final String getOtherNick() {
        if (isMeSender()) {
            return getReceiverNick();
        }
        return getSenderNick();
    }

    public final long getOtherUin() {
        o oVar;
        if (isMeSender()) {
            oVar = this.receiver;
        } else {
            oVar = this.sender;
        }
        return oVar.f443328a;
    }

    public final o getOtherUser(String uin) {
        if (isSender(uin)) {
            return this.receiver;
        }
        if (isReceiver(uin)) {
            return this.sender;
        }
        return null;
    }

    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public final o getReceiver() {
        return this.receiver;
    }

    public final String getReceiverNick() {
        String take;
        o oVar = this.receiver;
        take = StringsKt___StringsKt.take(UserFormatKt.toNickName(oVar.f443329b, oVar.f443328a), 20);
        return take;
    }

    public final o getSender() {
        return this.sender;
    }

    public final String getSenderNick() {
        String take;
        o oVar = this.sender;
        take = StringsKt___StringsKt.take(UserFormatKt.toNickName(oVar.f443329b, oVar.f443328a), 20);
        return take;
    }

    public final int getSingleMotionId() {
        return this.singleMotionId;
    }

    public final OnlineStatus getStatusInfo() {
        return this.statusInfo;
    }

    /* renamed from: getStatusResource, reason: from getter */
    public final Resource getResource() {
        return this.resource;
    }

    public final Integer getSuccessOtherGender() {
        if (isInviteSuccess()) {
            return Integer.valueOf(getOtherGender());
        }
        return null;
    }

    public final Long getSuccessOtherUin() {
        if (isInviteSuccess()) {
            return Long.valueOf(getOtherUin());
        }
        return null;
    }

    public final o getUser(String uin) {
        if (isSender(uin)) {
            return this.sender;
        }
        if (isReceiver(uin)) {
            return this.receiver;
        }
        return null;
    }

    public int hashCode() {
        String str = this.billNum;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final boolean isInInvite(String uin) {
        return Intrinsics.areEqual(String.valueOf(this.receiver.f443328a), uin) || Intrinsics.areEqual(String.valueOf(this.sender.f443328a), uin);
    }

    public final boolean isInviteSuccess() {
        return this.inviteStatus == 1;
    }

    public final boolean isMeReceiver() {
        return isReceiver(RecordIdentifier.INSTANCE.getSelfUin());
    }

    public final boolean isMeSender() {
        return isSender(RecordIdentifier.INSTANCE.getSelfUin());
    }

    public final boolean isReceiver(String uin) {
        return Intrinsics.areEqual(String.valueOf(this.receiver.f443328a), uin);
    }

    public final boolean isSender(String uin) {
        return Intrinsics.areEqual(String.valueOf(this.sender.f443328a), uin);
    }

    public final void setBackgroundUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backgroundUrl = str;
    }

    public final void setCountDown(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.countdown = str;
    }

    public final void setInviteStatus(int i3) {
        this.inviteStatus = i3;
    }

    public final void setPreviewUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.previewUrl = str;
    }

    public final void setReceiver(o oVar) {
        Intrinsics.checkNotNullParameter(oVar, "<set-?>");
        this.receiver = oVar;
    }

    public final void setSender(o oVar) {
        Intrinsics.checkNotNullParameter(oVar, "<set-?>");
        this.sender = oVar;
    }

    public final void setSingleMotionId(int i3) {
        this.singleMotionId = i3;
    }

    public final void setStatusInfo(OnlineStatus onlineStatus) {
        Intrinsics.checkNotNullParameter(onlineStatus, "<set-?>");
        this.statusInfo = onlineStatus;
    }

    public final void setStatusResource(Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "<set-?>");
        this.resource = resource;
    }

    public String toString() {
        return "(billNum='" + this.billNum + "', receiver=" + this.receiver.f443328a + ", inviteStatus=" + this.inviteStatus + ", status=" + this.statusInfo.getId() + util.base64_pad_url + this.statusInfo.getTitle() + ", resource=" + this.resource + ", countdown=" + this.countdown + ')';
    }

    public final Integer getSuccessOtherGender(int statusId) {
        if (this.statusInfo.getId() == statusId) {
            return getSuccessOtherGender();
        }
        return null;
    }

    public final Long getSuccessOtherUin(int statusId) {
        if (this.statusInfo.getId() == statusId) {
            return getSuccessOtherUin();
        }
        return null;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SquareMultiMotionDetailData) && Intrinsics.areEqual(this.billNum, ((SquareMultiMotionDetailData) other).billNum);
        }
        return true;
    }

    public static /* synthetic */ SquareMultiMotionDetailData copy$default(SquareMultiMotionDetailData squareMultiMotionDetailData, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = squareMultiMotionDetailData.billNum;
        }
        return squareMultiMotionDetailData.copy(str);
    }
}
