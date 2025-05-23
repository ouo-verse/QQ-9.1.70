package com.qzone.reborn.qzmoment.comment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a extends ReportDialog {
    public a(Context context, int i3) {
        super(context, i3);
    }

    public void N() {
        if (getWindow() != null && getWindow().getDecorView() != null) {
            getWindow().clearFlags(67108864);
            getWindow().getDecorView().setSystemUiVisibility(1280);
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        Window window = getWindow();
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        if (decorView instanceof ViewGroup) {
            View childAt = ((ViewGroup) decorView).getChildAt(0);
            if (childAt instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) childAt;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = viewGroup.getChildAt(i3);
                    if (childAt2 == null || childAt2.getId() == 16908290) {
                        return;
                    }
                    if (!(childAt2 instanceof ViewStub)) {
                        childAt2.setAlpha(0.0f);
                    }
                }
            }
        }
    }
}
