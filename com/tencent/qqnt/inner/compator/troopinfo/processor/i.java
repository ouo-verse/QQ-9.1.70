package com.tencent.qqnt.inner.compator.troopinfo.processor;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.troop.utils.bg;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/inner/compator/troopinfo/processor/i;", "Lcom/tencent/qqnt/inner/compator/troopinfo/a;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "b", "info", "c", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class i implements com.tencent.qqnt.inner.compator.troopinfo.a {
    static IPatchRedirector $redirector_;

    public i() {
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
        }
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void c(@Nullable TroopInfo info) {
        AppInterface e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) info);
        } else if (info != null && (e16 = bg.e()) != null) {
            ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).setTroopGameCardRedPoint(e16.getCurrentUin(), info.troopuin, info.isTroopGameCardEnabled());
        }
    }
}
