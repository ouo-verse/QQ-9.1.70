package com.tencent.luggage.wxa.g6;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface k extends DialogInterface {
    Window getWindow();

    boolean isShowing();

    void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener);

    void setOnShowListener(DialogInterface.OnShowListener onShowListener);

    void show();
}
