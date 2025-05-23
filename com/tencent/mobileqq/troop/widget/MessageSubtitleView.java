package com.tencent.mobileqq.troop.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: P */
@TargetApi(11)
/* loaded from: classes19.dex */
public class MessageSubtitleView extends RelativeLayout {
    static IPatchRedirector $redirector_;
    protected static int C;
    protected static int D;
    protected static int E;

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<TextView> f302343d;

    /* renamed from: e, reason: collision with root package name */
    int f302344e;

    /* renamed from: f, reason: collision with root package name */
    protected Queue<CharSequence> f302345f;

    /* renamed from: h, reason: collision with root package name */
    private Handler f302346h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f302347i;

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f302348m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        boolean f302349d;

        /* renamed from: e, reason: collision with root package name */
        int f302350e;

        public a(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MessageSubtitleView.this, Boolean.valueOf(z16), Integer.valueOf(i3));
            } else {
                this.f302349d = z16;
                this.f302350e = i3;
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
            if (this.f302349d) {
                if (this.f302350e == MessageSubtitleView.D) {
                    MessageSubtitleView.this.k();
                }
                if (!MessageSubtitleView.this.f302345f.isEmpty()) {
                    MessageSubtitleView.this.f();
                }
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
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76838);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        C = 1;
        D = 2;
        E = 3;
    }

    public MessageSubtitleView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f302343d = new ArrayList<>(4);
        this.f302344e = 0;
        this.f302345f = new LinkedList();
        this.f302347i = new Runnable() { // from class: com.tencent.mobileqq.troop.widget.MessageSubtitleView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MessageSubtitleView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    MessageSubtitleView.this.f();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        this.f302348m = new Runnable() { // from class: com.tencent.mobileqq.troop.widget.MessageSubtitleView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MessageSubtitleView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    MessageSubtitleView.this.e();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        j(context);
    }

    private void d(int i3, int i16) {
        boolean z16;
        Animator animator;
        if (i3 >= 0 && i3 < this.f302343d.size()) {
            TextView textView = this.f302343d.get(i3);
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i16 == C) {
                animator = i(textView);
            } else if (i16 == D) {
                animator = h(textView);
            } else if (i16 == E) {
                animator = g(textView);
            } else {
                animator = null;
            }
            if (animator != null) {
                animator.setInterpolator(new AccelerateInterpolator(0.2f));
                animator.addListener(new a(z16, i16));
                animator.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ArrayList<TextView> arrayList = this.f302343d;
        if (arrayList != null && arrayList.size() != 0) {
            for (int i3 = 0; i3 < this.f302343d.size(); i3++) {
                d(i3, D);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f302343d.size() > 3) {
            this.f302346h.removeCallbacks(this.f302348m);
            e();
            return;
        }
        if (this.f302343d.size() == 3) {
            this.f302346h.removeCallbacks(this.f302348m);
            e();
        }
        c();
        if (this.f302343d.size() == 1) {
            this.f302346h.removeCallbacks(this.f302348m);
            this.f302346h.postDelayed(this.f302348m, 8000L);
        }
    }

    private ObjectAnimator g(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    private ObjectAnimator h(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "translationY", textView.getTranslationY(), textView.getTranslationY() - this.f302344e);
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    private AnimatorSet i(TextView textView) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(g(textView)).with(h(textView));
        return animatorSet;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!this.f302345f.isEmpty() && this.f302343d.size() <= 3) {
            Context context = getContext();
            CharSequence poll = this.f302345f.poll();
            TextView textView = new TextView(context);
            textView.setShadowLayer(3.0f, 3.0f, 3.0f, R.color.f156964ga);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setSingleLine(true);
            textView.setTextSize(18.0f);
            textView.setTextColor(-1);
            textView.setTag(Long.valueOf(System.currentTimeMillis()));
            textView.setTranslationY(0.0f);
            textView.setText(poll);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(R.dimen.ayd), context.getResources().getDimensionPixelSize(R.dimen.ayb));
            layoutParams.topMargin = this.f302343d.size() * this.f302344e;
            addView(textView, layoutParams);
            this.f302343d.add(textView);
            if (this.f302343d.size() == 4) {
                d(this.f302343d.size() - 1, C);
            } else {
                d(this.f302343d.size() - 1, E);
            }
        }
    }

    void j(Context context) {
        this.f302346h = new Handler(context.getMainLooper());
        this.f302344e = context.getResources().getDimensionPixelSize(R.dimen.ayb);
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ArrayList<TextView> arrayList = this.f302343d;
        if (arrayList != null && arrayList.size() != 0) {
            int i3 = 0;
            while (i3 < this.f302343d.size()) {
                TextView textView = this.f302343d.get(i3);
                float y16 = textView.getY();
                if (y16 < 0.0f) {
                    removeView(textView);
                    this.f302343d.remove(textView);
                    i3--;
                } else if (y16 == 0.0f) {
                    long currentTimeMillis = 8200 - (System.currentTimeMillis() - ((Long) this.f302343d.get(0).getTag()).longValue());
                    if (currentTimeMillis <= 0) {
                        currentTimeMillis = 1000;
                    }
                    this.f302346h.removeCallbacks(this.f302348m);
                    this.f302346h.postDelayed(this.f302348m, currentTimeMillis);
                }
                i3++;
            }
        }
    }

    public MessageSubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302343d = new ArrayList<>(4);
        this.f302344e = 0;
        this.f302345f = new LinkedList();
        this.f302347i = new Runnable() { // from class: com.tencent.mobileqq.troop.widget.MessageSubtitleView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MessageSubtitleView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    MessageSubtitleView.this.f();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        this.f302348m = new Runnable() { // from class: com.tencent.mobileqq.troop.widget.MessageSubtitleView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MessageSubtitleView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    MessageSubtitleView.this.e();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        j(context);
    }
}
