package com.tencent.mvi.mvvm;

import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MVILiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.api.ability.e;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.f;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.mvvm.extension.d;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ol3.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\b\b\u0002\u0010\u0006*\u00020\u00052\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00072\u00020\b2\u00020\t2\u00020\nB\u0007\u00a2\u0006\u0004\b#\u0010\u0014J\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fH\u0007J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u000f\u0010\u0015\u001a\u00020\fH\u0010\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\t8\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006$"}, d2 = {"Lcom/tencent/mvi/mvvm/BaseVM;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mvi/api/runtime/b;", "Context", "Lcom/tencent/mvi/mvvm/framework/FrameworkVM;", "Lll3/a;", "Lcom/tencent/mvi/api/ability/b;", "Lcom/tencent/mvi/base/route/g;", "state", "", "updateUI", "(Lcom/tencent/mvi/base/mvi/MviUIState;)V", "Landroidx/lifecycle/MutableLiveData;", "getDefaultState", "Lkotlinx/coroutines/CoroutineScope;", "vmScope", "destroy$mvi_debug", "()V", "destroy", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Lcom/tencent/mvi/api/ability/e;", "fetchVBState", "Lcom/tencent/mvi/mvvm/extension/d;", "mCoroutineScope", "Lcom/tencent/mvi/mvvm/extension/d;", "fetcher", "Lcom/tencent/mvi/api/ability/b;", "getFetcher$mvi_debug", "()Lcom/tencent/mvi/api/ability/b;", "setFetcher$mvi_debug", "(Lcom/tencent/mvi/api/ability/b;)V", "<init>", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public abstract class BaseVM<I extends ol3.b, S extends MviUIState, Context extends com.tencent.mvi.api.runtime.b> extends FrameworkVM<I, S, Context> implements ll3.a, com.tencent.mvi.api.ability.b, g {
    static IPatchRedirector $redirector_;
    public com.tencent.mvi.api.ability.b fetcher;
    private d mCoroutineScope;

    public BaseVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void destroy$mvi_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        d dVar = this.mCoroutineScope;
        if (dVar != null) {
            dVar.a();
        }
        this.mCoroutineScope = null;
        super.destroy$mvi_debug();
    }

    @Override // com.tencent.mvi.api.ability.b
    @NotNull
    public e fetchVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (e) iPatchRedirector.redirect((short) 7, (Object) this, (Object) stateCmd);
        }
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        com.tencent.mvi.api.ability.b bVar = this.fetcher;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fetcher");
        }
        return bVar.fetchVBState(stateCmd);
    }

    @Deprecated(message = "\u5e9f\u5f03\uff0c\u7981\u6b62\u4f7f\u7528")
    @NotNull
    public final MutableLiveData<S> getDefaultState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        MVILiveData mUiState$mvi_debug = getMUiState$mvi_debug();
        if (mUiState$mvi_debug != null) {
            return mUiState$mvi_debug;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<S>");
    }

    @NotNull
    public final com.tencent.mvi.api.ability.b getFetcher$mvi_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (com.tencent.mvi.api.ability.b) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        com.tencent.mvi.api.ability.b bVar = this.fetcher;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fetcher");
        }
        return bVar;
    }

    public /* synthetic */ Set getSubscribeEventNames() {
        return f.a(this);
    }

    public /* synthetic */ Set getSubscribeEventRNames() {
        return f.b(this);
    }

    public final void setFetcher$mvi_debug(@NotNull com.tencent.mvi.api.ability.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.fetcher = bVar;
        }
    }

    public final void updateUI(@NotNull final S state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        ensureAttach();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            dispatchState$mvi_debug(state);
        } else {
            getMMainHandler().post(new Runnable(state) { // from class: com.tencent.mvi.mvvm.BaseVM$updateUI$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ MviUIState f337785d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f337785d = state;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) BaseVM.this, (Object) state);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    } else {
                        BaseVM.this.dispatchState$mvi_debug(this.f337785d);
                    }
                }
            });
        }
    }

    @Override // ll3.a
    @NotNull
    public CoroutineScope vmScope() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ensureAttach();
        if (this.mCoroutineScope == null) {
            this.mCoroutineScope = new d();
        }
        d dVar = this.mCoroutineScope;
        Intrinsics.checkNotNull(dVar);
        return dVar.e();
    }
}
