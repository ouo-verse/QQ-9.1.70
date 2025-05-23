package com.tencent.richmediabrowser.core;

import android.content.Intent;
import f04.b;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IBrowserBuilder {
    void buildComplete();

    void buildModel();

    void buildParams(Intent intent);

    void buildPresenter();

    void buildView();

    b getPresenter();
}
