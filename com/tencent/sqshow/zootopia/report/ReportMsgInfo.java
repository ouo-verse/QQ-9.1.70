package com.tencent.sqshow.zootopia.report;

import av4.d;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vas.banner.c;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J'\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\bH\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/sqshow/zootopia/report/ReportMsgInfo;", "Ljava/io/Serializable;", "Lav4/d;", "convertToMsgInfo", "", "component1", "", "component2", "Lcom/tencent/sqshow/zootopia/report/MsgBodyContent;", "component3", "msgId", QQBrowserActivity.KEY_MSG_TYPE, "msgBody", "copy", "", "toString", "hashCode", "", "other", "", "equals", "J", "getMsgId", "()J", "I", "getMsgType", "()I", "Lcom/tencent/sqshow/zootopia/report/MsgBodyContent;", "getMsgBody", "()Lcom/tencent/sqshow/zootopia/report/MsgBodyContent;", "<init>", "(JILcom/tencent/sqshow/zootopia/report/MsgBodyContent;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final /* data */ class ReportMsgInfo implements Serializable {
    private final MsgBodyContent msgBody;
    private final long msgId;
    private final int msgType;

    public ReportMsgInfo(long j3, int i3, MsgBodyContent msgBody) {
        Intrinsics.checkNotNullParameter(msgBody, "msgBody");
        this.msgId = j3;
        this.msgType = i3;
        this.msgBody = msgBody;
    }

    /* renamed from: component1, reason: from getter */
    public final long getMsgId() {
        return this.msgId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMsgType() {
        return this.msgType;
    }

    /* renamed from: component3, reason: from getter */
    public final MsgBodyContent getMsgBody() {
        return this.msgBody;
    }

    public final d convertToMsgInfo() {
        d dVar = new d();
        dVar.f27014a = this.msgId;
        dVar.f27015b = this.msgType;
        dVar.f27016c = MessageNano.toByteArray(this.msgBody.convertToMsgBodyCommon());
        return dVar;
    }

    public final ReportMsgInfo copy(long msgId, int msgType, MsgBodyContent msgBody) {
        Intrinsics.checkNotNullParameter(msgBody, "msgBody");
        return new ReportMsgInfo(msgId, msgType, msgBody);
    }

    public final MsgBodyContent getMsgBody() {
        return this.msgBody;
    }

    public final long getMsgId() {
        return this.msgId;
    }

    public final int getMsgType() {
        return this.msgType;
    }

    public int hashCode() {
        return (((c.a(this.msgId) * 31) + this.msgType) * 31) + this.msgBody.hashCode();
    }

    public String toString() {
        return "ReportMsgInfo(msgId=" + this.msgId + ", msgType=" + this.msgType + ", msgBody=" + this.msgBody + ")";
    }

    public static /* synthetic */ ReportMsgInfo copy$default(ReportMsgInfo reportMsgInfo, long j3, int i3, MsgBodyContent msgBodyContent, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            j3 = reportMsgInfo.msgId;
        }
        if ((i16 & 2) != 0) {
            i3 = reportMsgInfo.msgType;
        }
        if ((i16 & 4) != 0) {
            msgBodyContent = reportMsgInfo.msgBody;
        }
        return reportMsgInfo.copy(j3, i3, msgBodyContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportMsgInfo)) {
            return false;
        }
        ReportMsgInfo reportMsgInfo = (ReportMsgInfo) other;
        return this.msgId == reportMsgInfo.msgId && this.msgType == reportMsgInfo.msgType && Intrinsics.areEqual(this.msgBody, reportMsgInfo.msgBody);
    }
}
