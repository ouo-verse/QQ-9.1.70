package com.tencent.qqnt.aio.factory;

import com.tencent.aio.api.factory.g;
import com.tencent.aio.api.factory.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.api.IAIOFactoryApi;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/aio/factory/d;", "Lcom/tencent/aio/api/factory/g;", "Lcom/tencent/aio/base/log/f;", "buildAIOLogger", "Lcom/tencent/aio/msgservice/a;", "buildAIOMsgService", "Lys/a;", "buildActivityJumpService", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/aio/api/help/d;", "buildHelperProvider", "Lcom/tencent/aio/api/factory/j;", "buildMsgLevel", "Lcom/tencent/aio/api/factory/c;", "buildPanelArea", "Lcom/tencent/aio/api/factory/d;", "buildReserve1Level", "Lcom/tencent/aio/api/factory/e;", "buildReserve2Level", "Ldt/b;", "getBottomDialogFactory", "Lcom/tencent/aio/api/factory/a;", "buildFullBackgroundLevel", "", "isDebugModel", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class d implements g {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.base.log.f buildAIOLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.base.log.f) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildAIOLogger();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.msgservice.a buildAIOMsgService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.msgservice.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildAIOMsgService();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public ys.a buildActivityJumpService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ys.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildActivityJumpService();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.api.factory.f buildBusinessLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.api.factory.f) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildBusinessLevel();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.a buildFullBackgroundLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.aio.api.factory.a) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildFullBackgroundLevel();
    }

    @Override // com.tencent.aio.api.help.c
    @NotNull
    public com.tencent.aio.api.help.d buildHelperProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.aio.api.help.d) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildHelperProvider();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public j buildMsgLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (j) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildMsgLevel();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.c buildPanelArea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.aio.api.factory.c) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildPanelArea();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.d buildReserve1Level() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.aio.api.factory.d) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildReserve1Level();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.e buildReserve2Level() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.aio.api.factory.e) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildReserve2Level();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public dt.b getBottomDialogFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (dt.b) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).getBottomDialogFactory();
    }

    @Override // com.tencent.aio.api.factory.g
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "buildPanelArea", imports = {}))
    @Nullable
    public com.tencent.aio.part.root.panel.mvx.config.a getPanelFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.aio.part.root.panel.mvx.config.a) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return g.a.h(this);
    }

    @Override // com.tencent.aio.api.factory.g
    public boolean isDebugModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).isDebugModel();
    }
}
