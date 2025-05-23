package com.tencent.mobileqq.activity.miniaio;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e extends com.tencent.mobileqq.widget.f implements View.OnTouchListener, ValueAnimator.AnimatorUpdateListener, IMiniMsgUnreadCallback {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private float I;
    private float J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int P;
    private int Q;
    private View.OnClickListener R;
    private int S;
    private int T;
    ValueAnimator U;

    /* renamed from: d, reason: collision with root package name */
    private WindowManager.LayoutParams f183473d;

    /* renamed from: e, reason: collision with root package name */
    private WindowManager f183474e;

    /* renamed from: f, reason: collision with root package name */
    private Activity f183475f;

    /* renamed from: h, reason: collision with root package name */
    private View f183476h;

    /* renamed from: i, reason: collision with root package name */
    private final GestureDetector f183477i;

    /* renamed from: m, reason: collision with root package name */
    private int f183478m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (e.this.R != null) {
                e.this.R.onClick(e.this.f183476h);
                return true;
            }
            return false;
        }
    }

    public e(Activity activity, int i3, int i16, int i17, int i18, int i19, int i26, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), onClickListener);
            return;
        }
        this.f183475f = activity;
        this.E = i3;
        this.F = i16;
        this.S = i17;
        this.T = i18;
        this.P = i19;
        this.Q = i26;
        Context baseContext = BaseApplicationImpl.getApplication().getBaseContext();
        j(baseContext);
        this.R = onClickListener;
        this.f183477i = new GestureDetector(baseContext, new a());
    }

    private void g() {
        if (this.U == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.U = ofFloat;
            ofFloat.setDuration(200L);
            this.U.addListener(this);
            this.U.addUpdateListener(this);
        }
        this.U.start();
    }

    private boolean h(Activity activity) {
        if (!activity.isDestroyed() && !activity.isFinishing()) {
            return false;
        }
        return true;
    }

    @NonNull
    private Context j(Context context) {
        this.D = ImmersiveUtils.getStatusBarHeight(this.f183475f);
        int i3 = context.getResources().getDisplayMetrics().widthPixels;
        int i16 = context.getResources().getDisplayMetrics().heightPixels;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.f159144wq);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.f159145wr);
        int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.f159143wp);
        int dpToPx = ViewUtils.dpToPx(56.0f);
        this.G = i3;
        this.M = dimensionPixelSize;
        this.N = i16 - dimensionPixelSize3;
        int i17 = i3 - (dimensionPixelSize * 4);
        int dip2px = this.D + ViewUtils.dip2px(7.0f);
        int i18 = (i3 - dpToPx) - this.M;
        int i19 = i16 - dimensionPixelSize2;
        int i26 = this.P;
        if (i26 != -1) {
            this.f183478m = i26;
            this.C = this.Q;
        } else if (this.F != 0) {
            this.f183478m = i17;
            this.C = dip2px;
        } else {
            this.f183478m = i18;
            this.C = i19;
        }
        return context;
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        ValueAnimator valueAnimator = this.U;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            this.U.cancel();
        }
        if (this.H) {
            this.H = false;
            this.f183474e.removeViewImmediate(this.f183476h);
        }
        this.f183475f = null;
        this.f183476h = null;
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void hide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (this.H) {
            this.f183476h.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void hideUnread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (this.H) {
            this.f183476h.findViewById(R.id.ewt).setVisibility(8);
        }
    }

    public int[] i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (int[]) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        WindowManager.LayoutParams layoutParams = this.f183473d;
        if (layoutParams == null) {
            return null;
        }
        int[] iArr = new int[2];
        if (layoutParams != null) {
            iArr[0] = layoutParams.x;
            iArr[1] = layoutParams.y;
        }
        return iArr;
    }

    public void k(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (!this.H) {
            return;
        }
        int i17 = this.D;
        if (i16 < i17) {
            i16 = i17;
        }
        int i18 = this.N;
        if (i16 > i18) {
            i16 = i18;
        }
        int i19 = this.M;
        if (i3 < i19) {
            i3 = i19;
        }
        int i26 = this.f183478m;
        if (i3 > i26) {
            i3 = i26;
        }
        WindowManager.LayoutParams layoutParams = this.f183473d;
        layoutParams.y = i16;
        layoutParams.x = i3;
        this.f183474e.updateViewLayout(view, layoutParams);
    }

    public void l(Configuration configuration, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, configuration, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Activity activity = this.f183475f;
        if (activity != null && this.f183476h != null) {
            this.P = i3;
            this.Q = i16;
            j(activity);
            k(this.f183476h, this.P, this.Q);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) animator);
        }
    }

    @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) animator);
        }
    }

    @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this, (Object) animator);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) valueAnimator);
            return;
        }
        if (h(this.f183475f)) {
            return;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int i3 = this.f183478m;
        int i16 = this.K;
        if (i16 < this.G / 2) {
            i3 = this.M;
        }
        int i17 = i16 + ((int) ((i3 - i16) * floatValue));
        QLog.d("mini_msg_FloatViewManager", 2, "onAnimationUpdate .curPx = " + i17 + " ,mTouchUpX = " + this.K);
        k(this.f183476h, i17, this.L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0043, code lost:
    
        if (r4 != 3) goto L27;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        ValueAnimator valueAnimator = this.U;
        boolean z16 = false;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return false;
        }
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        boolean onTouchEvent = this.f183477i.onTouchEvent(motionEvent);
        if (this.F != 0) {
            return onTouchEvent;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    k(view, (int) (rawX - this.I), (int) (rawY - this.J));
                }
            }
            k(view, (int) (rawX - this.I), (int) (rawY - this.J));
            this.K = (int) (rawX - this.I);
            this.L = (int) (rawY - this.J);
            this.J = 0.0f;
            this.I = 0.0f;
            z16 = true;
        } else {
            this.I = motionEvent.getX();
            this.J = motionEvent.getY();
        }
        if (!onTouchEvent && z16) {
            g();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public boolean show(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        if (!this.f183475f.hasWindowFocus() || this.f183475f.isFinishing() || this.f183475f.isDestroyed()) {
            return false;
        }
        Activity activity = this.f183475f;
        if (QLog.isColorLevel()) {
            QLog.d("mini_msg_FloatViewManager", 2, "styleType = " + this.F + ",filterType = " + this.E);
        }
        if (this.f183476h == null) {
            View inflate = View.inflate(activity.getApplicationContext(), R.layout.f168284s8, null);
            this.f183476h = inflate;
            inflate.setOnTouchListener(this);
            RelativeLayout relativeLayout = (RelativeLayout) this.f183476h.findViewById(R.id.ewr);
            ImageView imageView = (ImageView) this.f183476h.findViewById(R.id.ews);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            if (this.F != 0) {
                int dpToPx = ViewUtils.dpToPx(38.0f);
                int dpToPx2 = ViewUtils.dpToPx(32.0f);
                layoutParams.width = dpToPx;
                layoutParams.height = dpToPx2;
                int dpToPx3 = ViewUtils.dpToPx(24.0f);
                layoutParams2.width = dpToPx3;
                layoutParams2.height = dpToPx3;
                layoutParams2.leftMargin = ViewUtils.dpToPx(4.0f);
                imageView.setPadding(0, 0, 0, 0);
                imageView.setBackgroundDrawable(null);
                if (this.S == 2 && (i16 = this.T) != 0) {
                    imageView.setImageResource(i16);
                } else {
                    imageView.setImageResource(R.drawable.qui_message_selector);
                }
                imageView.setColorFilter(imageView.getContext().getColor(R.color.qui_common_icon_nav_secondary));
            }
            if (AppSetting.f99565y) {
                AccessibilityUtil.e(this.f183476h, false);
                this.f183476h.setImportantForAccessibility(1);
                this.f183476h.setFocusable(true);
                this.f183476h.setFocusableInTouchMode(true);
            }
            this.f183474e = (WindowManager) activity.getApplicationContext().getSystemService("window");
            this.f183473d = new WindowManager.LayoutParams();
            if (QLog.isColorLevel()) {
                QLog.d("mini_msg_FloatViewManager", 2, "is activity window focused " + activity.hasWindowFocus());
            }
            int i17 = activity.getResources().getDisplayMetrics().heightPixels;
            if (this.P != -1 && this.F != 0 && this.Q == -1 && ScreenUtil.isNavigationBarExist(activity)) {
                this.C = (i17 - activity.getResources().getDimensionPixelSize(R.dimen.f159145wr)) - ScreenUtil.getNavigationBarHeight(activity);
            }
            int i18 = this.f183478m;
            int i19 = this.C;
            WindowManager.LayoutParams layoutParams3 = this.f183473d;
            layoutParams3.type = 1002;
            layoutParams3.format = 1;
            layoutParams3.flags = 40;
            layoutParams3.gravity = 51;
            layoutParams3.x = i18;
            layoutParams3.y = i19;
            layoutParams3.width = -2;
            layoutParams3.height = -2;
            layoutParams3.token = activity.getWindow().getDecorView().getWindowToken();
            try {
                this.f183474e.addView(this.f183476h, this.f183473d);
                this.H = true;
            } catch (WindowManager.BadTokenException e16) {
                QLog.e("mini_msg_FloatViewManager", 1, "show: ", e16);
            }
        }
        if (this.H) {
            this.f183476h.setVisibility(0);
        }
        updateUnreadCount(i3, false);
        return this.H;
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void updateOnBackFromMiniAIO(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
    public void updateUnreadCount(int i3, boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (this.H) {
            this.f183476h.setVisibility(0);
            View findViewById = this.f183476h.findViewById(R.id.ewt);
            if (findViewById instanceof QUIBadge) {
                QUIBadge qUIBadge = (QUIBadge) findViewById;
                if (!z16 && i3 > 0) {
                    qUIBadge.setVisibility(0);
                }
                qUIBadge.setDragType(-1);
                qUIBadge.setRedNum(i3);
            } else {
                TextView textView = (TextView) findViewById;
                String valueOf = String.valueOf(i3);
                if (i3 > 99) {
                    valueOf = "99+";
                }
                textView.setText(valueOf);
                if (!z16 && i3 > 0) {
                    textView.setVisibility(0);
                }
                com.tencent.qqnt.miniaio.e.f359478a.a(textView, i3);
            }
            if (AppSetting.f99565y) {
                if (i3 > 0) {
                    str = String.format("\u53ef\u70b9\u51fb\u67e5\u770b%d\u6761\u6d88\u606f", Integer.valueOf(i3));
                } else {
                    str = "\u53ef\u70b9\u51fb\u67e5\u770b\u6d88\u606f";
                }
                AccessibilityUtil.s(this.f183476h, str);
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            onAnimationEnd(animator);
        } else {
            iPatchRedirector.redirect((short) 4, this, animator, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            onAnimationStart(animator);
        } else {
            iPatchRedirector.redirect((short) 3, this, animator, Boolean.valueOf(z16));
        }
    }
}
