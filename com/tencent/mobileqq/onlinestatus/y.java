package com.tencent.mobileqq.onlinestatus;

import android.content.Intent;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface y {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface c {
        void a(String str);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface d {
        void a();

        void b(AppRuntime.Status status);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface e {
        void a(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface f {
        void a(String str);
    }

    void D3(d dVar);

    boolean Md();

    void O8(String str, int i3);

    void Og(a aVar);

    void Pc(b bVar);

    void Rb();

    void b6();

    boolean isShowing();

    boolean l(boolean z16);

    void l2(String str, int i3);

    void onAccountChanged();

    void onActivityResult(int i3, int i16, Intent intent);

    void onDestory();

    void onPause();

    void qe(a aVar);

    void s8();

    void show();

    void show(int i3);
}
