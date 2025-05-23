package com.tencent.mobileqq.gamecenter.media;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static c f212200b;

    /* renamed from: a, reason: collision with root package name */
    private GameCenterVideoViewController f212201a;

    public static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            if (f212200b == null) {
                f212200b = new c();
            }
            cVar = f212200b;
        }
        return cVar;
    }

    public GameCenterVideoViewController a() {
        return this.f212201a;
    }

    public void c() {
        GameCenterVideoViewController gameCenterVideoViewController = this.f212201a;
        if (gameCenterVideoViewController != null) {
            gameCenterVideoViewController.stop();
            this.f212201a.release();
            this.f212201a = null;
        }
    }

    public void d(GameCenterVideoViewController gameCenterVideoViewController) {
        GameCenterVideoViewController gameCenterVideoViewController2 = this.f212201a;
        if (gameCenterVideoViewController2 != null && gameCenterVideoViewController2 != null && gameCenterVideoViewController2 != gameCenterVideoViewController && gameCenterVideoViewController2 != null) {
            gameCenterVideoViewController2.stop();
            this.f212201a.release();
        }
        this.f212201a = gameCenterVideoViewController;
    }
}
