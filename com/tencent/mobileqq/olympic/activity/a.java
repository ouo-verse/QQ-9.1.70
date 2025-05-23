package com.tencent.mobileqq.olympic.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private LayoutInflater f255141a;

    /* renamed from: b, reason: collision with root package name */
    private Resources f255142b;

    /* renamed from: c, reason: collision with root package name */
    private ViewConfiguration f255143c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f255144d;

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f255145e;

    /* renamed from: f, reason: collision with root package name */
    private h f255146f;

    /* renamed from: g, reason: collision with root package name */
    private ViewGroup f255147g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f255148h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.olympic.activity.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class ViewOnTouchListenerC8178a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private float f255149d;

        /* renamed from: e, reason: collision with root package name */
        private float f255150e;

        /* renamed from: f, reason: collision with root package name */
        private long f255151f;

        ViewOnTouchListenerC8178a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (a.this.f255147g != null) {
                l lVar = (l) a.this.f255147g.getTag(R.id.f164434xl);
                m mVar = (m) a.this.f255147g.getTag();
                if (lVar != null && mVar != null) {
                    float x16 = motionEvent.getX();
                    float y16 = motionEvent.getY();
                    int action = motionEvent.getAction();
                    if (action != 0) {
                        if (action != 1) {
                            if (action != 2) {
                                if (action == 3) {
                                    this.f255149d = 0.0f;
                                    this.f255150e = 0.0f;
                                    this.f255151f = 0L;
                                    mVar.f255177a.setPressed(false);
                                }
                            } else if (lVar.f255164a == 1 && lVar.f255165b == 2) {
                                float f16 = x16 - this.f255149d;
                                float f17 = y16 - this.f255150e;
                                if (((float) Math.sqrt((f16 * f16) + (f17 * f17))) >= a.this.f255143c.getScaledTouchSlop()) {
                                    mVar.f255177a.setPressed(false);
                                }
                            }
                        } else {
                            float f18 = x16 - this.f255149d;
                            float f19 = y16 - this.f255150e;
                            float sqrt = (float) Math.sqrt((f18 * f18) + (f19 * f19));
                            long currentTimeMillis = System.currentTimeMillis() - this.f255151f;
                            if (sqrt < a.this.f255143c.getScaledTouchSlop()) {
                                if (lVar.f255165b == 2) {
                                    a.this.f255144d.removeMessages(101);
                                    a.this.f255144d.obtainMessage(101).sendToTarget();
                                    j jVar = lVar.f255170g;
                                    if (jVar != null) {
                                        jVar.a();
                                    }
                                }
                            } else if (sqrt > a.this.f255143c.getScaledTouchSlop() && f19 > 50.0f && ((float) currentTimeMillis) < 300.0f && lVar.f255164a == 1) {
                                a.this.f255144d.removeMessages(101);
                                a.this.f255144d.obtainMessage(101).sendToTarget();
                            }
                            this.f255149d = 0.0f;
                            this.f255150e = 0.0f;
                            this.f255151f = 0L;
                            mVar.f255177a.setPressed(false);
                        }
                    } else {
                        this.f255149d = x16;
                        this.f255150e = y16;
                        this.f255151f = System.currentTimeMillis();
                        if (lVar.f255164a == 1 && lVar.f255165b == 2) {
                            mVar.f255177a.setPressed(true);
                        }
                    }
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l f255153d;

        b(l lVar) {
            this.f255153d = lVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) lVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                a.this.f255144d.removeMessages(101);
                a.this.f255144d.obtainMessage(101).sendToTarget();
                i iVar = this.f255153d.f255174k;
                if (iVar != null) {
                    iVar.onContentClick();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l f255155d;

        c(l lVar) {
            this.f255155d = lVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) lVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f255155d.f255174k.a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (a.this.f255147g != null) {
                a.this.f255147g.setAlpha(floatValue);
                a.this.f255147g.setTranslationY((1.0f - floatValue) * BaseAIOUtils.f(25.0f, a.this.f255142b));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else if (a.this.f255147g != null) {
                a.this.f255147g.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f255159d;

        f(View view) {
            this.f255159d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) view);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f255159d.setAlpha(1.0f - floatValue);
            this.f255159d.setTranslationY(floatValue * BaseAIOUtils.f(25.0f, a.this.f255142b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class g extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f255161d;

        g(View view) {
            this.f255161d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) view);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                a.this.f255145e.removeView(this.f255161d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface h {
        void onVisibleChanged(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface i {
        void a();

        void onContentClick();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface j {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class k extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<a> f255163a;

        public k(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            } else {
                this.f255163a = new WeakReference<>(aVar);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            a aVar = this.f255163a.get();
            if (aVar == null) {
                return;
            }
            int i3 = message.what;
            if (i3 == 100) {
                aVar.h((l) message.obj);
            } else if (i3 == 101) {
                aVar.n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class l {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f255164a;

        /* renamed from: b, reason: collision with root package name */
        public int f255165b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f255166c;

        /* renamed from: d, reason: collision with root package name */
        public String f255167d;

        /* renamed from: e, reason: collision with root package name */
        public String f255168e;

        /* renamed from: f, reason: collision with root package name */
        public String f255169f;

        /* renamed from: g, reason: collision with root package name */
        public j f255170g;

        /* renamed from: h, reason: collision with root package name */
        public int f255171h;

        /* renamed from: i, reason: collision with root package name */
        public String f255172i;

        /* renamed from: j, reason: collision with root package name */
        public String f255173j;

        /* renamed from: k, reason: collision with root package name */
        public i f255174k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f255175l;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            } else {
                this.f255175l = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class m {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ViewGroup f255177a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f255178b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f255179c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f255180d;

        /* renamed from: e, reason: collision with root package name */
        public ARTipsCircleProgress f255181e;

        /* renamed from: f, reason: collision with root package name */
        public ViewGroup f255182f;

        /* renamed from: g, reason: collision with root package name */
        public ViewGroup f255183g;

        /* renamed from: h, reason: collision with root package name */
        public TextView f255184h;

        /* renamed from: i, reason: collision with root package name */
        public TextView f255185i;

        /* renamed from: j, reason: collision with root package name */
        public ViewGroup f255186j;

        /* renamed from: k, reason: collision with root package name */
        public TextView f255187k;

        /* renamed from: l, reason: collision with root package name */
        public View f255188l;

        /* renamed from: m, reason: collision with root package name */
        public TextView f255189m;

        /* renamed from: n, reason: collision with root package name */
        public TextView f255190n;

        /* renamed from: o, reason: collision with root package name */
        public ImageView f255191o;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }
    }

    public a(Context context, RelativeLayout relativeLayout, h hVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, relativeLayout, hVar, Boolean.valueOf(z16));
            return;
        }
        this.f255141a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f255142b = context.getResources();
        this.f255143c = ViewConfiguration.get(context);
        this.f255144d = new k(this);
        this.f255145e = relativeLayout;
        this.f255146f = hVar;
        this.f255148h = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(l lVar) {
        if (this.f255147g == null) {
            this.f255147g = j();
        }
        ViewGroup viewGroup = this.f255147g;
        if (viewGroup != null) {
            viewGroup.setTag(R.id.f164434xl, lVar);
            m mVar = (m) this.f255147g.getTag();
            if (mVar != null) {
                int i3 = lVar.f255165b;
                if (i3 != 1 && i3 != 2 && i3 != 3) {
                    if (i3 != 10 && i3 != 11) {
                        if (i3 == 12) {
                            mVar.f255177a.setVisibility(8);
                            mVar.f255182f.setVisibility(8);
                            mVar.f255188l.setVisibility(0);
                        }
                    } else {
                        mVar.f255177a.setVisibility(8);
                        mVar.f255188l.setVisibility(8);
                        mVar.f255182f.setVisibility(0);
                        if (lVar.f255175l) {
                            mVar.f255191o.setVisibility(0);
                        } else {
                            mVar.f255191o.setVisibility(4);
                        }
                        mVar.f255184h.setText(lVar.f255172i);
                        mVar.f255185i.setText(lVar.f255173j);
                        mVar.f255183g.setOnClickListener(new b(lVar));
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mVar.f255182f.getLayoutParams();
                        if (i3 != 10) {
                            if (i3 == 11) {
                                mVar.f255186j.setVisibility(0);
                                mVar.f255187k.setOnClickListener(new c(lVar));
                                layoutParams.bottomMargin = BaseAIOUtils.f(0.0f, this.f255142b);
                            }
                        } else {
                            mVar.f255186j.setVisibility(8);
                            layoutParams.bottomMargin = BaseAIOUtils.f(20.0f, this.f255142b);
                        }
                        mVar.f255182f.setLayoutParams(layoutParams);
                    }
                } else {
                    mVar.f255177a.setVisibility(0);
                    mVar.f255182f.setVisibility(8);
                    mVar.f255188l.setVisibility(8);
                    mVar.f255178b.setText(lVar.f255167d);
                    if (TextUtils.isEmpty(lVar.f255168e)) {
                        mVar.f255179c.setVisibility(8);
                        mVar.f255178b.setTextSize(1, 16.0f);
                    } else {
                        mVar.f255179c.setVisibility(0);
                        mVar.f255179c.setText(lVar.f255168e);
                        mVar.f255178b.setTextSize(1, 20.0f);
                    }
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                mVar.f255180d.setVisibility(8);
                                mVar.f255181e.setVisibility(0);
                                mVar.f255181e.setProgress(lVar.f255171h);
                                mVar.f255177a.setEnabled(false);
                            }
                        } else {
                            mVar.f255180d.setVisibility(0);
                            mVar.f255181e.setVisibility(8);
                            mVar.f255180d.setText(lVar.f255169f);
                            mVar.f255177a.setEnabled(true);
                        }
                    } else {
                        mVar.f255180d.setVisibility(8);
                        mVar.f255181e.setVisibility(8);
                        mVar.f255177a.setEnabled(false);
                    }
                }
                if (this.f255147g.getParent() == null) {
                    i();
                }
                if (lVar.f255166c) {
                    this.f255144d.removeMessages(101);
                    this.f255144d.sendMessageDelayed(this.f255144d.obtainMessage(101), 5000L);
                }
            }
        }
    }

    private void i() {
        if (QLog.isColorLevel()) {
            QLog.d("ARTipsManager", 2, "addTipsWithAnim");
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12, -1);
        if (this.f255148h) {
            layoutParams.bottomMargin = BaseAIOUtils.f(100.0f, this.f255142b);
        }
        this.f255145e.addView(this.f255147g, layoutParams);
        this.f255147g.setVisibility(4);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat.addUpdateListener(new d());
        ofFloat.addListener(new e());
        ofFloat.start();
        h hVar = this.f255146f;
        if (hVar != null) {
            hVar.onVisibleChanged(true);
        }
    }

    private ViewGroup j() {
        if (QLog.isColorLevel()) {
            QLog.d("ARTipsManager", 2, "createTipsView");
        }
        ViewGroup viewGroup = (ViewGroup) this.f255141a.inflate(R.layout.f167659di, (ViewGroup) null);
        if (viewGroup != null) {
            m mVar = new m();
            mVar.f255177a = (ViewGroup) viewGroup.findViewById(R.id.f164435xm);
            mVar.f255178b = (TextView) viewGroup.findViewById(R.id.f164439xq);
            mVar.f255179c = (TextView) viewGroup.findViewById(R.id.f164437xo);
            mVar.f255180d = (TextView) viewGroup.findViewById(R.id.f164436xn);
            mVar.f255181e = (ARTipsCircleProgress) viewGroup.findViewById(R.id.f164438xp);
            mVar.f255182f = (ViewGroup) viewGroup.findViewById(R.id.f164423xa);
            mVar.f255183g = (ViewGroup) viewGroup.findViewById(R.id.f164425xc);
            mVar.f255184h = (TextView) viewGroup.findViewById(R.id.f164427xe);
            mVar.f255185i = (TextView) viewGroup.findViewById(R.id.f164426xd);
            mVar.f255186j = (ViewGroup) viewGroup.findViewById(R.id.f164428xf);
            mVar.f255187k = (TextView) viewGroup.findViewById(R.id.f164429xg);
            mVar.f255188l = viewGroup.findViewById(R.id.f164430xh);
            mVar.f255189m = (TextView) viewGroup.findViewById(R.id.f164431xi);
            mVar.f255190n = (TextView) viewGroup.findViewById(R.id.f164433xk);
            mVar.f255191o = (ImageView) viewGroup.findViewById(R.id.f164424xb);
            viewGroup.setTag(mVar);
            viewGroup.setOnTouchListener(new ViewOnTouchListenerC8178a());
        }
        return viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (QLog.isColorLevel()) {
            QLog.d("ARTipsManager", 2, "removeTipsWithAnim");
        }
        ViewGroup viewGroup = this.f255147g;
        if (viewGroup != null) {
            this.f255147g = null;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(400L);
            ofFloat.addUpdateListener(new f(viewGroup));
            ofFloat.addListener(new g(viewGroup));
            ofFloat.start();
            h hVar = this.f255146f;
            if (hVar != null) {
                hVar.onVisibleChanged(false);
            }
        }
    }

    private void o(int i3, int i16, String str, String str2, i iVar, boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("ARTipsManager", 2, String.format("showBaike tag=%s type=%s title=%s content=%s listener=%s autoRemove=%s", Integer.valueOf(i3), Integer.valueOf(i16), str, str2, iVar, Boolean.valueOf(z16)));
        }
        l lVar = new l();
        lVar.f255164a = i3;
        lVar.f255165b = i16;
        lVar.f255166c = z16;
        lVar.f255172i = str;
        lVar.f255173j = str2;
        lVar.f255174k = iVar;
        lVar.f255175l = z17;
        this.f255144d.removeMessages(101);
        Message obtainMessage = this.f255144d.obtainMessage(100);
        obtainMessage.obj = lVar;
        obtainMessage.sendToTarget();
    }

    private void q(int i3, int i16, String str, String str2, String str3, j jVar, int i17, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", Integer.valueOf(i3), Integer.valueOf(i16), str, str2, str3, jVar, Integer.valueOf(i17), Boolean.valueOf(z16)));
        }
        l lVar = new l();
        lVar.f255164a = i3;
        lVar.f255165b = i16;
        lVar.f255166c = z16;
        lVar.f255167d = str;
        lVar.f255168e = str2;
        lVar.f255169f = str3;
        lVar.f255170g = jVar;
        lVar.f255171h = i17;
        this.f255144d.removeMessages(101);
        Message obtainMessage = this.f255144d.obtainMessage(100);
        obtainMessage.obj = lVar;
        obtainMessage.sendToTarget();
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ARTipsManager", 2, String.format("dismissTips", new Object[0]));
        }
        this.f255144d.removeMessages(100);
        if (this.f255147g != null) {
            this.f255144d.obtainMessage(101).sendToTarget();
        }
    }

    public int l() {
        l lVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        ViewGroup viewGroup = this.f255147g;
        if (viewGroup != null && (lVar = (l) viewGroup.getTag(R.id.f164434xl)) != null) {
            return lVar.f255164a;
        }
        return 0;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        ViewGroup viewGroup = this.f255147g;
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void p(String str, String str2, i iVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, str2, iVar, Boolean.valueOf(z16));
        } else {
            o(0, 10, str, str2, iVar, false, z16);
        }
    }

    public void r(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
        } else {
            q(i3, 1, str, null, null, null, 0, true);
        }
    }

    public void s(int i3, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, Boolean.valueOf(z16));
        } else {
            q(i3, 1, str, null, null, null, 0, z16);
        }
    }

    public void t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            r(0, str);
        }
    }

    public void u(int i3, String str, String str2, String str3, j jVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), str, str2, str3, jVar, Boolean.valueOf(z16));
        } else {
            q(i3, 2, str, str2, str3, jVar, 0, z16);
        }
    }

    public void v(String str, String str2, j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, jVar);
        } else {
            w(str, str2, jVar, false);
        }
    }

    public void w(String str, String str2, j jVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, jVar, Boolean.valueOf(z16));
        } else {
            u(0, str, null, str2, jVar, z16);
        }
    }

    public void x(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3);
        } else {
            q(0, 3, str, null, null, null, i3, false);
        }
    }
}
