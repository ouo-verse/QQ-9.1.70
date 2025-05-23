package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.av.business.handler.MobileNetSwitchHandler;
import com.tencent.av.utils.ax;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0002\f\u001bB\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u001a\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\u00060\u0013R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/av/app/MobileNetSwitchMonitor;", "", "Landroid/content/Intent;", "intent", "", "e", "d", "f", tl.h.F, "Lcom/tencent/av/app/VideoAppInterface;", "app", "g", "a", "Lcom/tencent/av/app/VideoAppInterface;", "c", "()Lcom/tencent/av/app/VideoAppInterface;", "setMApp", "(Lcom/tencent/av/app/VideoAppInterface;)V", "mApp", "Lcom/tencent/av/app/MobileNetSwitchMonitor$MobileNetSwitchReceiver;", "b", "Lcom/tencent/av/app/MobileNetSwitchMonitor$MobileNetSwitchReceiver;", "mMobileNetSwitchReceiver", "Llu/a;", "Llu/a;", "mMobileNetObserver", "<init>", "MobileNetSwitchReceiver", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class MobileNetSwitchMonitor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VideoAppInterface mApp;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MobileNetSwitchReceiver mMobileNetSwitchReceiver;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final lu.a mMobileNetObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/av/app/MobileNetSwitchMonitor$MobileNetSwitchReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/tencent/av/app/MobileNetSwitchMonitor;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final class MobileNetSwitchReceiver extends BroadcastReceiver {
        public MobileNetSwitchReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            if (intent != null) {
                MobileNetSwitchMonitor mobileNetSwitchMonitor = MobileNetSwitchMonitor.this;
                String action = intent.getAction();
                if (action != null) {
                    int hashCode = action.hashCode();
                    if (hashCode != -1013799216) {
                        if (hashCode == -175395106 && action.equals("mqq.intent.action.LAUNCH_com.tencent.mobileqq:video")) {
                            mobileNetSwitchMonitor.d();
                            return;
                        }
                        return;
                    }
                    if (action.equals("com.tencent.av.MOBILE_NET_SWITCH")) {
                        mobileNetSwitchMonitor.e(intent);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/av/app/MobileNetSwitchMonitor$b", "Llu/a;", "", "isSuccess", "", "data", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b extends lu.a {
        b() {
        }

        @Override // lu.a
        public void a(boolean isSuccess, @Nullable Object data) {
            if (QLog.isColorLevel()) {
                QLog.i("MobileNetSwitchObserver", 2, "onUpdateGetMobileNetSwitch isSuc: " + isSuccess);
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if ((peekAppRuntime instanceof VideoAppInterface) && isSuccess && (data instanceof Integer)) {
                boolean z16 = false;
                if (Intrinsics.areEqual(data, (Object) 0) || Intrinsics.areEqual(data, (Object) 2)) {
                    z16 = true;
                }
                VideoAppInterface videoAppInterface = (VideoAppInterface) peekAppRuntime;
                ea.X2(videoAppInterface.getCurrentUin(), z16);
                if (QLog.isColorLevel()) {
                    QLog.i("MobileNetSwitchObserver", 2, "onUpdateGetMobileNetSwitch setAgreeUseCellularForQuality from server: " + z16);
                }
                com.tencent.av.r h06 = com.tencent.av.r.h0();
                if (h06 != null) {
                    h06.E2(z16);
                }
                if (videoAppInterface.containObserver(this, true)) {
                    MobileNetSwitchMonitor.this.getMApp().removeObserver(this);
                }
            }
        }
    }

    public MobileNetSwitchMonitor(@NotNull VideoAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        this.mApp = app;
        this.mMobileNetSwitchReceiver = new MobileNetSwitchReceiver();
        this.mMobileNetObserver = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof VideoAppInterface) {
            g((VideoAppInterface) peekAppRuntime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d("MobileNetSwitchMonitor", 2, "MobileNetSwitchReceiver handle MOBILE_NET_SWITCH");
        }
        boolean booleanExtra = intent.getBooleanExtra("key_mobile_net_switch", false);
        if (com.tencent.av.r.h0() != null) {
            if (QLog.isColorLevel()) {
                QLog.d("MobileNetSwitchMonitor", 2, "MobileNetSwitchReceiver setAgreeUseCellularForQuality isAgree: " + booleanExtra);
            }
            com.tencent.av.r.h0().E2(booleanExtra);
        }
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final VideoAppInterface getMApp() {
        return this.mApp;
    }

    public final void f() {
        if (QLog.isColorLevel()) {
            QLog.d("MobileNetSwitchMonitor", 2, "register mobile net switch receiver");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.av.MOBILE_NET_SWITCH");
        intentFilter.addAction("mqq.intent.action.LAUNCH_com.tencent.mobileqq:video");
        this.mApp.getApplication().registerReceiver(this.mMobileNetSwitchReceiver, intentFilter);
    }

    public final void g(@NotNull VideoAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        if (!ax.b()) {
            if (QLog.isColorLevel()) {
                QLog.i("MobileNetSwitchMonitor", 2, "setMobileNetSupport setAgreeUseCellularForQuality toggle false");
            }
            com.tencent.av.r h06 = com.tencent.av.r.h0();
            if (h06 != null) {
                h06.E2(false);
                return;
            }
            return;
        }
        boolean n26 = ea.n2(app.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
            QLog.i("MobileNetSwitchMonitor", 2, "setMobileNetSupport setAgreeUseCellularForQuality from cache: " + n26);
        }
        com.tencent.av.r h07 = com.tencent.av.r.h0();
        if (h07 != null) {
            h07.E2(n26);
        }
        if (!app.containObserver(this.mMobileNetObserver, true)) {
            app.addObserver(this.mMobileNetObserver);
        }
        BusinessHandler businessHandler = this.mApp.getBusinessHandler(MobileNetSwitchHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.av.business.handler.MobileNetSwitchHandler");
        ((MobileNetSwitchHandler) businessHandler).D2();
    }

    public final void h() {
        this.mApp.getApplication().unregisterReceiver(this.mMobileNetSwitchReceiver);
    }
}
