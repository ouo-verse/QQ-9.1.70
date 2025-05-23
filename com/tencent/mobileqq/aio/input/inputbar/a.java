package com.tencent.mobileqq.aio.input.inputbar;

import android.os.Bundle;
import android.view.View;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.g;
import com.tencent.mobileqq.aio.input.adorn.e;
import com.tencent.mobileqq.aio.input.inputbar.vbcmd.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.api.ability.d;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\f*\u0001(\b\u0007\u0018\u0000 1*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003:\u00012B\u0015\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000!\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u001a\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0016\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00180\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u0015H\u0017R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00028\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/aio/input/inputbar/a;", "Lcom/tencent/mobileqq/aio/input/adorn/e;", "V", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/inputbar/vbcmd/a$a;", "stateCmd", "Landroid/os/Bundle;", "c1", "Lcom/tencent/mobileqq/aio/input/inputbar/vbcmd/a$c;", "e1", "d1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "state", "", "f1", "", "Ljava/lang/Class;", "getObserverStates", "bindViewAndData", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "Lcom/tencent/mvi/api/ability/d;", "generateVBState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/input/adorn/a;", "d", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "mAdornApi", "e", "Lcom/tencent/mobileqq/aio/input/adorn/e;", "mBinding", "com/tencent/mobileqq/aio/input/inputbar/a$b", "f", "Lcom/tencent/mobileqq/aio/input/inputbar/a$b;", "mDelegateMediator", h.F, "Landroid/os/Bundle;", "mVBCmdResultBundle", "<init>", "(Lcom/tencent/mobileqq/aio/input/adorn/a;)V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class a<V extends e> extends com.tencent.aio.base.mvvm.a<at.a, InputUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.input.adorn.a<V> mAdornApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private V mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mDelegateMediator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle mVBCmdResultBundle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/input/inputbar/a$a;", "", "", "DEBUG", "Z", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.inputbar.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002&\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0005J<\u0010\n\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u00028\u00000\bj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\t0\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/aio/input/inputbar/a$b", "Lcom/tencent/input/base/mvicompat/g;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/InputBarVBDelegateMediator;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", DomainData.DOMAIN_NAME, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends g<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super V> {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ a<V> f189695h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(a<V> aVar, c cVar) {
            super(cVar);
            this.f189695h = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) cVar);
            }
        }

        @Override // com.tencent.input.base.mvicompat.DelegateMediator
        @NotNull
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super V>> i(@NotNull com.tencent.mobileqq.aio.input.adorn.b host) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) host);
            }
            Intrinsics.checkNotNullParameter(host, "host");
            return ((a) this.f189695h).mAdornApi.e(host);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/input/inputbar/a$c", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lat/a;", "intent", "", "a", "", "getTag", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements com.tencent.mobileqq.aio.input.adorn.b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a<V> f189696d;

        c(a<V> aVar) {
            this.f189696d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(@NotNull at.a intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            } else {
                Intrinsics.checkNotNullParameter(intent, "intent");
                this.f189696d.sendIntent(intent);
            }
        }

        @Override // com.tencent.mobileqq.aio.input.adorn.b
        @NotNull
        public String getTag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "AIOInputBarVB2";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55642);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull com.tencent.mobileqq.aio.input.adorn.a<V> mAdornApi) {
        Intrinsics.checkNotNullParameter(mAdornApi, "mAdornApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mAdornApi);
            return;
        }
        this.mAdornApi = mAdornApi;
        this.mDelegateMediator = new b(this, new c(this));
        this.mVBCmdResultBundle = new Bundle();
    }

    @Deprecated(message = "\u4ee5\u540e\u518d\u89e3\u9664\u8fd9\u91cc\u7684\u8026\u5408\u95ee\u9898")
    private final Bundle c1(a.C7273a stateCmd) {
        V v3 = this.mBinding;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            v3 = null;
        }
        stateCmd.b(v3.a());
        return new Bundle();
    }

    private final Bundle d1() {
        Bundle bundle = new Bundle();
        V v3 = this.mBinding;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            v3 = null;
        }
        bundle.putInt("input_height", v3.getRoot().getHeight());
        return bundle;
    }

    private final Bundle e1(a.c stateCmd) {
        V v3 = this.mBinding;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            v3 = null;
        }
        stateCmd.b(v3.getRoot());
        return new Bundle();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mDelegateMediator.a();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<at.a, InputUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseVM) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new com.tencent.mobileqq.aio.input.inputbar.b(this.mAdornApi);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) state);
        } else {
            Intrinsics.checkNotNullParameter(state, "state");
            this.mDelegateMediator.f(state);
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull d stateCmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bundle) iPatchRedirector.redirect((short) 8, (Object) this, (Object) stateCmd);
        }
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof a.b) {
            return d1();
        }
        if (stateCmd instanceof a.C7273a) {
            return c1((a.C7273a) stateCmd);
        }
        if (stateCmd instanceof a.c) {
            return e1((a.c) stateCmd);
        }
        Bundle generateVBState = this.mDelegateMediator.generateVBState(stateCmd);
        if (generateVBState == null) {
            return this.mVBCmdResultBundle;
        }
        return generateVBState;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends InputUIState>> getObserverStates() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mDelegateMediator.l();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        V b16 = this.mAdornApi.b(createViewParams.a());
        this.mBinding = b16;
        b bVar = this.mDelegateMediator;
        V v3 = null;
        if (b16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            b16 = null;
        }
        bVar.c(b16);
        V v16 = this.mBinding;
        if (v16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            v3 = v16;
        }
        View root = v3.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Deprecated(message = "\u4e3a\u4e86\u517c\u5bb9\uff0c\u548c\u903b\u8f91\u8026\u5408\u5f88\u4e25\u91cd\u89c6\u56fe")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.mDelegateMediator.onDestroy();
        super.onDestroy();
        this.mVBCmdResultBundle.clear();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) reuseParam);
        } else {
            Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
            this.mDelegateMediator.d(reuseParam);
        }
    }
}
