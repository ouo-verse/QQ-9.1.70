package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.widget.LoadingView;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopRankRvLoadingItemLayoutBinding implements ViewBinding {
    public final TextView rankLoadingTv;
    public final LoadingView rankLoadingView;
    private final RelativeLayout rootView;

    MiniAppExpDesktopRankRvLoadingItemLayoutBinding(RelativeLayout relativeLayout, TextView textView, LoadingView loadingView) {
        this.rootView = relativeLayout;
        this.rankLoadingTv = textView;
        this.rankLoadingView = loadingView;
    }

    public static MiniAppExpDesktopRankRvLoadingItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopRankRvLoadingItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dj5, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopRankRvLoadingItemLayoutBinding bind(View view) {
        int i3 = R.id.rkv;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.rkv);
        if (textView != null) {
            i3 = R.id.rkw;
            LoadingView loadingView = (LoadingView) ViewBindings.findChildViewById(view, R.id.rkw);
            if (loadingView != null) {
                return new MiniAppExpDesktopRankRvLoadingItemLayoutBinding((RelativeLayout) view, textView, loadingView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
