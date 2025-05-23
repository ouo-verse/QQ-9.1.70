package com.tencent.biz.qqcircle.immersive.views;

import android.app.Activity;
import android.os.Handler;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.libpag.PAGFile;
import org.libpag.PAGImage;

/* compiled from: P */
/* loaded from: classes4.dex */
public class u implements a80.a {

    /* renamed from: o, reason: collision with root package name */
    public static final Handler f91319o = RFWThreadManager.getInstance().getSerialThreadHandler();

    /* renamed from: d, reason: collision with root package name */
    private long f91323d;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f91325f;

    /* renamed from: g, reason: collision with root package name */
    private a80.f f91326g;

    /* renamed from: h, reason: collision with root package name */
    private a80.i f91327h;

    /* renamed from: j, reason: collision with root package name */
    private a80.b f91329j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f91330k;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f91320a = true;

    /* renamed from: b, reason: collision with root package name */
    private int f91321b = 1;

    /* renamed from: c, reason: collision with root package name */
    private int f91322c = -1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f91324e = false;

    /* renamed from: l, reason: collision with root package name */
    private final Runnable f91331l = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.i
        @Override // java.lang.Runnable
        public final void run() {
            u.this.D();
        }
    };

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f91332m = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.l
        @Override // java.lang.Runnable
        public final void run() {
            u.this.F();
        }
    };

    /* renamed from: n, reason: collision with root package name */
    private final Observer<? super Boolean> f91333n = new Observer() { // from class: com.tencent.biz.qqcircle.immersive.views.m
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            u.this.G((Boolean) obj);
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private a80.o f91328i = new a80.o();

    public u() {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.n
            @Override // java.lang.Runnable
            public final void run() {
                u.this.I();
            }
        });
    }

    private boolean B() {
        FrameLayout frameLayout = this.f91325f;
        if (frameLayout == null || frameLayout.getContext() == null) {
            return true;
        }
        if (!(this.f91325f.getContext() instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) this.f91325f.getContext();
        if (activity.isDestroyed() || activity.isFinishing()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        a80.b bVar = this.f91329j;
        if (bVar != null) {
            bVar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        a80.b bVar = this.f91329j;
        if (bVar == null) {
            return;
        }
        bVar.stop();
        z();
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.p
            @Override // java.lang.Runnable
            public final void run() {
                u.this.C();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        a80.i iVar;
        if (!y() || (iVar = this.f91327h) == null) {
            return;
        }
        if (!iVar.e()) {
            QLog.e("QFSPagAnimationV", 1, "cant play isLoadSucceed return false");
            return;
        }
        ArrayList arrayList = new ArrayList(iVar.d());
        int size = arrayList.size();
        int i3 = this.f91322c;
        if (size > i3 && i3 >= 0) {
            final a80.b bVar = this.f91329j;
            if (bVar == null) {
                return;
            }
            this.f91328i.o(this.f91325f, iVar);
            bVar.stop();
            PAGFile pAGFile = (PAGFile) arrayList.get(i3);
            long j3 = this.f91323d;
            if (j3 != -1) {
                pAGFile.setDuration(j3);
            }
            bVar.setComposition(pAGFile);
            a80.f fVar = this.f91326g;
            if (fVar != null) {
                bVar.c(fVar);
                bVar.a(this.f91326g);
            }
            QLog.d("QFSPagAnimationV", 4, "real play pag mStaticImageMode\uff1a" + this.f91324e);
            bVar.setStaticImageMode(this.f91324e);
            if (this.f91324e) {
                bVar.setProgress(1.0d);
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        a80.b.this.setVisibility(0);
                    }
                });
                return;
            } else {
                bVar.flush();
                bVar.setProgress(0.0d);
                bVar.setRepeatCount(this.f91321b);
                bVar.play();
                return;
            }
        }
        QLog.e("QFSPagAnimationV", 1, "cant play: playIndex:" + i3 + ",file size:" + size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(Boolean bool) {
        if (bool == null) {
            return;
        }
        if (!bool.booleanValue()) {
            P("initFile error");
        } else {
            O();
            Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(Boolean bool) {
        if (bool == null) {
            return;
        }
        if (!bool.booleanValue()) {
            P("initView error");
            return;
        }
        R();
        this.f91329j = this.f91328i.f();
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        this.f91328i.f25667a.observeForever(new Observer() { // from class: com.tencent.biz.qqcircle.immersive.views.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u.this.H((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        a80.f fVar = this.f91326g;
        if (fVar != null) {
            fVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(String str) {
        a80.f fVar = this.f91326g;
        if (fVar != null) {
            fVar.e(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        a80.f fVar = this.f91326g;
        if (fVar != null) {
            fVar.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(boolean z16) {
        int i3;
        a80.b bVar = this.f91329j;
        if (bVar != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            bVar.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(a80.i iVar, a80.i iVar2) {
        if (iVar != null) {
            iVar.f25654c.removeObserver(this.f91333n);
        }
        iVar2.f25654c.observeForever(this.f91333n);
        if (!iVar2.c().isEmpty()) {
            A(iVar2);
        }
    }

    private void O() {
        QLog.e("QFSPagAnimationV", 1, "[onFileLoadSucceed]");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.j
            @Override // java.lang.Runnable
            public final void run() {
                u.this.J();
            }
        });
    }

    private void P(final String str) {
        QLog.e("QFSPagAnimationV", 1, "onInitError :" + str);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.t
            @Override // java.lang.Runnable
            public final void run() {
                u.this.K(str);
            }
        });
    }

    private void Q() {
        boolean z16;
        boolean g16 = this.f91328i.g();
        a80.i iVar = this.f91327h;
        if (iVar != null && iVar.e()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("QFSPagAnimationV", 1, "onInitStatusChange fileLoadSucceed:" + z16 + ",viewLoadSucceed:" + g16);
        if (z16 && g16 && !this.f91320a) {
            e(this.f91322c, this.f91321b, this.f91323d);
        }
    }

    private void R() {
        QLog.e("QFSPagAnimationV", 1, "[onViewLoadSucceed]");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.k
            @Override // java.lang.Runnable
            public final void run() {
                u.this.L();
            }
        });
    }

    private boolean y() {
        if (this.f91320a) {
            QLog.w("QFSPagAnimationV", 1, "play cancel, is stopping");
            return false;
        }
        if (B()) {
            QLog.w("QFSPagAnimationV", 1, "cant play: null container");
            return false;
        }
        if (this.f91329j != null && this.f91325f != null) {
            return true;
        }
        QLog.w("QFSPagAnimationV", 1, "cant play: null pagView or null container");
        return false;
    }

    protected void A(a80.i iVar) {
        QLog.d("QFSPagAnimationV", 1, "initFileAndView");
        if (B()) {
            QLog.d("QFSPagAnimationV", 1, "initFileAndView isContainerInvalid");
            return;
        }
        if (iVar != null) {
            iVar.i(this.f91325f.getContext());
        }
        this.f91328i.p(this.f91325f);
    }

    @Override // a80.a
    public synchronized void a(int i3) {
        a80.b bVar = this.f91329j;
        if (bVar == null) {
            return;
        }
        bVar.setScaleMode(i3);
    }

    @Override // a80.a
    public void b(boolean z16) {
        this.f91328i.m(z16);
    }

    @Override // a80.a
    public void c(int i3, PAGImage pAGImage, QFSPagAnimView.d dVar) {
        if (!this.f91330k) {
            if (!QCircleHostConstants._AppSetting.isDebugVersion()) {
                QLog.e("QFSPagAnimationV", 1, "replacePagImage is not editResMode");
                return;
            }
            throw new RuntimeException("replacePagImage must set editResMode first!!!");
        }
        a80.i iVar = this.f91327h;
        if (iVar != null) {
            iVar.h(i3, pAGImage, dVar);
        } else {
            QLog.e("QFSPagAnimationV", 1, "replacePagImage currentResInfo is null");
        }
    }

    @Override // a80.a
    public synchronized void d(boolean z16) {
        this.f91330k = z16;
        this.f91328i.n(z16);
    }

    @Override // a80.a
    public synchronized void e(int i3, int i16, long j3) {
        this.f91320a = false;
        this.f91322c = i3;
        this.f91321b = i16;
        this.f91323d = j3;
        a80.i iVar = this.f91327h;
        if (iVar == null) {
            P("resInfo is null");
            return;
        }
        if (iVar.e() && this.f91328i.g()) {
            Handler handler = f91319o;
            handler.removeCallbacks(this.f91331l);
            handler.removeCallbacks(this.f91332m);
            handler.post(this.f91332m);
        } else {
            QLog.d("QFSPagAnimationV", 1, "[play] do initFileAndView");
            A(iVar);
        }
    }

    @Override // a80.a
    public ByteBuffer f(int i3) {
        List<PAGFile> h16 = h();
        if (h16 == null) {
            return null;
        }
        if (h16.size() >= i3 + 1 && h16.get(i3) != null) {
            return h16.get(i3).audioBytes();
        }
        QLog.e("QFSPagAnimationV", 1, "getPagAudioBytes mPagFile null");
        return null;
    }

    @Override // a80.a
    public List<Object> g() {
        a80.i iVar = this.f91327h;
        if (iVar != null) {
            return iVar.c();
        }
        return null;
    }

    @Override // a80.a
    public List<PAGFile> h() {
        a80.i iVar = this.f91327h;
        if (iVar != null) {
            return iVar.d();
        }
        return null;
    }

    @Override // a80.a
    public synchronized void i(FrameLayout frameLayout, List<Object> list) {
        this.f91325f = frameLayout;
        final a80.i iVar = this.f91327h;
        final a80.i iVar2 = new a80.i(list);
        this.f91327h = iVar2;
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.r
            @Override // java.lang.Runnable
            public final void run() {
                u.this.N(iVar, iVar2);
            }
        });
    }

    @Override // a80.a
    public boolean j() {
        a80.b bVar = this.f91329j;
        if (bVar != null) {
            return bVar.isPlaying();
        }
        return false;
    }

    @Override // a80.a
    public void k(a80.f fVar) {
        this.f91326g = fVar;
    }

    @Override // a80.a
    public void l(final boolean z16) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.s
            @Override // java.lang.Runnable
            public final void run() {
                u.this.M(z16);
            }
        });
    }

    @Override // a80.a
    public synchronized void setStaticImageMode(boolean z16) {
        this.f91324e = z16;
    }

    @Override // a80.a
    public synchronized void stop() {
        this.f91320a = true;
        Handler handler = f91319o;
        handler.removeCallbacks(this.f91332m);
        handler.removeCallbacks(this.f91331l);
        handler.post(this.f91331l);
    }

    public void z() {
        a80.f fVar;
        a80.b bVar = this.f91329j;
        if (bVar != null && (fVar = this.f91326g) != null) {
            bVar.c(fVar);
        }
    }
}
