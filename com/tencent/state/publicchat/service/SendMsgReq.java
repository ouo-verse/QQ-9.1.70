package com.tencent.state.publicchat.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zs4.b;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b%\u0010&J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\nH\u00c6\u0003J\t\u0010\f\u001a\u00020\bH\u00c6\u0003J;\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\bH\u00c6\u0001J\t\u0010\u0013\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0010\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b$\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/state/publicchat/service/SendMsgReq;", "", "Lzs4/b;", "toPB", "", "component1", "", "component2", "", "component3", "Lcom/google/protobuf/nano/MessageNano;", "component4", "component5", "templateId", "appId", "channelId", "body", "roomId", "copy", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getTemplateId", "()Ljava/lang/String;", "I", "getAppId", "()I", "J", "getChannelId", "()J", "Lcom/google/protobuf/nano/MessageNano;", "getBody", "()Lcom/google/protobuf/nano/MessageNano;", "getRoomId", "<init>", "(Ljava/lang/String;IJLcom/google/protobuf/nano/MessageNano;J)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SendMsgReq {
    private final int appId;
    private final MessageNano body;
    private final long channelId;
    private final long roomId;
    private final String templateId;

    public SendMsgReq(String templateId, int i3, long j3, MessageNano body, long j16) {
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        Intrinsics.checkNotNullParameter(body, "body");
        this.templateId = templateId;
        this.appId = i3;
        this.channelId = j3;
        this.body = body;
        this.roomId = j16;
    }

    /* renamed from: component1, reason: from getter */
    public final String getTemplateId() {
        return this.templateId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAppId() {
        return this.appId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component4, reason: from getter */
    public final MessageNano getBody() {
        return this.body;
    }

    /* renamed from: component5, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    public final SendMsgReq copy(String templateId, int appId, long channelId, MessageNano body, long roomId) {
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        Intrinsics.checkNotNullParameter(body, "body");
        return new SendMsgReq(templateId, appId, channelId, body, roomId);
    }

    public final int getAppId() {
        return this.appId;
    }

    public final MessageNano getBody() {
        return this.body;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public int hashCode() {
        String str = this.templateId;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.appId) * 31) + c.a(this.channelId)) * 31;
        MessageNano messageNano = this.body;
        return ((hashCode + (messageNano != null ? messageNano.hashCode() : 0)) * 31) + c.a(this.roomId);
    }

    public final b toPB() {
        b bVar = new b();
        bVar.f453166a = this.templateId;
        int i3 = this.appId;
        bVar.f453172g = i3;
        bVar.f453167b = i3;
        bVar.f453168c = this.channelId;
        bVar.f453169d = MessageNano.toByteArray(this.body);
        bVar.f453170e = this.roomId;
        return bVar;
    }

    public String toString() {
        return "SendMsgReq(templateId=" + this.templateId + ", appId=" + this.appId + ", channelId=" + this.channelId + ", body=" + this.body + ", roomId=" + this.roomId + ")";
    }

    public /* synthetic */ SendMsgReq(String str, int i3, long j3, MessageNano messageNano, long j16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, j3, messageNano, (i16 & 16) != 0 ? 0L : j16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendMsgReq)) {
            return false;
        }
        SendMsgReq sendMsgReq = (SendMsgReq) other;
        return Intrinsics.areEqual(this.templateId, sendMsgReq.templateId) && this.appId == sendMsgReq.appId && this.channelId == sendMsgReq.channelId && Intrinsics.areEqual(this.body, sendMsgReq.body) && this.roomId == sendMsgReq.roomId;
    }

    public static /* synthetic */ SendMsgReq copy$default(SendMsgReq sendMsgReq, String str, int i3, long j3, MessageNano messageNano, long j16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = sendMsgReq.templateId;
        }
        if ((i16 & 2) != 0) {
            i3 = sendMsgReq.appId;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            j3 = sendMsgReq.channelId;
        }
        long j17 = j3;
        if ((i16 & 8) != 0) {
            messageNano = sendMsgReq.body;
        }
        MessageNano messageNano2 = messageNano;
        if ((i16 & 16) != 0) {
            j16 = sendMsgReq.roomId;
        }
        return sendMsgReq.copy(str, i17, j17, messageNano2, j16);
    }
}
