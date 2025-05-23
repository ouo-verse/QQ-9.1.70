package com.tencent.aelight.camera.ae.util;

import android.media.AudioManager;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private AudioManager f65757a;

    public void a() {
        AudioManager audioManager = this.f65757a;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
        }
    }

    public void b() {
        AudioManager audioManager = (AudioManager) BaseApplication.getContext().getSystemService("audio");
        this.f65757a = audioManager;
        audioManager.requestAudioFocus(null, 3, 2);
    }
}
