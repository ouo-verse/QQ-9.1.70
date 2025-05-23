package com.tencent.mobileqq.qqlive.trtc.video.source.screen;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveScreenCaptureParams;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCClientIPCModule;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCServerIPCModule;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e implements c, com.tencent.mobileqq.qqlive.trtc.ipc.a, com.tencent.mobileqq.qqlive.trtc.video.source.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.trtc.video.source.screen.a f273419a;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    static class a implements com.tencent.mobileqq.qqlive.trtc.video.source.screen.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.a
        public void h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                onScreenCaptureStarted();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.a
        public void k(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bundle);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("Key_TRTC_ErrCode", i3);
            bundle2.putString("Key_TRTC_ErrMsg", str);
            bundle2.putBundle("Key_TRTC_Extra", bundle);
            TRTCClientIPCModule.d("Action_Server_Screen_Callback_On_Error", bundle2);
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.a
        public void m(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("Key_TRTC_ErrCode", i3);
            TRTCClientIPCModule.d("Action_Server_Screen_Callback_Stop", bundle);
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.a
        public void onScreenCaptureStarted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                TRTCClientIPCModule.d("Action_Server_Screen_Callback_Start", null);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.a
        public void onScreenCaptureStopped(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                m(i3);
            }
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273419a = null;
            TRTCServerIPCModule.h().l(this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void a(@NonNull Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) handler);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void b() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void c(@NonNull com.tencent.mobileqq.qqlive.trtc.engine.c cVar) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f273419a = null;
            TRTCServerIPCModule.h().o(this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.c
    public void e(TRTCVideoQualityParams tRTCVideoQualityParams, QQLiveScreenCaptureParams qQLiveScreenCaptureParams) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) tRTCVideoQualityParams, (Object) qQLiveScreenCaptureParams);
            return;
        }
        Bundle bundle = new Bundle();
        if (tRTCVideoQualityParams != null) {
            bundle.putParcelable("Key_trtc_screen_params", tRTCVideoQualityParams);
        }
        TRTCServerIPCModule.g("Action_Client_Screen_Start", bundle, null);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void f() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.c
    public void g(com.tencent.mobileqq.qqlive.trtc.video.source.screen.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) aVar);
        } else {
            this.f273419a = aVar;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public TRTCVideoQualityParams getVideoQuality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (TRTCVideoQualityParams) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.ipc.a
    public boolean h(String str, Bundle bundle) {
        TRTCVideoQualityParams tRTCVideoQualityParams;
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, (Object) bundle)).booleanValue();
        }
        Bitmap bitmap = null;
        if (bundle != null) {
            bundle.setClassLoader(TRTCVideoQualityParams.class.getClassLoader());
            tRTCVideoQualityParams = (TRTCVideoQualityParams) bundle.getParcelable("Key_trtc_screen_params");
        } else {
            tRTCVideoQualityParams = null;
        }
        com.tencent.mobileqq.qqlive.trtc.b.r().y();
        if ("Action_Client_Screen_Set_Quality".equals(str)) {
            if (tRTCVideoQualityParams == null) {
                return true;
            }
            com.tencent.mobileqq.qqlive.trtc.b.r().a0(tRTCVideoQualityParams);
            return true;
        }
        if ("Action_Client_Screen_Start".equals(str)) {
            com.tencent.mobileqq.qqlive.trtc.b.r().W(new a());
            com.tencent.mobileqq.qqlive.trtc.b.r().g0(tRTCVideoQualityParams, null);
            return true;
        }
        if ("Action_Client_Screen_Stop".equals(str)) {
            com.tencent.mobileqq.qqlive.trtc.b.r().m0();
            return true;
        }
        if ("Action_Client_Screen_Mute_Video".equals(str)) {
            if (bundle != null && bundle.getBoolean("Key_trtc_source_mute", false)) {
                z16 = true;
            } else {
                z16 = false;
            }
            c t16 = com.tencent.mobileqq.qqlive.trtc.b.r().t(false);
            if (t16 == null) {
                return true;
            }
            t16.j(z16);
            return true;
        }
        if (!"Action_Client_Screen_Set_Mute_Bitmap".equals(str)) {
            return false;
        }
        if (bundle != null) {
            bitmap = (Bitmap) bundle.getParcelable("Key_trtc_source_mute_bitmap");
            i3 = bundle.getInt("Key_trtc_source_mute_fps", 0);
        } else {
            i3 = 0;
        }
        c t17 = com.tencent.mobileqq.qqlive.trtc.b.r().t(false);
        if (t17 == null || bitmap == null) {
            return true;
        }
        t17.i(bitmap, i3);
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void i(Bitmap bitmap, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bitmap, i3);
            return;
        }
        if (i3 < 5 || i3 > 20) {
            QLog.e("TRTCFakeScreenCaptureSource", 1, "fps except [5, 20]. but " + i3);
            i3 = 10;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("Key_trtc_source_mute_bitmap", bitmap);
        bundle.putInt("Key_trtc_source_mute_fps", i3);
        TRTCServerIPCModule.g("Action_Client_Screen_Set_Mute_Bitmap", bundle, null);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("Key_trtc_source_mute", z16);
        TRTCServerIPCModule.g("Action_Client_Screen_Mute_Video", bundle, null);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.ipc.a
    public boolean k(String str, Bundle bundle) {
        Bundle bundle2;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) bundle)).booleanValue();
        }
        if (this.f273419a == null) {
            return false;
        }
        String str2 = "";
        if (bundle != null) {
            i3 = bundle.getInt("Key_TRTC_ErrCode", 0);
            str2 = bundle.getString("Key_TRTC_ErrMsg", "");
            bundle2 = bundle.getBundle("Key_TRTC_Extra");
        } else {
            bundle2 = null;
            i3 = 0;
        }
        if ("Action_Server_Screen_Callback_On_Error".equals(str)) {
            this.f273419a.k(i3, str2, bundle2);
        } else if ("Action_Server_Screen_Callback_Start".equals(str)) {
            this.f273419a.onScreenCaptureStarted();
        } else {
            if (!"Action_Server_Screen_Callback_Stop".equals(str)) {
                return false;
            }
            this.f273419a.onScreenCaptureStopped(i3);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.a
    public void setVideoQuality(@NonNull TRTCVideoQualityParams tRTCVideoQualityParams) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) tRTCVideoQualityParams);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("Key_trtc_screen_params", tRTCVideoQualityParams);
        TRTCServerIPCModule.g("Action_Client_Screen_Set_Quality", bundle, null);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.c
    public void stopScreenCapture() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            TRTCServerIPCModule.g("Action_Client_Screen_Stop", null, null);
        }
    }
}
