package com.tencent.mobileqq.aio.helper.provider;

import com.tencent.aio.api.help.d;
import com.tencent.aio.main.businesshelper.e;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.helper.AIOChatBackgroundHelper;
import com.tencent.mobileqq.aio.helper.AIOUnreadBubbleHelper;
import com.tencent.mobileqq.aio.helper.DynamicPicHelper;
import com.tencent.mobileqq.aio.helper.MessageSendErrorHelper;
import com.tencent.mobileqq.aio.helper.MsgReadedHelper;
import com.tencent.mobileqq.aio.helper.MsgRelevantHelper;
import com.tencent.mobileqq.aio.helper.MultiForwardHelper;
import com.tencent.mobileqq.aio.helper.PttHelper;
import com.tencent.mobileqq.aio.helper.StickerRecHelper;
import com.tencent.mobileqq.aio.helper.ad;
import com.tencent.mobileqq.aio.helper.ae;
import com.tencent.mobileqq.aio.helper.at;
import com.tencent.mobileqq.aio.helper.au;
import com.tencent.mobileqq.aio.helper.aw;
import com.tencent.mobileqq.aio.helper.ax;
import com.tencent.mobileqq.aio.helper.bc;
import com.tencent.mobileqq.aio.helper.f;
import com.tencent.mobileqq.aio.helper.n;
import com.tencent.mobileqq.aio.helper.o;
import com.tencent.mobileqq.aio.helper.s;
import com.tencent.mobileqq.aio.helper.t;
import com.tencent.mobileqq.aio.helper.w;
import com.tencent.mobileqq.aio.notification.IAIONotificationApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ$\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/provider/DefaultAIOHelperProvider;", "Lcom/tencent/aio/api/help/d;", "", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelper", "()[Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/main/businesshelper/e;", "getNormalHelper", "()[Lcom/tencent/aio/main/businesshelper/e;", "Lcom/tencent/aio/api/help/a;", "param", "", "", "Lkotlin/Function0;", "getNormalHelperCreator", "getLifeCycleHelperCreator", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class DefaultAIOHelperProvider implements d {
    static IPatchRedirector $redirector_;

    public DefaultAIOHelperProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
    @Nullable
    public h[] getLifeCycleHelper(@NotNull com.tencent.aio.api.help.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? d.a.b(this, aVar) : (h[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
    }

    @Override // com.tencent.aio.api.help.d
    @Nullable
    public Map<String, Function0<h>> getLifeCycleHelperCreator(@NotNull com.tencent.aio.api.help.a param) {
        Map mapOf;
        Map<String, Function0<h>> plus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("MainThreadLiveHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$1.INSTANCE), TuplesKt.to("DynamicPicHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$2.INSTANCE), TuplesKt.to("LifeCycleHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$3.INSTANCE), TuplesKt.to("ArkContainerHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$4.INSTANCE), TuplesKt.to("LateInitMangerHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$5.INSTANCE), TuplesKt.to("MsgReadedHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$6.INSTANCE), TuplesKt.to("PhotoPanelHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$7.INSTANCE), TuplesKt.to("AIOEmoticonUIHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$8.INSTANCE), TuplesKt.to("MultiForwardHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$9.INSTANCE), TuplesKt.to("MsgRelevantHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$10.INSTANCE), TuplesKt.to("PlusPanelHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$11.INSTANCE), TuplesKt.to("PanelBackPressHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$12.INSTANCE), TuplesKt.to("RelatedEmotionHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$13.INSTANCE), TuplesKt.to("AIOChatBackgroundHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$14.INSTANCE), TuplesKt.to("MessageSendErrorHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$15.INSTANCE), TuplesKt.to("StickerRecHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$16.INSTANCE), TuplesKt.to("PttHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$17.INSTANCE), TuplesKt.to("AIORevokeGrayTipsHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$18.INSTANCE), TuplesKt.to("AIOPerfMonitorHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$19.INSTANCE), TuplesKt.to("AIOReserve1Helper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$20.INSTANCE), TuplesKt.to("AIOUnreadBubbleHelper", DefaultAIOHelperProvider$getLifeCycleHelperCreator$21.INSTANCE));
        plus = MapsKt__MapsKt.plus(mapOf, ((IAIONotificationApi) QRoute.api(IAIONotificationApi.class)).getAIONotificationHelperMap());
        return plus;
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
    @Nullable
    public e[] getNormalHelper(@NotNull com.tencent.aio.api.help.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? d.a.e(this, aVar) : (e[]) iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
    }

    @Override // com.tencent.aio.api.help.d
    @Nullable
    public Map<String, Function0<e>> getNormalHelperCreator(@NotNull com.tencent.aio.api.help.a param) {
        Map<String, Function0<e>> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("DeleteMessageHelper", DefaultAIOHelperProvider$getNormalHelperCreator$1.INSTANCE));
        return mapOf;
    }

    @Override // com.tencent.aio.api.help.d
    @NotNull
    public h[] getLifeCycleHelper() {
        Object[] plus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        plus = ArraysKt___ArraysJvmKt.plus((Object[]) new h[]{new b(), new DynamicPicHelper(), new ae(), new t(), new MsgReadedHelper(), new aw(), new f(), new MultiForwardHelper(), new MsgRelevantHelper(), new ax(), new at(), new bc(), new AIOChatBackgroundHelper(), new MessageSendErrorHelper(), new StickerRecHelper(), new PttHelper(), new au(), new o(), new n(), new AIOUnreadBubbleHelper(), new ad(), new s()}, (Object[]) ((IAIONotificationApi) QRoute.api(IAIONotificationApi.class)).getAIONotificationHelperArray());
        return (h[]) plus;
    }

    @Override // com.tencent.aio.api.help.d
    @NotNull
    public e[] getNormalHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new e[]{new w()} : (e[]) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
