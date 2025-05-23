package com.tencent.icgame.game.liveroom.impl.room.monitor;

import com.tencent.biz.richframework.monitor.IRFWMonitorManager;

/* loaded from: classes7.dex */
final class PerformanceHelper$AutoStopMonitorRunnableImpl implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private IRFWMonitorManager f115446d;

    @Override // java.lang.Runnable
    public void run() {
        this.f115446d.stop();
    }
}
