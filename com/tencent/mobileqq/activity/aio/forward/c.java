package com.tencent.mobileqq.activity.aio.forward;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes10.dex */
class c extends a {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.activity.aio.forward.a
    public synchronized boolean b(long j3, boolean z16) {
        Set<Long> set;
        if (z16) {
            set = this.f178669c;
        } else {
            set = this.f178668b;
        }
        if (set != null && set.size() > 0) {
            Iterator<Long> it = set.iterator();
            while (it.hasNext()) {
                if (it.next().longValue() == j3) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.activity.aio.forward.a
    public synchronized void d(long j3, long j16) {
        Set<Long> set = this.f178669c;
        if (set == null) {
            this.f178669c = new HashSet();
        } else {
            set.clear();
        }
        this.f178669c.add(Long.valueOf(j3));
        Set<Long> set2 = this.f178668b;
        if (set2 == null) {
            this.f178668b = new HashSet();
        } else {
            set2.clear();
        }
        this.f178668b.add(Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.activity.aio.forward.a
    public void g(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        SessionInfo sessionInfo;
        Set<Long> set = this.f178669c;
        if (set != null && set.size() > 0 && a(this.f178668b) == messageRecord.uniseq && !TextUtils.isEmpty(this.f178670d) && (sessionInfo = this.f178671e) != null) {
            long[] G = ChatActivityFacade.G(qQAppInterface, sessionInfo, this.f178670d);
            this.f178670d = "";
            if (G != null && G.length > 0) {
                this.f178673g = G[0];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.activity.aio.forward.a
    public boolean i(QQAppInterface qQAppInterface, long j3) {
        Set<Long> set = this.f178668b;
        if (set == null || set.isEmpty() || a(this.f178668b) != j3 || this.f178671e == null || this.f178673g <= 0) {
            return false;
        }
        QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
        SessionInfo sessionInfo = this.f178671e;
        messageFacade.Z0(sessionInfo.f179557e, sessionInfo.f179555d, this.f178673g, 32768, -1);
        e msgCache = qQAppInterface.getMsgCache();
        SessionInfo sessionInfo2 = this.f178671e;
        msgCache.G1(sessionInfo2.f179557e, sessionInfo2.f179555d, this.f178673g);
        this.f178673g = 0L;
        f();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.activity.aio.forward.a
    public boolean j(QQAppInterface qQAppInterface, long j3) {
        Set<Long> set = this.f178668b;
        if (set == null || set.size() <= 0 || a(this.f178668b) != j3 || a(this.f178668b) != j3 || this.f178671e == null || this.f178673g <= 0) {
            return false;
        }
        QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
        SessionInfo sessionInfo = this.f178671e;
        MessageRecord w06 = messageFacade.w0(sessionInfo.f179557e, sessionInfo.f179555d, this.f178673g);
        if (w06 != null) {
            qQAppInterface.getMessageFacade().E0(w06, null, false);
        }
        this.f178673g = 0L;
        f();
        return true;
    }
}
