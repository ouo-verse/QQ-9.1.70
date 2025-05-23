package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.gamecenter.api.ISearchPopService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.preload.SpringHbPreloadManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/app/automator/step/HongbaoConfigLoadStep;", "Lcom/tencent/mobileqq/app/automator/AsyncStep;", "Lcom/tencent/mobileqq/app/automator/Automator;", "()V", "doStep", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class HongbaoConfigLoadStep extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public HongbaoConfigLoadStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        SpringHbPreloadManager springHbPreloadManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("IAutomator", 2, "HongbaoConfigLoadStep execute reconnect!");
        }
        Manager manager = ((Automator) this.mAutomator).E.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.springhb.config.SpringHbEntranceConfigManager");
        ((com.tencent.mobileqq.springhb.config.g) manager).f(((Automator) this.mAutomator).E, 1);
        Manager manager2 = ((Automator) this.mAutomator).E.getManager(QQManagerFactory.SPRING_HB_PRELOAD_MANAGER);
        if (manager2 instanceof SpringHbPreloadManager) {
            springHbPreloadManager = (SpringHbPreloadManager) manager2;
        } else {
            springHbPreloadManager = null;
        }
        if (springHbPreloadManager != null) {
            springHbPreloadManager.v(false, 2);
        }
        ISearchPopService iSearchPopService = (ISearchPopService) ((Automator) this.mAutomator).E.getRuntimeService(ISearchPopService.class, "all");
        if (iSearchPopService != null) {
            iSearchPopService.requestPreloadConfig(false);
            return 7;
        }
        return 7;
    }
}
