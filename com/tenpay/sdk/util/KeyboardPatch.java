package com.tenpay.sdk.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tenpay.api.QFuncProxy;

/* loaded from: classes27.dex */
public class KeyboardPatch {
    private Activity mActivity;
    private View mContentView;
    private View mDecorView;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tenpay.sdk.util.KeyboardPatch.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            KeyboardPatch.this.mDecorView.getWindowVisibleDisplayFrame(rect);
            int i3 = KeyboardPatch.this.mDecorView.getContext().getResources().getDisplayMetrics().heightPixels - rect.bottom;
            QFuncProxy.isFlymeOS();
            if (i3 > 0) {
                if (KeyboardPatch.this.mContentView.getPaddingBottom() != i3) {
                    KeyboardPatch.this.mContentView.setPadding(0, 0, 0, i3);
                }
            } else if (KeyboardPatch.this.mContentView.getPaddingBottom() != 0) {
                KeyboardPatch.this.mContentView.setPadding(0, 0, 0, 0);
            }
        }
    };

    KeyboardPatch() {
    }

    public static KeyboardPatch patch(Activity activity, View view) {
        return new KeyboardPatch(activity, view);
    }

    public void disable() {
        this.mDecorView.getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void enable() {
        this.mDecorView.getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    KeyboardPatch(Activity activity, View view) {
        this.mActivity = activity;
        this.mDecorView = activity.getWindow().getDecorView();
        this.mContentView = view;
    }
}
