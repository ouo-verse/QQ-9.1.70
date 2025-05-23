package com.tencent.qqnt.textpreview.inject;

import android.app.Activity;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface f {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface a {
        void a();

        void b();

        void c();

        void e(String str);

        void onError(int i3, String str);

        void onPlayStart(String str);
    }

    void a(String str, String str2, int i3);

    void b(Activity activity, boolean z16);

    void c(a aVar);

    void destroy();

    boolean isWorking();

    void speak(String str, String str2);

    void stop();
}
