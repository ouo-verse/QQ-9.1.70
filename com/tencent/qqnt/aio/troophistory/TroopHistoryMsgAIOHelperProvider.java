package com.tencent.qqnt.aio.troophistory;

import com.tencent.aio.api.help.d;
import com.tencent.aio.main.businesshelper.e;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/troophistory/TroopHistoryMsgAIOHelperProvider;", "Lcom/tencent/aio/api/help/d;", "Lcom/tencent/aio/api/help/a;", "param", "", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelperCreator", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TroopHistoryMsgAIOHelperProvider implements d {
    static IPatchRedirector $redirector_;

    public TroopHistoryMsgAIOHelperProvider() {
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? d.a.a(this) : (h[]) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.aio.api.help.d
    @NotNull
    public Map<String, Function0<h>> getLifeCycleHelperCreator(@NotNull com.tencent.aio.api.help.a param) {
        Map<String, Function0<h>> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("MainThreadLiveHelper", TroopHistoryMsgAIOHelperProvider$getLifeCycleHelperCreator$1.INSTANCE), TuplesKt.to("ViewMonitorHelper", TroopHistoryMsgAIOHelperProvider$getLifeCycleHelperCreator$2.INSTANCE), TuplesKt.to("DynamicPicHelper", TroopHistoryMsgAIOHelperProvider$getLifeCycleHelperCreator$3.INSTANCE), TuplesKt.to("LifeCycleHelper", TroopHistoryMsgAIOHelperProvider$getLifeCycleHelperCreator$4.INSTANCE), TuplesKt.to("ArkContainerHelper", TroopHistoryMsgAIOHelperProvider$getLifeCycleHelperCreator$5.INSTANCE), TuplesKt.to("PhotoPanelHelper", TroopHistoryMsgAIOHelperProvider$getLifeCycleHelperCreator$6.INSTANCE), TuplesKt.to("AIOEmoticonUIHelper", TroopHistoryMsgAIOHelperProvider$getLifeCycleHelperCreator$7.INSTANCE), TuplesKt.to("GroupInfoHelper", TroopHistoryMsgAIOHelperProvider$getLifeCycleHelperCreator$8.INSTANCE), TuplesKt.to("PttHelper", TroopHistoryMsgAIOHelperProvider$getLifeCycleHelperCreator$9.INSTANCE), TuplesKt.to("AIOVideoPlayHelper", TroopHistoryMsgAIOHelperProvider$getLifeCycleHelperCreator$10.INSTANCE), TuplesKt.to("AIOPerfMonitorHelper", TroopHistoryMsgAIOHelperProvider$getLifeCycleHelperCreator$11.INSTANCE));
        return mapOf;
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
    @Nullable
    public e[] getNormalHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? d.a.d(this) : (e[]) iPatchRedirector.redirect((short) 5, (Object) this);
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? d.a.b(this, aVar) : (h[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
    @Nullable
    public e[] getNormalHelper(@NotNull com.tencent.aio.api.help.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? d.a.e(this, aVar) : (e[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
    }
}
