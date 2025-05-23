package com.tencent.mobileqq.guild.message.api;

import android.util.Pair;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.eventflow.GuildEventFlowTimeItem;
import com.tencent.mobileqq.guild.message.unread.DecreaseMsgSeqInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observer;
import mqq.app.api.IRuntimeService;
import tencent.im.group_pro_proto.common.common$MsgMeta;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes14.dex */
public interface IGuildMsgSeqTimeService extends IRuntimeService {
    void addDecreaseMsgSeq(String str, String str2, DecreaseMsgSeqInfo decreaseMsgSeqInfo);

    void addObserver(Observer observer);

    void delDecreaseMsgSeq(String str, DecreaseMsgSeqInfo decreaseMsgSeqInfo);

    void deleteObserver(Observer observer);

    HashSet<DecreaseMsgSeqInfo> getDecreaseMsgSeqList(String str);

    GuildEventFlowTimeItem getEventFlowTimeItem(String str);

    long getExpiredMsgSeq(String str);

    a getLastLocallMsgSeq(String str);

    a getLastLocallVisibleMsgSeq(String str);

    a getLastSvrMsgSeq(String str);

    a getLatestHasSeenMsg(String str);

    Pair<Long, byte[]> getLatestMsgToken(String str);

    a getReadedMsgSeq(String str);

    a getReportSeqTimeItem(String str, boolean z16);

    void setEventFlowTimeItem(String str, String str2, long j3);

    void setEventFlowTimeItem(String str, String str2, long j3, long j16, byte[] bArr);

    void setEventFlowTimeItem(String str, String str2, GuildEventFlowTimeItem guildEventFlowTimeItem);

    void setExpiredMsgSeq(String str, String str2, long j3);

    boolean setLastLocalMsgSeq(String str, String str2, a aVar);

    boolean setLastLocalVisibleMsgSeq(String str, String str2, a aVar);

    boolean setLastSvrMsgSeq(String str, String str2, a aVar, boolean z16);

    void setLatestHasSeenMsg(String str, a aVar);

    void setLatestMsgToken(String str, long j3, byte[] bArr);

    boolean setReadedMsgSeq(String str, String str2, a aVar, boolean z16);

    void updateLastSeqAndTime(ArrayList<MessageRecord> arrayList);

    boolean verifyLastLocalVisibleMsgSeq(String str, String str2, a aVar);

    boolean verifyLastSvrMsgSeq(String str, String str2, a aVar);

    boolean verifyReadedMsgSeq(String str, String str2, a aVar);

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a implements Cloneable {

        /* renamed from: d, reason: collision with root package name */
        public long f230119d;

        /* renamed from: e, reason: collision with root package name */
        public long f230120e;

        /* renamed from: f, reason: collision with root package name */
        public long f230121f;

        /* renamed from: h, reason: collision with root package name */
        private byte[] f230122h;

        /* renamed from: i, reason: collision with root package name */
        private long f230123i;

        public a() {
            this.f230119d = -1L;
            this.f230120e = -1L;
            this.f230121f = 0L;
            f(null);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a clone() {
            try {
                a aVar = (a) super.clone();
                aVar.f(this.f230122h);
                return aVar;
            } catch (CloneNotSupportedException unused) {
                return this;
            }
        }

        public long b() {
            if (this.f230122h == null) {
                QLog.i("MsgSeqTimeItem", 2, "getAtAllSeq msgMeta is null!");
                return -1L;
            }
            if (this.f230123i == -1) {
                common$MsgMeta common_msgmeta = new common$MsgMeta();
                try {
                    common_msgmeta.mergeFrom(this.f230122h);
                    this.f230123i = common_msgmeta.at_all_seq.get();
                } catch (Exception unused) {
                }
            }
            return this.f230123i;
        }

        public byte[] c() {
            return this.f230122h;
        }

        public boolean d() {
            if (this.f230119d > -1) {
                return true;
            }
            return false;
        }

        public void e(a aVar) {
            this.f230119d = aVar.f230119d;
            this.f230120e = aVar.f230120e;
            this.f230121f = aVar.f230121f;
            f(aVar.f230122h);
        }

        public void f(byte[] bArr) {
            byte[] bArr2;
            if (bArr == null) {
                bArr2 = null;
            } else {
                bArr2 = (byte[]) bArr.clone();
            }
            this.f230122h = bArr2;
            this.f230123i = -1L;
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("msgSeq:");
            sb5.append(this.f230119d);
            sb5.append(" ");
            sb5.append("cntSeq:");
            sb5.append(this.f230120e);
            sb5.append(" ");
            sb5.append("msgTime:");
            sb5.append(this.f230121f);
            sb5.append(" ");
            if (this.f230122h != null) {
                sb5.append("atAllSeq:");
                sb5.append(b());
                sb5.append(" ");
            }
            return sb5.toString();
        }

        public a(long j3, long j16, long j17, byte[] bArr) {
            this.f230119d = j3;
            this.f230120e = j16;
            this.f230121f = j17;
            f(bArr);
        }
    }
}
