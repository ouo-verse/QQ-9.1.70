package com.tencent.mobileqq.aio.msglist.holder.component.poke;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.PokeMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.GreatMoveCombolEffectView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOHapticApi;
import mqq.util.WeakReference;

/* loaded from: classes11.dex */
public class AIOPokeGreatMoveView extends RelativeLayout implements GreatMoveCombolEffectView.b {
    static IPatchRedirector $redirector_;
    private boolean C;
    private Bitmap D;
    private Drawable E;
    private h F;
    private boolean G;
    private float H;
    private WeakReference<Context> I;
    private e J;
    private String K;
    private int L;
    private PokeMsgItem M;
    private boolean N;
    private f P;
    private g Q;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f191456d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f191457e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f191458f;

    /* renamed from: h, reason: collision with root package name */
    private CustomFrameAnimationDrawable f191459h;

    /* renamed from: i, reason: collision with root package name */
    private CustomFrameAnimationDrawable f191460i;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f191461m;

    /* loaded from: classes11.dex */
    class a implements CustomFrameAnimationDrawable.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPokeGreatMoveView.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.poke.CustomFrameAnimationDrawable.c
        public void onUpdate(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else if (i3 == 23) {
                AIOPokeGreatMoveView.this.f191461m.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPokeGreatMoveView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) AIOPokeGreatMoveView.this.f191457e.getLayoutParams();
            if (AIOPokeGreatMoveView.this.C) {
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.rightMargin = intValue;
            } else {
                marginLayoutParams.leftMargin = intValue;
                marginLayoutParams.rightMargin = 0;
            }
            AIOPokeGreatMoveView.this.f191457e.setLayoutParams(marginLayoutParams);
        }
    }

    /* loaded from: classes11.dex */
    class c implements CustomFrameAnimationDrawable.c {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPokeGreatMoveView.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.poke.CustomFrameAnimationDrawable.c
        public void onUpdate(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else if (i3 == 23) {
                AIOPokeGreatMoveView.this.f191461m.start();
            }
        }
    }

    /* loaded from: classes11.dex */
    class d implements CustomFrameAnimationDrawable.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPokeGreatMoveView.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.poke.CustomFrameAnimationDrawable.a
        public void onEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AIOPokeGreatMoveView.this.F.f191472e = true;
            AIOPokeGreatMoveView.this.F.f191471d = false;
            if (AIOPokeGreatMoveView.this.Q != null) {
                AIOPokeGreatMoveView.this.Q.end();
                if (AIOPokeGreatMoveView.this.N) {
                    ((IAIOHapticApi) com.tencent.qqnt.aio.adapter.a.b(IAIOHapticApi.class)).stopEffect(AIOPokeGreatMoveView.this.L);
                    AIOPokeGreatMoveView.this.L = 0;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class e extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        /* loaded from: classes11.dex */
        class a implements CustomFrameAnimationDrawable.a {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
                }
            }

            @Override // com.tencent.mobileqq.aio.msglist.holder.component.poke.CustomFrameAnimationDrawable.a
            public void onEnd() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AIOPokeGreatMoveView.this.F.f191472e = true;
                AIOPokeGreatMoveView.this.F.f191471d = false;
                if (AIOPokeGreatMoveView.this.Q != null) {
                    AIOPokeGreatMoveView.this.Q.end();
                    if (AIOPokeGreatMoveView.this.N) {
                        ((IAIOHapticApi) com.tencent.qqnt.aio.adapter.a.b(IAIOHapticApi.class)).stopEffect(AIOPokeGreatMoveView.this.L);
                        AIOPokeGreatMoveView.this.L = 0;
                    }
                }
            }
        }

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPokeGreatMoveView.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            if (AIOPokeGreatMoveView.this.F.f191471d) {
                if (AIOPokeGreatMoveView.this.H == 2.0d) {
                    AIOPokeGreatMoveView.this.A();
                    AIOPokeGreatMoveView.this.E(5);
                } else {
                    AIOPokeGreatMoveView.this.f191458f.setImageDrawable(AIOPokeGreatMoveView.this.f191460i);
                    AIOPokeGreatMoveView.this.f191460i.u(AIOPokeGreatMoveView.this.C);
                    AIOPokeGreatMoveView.this.f191460i.x(new a());
                    AIOPokeGreatMoveView.this.f191460i.y();
                    AIOPokeGreatMoveView.this.E(1);
                }
                AIOPokeGreatMoveView.this.f191457e.setImageDrawable(null);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else if (AIOPokeGreatMoveView.this.C) {
                AIOPokeGreatMoveView.this.f191457e.setImageDrawable(AIOPokeGreatMoveView.this.E);
            } else {
                AIOPokeGreatMoveView.this.f191457e.setImageBitmap(AIOPokeGreatMoveView.this.D);
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface f {
        void a(long j3, boolean z16, Runnable runnable);
    }

    /* loaded from: classes11.dex */
    interface g {
        void end();
    }

    /* loaded from: classes11.dex */
    public static class h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f191468a;

        /* renamed from: b, reason: collision with root package name */
        public int f191469b;

        /* renamed from: c, reason: collision with root package name */
        public long f191470c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f191471d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f191472e;

        public h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public AIOPokeGreatMoveView(Context context) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.P.a(this.M.getMsgId(), this.C, new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.y
            @Override // java.lang.Runnable
            public final void run() {
                AIOPokeGreatMoveView.this.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(final int i3) {
        WeakReference<Context> weakReference = this.I;
        if (weakReference == null) {
            return;
        }
        Context context = weakReference.get();
        if (!(context instanceof Activity)) {
            return;
        }
        final Activity activity = (Activity) context;
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.x
            @Override // java.lang.Runnable
            public final void run() {
                AIOPokeGreatMoveView.this.y(activity, i3);
            }
        });
    }

    private void F() {
        WeakReference<Context> weakReference = this.I;
        if (weakReference == null) {
            return;
        }
        Context context = weakReference.get();
        if (!(context instanceof Activity)) {
            return;
        }
        final Activity activity = (Activity) context;
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.z
            @Override // java.lang.Runnable
            public final void run() {
                AIOPokeGreatMoveView.z(activity);
            }
        });
    }

    private AnimationSet s(int i3) {
        AnimationSet animationSet = new AnimationSet(false);
        int[] iArr = {80, 120, 120, 120, 120, 80, 80, 80};
        int i16 = i3 * 0;
        int[] iArr2 = {i3 * 5, i3 * (-12), i3 * 15, i3 * (-15), i3 * 12, i3 * (-8), i3 * 6, i16};
        int i17 = i3 * 1;
        int[] iArr3 = {i17, i3 * (-3), i3 * 2, i3 * (-2), i17, i3 * (-1), i17, i16};
        long j3 = 0;
        for (int i18 = 0; i18 < 8; i18++) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, com.tencent.mobileqq.utils.x.a(iArr2[i18]), 0.0f, com.tencent.mobileqq.utils.x.a(iArr3[i18]));
            translateAnimation.setDuration(iArr[i18]);
            translateAnimation.setStartOffset(j3);
            animationSet.addAnimation(translateAnimation);
            j3 += iArr[i18];
        }
        return animationSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(Activity activity, int i3) {
        if (!activity.isDestroyed() && !activity.isFinishing()) {
            ae.f191631a.A(activity, s(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(Activity activity) {
        View findViewById;
        if (!activity.isDestroyed() && !activity.isFinishing() && (findViewById = ((ViewGroup) activity.getWindow().getDecorView()).getChildAt(0).findViewById(R.id.tua)) != null) {
            findViewById.clearAnimation();
        }
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        int dip2px = ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(142.0f);
        int dip2px2 = (int) (ScreenUtil.SCREEN_WIDTH - (ScreenUtil.dip2px(142.0f) * this.H));
        if (dip2px2 < 0) {
            dip2px2 = dip2px / 2;
        }
        float f16 = (dip2px2 * 1.0f) / dip2px;
        ValueAnimator valueAnimator = this.f191461m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f191461m.removeAllListeners();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(dip2px2, -ScreenUtil.dip2px(80.0f));
        this.f191461m = ofInt;
        ofInt.addUpdateListener(new b());
        if (this.J == null) {
            this.J = new e();
        }
        this.f191461m.addListener(this.J);
        this.f191461m.setDuration(f16 * 600.0f);
        this.f191461m.setTarget(this.f191457e);
        this.f191461m.setInterpolator(new LinearInterpolator());
    }

    public void C(PokeMsgItem pokeMsgItem, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, pokeMsgItem, Boolean.valueOf(z16));
            return;
        }
        if (pokeMsgItem.r2() && GreatMoveCombolEffectView.M) {
            GreatMoveCombolEffectView greatMoveCombolEffectView = (GreatMoveCombolEffectView) ((ViewGroup) ((Activity) this.I.get()).getWindow().getDecorView()).getChildAt(0).findViewById(R.id.vsn);
            if (greatMoveCombolEffectView != null) {
                greatMoveCombolEffectView.l(pokeMsgItem.getMsgId(), this);
                return;
            }
            return;
        }
        h hVar = pokeMsgItem.unlimitedState;
        this.F = hVar;
        hVar.f191471d = true;
        hVar.f191472e = false;
        if (QLog.isColorLevel()) {
            QLog.d("fangdazhao", 2, "[" + this.F.f191468a + "," + this.F.f191470c + "," + this.F.f191469b + "]");
        }
        int i16 = this.F.f191468a;
        if (i16 < 23) {
            this.f191457e.setImageResource(0);
            this.f191458f.setImageDrawable(null);
            this.f191459h.r(this.F.f191468a);
            this.f191461m.cancel();
            this.f191457e.setImageDrawable(null);
            this.f191459h.s(new c());
            this.f191459h.p();
            return;
        }
        if (i16 < 29) {
            this.f191458f.setImageDrawable(null);
            if (this.C) {
                this.f191457e.setImageDrawable(this.E);
            } else {
                this.f191457e.setImageBitmap(this.D);
            }
            this.f191459h.r(this.F.f191468a);
            if (this.F.f191470c == -1) {
                this.f191461m.start();
            } else {
                this.f191461m.start();
                this.f191461m.setCurrentPlayTime(this.F.f191470c);
            }
            this.f191459h.s(null);
            this.f191459h.p();
            return;
        }
        int intValue = ((Integer) this.f191461m.getAnimatedValue()).intValue();
        if (intValue > 0) {
            if (this.C) {
                this.f191457e.setImageDrawable(this.E);
            } else {
                this.f191457e.setImageBitmap(this.D);
            }
            this.f191461m.start();
            this.f191461m.setCurrentPlayTime(this.F.f191470c);
            return;
        }
        if (intValue <= 0 && (i3 = this.F.f191469b) >= 0 && i3 < 9) {
            this.f191457e.setImageResource(0);
            this.f191458f.setImageDrawable(this.f191460i);
            this.f191460i.x(new d());
            this.f191460i.u(z16);
            this.f191460i.r(this.F.f191469b);
            this.f191460i.p();
            return;
        }
        this.f191456d.setImageDrawable(null);
        this.f191457e.setImageResource(0);
        this.f191458f.setImageDrawable(this.f191460i);
        g gVar = this.Q;
        if (gVar != null) {
            gVar.end();
            if (this.N) {
                ((IAIOHapticApi) com.tencent.qqnt.aio.adapter.a.b(IAIOHapticApi.class)).stopEffect(this.L);
            }
            this.L = 0;
        }
        h hVar2 = this.F;
        hVar2.f191471d = false;
        hVar2.f191472e = true;
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("placeholder", 2, "SHOW_PLACEHOLDER Unlimited");
        }
        h hVar = this.F;
        hVar.f191468a = 0;
        hVar.f191469b = 0;
        hVar.f191470c = 0L;
        hVar.f191471d = true;
        hVar.f191472e = false;
        this.f191456d.setImageDrawable(this.f191459h);
        this.f191457e.setImageDrawable(null);
        this.f191458f.setImageDrawable(null);
        this.f191459h.y();
        if (this.N) {
            this.L = ((IAIOHapticApi) com.tencent.qqnt.aio.adapter.a.b(IAIOHapticApi.class)).playEffect(this.K, 2);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.poke.GreatMoveCombolEffectView.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        h hVar = this.F;
        hVar.f191472e = true;
        hVar.f191471d = false;
        F();
        g gVar = this.Q;
        if (gVar != null) {
            gVar.end();
        }
    }

    public void setEndListener(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) gVar);
        } else {
            this.Q = gVar;
        }
    }

    public void setMirror(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        if (this.C == z16) {
            return;
        }
        this.C = z16;
        if (z16) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f191456d.getLayoutParams();
            layoutParams.addRule(9, -1);
            layoutParams.addRule(11, 0);
            this.f191456d.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f191458f.getLayoutParams();
            layoutParams2.addRule(9, 0);
            layoutParams2.addRule(11, -1);
            this.f191458f.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f191457e.getLayoutParams();
            layoutParams3.addRule(9, 0);
            layoutParams3.addRule(11, -1);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = com.tencent.mobileqq.utils.x.a(100.0f);
            this.f191457e.setLayoutParams(layoutParams3);
        } else {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f191456d.getLayoutParams();
            layoutParams4.addRule(9, 0);
            layoutParams4.addRule(11, -1);
            this.f191456d.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f191458f.getLayoutParams();
            layoutParams5.addRule(9, -1);
            layoutParams5.addRule(11, 0);
            this.f191458f.setLayoutParams(layoutParams5);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f191457e.getLayoutParams();
            layoutParams6.addRule(9, -1);
            layoutParams6.addRule(11, 0);
            layoutParams6.rightMargin = 0;
            layoutParams6.leftMargin = com.tencent.mobileqq.utils.x.a(100.0f);
            this.f191457e.setLayoutParams(layoutParams6);
        }
        this.f191459h.u(z16);
        this.f191460i.u(z16);
    }

    public void setParams(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        if (z16) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f191456d.getLayoutParams();
            layoutParams.addRule(9, -1);
            layoutParams.addRule(11, 0);
            layoutParams.height = (int) (ScreenUtil.dip2px(90.0f) * this.H);
            layoutParams.width = (int) (ScreenUtil.dip2px(90.0f) * this.H);
            this.f191456d.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f191458f.getLayoutParams();
            layoutParams2.addRule(9, 0);
            layoutParams2.addRule(11, -1);
            layoutParams2.height = (int) (ScreenUtil.dip2px(90.0f) * this.H);
            layoutParams2.width = (int) (ScreenUtil.dip2px(90.0f) * this.H);
            this.f191458f.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f191457e.getLayoutParams();
            layoutParams3.addRule(9, 0);
            layoutParams3.addRule(11, -1);
            layoutParams3.height = (int) (ScreenUtil.dip2px(34.0f) * this.H);
            layoutParams3.width = (int) (ScreenUtil.dip2px(48.0f) * this.H);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = com.tencent.mobileqq.utils.x.a(100.0f);
            this.f191457e.setLayoutParams(layoutParams3);
        } else {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f191456d.getLayoutParams();
            layoutParams4.addRule(9, 0);
            layoutParams4.addRule(11, -1);
            layoutParams4.height = (int) (ScreenUtil.dip2px(90.0f) * this.H);
            layoutParams4.width = (int) (ScreenUtil.dip2px(90.0f) * this.H);
            this.f191456d.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f191458f.getLayoutParams();
            layoutParams5.addRule(9, -1);
            layoutParams5.addRule(11, 0);
            layoutParams5.height = (int) (ScreenUtil.dip2px(90.0f) * this.H);
            layoutParams5.width = (int) (ScreenUtil.dip2px(90.0f) * this.H);
            this.f191458f.setLayoutParams(layoutParams5);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f191457e.getLayoutParams();
            layoutParams6.addRule(9, -1);
            layoutParams6.addRule(11, 0);
            layoutParams6.height = (int) (ScreenUtil.dip2px(34.0f) * this.H);
            layoutParams6.width = (int) (ScreenUtil.dip2px(48.0f) * this.H);
            layoutParams6.rightMargin = 0;
            layoutParams6.leftMargin = com.tencent.mobileqq.utils.x.a(100.0f);
            this.f191457e.setLayoutParams(layoutParams6);
        }
        B();
    }

    public CustomFrameAnimationDrawable t() {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (CustomFrameAnimationDrawable) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        String str = af.J3 + "/dazhao/dazhao2_motion/dazhao2_motion_";
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inMutable = true;
        try {
            bitmap = BaseImageUtil.decodeFileWithBufferedStream(str + "01.png", options);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("UnlimitedBladeWorks", 2, e16.toString());
            }
            bitmap = null;
        }
        CustomFrameAnimationDrawable customFrameAnimationDrawable = new CustomFrameAnimationDrawable(getResources(), bitmap, ae.f191631a.l());
        customFrameAnimationDrawable.i();
        int i3 = 0;
        while (i3 < 23) {
            int i16 = i3 + 1;
            if (i16 < 10) {
                customFrameAnimationDrawable.g(i3, 40, str + "0" + i16 + ".png");
            } else {
                customFrameAnimationDrawable.g(i3, 40, str + i16 + ".png");
            }
            i3 = i16;
        }
        customFrameAnimationDrawable.v();
        customFrameAnimationDrawable.w();
        return customFrameAnimationDrawable;
    }

    public CustomFrameAnimationDrawable u() {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (CustomFrameAnimationDrawable) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        String str = af.J3 + "/dazhao/daozhao_motion/dazhao_motion_";
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inMutable = true;
        try {
            bitmap = BaseImageUtil.decodeFileWithBufferedStream(str + "01.png", options);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("UnlimitedBladeWorks", 2, e16.toString());
            }
            bitmap = null;
        }
        CustomFrameAnimationDrawable customFrameAnimationDrawable = new CustomFrameAnimationDrawable(getResources(), bitmap, ae.f191631a.l());
        customFrameAnimationDrawable.i();
        int i3 = 0;
        while (i3 < 29) {
            int i16 = i3 + 1;
            if (i16 < 10) {
                customFrameAnimationDrawable.g(i3, 40, str + "0" + i16 + ".png");
            } else {
                customFrameAnimationDrawable.g(i3, 40, str + i16 + ".png");
            }
            i3 = i16;
        }
        customFrameAnimationDrawable.v();
        customFrameAnimationDrawable.w();
        return customFrameAnimationDrawable;
    }

    public void v(Context context, boolean z16, boolean z17, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, Boolean.valueOf(z16), Boolean.valueOf(z17), fVar);
            return;
        }
        this.N = z17;
        this.f191456d = (ImageView) findViewById(R.id.dob);
        this.f191457e = (ImageView) findViewById(R.id.a4r);
        this.f191458f = (ImageView) findViewById(R.id.ab9);
        this.f191459h = u();
        this.f191460i = t();
        this.f191456d.setImageDrawable(this.f191459h);
        this.C = z16;
        this.f191459h.u(z16);
        this.f191457e.clearAnimation();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inMutable = true;
        try {
            this.D = BaseImageUtil.decodeFileWithBufferedStream(af.K3, options);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("UnlimitedBladeWorks", 2, e16.toString());
            }
            this.D = null;
        }
        Bitmap bitmap = this.D;
        if (bitmap != null) {
            this.E = ae.j(bitmap);
        }
        this.I = new WeakReference<>(context);
        setParams(this.C);
        if (z17) {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeGreatMoveView.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOPokeGreatMoveView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((IAIOHapticApi) com.tencent.qqnt.aio.adapter.a.b(IAIOHapticApi.class)).addEffects();
                    }
                }
            }, null, true);
        }
        this.J = new e();
        this.f191459h.s(new a());
        this.P = fVar;
        this.G = true;
    }

    public void w(PokeMsgItem pokeMsgItem, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, pokeMsgItem, Float.valueOf(f16));
            return;
        }
        this.M = pokeMsgItem;
        this.F = pokeMsgItem.unlimitedState;
        this.H = f16;
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.G;
    }

    public AIOPokeGreatMoveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public AIOPokeGreatMoveView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.C = false;
        this.D = null;
        this.E = null;
        this.G = false;
        this.K = "chat_item_for_qqultnew";
        this.N = false;
        this.Q = null;
        LayoutInflater.from(context).inflate(R.layout.f167617dw3, (ViewGroup) this, true);
    }
}
