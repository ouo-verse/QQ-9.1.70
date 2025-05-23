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

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/provider/GroupAIOHelperProvider;", "Lcom/tencent/aio/api/help/d;", "Lcom/tencent/aio/api/help/a;", "param", "", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelperCreator", "", "Lcom/tencent/aio/main/businesshelper/e;", "getNormalHelper", "()[Lcom/tencent/aio/main/businesshelper/e;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class GroupAIOHelperProvider implements d {
    static IPatchRedirector $redirector_;

    public GroupAIOHelperProvider() {
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
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("MainThreadLiveHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$1.INSTANCE), TuplesKt.to("ViewMonitorHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$2.INSTANCE), TuplesKt.to("DynamicPicHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$3.INSTANCE), TuplesKt.to("LifeCycleHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$4.INSTANCE), TuplesKt.to("ArkContainerHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$5.INSTANCE), TuplesKt.to("LateInitMangerHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$6.INSTANCE), TuplesKt.to("MsgReadedHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$7.INSTANCE), TuplesKt.to("PhotoPanelHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$8.INSTANCE), TuplesKt.to("AIOEmoticonUIHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$9.INSTANCE), TuplesKt.to("DoutuHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$10.INSTANCE), TuplesKt.to("MultiForwardHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$11.INSTANCE), TuplesKt.to("StickerRecHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$12.INSTANCE), TuplesKt.to("MsgRelevantHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$13.INSTANCE), TuplesKt.to("PlusPanelHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$14.INSTANCE), TuplesKt.to("PanelBackPressHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$15.INSTANCE), TuplesKt.to("GroupInfoHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$16.INSTANCE), TuplesKt.to("RelatedEmotionHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$17.INSTANCE), TuplesKt.to("AIOChatBackgroundHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$18.INSTANCE), TuplesKt.to("AIOGestureHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$19.INSTANCE), TuplesKt.to("MessageSendErrorHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$20.INSTANCE), TuplesKt.to("PttHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$21.INSTANCE), TuplesKt.to("PanelShowHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$22.INSTANCE), TuplesKt.to("AIOVideoPlayHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$23.INSTANCE), TuplesKt.to("AIORevokeGrayTipsHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$24.INSTANCE), TuplesKt.to("AIOPerfMonitorHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$25.INSTANCE), TuplesKt.to("MsgSendHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$26.INSTANCE), TuplesKt.to("InputDialogPriorityHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$27.INSTANCE), TuplesKt.to("AIOFrameDrawerHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$28.INSTANCE), TuplesKt.to("AIOEmojiReaction", GroupAIOHelperProvider$getLifeCycleHelperCreator$29.INSTANCE), TuplesKt.to("AIONickIconHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$30.INSTANCE), TuplesKt.to("AIORichTextHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$31.INSTANCE), TuplesKt.to("AIOReserve1Helper", GroupAIOHelperProvider$getLifeCycleHelperCreator$32.INSTANCE), TuplesKt.to("AIONavHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$33.INSTANCE), TuplesKt.to("AIOUnreadBubbleHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$34.INSTANCE), TuplesKt.to("AniStickerHelper", GroupAIOHelperProvider$getLifeCycleHelperCreator$35.INSTANCE));
        plus = MapsKt__MapsKt.plus(mapOf, ((IAIONotificationApi) QRoute.api(IAIONotificationApi.class)).getAIONotificationHelperMap());
        Map<String, Function0<h>> b16 = a.b(param);
        Intrinsics.checkNotNullExpressionValue(b16, "getGroupOuterHelpersCreator(param)");
        plus2 = MapsKt__MapsKt.plus(plus, b16);
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
