package com.tencent.mobileqq.guild.message.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildAioMsgFilterApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f230114a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f230115b = 0;

        /* renamed from: c, reason: collision with root package name */
        public long f230116c = 0;

        @NonNull
        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("MsgSeqItem:{");
            sb5.append("uniqueSeq = " + this.f230114a);
            sb5.append(", msgSeq = " + this.f230115b);
            sb5.append(", cntSeq = " + this.f230116c);
            sb5.append("}");
            return sb5.toString();
        }
    }

    a getCurAioLatestMsgSeqItem(String str);

    boolean getJumpToBottomStatus();

    a getLatestMsgSeqItem(String str);

    a getLatestOnlineMsgSeqItem(String str);

    boolean getOneClickJumpSuccessStatus();

    a getReadLatestMsgSeqItem(String str);

    void resetCurAioLatestMsgSeqItem(String str);

    void setJumpToBottomStatus(boolean z16);

    void setOneClickJumpSuccessStatus(boolean z16);

    void updateCurAioLatestMsgSeqItem(String str, a aVar, boolean z16);

    void updateLatestMsgSeqItem(String str, a aVar, boolean z16);

    void updateLatestOnlineMsgMsgSeqItem(String str, a aVar, boolean z16);

    void updateReadLatestMsgSeqItem(String str, a aVar, boolean z16);
}
