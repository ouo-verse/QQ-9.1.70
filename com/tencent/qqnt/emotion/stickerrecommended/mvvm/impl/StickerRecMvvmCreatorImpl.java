package com.tencent.qqnt.emotion.stickerrecommended.mvvm.impl;

import android.content.Context;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emotion.stickerrecommended.mvvm.IStickerRecMvvmCreator;
import com.tencent.qqnt.emotion.stickerrecommended.mvvm.a;
import com.tencent.qqnt.emotion.stickerrecommended.mvvm.b;
import com.tencent.qqnt.emotion.stickerrecommended.mvvm.c;
import com.tencent.qqnt.emotion.stickerrecommended.mvvm.g;
import com.tencent.qqnt.emotion.stickerrecommended.mvvm.h;

/* compiled from: P */
/* loaded from: classes24.dex */
public class StickerRecMvvmCreatorImpl implements IStickerRecMvvmCreator {
    static IPatchRedirector $redirector_;

    public StickerRecMvvmCreatorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.mvvm.IStickerRecMvvmCreator
    public a createViewBinder(AppInterface appInterface, Context context, com.tencent.aio.api.runtime.a aVar, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, this, appInterface, context, aVar, bVar);
        }
        return new c(appInterface, context, aVar, bVar);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.mvvm.IStickerRecMvvmCreator
    public b createViewModel(ViewModelStoreOwner viewModelStoreOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewModelStoreOwner);
        }
        return (b) new ViewModelProvider(viewModelStoreOwner.getViewModelStore(), new h()).get(g.class);
    }
}
