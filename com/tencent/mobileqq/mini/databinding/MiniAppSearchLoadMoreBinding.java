package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.widget.LoadingView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppSearchLoadMoreBinding implements ViewBinding {
    public final FrameLayout flCustomViewWrapper;
    public final LinearLayout lLayoutContent;
    public final LoadingView pbLoading;
    private final FrameLayout rootView;
    public final TextView tvTips;

    MiniAppSearchLoadMoreBinding(FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout, LoadingView loadingView, TextView textView) {
        this.rootView = frameLayout;
        this.flCustomViewWrapper = frameLayout2;
        this.lLayoutContent = linearLayout;
        this.pbLoading = loadingView;
        this.tvTips = textView;
    }

    public static MiniAppSearchLoadMoreBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppSearchLoadMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.djj, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppSearchLoadMoreBinding bind(View view) {
        int i3 = R.id.rdl;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.rdl);
        if (frameLayout != null) {
            i3 = R.id.rek;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rek);
            if (linearLayout != null) {
                i3 = R.id.rkb;
                LoadingView loadingView = (LoadingView) ViewBindings.findChildViewById(view, R.id.rkb);
                if (loadingView != null) {
                    i3 = R.id.rlt;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rlt);
                    if (textView != null) {
                        return new MiniAppSearchLoadMoreBinding((FrameLayout) view, frameLayout, linearLayout, loadingView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
