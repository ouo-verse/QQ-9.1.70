package com.tencent.luggage.wxa.s9;

import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import com.tencent.luggage.wxa.s9.e;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements e.a {

    /* renamed from: a, reason: collision with root package name */
    public AcousticEchoCanceler f140201a;

    public c(AudioRecord audioRecord) {
        this.f140201a = null;
        boolean isAvailable = AcousticEchoCanceler.isAvailable();
        w.a("MicroMsg.MMAcousticEchoCanceler", "available  " + isAvailable);
        if (isAvailable) {
            this.f140201a = AcousticEchoCanceler.create(audioRecord.getAudioSessionId());
        }
    }

    @Override // com.tencent.luggage.wxa.s9.e.a
    public boolean a() {
        return AcousticEchoCanceler.isAvailable();
    }

    @Override // com.tencent.luggage.wxa.s9.e.a
    public boolean setEnabled(boolean z16) {
        AcousticEchoCanceler acousticEchoCanceler = this.f140201a;
        if (acousticEchoCanceler != null) {
            try {
                int enabled = acousticEchoCanceler.setEnabled(z16);
                if (enabled == 0) {
                    return true;
                }
                w.a("MicroMsg.MMAcousticEchoCanceler", "setEnabled failed " + enabled);
            } catch (Exception e16) {
                w.a("MicroMsg.MMAcousticEchoCanceler", e16, "", new Object[0]);
            }
        }
        return false;
    }
}
