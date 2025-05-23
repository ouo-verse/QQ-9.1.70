package com.tencent.qqcamerakit.capture;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CameraObservable extends com.tencent.qqcamerakit.common.c {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public Handler f344789c;

    public CameraObservable(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) handler);
        } else if (handler != null) {
            this.f344789c = handler;
        } else {
            this.f344789c = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.tencent.qqcamerakit.common.c
    public void b(int i3, int i16, String str, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, objArr);
            return;
        }
        Handler handler = this.f344789c;
        if (handler != null) {
            handler.post(new Runnable(i3, i16, str, objArr) { // from class: com.tencent.qqcamerakit.capture.CameraObservable.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f344790d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f344791e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f344792f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Object[] f344793h;

                {
                    this.f344790d = i3;
                    this.f344791e = i16;
                    this.f344792f = str;
                    this.f344793h = objArr;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, CameraObservable.this, Integer.valueOf(i3), Integer.valueOf(i16), str, objArr);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        CameraObservable.super.b(this.f344790d, this.f344791e, this.f344792f, this.f344793h);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }
}
