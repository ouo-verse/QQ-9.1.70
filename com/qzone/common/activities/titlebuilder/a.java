package com.qzone.common.activities.titlebuilder;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import d5.g;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface a extends com.qzone.feed.ui.activity.f {
    void E1(int i3, int i16, boolean z16);

    ViewGroup E5();

    void G6(g gVar);

    void H4(int i3);

    void K3(Intent intent);

    void P(int i3, View.OnClickListener onClickListener, boolean z16);

    ViewGroup R0();

    void T3(int i3, View.OnClickListener onClickListener);

    void b5(boolean z16);

    void setTitle(int i3);

    void setTitle(CharSequence charSequence);

    TextView u();

    TextView v();

    TextView x();
}
