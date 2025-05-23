package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.av.utils.af;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u0001:\u0002\u0007\u0013B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0012\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\u00060\u000eR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/av/app/MicrophoneMuteChangeMonitor;", "", "", "b", "c", "d", "Lcom/tencent/av/app/VideoAppInterface;", "a", "Lcom/tencent/av/app/VideoAppInterface;", "getMApp", "()Lcom/tencent/av/app/VideoAppInterface;", "setMApp", "(Lcom/tencent/av/app/VideoAppInterface;)V", "mApp", "Lcom/tencent/av/app/MicrophoneMuteChangeMonitor$MicrophoneMuteChangeReceiver;", "Lcom/tencent/av/app/MicrophoneMuteChangeMonitor$MicrophoneMuteChangeReceiver;", "mMicrophoneMuteChangeReceiver", "app", "<init>", "MicrophoneMuteChangeReceiver", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class MicrophoneMuteChangeMonitor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VideoAppInterface mApp;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MicrophoneMuteChangeReceiver mMicrophoneMuteChangeReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/av/app/MicrophoneMuteChangeMonitor$MicrophoneMuteChangeReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/tencent/av/app/MicrophoneMuteChangeMonitor;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final class MicrophoneMuteChangeReceiver extends BroadcastReceiver {
        public MicrophoneMuteChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            if (intent != null) {
                MicrophoneMuteChangeMonitor microphoneMuteChangeMonitor = MicrophoneMuteChangeMonitor.this;
                String action = intent.getAction();
                if (action != null && action.hashCode() == 835336980 && action.equals("android.media.action.MICROPHONE_MUTE_CHANGED")) {
                    microphoneMuteChangeMonitor.b();
                }
            }
        }
    }

    public MicrophoneMuteChangeMonitor(@NotNull VideoAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        this.mApp = app;
        this.mMicrophoneMuteChangeReceiver = new MicrophoneMuteChangeReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        SessionInfo f16;
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i("MicrophoneMuteChangeMonitor", 2, "handleMicrophoneMuteChanged");
        }
        Object systemService = BaseApplication.getContext().getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        boolean isMicrophoneMute = ((AudioManager) systemService).isMicrophoneMute();
        if (com.tencent.av.r.h0() != null && (f16 = com.tencent.av.n.e().f()) != null) {
            if (f16.F()) {
                if (QLog.isColorLevel()) {
                    QLog.i("MicrophoneMuteChangeMonitor", 2, "handleMicrophoneMuteChanged multi mic state change");
                }
                if ((isMicrophoneMute && !com.tencent.av.r.h0().X0()) || (!isMicrophoneMute && com.tencent.av.r.h0().X0())) {
                    boolean v3 = af.v();
                    if (!f16.f73037i1 && !f16.f73041j1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if ((z16 && f16.W0 && f16.X0 != 0) || (!v3 && z16 && f16.X0 == 1)) {
                        this.mApp.k0(new Object[]{15002, -1, Integer.valueOf(com.tencent.av.r.h0().e0()), Integer.valueOf(com.tencent.av.r.h0().e0())});
                        return;
                    }
                    int e06 = com.tencent.av.r.h0().e0();
                    com.tencent.av.r.h0().z("handleMicrophoneMuteChanged", com.tencent.av.r.h0().X(), com.tencent.av.r.h0().X0(), true, -1);
                    this.mApp.k0(new Object[]{15002, -1, Integer.valueOf(e06), Integer.valueOf(com.tencent.av.r.h0().e0())});
                    return;
                }
                return;
            }
            if (f16.E() && f16.f73060o0) {
                if (QLog.isColorLevel()) {
                    QLog.i("MicrophoneMuteChangeMonitor", 2, "handleMicrophoneMuteChanged double video meeting mic state change");
                }
                if ((isMicrophoneMute && !com.tencent.av.r.h0().X0()) || (!isMicrophoneMute && com.tencent.av.r.h0().X0())) {
                    try {
                        String str = f16.f73091w;
                        Intrinsics.checkNotNullExpressionValue(str, "sessionInfo.peerUin");
                        long parseLong = Long.parseLong(str);
                        int e07 = com.tencent.av.r.h0().e0();
                        com.tencent.av.r.h0().z("handleMicrophoneMuteChanged", parseLong, com.tencent.av.r.h0().X0(), true, -1);
                        this.mApp.k0(new Object[]{15002, -1, Integer.valueOf(e07), Integer.valueOf(com.tencent.av.r.h0().e0())});
                        return;
                    } catch (NumberFormatException unused) {
                        QLog.e("MicrophoneMuteChangeMonitor", 1, "handleMicrophoneMuteChanged parse ep");
                        return;
                    }
                }
                return;
            }
            if (f16.E()) {
                if (QLog.isColorLevel()) {
                    QLog.i("MicrophoneMuteChangeMonitor", 2, "handleMicrophoneMuteChanged double video mic state change");
                }
                if ((isMicrophoneMute && !f16.K) || (!isMicrophoneMute && f16.K)) {
                    f16.d0("handleMicrophoneMuteChanged", isMicrophoneMute);
                    this.mApp.k0(new Object[]{10005});
                    return;
                }
                return;
            }
            QLog.i("MicrophoneMuteChangeMonitor", 2, "handleMicrophoneMuteChanged no handled case");
        }
    }

    public final void c() {
        if (QLog.isColorLevel()) {
            QLog.i("MicrophoneMuteChangeMonitor", 2, "register mic mute change receiver");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.action.MICROPHONE_MUTE_CHANGED");
        this.mApp.getApplication().registerReceiver(this.mMicrophoneMuteChangeReceiver, intentFilter);
    }

    public final void d() {
        this.mApp.getApplication().unregisterReceiver(this.mMicrophoneMuteChangeReceiver);
    }
}
