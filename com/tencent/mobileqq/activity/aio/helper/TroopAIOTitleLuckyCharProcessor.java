package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterService;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.aio.adapter.api.IGuildTroopApi;
import com.tencent.troopguild.api.ITroopGuildApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/helper/TroopAIOTitleLuckyCharProcessor;", "Lcom/tencent/mobileqq/activity/aio/helper/p;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "troopUin", "", tl.h.F, "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/aio/title/ae;", "d", "", "g", "<init>", "()V", "c", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class TroopAIOTitleLuckyCharProcessor extends p {
    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Activity activity, String troopUin) {
        String replace$default;
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        replace$default = StringsKt__StringsJVMKt.replace$default("https://qun.qq.com/v2/luckyword/index?qunid={GROUPCODE}&_wv=67108865&_nav_txtclr=FFFFFF&_wvSb=0&source=enter", "{GROUPCODE}", troopUin, false, 4, (Object) null);
        intent.putExtra("url", replace$default);
        activity.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.activity.aio.helper.p
    @NotNull
    public Pair<com.tencent.mobileqq.aio.title.ae, com.tencent.mobileqq.aio.title.ae> d(@NotNull final Activity activity, @NotNull final TroopInfo troopInfo) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        String str;
        boolean z16;
        Pair<com.tencent.mobileqq.aio.title.ae, com.tencent.mobileqq.aio.title.ae> pair;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(ITroopLuckyCharacterService.class, "");
        } else {
            iRuntimeService = null;
        }
        ITroopLuckyCharacterService iTroopLuckyCharacterService = (ITroopLuckyCharacterService) iRuntimeService;
        if (iTroopLuckyCharacterService != null) {
            str = iTroopLuckyCharacterService.getLuckyCharacterPicUrl(troopInfo);
        } else {
            str = null;
        }
        boolean isTroopGuildSwitchOpen = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuildSwitchOpen(troopInfo.getTroopUin());
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return new Pair<>(null, null);
        }
        if (isTroopGuildSwitchOpen) {
            if (!((IGuildTroopApi) QRoute.api(IGuildTroopApi.class)).isNeedHideTroopGuildEntrance()) {
                return new Pair<>(null, null);
            }
            pair = new Pair<>(c(str, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.aio.helper.TroopAIOTitleLuckyCharProcessor$getMutualMarkDataPair$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    TroopAIOTitleLuckyCharProcessor troopAIOTitleLuckyCharProcessor = TroopAIOTitleLuckyCharProcessor.this;
                    Activity activity2 = activity;
                    String troopUin = troopInfo.getTroopUin();
                    Intrinsics.checkNotNullExpressionValue(troopUin, "troopInfo.troopUin");
                    troopAIOTitleLuckyCharProcessor.h(activity2, troopUin);
                }
            }), null);
        } else {
            pair = new Pair<>(c(str, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.aio.helper.TroopAIOTitleLuckyCharProcessor$getMutualMarkDataPair$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    TroopAIOTitleLuckyCharProcessor troopAIOTitleLuckyCharProcessor = TroopAIOTitleLuckyCharProcessor.this;
                    Activity activity2 = activity;
                    String troopUin = troopInfo.getTroopUin();
                    Intrinsics.checkNotNullExpressionValue(troopUin, "troopInfo.troopUin");
                    troopAIOTitleLuckyCharProcessor.h(activity2, troopUin);
                }
            }), null);
        }
        return pair;
    }

    public int g() {
        return 0;
    }
}
