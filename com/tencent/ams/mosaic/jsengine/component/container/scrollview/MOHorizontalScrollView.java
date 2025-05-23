package com.tencent.ams.mosaic.jsengine.component.container.scrollview;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MOHorizontalScrollView extends HorizontalScrollView implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private c f71101d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f71102e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f71103f;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MOHorizontalScrollView.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (MOHorizontalScrollView.this.f71101d != null) {
                MOHorizontalScrollView.this.f71101d.onScrollStop(MOHorizontalScrollView.this);
            }
        }
    }

    public MOHorizontalScrollView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f71103f = new a(Looper.getMainLooper());
        }
    }

    private void b() {
        if (!this.f71102e) {
            this.f71103f.removeMessages(0);
            this.f71103f.sendEmptyMessageDelayed(0, 100L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            this.f71102e = true;
        } else if (motionEvent.getAction() == 1) {
            this.f71102e = false;
            b();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.scrollview.b
    @NonNull
    public ViewGroup getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onScrollChanged(i3, i16, i17, i18);
        c cVar = this.f71101d;
        if (cVar != null) {
            cVar.onScrollChange(this, i3, i16, i17, i18);
        }
        b();
    }

    public void setOnScrollChangeListener(@Nullable c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.f71101d = cVar;
        }
    }
}
