package com.tencent.aio.stranger.impl.factory;

import com.tencent.aio.api.factory.f;
import com.tencent.aio.api.help.d;
import com.tencent.aio.main.businesshelper.e;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.gamemsg.GameMsgAIOThirdLevelFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.api.IAIOFactoryApi;
import com.tencent.qqnt.aio.api.IHelperProviderCompose;
import com.tencent.qqnt.aio.factory.d;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ys.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aio/stranger/impl/factory/GameMsgAIOFactory;", "Lcom/tencent/qqnt/aio/factory/d;", "Lys/a;", "buildActivityJumpService", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/aio/api/factory/e;", "buildReserve2Level", "Lcom/tencent/aio/api/help/d;", "buildHelperProvider", "<init>", "()V", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class GameMsgAIOFactory extends d {
    static IPatchRedirector $redirector_;

    public GameMsgAIOFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.factory.g
    @NotNull
    public a buildActivityJumpService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new com.tencent.aio.stranger.impl.jumpservice.a();
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.factory.g
    @NotNull
    public f buildBusinessLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new GameMsgAIOThirdLevelFactory();
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.help.c
    @NotNull
    public com.tencent.aio.api.help.d buildHelperProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.api.help.d) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new com.tencent.aio.api.help.d() { // from class: com.tencent.aio.stranger.impl.factory.GameMsgAIOFactory$buildHelperProvider$1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy defaultHelperProvider;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Lazy lazy;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                    lazy = LazyKt__LazyJVMKt.lazy(GameMsgAIOFactory$buildHelperProvider$1$defaultHelperProvider$2.INSTANCE);
                    this.defaultHelperProvider = lazy;
                } else {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                }
            }

            @NotNull
            public final com.tencent.aio.api.help.d a() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.aio.api.help.d) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return (com.tencent.aio.api.help.d) this.defaultHelperProvider.getValue();
            }

            @Override // com.tencent.aio.api.help.d
            @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
            @Nullable
            public h[] getLifeCycleHelper() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 5)) ? d.a.a(this) : (h[]) iPatchRedirector2.redirect((short) 5, (Object) this);
            }

            @Override // com.tencent.aio.api.help.d
            @Nullable
            public Map<String, Function0<h>> getLifeCycleHelperCreator(@NotNull com.tencent.aio.api.help.a param) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return (Map) iPatchRedirector2.redirect((short) 3, (Object) this, (Object) param);
                }
                Intrinsics.checkNotNullParameter(param, "param");
                return ((IHelperProviderCompose) QRoute.api(IHelperProviderCompose.class)).composeLifecycleHelpers(param, a().getLifeCycleHelper(), new h[0]);
            }

            @Override // com.tencent.aio.api.help.d
            @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
            @Nullable
            public e[] getNormalHelper() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 7)) ? d.a.d(this) : (e[]) iPatchRedirector2.redirect((short) 7, (Object) this);
            }

            @Override // com.tencent.aio.api.help.d
            @Nullable
            public Map<String, Function0<e>> getNormalHelperCreator(@NotNull com.tencent.aio.api.help.a param) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return (Map) iPatchRedirector2.redirect((short) 4, (Object) this, (Object) param);
                }
                Intrinsics.checkNotNullParameter(param, "param");
                return ((IHelperProviderCompose) QRoute.api(IHelperProviderCompose.class)).composeAllNormalHelpers(param, a().getNormalHelper(), new e[0]);
            }

            @Override // com.tencent.aio.api.help.d
            @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
            @Nullable
            public h[] getLifeCycleHelper(@NotNull com.tencent.aio.api.help.a aVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 6)) ? d.a.b(this, aVar) : (h[]) iPatchRedirector2.redirect((short) 6, (Object) this, (Object) aVar);
            }

            @Override // com.tencent.aio.api.help.d
            @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
            @Nullable
            public e[] getNormalHelper(@NotNull com.tencent.aio.api.help.a aVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 8)) ? d.a.e(this, aVar) : (e[]) iPatchRedirector2.redirect((short) 8, (Object) this, (Object) aVar);
            }
        };
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.e buildReserve2Level() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.api.factory.e) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildReserve2Level();
    }
}
