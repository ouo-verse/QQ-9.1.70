package com.tencent.luggage.wxa.wm;

import android.media.AudioManager;
import com.tencent.luggage.wxa.qm.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static int f144288c = 3;

    /* renamed from: b, reason: collision with root package name */
    public AudioManager.OnAudioFocusChangeListener f144290b = new C6888a();

    /* renamed from: a, reason: collision with root package name */
    public AudioManager f144289a = (AudioManager) z.c().getSystemService("audio");

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.wm.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6888a implements AudioManager.OnAudioFocusChangeListener {
        public C6888a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            w.d("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", Integer.valueOf(i3));
            if (i3 != -2 && i3 != -3) {
                if (i3 != 1 && i3 != 2 && i3 != 3) {
                    if (i3 == -1) {
                        w.d("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
                        if (k.f().b().c()) {
                            k.f().b().e();
                            k.f().c();
                            k.f().b(600000);
                        }
                        if (a.this.f144289a != null) {
                            a.this.f144289a.abandonAudioFocus(a.this.f144290b);
                            return;
                        }
                        return;
                    }
                    return;
                }
                w.d("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
                if (k.f().b().c()) {
                    k.f().b().a(false);
                    return;
                }
                return;
            }
            w.d("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
            if (k.f().b().c()) {
                k.f().b().e();
            }
        }
    }

    public void a() {
        w.d("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
        AudioManager audioManager = this.f144289a;
        if (audioManager == null) {
            return;
        }
        audioManager.abandonAudioFocus(this.f144290b);
    }

    public boolean b() {
        AudioManager audioManager = this.f144289a;
        if (audioManager == null) {
            return false;
        }
        int requestAudioFocus = audioManager.requestAudioFocus(this.f144290b, f144288c, 2);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(requestAudioFocus == 1);
        objArr[1] = Integer.valueOf(f144288c);
        w.d("MicroMsg.Music.MusicAudioFocusHelper", "request audio focus %b %d", objArr);
        return requestAudioFocus == 1;
    }
}
