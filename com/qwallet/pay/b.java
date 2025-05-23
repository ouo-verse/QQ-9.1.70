package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface b {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void x2(@Nullable Context context);
    }

    void a(Context context);

    boolean b();

    void c(a aVar);

    void onActivityResult(int i3, int i16, Intent intent);

    void onDestroy();
}
