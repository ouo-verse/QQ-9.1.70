package com.tencent.now.app.music.model.player;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.component.core.log.LogUtil;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.now.app.music.model.manager.MusicPlayMgr;

/* loaded from: classes22.dex */
public class MusicPlaySetting implements ThreadCenter.HandlerKeyable {
    private MusicPlayMgr C;

    /* renamed from: h, reason: collision with root package name */
    private BroadcastReceiver f338028h;

    /* renamed from: d, reason: collision with root package name */
    private b f338025d = null;

    /* renamed from: f, reason: collision with root package name */
    private int f338027f = 1;

    /* renamed from: m, reason: collision with root package name */
    private int f338030m = 0;
    private boolean D = false;
    private boolean E = false;
    private int F = 3;

    /* renamed from: i, reason: collision with root package name */
    private int f338029i = 1;

    /* renamed from: e, reason: collision with root package name */
    private AudioManager f338026e = (AudioManager) ul3.b.d().getSystemService("audio");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.HEADSET_PLUG") && intent.hasExtra("state")) {
                if (intent.getIntExtra("state", 0) == 0) {
                    LogUtil.e("enableMix", "receiver flag:0", new Object[0]);
                    MusicPlaySetting.this.f338030m = 0;
                } else if (intent.getIntExtra("state", 0) == 1) {
                    LogUtil.e("enableMix", "receiver flag:1", new Object[0]);
                    MusicPlaySetting.this.f338030m = 1;
                }
            }
        }
    }

    public MusicPlaySetting(MusicPlayMgr musicPlayMgr) {
        this.C = musicPlayMgr;
    }

    private void h() {
        AudioManager audioManager = this.f338026e;
        if (audioManager == null) {
            return;
        }
        int streamVolume = SystemMethodProxy.getStreamVolume(audioManager, 3);
        int streamMaxVolume = this.f338026e.getStreamMaxVolume(3);
        this.f338027f = streamMaxVolume;
        r(streamVolume / streamMaxVolume);
        if (this.f338026e.isWiredHeadsetOn()) {
            LogUtil.e("enableMix", "init flag:1", new Object[0]);
            this.f338030m = 1;
        } else {
            LogUtil.e("enableMix", "init flag:0", new Object[0]);
            this.f338030m = 0;
        }
        e(1);
    }

    private void m() {
        this.f338028h = new a();
        new IntentFilter().addAction("android.media.VOLUME_CHANGED_ACTION");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        ul3.b.d().registerReceiver(this.f338028h, intentFilter);
    }

    public void d() {
        try {
            ul3.b.d().unregisterReceiver(this.f338028h);
        } catch (Exception e16) {
            LogUtil.e("MusicPlaySetting", "destroyv error:" + e16, new Object[0]);
        }
        this.f338028h = null;
        b bVar = this.f338025d;
        if (bVar != null) {
            if (this.F == 3 && (bVar instanceof b)) {
                bVar.destroy();
            }
            this.f338025d = null;
        }
        ThreadCenter.clear(this);
    }

    public void e(int i3) {
        if (this.f338025d != null) {
            LogUtil.e("enableMix", "set flag:" + i3, new Object[0]);
            this.f338025d.g(i3);
        }
    }

    public int f() {
        return this.f338029i;
    }

    public int g() {
        b bVar = this.f338025d;
        if (bVar != null) {
            return bVar.getTimestamp();
        }
        return 0;
    }

    public void i(Activity activity) {
        new dm3.a().e("add_music").d("music_audio").b("obj1", "0").c();
    }

    public boolean j(Activity activity, String str, String str2) {
        if (this.f338025d == null && this.F == 3) {
            b o16 = com.tencent.now.app.music.model.player.a.o();
            this.f338025d = o16;
            o16.init();
        }
        b bVar = this.f338025d;
        if (bVar == null) {
            LogUtil.e("MusicPlaySetting", "musicdub new error", new Object[0]);
            return false;
        }
        bVar.a(this.E);
        i(activity);
        m();
        this.f338025d.c(new rz0.a() { // from class: com.tencent.now.app.music.model.player.MusicPlaySetting.1
            @Override // rz0.a
            public int a(int i3) {
                LogUtil.i("MusicPlaySetting", "musicdub notify event=%d", Integer.valueOf(i3));
                if (MusicPlaySetting.this.C != null && i3 == 0) {
                    ThreadCenter.postDefaultUITask(new Runnable() { // from class: com.tencent.now.app.music.model.player.MusicPlaySetting.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MusicPlaySetting.this.C != null) {
                                MusicPlaySetting.this.C.z();
                            }
                        }
                    });
                } else if (MusicPlaySetting.this.C != null && i3 == 101) {
                    ThreadCenter.postDefaultUITask(new Runnable() { // from class: com.tencent.now.app.music.model.player.MusicPlaySetting.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MusicPlaySetting.this.C != null) {
                                MusicPlaySetting.this.C.E();
                            }
                        }
                    });
                }
                return 0;
            }
        });
        if (!this.f338025d.init()) {
            LogUtil.e("MusicPlaySetting", "musicdub init error", new Object[0]);
            return false;
        }
        this.f338025d.e(0);
        LogUtil.i("MusicPlaySetting", "open music,musicFile:" + str + "  dubFile:" + str2, new Object[0]);
        h();
        boolean b16 = this.f338025d.b(str, str2);
        LogUtil.i("MusicPlaySetting", "is open success: " + b16, new Object[0]);
        if (b16) {
            b16 = this.f338025d.play();
            if (b16) {
                if (!TextUtils.isEmpty(str)) {
                    t(this.f338029i);
                }
                this.f338025d.stop(0);
            }
            LogUtil.e("MusicPlaySetting", "is play success: " + b16 + " isPlayPause:", new Object[0]);
        }
        return b16;
    }

    public void k() {
        LogUtil.e("MusicPlaySetting", "pause", new Object[0]);
        b bVar = this.f338025d;
        if (bVar != null) {
            bVar.pause();
        }
    }

    public void l() {
        LogUtil.e("MusicPlaySetting", "resume", new Object[0]);
        b bVar = this.f338025d;
        if (bVar != null) {
            bVar.replay();
        }
    }

    public void n(boolean z16) {
        this.E = z16;
    }

    public void o(final float f16) {
        ThreadCenter.postUITask(this, new Runnable() { // from class: com.tencent.now.app.music.model.player.MusicPlaySetting.5
            @Override // java.lang.Runnable
            public void run() {
                if (MusicPlaySetting.this.f338025d != null) {
                    MusicPlaySetting.this.f338025d.f(f16);
                }
            }
        });
    }

    public void p(final float f16) {
        ThreadCenter.postUITask(this, new Runnable() { // from class: com.tencent.now.app.music.model.player.MusicPlaySetting.4
            @Override // java.lang.Runnable
            public void run() {
                if (MusicPlaySetting.this.f338025d != null) {
                    MusicPlaySetting.this.f338025d.d(f16);
                }
            }
        });
    }

    public void q(int i3) {
        this.F = i3;
    }

    public void r(final float f16) {
        ThreadCenter.postUITask(this, new Runnable() { // from class: com.tencent.now.app.music.model.player.MusicPlaySetting.3
            @Override // java.lang.Runnable
            public void run() {
                if (MusicPlaySetting.this.f338025d != null) {
                    MusicPlaySetting.this.f338025d.setVolume(f16);
                }
            }
        });
    }

    public void s() {
        LogUtil.e("MusicPlaySetting", "stop", new Object[0]);
        b bVar = this.f338025d;
        if (bVar != null) {
            bVar.stop(1);
            this.f338025d = null;
        }
    }

    public void t(int i3) {
        b bVar = this.f338025d;
        if (bVar != null) {
            this.f338029i = i3;
            bVar.h(i3);
        }
    }
}
