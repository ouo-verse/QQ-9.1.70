package com.tencent.richmediabrowser.core;

import android.content.Context;
import f04.a;
import f04.b;
import f04.c;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IMvpFactory {
    a createModel(int i3, b bVar);

    b createPresenter(int i3);

    c createView(Context context, int i3, b bVar);
}
