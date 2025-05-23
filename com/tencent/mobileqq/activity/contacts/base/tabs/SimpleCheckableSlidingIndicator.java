package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.AbsSlidingIndicator;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.util.MqqWeakReferenceHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SimpleCheckableSlidingIndicator extends SimpleSlidingIndicator {
    static IPatchRedirector $redirector_;

    /* renamed from: q0, reason: collision with root package name */
    public static int f181533q0;

    /* renamed from: r0, reason: collision with root package name */
    public static int f181534r0;

    /* renamed from: s0, reason: collision with root package name */
    public static int f181535s0;

    /* renamed from: t0, reason: collision with root package name */
    static int f181536t0;

    /* renamed from: m0, reason: collision with root package name */
    private MqqWeakReferenceHandler f181537m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f181538n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f181539o0;

    /* renamed from: p0, reason: collision with root package name */
    Handler.Callback f181540p0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SimpleCheckableSlidingIndicator.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            ((AbsSlidingIndicator) SimpleCheckableSlidingIndicator.this).V = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            SimpleCheckableSlidingIndicator.this.invalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements Handler.Callback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SimpleCheckableSlidingIndicator.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            if (message.what == SimpleCheckableSlidingIndicator.f181536t0) {
                if (SimpleCheckableSlidingIndicator.this.getScrollX() == SimpleCheckableSlidingIndicator.this.f181538n0) {
                    SimpleCheckableSlidingIndicator.this.f181539o0 = SimpleCheckableSlidingIndicator.f181533q0;
                    SimpleCheckableSlidingIndicator.A(SimpleCheckableSlidingIndicator.this);
                    SimpleCheckableSlidingIndicator.this.f181537m0.removeMessages(SimpleCheckableSlidingIndicator.f181536t0);
                    return false;
                }
                SimpleCheckableSlidingIndicator.this.f181539o0 = SimpleCheckableSlidingIndicator.f181535s0;
                SimpleCheckableSlidingIndicator.A(SimpleCheckableSlidingIndicator.this);
                SimpleCheckableSlidingIndicator simpleCheckableSlidingIndicator = SimpleCheckableSlidingIndicator.this;
                simpleCheckableSlidingIndicator.f181538n0 = simpleCheckableSlidingIndicator.getScrollX();
                SimpleCheckableSlidingIndicator.this.f181537m0.sendEmptyMessageDelayed(SimpleCheckableSlidingIndicator.f181536t0, 50L);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface d {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68054);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f181533q0 = 0;
        f181534r0 = 1;
        f181535s0 = 2;
        f181536t0 = 1;
    }

    public SimpleCheckableSlidingIndicator(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        this.f181538n0 = V2TXJSAdapterConstants.EVT_ID_SDK_VERSION;
        this.f181539o0 = f181533q0;
        this.f181540p0 = new b();
    }

    static /* bridge */ /* synthetic */ d A(SimpleCheckableSlidingIndicator simpleCheckableSlidingIndicator) {
        simpleCheckableSlidingIndicator.getClass();
        return null;
    }

    @Override // com.tencent.mobileqq.widget.SimpleSlidingIndicator, com.tencent.mobileqq.widget.AbsSlidingIndicator
    protected void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        int i3 = this.f315362h;
        int i16 = this.f315361f;
        if (i3 != i16) {
            View childAt = this.f315359d.getChildAt(i3);
            View childAt2 = this.f315359d.getChildAt(this.f315361f);
            if (childAt != null && childAt2 != null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(childAt.getLeft(), childAt2.getLeft());
                ofInt.setDuration(200L);
                ofInt.addUpdateListener(new a());
                ofInt.start();
                return;
            }
            if (childAt2 != null) {
                this.V = childAt2.getLeft();
                invalidate();
                return;
            }
            return;
        }
        this.V = this.f315359d.getChildAt(i16).getLeft();
        invalidate();
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator, android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.f181539o0 = f181534r0;
                MqqWeakReferenceHandler mqqWeakReferenceHandler = this.f181537m0;
                if (mqqWeakReferenceHandler != null) {
                    mqqWeakReferenceHandler.removeMessages(f181536t0);
                }
            }
        } else {
            MqqWeakReferenceHandler mqqWeakReferenceHandler2 = this.f181537m0;
            if (mqqWeakReferenceHandler2 != null) {
                mqqWeakReferenceHandler2.sendEmptyMessage(f181536t0);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator
    protected void s(int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        int i16 = this.f315361f;
        if (i16 != i3) {
            this.f315362h = i16;
            this.f315361f = i3;
            r(i3);
            q(this.f315361f);
            if (z16) {
                d();
            } else {
                View childAt = this.f315359d.getChildAt(this.f315361f);
                if (childAt != null) {
                    this.V = childAt.getLeft();
                }
                invalidate();
            }
            AbsSlidingIndicator.f fVar = this.L;
            if (fVar != null && i3 >= 0) {
                fVar.I0(i3, z17);
            }
        }
    }

    public void setOnRepeatClickListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
        }
    }

    public void setScrollViewListener(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) dVar);
        } else if (this.f181537m0 == null) {
            this.f181537m0 = new MqqWeakReferenceHandler(this.f181540p0);
        }
    }

    public SimpleCheckableSlidingIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f181538n0 = V2TXJSAdapterConstants.EVT_ID_SDK_VERSION;
        this.f181539o0 = f181533q0;
        this.f181540p0 = new b();
    }

    public SimpleCheckableSlidingIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f181538n0 = V2TXJSAdapterConstants.EVT_ID_SDK_VERSION;
        this.f181539o0 = f181533q0;
        this.f181540p0 = new b();
    }
}
