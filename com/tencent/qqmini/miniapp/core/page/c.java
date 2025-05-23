package com.tencent.qqmini.miniapp.core.page;

import android.view.View;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface c {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface a {
        void onVerticalScroll(int i3);
    }

    int getMeasuredHeight();

    int getSavedScrollY();

    View getView();

    boolean handleBackPressed();

    void removeWebviewScrollListener(a aVar);

    void saveScrollY(int i3);

    void setOnWebviewScrollListener(a aVar);
}
