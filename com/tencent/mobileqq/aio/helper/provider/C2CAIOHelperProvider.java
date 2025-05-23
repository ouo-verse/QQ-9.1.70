package com.tencent.mobileqq.aio.helper.provider;

import com.tencent.aio.api.help.d;
import com.tencent.aio.main.businesshelper.e;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.helper.w;
import com.tencent.mobileqq.aio.notification.IAIONotificationApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
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

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/provider/C2CAIOHelperProvider;", "Lcom/tencent/aio/api/help/d;", "Lcom/tencent/aio/api/help/a;", "param", "", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelperCreator", "", "Lcom/tencent/aio/main/businesshelper/e;", "getNormalHelper", "()[Lcom/tencent/aio/main/businesshelper/e;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class C2CAIOHelperProvider implements d {
    static IPatchRedirector $redirector_;

    public C2CAIOHelperProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
    @Nullable
    public h[] getLifeCycleHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? d.a.a(this) : (h[]) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.aio.api.help.d
    @Nullable
    public Map<String, Function0<h>> getLifeCycleHelperCreator(@NotNull com.tencent.aio.api.help.a param) {
        Map mapOf;
        Map plus;
        Map<String, Function0<h>> plus2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("MainThreadLiveHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$1.INSTANCE), TuplesKt.to("ViewMonitorHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$2.INSTANCE), TuplesKt.to("DynamicPicHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$3.INSTANCE), TuplesKt.to("LifeCycleHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$4.INSTANCE), TuplesKt.to("ArkContainerHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$5.INSTANCE), TuplesKt.to("MsgReadedHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$6.INSTANCE), TuplesKt.to("PhotoPanelHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$7.INSTANCE), TuplesKt.to("AIOEmoticonUIHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$8.INSTANCE), TuplesKt.to("DoutuHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$9.INSTANCE), TuplesKt.to("MultiForwardHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$10.INSTANCE), TuplesKt.to("AIOTofuMsgHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$11.INSTANCE), TuplesKt.to("StickerRecHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$12.INSTANCE), TuplesKt.to("MsgRelevantHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$13.INSTANCE), TuplesKt.to("PlusPanelHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$14.INSTANCE), TuplesKt.to("PanelBackPressHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$15.INSTANCE), TuplesKt.to("RelatedEmotionHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$16.INSTANCE), TuplesKt.to("InputStatusHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$17.INSTANCE), TuplesKt.to("AIOChatBackgroundHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$18.INSTANCE), TuplesKt.to("PttHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$19.INSTANCE), TuplesKt.to("PokeHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$20.INSTANCE), TuplesKt.to("PanelShowHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$21.INSTANCE), TuplesKt.to("AIORevokeGrayTipsHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$22.INSTANCE), TuplesKt.to("AIOPerfMonitorHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$23.INSTANCE), TuplesKt.to("AIOVideoPlayHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$24.INSTANCE), TuplesKt.to("AIOFrameDrawerHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$25.INSTANCE), TuplesKt.to("MsgSendHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$26.INSTANCE), TuplesKt.to("AIORichTextHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$27.INSTANCE), TuplesKt.to("AIOReserve1Helper", C2CAIOHelperProvider$getLifeCycleHelperCreator$28.INSTANCE), TuplesKt.to("AIOUnreadBubbleHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$29.INSTANCE), TuplesKt.to("LateInitMangerHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$30.INSTANCE), TuplesKt.to("AniStickerHelper", C2CAIOHelperProvider$getLifeCycleHelperCreator$31.INSTANCE));
        plus = MapsKt__MapsKt.plus(mapOf, ((IAIONotificationApi) QRoute.api(IAIONotificationApi.class)).getAIONotificationHelperMap());
        Map<String, Function0<h>> a16 = a.a(param);
        Intrinsics.checkNotNullExpressionValue(a16, "getC2COuterHelpersCreators(param)");
        plus2 = MapsKt__MapsKt.plus(plus, a16);
        return plus2;
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
    @Nullable
    public e[] getNormalHelper(@NotNull com.tencent.aio.api.help.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? d.a.e(this, aVar) : (e[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u7981\u6b62\u6dfb\u52a0NormalHelper", replaceWith = @ReplaceWith(expression = "UseCase", imports = {}))
    @Nullable
    public Map<String, Function0<e>> getNormalHelperCreator(@NotNull com.tencent.aio.api.help.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Map) iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        }
        return d.a.f(this, aVar);
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
    @Nullable
    public h[] getLifeCycleHelper(@NotNull com.tencent.aio.api.help.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? d.a.b(this, aVar) : (h[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
    }

    @Override // com.tencent.aio.api.help.d
    @NotNull
    public e[] getNormalHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new e[]{new w()} : (e[]) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
