package com.tencent.biz.richframework.part;

import android.view.View;

/* loaded from: classes5.dex */
public interface IStatusViewProvider {
    View getStatusView();

    void showEmptyView(String str);

    void showErrorView(int i3, String str);

    void showHintView(String str);
}
