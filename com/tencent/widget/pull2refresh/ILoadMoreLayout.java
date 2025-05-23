package com.tencent.widget.pull2refresh;

import android.view.View;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface ILoadMoreLayout {
    boolean checkState(int i3);

    int getState();

    void setOnClickListener(View.OnClickListener onClickListener);

    boolean setState(int i3);
}
