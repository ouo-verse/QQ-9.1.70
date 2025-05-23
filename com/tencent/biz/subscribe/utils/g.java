package com.tencent.biz.subscribe.utils;

import android.view.View;
import android.view.Window;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Window f96286d;

        a(Window window) {
            this.f96286d = window;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i3) {
            this.f96286d.getDecorView().setSystemUiVisibility(5894);
        }
    }

    public static void a(Window window) {
        if (window == null) {
            return;
        }
        window.clearFlags(8);
    }

    public static void b(Window window) {
        if (window == null) {
            return;
        }
        window.setFlags(8, 8);
    }

    public static void c(Window window) {
        if (window == null) {
            return;
        }
        window.getDecorView().setSystemUiVisibility(2);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new a(window));
    }
}
