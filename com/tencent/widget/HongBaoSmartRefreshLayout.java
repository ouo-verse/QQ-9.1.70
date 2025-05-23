package com.tencent.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.portal.HongBaoPendantHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.entry.model.PendantData;
import com.tencent.mobileqq.springhb.module.ConversationHongBaoV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.view.ClipSkinnableRecycleView;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HongBaoSmartRefreshLayout extends SmartRefreshLayout {
    static IPatchRedirector $redirector_;
    private long A1;
    public HongBaoPendantHolder B1;
    private r3.h C1;
    private r3.e D1;
    private int E1;
    public int F1;
    public int G1;
    public boolean H1;
    public boolean I1;
    private int J1;
    private boolean K1;
    private GestureDetector L1;
    public int M1;
    public Handler N1;

    /* renamed from: m1, reason: collision with root package name */
    public RefreshState f384575m1;

    /* renamed from: n1, reason: collision with root package name */
    public boolean f384576n1;

    /* renamed from: o1, reason: collision with root package name */
    public boolean f384577o1;

    /* renamed from: p1, reason: collision with root package name */
    public ConversationHongBaoV2 f384578p1;

    /* renamed from: q1, reason: collision with root package name */
    public boolean f384579q1;

    /* renamed from: r1, reason: collision with root package name */
    public boolean f384580r1;

    /* renamed from: s1, reason: collision with root package name */
    public int f384581s1;

    /* renamed from: t1, reason: collision with root package name */
    public boolean[] f384582t1;

    /* renamed from: u1, reason: collision with root package name */
    public float[] f384583u1;

    /* renamed from: v1, reason: collision with root package name */
    public int f384584v1;

    /* renamed from: w1, reason: collision with root package name */
    public g f384585w1;

    /* renamed from: x1, reason: collision with root package name */
    public i f384586x1;

    /* renamed from: y1, reason: collision with root package name */
    public boolean f384587y1;

    /* renamed from: z1, reason: collision with root package name */
    public boolean f384588z1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class a extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f384589d;

        a(int i3) {
            this.f384589d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongBaoSmartRefreshLayout.this, i3);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            if (animator != null && animator.getDuration() == 0) {
                return;
            }
            QLog.d("HongBaoListView", 4, "springBackTo end offset:" + this.f384589d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class b implements GestureDetector.OnGestureListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongBaoSmartRefreshLayout.this);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout = HongBaoSmartRefreshLayout.this;
            if (hongBaoSmartRefreshLayout.f384578p1 != null) {
                int q06 = hongBaoSmartRefreshLayout.q0();
                HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout2 = HongBaoSmartRefreshLayout.this;
                int i3 = hongBaoSmartRefreshLayout2.f384578p1.P;
                if (q06 >= i3 && f17 <= -1500.0f) {
                    hongBaoSmartRefreshLayout2.setSpringbackOffset(i3);
                    HongBaoSmartRefreshLayout.this.D0(i3);
                    QLog.d("HongBaoListView", 1, "onFling velocityY:", Float.valueOf(f17), " countDownHeight:", Integer.valueOf(i3), " scrollY:", Integer.valueOf(HongBaoSmartRefreshLayout.this.q0()));
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class c extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongBaoSmartRefreshLayout.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                if (animator != null && animator.getDuration() == 0) {
                    return;
                }
                ((SmartRefreshLayout) HongBaoSmartRefreshLayout.this).X0.b(RefreshState.None);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class d implements Handler.Callback {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongBaoSmartRefreshLayout.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            int i3 = message.what;
            long j3 = 2000;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            if (i3 == 7) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("HongBaoListView", 2, "handleMessage MSG_WHAT_PREGUIDE_END");
                                }
                                HongBaoSmartRefreshLayout.this.setIsShowingPreguide(false);
                                QLog.d("HongBaoListView", 4, "MSG_WHAT_PREGUIDE_END setSpringbackOffset:0");
                                HongBaoSmartRefreshLayout.this.setSpringbackOffset(0);
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("HongBaoListView", 2, "handleMessage MSG_WHAT_THIRD_GUIDE_HIDE isShuaYiShuaCountDown:", Boolean.valueOf(HongBaoSmartRefreshLayout.this.w0()));
                            }
                            if (HongBaoSmartRefreshLayout.this.w0()) {
                                HongBaoSmartRefreshLayout.this.setIsShowingPreguide(false);
                                ConversationHongBaoV2 conversationHongBaoV2 = HongBaoSmartRefreshLayout.this.f384578p1;
                                if (conversationHongBaoV2 != null) {
                                    conversationHongBaoV2.P0();
                                }
                            } else {
                                HongBaoSmartRefreshLayout.this.u0(300L);
                                HongBaoSmartRefreshLayout.this.N1.sendEmptyMessageDelayed(7, 300L);
                                g gVar = HongBaoSmartRefreshLayout.this.f384585w1;
                                if (gVar != null) {
                                    gVar.i(false);
                                }
                            }
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("HongBaoListView", 2, "handleMessage MSG_WHAT_THIRD_GUIDE_SHOW arg2:", Integer.valueOf(message.arg2));
                        }
                        HongBaoSmartRefreshLayout.this.setIsShowingPreguide(true);
                        if (message.arg2 == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout = HongBaoSmartRefreshLayout.this;
                        int i16 = hongBaoSmartRefreshLayout.G1;
                        int i17 = i16 / 2;
                        int i18 = message.arg1;
                        if (i18 != 0) {
                            i17 = i18;
                        }
                        if (!z16) {
                            i16 = i17;
                        }
                        QLog.d("HongBaoListView", 4, "MSG_WHAT_THIRD_GUIDE_SHOW ", " getSpringbackOffset:", Integer.valueOf(hongBaoSmartRefreshLayout.s0()), " setSpringbackOffset:", Integer.valueOf(HongBaoSmartRefreshLayout.this.G1), " isSplashGuide:", Boolean.valueOf(z16), " downHeight:", Integer.valueOf(i16), " mBannerHeightWithoutTitlebar:", Integer.valueOf(HongBaoSmartRefreshLayout.this.G1));
                        HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout2 = HongBaoSmartRefreshLayout.this;
                        hongBaoSmartRefreshLayout2.setSpringbackOffset(hongBaoSmartRefreshLayout2.G1);
                        HongBaoSmartRefreshLayout.this.D0(i16);
                        if (z16) {
                            j3 = 3000;
                        }
                        HongBaoSmartRefreshLayout.this.N1.sendEmptyMessageDelayed(6, j3);
                        g gVar2 = HongBaoSmartRefreshLayout.this.f384585w1;
                        if (gVar2 != null) {
                            gVar2.n1(false);
                        }
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("HongBaoListView", 2, "handleMessage MSG_WHAT_FIRST_GUIDE_HIDE");
                    }
                    HongBaoSmartRefreshLayout.this.u0(300L);
                    HongBaoSmartRefreshLayout.this.N1.sendEmptyMessageDelayed(7, 300L);
                    g gVar3 = HongBaoSmartRefreshLayout.this.f384585w1;
                    if (gVar3 != null) {
                        gVar3.i(false);
                    }
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("HongBaoListView", 2, "handleMessage MSG_WHAT_FIRST_GUIDE_SHOW");
                }
                HongBaoSmartRefreshLayout.this.setIsShowingPreguide(true);
                HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout3 = HongBaoSmartRefreshLayout.this;
                hongBaoSmartRefreshLayout3.D0(hongBaoSmartRefreshLayout3.G1);
                g gVar4 = HongBaoSmartRefreshLayout.this.f384585w1;
                if (gVar4 != null) {
                    gVar4.n1(false);
                }
                HongBaoSmartRefreshLayout.this.N1.sendEmptyMessageDelayed(2, 2000L);
                HongBaoSmartRefreshLayout.this.invalidate();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class e extends r3.g {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        HongBaoSmartRefreshLayout f384594e;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private boolean j() {
            HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout = this.f384594e;
            if (hongBaoSmartRefreshLayout != null && hongBaoSmartRefreshLayout.f384579q1 && hongBaoSmartRefreshLayout.f384576n1) {
                return true;
            }
            return false;
        }

        @Override // r3.g, r3.f
        public void B9(q3.d dVar, boolean z16, float f16, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, dVar, Boolean.valueOf(z16), Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            } else {
                if (j()) {
                    return;
                }
                super.B9(dVar, z16, f16, i3, i16, i17);
            }
        }

        @Override // r3.g, r3.e
        public void E6(@NonNull q3.f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) fVar);
            } else {
                if (j()) {
                    return;
                }
                super.E6(fVar);
            }
        }

        @Override // r3.g, r3.f
        public void Pe(q3.d dVar, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, dVar, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                if (j()) {
                    return;
                }
                super.Pe(dVar, i3, i16);
            }
        }

        @Override // r3.g, r3.f
        public void Tf(q3.d dVar, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, dVar, Boolean.valueOf(z16));
            } else {
                if (j()) {
                    return;
                }
                super.Tf(dVar, z16);
            }
        }

        @Override // r3.g, r3.f
        public void Z7(q3.c cVar, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, cVar, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                if (j()) {
                    return;
                }
                super.Z7(cVar, i3, i16);
            }
        }

        @Override // r3.g, r3.f
        public void cd(q3.c cVar, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, cVar, Boolean.valueOf(z16));
            } else {
                if (j()) {
                    return;
                }
                super.cd(cVar, z16);
            }
        }

        @Override // r3.g, r3.i
        public void d(@NonNull q3.f fVar, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, fVar, refreshState, refreshState2);
            } else {
                if (j()) {
                    return;
                }
                super.d(fVar, refreshState, refreshState2);
            }
        }

        @Override // r3.g, r3.h
        public void e(@NonNull q3.f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) fVar);
            } else {
                if (j()) {
                    return;
                }
                super.e(fVar);
            }
        }

        protected void k(HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) hongBaoSmartRefreshLayout);
            } else {
                this.f384594e = hongBaoSmartRefreshLayout;
            }
        }

        @Override // r3.g, r3.f
        public void k6(q3.c cVar, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, cVar, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                if (j()) {
                    return;
                }
                super.k6(cVar, i3, i16);
            }
        }

        @Override // r3.g, r3.f
        public void kb(q3.c cVar, boolean z16, float f16, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, cVar, Boolean.valueOf(z16), Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            } else {
                if (j()) {
                    return;
                }
                super.kb(cVar, z16, f16, i3, i16, i17);
            }
        }

        @Override // r3.g, r3.f
        public void vf(q3.d dVar, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, dVar, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                if (j()) {
                    return;
                }
                super.vf(dVar, i3, i16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class f extends SmartRefreshLayout.f {
        static IPatchRedirector $redirector_;

        public f() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongBaoSmartRefreshLayout.this);
            }
        }

        @Override // com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout.f, q3.e
        public q3.e moveSpinner(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (q3.e) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
            q3.e moveSpinner = super.moveSpinner(i3, z16);
            if (i3 > 0) {
                HongBaoSmartRefreshLayout.this.f384577o1 = true;
            } else {
                HongBaoSmartRefreshLayout.this.f384577o1 = false;
            }
            HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout = HongBaoSmartRefreshLayout.this;
            g gVar = hongBaoSmartRefreshLayout.f384585w1;
            if (gVar != null) {
                gVar.h(hongBaoSmartRefreshLayout.getScrollX(), i3);
            }
            HongBaoSmartRefreshLayout hongBaoSmartRefreshLayout2 = HongBaoSmartRefreshLayout.this;
            if (hongBaoSmartRefreshLayout2.f384588z1 && i3 != hongBaoSmartRefreshLayout2.J1) {
                HongBaoSmartRefreshLayout.this.invalidate();
            }
            HongBaoSmartRefreshLayout.this.J1 = i3;
            return moveSpinner;
        }
    }

    public HongBaoSmartRefreshLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f384575m1 = RefreshState.None;
        this.f384576n1 = false;
        this.f384577o1 = false;
        this.f384578p1 = null;
        this.f384580r1 = false;
        this.f384581s1 = -1;
        this.f384582t1 = new boolean[10];
        this.f384583u1 = new float[10];
        this.f384584v1 = 1;
        this.f384585w1 = null;
        this.f384586x1 = null;
        this.f384587y1 = false;
        this.E1 = this.f41174m;
        this.F1 = 0;
        this.G1 = 0;
        this.H1 = false;
        this.I1 = false;
        this.J1 = 0;
        this.K1 = false;
        this.N1 = new Handler(Looper.getMainLooper(), new d());
        v0();
    }

    private void A0() {
        r3.h hVar = this.C1;
        if (hVar != null) {
            l(hVar);
            this.C1 = null;
        }
        r3.e eVar = this.D1;
        if (eVar != null) {
            W(eVar);
            this.D1 = null;
        }
        ((e) this.A0).k(null);
        a(true);
        setEnableOverScrollDrag(true);
        Object obj = this.S0;
        if (obj instanceof View) {
            ((View) obj).setVisibility(0);
        }
        q3.a aVar = this.S0;
        if (aVar != null) {
            aVar.getView().setEnabled(true);
            this.S0.getView().setVisibility(0);
        }
        this.X0.b(RefreshState.None);
        ConversationHongBaoV2 conversationHongBaoV2 = this.f384578p1;
        if (conversationHongBaoV2 != null) {
            conversationHongBaoV2.a0().getAnimTitle().bringToFront();
        }
    }

    private void k0() {
        r3.h hVar = this.f41187y0;
        if (hVar != null) {
            this.C1 = hVar;
        }
        r3.e eVar = this.f41188z0;
        if (eVar != null) {
            this.D1 = eVar;
        }
        ((e) this.A0).k(this);
        a(false);
        setEnableOverScrollDrag(true);
        Object obj = this.S0;
        if (obj instanceof View) {
            ((View) obj).setVisibility(4);
        }
        q3.a aVar = this.S0;
        if (aVar != null) {
            aVar.getView().setEnabled(false);
            this.S0.getView().setVisibility(4);
        }
        ConversationHongBaoV2 conversationHongBaoV2 = this.f384578p1;
        if (conversationHongBaoV2 != null) {
            conversationHongBaoV2.a0().getAnimTitle().bringToFront();
        }
    }

    private void l0(MotionEvent motionEvent) {
        try {
            if (this.L1 == null) {
                this.L1 = n0();
            }
            this.L1.onTouchEvent(motionEvent);
        } catch (Throwable th5) {
            QLog.e("HongBaoListView", 1, "checkGesture error:", th5);
        }
    }

    private GestureDetector n0() {
        return new GestureDetector(getContext(), new b());
    }

    private int p0() {
        ConversationHongBaoV2 conversationHongBaoV2 = this.f384578p1;
        if (conversationHongBaoV2 != null) {
            return conversationHongBaoV2.f289422s0;
        }
        View findViewById = findViewById(R.id.tug);
        if (findViewById != null) {
            return findViewById.getPaddingTop();
        }
        return 0;
    }

    private void v0() {
        setWillNotDraw(false);
        this.A0 = new e();
        this.X0 = new f();
        this.E1 = this.f41174m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w0() {
        ConversationHongBaoV2 conversationHongBaoV2 = this.f384578p1;
        if (conversationHongBaoV2 != null && conversationHongBaoV2.f289415m == 4) {
            return true;
        }
        return false;
    }

    public void B0(@NonNull PendantData pendantData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) pendantData);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HongBaoListView", 2, "showHongBao ," + this.f384588z1);
        }
        if (this.B1 != null) {
            invalidate();
            return;
        }
        HongBaoPendantHolder hongBaoPendantHolder = new HongBaoPendantHolder(this);
        this.B1 = hongBaoPendantHolder;
        hongBaoPendantHolder.l(pendantData);
        this.f384588z1 = true;
        invalidate();
    }

    public void C0(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(a.o.f355022a);
        this.N1.removeMessages(5);
        this.N1.removeMessages(6);
        this.N1.removeMessages(7);
        this.N1.sendMessageDelayed(Message.obtain(this.N1, 5, i3, i16), 150L);
    }

    public void D0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("HongBaoListView", 4, "springBackTo offset:" + i3);
        }
        a aVar = new a(i3);
        ValueAnimator t16 = t(i3, 0, this.W, this.f41174m);
        if (t16 != null && t16 == this.f41172k1) {
            t16.setDuration(this.f41166i);
            t16.addListener(aVar);
        } else {
            aVar.onAnimationEnd(null);
        }
    }

    public void E0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        this.N1.removeMessages(1);
        this.N1.removeMessages(2);
        setIsShowingPreguide(false);
    }

    public void F0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.f384579q1) {
            if (this.I1) {
                this.f41174m = 300;
                return;
            } else {
                this.f41174m = 600;
                return;
            }
        }
        this.f41174m = this.E1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout
    public boolean G(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, i3)).booleanValue();
        }
        if (w0() && q0() > 0) {
            if (i3 == 0) {
                if (this.f41172k1 != null) {
                    RefreshState refreshState = this.Y0;
                    if (refreshState == RefreshState.PullDownCanceled) {
                        this.X0.b(RefreshState.PullDownToRefresh);
                    } else if (refreshState == RefreshState.PullUpCanceled) {
                        this.X0.b(RefreshState.PullUpToLoad);
                    }
                    this.f41172k1.setDuration(0L);
                    this.f41172k1.cancel();
                    this.f41172k1 = null;
                }
                this.f41170j1 = null;
            }
            if (this.f41172k1 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.iAsync("HongBaoListView", 2, "[Async log]interceptAnimatorByAction change ret:" + z16);
            return z16;
        }
        return super.G(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout
    public void L(float f16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Float.valueOf(f16), Boolean.valueOf(z16));
            return;
        }
        if (w0() && z16 && f16 > 0.0f) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[Async log]moveSpinnerInfinitely change to moveSpinner spinner:");
            int i3 = (int) f16;
            sb5.append(i3);
            QLog.iAsync("HongBaoListView", 2, sb5.toString());
            this.X0.moveSpinner(i3, true);
            return;
        }
        super.L(f16, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout
    public void M(RefreshState refreshState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) refreshState);
            return;
        }
        if (this.f384579q1 && this.f384576n1) {
            RefreshState refreshState2 = this.Y0;
            if (refreshState2 != refreshState) {
                this.Y0 = refreshState;
                this.Z0 = refreshState;
                if (refreshState == RefreshState.LoadFinish) {
                    this.f41162g1 = false;
                }
            } else if (this.Z0 != refreshState2) {
                this.Z0 = refreshState2;
            }
        } else {
            super.M(refreshState);
        }
        this.f384575m1 = refreshState;
    }

    @Override // com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.f384579q1 && isEnabled()) {
            ConversationHongBaoV2 conversationHongBaoV2 = this.f384578p1;
            if (conversationHongBaoV2 != null && !conversationHongBaoV2.L) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (w0() && q0() > this.f384578p1.P) {
                l0(motionEvent);
            }
            int action = motionEvent.getAction() & 255;
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                this.f384582t1[motionEvent.getActionIndex()] = false;
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            this.f384583u1[actionIndex] = (int) motionEvent.getY(actionIndex);
                            this.f384582t1[actionIndex] = true;
                        }
                    } else {
                        g gVar = this.f384585w1;
                        if (gVar != null) {
                            gVar.b(this, null);
                        }
                        this.f384581s1 = -1;
                        this.f384587y1 = false;
                    }
                } else {
                    g gVar2 = this.f384585w1;
                    if (gVar2 != null) {
                        gVar2.c(this, this.f384577o1);
                    }
                    motionEvent.findPointerIndex(this.f384581s1);
                    if (this.f384577o1 && this.f384585w1 != null) {
                        int pointerCount = motionEvent.getPointerCount();
                        if (pointerCount > this.f384584v1) {
                            this.f384584v1 = pointerCount;
                        }
                        float f16 = 0.0f;
                        for (int i3 = 0; i3 < motionEvent.getPointerCount(); i3++) {
                            float y16 = motionEvent.getY(i3) - this.f384583u1[i3];
                            if (this.f384582t1[i3] && y16 > f16) {
                                f16 = y16;
                            }
                        }
                        int q06 = q0();
                        int i16 = this.G1;
                        if (q06 >= i16 / 2) {
                            if (f16 > i16 / 4.0f) {
                                setSpringbackOffset(i16);
                                this.f384585w1.e();
                                for (int i17 = 0; i17 < this.f384584v1; i17++) {
                                    this.f384582t1[i17] = false;
                                }
                            }
                            this.f384585w1.g();
                        }
                    }
                }
            } else {
                g gVar3 = this.f384585w1;
                if (gVar3 != null) {
                    gVar3.b(this, motionEvent);
                }
                this.f384581s1 = -1;
            }
            return dispatchTouchEvent;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) canvas);
            return;
        }
        super.draw(canvas);
        HongBaoPendantHolder hongBaoPendantHolder = this.B1;
        int p06 = p0();
        if (this.f384588z1 && hongBaoPendantHolder != null && p06 > 0) {
            int q06 = q0();
            if (q06 < 0) {
                q06 = 0;
            }
            hongBaoPendantHolder.P = q06 + p06;
            if (hongBaoPendantHolder.b(canvas)) {
                invalidate();
            }
        }
    }

    public void m0(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) motionEvent);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("HongBaoListView", 2, "onTouchEvent debug click event x = " + motionEvent.getX() + ", y = " + motionEvent.getY() + ", getListViewScrollY() = " + q0());
        }
        if (this.B1 != null && currentTimeMillis - this.A1 > 800 && q0() == 0) {
            this.A1 = currentTimeMillis;
            if (this.B1.k().contains(motionEvent.getX(), motionEvent.getY())) {
                RectF i3 = this.B1.i();
                if (i3 != null && i3.contains(motionEvent.getX(), motionEvent.getY())) {
                    i iVar = this.f384586x1;
                    if (iVar != null) {
                        iVar.b();
                        invalidate();
                    }
                } else {
                    i iVar2 = this.f384586x1;
                    if (iVar2 != null) {
                        iVar2.a();
                    }
                }
            }
        }
        this.f384587y1 = false;
    }

    public void o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        this.N1.removeMessages(5);
        this.N1.removeMessages(6);
        this.N1.removeMessages(7);
        setIsShowingPreguide(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
    
        if (r0 != 3) goto L39;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        HongBaoPendantHolder hongBaoPendantHolder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) motionEvent)).booleanValue();
        }
        ConversationHongBaoV2 conversationHongBaoV2 = this.f384578p1;
        if (conversationHongBaoV2 != null && !conversationHongBaoV2.L) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.K1 = true;
                }
            }
            this.K1 = false;
        } else {
            this.K1 = true;
            this.f384583u1[0] = motionEvent.getY();
            this.f384582t1[0] = true;
            g gVar = this.f384585w1;
            if (gVar != null) {
                gVar.a(this, motionEvent);
            }
            if (this.f384588z1 && (hongBaoPendantHolder = this.B1) != null && hongBaoPendantHolder.k().contains(motionEvent.getX(), motionEvent.getY())) {
                if (q0() == 0) {
                    this.f384587y1 = true;
                }
                super.onInterceptTouchEvent(motionEvent);
                if (QLog.isColorLevel()) {
                    QLog.d("HongBaoListView", 2, "2021_UI_ConversationHongBaoV2 HongBaoListView onInterceptTouchEvent return true, mComboListener = " + this.f384585w1);
                }
                return true;
            }
            this.f384587y1 = false;
            E0();
        }
        g gVar2 = this.f384585w1;
        if (gVar2 != null && gVar2.f(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) motionEvent)).booleanValue();
        }
        g gVar = this.f384585w1;
        if (gVar != null && gVar.d(motionEvent)) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (this.f384588z1 && this.f384587y1) {
            if (action == 1) {
                m0(motionEvent);
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) view, i3);
            return;
        }
        super.onVisibilityChanged(view, i3);
        if (this.H1) {
            this.H1 = false;
        }
    }

    public int q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.f41155e;
    }

    public int r0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f41174m;
    }

    protected int s0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        if (!this.f384579q1) {
            QLog.d("HongBaoListView", 4, "getSpringbackOffset not activie getSpringbackOffset:0");
            return 0;
        }
        QLog.d("HongBaoListView", 4, "getSpringbackOffset mSpringBackOffset:" + this.M1);
        return this.M1;
    }

    public void setComboListener(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) gVar);
        } else {
            this.f384585w1 = gVar;
        }
    }

    public void setIsShowingPreguide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.I1 = z16;
            F0();
        }
    }

    public void setPendantListener(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) iVar);
        } else {
            this.f384586x1 = iVar;
        }
    }

    public void setSelection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("HongBaoListView", 4, "setSelection position:" + i3);
        }
        View findViewById = findViewById(R.id.tug);
        if (findViewById instanceof ClipSkinnableRecycleView) {
            ((ClipSkinnableRecycleView) findViewById).scrollToPosition(i3);
        }
    }

    public void setSpringbackOffset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        QLog.d("HongBaoListView", 4, "setSpringbackOffset offset:" + i3);
        this.M1 = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout
    public ValueAnimator t(int i3, int i16, Interpolator interpolator, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (ValueAnimator) iPatchRedirector.redirect((short) 33, this, Integer.valueOf(i3), Integer.valueOf(i16), interpolator, Integer.valueOf(i17));
        }
        QLog.iAsync("HongBaoListView", 2, "[Async log]animSpinner endSpinner:" + i3 + " height:" + this.H0);
        if (w0() && (i3 == 0 || i3 == this.H0)) {
            QLog.iAsync("HongBaoListView", 2, "[Async log]animSpinner change to:" + s0());
            i3 = s0();
        }
        return super.t(i3, i16, interpolator, i17);
    }

    public void t0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        if (!this.f384588z1) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HongBaoListView", 2, "hideHongBao ,true");
        }
        this.f384588z1 = false;
        this.B1 = null;
        invalidate();
    }

    public void u0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, j3);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("HongBaoListView", 4, "hidePreGuide duration:", Long.valueOf(j3));
        }
        c cVar = new c();
        ValueAnimator t16 = t(0, 0, this.W, this.f41174m);
        if (t16 != null && t16 == this.f41172k1) {
            t16.setDuration(j3);
            t16.addListener(cVar);
        } else {
            cVar.onAnimationEnd(null);
        }
    }

    public boolean x0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.K1;
    }

    public void y0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HongBaoListView", 2, "modeHongbao");
        }
        k0();
        this.X0.b(RefreshState.None);
        this.f384579q1 = true;
        this.f384576n1 = true;
        this.f384580r1 = true;
    }

    public void z0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HongBaoListView", 2, "modeNormal");
        }
        this.X0.b(RefreshState.None);
        ((e) this.A0).k(null);
        A0();
        F0();
        setComboListener(null);
        this.f384579q1 = false;
        E0();
        this.f384576n1 = false;
        this.f384580r1 = false;
    }

    public HongBaoSmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f384575m1 = RefreshState.None;
        this.f384576n1 = false;
        this.f384577o1 = false;
        this.f384578p1 = null;
        this.f384580r1 = false;
        this.f384581s1 = -1;
        this.f384582t1 = new boolean[10];
        this.f384583u1 = new float[10];
        this.f384584v1 = 1;
        this.f384585w1 = null;
        this.f384586x1 = null;
        this.f384587y1 = false;
        this.E1 = this.f41174m;
        this.F1 = 0;
        this.G1 = 0;
        this.H1 = false;
        this.I1 = false;
        this.J1 = 0;
        this.K1 = false;
        this.N1 = new Handler(Looper.getMainLooper(), new d());
        v0();
    }
}
