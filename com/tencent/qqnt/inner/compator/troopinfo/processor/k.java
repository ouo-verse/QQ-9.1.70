package com.tencent.qqnt.inner.compator.troopinfo.processor;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/inner/compator/troopinfo/processor/k;", "Lcom/tencent/qqnt/inner/compator/troopinfo/a;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "b", "c", "a", "", "Z", "hasLuckyCharInfoChanged", "", "J", "originLuckyWordId", "", "I", "originLightCharNum", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class k implements com.tencent.qqnt.inner.compator.troopinfo.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean hasLuckyCharInfoChanged;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long originLuckyWordId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int originLightCharNum;

    public k() {
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
        } else if (this.hasLuckyCharInfoChanged) {
            ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).onLuckyCharInfoChanged();
        }
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void b(@Nullable TroopInfo troopInfo) {
        long j3;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
            return;
        }
        if (troopInfo == null) {
            return;
        }
        GroupExt groupExt = troopInfo.groupExt;
        if (groupExt != null) {
            j3 = groupExt.luckyWordId;
        } else {
            j3 = 0;
        }
        this.originLuckyWordId = j3;
        if (groupExt != null) {
            i3 = groupExt.lightCharNum;
        } else {
            i3 = 0;
        }
        this.originLightCharNum = i3;
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void c(@Nullable TroopInfo troopInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopInfo);
            return;
        }
        if (troopInfo == null) {
            return;
        }
        GroupExt groupExt = troopInfo.groupExt;
        boolean z17 = false;
        if (groupExt != null && this.originLuckyWordId == groupExt.luckyWordId) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (groupExt != null && this.originLightCharNum == groupExt.lightCharNum) {
                z17 = true;
            }
            if (z17) {
                return;
            }
        }
        this.hasLuckyCharInfoChanged = true;
    }
}
