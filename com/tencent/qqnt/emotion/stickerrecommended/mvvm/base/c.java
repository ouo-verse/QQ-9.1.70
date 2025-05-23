package com.tencent.qqnt.emotion.stickerrecommended.mvvm.base;

import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emotion.stickerrecommended.mvvm.base.a;

/* compiled from: P */
/* loaded from: classes24.dex */
public abstract class c<T extends a> extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    protected T f356560i;

    public c(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) t16);
        } else {
            this.f356560i = t16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onCleared();
        T t16 = this.f356560i;
        if (t16 != null) {
            t16.b();
        }
    }
}
