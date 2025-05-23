package com.tencent.av.qavperf.manager;

import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class QAVPMemoryManager implements Handler.Callback {
    private int C;
    private SessionInfo D;
    private volatile boolean F;

    /* renamed from: i, reason: collision with root package name */
    private final VideoAppInterface f74224i;

    /* renamed from: m, reason: collision with root package name */
    private int f74225m;

    /* renamed from: f, reason: collision with root package name */
    private final List<Integer> f74222f = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List<Integer> f74223h = new ArrayList();
    private Status E = Status.IDLE;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f74220d = new Handler(d.c(), this);

    /* renamed from: e, reason: collision with root package name */
    private final Handler f74221e = new Handler(d.c(), this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum Status {
        IDLE,
        RUNNING
    }

    public QAVPMemoryManager(VideoAppInterface videoAppInterface) {
        this.f74224i = videoAppInterface;
    }

    private void b(SessionInfo sessionInfo) {
        xv.a.f(new Runnable() { // from class: com.tencent.av.qavperf.manager.c
            @Override // java.lang.Runnable
            public final void run() {
                QAVPMemoryManager.this.d();
            }
        });
    }

    private boolean c(float f16, float f17, float f18) {
        if (f17 - f18 > f16 * 0.85f) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        int size = this.f74222f.size();
        int size2 = this.f74223h.size();
        if (size == 0 && size2 == 0) {
            xv.a.g(34, 1, null);
            return;
        }
        HashMap hashMap = new HashMap();
        if (size2 > 0) {
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = Integer.MAX_VALUE;
            while (i3 < size2) {
                int intValue = this.f74223h.get(i3).intValue();
                int max = Math.max(0, intValue);
                int min = Math.min(Integer.MAX_VALUE, intValue);
                i16 += intValue;
                i3++;
                i17 = max;
                i18 = min;
            }
            hashMap.put("video_mem_max", String.valueOf(i17));
            hashMap.put("video_mem_min", String.valueOf(i18));
            hashMap.put("video_mem_avg", String.valueOf(i16 / size2));
        } else {
            int i19 = 0;
            int i26 = Integer.MAX_VALUE;
            int i27 = 0;
            for (int i28 = 0; i28 < size; i28++) {
                int intValue2 = this.f74222f.get(i28).intValue();
                i27 = Math.max(i27, intValue2);
                i26 = Math.min(i26, intValue2);
                i19 += intValue2;
            }
            hashMap.put("audio_mem_max", String.valueOf(i27));
            hashMap.put("audio_mem_min", String.valueOf(i26));
            hashMap.put("audio_mem_avg", String.valueOf(i19 / size));
        }
        hashMap.put("mem_warn_top", String.valueOf(this.C));
        xv.a.g(34, 2, hashMap);
        i();
    }

    private void e() {
        if (this.E == Status.RUNNING) {
            this.f74220d.sendEmptyMessageDelayed(17, 10000L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00c6 A[Catch: all -> 0x00cc, TRY_LEAVE, TryCatch #2 {all -> 0x00cc, blocks: (B:18:0x00a0, B:20:0x00c6), top: B:17:0x00a0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f() {
        int i3;
        int i16;
        char c16;
        if (this.E == Status.RUNNING && this.f74222f.size() + this.f74223h.size() < 750) {
            try {
                Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                i3 = memoryInfo.getTotalPss() / 1024;
            } catch (Throwable th5) {
                th = th5;
                i3 = 0;
            }
            try {
                String a16 = vv.d.a(this.D);
                switch (a16.hashCode()) {
                    case -143225276:
                        if (a16.equals("local_video_only")) {
                            c16 = 3;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case 93166550:
                        if (a16.equals("audio")) {
                            c16 = 0;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case 112202875:
                        if (a16.equals("video")) {
                            c16 = 1;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case 413855369:
                        if (a16.equals("remote_video_only")) {
                            c16 = 2;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    default:
                        c16 = '\uffff';
                        break;
                }
                if (c16 != 0) {
                    if (c16 == 1 || c16 == 2 || c16 == 3) {
                        this.f74223h.add(Integer.valueOf(i3));
                    }
                } else {
                    this.f74222f.add(Integer.valueOf(i3));
                }
            } catch (Throwable th6) {
                th = th6;
                vv.c.b("get memory value fail:" + th.getMessage());
                if (c(((float) Runtime.getRuntime().maxMemory()) / 1024.0f, ((float) Runtime.getRuntime().totalMemory()) / 1024.0f, ((float) Runtime.getRuntime().freeMemory()) / 1024.0f)) {
                }
                if (this.E != Status.RUNNING) {
                    return;
                } else {
                    return;
                }
            }
        } else {
            i3 = 0;
        }
        try {
            if (c(((float) Runtime.getRuntime().maxMemory()) / 1024.0f, ((float) Runtime.getRuntime().totalMemory()) / 1024.0f, ((float) Runtime.getRuntime().freeMemory()) / 1024.0f)) {
                this.C++;
            }
        } catch (Throwable th7) {
            vv.c.b("get memory percent fail:" + th7.getMessage());
        }
        if (this.E != Status.RUNNING && this.F && (i16 = this.f74225m) < 10) {
            this.f74225m = i16 + 1;
            HashMap hashMap = new HashMap();
            hashMap.put("sample_type", "memory");
            hashMap.put("mem_value", String.valueOf(i3));
            hashMap.put("mem_ratio", String.valueOf(0.0f));
            xv.a.h(this.f74224i, this.D, hashMap);
            this.F = false;
        }
    }

    private void g() {
        if (this.E == Status.RUNNING) {
            this.f74221e.sendEmptyMessageDelayed(34, JsonGrayBusiId.UI_RESERVE_100000_110000);
        }
    }

    private void h() {
        this.F = true;
    }

    private void i() {
        this.F = false;
        this.f74223h.clear();
        this.f74222f.clear();
    }

    private void k() {
        e();
        g();
    }

    private void m(SessionInfo sessionInfo) {
        n();
        o();
        b(sessionInfo);
    }

    private void n() {
        Handler handler = this.f74220d;
        if (handler != null) {
            handler.removeMessages(17);
        }
    }

    private void o() {
        if (this.f74220d != null) {
            this.f74221e.removeMessages(34);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 17) {
            if (i3 == 34) {
                h();
                g();
                return true;
            }
            return true;
        }
        f();
        e();
        return true;
    }

    public void j(SessionInfo sessionInfo) {
        Status status = this.E;
        Status status2 = Status.RUNNING;
        if (status == status2) {
            return;
        }
        this.E = status2;
        this.D = sessionInfo;
        k();
        vv.c.a("start record memory");
    }

    public void l(SessionInfo sessionInfo) {
        Status status = this.E;
        Status status2 = Status.IDLE;
        if (status == status2) {
            return;
        }
        this.E = status2;
        m(sessionInfo);
        vv.c.a("finish record memory");
    }
}
