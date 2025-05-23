package com.tencent.qqnt.push.processor;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.config.ah;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "isSuccess", "", "uin", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
final class TroopMemberAddPushProcessor$onPushReceive$1 extends Lambda implements Function2<Boolean, String, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AppRuntime $app;
    final /* synthetic */ String $memberUid;
    final /* synthetic */ int $optType;
    final /* synthetic */ long $troopUin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopMemberAddPushProcessor$onPushReceive$1(int i3, String str, AppRuntime appRuntime, long j3) {
        super(2);
        this.$optType = i3;
        this.$memberUid = str;
        this.$app = appRuntime;
        this.$troopUin = j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, appRuntime, Long.valueOf(j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(long j3, String uin) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).markNewMemberIndexAndUinDailyFromPush(String.valueOf(j3), uin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(long j3, AppRuntime app, String uin) {
        ArrayList<String> arrayList;
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(String.valueOf(j3));
        ITroopInfoService iTroopInfoService = (ITroopInfoService) bg.l(ITroopInfoService.class);
        if (iTroopInfoService != null) {
            arrayList = iTroopInfoService.getTroopMemberForTroopHead(String.valueOf(j3));
        } else {
            arrayList = null;
        }
        ArrayList<String> arrayList2 = arrayList;
        if (troopInfoFromCache != null && arrayList2 != null && troopInfoFromCache.isNewTroop && !troopInfoFromCache.hasSetTroopHead() && (app instanceof AppInterface)) {
            if (arrayList2.size() < 9) {
                ah.a().c((AppInterface) app, String.valueOf(j3), uin, troopInfoFromCache, arrayList2);
            } else {
                ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchNewTroopHeadUinList(String.valueOf(j3));
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
        invoke(bool.booleanValue(), str);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16, @NotNull final String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), uin);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!z16) {
            QLog.e("TroopMemberAddPushProcessor", 1, "onPushReceive: uid to uin failed");
            return;
        }
        int i3 = this.$optType;
        if ((i3 == 2 || i3 == 130 || i3 == 3 || i3 == 131) && !Intrinsics.areEqual(this.$memberUid, this.$app.getCurrentUid())) {
            bg bgVar = bg.f302144a;
            final long j3 = this.$troopUin;
            bgVar.j(new Runnable() { // from class: com.tencent.qqnt.push.processor.d
                @Override // java.lang.Runnable
                public final void run() {
                    TroopMemberAddPushProcessor$onPushReceive$1.c(j3, uin);
                }
            });
        }
        bg bgVar2 = bg.f302144a;
        final long j16 = this.$troopUin;
        final AppRuntime appRuntime = this.$app;
        bgVar2.j(new Runnable() { // from class: com.tencent.qqnt.push.processor.e
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberAddPushProcessor$onPushReceive$1.d(j16, appRuntime, uin);
            }
        });
    }
}
