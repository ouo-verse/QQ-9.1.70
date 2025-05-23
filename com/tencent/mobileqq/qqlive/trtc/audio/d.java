package com.tencent.mobileqq.qqlive.trtc.audio;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCServerIPCModule;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d implements b, com.tencent.mobileqq.qqlive.trtc.ipc.a {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            TRTCServerIPCModule.h().l(this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.a
    public void a(@NonNull Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) handler);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.a
    public void b() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.a
    public boolean c(@NonNull com.tencent.mobileqq.qqlive.trtc.engine.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) cVar)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            TRTCServerIPCModule.g("Action_Client_Audio_StopMic", null, null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            TRTCServerIPCModule.h().o(this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.b
    public void e(boolean z16) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.b
    public void enableAudioVolumeEvaluation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.a
    public void f() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.b
    public void g(int i3) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("Key_trtc_audio_params", i3);
        TRTCServerIPCModule.g("Action_Client_Audio_StartMic", bundle, null);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.ipc.a
    public boolean h(String str, Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) bundle)).booleanValue();
        }
        com.tencent.mobileqq.qqlive.trtc.b.r().v();
        if ("Action_Client_Audio_StartMic".equals(str)) {
            if (bundle != null) {
                i3 = bundle.getInt("Key_trtc_audio_params");
            } else {
                i3 = 2;
            }
            QLog.d("TRTCFakeAudioSource", 1, "Action_Client_Audio_StartMic " + i3);
            com.tencent.mobileqq.qqlive.trtc.b.r().b0();
            return true;
        }
        if ("Action_Client_Audio_StopMic".equals(str)) {
            com.tencent.mobileqq.qqlive.trtc.b.r().i0();
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.b
    public boolean isMicEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.b
    public boolean isMicMuteEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.ipc.a
    public boolean k(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, (Object) bundle)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.b
    public void setAudioCaptureVolume(int i3) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
    }
}
