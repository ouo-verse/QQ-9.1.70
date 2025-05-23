package com.tencent.luggage.wxa.n3;

import com.tencent.luggage.wxa.n3.u;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface t extends u {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a extends u.a {
        void a(int i3, int i16, com.tencent.luggage.wxa.n3.a aVar);

        void a(int i3, c cVar);

        void a(int i3, d dVar);

        void a(int i3, l lVar);

        void a(int i3, o oVar);

        void a(y yVar);

        void onLoginComplete(int i3);

        void onLogoutComplete(int i3);
    }

    int a(int i3, int i16, String str, String str2, String str3, boolean z16, int i17);

    void a(String str, String str2);

    void a(String str, String str2, String str3, String str4, String str5);

    void autoLogin();

    void b();

    void c(a aVar);

    r createCloneSession();

    void f();

    c0 getLoginStatus();

    String getUsername();

    String o();

    void requestUploadLogfiles(int i3, int i16);
}
