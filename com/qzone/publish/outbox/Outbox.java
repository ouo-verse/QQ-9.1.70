package com.qzone.publish.outbox;

import NS_MOBILE_MAIN_PAGE.mobile_sub_set_cover_req;
import NS_MOBILE_OPERATION.operation_like_req;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.cover.business.protocol.QZoneSetCoverRequest;
import common.config.service.QzoneConfig;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.statistic.AccManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes39.dex */
public class Outbox implements c9.a {

    /* renamed from: o, reason: collision with root package name */
    private static Outbox f51231o;

    /* renamed from: a, reason: collision with root package name */
    private long f51232a;

    /* renamed from: e, reason: collision with root package name */
    private Handler f51236e;

    /* renamed from: g, reason: collision with root package name */
    private int f51238g;

    /* renamed from: h, reason: collision with root package name */
    private int f51239h;

    /* renamed from: i, reason: collision with root package name */
    private int f51240i;

    /* renamed from: j, reason: collision with root package name */
    private Runnable f51241j;

    /* renamed from: k, reason: collision with root package name */
    private Runnable f51242k;

    /* renamed from: l, reason: collision with root package name */
    private Runnable f51243l;

    /* renamed from: m, reason: collision with root package name */
    private Runnable f51244m;

    /* renamed from: n, reason: collision with root package name */
    private Runnable f51245n;

    /* renamed from: b, reason: collision with root package name */
    private a f51233b = new a();

    /* renamed from: c, reason: collision with root package name */
    private c f51234c = new c();

    /* renamed from: d, reason: collision with root package name */
    private d9.a f51235d = d9.a.b();

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f51237f = false;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class GroupQueue<T> extends ConcurrentLinkedQueue<T> {
        volatile boolean mPending = false;

        public GroupQueue() {
        }

        public boolean isPending() {
            return this.mPending;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
        public T peek() {
            if (this.mPending) {
                return null;
            }
            return (T) super.peek();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
        public T poll() {
            if (this.mPending) {
                return null;
            }
            return (T) super.poll();
        }

        public void setPending(boolean z16) {
            this.mPending = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends SparseArray<GroupQueue<com.qzone.publish.outbox.a>> {
        public a() {
        }

        public void a(com.qzone.publish.outbox.a aVar) {
            int i3 = aVar.f51255e;
            GroupQueue<com.qzone.publish.outbox.a> groupQueue = get(i3);
            if (groupQueue == null) {
                groupQueue = new GroupQueue<>();
                put(i3, groupQueue);
            }
            groupQueue.offer(aVar);
        }

        public com.qzone.publish.outbox.a b(int i3) {
            GroupQueue<com.qzone.publish.outbox.a> groupQueue = get(i3);
            if (groupQueue != null) {
                return groupQueue.peek();
            }
            return null;
        }

        public com.qzone.publish.outbox.a c(int i3) {
            GroupQueue<com.qzone.publish.outbox.a> groupQueue = get(i3);
            if (groupQueue != null) {
                return groupQueue.poll();
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b extends Handler {
        b() {
        }

        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            com.qzone.publish.outbox.a aVar;
            if (message == null) {
                return;
            }
            int i3 = message.what;
            if (i3 == 0) {
                com.qzone.publish.outbox.a aVar2 = (com.qzone.publish.outbox.a) message.obj;
                if (aVar2 != null) {
                    if (QZLog.isDevelopLevel()) {
                        QZLog.d("Outbox", 4, "startSession. session sid,gid,gname:" + aVar2.f51256f + "," + aVar2.f51255e + "," + aVar2.f51254d);
                    }
                    if (Outbox.this.z(aVar2)) {
                        Outbox.this.y(aVar2);
                        if (NetworkState.isNetSupport()) {
                            Outbox.this.P(aVar2.f51255e);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (i3 == 1) {
                Outbox.this.f51237f = false;
                Outbox.this.f51233b.clear();
                Outbox.this.f51234c.clear();
                Outbox.this.f51235d.a();
                Outbox.this.f51236e.removeCallbacks(Outbox.this.f51245n);
                Outbox.this.f51236e.removeCallbacks(Outbox.this.f51241j);
                Outbox.this.f51236e.removeCallbacks(Outbox.this.f51242k);
                Outbox.this.f51236e.removeCallbacks(Outbox.this.f51243l);
                Outbox.this.f51236e.removeCallbacks(Outbox.this.f51244m);
                return;
            }
            if (i3 == 2) {
                com.qzone.publish.outbox.a aVar3 = (com.qzone.publish.outbox.a) message.obj;
                if (aVar3 != null) {
                    if (QZLog.isDevelopLevel()) {
                        QZLog.d("Outbox", 4, "onSessionSuccess. session sid,gid,gname:" + aVar3.f51256f + "," + aVar3.f51255e + "," + aVar3.f51254d);
                    }
                    aVar3.setFinish();
                    aVar3.finish();
                    Outbox.this.B(aVar3.f51255e, aVar3);
                    return;
                }
                return;
            }
            if (i3 == 3) {
                com.qzone.publish.outbox.a aVar4 = (com.qzone.publish.outbox.a) message.obj;
                if (aVar4 != null) {
                    if (QZLog.isDevelopLevel()) {
                        QZLog.d("Outbox", 4, "onSessionOut. session sid,gid,gname:" + aVar4.f51256f + "," + aVar4.f51255e + "," + aVar4.f51254d);
                    }
                    aVar4.setCancel();
                    aVar4.cancel();
                    aVar4.finish();
                    Outbox.this.B(aVar4.f51255e, aVar4);
                    return;
                }
                return;
            }
            if (i3 != 4) {
                if (i3 == 5 && (aVar = (com.qzone.publish.outbox.a) message.obj) != null) {
                    if (QZLog.isDevelopLevel()) {
                        QZLog.d("Outbox", 4, "onSessionRetry. session sid,gid,gname:" + aVar.f51256f + "," + aVar.f51255e + "," + aVar.f51254d);
                    }
                    aVar.setPause();
                    Outbox.this.f51235d.g(aVar);
                    Outbox.this.I(true, aVar.f51255e);
                    return;
                }
                return;
            }
            com.qzone.publish.outbox.a aVar5 = (com.qzone.publish.outbox.a) message.obj;
            if (aVar5 != null) {
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("Outbox", 4, "onSessionFail. session sid,gid,gname:" + aVar5.f51256f + "," + aVar5.f51255e + "," + aVar5.f51254d + ", retryCnt = " + aVar5.getRetryCount());
                }
                aVar5.setPause();
                Outbox.this.f51235d.g(aVar5);
                if (aVar5.isInPeriod()) {
                    Outbox.this.I(true, aVar5.f51255e);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c extends SparseArray<com.qzone.publish.outbox.a> {
        public c() {
        }

        public com.qzone.publish.outbox.a a(int i3, GroupQueue<com.qzone.publish.outbox.a> groupQueue) {
            com.qzone.publish.outbox.a aVar = get(i3);
            if (aVar == null && (aVar = groupQueue.peek()) != null) {
                put(i3, aVar);
            }
            return aVar;
        }

        public void b(boolean z16, int i3, GroupQueue<com.qzone.publish.outbox.a> groupQueue) {
            String str;
            com.qzone.publish.outbox.a a16 = a(i3, groupQueue);
            if (a16 != null && a16.isPause()) {
                if (!z16) {
                    a16.clearRetryPerWakeUp();
                }
                int canRetry = a16.canRetry();
                if (canRetry == 1) {
                    a16.increaseRetry();
                    a16.increaseRetryPerWakeUp();
                    a16.setRunning();
                    a16.resume();
                    return;
                }
                if (canRetry == 3) {
                    if (a16 instanceof b9.a) {
                        StringBuilder sb5 = new StringBuilder();
                        b9.a aVar = (b9.a) a16;
                        if (aVar.getTask() != null && aVar.getTask().mRequest != null) {
                            str = aVar.getTask().mRequest.getCmdString();
                        } else {
                            str = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
                        }
                        sb5.append("b:");
                        sb5.append(str);
                        sb5.append(",o:");
                        sb5.append(aVar.getResultCode());
                        sb5.append(",c:");
                        sb5.append(aVar.getRetryCount());
                        sb5.append(",t:");
                        sb5.append(System.currentTimeMillis() - aVar.getmCreateTime());
                        AccManager.reportOutboxResult(1, 0, null, sb5.toString());
                    }
                    a16.setCancel();
                    Outbox.this.B(a16.f51255e, a16);
                    return;
                }
                a16.setPause();
                return;
            }
            if (QZLog.isDevelopLevel()) {
                QZLog.d("Outbox", 4, "group " + i3 + " no session to resume");
            }
        }

        public void c(int i3, GroupQueue<com.qzone.publish.outbox.a> groupQueue) {
            String str;
            com.qzone.publish.outbox.a a16 = a(i3, groupQueue);
            if (a16 == null) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("Outbox", 2, "group " + i3 + " no session to start: session is null");
                    return;
                }
                return;
            }
            if (!a16.isWaiting() && (!a16.isRunning() || a16.I <= 0 || System.currentTimeMillis() - a16.I <= 60000)) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("Outbox", 2, "group " + i3 + " no session to start: state is:" + a16.getState());
                    return;
                }
                return;
            }
            if (a16.canRetry() == 3) {
                if (a16 instanceof b9.a) {
                    StringBuilder sb5 = new StringBuilder();
                    b9.a aVar = (b9.a) a16;
                    if (aVar.getTask() != null && aVar.getTask().mRequest != null) {
                        str = aVar.getTask().mRequest.getCmdString();
                    } else {
                        str = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
                    }
                    sb5.append("b:");
                    sb5.append(str);
                    sb5.append(",o:");
                    sb5.append(aVar.getResultCode());
                    sb5.append(",c:");
                    sb5.append(aVar.getRetryCount());
                    sb5.append(",t:");
                    sb5.append(System.currentTimeMillis() - aVar.getmCreateTime());
                    AccManager.reportOutboxResult(1, 0, null, sb5.toString());
                }
                a16.setCancel();
                Outbox.this.B(a16.f51255e, a16);
                return;
            }
            a16.setRunning();
            a16.start();
        }
    }

    public Outbox() {
        b bVar;
        this.f51232a = 2000L;
        Looper looper = QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).getLooper();
        if (looper != null) {
            bVar = new b(looper);
        } else {
            bVar = new b();
        }
        this.f51236e = bVar;
        this.f51232a = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_OUTBOX, QzoneConfig.SECONDARY_OUTBOX_NEXT_INTERVAL, 2) * 1000;
    }

    public static final Outbox C() {
        if (f51231o == null) {
            synchronized (Outbox.class) {
                if (f51231o == null) {
                    f51231o = new Outbox();
                }
            }
        }
        return f51231o;
    }

    private synchronized void E(int i3, com.qzone.publish.outbox.a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.isCancel() || aVar.isFinish()) {
            aVar.setOnSessionCallback(null);
            aVar.setQuit();
            this.f51235d.e(aVar);
            com.qzone.publish.outbox.a b16 = this.f51233b.b(i3);
            if (!aVar.equals(b16)) {
                return;
            }
            this.f51234c.remove(i3);
            this.f51233b.c(i3);
            if (b16 != null) {
                b16.setOnSessionCallback(null);
                b16.setQuit();
            }
        }
    }

    private void H(boolean z16) {
        int size = this.f51233b.size();
        if (QZLog.isDevelopLevel()) {
            QZLog.d("Outbox", 4, "resumeAllInner." + z16 + ".group size : " + size);
        }
        for (int i3 = 0; i3 < size; i3++) {
            I(z16, this.f51233b.keyAt(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void I(boolean z16, int i3) {
        GroupQueue<com.qzone.publish.outbox.a> groupQueue = this.f51233b.get(i3);
        if (groupQueue != null && !groupQueue.isEmpty()) {
            this.f51234c.b(z16, i3, groupQueue);
            return;
        }
        if (QZLog.isDevelopLevel()) {
            QZLog.d("Outbox", 4, "group null or empty. gid:" + i3);
        }
    }

    private void K(boolean z16) {
        int size = this.f51233b.size();
        for (int i3 = 0; i3 < size; i3++) {
            L(z16, this.f51233b.keyAt(i3));
        }
    }

    private void L(boolean z16, int i3) {
        com.qzone.publish.outbox.a peek;
        GroupQueue<com.qzone.publish.outbox.a> groupQueue = this.f51233b.get(i3);
        if (groupQueue == null || (peek = groupQueue.peek()) == null) {
            return;
        }
        if (QZLog.isDevelopLevel()) {
            QZLog.d("Outbox", 4, "runGroup. gid,gname:" + i3 + "," + peek.f51254d);
        }
        if (!peek.isWaiting() && !peek.isRunning()) {
            if (peek.isPause()) {
                I(z16, i3);
                return;
            }
            return;
        }
        P(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(boolean z16) {
        Runnable runnable = new Runnable() { // from class: com.qzone.publish.outbox.Outbox.3
            @Override // java.lang.Runnable
            public void run() {
                Outbox.this.S();
            }
        };
        this.f51245n = runnable;
        this.f51236e.postDelayed(runnable, z16 ? 30000L : 180000L);
    }

    private void O() {
        int size = this.f51233b.size();
        for (int i3 = 0; i3 < size; i3++) {
            P(this.f51233b.keyAt(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void P(int i3) {
        GroupQueue<com.qzone.publish.outbox.a> groupQueue = this.f51233b.get(i3);
        if (groupQueue != null && !groupQueue.isEmpty()) {
            this.f51234c.c(i3, groupQueue);
        }
    }

    public void A() {
        this.f51236e.obtainMessage(1).sendToTarget();
    }

    public void D(final long j3) {
        this.f51236e.postDelayed(new Runnable() { // from class: com.qzone.publish.outbox.Outbox.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (Outbox.this) {
                    Outbox.this.f51235d.c(j3);
                    Outbox.this.F();
                    Outbox.this.f51237f = true;
                    Outbox.this.M(true);
                }
            }
        }, 3000L);
    }

    public synchronized void F() {
        R(this.f51235d.f());
    }

    public void G(final boolean z16) {
        if (this.f51237f) {
            H(z16);
            this.f51239h = 0;
            return;
        }
        if (QZLog.isDevelopLevel()) {
            QZLog.d("Outbox", 4, "resumeAll. but cache not init, wait 300ms.");
        }
        Runnable runnable = new Runnable() { // from class: com.qzone.publish.outbox.Outbox.5
            @Override // java.lang.Runnable
            public void run() {
                Outbox.this.f51239h++;
                if (Outbox.this.f51239h > 20) {
                    Outbox.this.f51239h = 0;
                } else {
                    Outbox.this.G(z16);
                }
            }
        };
        this.f51243l = runnable;
        this.f51236e.postDelayed(runnable, 300L);
    }

    public void J(final boolean z16) {
        if (this.f51237f) {
            K(z16);
            this.f51238g = 0;
            return;
        }
        if (QZLog.isDevelopLevel()) {
            QZLog.d("Outbox", 4, "runAll. but cache not init, wait 300ms.");
        }
        Runnable runnable = new Runnable() { // from class: com.qzone.publish.outbox.Outbox.6
            @Override // java.lang.Runnable
            public void run() {
                Outbox.this.f51238g++;
                if (Outbox.this.f51238g > 20) {
                    Outbox.this.f51238g = 0;
                } else {
                    Outbox.this.J(z16);
                }
            }
        };
        this.f51244m = runnable;
        this.f51236e.postDelayed(runnable, 300L);
    }

    public void N() {
        if (this.f51237f) {
            O();
            this.f51240i = 0;
            return;
        }
        if (QZLog.isDevelopLevel()) {
            QZLog.d("Outbox", 4, "startAll. but cache not init, wait 300ms.");
        }
        Runnable runnable = new Runnable() { // from class: com.qzone.publish.outbox.Outbox.4
            @Override // java.lang.Runnable
            public void run() {
                Outbox.this.f51240i++;
                if (Outbox.this.f51240i > 20) {
                    Outbox.this.f51240i = 0;
                } else {
                    Outbox.this.N();
                }
            }
        };
        this.f51242k = runnable;
        this.f51236e.postDelayed(runnable, 300L);
    }

    public synchronized void S() {
        if (NetworkState.isNetSupport()) {
            J(false);
        }
        M(false);
    }

    @Override // c9.a
    public void a(com.qzone.publish.outbox.a aVar) {
        this.f51236e.obtainMessage(2, aVar).sendToTarget();
    }

    @Override // c9.a
    public void b(com.qzone.publish.outbox.a aVar) {
        this.f51236e.obtainMessage(3, aVar).sendToTarget();
    }

    @Override // c9.a
    public void c(com.qzone.publish.outbox.a aVar) {
        this.f51236e.obtainMessage(4, aVar).sendToTarget();
    }

    public synchronized void y(com.qzone.publish.outbox.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.setOnSessionCallback(this);
        this.f51233b.a(aVar);
        this.f51235d.d(aVar);
    }

    private void R(List<com.qzone.publish.outbox.a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f51233b == null) {
            this.f51233b = new a();
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f51233b.a(list.get(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final int i3, com.qzone.publish.outbox.a aVar) {
        if (aVar == null) {
            return;
        }
        E(i3, aVar);
        final GroupQueue<com.qzone.publish.outbox.a> groupQueue = this.f51233b.get(i3);
        if (groupQueue == null || groupQueue.isPending() || groupQueue.isEmpty()) {
            return;
        }
        groupQueue.setPending(true);
        if (QZLog.isDevelopLevel()) {
            QZLog.d("Outbox", 4, "continueGroup. delay " + this.f51232a + " ms to start next.");
        }
        Runnable runnable = new Runnable() { // from class: com.qzone.publish.outbox.Outbox.2
            @Override // java.lang.Runnable
            public void run() {
                groupQueue.setPending(false);
                Outbox.this.P(i3);
            }
        };
        this.f51241j = runnable;
        this.f51236e.postDelayed(runnable, this.f51232a);
    }

    public void Q(com.qzone.publish.outbox.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f51236e.obtainMessage(0, aVar).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(com.qzone.publish.outbox.a aVar) {
        GroupQueue<com.qzone.publish.outbox.a> groupQueue;
        Iterator<com.qzone.publish.outbox.a> it;
        String str;
        String str2;
        if (aVar == null) {
            return false;
        }
        int i3 = 3;
        int i16 = 1;
        if (aVar.getmGroupName() != null && aVar.getmGroupName().equals("like")) {
            operation_like_req operation_like_reqVar = (operation_like_req) ((b9.a) aVar).getTask().mRequest.req;
            if (operation_like_reqVar == null || (groupQueue = this.f51233b.get(aVar.getGroupId())) == null || groupQueue.size() <= 0) {
                return true;
            }
            Iterator<com.qzone.publish.outbox.a> it5 = groupQueue.iterator();
            while (it5.hasNext()) {
                com.qzone.publish.outbox.a next = it5.next();
                if (next.canRetry() == i3) {
                    QZLog.d("Outbox", i16, "RETRY_NO_QUIT. session sid: :" + aVar.f51256f + ",gid: " + aVar.f51255e + ",gname: " + aVar.f51254d + ", action: " + operation_like_reqVar.action);
                } else {
                    QZoneRequest qZoneRequest = ((b9.a) next).getTask().mRequest;
                    operation_like_req operation_like_reqVar2 = qZoneRequest != null ? (operation_like_req) qZoneRequest.req : null;
                    if (operation_like_reqVar2 == null || (str = operation_like_reqVar.curkey) == null || (str2 = operation_like_reqVar2.curkey) == null || operation_like_reqVar.unikey == null || operation_like_reqVar2.unikey == null) {
                        it = it5;
                    } else {
                        GroupQueue<com.qzone.publish.outbox.a> groupQueue2 = groupQueue;
                        it = it5;
                        if (operation_like_reqVar2.uin == operation_like_reqVar.uin && str2.equals(str) && operation_like_reqVar2.unikey.equals(operation_like_reqVar.unikey) && operation_like_reqVar2.appid == operation_like_reqVar.appid) {
                            if (operation_like_reqVar2.action == operation_like_reqVar.action) {
                                QZLog.d("Outbox", 1, "same request, abort. session sid: :" + aVar.f51256f + ",gid: " + aVar.f51255e + ",gname: " + aVar.f51254d + ", action: " + operation_like_reqVar.action);
                                return false;
                            }
                            if (!next.isWaiting() && !next.isPause()) {
                                return true;
                            }
                            QZLog.d("Outbox", 1, "different request, removeSession. session sid: " + aVar.f51256f + ",gid: " + aVar.f51255e + ",gname: " + aVar.f51254d + ", action: " + operation_like_reqVar.action);
                            this.f51235d.e(next);
                            groupQueue2.remove(next);
                            return false;
                        }
                        groupQueue = groupQueue2;
                    }
                    it5 = it;
                    i3 = 3;
                    i16 = 1;
                }
            }
            return true;
        }
        if (aVar.getmGroupName() == null || !aVar.getmGroupName().equals("setCover")) {
            return true;
        }
        mobile_sub_set_cover_req mobile_sub_set_cover_reqVar = (mobile_sub_set_cover_req) ((QZoneSetCoverRequest) ((b9.a) aVar).getTask().mRequest).req;
        GroupQueue<com.qzone.publish.outbox.a> groupQueue3 = this.f51233b.get(aVar.getGroupId());
        if (groupQueue3 == null || groupQueue3.size() <= 0) {
            return true;
        }
        Iterator<com.qzone.publish.outbox.a> it6 = groupQueue3.iterator();
        while (it6.hasNext()) {
            com.qzone.publish.outbox.a next2 = it6.next();
            if (next2.canRetry() != 3) {
                mobile_sub_set_cover_req mobile_sub_set_cover_reqVar2 = (mobile_sub_set_cover_req) ((QZoneSetCoverRequest) ((b9.a) next2).getTask().mRequest).req;
                if (mobile_sub_set_cover_reqVar != null && mobile_sub_set_cover_reqVar2 != null && mobile_sub_set_cover_reqVar.cover != null && mobile_sub_set_cover_reqVar2.cover != null && mobile_sub_set_cover_reqVar2.uin == mobile_sub_set_cover_reqVar.uin) {
                    if (!next2.isWaiting() && !next2.isPause()) {
                        return true;
                    }
                    this.f51235d.e(next2);
                    groupQueue3.remove(next2);
                    return true;
                }
            }
        }
        return true;
    }
}
