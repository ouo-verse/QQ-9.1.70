package com.tencent.mobileqq.qqlive.anchor.beauty;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel;
import com.tencent.mobileqq.qqlive.anchor.beauty.processor.TemplateRenderStrategy;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveVideoBaseFrame;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes17.dex */
public class BeautyProcessor implements com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static BeautyProcessor f270374f;

    /* renamed from: a, reason: collision with root package name */
    private volatile com.tencent.mobileqq.qqlive.anchor.beauty.processor.b f270375a;

    /* renamed from: b, reason: collision with root package name */
    private Context f270376b;

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentLinkedQueue<Runnable> f270377c;

    /* renamed from: d, reason: collision with root package name */
    private final List<b> f270378d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.mobileqq.qqlive.anchor.beauty.processor.a f270379e;

    /* renamed from: com.tencent.mobileqq.qqlive.anchor.beauty.BeautyProcessor$7, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass7 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f270394d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f270395e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ MotionEvent f270396f;
        final /* synthetic */ BeautyProcessor this$0;

        @Override // java.lang.Runnable
        @SuppressLint({"DefaultLocale"})
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i("BeautyProcessor", 1, String.format("updateMotionEvent width=%d, height=%d", Integer.valueOf(this.f270394d), Integer.valueOf(this.f270395e)));
            if (this.this$0.f270375a == null) {
                QLog.e("BeautyProcessor", 1, "updateMotionEvent error, lightSdkProcessor is null!");
            } else {
                this.this$0.f270375a.u(this.f270396f, this.f270394d, this.f270395e);
            }
        }
    }

    /* loaded from: classes17.dex */
    class a implements com.tencent.mobileqq.qqlive.anchor.beauty.processor.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BeautyProcessor.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.processor.a
        public void B(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                return;
            }
            Iterator it = BeautyProcessor.this.f270378d.iterator();
            while (it.hasNext()) {
                ((b) it.next()).B(str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.processor.a
        public void D(String str, String str2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, str2, Integer.valueOf(i3));
                return;
            }
            Iterator it = BeautyProcessor.this.f270378d.iterator();
            while (it.hasNext()) {
                ((b) it.next()).D(str, str2, i3);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.processor.a
        public void N(String str, String str2, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            Iterator it = BeautyProcessor.this.f270378d.iterator();
            while (it.hasNext()) {
                ((b) it.next()).N(str, str2, i3, i16);
            }
        }
    }

    /* loaded from: classes17.dex */
    public interface b {
        void B(String str);

        void D(String str, String str2, int i3);

        void N(String str, String str2, int i3, int i16);
    }

    public BeautyProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f270377c = new ConcurrentLinkedQueue<>();
        this.f270378d = new ArrayList();
        this.f270379e = new a();
    }

    private void A() {
        G("", String.valueOf(0));
    }

    private void B() {
        H("", "1f");
    }

    private void C() {
        g gVar = g.f270406a;
        if (gVar.c(gVar.i(), false)) {
            QQToast.makeText(this.f270376b, R.string.f170873zu2, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        t();
    }

    private void g() {
        i();
        l();
        k();
    }

    private void i() {
        for (Map.Entry<String, String> entry : DataModel.i().d().entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                E(entry.getKey(), String.valueOf(0));
            }
        }
        DataModel.i().a();
        j(DataModel.BeautySecondaryItem.SUB_THIN_FACE_NATURE, 11);
    }

    private void j(DataModel.BeautySecondaryItem beautySecondaryItem, int i3) {
        F(beautySecondaryItem.getParent().getLightInterface(), String.valueOf(0), beautySecondaryItem.getSubLightInterface(), beautySecondaryItem.getSubLightValue());
        DataModel.i().b(i3);
    }

    private void k() {
        G("", String.valueOf(0));
    }

    private void l() {
        H("", String.valueOf(0));
    }

    public static BeautyProcessor n() {
        if (f270374f == null) {
            f270374f = new BeautyProcessor();
        }
        return f270374f;
    }

    private void q() {
        for (Map.Entry<String, Integer> entry : DataModel.i().c().entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                E(entry.getKey(), String.valueOf(entry.getValue().intValue() / 100.0f));
            }
        }
        r(DataModel.BeautySecondaryItem.SUB_THIN_FACE_NATURE);
    }

    private void r(DataModel.BeautySecondaryItem beautySecondaryItem) {
        String lightInterface = beautySecondaryItem.getParent().getLightInterface();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        g gVar = g.f270406a;
        sb5.append(gVar.h(gVar.t(beautySecondaryItem.getParent().getIndex()), (int) (beautySecondaryItem.getCurValue() / 100.0f)));
        F(lightInterface, sb5.toString(), beautySecondaryItem.getSubLightInterface(), gVar.q(gVar.r(beautySecondaryItem.getIndex()), beautySecondaryItem.getSubLightValue()));
    }

    private void s() {
        g gVar = g.f270406a;
        String q16 = gVar.q(gVar.d(), "");
        String q17 = gVar.q(gVar.f(), "1");
        if (TextUtils.isEmpty(q16)) {
            return;
        }
        G(q16, q17);
    }

    private void t() {
        g gVar = g.f270406a;
        String q16 = gVar.q(gVar.k(), "");
        String q17 = gVar.q(gVar.m(), "1");
        if (TextUtils.isEmpty(q16)) {
            return;
        }
        H(q16, q17);
    }

    private void u() {
        g gVar = g.f270406a;
        String q16 = gVar.q(gVar.o(), "");
        if (TextUtils.isEmpty(q16)) {
            return;
        }
        I(q16);
    }

    private void w() {
        y();
        B();
        A();
    }

    private void y() {
        for (Map.Entry<String, String> entry : DataModel.i().d().entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                E(entry.getKey(), entry.getValue());
            }
        }
        DataModel.i().p();
        z(DataModel.BeautySecondaryItem.SUB_THIN_FACE_NATURE, 11);
    }

    private void z(DataModel.BeautySecondaryItem beautySecondaryItem, int i3) {
        F(beautySecondaryItem.getParent().getLightInterface(), String.valueOf(beautySecondaryItem.getParent().getDefValue() / 100.0f), beautySecondaryItem.getSubLightInterface(), beautySecondaryItem.getSubLightValue());
        DataModel.i().q(i3);
    }

    public void E(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        } else {
            m(new Runnable(str, str2) { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.BeautyProcessor.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f270380d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f270381e;

                {
                    this.f270380d = str;
                    this.f270381e = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BeautyProcessor.this, str, str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.i("BeautyProcessor", 1, String.format("updateBeauty key=%s, value=%s", this.f270380d, this.f270381e));
                    if (BeautyProcessor.this.f270375a == null) {
                        QLog.e("BeautyProcessor", 1, "updateBeauty error, lightSdkProcessor is null!");
                    } else {
                        BeautyProcessor.this.f270375a.p(this.f270380d, this.f270381e);
                    }
                }
            });
        }
    }

    public void F(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, str3, str4);
        } else {
            m(new Runnable(str, str2, str3, str4) { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.BeautyProcessor.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f270382d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f270383e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f270384f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f270385h;

                {
                    this.f270382d = str;
                    this.f270383e = str2;
                    this.f270384f = str3;
                    this.f270385h = str4;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BeautyProcessor.this, str, str2, str3, str4);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.i("BeautyProcessor", 1, String.format("updateBeauty parentKey=%s, parentValue=%s, subKey=%s, subValue=%s", this.f270382d, this.f270383e, this.f270384f, this.f270385h));
                    if (BeautyProcessor.this.f270375a == null) {
                        QLog.e("BeautyProcessor", 1, "updateBeauty error, lightSdkProcessor is null!");
                    } else {
                        BeautyProcessor.this.f270375a.q(this.f270382d, this.f270383e, this.f270384f, this.f270385h);
                    }
                }
            });
        }
    }

    public void G(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
        } else {
            m(new Runnable(str, str2) { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.BeautyProcessor.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f270388d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f270389e;

                {
                    this.f270388d = str;
                    this.f270389e = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BeautyProcessor.this, str, str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.i("BeautyProcessor", 1, String.format("updateFilter path=%s, value=%s", this.f270388d, this.f270389e));
                    if (BeautyProcessor.this.f270375a == null) {
                        QLog.e("BeautyProcessor", 1, "updateFilter error, lightSdkProcessor is null!");
                        return;
                    }
                    g gVar = g.f270406a;
                    gVar.w(gVar.d(), this.f270388d);
                    gVar.w(gVar.f(), this.f270389e);
                    BeautyProcessor.this.f270375a.r(this.f270388d, this.f270389e);
                }
            });
        }
    }

    public void H(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
        } else {
            m(new Runnable(str, str2) { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.BeautyProcessor.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f270386d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f270387e;

                {
                    this.f270386d = str;
                    this.f270387e = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BeautyProcessor.this, str, str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.i("BeautyProcessor", 1, String.format("updateMakeup path=%s, value=%s", this.f270386d, this.f270387e));
                    if (BeautyProcessor.this.f270375a == null) {
                        QLog.e("BeautyProcessor", 1, "updateMakeup error, lightSdkProcessor is null!");
                        return;
                    }
                    g gVar = g.f270406a;
                    gVar.w(gVar.k(), this.f270386d);
                    gVar.w(gVar.m(), this.f270387e);
                    BeautyProcessor.this.f270375a.s(this.f270386d, this.f270387e, TemplateRenderStrategy.TemplateType.MAKEUP);
                }
            });
        }
    }

    public void I(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            m(new Runnable(str) { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.BeautyProcessor.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f270390d;

                {
                    this.f270390d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BeautyProcessor.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.i("BeautyProcessor", 1, String.format("updateProp path=%s", this.f270390d));
                    if (BeautyProcessor.this.f270375a == null) {
                        QLog.e("BeautyProcessor", 1, "updateProp error, lightSdkProcessor is null!");
                        return;
                    }
                    g gVar = g.f270406a;
                    gVar.w(gVar.o(), this.f270390d);
                    BeautyProcessor.this.f270375a.s(this.f270390d, String.valueOf(1.0f), TemplateRenderStrategy.TemplateType.PROP);
                    if (TextUtils.isEmpty(this.f270390d)) {
                        BeautyProcessor.this.D();
                    }
                }
            });
        }
    }

    public void J(MotionEvent motionEvent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, motionEvent, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            m(new Runnable(i3, i16, motionEvent) { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.BeautyProcessor.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f270391d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f270392e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ MotionEvent f270393f;

                {
                    this.f270391d = i3;
                    this.f270392e = i16;
                    this.f270393f = motionEvent;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BeautyProcessor.this, Integer.valueOf(i3), Integer.valueOf(i16), motionEvent);
                    }
                }

                @Override // java.lang.Runnable
                @SuppressLint({"DefaultLocale"})
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.i("BeautyProcessor", 1, String.format("updateTouchEvent width=%d, height=%d", Integer.valueOf(this.f270391d), Integer.valueOf(this.f270392e)));
                    if (BeautyProcessor.this.f270375a == null) {
                        QLog.e("BeautyProcessor", 1, "updateTouchEvent error, lightSdkProcessor is null!");
                    } else {
                        BeautyProcessor.this.f270375a.v(this.f270393f, this.f270391d, this.f270392e);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a
    public int a(QQLiveVideoBaseFrame qQLiveVideoBaseFrame, QQLiveVideoBaseFrame qQLiveVideoBaseFrame2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveVideoBaseFrame, (Object) qQLiveVideoBaseFrame2)).intValue();
        }
        if (this.f270375a == null) {
            QLog.e("BeautyProcessor", 1, "onProcessVideoFrame error, lightSdkProcessor is null!");
            return 0;
        }
        if (!this.f270375a.f()) {
            this.f270375a.a(qQLiveVideoBaseFrame, qQLiveVideoBaseFrame2);
        }
        while (!this.f270377c.isEmpty()) {
            Runnable poll = this.f270377c.poll();
            if (poll != null) {
                poll.run();
            }
        }
        this.f270375a.k(qQLiveVideoBaseFrame, qQLiveVideoBaseFrame2);
        return 0;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.i("BeautyProcessor", 1, "onGLContextDestroy");
        if (this.f270375a != null) {
            this.f270375a.o();
            this.f270375a = null;
        }
    }

    public void f(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bVar);
        } else {
            this.f270378d.add(bVar);
        }
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 11) {
                        g();
                        return;
                    } else {
                        j(DataModel.BeautySecondaryItem.SUB_THIN_FACE_NATURE, 11);
                        return;
                    }
                }
                k();
                return;
            }
            l();
            return;
        }
        i();
    }

    public void m(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) runnable);
            return;
        }
        synchronized (this.f270377c) {
            this.f270377c.add(runnable);
        }
    }

    public void o(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        } else {
            this.f270376b = context;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a
    public void onGLContextCreated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("BeautyProcessor", 1, "onGLContextCreated");
        if (this.f270375a == null) {
            this.f270375a = new com.tencent.mobileqq.qqlive.anchor.beauty.processor.b(this.f270376b);
            this.f270375a.m(this.f270379e);
            p();
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        q();
        t();
        u();
        s();
        C();
    }

    public void v(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bVar);
        } else {
            this.f270378d.remove(bVar);
        }
    }

    public void x(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 11) {
                        w();
                        return;
                    } else {
                        z(DataModel.BeautySecondaryItem.SUB_THIN_FACE_NATURE, 11);
                        return;
                    }
                }
                A();
                return;
            }
            B();
            return;
        }
        y();
    }
}
