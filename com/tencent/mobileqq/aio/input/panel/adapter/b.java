package com.tencent.mobileqq.aio.input.panel.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.launch.d;
import com.tencent.input.base.panelcontainer.j;
import com.tencent.mobileqq.aio.input.panel.adapter.PanelContainerAdapterUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.runtime.strategy.IStrategyFetcher;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\u000b\u001a\u00020\u00062\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0014\u0010\u001d\u001a\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u001bJ\u0016\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001f0\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0003H\u0016J\u001c\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J$\u0010$\u001a\u00020\u00062\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\b\u0010%\u001a\u00020\u0006H\u0016R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001e\u00100\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\t0\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/aio/input/panel/adapter/b;", "Lcom/tencent/aio/base/mvvm/a;", "", "Lcom/tencent/mobileqq/aio/input/panel/adapter/PanelContainerAdapterUIState;", "Landroid/content/Context;", "context", "", "d1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "mUIModel", "h1", "Lcom/tencent/mvi/log/b;", "e1", "Lpz0/a;", "f1", "", "invokeTag", "i1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "bindViewAndData", "Lcom/tencent/input/base/panelcontainer/c;", "creator", "j1", "", "Ljava/lang/Class;", "getObserverStates", "state", "g1", "createVM", "afterCreateVM", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "mRootView", "e", "Landroid/view/View;", "mPanelContainerViewStub", "Lcom/tencent/input/base/panelcontainer/j;", "f", "Lcom/tencent/input/base/panelcontainer/j;", "mRootVB", h.F, "Lcom/tencent/input/base/panelcontainer/c;", "mBuildPanelApi", "<init>", "()V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b extends com.tencent.aio.base.mvvm.a<Object, PanelContainerAdapterUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mPanelContainerViewStub;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j<com.tencent.aio.api.runtime.a> mRootVB;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.input.base.panelcontainer.c<com.tencent.aio.api.runtime.a> mBuildPanelApi;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/panel/adapter/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.panel.adapter.b$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/aio/input/panel/adapter/b$b", "Lcom/tencent/mvi/log/b;", "", "tag", "msg", "", "e", "i", "", "isColorLevel", "d", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.panel.adapter.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7278b implements com.tencent.mvi.log.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ com.tencent.mobileqq.aio.factory.d f189787a;

        C7278b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f189787a = com.tencent.mobileqq.aio.factory.d.f188788a;
            }
        }

        @Override // com.tencent.mvi.log.b
        public void d(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (QLog.isDevelopLevel()) {
                QLog.d(tag, 4, msg2);
            }
        }

        @Override // com.tencent.mvi.log.b
        public void e(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.f189787a.e(tag, msg2);
        }

        @Override // com.tencent.mvi.log.b
        public void i(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.f189787a.i(tag, msg2);
        }

        @Override // com.tencent.mvi.log.b
        public boolean isColorLevel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.f189787a.isColorLevel();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/aio/input/panel/adapter/b$c", "Lpz0/a;", "", "key", "", "defValue", "decodeInt", "value", "", "encodeInt", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements pz0.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MMKVOptionEntity f189788a;

        c(MMKVOptionEntity mMKVOptionEntity) {
            this.f189788a = mMKVOptionEntity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) mMKVOptionEntity);
            }
        }

        @Override // pz0.a
        public int decodeInt(@NotNull String key, int defValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) key, defValue)).intValue();
            }
            Intrinsics.checkNotNullParameter(key, "key");
            return this.f189788a.decodeInt(key, defValue);
        }

        @Override // pz0.a
        public void encodeInt(@NotNull String key, int value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) key, value);
            } else {
                Intrinsics.checkNotNullParameter(key, "key");
                this.f189788a.encodeInt(key, value);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/aio/input/panel/adapter/b$d", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lpz0/a;", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d extends IStrategyFetcher<pz0.a> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public pz0.a getF447332b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return b.this.f1();
            }
            return (pz0.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/aio/input/panel/adapter/b$e", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/mvi/log/b;", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e extends IStrategyFetcher<com.tencent.mvi.log.b> {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.mvi.log.b getF447332b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return b.this.e1();
            }
            return (com.tencent.mvi.log.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56463);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d1(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            int i3 = activity.getWindow().getAttributes().softInputMode;
            if ((i3 & 255) != 18) {
                int i16 = i3 & (-256);
                activity.getWindow().setSoftInputMode(i16 | 18);
                QLog.i("PanelContainerAdapterVB", 1, "checkIllegalSoftInputMode softInputMode = " + i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.log.b e1() {
        return new C7278b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final pz0.a f1() {
        MMKVOptionEntity from = QMMKV.from(getMContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(mContext, QMMKVFile.FILE_COMMON)");
        return new c(from);
    }

    private final void h1(BaseVM<Object, PanelContainerAdapterUIState, com.tencent.aio.api.runtime.a> mUIModel) {
        i1("launchPanelContainer");
        com.tencent.input.base.panelcontainer.c<com.tencent.aio.api.runtime.a> cVar = this.mBuildPanelApi;
        ViewGroup viewGroup = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBuildPanelApi");
            cVar = null;
        }
        this.mRootVB = new j<>(cVar);
        d.a aVar = new d.a();
        Intrinsics.checkNotNull(mUIModel);
        d.a d16 = aVar.d(mUIModel.getMContext());
        ViewGroup viewGroup2 = this.mRootView;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            viewGroup = viewGroup2;
        }
        d.a b16 = d16.e(viewGroup).b(getMContext());
        LifecycleOwner d17 = mUIModel.getMContext().d();
        Intrinsics.checkNotNullExpressionValue(d17, "mUIModel.mContext.lifecycleOwner");
        d.a c16 = b16.c(d17);
        j<com.tencent.aio.api.runtime.a> jVar = this.mRootVB;
        Intrinsics.checkNotNull(jVar);
        com.tencent.input.base.launch.d a16 = c16.f(jVar).g(getMStrategyService()).a();
        getMStrategyService().c(pz0.a.class, new d());
        getMStrategyService().c(com.tencent.mvi.log.b.class, new e());
        new com.tencent.input.base.launch.c().a(a16);
    }

    private final void i1(String invokeTag) {
        Integer num;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            num = Integer.valueOf(peekAppRuntime.hashCode());
        } else {
            num = null;
        }
        QLog.i("PanelContainerAdapterVB", 1, "debug[" + invokeTag + "]: appInterface=" + num);
    }

    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void afterCreateVM(@Nullable BaseVM<Object, PanelContainerAdapterUIState, com.tencent.aio.api.runtime.a> mUIModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) mUIModel);
            return;
        }
        super.afterCreateVM(mUIModel);
        if (this.mRootVB != null) {
            i1("mRootVB.buildVM");
            j<com.tencent.aio.api.runtime.a> jVar = this.mRootVB;
            if (jVar != null) {
                Intrinsics.checkNotNull(mUIModel);
                jVar.buildVM(mUIModel.getMContext());
                return;
            }
            return;
        }
        if (this.mPanelContainerViewStub != null) {
            ViewGroup viewGroup = this.mRootView;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                viewGroup = null;
            }
            viewGroup.removeViewInLayout(this.mPanelContainerViewStub);
            this.mPanelContainerViewStub = null;
        }
        h1(mUIModel);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ViewGroup viewGroup = this.mRootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        viewGroup.setClipChildren(false);
        ViewGroup viewGroup3 = this.mRootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup3 = null;
        }
        if (viewGroup3.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = this.mRootView;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                viewGroup2 = viewGroup4;
            }
            ViewParent parent = viewGroup2.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).setClipChildren(false);
        }
        i1("bindViewAndData");
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<Object, PanelContainerAdapterUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (BaseVM) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new PanelContainerAdapterVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull PanelContainerAdapterUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof PanelContainerAdapterUIState.CheckInputSoftModeUIState) {
            QLog.i("PanelContainerAdapterVB", 1, "CheckInputSoftModeUIState call");
            d1(getMContext());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends PanelContainerAdapterUIState>> getObserverStates() {
        List<Class<? extends PanelContainerAdapterUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(PanelContainerAdapterUIState.CheckInputSoftModeUIState.class);
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @NotNull
    public final b j1(@NotNull com.tencent.input.base.panelcontainer.c<com.tencent.aio.api.runtime.a> creator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) creator);
        }
        Intrinsics.checkNotNullParameter(creator, "creator");
        this.mBuildPanelApi = creator;
        return this;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        ViewGroup b16 = createViewParams.b();
        this.mRootView = b16;
        if (b16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            b16 = null;
        }
        Context context = b16.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
        d1(context);
        View view = new View(createViewParams.a());
        view.setWillNotDraw(true);
        view.setVisibility(8);
        this.mPanelContainerViewStub = view;
        Intrinsics.checkNotNull(view);
        return view;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        i1(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        j<com.tencent.aio.api.runtime.a> jVar = this.mRootVB;
        if (jVar != null) {
            jVar.onDestroy();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
        d1(context);
    }
}
