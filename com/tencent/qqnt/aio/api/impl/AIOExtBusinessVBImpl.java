package com.tencent.qqnt.aio.api.impl;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.aio.input.longshot.LongShotBarVB;
import com.tencent.mobileqq.aio.input.multiselect.MultiSelectBarVB;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.aio.api.IAIOExtBusinessVB;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u0018\u0010\b\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0002H\u0016J\u0018\u0010\t\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOExtBusinessVBImpl;", "Lcom/tencent/qqnt/aio/api/IAIOExtBusinessVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "getPublicAccountInputBarVB", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "getMultiSelectBarVB", "getLongShotBarVB", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOExtBusinessVBImpl implements IAIOExtBusinessVB {
    static IPatchRedirector $redirector_;

    public AIOExtBusinessVBImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOExtBusinessVB
    @NotNull
    public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> getLongShotBarVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new LongShotBarVB();
    }

    @Override // com.tencent.qqnt.aio.api.IAIOExtBusinessVB
    @NotNull
    public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> getMultiSelectBarVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new MultiSelectBarVB();
    }

    @Override // com.tencent.qqnt.aio.api.IAIOExtBusinessVB
    @NotNull
    public com.tencent.aio.base.mvvm.a<at.a, InputUIState> getPublicAccountInputBarVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new com.tencent.mobileqq.aio.input.inputbar.a(new com.tencent.qqnt.aio.publicaccount.inputadorn.a());
    }
}
