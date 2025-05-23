package com.tencent.qqnt.aio.helper.provider;

import com.tencent.aio.api.help.d;
import com.tencent.mobileqq.activity.aio.helper.TroopAIOTitleIconHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopEggAnimHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopGameNotifyUpdateHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopMemberLevelHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopSettingRedPointHelper;
import com.tencent.mobileqq.activity.aio.helper.aa;
import com.tencent.mobileqq.activity.aio.helper.ag;
import com.tencent.mobileqq.activity.aio.helper.ai;
import com.tencent.mobileqq.activity.aio.helper.ao;
import com.tencent.mobileqq.activity.aio.helper.av;
import com.tencent.mobileqq.activity.aio.helper.ay;
import com.tencent.mobileqq.activity.aio.helper.bb;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.exitoptimise.api.ITroopStateApi;
import com.tencent.mobileqq.troop.halfscreennotification.api.ITroopHalfScreenNotificationApi;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateHelperApi;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameApi;
import com.tencent.mobileqq.troop.troopownertask.api.ITroopOwnerTaskApi;
import com.tencent.mobileqq.troop.troopsquare.api.ITroopSquareApi;
import com.tencent.mobileqq.vas.aiotip.VasAioDisplayHelper;
import com.tencent.qqnt.aio.helper.AIOAnimationHelper;
import com.tencent.qqnt.aio.helper.AIOPushDialogHelper;
import com.tencent.qqnt.aio.helper.ArkHelper;
import com.tencent.qqnt.aio.helper.ClockHelper;
import com.tencent.qqnt.aio.helper.NTEmoPanelHelper;
import com.tencent.qqnt.aio.helper.OpenShareB77AIOHelper;
import com.tencent.qqnt.aio.helper.TroopBirthGiftHelper;
import com.tencent.qqnt.aio.helper.TroopGagHelper;
import com.tencent.qqnt.aio.helper.TroopSimpleInfoHelper;
import com.tencent.qqnt.aio.helper.UpComingHelper;
import com.tencent.qqnt.aio.helper.al;
import com.tencent.qqnt.aio.helper.aw;
import com.tencent.qqnt.aio.helper.ba;
import com.tencent.qqnt.aio.helper.bh;
import com.tencent.qqnt.aio.helper.bq;
import com.tencent.qqnt.aio.helper.cc;
import com.tencent.qqnt.aio.helper.ci;
import com.tencent.qqnt.aio.helper.cx;
import com.tencent.qqnt.aio.helper.cz;
import com.tencent.qqnt.aio.helper.dd;
import com.tencent.qqnt.aio.helper.de;
import com.tencent.qqnt.aio.helper.dg;
import com.tencent.qqnt.aio.helper.dl;
import com.tencent.qqnt.aio.helper.ds;
import com.tencent.qqnt.aio.helper.du;
import com.tencent.qqnt.aio.helper.dw;
import com.tencent.qqnt.aio.helper.dy;
import com.tencent.qqnt.aio.helper.ea;
import com.tencent.qqnt.aio.helper.ed;
import com.tencent.qqnt.aio.helper.ee;
import com.tencent.qqnt.aio.helper.ej;
import com.tencent.qqnt.aio.helper.en;
import com.tencent.qqnt.aio.helper.eq;
import com.tencent.qqnt.aio.helper.ew;
import com.tencent.qqnt.aio.helper.ex;
import com.tencent.qqnt.aio.helper.fb;
import com.tencent.qqnt.aio.helper.fi;
import com.tencent.qqnt.aio.helper.fo;
import com.tencent.qqnt.aio.helper.x;
import com.tencent.qqnt.aio.util.AIONotificationUtils;
import com.tencent.qqnt.helper.ITroopFlameHelperApi;
import com.tencent.qqnt.helper.ITroopHomeworkHelperApi;
import com.tencent.qqnt.helper.ITroopMemberInfoUpdateApi;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/helper/provider/GroupAIOHelperProvider;", "Lcom/tencent/aio/api/help/d;", "Lcom/tencent/aio/api/help/a;", "param", "", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelperCreator", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GroupAIOHelperProvider implements com.tencent.aio.api.help.d {
    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
    public com.tencent.aio.main.businesshelper.h[] getLifeCycleHelper() {
        return d.a.a(this);
    }

    @Override // com.tencent.aio.api.help.d
    public Map<String, Function0<com.tencent.aio.main.businesshelper.h>> getLifeCycleHelperCreator(com.tencent.aio.api.help.a param) {
        Map<String, ? extends Function0<? extends com.tencent.aio.main.businesshelper.h>> mapOf;
        Intrinsics.checkNotNullParameter(param, "param");
        AIONotificationUtils aIONotificationUtils = AIONotificationUtils.f352237a;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("MsgForwardHelper", new Function0<bq>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final bq invoke() {
                return new bq();
            }
        }), TuplesKt.to("ClockHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ClockHelper();
            }
        }), TuplesKt.to("MultiSelectOuterHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new com.tencent.qqnt.aio.helper.multiselect.a();
            }
        }), TuplesKt.to("TroopSubTitleHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new fi();
            }
        }), TuplesKt.to("TitleHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new dg();
            }
        }), TuplesKt.to("AIOShortcutBarHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new AIOShortcutBarHelper();
            }
        }), TuplesKt.to("TroopNotificationAIOHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ew();
            }
        }), TuplesKt.to("TroopRedTipHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ay();
            }
        }), TuplesKt.to("TroopSettingRedPointHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new TroopSettingRedPointHelper();
            }
        }), TuplesKt.to("TroopBlockHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ds();
            }
        }), TuplesKt.to("UpComingHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new UpComingHelper();
            }
        }), TuplesKt.to("VideoPlayHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new fo();
            }
        }), TuplesKt.to("AIOAnimationHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new AIOAnimationHelper();
            }
        }), TuplesKt.to("TroopGameGuideHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ao();
            }
        }), TuplesKt.to("TroopGameNotifyUpdateHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new TroopGameNotifyUpdateHelper();
            }
        }), TuplesKt.to("AIOPushDialogHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new AIOPushDialogHelper();
            }
        }), TuplesKt.to("TroopAIOTitleIconHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new TroopAIOTitleIconHelper();
            }
        }), TuplesKt.to("IceBreakHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$18
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new bh();
            }
        }), TuplesKt.to("TroopGiftHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$19
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ee();
            }
        }), TuplesKt.to("TroopBirthGiftHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$20
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new TroopBirthGiftHelper();
            }
        }), TuplesKt.to("TroopGiftAnimPlayHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$21
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ed();
            }
        }), TuplesKt.to("TroopAppHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$22
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new dl();
            }
        }), TuplesKt.to("VasAioDisplayHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$23
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new VasAioDisplayHelper();
            }
        }), TuplesKt.to("PaiYiPaiNTHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$24
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new cz();
            }
        }), TuplesKt.to("TroopResignHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$25
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ex();
            }
        }), TuplesKt.to("TroopSimpleInfoHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$26
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new TroopSimpleInfoHelper();
            }
        }), TuplesKt.to("TroopFansHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$27
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new dy();
            }
        }), TuplesKt.to("TroopEssenceMsgHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$28
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new dw();
            }
        }), TuplesKt.to("TroopMemberLevelHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$29
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new TroopMemberLevelHelper();
            }
        }), TuplesKt.to("TroopMemberNickIconHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$30
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new av();
            }
        }), TuplesKt.to("QCircleTroopRedDotHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$31
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new aa();
            }
        }), TuplesKt.to("TroopGagHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$32
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new TroopGagHelper();
            }
        }), TuplesKt.to("TroopJoinStateHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$33
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return ((ITroopStateApi) QRoute.api(ITroopStateApi.class)).createJoinStateHelper();
            }
        }), TuplesKt.to("TroopUiStateManageHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$34
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return ((ITroopStateApi) QRoute.api(ITroopStateApi.class)).createAioUIStateManageHelper();
            }
        }), TuplesKt.to("TroopGuildHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$35
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ej();
            }
        }), TuplesKt.to("TroopGuildUpgradeHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$36
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new en();
            }
        }), TuplesKt.to("TroopFileHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$37
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ea();
            }
        }), TuplesKt.to("NTEmoPanelHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$38
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new NTEmoPanelHelper();
            }
        }), TuplesKt.to("TroopAIONickIconHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$39
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ag();
            }
        }), TuplesKt.to("NTPanelIconRedDotHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$40
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ci();
            }
        }), TuplesKt.to("MsgHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$41
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new cc();
            }
        }), TuplesKt.to("TroopEffectHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$42
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new du();
            }
        }), TuplesKt.to("QWalletAIOHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$43
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new dd();
            }
        }), TuplesKt.to("GameCenterGroupHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$44
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new aw();
            }
        }), TuplesKt.to("GameMsgGroupHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$45
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ba();
            }
        }), TuplesKt.to("AvatarObserverHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$46
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new x();
            }
        }), TuplesKt.to("ArkHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$47
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ArkHelper();
            }
        }), TuplesKt.to("NTHiddenChatHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$48
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new com.tencent.mobileqq.app.nthiddenchat.a();
            }
        }), TuplesKt.to("TroopEggAnimHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$49
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new TroopEggAnimHelper();
            }
        }), TuplesKt.to("TroopAppShortCutNavBarHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$50
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ai();
            }
        }), TuplesKt.to("OpenShareB77AIOHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$51
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new OpenShareB77AIOHelper();
            }
        }), TuplesKt.to("TroopBatchAddFriendHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$52
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new com.tencent.mobileqq.troopAddFrd.nt.e();
            }
        }), TuplesKt.to("TroopOwnerTaskHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$53
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return ((ITroopOwnerTaskApi) QRoute.api(ITroopOwnerTaskApi.class)).createHelper();
            }
        }), TuplesKt.to("CameraHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$54
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new al();
            }
        }), TuplesKt.to("TroopInputSlashHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$55
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new eq();
            }
        }), TuplesKt.to("SearchEmotionDialogNewHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$56
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new de();
            }
        }), TuplesKt.to("TroopRobotFunctionHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$57
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new fb();
            }
        }), TuplesKt.to("TroopUnbindGameGroupHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$58
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new bb();
            }
        }), TuplesKt.to("PadCompatHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$59
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new cx();
            }
        }), TuplesKt.to("TroopMemberInfoUpdateHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$60
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return ((ITroopMemberInfoUpdateApi) QRoute.api(ITroopMemberInfoUpdateApi.class)).createHelper();
            }
        }), TuplesKt.to("TroopGameHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$61
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return ((ITroopGameApi) QRoute.api(ITroopGameApi.class)).createHelper();
            }
        }), TuplesKt.to("TroopAIOTitleFlameHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$62
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return ((ITroopFlameHelperApi) QRoute.api(ITroopFlameHelperApi.class)).createHelper();
            }
        }), TuplesKt.to("TroopHomeworkCheckRoleHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$63
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return ((ITroopHomeworkHelperApi) QRoute.api(ITroopHomeworkHelperApi.class)).createHelper();
            }
        }), TuplesKt.to("TroopSquareAIOHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$64
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return ((ITroopSquareApi) QRoute.api(ITroopSquareApi.class)).createAIOHelper();
            }
        }), TuplesKt.to("TroopCreateAIOShareHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$65
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return ((ITroopCreateHelperApi) QRoute.api(ITroopCreateHelperApi.class)).createHelper();
            }
        }), TuplesKt.to("TroopAIVoiceChatHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$66
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new yr2.a();
            }
        }), TuplesKt.to("TroopEnterAIONotificationHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider$getLifeCycleHelperCreator$67
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return ((ITroopHalfScreenNotificationApi) QRoute.api(ITroopHalfScreenNotificationApi.class)).createHelper();
            }
        }));
        return com.tencent.qqnt.aio.util.a.a(aIONotificationUtils.c(aIONotificationUtils.b(mapOf)), com.tencent.mobileqq.springhb.interactive.b.f289214a.b(param));
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
    public com.tencent.aio.main.businesshelper.e[] getNormalHelper() {
        return d.a.d(this);
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u7981\u6b62\u6dfb\u52a0NormalHelper", replaceWith = @ReplaceWith(expression = "UseCase", imports = {}))
    public Map<String, Function0<com.tencent.aio.main.businesshelper.e>> getNormalHelperCreator(com.tencent.aio.api.help.a aVar) {
        return d.a.f(this, aVar);
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
    public com.tencent.aio.main.businesshelper.h[] getLifeCycleHelper(com.tencent.aio.api.help.a aVar) {
        return d.a.b(this, aVar);
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
    public com.tencent.aio.main.businesshelper.e[] getNormalHelper(com.tencent.aio.api.help.a aVar) {
        return d.a.e(this, aVar);
    }
}
