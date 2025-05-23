package com.tencent.mobileqq.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SendMessageHandler extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private long f307273a;

    /* renamed from: b, reason: collision with root package name */
    private List<SendMessageRunnable> f307274b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f307275c;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f307276d;

    /* renamed from: e, reason: collision with root package name */
    public long f307277e;

    public SendMessageHandler() {
        super(Looper.getMainLooper());
        this.f307273a = System.currentTimeMillis();
        this.f307274b = Collections.synchronizedList(new ArrayList());
        this.f307275c = 0;
        this.f307276d = 0;
        this.f307277e = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(long j3, String str) {
        if (this.f307275c < this.f307274b.size() && this.f307274b.size() >= 1) {
            int i3 = this.f307275c;
            this.f307275c = i3 + 1;
            SendMessageRunnable sendMessageRunnable = this.f307274b.get(i3);
            sendMessageRunnable.D = i3;
            sendMessageRunnable.f307285m = System.currentTimeMillis();
            sendMessageRunnable.f307281e = j3;
            sendMessageRunnable.E = str;
            sendMessageRunnable.run();
        }
    }

    public synchronized long b(long j3) {
        return j3 - this.f307273a;
    }

    public synchronized boolean c() {
        for (int i3 = 0; i3 < this.f307276d; i3++) {
            if (!this.f307274b.get(i3).f307280d) {
                return false;
            }
        }
        return true;
    }

    public synchronized void d(SendMessageRunnable sendMessageRunnable) {
        sendMessageRunnable.f307284i = this.f307273a;
        this.f307274b.add(sendMessageRunnable);
    }

    public synchronized boolean e(int i3, long j3, long j16, String[] strArr) {
        if (i3 < this.f307275c) {
            SendMessageRunnable sendMessageRunnable = this.f307274b.get(i3);
            sendMessageRunnable.C = System.currentTimeMillis();
            sendMessageRunnable.f307282f = j3;
            sendMessageRunnable.f307283h = j16;
            sendMessageRunnable.f307280d = true;
            sendMessageRunnable.F = strArr;
            if (QLog.isColorLevel()) {
                QLog.d("WMJ", 2, "--->>>recordRetryResult msgSeq[" + this.f307277e + "] retryIndex[" + i3 + "] errorCode[" + j3 + "] serverReplyCode[" + j16 + "] retryInfo:" + toString());
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.e("WMJ", 2, "retry runnalbe not found!");
        }
        return false;
    }

    public synchronized boolean f(long j3, final long j16, final String str) {
        if (this.f307276d >= this.f307274b.size()) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.SendMessageHandler", 2, "shedule retry, seq:" + this.f307277e + "delayTime:" + j3 + ",timeout:" + j16 + " scheduleCount:" + this.f307276d + " reason:" + str);
        }
        this.f307276d++;
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.utils.SendMessageHandler.1
            @Override // java.lang.Runnable
            public void run() {
                SendMessageHandler.this.g(j16, str);
            }
        }, j3);
        return true;
    }

    public synchronized void h() {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.SendMessageHandler", 2, "stopAndRemoveRunnalbes");
        }
        removeCallbacksAndMessages(null);
        this.f307274b.clear();
        this.f307275c = 0;
        this.f307276d = 0;
    }

    @Override // android.os.Handler
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[");
        synchronized (this) {
            int i3 = this.f307275c;
            if (i3 > 0 && this.f307274b.size() >= i3) {
                for (int i16 = 0; i16 < i3; i16++) {
                    try {
                        sb5.append(this.f307274b.get(i16).toString());
                        if (i16 != i3 - 1) {
                            sb5.append(",");
                        }
                    } catch (Exception e16) {
                        sb5.append(e16.getMessage());
                    }
                }
            }
        }
        sb5.append("]");
        return sb5.toString();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class SendMessageRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public boolean f307280d = false;

        /* renamed from: e, reason: collision with root package name */
        public long f307281e = -1;

        /* renamed from: f, reason: collision with root package name */
        public long f307282f = Long.MAX_VALUE;

        /* renamed from: h, reason: collision with root package name */
        public long f307283h = Long.MAX_VALUE;

        /* renamed from: i, reason: collision with root package name */
        public long f307284i = -1;

        /* renamed from: m, reason: collision with root package name */
        public long f307285m = -1;
        public long C = -1;
        public int D = -1;
        public String E = "";
        public String[] F = new String[0];

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("{");
            sb5.append("index:");
            sb5.append(String.valueOf(this.D));
            sb5.append(",reason:");
            sb5.append(this.E);
            sb5.append(",startTime:");
            sb5.append(String.valueOf(this.f307285m - this.f307284i));
            sb5.append(",timeOut:");
            sb5.append(String.valueOf((this.f307285m - this.f307284i) + this.f307281e));
            if (this.f307280d) {
                sb5.append(",duration:");
                sb5.append(String.valueOf(this.C - this.f307285m));
                sb5.append(",error:");
                sb5.append(String.valueOf(this.f307282f));
                if (this.f307283h != Long.MAX_VALUE) {
                    sb5.append(",serverReply:");
                    sb5.append(String.valueOf(this.f307283h));
                }
            } else {
                sb5.append(",status:RUNNING");
            }
            sb5.append("}");
            return sb5.toString();
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
