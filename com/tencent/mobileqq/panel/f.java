package com.tencent.mobileqq.panel;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.aio.event.ShortCutBarEvent;
import com.tencent.mobileqq.aio.event.ShortcutEventIntent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f implements EmotionPanelListView.PullAndFastScrollListener, com.tencent.qqnt.aio.shortcutbar.g, d {
    static IPatchRedirector $redirector_;
    public static int E;
    protected RelativeLayout C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    protected int f257169d;

    /* renamed from: e, reason: collision with root package name */
    protected int f257170e;

    /* renamed from: f, reason: collision with root package name */
    private float f257171f;

    /* renamed from: h, reason: collision with root package name */
    private int f257172h;

    /* renamed from: i, reason: collision with root package name */
    protected QQAppInterface f257173i;

    /* renamed from: m, reason: collision with root package name */
    protected com.tencent.aio.api.runtime.a f257174m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
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
            f fVar = f.this;
            h.c(fVar.f257174m, intValue - fVar.f257169d);
        }
    }

    public f(QQAppInterface qQAppInterface, com.tencent.aio.api.runtime.a aVar, RelativeLayout relativeLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, aVar, relativeLayout);
            return;
        }
        this.f257170e = 0;
        this.D = true;
        this.f257173i = qQAppInterface;
        this.f257174m = aVar;
        this.C = relativeLayout;
    }

    private void b(int i3, String str) {
        int a16 = h.a(this.f257174m);
        int i16 = this.f257169d;
        int i17 = (a16 - i16) + (-i3);
        int i18 = i16 + i17;
        int i19 = E;
        if (i18 > i19) {
            i16 = i19;
        } else if (i18 >= i16) {
            i16 = i18;
        }
        QLog.d("RichTextPanelExtendHelper", 4, str + ": offset:" + i17 + ", target:" + i16);
        if (i16 != a16) {
            AbstractGifImage.pauseAll();
            QLog.d("RichTextPanelExtendHelper", 4, str + ": Final offset=" + (i16 - this.f257169d));
            h.c(this.f257174m, i16 - this.f257169d);
        }
    }

    private int e() {
        com.tencent.mobileqq.aio.event.h hVar = (com.tencent.mobileqq.aio.event.h) this.f257174m.e().k(new ShortcutEventIntent.OnGetIconBarHeightIntent());
        if (hVar != null) {
            return hVar.a();
        }
        return 0;
    }

    private void f() {
        if (this.f257173i.getApp().getResources().getConfiguration().orientation == 2) {
            QLog.d("RichTextPanelExtendHelper", 2, "devices on ORIENTATION_LANDSCAPE");
            E = (int) (this.f257169d * 1.1d);
        } else {
            QLog.d("RichTextPanelExtendHelper", 2, "devices on ORIENTATION_PORTRAIT");
            E = (int) (this.f257173i.getApp().getResources().getDisplayMetrics().heightPixels * 0.6d);
        }
        int i3 = this.f257169d;
        if (i3 > E) {
            E = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(int i3, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (intValue == i3) {
            AbstractGifImage.resumeAll();
        }
        h.c(this.f257174m, intValue - this.f257169d);
    }

    protected void c(int i3, final int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i3, i16);
        ofInt.setDuration(150L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.panel.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.j(i16, valueAnimator);
            }
        });
        ofInt.start();
    }

    protected void d(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i16, i17);
        ofInt.setDuration(i3);
        ofInt.addUpdateListener(new a());
        ofInt.start();
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener
    public void followHand(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent);
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.f257169d = h.b(this.f257174m);
        QLog.e("RichTextPanelExtendHelper", 2, "originPanelHeight has value is " + this.f257169d);
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (h.a(this.f257174m) == this.f257169d) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        if (r0 != 3) goto L35;
     */
    @Override // com.tencent.qqnt.aio.shortcutbar.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleTouchEvent(MotionEvent motionEvent) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean z16 = false;
        if (!k()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                b((int) ((motionEvent.getY() - this.f257171f) + 0.5f), "TouchEvent");
            }
            return true;
        }
        int a16 = h.a(this.f257174m);
        int i16 = E;
        if (a16 != i16 && a16 != (i3 = this.f257169d)) {
            int i17 = this.f257172h;
            if (a16 <= i17) {
                i16 = i3;
            }
            if (Math.abs(a16 - i17) > 100) {
                z16 = true;
            }
            if (!z16) {
                i16 = this.f257172h;
            }
            c(a16, i16);
        } else {
            AbstractGifImage.resumeAll();
        }
        return true;
    }

    boolean i() {
        if (this.f257174m != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.shortcutbar.g
    public boolean interceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!k()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                if (this.C.getParent() == null) {
                    return false;
                }
                this.C.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
            float y16 = motionEvent.getY();
            int i3 = (int) ((y16 - this.f257171f) + 0.5f);
            if (!i() || Math.abs(i3) <= e() * 0.6f) {
                return false;
            }
            this.f257171f = y16;
            return true;
        }
        this.f257171f = motionEvent.getY();
        this.f257172h = h.a(this.f257174m);
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener
    public boolean isPanelOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (h.a(this.f257174m) == E) {
            return true;
        }
        return false;
    }

    protected boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (E > this.f257169d && i()) {
            return true;
        }
        return false;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (i()) {
            this.f257170e = h.a(this.f257174m);
            if (this.f257169d != E) {
                h.c(this.f257174m, 0);
            }
        }
    }

    public void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        if (i()) {
            if (QLog.isColorLevel()) {
                QLog.d("RichTextPanelExtendHelper", 2, "onHide. openSoftInput: " + z16 + " mOriginPanelHeight: " + this.f257169d + " mOldPanelHeight: " + this.f257170e);
            }
            this.f257170e = 0;
            if (this.D) {
                this.f257174m.e().h(new ShortCutBarEvent.SetShortcutInterceptListener(null));
            }
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (i()) {
            if (QLog.isColorLevel()) {
                QLog.d("RichTextPanelExtendHelper", 2, "onShow.");
            }
            this.f257170e = 0;
            g();
            f();
            if (this.D) {
                this.f257174m.e().h(new ShortCutBarEvent.SetShortcutInterceptListener(this));
            }
        }
    }

    public void o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.D = z16;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener, com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
    public void onPullDown() {
        int a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (k() && (a16 = h.a(this.f257174m)) == E) {
            d(250, a16, this.f257169d);
            if (QLog.isColorLevel()) {
                QLog.d("RichTextPanelExtendHelper", 2, "onPullDown");
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener
    public void onPullUp() {
        int a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (k() && (a16 = h.a(this.f257174m)) == this.f257169d) {
            d(150, a16, E);
            if (QLog.isColorLevel()) {
                QLog.d("RichTextPanelExtendHelper", 2, "onPullUp");
            }
        }
    }
}
