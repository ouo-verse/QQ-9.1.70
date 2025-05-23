package com.tencent.mobileqq.qqlive.trtc.video.source;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.trtc.engine.c;
import com.tencent.mobileqq.qqlive.trtc.utils.SourceInitState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected final SourceInitState f273395a;

    /* renamed from: b, reason: collision with root package name */
    protected TRTCCloud f273396b;

    /* renamed from: c, reason: collision with root package name */
    protected WeakReference<Context> f273397c;

    /* renamed from: d, reason: collision with root package name */
    protected Handler f273398d;

    /* renamed from: e, reason: collision with root package name */
    protected TRTCVideoQualityParams f273399e;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273395a = new SourceInitState();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void a(@NonNull Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) handler);
        } else {
            this.f273398d = handler;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void b() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        q();
        QLog.d("TRTCVideoBaseSourceImpl", 1, "pauseSource!");
        TRTCCloud tRTCCloud = this.f273396b;
        if (tRTCCloud != null) {
            tRTCCloud.muteLocalVideo(true);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void c(@NonNull c cVar) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
            return;
        }
        if (!this.f273395a.b()) {
            if (QLog.isColorLevel()) {
                QLog.d("TRTCVideoBaseSourceImpl", 1, "initSource!");
            }
            this.f273396b = cVar.f273306a;
            this.f273397c = cVar.f273307b;
            this.f273395a.d();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        q();
        QLog.d("TRTCVideoBaseSourceImpl", 1, "destroy!");
        this.f273396b = null;
        this.f273399e = null;
        this.f273398d = null;
        this.f273395a.c();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void f() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        q();
        QLog.d("TRTCVideoBaseSourceImpl", 1, "resumeSource!");
        TRTCCloud tRTCCloud = this.f273396b;
        if (tRTCCloud != null) {
            tRTCCloud.muteLocalVideo(false);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public TRTCVideoQualityParams getVideoQuality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TRTCVideoQualityParams) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f273399e;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void i(@NonNull Bitmap bitmap, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bitmap, i3);
            return;
        }
        if (i3 >= 5 && i3 <= 20) {
            TRTCCloud tRTCCloud = this.f273396b;
            if (tRTCCloud != null) {
                tRTCCloud.setVideoMuteImage(bitmap, i3);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("fps except [5, 20]. but " + i3);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        TRTCCloud tRTCCloud = this.f273396b;
        if (tRTCCloud != null) {
            tRTCCloud.muteLocalVideo(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (this.f273395a.b()) {
        } else {
            throw new IllegalStateException("not init. please call setVideoSource");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void setVideoQuality(@NonNull TRTCVideoQualityParams tRTCVideoQualityParams) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tRTCVideoQualityParams);
            return;
        }
        QLog.i("TRTCVideoBaseSourceImpl", 1, "setVideoQuality. resolution:" + tRTCVideoQualityParams.getVideoResolution() + ", mode:" + tRTCVideoQualityParams.getVideoResolutionMode() + ", fps:" + tRTCVideoQualityParams.getVideoFps() + ", bitrate:" + tRTCVideoQualityParams.getMinVideoBitRate());
        this.f273399e = tRTCVideoQualityParams;
        TRTCCloudDef.TRTCVideoEncParam j3 = com.tencent.mobileqq.qqlive.trtc.utils.a.j(tRTCVideoQualityParams);
        TRTCCloud tRTCCloud = this.f273396b;
        if (tRTCCloud != null) {
            tRTCCloud.setVideoEncoderParam(j3);
        }
    }
}
