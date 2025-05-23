package com.tencent.mobileqq.teamwork.api;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.teamwork.menu.MenuTabViewBase;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface INativeEngineFileBrowserWrapper {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public enum OpenMode {
        MAIN_PROCESS,
        CHILD_PROCESS
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f291658a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f291659b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f291660c = "";
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void a(int i3, String str, ir2.b bVar);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface c {
        void b(int i3, String str);

        void c();

        void d(int i3);
    }

    MenuTabViewBase a(Context context);

    void b(boolean z16);

    void c(RectF rectF);

    void d();

    void e(int i3);

    void f(a aVar, b bVar);

    void g(int i3, a aVar, b bVar);

    View getView();

    void onDestroy();

    void onResume();
}
