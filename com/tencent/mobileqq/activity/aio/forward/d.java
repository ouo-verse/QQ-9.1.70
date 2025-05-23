package com.tencent.mobileqq.activity.aio.forward;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes10.dex */
class d extends a {
    private void m(long j3, long j16) {
        HashMap<Long, Long> hashMap;
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOrderManager", 2, "ForwardOrder realMapUniSeq newSeq -> " + j3 + ", originSeq -> " + j16 + ", forwardID -> " + this.f178667a);
        }
        Set<Long> set = this.f178669c;
        if (set != null && !set.isEmpty() && c(j16, this.f178669c) && (hashMap = this.f178672f) != null) {
            hashMap.put(Long.valueOf(j3), Long.valueOf(j16));
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOrderManager", 2, "ForwardOrder realMapUniSeq map do put, forwardID -> " + this.f178667a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.activity.aio.forward.a
    public synchronized boolean b(long j3, boolean z16) {
        Set<Long> set;
        Long l3;
        if (z16) {
            set = this.f178669c;
        } else {
            set = this.f178668b;
        }
        if (set != null && set.size() > 0) {
            Iterator<Long> it = set.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                HashMap<Long, Long> hashMap = this.f178672f;
                if (hashMap != null && hashMap.get(Long.valueOf(j3)) != null && (l3 = this.f178672f.get(Long.valueOf(j3))) != null && l3.longValue() > 0 && l3.longValue() == longValue) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.activity.aio.forward.a
    public void d(long j3, long j16) {
        if (c(j16, this.f178669c)) {
            m(j3, j16);
        } else {
            e(j3);
            m(j3, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.activity.aio.forward.a
    public synchronized void g(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        Long l3;
        SessionInfo sessionInfo;
        HashMap<Long, Long> hashMap = this.f178672f;
        if (hashMap != null && hashMap.get(Long.valueOf(messageRecord.uniseq)) != null && (l3 = this.f178672f.get(Long.valueOf(messageRecord.uniseq))) != null && c(l3.longValue(), this.f178669c)) {
            this.f178669c.remove(l3);
            if (this.f178669c.size() <= 0 && !TextUtils.isEmpty(this.f178670d) && (sessionInfo = this.f178671e) != null) {
                long[] G = ChatActivityFacade.G(qQAppInterface, sessionInfo, this.f178670d);
                this.f178670d = "";
                if (G != null && G.length > 0) {
                    this.f178673g = G[0];
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.activity.aio.forward.a
    public boolean j(QQAppInterface qQAppInterface, long j3) {
        Long l3;
        synchronized (this) {
            HashMap<Long, Long> hashMap = this.f178672f;
            if (hashMap != null && hashMap.get(Long.valueOf(j3)) != null && (l3 = this.f178672f.get(Long.valueOf(j3))) != null && c(l3.longValue(), this.f178668b)) {
                this.f178668b.remove(l3);
                if (QLog.isColorLevel()) {
                    QLog.d("ForwardOrderManager", 2, "SeparateForwardOrder onSendResult mChatMsgListAfter remove originUniSeq " + l3 + "\uff0c mChatMsgListAfter.size() -> " + this.f178668b.size() + ", forwardID -> " + this.f178667a);
                }
                if (this.f178668b.size() <= 0 && this.f178671e != null && this.f178673g > 0) {
                    QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
                    SessionInfo sessionInfo = this.f178671e;
                    MessageRecord w06 = messageFacade.w0(sessionInfo.f179557e, sessionInfo.f179555d, this.f178673g);
                    if (w06 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ForwardOrderManager", 2, "SeparateForwardOrder onSendResult query msg and send, newSeq -> " + j3 + ", forwardID -> " + this.f178667a);
                        }
                        qQAppInterface.getMessageFacade().E0(w06, null, false);
                        this.f178673g = 0L;
                        f();
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
