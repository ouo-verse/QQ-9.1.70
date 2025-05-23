package com.tencent.mobileqq.popanim.state;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pb.emosm.EmosmPb$SmallYellowItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e extends com.tencent.mobileqq.popanim.state.a implements com.tencent.mobileqq.activity.aio.stickerbubble.d, StickerBubbleAnimationView.a {
    static IPatchRedirector $redirector_;
    private LottieAnimationView C;
    private View D;
    private LottieDrawable E;
    protected com.tencent.mobileqq.stickerbubble.viewholder.b F;
    protected com.tencent.mobileqq.activity.aio.stickerbubble.e G;
    private PopOutAnimConfig H;
    ObjectAnimator I;

    /* renamed from: h, reason: collision with root package name */
    private int f259130h;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f259131i;

    /* renamed from: m, reason: collision with root package name */
    private LottieAnimationView f259132m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements LottieHelper.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                e.this.E = lottieDrawable;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) lottieDrawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f259134d;

        b(int i3) {
            this.f259134d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, i3);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) animator);
            } else {
                e.this.D.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                onAnimationEnd(animator);
            } else {
                iPatchRedirector.redirect((short) 3, this, animator, Boolean.valueOf(z16));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                onAnimationStart(animator);
            } else {
                iPatchRedirector.redirect((short) 2, this, animator, Boolean.valueOf(z16));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                e.this.D.setTranslationY(0.0f);
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            } else {
                e.this.D.setTranslationY(this.f259134d);
                com.tencent.mobileqq.popanim.view.a.j(0, e.this.C, e.this.D, e.this.f259132m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(ViewGroup viewGroup, f fVar) {
        super(viewGroup, fVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewGroup, (Object) fVar);
            return;
        }
        this.f259130h = ImmersiveUtils.getStatusBarHeight(this.f259122d);
        this.F = com.tencent.mobileqq.stickerbubble.viewholder.b.f290239a;
        this.f259132m = (LottieAnimationView) this.f259123e.findViewById(R.id.v6d);
        this.C = (LottieAnimationView) this.f259123e.findViewById(R.id.f26350da);
        this.D = this.f259123e.findViewById(R.id.f26360db);
        this.f259131i = (FrameLayout) this.f259123e.findViewById(R.id.f26310d7);
        this.H = this.f259124f.f259138c;
        com.tencent.mobileqq.activity.aio.stickerbubble.e eVar = new com.tencent.mobileqq.activity.aio.stickerbubble.e(this, this.f259124f.f259140e, true, true);
        this.G = eVar;
        eVar.j(false);
        LottieHelper.b(this.f259122d, "emoc/pop_anim_del.json", null, 50, 50, 0, new a());
    }

    private void t(EmoticonInfo emoticonInfo) {
        int i3;
        ICommonUsedSystemEmojiManagerService iCommonUsedSystemEmojiManagerService;
        if (emoticonInfo != null && (emoticonInfo instanceof SystemAndEmojiEmoticonInfo)) {
            SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
            int i16 = systemAndEmojiEmoticonInfo.emotionType;
            int i17 = systemAndEmojiEmoticonInfo.code;
            if (i17 == -1) {
                return;
            }
            EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = new EmosmPb$SmallYellowItem();
            emosmPb$SmallYellowItem.f342125id.set(i17);
            if (i16 == 1) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            emosmPb$SmallYellowItem.type.set(i3);
            long currentTimeMillis = System.currentTimeMillis();
            emosmPb$SmallYellowItem.f342126ts.set(currentTimeMillis);
            QLog.d("PopAnimState", 1, "addToCommonUsed type = " + i3 + ";id = " + i17 + ";ts = " + currentTimeMillis);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iCommonUsedSystemEmojiManagerService = (ICommonUsedSystemEmojiManagerService) peekAppRuntime.getRuntimeService(ICommonUsedSystemEmojiManagerService.class, "all")) != null) {
                iCommonUsedSystemEmojiManagerService.saveSystemEmojiInfoToCahce(emosmPb$SmallYellowItem);
            }
        }
    }

    private void u() {
        View view = this.D;
        if (view == null) {
            return;
        }
        if (this.I == null) {
            int i3 = view.getLayoutParams().height;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.D, "translationY", i3, 0.0f);
            this.I = ofFloat;
            ofFloat.setDuration(400L);
            this.I.addListener(new b(i3));
        }
        this.I.start();
    }

    @Override // com.tencent.mobileqq.popanim.state.a
    public void a(com.tencent.mobileqq.popanim.state.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        if (aVar instanceof PopDeleteState) {
            return;
        }
        this.F.f(this, true);
        LottieDrawable lottieDrawable = this.E;
        if (lottieDrawable != null) {
            this.C.setImageDrawable(lottieDrawable);
        }
        u();
        com.tencent.mobileqq.popanim.view.a.h("0X800BBA1", this.f259124f.f259137b);
    }

    @Override // com.tencent.mobileqq.popanim.state.a
    public void b(com.tencent.mobileqq.popanim.state.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        ObjectAnimator objectAnimator = this.I;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.I.end();
        }
        if (aVar instanceof PopDeleteState) {
            return;
        }
        com.tencent.mobileqq.popanim.view.a.j(4, this.C, this.D, this.f259132m);
        this.G.d();
    }

    @Override // com.tencent.mobileqq.popanim.state.a
    public boolean c(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        f fVar = this.f259124f;
        if (!fVar.f259145j) {
            fVar.f259145j = true;
            this.G.onShowPress(motionEvent);
        }
        this.G.g(motionEvent);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f259132m.getLayoutParams();
        layoutParams.leftMargin = ((int) motionEvent.getRawX()) - (this.f259132m.getWidth() / 2);
        layoutParams.topMargin = (((int) motionEvent.getRawY()) - this.f259130h) - (this.f259132m.getHeight() / 2);
        this.f259132m.requestLayout();
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.H.maxSendCount;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.H.startShakeAnimation();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.a
    public void h(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f259124f.f259136a.e();
            this.F.s(this);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.H.stopShakeAnimation();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public void j(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public void k(float f16, float f17, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        EmoticonInfo emoticonInfo = this.f259124f.f259137b;
        if (!(emoticonInfo instanceof SystemAndEmojiEmoticonInfo)) {
            QLog.e("PopAnimState", 1, "mEmoticonInfo error");
        } else {
            this.F.u(this.f259131i).d(com.tencent.mobileqq.popanim.view.a.b(new Point((int) f16, (int) f17), com.tencent.mobileqq.popanim.util.a.a(((SystemAndEmojiEmoticonInfo) emoticonInfo).code, this.H.apngSoLoaded), com.tencent.mobileqq.popanim.util.a.e(i16, this.H.itemCountShowAppear)));
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public boolean l(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public void m(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i16 == f()) {
            i16--;
            this.f259124f.f259146k = true;
        }
        this.F.k().m();
        f fVar = this.f259124f;
        SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) fVar.f259137b;
        if (!fVar.f259148m) {
            this.H.sendPopEmoMsg(systemAndEmojiEmoticonInfo, i16);
            com.tencent.mobileqq.popanim.view.a.h("0X800BBA3", systemAndEmojiEmoticonInfo);
            t(systemAndEmojiEmoticonInfo);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.F.k().setShowText(false);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.d
    public int r(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16), Float.valueOf(f17))).intValue();
        }
        QQEmoticonPanelLinearLayoutHelper a16 = this.f259124f.a();
        if (a16 == null) {
            return -1;
        }
        return a16.getCurrentPointViewIndex();
    }
}
