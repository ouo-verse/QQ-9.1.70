package com.tencent.icgame.game.initer.impl;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.icgame.game.utils.k;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.app.event.AppBecomeBackgroundEvent;
import com.tencent.timi.game.app.event.AppBecomeForegroundEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/icgame/game/initer/impl/f;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "", "d", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class f implements IGuardInterface {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "TGGroundInterfaceWrapper";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        SimpleEventBus.getInstance().dispatchEvent(new AppBecomeBackgroundEvent(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        SimpleEventBus.getInstance().dispatchEvent(new AppBecomeForegroundEvent(), true);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        QLog.i(this.TAG, 1, "onApplicationBackground");
        k.b(new Runnable() { // from class: com.tencent.icgame.game.initer.impl.e
            @Override // java.lang.Runnable
            public final void run() {
                f.c();
            }
        });
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        QLog.i(this.TAG, 1, "onApplicationForeground");
        k.b(new Runnable() { // from class: com.tencent.icgame.game.initer.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                f.d();
            }
        });
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean isEnabled) {
        QLog.i(this.TAG, 1, "onScreensStateChanged " + isEnabled);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long tick) {
    }
}
