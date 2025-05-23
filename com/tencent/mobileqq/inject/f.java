package com.tencent.mobileqq.inject;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface f {

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void a(String str);
    }

    int a();

    int b();

    void c(String str, a aVar);

    boolean enableTalkBack();

    int getAppId();

    String getSubVersion();

    boolean isDebugVersion();

    boolean loadNativeLibrary(Context context, String str, int i3, boolean z16);
}
