package com.tencent.luggage.wxa.s9;

import android.media.AudioRecord;
import android.media.audiofx.AutomaticGainControl;
import com.tencent.luggage.wxa.s9.e;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f implements e.a {

    /* renamed from: a, reason: collision with root package name */
    public AutomaticGainControl f140214a;

    public f(AudioRecord audioRecord) {
        this.f140214a = null;
        boolean isAvailable = AutomaticGainControl.isAvailable();
        w.a("MicroMsg.MMAutomaticGainControl", "available  " + isAvailable);
        if (isAvailable) {
            this.f140214a = AutomaticGainControl.create(audioRecord.getAudioSessionId());
        }
    }

    @Override // com.tencent.luggage.wxa.s9.e.a
    public boolean a() {
        return AutomaticGainControl.isAvailable();
    }

    @Override // com.tencent.luggage.wxa.s9.e.a
    public boolean setEnabled(boolean z16) {
        AutomaticGainControl automaticGainControl = this.f140214a;
        if (automaticGainControl != null) {
            try {
                int enabled = automaticGainControl.setEnabled(z16);
                if (enabled == 0) {
                    return true;
                }
                w.a("MicroMsg.MMAutomaticGainControl", "setEnabled failed " + enabled);
            } catch (Exception e16) {
                w.a("MicroMsg.MMAutomaticGainControl", e16, "", new Object[0]);
            }
        }
        return false;
    }
}
