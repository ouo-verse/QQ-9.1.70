package com.tencent.qqnt.aio.baseVM;

import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\b\u0012\u0004\u0012\u00028\u00010\u0006B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\b\u001a\u00020\u0007H\u0096\u0001J%\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0096\u0001J\b\u0010\u000f\u001a\u00020\u0007H\u0017\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/baseVM/a;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/aio/base/mvvm/b;", "", "", "j", "Landroidx/lifecycle/LiveData;", "stateLiveData", "Landroidx/lifecycle/Observer;", "observer", "", "observerState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class a<I extends b, S extends MviUIState> extends com.tencent.aio.base.mvvm.b<I, S> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ com.tencent.qqnt.aio.baseVM.state.a<S> f349776d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f349776d = new com.tencent.qqnt.aio.baseVM.state.a<>();
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f349776d.a();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public boolean observerState(@NotNull LiveData<S> stateLiveData, @NotNull Observer<S> observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) stateLiveData, (Object) observer)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(stateLiveData, "stateLiveData");
        Intrinsics.checkNotNullParameter(observer, "observer");
        return this.f349776d.b(stateLiveData, observer);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    @CallSuper
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDestroy();
            j();
        }
    }
}
