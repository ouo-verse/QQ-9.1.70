package com.tencent.mobileqq.mini.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopLimitedTimeRecommendAdapterViewHolderItemBinding implements ViewBinding {
    public final RecyclerView miniAppInnerLimitedTimeRecyclerView;
    public final MiniAppExpDesktopAdapterViewHolderTitleLayoutBinding personalTitleLayout;
    public final LinearLayout recommendItemLl;
    private final LinearLayout rootView;

    MiniAppExpDesktopLimitedTimeRecommendAdapterViewHolderItemBinding(LinearLayout linearLayout, RecyclerView recyclerView, MiniAppExpDesktopAdapterViewHolderTitleLayoutBinding miniAppExpDesktopAdapterViewHolderTitleLayoutBinding, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.miniAppInnerLimitedTimeRecyclerView = recyclerView;
        this.personalTitleLayout = miniAppExpDesktopAdapterViewHolderTitleLayoutBinding;
        this.recommendItemLl = linearLayout2;
    }

    public static MiniAppExpDesktopLimitedTimeRecommendAdapterViewHolderItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MiniAppExpDesktopLimitedTimeRecommendAdapterViewHolderItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dir, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MiniAppExpDesktopLimitedTimeRecommendAdapterViewHolderItemBinding bind(View view) {
        int i3 = R.id.rgg;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rgg);
        if (recyclerView != null) {
            i3 = R.id.rki;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.rki);
            if (findChildViewById != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new MiniAppExpDesktopLimitedTimeRecommendAdapterViewHolderItemBinding(linearLayout, recyclerView, MiniAppExpDesktopAdapterViewHolderTitleLayoutBinding.bind(findChildViewById), linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
