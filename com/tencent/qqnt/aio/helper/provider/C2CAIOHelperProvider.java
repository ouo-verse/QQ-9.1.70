package com.tencent.qqnt.aio.helper.provider;

import com.tencent.aio.api.help.d;
import com.tencent.mobileqq.vas.aiotip.VasAioDisplayHelper;
import com.tencent.mobileqq.vas.title.VasTitleHelper;
import com.tencent.qqnt.aio.helper.AIOAnimationHelper;
import com.tencent.qqnt.aio.helper.AIOPushDialogHelper;
import com.tencent.qqnt.aio.helper.ArkHelper;
import com.tencent.qqnt.aio.helper.C2CSubTitleHelper;
import com.tencent.qqnt.aio.helper.CallHelper;
import com.tencent.qqnt.aio.helper.NTEmoPanelHelper;
import com.tencent.qqnt.aio.helper.OnlineStatusHelper;
import com.tencent.qqnt.aio.helper.OpenShareB77AIOHelper;
import com.tencent.qqnt.aio.helper.UpComingHelper;
import com.tencent.qqnt.aio.helper.ZPlanCoupleAvatarHelper;
import com.tencent.qqnt.aio.helper.ZplanEntranceHelper;
import com.tencent.qqnt.aio.helper.ac;
import com.tencent.qqnt.aio.helper.al;
import com.tencent.qqnt.aio.helper.at;
import com.tencent.qqnt.aio.helper.ay;
import com.tencent.qqnt.aio.helper.az;
import com.tencent.qqnt.aio.helper.bh;
import com.tencent.qqnt.aio.helper.bq;
import com.tencent.qqnt.aio.helper.cc;
import com.tencent.qqnt.aio.helper.cd;
import com.tencent.qqnt.aio.helper.ci;
import com.tencent.qqnt.aio.helper.cp;
import com.tencent.qqnt.aio.helper.cx;
import com.tencent.qqnt.aio.helper.cz;
import com.tencent.qqnt.aio.helper.db;
import com.tencent.qqnt.aio.helper.dd;
import com.tencent.qqnt.aio.helper.de;
import com.tencent.qqnt.aio.helper.dg;
import com.tencent.qqnt.aio.helper.fo;
import com.tencent.qqnt.aio.helper.x;
import com.tencent.qqnt.aio.helper.y;
import com.tencent.qqnt.aio.helper.z;
import com.tencent.qqnt.aio.util.AIONotificationUtils;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/helper/provider/C2CAIOHelperProvider;", "Lcom/tencent/aio/api/help/d;", "Lcom/tencent/aio/api/help/a;", "param", "", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelperCreator", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class C2CAIOHelperProvider implements com.tencent.aio.api.help.d {
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
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("MsgForwardHelper", new Function0<bq>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final bq invoke() {
                return new bq();
            }
        }), TuplesKt.to("CallHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new CallHelper();
            }
        }), TuplesKt.to("C2CSubTitleHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new C2CSubTitleHelper();
            }
        }), TuplesKt.to("OnlineStatusHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new OnlineStatusHelper();
            }
        }), TuplesKt.to("TitleHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new dg();
            }
        }), TuplesKt.to("AIOAnimationHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new AIOAnimationHelper();
            }
        }), TuplesKt.to("MultiSelectOuterHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new com.tencent.qqnt.aio.helper.multiselect.a();
            }
        }), TuplesKt.to("ZplanEntranceHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ZplanEntranceHelper();
            }
        }), TuplesKt.to("MutualMarkHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new cd();
            }
        }), TuplesKt.to("UpComingHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new UpComingHelper();
            }
        }), TuplesKt.to("VideoPlayHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new fo();
            }
        }), TuplesKt.to("AIOPushDialogHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new AIOPushDialogHelper();
            }
        }), TuplesKt.to("HotPicHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new n61.a();
            }
        }), TuplesKt.to("IceBreakHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new bh();
            }
        }), TuplesKt.to("VasAioDisplayHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new VasAioDisplayHelper();
            }
        }), TuplesKt.to("C2CResignHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ac();
            }
        }), TuplesKt.to("C2CAIOFileHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new z();
            }
        }), TuplesKt.to("PaiYiPaiNTHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$18
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new cz();
            }
        }), TuplesKt.to("BubbleAnimHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$19
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new y();
            }
        }), TuplesKt.to("NTEmoPanelHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$20
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new NTEmoPanelHelper();
            }
        }), TuplesKt.to("VasTitleHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$21
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new VasTitleHelper();
            }
        }), TuplesKt.to("NTPanelIconRedDotHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$22
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ci();
            }
        }), TuplesKt.to("MsgHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$23
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new cc();
            }
        }), TuplesKt.to("OneWayFriendNtHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$24
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new cp();
            }
        }), TuplesKt.to("QWalletAIOHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$25
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new dd();
            }
        }), TuplesKt.to("GameCenterHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$26
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ay();
            }
        }), TuplesKt.to("GameMsgC2CHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$27
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new az();
            }
        }), TuplesKt.to("AvatarObserverHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$28
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new x();
            }
        }), TuplesKt.to("pokeEmotionAniHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$29
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new db();
            }
        }), TuplesKt.to("ArkHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$30
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ArkHelper();
            }
        }), TuplesKt.to("ForwardIMByThirdPartyHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$31
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new at();
            }
        }), TuplesKt.to("NTHiddenChatHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$32
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new com.tencent.mobileqq.app.nthiddenchat.a();
            }
        }), TuplesKt.to("OpenShareB77AIOHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$33
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new OpenShareB77AIOHelper();
            }
        }), TuplesKt.to("CameraHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$34
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new al();
            }
        }), TuplesKt.to("ZPlanCoupleAvatarHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$35
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new ZPlanCoupleAvatarHelper();
            }
        }), TuplesKt.to("SearchEmotionDialogNewHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$36
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new de();
            }
        }), TuplesKt.to("PadCompatHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider$getLifeCycleHelperCreator$37
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.aio.main.businesshelper.h invoke() {
                return new cx();
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
