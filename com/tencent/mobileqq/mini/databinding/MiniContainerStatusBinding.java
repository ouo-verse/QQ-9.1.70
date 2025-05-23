package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniContainerStatusBinding implements ViewBinding {
    public final LinearLayout miniException;
    public final ProgressBar miniLoading;
    public final Button miniRetry;
    private final View rootView;

    MiniContainerStatusBinding(View view, LinearLayout linearLayout, ProgressBar progressBar, Button button) {
        this.rootView = view;
        this.miniException = linearLayout;
        this.miniLoading = progressBar;
        this.miniRetry = button;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static MiniContainerStatusBinding bind(View view) {
        int i3 = R.id.f163697ri4;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163697ri4);
        if (linearLayout != null) {
            i3 = R.id.ril;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.ril);
            if (progressBar != null) {
                i3 = R.id.rj8;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.rj8);
                if (button != null) {
                    return new MiniContainerStatusBinding(view, linearLayout, progressBar, button);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static MiniContainerStatusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.djt, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
