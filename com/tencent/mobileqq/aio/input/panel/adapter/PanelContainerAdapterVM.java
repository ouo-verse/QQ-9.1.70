package com.tencent.mobileqq.aio.input.panel.adapter;

import android.content.res.Configuration;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.aio.api.runtime.emitter.c;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.input.panel.adapter.PanelContainerAdapterUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0007*\u0002\u000b\u000f\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0007R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/input/panel/adapter/PanelContainerAdapterVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "", "Lcom/tencent/mobileqq/aio/input/panel/adapter/PanelContainerAdapterUIState;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", "com/tencent/mobileqq/aio/input/panel/adapter/PanelContainerAdapterVM$b", "e", "Lcom/tencent/mobileqq/aio/input/panel/adapter/PanelContainerAdapterVM$b;", "mMultiWindowModeChangedCallback", "com/tencent/mobileqq/aio/input/panel/adapter/PanelContainerAdapterVM$a", "f", "Lcom/tencent/mobileqq/aio/input/panel/adapter/PanelContainerAdapterVM$a;", "mConfigurationChangedCallback", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class PanelContainerAdapterVM extends com.tencent.qqnt.aio.baseVM.a<Object, PanelContainerAdapterUIState> implements LifecycleObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mMultiWindowModeChangedCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mConfigurationChangedCallback;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/panel/adapter/PanelContainerAdapterVM$a", "Lcom/tencent/aio/api/runtime/emitter/b;", "Landroid/content/res/Configuration;", "configuration", "", "onConfigurationChanged", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements com.tencent.aio.api.runtime.emitter.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PanelContainerAdapterVM.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.aio.api.runtime.emitter.b
        public void onConfigurationChanged(@NotNull Configuration configuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) configuration);
            } else {
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                ((com.tencent.aio.api.runtime.a) PanelContainerAdapterVM.this.getMContext()).e().h(new PanelContainerMsgIntent.OnConfigurationChanged(configuration));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/panel/adapter/PanelContainerAdapterVM$b", "Lcom/tencent/aio/api/runtime/emitter/c;", "", "isInMultiWindowMode", "", "onMultiWindowModeChanged", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PanelContainerAdapterVM.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.aio.api.runtime.emitter.c
        public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isInMultiWindowMode);
            } else {
                ((com.tencent.aio.api.runtime.a) PanelContainerAdapterVM.this.getMContext()).e().h(new PanelContainerMsgIntent.OnMultiWindowModeChanged(isInMultiWindowMode));
            }
        }
    }

    public PanelContainerAdapterVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mMultiWindowModeChangedCallback = new b();
            this.mConfigurationChangedCallback = new a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(c.class).c(this.mMultiWindowModeChangedCallback);
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.b.class).c(this.mConfigurationChangedCallback);
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            updateUI(PanelContainerAdapterUIState.CheckInputSoftModeUIState.f189777d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(c.class).a(this.mMultiWindowModeChangedCallback);
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.b.class).a(this.mConfigurationChangedCallback);
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().addObserver(this);
    }
}
