package com.tencent.mobileqq.magicface.view;

import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MagicfaceViewController implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    public static boolean Y;
    protected TextView C;
    protected TextView D;
    protected TextView E;
    protected TextView F;
    protected Button G;
    protected Button H;
    protected Button I;
    protected Button J;
    protected ImageView K;
    public MagicfaceActionManager L;
    protected Button M;
    protected Button N;
    protected View P;
    protected View Q;
    protected boolean R;
    protected WindowManager S;
    protected Handler T;
    protected ActionGlobalData U;
    Runnable V;
    protected c W;
    Emoticon X;

    /* renamed from: d, reason: collision with root package name */
    protected a61.c f243528d;

    /* renamed from: e, reason: collision with root package name */
    protected String f243529e;

    /* renamed from: f, reason: collision with root package name */
    protected MagicfaceContainerView f243530f;

    /* renamed from: h, reason: collision with root package name */
    protected MagicfaceContainerView f243531h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.mobileqq.magicface.view.b f243532i;

    /* renamed from: m, reason: collision with root package name */
    protected com.tencent.mobileqq.magicface.view.b f243533m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements MagicfaceActionManager.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MagicfaceActionManager f243549a;

        a(MagicfaceActionManager magicfaceActionManager) {
            this.f243549a = magicfaceActionManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MagicfaceViewController.this, (Object) magicfaceActionManager);
            }
        }

        @Override // com.tencent.mobileqq.magicface.service.MagicfaceActionManager.e
        public void magicfaceClose() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f243549a.x();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements MagicfaceView.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Emoticon f243551a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f243552b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f243553c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f243554d;

        b(Emoticon emoticon, int i3, String str, int i16) {
            this.f243551a = emoticon;
            this.f243552b = i3;
            this.f243553c = str;
            this.f243554d = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MagicfaceViewController.this, emoticon, Integer.valueOf(i3), str, Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.mobileqq.magicface.view.MagicfaceView.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                MagicfaceViewController.this.L.g(this.f243551a, this.f243552b, this.f243553c, this.f243554d);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72945);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        Y = false;
        String o16 = ah.o();
        if (o16 != null) {
            String lowerCase = o16.toLowerCase();
            if (!lowerCase.contains("marvell") && !lowerCase.contains("armv5") && !lowerCase.contains("armv6")) {
                Y = true;
            } else {
                Y = false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("MagicfaceViewController", 2, "cpuType=" + o16);
        }
    }

    public static boolean c() {
        if (!VasToggle.BUG_108571707_2.isEnable(true)) {
            return false;
        }
        if (((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.magicface_support.name()) && Y && DecoderUtil.IS_LOAD_SUCESS) {
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceViewController", 2, "is_support_magic:TRUE");
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceViewController", 2, "is_support_magic:FALSE");
        }
        return false;
    }

    public void a() {
        View inflate;
        View inflate2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceViewController", 2, "initMagicfaceView begins");
        }
        if (this.f243530f == null) {
            if (QLog.isColorLevel()) {
                QLog.i("MagicfaceViewController", 2, "initMagicfaceView=======qvip_magicface_send");
            }
            if (this.R) {
                inflate2 = View.inflate(BaseApplication.getContext(), R.layout.bcf, null);
            } else {
                inflate2 = View.inflate(BaseApplication.getContext(), R.layout.bch, null);
            }
            this.f243532i = (com.tencent.mobileqq.magicface.view.b) inflate2.findViewById(R.id.ekv);
            this.f243530f = (MagicfaceContainerView) inflate2.findViewById(R.id.ekw);
            this.C = (TextView) inflate2.findViewById(R.id.el9);
            this.D = (TextView) inflate2.findViewById(R.id.ekx);
            this.H = (Button) inflate2.findViewById(R.id.el6);
            this.G = (Button) inflate2.findViewById(R.id.eku);
            this.J = (Button) inflate2.findViewById(R.id.el7);
            this.M = (Button) inflate2.findViewById(R.id.el8);
            this.G.setOnClickListener(this);
            this.H.setOnClickListener(this);
            this.J.setOnClickListener(this);
            this.M.setOnClickListener(this);
        }
        if (this.f243531h == null) {
            if (this.R) {
                inflate = View.inflate(BaseApplication.getContext(), R.layout.bce, null);
            } else {
                inflate = View.inflate(BaseApplication.getContext(), R.layout.bcg, null);
            }
            View inflate3 = View.inflate(BaseApplication.getContext(), R.layout.bci, null);
            this.P = inflate3;
            this.Q = inflate3.findViewById(R.id.el5);
            this.f243533m = (com.tencent.mobileqq.magicface.view.b) inflate.findViewById(R.id.eky);
            this.f243531h = (MagicfaceContainerView) inflate.findViewById(R.id.f166172el0);
            this.E = (TextView) this.P.findViewById(R.id.f166176el4);
            this.F = (TextView) inflate.findViewById(R.id.f166174el2);
            this.I = (Button) this.P.findViewById(R.id.ekz);
            this.N = (Button) this.P.findViewById(R.id.f166173el1);
            this.K = (ImageView) this.P.findViewById(R.id.f166175el3);
            this.I.setOnClickListener(this);
            this.N.setOnClickListener(this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceViewController", 2, "initMagicfaceView ends");
        }
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (this.P == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT < 26) {
            layoutParams.type = 2002;
        } else {
            layoutParams.type = 2038;
        }
        layoutParams.flags = 40;
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = i3;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.format = 1;
        this.S = (WindowManager) BaseApplication.getContext().getSystemService("window");
        if (this.P.getParent() != null) {
            try {
                this.S.removeView(this.P);
            } catch (Exception e16) {
                QLog.e("MagicfaceViewController", 1, "initTopbar: ", e16);
            }
        }
        try {
            this.S.addView(this.P, layoutParams);
        } catch (Exception e17) {
            QLog.e("MagicfaceViewController", 1, "initTopbar: ", e17);
        }
    }

    public void d(Emoticon emoticon, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) emoticon, (Object) cVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceViewController", 2, "func magicfaceAutoPlay, magicValue:" + emoticon.magicValue);
        }
        this.W = cVar;
        if (!c()) {
            c cVar2 = this.W;
            if (cVar2 != null) {
                cVar2.onPlayEnd();
                this.W = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceViewController", 2, "func magicfaceAutoPlay ends, not support.");
                return;
            }
            return;
        }
        Emoticon emoticon2 = new Emoticon();
        emoticon2.eId = emoticon.eId;
        emoticon2.epId = emoticon.epId;
        emoticon2.magicValue = emoticon.magicValue;
        emoticon2.jobType = emoticon.jobType;
        this.X = emoticon2;
        if (this.T != null) {
            if (this.V == null) {
                this.V = new Runnable() { // from class: com.tencent.mobileqq.magicface.view.MagicfaceViewController.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MagicfaceViewController.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("MagicfaceViewController", 2, "func run, magicValue:" + MagicfaceViewController.this.X.magicValue);
                        }
                        MagicfaceViewController magicfaceViewController = MagicfaceViewController.this;
                        magicfaceViewController.h(magicfaceViewController.X, 1, null);
                    }
                };
            }
            this.T.postDelayed(this.V, 400L);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.T.post(new Runnable() { // from class: com.tencent.mobileqq.magicface.view.MagicfaceViewController.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MagicfaceViewController.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        MagicfaceViewController.this.g();
                    }
                }
            });
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.L != null) {
            this.f243530f.setVisibility(8);
            ((View) this.f243532i).setVisibility(8);
            this.f243532i.setSurfaceCreatelistener(null);
            this.f243531h.setVisibility(8);
            this.f243530f.setMagicfaceGestureListener(null);
            this.f243531h.setMagicfaceGestureListener(null);
            ((View) this.f243533m).setVisibility(8);
            this.f243533m.setSurfaceCreatelistener(null);
            try {
                if (QLog.isColorLevel()) {
                    QLog.i("MagicfaceViewController", 2, "removeView=======DecorView");
                }
                ViewGroup c16 = this.f243528d.c();
                c16.removeView(this.f243531h);
                c16.removeView(this.f243530f);
                View view = this.P;
                if (view != null) {
                    view.setVisibility(8);
                    WindowManager windowManager = this.S;
                    if (windowManager != null) {
                        windowManager.removeView(this.P);
                    }
                }
            } catch (Exception unused) {
            }
            if (this.L.r()) {
                MagicfaceActionManager magicfaceActionManager = this.L;
                magicfaceActionManager.e(new a(magicfaceActionManager));
            } else {
                this.L.x();
            }
            c cVar = this.W;
            if (cVar != null) {
                cVar.onPlayEnd();
                this.W = null;
            }
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.J.getTag() == null) {
            return;
        }
        Emoticon emoticon = (Emoticon) this.J.getTag();
        if (emoticon.jobType == 2) {
            MagicfaceActionManager magicfaceActionManager = this.L;
            if (magicfaceActionManager != null && magicfaceActionManager.l() >= 0) {
                if (this.L.l() == 0) {
                    emoticon.magicValue = "value=1";
                } else {
                    emoticon.magicValue = "value=" + this.L.l();
                }
            }
            QQAppInterface f16 = this.f243528d.f();
            a61.c cVar = this.f243528d;
            ChatActivityFacade.H0(f16, cVar.f25578c, cVar.m(), emoticon);
            f();
            d(emoticon, null);
        }
    }

    public void h(Emoticon emoticon, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, emoticon, Integer.valueOf(i3), str);
            return;
        }
        AIOAnimationControlManager aIOAnimationControlManager = (AIOAnimationControlManager) this.f243528d.f25577b.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
        if (aIOAnimationControlManager != null && aIOAnimationControlManager.f306804d != 1) {
            aIOAnimationControlManager.D();
        }
        i(emoticon, i3, str, 1);
    }

    public void i(Emoticon emoticon, int i3, String str, int i16) {
        com.tencent.mobileqq.magicface.view.b bVar;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, emoticon, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicfaceViewController", 2, "func playMaigcface, magicValue:" + emoticon.magicValue);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = this.f243532i;
        if (obj != null && ((View) obj).getVisibility() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 1.");
            }
            c cVar = this.W;
            if (cVar != null) {
                cVar.onPlayEnd();
                this.W = null;
                return;
            }
            return;
        }
        Object obj2 = this.f243533m;
        if (obj2 != null && ((View) obj2).getVisibility() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 2.");
            }
            c cVar2 = this.W;
            if (cVar2 != null) {
                cVar2.onPlayEnd();
                this.W = null;
                return;
            }
            return;
        }
        MagicfaceActionManager magicfaceActionManager = this.L;
        if (magicfaceActionManager != null && magicfaceActionManager.r()) {
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 3.");
            }
            c cVar3 = this.W;
            if (cVar3 != null) {
                cVar3.onPlayEnd();
                this.W = null;
                return;
            }
            return;
        }
        if (i3 == 1) {
            ActionGlobalData o16 = MagicfaceActionManager.o(emoticon, i3, i16);
            this.U = o16;
            if (o16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 4.");
                }
                c cVar4 = this.W;
                if (cVar4 != null) {
                    cVar4.onPlayEnd();
                    this.W = null;
                    return;
                }
                return;
            }
        }
        this.f243529e = emoticon.epId;
        a();
        this.L = new MagicfaceActionManager(this);
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 5.");
            }
            this.f243531h.setVisibility(8);
            Object obj3 = this.f243533m;
            if (obj3 != null) {
                ((View) obj3).setVisibility(8);
            }
            this.f243530f.setVisibility(0);
            bVar = this.f243532i;
            textView = this.C;
            this.f243530f.setMagicfaceGestureListener(this.L);
            ViewGroup viewGroup = (ViewGroup) this.f243528d.d().getWindow().getDecorView();
            viewGroup.removeView(this.f243530f);
            viewGroup.addView(this.f243530f);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 6.");
            }
            ViewGroup viewGroup2 = (ViewGroup) this.f243528d.d().getWindow().getDecorView();
            viewGroup2.removeView(this.f243531h);
            Rect rect = new Rect();
            viewGroup2.getWindowVisibleDisplayFrame(rect);
            int i17 = rect.top;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.Q.setBackgroundColor(0);
            layoutParams.topMargin = i17;
            b(0);
            viewGroup2.addView(this.f243531h);
            this.f243531h.updateViewLayout((View) this.f243533m, layoutParams);
            this.T.post(new Runnable() { // from class: com.tencent.mobileqq.magicface.view.MagicfaceViewController.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MagicfaceViewController.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) MagicfaceViewController.this.I.getLayoutParams();
                    layoutParams2.rightMargin = (int) al.a(MagicfaceViewController.this.f243528d.d(), 10.0f);
                    MagicfaceViewController.this.I.setLayoutParams(layoutParams2);
                }
            });
            if (this.f243533m != null) {
                this.f243531h.setVisibility(8);
                ((View) this.f243533m).setVisibility(8);
                this.f243531h.setVisibility(0);
                this.f243533m.setIsFullScreen(this.U.f243351d);
            } else {
                QLog.e("MagicfaceViewController", 1, "magicfaceReceivePlay is null");
            }
            this.P.setVisibility(0);
            com.tencent.mobileqq.magicface.view.b bVar2 = this.f243533m;
            TextView textView2 = this.E;
            this.f243531h.setMagicfaceGestureListener(this.L);
            this.K.setVisibility(8);
            this.F.setVisibility(8);
            bVar = bVar2;
            textView = textView2;
        }
        ((View) bVar).setVisibility(0);
        SurfaceView surfaceView = (SurfaceView) bVar;
        surfaceView.setZOrderOnTop(true);
        surfaceView.getHolder().setFormat(-2);
        com.tencent.mobileqq.magicface.service.b bVar3 = new com.tencent.mobileqq.magicface.service.b();
        bVar3.k(bVar);
        this.L.z(bVar3);
        this.L.A(new MagicfaceActionManager.g(i3, textView) { // from class: com.tencent.mobileqq.magicface.view.MagicfaceViewController.6
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f243534a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ TextView f243535b;

            {
                this.f243534a = i3;
                this.f243535b = textView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MagicfaceViewController.this, Integer.valueOf(i3), textView);
                }
            }

            @Override // com.tencent.mobileqq.magicface.service.MagicfaceActionManager.g
            public void a(String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) str2);
                } else {
                    MagicfaceViewController.this.T.post(new Runnable(str2) { // from class: com.tencent.mobileqq.magicface.view.MagicfaceViewController.6.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f243539d;

                        {
                            this.f243539d = str2;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this, (Object) str2);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else if (this.f243539d != null) {
                                MagicfaceViewController.this.F.setVisibility(0);
                                MagicfaceViewController.this.F.setText(this.f243539d);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.magicface.service.MagicfaceActionManager.g
            public void b(String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str2);
                } else {
                    MagicfaceViewController.this.T.post(new Runnable(str2) { // from class: com.tencent.mobileqq.magicface.view.MagicfaceViewController.6.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f243537d;

                        {
                            this.f243537d = str2;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this, (Object) str2);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            if (anonymousClass6.f243534a == 1) {
                                if (this.f243537d == null) {
                                    MagicfaceViewController.this.K.setVisibility(8);
                                } else {
                                    MagicfaceViewController.this.K.setVisibility(0);
                                }
                            }
                            AnonymousClass6.this.f243535b.setText(this.f243537d);
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.magicface.service.MagicfaceActionManager.g
            public void c(String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) str2);
                } else {
                    MagicfaceViewController.this.T.post(new Runnable(str2) { // from class: com.tencent.mobileqq.magicface.view.MagicfaceViewController.6.3
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f243541d;

                        {
                            this.f243541d = str2;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this, (Object) str2);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                MagicfaceViewController.this.D.setText(this.f243541d);
                            }
                        }
                    });
                }
            }
        });
        this.L.y(new MagicfaceActionManager.d(currentTimeMillis, i3) { // from class: com.tencent.mobileqq.magicface.view.MagicfaceViewController.7
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f243543a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f243544b;

            {
                this.f243543a = currentTimeMillis;
                this.f243544b = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MagicfaceViewController.this, Long.valueOf(currentTimeMillis), Integer.valueOf(i3));
                }
            }

            @Override // com.tencent.mobileqq.magicface.service.MagicfaceActionManager.d
            public void magicfaceActionEnd(ActionGlobalData actionGlobalData) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) actionGlobalData);
                } else {
                    MagicfaceViewController.this.T.post(new Runnable() { // from class: com.tencent.mobileqq.magicface.view.MagicfaceViewController.7.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            URLDrawable.resume();
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            if (anonymousClass7.f243544b == 1) {
                                ((View) MagicfaceViewController.this.f243533m).setBackgroundColor(0);
                                MagicfaceViewController.this.f();
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.magicface.service.MagicfaceActionManager.d
            public void magicfaceActionStart(ActionGlobalData actionGlobalData) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) actionGlobalData);
                    return;
                }
                long currentTimeMillis2 = System.currentTimeMillis() - this.f243543a;
                if (QLog.isColorLevel()) {
                    QLog.d("MagicfaceViewController", 2, "\u3010magicface\u3011 cost =" + currentTimeMillis2 + "ms");
                }
                if (this.f243544b == 0) {
                    MagicfaceViewController.this.L.u(MagicfaceViewController.this.L.j());
                } else {
                    MagicfaceViewController.this.L.u(MagicfaceViewController.this.L.i());
                }
                MagicfaceViewController.this.T.post(new Runnable(actionGlobalData) { // from class: com.tencent.mobileqq.magicface.view.MagicfaceViewController.7.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ ActionGlobalData f243546d;

                    {
                        this.f243546d = actionGlobalData;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this, (Object) actionGlobalData);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        URLDrawable.pause();
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        if (anonymousClass7.f243544b == 0) {
                            MagicfaceViewController.this.k();
                        } else {
                            ((View) MagicfaceViewController.this.f243533m).setBackgroundColor(this.f243546d.f243354g);
                            MagicfaceViewController.this.j();
                        }
                        MagicfaceViewController.this.C.setText("");
                        MagicfaceViewController.this.D.setText("");
                    }
                });
            }
        });
        if (bVar.a()) {
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 7.");
            }
            this.L.g(emoticon, i3, str, i16);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 8.");
            }
            bVar.setSurfaceCreatelistener(new b(emoticon, i3, str, i16));
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.L.i()) {
            this.N.setBackgroundResource(R.drawable.f162106fo2);
        } else {
            this.N.setBackgroundResource(R.drawable.btz);
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (this.L.j()) {
            this.M.setBackgroundResource(R.drawable.f162115bu2);
        } else {
            this.M.setBackgroundResource(R.drawable.f162114bu1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.eku) {
                ReportController.o(this.f243528d.f(), "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.f243529e, "", "", "");
                f();
            } else if (id5 == R.id.ekz) {
                ReportController.o(this.f243528d.f(), "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.f243529e, "", "", "");
                f();
            } else if (id5 == R.id.el6) {
                ReportController.o(this.f243528d.f(), "CliOper", "", "", "MbFasong", "MbChongzuo", 0, 0, this.f243529e, "", "", "");
                MagicfaceActionManager magicfaceActionManager = this.L;
                if (magicfaceActionManager != null) {
                    magicfaceActionManager.d();
                    this.T.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.magicface.view.MagicfaceViewController.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MagicfaceViewController.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                MagicfaceViewController.this.L.w();
                            }
                        }
                    }, 300L);
                }
            } else if (id5 == R.id.el7) {
                g();
            } else if (id5 == R.id.el8) {
                boolean j3 = this.L.j();
                this.L.C(!j3);
                k();
                this.L.u(!j3);
                if (!j3) {
                    ReportController.o(this.f243528d.f(), "CliOper", "", "", "MbFasong", "MbKaiqiShengxiao", 0, 0, "", "", "", "");
                }
            } else if (id5 == R.id.f166173el1) {
                boolean i3 = this.L.i();
                this.L.B(!i3);
                j();
                this.L.u(!i3);
                if (!i3) {
                    ReportController.o(this.f243528d.f(), "CliOper", "", "", "MbJieshou", "MbKaiqiShengxiao2", 0, 0, "", "", "", "");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
