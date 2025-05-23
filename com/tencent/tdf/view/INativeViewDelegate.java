package com.tencent.tdf.view;

import android.graphics.Rect;
import android.view.View;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface INativeViewDelegate {
    void deleteView(View view);

    Rect getLayoutRect();

    void insertView(View view, int i3);

    void onDispose();

    void updateLayoutParams(int i3, int i16, int i17, int i18);
}
