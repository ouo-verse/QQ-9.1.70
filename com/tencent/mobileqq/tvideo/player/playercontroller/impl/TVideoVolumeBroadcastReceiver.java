package com.tencent.mobileqq.tvideo.player.playercontroller.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr;
import com.tencent.mobileqq.tvideo.player.playercontroller.impl.TVideoVolumeBroadcastReceiver;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoVolumeBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private final ListenerMgr<Runnable> f304599a = new ListenerMgr<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final TVideoVolumeBroadcastReceiver f304600a = new TVideoVolumeBroadcastReceiver();
    }

    public static TVideoVolumeBroadcastReceiver b() {
        return a.f304600a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void c() {
        this.f304599a.b(new ListenerMgr.a() { // from class: dy2.c
            @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.ListenerMgr.a
            public final void onNotify(Object obj) {
                ((Runnable) obj).run();
            }
        });
    }

    public void e(Runnable runnable) {
        this.f304599a.a(runnable);
    }

    public void f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        RFWApplication.getApplication().registerReceiver(this, intentFilter);
    }

    public void g(Runnable runnable) {
        this.f304599a.c(runnable);
    }

    public void h() {
        new IntentFilter().addAction("android.media.VOLUME_CHANGED_ACTION");
        RFWApplication.getApplication().unregisterReceiver(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: dy2.b
                @Override // java.lang.Runnable
                public final void run() {
                    TVideoVolumeBroadcastReceiver.this.c();
                }
            });
        }
    }
}
