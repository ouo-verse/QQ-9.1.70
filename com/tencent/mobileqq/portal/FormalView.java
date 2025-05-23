package com.tencent.mobileqq.portal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.SpringGiftView;
import com.tencent.mobileqq.springhb.ac;
import com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.springhb.entry.model.EntryConfigBean;
import com.tencent.mobileqq.springhb.entry.model.OnGrabActivityData;
import com.tencent.mobileqq.springhb.h;
import com.tencent.mobileqq.springhb.module.ConversationHongBaoV2;
import com.tencent.mobileqq.springhb.pack.PackInfo;
import com.tencent.mobileqq.springhb.preload.SpringRes;
import com.tencent.mobileqq.springhb.preload.s;
import com.tencent.mobileqq.util.af;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class FormalView extends BaseFormalView implements Handler.Callback, h.a, com.tencent.mobileqq.vip.j {
    static IPatchRedirector $redirector_;
    private AnimationSet C;
    private final TextView D;
    private final TextView E;
    private long F;
    private final ImageView G;
    private final View H;
    private final ImageView I;
    private final ProgressViewYellow J;
    private final HongbaoView K;
    private final Handler L;
    public List<PortalManager.LogoConfig> M;
    private final ConversationHongBaoV2 N;
    private boolean P;
    private final View Q;
    private long R;
    private long S;
    private boolean T;
    private boolean U;
    private String V;
    private long W;

    /* renamed from: a0, reason: collision with root package name */
    private String f259164a0;

    /* renamed from: b0, reason: collision with root package name */
    private long f259165b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f259166c0;

    /* renamed from: d, reason: collision with root package name */
    private final Set<Integer> f259167d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f259168d0;

    /* renamed from: e, reason: collision with root package name */
    private final StrokeTextView f259169e;

    /* renamed from: e0, reason: collision with root package name */
    boolean f259170e0;

    /* renamed from: f, reason: collision with root package name */
    private final ComboView f259171f;

    /* renamed from: h, reason: collision with root package name */
    private final SpeedComboView f259172h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f259173i;

    /* renamed from: m, reason: collision with root package name */
    private final ImageView f259174m;

    public FormalView(Context context, ConversationHongBaoV2 conversationHongBaoV2) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) conversationHongBaoV2);
            return;
        }
        this.P = true;
        this.R = 0L;
        this.S = 0L;
        this.T = false;
        this.U = false;
        this.V = "\u7ea2\u5305\u96e8\u7ed3\u675f";
        this.W = 0L;
        this.f259164a0 = "";
        this.f259165b0 = 0L;
        this.f259166c0 = 0;
        this.f259168d0 = false;
        this.f259170e0 = false;
        this.N = conversationHongBaoV2;
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        LayoutInflater.from(context).inflate(R.layout.av8, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.f87594us);
        this.G = imageView;
        this.f259171f = (ComboView) findViewById(R.id.f164845u14);
        SpeedComboView speedComboView = (SpeedComboView) findViewById(R.id.f87254tv);
        this.f259172h = speedComboView;
        speedComboView.a();
        OnGrabActivityData a16 = com.tencent.mobileqq.springhb.entry.helper.a.a();
        this.f259173i = a16 != null && TextUtils.equals(a16.comboViewType, "SpeedComboView");
        this.f259167d = B();
        StrokeTextView strokeTextView = (StrokeTextView) findViewById(R.id.d7h);
        this.f259169e = strokeTextView;
        strokeTextView.setText("\u53cc\u624b\u64cd\u4f5c\u66f4\u5bb9\u6613\u5f97\u798f\u5e01\u54e6~");
        this.f259174m = (ImageView) findViewById(R.id.d7e);
        this.D = (TextView) findViewById(R.id.jll);
        TextView textView = (TextView) findViewById(R.id.i0l);
        this.E = textView;
        if (Build.VERSION.SDK_INT >= 26) {
            textView.setShadowLayer(10.0f, 0.0f, 0.0f, -1);
        }
        this.H = findViewById(R.id.g1v);
        ProgressViewYellow progressViewYellow = (ProgressViewYellow) findViewById(R.id.g1o);
        this.J = progressViewYellow;
        SpringRes a17 = s.a("spring_shua_progress_bg.png");
        ColorDrawable colorDrawable = ApngOptions.TRANSPARENT;
        progressViewYellow.setBackground(a17.i(colorDrawable, new Bundle()));
        this.I = (ImageView) findViewById(R.id.f166546g21);
        this.Q = findViewById(R.id.zrt);
        HongbaoView hongbaoView = new HongbaoView(getContext());
        this.K = hongbaoView;
        hongbaoView.setOnGiftResultAnimFinished(this);
        addView(hongbaoView, 0, new RelativeLayout.LayoutParams(-1, -1));
        this.L = new Handler(this);
        SpringGiftView.f();
        if (ac.h().i()) {
            imageView.setImageDrawable(s.a("spring_shua_music_mute.png").i(colorDrawable, new Bundle()));
        } else {
            imageView.setImageDrawable(s.a("spring_shua_music_open.png").i(colorDrawable, new Bundle()));
        }
        y();
    }

    private AnimationSet A() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.5f, 1.0f, 1.5f, 1.0f, 1, 0.5f, 1, 0.5f);
        animationSet.setInterpolator(new OvershootInterpolator(1.0f));
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(400L);
        animationSet.setFillAfter(true);
        return animationSet;
    }

    private static Set<Integer> B() {
        EntryConfigBean J;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof QQAppInterface) && (J = ((SpringFestivalEntryManager) peekAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).J()) != null) {
            return J.commonData.comboNumberSet;
        }
        return new HashSet();
    }

    private static String C() {
        EntryConfigBean J;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof QQAppInterface) && (J = ((SpringFestivalEntryManager) peekAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).J()) != null) {
            return J.commonData.comboResUrl;
        }
        return null;
    }

    private boolean D(int i3) {
        return this.f259167d.contains(Integer.valueOf(i3));
    }

    private boolean E(float f16, float f17) {
        int[] iArr = {0, 0};
        this.G.getLocationOnScreen(iArr);
        int width = iArr[0] + this.G.getWidth();
        int height = iArr[1] + this.G.getHeight();
        if (f16 < iArr[0] || f16 >= width || f17 < iArr[1] || f17 >= height) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(Drawable drawable, Typeface typeface, Drawable drawable2) {
        View view = this.Q;
        if (view != null) {
            view.setBackground(drawable);
            TextView textView = (TextView) this.Q.findViewById(R.id.zrv);
            if (textView != null) {
                textView.setTypeface(typeface);
            }
            TextView textView2 = (TextView) this.Q.findViewById(R.id.zru);
            if (textView2 != null) {
                textView2.setTypeface(typeface);
            }
        }
        TextView textView3 = this.E;
        if (textView3 != null) {
            textView3.setTypeface(typeface);
        }
        setBackground(drawable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        SpringRes a16 = s.a("spring_shua_avoid_peak_bg.png");
        ColorDrawable colorDrawable = ApngOptions.TRANSPARENT;
        final Drawable i3 = a16.i(colorDrawable, new Bundle());
        final Drawable i16 = s.a("spring_shua_main_bg.png").i(colorDrawable, new Bundle());
        final Typeface createFromAsset = Typeface.createFromAsset(applicationContext.getAssets(), "fonts/FZ_PANGWA_SIMPLIFIED.ttf");
        post(new Runnable() { // from class: com.tencent.mobileqq.portal.f
            @Override // java.lang.Runnable
            public final void run() {
                FormalView.this.F(i3, createFromAsset, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        SpringGiftView.f();
        com.tencent.mobileqq.springhb.h.i((Activity) getContext(), 2, this.f259166c0, this, 0);
    }

    private void I() {
        boolean z16 = !ac.h().i();
        this.K.setMute(z16);
        if (z16) {
            this.G.setImageDrawable(s.a("spring_shua_music_mute.png").i(ApngOptions.TRANSPARENT, new Bundle()));
        } else {
            this.G.setImageDrawable(s.a("spring_shua_music_open.png").i(ApngOptions.TRANSPARENT, new Bundle()));
        }
    }

    private void J(ImageView imageView, int i3) {
        String C = C();
        if (TextUtils.isEmpty(C)) {
            imageView.setImageDrawable(ApngOptions.TRANSPARENT);
            return;
        }
        SpringRes b16 = s.b(C);
        String str = i3 + ".png";
        String str2 = b16.o() + File.separator + str;
        if (b16.r() && new File(str2).exists()) {
            imageView.setImageDrawable(b16.n(ApngOptions.TRANSPARENT, str, new Bundle()));
        } else {
            imageView.setImageDrawable(ApngOptions.TRANSPARENT);
        }
    }

    private void y() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.portal.e
            @Override // java.lang.Runnable
            public final void run() {
                FormalView.this.G();
            }
        }, 64, null, false);
    }

    public static boolean z() {
        String C = C();
        if (TextUtils.isEmpty(C)) {
            return false;
        }
        String o16 = s.b(C).o();
        if (TextUtils.isEmpty(o16)) {
            return false;
        }
        Iterator<Integer> it = B().iterator();
        while (it.hasNext()) {
            String str = o16 + File.separator + (it.next().intValue() + ".png");
            if (!new File(str).exists()) {
                QLog.e("FormalView", 1, "checkComboNumberFiles file doesn't exist:", str);
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vip.j
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        this.N.y0();
        QLog.d("FormalView", 1, "onFireGift");
        post(new Runnable() { // from class: com.tencent.mobileqq.portal.d
            @Override // java.lang.Runnable
            public final void run() {
                FormalView.this.H();
            }
        });
    }

    @Override // com.tencent.mobileqq.springhb.h.a
    public void b(boolean z16, PackInfo packInfo, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Boolean.valueOf(z16), packInfo, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.springhb.h.a
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        QLog.d("FormalView", 1, "onGiftViewShow");
        this.N.A0();
        u();
    }

    @Override // com.tencent.mobileqq.springhb.h.a
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            QLog.d("FormalView", 1, "onGiftViewHide");
            this.N.C0();
        }
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void e(int i3, int i16, String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        if (!this.P) {
            QLog.d("FormalView", 2, "combo, no network and refuse");
            return;
        }
        if (i3 > 0) {
            this.K.m(i3, this.f259165b0);
        }
        this.E.setVisibility(8);
        long currentTimeMillis = System.currentTimeMillis();
        if (i16 > 0 && currentTimeMillis - this.F < 500) {
            return;
        }
        if (this.C == null) {
            this.C = A();
        }
        this.C.reset();
        boolean D = D(i16);
        if (!D) {
            this.f259174m.setVisibility(4);
            this.f259174m.clearAnimation();
            if (this.f259173i) {
                this.f259172h.setVisibility(0);
                if (i16 != -100 && i16 != -101) {
                    this.f259172h.setComboCount(i16);
                    this.f259172h.startAnimation(this.C);
                } else if (i16 == -101) {
                    this.f259172h.setVisibility(4);
                    this.f259172h.clearAnimation();
                }
            } else {
                this.f259171f.setVisibility(0);
                this.f259169e.setVisibility(0);
                if (!TextUtils.isEmpty(str)) {
                    this.f259169e.setText(str);
                }
                if (i16 == -100) {
                    this.f259171f.setText("\u52a0\u628a\u52b2\u513f");
                } else if (i16 == -101) {
                    this.f259171f.setText(this.V);
                } else if (i16 < 10) {
                    this.f259171f.setText(i16 + "\u8fde\u5237");
                } else {
                    this.f259171f.setText(HippyTKDListViewAdapter.X + i16);
                }
                this.f259171f.startAnimation(this.C);
            }
        } else {
            this.f259172h.setVisibility(4);
            this.f259172h.clearAnimation();
            this.f259171f.setVisibility(4);
            this.f259171f.clearAnimation();
            this.f259169e.setVisibility(4);
            this.f259174m.setVisibility(0);
            J(this.f259174m, i16);
            this.f259174m.startAnimation(this.C);
            this.F = currentTimeMillis;
        }
        if (i16 == -101) {
            this.f259169e.setVisibility(4);
        }
        if (i16 > 0) {
            this.L.removeMessages(1);
            Handler handler = this.L;
            if (D) {
                j3 = 2000;
            } else {
                j3 = 800;
            }
            handler.sendEmptyMessageDelayed(1, j3);
        }
        this.f259168d0 = true;
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.S;
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void g(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) viewGroup);
            return;
        }
        ViewGroup viewGroup2 = viewGroup;
        while (true) {
            if (viewGroup2.getId() == R.id.b9o) {
                viewGroup = viewGroup2;
                break;
            } else {
                if (viewGroup2.getId() == af.c()) {
                    break;
                }
                if (viewGroup2.getParent() != null) {
                    viewGroup2 = (ViewGroup) viewGroup2.getParent();
                } else {
                    viewGroup2 = null;
                }
                if (viewGroup2 == null) {
                    break;
                }
            }
        }
        View findViewById = viewGroup.findViewById(R.id.gqz);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.Q.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 2 && this.f259170e0) {
                e(-101, -101, "");
                return false;
            }
            return false;
        }
        if (this.f259168d0 && !this.f259170e0) {
            e(-100, -100, "");
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.K.p();
        }
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void k(@NonNull MotionEvent motionEvent) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) motionEvent);
            return;
        }
        if (E(motionEvent.getRawX(), motionEvent.getRawY())) {
            j3 = SystemClock.uptimeMillis();
        } else {
            j3 = 0;
        }
        this.W = j3;
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void l(@Nullable MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) motionEvent);
        } else if (SystemClock.uptimeMillis() - this.W <= 300 && E(motionEvent.getRawX(), motionEvent.getRawY())) {
            I();
        }
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.K.k();
        }
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.K.o();
        }
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void o(long j3, long j16, CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), Long.valueOf(j16), charSequence);
            return;
        }
        this.f259166c0 = (int) (j3 / 1000);
        this.H.setVisibility(0);
        this.J.b(j3, j16);
        this.E.setVisibility(8);
        this.D.setVisibility(0);
        this.f259165b0 = j16 - j3;
        String charSequence2 = charSequence.toString();
        if (!this.f259164a0.equals(charSequence2)) {
            this.D.setText("\u5012\u8ba1\u65f6  " + ((Object) charSequence));
            this.f259164a0 = charSequence2;
        }
        this.I.setTranslationX((int) ((BaseAIOUtils.f(275.0f, getResources()) * this.f259165b0) / j16));
        if (!this.U && this.T) {
            this.R = this.f259165b0;
        }
        this.U = true;
        this.K.q(j3);
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.T) {
            if (this.U) {
                this.S += this.f259165b0 - this.R;
            }
            this.T = false;
        }
        this.K.k();
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void q(Function1<Boolean, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) function1);
            return;
        }
        this.K.r(function1);
        this.H.setVisibility(4);
        this.D.setVisibility(4);
        this.f259169e.setVisibility(4);
        if (this.K.i()) {
            this.N.O0();
            this.L.sendEmptyMessage(2);
        }
        this.f259170e0 = true;
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void r(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) viewGroup);
            return;
        }
        ViewGroup viewGroup2 = viewGroup;
        while (true) {
            if (viewGroup2.getId() == R.id.b9o) {
                viewGroup = viewGroup2;
                break;
            } else {
                if (viewGroup2.getId() == af.c()) {
                    break;
                }
                if (viewGroup2.getParent() != null) {
                    viewGroup2 = (ViewGroup) viewGroup2.getParent();
                } else {
                    viewGroup2 = null;
                }
                if (viewGroup2 == null) {
                    break;
                }
            }
        }
        View findViewById = viewGroup.findViewById(R.id.gqz);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.H.setVisibility(4);
        this.D.setVisibility(4);
        this.E.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void setGiftFiredNums(List<Integer> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) list);
        } else {
            this.K.setGiftFiredNums(list);
        }
    }

    public void setLogoConfigList(List<PortalManager.LogoConfig> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) list);
            return;
        }
        this.M = list;
        if (list != null && QLog.isColorLevel()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                PortalManager.LogoConfig logoConfig = list.get(i3);
                if (logoConfig != null) {
                    QLog.d("FormalView", 2, "setLogoConfigList, index=" + i3 + ", p=" + logoConfig);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void setProgressLogo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FormalView", 2, "setProgressLogo, bmp=" + str);
        }
        Drawable i3 = s.a("spring_shua_progress_brand.png").i(ApngOptions.TRANSPARENT, new Bundle());
        if (!TextUtils.isEmpty(str)) {
            this.I.setImageDrawable(s.b(str).i(i3, new Bundle()));
        } else {
            this.I.setImageDrawable(i3);
        }
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void setStartAndEndText(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.E.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.V = str2;
        }
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void setUpgradeNums(List<Integer> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        }
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        boolean z16 = true;
        if (!this.T) {
            if (this.U) {
                this.R = this.f259165b0;
            }
            this.T = true;
        }
        boolean i06 = this.N.i0();
        this.P = i06;
        if (this.Q.getVisibility() != 8) {
            z16 = false;
        }
        if (i06 != z16) {
            if (this.P) {
                this.Q.setVisibility(8);
            } else {
                this.Q.setVisibility(0);
                if (Build.VERSION.SDK_INT >= 26) {
                    ((TextView) this.Q.findViewById(R.id.zrv)).setShadowLayer(10.0f, 0.0f, 0.0f, -1);
                    ((TextView) this.Q.findViewById(R.id.zru)).setShadowLayer(10.0f, 0.0f, 0.0f, -1);
                }
            }
        }
        if (this.P) {
            this.K.l();
        } else {
            this.K.k();
        }
    }

    @Override // com.tencent.mobileqq.portal.BaseFormalView
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.U && this.T) {
            this.S += this.f259165b0 - this.R;
            this.T = false;
        }
    }
}
