package com.tencent.mobileqq.qqlive.trtc.video.source.screen;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveScreenCaptureParams;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.utils.r;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class TRTCScreenCaptureSource extends com.tencent.mobileqq.qqlive.trtc.video.source.b implements c, b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private QQLiveScreenCaptureParams f273406f;

    /* renamed from: g, reason: collision with root package name */
    private a f273407g;

    public TRTCScreenCaptureSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273407g = null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.b, com.tencent.mobileqq.qqlive.trtc.video.source.a
    public synchronized void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        q();
        super.destroy();
        this.f273407g = null;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.c
    public void e(TRTCVideoQualityParams tRTCVideoQualityParams, QQLiveScreenCaptureParams qQLiveScreenCaptureParams) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tRTCVideoQualityParams, (Object) qQLiveScreenCaptureParams);
            return;
        }
        q();
        if (tRTCVideoQualityParams == null) {
            tRTCVideoQualityParams = this.f273399e;
        }
        this.f273399e = tRTCVideoQualityParams;
        this.f273406f = qQLiveScreenCaptureParams;
        Context context = this.f273397c.get();
        if (this.f273399e == null && context != null) {
            this.f273399e = r.f(context, true, true);
        }
        QLog.i("TRTCScreenCaptureSource", 1, "startScreenCapture.");
        this.f273396b.startScreenCapture(0, com.tencent.mobileqq.qqlive.trtc.utils.a.j(this.f273399e), com.tencent.mobileqq.qqlive.trtc.utils.a.h(this.f273406f));
        r();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.c
    public void g(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
        } else {
            this.f273407g = aVar;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.a
    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        QLog.i("TRTCScreenCaptureSource", 1, "onScreenCaptureResumed.");
        a aVar = this.f273407g;
        if (aVar == null) {
            QLog.i("TRTCScreenCaptureSource", 1, "onScreenCaptureResumed: listener==null. [Miss]");
        } else {
            com.tencent.mobileqq.qqlive.trtc.utils.c.a(this.f273398d, new Runnable(aVar, i3) { // from class: com.tencent.mobileqq.qqlive.trtc.video.source.screen.TRTCScreenCaptureSource.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ a f273415d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f273416e;

                {
                    this.f273415d = aVar;
                    this.f273416e = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TRTCScreenCaptureSource.this, aVar, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f273415d.h(this.f273416e);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.a
    public void k(int i3, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), str, bundle);
            return;
        }
        QLog.i("TRTCScreenCaptureSource", 1, "onScreenCaptureError: code " + i3 + ", msg " + str);
        stopScreenCapture();
        a aVar = this.f273407g;
        if (aVar == null) {
            QLog.i("TRTCScreenCaptureSource", 1, "onScreenCaptureError: listener==null. [Miss]");
        } else {
            com.tencent.mobileqq.qqlive.trtc.utils.c.a(this.f273398d, new Runnable(aVar, i3, str, bundle) { // from class: com.tencent.mobileqq.qqlive.trtc.video.source.screen.TRTCScreenCaptureSource.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ a f273408d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f273409e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f273410f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Bundle f273411h;

                {
                    this.f273408d = aVar;
                    this.f273409e = i3;
                    this.f273410f = str;
                    this.f273411h = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TRTCScreenCaptureSource.this, aVar, Integer.valueOf(i3), str, bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f273408d.k(this.f273409e, this.f273410f, this.f273411h);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.a
    public void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        QLog.i("TRTCScreenCaptureSource", 1, "onScreenCapturePaused.");
        a aVar = this.f273407g;
        if (aVar == null) {
            QLog.i("TRTCScreenCaptureSource", 1, "onScreenCapturePaused: listener==null. [Miss]");
        } else {
            com.tencent.mobileqq.qqlive.trtc.utils.c.a(this.f273398d, new Runnable(aVar, i3) { // from class: com.tencent.mobileqq.qqlive.trtc.video.source.screen.TRTCScreenCaptureSource.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ a f273413d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f273414e;

                {
                    this.f273413d = aVar;
                    this.f273414e = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TRTCScreenCaptureSource.this, aVar, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f273413d.m(this.f273414e);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.a
    public void onScreenCaptureStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QLog.i("TRTCScreenCaptureSource", 1, "onScreenCaptureStarted.");
        a aVar = this.f273407g;
        if (aVar == null) {
            QLog.i("TRTCScreenCaptureSource", 1, "onScreenCaptureStarted: listener==null. [Miss]");
        } else {
            com.tencent.mobileqq.qqlive.trtc.utils.c.a(this.f273398d, new Runnable(aVar) { // from class: com.tencent.mobileqq.qqlive.trtc.video.source.screen.TRTCScreenCaptureSource.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ a f273412d;

                {
                    this.f273412d = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TRTCScreenCaptureSource.this, (Object) aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f273412d.onScreenCaptureStarted();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.a
    public void onScreenCaptureStopped(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        QLog.i("TRTCScreenCaptureSource", 1, "onScreenCaptureStopped: " + i3);
        a aVar = this.f273407g;
        if (aVar == null) {
            QLog.i("TRTCScreenCaptureSource", 1, "onScreenCaptureStopped: listener==null. [Miss]");
        } else {
            com.tencent.mobileqq.qqlive.trtc.utils.c.a(this.f273398d, new Runnable(aVar, i3) { // from class: com.tencent.mobileqq.qqlive.trtc.video.source.screen.TRTCScreenCaptureSource.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ a f273417d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f273418e;

                {
                    this.f273417d = aVar;
                    this.f273418e = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TRTCScreenCaptureSource.this, aVar, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f273417d.onScreenCaptureStopped(this.f273418e);
                    }
                }
            });
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DTConstants.TAG.API, "setScreenCaptureAutoRotateEnabled");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("enable", true);
            jSONObject.put("params", jSONObject2);
            this.f273396b.callExperimentalAPI(jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e("TRTCScreenCaptureSource", 1, "enableAutoRotate failed " + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.c
    public void stopScreenCapture() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f273396b.stopScreenCapture();
        }
    }
}
