package com.tencent.luggage.wxa.wj;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.wj.e;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        ViewGroup a(View view);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(e.b bVar);
    }

    @Nullable
    e.b a();

    void a(int i3);

    void a(@NonNull View view, int i3);

    void a(WebChromeClient.CustomViewCallback customViewCallback);

    void a(com.tencent.luggage.wxa.wj.b bVar);

    void b(com.tencent.luggage.wxa.wj.b bVar);

    boolean b();

    boolean c();

    void release();
}
