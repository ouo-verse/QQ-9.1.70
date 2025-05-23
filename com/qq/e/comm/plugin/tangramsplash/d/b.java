package com.qq.e.comm.plugin.tangramsplash.d;

import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.ITGChangeBackgroundStatusManager;
import com.qq.e.comm.util.GDTLogger;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack f39867a;

    public static void a() {
        ITGChangeBackgroundStatusManager iTGChangeBackgroundStatusManager;
        GDTLogger.i("registerChangeBackgroundStatusCallBack");
        if (f39867a == null) {
            f39867a = new ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack() { // from class: com.qq.e.comm.plugin.tangramsplash.d.b.1
                @Override // com.qq.e.comm.pi.ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack
                public void onBackground() {
                }

                @Override // com.qq.e.comm.pi.ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack
                public void onForeground() {
                }
            };
        }
        WeakReference<ITGChangeBackgroundStatusManager> tGChangeBackgroundStatusListener = GlobalSetting.getTGChangeBackgroundStatusListener();
        if (tGChangeBackgroundStatusListener != null && (iTGChangeBackgroundStatusManager = tGChangeBackgroundStatusListener.get()) != null) {
            iTGChangeBackgroundStatusManager.register(new WeakReference<>(f39867a));
        }
    }
}
