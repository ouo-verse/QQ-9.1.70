package com.tencent.luggage.wxa.s9;

import android.media.AudioRecord;
import android.media.audiofx.NoiseSuppressor;
import com.tencent.luggage.wxa.s9.e;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g implements e.a {

    /* renamed from: a, reason: collision with root package name */
    public NoiseSuppressor f140215a;

    public g(AudioRecord audioRecord) {
        this.f140215a = null;
        boolean isAvailable = NoiseSuppressor.isAvailable();
        w.a("MicroMsg.MMNoiseSuppressor", "available  " + isAvailable);
        if (isAvailable) {
            this.f140215a = NoiseSuppressor.create(audioRecord.getAudioSessionId());
        }
    }

    @Override // com.tencent.luggage.wxa.s9.e.a
    public boolean a() {
        return NoiseSuppressor.isAvailable();
    }

    @Override // com.tencent.luggage.wxa.s9.e.a
    public boolean setEnabled(boolean z16) {
        NoiseSuppressor noiseSuppressor = this.f140215a;
        if (noiseSuppressor != null) {
            try {
                int enabled = noiseSuppressor.setEnabled(z16);
                if (enabled == 0) {
                    return true;
                }
                w.a("MicroMsg.MMNoiseSuppressor", "setEnabled failed " + enabled);
            } catch (Exception e16) {
                w.a("MicroMsg.MMNoiseSuppressor", e16, "", new Object[0]);
            }
        }
        return false;
    }
}
