package com.tencent.mobileqq.aio.utils.api.impl;

import android.view.ViewGroup;
import com.tencent.aio.base.mvvm.a;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeAnimationVB;
import com.tencent.mobileqq.aio.utils.api.IPokeMessageApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/api/impl/PokeMessageApiImpl;", "Lcom/tencent/mobileqq/aio/utils/api/IPokeMessageApi;", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "getPokeAnimationVB", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PokeMessageApiImpl implements IPokeMessageApi {
    static IPatchRedirector $redirector_;

    public PokeMessageApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.utils.api.IPokeMessageApi
    @NotNull
    public a<? extends b, ? extends MviUIState> getPokeAnimationVB(@NotNull ViewGroup rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        return new AIOPokeAnimationVB(rootView);
    }
}
