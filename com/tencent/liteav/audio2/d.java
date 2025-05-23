package com.tencent.liteav.audio2;

import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class d extends AudioManager.AudioRecordingCallback {

    /* renamed from: a, reason: collision with root package name */
    volatile a f118852a;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    interface a {
        void OnRecordingConfigChanged(List<AudioRecordingConfiguration> list);
    }

    public d() {
        AudioManager audioManager;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 24 && (audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio")) != null) {
            try {
                audioManager.registerAudioRecordingCallback(this, null);
                Log.i("LiteavAudioRecordingCallback", "register audio recording callback", new Object[0]);
            } catch (Throwable th5) {
                Log.e("LiteavAudioRecordingCallback", "register audio recording callback exception " + th5.getMessage(), new Object[0]);
            }
        }
    }

    @Override // android.media.AudioManager.AudioRecordingCallback
    public final void onRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
        a aVar = this.f118852a;
        if (aVar == null) {
            return;
        }
        aVar.OnRecordingConfigChanged(list);
    }
}
