package com.tencent.mobileqq.activity.aio.forward;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes10.dex */
abstract class a {

    /* renamed from: a, reason: collision with root package name */
    int f178667a;

    /* renamed from: b, reason: collision with root package name */
    Set<Long> f178668b;

    /* renamed from: c, reason: collision with root package name */
    Set<Long> f178669c;

    /* renamed from: d, reason: collision with root package name */
    String f178670d;

    /* renamed from: e, reason: collision with root package name */
    SessionInfo f178671e;

    /* renamed from: f, reason: collision with root package name */
    HashMap<Long, Long> f178672f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    long f178673g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a(Set<Long> set) {
        Object[] array;
        if (set != null && set.size() > 0 && (array = set.toArray()) != null && array.length > 0) {
            Object obj = array[0];
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            return 0L;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean b(long j3, boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(long j3, Set<Long> set) {
        synchronized (this) {
            if (set != null) {
                if (!set.isEmpty()) {
                    Iterator<Long> it = set.iterator();
                    while (it.hasNext()) {
                        if (it.next().longValue() == j3) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void e(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOrderManager", 2, "ForwardOrder msgIDToSend id -> " + j3);
        }
        Set<Long> set = this.f178668b;
        if (set != null) {
            set.add(Long.valueOf(j3));
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOrderManager", 2, "ForwardOrder mChatMsgListAfter add id -> " + j3);
            }
        }
        Set<Long> set2 = this.f178669c;
        if (set2 != null) {
            set2.add(Long.valueOf(j3));
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOrderManager", 2, "ForwardOrder mChatMsgListBefore add id -> " + j3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void f() {
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOrderManager", 2, "ForwardOrder onDestroy forward id -> " + this.f178667a);
        }
        this.f178671e = null;
        this.f178670d = "";
        this.f178673g = 0L;
        Set<Long> set = this.f178668b;
        if (set != null) {
            set.clear();
            this.f178668b = null;
        }
        Set<Long> set2 = this.f178669c;
        if (set2 != null) {
            set2.clear();
            this.f178669c = null;
        }
        HashMap<Long, Long> hashMap = this.f178672f;
        if (hashMap != null) {
            hashMap.clear();
            this.f178672f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void g(QQAppInterface qQAppInterface, MessageRecord messageRecord);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a h(SessionInfo sessionInfo, String str, List<Long> list, int i3) {
        this.f178667a = i3;
        this.f178671e = sessionInfo;
        this.f178670d = str;
        if (list != null) {
            this.f178668b = new HashSet(list);
            this.f178669c = new HashSet(list);
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOrderManager", 2, "Forward order onPreForward mChatMsgListAfter.size() -> " + this.f178668b.size() + ", mChatMsgListBefore.size() -> " + this.f178669c.size() + ", ForwardID -> " + i3);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(QQAppInterface qQAppInterface, long j3) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean j(QQAppInterface qQAppInterface, long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(QQAppInterface qQAppInterface, long j3) {
        SessionInfo sessionInfo;
        synchronized (this) {
            Set<Long> set = this.f178669c;
            if (set != null && set.size() > 0) {
                Iterator<Long> it = this.f178669c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().longValue() == j3) {
                        it.remove();
                        break;
                    }
                }
                if (this.f178669c.size() <= 0 && !TextUtils.isEmpty(this.f178670d) && (sessionInfo = this.f178671e) != null) {
                    long[] G = ChatActivityFacade.G(qQAppInterface, sessionInfo, this.f178670d);
                    this.f178670d = "";
                    if (G != null && G.length > 0) {
                        this.f178673g = G[0];
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void l(long j3, long j16) {
        Set<Long> set = this.f178668b;
        if (set != null && set.size() > 0 && this.f178668b.contains(Long.valueOf(j3))) {
            this.f178668b.remove(Long.valueOf(j3));
            this.f178668b.add(Long.valueOf(j16));
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOrderManager", 2, "Forward order replaceOriginChatMsg mChatMsgListAfter.size() -> " + this.f178668b.size() + ", mChatMsgListAfter remove uniSeq -> " + j3 + ", mChatMsgListAfter add uniSeq -> " + j16 + ", ForwardID -> " + this.f178667a);
            }
        }
        Set<Long> set2 = this.f178669c;
        if (set2 != null && set2.size() > 0 && this.f178669c.contains(Long.valueOf(j3))) {
            this.f178669c.remove(Long.valueOf(j3));
            this.f178669c.add(Long.valueOf(j16));
        }
    }
}
