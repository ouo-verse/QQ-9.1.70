package com.tencent.mobileqq.qqlive.anchor.beauty;

import android.view.View;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.beauty.BeautyLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class BeautyModule {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f270366a;

    /* renamed from: b, reason: collision with root package name */
    private h f270367b;

    /* renamed from: c, reason: collision with root package name */
    private final IAegisLogApi f270368c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.anchor.beauty.widget.a f270369d;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f270370e;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f270371f;

    /* renamed from: g, reason: collision with root package name */
    private final BeautyLoader.b f270372g;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements BeautyLoader.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BeautyModule.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.BeautyLoader.b
        public void a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                BeautyModule.this.s("onLoadFail send msg");
                BeautyModule.this.u(i3, i16);
                BeautyModule.this.y();
                return;
            }
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.BeautyLoader.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                BeautyModule.this.s("onDownloadStarted");
                BeautyModule.this.t();
                BeautyModule.this.y();
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.BeautyLoader.b
        public void onLoadComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                BeautyModule.this.s("onLoadComplete");
                BeautyModule.this.v();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.BeautyLoader.b
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                BeautyModule.this.s(HippyQQPagView.EventName.ON_LOAD_START);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public BeautyModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f270366a = false;
        this.f270368c = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.f270369d = null;
        this.f270370e = null;
        this.f270371f = new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.BeautyModule.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BeautyModule.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    BeautyModule.this.k();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        a aVar = new a();
        this.f270372g = aVar;
        BeautyLoader.d().i();
        BeautyLoader.d().k(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        s("checkBeautyInit");
        BeautyLoader.d().g();
    }

    private void m() {
        s("initLightSDK");
        ((IAEKitForQQ) QRoute.api(IAEKitForQQ.class)).init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f270367b = null;
        this.f270369d.cancel();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        if (this.f270369d == null) {
            this.f270369d = new com.tencent.mobileqq.qqlive.anchor.beauty.widget.a(ul3.b.e());
        }
        this.f270369d.N(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BeautyModule.this.n(view);
            }
        });
        this.f270369d.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(int i3) {
        com.tencent.mobileqq.qqlive.anchor.beauty.widget.a aVar = this.f270369d;
        if (aVar != null) {
            aVar.O(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        m();
        com.tencent.mobileqq.qqlive.anchor.beauty.widget.a aVar = this.f270369d;
        if (aVar != null) {
            aVar.dismiss();
        }
        BeautyProcessor n3 = BeautyProcessor.n();
        n3.o(BaseApplication.getContext());
        x(n3);
    }

    private void r(String str) {
        this.f270368c.e("BeautyModule", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        this.f270368c.i("BeautyModule", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.b
            @Override // java.lang.Runnable
            public final void run() {
                BeautyModule.this.o();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i3, final int i16) {
        if (i3 != 1) {
            r("unKnow error! Terminal download task.");
            w(i3, "download beauty res fail! errorCode:" + i3);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.d
            @Override // java.lang.Runnable
            public final void run() {
                BeautyModule.this.p(i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.c
            @Override // java.lang.Runnable
            public final void run() {
                BeautyModule.this.q();
            }
        });
    }

    private void w(int i3, String str) {
        h hVar = this.f270367b;
        if (hVar != null) {
            hVar.onFailure(i3, str);
        }
    }

    private void x(com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a aVar) {
        this.f270366a = true;
        h hVar = this.f270367b;
        if (hVar != null) {
            hVar.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Runnable runnable = this.f270370e;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 64);
        }
        this.f270370e = ThreadManagerV2.executeDelay(this.f270371f, 64, null, true, 3000L);
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f270367b = null;
        Runnable runnable = this.f270370e;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 64);
        }
        com.tencent.mobileqq.qqlive.anchor.beauty.widget.a aVar = this.f270369d;
        if (aVar != null) {
            if (aVar.isShowing()) {
                this.f270369d.dismiss();
            }
            this.f270369d = null;
        }
        BeautyLoader.d().c();
        BeautyLoader.d().l();
    }

    public void z(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar);
            return;
        }
        this.f270367b = hVar;
        s("setupBeauty isInitBeauty:" + this.f270366a);
        if (!this.f270366a) {
            k();
        } else {
            x(BeautyProcessor.n());
        }
    }
}
