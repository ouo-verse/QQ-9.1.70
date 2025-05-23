package com.tencent.mobileqq.springhb;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.entry.model.GameCenterConfigData;
import com.tencent.mobileqq.springhb.h;
import com.tencent.mobileqq.springhb.pack.PackInfo;
import com.tencent.mobileqq.springhb.preload.SpringRes;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SpringGiftView extends RelativeLayout implements View.OnClickListener, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: b0, reason: collision with root package name */
    private static Bitmap f288930b0;

    /* renamed from: c0, reason: collision with root package name */
    private static SpringGiftView f288931c0;
    private ImageView C;
    private ImageView D;
    private ImageView E;
    private ImageView F;
    private View G;
    private View H;
    private View I;
    private ImageView J;
    private View K;
    private Activity L;
    private Handler M;
    private volatile boolean N;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private long T;
    private String U;
    private String V;
    private String W;

    /* renamed from: a0, reason: collision with root package name */
    private h.a f288932a0;

    /* renamed from: d, reason: collision with root package name */
    private TextView f288933d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f288934e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f288935f;

    /* renamed from: h, reason: collision with root package name */
    private PackInfo f288936h;

    /* renamed from: i, reason: collision with root package name */
    private int f288937i;

    /* renamed from: m, reason: collision with root package name */
    private URLImageView f288938m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringGiftView.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    SpringGiftView.this.f288933d.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            SpringGiftView.this.f288933d.setAlpha(0.7f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringGiftView.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    SpringGiftView.this.f288934e.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            SpringGiftView.this.f288934e.setAlpha(0.7f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f288941d;

        c(URLDrawable uRLDrawable) {
            this.f288941d = uRLDrawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringGiftView.this, (Object) uRLDrawable);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            QLog.d("SpringHb_SpringGiftView", 1, "onAnimationEnd");
            if (this.f288941d != null) {
                SpringGiftView.this.C.setImageDrawable(this.f288941d);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                QLog.d("SpringHb_SpringGiftView", 1, "onAnimationStart");
            }
        }
    }

    public SpringGiftView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void d(boolean z16) {
        int i3;
        Drawable colorDrawable;
        removeAllViews();
        this.P = z16;
        LayoutInflater from = LayoutInflater.from(getContext());
        if (z16) {
            i3 = R.layout.hqn;
        } else {
            i3 = R.layout.hqo;
        }
        SpringGiftView springGiftView = (SpringGiftView) from.inflate(i3, (ViewGroup) null);
        setBackgroundColor(0);
        addView(springGiftView, new RelativeLayout.LayoutParams(-1, -1));
        l();
        q();
        p();
        if (f288930b0 != null) {
            colorDrawable = new BitmapDrawable(f288930b0);
        } else {
            QLog.d("SpringHb_SpringGiftView", 1, "changeOrientation, sStarBitmap null");
            colorDrawable = new ColorDrawable(0);
        }
        this.C.setImageDrawable(colorDrawable);
        PackInfo packInfo = this.f288936h;
        if (packInfo != null) {
            t(packInfo);
        }
    }

    private void e() {
        String i3 = i();
        this.U = i3;
        if (TextUtils.isEmpty(i3)) {
            this.U = h(com.tencent.mobileqq.springhb.preload.s.a("spring_gift_get_animate.png"));
        }
        if (TextUtils.isEmpty(this.U)) {
            QLog.d("SpringHb_SpringGiftView", 1, "checkResource, mStarApngPath empty");
        } else if (!com.tencent.mobileqq.filemanager.util.q.p(this.U)) {
            QLog.d("SpringHb_SpringGiftView", 1, "checkResource, mStarApngPath file not found=", this.U);
        }
        String h16 = h(com.tencent.mobileqq.springhb.preload.s.a("spring_gift_get_star_animate.png"));
        this.V = h16;
        if (TextUtils.isEmpty(h16)) {
            QLog.d("SpringHb_SpringGiftView", 1, "checkResource, mStarBgApngPath empty");
        }
        String h17 = h(com.tencent.mobileqq.springhb.preload.s.a("spring_gift_get_boom_animate.png"));
        this.W = h17;
        if (TextUtils.isEmpty(h17)) {
            QLog.d("SpringHb_SpringGiftView", 1, "checkResource, mBoomApngPath empty");
        }
        if (f288930b0 == null) {
            QLog.d("SpringHb_SpringGiftView", 1, "checkResource, load star bitmap");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                f288930b0 = SafeBitmapFactory.decodeFile(this.U);
            } catch (OutOfMemoryError e16) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(601, e16, this.U);
                }
                QLog.e("SpringHb_SpringGiftView", 1, "checkResource get bitmap error:", e16);
            }
            QLog.d("SpringHb_SpringGiftView", 1, "checkResource, load star bitmap end, sStarBitmap=" + f288930b0 + ", duration=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static void f() {
        SpringGiftView springGiftView = f288931c0;
        if (springGiftView != null) {
            springGiftView.j();
            f288931c0 = null;
        }
    }

    private void g() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(250L);
        startAnimation(alphaAnimation);
    }

    public static String h(SpringRes springRes) {
        String l3 = springRes.l();
        if (TextUtils.isEmpty(l3) || !com.tencent.mobileqq.filemanager.util.q.p(l3)) {
            if (!TextUtils.isEmpty(springRes.k())) {
                l3 = springRes.k();
            } else {
                l3 = null;
            }
        }
        if (l3 == null) {
            return "";
        }
        return l3;
    }

    private String i() {
        GameCenterConfigData h16 = com.tencent.mobileqq.springhb.prize.h.h();
        if (h16 != null && !TextUtils.isEmpty(h16.giftAnimResUrl)) {
            String h17 = h(com.tencent.mobileqq.springhb.preload.s.b(h16.giftAnimResUrl));
            if (com.tencent.mobileqq.filemanager.util.q.p(h17)) {
                return h17;
            }
        }
        return "";
    }

    private void k(Activity activity, h.a aVar, boolean z16, int i3, boolean z17) {
        this.L = activity;
        this.f288932a0 = aVar;
        this.P = z16;
        this.f288937i = i3;
        this.S = z17;
        this.T = System.currentTimeMillis();
        ac.h().o(1);
        x.q(getContext());
        e();
        l();
        g();
        q();
        p();
        Handler handler = new Handler(Looper.getMainLooper(), this);
        this.M = handler;
        handler.sendMessageDelayed(handler.obtainMessage(4), 100L);
    }

    private void l() {
        this.G = findViewById(R.id.u6s);
        View findViewById = findViewById(R.id.b9d);
        this.H = findViewById;
        SpringRes a16 = com.tencent.mobileqq.springhb.preload.s.a("spring_gift_open_bg.png");
        ColorDrawable colorDrawable = ApngOptions.TRANSPARENT;
        findViewById.setBackgroundDrawable(a16.i(colorDrawable, new Bundle()));
        View findViewById2 = findViewById(R.id.b9a);
        this.I = findViewById2;
        findViewById2.setBackgroundDrawable(com.tencent.mobileqq.springhb.preload.s.a("spring_gift_logo_bg.png").i(colorDrawable, new Bundle()));
        ImageView imageView = (ImageView) findViewById(R.id.xjm);
        this.J = imageView;
        imageView.setImageDrawable(com.tencent.mobileqq.springhb.preload.s.a("spring_gift_get_word.png").i(colorDrawable, new Bundle()));
        TextView textView = (TextView) findViewById(R.id.tfr);
        this.f288933d = textView;
        textView.setBackgroundDrawable(com.tencent.mobileqq.springhb.preload.s.a("spring_gift_open_bg.png").i(colorDrawable, new Bundle()));
        this.E = (ImageView) findViewById(R.id.xks);
        this.F = (ImageView) findViewById(R.id.xkt);
        this.C = (ImageView) findViewById(R.id.xkr);
        URLImageView uRLImageView = (URLImageView) findViewById(R.id.xka);
        this.f288938m = uRLImageView;
        uRLImageView.setImageDrawable(com.tencent.mobileqq.springhb.preload.s.a("spring_common_qq_logo.png").i(colorDrawable, new Bundle()));
        TextView textView2 = (TextView) findViewById(R.id.aga);
        this.f288934e = textView2;
        textView2.setBackgroundDrawable(com.tencent.mobileqq.springhb.preload.s.a("spring_gift_pause_bg.png").i(colorDrawable, new Bundle()));
        ImageView imageView2 = (ImageView) findViewById(R.id.tdn);
        this.f288935f = imageView2;
        imageView2.setBackground(com.tencent.mobileqq.springhb.preload.s.a("spring_common_close.png").i(colorDrawable, new Bundle()));
        this.K = findViewById(R.id.f1189975n);
        this.G.setVisibility(0);
        this.H.setVisibility(0);
        this.I.setVisibility(4);
        this.J.setVisibility(4);
        this.H.setVisibility(0);
        this.f288933d.setVisibility(4);
        this.f288933d.setOnClickListener(this);
        this.f288934e.setOnClickListener(this);
        this.f288933d.setOnTouchListener(new a());
        this.f288934e.setOnTouchListener(new b());
        this.f288935f.setOnClickListener(this);
        this.K.setOnClickListener(this);
        if (this.f288937i == 2) {
            this.f288934e.setVisibility(0);
            this.f288935f.setVisibility(8);
        } else {
            this.f288934e.setVisibility(8);
            this.f288935f.setVisibility(0);
        }
        if (this.S) {
            this.I.setVisibility(4);
            this.H.setVisibility(4);
            this.f288933d.setVisibility(4);
            this.f288934e.setVisibility(4);
            this.f288935f.setVisibility(4);
        }
    }

    private void m() {
        QLog.d("SpringHb_SpringGiftView", 1, "openGift, mIsOpenGift=", Boolean.valueOf(this.N));
        if (this.N) {
            return;
        }
        this.N = true;
        n();
        this.M.removeMessages(1);
        Handler handler = this.M;
        handler.sendMessageDelayed(handler.obtainMessage(1), 400L);
    }

    private void n() {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        QLog.d("SpringHb_SpringGiftView", 1, "playOpenGiftAnimation");
        ImageView imageView = (ImageView) findViewById(R.id.xja);
        this.D = imageView;
        imageView.setVisibility(0);
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoadingDrawable(new ColorDrawable(7));
        apngOptions.setUseCache(true);
        Resources resources = super.getResources();
        if (this.P) {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.dcy);
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.dcx);
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.dcz);
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.dcw);
        }
        apngOptions.setRequestWidth(dimensionPixelSize);
        apngOptions.setRequestHeight(dimensionPixelSize2);
        apngOptions.setUseCache(false);
        apngOptions.setLoop(1);
        if (!TextUtils.isEmpty(this.W)) {
            this.D.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", apngOptions, this.W));
        }
    }

    private void o() {
        Drawable colorDrawable;
        int dimensionPixelSize;
        String str;
        Drawable colorDrawable2;
        ApngOptions apngOptions = new ApngOptions();
        if (f288930b0 != null) {
            colorDrawable = new BitmapDrawable(f288930b0);
        } else {
            colorDrawable = new ColorDrawable(0);
        }
        apngOptions.setLoadingDrawable(colorDrawable);
        apngOptions.setUseCache(false);
        Resources resources = super.getResources();
        if (this.P) {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.dd7);
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.dd9);
        }
        apngOptions.setRequestWidth(dimensionPixelSize);
        apngOptions.setRequestHeight(dimensionPixelSize);
        GameCenterConfigData h16 = com.tencent.mobileqq.springhb.prize.h.h();
        if (h16 != null && !TextUtils.isEmpty(h16.giftAnimResUrl)) {
            str = h16.giftAnimResUrl;
        } else {
            str = "";
        }
        URLDrawable f16 = com.tencent.mobileqq.springhb.prize.h.f(str, "spring_gift_get_animate.png", apngOptions);
        if (f288930b0 != null) {
            colorDrawable2 = new BitmapDrawable(f288930b0);
        } else {
            QLog.d("SpringHb_SpringGiftView", 1, "playShowAnimation, sStarBitmap null");
            colorDrawable2 = new ColorDrawable(0);
        }
        this.C.setImageDrawable(colorDrawable2);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.3f, 1.0f, 0.3f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(250L);
        scaleAnimation.setFillAfter(true);
        RotateAnimation rotateAnimation = new RotateAnimation(45.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(250L);
        rotateAnimation.setRepeatCount(0);
        rotateAnimation.setFillAfter(true);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new c(f16));
        this.C.startAnimation(animationSet);
    }

    private void p() {
        int dpToPx;
        int dpToPx2;
        QLog.d("SpringHb_SpringGiftView", 1, "playStarBg2Animation");
        this.F.setVisibility(0);
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoadingDrawable(new ColorDrawable(7));
        apngOptions.setUseCache(true);
        if (this.P) {
            dpToPx = ViewUtils.dpToPx(188.0f);
            dpToPx2 = ViewUtils.dpToPx(226.0f);
        } else {
            dpToPx = ViewUtils.dpToPx(375.0f);
            dpToPx2 = ViewUtils.dpToPx(450.0f);
        }
        apngOptions.setRequestWidth(dpToPx);
        apngOptions.setRequestHeight(dpToPx2);
        apngOptions.setUseCache(false);
        apngOptions.setLoop(1);
        if (!TextUtils.isEmpty(this.V)) {
            this.F.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", apngOptions, this.V));
        }
    }

    private void q() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154933ty);
        loadAnimation.setInterpolator(new LinearInterpolator());
        this.E.setImageDrawable(com.tencent.mobileqq.springhb.preload.s.a("spring_gift_get_bg.png").i(ApngOptions.TRANSPARENT, new Bundle()));
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.3f, 1.0f, 0.3f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(250L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(loadAnimation);
        animationSet.addAnimation(scaleAnimation);
        this.E.startAnimation(animationSet);
    }

    private void r() {
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", "host");
        hashMap.put("from_src", "2");
        hashMap.put("module_id", "prizecards");
        hashMap.put("submodule_id", "prize_floating");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "exp");
        hashMap.put(QCircleQualityReporter.KEY_OBJ_ID, this.f288936h.bizId);
        hashMap.put("oper_res", String.valueOf(this.f288936h.type));
        hashMap.put("card_id", String.valueOf(this.f288936h.prizeId));
        hashMap.put("changci_id", String.valueOf(this.f288936h.promotionId));
        hashMap.put("ext5", com.tencent.mobileqq.springhb.prize.h.e());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportForGameCenter(hashMap);
        }
    }

    public static SpringGiftView s(Activity activity, h.a aVar, int i3, boolean z16, boolean z17) {
        int i16;
        QLog.d("SpringHb_SpringGiftView", 1, "show");
        long currentTimeMillis = System.currentTimeMillis();
        f();
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (z16) {
            i16 = R.layout.hqn;
        } else {
            i16 = R.layout.hqo;
        }
        SpringGiftView springGiftView = (SpringGiftView) from.inflate(i16, (ViewGroup) null);
        viewGroup.addView(springGiftView, new RelativeLayout.LayoutParams(-1, -1));
        springGiftView.k(activity, aVar, z16, i3, z17);
        if (aVar != null) {
            QLog.d("SpringHb_SpringGiftView", 1, "show, onGiftViewShow");
            aVar.c();
        }
        f288931c0 = springGiftView;
        QLog.d("SpringHb_SpringGiftView", 1, "show, duration=", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return springGiftView;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        o();
                    }
                } else {
                    d(((Boolean) message.obj).booleanValue());
                }
            } else {
                j();
            }
        } else {
            QLog.d("SpringHb_SpringGiftView", 1, "MSG_OPEN_GIFT, mIsOpen=", Boolean.valueOf(this.Q));
            if (!this.Q) {
                this.Q = true;
                x.h(this.L, this.f288936h, this.f288937i, this.P, -1, "");
                this.f288932a0 = null;
                this.M.removeMessages(2);
                Handler handler = this.M;
                handler.sendMessageDelayed(handler.obtainMessage(2), 300L);
            }
        }
        return false;
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d("SpringHb_SpringGiftView", 1, "hide");
        this.R = true;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        this.L = null;
        if (f288931c0 != null) {
            f288931c0 = null;
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
            if (id5 != R.id.f1189975n && id5 != R.id.tfr) {
                if (id5 == R.id.aga || id5 == R.id.tdn) {
                    j();
                    if (this.f288932a0 != null) {
                        QLog.d("SpringHb_SpringGiftView", 1, "onClick, onGiftViewHide");
                        this.f288932a0.d();
                        this.f288932a0 = null;
                    }
                    this.M.removeCallbacksAndMessages(null);
                }
            } else if (this.f288936h != null) {
                m();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        boolean z16 = false;
        QLog.d("SpringHb_SpringGiftView", 1, "onConfigurationChanged, new orientation=", Integer.valueOf(configuration.orientation), ", mIsLandscape=", Boolean.valueOf(this.P));
        if (this.P) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        int i16 = configuration.orientation;
        if (i3 != i16 && this.M != null) {
            if (i16 == 2) {
                z16 = true;
            }
            this.P = z16;
            removeAllViews();
            Message obtainMessage = this.M.obtainMessage(3);
            obtainMessage.obj = Boolean.valueOf(z16);
            this.M.removeMessages(3);
            this.M.sendMessageDelayed(obtainMessage, 200L);
        }
    }

    public void t(PackInfo packInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) packInfo);
            return;
        }
        QLog.d("SpringHb_SpringGiftView", 1, "showResult, mIsHide=", Boolean.valueOf(this.R));
        if (this.R) {
            return;
        }
        this.f288936h = packInfo;
        if (!this.S) {
            this.I.setVisibility(0);
            this.J.setVisibility(0);
            this.f288933d.setVisibility(0);
            this.H.setVisibility(8);
            if (!TextUtils.isEmpty(this.f288936h.businessNamePic)) {
                this.f288938m.setImageDrawable(com.tencent.mobileqq.springhb.preload.s.b(this.f288936h.businessNamePic).i(com.tencent.mobileqq.springhb.preload.s.a("spring_common_qq_logo.png").i(ApngOptions.TRANSPARENT, new Bundle()), new Bundle()));
            }
        } else {
            long currentTimeMillis = System.currentTimeMillis() - this.T;
            if (currentTimeMillis < 1200) {
                this.M.removeMessages(1);
                Handler handler = this.M;
                handler.sendMessageDelayed(handler.obtainMessage(1), 1200 - currentTimeMillis);
            } else {
                this.M.removeMessages(1);
                Handler handler2 = this.M;
                handler2.sendMessage(handler2.obtainMessage(1));
            }
        }
        r();
    }

    public SpringGiftView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public SpringGiftView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
