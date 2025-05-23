package com.tencent.qqnt.aio.api.impl;

import com.tencent.mobileqq.aio.panel.photo.PhotoPanelVB;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.aio.api.IAIOUniversalPanelVB;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016J\u0018\u0010\u0006\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOUniversalPanelVBImpl;", "Lcom/tencent/qqnt/aio/api/IAIOUniversalPanelVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "getPhotoPanelVB", "getEmojiPanelVB", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOUniversalPanelVBImpl implements IAIOUniversalPanelVB {
    static IPatchRedirector $redirector_;

    public AIOUniversalPanelVBImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOUniversalPanelVB
    @NotNull
    public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> getEmojiPanelVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new com.tencent.mobileqq.aio.panel.emoticon.c();
    }

    @Override // com.tencent.qqnt.aio.api.IAIOUniversalPanelVB
    @NotNull
    public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> getPhotoPanelVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new PhotoPanelVB();
    }
}
