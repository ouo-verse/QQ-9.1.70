package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class aq {

    /* renamed from: e, reason: collision with root package name */
    private static aq f98070e;

    /* renamed from: b, reason: collision with root package name */
    public ap f98072b;

    /* renamed from: c, reason: collision with root package name */
    public long f98073c;

    /* renamed from: d, reason: collision with root package name */
    public long f98074d;

    /* renamed from: f, reason: collision with root package name */
    private final Context f98075f;

    /* renamed from: g, reason: collision with root package name */
    private Map<Integer, Long> f98076g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f98077h = new LinkedBlockingQueue<>();

    /* renamed from: i, reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f98078i = new LinkedBlockingQueue<>();

    /* renamed from: j, reason: collision with root package name */
    private final Object f98079j = new Object();

    /* renamed from: k, reason: collision with root package name */
    private long f98080k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f98081l = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ae f98071a = ae.a();

    aq(Context context) {
        this.f98075f = context;
    }

    static /* synthetic */ int b(aq aqVar) {
        int i3 = aqVar.f98081l - 1;
        aqVar.f98081l = i3;
        return i3;
    }

    public static synchronized aq a(Context context) {
        aq aqVar;
        synchronized (aq.class) {
            if (f98070e == null) {
                f98070e = new aq(context);
            }
            aqVar = f98070e;
        }
        return aqVar;
    }

    public final boolean b(int i3) {
        if (p.f98529c) {
            av.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - a(i3);
        av.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i3));
        if (currentTimeMillis >= 30000) {
            return true;
        }
        av.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    public static synchronized aq a() {
        aq aqVar;
        synchronized (aq.class) {
            aqVar = f98070e;
        }
        return aqVar;
    }

    public final void a(int i3, cj cjVar, String str, String str2, ap apVar, long j3, boolean z16) {
        try {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            a(new ar(this.f98075f, i3, cjVar.f98433g, am.a((Object) cjVar), str, str2, apVar, z16), true, true, j3);
        } catch (Throwable th6) {
            th = th6;
            if (av.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private void b() {
        at a16 = at.a();
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        final LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.f98079j) {
            av.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            int size = this.f98077h.size();
            final int size2 = this.f98078i.size();
            if (size == 0 && size2 == 0) {
                av.c("[UploadManager] There is no upload task in queue.", new Object[0]);
                return;
            }
            if (a16 == null || !a16.b()) {
                size2 = 0;
            }
            a(this.f98077h, linkedBlockingQueue, size);
            a(this.f98078i, linkedBlockingQueue2, size2);
            a(size, linkedBlockingQueue);
            if (size2 > 0) {
                av.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            }
            at a17 = at.a();
            if (a17 != null) {
                a17.a(new Runnable() { // from class: com.tencent.bugly.proguard.aq.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Runnable runnable;
                        for (int i3 = 0; i3 < size2 && (runnable = (Runnable) linkedBlockingQueue2.poll()) != null; i3++) {
                            runnable.run();
                        }
                    }
                });
            }
        }
    }

    public final void a(byte[] bArr, String str, String str2, ap apVar, boolean z16) {
        try {
            a(new as(this.f98075f, bArr, str, str2, apVar), z16, false, 0L);
        } catch (Throwable th5) {
            if (av.a(th5)) {
                return;
            }
            th5.printStackTrace();
        }
    }

    public final void a(int i3, cj cjVar, String str, String str2, ap apVar) {
        try {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            a(new ar(this.f98075f, i3, cjVar.f98433g, am.a((Object) cjVar), str, str2, apVar, 0, 0, false), false, false, 0L);
        } catch (Throwable th6) {
            th = th6;
            if (av.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final long a(boolean z16) {
        long j3;
        long b16 = ba.b();
        int i3 = z16 ? 5 : 3;
        List<ag> a16 = this.f98071a.a(i3);
        if (a16 != null && a16.size() > 0) {
            j3 = 0;
            try {
                ag agVar = a16.get(0);
                if (agVar.f97982e >= b16) {
                    j3 = ba.d(agVar.f97984g);
                    if (i3 == 3) {
                        this.f98073c = j3;
                    } else {
                        this.f98074d = j3;
                    }
                    a16.remove(agVar);
                }
            } catch (Throwable th5) {
                av.a(th5);
            }
            if (a16.size() > 0) {
                this.f98071a.a(a16);
            }
        } else {
            j3 = z16 ? this.f98074d : this.f98073c;
        }
        av.c("[UploadManager] Local network consume: %d KB", Long.valueOf(j3 / 1024));
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void a(long j3, boolean z16) {
        int i3 = z16 ? 5 : 3;
        ag agVar = new ag();
        agVar.f97979b = i3;
        agVar.f97982e = ba.b();
        agVar.f97980c = "";
        agVar.f97981d = "";
        agVar.f97984g = ba.c(j3);
        this.f98071a.b(i3);
        this.f98071a.a(agVar);
        if (z16) {
            this.f98074d = j3;
        } else {
            this.f98073c = j3;
        }
        av.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j3 / 1024));
    }

    public final synchronized void a(int i3, long j3) {
        if (i3 < 0) {
            av.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i3));
            return;
        }
        this.f98076g.put(Integer.valueOf(i3), Long.valueOf(j3));
        ag agVar = new ag();
        agVar.f97979b = i3;
        agVar.f97982e = j3;
        agVar.f97980c = "";
        agVar.f97981d = "";
        agVar.f97984g = new byte[0];
        this.f98071a.b(i3);
        this.f98071a.a(agVar);
        av.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i3), ba.a(j3));
    }

    public final synchronized long a(int i3) {
        if (i3 >= 0) {
            Long l3 = this.f98076g.get(Integer.valueOf(i3));
            if (l3 != null) {
                return l3.longValue();
            }
        } else {
            av.e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i3));
        }
        return 0L;
    }

    private static void a(LinkedBlockingQueue<Runnable> linkedBlockingQueue, LinkedBlockingQueue<Runnable> linkedBlockingQueue2, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            Runnable peek = linkedBlockingQueue.peek();
            if (peek == null) {
                return;
            }
            try {
                linkedBlockingQueue2.put(peek);
                linkedBlockingQueue.poll();
            } catch (Throwable th5) {
                av.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th5.getMessage());
            }
        }
    }

    private void a(int i3, LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        at a16 = at.a();
        if (i3 > 0) {
            av.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(i3), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        }
        for (int i16 = 0; i16 < i3; i16++) {
            final Runnable poll = linkedBlockingQueue.poll();
            if (poll == null) {
                return;
            }
            synchronized (this.f98079j) {
                if (this.f98081l >= 2 && a16 != null) {
                    a16.a(poll);
                } else {
                    av.a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                    if (ba.a(new Runnable() { // from class: com.tencent.bugly.proguard.aq.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            poll.run();
                            synchronized (aq.this.f98079j) {
                                aq.b(aq.this);
                            }
                        }
                    }, "BUGLY_ASYNC_UPLOAD") != null) {
                        synchronized (this.f98079j) {
                            this.f98081l++;
                        }
                    } else {
                        av.d("[UploadManager] Failed to start a thread to execute asynchronous upload task,will try again next time.", new Object[0]);
                        a(poll, true);
                    }
                }
            }
        }
    }

    private boolean a(Runnable runnable, boolean z16) {
        if (runnable == null) {
            av.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            av.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f98079j) {
                if (z16) {
                    this.f98077h.put(runnable);
                } else {
                    this.f98078i.put(runnable);
                }
            }
            return true;
        } catch (Throwable th5) {
            av.e("[UploadManager] Failed to add upload task to queue: %s", th5.getMessage());
            return false;
        }
    }

    private void a(Runnable runnable, long j3) {
        if (runnable == null) {
            av.d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        av.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread a16 = ba.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (a16 == null) {
            av.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            a16.join(j3);
        } catch (Throwable th5) {
            av.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th5.getMessage());
            a(runnable, true);
            b();
        }
    }

    public final void a(Runnable runnable, boolean z16, boolean z17, long j3) {
        av.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z17) {
            a(runnable, j3);
        } else {
            a(runnable, z16);
            b();
        }
    }
}
