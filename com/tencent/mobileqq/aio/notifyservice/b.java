package com.tencent.mobileqq.aio.notifyservice;

import com.tencent.aio.api.help.d;
import com.tencent.aio.main.businesshelper.e;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.helper.AIOChatBackgroundHelper;
import com.tencent.mobileqq.aio.helper.AIOUnreadBubbleHelper;
import com.tencent.mobileqq.aio.helper.DynamicPicHelper;
import com.tencent.mobileqq.aio.helper.MsgReadedHelper;
import com.tencent.mobileqq.aio.helper.MsgRelevantHelper;
import com.tencent.mobileqq.aio.helper.MultiForwardHelper;
import com.tencent.mobileqq.aio.helper.ad;
import com.tencent.mobileqq.aio.helper.ae;
import com.tencent.mobileqq.aio.helper.at;
import com.tencent.mobileqq.aio.helper.aw;
import com.tencent.mobileqq.aio.helper.ax;
import com.tencent.mobileqq.aio.helper.f;
import com.tencent.mobileqq.aio.helper.n;
import com.tencent.mobileqq.aio.helper.t;
import com.tencent.mobileqq.aio.helper.w;
import com.tencent.mobileqq.aio.notification.IAIONotificationApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Collection;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/notifyservice/b;", "Lcom/tencent/aio/api/help/d;", "", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelper", "()[Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/main/businesshelper/e;", "getNormalHelper", "()[Lcom/tencent/aio/main/businesshelper/e;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b implements d {
    static IPatchRedirector $redirector_;

    public b() {
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? d.a.b(this, aVar) : (h[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
    }

    @Override // com.tencent.aio.api.help.d
    @Nullable
    public Map<String, Function0<h>> getLifeCycleHelperCreator(@NotNull com.tencent.aio.api.help.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        }
        return d.a.c(this, aVar);
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
    @Nullable
    public e[] getNormalHelper(@NotNull com.tencent.aio.api.help.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? d.a.e(this, aVar) : (e[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
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
    @NotNull
    public h[] getLifeCycleHelper() {
        Object[] plus;
        Object[] plus2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        plus = ArraysKt___ArraysJvmKt.plus((Object[]) new h[]{new DynamicPicHelper(), new ae(), new t(), new ad(), new MsgReadedHelper(), new aw(), new f(), new ax(), new com.tencent.mobileqq.aio.helper.provider.b(), new at(), new MultiForwardHelper(), new n(), new AIOUnreadBubbleHelper(), new AIOChatBackgroundHelper(), new MsgRelevantHelper()}, (Object[]) ((IAIONotificationApi) QRoute.api(IAIONotificationApi.class)).getAIONotificationHelperArray());
        plus2 = ArraysKt___ArraysJvmKt.plus(plus, (Collection) c.f193012a.b());
        return (h[]) plus2;
    }

    @Override // com.tencent.aio.api.help.d
    @NotNull
    public e[] getNormalHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new e[]{new w()} : (e[]) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
