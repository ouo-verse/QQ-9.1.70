package com.tencent.richmediabrowser.view.recyclerview;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BrowserItemDecoration extends RecyclerView.ItemDecoration {
    private int mSpace;
    private MainBrowserPresenter mainBrowserPresenter;

    public BrowserItemDecoration(int i3, MainBrowserPresenter mainBrowserPresenter) {
        this.mSpace = i3;
        this.mainBrowserPresenter = mainBrowserPresenter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        rect.top = 0;
        rect.bottom = 0;
        int i3 = this.mSpace;
        rect.left = i3;
        rect.right = i3;
    }
}
