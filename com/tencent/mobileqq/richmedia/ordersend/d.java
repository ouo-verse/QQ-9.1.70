package com.tencent.mobileqq.richmedia.ordersend;

import android.text.TextUtils;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.bo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d implements OrderMediaMsgTimerController.a {

    /* renamed from: l, reason: collision with root package name */
    public static String f281633l = "OrderMediaMsgSessionQueue";

    /* renamed from: b, reason: collision with root package name */
    private OrderMediaMsgTimerController f281635b;

    /* renamed from: c, reason: collision with root package name */
    private OrderMediaMsgStatusCallback f281636c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.richmedia.ordersend.a f281637d;

    /* renamed from: e, reason: collision with root package name */
    private c f281638e;

    /* renamed from: f, reason: collision with root package name */
    private Iterator<com.tencent.mobileqq.richmedia.ordersend.b> f281639f;

    /* renamed from: g, reason: collision with root package name */
    private String f281640g;

    /* renamed from: j, reason: collision with root package name */
    protected OrderMediaMsgStatusCallback.b f281643j = new a();

    /* renamed from: k, reason: collision with root package name */
    bo f281644k = new b();

    /* renamed from: h, reason: collision with root package name */
    private int f281641h = 0;

    /* renamed from: i, reason: collision with root package name */
    private long f281642i = 0;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentLinkedQueue<com.tencent.mobileqq.richmedia.ordersend.b> f281634a = new ConcurrentLinkedQueue<>();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements OrderMediaMsgStatusCallback.b {
        a() {
        }

        @Override // com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.b
        public void a(long j3, int i3) {
            QLog.d(d.f281633l, 1, "notifyError uniseq:", Long.valueOf(j3), ", errCode:", Integer.valueOf(i3));
            d.this.u(j3);
        }

        @Override // com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.b
        public void b(long j3) {
            Iterator it = d.this.f281634a.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                com.tencent.mobileqq.richmedia.ordersend.b bVar = (com.tencent.mobileqq.richmedia.ordersend.b) it.next();
                if (j3 == bVar.f281625d && d.this.f281637d.i(bVar.f281629h)) {
                    d.this.u(j3);
                    z16 = true;
                }
            }
            QLog.d(d.f281633l, 1, "notifyCheckStatus uniseq:", Long.valueOf(j3), ", invalid:", Boolean.valueOf(z16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends bo {
        b() {
        }

        @Override // com.tencent.mobileqq.app.bo
        public void onNotifyResultAfterSendRich(boolean z16, long j3, StatictisInfo statictisInfo) {
            if (d.this.f281634a == null) {
                QLog.d(d.f281633l, 1, "return because queue is null, isSuccess:", Boolean.valueOf(z16), " ,uniseq:", Long.valueOf(j3));
                return;
            }
            com.tencent.mobileqq.richmedia.ordersend.b bVar = (com.tencent.mobileqq.richmedia.ordersend.b) d.this.f281634a.peek();
            if (bVar != null) {
                if (j3 == bVar.f281625d && bVar.f281624c == 4) {
                    bVar.f281624c = 5;
                    d.this.f281634a.remove(bVar);
                    d.this.f281635b.j();
                    bo boVar = bVar.f281630i;
                    if (boVar != null) {
                        boVar.onNotifyResultAfterSendRich(z16, j3, statictisInfo);
                    }
                    IOrderMediaMsgService.a aVar = bVar.f281631j;
                    if (aVar != null) {
                        aVar.onSendEnd(z16, j3);
                    }
                    if (bVar.f281627f) {
                        d.this.f281637d.removeCompressTask(j3);
                    }
                    d.this.f281636c.k(bVar.f281625d);
                    if (QLog.isColorLevel()) {
                        QLog.d(d.f281633l, 2, "OrderSendObserver remove uniseq:" + j3 + ", queue size:" + d.this.f281634a.size() + ", mNeedCompress:" + bVar.f281627f + ", issuccess:" + z16);
                    }
                } else {
                    QLog.d(d.f281633l, 1, "OrderSendObserver peekFirst but fail, status:", Integer.valueOf(bVar.f281624c), ", uniseq:", Long.valueOf(bVar.f281625d));
                }
            } else {
                QLog.d(d.f281633l, 1, "OrderSendObserver peekFirst is null. uniseq:", Long.valueOf(j3), ", issuccess:", Boolean.valueOf(z16));
            }
            d.this.t();
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface c {
        void onAllCompleted(String str);
    }

    public d(String str, com.tencent.mobileqq.richmedia.ordersend.a aVar) {
        this.f281640g = str;
        this.f281637d = aVar;
        OrderMediaMsgStatusCallback orderMediaMsgStatusCallback = new OrderMediaMsgStatusCallback(this.f281640g);
        this.f281636c = orderMediaMsgStatusCallback;
        orderMediaMsgStatusCallback.b(this.f281643j);
        this.f281635b = new OrderMediaMsgTimerController(this);
    }

    private void l(com.tencent.mobileqq.richmedia.ordersend.b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d(f281633l, 2, "doNextAddSend " + bVar.f281622a + ", uniseq:" + bVar.f281625d + ", addStatus:" + bVar.f281623b + ", sendStatus:" + bVar.f281624c);
        }
        this.f281636c.k(bVar.f281625d);
        if (bVar.c()) {
            this.f281637d.a(bVar.f281629h);
        }
        if (bVar.d()) {
            this.f281637d.c(bVar.f281629h, bVar.f281630i, bVar.f281631j);
        }
        s();
        t();
    }

    private MessageRecord o(long j3) {
        MessageRecord messageRecord = null;
        if (j3 != 0) {
            Iterator<com.tencent.mobileqq.richmedia.ordersend.b> it = this.f281634a.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.richmedia.ordersend.b next = it.next();
                if (j3 == next.f281625d) {
                    messageRecord = next.f281629h;
                }
            }
        }
        return messageRecord;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00cb, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00cd, code lost:
    
        com.tencent.qphone.base.util.QLog.d(com.tencent.mobileqq.richmedia.ordersend.d.f281633l, 2, "not ready to add " + r1.f281622a + ", path:" + r1.f281626e + ", mStatus:" + r1.f281623b);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void s() {
        Iterator<com.tencent.mobileqq.richmedia.ordersend.b> it = this.f281634a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.tencent.mobileqq.richmedia.ordersend.b next = it.next();
            if (next.c()) {
                next.f281623b = 2;
                this.f281636c.c(next.f281625d);
                this.f281637d.a(next.f281629h);
                if (QLog.isColorLevel()) {
                    QLog.d(f281633l, 2, "success in add " + next.f281622a + ", uniseq:" + next.f281625d + ", path:" + next.f281626e + ", status:" + next.f281623b);
                }
                Runnable runnable = next.f281632k;
                if (runnable != null) {
                    this.f281635b.i(runnable);
                    next.f281632k = null;
                    if (QLog.isColorLevel()) {
                        QLog.d(f281633l, 2, "remove mAddTimeoutRunable1 uniseq:" + next.f281625d);
                    }
                }
                if (next.f281628g) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f281633l, 2, "invalid msg:" + next.f281625d);
                    }
                    u(next.f281625d);
                }
            } else if (!next.a()) {
                break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void t() {
        if (this.f281634a.isEmpty()) {
            com.tencent.mobileqq.richmedia.ordersend.c.c(this.f281641h, System.currentTimeMillis() - this.f281642i);
            c cVar = this.f281638e;
            if (cVar != null) {
                cVar.onAllCompleted(this.f281640g);
            }
            this.f281635b.g();
            this.f281642i = 0L;
            this.f281641h = 0;
            return;
        }
        com.tencent.mobileqq.richmedia.ordersend.b peek = this.f281634a.peek();
        if (peek != null) {
            if (peek.d()) {
                peek.f281624c = 4;
                this.f281635b.k();
                this.f281635b.e(peek.f281625d);
                this.f281637d.c(peek.f281629h, this.f281644k, peek.f281631j);
                if (QLog.isColorLevel()) {
                    QLog.d(f281633l, 2, "success in send " + peek.f281622a + ", uniseq:" + peek.f281625d + ", dest:" + peek.f281626e + ", status:" + peek.f281624c);
                }
            } else if (!peek.b()) {
                if (this.f281637d.d(peek.f281629h)) {
                    peek.f281627f = true;
                }
                boolean f16 = this.f281635b.f(peek.f281625d);
                if (QLog.isColorLevel()) {
                    QLog.d(f281633l, 2, "not ready to send " + peek.f281622a + ", uniseq:" + peek.f281625d + ", dest:" + peek.f281626e + ", status:" + peek.f281624c + ", needCompress:" + peek.f281627f + ", addSuccess:" + f16);
                }
            }
            QLog.d(f281633l, 1, "queue peek", peek.toString());
        } else {
            QLog.d(f281633l, 1, "queue peek is empty!");
        }
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.a
    public void a(long j3) {
        int i3;
        boolean z16;
        this.f281635b.k();
        com.tencent.mobileqq.richmedia.ordersend.b bVar = null;
        if (j3 != 0) {
            if (this.f281637d.i(o(j3))) {
                bVar = u(j3);
            }
        } else if (!this.f281634a.isEmpty()) {
            com.tencent.mobileqq.richmedia.ordersend.b peek = this.f281634a.peek();
            if (peek != null && this.f281637d.i(peek.f281629h)) {
                bVar = u(peek.f281625d);
            }
            QLog.d(f281633l, 1, "uniseq is invalid:", Long.valueOf(j3));
        }
        if (bVar != null) {
            MessageRecord messageRecord = bVar.f281629h;
            if (messageRecord == null) {
                i3 = 0;
            } else {
                i3 = messageRecord.msgtype;
            }
            z16 = true;
        } else {
            i3 = -1;
            z16 = false;
        }
        com.tencent.mobileqq.richmedia.ordersend.c.d(i3, z16);
        if (!z16) {
            this.f281635b.b(j3, this.f281637d.f(o(j3)), 3);
        }
        QLog.d(f281633l, 1, "timeout!!! upload msg:", Long.valueOf(j3), " ,invalid:", Boolean.valueOf(z16), " ,msgtype:", Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.a
    public void b(Object obj) {
        com.tencent.mobileqq.richmedia.ordersend.b bVar;
        int i3;
        int i16;
        MessageRecord messageRecord;
        if (obj instanceof Long) {
            bVar = u(((Long) obj).longValue());
            i3 = 1;
        } else if (obj instanceof String) {
            bVar = v((String) obj);
            i3 = 2;
        } else {
            bVar = null;
            i3 = 0;
        }
        if (bVar != null && (messageRecord = bVar.f281629h) != null) {
            i16 = messageRecord.msgtype;
        } else {
            i16 = -1;
        }
        com.tencent.mobileqq.richmedia.ordersend.c.b(i16, i3);
        QLog.d(f281633l, 1, "timeout!!! add msg:", obj, " ,msgtype:", Integer.valueOf(i16));
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.a
    public void c(long j3) {
        this.f281635b.j();
        com.tencent.mobileqq.richmedia.ordersend.b u16 = u(j3);
        if (u16 != null) {
            QLog.d(f281633l, 1, "timeout!!! send msg:", Long.valueOf(j3), u16.toString());
        } else {
            QLog.d(f281633l, 1, "timeout!!! send msg:", Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.a
    public void d(long j3, int i3, int i16) {
        this.f281635b.h(j3);
        if (i16 == 0) {
            u(j3);
            QLog.d(f281633l, 1, "blocking!!! count zero ", Long.valueOf(j3));
        } else {
            if (i3 == -1) {
                this.f281635b.b(j3, this.f281637d.f(o(j3)), i16 - 1);
                return;
            }
            int f16 = this.f281637d.f(o(j3));
            if (f16 > i3) {
                this.f281635b.b(j3, f16, i16);
            } else {
                u(j3);
                QLog.d(f281633l, 1, "blocking!!! progress stuck ", Long.valueOf(j3));
            }
        }
    }

    public void j(MessageRecord messageRecord, long j3, String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(f281633l, 2, "addOrderMsgRecord uniseq:" + j3 + ", path:" + str + ", realadd:" + z16);
        }
        Iterator<com.tencent.mobileqq.richmedia.ordersend.b> it = this.f281634a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.tencent.mobileqq.richmedia.ordersend.b next = it.next();
            long j16 = next.f281625d;
            if (j16 != 0 && j3 == j16) {
                next.f281629h = messageRecord;
                if (z16) {
                    next.f281623b = 1;
                } else {
                    next.f281623b = 2;
                    Runnable runnable = next.f281632k;
                    if (runnable != null) {
                        this.f281635b.i(runnable);
                        next.f281632k = null;
                        if (QLog.isColorLevel()) {
                            QLog.d(f281633l, 2, "remove mAddTimeoutRunable2 uniseq:" + next.f281625d);
                        }
                    }
                }
            } else if (j16 == 0 && !TextUtils.isEmpty(str) && str.equals(next.f281626e)) {
                next.f281629h = messageRecord;
                next.f281625d = j3;
                if (z16) {
                    next.f281623b = 1;
                } else {
                    next.f281623b = 2;
                    Runnable runnable2 = next.f281632k;
                    if (runnable2 != null) {
                        this.f281635b.i(runnable2);
                        next.f281632k = null;
                        if (QLog.isColorLevel()) {
                            QLog.d(f281633l, 2, "remove mAddTimeoutRunable3 uniseq:" + next.f281625d);
                        }
                    }
                }
            }
        }
        if (z16) {
            s();
        }
    }

    public void k() {
        OrderMediaMsgStatusCallback orderMediaMsgStatusCallback = this.f281636c;
        if (orderMediaMsgStatusCallback != null) {
            orderMediaMsgStatusCallback.d();
            this.f281636c = null;
        }
        ConcurrentLinkedQueue<com.tencent.mobileqq.richmedia.ordersend.b> concurrentLinkedQueue = this.f281634a;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
            this.f281634a = null;
        }
        OrderMediaMsgTimerController orderMediaMsgTimerController = this.f281635b;
        if (orderMediaMsgTimerController != null) {
            orderMediaMsgTimerController.g();
            this.f281635b = null;
        }
        this.f281638e = null;
    }

    public void m(long j3, String str) {
        n(j3, str, false);
    }

    public void n(long j3, String str, boolean z16) {
        com.tencent.mobileqq.richmedia.ordersend.b bVar = new com.tencent.mobileqq.richmedia.ordersend.b();
        bVar.f281625d = j3;
        bVar.f281626e = str;
        bVar.f281628g = z16;
        int i3 = this.f281641h + 1;
        this.f281641h = i3;
        bVar.f281622a = i3;
        bVar.f281623b = 0;
        bVar.f281624c = 0;
        this.f281634a.offer(bVar);
        if (j3 != 0) {
            bVar.f281632k = this.f281635b.c(j3);
        } else {
            bVar.f281632k = this.f281635b.d(str);
        }
        if (this.f281642i == 0) {
            this.f281642i = System.currentTimeMillis();
        }
        if (QLog.isColorLevel()) {
            QLog.d(f281633l, 2, "enqueueMediaMsg msgSize:" + this.f281641h + ", uniseq:" + j3 + ", path:" + str + ", queue:" + this.f281634a.size());
        }
    }

    public OrderMediaMsgStatusCallback p() {
        return this.f281636c;
    }

    public boolean q(long j3, String str) {
        Iterator<com.tencent.mobileqq.richmedia.ordersend.b> it = this.f281634a.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.richmedia.ordersend.b next = it.next();
            long j16 = next.f281625d;
            if (j16 != 0 && j3 == j16) {
                return true;
            }
            if (j16 == 0 && !TextUtils.isEmpty(str) && str.equals(next.f281626e)) {
                return true;
            }
        }
        return false;
    }

    public boolean r() {
        return this.f281634a.isEmpty();
    }

    public com.tencent.mobileqq.richmedia.ordersend.b u(long j3) {
        this.f281639f = this.f281634a.iterator();
        while (this.f281639f.hasNext()) {
            com.tencent.mobileqq.richmedia.ordersend.b next = this.f281639f.next();
            if (j3 == next.f281625d) {
                if (QLog.isColorLevel()) {
                    QLog.d(f281633l, 2, "removeMediaMsgByUniseq " + next.f281622a + ", uniseq:" + next.f281625d);
                }
                this.f281639f.remove();
                l(next);
                return next;
            }
        }
        return null;
    }

    public com.tencent.mobileqq.richmedia.ordersend.b v(String str) {
        this.f281639f = this.f281634a.iterator();
        while (this.f281639f.hasNext()) {
            com.tencent.mobileqq.richmedia.ordersend.b next = this.f281639f.next();
            if (str.equals(next.f281626e)) {
                if (QLog.isColorLevel()) {
                    QLog.d(f281633l, 2, "removeMediaMsgByPath " + next.f281622a + ", uniseq:" + next.f281625d);
                }
                this.f281639f.remove();
                l(next);
                return next;
            }
        }
        return null;
    }

    public void w(MessageRecord messageRecord, bo boVar, IOrderMediaMsgService.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d(f281633l, 2, "sendOrderMsgRecord:" + messageRecord.uniseq);
        }
        Iterator<com.tencent.mobileqq.richmedia.ordersend.b> it = this.f281634a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.tencent.mobileqq.richmedia.ordersend.b next = it.next();
            if (messageRecord.uniseq == next.f281625d) {
                next.f281629h = messageRecord;
                next.f281630i = boVar;
                next.f281631j = aVar;
                next.f281624c = 3;
                if (QLog.isColorLevel()) {
                    QLog.d(f281633l, 2, "ready to send " + next.f281622a + ", uniseq:" + next.f281625d + ", addStatus:" + next.f281623b + ", sendStatus:" + next.f281624c);
                }
            }
        }
        t();
    }

    public void x(c cVar) {
        this.f281638e = cVar;
    }

    public void y(long j3, long j16) {
        if (j3 != 0 && j16 != 0) {
            boolean z16 = false;
            if (!this.f281634a.isEmpty()) {
                Iterator<com.tencent.mobileqq.richmedia.ordersend.b> it = this.f281634a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.mobileqq.richmedia.ordersend.b next = it.next();
                    if (j3 == next.f281625d) {
                        next.f281625d = j16;
                        Runnable runnable = next.f281632k;
                        if (runnable != null) {
                            this.f281635b.i(runnable);
                            next.f281632k = this.f281635b.c(j16);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(f281633l, 2, "updateMediaMsgByUniseq old:", Long.valueOf(j3), ", new:", Long.valueOf(j16));
                        }
                        z16 = true;
                    }
                }
            }
            if (!z16) {
                m(j16, "");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f281633l, 2, "oldSeq and newSeq should not be zero");
        }
    }
}
