package com.tencent.mobileqq.qqlive.trtc.render;

import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.trtc.engine.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes17.dex */
public class TRTCRenderCtrl implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final c f273352a;

    /* renamed from: b, reason: collision with root package name */
    private TXCloudVideoView f273353b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<ViewGroup> f273354c;

    public TRTCRenderCtrl(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
        } else {
            this.f273352a = cVar;
        }
    }

    private void c() {
        Context context = this.f273352a.f273307b.get();
        if (context == null) {
            QLog.e("TRTCRenderCtrl", 1, "getTRTCPreview failed!");
        }
        if (this.f273353b == null) {
            TXCloudVideoView tXCloudVideoView = new TXCloudVideoView(context);
            this.f273353b = tXCloudVideoView;
            tXCloudVideoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(WeakReference<ViewGroup> weakReference) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        if (this.f273353b == null) {
            c();
        }
        WeakReference<ViewGroup> weakReference2 = this.f273354c;
        if (weakReference2 != null && (viewGroup2 = weakReference2.get()) != null) {
            viewGroup2.removeView(this.f273353b);
        }
        this.f273354c = weakReference;
        if (weakReference != null && (viewGroup = weakReference.get()) != null) {
            viewGroup.addView(this.f273353b);
        }
    }

    private boolean f() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    private boolean g(WeakReference<ViewGroup> weakReference) {
        if (weakReference != null && weakReference.get() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.render.a
    public void a(WeakReference<ViewGroup> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) weakReference);
            return;
        }
        if (this.f273354c == null && weakReference == null) {
            return;
        }
        if (f()) {
            d(weakReference);
        } else {
            ThreadManager.getUIHandler().post(new Runnable(weakReference) { // from class: com.tencent.mobileqq.qqlive.trtc.render.TRTCRenderCtrl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ WeakReference f273355d;

                {
                    this.f273355d = weakReference;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TRTCRenderCtrl.this, (Object) weakReference);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TRTCRenderCtrl.this.d(this.f273355d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.render.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (g(this.f273354c) && this.f273353b != null) {
            this.f273354c.get().removeView(this.f273353b);
            this.f273353b = null;
            this.f273354c = null;
        }
    }

    public TXCloudVideoView e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TXCloudVideoView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f273353b;
    }
}
