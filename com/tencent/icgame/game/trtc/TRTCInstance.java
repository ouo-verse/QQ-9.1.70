package com.tencent.icgame.game.trtc;

import android.os.Handler;
import android.os.Looper;
import ay0.b;
import ay0.c;
import com.tencent.icgame.game.utils.g;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.trtc.TRTCCloud;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TRTCInstance {

    /* renamed from: a, reason: collision with root package name */
    private volatile TRTCCloud f115824a;

    /* renamed from: b, reason: collision with root package name */
    public volatile TRTCCloud f115825b;

    /* renamed from: c, reason: collision with root package name */
    private ay0.a f115826c = new ay0.a();

    /* renamed from: d, reason: collision with root package name */
    Handler f115827d = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    private LocalAudioRunnable f115828e = new LocalAudioRunnable();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private class LocalAudioRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public boolean f115829d;

        LocalAudioRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f115829d) {
                TRTCInstance.this.f115824a.startLocalAudio();
            } else {
                TRTCInstance.this.f115824a.stopLocalAudio();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a extends b {
        a(ay0.a aVar) {
            super(aVar);
        }
    }

    private void c(yx0.a aVar) {
        if (this.f115824a == null) {
            synchronized (TRTCCloud.class) {
                if (this.f115824a == null) {
                    this.f115824a = TRTCCloud.sharedInstance(tu0.a.b());
                    this.f115824a.enableAudioVolumeEvaluation(300);
                    TRTCCloud.setLogLevel(2);
                    TRTCCloud.setLogDirPath(g.f(System.currentTimeMillis()));
                    this.f115824a.setListener(new a(this.f115826c));
                }
            }
        }
    }

    public void b(yx0.a aVar) {
        c.a(OperateCustomButton.OPERATE_CREATE, new Object[0]);
        c(aVar);
    }

    public void d() {
        c.a("destroy", new Object[0]);
        if (this.f115825b != null) {
            synchronized (TRTCCloud.class) {
                if (this.f115825b != null) {
                    this.f115825b.setListener(null);
                    this.f115825b = null;
                }
            }
            c.a("destroy sub", new Object[0]);
        }
        if (this.f115824a != null) {
            synchronized (TRTCCloud.class) {
                if (this.f115824a != null) {
                    this.f115827d.removeCallbacks(this.f115828e);
                    TRTCCloud.destroySharedInstance();
                    this.f115824a.setListener(null);
                    this.f115824a = null;
                }
            }
        }
    }

    public void e(yx0.a aVar) {
        c.a("enterRoom", new Object[0]);
        this.f115824a.setSystemVolumeType(1);
        this.f115824a.setDefaultStreamRecvMode(true, true);
        this.f115824a.enterRoom(aVar.a(), aVar.f451367a);
    }

    public void f() {
        c.a("exitRoom", new Object[0]);
        this.f115824a.exitRoom();
    }
}
