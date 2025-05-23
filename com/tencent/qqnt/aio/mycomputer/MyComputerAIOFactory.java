package com.tencent.qqnt.aio.mycomputer;

import com.tencent.aio.api.help.d;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.AIOFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.aio.api.IAIOFactoryApi;
import com.tencent.qqnt.aio.api.IHelperProviderCompose;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/mycomputer/MyComputerAIOFactory;", "Lcom/tencent/mobileqq/aio/AIOFactory;", "Lcom/tencent/aio/api/help/d;", "buildHelperProvider", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/aio/api/factory/c;", "buildPanelArea", "Lcom/tencent/aio/api/factory/a;", "buildFullBackgroundLevel", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MyComputerAIOFactory extends AIOFactory {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/mycomputer/MyComputerAIOFactory$a", "Lcom/tencent/aio/api/factory/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements com.tencent.aio.api.factory.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.api.factory.a
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new MyComputerBackgroundVB();
        }
    }

    public MyComputerAIOFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.AIOFactory, com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.api.factory.f buildBusinessLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.api.factory.f) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new MyComputerAIOThirdLevelFactory();
    }

    @Override // com.tencent.mobileqq.aio.AIOFactory, com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.a buildFullBackgroundLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.api.factory.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.aio.AIOFactory, com.tencent.aio.api.help.c
    @NotNull
    public com.tencent.aio.api.help.d buildHelperProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.api.help.d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new com.tencent.aio.api.help.d() { // from class: com.tencent.qqnt.aio.mycomputer.MyComputerAIOFactory$buildHelperProvider$1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy defaultHelperProvider;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Lazy lazy;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                    lazy = LazyKt__LazyJVMKt.lazy(MyComputerAIOFactory$buildHelperProvider$1$defaultHelperProvider$2.INSTANCE);
                    this.defaultHelperProvider = lazy;
                } else {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                }
            }

            @NotNull
            public final MyComputerAIOHelperProvider a() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (MyComputerAIOHelperProvider) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return (MyComputerAIOHelperProvider) this.defaultHelperProvider.getValue();
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
            public com.tencent.aio.main.businesshelper.e[] getNormalHelper() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 7)) ? d.a.d(this) : (com.tencent.aio.main.businesshelper.e[]) iPatchRedirector2.redirect((short) 7, (Object) this);
            }

            @Override // com.tencent.aio.api.help.d
            @Nullable
            public Map<String, Function0<com.tencent.aio.main.businesshelper.e>> getNormalHelperCreator(@NotNull com.tencent.aio.api.help.a param) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return (Map) iPatchRedirector2.redirect((short) 4, (Object) this, (Object) param);
                }
                Intrinsics.checkNotNullParameter(param, "param");
                return ((IHelperProviderCompose) QRoute.api(IHelperProviderCompose.class)).composeAllNormalHelpers(param, a().getNormalHelper(), new com.tencent.aio.main.businesshelper.e[0]);
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
            public com.tencent.aio.main.businesshelper.e[] getNormalHelper(@NotNull com.tencent.aio.api.help.a aVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 8)) ? d.a.e(this, aVar) : (com.tencent.aio.main.businesshelper.e[]) iPatchRedirector2.redirect((short) 8, (Object) this, (Object) aVar);
            }
        };
    }

    @Override // com.tencent.mobileqq.aio.AIOFactory, com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.api.factory.c buildPanelArea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.api.factory.c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildPanelAreaWithPanelFactory(new f());
    }
}
