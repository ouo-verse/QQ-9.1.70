package com.tencent.aelight.camera.ae.flashshow;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ay {
    public static ViewModelProvider a(ViewModelStoreOwner viewModelStoreOwner) {
        return new ViewModelProvider(viewModelStoreOwner, ViewModelProvider.AndroidViewModelFactory.getInstance(MobileQQ.sMobileQQ));
    }
}
