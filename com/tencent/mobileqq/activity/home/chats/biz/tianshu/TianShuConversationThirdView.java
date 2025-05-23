package com.tencent.mobileqq.activity.home.chats.biz.tianshu;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.armap.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TianShuConversationThirdView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private boolean f182980d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f182981e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f182982f;

    /* renamed from: h, reason: collision with root package name */
    public d f182983h;

    /* renamed from: i, reason: collision with root package name */
    public volatile d f182984i;

    /* renamed from: m, reason: collision with root package name */
    private a f182985m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        void a(float f16, float f17);
    }

    public TianShuConversationThirdView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f182982f = false;
        setBackgroundColor(0);
        setViewVisibility(false);
    }

    @NonNull
    private ViewGroup.LayoutParams d(int i3, int i16) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        }
        layoutParams.width = i3;
        layoutParams.height = i16;
        return layoutParams;
    }

    public void a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        ViewGroup.LayoutParams d16 = d(i3, i16);
        if (d16 instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) d16;
            layoutParams.startToStart = 0;
            layoutParams.endToEnd = 0;
        }
        setLayoutParams(d16);
        QLog.i("TianShuConversationThirdView", 1, "adjustBreathLightLayoutParam  | width = " + i3 + " | height = " + i16);
    }

    public void b(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        ViewGroup.LayoutParams d16 = d(i3, i16);
        if (d16 instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) d16).endToEnd = 0;
        }
        setLayoutParams(d16);
        QLog.i("TianShuConversationThirdView", 1, "adjustPendantLayoutParam  | width = " + i3 + " | height = " + i16);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        setShowLight(false);
        this.f182984i = null;
        QLog.i("TianShuConversationThirdView", 1, "dismissBreathLight");
    }

    public void e(d dVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar);
            return;
        }
        this.f182984i = dVar;
        if (dVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        setShowLight(z16);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z16;
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.f182980d && (dVar = this.f182983h) != null && dVar.b(canvas)) {
            invalidate();
        }
        if (this.f182981e && this.f182984i != null) {
            if (this.f182984i != null && this.f182984i.b(canvas)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.f182980d) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (action == 1) {
            QLog.d("TianShuConversationThirdView", 1, "onTouchEvent debug click event  | x = " + motionEvent.getX() + " | y = " + motionEvent.getY());
            if (this.f182985m != null && (dVar = this.f182983h) != null && dVar.j(0) != null && this.f182983h.j(0).contains(motionEvent.getX(), motionEvent.getY())) {
                this.f182985m.a(motionEvent.getX(), motionEvent.getY());
            }
        }
        return onTouchEvent;
    }

    public void setOnPendentClickListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.f182985m = aVar;
        }
    }

    public void setPendantHolder(d dVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) dVar);
            return;
        }
        this.f182983h = dVar;
        if (dVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        setShowPendent(z16);
        QLog.i("TianShuConversationThirdView", 1, "setPendantHolder  pendantHolder = " + dVar);
        invalidate();
    }

    public void setShowLight(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        this.f182981e = z16;
        setViewVisibility(z16);
        QLog.i("TianShuConversationThirdView", 1, "setShowLight  showLight = " + z16);
    }

    public void setShowPendent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        this.f182980d = z16;
        setViewVisibility(z16);
        QLog.i("TianShuConversationThirdView", 1, "setShowPendent  showPendent = " + z16);
    }

    public void setViewVisibility(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (!z16) {
            TianShuManager.getInstance().clearAdShowStatus(341);
            TianShuManager.getInstance().clearAdShowStatus(339);
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
    }
}
