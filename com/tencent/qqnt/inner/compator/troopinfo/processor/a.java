package com.tencent.qqnt.inner.compator.troopinfo.processor;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/inner/compator/troopinfo/processor/a;", "Lcom/tencent/qqnt/inner/compator/troopinfo/a;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "b", "c", "a", "", "J", "originFlagEx2", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements com.tencent.qqnt.inner.compator.troopinfo.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long originFlagEx2;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void b(@Nullable TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
        } else {
            if (troopInfo == null) {
                return;
            }
            this.originFlagEx2 = troopInfo.cmdUinFlagEx2;
        }
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void c(@Nullable TroopInfo troopInfo) {
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopInfo);
            return;
        }
        if (troopInfo == null) {
            return;
        }
        long j3 = this.originFlagEx2;
        if (j3 == troopInfo.cmdUinFlagEx2 || TroopInfo.isCmdUinFlagEx2Open(j3, 512) == TroopInfo.isCmdUinFlagEx2Open(troopInfo.cmdUinFlagEx2, 512) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).updateHiddenChat(peekAppRuntime, troopInfo);
    }
}
