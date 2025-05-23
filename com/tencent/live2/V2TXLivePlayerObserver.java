package com.tencent.live2;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes7.dex */
public abstract class V2TXLivePlayerObserver {
    static IPatchRedirector $redirector_;

    public V2TXLivePlayerObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void onAudioLoading(V2TXLivePlayer v2TXLivePlayer, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) v2TXLivePlayer, (Object) bundle);
        }
    }

    public void onAudioPlaying(V2TXLivePlayer v2TXLivePlayer, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, v2TXLivePlayer, Boolean.valueOf(z16), bundle);
        }
    }

    public void onConnected(V2TXLivePlayer v2TXLivePlayer, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v2TXLivePlayer, (Object) bundle);
        }
    }

    public void onError(V2TXLivePlayer v2TXLivePlayer, int i3, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, v2TXLivePlayer, Integer.valueOf(i3), str, bundle);
        }
    }

    public void onLocalRecordBegin(V2TXLivePlayer v2TXLivePlayer, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, v2TXLivePlayer, Integer.valueOf(i3), str);
        }
    }

    public void onLocalRecordComplete(V2TXLivePlayer v2TXLivePlayer, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, v2TXLivePlayer, Integer.valueOf(i3), str);
        }
    }

    public void onLocalRecording(V2TXLivePlayer v2TXLivePlayer, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, v2TXLivePlayer, Long.valueOf(j3), str);
        }
    }

    public void onPlayoutAudioFrame(V2TXLivePlayer v2TXLivePlayer, V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) v2TXLivePlayer, (Object) v2TXLiveAudioFrame);
        }
    }

    public void onPlayoutVolumeUpdate(V2TXLivePlayer v2TXLivePlayer, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) v2TXLivePlayer, i3);
        }
    }

    public void onReceiveSeiMessage(V2TXLivePlayer v2TXLivePlayer, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, v2TXLivePlayer, Integer.valueOf(i3), bArr);
        }
    }

    public void onRenderVideoFrame(V2TXLivePlayer v2TXLivePlayer, V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) v2TXLivePlayer, (Object) v2TXLiveVideoFrame);
        }
    }

    public void onSnapshotComplete(V2TXLivePlayer v2TXLivePlayer, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) v2TXLivePlayer, (Object) bitmap);
        }
    }

    public void onStatisticsUpdate(V2TXLivePlayer v2TXLivePlayer, V2TXLiveDef.V2TXLivePlayerStatistics v2TXLivePlayerStatistics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) v2TXLivePlayer, (Object) v2TXLivePlayerStatistics);
        }
    }

    public void onStreamSwitched(V2TXLivePlayer v2TXLivePlayer, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, v2TXLivePlayer, str, Integer.valueOf(i3));
        }
    }

    public void onVideoLoading(V2TXLivePlayer v2TXLivePlayer, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) v2TXLivePlayer, (Object) bundle);
        }
    }

    public void onVideoPlaying(V2TXLivePlayer v2TXLivePlayer, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, v2TXLivePlayer, Boolean.valueOf(z16), bundle);
        }
    }

    public void onVideoResolutionChanged(V2TXLivePlayer v2TXLivePlayer, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, v2TXLivePlayer, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void onWarning(V2TXLivePlayer v2TXLivePlayer, int i3, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, v2TXLivePlayer, Integer.valueOf(i3), str, bundle);
        }
    }
}
