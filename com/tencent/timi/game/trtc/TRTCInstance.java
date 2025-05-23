package com.tencent.timi.game.trtc;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.timi.game.utils.l;
import com.tencent.trtc.TRTCCloud;
import tn4.b;
import tn4.c;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TRTCInstance {

    /* renamed from: a, reason: collision with root package name */
    private volatile TRTCCloud f379970a;

    /* renamed from: b, reason: collision with root package name */
    public volatile TRTCCloud f379971b;

    /* renamed from: c, reason: collision with root package name */
    private tn4.a f379972c = new tn4.a();

    /* renamed from: d, reason: collision with root package name */
    Handler f379973d = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    private LocalAudioRunnable f379974e = new LocalAudioRunnable();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private class LocalAudioRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public boolean f379975d;

        LocalAudioRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f379975d) {
                TRTCInstance.this.f379970a.startLocalAudio();
            } else {
                TRTCInstance.this.f379970a.stopLocalAudio();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a extends b {
        a(tn4.a aVar) {
            super(aVar);
        }
    }

    private void c(rn4.a aVar) {
        if (this.f379970a == null) {
            synchronized (TRTCCloud.class) {
                if (this.f379970a == null) {
                    this.f379970a = TRTCCloud.sharedInstance(eh4.a.b());
                    this.f379970a.enableAudioVolumeEvaluation(300);
                    TRTCCloud.setLogLevel(2);
                    TRTCCloud.setLogDirPath(l.g(System.currentTimeMillis()));
                    this.f379970a.setListener(new a(this.f379972c));
                }
            }
        }
    }

    public void b(rn4.a aVar) {
        c.a(OperateCustomButton.OPERATE_CREATE, new Object[0]);
        c(aVar);
    }

    public void d() {
        c.a("destroy", new Object[0]);
        if (this.f379971b != null) {
            synchronized (TRTCCloud.class) {
                if (this.f379971b != null) {
                    this.f379971b.setListener(null);
                    this.f379971b = null;
                }
            }
            c.a("destroy sub", new Object[0]);
        }
        if (this.f379970a != null) {
            synchronized (TRTCCloud.class) {
                if (this.f379970a != null) {
                    this.f379973d.removeCallbacks(this.f379974e);
                    TRTCCloud.destroySharedInstance();
                    this.f379970a.setListener(null);
                    this.f379970a = null;
                }
            }
        }
    }

    public void e(rn4.a aVar) {
        c.a("enterRoom", new Object[0]);
        this.f379970a.setSystemVolumeType(1);
        this.f379970a.setDefaultStreamRecvMode(true, true);
        this.f379970a.enterRoom(aVar.a(), aVar.f431770a);
    }

    public void f() {
        c.a("exitRoom", new Object[0]);
        this.f379970a.exitRoom();
    }
}
