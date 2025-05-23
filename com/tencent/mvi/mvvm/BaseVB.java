package com.tencent.mvi.mvvm;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.api.ability.c;
import com.tencent.mvi.api.ability.d;
import com.tencent.mvi.api.ability.e;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.exception.MviException;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\b\b\u0002\u0010\u0006*\u00020\u00052\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00072\u00020\b2\u00020\tB\u0007\u00a2\u0006\u0004\b-\u0010.J\"\u0010\r\u001a\u00020\f2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u001b\u001a\u00020\f2\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\nH\u0017J\b\u0010\u001c\u001a\u00020\fH\u0016J\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\b\u0010!\u001a\u00020 H\u0016R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R!\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/mvvm/framework/a;", "Lcom/tencent/mvi/api/ability/c;", "Lcom/tencent/mvi/api/ability/b;", "Lcom/tencent/mvi/mvvm/BaseVM;", "vm", "", "registerObserver", "checkStateProvider", "clearStateProvider", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Lcom/tencent/mvi/api/ability/e;", "fetchVBState", "state", "handleUIState", "(Lcom/tencent/mvi/base/mvi/MviUIState;)V", "intent", "sendIntent", "(Lol3/b;)V", "mUIModel", "afterCreateVM", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "", "getSubscribeSubUIStateNames", "", "optLiveData", "Lcom/tencent/mvi/mvvm/extension/b;", "mUIStateProvider$delegate", "Lkotlin/Lazy;", "getMUIStateProvider", "()Lcom/tencent/mvi/mvvm/extension/b;", "mUIStateProvider", "Landroidx/lifecycle/Observer;", "mObserver$delegate", "getMObserver", "()Landroidx/lifecycle/Observer;", "mObserver", "<init>", "()V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public abstract class BaseVB<I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b> extends com.tencent.mvi.mvvm.framework.a<I, S, C> implements c, com.tencent.mvi.api.ability.b {
    static IPatchRedirector $redirector_;

    /* renamed from: mObserver$delegate, reason: from kotlin metadata */
    private final Lazy mObserver;

    /* renamed from: mUIStateProvider$delegate, reason: from kotlin metadata */
    private final Lazy mUIStateProvider;

    public BaseVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.mUIStateProvider = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<com.tencent.mvi.mvvm.extension.b>() { // from class: com.tencent.mvi.mvvm.BaseVB$mUIStateProvider$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) BaseVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mvi.mvvm.extension.b invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) ? new com.tencent.mvi.mvvm.extension.b(new WeakReference(BaseVB.this)) : (com.tencent.mvi.mvvm.extension.b) iPatchRedirector2.redirect((short) 1, (Object) this);
            }
        });
        this.mObserver = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Observer<S>>() { // from class: com.tencent.mvi.mvvm.BaseVB$mObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002\"\b\b\u0002\u0010\u0005*\u00020\u00042\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00018\u00018\u0001H\n\u00a2\u0006\u0004\b\t\u0010\n"}, d2 = {"Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/mvi/base/mvi/MviUIState;)V"}, k = 3, mv = {1, 4, 2})
            /* loaded from: classes21.dex */
            public static final class a<T> implements Observer<S> {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) BaseVB$mObserver$2.this);
                    }
                }

                /* JADX WARN: Incorrect types in method signature: (TS;)V */
                @Override // androidx.lifecycle.Observer
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final void onChanged(MviUIState it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) it);
                        return;
                    }
                    BaseVB baseVB = BaseVB.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    baseVB.handleUIState(it);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) BaseVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Observer<S> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) ? new a() : (Observer) iPatchRedirector2.redirect((short) 1, (Object) this);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void checkStateProvider() {
        com.tencent.mvi.api.ability.a aVar;
        String q16;
        if ((this instanceof com.tencent.mvi.api.ability.a) && (q16 = (aVar = (com.tencent.mvi.api.ability.a) this).q()) != null) {
            com.tencent.mvi.mvvm.extension.c.f337790b.a(q16, aVar.Q0());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void clearStateProvider() {
        String q16;
        if ((this instanceof com.tencent.mvi.api.ability.a) && (q16 = ((com.tencent.mvi.api.ability.a) this).q()) != null) {
            com.tencent.mvi.mvvm.extension.c.f337790b.b(q16);
        }
    }

    private final Observer<S> getMObserver() {
        return (Observer) this.mObserver.getValue();
    }

    private final com.tencent.mvi.mvvm.extension.b getMUIStateProvider() {
        return (com.tencent.mvi.mvvm.extension.b) this.mUIStateProvider.getValue();
    }

    private final void registerObserver(BaseVM<I, S, C> vm5) {
        if (optLiveData()) {
            Set<String> subscribeSubUIStateNames = getSubscribeSubUIStateNames();
            if (subscribeSubUIStateNames != null) {
                vm5.attach$mvi_debug((Collection<String>) subscribeSubUIStateNames, (Observer<?>) getMObserver());
                if (com.tencent.mvi.a.f337742b.a() && (!getObserverStates().isEmpty())) {
                    throw new MviException("can not both use getObserverStates and  AutoSubUIState !!");
                }
                return;
            }
            vm5.attach$mvi_debug((List) getObserverStates(), (Observer<?>) getMObserver());
            return;
        }
        vm5.observe$mvi_debug(getMObserver());
        Iterator<T> it = getObserverStates().iterator();
        while (it.hasNext()) {
            vm5.addSource$mvi_debug((Class) it.next(), getMObserver());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @CallSuper
    public void afterCreateVM(@Nullable BaseVM<I, S, C> mUIModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) mUIModel);
        } else if (mUIModel != null) {
            mUIModel.setFetcher$mvi_debug(this);
            mUIModel.setOptLiveData$mvi_debug(optLiveData());
            registerObserver(mUIModel);
            checkStateProvider();
        }
    }

    @Override // com.tencent.mvi.api.ability.b
    @NotNull
    public final e fetchVBState(@NotNull d stateCmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (e) iPatchRedirector.redirect((short) 1, (Object) this, (Object) stateCmd);
        }
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        return getMUIStateProvider().fetchVBState(stateCmd);
    }

    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull d stateCmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bundle) iPatchRedirector.redirect((short) 9, (Object) this, (Object) stateCmd);
        }
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        return c.a.a(this, stateCmd);
    }

    @Nullable
    public final Set<String> getSubscribeSubUIStateNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return null;
    }

    public void handleUIState(@NotNull S state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) state);
        } else {
            Intrinsics.checkNotNullParameter(state, "state");
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDestroy();
            clearStateProvider();
        }
    }

    public boolean optLiveData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    public final void sendIntent(@NotNull I intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        BaseVM<I, S, C> mUIModel = getMUIModel();
        if (mUIModel != null) {
            mUIModel.handleIntent(intent);
        }
    }
}
