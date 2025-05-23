package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* loaded from: classes33.dex */
public final class MiniAppWidgetPullLoadMoreBinding implements ViewBinding {
    public final View divider;
    public final ProgressBar progress;
    private final LinearLayout rootView;
    public final TextView text;

    MiniAppWidgetPullLoadMoreBinding(LinearLayout linearLayout, View view, ProgressBar progressBar, TextView textView) {
        this.rootView = linearLayout;
        this.divider = view;
        this.progress = progressBar;
        this.text = textView;
    }

    public static MiniAppWidgetPullLoadMoreBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppWidgetPullLoadMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djp, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppWidgetPullLoadMoreBinding bind(View view) {
        int i3 = R.id.rdc;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.rdc);
        if (findChildViewById != null) {
            i3 = R.id.rkj;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.rkj);
            if (progressBar != null) {
                i3 = R.id.rlc;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rlc);
                if (textView != null) {
                    return new MiniAppWidgetPullLoadMoreBinding((LinearLayout) view, findChildViewById, progressBar, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
