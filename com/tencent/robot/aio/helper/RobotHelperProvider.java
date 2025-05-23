package com.tencent.robot.aio.helper;

import com.tencent.aio.api.help.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.api.IAIOFactoryApi;
import com.tencent.robot.aio.helper.tts.RobotTtsAbilityHelper;
import com.tencent.robot.aio.helper.tts.RobotTtsPlayingHelper;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/aio/helper/RobotHelperProvider;", "Lcom/tencent/aio/api/help/d;", "Lcom/tencent/aio/api/help/a;", "param", "", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelperCreator", "Lcom/tencent/aio/main/businesshelper/e;", "getNormalHelperCreator", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotHelperProvider implements com.tencent.aio.api.help.d {
    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
    @Nullable
    public com.tencent.aio.main.businesshelper.h[] getLifeCycleHelper() {
        return d.a.a(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0018, code lost:
    
        r4 = kotlin.collections.MapsKt__MapsKt.minus((java.util.Map) r4, (java.lang.Object[]) new java.lang.String[]{"StickerRecHelper", "AIOChatBackgroundHelper"});
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0028, code lost:
    
        r4 = kotlin.collections.MapsKt__MapsKt.plus(r4, ((com.tencent.qqnt.robot.api.IRobotExtApi) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.qqnt.robot.api.IRobotExtApi.class)).getRobotBaseHelpers());
     */
    @Override // com.tencent.aio.api.help.d
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, Function0<com.tencent.aio.main.businesshelper.h>> getLifeCycleHelperCreator(@NotNull com.tencent.aio.api.help.a param) {
        Map minus;
        Map plus;
        Map mapOf;
        Map<String, Function0<com.tencent.aio.main.businesshelper.h>> plus2;
        Intrinsics.checkNotNullParameter(param, "param");
        Map<String, Function0<com.tencent.aio.main.businesshelper.h>> lifeCycleHelperCreator = ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildHelperProvider().getLifeCycleHelperCreator(param);
        if (lifeCycleHelperCreator != null && minus != null && plus != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("RobotMenuHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new RobotMenuHelper();
                }
            }), TuplesKt.to("RobotBottomSubMenuHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new a();
                }
            }), TuplesKt.to("RobotSubTitleHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new q();
                }
            }), TuplesKt.to("RobotInputStatusHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new RobotInputStatusHelper();
                }
            }), TuplesKt.to("RobotTtsPlayingHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$5
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new RobotTtsPlayingHelper();
                }
            }), TuplesKt.to("RobotCallHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$6
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new d();
                }
            }), TuplesKt.to("RobotEnterEventHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new e();
                }
            }), TuplesKt.to("RobotMsgReportHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$8
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new l();
                }
            }), TuplesKt.to("RobotInputStyleConfigHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$9
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new i();
                }
            }), TuplesKt.to("RobotProfileHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$10
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new RobotProfileHelper();
                }
            }), TuplesKt.to("RobotAutoReadAbilityHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$11
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new RobotTtsAbilityHelper();
                }
            }), TuplesKt.to("RobotNewerGuideHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$12
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new n();
                }
            }), TuplesKt.to("RobotSearchHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$13
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new RobotSearchHelper();
                }
            }), TuplesKt.to("RobotDrawHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$14
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new RobotDrawHelper();
                }
            }), TuplesKt.to("RobotWriteHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$15
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new RobotWriteHelper();
                }
            }), TuplesKt.to("RobotShareSessionHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$16
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new RobotShareSessionHelper();
                }
            }), TuplesKt.to("RobotRromptFunctionHelper", new Function0<com.tencent.aio.main.businesshelper.h>() { // from class: com.tencent.robot.aio.helper.RobotHelperProvider$getLifeCycleHelperCreator$17
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.aio.main.businesshelper.h invoke() {
                    return new RobotRromptFunctionHelper();
                }
            }));
            plus2 = MapsKt__MapsKt.plus(plus, mapOf);
            return plus2;
        }
        return null;
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
    @Nullable
    public com.tencent.aio.main.businesshelper.e[] getNormalHelper() {
        return d.a.d(this);
    }

    @Override // com.tencent.aio.api.help.d
    @Nullable
    public Map<String, Function0<com.tencent.aio.main.businesshelper.e>> getNormalHelperCreator(@NotNull com.tencent.aio.api.help.a param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildHelperProvider().getNormalHelperCreator(param);
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
    @Nullable
    public com.tencent.aio.main.businesshelper.h[] getLifeCycleHelper(@NotNull com.tencent.aio.api.help.a aVar) {
        return d.a.b(this, aVar);
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
    @Nullable
    public com.tencent.aio.main.businesshelper.e[] getNormalHelper(@NotNull com.tencent.aio.api.help.a aVar) {
        return d.a.e(this, aVar);
    }
}
