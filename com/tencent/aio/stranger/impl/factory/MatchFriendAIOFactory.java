package com.tencent.aio.stranger.impl.factory;

import at.e;
import com.tencent.aio.api.factory.f;
import com.tencent.aio.api.help.a;
import com.tencent.aio.api.help.d;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.aio.stranger.api.IStrangerAIOAdapterApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.aio.api.IAIOFactoryExtApi;
import com.tencent.qqnt.aio.api.IAIOUniversalBusinessVB;
import com.tencent.qqnt.aio.api.IHelperProviderCompose;
import com.tencent.qqnt.aio.factory.d;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/stranger/impl/factory/MatchFriendAIOFactory;", "Lcom/tencent/qqnt/aio/factory/d;", "Lys/a;", "buildActivityJumpService", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/aio/api/help/d;", "buildHelperProvider", "<init>", "()V", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class MatchFriendAIOFactory extends d {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016J\u0018\u0010\b\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0002H\u0016J\u0018\u0010\t\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00060\u0002H\u0016R\u001b\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/aio/stranger/impl/factory/MatchFriendAIOFactory$a", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "buildInputVB", "", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "buildTitleVB", "buildShortcutBarVB", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "a", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "getInputAdornApi", "()Lcom/tencent/mobileqq/aio/input/adorn/a;", "inputAdornApi", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class a implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.aio.input.adorn.a<?> inputAdornApi;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.inputAdornApi = ((IStrangerAIOAdapterApi) QRoute.api(IStrangerAIOAdapterApi.class)).getInputBarAdornApi();
            }
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildBottomBarVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return f.a.a(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public List<com.tencent.aio.base.mvvm.a<? extends b, ? extends MviUIState>> buildBusinessVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (List) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return f.a.b(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends at.a, ? extends InputUIState> buildInputVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return ((IAIOUniversalBusinessVB) QRoute.api(IAIOUniversalBusinessVB.class)).getInputContainerVBWithAdornApi(this.inputAdornApi, true);
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        public com.tencent.aio.base.mvvm.a<Object, Object> buildShortcutBarVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return ((IAIOUniversalBusinessVB) QRoute.api(IAIOUniversalBusinessVB.class)).getShortcutBarVB();
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        public com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> buildTitleVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return ((IAIOUniversalBusinessVB) QRoute.api(IAIOUniversalBusinessVB.class)).getTitleVB();
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<? extends e, ? extends TopTipViewState> buildTopTipVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return f.a.f(this);
        }

        @Override // com.tencent.aio.api.factory.h
        @Nullable
        public com.tencent.aio.api.b getLayoutDelegate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (com.tencent.aio.api.b) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return f.a.g(this);
        }
    }

    public MatchFriendAIOFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.factory.g
    @NotNull
    public ys.a buildActivityJumpService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ys.a) iPatchRedirector.redirect((short) 2, (Object) this);
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
        return ((IAIOFactoryExtApi) QRoute.api(IAIOFactoryExtApi.class)).buildBusinessLevelCompactInputHeight(new a());
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.help.c
    @NotNull
    public com.tencent.aio.api.help.d buildHelperProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.api.help.d) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new com.tencent.aio.api.help.d() { // from class: com.tencent.aio.stranger.impl.factory.MatchFriendAIOFactory$buildHelperProvider$1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy defaultHelperProvider;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Lazy lazy;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                    lazy = LazyKt__LazyJVMKt.lazy(MatchFriendAIOFactory$buildHelperProvider$1$defaultHelperProvider$2.INSTANCE);
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
            public Map<String, Function0<h>> getLifeCycleHelperCreator(@NotNull a param) {
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
            public Map<String, Function0<com.tencent.aio.main.businesshelper.e>> getNormalHelperCreator(@NotNull a param) {
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
            public h[] getLifeCycleHelper(@NotNull a aVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 6)) ? d.a.b(this, aVar) : (h[]) iPatchRedirector2.redirect((short) 6, (Object) this, (Object) aVar);
            }

            @Override // com.tencent.aio.api.help.d
            @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
            @Nullable
            public com.tencent.aio.main.businesshelper.e[] getNormalHelper(@NotNull a aVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 8)) ? d.a.e(this, aVar) : (com.tencent.aio.main.businesshelper.e[]) iPatchRedirector2.redirect((short) 8, (Object) this, (Object) aVar);
            }
        };
    }
}
