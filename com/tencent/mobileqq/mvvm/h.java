package com.tencent.mobileqq.mvvm;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_;

    public static ViewModelProvider a(ViewModelStoreOwner viewModelStoreOwner) {
        return b(viewModelStoreOwner, ViewModelProvider.AndroidViewModelFactory.getInstance(MobileQQ.sMobileQQ));
    }

    public static ViewModelProvider b(ViewModelStoreOwner viewModelStoreOwner, ViewModelProvider.Factory factory) {
        return new ViewModelProvider(viewModelStoreOwner.getViewModelStore(), factory);
    }
}
