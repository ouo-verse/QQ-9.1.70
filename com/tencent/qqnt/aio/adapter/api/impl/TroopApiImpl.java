package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatVB;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagService;
import com.tencent.mobileqq.troop.troopsquare.api.ITroopSquareApi;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.ITroopApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtFlameData;
import com.tencent.qqnt.kernel.nativeinterface.GroupInfoSource;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J(\u0010\u001c\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\"\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020 \u0012\u0006\b\u0001\u0012\u00020!0\u001fH\u0016\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/TroopApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/ITroopApi;", "", "uin", "", "isExitTroop", "troopUin", "isTroopMember", "memberUin", "isTroopOwner", "Landroid/content/Context;", "context", "peerUinStr", "", "goToAppealForTempBlock", "isGagMode", "groupUin", "openGroupProfile", "showExitTroopPinToTopMsg", "ext", "openTroopSquarePage", "", "groupCode", "clearGroupSquareRedpointCache", "event", "", "", "params", "troopBeaconReport", "isTroopSquareSwitchOn", "hasTroopFlame", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "getAIVoiceChatVB", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TroopApiImpl implements ITroopApi {
    public static final String TAG = "TroopApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.tencent.mobileqq.data.troop.TroopInfo] */
    public static final void showExitTroopPinToTopMsg$lambda$3$lambda$2(Ref.ObjectRef troopInfo, ITroopInfoService troopInfoService, String troopUin, Function1 next, int i3, String str) {
        Intrinsics.checkNotNullParameter(troopInfo, "$troopInfo");
        Intrinsics.checkNotNullParameter(troopInfoService, "$troopInfoService");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(next, "$next");
        ?? findTroopInfo = troopInfoService.findTroopInfo(troopUin);
        troopInfo.element = findTroopInfo;
        if (findTroopInfo == 0) {
            QLog.i("TroopApiImpl", 1, "[showExitTroopPinToTopMsg] troopInfo is null, troopUin:" + troopUin);
        }
        TroopInfo troopInfo2 = (TroopInfo) troopInfo.element;
        if (troopInfo2 != null) {
            next.invoke(troopInfo2);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> getAIVoiceChatVB() {
        return new TroopAIVoiceChatVB();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public void goToAppealForTempBlock(Context context, String peerUinStr) {
        Intrinsics.checkNotNullParameter(peerUinStr, "peerUinStr");
        ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).goToAppealForTempBlock(context, peerUinStr);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public boolean hasTroopFlame(String troopUin) {
        GroupExtFlameData groupExtFlameData;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        TroopInfo findTroopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(troopUin, false, false);
        return ((findTroopInfo != null ? findTroopInfo.groupExt : null) == null || (groupExtFlameData = findTroopInfo.groupExt.groupExtFlameData) == null || groupExtFlameData.switchState != 1 || groupExtFlameData.state == 0) ? false : true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public boolean isExitTroop(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        QRouteApi api = QRoute.api(ITroopListRepoApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopListRepoApi::class.java)");
        return ITroopListRepoApi.a.b((ITroopListRepoApi) api, uin, "TroopApiImpl", false, 4, null);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public boolean isGagMode(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d("TroopApiImpl", 1, "isGagMode app is null");
            return false;
        }
        boolean z16 = ((ITroopGagService) peekAppRuntime.getRuntimeService(ITroopGagService.class, "")).getSelfGagInfo(uin, true).f300235b;
        QLog.d("TroopApiImpl", 1, "isGagMode " + z16);
        return z16;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public boolean isTroopMember(String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        TroopInfo troopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(troopUin);
        return troopInfoFromCache != null && troopInfoFromCache.hadJoinTroop();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public boolean isTroopOwner(String troopUin, String memberUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        TroopInfo troopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(troopUin);
        return troopInfoFromCache != null && troopInfoFromCache.isTroopOwner(memberUin);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public boolean isTroopSquareSwitchOn(String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return ((ITroopSquareApi) QRoute.api(ITroopSquareApi.class)).isSwitchOn(troopUin);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public void openGroupProfile(Context context, String groupUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopInfoActivity(context, ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getTroopProfileExtra(groupUin, 0), 2);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public void openTroopSquarePage(String troopUin, String ext) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(ext, "ext");
        ((ITroopSquareApi) QRoute.api(ITroopSquareApi.class)).openSquarePage(troopUin, ext);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.Object, com.tencent.mobileqq.data.troop.TroopInfo] */
    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public void showExitTroopPinToTopMsg(final String troopUin) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("TroopApiImpl", 1, "[showExitTroopPinToTopMsg] app is null");
            return;
        }
        final TroopApiImpl$showExitTroopPinToTopMsg$next$1 troopApiImpl$showExitTroopPinToTopMsg$next$1 = TroopApiImpl$showExitTroopPinToTopMsg$next$1.INSTANCE;
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        final ITroopInfoService iTroopInfoService = (ITroopInfoService) runtimeService;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? troopInfo = iTroopInfoService.findTroopInfo(troopUin);
        objectRef.element = troopInfo;
        if (troopInfo == 0) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
            if (longOrNull != null) {
                long longValue = longOrNull.longValue();
                com.tencent.qqnt.kernel.api.s i3 = com.tencent.mobileqq.troop.utils.bg.i(null, 1, null);
                if (i3 != null) {
                    i3.getGroupDetailInfo(longValue, GroupInfoSource.KAIO, new IOperateCallback() { // from class: com.tencent.qqnt.aio.adapter.api.impl.bf
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i16, String str) {
                            TroopApiImpl.showExitTroopPinToTopMsg$lambda$3$lambda$2(Ref.ObjectRef.this, iTroopInfoService, troopUin, troopApiImpl$showExitTroopPinToTopMsg$next$1, i16, str);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        Intrinsics.checkNotNullExpressionValue(troopInfo, "troopInfo");
        troopApiImpl$showExitTroopPinToTopMsg$next$1.invoke((TroopApiImpl$showExitTroopPinToTopMsg$next$1) troopInfo);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public void troopBeaconReport(String event, Map<String, ? extends Object> params) {
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report(event, params);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITroopApi
    public void clearGroupSquareRedpointCache(long groupCode) {
        com.tencent.qqnt.kernel.api.s i3 = com.tencent.mobileqq.troop.utils.bg.i(null, 1, null);
        if (i3 != null) {
            i3.clearGroupSquareRedpointCache(groupCode);
        }
    }
}
