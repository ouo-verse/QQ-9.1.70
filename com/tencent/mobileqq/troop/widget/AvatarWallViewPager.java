package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.be;
import com.tencent.mobileqq.utils.ViewUtils;
import java.lang.reflect.Field;

/* loaded from: classes19.dex */
public class AvatarWallViewPager extends RelativeLayout {
    static IPatchRedirector $redirector_;
    protected boolean C;
    protected float D;
    protected float E;
    protected float F;
    protected float G;
    private boolean H;
    private boolean I;
    protected int J;
    protected ViewPager.SimpleOnPageChangeListener K;
    protected Handler L;

    /* renamed from: d, reason: collision with root package name */
    protected int f302273d;

    /* renamed from: e, reason: collision with root package name */
    protected Context f302274e;

    /* renamed from: f, reason: collision with root package name */
    protected RollViewPager f302275f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f302276h;

    /* renamed from: i, reason: collision with root package name */
    protected LinearLayout f302277i;

    /* renamed from: m, reason: collision with root package name */
    protected c f302278m;

    /* loaded from: classes19.dex */
    public class RollViewPager extends ViewPager {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f302279d;

        public RollViewPager(AvatarWallViewPager avatarWallViewPager, Context context) {
            this(context, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) avatarWallViewPager, (Object) context);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
        
            if (r5 != 261) goto L43;
         */
        @Override // android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
            }
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            float abs = Math.abs(x16 - AvatarWallViewPager.this.F);
            float abs2 = Math.abs(y16 - AvatarWallViewPager.this.G);
            int action = motionEvent.getAction();
            if (action != 0) {
                boolean z16 = false;
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                        }
                    } else {
                        if (this.f302279d <= 1) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        } else {
                            if (abs < abs2 && Math.abs(y16 - AvatarWallViewPager.this.E) > AvatarWallViewPager.this.f302273d) {
                                getParent().requestDisallowInterceptTouchEvent(false);
                            } else {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            if (abs > abs2 && Math.abs(x16 - AvatarWallViewPager.this.D) > AvatarWallViewPager.this.f302273d) {
                                z16 = super.dispatchTouchEvent(motionEvent);
                            } else {
                                requestDisallowInterceptTouchEvent(false);
                            }
                        }
                        AvatarWallViewPager avatarWallViewPager = AvatarWallViewPager.this;
                        avatarWallViewPager.F = x16;
                        avatarWallViewPager.G = y16;
                    }
                    return z16;
                }
                requestDisallowInterceptTouchEvent(false);
                boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                float abs3 = Math.abs(x16 - AvatarWallViewPager.this.D);
                AvatarWallViewPager avatarWallViewPager2 = AvatarWallViewPager.this;
                if (abs3 < avatarWallViewPager2.f302273d) {
                    float abs4 = Math.abs(y16 - avatarWallViewPager2.E);
                    AvatarWallViewPager avatarWallViewPager3 = AvatarWallViewPager.this;
                    if (abs4 < avatarWallViewPager3.f302273d && avatarWallViewPager3.f302276h) {
                        requestDisallowInterceptTouchEvent(false);
                        AvatarWallViewPager.this.performClick();
                        AvatarWallViewPager.this.e();
                        return z16;
                    }
                }
                z16 = dispatchTouchEvent;
                AvatarWallViewPager.this.e();
                return z16;
            }
            AvatarWallViewPager.this.getClass();
            throw null;
        }

        @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
            }
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException e16) {
                be.b("avatarWallViewPager", "ote_pointerindex_out_of_range", e16.toString(), "", "", "");
                e16.printStackTrace();
                return false;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException e16) {
                be.b("avatarWallViewPager", "te_pointerindex_out_of_range", e16.toString(), "", "", "");
                e16.printStackTrace();
                return false;
            }
        }

        public RollViewPager(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, AvatarWallViewPager.this, context, attributeSet);
        }
    }

    /* loaded from: classes19.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AvatarWallViewPager.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (!AvatarWallViewPager.this.H && AvatarWallViewPager.this.I) {
                AvatarWallViewPager.this.getClass();
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes19.dex */
    public class b extends Scroller {
        static IPatchRedirector $redirector_;

        public b(Context context, Interpolator interpolator) {
            super(context, interpolator);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AvatarWallViewPager.this, context, interpolator);
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                declaredField.set(AvatarWallViewPager.this.f302275f, this);
                declaredField.setAccessible(false);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // android.widget.Scroller
        public void startScroll(int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                super.startScroll(i3, i16, i17, i18, 500);
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            }
        }

        @Override // android.widget.Scroller
        public void startScroll(int i3, int i16, int i17, int i18, int i19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                super.startScroll(i3, i16, i17, i18, 500);
            } else {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes19.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f302283d;

        protected c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AvatarWallViewPager.this);
            } else {
                this.f302283d = 0;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener = AvatarWallViewPager.this.K;
            if (simpleOnPageChangeListener != null) {
                simpleOnPageChangeListener.onPageScrollStateChanged(i3);
            }
            AvatarWallViewPager avatarWallViewPager = AvatarWallViewPager.this;
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            avatarWallViewPager.f302276h = z16;
            if (!z16) {
                return;
            }
            int currentItem = avatarWallViewPager.f302275f.getCurrentItem();
            AvatarWallViewPager avatarWallViewPager2 = AvatarWallViewPager.this;
            avatarWallViewPager2.J = currentItem;
            avatarWallViewPager2.getClass();
            throw null;
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
                return;
            }
            super.onPageScrolled(i3, f16, i16);
            ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener = AvatarWallViewPager.this.K;
            if (simpleOnPageChangeListener != null) {
                simpleOnPageChangeListener.onPageScrolled(i3, f16, i16);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                AvatarWallViewPager.this.getClass();
                throw null;
            }
        }
    }

    public AvatarWallViewPager(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    protected LinearLayout c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new LinearLayout(this.f302274e);
    }

    protected void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f302273d = ViewConfiguration.get(this.f302274e).getScaledTouchSlop();
        RollViewPager rollViewPager = new RollViewPager(this, this.f302274e);
        this.f302275f = rollViewPager;
        addView(rollViewPager, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = ViewUtils.dip2px(13.0f);
        layoutParams.bottomMargin = ViewUtils.dip2px(10.0f);
        LinearLayout c16 = c();
        this.f302277i = c16;
        c16.setBackgroundColor(getResources().getColor(17170445));
        this.f302277i.setGravity(5);
        addView(this.f302277i, layoutParams);
        c cVar = new c();
        this.f302278m = cVar;
        this.f302275f.setOnPageChangeListener(cVar);
        new b(this.f302274e, new LinearInterpolator()).a();
    }

    protected void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.H = false;
        if (this.I) {
            this.L.removeCallbacksAndMessages(null);
            Handler handler = this.L;
            handler.sendMessageDelayed(handler.obtainMessage(), 4000L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        this.I = true;
        if (!this.H) {
            this.L.removeCallbacksAndMessages(null);
            Handler handler = this.L;
            handler.sendMessageDelayed(handler.obtainMessage(), 4000L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        this.I = false;
        this.L.removeCallbacksAndMessages(null);
    }

    public void setAdapter(com.tencent.mobileqq.troop.widget.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar);
        }
    }

    public void setOnPageChangeListener(ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) simpleOnPageChangeListener);
        } else {
            this.K = simpleOnPageChangeListener;
        }
    }

    public AvatarWallViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302276h = true;
        this.C = false;
        this.H = true;
        this.I = false;
        this.L = new a(Looper.getMainLooper());
        this.f302274e = context;
        d();
    }
}
