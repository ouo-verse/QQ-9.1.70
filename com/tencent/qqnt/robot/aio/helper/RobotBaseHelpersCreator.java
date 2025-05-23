package com.tencent.qqnt.robot.aio.helper;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.title.VasTitleHelper;
import com.tencent.qqnt.aio.api.IQQShowTofu;
import com.tencent.qqnt.aio.helper.AIOPushDialogHelper;
import com.tencent.qqnt.aio.helper.ArkHelper;
import com.tencent.qqnt.aio.helper.C2CRobotMsgHelper;
import com.tencent.qqnt.aio.helper.NTEmoPanelHelper;
import com.tencent.qqnt.aio.helper.UinUidUpdateHelper;
import com.tencent.qqnt.aio.helper.UpComingHelper;
import com.tencent.qqnt.aio.helper.ac;
import com.tencent.qqnt.aio.helper.ad;
import com.tencent.qqnt.aio.helper.at;
import com.tencent.qqnt.aio.helper.ay;
import com.tencent.qqnt.aio.helper.bq;
import com.tencent.qqnt.aio.helper.cc;
import com.tencent.qqnt.aio.helper.dg;
import com.tencent.qqnt.aio.helper.fo;
import com.tencent.qqnt.aio.helper.multiselect.j;
import com.tencent.qqnt.aio.helper.x;
import com.tencent.qqnt.aio.helper.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/robot/aio/helper/RobotBaseHelpersCreator;", "", "", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RobotBaseHelpersCreator {
    public final Map<String, Function0<h>> a() {
        Map<String, Function0<h>> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("MsgForwardHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new bq();
            }
        }), TuplesKt.to("TitleHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new dg();
            }
        }), TuplesKt.to("VasTitleHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new VasTitleHelper();
            }
        }), TuplesKt.to("MultiSelectOuterHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new com.tencent.qqnt.aio.helper.multiselect.a();
            }
        }), TuplesKt.to("RobotMultiSelectOuterHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new j();
            }
        }), TuplesKt.to("UpComingHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new UpComingHelper();
            }
        }), TuplesKt.to("VideoPlayHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new fo();
            }
        }), TuplesKt.to("AIOPushDialogHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new AIOPushDialogHelper();
            }
        }), TuplesKt.to("BubbleAnimHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new y();
            }
        }), TuplesKt.to("NTEmoPanelHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new NTEmoPanelHelper();
            }
        }), TuplesKt.to("AvatarObserverHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new x();
            }
        }), TuplesKt.to("MsgHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new cc();
            }
        }), TuplesKt.to("GameCenterHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new ay();
            }
        }), TuplesKt.to("ArkHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new ArkHelper();
            }
        }), TuplesKt.to("ForwardIMByThirdPartyHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new at();
            }
        }), TuplesKt.to("NTHiddenChatHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new com.tencent.mobileqq.app.nthiddenchat.a();
            }
        }), TuplesKt.to("UinUidUpdateHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new UinUidUpdateHelper();
            }
        }), TuplesKt.to("C2CResignHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$18
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new ac();
            }
        }), TuplesKt.to("C2CRobotMsgHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$19
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new C2CRobotMsgHelper();
            }
        }), TuplesKt.to("C2CInputSlashHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$20
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new ad();
            }
        }), TuplesKt.to("RobotTitleHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$21
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new a();
            }
        }), TuplesKt.to("AIOTofuMsgHelper", new Function0<h>() { // from class: com.tencent.qqnt.robot.aio.helper.RobotBaseHelpersCreator$create$22
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return ((IQQShowTofu) QRoute.api(IQQShowTofu.class)).getAIOTofuHelper();
            }
        }));
        return mapOf;
    }
}
