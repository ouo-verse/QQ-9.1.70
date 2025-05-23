package com.tencent.qqmini.minigame.yungame.va;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.minigame.yungame.va.a;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqmini/minigame/yungame/va/VADownloadDualChannelDelegate;", "Lcom/tencent/qqmini/minigame/yungame/va/a;", "", "process", "", "a", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "b", "reset", "enable", "c", "Lcom/tencent/qqmini/minigame/yungame/va/a$a;", "caller", "d", "Z", "dualChannelGuideSwitch", "hadShowDualChannelTips", "Landroid/os/Handler;", "Landroid/os/Handler;", "uiHandler", "Ljava/util/concurrent/atomic/AtomicInteger;", "e", "Ljava/util/concurrent/atomic/AtomicInteger;", "firstProcess", "f", "currentProcess", "g", "Lcom/tencent/qqmini/minigame/yungame/va/a$a;", "Ljava/lang/Runnable;", h.F, "Ljava/lang/Runnable;", "runnable", "<init>", "()V", "i", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class VADownloadDualChannelDelegate implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean dualChannelGuideSwitch;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean enable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean hadShowDualChannelTips;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Handler uiHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger firstProcess;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger currentProcess;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private a.InterfaceC9397a caller;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Runnable runnable;

    public VADownloadDualChannelDelegate() {
        boolean z16;
        VirtualAppProxy virtualAppProxy = (VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class);
        if (virtualAppProxy != null) {
            z16 = virtualAppProxy.getDualChannelDownloadSwitch();
        } else {
            z16 = false;
        }
        this.dualChannelGuideSwitch = z16;
        this.enable = true;
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.firstProcess = new AtomicInteger(-1);
        this.currentProcess = new AtomicInteger(-1);
        this.runnable = new Runnable() { // from class: com.tencent.qqmini.minigame.yungame.va.VADownloadDualChannelDelegate$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z17;
                AtomicInteger atomicInteger;
                AtomicInteger atomicInteger2;
                a.InterfaceC9397a interfaceC9397a;
                z17 = VADownloadDualChannelDelegate.this.enable;
                if (z17) {
                    atomicInteger = VADownloadDualChannelDelegate.this.currentProcess;
                    int i3 = atomicInteger.get();
                    atomicInteger2 = VADownloadDualChannelDelegate.this.firstProcess;
                    if (i3 - atomicInteger2.get() >= 5) {
                        return;
                    }
                    QMLog.i("VADownloadDualChannelDelegate", "call showDualChannelTips");
                    interfaceC9397a = VADownloadDualChannelDelegate.this.caller;
                    if (interfaceC9397a != null && interfaceC9397a.showDualChannelTips()) {
                        VADownloadDualChannelDelegate.this.hadShowDualChannelTips = true;
                    }
                }
            }
        };
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.a
    public void a(int process) {
        if (!this.dualChannelGuideSwitch && this.enable && !this.hadShowDualChannelTips) {
            if (this.firstProcess.get() != -1) {
                this.currentProcess.set(process);
                return;
            }
            this.firstProcess.set(process);
            this.uiHandler.postDelayed(this.runnable, 18000L);
            QMLog.i("VADownloadDualChannelDelegate", "post dual delay runnable firstProcess:" + this.firstProcess.get());
        }
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.a
    public void b(boolean r36) {
        QMLog.i("VADownloadDualChannelDelegate", "handleDualChannelSwitch switch:" + r36);
        VirtualAppProxy virtualAppProxy = (VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class);
        if (virtualAppProxy != null) {
            virtualAppProxy.updateDualChannelDownloadSwitch(r36);
        }
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.a
    public void c(boolean enable) {
        this.enable = enable;
        reset();
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.a
    public void d(@Nullable a.InterfaceC9397a caller) {
        this.caller = caller;
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.a
    public void reset() {
        if (QMLog.isColorLevel()) {
            QMLog.i("VADownloadDualChannelDelegate", "reset");
        }
        this.firstProcess.set(-1);
        this.currentProcess.set(-1);
        this.uiHandler.removeCallbacks(this.runnable);
    }
}
