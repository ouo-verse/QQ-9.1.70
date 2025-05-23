package com.tencent.qqnt.inner.compator.troopinfo.processor;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.troop.ITroopGagUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/inner/compator/troopinfo/processor/h;", "Lcom/tencent/qqnt/inner/compator/troopinfo/a;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "b", "c", "a", "", "J", "originGagTime", "originGagMeTime", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class h implements com.tencent.qqnt.inner.compator.troopinfo.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long originGagTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long originGagMeTime;

    public h() {
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
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
            return;
        }
        long j16 = 0;
        if (troopInfo != null) {
            j3 = troopInfo.dwGagTimeStamp;
        } else {
            j3 = 0;
        }
        this.originGagTime = j3;
        if (troopInfo != null) {
            j16 = troopInfo.dwGagTimeStamp_me;
        }
        this.originGagMeTime = j16;
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void c(@Nullable TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopInfo);
            return;
        }
        if (troopInfo != null && this.originGagTime != troopInfo.dwGagTimeStamp) {
            ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).onPushTroopGagMsg(troopInfo);
        }
        if (troopInfo != null && this.originGagMeTime != troopInfo.dwGagTimeStamp_me) {
            ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).onPushMeGagMsg(troopInfo);
        }
    }
}
