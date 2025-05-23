package com.tencent.mobileqq.activity.aio.forward;

import android.util.SparseArray;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static b f178674c;

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f178675a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private SparseArray<a> f178676b = new SparseArray<>();

    b() {
    }

    private a b(long j3, boolean z16) {
        for (int size = this.f178676b.size() - 1; size >= 0; size--) {
            a valueAt = this.f178676b.valueAt(size);
            if (valueAt != null && valueAt.b(j3, z16)) {
                return valueAt;
            }
        }
        return null;
    }

    public static b d() {
        if (f178674c == null) {
            synchronized (b.class) {
                if (f178674c == null) {
                    f178674c = new b();
                }
            }
        }
        return f178674c;
    }

    public String a(int i3) {
        a aVar = this.f178676b.get(i3);
        if (aVar != null) {
            return aVar.f178670d;
        }
        return null;
    }

    public int c() {
        return this.f178675a.incrementAndGet();
    }

    public void e(long j3, long j16, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOrderManager", 2, "mapUniSeqId:: newSeq -> " + j3 + ", originSeq -> " + j16 + ", id -> " + i3);
        }
        a aVar = this.f178676b.get(i3);
        if (aVar != null) {
            aVar.d(j3, j16);
        }
    }

    public void f(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        synchronized (this) {
            a b16 = b(messageRecord.uniseq, true);
            if (b16 != null) {
                b16.g(qQAppInterface, messageRecord);
            }
        }
    }

    public void g(QQAppInterface qQAppInterface, List<MessageRecord> list) {
        synchronized (this) {
            if (list != null) {
                if (list.size() > 0) {
                    Iterator<MessageRecord> it = list.iterator();
                    while (it.hasNext()) {
                        f(qQAppInterface, it.next());
                    }
                }
            }
        }
    }

    public void h(SessionInfo sessionInfo, String str, int i3) {
        i(sessionInfo, str, new ArrayList(), 1, i3);
    }

    public void i(SessionInfo sessionInfo, String str, List<MessageRecord> list, int i3, int i16) {
        a cVar;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (MessageRecord messageRecord : list) {
                arrayList.add(Long.valueOf(messageRecord.uniseq));
                if (QLog.isColorLevel()) {
                    QLog.d("ForwardOrderManager", 2, "onPreForward :: mr.uniseq -> " + messageRecord.uniseq + ", forwardID -> " + i16);
                }
            }
        }
        if (i3 == 1) {
            cVar = new d();
        } else {
            cVar = new c();
        }
        this.f178676b.put(i16, cVar.h(sessionInfo, str, arrayList, i16));
    }

    public void j(QQAppInterface qQAppInterface, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOrderManager", 2, "onSendCancel newSeq -> " + j3 + ", mForwardEntities.size() => " + this.f178676b.size());
        }
        a b16 = b(j3, false);
        if (b16 != null && b16.i(qQAppInterface, j3)) {
            this.f178676b.remove(b16.f178667a);
        }
    }

    public void k(QQAppInterface qQAppInterface, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOrderManager", 2, "onSendResult newSeq -> " + j3 + ", mForwardEntities.size() => " + this.f178676b.size());
        }
        a b16 = b(j3, false);
        if (b16 != null && b16.j(qQAppInterface, j3)) {
            this.f178676b.remove(b16.f178667a);
        }
    }

    public void l(QQAppInterface qQAppInterface, long j3, int i3) {
        a aVar = this.f178676b.get(i3);
        if (aVar != null) {
            aVar.k(qQAppInterface, j3);
        }
    }

    public void m(MessageRecord messageRecord, MessageRecord messageRecord2, int i3) {
        synchronized (this) {
            this.f178676b.get(i3).l(messageRecord.uniseq, messageRecord2.uniseq);
        }
    }
}
