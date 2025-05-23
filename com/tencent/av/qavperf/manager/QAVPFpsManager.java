package com.tencent.av.qavperf.manager;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import android.view.Choreographer;
import androidx.annotation.NonNull;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@TargetApi(16)
/* loaded from: classes3.dex */
public class QAVPFpsManager implements Choreographer.FrameCallback, Handler.Callback {
    private boolean C;
    private SessionInfo E;
    private final VideoAppInterface F;

    /* renamed from: m, reason: collision with root package name */
    private int f74219m;

    /* renamed from: d, reason: collision with root package name */
    private long f74214d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f74215e = 0;

    /* renamed from: i, reason: collision with root package name */
    private final List<Float> f74218i = new ArrayList();
    private Status D = Status.IDLE;
    private final wv.b G = wv.b.b();

    /* renamed from: f, reason: collision with root package name */
    private final Handler f74216f = new Handler(d.b(), this);

    /* renamed from: h, reason: collision with root package name */
    private final Handler f74217h = new Handler(d.b(), this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum Status {
        IDLE,
        RUNNING
    }

    public QAVPFpsManager(VideoAppInterface videoAppInterface) {
        this.F = videoAppInterface;
    }

    private void b(SessionInfo sessionInfo) {
        xv.a.f(new Runnable() { // from class: com.tencent.av.qavperf.manager.b
            @Override // java.lang.Runnable
            public final void run() {
                QAVPFpsManager.this.e();
            }
        });
    }

    private void c() {
        int i3;
        long j3 = this.f74214d;
        if (j3 == 0) {
            this.f74214d = this.f74215e;
            return;
        }
        float f16 = ((float) (this.f74215e - j3)) / 1.0E9f;
        if (f16 <= 0.0f) {
            return;
        }
        float a16 = this.G.a() / f16;
        this.f74214d = this.f74215e;
        if (a16 > 0.0f && this.D == Status.RUNNING && this.f74218i.size() < 1440) {
            this.f74218i.add(Float.valueOf(a16));
        }
        if (this.C && (i3 = this.f74219m) < 10) {
            this.f74219m = i3 + 1;
            HashMap hashMap = new HashMap();
            hashMap.put("sample_type", "fps");
            hashMap.put("fps_draw", String.valueOf(a16));
            xv.a.h(this.F, this.E, hashMap);
            this.C = false;
        }
        this.G.c();
    }

    private void d() {
        this.C = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        int size = this.f74218i.size();
        if (size == 0) {
            xv.a.g(17, 1, null);
            return;
        }
        float f16 = 0.0f;
        for (int i3 = 0; i3 < size; i3++) {
            f16 += this.f74218i.get(i3).floatValue();
        }
        float f17 = f16 / size;
        HashMap hashMap = new HashMap();
        hashMap.put("fps_draw", String.valueOf(f17));
        xv.a.g(17, 2, hashMap);
        h();
    }

    private void f() {
        if (this.D == Status.RUNNING) {
            this.f74216f.sendEmptyMessageDelayed(17, 5000L);
        }
    }

    private void g() {
        if (this.D == Status.RUNNING) {
            this.f74217h.sendEmptyMessageDelayed(34, JsonGrayBusiId.UI_RESERVE_100000_110000);
        }
    }

    private void h() {
        this.C = false;
        this.f74218i.clear();
    }

    private void k() {
        Handler handler = this.f74216f;
        if (handler != null) {
            handler.removeMessages(17);
        }
    }

    private void l() {
        Handler handler = this.f74217h;
        if (handler != null) {
            handler.removeMessages(34);
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j3) {
        this.f74215e = j3;
        Choreographer.getInstance().postFrameCallback(this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        int i3 = message.what;
        if (i3 != 17) {
            if (i3 == 34) {
                d();
                g();
                return true;
            }
            return true;
        }
        c();
        f();
        return true;
    }

    public void i(SessionInfo sessionInfo) {
        Status status = this.D;
        Status status2 = Status.RUNNING;
        if (status == status2) {
            return;
        }
        this.D = status2;
        this.E = sessionInfo;
        this.f74214d = System.nanoTime();
        f();
        g();
        Choreographer.getInstance().postFrameCallback(this);
        vv.c.a("start record fps");
        this.G.c();
    }

    public void j(SessionInfo sessionInfo) {
        Status status = this.D;
        Status status2 = Status.IDLE;
        if (status == status2) {
            return;
        }
        this.D = status2;
        Choreographer.getInstance().removeFrameCallback(this);
        k();
        l();
        b(sessionInfo);
        vv.c.a("finish record fps");
    }
}
