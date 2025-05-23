package com.tencent.luggage.wxa.xd;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.nb.a;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface f extends d, g {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        ViewGroup a();

        a.c a(int i3, boolean z16);

        boolean a(int i3);

        boolean a(int i3, com.tencent.luggage.wxa.kj.f1 f1Var, int i16);

        boolean a(int i3, float[] fArr, int i16, Boolean bool, Boolean bool2);

        boolean a(View view, int i3, int i16, float[] fArr, int i17, boolean z16, boolean z17, boolean z18);

        boolean b(int i3);

        View c();

        View c(int i3);

        int d(int i3);

        boolean e(int i3);

        boolean f(int i3);

        boolean g(int i3);

        a.c h(int i3);

        int i(int i3);
    }

    a a(boolean z16);

    boolean d();

    View getContentView();

    a getCustomViewContainer();
}
