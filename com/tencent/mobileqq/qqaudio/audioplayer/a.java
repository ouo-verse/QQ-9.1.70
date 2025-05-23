package com.tencent.mobileqq.qqaudio.audioplayer;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    Application f262161a;

    /* renamed from: b, reason: collision with root package name */
    C8285a f262162b;

    /* renamed from: c, reason: collision with root package name */
    WeakReference<AudioPlayerBase> f262163c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqaudio.audioplayer.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C8285a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f262164a;

        /* renamed from: b, reason: collision with root package name */
        int f262165b;

        /* renamed from: c, reason: collision with root package name */
        boolean f262166c;

        /* renamed from: d, reason: collision with root package name */
        long f262167d;

        /* renamed from: e, reason: collision with root package name */
        long f262168e;

        C8285a(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, str, Integer.valueOf(i3));
                return;
            }
            this.f262166c = false;
            this.f262167d = 0L;
            this.f262168e = 0L;
            this.f262164a = str;
            this.f262165b = i3;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
            if (QLog.isColorLevel()) {
                QLog.d("AudioPlayer_SCOHelper", 2, "onReceive ACTION_SCO_AUDIO_STATE_UPDATED = " + intExtra + " " + this.f262164a + ", time=" + uptimeMillis);
            }
            AudioPlayerBase d16 = a.this.d();
            if (1 == intExtra) {
                if (this.f262168e == 0) {
                    this.f262168e = uptimeMillis;
                    if (d16 != null) {
                        AudioManager k3 = d16.k();
                        if (k3 != null) {
                            k3.setBluetoothScoOn(true);
                            AudioPlayerBase.N = true;
                        }
                        d16.s();
                        if (!d16.r()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("AudioPlayer_SCOHelper", 2, "onReceive SCO_AUDIO_STATE_CONNECTED need replay time=" + uptimeMillis);
                            }
                            d16.E(true);
                            d16.A(this.f262164a, this.f262165b);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (2 == intExtra) {
                this.f262166c = true;
                return;
            }
            if (intExtra == 0) {
                if (this.f262167d == 0) {
                    this.f262167d = uptimeMillis;
                    return;
                }
                if (this.f262166c && d16 != null) {
                    d16.H();
                }
                if (d16 != null) {
                    d16.t();
                }
                long j3 = this.f262168e;
                if ((j3 != 0 && uptimeMillis - j3 <= 2000) || uptimeMillis - this.f262167d <= 1000) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AudioPlayer_SCOHelper", 2, "sco disconnected quickly.");
                    }
                    c.f262175d = true;
                    if (d16 != null) {
                        d16.i();
                        if (d16.r()) {
                            d16.E(false);
                            d16.A(this.f262164a, this.f262165b);
                            return;
                        } else {
                            d16.w(0);
                            return;
                        }
                    }
                    return;
                }
                if (d16 != null && d16.r()) {
                    d16.w(d16.m());
                }
            }
        }
    }

    public a(Application application) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) application);
        } else {
            this.f262161a = application;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AudioPlayerBase d() {
        WeakReference<AudioPlayerBase> weakReference = this.f262163c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3)).intValue();
        }
        if (c.f262174c != -1) {
            return 1;
        }
        for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) BaseApplication.getContext().getSystemService("audio")).getDevices(2)) {
            if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 7) {
                c.f262174c = audioDeviceInfo.getType();
            }
        }
        if (c.f262174c == -1) {
            c.f262174c = 0;
        }
        return 1;
    }

    public void c(AudioPlayerBase audioPlayerBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) audioPlayerBase);
            return;
        }
        if (audioPlayerBase == null && QLog.isColorLevel()) {
            QLog.d("AudioPlayer_SCOHelper", 2, "setAudioPlayer audioPlayer is null");
        }
        this.f262163c = new WeakReference<>(audioPlayerBase);
    }

    public int e(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3)).intValue();
        }
        if (this.f262161a == null) {
            return 0;
        }
        C8285a c8285a = new C8285a(str, i3);
        this.f262162b = c8285a;
        this.f262161a.registerReceiver(c8285a, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        AudioPlayerBase d16 = d();
        if (d16 == null || d16.k() == null) {
            return 0;
        }
        d16.k().startBluetoothSco();
        if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer_SCOHelper", 2, "tryStartBluetoothSCO return: Check_SCO_Result_Check_Access_Need_Return");
        }
        return 2;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f262162b != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioPlayer_SCOHelper", 2, "unregister sco receiver:  " + SystemClock.uptimeMillis());
            }
            try {
                this.f262161a.unregisterReceiver(this.f262162b);
            } catch (Exception unused) {
            }
            this.f262162b = null;
        }
    }
}
