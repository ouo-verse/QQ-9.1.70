package com.tencent.mobileqq.kandian.glue.video;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.view.VideoCountDownView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Queue;
import r62.b;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a implements Handler.Callback, View.OnClickListener {
    private Handler C;
    private int D;
    private FrameLayout E;
    private VideoCountDownView F;
    private k62.a G;
    private k62.a H;
    private k62.a I;
    private int J;
    private boolean K;
    private Queue<k62.a> L;
    private int M;
    private List<C7961a> N;
    private int P;

    /* renamed from: d, reason: collision with root package name */
    private Context f240037d;

    /* renamed from: e, reason: collision with root package name */
    private j62.a f240038e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f240039f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f240040h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f240041i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f240042m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.kandian.glue.video.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public static class C7961a {

        /* renamed from: a, reason: collision with root package name */
        public k62.a f240043a;

        /* renamed from: b, reason: collision with root package name */
        public int f240044b;

        public C7961a(k62.a aVar, int i3) {
            this.f240043a = aVar;
            this.f240044b = i3;
        }
    }

    private void g() {
        k62.a aVar = this.I;
        k62.a aVar2 = this.H;
        aVar.f411772d = aVar2.f411772d + 1;
        i(aVar2, aVar);
    }

    private void i(k62.a aVar, k62.a aVar2) {
        if ((aVar instanceof k62.b) && (aVar2 instanceof k62.b)) {
        }
    }

    private void m() {
        k62.a aVar = this.I;
        if (aVar != null && this.f240038e != null) {
            this.L.remove(aVar);
            this.f240038e.c(this.I);
            this.P++;
        }
        this.I = null;
        this.K = false;
    }

    public void a(int i3) {
        this.D = i3;
        if (j()) {
            if (this.D > 0) {
                this.F.a(i3);
                p(i3, System.currentTimeMillis());
            } else if (this.I != null) {
                d();
                m();
            } else {
                this.F.b();
            }
        }
    }

    public void c(k62.a aVar, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("VideoFullPlayController", 2, "enterFullMode videoPlayParam:" + aVar);
        }
        this.f240039f = true;
        this.H = aVar;
        this.P = 1;
        this.J = i3;
        this.K = true;
        this.L.clear();
        if (this.H != null) {
            long j3 = aVar.f411773e;
            if (j3 == 409409) {
                this.M = 0;
            } else if (j3 == 56) {
                this.M = 1;
            } else {
                this.M = 2;
            }
        }
    }

    public void f() {
        k62.a peek = this.L.peek();
        if (peek == null) {
            o();
        } else {
            l(peek);
        }
    }

    public k62.a h() {
        return this.H;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            long currentTimeMillis = System.currentTimeMillis() - ((Long) message.obj).longValue();
            if (currentTimeMillis >= 1000) {
                int i3 = (int) (message.arg1 - (currentTimeMillis / 1000));
                message.arg1 = i3;
                a(i3);
            } else {
                p(message.arg1, ((Long) message.obj).longValue());
            }
        }
        return true;
    }

    public boolean j() {
        return this.f240040h;
    }

    public boolean k() {
        return this.f240039f;
    }

    public void l(k62.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoFullPlayController", 2, "onFetch nextVideoPlayParam:" + aVar);
        }
        this.I = aVar;
        this.F.setIsXgMode(this.f240041i);
        this.F.setNextVideoInfo(aVar);
        if (!this.f240041i) {
            a(3);
        }
        g();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.ajf) {
            return;
        }
        d();
        j62.a aVar = this.f240038e;
        if (aVar != null) {
            aVar.c(this.G);
        }
        k62.a aVar2 = this.G;
        if (aVar2 == null) {
            return;
        }
        PublicAccountReportUtils.l(null, "", "0X8009503", "0X8009503", 0, 0, "", String.valueOf(this.M), "", new b.a(null, null, aVar2.f411771c, aVar2.a()).h((int) this.G.f411773e).g().b(), false);
    }

    public void b(k62.a aVar) {
        this.f240040h = true;
        this.f240041i = true ^ NetworkUtil.isWifiConnected(this.f240037d);
        if (QLog.isColorLevel()) {
            QLog.i("VideoFullPlayController", 2, "enterCountDownMode videoPlayParam:" + aVar + " mVideoRootFrameLayout:" + this.E);
        }
        if (aVar == null || this.E == null) {
            return;
        }
        this.G = aVar;
        if (this.F == null) {
            VideoCountDownView videoCountDownView = new VideoCountDownView(this.f240037d);
            this.F = videoCountDownView;
            videoCountDownView.setOnClickListener(null);
            this.F.setOnCustomClickListener(this);
        }
        this.F.f();
        this.F.setTitle(aVar.f411769a);
        if (this.f240042m) {
            this.F.e(new PublicAccountHttpDownloaderImpl().makeURL(aVar.f411770b, 0));
        } else {
            this.F.c();
        }
        if (this.F.getParent() != null) {
            ((ViewGroup) this.F.getParent()).removeView(this.F);
        }
        this.E.addView(this.F);
        f();
        PublicAccountReportUtils.l(null, "", "0X8009502", "0X8009502", 0, 0, "", String.valueOf(this.M), "", new b.a(null, null, aVar.f411771c, aVar.a()).h((int) aVar.f411773e).g().b(), false);
    }

    public void d() {
        this.f240040h = false;
        this.E.removeView(this.F);
        n();
    }

    public void e() {
        this.f240039f = false;
        k62.a aVar = this.H;
        if (aVar != null) {
            this.N.add(new C7961a(aVar, this.P));
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoFullPlayController", 2, "exitFullMode: ");
        }
    }

    public void p(int i3, long j3) {
        if (i3 <= 0) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i3;
        obtain.obj = Long.valueOf(j3);
        this.C.sendMessageDelayed(obtain, 500L);
    }

    private void n() {
    }

    private void o() {
    }
}
