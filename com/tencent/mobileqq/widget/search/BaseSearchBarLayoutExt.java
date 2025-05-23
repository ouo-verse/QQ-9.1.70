package com.tencent.mobileqq.widget.search;

import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class BaseSearchBarLayoutExt {
    protected QUISearchBar mBar;

    public BaseSearchBarLayoutExt(@NonNull QUISearchBar qUISearchBar) {
        this.mBar = qUISearchBar;
    }

    public abstract int getLayoutWidthInPx(int i3);

    public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        return false;
    }

    public void onDetachView() {
    }

    public void onUpdateLayout(int i3) {
    }

    public void onUpdateColorType(int i3, int i16) {
    }

    public void onUpdateTheme(int i3, int i16) {
    }

    public void onInitLeftView(@NonNull FrameLayout frameLayout, int i3, int i16, int i17) {
    }
}
