package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0016\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0006\u0010\r\u001a\u00020\u0002R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/k;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "", "tick", "onBackgroundTimeTick", "", "isEnabled", "onScreensStateChanged", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "onApplicationBackground", "a", "Lcom/tencent/mobileqq/qqexpand/utils/o;", "d", "Lcom/tencent/mobileqq/qqexpand/utils/o;", "getApplicationBackgroundListener", "()Lcom/tencent/mobileqq/qqexpand/utils/o;", "setApplicationBackgroundListener", "(Lcom/tencent/mobileqq/qqexpand/utils/o;)V", "applicationBackgroundListener", "<init>", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class k implements IGuardInterface {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private o applicationBackgroundListener;

    public k(o oVar) {
        this.applicationBackgroundListener = oVar;
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        o oVar = this.applicationBackgroundListener;
        if (oVar != null) {
            oVar.onBackground();
        }
    }

    public final void a() {
        this.applicationBackgroundListener = null;
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

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean isEnabled) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
    }
}
