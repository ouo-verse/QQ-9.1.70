package com.tencent.crossengine;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GameMainThread extends Thread implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private CEApplication f100460d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f100461e = false;

    public GameMainThread(CEApplication cEApplication) {
        setName("CEGame-Thread-" + getId());
        this.f100460d = cEApplication;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f100460d.gameLoop();
    }
}
