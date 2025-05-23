package com.tencent.mobileqq.nearbypro.aio.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/event/NearbyProAioMsgEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "msgId", "", "peer", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "errorCode", "", "errorMsg", "", "(JLcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "getMsgId", "()J", "getPeer", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class NearbyProAioMsgEvent extends SimpleBaseEvent {
    private final int errorCode;

    @Nullable
    private final String errorMsg;
    private final long msgId;

    @Nullable
    private final Contact peer;

    public NearbyProAioMsgEvent() {
        this(0L, null, 0, null, 15, null);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final long getMsgId() {
        return this.msgId;
    }

    @Nullable
    public final Contact getPeer() {
        return this.peer;
    }

    public /* synthetic */ NearbyProAioMsgEvent(long j3, Contact contact, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0L : j3, (i16 & 2) != 0 ? null : contact, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? null : str);
    }

    public NearbyProAioMsgEvent(long j3, @Nullable Contact contact, int i3, @Nullable String str) {
        this.msgId = j3;
        this.peer = contact;
        this.errorCode = i3;
        this.errorMsg = str;
    }
}
