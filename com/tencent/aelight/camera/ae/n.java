package com.tencent.aelight.camera.ae;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes32.dex */
public class n {
    public static ViewModelProvider a(ViewModelStoreOwner viewModelStoreOwner) {
        return new ViewModelProvider(viewModelStoreOwner, ViewModelProvider.AndroidViewModelFactory.getInstance(MobileQQ.sMobileQQ));
    }

    public static ViewModelProvider b(ViewModelStoreOwner viewModelStoreOwner, ViewModelProvider.Factory factory) {
        return new ViewModelProvider(viewModelStoreOwner, factory);
    }
}
