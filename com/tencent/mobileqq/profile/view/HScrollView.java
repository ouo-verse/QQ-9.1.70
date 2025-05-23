package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class HScrollView extends HorizontalScrollView implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Handler f260389d;

    /* renamed from: e, reason: collision with root package name */
    private a f260390e;

    /* renamed from: f, reason: collision with root package name */
    private int f260391f;

    /* renamed from: h, reason: collision with root package name */
    private int f260392h;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a(int i3);
    }

    public HScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f260391f = V2TXJSAdapterConstants.EVT_ID_SDK_VERSION;
        this.f260392h = 1;
        this.f260389d = new Handler();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.f260392h = 2;
                this.f260390e.a(2);
                this.f260389d.removeCallbacks(this);
            }
        } else {
            this.f260389d.post(this);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (getScrollX() == this.f260391f) {
            this.f260392h = 1;
            a aVar = this.f260390e;
            if (aVar != null) {
                aVar.a(1);
            }
            this.f260389d.removeCallbacks(this);
            return;
        }
        this.f260392h = 3;
        a aVar2 = this.f260390e;
        if (aVar2 != null) {
            aVar2.a(3);
        }
        this.f260391f = getScrollX();
        this.f260389d.postDelayed(this, 50L);
    }

    public void setOnScrollListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f260390e = aVar;
        }
    }
}
