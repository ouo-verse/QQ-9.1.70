package com.tencent.mobileqq.springhb.module;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.view.TitleAreaHeadLayout;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.portal.BaseFormalView;
import com.tencent.mobileqq.portal.BasePrepareView;
import com.tencent.mobileqq.portal.FormalView;
import com.tencent.mobileqq.portal.PrepareView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.ac;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.entry.c;
import com.tencent.mobileqq.springhb.entry.model.BaseActivityData;
import com.tencent.mobileqq.springhb.entry.model.EntryConfigBean;
import com.tencent.mobileqq.springhb.entry.model.OnGrabActivityData;
import com.tencent.mobileqq.springhb.entry.model.PendantData;
import com.tencent.mobileqq.springhb.entry.model.UserData;
import com.tencent.mobileqq.springhb.main.BaseCountDownProgressView;
import com.tencent.mobileqq.springhb.main.CountDownProgressView;
import com.tencent.mobileqq.springhb.main.SpringToMainHelper;
import com.tencent.mobileqq.springhb.preload.SpringRes;
import com.tencent.mobileqq.springhb.preload.s;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.util.af;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.widget.HongBaoSmartRefreshLayout;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ConversationHongBaoV2 implements Handler.Callback {
    static IPatchRedirector $redirector_;
    public Runnable A0;
    public com.tencent.widget.g B0;
    private boolean C;
    public com.tencent.widget.i C0;
    private boolean D;
    private long D0;
    private boolean E;
    private long E0;
    public long F;
    private Drawable F0;
    public Handler G;
    private Drawable G0;
    public boolean H;
    String H0;
    public int I;
    public long J;
    public boolean K;
    public boolean L;
    public boolean M;
    int N;
    public int P;
    private final com.tencent.mobileqq.springhb.entry.worker.d Q;
    Conversation R;
    int S;
    private int T;
    private int U;
    private int V;
    private boolean W;
    private OnGrabActivityData.Share X;
    private long Y;
    private i Z;

    /* renamed from: a0, reason: collision with root package name */
    long f289398a0;

    /* renamed from: b0, reason: collision with root package name */
    CountDownTimer f289399b0;

    /* renamed from: c0, reason: collision with root package name */
    long f289400c0;

    /* renamed from: d, reason: collision with root package name */
    public BaseFormalView f289401d;

    /* renamed from: d0, reason: collision with root package name */
    StringBuilder f289402d0;

    /* renamed from: e, reason: collision with root package name */
    public BasePrepareView f289403e;

    /* renamed from: e0, reason: collision with root package name */
    StringBuilder f289404e0;

    /* renamed from: f, reason: collision with root package name */
    public View f289405f;

    /* renamed from: f0, reason: collision with root package name */
    String f289406f0;

    /* renamed from: g0, reason: collision with root package name */
    boolean f289407g0;

    /* renamed from: h, reason: collision with root package name */
    public HongBaoSmartRefreshLayout f289408h;

    /* renamed from: h0, reason: collision with root package name */
    ImageView f289409h0;

    /* renamed from: i, reason: collision with root package name */
    public long f289410i;

    /* renamed from: i0, reason: collision with root package name */
    private FrameLayout f289411i0;

    /* renamed from: j0, reason: collision with root package name */
    private BaseCountDownProgressView f289412j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f289413k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f289414l0;

    /* renamed from: m, reason: collision with root package name */
    public int f289415m;

    /* renamed from: m0, reason: collision with root package name */
    private int f289416m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f289417n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f289418o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f289419p0;

    /* renamed from: q0, reason: collision with root package name */
    private Interpolator f289420q0;

    /* renamed from: r0, reason: collision with root package name */
    private ValueAnimator f289421r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f289422s0;

    /* renamed from: t0, reason: collision with root package name */
    private Animator.AnimatorListener f289423t0;

    /* renamed from: u0, reason: collision with root package name */
    private ValueAnimator f289424u0;

    /* renamed from: v0, reason: collision with root package name */
    private Animator.AnimatorListener f289425v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f289426w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f289427x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f289428y0;

    /* renamed from: z0, reason: collision with root package name */
    public Runnable f289429z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f289433a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TitleAreaHeadLayout f289434b;

        a(View view, TitleAreaHeadLayout titleAreaHeadLayout) {
            this.f289433a = view;
            this.f289434b = titleAreaHeadLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ConversationHongBaoV2.this, view, titleAreaHeadLayout);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "doHideTitleAnim onAnimationCancel");
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f289433a.getLayoutParams();
            layoutParams.topMargin = -ConversationHongBaoV2.this.f289419p0;
            this.f289433a.setLayoutParams(layoutParams);
            this.f289434b.setAlpha(0.0f);
            this.f289434b.setVisibility(8, "spring_hb");
            this.f289433a.setEnabled(true);
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "doHideTitleAnim onAnimationEnd");
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f289433a.getLayoutParams();
            layoutParams.topMargin = -ConversationHongBaoV2.this.f289419p0;
            this.f289433a.setLayoutParams(layoutParams);
            this.f289434b.setAlpha(0.0f);
            this.f289434b.setVisibility(8, "spring_hb");
            this.f289433a.setEnabled(true);
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                this.f289433a.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f289436a;

        b(String str) {
            this.f289436a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConversationHongBaoV2.this, (Object) str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements com.tencent.widget.g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f289438a;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConversationHongBaoV2.this);
            } else {
                this.f289438a = 0;
            }
        }

        private boolean j(@NonNull MotionEvent motionEvent) {
            int[] iArr = {0, 0};
            ConversationHongBaoV2.this.f289412j0.getLocationOnScreen(iArr);
            int width = iArr[0] + ConversationHongBaoV2.this.f289412j0.getWidth();
            int height = iArr[1] + ConversationHongBaoV2.this.f289412j0.getHeight();
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (rawX < iArr[0] || rawX >= width || rawY < iArr[1] || rawY >= height) {
                return false;
            }
            return true;
        }

        private boolean k() {
            ConversationHongBaoV2 conversationHongBaoV2 = ConversationHongBaoV2.this;
            if (conversationHongBaoV2.f289415m == 4 && conversationHongBaoV2.f289412j0 != null && ConversationHongBaoV2.this.f289412j0.getVisibility() == 0 && ConversationHongBaoV2.this.f289412j0.getAlpha() > 0.99f) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.widget.g
        public void a(HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout, @NonNull MotionEvent motionEvent) {
            BaseFormalView baseFormalView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) hongBaoSmartRefreshLayout, (Object) motionEvent);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.iAsync("2025_UI_ConversationHofngBaoV2", 2, "[Async log]onTouchDown state:" + ConversationHongBaoV2.this.f289415m);
            }
            ConversationHongBaoV2 conversationHongBaoV2 = ConversationHongBaoV2.this;
            if (conversationHongBaoV2.f289415m == 4 && (baseFormalView = conversationHongBaoV2.f289401d) != null && baseFormalView != null) {
                baseFormalView.k(motionEvent);
            }
        }

        @Override // com.tencent.widget.g
        public void b(HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout, @Nullable MotionEvent motionEvent) {
            BaseFormalView baseFormalView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) hongBaoSmartRefreshLayout, (Object) motionEvent);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.iAsync("2025_UI_ConversationHofngBaoV2", 2, "[Async log]onTouchRelease, mState = " + ConversationHongBaoV2.this.f289415m);
            }
            if (!ConversationHongBaoV2.this.f289408h.isEnabled() && ConversationHongBaoV2.this.f289415m == 4) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 1, "onTouchRelease, disable touch event");
                return;
            }
            ConversationHongBaoV2 conversationHongBaoV2 = ConversationHongBaoV2.this;
            if (conversationHongBaoV2.f289415m == 4 && (baseFormalView = conversationHongBaoV2.f289401d) != null && baseFormalView != null) {
                baseFormalView.l(motionEvent);
            }
            int q06 = hongBaoSmartRefreshLayout.q0();
            ConversationHongBaoV2 conversationHongBaoV22 = ConversationHongBaoV2.this;
            if (q06 >= conversationHongBaoV22.f289408h.G1 / 2 && conversationHongBaoV22.f289415m == 2) {
                long currentTimeMillis = System.currentTimeMillis();
                ConversationHongBaoV2 conversationHongBaoV23 = ConversationHongBaoV2.this;
                if (currentTimeMillis - conversationHongBaoV23.f289400c0 > 500) {
                    conversationHongBaoV23.f289400c0 = System.currentTimeMillis();
                    ConversationHongBaoV2.this.b1();
                }
            }
            ConversationHongBaoV2 conversationHongBaoV24 = ConversationHongBaoV2.this;
            if (conversationHongBaoV24.f289415m != 4) {
                if (q06 < conversationHongBaoV24.f289408h.G1 / 2 && q06 > 0) {
                    conversationHongBaoV24.G.removeCallbacks(conversationHongBaoV24.f289429z0);
                    ConversationHongBaoV2.this.f289408h.setSpringbackOffset(0);
                    HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout2 = ConversationHongBaoV2.this.f289408h;
                    hongBaoSmartRefreshLayout2.D0(hongBaoSmartRefreshLayout2.M1);
                }
            } else if (q06 < conversationHongBaoV24.f289408h.G1 / 2 && q06 > 0) {
                conversationHongBaoV24.G.removeCallbacks(conversationHongBaoV24.f289429z0);
                ConversationHongBaoV2 conversationHongBaoV25 = ConversationHongBaoV2.this;
                conversationHongBaoV25.f289408h.setSpringbackOffset(conversationHongBaoV25.P);
                HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout3 = ConversationHongBaoV2.this.f289408h;
                hongBaoSmartRefreshLayout3.D0(hongBaoSmartRefreshLayout3.M1);
            }
            HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout4 = ConversationHongBaoV2.this.f289408h;
            if (q06 < hongBaoSmartRefreshLayout4.G1 / 2 && !hongBaoSmartRefreshLayout4.I1) {
                i(false);
            }
            ConversationHongBaoV2 conversationHongBaoV26 = ConversationHongBaoV2.this;
            conversationHongBaoV26.G.removeCallbacks(conversationHongBaoV26.f289429z0);
            ConversationHongBaoV2 conversationHongBaoV27 = ConversationHongBaoV2.this;
            conversationHongBaoV27.G.postDelayed(conversationHongBaoV27.f289429z0, 2000L);
        }

        @Override // com.tencent.widget.g
        public void c(HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, hongBaoSmartRefreshLayout, Boolean.valueOf(z16));
                return;
            }
            ConversationHongBaoV2 conversationHongBaoV2 = ConversationHongBaoV2.this;
            conversationHongBaoV2.G.removeCallbacks(conversationHongBaoV2.f289429z0);
            try {
                int q06 = hongBaoSmartRefreshLayout.q0();
                if (z16) {
                    int i3 = ConversationHongBaoV2.this.f289415m;
                    if ((i3 == 2 || i3 == 4) && q06 > ViewUtils.dpToPx(1.0f)) {
                        ConversationHongBaoV2.this.N();
                    }
                }
            } catch (Throwable th5) {
                QLog.e("2025_UI_ConversationHofngBaoV2", 1, "onTouchMoving", th5);
            }
        }

        @Override // com.tencent.widget.g
        public boolean d(@NonNull MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (k() && j(motionEvent)) {
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action == 1) {
                        ConversationHongBaoV2.this.f289412j0.c(motionEvent);
                    }
                } else {
                    ConversationHongBaoV2.this.f289412j0.b(motionEvent);
                }
                return true;
            }
            return false;
        }

        @Override // com.tencent.widget.g
        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (ConversationHongBaoV2.this.k0()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "tryGrab NoNetworkUI is showing");
                return;
            }
            ConversationHongBaoV2 conversationHongBaoV2 = ConversationHongBaoV2.this;
            if (conversationHongBaoV2.f289415m == 4) {
                if (conversationHongBaoV2.T == 1) {
                    ConversationHongBaoV2.this.g1();
                    HashMap hashMap = new HashMap();
                    hashMap.put("buss_id", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
                    hashMap.put("module_id", "swip");
                    hashMap.put("submodule_id", "first_swip");
                    hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "exp");
                    hashMap.put("ext5", com.tencent.mobileqq.springhb.prize.h.e());
                    if (ConversationHongBaoV2.this.Q.j() != null) {
                        hashMap.put("changci_id", ConversationHongBaoV2.this.Q.j().f289093id);
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportForGameCenter(hashMap);
                    }
                }
                ConversationHongBaoV2.this.T++;
                ConversationHongBaoV2.this.S++;
                long currentTimeMillis = System.currentTimeMillis();
                ConversationHongBaoV2 conversationHongBaoV22 = ConversationHongBaoV2.this;
                int i3 = conversationHongBaoV22.S;
                if (i3 == 1) {
                    BaseFormalView baseFormalView = conversationHongBaoV22.f289401d;
                    if (baseFormalView != null) {
                        baseFormalView.e(i3, conversationHongBaoV22.T, ConversationHongBaoV2.this.f289414l0);
                    }
                    ConversationHongBaoV2.this.f289398a0 = currentTimeMillis;
                } else {
                    long j3 = currentTimeMillis - conversationHongBaoV22.f289398a0;
                    conversationHongBaoV22.f289398a0 = currentTimeMillis;
                    if (j3 > 1000) {
                        conversationHongBaoV22.S = 1;
                    }
                    BaseFormalView baseFormalView2 = conversationHongBaoV22.f289401d;
                    if (baseFormalView2 != null) {
                        baseFormalView2.e(conversationHongBaoV22.S, conversationHongBaoV22.T, ConversationHongBaoV2.this.f289414l0);
                    }
                    ac.h().o(0);
                }
                ConversationHongBaoV2 conversationHongBaoV23 = ConversationHongBaoV2.this;
                if (conversationHongBaoV23.S > conversationHongBaoV23.U) {
                    ConversationHongBaoV2 conversationHongBaoV24 = ConversationHongBaoV2.this;
                    conversationHongBaoV24.U = conversationHongBaoV24.S;
                }
                if (ConversationHongBaoV2.this.K()) {
                    ConversationHongBaoV2 conversationHongBaoV25 = ConversationHongBaoV2.this;
                    if (conversationHongBaoV25.f289401d != null) {
                        conversationHongBaoV25.Q.o().c(ConversationHongBaoV2.this.f289401d.getContext(), ConversationHongBaoV2.this.S);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("2025_UI_ConversationHofngBaoV2", 2, "tryGrab not allowGrabHongbao");
                }
            }
        }

        @Override // com.tencent.widget.g
        public boolean f(@NonNull MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (k() && j(motionEvent)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.widget.g
        public void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.iAsync("2025_UI_ConversationHofngBaoV2", 2, "[Async log]tryCountdown mState = " + ConversationHongBaoV2.this.f289415m);
            }
            ConversationHongBaoV2 conversationHongBaoV2 = ConversationHongBaoV2.this;
            if (conversationHongBaoV2.f289415m == 3 && conversationHongBaoV2.i0()) {
                ConversationHongBaoV2.this.l1(-1L);
                ConversationHongBaoV2.this.H0();
                ConversationHongBaoV2.this.T++;
                ConversationHongBaoV2 conversationHongBaoV22 = ConversationHongBaoV2.this;
                int i3 = conversationHongBaoV22.S + 1;
                conversationHongBaoV22.S = i3;
                if (i3 == 1) {
                    BaseFormalView baseFormalView = conversationHongBaoV22.f289401d;
                    if (baseFormalView != null) {
                        baseFormalView.e(i3, conversationHongBaoV22.T, ConversationHongBaoV2.this.f289414l0);
                    }
                    ConversationHongBaoV2.this.f289398a0 = System.currentTimeMillis();
                }
                ConversationHongBaoV2 conversationHongBaoV23 = ConversationHongBaoV2.this;
                if (conversationHongBaoV23.S > conversationHongBaoV23.U) {
                    ConversationHongBaoV2 conversationHongBaoV24 = ConversationHongBaoV2.this;
                    conversationHongBaoV24.U = conversationHongBaoV24.S;
                }
            }
            if (ConversationHongBaoV2.this.M) {
                n1(false);
            }
        }

        @Override // com.tencent.widget.g
        public void h(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (this.f289438a != 0 && i16 == 0) {
                i(false);
            }
            this.f289438a = i16;
            ConversationHongBaoV2 conversationHongBaoV2 = ConversationHongBaoV2.this;
            if (!conversationHongBaoV2.L) {
                int i17 = conversationHongBaoV2.f289415m;
                if ((i17 == 2 || i17 == 3) && i16 >= 0) {
                    conversationHongBaoV2.L(conversationHongBaoV2.f289422s0 + i16);
                    return;
                }
                return;
            }
            int i18 = conversationHongBaoV2.f289415m;
            if (i18 != 3) {
                if (i18 == 4) {
                    if (conversationHongBaoV2.C) {
                        QLog.d("2025_UI_ConversationHofngBaoV2", 2, " onOverScroll STATE_SHUA_YI_SHUA_COUNTDOWN break, Changing NormalMode nScrollY:", Integer.valueOf(i16));
                    } else {
                        ConversationHongBaoV2 conversationHongBaoV22 = ConversationHongBaoV2.this;
                        if (i16 <= conversationHongBaoV22.P) {
                            conversationHongBaoV22.N();
                            ConversationHongBaoV2.this.f289412j0.setAlpha(1.0f);
                            ConversationHongBaoV2.this.f289412j0.setVisibility(0);
                            ConversationHongBaoV2.this.G0();
                            BaseFormalView baseFormalView = ConversationHongBaoV2.this.f289401d;
                            if (baseFormalView != null) {
                                baseFormalView.p();
                            }
                            FrameHelperActivity.hj(true);
                        } else {
                            FrameHelperActivity.hj(false);
                            ConversationHongBaoV2 conversationHongBaoV23 = ConversationHongBaoV2.this;
                            if (i16 <= conversationHongBaoV23.P * 2) {
                                conversationHongBaoV23.f289412j0.setAlpha(((int) ((((r3 + i16) * 1.0f) / r0) * 255.0f)) / 255.0f);
                            } else {
                                conversationHongBaoV23.f289412j0.setAlpha(0.0f);
                            }
                            BaseFormalView baseFormalView2 = ConversationHongBaoV2.this.f289401d;
                            if (baseFormalView2 != null) {
                                baseFormalView2.t();
                            }
                        }
                        ConversationHongBaoV2 conversationHongBaoV24 = ConversationHongBaoV2.this;
                        if (i16 > conversationHongBaoV24.f289422s0) {
                            conversationHongBaoV24.M(false);
                        } else if (i16 <= conversationHongBaoV24.P) {
                            conversationHongBaoV24.f289427x0 = true;
                        }
                    }
                }
            } else {
                BaseFormalView baseFormalView3 = conversationHongBaoV2.f289401d;
                if (baseFormalView3 != null) {
                    if (i16 <= 0) {
                        baseFormalView3.p();
                    } else {
                        baseFormalView3.t();
                    }
                }
            }
            if (i16 >= 0) {
                ConversationHongBaoV2 conversationHongBaoV25 = ConversationHongBaoV2.this;
                conversationHongBaoV25.L(conversationHongBaoV25.f289422s0 + i16);
            }
        }

        @Override // com.tencent.widget.g
        public void i(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showTitle direct = " + z16);
            }
            ConversationHongBaoV2.this.e1(z16);
        }

        @Override // com.tencent.widget.g
        public void n1(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "hideTitle direct = " + z16);
            }
            ConversationHongBaoV2.this.d0(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d implements com.tencent.widget.i {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConversationHongBaoV2.this);
            }
        }

        @Override // com.tencent.widget.i
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "onHongBaoPendantClick mState = ", Integer.valueOf(ConversationHongBaoV2.this.f289415m));
            }
            if (ConversationHongBaoV2.this.h0()) {
                ConversationHongBaoV2.this.c1(0);
                ConversationHongBaoV2.this.Q.p().m();
            } else {
                ConversationHongBaoV2.this.Q.p().k();
            }
        }

        @Override // com.tencent.widget.i
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            ConversationHongBaoV2.this.Q.p().n();
            ConversationHongBaoV2.this.Q.p().j();
            ConversationHongBaoV2.this.Q.p().g(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e extends CountDownTimer {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f289441a;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements Function1<Boolean, Unit> {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ i f289443d;

            a(i iVar) {
                this.f289443d = iVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) iVar);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(Boolean bool) {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                }
                boolean z17 = true;
                if (ConversationHongBaoV2.this.Q.j() == null) {
                    QLog.d("2025_UI_ConversationHofngBaoV2", 1, "\u6d3b\u52a8\u5df2\u7ecf\u7ed3\u675f");
                    return Unit.INSTANCE;
                }
                QLog.d("2025_UI_ConversationHofngBaoV2", 1, "CountDownTimer onFinish mResume=", Boolean.valueOf(ConversationHongBaoV2.this.L), " isShuayishuaResume=", bool, " mHasPlayedFullScreenAnimation=", Boolean.valueOf(ConversationHongBaoV2.this.E));
                ConversationHongBaoV2 conversationHongBaoV2 = ConversationHongBaoV2.this;
                if (conversationHongBaoV2.L && (conversationHongBaoV2.E || bool.booleanValue())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ac.h().v();
                ac.h().r();
                ConversationHongBaoV2.this.V0(0L);
                ConversationHongBaoV2.this.N0();
                ConversationHongBaoV2 conversationHongBaoV22 = ConversationHongBaoV2.this;
                if (conversationHongBaoV22.L && bool.booleanValue()) {
                    z17 = false;
                }
                conversationHongBaoV22.p0(z17);
                if (z16) {
                    this.f289443d.a();
                }
                ConversationHongBaoV2.this.J0();
                ConversationHongBaoV2.this.O();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j3, long j16, long j17) {
            super(j3, j16);
            this.f289441a = j17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ConversationHongBaoV2.this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            onTick(0L);
            ConversationHongBaoV2.this.Q.j().getId();
            a aVar = new a(new i());
            if (ConversationHongBaoV2.this.f289413k0) {
                aVar.invoke(Boolean.FALSE);
                return;
            }
            BaseFormalView baseFormalView = ConversationHongBaoV2.this.f289401d;
            if (baseFormalView != null) {
                baseFormalView.q(aVar);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ConversationHongBaoV2.this.W0(j3);
            if (currentTimeMillis - ConversationHongBaoV2.this.D0 > 1000) {
                ConversationHongBaoV2.this.D0 = currentTimeMillis;
                ConversationHongBaoV2.this.V0(j3);
            }
            if (ConversationHongBaoV2.this.f289412j0.getVisibility() == 0) {
                ConversationHongBaoV2.this.Y(j3);
                ConversationHongBaoV2.this.f289412j0.d(j3, this.f289441a, ConversationHongBaoV2.this.f289402d0);
                if (j3 > 1000 && ConversationHongBaoV2.this.f289408h.q0() == 0 && !ConversationHongBaoV2.this.f289408h.x0() && currentTimeMillis - ConversationHongBaoV2.this.E0 > ConversationHongBaoV2.this.f289408h.r0()) {
                    QLog.d("2025_UI_ConversationHofngBaoV2", 2, "onTick re-springBackTo mCountDownRedBannerHeight:" + ConversationHongBaoV2.this.P);
                    ConversationHongBaoV2.this.E0 = currentTimeMillis;
                    ConversationHongBaoV2 conversationHongBaoV2 = ConversationHongBaoV2.this;
                    conversationHongBaoV2.f289408h.setSpringbackOffset(conversationHongBaoV2.P);
                    ConversationHongBaoV2 conversationHongBaoV22 = ConversationHongBaoV2.this;
                    conversationHongBaoV22.f289408h.D0(conversationHongBaoV22.P);
                }
            }
            BaseFormalView baseFormalView = ConversationHongBaoV2.this.f289401d;
            if (baseFormalView != null && baseFormalView.getVisibility() == 0) {
                ConversationHongBaoV2.this.Y(j3);
                ConversationHongBaoV2 conversationHongBaoV23 = ConversationHongBaoV2.this;
                conversationHongBaoV23.f289401d.o(j3, this.f289441a, conversationHongBaoV23.f289404e0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameLayout.LayoutParams f289445a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f289446b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TitleAreaHeadLayout f289447c;

        f(FrameLayout.LayoutParams layoutParams, View view, TitleAreaHeadLayout titleAreaHeadLayout) {
            this.f289445a = layoutParams;
            this.f289446b = view;
            this.f289447c = titleAreaHeadLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ConversationHongBaoV2.this, layoutParams, view, titleAreaHeadLayout);
            }
        }

        @Override // com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            if (valueAnimator.getAnimatedValue() == null) {
                return;
            }
            float intValue = (((Integer) valueAnimator.getAnimatedValue()).intValue() * 1.0f) / 1000.0f;
            FrameLayout.LayoutParams layoutParams = this.f289445a;
            layoutParams.topMargin = (int) ((-ConversationHongBaoV2.this.f289419p0) * (1.0f - intValue));
            this.f289446b.setLayoutParams(layoutParams);
            this.f289447c.setAlpha(intValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TitleAreaHeadLayout f289449a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f289450b;

        g(TitleAreaHeadLayout titleAreaHeadLayout, View view) {
            this.f289449a = titleAreaHeadLayout;
            this.f289450b = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ConversationHongBaoV2.this, titleAreaHeadLayout, view);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "doShowTitleAnim onAnimationCancel");
            }
            ConversationHongBaoV2.this.T0();
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "doShowTitleAnim onAnimationEnd");
            }
            ConversationHongBaoV2.this.T0();
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                this.f289449a.setVisibility(0, "spring_hb");
                this.f289450b.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameLayout.LayoutParams f289452a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f289453b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TitleAreaHeadLayout f289454c;

        h(FrameLayout.LayoutParams layoutParams, View view, TitleAreaHeadLayout titleAreaHeadLayout) {
            this.f289452a = layoutParams;
            this.f289453b = view;
            this.f289454c = titleAreaHeadLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ConversationHongBaoV2.this, layoutParams, view, titleAreaHeadLayout);
            }
        }

        @Override // com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            if (valueAnimator.getAnimatedValue() == null) {
                return;
            }
            float intValue = (((Integer) valueAnimator.getAnimatedValue()).intValue() * 1.0f) / 1000.0f;
            int i3 = (int) ((-ConversationHongBaoV2.this.f289419p0) * intValue);
            float f16 = 1.0f - intValue;
            FrameLayout.LayoutParams layoutParams = this.f289452a;
            layoutParams.topMargin = i3;
            this.f289453b.setLayoutParams(layoutParams);
            this.f289454c.setAlpha(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class i {
        static IPatchRedirector $redirector_;

        public i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ConversationHongBaoV2.this);
            }
        }

        public void a() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "ShowSharePageTask invoke");
            }
            EntryConfigBean J = ConversationHongBaoV2.this.Q.n().J();
            if (J != null) {
                str = J.commonData.springHBMainUrl;
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                SpringToMainHelper.k(ConversationHongBaoV2.this.Z(), str, "4");
            }
        }
    }

    public ConversationHongBaoV2(com.tencent.mobileqq.springhb.entry.worker.d dVar, Conversation conversation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar, (Object) conversation);
            return;
        }
        this.f289410i = 0L;
        this.f289415m = -1;
        this.C = false;
        this.D = true;
        this.E = false;
        this.F = -1L;
        this.G = new Handler(Looper.getMainLooper(), this);
        this.H = false;
        this.I = 0;
        this.J = 0L;
        this.K = true;
        this.M = true;
        this.N = 0;
        this.P = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = false;
        this.X = null;
        this.Y = -1L;
        this.f289399b0 = null;
        this.f289400c0 = 0L;
        this.f289402d0 = new StringBuilder(12);
        this.f289404e0 = new StringBuilder(8);
        this.f289406f0 = "";
        this.f289407g0 = true;
        this.f289413k0 = false;
        this.f289414l0 = null;
        this.f289416m0 = 0;
        this.f289417n0 = false;
        this.f289418o0 = 0;
        this.f289419p0 = -1;
        this.f289420q0 = new AccelerateDecelerateInterpolator();
        this.f289421r0 = null;
        this.f289422s0 = 0;
        this.f289423t0 = null;
        this.f289424u0 = null;
        this.f289425v0 = null;
        this.f289426w0 = false;
        this.f289427x0 = true;
        this.f289428y0 = false;
        this.f289429z0 = new Runnable() { // from class: com.tencent.mobileqq.springhb.module.ConversationHongBaoV2.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ConversationHongBaoV2.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                FrameHelperActivity.hj(true);
                if (ConversationHongBaoV2.this.f289408h.q0() == 0) {
                    return;
                }
                ConversationHongBaoV2 conversationHongBaoV2 = ConversationHongBaoV2.this;
                if (conversationHongBaoV2.f289415m == 4) {
                    conversationHongBaoV2.f289408h.setSpringbackOffset(conversationHongBaoV2.P);
                    float abs = Math.abs(ConversationHongBaoV2.this.f289408h.q0() + ConversationHongBaoV2.this.P);
                    ConversationHongBaoV2 conversationHongBaoV22 = ConversationHongBaoV2.this;
                    int i3 = conversationHongBaoV22.P;
                    if (abs > (i3 * 1.0f) / 13.0f) {
                        conversationHongBaoV22.f289408h.D0(i3);
                    }
                } else {
                    HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout = conversationHongBaoV2.f289408h;
                    if (!hongBaoSmartRefreshLayout.I1) {
                        hongBaoSmartRefreshLayout.setSpringbackOffset(0);
                        if (ConversationHongBaoV2.this.f289408h.q0() != 0) {
                            ConversationHongBaoV2 conversationHongBaoV23 = ConversationHongBaoV2.this;
                            if (conversationHongBaoV23.f289415m != -1 || !conversationHongBaoV23.Q.l().f()) {
                                ConversationHongBaoV2.this.f289408h.D0(0);
                            }
                        }
                    }
                }
                ConversationHongBaoV2 conversationHongBaoV24 = ConversationHongBaoV2.this;
                if (!conversationHongBaoV24.f289408h.I1) {
                    conversationHongBaoV24.e1(false);
                }
                if (QLog.isColorLevel() && ConversationHongBaoV2.this.f289412j0 != null) {
                    QLog.d("2025_UI_ConversationHofngBaoV2", 2, "mTouchReleaseRunable mProgressViewRed alpha = " + ConversationHongBaoV2.this.f289412j0.a() + ",visibility = " + ConversationHongBaoV2.this.f289412j0.getVisibility());
                }
            }
        };
        this.A0 = new Runnable() { // from class: com.tencent.mobileqq.springhb.module.ConversationHongBaoV2.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ConversationHongBaoV2.this);
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
                    QLog.d("2025_UI_ConversationHofngBaoV2", 2, "mHongbaoFullScreenRunnable do run");
                }
                ConversationHongBaoV2.this.E = true;
                ConversationHongBaoV2 conversationHongBaoV2 = ConversationHongBaoV2.this;
                conversationHongBaoV2.R0(conversationHongBaoV2.f289408h.getContext());
                ConversationHongBaoV2 conversationHongBaoV22 = ConversationHongBaoV2.this;
                conversationHongBaoV22.Q0((Activity) conversationHongBaoV22.f289408h.getContext());
                ConversationHongBaoV2.this.f289408h.setEnabled(false);
                ConversationHongBaoV2.this.f289408h.cancelPendingInputEvents();
                ConversationHongBaoV2.this.G.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.springhb.module.ConversationHongBaoV2.2.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else {
                            ConversationHongBaoV2.this.f289408h.setEnabled(true);
                        }
                    }
                }, 5000L);
                ConversationHongBaoV2.this.f289408h.setSpringbackOffset(3000);
                if (ConversationHongBaoV2.this.f289408h.q0() != 0) {
                    ConversationHongBaoV2.this.f289408h.D0(3000);
                }
            }
        };
        this.B0 = new c();
        this.C0 = new d();
        this.Q = dVar;
        this.R = conversation;
    }

    private void E0() {
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "recoverListViewContainerBg messageListContainerBackground = ", this.F0, " messageListBackground:", this.G0);
        }
        if (this.F0 != null) {
            this.R.getAnimContainer().setBackgroundDrawable(this.F0);
        }
        if (this.G0 != null) {
            this.R.getListBackgroundView().setBackgroundDrawable(this.G0);
        }
    }

    private void F0() {
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "recoverListViewContainerLayoutParams");
        }
        this.f289426w0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        BaseCountDownProgressView baseCountDownProgressView = this.f289412j0;
        if (baseCountDownProgressView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) baseCountDownProgressView.getLayoutParams();
        int i3 = layoutParams.topMargin;
        View animTitle = this.R.getAnimTitle();
        int height = animTitle.getHeight();
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "refreshRedProgressBarTopMargin,statusTitle.w = ", Integer.valueOf(animTitle.getWidth()), ",statusTitle.h = ", Integer.valueOf(animTitle.getHeight()), ",mProgressViewRed cur topMargin = ", Integer.valueOf(i3));
        }
        if (height != i3) {
            layoutParams.topMargin = height;
            this.f289412j0.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K() {
        BaseActivityData j3 = this.Q.j();
        if (j3 == null || this.Q.n().O(j3.f289093id).leftCountDownDuration <= 3000) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
        hashMap.put("module_id", "swip");
        hashMap.put("submodule_id", "exit_button");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "clk");
        hashMap.put("ext5", com.tencent.mobileqq.springhb.prize.h.e());
        if (this.Q.j() != null) {
            hashMap.put("changci_id", this.Q.j().f289093id);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportForGameCenter(hashMap);
        }
    }

    private void L0() {
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
        hashMap.put("module_id", "swip");
        hashMap.put("submodule_id", "exit_button");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "exp");
        hashMap.put("ext5", com.tencent.mobileqq.springhb.prize.h.e());
        if (this.Q.j() != null) {
            hashMap.put("changci_id", this.Q.j().f289093id);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportForGameCenter(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (this.R.getAnimContainer() != null && this.R.getAnimContainer().getBackground() != null) {
            this.F0 = this.R.getAnimContainer().getBackground();
            this.R.getAnimContainer().setBackgroundDrawable(null);
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "cleanListViewContainerBg messageListContainerBackground = ", this.F0);
            }
        }
        if (this.R.getListBackgroundView() != null && this.R.getListBackgroundView().getBackground() != null) {
            this.G0 = this.R.getListBackgroundView().getBackground();
            this.R.getListBackgroundView().setBackgroundDrawable(null);
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "cleanListViewContainerBg messageListBackground = ", this.G0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        BaseActivityData j3 = this.Q.j();
        if (j3 == null) {
            return;
        }
        com.tencent.mobileqq.springhb.servlet.c.d(j3.promotionId, this.T, new Function2() { // from class: com.tencent.mobileqq.springhb.module.f
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit o06;
                o06 = ConversationHongBaoV2.o0((Integer) obj, (Bundle) obj2);
                return o06;
            }
        });
        BaseFormalView baseFormalView = this.f289401d;
        if (baseFormalView == null) {
            return;
        }
        baseFormalView.u();
        if (this.f289401d.f() > 0) {
            f1();
            HashMap hashMap = new HashMap();
            hashMap.put("buss_id", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
            hashMap.put("module_id", "swip");
            hashMap.put("submodule_id", "timelong");
            hashMap.put(WadlReportBuilder.TableElem.OPER_ID, QCircleDaTongConstant.ElementParamValue.STAY);
            hashMap.put("oper_res", String.valueOf(this.T));
            hashMap.put("ext2", String.valueOf(this.f289401d.f()));
            hashMap.put("ext5", com.tencent.mobileqq.springhb.prize.h.e());
            if (this.Q.j() != null) {
                hashMap.put("changci_id", this.Q.j().f289093id);
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportForGameCenter(hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        QLog.d("2025_UI_ConversationHofngBaoV2", 1, "clearShareData");
        this.T = 0;
        this.V = 0;
        this.X = null;
    }

    private void P() {
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "clearTitleAnimation");
        }
        ValueAnimator valueAnimator = this.f289421r0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f289421r0.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.f289424u0;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.f289424u0.removeAllListeners();
        }
        this.R.getAnimTitle().setEnabled(true);
    }

    private BaseCountDownProgressView Q() {
        return new CountDownProgressView(Z());
    }

    private BaseFormalView R() {
        return new FormalView(Z(), this);
    }

    private BasePrepareView S() {
        return new PrepareView(Z());
    }

    @TargetApi(11)
    private void T(View view, View view2, TitleAreaHeadLayout titleAreaHeadLayout) {
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "doHideTitleAnim mTitleBarOffset = " + this.f289419p0);
        }
        if (!this.f289426w0) {
            f0(view2, view);
        }
        if (this.f289419p0 <= 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (this.f289424u0 == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1000);
            this.f289424u0 = ofInt;
            ofInt.setDuration(300L);
            this.f289424u0.setInterpolator(this.f289420q0);
            this.f289424u0.addUpdateListener(new h(layoutParams, view, titleAreaHeadLayout));
            this.f289425v0 = new a(view, titleAreaHeadLayout);
        }
        this.Q.h().r(0);
        this.f289424u0.removeAllListeners();
        this.f289424u0.cancel();
        this.f289424u0.addListener(this.f289425v0);
        this.f289424u0.start();
    }

    private void U() {
        this.E = false;
        P();
        e1(true);
        E0();
        n1();
        if (ThemeUtil.isNowThemeIsSuperTheme() && !this.Q.e()) {
            this.R.refreshStatusBarUIByTheme();
        }
        if (this.f289415m == -1) {
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "normalMode return for STATE_EMPTY");
                return;
            }
            return;
        }
        if (!j0()) {
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "normalMode return for hongbao not shown");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "doNormalMode");
        }
        this.f289408h.setSpringbackOffset(0);
        this.f289408h.D0(0);
        FrameHelperActivity.hj(true);
        this.f289408h.z0();
        this.R.setThemeDiyBgConversation();
        W();
        this.Q.h().m();
        this.f289403e.e();
        this.f289411i0.removeView(this.f289403e);
        this.f289403e = null;
        this.f289411i0.removeView(this.f289401d);
        BaseFormalView baseFormalView = this.f289401d;
        if (baseFormalView != null) {
            baseFormalView.p();
            this.f289401d.r(c0());
            this.f289401d.i();
            this.f289401d = null;
        }
        this.f289411i0.removeView(this.f289412j0);
        this.f289411i0.removeView(this.f289405f);
        this.G.removeCallbacks(this.f289429z0);
        F0();
        this.F = -1L;
        this.f289415m = -1;
        this.D = true;
        this.f289428y0 = false;
        ac.h().r();
        M(true);
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "normalMode,mState updated to STATE_EMPTY, mState = ", Integer.valueOf(this.f289415m));
        }
    }

    @TargetApi(11)
    private void V(View view, View view2, TitleAreaHeadLayout titleAreaHeadLayout) {
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "doShowTitleAnim mTitleBarOffset = ", Integer.valueOf(this.f289419p0));
        }
        if (!this.f289426w0) {
            f0(view2, view);
        }
        if (this.f289419p0 <= 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (this.f289421r0 == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1000);
            this.f289421r0 = ofInt;
            ofInt.setDuration(300L);
            this.f289421r0.setInterpolator(this.f289420q0);
            this.f289421r0.addUpdateListener(new f(layoutParams, view, titleAreaHeadLayout));
            this.f289423t0 = new g(titleAreaHeadLayout, view);
        }
        this.f289421r0.removeAllListeners();
        this.f289421r0.cancel();
        this.f289421r0.addListener(this.f289423t0);
        this.f289421r0.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "saveActivityLeftCountDownDuration duration = ", Long.valueOf(j3));
        }
        BaseActivityData j16 = this.Q.j();
        if (j16 != null) {
            UserData.UserDataItem O = this.Q.n().O(j16.f289093id);
            O.leftCountDownDuration = j3;
            O.totalGrabCountForShare = this.T;
            O.totalHitCountForShare = this.V;
            this.Q.n().g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(long j3) {
        BaseActivityData j16 = this.Q.j();
        if (j16 != null) {
            UserData.UserDataItem O = this.Q.n().O(j16.f289093id);
            O.leftCountDownDuration = j3;
            O.totalGrabCountForShare = this.T;
            O.totalHitCountForShare = this.V;
        }
    }

    private void X0(OnGrabActivityData onGrabActivityData) {
        Bitmap h16 = s.b(onGrabActivityData.previewEntryData.logoImgUrl).h(null, -1, ViewUtils.dpToPx(127.0f), ViewUtils.dpToPx(27.0f));
        this.f289403e.setLogo(h16);
        if (h16 == null) {
            this.Q.n().t(new b(onGrabActivityData.previewEntryData.logoImgUrl));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        PendantData pendantData;
        BaseActivityData j3 = this.Q.j();
        if (j3 != null && (pendantData = j3.pendantData) != null) {
            this.Q.p().p(2, pendantData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity Z() {
        return this.Q.i().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1() {
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showPrepareViewAnimation mState = ", Integer.valueOf(this.f289415m));
        }
        BasePrepareView basePrepareView = this.f289403e;
        if (basePrepareView != null && this.f289415m == 2) {
            basePrepareView.b();
            if (!this.f289417n0) {
                BaseActivityData j3 = this.Q.j();
                if (j3 instanceof OnGrabActivityData) {
                    this.f289403e.setBackground(s.b(((OnGrabActivityData) j3).previewEntryData.bgImgUrl).h(null, -1, ViewUtils.dpToPx(250.0f), ViewUtils.dpToPx(541.0f)));
                }
                this.f289417n0 = true;
            }
            this.G.removeMessages(1006);
            this.G.sendEmptyMessageDelayed(1006, 500L);
        }
    }

    private ViewGroup c0() {
        return this.Q.i().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showRealPreGuide", " mHongBaoListView:", this.f289408h, " guideType:", Integer.valueOf(i3));
        }
        if (this.f289408h == null) {
            return;
        }
        N();
        int i16 = this.f289408h.G1;
        int i17 = this.f289415m;
        if (i17 == 3) {
            this.f289408h.C0(i16 - BaseAIOUtils.f(100.0f, Z().getResources()), i3);
        } else if (i17 == 2 || i17 == 4) {
            b1();
            this.f289408h.C0(i16, i3);
        }
    }

    private void f0(View view, View view2) {
        g0(view, view2, 0);
    }

    private void f1() {
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", "mqq");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.PG_ID, "pg_msg_list");
        hashMap.put("module_id", "md_swipe_redpacket");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "md_exp_end");
        hashMap.put("ext1", String.valueOf(this.f289401d.f()));
        hashMap.put("ext2", String.valueOf(this.T));
        if (this.Q.j() != null) {
            hashMap.put("changci_id", this.Q.j().f289093id);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportForSpringHb(hashMap);
        }
    }

    private void g0(View view, View view2, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "initTitleAnim statusTitleHeight:", Integer.valueOf(i3));
        }
        if (i3 > 0) {
            this.f289419p0 = i3;
        } else {
            int i16 = this.f289422s0;
            if (i16 > 0) {
                this.f289419p0 = i16;
            } else {
                this.f289419p0 = view2.getHeight();
            }
        }
        QLog.d("2025_UI_ConversationHofngBaoV2", 1, "initTitleAnim start mTitleBarOffset=", Integer.valueOf(this.f289419p0));
        view2.post(new Runnable() { // from class: com.tencent.mobileqq.springhb.module.e
            @Override // java.lang.Runnable
            public final void run() {
                ConversationHongBaoV2.this.m0();
            }
        });
        this.f289426w0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1() {
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", "mqq");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.PG_ID, "pg_msg_list");
        hashMap.put("module_id", "md_swipe_redpacket_first");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "md_exp");
        if (this.Q.j() != null) {
            hashMap.put("changci_id", this.Q.j().f289093id);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportForSpringHb(hashMap);
        }
    }

    private void h1() {
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", "mqq");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.PG_ID, "pg_msg_list");
        hashMap.put("module_id", "md_swipe_peek_hour");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "md_exp");
        if (this.Q.j() != null) {
            hashMap.put("changci_id", this.Q.j().f289093id);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportForSpringHb(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", "mqq");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.PG_ID, "pg_msg_list");
        hashMap.put("module_id", "md_top_banner");
        hashMap.put("item_id", "em_top_baner_act_progress_close");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "em_clk");
        if (this.Q.j() != null) {
            hashMap.put("changci_id", this.Q.j().f289093id);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportForSpringHb(hashMap);
        }
    }

    private void j1() {
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", "mqq");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.PG_ID, "pg_msg_list");
        hashMap.put("module_id", "md_top_banner");
        hashMap.put("item_id", "em_top_baner_act_progress_bar");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "em_imp");
        if (this.Q.j() != null) {
            hashMap.put("changci_id", this.Q.j().f289093id);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportForSpringHb(hashMap);
        }
    }

    private void k1() {
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", "mqq");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.PG_ID, "pg_msg_list");
        hashMap.put("module_id", "md_swipe_redpacket");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "md_exp");
        if (this.Q.j() != null) {
            hashMap.put("changci_id", this.Q.j().f289093id);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportForSpringHb(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit l0(SpringRes springRes, SpringRes springRes2, Boolean bool) {
        if (bool.booleanValue()) {
            this.f289409h0.setImageDrawable(springRes.i(com.tencent.mobileqq.urldrawable.b.f306350a, new Bundle()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0() {
        QLog.d("2025_UI_ConversationHofngBaoV2", 1, "initTitleAnim sendEventToChat mTitleBarOffset=", Integer.valueOf(this.f289419p0));
        ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(new a.r(this.f289419p0));
        ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(a.o.f355022a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0() {
        if (this.L) {
            ApngImage.playByTag(26);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit o0(Integer num, Bundle bundle) {
        QLog.d("2025_UI_ConversationHofngBaoV2", 2, "reportSysFinish gamehb bundle = " + bundle);
        return Unit.INSTANCE;
    }

    private void q0() {
        if (this.f289415m != 3) {
            this.f289415m = 3;
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showTask,mState updated to STATE_SHUA_YI_SHUA_READY, ", Integer.valueOf(this.f289415m));
            }
            BaseFormalView baseFormalView = this.f289401d;
            if (baseFormalView != null) {
                baseFormalView.s();
            }
            this.f289412j0.setVisibility(8);
            n1();
            m1();
            W();
        }
    }

    private void r0() {
        if (this.f289415m != 2) {
            this.f289415m = 2;
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showPrepare,mState updated to STATE_YURE, ", Integer.valueOf(this.f289415m));
            }
            e0();
            this.f289408h.setComboListener(this.B0);
            this.f289403e.setVisibility(0);
            BaseFormalView baseFormalView = this.f289401d;
            if (baseFormalView != null) {
                baseFormalView.setVisibility(8);
            }
            this.f289412j0.setVisibility(8);
            n1();
            W();
            M0();
        }
    }

    public void A0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        this.L = false;
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "onPause() isShowBrushResultPage = ", Boolean.valueOf(this.W), ",mState = ", Integer.valueOf(this.f289415m));
        }
        if (!j0()) {
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "onPause return for not showing hb");
                return;
            }
            return;
        }
        BaseFormalView baseFormalView = this.f289401d;
        if (baseFormalView != null) {
            baseFormalView.m();
        }
        BasePrepareView basePrepareView = this.f289403e;
        if (basePrepareView != null) {
            basePrepareView.a();
        }
        if (this.W && this.f289399b0 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "onPause mTimerCountDown.cancel");
            }
            this.f289399b0.cancel();
        }
        this.G.removeCallbacks(this.f289429z0);
        this.G.post(this.f289429z0);
        o1();
        UserData.UserDataItem O = this.Q.n().O(this.Q.j().f289093id);
        O.totalGrabCountForShare = this.T;
        O.totalHitCountForShare = this.V;
        this.Q.n().h0();
        if (this.f289415m == 4) {
            P0();
            W();
            this.f289412j0.setAlpha(1.0f);
            this.f289412j0.setVisibility(0);
            this.f289412j0.invalidate();
            L(this.f289422s0);
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "onPause mProgressViewRed alpha = ", Float.valueOf(this.f289412j0.a()), ",visibility = ", Integer.valueOf(this.f289412j0.getVisibility()));
        }
    }

    public void B0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        if (!j0()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "onPostThemeChanged mState = ", Integer.valueOf(this.f289415m));
        }
        if (this.f289415m == 3) {
            n1();
            m1();
        }
    }

    public void C0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "onResume() mState = ", Integer.valueOf(this.f289415m), ",delayedShowSharePageTask = ", this.Z, ",mIsHongBaoGiftViewShowing = ", Boolean.valueOf(this.f289428y0));
        }
        if (j0() && this.f289428y0) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 1, "onResume() return, because of HongBaoGiftView is showing");
            HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout = this.f289408h;
            if (hongBaoSmartRefreshLayout != null && hongBaoSmartRefreshLayout.q0() == 0) {
                this.f289408h.setSpringbackOffset(this.P);
                this.f289408h.D0(this.P);
                return;
            }
            return;
        }
        i iVar = this.Z;
        if (iVar != null) {
            iVar.a();
            this.Z = null;
        }
        if (this.W) {
            this.W = false;
            this.Q.o().h();
        }
        Handler handler = this.G;
        if (handler != null && !handler.hasMessages(1002)) {
            this.L = true;
            if (this.Q.p().i() || this.Q.q().x()) {
                this.G.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.springhb.module.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConversationHongBaoV2.this.n0();
                    }
                }, 1000L);
            }
            if (!j0()) {
                if (QLog.isColorLevel()) {
                    QLog.d("2025_UI_ConversationHofngBaoV2", 2, "onResume() return for not showing hongbao");
                    return;
                }
                return;
            }
            if (this.f289415m == 4) {
                l1(b0());
                HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout2 = this.f289408h;
                if (hongBaoSmartRefreshLayout2 != null && hongBaoSmartRefreshLayout2.q0() == 0) {
                    this.f289408h.setSpringbackOffset(this.P);
                    this.f289408h.D0(this.P);
                }
            }
            if (!this.Q.n().V() && this.f289408h != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("2025_UI_ConversationHofngBaoV2", 2, "onResume hideHongbaoPendant");
                }
                this.Q.p().g(0);
            }
            BaseFormalView baseFormalView = this.f289401d;
            if (baseFormalView != null) {
                baseFormalView.n();
            }
            if (this.H) {
                if (this.f289407g0) {
                    Z0(0);
                }
                this.H = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "onResume refreshScheduleTask");
            }
            this.Q.n().k0();
            o1();
        }
    }

    public void D0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "postOnResume");
        }
        this.G.sendEmptyMessageDelayed(1002, 800L);
    }

    public void H0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "reportBrushBeginShua");
        }
        HashMap hashMap = new HashMap();
        BaseActivityData j3 = this.Q.j();
        if (j3 != null) {
            String str = j3.f289093id;
            hashMap.put("active_id", str);
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "reportBrushBeginShua, id = ", str);
            }
        }
    }

    public void I0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "reportBrushMainPageExpose");
        }
        this.Y = System.currentTimeMillis();
        UserData.UserDataItem O = this.Q.n().O(this.Q.j().f289093id);
        O.isAbnormalQuit = true;
        O.brushStartTsForReport = this.Y;
        this.Q.n().g0();
        HashMap hashMap = new HashMap();
        BaseActivityData j3 = this.Q.j();
        if (j3 != null) {
            String str = j3.f289093id;
            hashMap.put("active_id", str);
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "reportBrushMainPageExpose isAbnormalQuit true, id = ", str);
            }
        }
    }

    public void J0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        String valueOf = String.valueOf((System.currentTimeMillis() - this.Y) / 1000);
        this.Y = -1L;
        this.Q.n().O(this.Q.j().f289093id).isAbnormalQuit = false;
        this.Q.n().g0();
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "reportBrushMainPageQuit duration = ", valueOf, ",totalGrabCountForShare = ", Integer.valueOf(this.T));
        }
    }

    protected void L(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        View view = this.f289405f;
        if (view == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i3;
        this.f289405f.setLayoutParams(layoutParams);
    }

    protected void M(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        if (z16) {
            this.f289427x0 = true;
            this.Q.i().c().changeSpecialCareVisible(true);
        } else if (this.f289427x0) {
            this.f289427x0 = false;
            this.Q.i().c().changeSpecialCareVisible(false);
        }
    }

    public void M0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "reportStaggerdPeakExpose");
        }
    }

    public void O0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
            return;
        }
        this.G.removeCallbacks(this.A0);
        this.G.post(this.A0);
        this.G.removeCallbacks(this.f289429z0);
        this.G.postDelayed(this.f289429z0, 5000L);
    }

    public void P0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
        } else {
            this.G.removeCallbacks(this.f289429z0);
            this.G.post(this.f289429z0);
        }
    }

    public void Q0(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) activity);
            return;
        }
        if (this.G == null) {
            return;
        }
        View findViewById = activity.findViewById(af.f());
        View findViewById2 = activity.findViewById(R.id.kmr);
        if (findViewById != null && findViewById2 != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById, "translationY", findViewById.getHeight());
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(findViewById2, "translationY", findViewById2.getHeight());
            ofFloat2.setInterpolator(new AccelerateInterpolator());
            ofFloat.start();
            ofFloat2.start();
            this.G.postDelayed(new Runnable(findViewById, findViewById2) { // from class: com.tencent.mobileqq.springhb.module.ConversationHongBaoV2.12
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ View f289430d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ View f289431e;

                {
                    this.f289430d = findViewById;
                    this.f289431e = findViewById2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ConversationHongBaoV2.this, findViewById, findViewById2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f289430d.setTranslationY(0.0f);
                        this.f289431e.setTranslationY(0.0f);
                    }
                }
            }, 5000L);
        }
    }

    public void R0(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) context);
        } else {
            try {
                context.startService(new Intent(context, (Class<?>) PreloadWebService.class));
            } catch (Throwable unused) {
            }
            SpringToMainHelper.o(this.R.getApp());
        }
    }

    public void S0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        ImageView imageView = this.f289409h0;
        if (imageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.topMargin = this.f289422s0 + ViewUtils.dpToPx(20.0f);
            this.f289409h0.setLayoutParams(layoutParams);
        }
    }

    @TargetApi(11)
    public void T0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "resetTitle");
        }
        View animTitle = this.R.getAnimTitle();
        TitleAreaHeadLayout animHead = this.R.getAnimHead();
        int i3 = 0;
        if (animTitle != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) animTitle.getLayoutParams();
            layoutParams.topMargin = 0;
            animTitle.setLayoutParams(layoutParams);
            animTitle.setEnabled(true);
        }
        if (animHead != null) {
            animHead.setAlpha(1.0f);
            if (animHead.j()) {
                i3 = 8;
            }
            if (animHead.getVisibility() != i3) {
                animHead.setVisibility(i3, "spring_hb");
            }
        }
        this.Q.h().r(this.f289422s0);
    }

    public void U0(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
            return;
        }
        if (i3 > 0) {
            this.f289422s0 = i3;
        } else {
            Conversation conversation = this.R;
            int i17 = conversation.statusTitleHeightInNormalState;
            if (i17 > 0) {
                this.f289422s0 = i17;
            } else {
                this.f289422s0 = conversation.getAnimTitle().getHeight();
            }
        }
        this.Q.h().r(this.f289422s0);
        S0();
        g0(this.R.getAnimContainer(), this.R.getAnimTitle(), i3);
        G0();
        HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout = this.f289408h;
        int i18 = 0;
        if (hongBaoSmartRefreshLayout != null) {
            i16 = hongBaoSmartRefreshLayout.q0();
        } else {
            i16 = 0;
        }
        int i19 = this.f289422s0;
        if (i16 > 0) {
            i18 = i16;
        }
        L(i19 + i18);
    }

    public void W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "endCountDown");
        }
        if (this.f289399b0 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "endCountDown mTimerCountDown.cancel");
            }
            this.f289399b0.cancel();
            this.f289399b0 = null;
        }
        FrameHelperActivity.hj(true);
        this.S = 0;
        this.f289410i = 0L;
        this.f289398a0 = 0L;
        ac.h().v();
        HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout = this.f289408h;
        if (hongBaoSmartRefreshLayout.M1 == this.P) {
            hongBaoSmartRefreshLayout.setSpringbackOffset(0);
            this.f289408h.D0(0);
        }
    }

    public void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "ensureInit mState = ", Integer.valueOf(this.f289415m));
        }
        if (this.f289415m == -1) {
            this.f289411i0 = (FrameLayout) c0().findViewById(R.id.a46);
            HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout = (HongBaoSmartRefreshLayout) c0().findViewById(R.id.f71863pa);
            this.f289408h = hongBaoSmartRefreshLayout;
            hongBaoSmartRefreshLayout.f384578p1 = this;
            hongBaoSmartRefreshLayout.F1 = (int) Z().getResources().getDimension(R.dimen.aew);
            View animTitle = this.R.getAnimTitle();
            if (animTitle != null && animTitle.getHeight() != 0) {
                int height = animTitle.getHeight();
                int i3 = this.R.statusTitleHeightInNormalState;
                if (QLog.isColorLevel()) {
                    QLog.d("2025_UI_ConversationHofngBaoV2", 2, "ensureInit statusTitleHeight = ", Integer.valueOf(height), ",statusTitleHeightInNormalState = ", Integer.valueOf(i3));
                }
                if (i3 > 0) {
                    height = i3;
                }
                this.f289422s0 = height;
                HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout2 = this.f289408h;
                hongBaoSmartRefreshLayout2.G1 = hongBaoSmartRefreshLayout2.F1 - height;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("2025_UI_ConversationHofngBaoV2", 2, "ensureInit title = ", animTitle);
                }
                int f16 = BaseAIOUtils.f(50.0f, Z().getResources());
                this.f289422s0 = f16;
                HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout3 = this.f289408h;
                hongBaoSmartRefreshLayout3.G1 = hongBaoSmartRefreshLayout3.F1 - f16;
            }
            HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout4 = this.f289408h;
            this.f289416m0 = hongBaoSmartRefreshLayout4.F1;
            this.f289418o0 = hongBaoSmartRefreshLayout4.G1;
            this.Q.h().r(this.f289422s0);
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "ensureInit backgroundBannerHeight = ", Integer.valueOf(this.f289416m0), ", bannerHeightWithoutTitlebar = ", Integer.valueOf(this.f289418o0));
            }
            this.N = (int) Z().getResources().getDimension(R.dimen.f159445af1);
            BasePrepareView basePrepareView = this.f289403e;
            if (basePrepareView != null) {
                this.f289411i0.removeView(basePrepareView);
            }
            BaseFormalView baseFormalView = this.f289401d;
            if (baseFormalView != null) {
                this.f289411i0.removeView(baseFormalView);
            }
            View view = this.f289405f;
            if (view != null) {
                this.f289411i0.removeView(view);
            }
            BaseCountDownProgressView baseCountDownProgressView = this.f289412j0;
            if (baseCountDownProgressView != null) {
                this.f289411i0.removeView(baseCountDownProgressView);
            }
            this.f289403e = S();
            this.f289401d = R();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.f289403e.setLayoutParams(layoutParams);
            this.f289403e.setVisibility(8);
            this.f289411i0.addView(this.f289403e);
            this.f289417n0 = false;
            this.f289401d.setLayoutParams(layoutParams);
            this.f289401d.setVisibility(8);
            EntryConfigBean J = this.Q.n().J();
            if (J != null) {
                this.f289401d.setGiftFiredNums(J.commonData.giftFiredNums);
                this.f289401d.setUpgradeNums(J.commonData.comboUpgradeNums);
            }
            BaseActivityData j3 = this.Q.j();
            if (j3 instanceof OnGrabActivityData) {
                OnGrabActivityData onGrabActivityData = (OnGrabActivityData) j3;
                this.f289401d.setStartAndEndText(onGrabActivityData.startWording, onGrabActivityData.endWording);
            }
            this.f289411i0.addView(this.f289401d);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams2.gravity = 48;
            layoutParams2.topMargin = this.f289422s0;
            View view2 = new View(Z());
            this.f289405f = view2;
            view2.setLayoutParams(layoutParams2);
            this.f289405f.setBackground(Z().getResources().getDrawable(R.drawable.qui_common_bg_primary_bg));
            this.f289411i0.addView(this.f289405f);
            this.f289413k0 = false;
            BaseCountDownProgressView Q = Q();
            this.f289412j0 = Q;
            Q.setOnQuitClickListener(new Runnable() { // from class: com.tencent.mobileqq.springhb.module.ConversationHongBaoV2.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ConversationHongBaoV2.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ConversationHongBaoV2.this.f289413k0 = true;
                        ConversationHongBaoV2.this.f289399b0.cancel();
                        ConversationHongBaoV2.this.f289399b0.onFinish();
                        ConversationHongBaoV2.this.K0();
                        ConversationHongBaoV2.this.i1();
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.f289412j0.setVisibility(8);
            int dimension = (int) Z().getResources().getDimension(R.dimen.aex);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, dimension);
            HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout5 = this.f289408h;
            layoutParams3.topMargin = hongBaoSmartRefreshLayout5.F1 - hongBaoSmartRefreshLayout5.G1;
            this.P = dimension;
            this.f289412j0.setLayoutParams(layoutParams3);
            this.f289411i0.addView(this.f289412j0);
            this.f289409h0 = (ImageView) c0().findViewById(R.id.d7f);
            final SpringRes a16 = s.a("spring_shua_gesture_hand.png");
            a16.d(Z(), new Function2() { // from class: com.tencent.mobileqq.springhb.module.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l06;
                    l06 = ConversationHongBaoV2.this.l0(a16, (SpringRes) obj, (Boolean) obj2);
                    return l06;
                }
            });
            this.f289401d.g(c0());
            ac.h().t();
            this.f289415m = 1;
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "ensureInit,mState updated to STATE_INITED, ", Integer.valueOf(this.f289415m), ",mProgressViewRed topMargin = ", Integer.valueOf(layoutParams3.topMargin));
                return;
            }
            return;
        }
        HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout6 = this.f289408h;
        if (hongBaoSmartRefreshLayout6 != null) {
            hongBaoSmartRefreshLayout6.f384578p1 = this;
            hongBaoSmartRefreshLayout6.F1 = this.f289416m0;
            hongBaoSmartRefreshLayout6.G1 = this.f289418o0;
        }
    }

    void Y(long j3) {
        if (this.J == j3) {
            return;
        }
        this.J = j3;
        int i3 = (int) (j3 / 1000);
        int i16 = i3 / 60;
        int i17 = i3 % 60;
        int i18 = ((int) j3) % 100;
        StringBuilder sb5 = this.f289404e0;
        sb5.delete(0, sb5.length());
        if (i16 > 0) {
            if (i16 < 10) {
                this.f289404e0.append("0");
            }
            StringBuilder sb6 = this.f289404e0;
            sb6.append(i16);
            sb6.append(":");
        }
        if (i17 < 10) {
            this.f289404e0.append("0");
        }
        this.f289404e0.append(i17);
        this.f289404e0.append(":");
        if (i18 < 10) {
            this.f289404e0.append("0");
        }
        this.f289404e0.append(i18);
        StringBuilder sb7 = this.f289402d0;
        sb7.delete(0, sb7.length());
        this.f289402d0.append(this.f289406f0);
        this.f289402d0.append((CharSequence) this.f289404e0);
    }

    public boolean Z0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, i3)).booleanValue();
        }
        if (FrameHelperActivity.Gi()) {
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showPreGuide ", Integer.valueOf(this.f289415m));
            }
            return false;
        }
        if (this.f289408h == null) {
            return false;
        }
        c1(i3);
        return true;
    }

    public Conversation a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Conversation) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.R;
    }

    public void a1(OnGrabActivityData onGrabActivityData, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, onGrabActivityData, Long.valueOf(j3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showPrepareCountDown", ",mState = ", Integer.valueOf(this.f289415m), ",taskID = ", this.H0 + ",prepareCountDownMs = " + j3);
        }
        h1();
        HashMap hashMap = new HashMap();
        hashMap.put("buss_id", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
        hashMap.put("module_id", "swip");
        hashMap.put("submodule_id", "cuofeng_page");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "exp");
        hashMap.put("ext2", String.valueOf(j3 / 1000));
        hashMap.put("ext5", com.tencent.mobileqq.springhb.prize.h.e());
        if (this.Q.j() != null) {
            hashMap.put("changci_id", this.Q.j().f289093id);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportForGameCenter(hashMap);
        }
        this.X = onGrabActivityData.shareData;
        X();
        this.H0 = onGrabActivityData.f289093id;
        r0();
        boolean V = this.Q.n().V();
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showPrepareCountDown", ",mState = ", Integer.valueOf(this.f289415m), ",taskID = ", this.H0, ",isPendantShowSwitchOn = ", Boolean.valueOf(V));
        }
        if (j3 >= 0) {
            this.f289403e.d(j3);
        } else {
            this.f289403e.e();
        }
        X0(onGrabActivityData);
        if (this.Q.n().O(this.Q.j().f289093id).hasClickCloseBtn || !V) {
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showPrepareCountDown hide pendant");
            }
            this.Q.p().g(2);
        }
    }

    public long b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.Q.n().O(this.Q.j().f289093id).leftCountDownDuration;
    }

    public void d0(boolean z16) {
        Conversation conversation;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "hideTitle direct = ", Boolean.valueOf(z16), ",mTitleIsVisible = ", Boolean.valueOf(this.M));
        }
        if (this.M && (conversation = this.R) != null) {
            this.M = false;
            if (!z16) {
                try {
                    T(conversation.getAnimTitle(), this.R.getAnimContainer(), this.R.getAnimHead());
                    return;
                } catch (Throwable th5) {
                    QLog.d("2025_UI_ConversationHofngBaoV2", 2, "hideTitle error:", th5);
                    return;
                }
            }
            View animTitle = conversation.getAnimTitle();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) animTitle.getLayoutParams();
            layoutParams.topMargin = -this.f289419p0;
            animTitle.setLayoutParams(layoutParams);
            TitleAreaHeadLayout animHead = this.R.getAnimHead();
            animHead.setVisibility(8, "spring_hb");
            animHead.setAlpha(0.0f);
            this.Q.h().r(0);
            this.M = false;
        }
    }

    public void d1(OnGrabActivityData onGrabActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) onGrabActivityData);
            return;
        }
        UserData.UserDataItem O = this.Q.n().O(this.Q.j().f289093id);
        long j3 = O.leftCountDownDuration;
        boolean V = this.Q.n().V();
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showShuaYiShuaTask leftCountDownDuration = ", Long.valueOf(j3), ",isPendantShowSwitchOn = ", Boolean.valueOf(V), ",mState = ", Integer.valueOf(this.f289415m));
        }
        if (this.f289415m == -1 && j3 == 0) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showShuaYiShuaTask return mState == STATE_EMPTY && leftCountDownDuration == 0");
            p0(true);
            return;
        }
        if (onGrabActivityData.f289093id.equals(this.H0) && this.f289415m == 3) {
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showShuaYiShuaTask return for already STATE_SHUA_YI_SHUA_READY ,taskID = ", this.H0);
                return;
            }
            return;
        }
        this.X = onGrabActivityData.shareData;
        X();
        this.H0 = onGrabActivityData.f289093id;
        int i3 = this.f289415m;
        if (i3 != 3 && i3 != 4) {
            e0();
            this.f289408h.setComboListener(this.B0);
            this.f289403e.setVisibility(8);
            this.f289403e.c();
            this.f289417n0 = false;
            BaseFormalView baseFormalView = this.f289401d;
            if (baseFormalView != null) {
                baseFormalView.setVisibility(0);
            }
        }
        this.f289414l0 = onGrabActivityData.grabWording;
        String str = onGrabActivityData.tipBarWording;
        this.f289406f0 = str;
        if (TextUtils.isEmpty(str)) {
            this.f289406f0 = "\u7ee7\u7eed\u4e0b\u62c9\u62a2\u73b0\u91d1\u7ea2\u5305 \u5012\u8ba1\u65f6 ";
        }
        SpringRes a16 = s.a("spring_shua_background_audio");
        if (a16.q()) {
            ac.h().s(new File(a16.l()));
        }
        if (j3 < 0) {
            q0();
        } else {
            if (j3 == 0) {
                p0(true);
                return;
            }
            l1(j3);
        }
        BaseFormalView baseFormalView2 = this.f289401d;
        if (baseFormalView2 != null) {
            baseFormalView2.setProgressLogo(onGrabActivityData.progressBrandImgUrl);
        }
        if (O.hasClickCloseBtn || !V) {
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showShuaYiShuaTask hide pendant");
            }
            this.Q.p().g(2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showShuaYiShuaTask mState:", Integer.valueOf(this.f289415m), " isShuaYiShuaSplashShowing:", Boolean.valueOf(SetSplash.h()), " isShowShuaYiShuaSplashGuide:", Boolean.valueOf(SetSplash.f()));
        }
        if (this.f289415m == 3) {
            N();
            Message obtainMessage = this.G.obtainMessage(1008, SetSplash.f() ? 1 : 0, 0);
            this.G.removeMessages(1008);
            this.G.sendMessageDelayed(obtainMessage, 200L);
        }
    }

    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (this.f289415m == -1) {
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "hongbaoMode return for STATE_EMPTY");
            }
        } else {
            if (j0()) {
                if (QLog.isColorLevel()) {
                    QLog.d("2025_UI_ConversationHofngBaoV2", 2, "hongbaoMode return for already show hongbao");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "hongbaoMode");
            }
            this.f289408h.y0();
            Y0();
            this.R.setThemeDiyBgConversation();
            N();
            this.E = false;
            this.D = false;
        }
    }

    public void e1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showTitle direct = ", Boolean.valueOf(z16), ",mTitleIsVisible = ", Boolean.valueOf(this.M));
        }
        if (z16) {
            ValueAnimator valueAnimator = this.f289421r0;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f289421r0.removeAllListeners();
                this.f289421r0.cancel();
            }
            T0();
            this.M = true;
            return;
        }
        if (this.M) {
            ValueAnimator valueAnimator2 = this.f289421r0;
            if (valueAnimator2 != null && !valueAnimator2.isRunning()) {
                if (QLog.isColorLevel()) {
                    QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showTitle do resetTitle");
                }
                T0();
                return;
            }
            return;
        }
        this.M = true;
        try {
            V(this.R.getAnimTitle(), this.R.getAnimContainer(), this.R.getAnimHead());
        } catch (Throwable th5) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showTitle error:", th5);
        }
    }

    public boolean h0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        int i3 = this.f289415m;
        if (i3 != 2 && i3 != 3 && i3 != 4) {
            return false;
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1002) {
            if (i3 != 1006) {
                if (i3 == 1008) {
                    if (QLog.isColorLevel()) {
                        QLog.d("2025_UI_ConversationHofngBaoV2", 2, "handleMessage MSG_WHAT_SHOW_PREGUIDE arg1:", Integer.valueOf(message.arg1));
                    }
                    Z0(message.arg1);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("2025_UI_ConversationHofngBaoV2", 2, "handleMessage MSG_WHAT_PlAYSOUND_RING");
                }
                if (this.L) {
                    ac.h().o(4);
                }
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "handleMessage MSG_WHAT_POST_ONRESUME");
            }
            C0();
        }
        return false;
    }

    public boolean i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this)).booleanValue();
        }
        return AppNetConnInfo.isNetSupport();
    }

    public boolean j0() {
        HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.f289415m == -1 || (hongBaoSmartRefreshLayout = this.f289408h) == null || !hongBaoSmartRefreshLayout.f384576n1 || !hongBaoSmartRefreshLayout.f384580r1) {
            return false;
        }
        return true;
    }

    public boolean k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        BaseFormalView baseFormalView = this.f289401d;
        if (baseFormalView != null && baseFormalView.h()) {
            return true;
        }
        return false;
    }

    public void l1(long j3) {
        long j16;
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "startCountDown , countDownDuration = ", Long.valueOf(j3), ",mState = ", Integer.valueOf(this.f289415m));
        }
        if (this.f289415m != 4) {
            this.f289415m = 4;
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "startCountDown,mState updated to STATE_SHUA_YI_SHUA_COUNTDOWN, ", Integer.valueOf(this.f289415m));
            }
            this.f289412j0.setAlpha(0.0f);
            this.f289412j0.setVisibility(0);
            this.Q.p().g(2);
            if (j3 != -1 && this.f289408h.M1 == 0) {
                ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(a.o.f355022a);
                this.f289408h.setSpringbackOffset(this.P);
                this.f289408h.D0(this.P);
            }
            this.f289408h.o0();
            n1();
            this.Q.h().m();
        }
        BaseActivityData j18 = this.Q.j();
        if (j3 == -1) {
            k1();
            HashMap hashMap = new HashMap();
            hashMap.put("buss_id", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
            hashMap.put("module_id", "swip");
            hashMap.put("submodule_id", "begin_page");
            hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "exp");
            hashMap.put("ext5", com.tencent.mobileqq.springhb.prize.h.e());
            if (this.Q.j() != null) {
                hashMap.put("changci_id", this.Q.j().f289093id);
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportForGameCenter(hashMap);
            }
            I0();
            if (j18 instanceof OnGrabActivityData) {
                j16 = ((OnGrabActivityData) j18).playDuration * 1000;
            } else {
                j16 = 0;
            }
            if (this.Q.n().Y()) {
                int M = this.Q.n().M();
                j16 /= M;
                if (QLog.isColorLevel()) {
                    QLog.d("2025_UI_ConversationHofngBaoV2", 2, "startCountDown SpeedUp countDownDuration = ", Long.valueOf(j16), ", ratio = ", Integer.valueOf(M));
                }
            }
        } else {
            j16 = j3;
        }
        if (this.f289399b0 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "startCountDown mTimerCountDown.cancel");
            }
            this.f289399b0.cancel();
        }
        if (this.K && this.L && ac.h().j()) {
            ac.h().o(2);
        }
        SpringToMainHelper.o(this.R.getApp());
        UserData.UserDataItem O = this.Q.n().O(this.Q.j().f289093id);
        this.T = O.totalGrabCountForShare;
        this.V = O.totalHitCountForShare;
        if (this.Y < 0) {
            this.Y = O.brushStartTsForReport;
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "startCountDown brushStartTsForReport = ", Long.valueOf(this.Y));
            }
        }
        G0();
        QLog.d("2025_UI_ConversationHofngBaoV2", 1, "startCountDown countDownDuration = ", Long.valueOf(j3), ",realCountDownDuration = ", Long.valueOf(j16), "\uff0ctotalGrabCountForShare = ", Integer.valueOf(this.T));
        if (j18 instanceof OnGrabActivityData) {
            j17 = ((OnGrabActivityData) j18).playDuration * 1000;
        } else {
            j17 = 0;
        }
        e eVar = new e(j16, 40L, j17);
        this.f289399b0 = eVar;
        eVar.start();
        L0();
        j1();
    }

    public boolean m1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        if (this.f289415m != 3) {
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "startGestureGuide return,  mState = ", Integer.valueOf(this.f289415m));
            }
            return false;
        }
        if (this.f289409h0 != null) {
            S0();
            this.f289409h0.setVisibility(0);
        }
        return true;
    }

    public void n1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        ImageView imageView = this.f289409h0;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void o1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (!j0()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "updateState mState = ", Integer.valueOf(this.f289415m));
        }
        if (this.f289415m == 4) {
            if (!this.L || !this.K || FrameHelperActivity.Gi()) {
                FrameHelperActivity.hj(true);
            }
        }
    }

    public void p0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        if (this.f289415m != -1) {
            if (QLog.isColorLevel()) {
                QLog.d("2025_UI_ConversationHofngBaoV2", 2, "showTask,mState updated to STATE_SHUA_YI_SHUA_END, ", Integer.valueOf(this.f289415m));
            }
            this.Q.p().b();
            if (z16) {
                s0();
                Y0();
            } else {
                this.G.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.springhb.module.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConversationHongBaoV2.this.s0();
                    }
                }, 2000L);
                this.G.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.springhb.module.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConversationHongBaoV2.this.Y0();
                    }
                }, 3000L);
            }
        }
        this.Q.f().o(this.Q.j());
    }

    public void s0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        try {
        } finally {
            try {
            } finally {
            }
        }
        if (this.D && !this.Q.l().e()) {
            QLog.i("2025_UI_ConversationHofngBaoV2", 1, "normalMode normal state and not default style");
        } else {
            this.C = true;
            U();
        }
    }

    public boolean t0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "onBannerClicked mState = ", Integer.valueOf(this.f289415m));
        }
        if (!this.Q.n().X() || !h0()) {
            return false;
        }
        c1(0);
        return true;
    }

    public void u0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "onBeforeAccountChanged mState = ", Integer.valueOf(this.f289415m));
        }
        if (this.f289415m == -1) {
            return;
        }
        s0();
    }

    public void v0(boolean z16, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str, bundle);
        }
    }

    public void w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else {
            if (!j0()) {
                return;
            }
            o1();
            if (this.f289415m == 4) {
                C0();
            }
        }
    }

    public void x0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (!j0()) {
            return;
        }
        if (this.f289415m == 4) {
            A0();
        }
        o1();
        this.f289408h.setSpringbackOffset(0);
        if (this.f289408h.q0() != 0) {
            this.f289408h.D0(0);
        }
        e1(true);
        BaseFormalView baseFormalView = this.f289401d;
        if (baseFormalView != null) {
            baseFormalView.j();
        }
    }

    public void y0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this);
        } else {
            this.V++;
        }
    }

    public void z0(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) logoutReason);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("2025_UI_ConversationHofngBaoV2", 2, "onLogout mState = ", Integer.valueOf(this.f289415m));
        }
        if (this.f289415m == -1) {
            return;
        }
        s0();
    }
}
