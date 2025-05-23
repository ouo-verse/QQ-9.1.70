package com.tencent.biz.videostory.widget.easylyric;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SingleLyricView extends RelativeLayout implements com.tencent.biz.videostory.widget.easylyric.c {
    private int C;
    private com.tencent.mobileqq.lyric.data.d D;
    private AnimatorSet E;
    private long F;
    private String G;
    private long H;
    private boolean I;
    private String J;
    private int K;
    private Handler L;

    /* renamed from: d, reason: collision with root package name */
    private final String f97194d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.biz.videostory.widget.easylyric.d f97195e;

    /* renamed from: f, reason: collision with root package name */
    private final f f97196f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f97197h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f97198i;

    /* renamed from: m, reason: collision with root package name */
    private volatile com.tencent.mobileqq.lyric.data.b f97199m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (SingleLyricView.this.f97197h != null) {
                SingleLyricView.this.f97197h.setAlpha(floatValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f97206d;

        b(String str) {
            this.f97206d = str;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            if (SingleLyricView.this.f97197h != null) {
                SingleLyricView.this.f97197h.setText(this.f97206d);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (SingleLyricView.this.f97197h != null) {
                SingleLyricView.this.f97197h.setText(this.f97206d);
                SingleLyricView.this.f97197h.setAlpha(0.3f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z16) {
            SingleLyricView.this.f97197h.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (SingleLyricView.this.f97197h != null) {
                SingleLyricView.this.f97197h.setAlpha(floatValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            if (SingleLyricView.this.f97197h != null) {
                SingleLyricView.this.f97197h.setAlpha(1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            if (SingleLyricView.this.f97197h != null) {
                SingleLyricView.this.f97197h.setAlpha(1.0f);
            }
        }
    }

    public SingleLyricView(Context context) {
        this(context, null);
    }

    private void f(String str) {
        AnimatorSet animatorSet = this.E;
        if (animatorSet != null) {
            animatorSet.end();
        }
        this.E = new AnimatorSet();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(new a());
        ofFloat.addListener(new b(str));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.3f, 1.0f);
        ofFloat2.setDuration(500L);
        ofFloat2.addUpdateListener(new c());
        ofFloat2.addListener(new d());
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        ofFloat2.addListener(new e());
        this.E.playSequentially(ofFloat, ofFloat2);
        this.E.start();
    }

    private void g(AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SingleLyricView, i3, 0);
        try {
            this.K = obtainStyledAttributes.getInteger(R.styleable.SingleLyricView_lyric_type, 1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // com.tencent.biz.videostory.widget.easylyric.c
    public void a(long j3) {
        boolean z16;
        TextView textView;
        if (this.f97199m == null) {
            return;
        }
        com.tencent.mobileqq.lyric.data.d a16 = com.tencent.biz.videostory.widget.easylyric.e.b().a(this.f97199m, this.F + j3);
        boolean z17 = true;
        if (this.D != a16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!this.I || j3 >= this.H) {
            z17 = false;
        }
        if (a16 != null && z16 && !z17) {
            this.D = a16;
            f(a16.f243148a);
            this.J = a16.f243148a;
        } else if (z17 && !TextUtils.isEmpty(this.G) && !this.G.equals(this.J) && (textView = this.f97197h) != null) {
            textView.setText(this.G);
            this.J = this.G;
            this.D = null;
        }
    }

    public void e() {
        this.L.removeCallbacks(null);
        this.C = -1;
        this.f97199m = null;
        TextView textView = this.f97197h;
        if (textView != null) {
            textView.setText("");
            this.f97197h.setAlpha(1.0f);
        }
        AnimatorSet animatorSet = this.E;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.G = null;
        this.F = 0L;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f97195e.a(this);
        h.b().a(this.f97196f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h.b().f(this.f97196f);
        this.f97195e.b();
        AnimatorSet animatorSet = this.E;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.L.removeCallbacks(null);
    }

    public void setData(final String str, final String str2) {
        this.f97199m = null;
        this.L.post(new Runnable() { // from class: com.tencent.biz.videostory.widget.easylyric.SingleLyricView.7
            @Override // java.lang.Runnable
            public void run() {
                SingleLyricView.this.f97199m = com.tencent.biz.videostory.widget.easylyric.e.b().c(str, str2);
            }
        });
        this.F = 0L;
    }

    public void setPos(long j3) {
        if (j3 < 0) {
            j3 = 0;
        }
        this.F = j3;
    }

    public void setSongName(String str, long j3) {
        if (!TextUtils.isEmpty(str)) {
            this.G = str;
            TextView textView = this.f97197h;
            if (textView != null) {
                textView.setAlpha(1.0f);
                this.f97197h.setText(str);
            }
            this.I = true;
            if (j3 < 0) {
                j3 = 3000;
            }
            this.H = j3;
        }
    }

    public SingleLyricView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleLyricView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f97194d = "SingleLyricView";
        this.F = 0L;
        this.H = 0L;
        this.I = false;
        LayoutInflater.from(context).inflate(R.layout.f169175c35, (ViewGroup) this, true);
        g(attributeSet, i3);
        this.f97198i = (ImageView) findViewById(R.id.iwq);
        if (this.K == 1) {
            TextView textView = (TextView) findViewById(R.id.iwr);
            this.f97197h = textView;
            if (textView != null) {
                textView.setVisibility(0);
            }
            ImageView imageView = this.f97198i;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } else {
            TextView textView2 = (TextView) findViewById(R.id.j66);
            this.f97197h = textView2;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            ImageView imageView2 = this.f97198i;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        }
        this.f97195e = new com.tencent.biz.videostory.widget.easylyric.d();
        this.f97196f = new f() { // from class: com.tencent.biz.videostory.widget.easylyric.SingleLyricView.1
            @Override // com.tencent.biz.videostory.widget.easylyric.f
            public void a(final long j3) {
                SingleLyricView.this.post(new Runnable() { // from class: com.tencent.biz.videostory.widget.easylyric.SingleLyricView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SingleLyricView.this.f97195e.k(j3);
                    }
                });
            }

            @Override // com.tencent.biz.videostory.widget.easylyric.f
            public void onPlay() {
                SingleLyricView.this.f97195e.h();
            }

            @Override // com.tencent.biz.videostory.widget.easylyric.f
            public void onStop() {
                SingleLyricView.this.f97195e.j();
            }
        };
        this.L = new Handler(ThreadManagerV2.getSubThreadLooper());
    }
}
