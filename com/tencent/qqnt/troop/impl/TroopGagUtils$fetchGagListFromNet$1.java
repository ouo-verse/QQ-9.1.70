package com.tencent.qqnt.troop.impl;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqnt.troopmemberlist.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\n\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "isSuccess", "", "uin2ShuntUpTime", "", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class TroopGagUtils$fetchGagListFromNet$1 extends Lambda implements Function2<Boolean, Map<String, ? extends Long>, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ LifecycleOwner $owner;
    final /* synthetic */ String $troopUin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopGagUtils$fetchGagListFromNet$1(String str, LifecycleOwner lifecycleOwner) {
        super(2);
        this.$troopUin = str;
        this.$owner = lifecycleOwner;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) lifecycleOwner);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String str, boolean z16, List troopMemberList) {
        Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        if (z16) {
            TroopGagUtils.INSTANCE.notifyGagStatusUI(str, troopMemberList);
        } else {
            QLog.e("TroopGagUtilsImpl", 2, "fetchTroopMemberGagListFromNet: fetchTroopMemberUinListInfo error");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Map<String, ? extends Long> map) {
        invoke(bool.booleanValue(), (Map<String, Long>) map);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16, @NotNull Map<String, Long> uin2ShuntUpTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), uin2ShuntUpTime);
            return;
        }
        Intrinsics.checkNotNullParameter(uin2ShuntUpTime, "uin2ShuntUpTime");
        if (z16) {
            ArrayList arrayList = new ArrayList(uin2ShuntUpTime.keySet());
            ITroopMemberListRepoApi iTroopMemberListRepoApi = (ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class);
            final String str = this.$troopUin;
            iTroopMemberListRepoApi.fetchTroopMemberUinListInfo(str, arrayList, false, this.$owner, "TroopGagUtilsImpl", new f() { // from class: com.tencent.qqnt.troop.impl.d
                @Override // com.tencent.qqnt.troopmemberlist.f
                public final void a(boolean z17, List list) {
                    TroopGagUtils$fetchGagListFromNet$1.b(str, z17, list);
                }
            });
            return;
        }
        QLog.e("TroopGagUtilsImpl", 2, "fetchTroopMemberGagListFromNet: fetchTroopMemberGapInfo error");
    }
}
