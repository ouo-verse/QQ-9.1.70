package com.tencent.qqperf.monitor.crash;

import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes25.dex */
public class CrashRunStepRecordHelper {

    /* renamed from: d, reason: collision with root package name */
    private static final Boolean f363123d = Boolean.FALSE;

    /* renamed from: e, reason: collision with root package name */
    private static volatile CrashRunStepRecordHelper f363124e;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f363125a = false;

    /* renamed from: b, reason: collision with root package name */
    private volatile ConcurrentLinkedQueue<a> f363126b = new ConcurrentLinkedQueue<>();

    /* renamed from: c, reason: collision with root package name */
    private volatile CrashRunStepLogRecorder f363127c = new CrashRunStepLogRecorder();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class CrashRunStepLogRecorder implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private volatile long f363128d = -1;

        CrashRunStepLogRecorder() {
        }

        private boolean e() {
            CrashRunStepRecordHelper.this.d("checkRecordTime lastRecordTime:" + this.f363128d);
            long currentTimeMillis = System.currentTimeMillis() - this.f363128d;
            CrashRunStepRecordHelper.this.d("checkRecordTime checktime:" + currentTimeMillis);
            if (currentTimeMillis < 10000) {
                return true;
            }
            return false;
        }

        private void f() {
            CrashRunStepRecordHelper.this.d("runInner logItems size=" + CrashRunStepRecordHelper.this.f363126b.size());
            a aVar = (a) CrashRunStepRecordHelper.this.f363126b.poll();
            if (aVar == null) {
                CrashRunStepRecordHelper.this.d("runInner logItem is null");
                return;
            }
            QLog.d("CrashRunStepReord", 1, "nStep=" + aVar.f363129a + " |timeCost=" + aVar.f363131c + " |subStepMsg:" + aVar.f363130b);
            this.f363128d = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    CrashRunStepRecordHelper.this.d("CrashRunStepLogReorder run start " + CrashRunStepRecordHelper.this.f363126b.size());
                    if (!CrashRunStepRecordHelper.this.f363126b.isEmpty()) {
                        this.f363128d = System.currentTimeMillis();
                    }
                    while (e()) {
                        f();
                    }
                } catch (OutOfMemoryError unused) {
                    CrashRunStepRecordHelper.this.f363126b.clear();
                }
            } finally {
                this.f363128d = -1L;
                CrashRunStepRecordHelper.this.f363125a = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        int f363129a;

        /* renamed from: b, reason: collision with root package name */
        String f363130b;

        /* renamed from: c, reason: collision with root package name */
        long f363131c;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (f363123d.booleanValue()) {
            Log.d("CrashRunStepReord", str);
        }
    }

    public static CrashRunStepRecordHelper e() {
        if (f363124e == null) {
            f363124e = new CrashRunStepRecordHelper();
        }
        return f363124e;
    }

    private void g() {
        if (this.f363125a) {
            return;
        }
        this.f363125a = true;
        ThreadManagerV2.excute(this.f363127c, 64, null, false);
    }

    public synchronized void f(int i3, String str, long j3) {
        a aVar = new a();
        aVar.f363129a = i3;
        if (str == null) {
            str = "";
        }
        aVar.f363130b = str;
        aVar.f363131c = j3;
        this.f363126b.offer(aVar);
        d("reordCrashRunStep logItems size=" + this.f363126b.size());
        g();
    }
}
