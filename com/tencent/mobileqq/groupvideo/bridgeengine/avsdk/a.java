package com.tencent.mobileqq.groupvideo.bridgeengine.avsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.av.utils.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final String f213722f;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f213723a;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f213724b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f213725c;

    /* renamed from: d, reason: collision with root package name */
    private b f213726d;

    /* renamed from: e, reason: collision with root package name */
    private final BroadcastReceiver f213727e;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.groupvideo.bridgeengine.avsdk.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class C7658a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        C7658a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if (action != null && a.this.f213725c) {
                if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("state", -1);
                    QLog.i(a.f213722f, 1, String.format("onReceive ACTION_HEADSET_PLUG state=%s", Integer.valueOf(intExtra)));
                    if (intExtra == 0) {
                        a.this.g(3);
                    } else if (intExtra == 1) {
                        a.this.f(3);
                    }
                }
                if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(action)) {
                    int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
                    QLog.i(a.f213722f, 1, String.format("onReceive ACTION_CONNECTION_STATE_CHANGED state=%s", Integer.valueOf(intExtra2)));
                    if (intExtra2 == 2 || intExtra2 == 12) {
                        a.this.f(2);
                        return;
                    } else {
                        if (intExtra2 == 0) {
                            a.this.g(2);
                            return;
                        }
                        return;
                    }
                }
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                    int intExtra3 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                    QLog.i(a.f213722f, 1, String.format("onReceive ACTION_STATE_CHANGED state=%s", Integer.valueOf(intExtra3)));
                    if (intExtra3 == 10 || intExtra3 == 13) {
                        a.this.g(2);
                    }
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25074);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f213722f = com.tencent.mobileqq.groupvideo.config.a.a() + "AudioRouter";
    }

    public a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.f213723a = -1;
        this.f213724b = -1;
        this.f213727e = new C7658a();
        this.f213726d = bVar;
    }

    private boolean e(Context context) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            return Boolean.parseBoolean(audioManager.getClass().getMethod("isWiredHeadsetOn", new Class[0]).invoke(audioManager, null).toString());
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i3) {
        QLog.i(f213722f, 1, "onDeviceConnect route=" + i3);
        if (this.f213723a != 2 && this.f213723a != 3) {
            this.f213724b = this.f213723a;
        }
        this.f213726d.setAudioRoute(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i3) {
        QLog.i(f213722f, 1, "onDeviceLoss device=" + i3);
        if (this.f213724b != -1) {
            this.f213726d.setAudioRoute(this.f213724b);
            this.f213724b = -1;
        } else if (i3 != 1) {
            this.f213726d.setAudioRoute(1);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f213725c = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        MobileQQ.sMobileQQ.getApplicationContext().registerReceiver(this.f213727e, intentFilter);
        if (ai.g(MobileQQ.sMobileQQ.getApplicationContext())) {
            QLog.i(f213722f, 1, "start has blue tooth connected");
            this.f213726d.setAudioRoute(2);
        } else if (e(MobileQQ.sMobileQQ.getApplicationContext())) {
            QLog.i(f213722f, 1, "start has headset ");
            this.f213726d.setAudioRoute(3);
        } else {
            QLog.i(f213722f, 1, "start set default");
            this.f213726d.setAudioRoute(1);
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (!this.f213725c) {
                return;
            }
            this.f213725c = false;
            MobileQQ.sMobileQQ.getApplicationContext().unregisterReceiver(this.f213727e);
            this.f213723a = -1;
            this.f213724b = -1;
        }
    }
}
